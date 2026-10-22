package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "", "<anonymous>", "(LUa/M;)Ljava/util/Map;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$silentImages$1$1", f = "AgentSession.kt", l = {3469}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$AgentConversation$silentImages$1$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Map<String, ? extends String>>, Object> {
    final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super Map<String, String>>, Object> $block;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentSession$AgentConversation$silentImages$1$1(InterfaceC5074l<? super InterfaceC4014c<? super Map<String, String>>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super AgentSession$AgentConversation$silentImages$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$block = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$AgentConversation$silentImages$1$1(this.$block, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<? super Map<String, String>> interfaceC4014c) {
        return ((AgentSession$AgentConversation$silentImages$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        InterfaceC5074l<InterfaceC4014c<? super Map<String, String>>, Object> interfaceC5074l = this.$block;
        this.label = 1;
        Object objInvoke = interfaceC5074l.invoke(this);
        return objInvoke == objG ? objG : objInvoke;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super Map<String, ? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Map<String, String>>) interfaceC4014c);
    }
}
