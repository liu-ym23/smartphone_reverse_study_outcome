package com.android.server.power.feature;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.android.server.display.feature.DisplayManagerFlags$$ExternalSyntheticLambda0;
import com.android.server.display.feature.DisplayManagerFlags$$ExternalSyntheticLambda1;
import java.io.PrintWriter;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class PowerManagerFlags {
    private static final boolean DEBUG = false;
    private static final String TAG = "PowerManagerFlags";
    private final FlagState mDisableFrozenProcessWakelocks;
    private final FlagState mEarlyScreenTimeoutDetectorFlagState;
    private final FlagState mEnableScreenTimeoutPolicyListenerApi;
    private final FlagState mFrameworkWakelockInfo;
    private final FlagState mImproveWakelockLatency;
    private final FlagState mMoveWscLoggingToNotifier;
    private final FlagState mPerDisplayWakeByTouch;
    private final FlagState mPolicyReasonInDisplayPowerRequest;
    private final FlagState mWakelockAttributionViaWorkchain;

    private static class FlagState {
        private boolean mEnabled;
        private boolean mEnabledSet;
        private final Supplier<Boolean> mFlagFunction;
        private final String mName;

        /* JADX INFO: renamed from: -$$Nest$misEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7638$$Nest$misEnabled(FlagState r0) {
            return r0.isEnabled();
        }

        /* synthetic */ FlagState(String r1, Supplier r2, PowerManagerFlagsIA r3) {
            this(r1, r2);
        }

        private FlagState(String name, Supplier<Boolean> flagFunction) {
            this.mName = name;
            this.mFlagFunction = flagFunction;
        }

        private boolean isEnabled() {
            if (this.mEnabledSet == true) goto L5;
            this.mEnabled = flagOrSystemProperty(this.mFlagFunction, this.mName);
            this.mEnabledSet = true;
            return this.mEnabled;
        L5:
            return this.mEnabled;
        }

        private boolean flagOrSystemProperty(Supplier<Boolean> flagFunction, String flagName) {
            boolean flagValue = flagFunction.get().booleanValue();
            if (Build.IS_ENG == true) goto L9;
            if (Build.IS_USERDEBUG == true) goto L9;
            return flagValue;
        L9:
            return SystemProperties.getBoolean("persist.sys." + flagName + "-override", flagValue);
        }

        public String toString() {
            int nameLength = this.mName.length();
            return TextUtils.substring(this.mName, 39, nameLength) + ": " + TextUtils.formatSimple("%" + (91 - nameLength) + "s%s", new Object[]{" ", Boolean.valueOf(isEnabled())}) + " (def:" + this.mFlagFunction.get() + ")";
        }
    }

    public PowerManagerFlags() {
        String r2 = "com.android.server.power.feature.flags.enable_early_screen_timeout_detector";
        PowerManagerFlagsIA r3 = null;
        this.mEarlyScreenTimeoutDetectorFlagState = new FlagState(r2, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r4 = "com.android.server.power.feature.flags.enable_screen_timeout_policy_listener_api";
        this.mEnableScreenTimeoutPolicyListenerApi = new FlagState(r4, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r5 = "com.android.server.power.feature.flags.improve_wakelock_latency";
        this.mImproveWakelockLatency = new FlagState(r5, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r6 = "com.android.server.power.feature.flags.per_display_wake_by_touch";
        this.mPerDisplayWakeByTouch = new FlagState(r6, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r7 = "com.android.server.power.feature.flags.framework_wakelock_info";
        this.mFrameworkWakelockInfo = new FlagState(r7, new DisplayManagerFlags$$ExternalSyntheticLambda1(), r3);
        String r8 = "com.android.server.power.feature.flags.policy_reason_in_display_power_request";
        this.mPolicyReasonInDisplayPowerRequest = new FlagState(r8, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r9 = "com.android.server.power.feature.flags.move_wsc_logging_to_notifier";
        this.mMoveWscLoggingToNotifier = new FlagState(r9, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r10 = "com.android.server.power.feature.flags.wakelock_attribution_via_workchain";
        this.mWakelockAttributionViaWorkchain = new FlagState(r10, new DisplayManagerFlags$$ExternalSyntheticLambda0(), r3);
        String r11 = "com.android.server.power.feature.flags.disable_frozen_process_wakelocks";
        this.mDisableFrozenProcessWakelocks = new FlagState(r11, new DisplayManagerFlags$$ExternalSyntheticLambda1(), r3);
    }

    public boolean isEarlyScreenTimeoutDetectorEnabled() {
        return FlagState.m7638$$Nest$misEnabled(this.mEarlyScreenTimeoutDetectorFlagState);
    }

    public boolean isScreenTimeoutPolicyListenerApiEnabled() {
        return FlagState.m7638$$Nest$misEnabled(this.mEnableScreenTimeoutPolicyListenerApi);
    }

    public boolean improveWakelockLatency() {
        return FlagState.m7638$$Nest$misEnabled(this.mImproveWakelockLatency);
    }

    public boolean isPerDisplayWakeByTouchEnabled() {
        return FlagState.m7638$$Nest$misEnabled(this.mPerDisplayWakeByTouch);
    }

    public boolean isFrameworkWakelockInfoEnabled() {
        return FlagState.m7638$$Nest$misEnabled(this.mFrameworkWakelockInfo);
    }

    public boolean isPolicyReasonInDisplayPowerRequestEnabled() {
        return FlagState.m7638$$Nest$misEnabled(this.mPolicyReasonInDisplayPowerRequest);
    }

    public boolean isMoveWscLoggingToNotifierEnabled() {
        return FlagState.m7638$$Nest$misEnabled(this.mMoveWscLoggingToNotifier);
    }

    public boolean isWakelockAttributionViaWorkchainEnabled() {
        return FlagState.m7638$$Nest$misEnabled(this.mWakelockAttributionViaWorkchain);
    }

    public boolean isDisableFrozenProcessWakelocksEnabled() {
        return FlagState.m7638$$Nest$misEnabled(this.mDisableFrozenProcessWakelocks);
    }

    public void dump(PrintWriter pw) {
        pw.println("PowerManagerFlags:");
        pw.println(" " + this.mEarlyScreenTimeoutDetectorFlagState);
        pw.println(" " + this.mImproveWakelockLatency);
        pw.println(" " + this.mPerDisplayWakeByTouch);
        pw.println(" " + this.mFrameworkWakelockInfo);
        pw.println(" " + this.mMoveWscLoggingToNotifier);
        pw.println(" " + this.mWakelockAttributionViaWorkchain);
        pw.println(" " + this.mDisableFrozenProcessWakelocks);
    }
}
