package androidx.work;

import android.content.Context;
import androidx.concurrent.futures.ListenableFutureKt;
import androidx.work.c;
import h2.f;
import h2.i;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class CoroutineWorker extends c {
    private final CoroutineDispatcher coroutineContext;
    private final WorkerParameters params;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends CoroutineDispatcher {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2762a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final CoroutineDispatcher f2763b = Dispatchers.getDefault();

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public final void dispatch(d context, Runnable block) {
            g.f(context, "context");
            g.f(block, "block");
            f2763b.dispatch(context, block);
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public final boolean isDispatchNeeded(d context) {
            g.f(context, "context");
            return f2763b.isDispatchNeeded(context);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {121}, m = "invokeSuspend")
    /* renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super f>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f2764a;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return CoroutineWorker.this.new AnonymousClass1(bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super f> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f2764a;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                return obj;
            }
            kotlin.c.b(obj);
            this.f2764a = 1;
            Object foregroundInfo = CoroutineWorker.this.getForegroundInfo(this);
            return foregroundInfo == coroutineSingletons ? coroutineSingletons : foregroundInfo;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {67}, m = "invokeSuspend")
    /* renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01941 extends SuspendLambda implements p<CoroutineScope, qb.b<? super c.a>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f2766a;

        public C01941(qb.b<? super C01941> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return CoroutineWorker.this.new C01941(bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super c.a> bVar) {
            return ((C01941) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f2766a;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                return obj;
            }
            kotlin.c.b(obj);
            this.f2766a = 1;
            Object objDoWork = CoroutineWorker.this.doWork(this);
            return objDoWork == coroutineSingletons ? coroutineSingletons : objDoWork;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context appContext, WorkerParameters params) {
        super(appContext, params);
        g.f(appContext, "appContext");
        g.f(params, "params");
        this.params = params;
        this.coroutineContext = a.f2762a;
    }

    public static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, qb.b<? super f> bVar) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object doWork(qb.b<? super c.a> bVar);

    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object getForegroundInfo(qb.b<? super f> bVar) {
        return getForegroundInfo$suspendImpl(this, bVar);
    }

    @Override // androidx.work.c
    public final c5.a<f> getForegroundInfoAsync() {
        return i.a(getCoroutineContext().plus(JobKt__JobKt.Job$default(null, 1, null)), new AnonymousClass1(null));
    }

    @Override // androidx.work.c
    public final void onStopped() {
        super.onStopped();
    }

    public final Object setForeground(f fVar, qb.b<? super n> bVar) throws Throwable {
        c5.a<Void> foregroundAsync = setForegroundAsync(fVar);
        g.e(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        Object objA = ListenableFutureKt.a(foregroundAsync, bVar);
        return objA == CoroutineSingletons.f10059a ? objA : n.f10413a;
    }

    public final Object setProgress(Data data, qb.b<? super n> bVar) throws Throwable {
        c5.a<Void> progressAsync = setProgressAsync(data);
        g.e(progressAsync, "setProgressAsync(data)");
        Object objA = ListenableFutureKt.a(progressAsync, bVar);
        return objA == CoroutineSingletons.f10059a ? objA : n.f10413a;
    }

    @Override // androidx.work.c
    public final c5.a<c.a> startWork() {
        CoroutineDispatcher coroutineContext = !g.b(getCoroutineContext(), a.f2762a) ? getCoroutineContext() : this.params.f2807g;
        g.e(coroutineContext, "if (coroutineContext != …rkerContext\n            }");
        return i.a(coroutineContext.plus(JobKt__JobKt.Job$default(null, 1, null)), new C01941(null));
    }

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }
}
