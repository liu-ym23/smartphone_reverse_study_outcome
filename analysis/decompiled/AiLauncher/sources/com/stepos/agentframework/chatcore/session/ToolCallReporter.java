package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentcache.sdk.api.LogLevel;
import com.stepos.agentcache.sdk.api.LogMessage;
import com.stepos.agentframework.chatcore.C1846a;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import h8.C4148a;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0012\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ToolCallReporter;", "", "<init>", "()V", "", "sessionId", "Lw4/c;", "message", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lw4/c;Lcom/stepos/agentframework/chatcore/intent/e;)V", "TAG", "Ljava/lang/String;", "", "MAX_ENTRIES", "I", "com/stepos/agentframework/chatcore/session/ToolCallReporter$reported$1", "reported", "Lcom/stepos/agentframework/chatcore/session/ToolCallReporter$reported$1;", "Lcom/stepos/agentframework/chatcore/a;", "chatReporter", "Lcom/stepos/agentframework/chatcore/a;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ToolCallReporter {
    private static final int MAX_ENTRIES = 512;
    private static final String TAG = "ToolCallReporter";
    public static final ToolCallReporter INSTANCE = new ToolCallReporter();
    private static final ToolCallReporter$reported$1 reported = new LinkedHashMap<String, Boolean>() { // from class: com.stepos.agentframework.chatcore.session.ToolCallReporter$reported$1
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return d((String) obj);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Boolean) {
                return g((Boolean) obj);
            }
            return false;
        }

        public /* bridge */ boolean d(String str) {
            return super.containsKey(str);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Boolean>> entrySet() {
            return i();
        }

        public /* bridge */ boolean g(Boolean bool) {
            return super.containsValue(bool);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return h((String) obj);
            }
            return null;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : n((String) obj, (Boolean) obj2);
        }

        public /* bridge */ Boolean h(String str) {
            return (Boolean) super.get(str);
        }

        public /* bridge */ Set<Map.Entry<String, Boolean>> i() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> j() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return j();
        }

        public /* bridge */ Boolean n(String str, Boolean bool) {
            return (Boolean) super.getOrDefault(str, bool);
        }

        public /* bridge */ int q() {
            return super.size();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return t((String) obj);
            }
            return null;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
            return size() > 512;
        }

        public /* bridge */ Collection<Boolean> s() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return q();
        }

        public /* bridge */ Boolean t(String str) {
            return (Boolean) super.remove(str);
        }

        public /* bridge */ boolean u(String str, Boolean bool) {
            return super.remove(str, bool);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Boolean> values() {
            return s();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof Boolean)) {
                return u((String) obj, (Boolean) obj2);
            }
            return false;
        }
    };
    private static final C1846a chatReporter = new C1846a();

    public final void a(String sessionId, ChatMessage message, AgentTool tool) {
        Object objB;
        String sessionId2 = sessionId;
        kotlin.jvm.internal.p.i(sessionId2, "sessionId");
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(tool, "tool");
        String toolCallId = tool.getToolCallId();
        if (toolCallId.length() == 0 || tool.getIsUpdate() || tool.getName().length() == 0) {
            return;
        }
        String traceId = message.getTraceId();
        if (traceId.length() == 0) {
            C4148a.u(TAG, "skip: no traceId, toolCallId=" + toolCallId + " name=" + tool.getName(), false, 4, null);
            return;
        }
        String str = sessionId2 + "|" + toolCallId;
        ToolCallReporter$reported$1 toolCallReporter$reported$1 = reported;
        synchronized (toolCallReporter$reported$1) {
            if (toolCallReporter$reported$1.put(str, Boolean.TRUE) != null) {
                return;
            }
            Y8.t tVar = Y8.t.f7040a;
            Map<String, ? extends Object> mapM = kotlin.collections.a.m(Y8.j.a("tool_name", tool.getName()), Y8.j.a("tool_call_id", toolCallId));
            Pair pairA = Y8.j.a("tool_name", tool.getName());
            Pair pairA2 = Y8.j.a("tool_call_id", toolCallId);
            Pair pairA3 = Y8.j.a("msg_type", "trace_log");
            Pair pairA4 = Y8.j.a("msg_id", message.getMessageId());
            Pair pairA5 = Y8.j.a("agent_id", message.getAgentId());
            if (sessionId2.length() == 0) {
                sessionId2 = message.getSessionId();
            }
            Map mapM2 = kotlin.collections.a.m(pairA, pairA2, pairA3, pairA4, pairA5, Y8.j.a("session_id", sessionId2));
            C4148a.k(TAG, "report traceId=" + traceId + " toolCallId=" + toolCallId + " name=" + tool.getName(), false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                C1846a c1846a = chatReporter;
                c1846a.a(traceId, "agent_bus_task", mapM);
                C1846a.c(c1846a, traceId, "agent_bus_task", new LogMessage(LogLevel.INFO, "trace_log", com.stepos.agentframework.adapter.netcore.j.b(mapM2), null, 8, null), 0, 8, null);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "report failed: " + thE.getMessage(), false, 4, null);
            }
        }
    }
}
