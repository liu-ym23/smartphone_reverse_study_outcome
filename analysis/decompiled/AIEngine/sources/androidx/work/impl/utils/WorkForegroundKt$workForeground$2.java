package androidx.work.impl.utils;

import android.content.Context;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.ListenableFutureKt;
import androidx.work.impl.e;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import h2.f;
import h2.j;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "androidx.work.impl.utils.WorkForegroundKt$workForeground$2", f = "WorkForeground.kt", l = {42, ErrorCodes.AFTER_SERVICE_METHOD_INTERCEPT_ERROR}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WorkForegroundKt$workForeground$2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super Void>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2980a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.work.c f2981b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q2.p f2982c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r2.p f2983d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f2984e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkForegroundKt$workForeground$2(androidx.work.c cVar, q2.p pVar, r2.p pVar2, Context context, qb.b bVar) {
        super(2, bVar);
        this.f2981b = cVar;
        this.f2982c = pVar;
        this.f2983d = pVar2;
        this.f2984e = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new WorkForegroundKt$workForeground$2(this.f2981b, this.f2982c, this.f2983d, this.f2984e, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Void> bVar) {
        return ((WorkForegroundKt$workForeground$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str = this.f2982c.f11507c;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2980a;
        androidx.work.c cVar = this.f2981b;
        if (i10 == 0) {
            kotlin.c.b(obj);
            c5.a<f> foregroundInfoAsync = cVar.getForegroundInfoAsync();
            g.e(foregroundInfoAsync, "worker.getForegroundInfoAsync()");
            this.f2980a = 1;
            obj = e.a(foregroundInfoAsync, cVar, this);
            if (obj != coroutineSingletons) {
            }
        }
        if (i10 != 1) {
            if (i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        f fVar = (f) obj;
        if (fVar == null) {
            throw new IllegalStateException(a0.a.k("Worker was marked important (", str, ") but did not provide ForegroundInfo"));
        }
        String str2 = b.f2985a;
        j.d().a(str2, "Updating notification for " + str);
        CallbackToFutureAdapter.c cVarA = this.f2983d.a(this.f2984e, cVar.getId(), fVar);
        this.f2980a = 2;
        Object objA = ListenableFutureKt.a(cVarA, this);
        return objA == coroutineSingletons ? coroutineSingletons : objA;
    }
}
