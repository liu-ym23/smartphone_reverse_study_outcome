package com.stepos.agentframework.chatcore.session.db;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import w4.MessageSearchProjectionEntity;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH'¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH'¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H'¢\u0006\u0004\b\u001d\u0010\u001c¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/I0;", "", "Lw4/g;", "projection", "LY8/t;", "f", "(Lw4/g;)V", "", "projections", Const.INTENT_KEY_UMID, "(Ljava/util/List;)V", "", "pattern", "", "limit", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;I)Ljava/util/List;", "sessionIds", "perSessionLimit", "maxTextLength", "Lcom/stepos/agentframework/chatcore/session/db/V0;", "e", "(Ljava/util/List;II)Ljava/util/List;", "oldSessionId", "newSessionId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "c", "()V", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface I0 {
    void a();

    void b(String oldSessionId, String newSessionId);

    void c();

    void d(List<MessageSearchProjectionEntity> projections);

    List<SessionOpeningMessageRow> e(List<String> sessionIds, int perSessionLimit, int maxTextLength);

    void f(MessageSearchProjectionEntity projection);

    List<MessageSearchProjectionEntity> g(String pattern, int limit);
}
