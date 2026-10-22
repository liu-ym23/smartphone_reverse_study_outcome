package x4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import com.stepos.agentframework.chatcore.session.db.InterruptedRoundRow;
import java.util.List;
import kotlin.Metadata;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0013\u001a\u00020\fH&¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J5\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\fH&¢\u0006\u0004\b\u001f\u0010\u0012J\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H&¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H&¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010'\u001a\u00020\u001aH&¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH&¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u0007H&¢\u0006\u0004\b/\u0010!J\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u00100\u001a\u00020\fH&¢\u0006\u0004\b1\u0010\u0015J\u001f\u00104\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u00103\u001a\u000202H&¢\u0006\u0004\b4\u00105J%\u00108\u001a\u00020\u00162\f\u00106\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u00107\u001a\u00020$H&¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\fH&¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fH&¢\u0006\u0004\b<\u0010;J\u000f\u0010=\u001a\u00020\u0004H&¢\u0006\u0004\b=\u0010>J'\u0010A\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\u0016H&¢\u0006\u0004\bA\u0010BJ\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010?\u001a\u00020\fH&¢\u0006\u0004\bC\u0010\u0015J\u001f\u0010E\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\f2\u0006\u0010D\u001a\u00020\u0016H&¢\u0006\u0004\bE\u0010FJ!\u0010I\u001a\u0004\u0018\u00010\u00022\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\u0016H&¢\u0006\u0004\bI\u0010J¨\u0006KÀ\u0006\u0003"}, d2 = {"Lx4/f;", "", "Lw4/c;", "message", "LY8/t;", "t", "(Lw4/c;)V", "", "messages", "k", "(Ljava/util/List;)V", "newMessage", "", "oldMessageId", "n", "(Lw4/c;Ljava/lang/String;)V", "messageId", "v", "(Ljava/lang/String;)Lw4/c;", "sessionId", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/util/List;", "", "limit", "l", "(Ljava/lang/String;I)Ljava/util/List;", "", "beforeTime", "beforeMessageId", "x", "(Ljava/lang/String;JLjava/lang/String;I)Ljava/util/List;", "w", "s", "()Ljava/util/List;", "p", "(I)Ljava/util/List;", "", Const.INTENT_KEY_UMID, "()Z", "sinceTime", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(J)Ljava/util/List;", "oldSessionId", "newSessionId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatcore/session/db/B0;", "c", "pairId", "m", "Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "hint", "f", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/ChatHintType;)V", "messageIds", "failed", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;Z)I", "q", "(Ljava/lang/String;)V", "e", Const.INTENT_KEY_APIKEY, "()V", "groupId", "variantIndex", "u", "(Lw4/c;Ljava/lang/String;I)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "currentIndex", "r", "(Ljava/lang/String;I)I", "activeMessageId", "targetVariantIndex", "o", "(Ljava/lang/String;I)Lw4/c;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface f {
    void a();

    void b(String oldSessionId, String newSessionId);

    List<InterruptedRoundRow> c();

    boolean d();

    void e(String sessionId);

    void f(String messageId, ChatHintType hint);

    List<ChatMessage> g(String sessionId);

    int h(List<String> messageIds, boolean failed);

    List<String> i(long sinceTime);

    List<ChatMessage> j(String groupId);

    void k(List<ChatMessage> messages);

    List<ChatMessage> l(String sessionId, int limit);

    List<ChatMessage> m(String pairId);

    void n(ChatMessage newMessage, String oldMessageId);

    ChatMessage o(String activeMessageId, int targetVariantIndex);

    List<ChatMessage> p(int limit);

    void q(String messageId);

    int r(String groupId, int currentIndex);

    List<ChatMessage> s();

    void t(ChatMessage message);

    void u(ChatMessage message, String groupId, int variantIndex);

    ChatMessage v(String messageId);

    ChatMessage w(String sessionId);

    List<ChatMessage> x(String sessionId, long beforeTime, String beforeMessageId, int limit);
}
