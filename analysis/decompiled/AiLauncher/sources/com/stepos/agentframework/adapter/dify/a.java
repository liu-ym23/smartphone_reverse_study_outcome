package com.stepos.agentframework.adapter.dify;

import Ac.f;
import Ac.i;
import Ac.s;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.agents.y;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \b2\u00020\u0001:\u0001\u0006J$\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/a;", "", "", "secretKey", "messageId", "Lj4/d;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Companion", "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface a {
    public static final String CHAT_PATH = "v1/chat-messages";
    public static final String COMPLETION_PATH = "v1/completion-messages";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/a$a;", "", "<init>", "()V", "", "CHAT_PATH", "Ljava/lang/String;", "COMPLETION_PATH", "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.dify.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CHAT_PATH = "v1/chat-messages";
        public static final String COMPLETION_PATH = "v1/completion-messages";
    }

    @f("v1/messages/{message_id}/suggested")
    Object a(@i("Authorization") String str, @s(y.META_KEY_MESSAGE_ID) String str2, InterfaceC4014c<? super j4.d> interfaceC4014c);
}
