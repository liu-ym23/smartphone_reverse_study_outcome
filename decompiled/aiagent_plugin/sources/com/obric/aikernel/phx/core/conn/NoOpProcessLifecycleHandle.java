package com.obric.aikernel.phx.core.conn;

/* JADX INFO: compiled from: ChildProcessLifecycleBinding.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NoOpProcessLifecycleHandle implements ProcessLifecycleHandle {
    public static final NoOpProcessLifecycleHandle INSTANCE = null;

    static {
        INSTANCE = new NoOpProcessLifecycleHandle();
    }

    @Override // com.obric.aikernel.phx.core.conn.ProcessLifecycleHandle
    public void close() {
    }

    private NoOpProcessLifecycleHandle() {
    }
}
