package com.android.server.inputmethod;

import android.os.IBinder;
import android.util.SparseArray;
import android.view.inputmethod.InputBinding;
import com.android.internal.inputmethod.IRemoteInputConnection;

/* JADX INFO: loaded from: classes2.dex */
final class ClientState {
    final SparseArray<InputMethodManagerService.AccessibilitySessionState> mAccessibilitySessions;
    final InputBinding mBinding;
    final IInputMethodClientInvoker mClient;
    final IBinder.DeathRecipient mClientDeathRecipient;
    InputMethodManagerService.SessionState mCurSession;
    final IRemoteInputConnection mFallbackInputConnection;
    final int mPid;
    final int mSelfReportedDisplayId;
    boolean mSessionRequested;
    boolean mSessionRequestedForAccessibility;
    final int mUid;

    ClientState(IInputMethodClientInvoker client, IRemoteInputConnection fallbackInputConnection, int uid, int pid, int selfReportedDisplayId, IBinder.DeathRecipient clientDeathRecipient) {
        this.mAccessibilitySessions = new SparseArray();
        this.mClient = client;
        this.mFallbackInputConnection = fallbackInputConnection;
        this.mUid = uid;
        this.mPid = pid;
        this.mSelfReportedDisplayId = selfReportedDisplayId;
        this.mBinding = new InputBinding(null, fallbackInputConnection.asBinder(), this.mUid, this.mPid);
        this.mClientDeathRecipient = clientDeathRecipient;
    }

    public String toString() {
        return "ClientState{" + Integer.toHexString(System.identityHashCode(this)) + " mUid=" + this.mUid + " mPid=" + this.mPid + " mSelfReportedDisplayId=" + this.mSelfReportedDisplayId + "}";
    }
}
