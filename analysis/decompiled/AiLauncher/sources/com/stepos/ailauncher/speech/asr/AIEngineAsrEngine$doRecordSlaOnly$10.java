package com.stepos.ailauncher.speech.asr;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.contract.api.speech.AsrCallback;
import com.stepos.ailauncher.speech.R$string;
import com.stepos.ailauncher.speech.model.ErrorModel;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$doRecordSlaOnly$10", f = "AIEngineAsrEngine.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AIEngineAsrEngine$doRecordSlaOnly$10 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ AsrCallback $callback;
    int label;
    final /* synthetic */ AIEngineAsrEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineAsrEngine$doRecordSlaOnly$10(AsrCallback asrCallback, AIEngineAsrEngine aIEngineAsrEngine, InterfaceC4014c<? super AIEngineAsrEngine$doRecordSlaOnly$10> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$callback = asrCallback;
        this.this$0 = aIEngineAsrEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AIEngineAsrEngine$doRecordSlaOnly$10(this.$callback, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AIEngineAsrEngine$doRecordSlaOnly$10) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        AsrCallback asrCallback = this.$callback;
        String string = this.this$0.context.getString(R$string.speech_error_no_speech_detected);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        asrCallback.onError(ErrorModel.Err_ASR_NO_SPEECH, string);
        this.$callback.onRecordingStopped();
        return t.f7040a;
    }
}
