package com.android.server.audio;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseArray;
import com.android.modules.expresslog.Counter;
import com.android.server.utils.EventLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class HardeningEnforcer {
    private static final int ALLOWED = 0;
    private static final boolean DEBUG = false;
    private static final int DENIED_IF_FULL = 2;
    private static final int DENIED_IF_PARTIAL = 1;
    private static final int LOG_NB_EVENTS = 20;
    public static final int METHOD_AUDIO_MANAGER_ADJUST_STREAM_VOLUME = 103;
    public static final int METHOD_AUDIO_MANAGER_ADJUST_SUGGESTED_STREAM_VOLUME = 102;
    public static final int METHOD_AUDIO_MANAGER_ADJUST_VOLUME = 101;
    public static final int METHOD_AUDIO_MANAGER_REQUEST_AUDIO_FOCUS = 300;
    public static final int METHOD_AUDIO_MANAGER_SET_RINGER_MODE = 200;
    public static final int METHOD_AUDIO_MANAGER_SET_STREAM_VOLUME = 100;
    static final SparseArray<String> METRIC_COUNTERS_FOCUS_DENIAL = null;
    static final SparseArray<String> METRIC_COUNTERS_FOCUS_GRANT = null;
    private static final String TAG = "AS.HardeningEnforcer";
    final ActivityManager mActivityManager;
    final AppOpsManager mAppOps;
    final Context mContext;
    final EventLogger mEventLogger;
    final boolean mIsAutomotive;
    final PackageManager mPackageManager;
    final AtomicBoolean mShouldEnableAllHardening;

    static {
        METRIC_COUNTERS_FOCUS_DENIAL = new SparseArray(4);
        METRIC_COUNTERS_FOCUS_GRANT = new SparseArray(4);
        METRIC_COUNTERS_FOCUS_GRANT.put(1, "media_audio.value_audio_focus_gain_granted");
        METRIC_COUNTERS_FOCUS_GRANT.put(2, "media_audio.value_audio_focus_gain_transient_granted");
        METRIC_COUNTERS_FOCUS_GRANT.put(3, "media_audio.value_audio_focus_gain_transient_duck_granted");
        METRIC_COUNTERS_FOCUS_GRANT.put(4, "media_audio.value_audio_focus_gain_transient_excl_granted");
        METRIC_COUNTERS_FOCUS_DENIAL.put(1, "media_audio.value_audio_focus_gain_appops_denial");
        METRIC_COUNTERS_FOCUS_DENIAL.put(2, "media_audio.value_audio_focus_gain_transient_appops_denial");
        METRIC_COUNTERS_FOCUS_DENIAL.put(3, "media_audio.value_audio_focus_gain_transient_duck_appops_denial");
        METRIC_COUNTERS_FOCUS_DENIAL.put(4, "media_audio.value_audio_focus_gain_transient_excl_appops_denial");
    }

    public HardeningEnforcer(Context ctxt, boolean isAutomotive, AtomicBoolean shouldEnableHardening, AppOpsManager appOps, PackageManager pm, EventLogger logger) {
        this.mContext = ctxt;
        this.mIsAutomotive = isAutomotive;
        this.mShouldEnableAllHardening = shouldEnableHardening;
        this.mAppOps = appOps;
        this.mActivityManager = (ActivityManager) ctxt.getSystemService(ActivityManager.class);
        this.mPackageManager = pm;
        this.mEventLogger = logger;
    }

    protected boolean blockVolumeMethod(int volumeMethod, String packageName, int uid) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_SETTINGS_PRIVILEGED") != 0) goto L6;
        return false;
    L6:
        if (this.mIsAutomotive == true) goto L8;
        boolean enforced = this.mShouldEnableAllHardening.get();
        if (noteOp(155, uid, packageName, null) == true) goto L16;
        Counter.logIncrementWithUid("media_audio.value_audio_volume_hardening_partial_restriction", uid);
        int allowed = 1;
    L19:
        if (allowed == 0) goto L29;
        StringBuilder r5 = new StringBuilder();
        r5.append("AudioHardening volume control for api ");
        r5.append(volumeMethod);
        if (enforced == true) goto L23;
        String r6 = " would be ";
    L24:
        r5.append(r6);
        r5.append("ignored for ");
        r5.append(getPackNameForUid(uid));
        r5.append(" (");
        r5.append(uid);
        r5.append("), level: ");
        if (allowed != 1) goto L27;
        String r7 = "partial";
    L28:
        r5.append(r7);
        String msg = r5.toString();
        this.mEventLogger.enqueueAndSlog(msg, 2, TAG);
        goto L29
    L27:
        r7 = "full";
        goto L28
    L23:
        r6 = " ";
    L29:
        if (enforced == false) goto L33;
        if (allowed != 0) goto L32;
        return false;
    L32:
        return true;
    L33:
        return false;
    L16:
        if (noteOp(154, uid, packageName, null) == true) goto L18;
        Counter.logIncrementWithUid("media_audio.value_audio_volume_hardening_strict_restriction", uid);
        allowed = 2;
        goto L19
    L18:
        Counter.logIncrementWithUid("media_audio.value_audio_volume_hardening_allowed", uid);
        allowed = 0;
        goto L19
    L8:
        if (uid >= 10000) goto L10;
        return false;
    L10:
        Slog.e(TAG, "Preventing volume method " + volumeMethod + " for " + packageName);
        return true;
    }

    protected boolean blockFocusMethod(int callingUid, int focusMethod, String clientId, int focusReqType, String packageName, String attributionTag, int targetSdk) {
        if (packageName.isEmpty() == false) goto L5;
        String packageName2 = getPackNameForUid(callingUid);
    L6:
        boolean blockedIfFull = !noteOp(154, callingUid, packageName2, attributionTag);
        boolean blocked = true;
        boolean unblockedBySdk = false;
        if (noteOp(32, callingUid, packageName2, attributionTag) == false) goto L10;
        blocked = false;
    L13:
        if (this.mShouldEnableAllHardening.get() == true) goto L17;
        if (unblockedBySdk == false) goto L17;
        boolean enforced = false;
    L18:
        boolean enforcedFull = this.mShouldEnableAllHardening.get();
        if (blocked == false) goto L22;
        if (enforced == false) goto L22;
        boolean r14 = true;
    L23:
        metricsLogFocusReq(r14, focusReqType, callingUid, unblockedBySdk);
        if (blocked == false) goto L31;
        boolean blockedIfFull2 = blockedIfFull;
        StringBuilder r6 = new StringBuilder();
        r6.append("AudioHardening focus request for req ");
        r6.append(focusReqType);
        if (enforced == true) goto L28;
        String r4 = " would be ";
    L29:
        r6.append(r4);
        r6.append("ignored for ");
        r6.append(packageName2);
        r6.append(" (");
        r6.append(callingUid);
        r6.append("), ");
        r6.append(clientId);
        r6.append(", level: partial");
        String msg = r6.toString();
        this.mEventLogger.enqueueAndSlog(msg, 2, TAG);
    L38:
        if (blocked == false) goto L40;
        if (enforced == false) goto L40;
    L42:
        return true;
    L40:
        if (blockedIfFull2 == false) goto L43;
        if (enforcedFull == true) goto L42;
    L43:
        return false;
    L28:
        r4 = " ";
        goto L29
    L31:
        blockedIfFull2 = blockedIfFull;
        if (blockedIfFull2 == false) goto L38;
        StringBuilder r7 = new StringBuilder();
        r7.append("AudioHardening focus request for req ");
        r7.append(focusReqType);
        if (enforcedFull == true) goto L36;
        String r5 = " would be ";
    L37:
        r7.append(r5);
        r7.append("ignored for ");
        r7.append(packageName2);
        r7.append(" (");
        r7.append(callingUid);
        r7.append("), ");
        r7.append(clientId);
        r7.append(", level: full");
        String msg2 = r7.toString();
        this.mEventLogger.enqueueAndSlog(msg2, 2, TAG);
        goto L38
    L36:
        r5 = " ";
    L22:
        r14 = false;
    L17:
        enforced = true;
        goto L18
    L10:
        if (targetSdk >= 35) goto L13;
        unblockedBySdk = true;
        goto L13
    L5:
        packageName2 = packageName;
        goto L6
    }

    void metricsLogFocusReq(boolean blocked, int focusReq, int callingUid, boolean unblockedBySdk) {
        if (blocked == false) goto L4;
        String metricId = METRIC_COUNTERS_FOCUS_DENIAL.get(focusReq);
    L6:
        if (TextUtils.isEmpty(metricId) == false) goto L19;
        Slog.e(TAG, "Bad string for focus metrics gain:" + focusReq + " blocked:" + blocked);
        return;
    L19:
        Counter.logIncrementWithUid(metricId, callingUid);     // Catch: Exception -> L14
        if (blocked == true) goto L21;
        if (unblockedBySdk == false) goto L22;
        Counter.logIncrementWithUid("media_audio.value_audio_focus_grant_hardening_waived_by_sdk", callingUid);     // Catch: Exception -> L14
        return;
    L22:
        return;
    L21:
        return;
    L14:
        e = move-exception;
        Slog.e(TAG, "Counter error metricId:" + metricId + " for focus req:" + focusReq + " from uid:" + callingUid, e);
        return;
    L4:
        metricId = METRIC_COUNTERS_FOCUS_GRANT.get(focusReq);
        goto L6
    }

    private String getPackNameForUid(int uid) {
        long token = Binder.clearCallingIdentity();
        String[] names = this.mPackageManager.getPackagesForUid(uid);     // Catch: Throwable -> L13
        if (names != null) goto L6;
    L15:
        String r3 = "[" + uid + "]";     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(token);
        return r3;
    L6:
        if (names.length == 0) goto L15;
        if (TextUtils.isEmpty(names[0]) == true) goto L15;
        String r4 = names[0];     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(token);
        return r4;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private boolean noteOp(int op, int uid, String packageName, String attributionTag) {
        if (this.mAppOps.noteOpNoThrow(op, uid, packageName, attributionTag, null) == 0) goto L6;
        return false;
    L6:
        return true;
    }
}
