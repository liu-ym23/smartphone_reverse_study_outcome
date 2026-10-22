package com.stepos.ailauncher.chat.voice.motionkit;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$launchWaveRetire$1", f = "VoiceListenAnimation.kt", l = {793}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class VoiceListenAnimation$launchWaveRetire$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ float $exitDur;
    float F$0;
    float F$1;
    int label;
    final /* synthetic */ VoiceListenAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceListenAnimation$launchWaveRetire$1(float f10, VoiceListenAnimation voiceListenAnimation, InterfaceC4014c<? super VoiceListenAnimation$launchWaveRetire$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$exitDur = f10;
        this.this$0 = voiceListenAnimation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new VoiceListenAnimation$launchWaveRetire$1(this.$exitDur, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((VoiceListenAnimation$launchWaveRetire$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0033 -> B:14:0x0036). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 != r3) goto L14
            float r1 = r7.F$1
            float r4 = r7.F$0
            kotlin.C4849c.b(r8)
            goto L36
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1c:
            kotlin.C4849c.b(r8)
            float r8 = r7.$exitDur
            r1 = r8
            r4 = r2
        L23:
            int r8 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r8 >= 0) goto L46
            r7.F$0 = r4
            r7.F$1 = r1
            r7.label = r3
            r5 = 50
            java.lang.Object r8 = Ua.U.a(r5, r7)
            if (r8 != r0) goto L36
            return r0
        L36:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r8 = r7.this$0
            float r8 = r8.getSpeed()
            float r8 = v9.C5685n.e(r8, r2)
            r5 = 1028443341(0x3d4ccccd, float:0.05)
            float r8 = r8 * r5
            float r4 = r4 + r8
            goto L23
        L46:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r8 = r7.this$0
            r0 = 0
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.P(r8, r0)
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r8 = r7.this$0
            java.util.LinkedHashMap r8 = com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.x(r8)
            java.lang.String r0 = "AudioWave"
            java.lang.Object r8 = r8.remove(r0)
            s7.k r8 = (s7.k) r8
            if (r8 == 0) goto L60
            r8.release()
        L60:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r8 = r7.this$0
            boolean r8 = com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.s(r8)
            if (r8 == 0) goto L6d
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r8 = r7.this$0
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.J(r8)
        L6d:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r8 = r7.this$0
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.I(r8)
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r7 = r7.this$0
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.F(r7)
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$launchWaveRetire$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
