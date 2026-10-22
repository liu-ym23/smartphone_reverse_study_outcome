package com.android.server.wm;

import android.app.IAssistDataReceiver;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.android.server.am.AssistDataRequester;

/* JADX INFO: loaded from: classes3.dex */
class AssistDataReceiverProxy implements AssistDataRequester.AssistDataRequesterCallbacks, IBinder.DeathRecipient {
    private static final String TAG = "ActivityTaskManager";
    private String mCallerPackage;
    private IAssistDataReceiver mReceiver;

    public AssistDataReceiverProxy(IAssistDataReceiver receiver, String callerPackage) {
        this.mReceiver = receiver;
        this.mCallerPackage = callerPackage;
        linkToDeath();
    }

    @Override // com.android.server.am.AssistDataRequester.AssistDataRequesterCallbacks
    public boolean canHandleReceivedAssistDataLocked() {
        return true;
    }

    @Override // com.android.server.am.AssistDataRequester.AssistDataRequesterCallbacks
    public void onAssistDataReceivedLocked(Bundle data, int activityIndex, int activityCount) {
        if (this.mReceiver == null) goto L11;
        this.mReceiver.onHandleAssistData(data);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Log.w(TAG, "Failed to proxy assist data to receiver in package=" + this.mCallerPackage, e);
        return;
    }

    @Override // com.android.server.am.AssistDataRequester.AssistDataRequesterCallbacks
    public void onAssistScreenshotReceivedLocked(Bitmap screenshot) {
        if (this.mReceiver == null) goto L11;
        this.mReceiver.onHandleAssistScreenshot(screenshot);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Log.w(TAG, "Failed to proxy assist screenshot to receiver in package=" + this.mCallerPackage, e);
        return;
    }

    @Override // com.android.server.am.AssistDataRequester.AssistDataRequesterCallbacks
    public void onAssistRequestCompleted() {
        unlinkToDeath();
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        unlinkToDeath();
    }

    private void linkToDeath() {
        this.mReceiver.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Log.w(TAG, "Could not link to client death", e);
    }

    private void unlinkToDeath() {
        if (this.mReceiver == null) goto L5;
        this.mReceiver.asBinder().unlinkToDeath(this, 0);
    L5:
        this.mReceiver = null;
    }
}
