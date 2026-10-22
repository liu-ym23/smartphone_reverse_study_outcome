package g4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lg4/g;", "", "<init>", "()V", "", "CONVERSATION_CHAT_CREATED", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "CONVERSATION_CHAT_IN_PROGRESS", Const.INTENT_KEY_UMID, "CONVERSATION_MESSAGE_DELTA", Const.INTENT_KEY_BACKGROUND_COMMAND, "CONVERSATION_MESSAGE_COMPLETED", "f", "CONVERSATION_CHAT_COMPLETED", Const.INTENT_KEY_APIKEY, "CONVERSATION_CHAT_REQUIRES_ACTION", "e", "CONVERSATION_CHAT_FAILED", "c", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: g4.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4102g {
    public static final C4102g INSTANCE = new C4102g();
    private static final String CONVERSATION_CHAT_CREATED = "conversation.chat.created";
    private static final String CONVERSATION_CHAT_IN_PROGRESS = "conversation.chat.in_progress";
    private static final String CONVERSATION_MESSAGE_DELTA = "conversation.message.delta";
    private static final String CONVERSATION_MESSAGE_COMPLETED = "conversation.message.completed";
    private static final String CONVERSATION_CHAT_COMPLETED = "conversation.chat.completed";
    private static final String CONVERSATION_CHAT_REQUIRES_ACTION = "conversation.chat.requires_action";
    private static final String CONVERSATION_CHAT_FAILED = "conversation.chat.failed";

    public final String a() {
        return CONVERSATION_CHAT_COMPLETED;
    }

    public final String b() {
        return CONVERSATION_CHAT_CREATED;
    }

    public final String c() {
        return CONVERSATION_CHAT_FAILED;
    }

    public final String d() {
        return CONVERSATION_CHAT_IN_PROGRESS;
    }

    public final String e() {
        return CONVERSATION_CHAT_REQUIRES_ACTION;
    }

    public final String f() {
        return CONVERSATION_MESSAGE_COMPLETED;
    }

    public final String g() {
        return CONVERSATION_MESSAGE_DELTA;
    }
}
