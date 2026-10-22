package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public abstract class x0 {
    public static final CoroutineDispatcher a(Executor r10) {
        return new w0(r10);
    }

    public static final ExecutorCoroutineDispatcher b(ExecutorService r10) {
        return new w0(r10);
    }
}
