package com.stepos.agentframework.adapter.coze;

import C7.r;
import F9.C;
import H7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.agentframework.adapter.coze.bean.AgentDetailResult;
import com.stepos.agentframework.adapter.coze.bean.BlockingResult;
import com.stepos.agentframework.adapter.coze.bean.CompletionRequestBody;
import com.stepos.agentframework.adapter.coze.bean.CreateConversation;
import com.stepos.agentframework.adapter.coze.bean.CreateConversationResult;
import com.stepos.agentframework.adapter.coze.bean.LikeBody;
import com.stepos.agentframework.adapter.coze.bean.UploadFileResult;
import kotlin.Metadata;
import sa.InterfaceC1926a;
import sa.f;
import sa.i;
import sa.l;
import sa.o;
import sa.q;
import sa.s;
import sa.t;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000  2\u00020\u0001:\u0001 J$\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\n\u001a\u00020\tH§@¢\u0006\u0004\b\f\u0010\rJ$\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000eH§@¢\u0006\u0004\b\u0011\u0010\u0012J<\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u0015H§@¢\u0006\u0004\b\u0018\u0010\u0019J.\u0010\u001e\u001a\u00020\u001d2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0003\u0010\u001c\u001a\u00020\u001bH§@¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006!À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/Api;", "", "", "secretKey", "Lcom/stepos/agentframework/adapter/coze/bean/CreateConversation;", "body", "Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult;", "createConversation", "(Ljava/lang/String;Lcom/stepos/agentframework/adapter/coze/bean/CreateConversation;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/coze/bean/CompletionRequestBody;", "completionRequestBody", "Lcom/stepos/agentframework/adapter/coze/bean/BlockingResult;", "chatMessagesBlock", "(Lcom/stepos/agentframework/adapter/coze/bean/CompletionRequestBody;LH7/c;)Ljava/lang/Object;", "LF9/C;", BffConstant.Type.File, "Lcom/stepos/agentframework/adapter/coze/bean/UploadFileResult;", "uploadFile", "(Ljava/lang/String;LF9/C;LH7/c;)Ljava/lang/Object;", "conversationId", "messageId", "Lcom/stepos/agentframework/adapter/coze/bean/LikeBody;", "feedBack", "LC7/r;", "feedback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/coze/bean/LikeBody;LH7/c;)Ljava/lang/Object;", "botId", "", "isPublished", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult;", "getAgentDetail", "(Ljava/lang/String;Ljava/lang/String;ZLH7/c;)Ljava/lang/Object;", "Companion", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Api {
    public static final String CHAT_PATH = "v3/chat";
    public static final String CHAT_SUBMIT_TOOL_OUTPUTS = "v3/chat/submit_tool_outputs";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/Api$Companion;", "", AppAgent.CONSTRUCT, "()V", "CHAT_PATH", "", "CHAT_SUBMIT_TOOL_OUTPUTS", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CHAT_PATH = "v3/chat";
        public static final String CHAT_SUBMIT_TOOL_OUTPUTS = "v3/chat/submit_tool_outputs";

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getAgentDetail$default(Api api, String str, String str2, boolean z10, c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAgentDetail");
        }
        if ((i & 4) != 0) {
            z10 = true;
        }
        return api.getAgentDetail(str, str2, z10, cVar);
    }

    @o("v1/completion-messages")
    Object chatMessagesBlock(@InterfaceC1926a CompletionRequestBody completionRequestBody, c<? super BlockingResult> cVar);

    @o("v1/conversation/create")
    Object createConversation(@i("Authorization") String str, @InterfaceC1926a CreateConversation createConversation, c<? super CreateConversationResult> cVar);

    @o("v1/conversations/{conversation_id}/messages/{message_id}/feedback")
    Object feedback(@i("Authorization") String str, @s("conversation_id") String str2, @s("message_id") String str3, @InterfaceC1926a LikeBody likeBody, c<? super r> cVar);

    @f("v1/bots/{bot_id}")
    Object getAgentDetail(@i("Authorization") String str, @s("bot_id") String str2, @t("is_published") boolean z10, c<? super AgentDetailResult> cVar);

    @o("v1/files/upload")
    @l
    Object uploadFile(@i("Authorization") String str, @q C c, c<? super UploadFileResult> cVar);
}
