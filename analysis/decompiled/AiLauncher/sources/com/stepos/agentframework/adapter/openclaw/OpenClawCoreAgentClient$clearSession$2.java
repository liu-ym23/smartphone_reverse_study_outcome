package com.stepos.agentframework.adapter.openclaw;

import Ua.M;
import Y8.t;
import com.zyql.agentfront.sdk.client.AgentFrontClient;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$clearSession$2", f = "OpenClawCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class OpenClawCoreAgentClient$clearSession$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $sessionKey;
    int label;
    final /* synthetic */ OpenClawCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenClawCoreAgentClient$clearSession$2(OpenClawCoreAgentClient openClawCoreAgentClient, String str, InterfaceC4014c<? super OpenClawCoreAgentClient$clearSession$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = openClawCoreAgentClient;
        this.$sessionKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new OpenClawCoreAgentClient$clearSession$2(this.this$0, this.$sessionKey, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((OpenClawCoreAgentClient$clearSession$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        AgentFrontClient agentFrontClient = this.this$0.agentFrontClient;
        if (agentFrontClient == null) {
            this.this$0.logger.b("OpenClawCoreAgentClient", "clearSession failed: client is null, sessionKey=" + this.$sessionKey);
            return t.f7040a;
        }
        try {
            this.this$0.logger.c("OpenClawCoreAgentClient", "clearSession: sessionKey=" + this.$sessionKey);
            AgentFrontClient.U(agentFrontClient, this.$sessionKey, null, 2, null);
        } catch (Exception e10) {
            this.this$0.logger.b("OpenClawCoreAgentClient", "clearSession failed: sessionKey=" + this.$sessionKey + ", error=" + e10.getMessage());
        }
        return t.f7040a;
    }
}
