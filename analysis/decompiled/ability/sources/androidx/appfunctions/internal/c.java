package androidx.appfunctions.internal;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1699a;

    public /* synthetic */ c(int i) {
        this.f1699a = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f1699a) {
            case 0:
                runnable.run();
                break;
            case 1:
                ArchTaskExecutor.lambda$static$0(runnable);
                break;
            default:
                ArchTaskExecutor.lambda$static$1(runnable);
                break;
        }
    }
}
