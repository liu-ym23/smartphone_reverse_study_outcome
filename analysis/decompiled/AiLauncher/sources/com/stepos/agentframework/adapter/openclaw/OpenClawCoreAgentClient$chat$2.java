package com.stepos.agentframework.adapter.openclaw;

import Ua.M;
import Y8.t;
import android.content.Context;
import com.stepos.agentframework.adapter.netcore.h;
import com.stepos.agentframework.adapter.netcore.n;
import com.zyql.agentfront.sdk.client.AgentFrontClient;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.HashMap;
import kotlin.C0918n;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/agentframework/adapter/netcore/n;", "<anonymous>", "(LUa/M;)Lcom/stepos/agentframework/adapter/netcore/n;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$chat$2", f = "OpenClawCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class OpenClawCoreAgentClient$chat$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super n>, Object> {
    final /* synthetic */ h $listener;
    final /* synthetic */ C0918n $request;
    int label;
    final /* synthetic */ OpenClawCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenClawCoreAgentClient$chat$2(OpenClawCoreAgentClient openClawCoreAgentClient, C0918n c0918n, h hVar, InterfaceC4014c<? super OpenClawCoreAgentClient$chat$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = openClawCoreAgentClient;
        this.$request = c0918n;
        this.$listener = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new OpenClawCoreAgentClient$chat$2(this.this$0, this.$request, this.$listener, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super n> interfaceC4014c) {
        return ((OpenClawCoreAgentClient$chat$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Context context = this.this$0.context;
        if (context == null) {
            return null;
        }
        AgentFrontClient agentFrontClientZ0 = this.this$0.z0(context);
        HashMap<String, Object> mapS = this.$request.s();
        return (mapS == null || mapS.isEmpty()) ? this.this$0.A0(this.$request, this.$listener, agentFrontClientZ0) : this.this$0.G0(this.$request, agentFrontClientZ0);
    }
}
