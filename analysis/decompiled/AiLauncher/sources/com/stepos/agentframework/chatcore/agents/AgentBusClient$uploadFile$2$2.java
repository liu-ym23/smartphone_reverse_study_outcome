package com.stepos.agentframework.chatcore.agents;

import Ua.M;
import com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.session.AgentError;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import n4.AbstractC4939a;
import t4.InterfaceC5507a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.AgentBusClient$uploadFile$2$2", f = "AgentBusClient.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusClient$uploadFile$2$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ FileInfo $fileInfo;
    final /* synthetic */ InterfaceC5507a $listener;
    final /* synthetic */ AbstractC4939a $status;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusClient$uploadFile$2$2(AbstractC4939a abstractC4939a, InterfaceC5507a interfaceC5507a, FileInfo fileInfo, InterfaceC4014c<? super AgentBusClient$uploadFile$2$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$status = abstractC4939a;
        this.$listener = interfaceC5507a;
        this.$fileInfo = fileInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusClient$uploadFile$2$2(this.$status, this.$listener, this.$fileInfo, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentBusClient$uploadFile$2$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.$listener.c(this.$fileInfo, new AgentError(FileStorageUploadHelper.INSTANCE.i(((AbstractC4939a.Failed) this.$status).getCause()) ? 10105 : AgentError.AGENT_ERROR_FILE_UPLOAD, ((AbstractC4939a.Failed) this.$status).getMessage(), ((AbstractC4939a.Failed) this.$status).getCause()));
        return Y8.t.f7040a;
    }
}
