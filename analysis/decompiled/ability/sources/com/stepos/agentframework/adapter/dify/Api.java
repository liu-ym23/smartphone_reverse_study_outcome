package com.stepos.agentframework.adapter.dify;

import C7.r;
import H7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.dify.bean.BlockingResult;
import com.stepos.agentframework.adapter.dify.bean.CompletionRequestBody;
import com.stepos.agentframework.adapter.dify.bean.LikeBody;
import com.stepos.agentframework.adapter.dify.bean.SuggestResult;
import kotlin.Metadata;
import sa.InterfaceC1926a;
import sa.f;
import sa.i;
import sa.o;
import sa.s;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u000b\u001a\u00020\nH§@¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u0007H§@¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/Api;", "", "Lcom/stepos/agentframework/adapter/dify/bean/CompletionRequestBody;", "completionRequestBody", "Lcom/stepos/agentframework/adapter/dify/bean/BlockingResult;", "chatMessagesBlock", "(Lcom/stepos/agentframework/adapter/dify/bean/CompletionRequestBody;LH7/c;)Ljava/lang/Object;", "", "secretKey", "messageId", "Lcom/stepos/agentframework/adapter/dify/bean/LikeBody;", "likeBody", "LC7/r;", "feedbacks", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/dify/bean/LikeBody;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/dify/bean/SuggestResult;", "suggested", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Companion", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Api {
    public static final String CHAT_PATH = "v1/chat-messages";
    public static final String COMPLETION_PATH = "v1/completion-messages";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/Api$Companion;", "", AppAgent.CONSTRUCT, "()V", "CHAT_PATH", "", "COMPLETION_PATH", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CHAT_PATH = "v1/chat-messages";
        public static final String COMPLETION_PATH = "v1/completion-messages";

        private Companion() {
        }
    }

    @o("v1/completion-messages")
    Object chatMessagesBlock(@InterfaceC1926a CompletionRequestBody completionRequestBody, c<? super BlockingResult> cVar);

    @o("v1/messages/{message_id}/feedbacks")
    Object feedbacks(@i("Authorization") String str, @s("message_id") String str2, @InterfaceC1926a LikeBody likeBody, c<? super r> cVar);

    @f("v1/messages/{message_id}/suggested")
    Object suggested(@i("Authorization") String str, @s("message_id") String str2, c<? super SuggestResult> cVar);
}
