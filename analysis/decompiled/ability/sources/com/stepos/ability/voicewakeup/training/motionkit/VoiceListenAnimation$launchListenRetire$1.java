package com.stepos.ability.voicewakeup.training.motionkit;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$launchListenRetire$1", f = "VoiceListenAnimation.kt", l = {852}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class VoiceListenAnimation$launchListenRetire$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public float f3401a;
    public int b;
    public final /* synthetic */ a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceListenAnimation$launchListenRetire$1(a aVar, H7.c cVar) {
        super(2, cVar);
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new VoiceListenAnimation$launchListenRetire$1(this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((VoiceListenAnimation$launchListenRetire$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:14:0x0037). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r8.b
            C7.r r2 = C7.r.f317a
            r3 = 0
            r4 = 1
            com.stepos.ability.voicewakeup.training.motionkit.a r5 = r8.c
            if (r1 == 0) goto L1c
            if (r1 != r4) goto L14
            float r1 = r8.f3401a
            kotlin.b.b(r9)
            goto L37
        L14:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1c:
            kotlin.b.b(r9)
            r1 = r3
        L20:
            A5.c r9 = r5.k
            float r9 = I4.o.c(r9)
            int r9 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r9 >= 0) goto L4c
            r8.f3401a = r1
            r8.b = r4
            r6 = 50
            java.lang.Object r9 = kotlinx.coroutines.a.f(r6, r8)
            if (r9 != r0) goto L37
            return r0
        L37:
            float r9 = r5.f
            int r6 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r6 >= 0) goto L3e
            r9 = r3
        L3e:
            r6 = 1028443341(0x3d4ccccd, float:0.05)
            float r9 = r9 * r6
            float r1 = r1 + r9
            java.util.concurrent.atomic.AtomicBoolean r9 = r5.f3414D
            boolean r9 = r9.get()
            if (r9 == 0) goto L20
            return r2
        L4c:
            r8 = 0
            r5.f3417H = r8
            java.util.LinkedHashMap r8 = r5.g
            java.lang.String r9 = "WaterDrop"
            java.lang.Object r8 = r8.get(r9)
            com.stepos.motionkit.FxInstance r8 = (com.stepos.motionkit.FxInstance) r8
            if (r8 == 0) goto L63
            java.lang.String r9 = "uListenTime"
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8.setUniform(r9, r0)
        L63:
            boolean r8 = r5.h()
            if (r8 == 0) goto L6c
            r5.s()
        L6c:
            r5.n()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$launchListenRetire$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
