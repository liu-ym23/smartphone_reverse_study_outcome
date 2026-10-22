package m9;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;

/* renamed from: m9.H, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ExecutorC1690H implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1729v f5314a;

    public ExecutorC1690H(AbstractC1729v abstractC1729v) {
        this.f5314a = abstractC1729v;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f4908a;
        AbstractC1729v abstractC1729v = this.f5314a;
        if (abstractC1729v.isDispatchNeeded(emptyCoroutineContext)) {
            abstractC1729v.dispatch(emptyCoroutineContext, runnable);
        } else {
            runnable.run();
        }
    }

    public final String toString() {
        return this.f5314a.toString();
    }
}
