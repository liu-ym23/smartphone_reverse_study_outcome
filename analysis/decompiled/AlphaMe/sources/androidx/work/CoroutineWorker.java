package androidx.work;

import D0.a;
import D0.j;
import E0.c;
import Z2.A;
import Z2.C0128h;
import Z2.G;
import Z2.I;
import Z2.InterfaceC0142p;
import Z2.Q;
import Z2.r0;
import Z2.x0;
import android.content.Context;
import androidx.activity.d;
import androidx.appcompat.widget.RunnableC0209k;
import d3.f;
import java.util.concurrent.ExecutionException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s0.C0848f;
import s0.C0849g;
import s0.C0850h;
import s0.C0852j;
import s0.EnumC0851i;
import s0.n;
import s0.s;
import t0.J;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\r\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u00020\u001e8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b#\u0010\u0013\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Landroidx/work/CoroutineWorker;", "Ls0/s;", "LD1/a;", "Ls0/r;", "startWork", "()LD1/a;", "Ls0/j;", "getForegroundInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ls0/h;", "data", "", "setProgress", "(Ls0/h;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foregroundInfo", "setForeground", "(Ls0/j;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getForegroundInfoAsync", "onStopped", "()V", "LZ2/p;", "job", "LZ2/p;", "getJob$work_runtime_release", "()LZ2/p;", "LD0/j;", "future", "LD0/j;", "getFuture$work_runtime_release", "()LD0/j;", "LZ2/A;", "coroutineContext", "LZ2/A;", "getCoroutineContext", "()LZ2/A;", "getCoroutineContext$annotations", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCoroutineWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineWorker.kt\nandroidx/work/CoroutineWorker\n+ 2 ListenableFuture.kt\nandroidx/work/ListenableFutureKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,144:1\n40#2,8:145\n48#2:162\n60#2,7:163\n40#2,8:172\n48#2:189\n60#2,7:190\n314#3,9:153\n323#3,2:170\n314#3,9:180\n323#3,2:197\n*S KotlinDebug\n*F\n+ 1 CoroutineWorker.kt\nandroidx/work/CoroutineWorker\n*L\n110#1:145,8\n110#1:162\n110#1:163,7\n125#1:172,8\n125#1:189\n125#1:190,7\n110#1:153,9\n110#1:170,2\n125#1:180,9\n125#1:197,2\n*E\n"})
/* loaded from: classes.dex */
public abstract class CoroutineWorker extends s {

    @NotNull
    private final A coroutineContext;

    @NotNull
    private final j future;

    @NotNull
    private final InterfaceC0142p job;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(@NotNull Context appContext, @NotNull WorkerParameters params) {
        super(appContext, params);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(params, "params");
        this.job = I.a();
        j jVar = new j();
        Intrinsics.checkNotNullExpressionValue(jVar, "create()");
        this.future = jVar;
        jVar.a(new d(8, this), ((c) getTaskExecutor()).f400a);
        this.coroutineContext = Q.f2189a;
    }

    public static void a(CoroutineWorker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.future.f390a instanceof a) {
            ((x0) this$0.job).b(null);
        }
    }

    @Deprecated(message = "use withContext(...) inside doWork() instead.")
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    public static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, Continuation<? super C0852j> continuation) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object doWork(Continuation continuation);

    @NotNull
    public A getCoroutineContext() {
        return this.coroutineContext;
    }

    @Nullable
    public Object getForegroundInfo(@NotNull Continuation<? super C0852j> continuation) {
        return getForegroundInfo$suspendImpl(this, continuation);
    }

    @NotNull
    public final D1.a getForegroundInfoAsync() {
        r0 r0VarA = I.a();
        f fVarA = G.a(getCoroutineContext().plus(r0VarA));
        n nVar = new n(r0VarA);
        J.y(fVarA, null, new C0848f(nVar, this, null), 3);
        return nVar;
    }

    @NotNull
    /* renamed from: getFuture$work_runtime_release, reason: from getter */
    public final j getFuture() {
        return this.future;
    }

    @NotNull
    /* renamed from: getJob$work_runtime_release, reason: from getter */
    public final InterfaceC0142p getJob() {
        return this.job;
    }

    @Override // s0.s
    public final void onStopped() {
        this.future.cancel(false);
    }

    @Nullable
    public final Object setForeground(@NotNull C0852j c0852j, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        D1.a foregroundAsync = setForegroundAsync(c0852j);
        Intrinsics.checkNotNullExpressionValue(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        if (foregroundAsync.isDone()) {
            try {
                foregroundAsync.get();
            } catch (ExecutionException e4) {
                Throwable cause = e4.getCause();
                if (cause == null) {
                    throw e4;
                }
                throw cause;
            }
        } else {
            C0128h c0128h = new C0128h(1, IntrinsicsKt.intercepted(continuation));
            c0128h.u();
            foregroundAsync.a(new RunnableC0209k(c0128h, foregroundAsync, 4), EnumC0851i.f14202a);
            c0128h.o(new S.s(3, foregroundAsync));
            Object objT = c0128h.t();
            if (objT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (objT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return objT;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object setProgress(@NotNull C0850h c0850h, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        D1.a progressAsync = setProgressAsync(c0850h);
        Intrinsics.checkNotNullExpressionValue(progressAsync, "setProgressAsync(data)");
        if (progressAsync.isDone()) {
            try {
                progressAsync.get();
            } catch (ExecutionException e4) {
                Throwable cause = e4.getCause();
                if (cause == null) {
                    throw e4;
                }
                throw cause;
            }
        } else {
            C0128h c0128h = new C0128h(1, IntrinsicsKt.intercepted(continuation));
            c0128h.u();
            progressAsync.a(new RunnableC0209k(c0128h, progressAsync, 4), EnumC0851i.f14202a);
            c0128h.o(new S.s(3, progressAsync));
            Object objT = c0128h.t();
            if (objT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (objT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return objT;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // s0.s
    @NotNull
    public final D1.a startWork() {
        J.y(G.a(getCoroutineContext().plus(this.job)), null, new C0849g(this, null), 3);
        return this.future;
    }
}
