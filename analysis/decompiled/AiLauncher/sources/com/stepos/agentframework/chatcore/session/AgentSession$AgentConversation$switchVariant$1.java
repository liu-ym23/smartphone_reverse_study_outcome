package com.stepos.agentframework.chatcore.session;

import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.L0;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$switchVariant$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$AgentConversation$switchVariant$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ int $delta;
    final /* synthetic */ String $messageId;
    int label;
    final /* synthetic */ AgentSession this$0;
    final /* synthetic */ AgentSession.AgentConversation this$1;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Integer.valueOf(((ChatMessage) t10).getVariantIndex()), Integer.valueOf(((ChatMessage) t11).getVariantIndex()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$AgentConversation$switchVariant$1(AgentSession agentSession, String str, AgentSession.AgentConversation agentConversation, int i10, InterfaceC4014c<? super AgentSession$AgentConversation$switchVariant$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
        this.$messageId = str;
        this.this$1 = agentConversation;
        this.$delta = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$AgentConversation$switchVariant$1(this.this$0, this.$messageId, this.this$1, this.$delta, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$AgentConversation$switchVariant$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        ChatMessage chatMessageV = this.this$0.messageRepository.v(this.$messageId);
        if (chatMessageV == null) {
            return Y8.t.f7040a;
        }
        String variantGroupId = chatMessageV.getVariantGroupId();
        if (variantGroupId.length() == 0) {
            C4148a.u(this.this$1.TAG, "switchVariant skip: no variant group, id=" + this.$messageId, false, 4, null);
            return Y8.t.f7040a;
        }
        List listC1 = Z8.F.c1(Z8.F.T0(this.this$0.messageRepository.j(variantGroupId), chatMessageV), new a());
        Iterator it = listC1.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (((ChatMessage) it.next()).getVariantIndex() == chatMessageV.getVariantIndex()) {
                break;
            }
            i10++;
        }
        ChatMessage chatMessage = (ChatMessage) Z8.F.t0(listC1, this.$delta + i10);
        if (i10 >= 0 && chatMessage != null && chatMessage.getVariantIndex() != chatMessageV.getVariantIndex()) {
            ChatMessage chatMessageO = this.this$0.messageRepository.o(this.$messageId, chatMessage.getVariantIndex());
            if (chatMessageO != null) {
                this.this$0.B0(new L0.MessageReplace(chatMessageO.getSessionId(), this.$messageId, chatMessageO, 0L, true, 8, null));
                return Y8.t.f7040a;
            }
            C4148a.u(this.this$1.TAG, "switchVariant failed: swap returned null, target=" + chatMessage.getMessageId(), false, 4, null);
            return Y8.t.f7040a;
        }
        C4148a.k(this.this$1.TAG, "switchVariant out of range: pos=" + i10 + " delta=" + this.$delta + " size=" + listC1.size(), false, 4, null);
        return Y8.t.f7040a;
    }
}
