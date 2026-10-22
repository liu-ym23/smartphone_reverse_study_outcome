package com.stepos.ability.voicewakeup.training;

import C7.r;
import S7.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity$recordCurrentRound$2", f = "TrainingActivity.kt", l = {497, 498}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TrainingActivity$recordCurrentRound$2 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public int f3382a;
    public final /* synthetic */ TrainingActivity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$recordCurrentRound$2(TrainingActivity trainingActivity, H7.c cVar) {
        super(1, cVar);
        this.b = trainingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new TrainingActivity$recordCurrentRound$2(this.b, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((TrainingActivity$recordCurrentRound$2) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        if (r7.m(r1, r6) == r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
    
        if (r7.m(r1, r6) == r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r6.f3382a
            r2 = 2
            r3 = 1
            com.stepos.ability.voicewakeup.training.TrainingActivity r4 = r6.b
            if (r1 == 0) goto L1a
            if (r1 == r3) goto Le
            if (r1 != r2) goto L12
        Le:
            kotlin.b.b(r7)
            goto L58
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1a:
            kotlin.b.b(r7)
            com.stepos.ability.voicewakeup.training.TrainingActivity$RoundFeedback r7 = r4.y
            int r7 = r7.ordinal()
            if (r7 == 0) goto L58
            r1 = 0
            java.lang.String r5 = "orb"
            if (r7 == r3) goto L45
            if (r7 != r2) goto L3f
            com.stepos.ability.voicewakeup.ui.d r7 = r4.c
            if (r7 == 0) goto L3b
            com.stepos.ability.voicewakeup.ui.WakeupPagAnimation r1 = com.stepos.ability.voicewakeup.ui.WakeupPagAnimation.e
            r6.f3382a = r2
            java.lang.Object r7 = r7.m(r1, r6)
            if (r7 != r0) goto L58
            goto L53
        L3b:
            kotlin.jvm.internal.k.n(r5)
            throw r1
        L3f:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L45:
            com.stepos.ability.voicewakeup.ui.d r7 = r4.c
            if (r7 == 0) goto L54
            com.stepos.ability.voicewakeup.ui.WakeupPagAnimation r1 = com.stepos.ability.voicewakeup.ui.WakeupPagAnimation.d
            r6.f3382a = r3
            java.lang.Object r7 = r7.m(r1, r6)
            if (r7 != r0) goto L58
        L53:
            return r0
        L54:
            kotlin.jvm.internal.k.n(r5)
            throw r1
        L58:
            H7.h r6 = r6.getContext()
            kotlinx.coroutines.a.g(r6)
            com.stepos.ability.voicewakeup.training.TrainingActivity$RoundFeedback r6 = com.stepos.ability.voicewakeup.training.TrainingActivity.RoundFeedback.f3375a
            r4.y = r6
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.TrainingActivity$recordCurrentRound$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
