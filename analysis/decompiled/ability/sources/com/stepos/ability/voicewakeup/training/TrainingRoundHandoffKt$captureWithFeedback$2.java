package com.stepos.ability.voicewakeup.training;

import C7.r;
import S7.k;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineStart;
import m9.AbstractC1683A;
import m9.C1687E;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingRoundHandoffKt$captureWithFeedback$2", f = "TrainingRoundHandoff.kt", l = {21}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TrainingRoundHandoffKt$captureWithFeedback$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public C1687E f3391a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ n d;
    public final /* synthetic */ k e;
    public final /* synthetic */ n f;

    @J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingRoundHandoffKt$captureWithFeedback$2$1", f = "TrainingRoundHandoff.kt", l = {22, 24}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/Function0;", "LC7/r;", "startCapture", "<anonymous>", "(LS7/a;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.voicewakeup.training.TrainingRoundHandoffKt$captureWithFeedback$2$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f3392a;
        public /* synthetic */ Object b;
        public final /* synthetic */ C1687E c;
        public final /* synthetic */ InterfaceC1733z d;
        public final /* synthetic */ n e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(C1687E c1687e, InterfaceC1733z interfaceC1733z, n nVar, H7.c cVar) {
            super(2, cVar);
            this.c = c1687e;
            this.d = interfaceC1733z;
            this.e = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.c, this.d, this.e, cVar);
            anonymousClass1.b = obj;
            return anonymousClass1;
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((S7.a) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
        
            if (((com.stepos.ability.voicewakeup.training.TrainingActivity$recordCurrentRound$3) r5.e).invoke(r0, r5) == r1) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r5.b
                S7.a r0 = (S7.a) r0
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r2 = r5.f3392a
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L20
                if (r2 == r4) goto L1c
                if (r2 != r3) goto L14
                kotlin.b.b(r6)
                goto L49
            L14:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1c:
                kotlin.b.b(r6)
                goto L30
            L20:
                kotlin.b.b(r6)
                r5.b = r0
                r5.f3392a = r4
                m9.E r6 = r5.c
                java.lang.Object r6 = r6.z(r5)
                if (r6 != r1) goto L30
                goto L48
            L30:
                m9.z r6 = r5.d
                H7.h r6 = r6.getCoroutineContext()
                kotlinx.coroutines.a.g(r6)
                r6 = 0
                r5.b = r6
                r5.f3392a = r3
                S7.n r6 = r5.e
                com.stepos.ability.voicewakeup.training.TrainingActivity$recordCurrentRound$3 r6 = (com.stepos.ability.voicewakeup.training.TrainingActivity$recordCurrentRound$3) r6
                java.lang.Object r5 = r6.invoke(r0, r5)
                if (r5 != r1) goto L49
            L48:
                return r1
            L49:
                C7.r r5 = C7.r.f317a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.TrainingRoundHandoffKt$captureWithFeedback$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingRoundHandoffKt$captureWithFeedback$2(n nVar, k kVar, n nVar2, H7.c cVar) {
        super(2, cVar);
        this.d = nVar;
        this.e = kVar;
        this.f = nVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        TrainingRoundHandoffKt$captureWithFeedback$2 trainingRoundHandoffKt$captureWithFeedback$2 = new TrainingRoundHandoffKt$captureWithFeedback$2(this.d, this.e, this.f, cVar);
        trainingRoundHandoffKt$captureWithFeedback$2.c = obj;
        return trainingRoundHandoffKt$captureWithFeedback$2;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TrainingRoundHandoffKt$captureWithFeedback$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th;
        C1687E c1687e;
        InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.c;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.b;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c1687e = this.f3391a;
            try {
                kotlin.b.b(obj);
                c1687e.cancel(null);
                return obj;
            } catch (Throwable th2) {
                th = th2;
                c1687e.cancel(null);
                throw th;
            }
        }
        kotlin.b.b(obj);
        CoroutineStart coroutineStart = CoroutineStart.f5175a;
        C1687E c1687eD = AbstractC1683A.d(interfaceC1733z, null, new TrainingRoundHandoffKt$captureWithFeedback$2$animation$1(this.e, null), 1);
        try {
            n nVar = this.d;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(c1687eD, interfaceC1733z, this.f, null);
            this.c = null;
            this.f3391a = c1687eD;
            this.b = 1;
            Object objInvoke = ((TrainingActivity$recordCurrentRound$4) nVar).invoke(anonymousClass1, this);
            if (objInvoke == coroutineSingletons) {
                return coroutineSingletons;
            }
            obj = objInvoke;
            c1687e = c1687eD;
            c1687e.cancel(null);
            return obj;
        } catch (Throwable th3) {
            th = th3;
            c1687e = c1687eD;
            c1687e.cancel(null);
            throw th;
        }
    }
}
