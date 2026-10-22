package com.stepos.ability.report;

import P3.c;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.init.IInit;
import com.stepos.ability.commoninternal.AgentCache;
import com.stepos.ability.commoninternal.Key;
import com.stepos.ability.report.event.AgentCacheTaskEvent;
import com.stepos.ability.report.event.LogEvent;
import com.stepos.ability.report.event.ToolCallRequestEvent;
import com.stepos.ability.report.event.ToolCallResponseEvent;
import com.stepos.agentcache.sdk.api.AgentCacheConfig;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.agentcache.sdk.api.AgentCacheSendResult;
import com.stepos.agentcache.sdk.api.LogLevel;
import com.stepos.agentcache.sdk.api.LogMessage;
import j9.m;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.GuiAgentConfigKt;
import stepai.android.llm.base.twoway.FlowType;
import t4.a;
import t4.b;

@Singleton
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d*\u00020\u000f¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d*\u00020\u000f¢\u0006\u0004\b\"\u0010!J\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d*\u00020\u0014¢\u0006\u0004\b \u0010#J\u001d\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d*\u00020\u0014¢\u0006\u0004\b\"\u0010#J\u0011\u0010%\u001a\u00020$*\u00020\u0017¢\u0006\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/stepos/ability/report/ReportManager;", "Lcom/stepos/ability/report/IReportManager;", "Lcom/stepos/ability/api/init/IInit;", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/ability/report/event/LogLevel;", "level", "Lcom/stepos/agentcache/sdk/api/LogLevel;", "getLogLevel", "(Lcom/stepos/ability/report/event/LogLevel;)Lcom/stepos/agentcache/sdk/api/LogLevel;", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "Lcom/stepos/ability/report/event/ToolCallRequestEvent;", NotificationCompat.CATEGORY_EVENT, "", "reportToolCallRequestEvent", "(Lcom/stepos/ability/report/event/ToolCallRequestEvent;)Z", "Lcom/stepos/ability/report/event/ToolCallResponseEvent;", "reportToolCallResponseEvent", "(Lcom/stepos/ability/report/event/ToolCallResponseEvent;)Z", "Lcom/stepos/ability/report/event/LogEvent;", "reportLogEvent", "(Lcom/stepos/ability/report/event/LogEvent;)Z", "Lcom/stepos/ability/report/event/AgentCacheTaskEvent;", "reportTaskEvent", "(Lcom/stepos/ability/report/event/AgentCacheTaskEvent;)Z", "", "", "", "toCommonFieldMap", "(Lcom/stepos/ability/report/event/ToolCallRequestEvent;)Ljava/util/Map;", "toBizDataMap", "(Lcom/stepos/ability/report/event/ToolCallResponseEvent;)Ljava/util/Map;", "Lcom/stepos/agentcache/sdk/api/LogMessage;", "toLogMessage", "(Lcom/stepos/ability/report/event/LogEvent;)Lcom/stepos/agentcache/sdk/api/LogMessage;", "Companion", "t4/a", "report_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReportManager implements IReportManager, IInit {
    public static final a Companion = new a();
    private static final String TAG = "ReportManager";

    @Inject
    public ReportManager() {
    }

    private final LogLevel getLogLevel(com.stepos.ability.report.event.LogLevel level) {
        int i = b.f6657a[level.ordinal()];
        if (i == 1) {
            return LogLevel.INFO;
        }
        if (i == 2) {
            return LogLevel.WARN;
        }
        if (i == 3) {
            return LogLevel.ERROR;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(AgentCacheSendResult result) {
        k.f(result, "result");
        c.b(TAG, "report result: " + result);
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        k.f(context, "context");
        AgentCacheSdk agentCacheSdk = AgentCacheSdk.INSTANCE;
        c.b(TAG, "init isInitialized: " + agentCacheSdk.isInitialized());
        if (agentCacheSdk.isInitialized()) {
            return;
        }
        agentCacheSdk.init(context, new AgentCacheConfig(null, 0, false, 3, null), new com.bumptech.glide.load.resource.bitmap.b(12));
        c.b(TAG, "init result isInitialized: " + agentCacheSdk.isInitialized());
    }

    @Override // com.stepos.ability.report.IReportManager
    public boolean reportLogEvent(LogEvent event) {
        k.f(event, "event");
        AgentCacheSdk agentCacheSdk = AgentCacheSdk.INSTANCE;
        c.b(TAG, "report isInitialized: " + agentCacheSdk.isInitialized() + ", logEvent: " + event);
        if (event.getTraceId().length() == 0 || m.s0(event.getTraceId()) || !agentCacheSdk.isInitialized()) {
            return false;
        }
        return agentCacheSdk.reportLog(event.getTraceId(), event.getNodeName(), toLogMessage(event), event.getStatusCode());
    }

    @Override // com.stepos.ability.report.IReportManager
    public boolean reportTaskEvent(AgentCacheTaskEvent event) {
        k.f(event, "event");
        String traceId = event.getTraceId();
        if (traceId == null || traceId.length() == 0) {
            c.f1086a.invoke(5, "Ability_".concat(TAG), "execute: traceId is null", null);
            return false;
        }
        LinkedHashMap linkedHashMapS = kotlin.collections.a.S(new Pair("task_id", event.getTaskId()), new Pair("task_type", event.getType()), new Pair(FlowType.COMPLETED, Boolean.valueOf(event.getComplete())));
        Boolean success = event.getSuccess();
        if (success != null) {
            linkedHashMapS.put("success", success);
        }
        return AgentCacheSdk.reportEvent$default(AgentCacheSdk.INSTANCE, event.getTraceId(), AgentCache.AGENT_CACHE_NODE_NAME, B7.a.x("msg_type", event.getMsgType()), linkedHashMapS, null, null, k.b(event.getSuccess(), Boolean.TRUE) ? 200 : 500, 48, null);
    }

    @Override // com.stepos.ability.report.IReportManager
    public boolean reportToolCallRequestEvent(ToolCallRequestEvent event) {
        k.f(event, "event");
        AgentCacheSdk agentCacheSdk = AgentCacheSdk.INSTANCE;
        c.b(TAG, "report isInitialized: " + agentCacheSdk.isInitialized() + ", requestEvent: " + event);
        if (event.getTraceId().length() == 0 || m.s0(event.getTraceId()) || !agentCacheSdk.isInitialized()) {
            return false;
        }
        return AgentCacheSdk.reportEvent$default(agentCacheSdk, event.getTraceId(), "tool_call", toCommonFieldMap(event), toBizDataMap(event), event.getInput(), null, event.getStatusCode(), 32, null);
    }

    @Override // com.stepos.ability.report.IReportManager
    public boolean reportToolCallResponseEvent(ToolCallResponseEvent event) {
        k.f(event, "event");
        AgentCacheSdk agentCacheSdk = AgentCacheSdk.INSTANCE;
        c.b(TAG, "report isInitialized: " + agentCacheSdk.isInitialized() + ", responseEvent: " + event);
        if (event.getTraceId().length() == 0 || m.s0(event.getTraceId()) || !agentCacheSdk.isInitialized()) {
            return false;
        }
        return AgentCacheSdk.reportEvent$default(agentCacheSdk, event.getTraceId(), "tool_call", toCommonFieldMap(event), toBizDataMap(event), null, event.getOutput(), event.getStatusCode(), 16, null);
    }

    public final Map<String, Object> toBizDataMap(ToolCallRequestEvent toolCallRequestEvent) {
        k.f(toolCallRequestEvent, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(GuiAgentConfigKt.META_KEY_TOOL_CALL_ID, toolCallRequestEvent.getToolCallId());
        linkedHashMap.put("tool_name", toolCallRequestEvent.getToolName());
        linkedHashMap.put(Key.KEY_TOOL_ID, toolCallRequestEvent.getToolId());
        linkedHashMap.put("call_type", toolCallRequestEvent.getCallType().getValue());
        return linkedHashMap;
    }

    public final Map<String, Object> toCommonFieldMap(ToolCallRequestEvent toolCallRequestEvent) {
        k.f(toolCallRequestEvent, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("msg_type", AgentCache.AGENT_CACHE_MSG_TYPE_UP_LINK);
        linkedHashMap.put("session_id", toolCallRequestEvent.getSessionId());
        return linkedHashMap;
    }

    public final LogMessage toLogMessage(LogEvent logEvent) {
        k.f(logEvent, "<this>");
        return new LogMessage(getLogLevel(logEvent.getLevel()), logEvent.getType().getValue(), logEvent.getLog(), logEvent.getStack());
    }

    public final Map<String, Object> toCommonFieldMap(ToolCallResponseEvent toolCallResponseEvent) {
        k.f(toolCallResponseEvent, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("msg_type", AgentCache.AGENT_CACHE_MSG_TYPE_DOWN_LINK);
        linkedHashMap.put("session_id", toolCallResponseEvent.getSessionId());
        return linkedHashMap;
    }

    public final Map<String, Object> toBizDataMap(ToolCallResponseEvent toolCallResponseEvent) {
        k.f(toolCallResponseEvent, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(GuiAgentConfigKt.META_KEY_TOOL_CALL_ID, toolCallResponseEvent.getToolCallId());
        linkedHashMap.put("tool_name", toolCallResponseEvent.getToolName());
        linkedHashMap.put(Key.KEY_TOOL_ID, toolCallResponseEvent.getToolId());
        linkedHashMap.put("call_type", toolCallResponseEvent.getCallType().getValue());
        return linkedHashMap;
    }
}
