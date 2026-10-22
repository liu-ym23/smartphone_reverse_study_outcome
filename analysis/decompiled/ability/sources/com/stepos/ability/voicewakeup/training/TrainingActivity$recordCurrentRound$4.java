package com.stepos.ability.voicewakeup.training;

import C7.r;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity$recordCurrentRound$4", f = "TrainingActivity.kt", l = {520}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062(\u0010\u0005\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Function2;", "Lkotlin/Function0;", "LC7/r;", "LH7/c;", "", "ready", "Ljava/nio/ShortBuffer;", "<anonymous>", "(LS7/n;)Ljava/nio/ShortBuffer;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TrainingActivity$recordCurrentRound$4 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public b f3384a;
    public Long b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ TrainingActivity e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$recordCurrentRound$4(TrainingActivity trainingActivity, H7.c cVar) {
        super(2, cVar);
        this.e = trainingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        TrainingActivity$recordCurrentRound$4 trainingActivity$recordCurrentRound$4 = new TrainingActivity$recordCurrentRound$4(this.e, cVar);
        trainingActivity$recordCurrentRound$4.d = obj;
        return trainingActivity$recordCurrentRound$4;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TrainingActivity$recordCurrentRound$4) create((n) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = r11.d
            r6 = r0
            S7.n r6 = (S7.n) r6
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r11.c
            r2 = 1
            if (r1 == 0) goto L21
            if (r1 != r2) goto L19
            java.lang.Long r1 = r11.b
            com.stepos.ability.voicewakeup.training.b r11 = r11.f3384a
            kotlin.b.b(r12)     // Catch: java.lang.Throwable -> L16
            goto L6c
        L16:
            r0 = move-exception
            r12 = r0
            goto L7c
        L19:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L21:
            kotlin.b.b(r12)
            com.stepos.ability.voicewakeup.training.TrainingActivity r12 = r11.e
            com.stepos.ability.voicewakeup.training.b r8 = r12.l
            r1 = 0
            if (r8 == 0) goto L44
            com.stepos.ability.voicewakeup.training.c r3 = r8.c
            r4 = 0
            r3.o = r4
            boolean r4 = r3.f3397j
            r4 = r4 ^ r2
            r3.m = r4
            long r4 = r3.l
            r9 = 1
            long r4 = r4 + r9
            r3.l = r4
            java.lang.Long r3 = new java.lang.Long
            r3.<init>(r4)
            r9 = r3
            r3 = r1
            goto L46
        L44:
            r3 = r1
            r9 = r3
        L46:
            com.stepos.ability.voicewakeup.training.a r1 = r12.t()     // Catch: java.lang.Throwable -> L78
            H4.l r4 = new H4.l     // Catch: java.lang.Throwable -> L78
            r5 = 0
            r4.<init>(r5, r9, r8)     // Catch: java.lang.Throwable -> L78
            H4.f r5 = new H4.f     // Catch: java.lang.Throwable -> L78
            r7 = 5
            r5.<init>(r12, r7)     // Catch: java.lang.Throwable -> L78
            r11.d = r3     // Catch: java.lang.Throwable -> L78
            r11.f3384a = r8     // Catch: java.lang.Throwable -> L78
            r11.b = r9     // Catch: java.lang.Throwable -> L78
            r11.c = r2     // Catch: java.lang.Throwable -> L78
            r2 = 16000(0x3e80, float:2.2421E-41)
            r3 = 3000(0xbb8, float:4.204E-42)
            r7 = r11
            java.lang.Comparable r12 = r1.b(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L78
            if (r12 != r0) goto L6a
            return r0
        L6a:
            r11 = r8
            r1 = r9
        L6c:
            java.nio.ShortBuffer r12 = (java.nio.ShortBuffer) r12     // Catch: java.lang.Throwable -> L16
            if (r1 == 0) goto L77
            long r0 = r1.longValue()
            r11.a(r0)
        L77:
            return r12
        L78:
            r0 = move-exception
            r12 = r0
            r11 = r8
            r1 = r9
        L7c:
            if (r1 == 0) goto L85
            long r0 = r1.longValue()
            r11.a(r0)
        L85:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.TrainingActivity$recordCurrentRound$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
