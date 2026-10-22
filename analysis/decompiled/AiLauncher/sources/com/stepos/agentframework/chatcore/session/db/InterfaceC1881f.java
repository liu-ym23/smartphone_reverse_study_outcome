package com.stepos.agentframework.chatcore.session.db;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import java.util.List;
import kotlin.Metadata;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nH'¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H'¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0007H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u001c\u001a\u00020\nH'¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0007H'¢\u0006\u0004\b\u001f\u0010 J5\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0007H'¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\nH'¢\u0006\u0004\b(\u0010'J\u0019\u0010)\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\nH'¢\u0006\u0004\b)\u0010\rJ\u0019\u0010*\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\nH'¢\u0006\u0004\b*\u0010\rJ\u0019\u0010+\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\nH'¢\u0006\u0004\b+\u0010\rJ\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010,\u001a\u00020!H'¢\u0006\u0004\b-\u0010.J\u0011\u0010/\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u00020\u00042\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH'¢\u0006\u0004\b3\u00104J\u001f\u00107\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00106\u001a\u000205H'¢\u0006\u0004\b7\u00108J%\u0010;\u001a\u00020\u00072\f\u00109\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010:\u001a\u00020\u0013H'¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\nH'¢\u0006\u0004\b>\u0010?J\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u0010H'¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0007H'¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0004H'¢\u0006\u0004\bE\u0010F¨\u0006GÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/f;", "", "Lw4/c;", "chatMessage", "LY8/t;", "q", "(Lw4/c;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lw4/c;)I", "", "messageId", "p", "(Ljava/lang/String;)Lw4/c;", "pairId", "userRole", "", "u", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "", Const.INTENT_KEY_UMID, "()Z", "sessionIds", "x", "(Ljava/util/List;)Ljava/util/List;", "limit", "r", "(I)Ljava/util/List;", "sessionId", "y", "(Ljava/lang/String;)Ljava/util/List;", "n", "(Ljava/lang/String;I)Ljava/util/List;", "", "beforeTime", "beforeMessageId", "v", "(Ljava/lang/String;JLjava/lang/String;I)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", "k", "m", "z", "l", "sinceTime", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(J)Ljava/util/List;", "t", "()Lw4/c;", "oldSessionId", "newSessionId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "hint", "f", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/ChatHintType;)V", "messageIds", "failed", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;Z)I", "requestId", "s", "(Ljava/lang/String;)I", "Lcom/stepos/agentframework/chatcore/session/db/B0;", "o", "()Ljava/util/List;", "c", "()I", Const.INTENT_KEY_APIKEY, "()V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.db.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC1881f {
    static /* synthetic */ List w(InterfaceC1881f interfaceC1881f, String str, String str2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPairUserMessageById");
        }
        if ((i10 & 2) != 0) {
            str2 = "USER";
        }
        return interfaceC1881f.u(str, str2);
    }

    void a();

    void b(String oldSessionId, String newSessionId);

    int c();

    boolean d();

    void f(String messageId, ChatHintType hint);

    void g(String messageId);

    int h(List<String> messageIds, boolean failed);

    List<String> i(long sinceTime);

    int j(ChatMessage chatMessage);

    void k(String sessionId);

    ChatMessage l(String sessionId);

    ChatMessage m(String sessionId);

    List<ChatMessage> n(String sessionId, int limit);

    List<InterruptedRoundRow> o();

    ChatMessage p(String messageId);

    void q(ChatMessage chatMessage);

    List<ChatMessage> r(int limit);

    int s(String requestId);

    ChatMessage t();

    List<ChatMessage> u(String pairId, String userRole);

    List<ChatMessage> v(String sessionId, long beforeTime, String beforeMessageId, int limit);

    List<String> x(List<String> sessionIds);

    List<ChatMessage> y(String sessionId);

    ChatMessage z(String sessionId);
}
