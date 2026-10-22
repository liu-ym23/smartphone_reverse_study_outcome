package kotlinx.coroutines;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TimeoutKt {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {101}, m = "withTimeoutOrNull")
    /* renamed from: kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TimeoutKt.withTimeoutOrNull(0L, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlinx.coroutines.TimeoutCancellationException TimeoutCancellationException(long r2, kotlinx.coroutines.Delay r4, kotlinx.coroutines.Job r5) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.DelayWithTimeoutDiagnostics
            if (r0 == 0) goto L7
            kotlinx.coroutines.DelayWithTimeoutDiagnostics r4 = (kotlinx.coroutines.DelayWithTimeoutDiagnostics) r4
            goto L8
        L7:
            r4 = 0
        L8:
            if (r4 == 0) goto L18
            int r0 = hc.a.f9403d
            kotlin.time.DurationUnit r0 = kotlin.time.DurationUnit.f10100c
            long r0 = androidx.datastore.preferences.protobuf.b1.W(r2, r0)
            java.lang.String r4 = r4.m141timeoutMessageLRDsOJo(r0)
            if (r4 != 0) goto L20
        L18:
            java.lang.String r4 = "Timed out waiting for "
            java.lang.String r0 = " ms"
            java.lang.String r4 = ai.onnxruntime.a.h(r2, r4, r0)
        L20:
            kotlinx.coroutines.TimeoutCancellationException r2 = new kotlinx.coroutines.TimeoutCancellationException
            r2.<init>(r4, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.TimeoutCancellationException(long, kotlinx.coroutines.Delay, kotlinx.coroutines.Job):kotlinx.coroutines.TimeoutCancellationException");
    }

    private static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> timeoutCoroutine, p<? super CoroutineScope, ? super b<? super T>, ? extends Object> pVar) {
        JobKt.disposeOnCompletion(timeoutCoroutine, DelayKt.getDelay(timeoutCoroutine.uCont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.getContext()));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(timeoutCoroutine, timeoutCoroutine, pVar);
    }

    public static final <T> Object withTimeout(long j10, p<? super CoroutineScope, ? super b<? super T>, ? extends Object> pVar, b<? super T> frame) {
        if (j10 <= 0) {
            throw new TimeoutCancellationException("Timed out immediately");
        }
        Object obj = setupTimeout(new TimeoutCoroutine(j10, frame), pVar);
        if (obj == CoroutineSingletons.f10059a) {
            g.f(frame, "frame");
        }
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.TimeoutCoroutine] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object withTimeoutOrNull(long r7, zb.p<? super kotlinx.coroutines.CoroutineScope, ? super qb.b<? super T>, ? extends java.lang.Object> r9, qb.b<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
            java.lang.Object r8 = r0.L$0
            zb.p r8 = (zb.p) r8
            kotlin.c.b(r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L30
            return r10
        L30:
            r8 = move-exception
            goto L62
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            kotlin.c.b(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L44
            return r3
        L44:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r0.L$0 = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L60
            r0.L$1 = r10     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L60
            r0.J$0 = r7     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L60
            r0.label = r4     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L60
            kotlinx.coroutines.TimeoutCoroutine r2 = new kotlinx.coroutines.TimeoutCoroutine     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L60
            r2.<init>(r7, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L60
            r10.f10076a = r2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L60
            java.lang.Object r7 = setupTimeout(r2, r9)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L60
            if (r7 != r1) goto L5f
            return r1
        L5f:
            return r7
        L60:
            r8 = move-exception
            r7 = r10
        L62:
            kotlinx.coroutines.Job r9 = r8.coroutine
            T r7 = r7.f10076a
            if (r9 != r7) goto L69
            return r3
        L69:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(long, zb.p, qb.b):java.lang.Object");
    }
}
