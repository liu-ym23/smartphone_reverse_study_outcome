package com.stepos.agentframework.adapter.coze;

import Ac.i;
import Ac.l;
import Ac.o;
import Ac.q;
import Ac.s;
import Ac.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.coze.bean.AgentDetailResult;
import com.stepos.agentframework.adapter.coze.bean.CreateConversationResult;
import com.stepos.agentframework.adapter.coze.bean.UploadFileResult;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import e9.InterfaceC4014c;
import g4.C4103h;
import g4.CreateConversation;
import kotlin.Metadata;
import tb.y;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0007J$\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\tH§@¢\u0006\u0004\b\f\u0010\rJ<\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0010H§@¢\u0006\u0004\b\u0013\u0010\u0014J.\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0003\u0010\u0017\u001a\u00020\u0016H§@¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/a;", "", "", "secretKey", "Lg4/d;", "body", "Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lg4/d;Le9/c;)Ljava/lang/Object;", "Ltb/y$c;", Const.STR_FILE, "Lcom/stepos/agentframework/adapter/coze/bean/UploadFileResult;", "e", "(Ljava/lang/String;Ltb/y$c;Le9/c;)Ljava/lang/Object;", "conversationId", "messageId", "Lg4/h;", "feedBack", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lg4/h;Le9/c;)Ljava/lang/Object;", "botId", "", "isPublished", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;ZLe9/c;)Ljava/lang/Object;", "Companion", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface a {
    public static final String CHAT_PATH = "v3/chat";
    public static final String CHAT_SUBMIT_TOOL_OUTPUTS = "v3/chat/submit_tool_outputs";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/a$a;", "", "<init>", "()V", "", "CHAT_PATH", "Ljava/lang/String;", "CHAT_SUBMIT_TOOL_OUTPUTS", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.coze.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CHAT_PATH = "v3/chat";
        public static final String CHAT_SUBMIT_TOOL_OUTPUTS = "v3/chat/submit_tool_outputs";
    }

    static /* synthetic */ Object c(a aVar, String str, String str2, boolean z10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAgentDetail");
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return aVar.b(str, str2, z10, interfaceC4014c);
    }

    @o("v1/conversation/create")
    Object a(@i("Authorization") String str, @Ac.a CreateConversation createConversation, InterfaceC4014c<? super CreateConversationResult> interfaceC4014c);

    @Ac.f("v1/bots/{bot_id}")
    Object b(@i("Authorization") String str, @s("bot_id") String str2, @t("is_published") boolean z10, InterfaceC4014c<? super AgentDetailResult> interfaceC4014c);

    @o("v1/conversations/{conversation_id}/messages/{message_id}/feedback")
    Object d(@i("Authorization") String str, @s("conversation_id") String str2, @s(RequestParameter.META_KEY_MESSAGE_ID) String str3, @Ac.a C4103h c4103h, InterfaceC4014c<? super Y8.t> interfaceC4014c);

    @l
    @o("v1/files/upload")
    Object e(@i("Authorization") String str, @q y.c cVar, InterfaceC4014c<? super UploadFileResult> interfaceC4014c);
}
