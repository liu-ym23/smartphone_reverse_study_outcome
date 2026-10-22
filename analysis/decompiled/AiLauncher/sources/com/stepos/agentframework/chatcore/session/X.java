package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import u4.AgentTask;
import u4.AgentTaskComplete;
import u4.AgentTaskError;
import u4.AgentTaskEvent;
import u4.AgentTaskPlan;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/X;", "", "Lu4/i;", "task", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lu4/i;)V", "", "sessionId", "Lu4/e;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lu4/e;)V", "Lu4/f;", "c", "(Ljava/lang/String;Lu4/f;)V", "Lu4/g;", "e", "(Ljava/lang/String;Lu4/g;)V", "Lu4/h;", "event", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lu4/h;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface X {
    void a(AgentTaskPlan task);

    default void b(String sessionId, AgentTaskEvent event) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(event, "event");
    }

    void c(String sessionId, AgentTaskComplete task);

    void d(String sessionId, AgentTask task);

    void e(String sessionId, AgentTaskError task);
}
