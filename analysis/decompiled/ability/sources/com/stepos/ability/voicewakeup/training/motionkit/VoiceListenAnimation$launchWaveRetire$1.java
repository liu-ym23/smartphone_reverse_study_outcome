package com.stepos.ability.voicewakeup.training.motionkit;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$launchWaveRetire$1", f = "VoiceListenAnimation.kt", l = {782}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class VoiceListenAnimation$launchWaveRetire$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public float f3402a;
    public float b;
    public int c;
    public final /* synthetic */ float d;
    public final /* synthetic */ a e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceListenAnimation$launchWaveRetire$1(float f, a aVar, H7.c cVar) {
        super(2, cVar);
        this.d = f;
        this.e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new VoiceListenAnimation$launchWaveRetire$1(this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((VoiceListenAnimation$launchWaveRetire$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0033 -> B:14:0x0036). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r8.c
            r2 = 0
            r3 = 1
            com.stepos.ability.voicewakeup.training.motionkit.a r4 = r8.e
            if (r1 == 0) goto L1c
            if (r1 != r3) goto L14
            float r1 = r8.b
            float r5 = r8.f3402a
            kotlin.b.b(r9)
            goto L36
        L14:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1c:
            kotlin.b.b(r9)
            float r9 = r8.d
            r1 = r9
            r5 = r2
        L23:
            int r9 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r9 >= 0) goto L43
            r8.f3402a = r5
            r8.b = r1
            r8.c = r3
            r6 = 50
            java.lang.Object r9 = kotlinx.coroutines.a.f(r6, r8)
            if (r9 != r0) goto L36
            return r0
        L36:
            float r9 = r4.f
            int r6 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r6 >= 0) goto L3d
            r9 = r2
        L3d:
            r6 = 1028443341(0x3d4ccccd, float:0.05)
            float r9 = r9 * r6
            float r5 = r5 + r9
            goto L23
        L43:
            r8 = 0
            r4.f3418I = r8
            java.util.LinkedHashMap r8 = r4.g
            java.lang.String r9 = "AudioWave"
            java.lang.Object r8 = r8.remove(r9)
            com.stepos.motionkit.FxInstance r8 = (com.stepos.motionkit.FxInstance) r8
            if (r8 == 0) goto L56
            r8.release()
        L56:
            boolean r8 = r4.h()
            if (r8 == 0) goto L5f
            r4.s()
        L5f:
            r4.r()
            r4.n()
            C7.r r8 = C7.r.f317a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.motionkit.VoiceListenAnimation$launchWaveRetire$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
