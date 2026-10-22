package com.stepos.ailauncher.speech.tts;

import Ua.M;
import Ua.U;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$scheduleScreenOffDisconnect$1", f = "AIEngineTtsEngine.kt", l = {1049}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AIEngineTtsEngine$scheduleScreenOffDisconnect$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $from;
    final /* synthetic */ int $generation;
    int label;
    final /* synthetic */ AIEngineTtsEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEngineTtsEngine$scheduleScreenOffDisconnect$1(AIEngineTtsEngine aIEngineTtsEngine, int i10, String str, InterfaceC4014c<? super AIEngineTtsEngine$scheduleScreenOffDisconnect$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = aIEngineTtsEngine;
        this.$generation = i10;
        this.$from = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AIEngineTtsEngine$scheduleScreenOffDisconnect$1(this.this$0, this.$generation, this.$from, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AIEngineTtsEngine$scheduleScreenOffDisconnect$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            this.label = 1;
            if (U.a(5000L, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        this.this$0.s0(this.$generation, this.$from);
        return t.f7040a;
    }
}
