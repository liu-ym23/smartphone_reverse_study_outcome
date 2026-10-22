package com.bytedance.android.live.revenue.core.util;

import com.bytedance.android.scope.o;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class AsyncService implements o, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ey0.a f91030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f91031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Continuation<Unit>> f91032c;

    public static final class a implements Continuation<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsyncService f91033a;

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f91033a.f91030a;
        }

        public a(AsyncService r100) {
            this.f91033a = r100;
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object r100) {
            AsyncService r101 = this.f91033a;
            Throwable r102 = Result.m9452exceptionOrNullimpl(r100);
            if (r102 == null) goto L6;
            r100 = r102;
        L6:
            r101.f91031b = r100;
            Object r103 = this.f91033a.f91031b;
            if (Intrinsics.areEqual(r103, Unit.INSTANCE) == false) goto L14;
            Iterator<T> r104 = this.f91033a.f91032c.iterator();
        L10:
            if (r104.hasNext() == false) goto L12;
            ey0.b.a((Continuation) r104.next(), Unit.INSTANCE);
            goto L10
        L12:
            ((ArrayList) this.f91033a.f91032c).clear();
            return;
        L14:
            if ((r103 instanceof Throwable) == false) goto L22;
            Iterator<T> r105 = this.f91033a.f91032c.iterator();
        L17:
            if (r105.hasNext() == false) goto L23;
            Continuation r106 = (Continuation) r105.next();
            Result.Companion r107 = Result.Companion;
            r106.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure((Throwable) r103)));
            goto L17
        L23:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.core.util.AsyncService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Continuation<? super Unit>, Object>, SuspendFunction {
        public AnonymousClass1(AsyncService r100) {
            super(1, r100, AsyncService.class, "onStartAsync", "onStartAsync(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((AsyncService) this.receiver).o0(r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }
    }

    public abstract Object o0(Continuation<? super Unit> r100);

    @Override // com.bytedance.android.live.revenue.core.util.d
    public final boolean f() {
        Object r100 = this.f91031b;
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof Throwable) == false) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r100, Boolean.valueOf(this.f91030a.f474783a)) == false) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(r100, Unit.INSTANCE) == false) goto L16;
        return true;
    L16:
        throw new AssertionError();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        ContinuationKt.startCoroutine(new AnonymousClass1(this), new a(this));
    }

    @Override // com.bytedance.android.scope.o
    public void onStop() {
        this.f91030a.f474783a = true;
        ((ArrayList) this.f91032c).clear();
    }

    public AsyncService() {
        this.f91030a = new ey0.a();
        this.f91032c = new ArrayList();
    }

    @Override // com.bytedance.android.live.revenue.core.util.d
    public final Object g(Continuation<? super Unit> r100) {
        if (f() == true) goto L10;
        SafeContinuation r101 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        ((ArrayList) this.f91032c).add(r101);
        Object r102 = r101.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L9:
        return r102;
    L10:
        return Unit.INSTANCE;
    }

    public final void p0(com.bytedance.android.livesdk.revenue.service.sti.a r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$use");
        Intrinsics.checkNotNullParameter(r101, "block");
        if (r100.f() == false) goto L5;
        r101.invoke(r100);
        return;
    L5:
        AsyncService$use$1 r102 = new AsyncService$use$1(r100, r101, null);
        Intrinsics.checkNotNullParameter(r102, "block");
        if (this.f91030a.f474783a == true) goto L11;
        ContinuationKt.startCoroutine(r102, new com.bytedance.android.live.revenue.core.util.a(this));
        return;
    }
}
