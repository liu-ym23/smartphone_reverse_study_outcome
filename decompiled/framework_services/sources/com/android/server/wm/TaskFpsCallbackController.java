package com.android.server.wm;

import android.os.IBinder;
import android.os.RemoteException;
import android.window.ITaskFpsCallback;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
final class TaskFpsCallbackController {
    private final HashMap<IBinder, IBinder.DeathRecipient> mDeathRecipients;
    private final HashMap<IBinder, Long> mTaskFpsCallbacks;

    public static /* synthetic */ void $r8$lambda$SMMa28G8Yw6JKRU9LZ4_14O2AAE(TaskFpsCallbackController r0, ITaskFpsCallback r1) {
        r0.lambda$registerListener$0(r1);
    }

    private static native long nativeRegister(ITaskFpsCallback r0, int r1);

    private static native void nativeUnregister(long r0);

    TaskFpsCallbackController() {
        this.mTaskFpsCallbacks = new HashMap();
        this.mDeathRecipients = new HashMap();
    }

    void registerListener(int taskId, final ITaskFpsCallback callback) {
        if (callback != null) goto L4;
        return;
    L4:
        IBinder binder = callback.asBinder();
        if (this.mTaskFpsCallbacks.containsKey(binder) == false) goto L7;
        return;
    L7:
        long nativeListener = nativeRegister(callback, taskId);
        this.mTaskFpsCallbacks.put(binder, Long.valueOf(nativeListener));
        IBinder.DeathRecipient deathRecipient = new TaskFpsCallbackController$$ExternalSyntheticLambda0(this, callback);
        binder.linkToDeath(deathRecipient, 0);     // Catch: RemoteException -> L10
        this.mDeathRecipients.put(binder, deathRecipient);     // Catch: RemoteException -> L10
        return;
    }

    private /* synthetic */ void lambda$registerListener$0(ITaskFpsCallback callback) {
        unregisterListener(callback);
    }

    void unregisterListener(ITaskFpsCallback callback) {
        if (callback != null) goto L4;
        return;
    L4:
        IBinder binder = callback.asBinder();
        if (this.mTaskFpsCallbacks.containsKey(binder) == true) goto L7;
        return;
    L7:
        binder.unlinkToDeath(this.mDeathRecipients.get(binder), 0);
        this.mDeathRecipients.remove(binder);
        nativeUnregister(this.mTaskFpsCallbacks.get(binder).longValue());
        this.mTaskFpsCallbacks.remove(binder);
    }
}
