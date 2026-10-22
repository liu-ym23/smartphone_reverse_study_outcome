package com.android.server.media.projection;

import android.app.AppOpsManager;
import android.app.KeyguardManager;
import android.app.role.RoleManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.util.Slog;
import com.android.server.SystemConfig;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class MediaProjectionStopController {
    static final int STOP_REASON_CALL_END = 2;
    static final int STOP_REASON_KEYGUARD = 1;
    static final int STOP_REASON_UNKNOWN = 0;
    private static final String TAG = "MediaProjectionStopController";
    private final AppOpsManager mAppOpsManager;
    private final ContentResolver mContentResolver;
    private boolean mIsInCall;
    private final KeyguardManager mKeyguardManager;
    private long mLastCallStartTimeMillis;
    private final PackageManager mPackageManager;
    private final RoleHolderProvider mRoleHolderProvider;
    private final Consumer<Integer> mStopReasonConsumer;
    private final TelecomManager mTelecomManager;
    private final TelephonyCallback mTelephonyCallback;
    private final TelephonyManager mTelephonyManager;

    private final class ProjectionTelephonyCallback extends TelephonyCallback implements TelephonyCallback.CallStateListener {
        final /* synthetic */ MediaProjectionStopController this$0;

        /* synthetic */ ProjectionTelephonyCallback(MediaProjectionStopController r1, MediaProjectionStopControllerIA r2) {
            this(r1);
        }

        private ProjectionTelephonyCallback(MediaProjectionStopController r1) {
            this.this$0 = r1;
        }

        @Override // android.telephony.TelephonyCallback.CallStateListener
        public void onCallStateChanged(int state) {
            this.this$0.callStateChanged();
        }
    }

    interface RoleHolderProvider {
        List<String> getRoleHoldersAsUser(String r1, UserHandle r2);
    }

    public static /* synthetic */ List $r8$lambda$mvM8pK9Lkoi3AQwy6r7PezXYveY(Context r0, String r1, UserHandle r2) {
        return lambda$new$0(r0, r1, r2);
    }

    public MediaProjectionStopController(final Context context, Consumer<Integer> stopReasonConsumer) {
        this(context, stopReasonConsumer, new MediaProjectionStopController$$ExternalSyntheticLambda1(context));
    }

    private static /* synthetic */ List lambda$new$0(Context context, String roleName, UserHandle user) {
        return ((RoleManager) context.getSystemService(RoleManager.class)).getRoleHoldersAsUser(roleName, user);
    }

    MediaProjectionStopController(Context context, Consumer<Integer> stopReasonConsumer, RoleHolderProvider roleHolderProvider) {
        this.mTelephonyCallback = new ProjectionTelephonyCallback(this, null);
        this.mStopReasonConsumer = stopReasonConsumer;
        this.mKeyguardManager = (KeyguardManager) context.getSystemService(KeyguardManager.class);
        this.mTelecomManager = (TelecomManager) context.getSystemService(TelecomManager.class);
        this.mTelephonyManager = (TelephonyManager) context.getSystemService(TelephonyManager.class);
        this.mAppOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        this.mPackageManager = context.getPackageManager();
        this.mContentResolver = context.getContentResolver();
        this.mRoleHolderProvider = roleHolderProvider;
    }

    public void startTrackingStopReasons(Context context) {
        long token = Binder.clearCallingIdentity();
        this.mKeyguardManager.addKeyguardLockedStateListener(context.getMainExecutor(), new MediaProjectionStopController$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L6
        callStateChanged();     // Catch: Throwable -> L6
        this.mTelephonyManager.registerTelephonyCallback(context.getMainExecutor(), this.mTelephonyCallback);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean isStopReasonCallEnd(int stopReason) {
        if (stopReason != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isExemptFromStopping(MediaProjectionManagerService.MediaProjection projectionGrant, int stopReason) {
        return isExempt(projectionGrant, stopReason, false);
    }

    private boolean isExempt(MediaProjectionManagerService.MediaProjection projectionGrant, int stopReason, boolean forStart) {
        if (projectionGrant != null) goto L5;
    L43:
        return true;
    L5:
        if (projectionGrant.packageName == null) goto L43;
        if (Settings.Global.getInt(this.mContentResolver, "disable_screen_share_protections_for_apps_and_notifications", 0) == 0) goto L10;
        boolean disableScreenShareProtections = true;
    L12:
        if (disableScreenShareProtections == false) goto L16;
        Slog.v(TAG, "Continuing MediaProjection as screenshare protections are disabled.");
        return true;
    L16:
        if (this.mPackageManager.checkPermission("android.permission.RECORD_SENSITIVE_CONTENT", projectionGrant.packageName) != 0) goto L20;
        Slog.v(TAG, "Continuing MediaProjection for package with RECORD_SENSITIVE_CONTENT permission");
        return true;
    L20:
        if (this.mAppOpsManager.noteOpNoThrow(46, projectionGrant.uid, projectionGrant.packageName, null, "recording lockscreen") != 0) goto L24;
        Slog.v(TAG, "Continuing MediaProjection for package with OP_PROJECT_MEDIA AppOp ");
        return true;
    L24:
        if (this.mRoleHolderProvider.getRoleHoldersAsUser("android.app.role.COMPANION_DEVICE_APP_STREAMING", projectionGrant.userHandle).contains(projectionGrant.packageName) == false) goto L28;
        Slog.v(TAG, "Continuing MediaProjection for package holding app streaming role.");
        return true;
    L28:
        if (SystemConfig.getInstance().getBugreportWhitelistedPackages().contains(projectionGrant.packageName) == false) goto L31;
        Slog.v(TAG, "Continuing MediaProjection for package allowlisted for bugreporting.");
        return true;
    L31:
        if (forStart == true) goto L37;
        if (projectionGrant.getVirtualDisplayId() != (-1)) goto L37;
        Slog.v(TAG, "Continuing MediaProjection as current projection has no VirtualDisplay.");
        return true;
    L37:
        if (stopReason == 2) goto L39;
    L42:
        return false;
    L39:
        if (projectionGrant.getCreateTimeMillis() >= this.mLastCallStartTimeMillis) goto L42;
        Slog.v(TAG, "Continuing MediaProjection as (phone) call started after MediaProjection was created.");
        return true;
    L10:
        disableScreenShareProtections = false;
        goto L12
    }

    public boolean isStartForbidden(MediaProjectionManagerService.MediaProjection projectionGrant) {
        if (this.mKeyguardManager.isKeyguardLocked() == true) goto L6;
        return false;
    L6:
        if (isExempt(projectionGrant, 0, true) == false) goto L8;
        return false;
    L8:
        return true;
    }

    void onKeyguardLockedStateChanged(boolean isKeyguardLocked) {
        if (isKeyguardLocked == true) goto L4;
        return;
    L4:
        this.mStopReasonConsumer.accept(1);
    }

    void callStateChanged() {
        boolean isInCall = this.mTelecomManager.isInCall();
        if (isInCall == false) goto L6;
        this.mLastCallStartTimeMillis = SystemClock.uptimeMillis();
    L6:
        if (isInCall != this.mIsInCall) goto L9;
        return;
    L9:
        if (this.mIsInCall == false) goto L12;
        if (isInCall == true) goto L12;
        this.mStopReasonConsumer.accept(2);
    L12:
        this.mIsInCall = isInCall;
    }

    public static String stopReasonToString(int stopReason) {
        switch(stopReason) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return "";
    L5:
        return "STOP_REASON_CALL_END";
    L7:
        return "STOP_REASON_KEYGUARD";
    }
}
