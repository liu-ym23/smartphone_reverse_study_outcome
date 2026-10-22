package com.stepos.agentframework.chatcore.session;

import com.stepos.agentframework.chatcore.session.L0;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.ChatRound$resetStreamStallTimer$2", f = "ChatRound.kt", l = {750}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ChatRound$resetStreamStallTimer$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ ChatRound this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatRound$resetStreamStallTimer$2(ChatRound chatRound, InterfaceC4014c<? super ChatRound$resetStreamStallTimer$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatRound;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatRound$resetStreamStallTimer$2(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatRound$resetStreamStallTimer$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            long networkToastDelayMs = this.this$0.owner.getConfig().getNetworkToastDelayMs() + this.this$0.owner.getConfig().getCotCollapseDelayMs();
            this.label = 1;
            if (Ua.U.a(networkToastDelayMs, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (this.this$0.getTalkPhase() != TalkPhase.COT_THINKING) {
            return Y8.t.f7040a;
        }
        C4148a.u(this.this$0.TAG, "cot stalled, collapse thinking content and prompt reconnect", false, 4, null);
        this.this$0.owner.B0(new L0.COTCollapseEvent(this.this$0.B0(), 0L, 2, null));
        ChatRound.u0(this.this$0, true, null, 2, null);
        return Y8.t.f7040a;
    }
}
