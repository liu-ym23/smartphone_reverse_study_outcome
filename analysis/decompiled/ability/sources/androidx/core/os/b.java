package androidx.core.os;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final /* synthetic */ class b implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
