package com.android.server.notification;

import android.R;
import android.app.INotificationManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.IPackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.UserHandle;
import android.service.notification.Condition;
import android.service.notification.IConditionProvider;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ConditionProviders extends ManagedServices {
    static final String TAG_ENABLED_DND_APPS = "dnd_apps";
    private Callback mCallback;
    private final ArrayList<ConditionRecord> mRecords;
    private final ArraySet<String> mSystemConditionProviderNames;
    private final ArraySet<SystemConditionProviderService> mSystemConditionProviders;

    public interface Callback {
        void onConditionChanged(Uri r1, Condition r2, int r3);

        void onServiceAdded(ComponentName r1);
    }

    static class ConditionRecord {
        public final ComponentName component;
        public Condition condition;
        public final Uri id;
        public ManagedServices.ManagedServiceInfo info;
        public boolean subscribed;

        /* synthetic */ ConditionRecord(Uri r1, ComponentName r2, ConditionProvidersIA r3) {
            this(r1, r2);
        }

        private ConditionRecord(Uri id, ComponentName component) {
            this.id = id;
            this.component = component;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("ConditionRecord[id=");
            r0.append(this.id);
            r0.append(",component=");
            r0.append(this.component);
            r0.append(",subscribed=");
            StringBuilder sb = r0.append(this.subscribed);
            sb.append(']');
            return sb.toString();
        }
    }

    public ConditionProviders(Context context, ManagedServices.UserProfiles userProfiles, IPackageManager pm) {
        super(context, new Object(), userProfiles, pm);
        this.mRecords = new ArrayList();
        this.mSystemConditionProviders = new ArraySet();
        this.mSystemConditionProviderNames = safeSet(PropConfig.getStringArray(this.mContext, "system.condition.providers", R.array.config_waterfallCutoutArray));
        this.mApprovalLevel = 0;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public boolean isSystemProviderEnabled(String path) {
        return this.mSystemConditionProviderNames.contains(path);
    }

    public void addSystemProvider(SystemConditionProviderService service) {
        this.mSystemConditionProviders.add(service);
        service.attachBase(this.mContext);
        registerSystemService(service.asInterface(), service.getComponent(), 0, 1000);
    }

    public Iterable<SystemConditionProviderService> getSystemProviders() {
        return this.mSystemConditionProviders;
    }

    @Override // com.android.server.notification.ManagedServices
    protected ArrayMap<Boolean, ArrayList<ComponentName>> resetComponents(String packageName, int userId) {
        resetPackage(packageName, userId);
        ArrayMap<Boolean, ArrayList<ComponentName>> changes = new ArrayMap();
        changes.put(true, new ArrayList(0));
        changes.put(false, new ArrayList(0));
        return changes;
    }

    boolean resetPackage(String packageName, int userId) {
        boolean isAllowed = super.isPackageOrComponentAllowed(packageName, userId);
        boolean isDefault = super.isDefaultComponentOrPackage(packageName);
        if (isAllowed == true) goto L7;
        if (isDefault == false) goto L7;
        setPackageOrComponentEnabled(packageName, userId, true, true);
    L7:
        if (isAllowed == false) goto L10;
        if (isDefault == true) goto L10;
        setPackageOrComponentEnabled(packageName, userId, true, false);
    L10:
        if (isAllowed == true) goto L14;
        if (isDefault == false) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // com.android.server.notification.ManagedServices
    void writeDefaults(TypedXmlSerializer out) throws IOException {
        Object r0 = this.mDefaultsLock;
        monitor-enter(r0);
        String defaults = String.join(":", this.mDefaultPackages);     // Catch: Throwable -> L7
        out.attribute(null, "defaults", defaults);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.ManagedServices
    protected ManagedServices.Config getConfig() {
        ManagedServices.Config c = new ManagedServices.Config();
        c.caption = "condition provider";
        c.serviceInterface = "android.service.notification.ConditionProviderService";
        c.secureSettingName = null;
        c.xmlTag = TAG_ENABLED_DND_APPS;
        c.secondarySettingName = "enabled_notification_listeners";
        c.bindPermission = "android.permission.BIND_CONDITION_PROVIDER_SERVICE";
        c.settingsAction = "android.settings.ACTION_CONDITION_PROVIDER_SETTINGS";
        c.clientLabel = R.string.config_defaultCaptivePortalLoginPackageName;
        return c;
    }

    @Override // com.android.server.notification.ManagedServices
    public void dump(PrintWriter pw, NotificationManagerService.DumpFilter filter) {
        super.dump(pw, filter);
        Object r0 = this.mMutex;
        monitor-enter(r0);
        pw.print("    mRecords(");     // Catch: Throwable -> L12
        pw.print(this.mRecords.size());     // Catch: Throwable -> L12
        pw.println("):");     // Catch: Throwable -> L12
        int i = 0;
    L6:
        if (i >= this.mRecords.size()) goto L19;
        ConditionRecord r = this.mRecords.get(i);     // Catch: Throwable -> L12
        if (filter != null) goto L10;
    L14:
        pw.print("      ");     // Catch: Throwable -> L12
        pw.println(r);     // Catch: Throwable -> L12
        String countdownDesc = CountdownConditionProvider.tryParseDescription(r.id);     // Catch: Throwable -> L12
        if (countdownDesc == null) goto L17;
        pw.print("        (");     // Catch: Throwable -> L12
        pw.print(countdownDesc);     // Catch: Throwable -> L12
        pw.println(")");     // Catch: Throwable -> L12
    L17:
        i = i + 1;     // Catch: Throwable -> L12
        goto L6
    L10:
        if (filter.matches(r.component) == true) goto L14;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L12
        pw.print("    mSystemConditionProviders: ");
        pw.println(this.mSystemConditionProviderNames);
        int i2 = 0;
    L22:
        if (i2 >= this.mSystemConditionProviders.size()) goto L25;
        this.mSystemConditionProviders.valueAt(i2).dump(pw, filter);
        i2 = i2 + 1;
        goto L22
    L25:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.ManagedServices
    protected IInterface asInterface(IBinder binder) {
        return IConditionProvider.Stub.asInterface(binder);
    }

    @Override // com.android.server.notification.ManagedServices
    protected boolean checkType(IInterface service) {
        return service instanceof IConditionProvider;
    }

    @Override // com.android.server.notification.ManagedServices
    public void onBootPhaseAppsCanStart() {
        super.onBootPhaseAppsCanStart();
        int i = 0;
    L4:
        if (i >= this.mSystemConditionProviders.size()) goto L7;
        this.mSystemConditionProviders.valueAt(i).onBootComplete();
        i = i + 1;
        goto L4
    }

    @Override // com.android.server.notification.ManagedServices
    public void onUserSwitched(int user) {
        super.onUserSwitched(user);
        int i = 0;
    L4:
        if (i >= this.mSystemConditionProviders.size()) goto L6;
        this.mSystemConditionProviders.valueAt(i).onUserSwitched(UserHandle.of(user));
        i = i + 1;
        goto L4
    }

    @Override // com.android.server.notification.ManagedServices
    protected void onServiceAdded(ManagedServices.ManagedServiceInfo info) {
        IConditionProvider provider = provider(info);
        provider.onConnected();     // Catch: RemoteException -> L5
    L8:
        if (this.mCallback == null) goto L13;
        this.mCallback.onServiceAdded(info.component);
        return;
    L13:
        return;
    L5:
        e = move-exception;
        Slog.e(this.TAG, "can't connect to service " + info, e);
        goto L8
    }

    @Override // com.android.server.notification.ManagedServices
    protected void ensureFilters(ServiceInfo si, int userId) {
    }

    @Override // com.android.server.notification.ManagedServices
    protected void loadDefaultsFromConfig() {
        String defaultDndAccess = this.mContext.getResources().getString(R.string.config_dreamsDefaultComponent);
        if (defaultDndAccess == null) goto L12;
        String[] dnds = defaultDndAccess.split(":");
        int i = 0;
    L6:
        if (i >= dnds.length) goto L16;
        if (TextUtils.isEmpty(dnds[i]) == true) goto L11;
        addDefaultComponentOrPackage(dnds[i]);
    L11:
        i = i + 1;
        goto L6
    L16:
        return;
    }

    @Override // com.android.server.notification.ManagedServices
    protected void onServiceRemovedLocked(ManagedServices.ManagedServiceInfo removed) {
        if (removed != null) goto L4;
        return;
    L4:
        int i = this.mRecords.size() - 1;
    L5:
        if (i < 0) goto L12;
        ConditionRecord r = this.mRecords.get(i);
        if (r.component.equals(removed.component) == false) goto L10;
        this.mRecords.remove(i);
    L10:
        i = i - 1;
        goto L5
    }

    @Override // com.android.server.notification.ManagedServices
    public void onPackagesChanged(boolean removingPackage, String[] pkgList, int[] uid) {
        if (removingPackage == false) goto L16;
        INotificationManager inm = NotificationManager.getService();
        if (pkgList == null) goto L16;
        if (pkgList.length <= 0) goto L16;
        int r1 = pkgList.length;
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L16;
        String pkgName = pkgList[r3];
        inm.removeAutomaticZenRules(pkgName, false);     // Catch: Exception -> L13
        inm.setNotificationPolicyAccessGranted(pkgName, false);     // Catch: Exception -> L13
    L15:
        r3 = r3 + 1;
    L13:
        e = move-exception;
        Slog.e(this.TAG, "Failed to clean up rules for " + pkgName, e);
    L16:
        super.onPackagesChanged(removingPackage, pkgList, uid);
    }

    @Override // com.android.server.notification.ManagedServices
    protected boolean isValidEntry(String packageOrComponent, int userId) {
        return true;
    }

    @Override // com.android.server.notification.ManagedServices
    protected boolean allowRebindForParentUser() {
        return true;
    }

    @Override // com.android.server.notification.ManagedServices
    protected String getRequiredPermission() {
        return null;
    }

    public ManagedServices.ManagedServiceInfo checkServiceToken(IConditionProvider provider) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
        ManagedServices.ManagedServiceInfo r1 = checkServiceTokenLocked(provider);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private Condition[] getValidConditions(String pkg, Condition[] conditions) {
        if (conditions != null) goto L5;
    L29:
        return null;
    L5:
        if (conditions.length == 0) goto L29;
        int N = conditions.length;
        ArrayMap<Uri, Condition> valid = new ArrayMap(N);
        int i = 0;
    L8:
        if (i >= N) goto L17;
        if (conditions[i] != null) goto L12;
        Slog.w(this.TAG, "Ignoring null condition from " + pkg);
    L16:
        i = i + 1;
        goto L8
    L12:
        Uri id = conditions[i].id;
        if (valid.containsKey(id) == false) goto L15;
        Slog.w(this.TAG, "Ignoring condition from " + pkg + " for duplicate id: " + id);
        goto L16
    L15:
        valid.put(id, conditions[i]);
        goto L16
    L17:
        int i2 = valid.size();
        if (i2 != 0) goto L21;
        return null;
    L21:
        if (valid.size() != N) goto L23;
        return conditions;
    L23:
        Condition[] rt = new Condition[valid.size()];
        int i3 = 0;
    L25:
        if (i3 >= rt.length) goto L28;
        rt[i3] = valid.valueAt(i3);
        i3 = i3 + 1;
        goto L25
    L28:
        return rt;
    }

    ConditionRecord getRecord(Uri id, ComponentName component) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
        ConditionRecord r1 = getRecordLocked(id, component, false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    private ConditionRecord getRecordLocked(Uri id, ComponentName component, boolean create) {
        ConditionProvidersIA r0 = null;
        if (id == null) goto L19;
        if (component == null) goto L19;
        int N = this.mRecords.size();
        int i = 0;
    L7:
        if (i >= N) goto L15;
        ConditionRecord r = this.mRecords.get(i);
        if (r.id.equals(id) == false) goto L13;
        if (r.component.equals(component) == false) goto L13;
        return r;
    L13:
        i = i + 1;
        goto L7
    L15:
        if (create == false) goto L18;
        ConditionRecord r2 = new ConditionRecord(id, component, r0);
        this.mRecords.add(r2);
        return r2;
    L18:
        return null;
    L19:
        return null;
    }

    public void notifyConditions(String pkg, ManagedServices.ManagedServiceInfo info, Condition[] conditions) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.DEBUG == false) goto L13;
        String r1 = this.TAG;     // Catch: Throwable -> L11
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L11
        r2.append("notifyConditions pkg=");     // Catch: Throwable -> L11
        r2.append(pkg);     // Catch: Throwable -> L11
        r2.append(" info=");     // Catch: Throwable -> L11
        r2.append(info);     // Catch: Throwable -> L11
        r2.append(" conditions=");     // Catch: Throwable -> L11
        if (conditions != null) goto L9;
        List r3 = null;
    L10:
        r2.append(r3);     // Catch: Throwable -> L11
        Slog.d(r1, r2.toString());     // Catch: Throwable -> L11
        goto L13
    L9:
        r3 = Arrays.asList(conditions);     // Catch: Throwable -> L11
    L13:
        Condition[] conditions2 = getValidConditions(pkg, conditions);     // Catch: Throwable -> L11
        if (conditions2 == null) goto L31;
        if (conditions2.length == 0) goto L31;
        int N = conditions2.length;     // Catch: Throwable -> L11
        int i = 0;
    L19:
        if (i >= N) goto L22;
        Condition c = conditions2[i];     // Catch: Throwable -> L11
        ConditionRecord r = getRecordLocked(c.id, info.component, true);     // Catch: Throwable -> L11
        r.info = info;     // Catch: Throwable -> L11
        r.condition = c;     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L19
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L11
        int N2 = conditions2.length;
        int i2 = 0;
    L24:
        if (i2 >= N2) goto L30;
        Condition c2 = conditions2[i2];
        if (this.mCallback == null) goto L28;
        this.mCallback.onConditionChanged(c2.id, c2, info.uid);
    L28:
        i2 = i2 + 1;
        goto L24
    L30:
        return;
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public IConditionProvider findConditionProvider(ComponentName component) {
        if (component != null) goto L5;
        return null;
    L5:
        Iterator<ManagedServices.ManagedServiceInfo> r1 = getServices().iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        ManagedServices.ManagedServiceInfo service = r1.next();
        if (component.equals(service.component) == false) goto L7;
        return provider(service);
    L13:
        return null;
    }

    public Condition findCondition(ComponentName component, Uri conditionId) {
        Condition r0 = null;
        if (component == null) goto L18;
        if (conditionId == null) goto L18;
        Object r1 = this.mMutex;
        monitor-enter(r1);
        ConditionRecord r = getRecordLocked(conditionId, component, false);     // Catch: Throwable -> L12
        if (r == null) goto L14;
        r0 = r.condition;     // Catch: Throwable -> L12
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r0;
    L12:
        th = move-exception;
        throw th;
    L18:
        return null;
    }

    public void ensureRecordExists(ComponentName component, Uri conditionId, IConditionProvider provider) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
        ConditionRecord r = getRecordLocked(conditionId, component, true);     // Catch: Throwable -> L8
        if (r.info != null) goto L10;
        r.info = checkServiceTokenLocked(provider);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean subscribeIfNecessary(ComponentName component, Uri conditionId) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
        ConditionRecord r = getRecordLocked(conditionId, component, false);     // Catch: Throwable -> L10
        if (r != null) goto L13;
        Slog.w(this.TAG, "Unable to subscribe to " + component + " " + conditionId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L13:
        if (r.subscribed == false) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    L17:
        subscribeLocked(r);     // Catch: Throwable -> L10
        boolean r1 = r.subscribed;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public void unsubscribeIfNecessary(ComponentName component, Uri conditionId) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
        ConditionRecord r = getRecordLocked(conditionId, component, false);     // Catch: Throwable -> L10
        if (r != null) goto L13;
        Slog.w(this.TAG, "Unable to unsubscribe to " + component + " " + conditionId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L13:
        if (r.subscribed == true) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L16:
        unsubscribeLocked(r);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void subscribeLocked(ConditionRecord r) {
        if (this.DEBUG == false) goto L5;
        Slog.d(this.TAG, "subscribeLocked " + r);
    L5:
        IConditionProvider provider = provider(r);
        RemoteException re = null;
        if (provider != null) goto L16;
    L11:
        if (r == null) goto L13;
        Uri r2 = r.id;
    L14:
        ZenLog.traceSubscribe(r2, provider, re);
        return;
    L13:
        r2 = null;
        goto L14
    L16:
        Slog.d(this.TAG, "Subscribing to " + r.id + " with " + r.component);     // Catch: RemoteException -> L9
        provider.onSubscribe(r.id);     // Catch: RemoteException -> L9
        r.subscribed = true;     // Catch: RemoteException -> L9
    L9:
        e = move-exception;
        Slog.w(this.TAG, "Error subscribing to " + r, e);
        re = e;
        goto L11
    }

    @SafeVarargs
    private static <T> ArraySet<T> safeSet(T... items) {
        ArraySet<T> rt = new ArraySet();
        if (items != null) goto L5;
    L15:
        return rt;
    L5:
        if (items.length == 0) goto L15;
        int N = items.length;
        int i = 0;
    L8:
        if (i >= N) goto L14;
        T item = items[i];
        if (item == null) goto L12;
        rt.add(item);
    L12:
        i = i + 1;
        goto L8
    L14:
        return rt;
    }

    private void unsubscribeLocked(ConditionRecord r) {
        if (this.DEBUG == false) goto L5;
        Slog.d(this.TAG, "unsubscribeLocked " + r);
    L5:
        IConditionProvider provider = provider(r);
        RemoteException re = null;
        if (provider != null) goto L17;
    L12:
        if (r == null) goto L14;
        Uri r2 = r.id;
    L15:
        ZenLog.traceUnsubscribe(r2, provider, re);
        return;
    L14:
        r2 = null;
        goto L15
    L17:
        provider.onUnsubscribe(r.id);     // Catch: RemoteException -> L9
    L11:
        r.subscribed = false;
    L9:
        e = move-exception;
        Slog.w(this.TAG, "Error unsubscribing to " + r, e);
        re = e;
        goto L11
    }

    private static IConditionProvider provider(ConditionRecord r) {
        if (r != null) goto L5;
        return null;
    L5:
        return provider(r.info);
    }

    private static IConditionProvider provider(ManagedServices.ManagedServiceInfo info) {
        if (info != null) goto L5;
        return null;
    L5:
        return info.service;
    }

    void resetDefaultFromConfig() {
        Object r0 = this.mDefaultsLock;
        monitor-enter(r0);
        this.mDefaultComponents.clear();     // Catch: Throwable -> L8
        this.mDefaultPackages.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        loadDefaultsFromConfig();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    boolean removeDefaultFromConfig(int userId) {
        boolean removed = false;
        String defaultDndDenied = this.mContext.getResources().getString(R.string.config_emergency_call_number);
        if (defaultDndDenied == null) goto L12;
        String[] dnds = defaultDndDenied.split(":");
        int i = 0;
    L6:
        if (i >= dnds.length) goto L12;
        if (TextUtils.isEmpty(dnds[i]) == true) goto L11;
        removed = removed | removePackageFromApprovedLists(userId, dnds[i], "remove from config");
    L11:
        i = i + 1;
    L12:
        return removed;
    }

    private boolean removePackageFromApprovedLists(int userId, String pkg, String reason) {
        boolean removed = false;
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r2 = this.mApproved;
        monitor-enter(r2);
        ArrayMap<Boolean, ArraySet<String>> approvedByType = this.mApproved.get(Integer.valueOf(userId));     // Catch: Throwable -> L26
        if (approvedByType == null) goto L31;
        int approvedByTypeSize = approvedByType.size();     // Catch: Throwable -> L26
        int i = 0;
    L7:
        if (i >= approvedByTypeSize) goto L31;
        ArraySet<String> approved = approvedByType.valueAt(i);     // Catch: Throwable -> L26
        int approvedSize = approved.size();     // Catch: Throwable -> L26
        int j = approvedSize - 1;     // Catch: Throwable -> L26
    L9:
        if (j < 0) goto L28;
        String packageOrComponent = approved.valueAt(j);     // Catch: Throwable -> L26
        String packageName = getPackageName(packageOrComponent);     // Catch: Throwable -> L26
    L21:
        th = th;
    L33:
        monitor-exit(r2);     // Catch: Throwable -> L19
        throw th;
    L13:
        if (TextUtils.equals(pkg, packageName) == false) goto L25;
        approved.removeAt(j);     // Catch: Throwable -> L21
        removed = true;
        if (this.DEBUG == false) goto L25;
        String r11 = this.TAG;     // Catch: Throwable -> L21
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L21
        r12.append("Removing ");     // Catch: Throwable -> L21
        r12.append(packageOrComponent);     // Catch: Throwable -> L21
        r12.append(" from approved list; ");     // Catch: Throwable -> L21
        r12.append(reason);     // Catch: Throwable -> L19
        Slog.v(r11, r12.toString());     // Catch: Throwable -> L19
    L19:
        th = th;
    L25:
        j = j - 1;     // Catch: Throwable -> L19
        goto L9
    L28:
        i = i + 1;     // Catch: Throwable -> L19
    L31:
        monitor-exit(r2);     // Catch: Throwable -> L19
        return removed;
    L26:
        th = th;
        goto L33
    }
}
