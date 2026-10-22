package com.android.server.notification;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Binder;
import android.os.UserHandle;
import android.service.notification.Condition;
import android.service.notification.IConditionProvider;
import android.service.notification.ZenModeConfig;
import android.util.ArraySet;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import com.android.server.pm.PackageManagerService;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ZenModeConditions implements ConditionProviders.Callback {
    private static final boolean DEBUG = false;
    private static final String TAG = "ZenModeHelper";
    private final ConditionProviders mConditionProviders;
    private final ZenModeHelper mHelper;
    protected final ArraySet<Pair<Uri, ComponentName>> mSubscriptions;

    static {
        DEBUG = ZenModeHelper.DEBUG;
    }

    public ZenModeConditions(ZenModeHelper helper, ConditionProviders conditionProviders) {
        this.mSubscriptions = new ArraySet();
        this.mHelper = helper;
        this.mConditionProviders = conditionProviders;
        if (this.mConditionProviders.isSystemProviderEnabled("countdown") == false) goto L6;
        this.mConditionProviders.addSystemProvider(new CountdownConditionProvider());
    L6:
        if (this.mConditionProviders.isSystemProviderEnabled("schedule") == false) goto L9;
        this.mConditionProviders.addSystemProvider(new ScheduleConditionProvider());
    L9:
        if (this.mConditionProviders.isSystemProviderEnabled("event") == false) goto L12;
        this.mConditionProviders.addSystemProvider(new EventConditionProvider());
    L12:
        if (this.mConditionProviders.isSystemProviderEnabled("custom_manual") == false) goto L14;
        this.mConditionProviders.addSystemProvider(new CustomManualConditionProvider());
    L14:
        this.mConditionProviders.setCallback(this);
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("mSubscriptions=");
        pw.println(this.mSubscriptions);
    }

    public void evaluateConfig(ZenModeConfig config, ComponentName trigger, boolean processSubscriptions) {
        if (config != null) goto L4;
        return;
    L4:
        ArraySet<Pair<Uri, ComponentName>> current = new ArraySet();
        evaluateRule(config.manualRule, current, null, processSubscriptions, true);
        Iterator r12 = config.automaticRules.values().iterator();
    L6:
        if (r12.hasNext() == false) goto L12;
        ZenModeConfig.ZenRule automaticRule = (ZenModeConfig.ZenRule) r12.next();
        if (automaticRule.component == null) goto L10;
        ComponentName trigger2 = trigger;
        evaluateRule(automaticRule, current, trigger2, processSubscriptions, false);
        automaticRule.reconsiderConditionOverride();
    L11:
        trigger = trigger2;
        goto L6
    L10:
        trigger2 = trigger;
        goto L11
    L12:
        ArraySet<Pair<Uri, ComponentName>> r11 = this.mSubscriptions;
        monitor-enter(r11);
        int N = this.mSubscriptions.size();     // Catch: Throwable -> L21
        int i = N - 1;     // Catch: Throwable -> L21
    L15:
        if (i < 0) goto L25;
        Pair<Uri, ComponentName> subscription = this.mSubscriptions.valueAt(i);     // Catch: Throwable -> L21
        if (processSubscriptions == false) goto L23;
        if (current.contains(subscription) == true) goto L23;
        this.mConditionProviders.unsubscribeIfNecessary((ComponentName) subscription.second, (Uri) subscription.first);     // Catch: Throwable -> L21
        this.mSubscriptions.removeAt(i);     // Catch: Throwable -> L21
    L23:
        i = i - 1;     // Catch: Throwable -> L21
        goto L15
    L25:
        monitor-exit(r11);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.ConditionProviders.Callback
    public void onServiceAdded(ComponentName component) {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "onServiceAdded " + component);
    L5:
        int callingUid = Binder.getCallingUid();
        ZenModeHelper r2 = this.mHelper;
        ZenModeConfig r3 = this.mHelper.getConfig();
        if (callingUid != 1000) goto L8;
        int r5 = 5;
    L9:
        r2.setConfig(r3, component, r5, "zmc.onServiceAdded:" + component, callingUid);
        return;
    L8:
        r5 = 4;
        goto L9
    }

    @Override // com.android.server.notification.ConditionProviders.Callback
    public void onConditionChanged(Uri id, Condition condition, int callingUid) {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "onConditionChanged " + id + " " + condition);
    L5:
        ZenModeConfig config = this.mHelper.getConfig();
        if (config != null) goto L8;
        return;
    L8:
        ZenModeHelper r1 = this.mHelper;
        UserHandle r2 = UserHandle.CURRENT;
        if (callingUid != 1000) goto L11;
        int r5 = 5;
    L12:
        r1.setAutomaticZenRuleStateFromConditionProvider(r2, id, condition, r5, callingUid);
        return;
    L11:
        r5 = 4;
        goto L12
    }

    private void evaluateRule(ZenModeConfig.ZenRule rule, ArraySet<Pair<Uri, ComponentName>> current, ComponentName trigger, boolean processSubscriptions, boolean isManual) {
        if (rule != null) goto L4;
        return;
    L4:
        if (rule.conditionId != null) goto L7;
        return;
    L7:
        if (rule.configurationActivity == null) goto L9;
        return;
    L9:
        Uri id = rule.conditionId;
        boolean r1 = true;
        if (isManual == false) goto L12;
    L15:
        boolean isSystemRule = true;
    L16:
        if (isSystemRule == false) goto L18;
    L23:
        boolean isSystemCondition = false;
        if (isSystemRule == false) goto L32;
        Iterator<SystemConditionProviderService> r5 = this.mConditionProviders.getSystemProviders().iterator();
    L27:
        if (r5.hasNext() == false) goto L32;
        SystemConditionProviderService sp = r5.next();
        if (sp.isValidConditionId(id) == false) goto L27;
        this.mConditionProviders.ensureRecordExists(sp.getComponent(), id, sp.asInterface());
        rule.component = sp.getComponent();
        isSystemCondition = true;
    L32:
        if (isSystemCondition == true) goto L43;
        IConditionProvider cp = this.mConditionProviders.findConditionProvider(rule.component);
        if (DEBUG == false) goto L40;
        StringBuilder r7 = new StringBuilder();
        r7.append("Ensure external rule exists: ");
        if (cp != null) goto L39;
        r1 = false;
    L39:
        r7.append(r1);
        r7.append(" for ");
        r7.append(id);
        Log.d(TAG, r7.toString());
    L40:
        if (cp == null) goto L43;
        this.mConditionProviders.ensureRecordExists(rule.component, id, cp);
    L43:
        if (rule.component == null) goto L45;
    L49:
        Pair<Uri, ComponentName> uriAndCps = new Pair(id, rule.component);
        if (current == null) goto L52;
        current.add(uriAndCps);
    L52:
        if (processSubscriptions == false) goto L74;
        if (trigger != null) goto L55;
    L56:
        if (isSystemCondition == false) goto L74;
    L58:
        if (DEBUG == false) goto L61;
        Log.d(TAG, "Subscribing to " + rule.component);
    L61:
        if (this.mConditionProviders.subscribeIfNecessary(rule.component, rule.conditionId) == false) goto L70;
        ArraySet<Pair<Uri, ComponentName>> r2 = this.mSubscriptions;
        monitor-enter(r2);
        this.mSubscriptions.add(uriAndCps);     // Catch: Throwable -> L67
        monitor-exit(r2);     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        throw th;
    L70:
        rule.condition = null;
        if (DEBUG == false) goto L74;
        Log.d(TAG, "zmc failed to subscribe");
        goto L74
    L55:
        if (trigger.equals(rule.component) == true) goto L58;
    L74:
        if (rule.component != null) goto L76;
        return;
    L76:
        if (rule.condition != null) goto L93;
        rule.condition = this.mConditionProviders.findCondition(rule.component, rule.conditionId);
        if (rule.condition != null) goto L80;
        return;
    L80:
        if (DEBUG == false) goto L95;
        Log.d(TAG, "Found existing condition for: " + rule.conditionId);
        return;
    L95:
        return;
    L93:
        return;
    L45:
        if (rule.enabler != null) goto L49;
        if (isManual == true) goto L91;
        Log.w(TAG, "No component found for automatic rule: " + rule.conditionId);
        rule.enabled = false;
        return;
    L91:
        return;
    L18:
        if (rule.component == null) goto L23;
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(rule.component.getPackageName()) == false) goto L23;
        Slog.w(TAG, "Rule " + rule.id + " belongs to package " + rule.getPkg() + " but has component=" + rule.component + " which is not allowed!");
        return;
    L12:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(rule.getPkg()) == true) goto L15;
        isSystemRule = false;
        goto L16
    }
}
