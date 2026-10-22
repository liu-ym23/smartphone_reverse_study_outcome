package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentSession;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J;\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJC\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\r\u0010\u000eJI\u0010\u0012\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/Y;", "", "", "message", "", "meta", "Lcom/stepos/agentframework/chatcore/session/AgentSession$c;", "bizCallback", "LY8/t;", "c", "(Ljava/lang/String;Ljava/util/Map;Lcom/stepos/agentframework/chatcore/session/AgentSession$c;)V", "", "deepThinking", "f", "(Ljava/lang/String;ZLjava/util/Map;Lcom/stepos/agentframework/chatcore/session/AgentSession$c;)V", "", "Lu4/m;", "messages", Const.INTENT_KEY_UMID, "(Ljava/util/List;ZLjava/util/Map;Lcom/stepos/agentframework/chatcore/session/AgentSession$c;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Y {
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void a(Y y10, String str, Map map, AgentSession.c cVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendTextMessage");
        }
        if ((i10 & 2) != 0) {
            map = null;
        }
        if ((i10 & 4) != 0) {
            cVar = null;
        }
        y10.c(str, map, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void b(Y y10, List list, boolean z10, Map map, AgentSession.c cVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: request");
        }
        if ((i10 & 4) != 0) {
            map = null;
        }
        if ((i10 & 8) != 0) {
            cVar = null;
        }
        y10.d(list, z10, map, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void e(Y y10, String str, boolean z10, Map map, AgentSession.c cVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendTextMessage");
        }
        if ((i10 & 4) != 0) {
            map = null;
        }
        if ((i10 & 8) != 0) {
            cVar = null;
        }
        y10.f(str, z10, map, cVar);
    }

    void c(String message, Map<String, String> meta, AgentSession.c bizCallback);

    void d(List<? extends u4.m> messages, boolean deepThinking, Map<String, String> meta, AgentSession.c bizCallback);

    void f(String message, boolean deepThinking, Map<String, String> meta, AgentSession.c bizCallback);
}
