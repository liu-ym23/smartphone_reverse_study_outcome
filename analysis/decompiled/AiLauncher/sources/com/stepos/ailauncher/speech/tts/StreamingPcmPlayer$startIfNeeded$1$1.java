package com.stepos.ailauncher.speech.tts;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.chat.wake.circle.F;
import com.stepos.ailauncher.speech.tts.StreamingPcmPlayer;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.tts.StreamingPcmPlayer$startIfNeeded$1$1", f = "StreamingPcmPlayer.kt", l = {F.LOOP_END_FRAME}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class StreamingPcmPlayer$startIfNeeded$1$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ Ref$ObjectRef<StreamingPcmPlayer.c> $session;
    int label;
    final /* synthetic */ StreamingPcmPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamingPcmPlayer$startIfNeeded$1$1(StreamingPcmPlayer streamingPcmPlayer, Ref$ObjectRef<StreamingPcmPlayer.c> ref$ObjectRef, InterfaceC4014c<? super StreamingPcmPlayer$startIfNeeded$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = streamingPcmPlayer;
        this.$session = ref$ObjectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new StreamingPcmPlayer$startIfNeeded$1$1(this.this$0, this.$session, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((StreamingPcmPlayer$startIfNeeded$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StreamingPcmPlayer.c cVar;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            StreamingPcmPlayer streamingPcmPlayer = this.this$0;
            StreamingPcmPlayer.c cVar2 = this.$session.f34820a;
            if (cVar2 == null) {
                kotlin.jvm.internal.p.A("session");
                cVar = null;
            } else {
                cVar = cVar2;
            }
            this.label = 1;
            if (streamingPcmPlayer.F(cVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
