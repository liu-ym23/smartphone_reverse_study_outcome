package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "", "", "code", "<init>", "(Ljava/lang/String;II)V", "I", "getCode", "()I", "Companion", Const.INTENT_KEY_APIKEY, ModelFlowMeta.PLAN_NONE, "RISK", "PRIVACY", "STOPPED", "TIMEOUT", "AGENT_OFFLINE", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChatHintType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ChatHintType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int code;
    public static final ChatHintType NONE = new ChatHintType(ModelFlowMeta.PLAN_NONE, 0, 0);
    public static final ChatHintType RISK = new ChatHintType("RISK", 1, 1);
    public static final ChatHintType PRIVACY = new ChatHintType("PRIVACY", 2, 2);
    public static final ChatHintType STOPPED = new ChatHintType("STOPPED", 3, 3);
    public static final ChatHintType TIMEOUT = new ChatHintType("TIMEOUT", 4, 4);
    public static final ChatHintType AGENT_OFFLINE = new ChatHintType("AGENT_OFFLINE", 5, 5);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ChatHintType$a;", "", "<init>", "()V", "", "code", "Lcom/stepos/agentframework/chatcore/session/ChatHintType;", Const.INTENT_KEY_APIKEY, "(I)Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.ChatHintType$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ChatHintType a(int code) {
            ChatHintType next;
            Iterator<ChatHintType> it = ChatHintType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getCode() == code) {
                    break;
                }
            }
            ChatHintType chatHintType = next;
            return chatHintType == null ? ChatHintType.NONE : chatHintType;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ ChatHintType[] $values() {
        return new ChatHintType[]{NONE, RISK, PRIVACY, STOPPED, TIMEOUT, AGENT_OFFLINE};
    }

    static {
        ChatHintType[] chatHintTypeArr$values = $values();
        $VALUES = chatHintTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(chatHintTypeArr$values);
        INSTANCE = new Companion(null);
    }

    private ChatHintType(String str, int i10, int i11) {
        this.code = i11;
    }

    public static InterfaceC4149a<ChatHintType> getEntries() {
        return $ENTRIES;
    }

    public static ChatHintType valueOf(String str) {
        return (ChatHintType) Enum.valueOf(ChatHintType.class, str);
    }

    public static ChatHintType[] values() {
        return (ChatHintType[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
