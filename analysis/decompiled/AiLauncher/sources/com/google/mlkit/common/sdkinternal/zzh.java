package com.google.mlkit.common.sdkinternal;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
enum zzh implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        a.a().f21805a.post(runnable);
    }
}
