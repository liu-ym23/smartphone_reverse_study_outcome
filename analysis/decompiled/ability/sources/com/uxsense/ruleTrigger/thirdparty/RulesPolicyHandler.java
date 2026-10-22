package com.uxsense.ruleTrigger.thirdparty;

import B7.a;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import com.uxsense.base.parse.ViewTreeBuilder;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.core.pattern.PatternMatchResult;
import com.uxsense.ruleTrigger.IRuleCallback;
import com.uxsense.ruleTrigger.RuleMatchResult;
import com.uxsense.ruleTrigger.TriggerRule;
import com.uxsense.ruleTrigger.TriggerRuleParse;
import com.uxsense.ruleTrigger.model.TriggerCondition;
import com.uxsense.ruleTrigger.model.TriggerEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class RulesPolicyHandler {
    private static final boolean DEBUG = true;
    private static final String TAG = "RulesPolicyHandler";
    private static IRuleCallback callback;
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private static final List<TriggerRule> mTriggerRuleList = new ArrayList();
    private static final Map<String, RuleState> sRuleStates = new HashMap();

    public static final class RuleState {
        int fireCount;
        long lastFireUptime;

        private RuleState() {
        }
    }

    private static Runnable createFireRunnable(final TriggerRule triggerRule, final int i, final String str, final IRuleCallback iRuleCallback, final View view) {
        return new Runnable() { // from class: com.uxsense.ruleTrigger.thirdparty.RulesPolicyHandler.1
            @Override // java.lang.Runnable
            public void run() {
                View view2;
                if (i == 20 && (view2 = view) != null && !view2.isAttachedToWindow()) {
                    Log.d(RulesPolicyHandler.TAG, "createFireRunnable: view detached, skip rule=" + triggerRule.getName());
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (RulesPolicyHandler.shouldFire(triggerRule, jUptimeMillis)) {
                    Intent intent = new Intent();
                    intent.putExtra("apex.event", i);
                    String str2 = str;
                    if (str2 != null) {
                        intent.putExtra("targetWindowTitle", str2);
                    }
                    RulesPolicyHandler.replyTriggerEventToApex(iRuleCallback, 0, intent);
                    RulesPolicyHandler.markFired(triggerRule, jUptimeMillis);
                }
            }
        };
    }

    private static Object dispatchClick(View view, String str, IRuleCallback iRuleCallback) throws Resources.NotFoundException {
        String resourceEntryName;
        if (!mTriggerRuleList.isEmpty() && iRuleCallback != null) {
            String name = view.getClass().getName();
            try {
                resourceEntryName = view.getResources().getResourceEntryName(view.getId());
            } catch (Resources.NotFoundException unused) {
                resourceEntryName = "";
            }
            String str2 = TAG;
            StringBuilder sbW = a.w("dispatchClick: className=", name, ", resourceEntryName=", resourceEntryName, ", windowTitle=");
            sbW.append(str);
            Log.d(str2, sbW.toString());
            for (TriggerRule triggerRule : mTriggerRuleList) {
                if (triggerRule.isEnabled() && triggerRule.getTrigger().getViewTriggers().length != 0 && (str == null || triggerRule.matchesActivity(str))) {
                    Intent intent = new Intent();
                    intent.putExtra("apex.event", 100);
                    if (str != null) {
                        intent.putExtra("targetWindowTitle", str);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("clickedViewClass", name);
                    bundle.putString("clickedViewId", resourceEntryName);
                    bundle.putString("ruleName", triggerRule.getName());
                    intent.putExtra("apex.extras", bundle);
                    replyTriggerEventToApex(iRuleCallback, 0, intent);
                    Log.i(TAG, "dispatchClick: fired rule=" + triggerRule.getName());
                }
            }
        }
        return null;
    }

    private static Object dispatchFirstTraversals(View view, String str) {
        ArrayList arrayList = new ArrayList();
        List<TriggerRule> list = mTriggerRuleList;
        if (list.isEmpty()) {
            Log.d(TAG, "dispatchFirstTraversals, no rules available");
            return arrayList;
        }
        ViewTreeBuilder.BuildResult buildResultBuild = ViewTreeBuilder.build(view);
        List<RuleMatchResult> list2 = TriggerRuleParse.parse(buildResultBuild.getRootNode(), list, str);
        String str2 = TAG;
        StringBuilder sbV = a.v("dispatchFirstTraversals, windowTitle=", str, ", matchResults=");
        sbV.append(list2.size());
        Log.d(str2, sbV.toString());
        if (list2.isEmpty()) {
            return arrayList;
        }
        for (int i = 0; i < list2.size(); i++) {
            RuleMatchResult ruleMatchResult = list2.get(i);
            TriggerRule rule = ruleMatchResult.getRule();
            boolean z10 = rule.getTrigger().getViewTriggers().length > 0;
            String str3 = TAG;
            StringBuilder sbU = a.u(i, "  [", "] Rule: ");
            sbU.append(rule.getName());
            sbU.append(", hasViewTriggers=");
            sbU.append(z10);
            sbU.append(", matchCount=");
            sbU.append(ruleMatchResult.getMatchCount());
            Log.i(str3, sbU.toString());
            if (z10 && rule.getViewPattern() != null) {
                Iterator<PatternMatchResult> it = ruleMatchResult.getMatchResults().iterator();
                while (it.hasNext()) {
                    Map<String, KViewNode> nodesWithTriggers = it.next().getNodesWithTriggers();
                    Log.i(TAG, "       - Nodes with triggers: " + nodesWithTriggers.keySet());
                    Iterator<Map.Entry<String, KViewNode>> it2 = nodesWithTriggers.entrySet().iterator();
                    while (it2.hasNext()) {
                        KViewNode value = it2.next().getValue();
                        View viewFindView = buildResultBuild.findView(value.getNodeId());
                        if (viewFindView != null) {
                            arrayList.add(viewFindView);
                        } else {
                            Log.w(TAG, "       View not found for nodeId=" + value.getNodeId());
                        }
                    }
                }
            }
        }
        Log.i(TAG, "[TriggerRule] Total views to monitor: " + arrayList.size());
        return arrayList;
    }

    private static void dispatchLifecycle(View view, int i, String str, long j5) {
        IRuleCallback iRuleCallback;
        List<TriggerRule> list = mTriggerRuleList;
        if (list.isEmpty() || (iRuleCallback = callback) == null) {
            return;
        }
        for (TriggerRule triggerRule : list) {
            if (triggerRule.isEnabled() && triggerRule.hasActivityTrigger() && triggerRule.shouldTriggerOnActivity(i) && (str == null || triggerRule.matchesActivity(str))) {
                if (shouldFire(triggerRule, j5)) {
                    Runnable runnableCreateFireRunnable = createFireRunnable(triggerRule, i, str, iRuleCallback, view);
                    long delayMillis = triggerRule.getTrigger().getDelayMillis();
                    if (delayMillis > 0) {
                        MAIN_HANDLER.postDelayed(runnableCreateFireRunnable, delayMillis);
                    } else {
                        runnableCreateFireRunnable.run();
                    }
                } else {
                    Log.d(TAG, "dispatchLifecycle: skip by cooldown/triggerOnce, rule=" + triggerRule.getName());
                }
            }
        }
    }

    public static Object handleTriggerEvent(View view, Intent intent) {
        if (intent == null) {
            return null;
        }
        int intExtra = intent.getIntExtra("apex.event", -1);
        if (intExtra < 0) {
            Log.d(TAG, "handleTriggerEvent: missing event id");
            return null;
        }
        String stringExtra = intent.getStringExtra("apex.windowTitle");
        long jUptimeMillis = SystemClock.uptimeMillis();
        String str = TAG;
        Log.d(str, "handleTriggerEvent: event=" + TriggerEvent.name(intExtra) + ", windowTitle=" + stringExtra);
        if (intExtra == 20) {
            dispatchLifecycle(view, intExtra, stringExtra, jUptimeMillis);
            return dispatchFirstTraversals(view, stringExtra);
        }
        if (intExtra == 100) {
            return dispatchClick(view, stringExtra, callback);
        }
        switch (intExtra) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                dispatchLifecycle(view, intExtra, stringExtra, jUptimeMillis);
                break;
            default:
                androidx.constraintlayout.core.dsl.a.p(intExtra, "handleTriggerEvent: unhandled event ", str);
                break;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void markFired(TriggerRule triggerRule, long j5) {
        Map<String, RuleState> map = sRuleStates;
        RuleState ruleState = map.get(triggerRule.getName());
        if (ruleState == null) {
            ruleState = new RuleState();
            map.put(triggerRule.getName(), ruleState);
        }
        ruleState.lastFireUptime = j5;
        ruleState.fireCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void replyTriggerEventToApex(IRuleCallback iRuleCallback, int i, Intent intent) {
        if (iRuleCallback == null) {
            return;
        }
        try {
            iRuleCallback.onTriggerEvent(i, intent);
        } catch (RemoteException e) {
            Log.e(TAG, "replyTriggerEventToApex: binder failed", e);
        }
    }

    public static void requestTriggerRules(Intent intent) {
        String str = TAG;
        Log.d(str, "requestTriggerRules...");
        if (intent.getExtras() == null) {
            Log.e(str, "requestTriggerRules, extras is null.");
            return;
        }
        IBinder binder = intent.getExtras().getBinder("targetDexBinder");
        if (binder == null || !binder.isBinderAlive()) {
            Log.e(str, "requestTriggerRules, callback binder is null or died.");
            return;
        }
        IRuleCallback iRuleCallbackAsInterface = IRuleCallback.Stub.asInterface(binder);
        callback = iRuleCallbackAsInterface;
        if (iRuleCallbackAsInterface == null) {
            Log.e(str, "requestTriggerRules, callback is null.");
            return;
        }
        String string = intent.getExtras().getString("targetFindPackage");
        String string2 = intent.getExtras().getString("targetAppVersion");
        List<TriggerRule> listRequestRules = Collections.EMPTY_LIST;
        try {
            listRequestRules = callback.requestRules(string, string2);
        } catch (RemoteException e) {
            Log.w(TAG, "requestTriggerRules, error, " + e.getMessage());
        }
        if (listRequestRules == null || listRequestRules.isEmpty()) {
            Log.w(TAG, "requestTriggerRules, triggerRuleList is empty.");
            return;
        }
        List<TriggerRule> list = mTriggerRuleList;
        list.clear();
        list.addAll(listRequestRules);
        sRuleStates.clear();
        for (TriggerRule triggerRule : list) {
            Log.d(TAG, "" + triggerRule);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldFire(TriggerRule triggerRule, long j5) {
        Map<String, RuleState> map = sRuleStates;
        RuleState ruleState = map.get(triggerRule.getName());
        if (ruleState == null) {
            ruleState = new RuleState();
            map.put(triggerRule.getName(), ruleState);
        }
        TriggerCondition trigger = triggerRule.getTrigger();
        if (trigger.isTriggerOnce() && ruleState.fireCount > 0) {
            return false;
        }
        if (trigger.getMaxTriggerCount() <= 0 || ruleState.fireCount < trigger.getMaxTriggerCount()) {
            return trigger.getCooldownMillis() <= 0 || j5 - ruleState.lastFireUptime >= trigger.getCooldownMillis();
        }
        return false;
    }
}
