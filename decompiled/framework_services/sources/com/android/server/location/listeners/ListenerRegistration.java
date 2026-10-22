package com.android.server.location.listeners;

import com.android.internal.listeners.ListenerExecutor;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class ListenerRegistration<TListener> implements ListenerExecutor {
    private boolean mActive;
    private final Executor mExecutor;
    private volatile TListener mListener;

    public static /* synthetic */ Object $r8$lambda$Az8TrU1jpn4hMJorXEqKeseINgI(ListenerRegistration r0) {
        return r0.lambda$executeOperation$0();
    }

    protected ListenerRegistration(Executor executor, TListener listener) {
        executor.getClass();
        this.mExecutor = executor;
        this.mActive = false;
        listener.getClass();
        this.mListener = listener;
    }

    protected String getTag() {
        return "ListenerRegistration";
    }

    protected final Executor getExecutor() {
        return this.mExecutor;
    }

    protected void onRegister(Object key) {
    }

    protected void onUnregister() {
    }

    protected void onActive() {
    }

    protected void onInactive() {
    }

    public final boolean isActive() {
        return this.mActive;
    }

    final boolean setActive(boolean active) {
        if (active == this.mActive) goto L6;
        this.mActive = active;
        return true;
    L6:
        return false;
    }

    public final boolean isRegistered() {
        if (this.mListener == null) goto L5;
        return true;
    L5:
        return false;
    }

    final void unregisterInternal() {
        this.mListener = null;
        onListenerUnregister();
    }

    protected void onListenerUnregister() {
    }

    protected void onOperationFailure(ListenerExecutor.ListenerOperation<TListener> operation, Exception exception) {
        throw new AssertionError(exception);
    }

    private /* synthetic */ Object lambda$executeOperation$0() {
        return this.mListener;
    }

    protected final void executeOperation(ListenerExecutor.ListenerOperation<TListener> operation) {
        executeSafely(this.mExecutor, new ListenerRegistration$$ExternalSyntheticLambda0(this), operation, new ListenerRegistration$$ExternalSyntheticLambda1(this));
    }

    public String toString() {
        return "[]";
    }

    public final boolean equals(Object obj) {
        if (this != obj) goto L4;
        return true;
    L4:
        return false;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
