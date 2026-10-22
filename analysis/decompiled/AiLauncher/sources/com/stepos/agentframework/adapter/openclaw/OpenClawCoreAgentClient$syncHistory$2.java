package com.stepos.agentframework.adapter.openclaw;

import Ua.M;
import Y8.t;
import Z8.C1174w;
import com.zyql.agentfront.bean.SessionChatMessage;
import com.zyql.agentfront.bean.SyncHistoryResponse;
import com.zyql.agentfront.sdk.client.AgentFrontClient;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.RemoteChatMessage;
import kotlin.SyncHistoryRequest;
import kotlin.SyncHistoryResult;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LK6/D;", "<anonymous>", "(LUa/M;)LK6/D;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$syncHistory$2", f = "OpenClawCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class OpenClawCoreAgentClient$syncHistory$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super SyncHistoryResult>, Object> {
    final /* synthetic */ SyncHistoryRequest $request;
    int label;
    final /* synthetic */ OpenClawCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenClawCoreAgentClient$syncHistory$2(OpenClawCoreAgentClient openClawCoreAgentClient, SyncHistoryRequest syncHistoryRequest, InterfaceC4014c<? super OpenClawCoreAgentClient$syncHistory$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = openClawCoreAgentClient;
        this.$request = syncHistoryRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new OpenClawCoreAgentClient$syncHistory$2(this.this$0, this.$request, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super SyncHistoryResult> interfaceC4014c) {
        return ((OpenClawCoreAgentClient$syncHistory$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
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
            this.this$0.logger.b("OpenClawCoreAgentClient", "syncHistory failed: client is null, sessionKey=" + this.$request.getSessionKey());
            return new SyncHistoryResult(null, false, "client is null", null, 9, null);
        }
        try {
            this.this$0.logger.c("OpenClawCoreAgentClient", "syncHistory: sessionKey=" + this.$request.getSessionKey());
            SyncHistoryResponse syncHistoryResponseQ0 = agentFrontClient.q0(new com.zyql.agentfront.bean.SyncHistoryRequest(this.$request.getSessionKey(), null, 2, null));
            if (!syncHistoryResponseQ0.getSuccess()) {
                return new SyncHistoryResult(null, false, syncHistoryResponseQ0.getErrorMessage(), null, 9, null);
            }
            List<SessionChatMessage> messages = syncHistoryResponseQ0.getMessages();
            ArrayList arrayList = new ArrayList(C1174w.x(messages, 10));
            for (SessionChatMessage sessionChatMessage : messages) {
                arrayList.add(new RemoteChatMessage(sessionChatMessage.getId(), sessionChatMessage.getRole(), sessionChatMessage.getContent(), sessionChatMessage.getTime()));
            }
            return new SyncHistoryResult(arrayList, true, null, null, 12, null);
        } catch (Exception e10) {
            this.this$0.logger.b("OpenClawCoreAgentClient", "syncHistory failed: sessionKey=" + this.$request.getSessionKey() + ", error=" + e10.getMessage());
            return new SyncHistoryResult(null, false, e10.getMessage(), null, 9, null);
        }
    }
}
