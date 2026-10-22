package com.stepos.agentframework.adapter.agentbus;

import a4.Message;
import com.stepos.agentbus.generated.Role;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "sessionId", "La4/w;", "message", "LY8/t;", "<anonymous>", "(Ljava/lang/String;La4/w;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusKt$connectAgentBus$1", f = "ClawChannelAgentBus.kt", l = {23}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ClawChannelAgentBusKt$connectAgentBus$1 extends SuspendLambda implements p9.q<String, Message, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ClawChannel $channel;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClawChannelAgentBusKt$connectAgentBus$1(ClawChannel clawChannel, InterfaceC4014c<? super ClawChannelAgentBusKt$connectAgentBus$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$channel = clawChannel;
    }

    @Override // p9.q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(String str, Message message, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        ClawChannelAgentBusKt$connectAgentBus$1 clawChannelAgentBusKt$connectAgentBus$1 = new ClawChannelAgentBusKt$connectAgentBus$1(this.$channel, interfaceC4014c);
        clawChannelAgentBusKt$connectAgentBus$1.L$0 = str;
        clawChannelAgentBusKt$connectAgentBus$1.L$1 = message;
        return clawChannelAgentBusKt$connectAgentBus$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str = (String) this.L$0;
        Message message = (Message) this.L$1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Role role = message.getRole();
            int length = message.getContent().length();
            String delta = message.getDelta();
            int length2 = delta != null ? delta.length() : 0;
            C4148a.d("ClawChannelAgentBus", "onMessage session=" + str + " role=" + role + " contentLen=" + length + " deltaLen=" + length2 + " tools=" + message.g().size(), false, 4, null);
            ClawChannel clawChannel = this.$channel;
            this.L$0 = g9.h.a(str);
            this.L$1 = g9.h.a(message);
            this.label = 1;
            if (clawChannel.b(str, message, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
