package com.android.server.location.listeners;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RemovableListenerRegistration<TKey, TListener> extends ListenerRegistration<TListener> {
    private volatile TKey mKey;
    private final AtomicBoolean mRemoved;

    /* JADX INFO: renamed from: $r8$lambda$pm2-n25x_84SmCBXh4Fz-aabc0o, reason: not valid java name */
    public static /* synthetic */ void m5382$r8$lambda$pm2n25x_84SmCBXh4Fzaabc0o(RemovableListenerRegistration r0, Object r1, Object r2) {
        r0.lambda$remove$0(r1, r2);
    }

    protected abstract ListenerMultiplexer<TKey, ? super TListener, ?, ?> getOwner();

    protected RemovableListenerRegistration(Executor executor, TListener listener) {
        super(executor, listener);
        this.mRemoved = new AtomicBoolean(false);
    }

    protected final TKey getKey() {
        TKey r0 = this.mKey;
        r0.getClass();
        return r0;
    }

    public final void remove() {
        remove(true);
    }

    public final void remove(boolean immediately) {
        final TKey key = this.mKey;
        if (key != null) goto L5;
        return;
    L5:
        if (this.mRemoved.getAndSet(true) == true) goto L12;
        onRemove(immediately);
        if (immediately == false) goto L9;
        getOwner().removeRegistration(key, this);
        return;
    L9:
        executeOperation(new RemovableListenerRegistration$$ExternalSyntheticLambda0(this, key));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$remove$0(Object r2, Object listener) throws Exception {
        getOwner().removeRegistration(r2, this);
    }

    protected void onRemove(boolean immediately) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.server.location.listeners.ListenerRegistration
    protected final void onRegister(Object r1) {
        super.onRegister(r1);
        r1.getClass();
        this.mKey = r1;
        onRegister();
    }

    protected void onRegister() {
    }

    @Override // com.android.server.location.listeners.ListenerRegistration
    protected void onUnregister() {
        this.mKey = null;
        super.onUnregister();
    }
}
