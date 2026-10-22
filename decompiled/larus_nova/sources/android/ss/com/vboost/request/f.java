package android.ss.com.vboost.request;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Callable<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f4760a;

    public f(d r100) {
        this.f4760a = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() {
        android.ss.com.vboost.i.c.e().c(this.f4760a);
        return null;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Integer call() {
        return call();
    }
}
