package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ConversationSessionKind;", "", "", "code", "<init>", "(Ljava/lang/String;II)V", "I", "getCode", "()I", "Companion", Const.INTENT_KEY_APIKEY, "NORMAL", "MAIN", "CHANNEL", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConversationSessionKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ConversationSessionKind[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int code;
    public static final ConversationSessionKind NORMAL = new ConversationSessionKind("NORMAL", 0, 0);
    public static final ConversationSessionKind MAIN = new ConversationSessionKind("MAIN", 1, 1);
    public static final ConversationSessionKind CHANNEL = new ConversationSessionKind("CHANNEL", 2, 2);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ConversationSessionKind$a;", "", "<init>", "()V", "", "code", "Lcom/stepos/agentframework/chatcore/session/ConversationSessionKind;", Const.INTENT_KEY_APIKEY, "(I)Lcom/stepos/agentframework/chatcore/session/ConversationSessionKind;", "", "sessionId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/ConversationSessionKind;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.ConversationSessionKind$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ConversationSessionKind a(int code) {
            ConversationSessionKind next;
            Iterator<ConversationSessionKind> it = ConversationSessionKind.getEntries().iterator();
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
            ConversationSessionKind conversationSessionKind = next;
            return conversationSessionKind == null ? ConversationSessionKind.NORMAL : conversationSessionKind;
        }

        public final ConversationSessionKind b(String sessionId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            if (sessionId.length() == 0) {
                return ConversationSessionKind.NORMAL;
            }
            if (kotlin.jvm.internal.p.d(sessionId, ConversationSessionIds.MAIN_SESSION_ID)) {
                return ConversationSessionKind.MAIN;
            }
            if (!La.D.X(sessionId, ConversationSessionIds.CHANNEL_WECHAT_PREFIX, false, 2, null) && !La.D.X(sessionId, ConversationSessionIds.CHANNEL_FEISHU_PREFIX, false, 2, null)) {
                return ConversationSessionKind.NORMAL;
            }
            return ConversationSessionKind.CHANNEL;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ ConversationSessionKind[] $values() {
        return new ConversationSessionKind[]{NORMAL, MAIN, CHANNEL};
    }

    static {
        ConversationSessionKind[] conversationSessionKindArr$values = $values();
        $VALUES = conversationSessionKindArr$values;
        $ENTRIES = kotlin.enums.a.a(conversationSessionKindArr$values);
        INSTANCE = new Companion(null);
    }

    private ConversationSessionKind(String str, int i10, int i11) {
        this.code = i11;
    }

    public static InterfaceC4149a<ConversationSessionKind> getEntries() {
        return $ENTRIES;
    }

    public static ConversationSessionKind valueOf(String str) {
        return (ConversationSessionKind) Enum.valueOf(ConversationSessionKind.class, str);
    }

    public static ConversationSessionKind[] values() {
        return (ConversationSessionKind[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
