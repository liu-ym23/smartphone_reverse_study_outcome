package com.android.server.location.listeners;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.android.internal.listeners.ListenerExecutor;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BinderListenerRegistration<TKey, TListener> extends RemovableListenerRegistration<TKey, TListener> implements IBinder.DeathRecipient {
    protected abstract IBinder getBinderFromKey(TKey r1);

    protected BinderListenerRegistration(Executor executor, TListener listener) {
        super(executor, listener);
    }

    @Override // com.android.server.location.listeners.RemovableListenerRegistration
    protected void onRegister() {
        super.onRegister();
        getBinderFromKey(getKey()).linkToDeath(this, 0);     // Catch: RemoteException -> L5
        return;
    L6:
        remove();
    }

    @Override // com.android.server.location.listeners.RemovableListenerRegistration, com.android.server.location.listeners.ListenerRegistration
    protected void onUnregister() {
        getBinderFromKey(getKey()).unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L4
    L6:
        super.onUnregister();
        return;
    L4:
        e = move-exception;
        Log.w(getTag(), "failed to unregister binder death listener", e);
        goto L6
    }

    @Override // com.android.server.location.listeners.ListenerRegistration
    public void onOperationFailure(ListenerExecutor.ListenerOperation<TListener> operation, Exception e) {
        if ((e instanceof RemoteException) == false) goto L5;
        Log.w(getTag(), "registration " + this + " removed", e);
        remove();
        return;
    L5:
        super.onOperationFailure(operation, e);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
    L5:
        e = move-exception;
        throw new AssertionError(e);
    L3:
        if (Log.isLoggable(getTag(), 3) == false) goto L7;
        Log.d(getTag(), "binder registration " + this + " died");     // Catch: RuntimeException -> L5
    L7:
        remove();     // Catch: RuntimeException -> L5
    }
}
