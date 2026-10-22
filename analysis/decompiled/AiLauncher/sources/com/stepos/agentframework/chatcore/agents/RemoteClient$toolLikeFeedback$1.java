package com.stepos.agentframework.chatcore.agents;

import Ua.M;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.ailauncher.chat.wake.circle.F;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.VoteRequest;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.RemoteClient$toolLikeFeedback$1", f = "RemoteClient.kt", l = {F.GESTURE_WIDTH_DP}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class RemoteClient$toolLikeFeedback$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $toolCallId;
    final /* synthetic */ VoteRequest $voteRequest;
    final /* synthetic */ int $voteType;
    int label;
    final /* synthetic */ RemoteClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteClient$toolLikeFeedback$1(VoteRequest voteRequest, RemoteClient remoteClient, String str, int i10, String str2, InterfaceC4014c<? super RemoteClient$toolLikeFeedback$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$voteRequest = voteRequest;
        this.this$0 = remoteClient;
        this.$toolCallId = str;
        this.$voteType = i10;
        this.$taskId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RemoteClient$toolLikeFeedback$1(this.$voteRequest, this.this$0, this.$toolCallId, this.$voteType, this.$taskId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((RemoteClient$toolLikeFeedback$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                ApiManager apiManager = ApiManager.INSTANCE;
                ApiType apiType = ApiType.BFF;
                VoteRequest voteRequest = this.$voteRequest;
                this.label = 1;
                obj = apiManager.r0(apiType, voteRequest, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                C4148a.k(this.this$0.getTAG(), "✅ [ToolLike-2] 工具点赞发送成功: toolCallId=" + this.$toolCallId + ", voteType=" + this.$voteType + ", taskId=" + this.$taskId, false, 4, null);
            } else {
                C4148a.h(this.this$0.getTAG(), "❌ [ToolLike-2] 工具点赞发送失败: toolCallId=" + this.$toolCallId, false, 4, null);
            }
        } catch (Exception e10) {
            C4148a.g(this.this$0.getTAG(), "❌ [ToolLike-2] 工具点赞异常: " + e10.getMessage(), e10, false, 8, null);
        }
        return Y8.t.f7040a;
    }
}
