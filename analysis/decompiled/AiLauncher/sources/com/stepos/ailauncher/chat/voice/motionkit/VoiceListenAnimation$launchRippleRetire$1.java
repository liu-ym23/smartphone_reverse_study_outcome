package com.stepos.ailauncher.chat.voice.motionkit;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$launchRippleRetire$1", f = "VoiceListenAnimation.kt", l = {878}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class VoiceListenAnimation$launchRippleRetire$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    float F$0;
    int label;
    final /* synthetic */ VoiceListenAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceListenAnimation$launchRippleRetire$1(VoiceListenAnimation voiceListenAnimation, InterfaceC4014c<? super VoiceListenAnimation$launchRippleRetire$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = voiceListenAnimation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new VoiceListenAnimation$launchRippleRetire$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((VoiceListenAnimation$launchRippleRetire$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0036 -> B:14:0x0039). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1a
            if (r1 != r3) goto L12
            float r1 = r6.F$0
            kotlin.C4849c.b(r7)
            goto L39
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1a:
            kotlin.C4849c.b(r7)
            r1 = r2
        L1e:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r7 = r6.this$0
            com.stepos.ailauncher.chat.voice.motionkit.q r7 = com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.y(r7)
            float r7 = com.stepos.ailauncher.chat.voice.motionkit.O.f(r7)
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 >= 0) goto L57
            r6.F$0 = r1
            r6.label = r3
            r4 = 50
            java.lang.Object r7 = Ua.U.a(r4, r6)
            if (r7 != r0) goto L39
            return r0
        L39:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r7 = r6.this$0
            float r7 = r7.getSpeed()
            float r7 = v9.C5685n.e(r7, r2)
            r4 = 1028443341(0x3d4ccccd, float:0.05)
            float r7 = r7 * r4
            float r1 = r1 + r7
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r7 = r6.this$0
            java.util.concurrent.atomic.AtomicBoolean r7 = com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.v(r7)
            boolean r7 = r7.get()
            if (r7 == 0) goto L1e
            Y8.t r6 = Y8.t.f7040a
            return r6
        L57:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r7 = r6.this$0
            r0 = 0
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.L(r7, r0)
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r7 = r6.this$0
            java.util.LinkedHashMap r7 = com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.x(r7)
            java.lang.String r0 = "WaterDrop"
            java.lang.Object r7 = r7.get(r0)
            s7.k r7 = (s7.k) r7
            if (r7 == 0) goto L76
            java.lang.String r0 = "uRippleTime"
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7.g(r0, r1)
        L76:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r7 = r6.this$0
            boolean r7 = com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.s(r7)
            if (r7 == 0) goto L83
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r7 = r6.this$0
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.J(r7)
        L83:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation r6 = r6.this$0
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.F(r6)
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$launchRippleRetire$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
