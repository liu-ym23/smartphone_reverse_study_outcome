package com.stepos.ailauncher.speech.asr;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.contract.api.speech.AsrCallback;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$doRecord$5", f = "AIEngineAsrEngine.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AIEngineAsrEngine$doRecord$5 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ AsrCallback $callback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineAsrEngine$doRecord$5(AsrCallback asrCallback, InterfaceC4014c<? super AIEngineAsrEngine$doRecord$5> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$callback = asrCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AIEngineAsrEngine$doRecord$5(this.$callback, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AIEngineAsrEngine$doRecord$5) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.$callback.onRecordingStarted();
        return t.f7040a;
    }
}
