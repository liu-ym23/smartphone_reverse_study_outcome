package com.stepos.agentframework.chatcore.session.db;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0015\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u000eH'¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'¢\u0006\u0004\b\u001a\u0010\tJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000eH'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000eH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000eH'¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000eH'¢\u0006\u0004\b \u0010\u001eJ\u001f\u0010!\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b%\u0010\"J\u001f\u0010'\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000bH'¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020)H'¢\u0006\u0004\b+\u0010,J'\u00100\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020)H'¢\u0006\u0004\b0\u00101J\u001f\u00102\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020)H'¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u0010H'¢\u0006\u0004\b5\u00106J\u001f\u00108\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u000bH'¢\u0006\u0004\b8\u00109J\u001f\u0010;\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000bH'¢\u0006\u0004\b;\u00109J\u000f\u0010<\u001a\u00020\u0004H'¢\u0006\u0004\b<\u0010=¨\u0006>À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/Q;", "", "Lw4/e;", "title", "LY8/t;", "r", "(Lw4/e;)V", "", "q", "()Ljava/util/List;", "v", "", "p", "()J", "", "titlePattern", "", "limit", "e", "(Ljava/lang/String;I)Ljava/util/List;", "sessionIds", "u", "(Ljava/util/List;)Ljava/util/List;", "sessionId", "c", "(Ljava/lang/String;)Lw4/e;", "w", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", "o", "(Ljava/lang/String;)I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "n", "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)I", "f", "lastReadAt", "k", "(Ljava/lang/String;J)V", "", "failed", "t", "(Ljava/lang/String;Z)I", "oldSessionId", "newSessionId", "isTempSession", "l", "(Ljava/lang/String;Ljava/lang/String;Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Z)V", "sessionKind", Const.INTENT_KEY_UMID, "(Ljava/lang/String;I)V", "lastActiveAt", "m", "(Ljava/lang/String;J)I", "at", "s", Const.INTENT_KEY_APIKEY, "()V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Q {
    void a();

    int b(String sessionId, String title);

    w4.e c(String sessionId);

    void d(String sessionId, int sessionKind);

    List<w4.e> e(String titlePattern, int limit);

    void f(String sessionId, String title);

    void g(String sessionId);

    int h(String sessionId);

    int i(String sessionId);

    void j(String sessionId, boolean isTempSession);

    void k(String sessionId, long lastReadAt);

    void l(String oldSessionId, String newSessionId, boolean isTempSession);

    int m(String sessionId, long lastActiveAt);

    void n(String sessionId, String title);

    int o(String sessionId);

    long p();

    List<w4.e> q();

    void r(w4.e title);

    int s(String sessionId, long at);

    int t(String sessionId, boolean failed);

    List<w4.e> u(List<String> sessionIds);

    List<w4.e> v();

    List<w4.e> w();
}
