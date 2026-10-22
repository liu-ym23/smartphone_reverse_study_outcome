package D2;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class E implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
