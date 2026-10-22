package com.android.server.notification;

import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.service.notification.ZenAdapters;
import android.service.notification.ZenModeConfig;
import android.service.notification.ZenModeDiff;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.logging.UiEventLogger;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.pm.PackageManagerService;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class ZenModeEventLogger {
    protected static final int ACTIVE_RULE_TYPE_MANUAL = 999;
    private static final String TAG = "ZenModeEventLogger";
    static final int ZEN_MODE_UNKNOWN = -1;
    ZenStateChanges mChangeState;
    private final PackageManager mPm;

    public static class ZenModeInfo {
        final ZenModeConfig mConfig;
        final NotificationManager.Policy mPolicy;
        final int mZenMode;

        ZenModeInfo(int zenMode, ZenModeConfig config, NotificationManager.Policy policy) {
            this.mZenMode = zenMode;
            NotificationManager.Policy r0 = null;
            if (config == null) goto L5;
            ZenModeConfig r1 = config.copy();
        L6:
            this.mConfig = r1;
            if (policy == null) goto L9;
            r0 = policy.copy();
        L9:
            this.mPolicy = r0;
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static final enum ZenStateChangedEvent extends Enum<ZenStateChangedEvent> implements UiEventLogger.UiEventEnum {
        private static final /* synthetic */ ZenStateChangedEvent[] $VALUES = null;
        public static final ZenStateChangedEvent DND_ACTIVE_RULES_CHANGED = null;
        public static final ZenStateChangedEvent DND_POLICY_CHANGED = null;
        public static final ZenStateChangedEvent DND_TURNED_OFF = null;
        public static final ZenStateChangedEvent DND_TURNED_ON = null;
        private final int mId;

        private static /* synthetic */ ZenStateChangedEvent[] $values() {
            return new ZenStateChangedEvent[]{DND_TURNED_ON, DND_TURNED_OFF, DND_POLICY_CHANGED, DND_ACTIVE_RULES_CHANGED};
        }

        public static ZenStateChangedEvent valueOf(String name) {
            return (ZenStateChangedEvent) Enum.valueOf(ZenStateChangedEvent.class, name);
        }

        public static ZenStateChangedEvent[] values() {
            return (ZenStateChangedEvent[]) $VALUES.clone();
        }

        static {
            DND_TURNED_ON = new ZenStateChangedEvent("DND_TURNED_ON", 0, 1368);
            DND_TURNED_OFF = new ZenStateChangedEvent("DND_TURNED_OFF", 1, 1369);
            DND_POLICY_CHANGED = new ZenStateChangedEvent("DND_POLICY_CHANGED", 2, 1370);
            DND_ACTIVE_RULES_CHANGED = new ZenStateChangedEvent("DND_ACTIVE_RULES_CHANGED", 3, 1371);
            $VALUES = $values();
        }

        private ZenStateChangedEvent(String r1, int r2, int id) {
            super(r1, r2);
            this.mId = id;
        }

        public int getId() {
            return this.mId;
        }
    }

    static class ZenStateChanges {
        int mCallingUid;
        ZenModeConfig mNewConfig;
        NotificationManager.Policy mNewPolicy;
        int mNewZenMode;
        int mOrigin;
        ZenModeConfig mPrevConfig;
        NotificationManager.Policy mPrevPolicy;
        int mPrevZenMode;

        /* JADX INFO: renamed from: -$$Nest$mgetChangedAutomaticRules, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m6300$$Nest$mgetChangedAutomaticRules(ZenStateChanges r0) {
            return r0.getChangedAutomaticRules();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetNewManualRuleEnabler, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6301$$Nest$mgetNewManualRuleEnabler(ZenStateChanges r0) {
            return r0.getNewManualRuleEnabler();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetRulePackageAndUser, reason: not valid java name */
        static /* bridge */ /* synthetic */ Pair m6302$$Nest$mgetRulePackageAndUser(ZenStateChanges r0, String r1, ZenModeDiff.RuleDiff r2) {
            return r0.getRulePackageAndUser(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$minit, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6303$$Nest$minit(ZenStateChanges r0, ZenModeInfo r1, ZenModeInfo r2, int r3, int r4) {
            r0.init(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mshouldLogChanges, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6304$$Nest$mshouldLogChanges(ZenStateChanges r0) {
            return r0.shouldLogChanges();
        }

        ZenStateChanges() {
            this.mPrevZenMode = -1;
            this.mNewZenMode = -1;
            this.mCallingUid = -1;
            this.mOrigin = 0;
        }

        private void init(ZenModeInfo prevInfo, ZenModeInfo newInfo, int callingUid, int origin) {
            this.mPrevZenMode = prevInfo.mZenMode;
            this.mNewZenMode = newInfo.mZenMode;
            this.mPrevConfig = prevInfo.mConfig;
            this.mNewConfig = newInfo.mConfig;
            this.mPrevPolicy = prevInfo.mPolicy;
            this.mNewPolicy = newInfo.mPolicy;
            this.mCallingUid = callingUid;
            this.mOrigin = origin;
        }

        private boolean hasPolicyDiff() {
            if (this.mPrevPolicy != null) goto L5;
        L7:
            return false;
        L5:
            if (Objects.equals(this.mPrevPolicy, this.mNewPolicy) == true) goto L7;
            return true;
        }

        private boolean shouldLogChanges() {
            if (zenModeFlipped() == false) goto L6;
            return true;
        L6:
            if (hasActiveRuleCountDiff() == false) goto L9;
            return true;
        L9:
            if (this.mNewZenMode != 0) goto L12;
            return false;
        L12:
            if (hasPolicyDiff() == false) goto L14;
            return true;
        L14:
            if (hasActiveRuleCountDiff() == false) goto L17;
            return true;
        L17:
            return false;
        }

        private boolean zenModeFlipped() {
            if (this.mPrevZenMode != this.mNewZenMode) goto L6;
            return false;
        L6:
            if (this.mPrevZenMode != 0) goto L8;
        L9:
            return true;
        L8:
            if (this.mNewZenMode == 0) goto L9;
            return false;
        }

        ZenStateChangedEvent getEventId() {
            if (shouldLogChanges() == true) goto L6;
            Log.wtf(ZenModeEventLogger.TAG, "attempt to get DNDStateChanged fields without shouldLog=true");
        L6:
            if (zenModeFlipped() == false) goto L14;
            if (this.mPrevZenMode != 0) goto L12;
            return ZenStateChangedEvent.DND_TURNED_ON;
        L12:
            return ZenStateChangedEvent.DND_TURNED_OFF;
        L14:
            if (this.mNewZenMode != 0) goto L23;
            if (hasPolicyDiff() == false) goto L18;
        L19:
            Log.wtf(ZenModeEventLogger.TAG, "Detected policy diff even though DND is OFF and not toggled");
        L21:
            return ZenStateChangedEvent.DND_ACTIVE_RULES_CHANGED;
        L18:
            if (hasChannelsBypassingDiff() == false) goto L21;
        L23:
            if (hasPolicyDiff() == true) goto L30;
            if (hasChannelsBypassingDiff() == true) goto L30;
            return ZenStateChangedEvent.DND_ACTIVE_RULES_CHANGED;
        L30:
            return ZenStateChangedEvent.DND_POLICY_CHANGED;
        }

        int getChangedRuleType() {
            ZenModeDiff.ConfigDiff diff = new ZenModeDiff.ConfigDiff(this.mPrevConfig, this.mNewConfig);
            if (diff.hasDiff() == true) goto L5;
            return 0;
        L5:
            ZenModeDiff.RuleDiff manualDiff = diff.getManualRuleDiff();
            if (manualDiff != null) goto L8;
        L19:
            ArrayMap<String, ZenModeDiff.RuleDiff> autoDiffs = diff.getAllAutomaticRuleDiffs();
            if (autoDiffs == null) goto L35;
            Iterator<ZenModeDiff.RuleDiff> r4 = autoDiffs.values().iterator();
        L23:
            if (r4.hasNext() == false) goto L35;
            ZenModeDiff.RuleDiff d = r4.next();
            if (d == null) goto L23;
            if (d.hasDiff() == false) goto L23;
            if (d.becameActive() == true) goto L32;
            if (d.becameInactive() == false) goto L23;
            return 2;
        L32:
            return 2;
        L35:
            return 0;
        L8:
            if (manualDiff.hasDiff() == false) goto L19;
            if (manualDiff.wasAdded() == false) goto L12;
            return 1;
        L12:
            if (manualDiff.wasRemoved() == false) goto L14;
            return 1;
        L14:
            if (manualDiff.becameActive() == false) goto L16;
            return 1;
        L16:
            if (manualDiff.becameInactive() == false) goto L19;
            return 1;
        }

        private boolean hasActiveRuleCountDiff() {
            if (numActiveRulesInConfig(this.mPrevConfig) == numActiveRulesInConfig(this.mNewConfig)) goto L5;
            return true;
        L5:
            return false;
        }

        List<ZenModeConfig.ZenRule> activeRulesList(ZenModeConfig config) {
            ArrayList<ZenModeConfig.ZenRule> rules = new ArrayList();
            if (config != null) goto L6;
            return rules;
        L6:
            if (config.isManualActive() == false) goto L9;
            ZenModeConfig.ZenRule rule = config.manualRule.copy();
            rule.type = 999;
            rules.add(rule);
        L9:
            if (config.automaticRules == null) goto L19;
            Iterator r1 = config.automaticRules.values().iterator();
        L12:
            if (r1.hasNext() == false) goto L19;
            ZenModeConfig.ZenRule rule2 = (ZenModeConfig.ZenRule) r1.next();
            if (rule2 == null) goto L12;
            if (rule2.isActive() == false) goto L12;
            rules.add(rule2);
        L19:
            return rules;
        }

        int numActiveRulesInConfig(ZenModeConfig config) {
            return activeRulesList(config).size();
        }

        int getNumRulesActive() {
            return numActiveRulesInConfig(this.mNewConfig);
        }

        int[] getActiveRuleTypes() {
            ArrayList<Integer> activeTypes = new ArrayList();
            List<ZenModeConfig.ZenRule> activeRules = activeRulesList(this.mNewConfig);
            if (activeRules.size() == 0) goto L5;
            Iterator<ZenModeConfig.ZenRule> r2 = activeRules.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            ZenModeConfig.ZenRule rule = r2.next();
            activeTypes.add(Integer.valueOf(rule.type));
            goto L8
        L10:
            Collections.sort(activeTypes);
            int[] out = new int[activeTypes.size()];
            int i = 0;
        L12:
            if (i >= activeTypes.size()) goto L15;
            out[i] = activeTypes.get(i).intValue();
            i = i + 1;
            goto L12
        L15:
            return out;
        L5:
            return new int[0];
        }

        boolean getIsUserAction() {
            if (this.mOrigin != 3) goto L5;
        L8:
            return true;
        L5:
            if (this.mOrigin == 7) goto L8;
            return false;
        }

        boolean isFromSystemOrSystemUi() {
            if (this.mOrigin != 1) goto L5;
            return true;
        L5:
            if (this.mOrigin != 2) goto L7;
            return true;
        L7:
            if (this.mOrigin != 5) goto L9;
            return true;
        L9:
            if (this.mOrigin == 6) goto L16;
            return false;
        L16:
            return true;
        }

        int getPackageUid() {
            return this.mCallingUid;
        }

        int getChangeOrigin() {
            return this.mOrigin;
        }

        byte[] getDNDPolicyProto() {
            if (this.mNewZenMode != 0) goto L6;
            return null;
        L6:
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ProtoOutputStream proto = new ProtoOutputStream(bytes);
            if (this.mNewPolicy == null) goto L13;
            proto.write(1159641169921L, toState(this.mNewPolicy.allowCalls()));
            proto.write(1159641169922L, toState(this.mNewPolicy.allowRepeatCallers()));
            proto.write(1159641169923L, toState(this.mNewPolicy.allowMessages()));
            proto.write(1159641169924L, toState(this.mNewPolicy.allowConversations()));
            proto.write(1159641169925L, toState(this.mNewPolicy.allowReminders()));
            proto.write(1159641169926L, toState(this.mNewPolicy.allowEvents()));
            proto.write(1159641169927L, toState(this.mNewPolicy.allowAlarms()));
            proto.write(1159641169928L, toState(this.mNewPolicy.allowMedia()));
            proto.write(1159641169929L, toState(this.mNewPolicy.allowSystem()));
            proto.write(1159641169930L, toState(this.mNewPolicy.showFullScreenIntents()));
            proto.write(1159641169931L, toState(this.mNewPolicy.showLights()));
            proto.write(1159641169932L, toState(this.mNewPolicy.showPeeking()));
            proto.write(1159641169933L, toState(this.mNewPolicy.showStatusBarIcons()));
            proto.write(1159641169934L, toState(this.mNewPolicy.showBadges()));
            proto.write(1159641169935L, toState(this.mNewPolicy.showAmbient()));
            proto.write(1159641169936L, toState(this.mNewPolicy.showInNotificationList()));
            proto.write(1159641169937L, ZenAdapters.prioritySendersToPeopleType(this.mNewPolicy.allowCallsFrom()));
            proto.write(1159641169938L, ZenAdapters.prioritySendersToPeopleType(this.mNewPolicy.allowMessagesFrom()));
            proto.write(1159641169939L, this.mNewPolicy.allowConversationsFrom());
            if (this.mNewPolicy.allowPriorityChannels() == false) goto L11;
            int r2 = 1;
        L12:
            proto.write(1159641169940L, r2);
        L14:
            proto.flush();
            return bytes.toByteArray();
        L11:
            r2 = 2;
            goto L12
        L13:
            Log.wtf(ZenModeEventLogger.TAG, "attempted to write zen mode log event with null policy");
            goto L14
        }

        boolean getAreChannelsBypassing() {
            if (this.mNewPolicy != null) goto L5;
            return false;
        L5:
            if ((this.mNewPolicy.state & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        private boolean hasChannelsBypassingDiff() {
            if (this.mPrevPolicy != null) goto L5;
        L7:
            boolean prevChannelsBypassing = false;
        L9:
            if (prevChannelsBypassing != getAreChannelsBypassing()) goto L11;
            return false;
        L11:
            return true;
        L5:
            if ((this.mPrevPolicy.state & 1) == 0) goto L7;
            prevChannelsBypassing = true;
            goto L9
        }

        private int toState(boolean allow) {
            if (allow == false) goto L4;
            return 1;
        L4:
            return 2;
        }

        private ArrayMap<String, ZenModeDiff.RuleDiff> getChangedAutomaticRules() {
            ArrayMap<String, ZenModeDiff.RuleDiff> ruleDiffs = new ArrayMap();
            ZenModeDiff.ConfigDiff diff = new ZenModeDiff.ConfigDiff(this.mPrevConfig, this.mNewConfig);
            if (diff.hasDiff() == true) goto L5;
            return ruleDiffs;
        L5:
            ArrayMap<String, ZenModeDiff.RuleDiff> autoDiffs = diff.getAllAutomaticRuleDiffs();
            if (autoDiffs == null) goto L8;
            return autoDiffs;
        L8:
            return ruleDiffs;
        }

        private Pair<String, Integer> getRulePackageAndUser(String id, ZenModeDiff.RuleDiff diff) {
            ZenModeConfig configForSearch = this.mNewConfig;
            if (diff.wasRemoved() == false) goto L6;
            configForSearch = this.mPrevConfig;
        L6:
            if (configForSearch != null) goto L8;
            return null;
        L8:
            ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) configForSearch.automaticRules.getOrDefault(id, null);
            if (rule != null) goto L11;
        L18:
            return null;
        L11:
            if (rule.component == null) goto L15;
            return new Pair(rule.component.getPackageName(), Integer.valueOf(configForSearch.user));
        L15:
            if (rule.configurationActivity == null) goto L18;
            return new Pair(rule.configurationActivity.getPackageName(), Integer.valueOf(configForSearch.user));
        }

        private String getNewManualRuleEnabler() {
            if (this.mNewConfig != null) goto L5;
            return null;
        L5:
            if (this.mNewConfig.manualRule != null) goto L8;
            return null;
        L8:
            return this.mNewConfig.manualRule.enabler;
        }

        protected ZenStateChanges copy() {
            ZenStateChanges copy = new ZenStateChanges();
            copy.mPrevZenMode = this.mPrevZenMode;
            copy.mNewZenMode = this.mNewZenMode;
            copy.mPrevConfig = this.mPrevConfig.copy();
            copy.mNewConfig = this.mNewConfig.copy();
            copy.mPrevPolicy = this.mPrevPolicy.copy();
            copy.mNewPolicy = this.mNewPolicy.copy();
            copy.mCallingUid = this.mCallingUid;
            copy.mOrigin = this.mOrigin;
            return copy;
        }
    }

    ZenModeEventLogger(PackageManager pm) {
        this.mChangeState = new ZenStateChanges();
        this.mPm = pm;
    }

    public final void maybeLogZenChange(ZenModeInfo prevInfo, ZenModeInfo newInfo, int callingUid, int origin) {
        ZenStateChanges.m6303$$Nest$minit(this.mChangeState, prevInfo, newInfo, callingUid, origin);
        if (ZenStateChanges.m6304$$Nest$mshouldLogChanges(this.mChangeState) == false) goto L5;
        maybeReassignCallingUid();
        logChanges();
    L5:
        this.mChangeState = new ZenStateChanges();
    }

    private void maybeReassignCallingUid() {
        int userId = -1;
        String packageName = null;
        if (this.mChangeState.getChangedRuleType() != 1) goto L12;
        if (this.mChangeState.isFromSystemOrSystemUi() == true) goto L7;
        return;
    L7:
        if (ZenStateChanges.m6301$$Nest$mgetNewManualRuleEnabler(this.mChangeState) == null) goto L38;
        packageName = ZenStateChanges.m6301$$Nest$mgetNewManualRuleEnabler(this.mChangeState);
        userId = this.mChangeState.mNewConfig.user;
        goto L12
    L38:
        return;
    L12:
        if (this.mChangeState.getChangedRuleType() != 2) goto L27;
        if (this.mChangeState.isFromSystemOrSystemUi() == false) goto L16;
        return;
    L16:
        ArrayMap<String, ZenModeDiff.RuleDiff> changedRules = ZenStateChanges.m6300$$Nest$mgetChangedAutomaticRules(this.mChangeState);
        if (changedRules.size() == 1) goto L19;
        return;
    L19:
        Pair<String, Integer> ruleInfo = ZenStateChanges.m6302$$Nest$mgetRulePackageAndUser(this.mChangeState, changedRules.keyAt(0), changedRules.valueAt(0));
        if (ruleInfo != null) goto L22;
        return;
    L22:
        if (((String) ruleInfo.first).equals(PackageManagerService.PLATFORM_PACKAGE_NAME) == true) goto L39;
        packageName = (String) ruleInfo.first;
        userId = ((Integer) ruleInfo.second).intValue();
        goto L27
    L39:
        return;
    L27:
        if (userId == (-1)) goto L35;
        if (packageName == null) goto L41;
        int uid = this.mPm.getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L32
        this.mChangeState.mCallingUid = uid;     // Catch: PackageManager.NameNotFoundException -> L32
        return;
    L33:
        Slog.e(TAG, "unable to find package name " + packageName + " " + userId);
        return;
    L41:
        return;
    }

    void logChanges() {
        FrameworkStatsLog.write(FrameworkStatsLog.DND_STATE_CHANGED, this.mChangeState.getEventId().getId(), this.mChangeState.mNewZenMode, this.mChangeState.mPrevZenMode, this.mChangeState.getChangedRuleType(), this.mChangeState.getNumRulesActive(), this.mChangeState.getIsUserAction(), this.mChangeState.getPackageUid(), this.mChangeState.getDNDPolicyProto(), this.mChangeState.getAreChannelsBypassing(), this.mChangeState.getActiveRuleTypes(), this.mChangeState.getChangeOrigin());
    }
}
