package com.stepos.ailauncher.speech.tts;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.contract.api.speech.TtsListener;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$finishStream$2", f = "AIEngineTtsEngine.kt", l = {871, 874, 892}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AIEngineTtsEngine$finishStream$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ int $generation;
    final /* synthetic */ TtsListener $listener;
    final /* synthetic */ String $reason;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIEngineTtsEngine this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$finishStream$2$2", f = "AIEngineTtsEngine.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$finishStream$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ TtsListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(TtsListener ttsListener, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$listener = ttsListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$listener, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            TtsListener ttsListener = this.$listener;
            if (ttsListener != null) {
                ttsListener.onPlayStopped();
            }
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineTtsEngine$finishStream$2(AIEngineTtsEngine aIEngineTtsEngine, int i10, String str, TtsListener ttsListener, InterfaceC4014c<? super AIEngineTtsEngine$finishStream$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = aIEngineTtsEngine;
        this.$generation = i10;
        this.$reason = str;
        this.$listener = ttsListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AIEngineTtsEngine$finishStream$2 aIEngineTtsEngine$finishStream$2 = new AIEngineTtsEngine$finishStream$2(this.this$0, this.$generation, this.$reason, this.$listener, interfaceC4014c);
        aIEngineTtsEngine$finishStream$2.L$0 = obj;
        return aIEngineTtsEngine$finishStream$2;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AIEngineTtsEngine$finishStream$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        if (r0.c(r24) == r3) goto L14;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$finishStream$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
