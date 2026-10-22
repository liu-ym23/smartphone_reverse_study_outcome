package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class JobListenableFuture implements ListenableFuture {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Job f5363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.a f5364b;

    public JobListenableFuture(Job r10, androidx.work.impl.utils.futures.a r11) {
        q.g(r10, "job");
        q.g(r11, "underlying");
        this.f5363a = r10;
        this.f5364b = r11;
        r10.invokeOnCompletion(new AnonymousClass1(this));
    }

    public static final /* synthetic */ androidx.work.impl.utils.futures.a b(JobListenableFuture r10) {
        return r10.f5364b;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r10, Executor r11) {
        this.f5364b.addListener(r10, r11);
    }

    public final void c(Object r10) {
        this.f5364b.p(r10);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r10) {
        return this.f5364b.cancel(r10);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.f5364b.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f5364b.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f5364b.isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get(long r10, TimeUnit r11) {
        return this.f5364b.get(r10, r11);
    }

    public /* synthetic */ JobListenableFuture(Job r10, androidx.work.impl.utils.futures.a r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = androidx.work.impl.utils.futures.a.t();
        q.f(r11, "create()");
    L5:
        this(r10, r11);
    }
}
