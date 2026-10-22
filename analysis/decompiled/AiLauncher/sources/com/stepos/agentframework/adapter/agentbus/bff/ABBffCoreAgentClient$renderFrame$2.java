package com.stepos.agentframework.adapter.agentbus.bff;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$renderFrame$2", f = "ABBffCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ABBffCoreAgentClient$renderFrame$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ Map<String, String> $meta;
    final /* synthetic */ com.stepos.agentframework.protobuf.f $msg;
    final /* synthetic */ Object $role;
    int label;
    final /* synthetic */ ABBffCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABBffCoreAgentClient$renderFrame$2(ABBffCoreAgentClient aBBffCoreAgentClient, Object obj, Map<String, String> map, com.stepos.agentframework.protobuf.f fVar, InterfaceC4014c<? super ABBffCoreAgentClient$renderFrame$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = aBBffCoreAgentClient;
        this.$role = obj;
        this.$meta = map;
        this.$msg = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ABBffCoreAgentClient$renderFrame$2(this.this$0, this.$role, this.$meta, this.$msg, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ABBffCoreAgentClient$renderFrame$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        ABBffCoreAgentClient aBBffCoreAgentClient = this.this$0;
        Object obj2 = this.$role;
        String str = this.$meta.get("reasoning");
        String str2 = this.$meta.get("approval");
        String str3 = this.$meta.get("seq_no");
        String str4 = this.$meta.get("message_partial");
        aBBffCoreAgentClient.L0("renderFrame role=" + obj2 + " reasoning=" + ((Object) str) + " approval=" + ((Object) str2) + " seq=" + ((Object) str3) + " partial=" + ((Object) str4) + " deltaLen=" + this.$msg.getDelta().length() + " contentLen=" + this.$msg.getContent().length() + " tools=" + this.$msg.getToolCallsCount());
        ABBffCoreAgentClient aBBffCoreAgentClient2 = this.this$0;
        Map<String, String> map = this.$meta;
        kotlin.jvm.internal.p.f(map);
        aBBffCoreAgentClient2.O0(map);
        ABBffCoreAgentClient aBBffCoreAgentClient3 = this.this$0;
        Map<String, String> map2 = this.$meta;
        kotlin.jvm.internal.p.f(map2);
        aBBffCoreAgentClient3.P0(map2);
        return t.f7040a;
    }
}
