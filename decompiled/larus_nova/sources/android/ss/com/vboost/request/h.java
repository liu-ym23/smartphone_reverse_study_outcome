package android.ss.com.vboost.request;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes2.dex */
public class h implements Callable<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f4767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ScheduledFuture<Integer> f4768b;

    public h(d r100) {
        this.f4767a = r100;
    }

    public ScheduledFuture<Integer> a() {
        return this.f4768b;
    }

    public void a(ScheduledFuture<Integer> r100) {
        this.f4768b = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() {
        if (this.f4767a.b() != g.f4763c) goto L5;
    L7:
        RequestManager.getInstance().completeRequest(this.f4767a, true);
        return null;
    L5:
        if (this.f4767a.b() == g.f4761a) goto L7;
        this.f4767a.f4747j = true;
        android.ss.com.vboost.i.c.e().c(this.f4767a);
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Integer call() {
        return call();
    }
}
