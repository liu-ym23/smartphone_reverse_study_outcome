package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.ReferenceSource;
import u4.AgentModeration;
import u4.AgentResponse;
import u4.AgentTask;
import u4.AgentTaskComplete;
import u4.AgentTaskError;
import u4.AgentTaskPlan;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010 \u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J%\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00022\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016¢\u0006\u0004\b*\u0010+J'\u0010.\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010/J+\u00105\u001a\u00020\u00042\u0006\u00101\u001a\u0002002\b\u00103\u001a\u0004\u0018\u0001022\b\u00104\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0004H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0004H\u0016¢\u0006\u0004\b9\u00108¨\u0006:À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/W;", "", "", "sessionId", "LY8/t;", "onSessionCreated", "(Ljava/lang/String;)V", "Lu4/d;", UxipConstants.f30685x, "l", "(Lu4/d;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lcom/stepos/agentframework/chatcore/session/AgentError;", "error", "c", "(Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "Lu4/i;", "task", Const.INTENT_KEY_APIKEY, "(Lu4/i;)V", "Lu4/e;", "f", "(Lu4/e;)V", "Lu4/f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lu4/f;)V", "Lu4/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lu4/g;)V", "", "Lcom/stepos/agentframework/chatcore/intent/e;", "tools", "k", "(Ljava/util/List;)V", "Lu4/c;", "moderation", Const.INTENT_KEY_UMID, "(Lu4/c;)V", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "", "LK6/A;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/util/List;)V", "name", "resultJson", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "success", "", "code", "message", Const.INTENT_KEY_PKGNAME, "(ZLjava/lang/Integer;Ljava/lang/String;)V", "n", "()V", "e", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface W {
    void a(AgentTaskPlan task);

    default void b(boolean success, Integer code, String message) {
    }

    void c(AgentError error);

    void d(AgentModeration moderation);

    default void e() {
    }

    void f(AgentTask task);

    default void g(String runId, List<ReferenceSource> sources) {
        kotlin.jvm.internal.p.i(runId, "runId");
        kotlin.jvm.internal.p.i(sources, "sources");
    }

    void h(AgentTaskComplete task);

    void i(AgentTaskError task);

    void j(AgentResponse response);

    void k(List<AgentTool> tools);

    void l(AgentResponse response);

    default void m(String runId, String name, String resultJson) {
        kotlin.jvm.internal.p.i(runId, "runId");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(resultJson, "resultJson");
    }

    default void n() {
    }

    void onSessionCreated(String sessionId);
}
