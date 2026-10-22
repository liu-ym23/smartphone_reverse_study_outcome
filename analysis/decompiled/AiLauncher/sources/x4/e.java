package x4;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\rH&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b \u0010\u001fJ\u001f\u0010!\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b!\u0010\u001fJ'\u0010#\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H&¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0002H&¢\u0006\u0004\b'\u0010(J'\u0010*\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0015H&¢\u0006\u0004\b*\u0010+J)\u0010-\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\rH&¢\u0006\u0004\b-\u0010.J)\u00100\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\rH&¢\u0006\u0004\b0\u0010.J\u000f\u00101\u001a\u00020\u0011H&¢\u0006\u0004\b1\u00102¨\u00063À\u0006\u0003"}, d2 = {"Lx4/e;", "", "", "sessionId", "Lw4/e;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Lw4/e;", "agentId", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/util/List;", "l", "()Ljava/util/List;", "", "r", "(Ljava/lang/String;)J", "title", "LY8/t;", "m", "(Lw4/e;)V", "tempSessionId", "", "useOpenClawSessionKindRules", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "lastReadAt", "q", "(Ljava/lang/String;Ljava/lang/String;J)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;)V", "p", "(Ljava/lang/String;Ljava/lang/String;)Z", "s", "k", "newTitle", "t", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "label", "Lx4/a;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Lx4/a;", "failed", "o", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "lastActiveAt", "u", "(Ljava/lang/String;Ljava/lang/String;J)Z", "at", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "()V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface e {
    void a();

    InterfaceC5848a b(String sessionId, String label);

    w4.e g(String sessionId);

    void h(String agentId, String sessionId);

    boolean i(String agentId, String sessionId, long at);

    List<w4.e> j(String agentId);

    boolean k(String agentId, String sessionId);

    List<w4.e> l();

    void m(w4.e title);

    void n(String agentId, String tempSessionId, String sessionId, boolean useOpenClawSessionKindRules);

    boolean o(String agentId, String sessionId, boolean failed);

    boolean p(String agentId, String sessionId);

    void q(String agentId, String sessionId, long lastReadAt);

    long r(String agentId);

    boolean s(String agentId, String sessionId);

    void t(String agentId, String sessionId, String newTitle);

    boolean u(String agentId, String sessionId, long lastActiveAt);
}
