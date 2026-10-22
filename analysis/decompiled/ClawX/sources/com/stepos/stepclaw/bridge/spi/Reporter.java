package com.stepos.stepclaw.bridge.spi;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.track.ToolCallReportPhase;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.ReaderJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J©\u0001\u0010\u0015\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0015\u0010\u0016J¹\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0085\u0001\u0010(\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010'\u001a\u00020&2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b(\u0010)J-\u0010*\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b*\u0010+JQ\u00100\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00022\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010-2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b0\u00101J;\u00102\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b2\u00103J\u0019\u00104\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b4\u0010\u0006J\u001f\u00106\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0002H\u0016¢\u0006\u0004\b6\u00107¨\u00068À\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/Reporter;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sessionId", "Lb5/a0;", "onNewTurn", "(Ljava/lang/String;)V", "runId", "llmRequestId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "requestSeq", ConfigIpcContract.KEY_PROVIDER, ConfigIpcContract.KEY_MODEL, "systemPrompt", "prompt", "finalRequestPayloadJson", "requestEnvelopeJson", "agentId", "agentName", "sessionKey", "hookTraceId", "onLlmInput", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "responseJson", "sessionResponseJson", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "usageFromHook", "usageInput", "usageOutput", "usageCacheRead", "onLlmOutput", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "toolName", "paramsJson", "resultJson", "error", "toolCallId", "outputTextIfNoResult", "Lcom/stepos/stepclaw/base/track/ToolCallReportPhase;", "phase", "onToolCall", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/stepclaw/base/track/ToolCallReportPhase;Ljava/lang/String;Ljava/lang/String;)V", "hasMemorySearchUplinkReported", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "parentSessionId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "subagentConfig", "outputText", "onSkillStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "onSkillEnd", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onSessionReset", "traceId", "seedTraceId", "(Ljava/lang/String;Ljava/lang/String;)V", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Reporter {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean hasMemorySearchUplinkReported(Reporter reporter, String str, String str2, String str3) {
            return Reporter.super.hasMemorySearchUplinkReported(str, str2, str3);
        }

        @Deprecated
        public static void seedTraceId(Reporter reporter, String sessionKey, String traceId) {
            p.e(sessionKey, "sessionKey");
            p.e(traceId, "traceId");
            Reporter.super.seedTraceId(sessionKey, traceId);
        }
    }

    static /* synthetic */ void onLlmInput$default(Reporter reporter, String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLlmInput");
        }
        reporter.onLlmInput(str, str2, str3, (i8 & 8) != 0 ? null : num, str4, str5, str6, str7, (i8 & 256) != 0 ? null : str8, (i8 & 512) != 0 ? null : str9, (i8 & 1024) != 0 ? null : str10, (i8 & 2048) != 0 ? null : str11, (i8 & 4096) != 0 ? null : str12, (i8 & 8192) != 0 ? null : str13);
    }

    static /* synthetic */ void onLlmOutput$default(Reporter reporter, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z, Integer num, Integer num2, Integer num3, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLlmOutput");
        }
        reporter.onLlmOutput(str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : str3, str4, str5, str6, (i8 & 64) != 0 ? null : str7, (i8 & 128) != 0 ? null : str8, (i8 & 256) != 0 ? null : str9, (i8 & 512) != 0 ? null : str10, (i8 & 1024) != 0 ? null : str11, (i8 & 2048) != 0 ? false : z, (i8 & 4096) != 0 ? null : num, (i8 & 8192) != 0 ? null : num2, (i8 & ReaderJsonLexerKt.BATCH_SIZE) != 0 ? null : num3);
    }

    static /* synthetic */ void onSkillEnd$default(Reporter reporter, String str, String str2, String str3, String str4, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSkillEnd");
        }
        if ((i8 & 4) != 0) {
            str3 = null;
        }
        if ((i8 & 8) != 0) {
            str4 = null;
        }
        reporter.onSkillEnd(str, str2, str3, str4);
    }

    static /* synthetic */ void onSkillStart$default(Reporter reporter, String str, String str2, Map map, String str3, String str4, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSkillStart");
        }
        if ((i8 & 8) != 0) {
            str3 = null;
        }
        if ((i8 & 16) != 0) {
            str4 = null;
        }
        reporter.onSkillStart(str, str2, map, str3, str4);
    }

    static /* synthetic */ void onToolCall$default(Reporter reporter, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ToolCallReportPhase toolCallReportPhase, String str9, String str10, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onToolCall");
        }
        if ((i8 & 64) != 0) {
            str7 = null;
        }
        if ((i8 & 128) != 0) {
            str8 = null;
        }
        if ((i8 & 256) != 0) {
            toolCallReportPhase = ToolCallReportPhase.AFTER;
        }
        if ((i8 & 512) != 0) {
            str9 = null;
        }
        if ((i8 & 1024) != 0) {
            str10 = null;
        }
        reporter.onToolCall(str, str2, str3, str4, str5, str6, str7, str8, toolCallReportPhase, str9, str10);
    }

    default boolean hasMemorySearchUplinkReported(String sessionId, String runId, String sessionKey) {
        return false;
    }

    void onLlmInput(String sessionId, String runId, String llmRequestId, Integer requestSeq, String provider, String model, String systemPrompt, String prompt, String finalRequestPayloadJson, String requestEnvelopeJson, String agentId, String agentName, String sessionKey, String hookTraceId);

    void onLlmOutput(String sessionId, String runId, String llmRequestId, String provider, String model, String responseJson, String sessionResponseJson, String agentId, String agentName, String sessionKey, String hookTraceId, boolean usageFromHook, Integer usageInput, Integer usageOutput, Integer usageCacheRead);

    void onNewTurn(String sessionId);

    void onSessionReset(String sessionId);

    void onSkillEnd(String sessionId, String parentSessionId, String outputText, String hookTraceId);

    void onSkillStart(String sessionId, String parentSessionId, Map<String, String> subagentConfig, String outputText, String hookTraceId);

    void onToolCall(String sessionId, String runId, String toolName, String paramsJson, String resultJson, String error, String toolCallId, String outputTextIfNoResult, ToolCallReportPhase phase, String sessionKey, String hookTraceId);

    default void seedTraceId(String sessionKey, String traceId) {
        p.e(sessionKey, "sessionKey");
        p.e(traceId, "traceId");
    }
}
