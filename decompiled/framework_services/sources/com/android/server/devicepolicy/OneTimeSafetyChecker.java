package com.android.server.devicepolicy;

import android.app.admin.DevicePolicyManager;
import android.app.admin.DevicePolicyManagerLiteInternal;
import android.app.admin.DevicePolicySafetyChecker;
import android.os.Handler;
import android.os.Looper;
import android.util.Slog;
import com.android.internal.os.IResultReceiver;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes2.dex */
final class OneTimeSafetyChecker implements DevicePolicySafetyChecker {
    private static final long SELF_DESTRUCT_TIMEOUT_MS = 10000;
    private static final String TAG = null;
    private boolean mDone;
    private final Handler mHandler;
    private final int mOperation;
    private final DevicePolicySafetyChecker mRealSafetyChecker;
    private final int mReason;
    private final DevicePolicyManagerService mService;

    /* JADX INFO: renamed from: $r8$lambda$MgjNXpsv9c-3jBgs7EwALBv0fXY, reason: not valid java name */
    public static /* synthetic */ void m3510$r8$lambda$MgjNXpsv9c3jBgs7EwALBv0fXY(OneTimeSafetyChecker r0) {
        r0.lambda$new$0();
    }

    static {
        TAG = OneTimeSafetyChecker.class.getSimpleName();
    }

    OneTimeSafetyChecker(DevicePolicyManagerService service, int operation, int reason) {
        this.mHandler = new Handler(Looper.getMainLooper());
        service.getClass();
        this.mService = service;
        this.mOperation = operation;
        this.mReason = reason;
        this.mRealSafetyChecker = service.getDevicePolicySafetyChecker();
        Slog.i(TAG, "OneTimeSafetyChecker constructor: operation=" + DevicePolicyManager.operationToString(operation) + ", reason=" + DevicePolicyManager.operationSafetyReasonToString(reason) + ", realChecker=" + this.mRealSafetyChecker + ", maxDuration=10000ms");
        this.mHandler.postDelayed(new OneTimeSafetyChecker$$ExternalSyntheticLambda0(this), 10000);
    }

    private /* synthetic */ void lambda$new$0() {
        selfDestruct();
    }

    public int getUnsafeOperationReason(int operation) {
        String name = DevicePolicyManager.operationToString(operation);
        Slog.i(TAG, "getUnsafeOperationReason(" + name + ")");
        int reason = -1;
        if (operation != this.mOperation) goto L5;
        reason = this.mReason;
    L6:
        String reasonName = DevicePolicyManager.operationSafetyReasonToString(reason);
        DevicePolicyManagerLiteInternal dpmi = (DevicePolicyManagerLiteInternal) LocalServices.getService(DevicePolicyManagerLiteInternal.class);
        Slog.i(TAG, "notifying " + reasonName + " is UNSAFE");
        dpmi.notifyUnsafeOperationStateChanged(this, reason, false);
        Slog.i(TAG, "notifying " + reasonName + " is SAFE");
        dpmi.notifyUnsafeOperationStateChanged(this, reason, true);
        Slog.i(TAG, "returning " + reasonName);
        disableSelf();
        return reason;
    L5:
        Slog.wtf(TAG, "invalid call to isDevicePolicyOperationSafe(): asked for " + name + ", should be " + DevicePolicyManager.operationToString(this.mOperation));
        goto L6
    }

    public boolean isSafeOperation(int reason) {
        if (this.mReason == reason) goto L5;
        boolean safe = true;
    L6:
        Slog.i(TAG, "isSafeOperation(" + DevicePolicyManager.operationSafetyReasonToString(reason) + "): " + safe);
        disableSelf();
        return safe;
    L5:
        safe = false;
        goto L6
    }

    public void onFactoryReset(IResultReceiver callback) {
        throw new UnsupportedOperationException();
    }

    private void disableSelf() {
        if (this.mDone == false) goto L6;
        Slog.w(TAG, "disableSelf(): already disabled");
        return;
    L6:
        Slog.i(TAG, "restoring DevicePolicySafetyChecker to " + this.mRealSafetyChecker);
        this.mService.setDevicePolicySafetyCheckerUnchecked(this.mRealSafetyChecker);
        this.mDone = true;
    }

    private void selfDestruct() {
        if (this.mDone == false) goto L5;
        return;
    L5:
        Slog.e(TAG, "Self destructing " + this + ", as it was not automatically disabled");
        disableSelf();
    }

    public String toString() {
        return "OneTimeSafetyChecker[id=" + System.identityHashCode(this) + ", reason=" + DevicePolicyManager.operationSafetyReasonToString(this.mReason) + ", operation=" + DevicePolicyManager.operationToString(this.mOperation) + ']';
    }
}
