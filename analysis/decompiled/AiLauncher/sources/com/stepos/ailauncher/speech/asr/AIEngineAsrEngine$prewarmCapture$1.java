package com.stepos.ailauncher.speech.asr;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.common.utils.C3202f;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$prewarmCapture$1", f = "AIEngineAsrEngine.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AIEngineAsrEngine$prewarmCapture$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ int $epoch;
    int label;
    final /* synthetic */ AIEngineAsrEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineAsrEngine$prewarmCapture$1(int i10, AIEngineAsrEngine aIEngineAsrEngine, InterfaceC4014c<? super AIEngineAsrEngine$prewarmCapture$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$epoch = i10;
        this.this$0 = aIEngineAsrEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AIEngineAsrEngine$prewarmCapture$1(this.$epoch, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AIEngineAsrEngine$prewarmCapture$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        t tVar;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            if (this.$epoch != this.this$0.captureEpoch.get()) {
                tVar = t.f7040a;
                return tVar;
            }
            MicCapturePrewarm micCapturePrewarmA0 = this.this$0.a0(!C3202f.INSTANCE.e());
            if (micCapturePrewarmA0 != null) {
                Object obj2 = this.this$0.captureLock;
                int i10 = this.$epoch;
                AIEngineAsrEngine aIEngineAsrEngine = this.this$0;
                synchronized (obj2) {
                    try {
                        if (i10 == aIEngineAsrEngine.captureEpoch.get() && aIEngineAsrEngine.liveCapture == null) {
                            aIEngineAsrEngine.liveCapture = micCapturePrewarmA0;
                            C4109a.f(C4148a.k("AIEngineAsr", "prewarmCapture started source=" + micCapturePrewarmA0.getAudioSource(), false, 4, null));
                        } else {
                            aIEngineAsrEngine.Y(micCapturePrewarmA0);
                            t tVar2 = t.f7040a;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (this.$epoch == this.this$0.captureEpoch.get()) {
                    this.this$0.prewarmInFlight.set(false);
                }
                return t.f7040a;
            }
            tVar = t.f7040a;
            if (this.$epoch != this.this$0.captureEpoch.get()) {
                return tVar;
            }
            return tVar;
        } finally {
            if (this.$epoch == this.this$0.captureEpoch.get()) {
                this.this$0.prewarmInFlight.set(false);
            }
        }
    }
}
