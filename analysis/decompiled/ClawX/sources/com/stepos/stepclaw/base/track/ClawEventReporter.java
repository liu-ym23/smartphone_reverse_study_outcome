package com.stepos.stepclaw.base.track;

import a.a;
import a6.w;
import a8.b;
import android.util.Log;
import b5.a0;
import b5.h;
import b5.i;
import c5.m;
import c5.o;
import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import d5.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m0.f;
import org.bouncycastle.asn1.x509.DisplayText;
import org.json.JSONArray;
import org.json.JSONObject;
import p5.l;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 x2\u00020\u0001:\u0003xyzB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u009b\u0001\u0010\u0019\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ£\u0001\u0010\"\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010!\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\"\u0010#J{\u0010,\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010)\u001a\u0004\u0018\u00010\u00062\u0006\u0010+\u001a\u00020*2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b,\u0010-J-\u0010.\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b.\u0010/JM\u00104\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u00100\u001a\u0004\u0018\u00010\u00062\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001012\b\u00103\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b4\u00105J7\u00106\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u00100\u001a\u0004\u0018\u00010\u00062\b\u00103\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b6\u00107J\u001f\u00109\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b;\u0010\nJ\u000f\u0010<\u001a\u00020\u0006H\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010@J1\u0010A\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bA\u0010BJ%\u0010C\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010=J\u000f\u0010F\u001a\u00020\u0006H\u0002¢\u0006\u0004\bF\u0010=J%\u0010H\u001a\u00020\u00062\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u000101H\u0002¢\u0006\u0004\bH\u0010IJ-\u0010J\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bJ\u0010BJ\u0019\u0010K\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bK\u0010@J\u0017\u0010N\u001a\u00020\b2\u0006\u0010M\u001a\u00020LH\u0002¢\u0006\u0004\bN\u0010OJ9\u0010P\u001a\u0004\u0018\u00010L2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020\b2\u0006\u0010M\u001a\u00020LH\u0002¢\u0006\u0004\bR\u0010OJQ\u0010X\u001a\u00020\b2\u0006\u00108\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u00062\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020T012\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020T012\b\b\u0002\u0010W\u001a\u00020\rH\u0002¢\u0006\u0004\bX\u0010YJ?\u0010Z\u001a\u00020\b2\u0006\u0010S\u001a\u00020\u00062\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020T012\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020T01H\u0002¢\u0006\u0004\bZ\u0010[J%\u0010]\u001a\u0004\u0018\u00010\\2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b]\u0010^J-\u0010_\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b_\u0010BJ\u008b\u0001\u0010b\u001a\u00020\b2\u0006\u00108\u001a\u00020\u00062\b\u0010`\u001a\u0004\u0018\u00010\u00062\u0006\u0010S\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010)\u001a\u0004\u0018\u00010\u00062\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020T01H\u0002¢\u0006\u0004\bb\u0010cJ\u001b\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020T01H\u0002¢\u0006\u0004\bd\u0010eJ\u0019\u0010f\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bf\u0010@J-\u0010h\u001a\u00020g2\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010!\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\bh\u0010iJ\u0019\u0010j\u001a\u00020g2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bj\u0010kJ\u0019\u0010l\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bl\u0010@R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010mR \u0010o\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR \u0010q\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020L0n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010pR,\u0010r\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020T010n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010pRT\u0010u\u001aB\u0012\f\u0012\n t*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n t*\u0004\u0018\u00010\u001d0\u001d t* \u0012\f\u0012\n t*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n t*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010s0s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vRT\u0010w\u001aB\u0012\f\u0012\n t*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n t*\u0004\u0018\u00010\u001d0\u001d t* \u0012\f\u0012\n t*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n t*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010s0s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010v¨\u0006{"}, d2 = {"Lcom/stepos/stepclaw/base/track/ClawEventReporter;", "Lcom/stepos/stepclaw/base/track/ClawReporter;", "Lcom/stepos/stepclaw/base/track/ClawReporterDependencies;", "dependencies", "<init>", "(Lcom/stepos/stepclaw/base/track/ClawReporterDependencies;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sessionId", "Lb5/a0;", "onNewTurn", "(Ljava/lang/String;)V", "runId", "llmRequestId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "requestSeq", ConfigIpcContract.KEY_PROVIDER, ConfigIpcContract.KEY_MODEL, "systemPrompt", "prompt", "finalRequestPayloadJson", "requestEnvelopeJson", "agentId", "agentName", "sessionKey", "hookTraceId", "onLlmInput", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "responseJson", "sessionResponseJson", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "usageFromHook", "usageInput", "usageOutput", "usageCacheRead", "onLlmOutput", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "toolName", "paramsJson", "resultJson", "error", "toolCallId", "outputTextIfNoResult", "Lcom/stepos/stepclaw/base/track/ToolCallReportPhase;", "phase", "onToolCall", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/stepclaw/base/track/ToolCallReportPhase;Ljava/lang/String;Ljava/lang/String;)V", "hasMemorySearchUplinkReported", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "parentSessionId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "subagentConfig", "outputText", "onSkillStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "onSkillEnd", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "traceId", "seedTraceId", "(Ljava/lang/String;Ljava/lang/String;)V", "onSessionReset", "newSessionTraceId", "()Ljava/lang/String;", "raw", "requireTraceId", "(Ljava/lang/String;)Ljava/lang/String;", "resolveTraceIdForReport", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "toolCallNodeNameForReport", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "userId", "appVersion", "config", "subagentConfigAsInputText", "(Ljava/util/Map;)Ljava/lang/String;", "resolveAgentName", "parseAgentIdFromSessionKey", "Lcom/stepos/stepclaw/base/track/ClawEventReporter$LlmInputCache;", "cache", "putLlmInputCache", "(Lcom/stepos/stepclaw/base/track/ClawEventReporter$LlmInputCache;)V", "takeLlmInputCache", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/base/track/ClawEventReporter$LlmInputCache;", "purgeLlmInputCacheAliases", "nodeName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "commonFields", "bizData", "statusCode", "report", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;I)V", "logReportDebugSummary", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "extractTemperature", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Double;", "memorySearchUplinkCompositeKey", "hookSessionId", "bizDataExtras", "emitToolCallPhaseReport", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/stepclaw/base/track/ToolCallReportPhase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "emptySkillBizData", "()Ljava/util/Map;", "resolveCallType", "Lcom/stepos/stepclaw/base/track/ClawEventReporter$TokenUsage;", "tokenUsageFromHook", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/stepos/stepclaw/base/track/ClawEventReporter$TokenUsage;", "parseTokenUsage", "(Ljava/lang/String;)Lcom/stepos/stepclaw/base/track/ClawEventReporter$TokenUsage;", "extractModelOutputDisplayText", "Lcom/stepos/stepclaw/base/track/ClawReporterDependencies;", "Ljava/util/concurrent/ConcurrentHashMap;", "cronTraceIds", "Ljava/util/concurrent/ConcurrentHashMap;", "llmInputCache", "skillBizByScope", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "memorySearchUplinkReportedKeys", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "toolCallDedupKeys", "Companion", "LlmInputCache", "TokenUsage", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ClawEventReporter implements ClawReporter {
    private static final String FALLBACK_AGENT_LABEL = "openclaw";
    private final ConcurrentHashMap<String, String> cronTraceIds;
    private final ClawReporterDependencies dependencies;
    private final ConcurrentHashMap<String, LlmInputCache> llmInputCache;
    private final ConcurrentHashMap.KeySetView<String, Boolean> memorySearchUplinkReportedKeys;
    private final ConcurrentHashMap<String, Map<String, Object>> skillBizByScope;
    private final ConcurrentHashMap.KeySetView<String, Boolean> toolCallDedupKeys;
    private static final String TAG = "ClawEventReporter";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J£\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00064"}, d2 = {"Lcom/stepos/stepclaw/base/track/ClawEventReporter$LlmInputCache;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "runId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "llmRequestId", "sessionId", ConfigIpcContract.KEY_PROVIDER, ConfigIpcContract.KEY_MODEL, "systemPrompt", "prompt", "finalRequestPayloadJson", "requestEnvelopeJson", "agentId", "agentName", "sessionKey", "modelCallNodeName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRunId", "()Ljava/lang/String;", "getLlmRequestId", "getSessionId", "getProvider", "getModel", "getSystemPrompt", "getPrompt", "getFinalRequestPayloadJson", "getRequestEnvelopeJson", "getAgentId", "getAgentName", "getSessionKey", "getModelCallNodeName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LlmInputCache {
        private final String agentId;
        private final String agentName;
        private final String finalRequestPayloadJson;
        private final String llmRequestId;
        private final String model;
        private final String modelCallNodeName;
        private final String prompt;
        private final String provider;
        private final String requestEnvelopeJson;
        private final String runId;
        private final String sessionId;
        private final String sessionKey;
        private final String systemPrompt;

        public LlmInputCache(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String modelCallNodeName) {
            p.e(modelCallNodeName, "modelCallNodeName");
            this.runId = str;
            this.llmRequestId = str2;
            this.sessionId = str3;
            this.provider = str4;
            this.model = str5;
            this.systemPrompt = str6;
            this.prompt = str7;
            this.finalRequestPayloadJson = str8;
            this.requestEnvelopeJson = str9;
            this.agentId = str10;
            this.agentName = str11;
            this.sessionKey = str12;
            this.modelCallNodeName = modelCallNodeName;
        }

        public static /* synthetic */ LlmInputCache copy$default(LlmInputCache llmInputCache, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = llmInputCache.runId;
            }
            return llmInputCache.copy(str, (i8 & 2) != 0 ? llmInputCache.llmRequestId : str2, (i8 & 4) != 0 ? llmInputCache.sessionId : str3, (i8 & 8) != 0 ? llmInputCache.provider : str4, (i8 & 16) != 0 ? llmInputCache.model : str5, (i8 & 32) != 0 ? llmInputCache.systemPrompt : str6, (i8 & 64) != 0 ? llmInputCache.prompt : str7, (i8 & 128) != 0 ? llmInputCache.finalRequestPayloadJson : str8, (i8 & 256) != 0 ? llmInputCache.requestEnvelopeJson : str9, (i8 & 512) != 0 ? llmInputCache.agentId : str10, (i8 & 1024) != 0 ? llmInputCache.agentName : str11, (i8 & 2048) != 0 ? llmInputCache.sessionKey : str12, (i8 & 4096) != 0 ? llmInputCache.modelCallNodeName : str13);
        }

        /* renamed from: component1, reason: from getter */
        public final String getRunId() {
            return this.runId;
        }

        /* renamed from: component10, reason: from getter */
        public final String getAgentId() {
            return this.agentId;
        }

        /* renamed from: component11, reason: from getter */
        public final String getAgentName() {
            return this.agentName;
        }

        /* renamed from: component12, reason: from getter */
        public final String getSessionKey() {
            return this.sessionKey;
        }

        /* renamed from: component13, reason: from getter */
        public final String getModelCallNodeName() {
            return this.modelCallNodeName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLlmRequestId() {
            return this.llmRequestId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getProvider() {
            return this.provider;
        }

        /* renamed from: component5, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        /* renamed from: component6, reason: from getter */
        public final String getSystemPrompt() {
            return this.systemPrompt;
        }

        /* renamed from: component7, reason: from getter */
        public final String getPrompt() {
            return this.prompt;
        }

        /* renamed from: component8, reason: from getter */
        public final String getFinalRequestPayloadJson() {
            return this.finalRequestPayloadJson;
        }

        /* renamed from: component9, reason: from getter */
        public final String getRequestEnvelopeJson() {
            return this.requestEnvelopeJson;
        }

        public final LlmInputCache copy(String runId, String llmRequestId, String sessionId, String provider, String model, String systemPrompt, String prompt, String finalRequestPayloadJson, String requestEnvelopeJson, String agentId, String agentName, String sessionKey, String modelCallNodeName) {
            p.e(modelCallNodeName, "modelCallNodeName");
            return new LlmInputCache(runId, llmRequestId, sessionId, provider, model, systemPrompt, prompt, finalRequestPayloadJson, requestEnvelopeJson, agentId, agentName, sessionKey, modelCallNodeName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LlmInputCache)) {
                return false;
            }
            LlmInputCache llmInputCache = (LlmInputCache) other;
            return p.a(this.runId, llmInputCache.runId) && p.a(this.llmRequestId, llmInputCache.llmRequestId) && p.a(this.sessionId, llmInputCache.sessionId) && p.a(this.provider, llmInputCache.provider) && p.a(this.model, llmInputCache.model) && p.a(this.systemPrompt, llmInputCache.systemPrompt) && p.a(this.prompt, llmInputCache.prompt) && p.a(this.finalRequestPayloadJson, llmInputCache.finalRequestPayloadJson) && p.a(this.requestEnvelopeJson, llmInputCache.requestEnvelopeJson) && p.a(this.agentId, llmInputCache.agentId) && p.a(this.agentName, llmInputCache.agentName) && p.a(this.sessionKey, llmInputCache.sessionKey) && p.a(this.modelCallNodeName, llmInputCache.modelCallNodeName);
        }

        public final String getAgentId() {
            return this.agentId;
        }

        public final String getAgentName() {
            return this.agentName;
        }

        public final String getFinalRequestPayloadJson() {
            return this.finalRequestPayloadJson;
        }

        public final String getLlmRequestId() {
            return this.llmRequestId;
        }

        public final String getModel() {
            return this.model;
        }

        public final String getModelCallNodeName() {
            return this.modelCallNodeName;
        }

        public final String getPrompt() {
            return this.prompt;
        }

        public final String getProvider() {
            return this.provider;
        }

        public final String getRequestEnvelopeJson() {
            return this.requestEnvelopeJson;
        }

        public final String getRunId() {
            return this.runId;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getSessionKey() {
            return this.sessionKey;
        }

        public final String getSystemPrompt() {
            return this.systemPrompt;
        }

        public int hashCode() {
            String str = this.runId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.llmRequestId;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.sessionId;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.provider;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.model;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.systemPrompt;
            int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.prompt;
            int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.finalRequestPayloadJson;
            int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.requestEnvelopeJson;
            int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.agentId;
            int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.agentName;
            int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.sessionKey;
            return this.modelCallNodeName.hashCode() + ((iHashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31);
        }

        public String toString() {
            String str = this.runId;
            String str2 = this.llmRequestId;
            String str3 = this.sessionId;
            String str4 = this.provider;
            String str5 = this.model;
            String str6 = this.systemPrompt;
            String str7 = this.prompt;
            String str8 = this.finalRequestPayloadJson;
            String str9 = this.requestEnvelopeJson;
            String str10 = this.agentId;
            String str11 = this.agentName;
            String str12 = this.sessionKey;
            String str13 = this.modelCallNodeName;
            StringBuilder sbV = b.v("LlmInputCache(runId=", str, ", llmRequestId=", str2, ", sessionId=");
            b.A(sbV, str3, ", provider=", str4, ", model=");
            b.A(sbV, str5, ", systemPrompt=", str6, ", prompt=");
            b.A(sbV, str7, ", finalRequestPayloadJson=", str8, ", requestEnvelopeJson=");
            b.A(sbV, str9, ", agentId=", str10, ", agentName=");
            b.A(sbV, str11, ", sessionKey=", str12, ", modelCallNodeName=");
            return f.f(sbV, str13, ")");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/base/track/ClawEventReporter$TokenUsage;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "input", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "output", "hitCache", "<init>", "(IILjava/lang/Integer;)V", "getInput", "()I", "getOutput", "getHitCache", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(IILjava/lang/Integer;)Lcom/stepos/stepclaw/base/track/ClawEventReporter$TokenUsage;", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TokenUsage {
        private final Integer hitCache;
        private final int input;
        private final int output;

        public TokenUsage(int i8, int i9, Integer num) {
            this.input = i8;
            this.output = i9;
            this.hitCache = num;
        }

        public static /* synthetic */ TokenUsage copy$default(TokenUsage tokenUsage, int i8, int i9, Integer num, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                i8 = tokenUsage.input;
            }
            if ((i10 & 2) != 0) {
                i9 = tokenUsage.output;
            }
            if ((i10 & 4) != 0) {
                num = tokenUsage.hitCache;
            }
            return tokenUsage.copy(i8, i9, num);
        }

        /* renamed from: component1, reason: from getter */
        public final int getInput() {
            return this.input;
        }

        /* renamed from: component2, reason: from getter */
        public final int getOutput() {
            return this.output;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getHitCache() {
            return this.hitCache;
        }

        public final TokenUsage copy(int input, int output, Integer hitCache) {
            return new TokenUsage(input, output, hitCache);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TokenUsage)) {
                return false;
            }
            TokenUsage tokenUsage = (TokenUsage) other;
            return this.input == tokenUsage.input && this.output == tokenUsage.output && p.a(this.hitCache, tokenUsage.hitCache);
        }

        public final Integer getHitCache() {
            return this.hitCache;
        }

        public final int getInput() {
            return this.input;
        }

        public final int getOutput() {
            return this.output;
        }

        public int hashCode() {
            int iC = b.C(this.output, Integer.hashCode(this.input) * 31, 31);
            Integer num = this.hitCache;
            return iC + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            int i8 = this.input;
            int i9 = this.output;
            Integer num = this.hitCache;
            StringBuilder sbT = b.t("TokenUsage(input=", i8, ", output=", i9, ", hitCache=");
            sbT.append(num);
            sbT.append(")");
            return sbT.toString();
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolCallReportPhase.values().length];
            try {
                iArr[ToolCallReportPhase.BEFORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToolCallReportPhase.AFTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ClawEventReporter(ClawReporterDependencies dependencies) {
        p.e(dependencies, "dependencies");
        this.dependencies = dependencies;
        this.cronTraceIds = new ConcurrentHashMap<>();
        this.llmInputCache = new ConcurrentHashMap<>();
        this.skillBizByScope = new ConcurrentHashMap<>();
        this.memorySearchUplinkReportedKeys = ConcurrentHashMap.newKeySet();
        this.toolCallDedupKeys = ConcurrentHashMap.newKeySet();
    }

    private final String appVersion() {
        return this.dependencies.getAppVersion();
    }

    private final void emitToolCallPhaseReport(String traceId, String hookSessionId, String nodeName, ToolCallReportPhase phase, String paramsJson, String resultJson, String error, String toolName, String toolCallId, String runId, String outputTextIfNoResult, Map<String, ? extends Object> bizDataExtras) {
        ToolCallReportPhase toolCallReportPhase;
        String str;
        String str2;
        int i8 = (error == null || n.t1(error)) ? DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE : 500;
        String string = toolCallId != null ? n.T1(toolCallId).toString() : null;
        String str3 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        if (string == null) {
            string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (string.length() == 0) {
            string = runId != null ? n.T1(runId).toString() : null;
            if (string == null) {
                string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            String string2 = toolName != null ? n.T1(toolName).toString() : null;
            if (string2 == null) {
                string2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            if (string.length() > 0 && string2.length() > 0) {
                string = b.o(string, ":", string2);
            } else if (string.length() <= 0) {
                string = string2.length() > 0 ? "tool:".concat(string2) : "unknown_tool_call";
            }
        }
        String string3 = resultJson != null ? n.T1(resultJson).toString() : null;
        if (string3 == null) {
            string3 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        String string4 = outputTextIfNoResult != null ? n.T1(outputTextIfNoResult).toString() : null;
        if (string4 == null) {
            string4 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (string3.length() > 0) {
            string4 = string3;
            toolCallReportPhase = phase;
        } else if (error != null && !n.t1(error)) {
            string3 = n.T1(error).toString();
            string4 = string3;
            toolCallReportPhase = phase;
        } else if (string4.length() > 0) {
            toolCallReportPhase = phase;
        } else {
            toolCallReportPhase = phase;
            string4 = toolCallReportPhase == ToolCallReportPhase.AFTER ? ConfigIpcContract.KEY_OK : SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        g gVar = new g();
        gVar.put("tool_name", toolName == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : toolName);
        gVar.put("tool_call_id", string);
        gVar.put("call_type", resolveCallType(toolName));
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i9 = iArr[toolCallReportPhase.ordinal()];
        if (i9 == 1) {
            str = "before";
        } else {
            if (i9 != 2) {
                throw new w();
            }
            str = "after";
        }
        gVar.put("tool_phase", str);
        gVar.putAll(bizDataExtras);
        g gVarB = gVar.b();
        int i10 = iArr[toolCallReportPhase.ordinal()];
        if (i10 == 1) {
            str2 = "uplink";
        } else {
            if (i10 != 2) {
                throw new w();
            }
            str2 = "downlink";
        }
        g gVar2 = new g();
        gVar2.put("msg_type", str2);
        if (hookSessionId == null) {
            hookSessionId = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        gVar2.put("session_id", hookSessionId);
        int i11 = iArr[toolCallReportPhase.ordinal()];
        if (i11 == 1) {
            if (paramsJson != null) {
                str3 = paramsJson;
            }
            gVar2.put("input_text", str3);
        } else {
            if (i11 != 2) {
                throw new w();
            }
            gVar2.put("output_text", string4);
        }
        gVar2.put("app_version", appVersion());
        if (error != null && !n.t1(error)) {
            gVar2.put("status_message", error);
        }
        report(traceId, nodeName, gVar2.b(), gVarB, i8);
    }

    private final Map<String, Object> emptySkillBizData() {
        return z.U(new b5.g("skill_id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), new b5.g("skill_name", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [b5.h] */
    private final String extractModelOutputDisplayText(String responseJson) {
        String strO;
        JSONObject jSONObject;
        String string;
        if (responseJson == null || n.t1(responseJson)) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        try {
            jSONObject = new JSONObject(responseJson);
            String strOptString = jSONObject.optString("text");
            p.d(strOptString, "optString(...)");
            string = n.T1(strOptString).toString();
        } catch (Throwable th) {
            strO = a.o(th);
        }
        if (string.length() > 0) {
            return string;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("assistantTexts");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            strO = responseJson;
        } else {
            StringBuilder sb = new StringBuilder();
            int length = jSONArrayOptJSONArray.length();
            for (int i8 = 0; i8 < length; i8++) {
                if (i8 > 0) {
                    sb.append("\n\n");
                }
                sb.append(jSONArrayOptJSONArray.optString(i8));
            }
            strO = sb.toString();
        }
        if (!(strO instanceof h)) {
            responseJson = strO;
        }
        return responseJson;
    }

    private final Double extractTemperature(String requestEnvelopeJson, String finalRequestPayloadJson) {
        Double dExtractTemperature$parseTemperature = extractTemperature$parseTemperature(this, requestEnvelopeJson, new a6.z(14));
        if (dExtractTemperature$parseTemperature != null && !Double.isNaN(dExtractTemperature$parseTemperature.doubleValue())) {
            return dExtractTemperature$parseTemperature;
        }
        Double dExtractTemperature$parseTemperature2 = extractTemperature$parseTemperature(this, finalRequestPayloadJson, new a6.z(15));
        if (dExtractTemperature$parseTemperature2 == null || Double.isNaN(dExtractTemperature$parseTemperature2.doubleValue())) {
            return null;
        }
        return dExtractTemperature$parseTemperature2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double extractTemperature$lambda$1(JSONObject envelope) {
        p.e(envelope, "envelope");
        JSONObject jSONObjectOptJSONObject = envelope.optJSONObject("options");
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.isNull("temperature")) {
            return null;
        }
        return Double.valueOf(jSONObjectOptJSONObject.optDouble("temperature"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double extractTemperature$lambda$2(JSONObject payload) {
        p.e(payload, "payload");
        if (payload.isNull("temperature")) {
            return null;
        }
        return Double.valueOf(payload.optDouble("temperature"));
    }

    private static final Double extractTemperature$parseTemperature(ClawEventReporter clawEventReporter, String str, l lVar) {
        Object objO;
        if (str == null || n.t1(str)) {
            return null;
        }
        try {
            objO = (Double) lVar.invoke(new JSONObject(str));
        } catch (Throwable th) {
            objO = a.o(th);
        }
        return (Double) (objO instanceof h ? null : objO);
    }

    private final void logReportDebugSummary(String nodeName, Map<String, ? extends Object> commonFields, Map<String, ? extends Object> bizData) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        int length = 0;
        if (u.c1(nodeName, "model_call", false)) {
            String strA0 = m.A0(bizData.keySet(), ",", null, null, null, 62);
            Object obj = commonFields.get("output_text");
            int length2 = (obj == null || (string5 = obj.toString()) == null) ? 0 : string5.length();
            Object obj2 = commonFields.get("input_text");
            int length3 = (obj2 == null || (string4 = obj2.toString()) == null) ? 0 : string4.length();
            Object obj3 = bizData.get("model_final_request");
            int length4 = (obj3 == null || (string3 = obj3.toString()) == null) ? 0 : string3.length();
            Object obj4 = bizData.get("model_request_envelope");
            int length5 = (obj4 == null || (string2 = obj4.toString()) == null) ? 0 : string2.length();
            Object obj5 = bizData.get("model_session_response");
            if (obj5 != null && (string = obj5.toString()) != null) {
                length = string.length();
            }
            Object obj6 = bizData.get("temperature");
            String string6 = obj6 != null ? obj6.toString() : null;
            if (string6 == null) {
                string6 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            Object obj7 = bizData.get("provider_id");
            Object obj8 = bizData.get("model_id");
            Object obj9 = bizData.get("run_id");
            Object obj10 = bizData.get("llm_request_id");
            StringBuilder sbV = b.v("report_debug: node=", nodeName, " keys=[", strA0, "] provider=");
            sbV.append(obj7);
            sbV.append(" model=");
            sbV.append(obj8);
            sbV.append(" runId=");
            sbV.append(obj9);
            sbV.append(" llmRequestId=");
            sbV.append(obj10);
            sbV.append(" temperature=");
            sbV.append(string6);
            sbV.append(" inputTextLen=");
            sbV.append(length3);
            sbV.append(" outputTextLen=");
            b.z(sbV, length2, " finalRequestLen=", length4, " requestEnvelopeLen=");
            sbV.append(length5);
            sbV.append(" sessionResponseLen=");
            sbV.append(length);
            ALog.d$default(TAG, sbV.toString(), null, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String memorySearchUplinkCompositeKey(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
            r1 = this;
            r1 = 0
            if (r4 == 0) goto L17
            java.lang.CharSequence r4 = x5.n.T1(r4)
            java.lang.String r4 = r4.toString()
            if (r4 == 0) goto L17
            int r0 = r4.length()
            if (r0 <= 0) goto L14
            goto L15
        L14:
            r4 = r1
        L15:
            if (r4 != 0) goto L32
        L17:
            if (r2 == 0) goto L2d
            java.lang.CharSequence r2 = x5.n.T1(r2)
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L2d
            int r4 = r2.length()
            if (r4 <= 0) goto L2a
            goto L2b
        L2a:
            r2 = r1
        L2b:
            r4 = r2
            goto L2e
        L2d:
            r4 = r1
        L2e:
            if (r4 != 0) goto L32
            java.lang.String r4 = "default"
        L32:
            if (r3 == 0) goto L3c
            java.lang.CharSequence r1 = x5.n.T1(r3)
            java.lang.String r1 = r1.toString()
        L3c:
            if (r1 != 0) goto L40
            java.lang.String r1 = ""
        L40:
            java.lang.String r2 = "\u0001"
            java.lang.String r1 = a8.b.o(r4, r2, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.track.ClawEventReporter.memorySearchUplinkCompositeKey(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private final String newSessionTraceId() {
        return this.dependencies.generateTraceId();
    }

    private final String parseAgentIdFromSessionKey(String sessionKey) {
        if (sessionKey == null || n.t1(sessionKey)) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        List listG1 = n.G1(sessionKey, new String[]{":"}, 0, 6);
        ArrayList arrayList = new ArrayList(o.n0(listG1, 10));
        Iterator it = listG1.iterator();
        while (it.hasNext()) {
            arrayList.add(n.T1((String) it.next()).toString());
        }
        if (arrayList.size() < 2 || !u.W0((String) arrayList.get(0), "agent")) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        Object obj = arrayList.get(1);
        if (((String) obj).length() <= 0) {
            obj = null;
        }
        String str = (String) obj;
        return str == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.stepclaw.base.track.ClawEventReporter.TokenUsage parseTokenUsage(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r8 = "output"
            java.lang.String r0 = "completion_tokens"
            java.lang.String r1 = "output_tokens"
            java.lang.String r2 = "input"
            java.lang.String r3 = "prompt_tokens"
            java.lang.String r4 = "input_tokens"
            r5 = 0
            r6 = 0
            if (r9 == 0) goto Lb4
            boolean r7 = x5.n.t1(r9)
            if (r7 == 0) goto L18
            goto Lb4
        L18:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L32
            r7.<init>(r9)     // Catch: java.lang.Throwable -> L32
            java.lang.String r9 = "usage"
            org.json.JSONObject r9 = r7.optJSONObject(r9)     // Catch: java.lang.Throwable -> L32
            if (r9 != 0) goto L27
        L25:
            r2 = r6
            goto L4a
        L27:
            boolean r7 = r9.has(r4)     // Catch: java.lang.Throwable -> L32
            if (r7 == 0) goto L35
            int r2 = r9.getInt(r4)     // Catch: java.lang.Throwable -> L32
            goto L4a
        L32:
            r8 = move-exception
            goto L91
        L35:
            boolean r4 = r9.has(r3)     // Catch: java.lang.Throwable -> L32
            if (r4 == 0) goto L40
            int r2 = r9.getInt(r3)     // Catch: java.lang.Throwable -> L32
            goto L4a
        L40:
            boolean r3 = r9.has(r2)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L25
            int r2 = r9.getInt(r2)     // Catch: java.lang.Throwable -> L32
        L4a:
            if (r9 != 0) goto L4e
        L4c:
            r8 = r6
            goto L6e
        L4e:
            boolean r3 = r9.has(r1)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L59
            int r8 = r9.getInt(r1)     // Catch: java.lang.Throwable -> L32
            goto L6e
        L59:
            boolean r1 = r9.has(r0)     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L64
            int r8 = r9.getInt(r0)     // Catch: java.lang.Throwable -> L32
            goto L6e
        L64:
            boolean r0 = r9.has(r8)     // Catch: java.lang.Throwable -> L32
            if (r0 == 0) goto L4c
            int r8 = r9.getInt(r8)     // Catch: java.lang.Throwable -> L32
        L6e:
            java.lang.String r0 = "cache_read_input_tokens"
            if (r9 == 0) goto L77
            int r1 = r9.optInt(r0)     // Catch: java.lang.Throwable -> L32
            goto L78
        L77:
            r1 = r6
        L78:
            if (r9 == 0) goto L8a
            boolean r9 = r9.has(r0)     // Catch: java.lang.Throwable -> L32
            r0 = 1
            if (r9 != r0) goto L8a
            if (r1 <= 0) goto L84
            goto L85
        L84:
            r0 = r6
        L85:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L32
            goto L8b
        L8a:
            r9 = r5
        L8b:
            com.stepos.stepclaw.base.track.ClawEventReporter$TokenUsage r0 = new com.stepos.stepclaw.base.track.ClawEventReporter$TokenUsage     // Catch: java.lang.Throwable -> L32
            r0.<init>(r2, r8, r9)     // Catch: java.lang.Throwable -> L32
            goto L95
        L91:
            b5.h r0 = a.a.o(r8)
        L95:
            java.lang.Throwable r8 = b5.i.a(r0)
            if (r8 != 0) goto L9c
            goto Lb1
        L9c:
            java.lang.String r8 = r8.getMessage()
            java.lang.String r9 = "parseTokenUsage failed: "
            java.lang.String r8 = m0.f.c(r9, r8)
            r9 = 4
            java.lang.String r0 = "ClawEventReporter"
            com.stepos.stepclaw.base.util.ALog.d$default(r0, r8, r5, r9, r5)
            com.stepos.stepclaw.base.track.ClawEventReporter$TokenUsage r0 = new com.stepos.stepclaw.base.track.ClawEventReporter$TokenUsage
            r0.<init>(r6, r6, r5)
        Lb1:
            com.stepos.stepclaw.base.track.ClawEventReporter$TokenUsage r0 = (com.stepos.stepclaw.base.track.ClawEventReporter.TokenUsage) r0
            return r0
        Lb4:
            com.stepos.stepclaw.base.track.ClawEventReporter$TokenUsage r8 = new com.stepos.stepclaw.base.track.ClawEventReporter$TokenUsage
            r8.<init>(r6, r6, r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.track.ClawEventReporter.parseTokenUsage(java.lang.String):com.stepos.stepclaw.base.track.ClawEventReporter$TokenUsage");
    }

    private final void purgeLlmInputCacheAliases(LlmInputCache cache) {
        String string;
        String string2;
        String string3;
        String string4;
        String llmRequestId = cache.getLlmRequestId();
        if (llmRequestId != null && (string4 = n.T1(llmRequestId).toString()) != null) {
            if (string4.length() <= 0) {
                string4 = null;
            }
            if (string4 != null) {
                this.llmInputCache.remove("lr:".concat(string4));
            }
        }
        String runId = cache.getRunId();
        if (runId != null && (string3 = n.T1(runId).toString()) != null) {
            if (string3.length() <= 0) {
                string3 = null;
            }
            if (string3 != null) {
                this.llmInputCache.remove("r:".concat(string3));
            }
        }
        String sessionKey = cache.getSessionKey();
        if (sessionKey != null && (string2 = n.T1(sessionKey).toString()) != null) {
            if (string2.length() <= 0) {
                string2 = null;
            }
            if (string2 != null) {
                this.llmInputCache.remove("sk:".concat(string2));
            }
        }
        String sessionId = cache.getSessionId();
        if (sessionId != null && (string = n.T1(sessionId).toString()) != null) {
            String str = string.length() > 0 ? string : null;
            if (str != null) {
                this.llmInputCache.remove("si:".concat(str));
            }
        }
        this.llmInputCache.remove("default");
    }

    private final void putLlmInputCache(LlmInputCache cache) {
        String string;
        String string2;
        String string3;
        String string4;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String llmRequestId = cache.getLlmRequestId();
        if (llmRequestId != null && (string4 = n.T1(llmRequestId).toString()) != null) {
            if (string4.length() <= 0) {
                string4 = null;
            }
            if (string4 != null) {
                linkedHashSet.add("lr:".concat(string4));
            }
        }
        String runId = cache.getRunId();
        if (runId != null && (string3 = n.T1(runId).toString()) != null) {
            if (string3.length() <= 0) {
                string3 = null;
            }
            if (string3 != null) {
                linkedHashSet.add("r:".concat(string3));
            }
        }
        String sessionKey = cache.getSessionKey();
        if (sessionKey != null && (string2 = n.T1(sessionKey).toString()) != null) {
            if (string2.length() <= 0) {
                string2 = null;
            }
            if (string2 != null) {
                linkedHashSet.add("sk:".concat(string2));
            }
        }
        String sessionId = cache.getSessionId();
        if (sessionId != null && (string = n.T1(sessionId).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                linkedHashSet.add("si:".concat(string));
            }
        }
        if (linkedHashSet.isEmpty()) {
            linkedHashSet.add("default");
        }
        Iterator it = linkedHashSet.iterator();
        p.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            p.d(next, "next(...)");
            this.llmInputCache.put((String) next, cache);
        }
        String runId2 = cache.getRunId();
        ALog.d$default(TAG, "llm_input cache keys=" + linkedHashSet + " runId=" + (runId2 != null ? n.Q1(8, runId2) : null), null, 4, null);
    }

    private final void report(String traceId, String nodeName, Map<String, ? extends Object> commonFields, Map<String, ? extends Object> bizData, int statusCode) {
        Object objO;
        try {
            String strRequireTraceId = requireTraceId(traceId);
            LinkedHashMap linkedHashMap = new LinkedHashMap(commonFields.size() + 1);
            linkedHashMap.putAll(commonFields);
            linkedHashMap.put("trace_id", strRequireTraceId);
            if (DEBUG) {
                ALog.d$default(TAG, "report: node=" + nodeName + " trace_id_len=" + strRequireTraceId.length() + " traceId=" + strRequireTraceId + "… commonFields=" + linkedHashMap + " bizData=" + bizData + " status=" + statusCode, null, 4, null);
            }
            logReportDebugSummary(nodeName, linkedHashMap, bizData);
            this.dependencies.reportEvent(strRequireTraceId, nodeName, linkedHashMap, bizData, statusCode);
            ALog.d$default(TAG, "reported: node=" + nodeName + " status=" + statusCode, null, 4, null);
            objO = a0.f883a;
        } catch (Throwable th) {
            objO = a.o(th);
        }
        Throwable thA = i.a(objO);
        if (thA != null) {
            ALog.w$default(TAG, b.p("reportEvent failed: node=", nodeName, " err=", thA.getMessage()), null, 4, null);
        }
    }

    public static /* synthetic */ void report$default(ClawEventReporter clawEventReporter, String str, String str2, Map map, Map map2, int i8, int i9, Object obj) {
        if ((i9 & 16) != 0) {
            i8 = DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE;
        }
        clawEventReporter.report(str, str2, map, map2, i8);
    }

    private final String requireTraceId(String raw) {
        String string = n.T1(raw).toString();
        if (string.length() > 0) {
            return string;
        }
        ALog.w$default(TAG, "traceId 为空，已重新生成", null, 4, null);
        return newSessionTraceId();
    }

    private final String resolveAgentName(String agentName, String agentId, String sessionKey) {
        String string;
        String string2;
        if (agentName != null && (string2 = n.T1(agentName).toString()) != null) {
            if (string2.length() <= 0) {
                string2 = null;
            }
            if (string2 != null) {
                return string2;
            }
        }
        if (agentId != null && (string = n.T1(agentId).toString()) != null) {
            String str = string.length() > 0 ? string : null;
            if (str != null) {
                return str;
            }
        }
        String agentIdFromSessionKey = parseAgentIdFromSessionKey(sessionKey);
        return agentIdFromSessionKey.length() > 0 ? agentIdFromSessionKey : FALLBACK_AGENT_LABEL;
    }

    private final String resolveCallType(String toolName) {
        return toolName == null ? "local_api" : (n.g1(toolName, ":", false) || u.c1(toolName, "mcp_", false)) ? "remote_mcp" : "local_api";
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String resolveTraceIdForReport(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L14
            java.lang.CharSequence r3 = x5.n.T1(r3)
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L14
            int r1 = r3.length()
            if (r1 <= 0) goto L14
            goto L15
        L14:
            r3 = r0
        L15:
            if (r3 == 0) goto L18
            return r3
        L18:
            if (r4 == 0) goto L2e
            java.lang.CharSequence r3 = x5.n.T1(r4)
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L2e
            int r4 = r3.length()
            if (r4 <= 0) goto L2b
            goto L2c
        L2b:
            r3 = r0
        L2c:
            if (r3 != 0) goto L42
        L2e:
            if (r5 == 0) goto L41
            java.lang.CharSequence r3 = x5.n.T1(r5)
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L41
            int r4 = r3.length()
            if (r4 <= 0) goto L41
            goto L42
        L41:
            r3 = r0
        L42:
            if (r3 == 0) goto L4d
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r4 = r2.cronTraceIds
            java.lang.Object r3 = r4.get(r3)
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0
        L4d:
            if (r0 == 0) goto L50
            return r0
        L50:
            java.lang.String r3 = ""
            java.lang.String r2 = r2.requireTraceId(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.track.ClawEventReporter.resolveTraceIdForReport(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static /* synthetic */ String resolveTraceIdForReport$default(ClawEventReporter clawEventReporter, String str, String str2, String str3, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        if ((i8 & 4) != 0) {
            str3 = null;
        }
        return clawEventReporter.resolveTraceIdForReport(str, str2, str3);
    }

    private final String subagentConfigAsInputText(Map<String, String> config) {
        Set<Map.Entry<String, String>> setEntrySet;
        String strA0;
        return (config == null || (setEntrySet = config.entrySet()) == null || (strA0 = m.A0(setEntrySet, ";", null, null, new a6.z(16), 30)) == null) ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : strA0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence subagentConfigAsInputText$lambda$0(Map.Entry it) {
        p.e(it, "it");
        return it.getKey() + "=" + it.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.stepclaw.base.track.ClawEventReporter.LlmInputCache takeLlmInputCache(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L1e
            java.lang.CharSequence r3 = x5.n.T1(r3)
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L1e
            int r1 = r3.length()
            if (r1 <= 0) goto L14
            goto L15
        L14:
            r3 = r0
        L15:
            if (r3 == 0) goto L1e
            java.lang.String r1 = "lr:"
            java.lang.String r3 = r1.concat(r3)
            goto L1f
        L1e:
            r3 = r0
        L1f:
            if (r4 == 0) goto L3c
            java.lang.CharSequence r4 = x5.n.T1(r4)
            java.lang.String r4 = r4.toString()
            if (r4 == 0) goto L3c
            int r1 = r4.length()
            if (r1 <= 0) goto L32
            goto L33
        L32:
            r4 = r0
        L33:
            if (r4 == 0) goto L3c
            java.lang.String r1 = "r:"
            java.lang.String r4 = r1.concat(r4)
            goto L3d
        L3c:
            r4 = r0
        L3d:
            if (r5 == 0) goto L5a
            java.lang.CharSequence r5 = x5.n.T1(r5)
            java.lang.String r5 = r5.toString()
            if (r5 == 0) goto L5a
            int r1 = r5.length()
            if (r1 <= 0) goto L50
            goto L51
        L50:
            r5 = r0
        L51:
            if (r5 == 0) goto L5a
            java.lang.String r1 = "sk:"
            java.lang.String r5 = r1.concat(r5)
            goto L5b
        L5a:
            r5 = r0
        L5b:
            if (r6 == 0) goto L77
            java.lang.CharSequence r6 = x5.n.T1(r6)
            java.lang.String r6 = r6.toString()
            if (r6 == 0) goto L77
            int r1 = r6.length()
            if (r1 <= 0) goto L6e
            goto L6f
        L6e:
            r6 = r0
        L6f:
            if (r6 == 0) goto L77
            java.lang.String r0 = "si:"
            java.lang.String r0 = r0.concat(r6)
        L77:
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r0}
            java.util.ArrayList r3 = c5.l.d0(r3)
            int r4 = r3.size()
            r5 = 0
        L84:
            if (r5 >= r4) goto L9d
            java.lang.Object r6 = r3.get(r5)
            int r5 = r5 + 1
            java.lang.String r6 = (java.lang.String) r6
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.stepclaw.base.track.ClawEventReporter$LlmInputCache> r0 = r2.llmInputCache
            java.lang.Object r6 = r0.remove(r6)
            com.stepos.stepclaw.base.track.ClawEventReporter$LlmInputCache r6 = (com.stepos.stepclaw.base.track.ClawEventReporter.LlmInputCache) r6
            if (r6 != 0) goto L99
            goto L84
        L99:
            r2.purgeLlmInputCacheAliases(r6)
            return r6
        L9d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.stepclaw.base.track.ClawEventReporter$LlmInputCache> r3 = r2.llmInputCache
            java.lang.String r4 = "default"
            java.lang.Object r3 = r3.remove(r4)
            com.stepos.stepclaw.base.track.ClawEventReporter$LlmInputCache r3 = (com.stepos.stepclaw.base.track.ClawEventReporter.LlmInputCache) r3
            if (r3 == 0) goto Lac
            r2.purgeLlmInputCacheAliases(r3)
        Lac:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.track.ClawEventReporter.takeLlmInputCache(java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.stepos.stepclaw.base.track.ClawEventReporter$LlmInputCache");
    }

    private final TokenUsage tokenUsageFromHook(Integer usageInput, Integer usageOutput, Integer usageCacheRead) {
        Integer numValueOf;
        if (usageCacheRead != null) {
            numValueOf = Integer.valueOf(usageCacheRead.intValue() > 0 ? 1 : 0);
        } else {
            numValueOf = null;
        }
        return new TokenUsage(usageInput != null ? usageInput.intValue() : 0, usageOutput != null ? usageOutput.intValue() : 0, numValueOf);
    }

    private final String toolCallNodeNameForReport(String toolName, String toolCallId) {
        String string;
        String str = null;
        String string2 = toolName != null ? n.T1(toolName).toString() : null;
        if (string2 == null) {
            string2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (string2.length() == 0) {
            return "tool_call";
        }
        Pattern patternCompile = Pattern.compile("[\\s/\\\\]+");
        p.d(patternCompile, "compile(...)");
        String strReplaceAll = patternCompile.matcher(string2).replaceAll("_");
        p.d(strReplaceAll, "replaceAll(...)");
        String strU1 = n.U1(strReplaceAll, '_');
        if (strU1.length() == 0) {
            return "tool_call";
        }
        String strC = f.c("tool_call_", strU1);
        if (p.a(strC, "tool_call_exec")) {
            if (toolCallId != null && (string = n.T1(toolCallId).toString()) != null) {
                String strR1 = n.R1(6, string);
                if (strR1.length() > 0) {
                    str = strR1;
                }
            }
            if (str != null) {
                return b.o(strC, "_", str);
            }
        }
        return strC;
    }

    public static /* synthetic */ String toolCallNodeNameForReport$default(ClawEventReporter clawEventReporter, String str, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        return clawEventReporter.toolCallNodeNameForReport(str, str2);
    }

    private final String userId() {
        return this.dependencies.getUserId();
    }

    @Override // com.stepos.stepclaw.base.track.ClawReporter
    public boolean hasMemorySearchUplinkReported(String sessionId, String runId, String sessionKey) {
        return this.memorySearchUplinkReportedKeys.contains(memorySearchUplinkCompositeKey(sessionId, runId, sessionKey));
    }

    @Override // com.stepos.stepclaw.base.track.ClawReporter
    public void onLlmInput(String sessionId, String runId, String llmRequestId, Integer requestSeq, String provider, String model, String systemPrompt, String prompt, String finalRequestPayloadJson, String requestEnvelopeJson, String agentId, String agentName, String sessionKey, String hookTraceId) {
        String str;
        String strResolveTraceIdForReport$default = resolveTraceIdForReport$default(this, hookTraceId, sessionKey, null, 4, null);
        if (requestSeq != null) {
            str = "model_call_" + requestSeq;
        } else {
            str = "model_call";
        }
        String strResolveAgentName = resolveAgentName(agentName, agentId, sessionKey);
        String string = provider != null ? n.T1(provider).toString() : null;
        String str2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        if (string == null) {
            string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        String string2 = model != null ? n.T1(model).toString() : null;
        if (string2 == null) {
            string2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        String string3 = systemPrompt != null ? n.T1(systemPrompt).toString() : null;
        if (string3 == null) {
            string3 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        String string4 = prompt != null ? n.T1(prompt).toString() : null;
        if (string4 == null) {
            string4 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        Double dExtractTemperature = extractTemperature(requestEnvelopeJson, finalRequestPayloadJson);
        g gVar = new g();
        gVar.put("agent_name", strResolveAgentName);
        gVar.put("prompt_template", string3);
        gVar.put("provider_id", string);
        gVar.put("model_id", string2);
        String string5 = runId != null ? n.T1(runId).toString() : null;
        if (string5 == null) {
            string5 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        gVar.put("run_id", string5);
        String string6 = llmRequestId != null ? n.T1(llmRequestId).toString() : null;
        if (string6 == null) {
            string6 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        gVar.put("llm_request_id", string6);
        if (finalRequestPayloadJson != null && !n.t1(finalRequestPayloadJson)) {
            gVar.put("model_final_request", finalRequestPayloadJson);
        }
        if (requestEnvelopeJson != null && !n.t1(requestEnvelopeJson)) {
            gVar.put("model_request_envelope", requestEnvelopeJson);
        }
        if (dExtractTemperature != null) {
            gVar.put("temperature", dExtractTemperature);
        }
        gVar.put("input_tokens", 0);
        gVar.put("output_tokens", 0);
        g gVarB = gVar.b();
        b5.g gVar2 = new b5.g("msg_type", "uplink");
        if (sessionId != null) {
            str2 = sessionId;
        }
        report$default(this, strResolveTraceIdForReport$default, str, z.U(gVar2, new b5.g("session_id", str2), new b5.g("input_text", string4), new b5.g("app_version", appVersion())), gVarB, 0, 16, null);
        putLlmInputCache(new LlmInputCache(runId, llmRequestId, sessionId, provider, model, systemPrompt, prompt, finalRequestPayloadJson, requestEnvelopeJson, agentId, agentName, sessionKey, str));
        String strQ1 = runId != null ? n.Q1(8, runId) : null;
        StringBuilder sbV = b.v("llm_input uplink + cache: session=", sessionId, " model=", model, " agentId=");
        sbV.append(agentId);
        sbV.append(" runId=");
        sbV.append(strQ1);
        ALog.d$default(TAG, sbV.toString(), null, 4, null);
    }

    @Override // com.stepos.stepclaw.base.track.ClawReporter
    public void onLlmOutput(String sessionId, String runId, String llmRequestId, String provider, String model, String responseJson, String sessionResponseJson, String agentId, String agentName, String sessionKey, String hookTraceId, boolean usageFromHook, Integer usageInput, Integer usageOutput, Integer usageCacheRead) {
        String modelCallNodeName;
        String str;
        TokenUsage tokenUsage;
        String str2;
        String str3;
        String str4;
        LlmInputCache llmInputCache;
        String str5;
        String str6;
        String str7;
        String sessionKey2;
        String agentId2;
        String agentName2;
        String systemPrompt;
        String str8 = sessionId;
        String strResolveTraceIdForReport$default = resolveTraceIdForReport$default(this, hookTraceId, sessionKey, null, 4, null);
        LlmInputCache llmInputCacheTakeLlmInputCache = takeLlmInputCache(llmRequestId, runId, sessionKey, str8);
        if (llmInputCacheTakeLlmInputCache == null || (modelCallNodeName = llmInputCacheTakeLlmInputCache.getModelCallNodeName()) == null) {
            modelCallNodeName = "model_call";
        }
        if (usageFromHook) {
            tokenUsage = tokenUsageFromHook(usageInput, usageOutput, usageCacheRead);
            str = responseJson;
        } else {
            str = responseJson;
            tokenUsage = parseTokenUsage(str);
        }
        int input = tokenUsage.getInput();
        int output = tokenUsage.getOutput();
        Integer hitCache = tokenUsage.getHitCache();
        String provider2 = provider == null ? llmInputCacheTakeLlmInputCache != null ? llmInputCacheTakeLlmInputCache.getProvider() : null : provider;
        String string = provider2 != null ? n.T1(provider2).toString() : null;
        if (string == null) {
            string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (model == null) {
            String model2 = llmInputCacheTakeLlmInputCache != null ? llmInputCacheTakeLlmInputCache.getModel() : null;
            str2 = model2 == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : model2;
        } else {
            str2 = model;
        }
        if (llmInputCacheTakeLlmInputCache == null || (systemPrompt = llmInputCacheTakeLlmInputCache.getSystemPrompt()) == null) {
            str3 = strResolveTraceIdForReport$default;
            str4 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            str3 = strResolveTraceIdForReport$default;
            str4 = systemPrompt;
        }
        String str9 = (llmInputCacheTakeLlmInputCache == null || (agentName2 = llmInputCacheTakeLlmInputCache.getAgentName()) == null) ? agentName : agentName2;
        if (llmInputCacheTakeLlmInputCache == null || (agentId2 = llmInputCacheTakeLlmInputCache.getAgentId()) == null) {
            llmInputCache = llmInputCacheTakeLlmInputCache;
            str5 = agentId;
        } else {
            llmInputCache = llmInputCacheTakeLlmInputCache;
            str5 = agentId2;
        }
        if (llmInputCache == null || (sessionKey2 = llmInputCache.getSessionKey()) == null) {
            str6 = modelCallNodeName;
            str7 = sessionKey;
        } else {
            str6 = modelCallNodeName;
            str7 = sessionKey2;
        }
        String strResolveAgentName = resolveAgentName(str9, str5, str7);
        g gVar = new g();
        gVar.put("agent_name", strResolveAgentName);
        gVar.put("prompt_template", str4);
        gVar.put("provider_id", string);
        gVar.put("model_id", str2);
        String string2 = runId != null ? n.T1(runId).toString() : null;
        if (string2 == null) {
            string2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        gVar.put("run_id", string2);
        String string3 = llmRequestId != null ? n.T1(llmRequestId).toString() : null;
        if (string3 == null) {
            string3 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        gVar.put("llm_request_id", string3);
        Double dExtractTemperature = extractTemperature(llmInputCache != null ? llmInputCache.getRequestEnvelopeJson() : null, llmInputCache != null ? llmInputCache.getFinalRequestPayloadJson() : null);
        if (dExtractTemperature != null) {
            gVar.put("temperature", Double.valueOf(dExtractTemperature.doubleValue()));
        }
        if (sessionResponseJson != null && !n.t1(sessionResponseJson)) {
            gVar.put("model_session_response", sessionResponseJson);
        }
        gVar.put("input_tokens", Integer.valueOf(input));
        gVar.put("output_tokens", Integer.valueOf(output));
        if (hitCache != null) {
            gVar.put("hit_cache", hitCache);
        }
        g gVarB = gVar.b();
        if (sessionResponseJson != null) {
            str = sessionResponseJson;
        }
        String strExtractModelOutputDisplayText = extractModelOutputDisplayText(str);
        b5.g gVar2 = new b5.g("msg_type", "downlink");
        if (str8 == null) {
            str8 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        report$default(this, str3, str6, z.U(gVar2, new b5.g("session_id", str8), new b5.g("output_text", strExtractModelOutputDisplayText), new b5.g("app_version", appVersion())), gVarB, 0, 16, null);
    }

    @Override // com.stepos.stepclaw.base.track.ClawReporter
    public void onNewTurn(String sessionId) {
        ALog.d$default(TAG, f.c("new turn: sessionId=", sessionId), null, 4, null);
    }

    @Override // com.stepos.stepclaw.base.track.ClawReporter
    public void onSessionReset(String sessionId) {
        ALog.d$default(TAG, f.c("session reset: sessionId=", sessionId), null, 4, null);
        this.llmInputCache.clear();
        this.skillBizByScope.clear();
        this.memorySearchUplinkReportedKeys.clear();
        this.toolCallDedupKeys.clear();
        this.cronTraceIds.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    @Override // com.stepos.stepclaw.base.track.ClawReporter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSkillEnd(java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.track.ClawEventReporter.onSkillEnd(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1  */
    @Override // com.stepos.stepclaw.base.track.ClawReporter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSkillStart(java.lang.String r15, java.lang.String r16, java.util.Map<java.lang.String, java.lang.String> r17, java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.track.ClawEventReporter.onSkillStart(java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    @Override // com.stepos.stepclaw.base.track.ClawReporter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onToolCall(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.stepos.stepclaw.base.track.ToolCallReportPhase r22, java.lang.String r23, java.lang.String r24) {
        /*
            r13 = this;
            r8 = r16
            r9 = r20
            r4 = r22
            r0 = r23
            java.lang.String r1 = "phase"
            kotlin.jvm.internal.p.e(r4, r1)
            r1 = 1
            if (r8 == 0) goto L6c
            java.lang.String r2 = "exec"
            boolean r2 = r8.equalsIgnoreCase(r2)
            if (r2 != r1) goto L6c
            r2 = 0
            if (r9 == 0) goto L44
            java.lang.CharSequence r3 = x5.n.T1(r9)
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L44
            int r5 = r3.length()
            if (r5 <= 0) goto L2c
            goto L2d
        L2c:
            r3 = r2
        L2d:
            if (r3 == 0) goto L44
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r3 = "\u0001"
            r5.append(r3)
            r5.append(r4)
            java.lang.String r3 = r5.toString()
            goto L45
        L44:
            r3 = r2
        L45:
            if (r3 == 0) goto L6c
            java.util.concurrent.ConcurrentHashMap$KeySetView<java.lang.String, java.lang.Boolean> r5 = r13.toolCallDedupKeys
            boolean r3 = r5.add(r3)
            if (r3 != 0) goto L6c
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "onToolCall: dup skipped phase="
            r13.<init>(r14)
            r13.append(r4)
            java.lang.String r14 = " toolCallId="
            r13.append(r14)
            r13.append(r9)
            java.lang.String r13 = r13.toString()
            r14 = 4
            java.lang.String r15 = "ClawEventReporter"
            com.stepos.stepclaw.base.util.ALog.w$default(r15, r13, r2, r14, r2)
            return
        L6c:
            com.stepos.stepclaw.base.track.ToolCallReportPhase r2 = com.stepos.stepclaw.base.track.ToolCallReportPhase.BEFORE
            if (r4 != r2) goto L83
            if (r8 == 0) goto L83
            java.lang.String r2 = "memory_search"
            boolean r2 = r8.equalsIgnoreCase(r2)
            if (r2 != r1) goto L83
            java.util.concurrent.ConcurrentHashMap$KeySetView<java.lang.String, java.lang.Boolean> r1 = r13.memorySearchUplinkReportedKeys
            java.lang.String r2 = r13.memorySearchUplinkCompositeKey(r14, r15, r0)
            r1.add(r2)
        L83:
            r1 = r24
            java.lang.String r1 = r13.resolveTraceIdForReport(r1, r0, r14)
            java.lang.String r3 = r13.toolCallNodeNameForReport(r8, r9)
            c5.t r12 = c5.t.f1093a
            r0 = r13
            r2 = r14
            r10 = r15
            r5 = r17
            r6 = r18
            r7 = r19
            r11 = r21
            r0.emitToolCallPhaseReport(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.track.ClawEventReporter.onToolCall(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.stepos.stepclaw.base.track.ToolCallReportPhase, java.lang.String, java.lang.String):void");
    }

    @Override // com.stepos.stepclaw.base.track.ClawReporter
    public void seedTraceId(String sessionKey, String traceId) {
        p.e(sessionKey, "sessionKey");
        p.e(traceId, "traceId");
        String string = n.T1(sessionKey).toString();
        if (string.length() <= 0) {
            string = null;
        }
        if (string == null) {
            return;
        }
        String string2 = n.T1(traceId).toString();
        if (string2.length() <= 0) {
            string2 = null;
        }
        if (string2 == null) {
            return;
        }
        this.cronTraceIds.put(string, string2);
        ALog.i$default(TAG, b.q("[trace] seedTraceId: sessionKey=", string, " traceId=", n.Q1(8, string2), "…"), null, 4, null);
    }
}
