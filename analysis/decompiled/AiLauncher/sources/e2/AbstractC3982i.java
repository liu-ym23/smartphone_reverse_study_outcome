package e2;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: e2.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3982i {
    public static Executor a() {
        return new ExecutorC3984k(Executors.newSingleThreadExecutor());
    }
}
