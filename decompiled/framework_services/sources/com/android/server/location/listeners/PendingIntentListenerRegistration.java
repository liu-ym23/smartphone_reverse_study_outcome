package com.android.server.location.listeners;

import android.app.PendingIntent;
import android.util.Log;
import com.android.internal.listeners.ListenerExecutor;
import com.android.internal.util.ConcurrentUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PendingIntentListenerRegistration<TKey, TListener> extends RemovableListenerRegistration<TKey, TListener> implements PendingIntent.CancelListener {
    protected abstract PendingIntent getPendingIntentFromKey(TKey r1);

    protected PendingIntentListenerRegistration(TListener listener) {
        super(ConcurrentUtils.DIRECT_EXECUTOR, listener);
    }

    @Override // com.android.server.location.listeners.RemovableListenerRegistration
    protected void onRegister() {
        super.onRegister();
        if (getPendingIntentFromKey(getKey()).addCancelListener(ConcurrentUtils.DIRECT_EXECUTOR, this) == true) goto L6;
        remove();
        return;
    }

    @Override // com.android.server.location.listeners.RemovableListenerRegistration, com.android.server.location.listeners.ListenerRegistration
    protected void onUnregister() {
        getPendingIntentFromKey(getKey()).removeCancelListener(this);
        super.onUnregister();
    }

    @Override // com.android.server.location.listeners.ListenerRegistration
    protected void onOperationFailure(ListenerExecutor.ListenerOperation<TListener> operation, Exception e) {
        if ((e instanceof PendingIntent.CanceledException) == false) goto L5;
        Log.w(getTag(), "registration " + this + " removed", e);
        remove();
        return;
    L5:
        super.onOperationFailure(operation, e);
    }

    public void onCanceled(PendingIntent intent) {
        if (Log.isLoggable(getTag(), 3) == false) goto L5;
        Log.d(getTag(), "pending intent registration " + this + " canceled");
    L5:
        remove();
    }
}
