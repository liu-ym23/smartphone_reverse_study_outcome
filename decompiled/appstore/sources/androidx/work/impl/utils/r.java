package androidx.work.impl.utils;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class r implements Executor {
    public r() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        r10.run();
    }
}
