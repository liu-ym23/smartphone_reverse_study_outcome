package androidx.work;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h1;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\rJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\u0004\b\u0010\u0010\u000bJ\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010&\u001a\u00020 8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010\u0013\u001a\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Landroidx/work/CoroutineWorker;", "Landroidx/work/h;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/h$a;", "l", "()Lcom/google/common/util/concurrent/ListenableFuture;", "p", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/d;", "r", "c", "", "j", "()V", "Lkotlinx/coroutines/CompletableJob;", "e", "Lkotlinx/coroutines/CompletableJob;", "getJob$work_runtime_ktx_release", "()Lkotlinx/coroutines/CompletableJob;", "job", "Landroidx/work/impl/utils/futures/a;", "f", "Landroidx/work/impl/utils/futures/a;", "t", "()Landroidx/work/impl/utils/futures/a;", "future", "Lkotlinx/coroutines/CoroutineDispatcher;", "g", "Lkotlinx/coroutines/CoroutineDispatcher;", "q", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineContext$annotations", "coroutineContext", "work-runtime-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class CoroutineWorker extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompletableJob f5360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.a f5361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineDispatcher f5362g;

    public CoroutineWorker(@NotNull Context r10, @NotNull WorkerParameters r11) {
        q.g(r10, "appContext");
        q.g(r11, "params");
        super(r10, r11);
        this.f5360e = h1.b(null, 1, null);
        androidx.work.impl.utils.futures.a r12 = androidx.work.impl.utils.futures.a.t();
        q.f(r12, "create()");
        this.f5361f = r12;
        r12.addListener(new b(this), f().getSerialTaskExecutor());
        this.f5362g = l0.a();
    }

    public static /* synthetic */ void n(CoroutineWorker r10) {
        o(r10);
    }

    public static final void o(CoroutineWorker r10) {
        q.g(r10, "this$0");
        if (r10.f5361f.isCancelled() == false) goto L6;
        Job.a.b(r10.f5360e, null, 1, null);
        return;
    }

    public static /* synthetic */ Object s(CoroutineWorker r10, Continuation r11) {
        throw new IllegalStateException("Not implemented");
    }

    @Override // androidx.work.h
    public final ListenableFuture c() {
        CompletableJob r10 = h1.b(null, 1, null);
        CoroutineScope r11 = d0.a(q().plus(r10));
        JobListenableFuture r12 = new JobListenableFuture(r10, null, 2, null);
        kotlinx.coroutines.h.d(r11, null, null, new CoroutineWorker$getForegroundInfoAsync$1(r12, this, null), 3, null);
        return r12;
    }

    @Override // androidx.work.h
    public final void j() {
        super.j();
        this.f5361f.cancel(false);
    }

    @Override // androidx.work.h
    public final ListenableFuture l() {
        kotlinx.coroutines.h.d(d0.a(q().plus(this.f5360e)), null, null, new CoroutineWorker$startWork$1(this, null), 3, null);
        return this.f5361f;
    }

    public abstract Object p(Continuation r10);

    public CoroutineDispatcher q() {
        return this.f5362g;
    }

    public Object r(Continuation r10) {
        return s(this, r10);
    }

    public final androidx.work.impl.utils.futures.a t() {
        return this.f5361f;
    }
}
