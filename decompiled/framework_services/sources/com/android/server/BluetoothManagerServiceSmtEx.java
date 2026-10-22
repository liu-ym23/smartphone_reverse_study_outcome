package com.android.server;

import android.content.Context;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothManagerServiceSmtEx {
    private static final int MESSAGE_APP_UNFREEZE_CALLBACK = 600;
    private static final String TAG = "BluetoothManagerServiceSmtEx";
    private final ApplicationFreezerInternalSmt.IFrozenCallback mFreezeCallback;

    public BluetoothManagerServiceSmtEx() {
        this.mFreezeCallback = new AnonymousClass1(this);
    }

    void registerBleCallback() {
    }

    void unregisterBleCallback() {
    }

    public void handleMessage(Message msg) {
        int r0 = msg.what;
    }

    void sendStateOnAppUnfreezeCallback(int pid, int uid) {
    }

    public void pendingBluetoothState(int pid, int uid) {
        ApplicationFreezerHelperSmt.registerFrozenCallbackByPidOnce(pid, uid, this.mFreezeCallback);
    }

    boolean hasSmtOp(Context context, int callingUid, String packageName) {
        return true;
    }
}
