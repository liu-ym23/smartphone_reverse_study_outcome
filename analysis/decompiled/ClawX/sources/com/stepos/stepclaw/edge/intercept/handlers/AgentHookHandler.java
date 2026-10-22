package com.stepos.stepclaw.edge.intercept.handlers;

import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.track.ClawReportBridge;
import com.stepos.stepclaw.base.track.ClawReporter;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.edge.intercept.model.BeforeAgentStartRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforeAgentStartResponse;
import com.stepos.stepclaw.edge.intercept.model.BeforeModelResolveRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforeModelResolveResponse;
import com.stepos.stepclaw.edge.intercept.model.BeforePromptBuildRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforePromptBuildResponse;
import com.stepos.stepclaw.edge.intercept.model.CronSessionStartRequest;
import com.stepos.stepclaw.edge.intercept.model.CronSessionStartResponse;
import com.stepos.stepclaw.edge.intercept.model.HookResponseJson;
import com.stepos.stepclaw.edge.intercept.model.LlmInputRequest;
import com.stepos.stepclaw.edge.intercept.model.LlmOutputRequest;
import com.stepos.stepclaw.edge.intercept.model.LlmUsage;
import com.stepos.stepclaw.gateway.d;
import j3.a;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonKt;
import m0.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J+\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000f\"\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0018"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/handlers/AgentHookHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "handleBeforeModelResolve", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "body", "handleBeforePromptBuild", "handleBeforeAgentStart", "handleLlmInput", "handleLlmOutput", "firstNonBlankJsonString", "root", "Lorg/json/JSONObject;", "keys", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "(Lorg/json/JSONObject;[Ljava/lang/String;)Ljava/lang/String;", "buildSyntheticLlmOutputPayload", "handleAgentEnd", "isAbortLikeError", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "error", "handleCronSessionStart", "Companion", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AgentHookHandler {
    private static final String TAG = "AgentHookHandler";
    private static final Json json = JsonKt.Json$default(null, new d(25), 1, null);
    private static final Pattern TEXT_MESSAGE_TEXT_PATTERN = Pattern.compile("TextMessage\\(\\s*text\\s*=\\s*(.*?),\\s*streamChunk\\s*=", 32);

    private final String buildSyntheticLlmOutputPayload(JSONObject root) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayOptJSONArray = root.optJSONArray("assistantTexts");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            StringBuilder sb = new StringBuilder();
            int length = jSONArrayOptJSONArray.length();
            for (int i8 = 0; i8 < length; i8++) {
                if (i8 > 0) {
                    sb.append("\n\n");
                }
                sb.append(jSONArrayOptJSONArray.optString(i8));
            }
            jSONObject.put("text", sb.toString());
        }
        JSONObject jSONObjectOptJSONObject = root.optJSONObject("usage");
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObjectOptJSONObject.has("input_tokens")) {
                jSONObject2.put("input_tokens", jSONObjectOptJSONObject.getInt("input_tokens"));
            } else if (jSONObjectOptJSONObject.has("prompt_tokens")) {
                jSONObject2.put("input_tokens", jSONObjectOptJSONObject.getInt("prompt_tokens"));
            } else if (jSONObjectOptJSONObject.has("input")) {
                jSONObject2.put("input_tokens", jSONObjectOptJSONObject.getInt("input"));
            }
            if (jSONObjectOptJSONObject.has("output_tokens")) {
                jSONObject2.put("output_tokens", jSONObjectOptJSONObject.getInt("output_tokens"));
            } else if (jSONObjectOptJSONObject.has("completion_tokens")) {
                jSONObject2.put("output_tokens", jSONObjectOptJSONObject.getInt("completion_tokens"));
            } else if (jSONObjectOptJSONObject.has("output")) {
                jSONObject2.put("output_tokens", jSONObjectOptJSONObject.getInt("output"));
            }
            if (jSONObjectOptJSONObject.has("cacheRead")) {
                jSONObject2.put("cache_read_input_tokens", jSONObjectOptJSONObject.getInt("cacheRead"));
            }
            if (jSONObjectOptJSONObject.has("cache_read_input_tokens")) {
                jSONObject2.put("cache_read_input_tokens", jSONObjectOptJSONObject.getInt("cache_read_input_tokens"));
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("usage", jSONObject2);
            }
        }
        if (jSONObject.length() > 0) {
            return jSONObject.toString();
        }
        return null;
    }

    private final String firstNonBlankJsonString(JSONObject root, String... keys) {
        for (String str : keys) {
            if (root.has(str) && !root.isNull(str)) {
                String strOptString = root.optString(str, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                p.d(strOptString, "optString(...)");
                String string = n.T1(strOptString).toString();
                if (string.length() > 0) {
                    return string;
                }
            }
        }
        return null;
    }

    private final boolean isAbortLikeError(String error) {
        Locale US = Locale.US;
        p.d(US, "US");
        String lowerCase = error.toLowerCase(US);
        p.d(lowerCase, "toLowerCase(...)");
        return n.g1(lowerCase, "abort", false) || n.g1(lowerCase, "cancel", false) || n.g1(lowerCase, "stopreason=rpc", false) || n.g1(lowerCase, "stopped by rpc", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setEncodeDefaults(true);
        return a0.f883a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:3:0x0009, B:5:0x0023, B:7:0x002d, B:25:0x0057, B:27:0x005d, B:29:0x0067, B:33:0x006f, B:37:0x007e, B:41:0x008e, B:46:0x009b, B:49:0x00a6, B:52:0x00b2, B:15:0x003b, B:17:0x0041, B:19:0x004b), top: B:59:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String handleAgentEnd(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.edge.intercept.handlers.AgentHookHandler.handleAgentEnd(java.lang.String):java.lang.String");
    }

    public final String handleBeforeAgentStart(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            ALog.d$default(TAG, "before_agent_start: sessionId=" + ((BeforeAgentStartRequest) json2.decodeFromString(BeforeAgentStartRequest.INSTANCE.serializer(), body)).getSessionId(), null, 4, null);
            BeforeAgentStartResponse.Companion companion = BeforeAgentStartResponse.INSTANCE;
            return json2.encodeToString(companion.serializer(), companion.empty());
        } catch (Exception e9) {
            f.l("before_agent_start error: ", e9.getMessage(), TAG, e9);
            Json json3 = json;
            BeforeAgentStartResponse.Companion companion2 = BeforeAgentStartResponse.INSTANCE;
            return json3.encodeToString(companion2.serializer(), companion2.empty());
        }
    }

    public final String handleBeforeModelResolve(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            ALog.d$default(TAG, "before_model_resolve: sessionId=" + ((BeforeModelResolveRequest) json2.decodeFromString(BeforeModelResolveRequest.INSTANCE.serializer(), body)).getSessionId(), null, 4, null);
            BeforeModelResolveResponse.Companion companion = BeforeModelResolveResponse.INSTANCE;
            return json2.encodeToString(companion.serializer(), companion.empty());
        } catch (Exception e9) {
            f.l("before_model_resolve error: ", e9.getMessage(), TAG, e9);
            Json json3 = json;
            BeforeModelResolveResponse.Companion companion2 = BeforeModelResolveResponse.INSTANCE;
            return json3.encodeToString(companion2.serializer(), companion2.empty());
        }
    }

    public final String handleBeforePromptBuild(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            ALog.d$default(TAG, "before_prompt_build: sessionId=" + ((BeforePromptBuildRequest) json2.decodeFromString(BeforePromptBuildRequest.INSTANCE.serializer(), body)).getSessionId(), null, 4, null);
            BeforePromptBuildResponse.Companion companion = BeforePromptBuildResponse.INSTANCE;
            return json2.encodeToString(companion.serializer(), companion.empty());
        } catch (Exception e9) {
            f.l("before_prompt_build error: ", e9.getMessage(), TAG, e9);
            Json json3 = json;
            BeforePromptBuildResponse.Companion companion2 = BeforePromptBuildResponse.INSTANCE;
            return json3.encodeToString(companion2.serializer(), companion2.empty());
        }
    }

    public final String handleCronSessionStart(String body) {
        ClawReporter reporter;
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            CronSessionStartRequest cronSessionStartRequest = (CronSessionStartRequest) json2.decodeFromString(CronSessionStartRequest.INSTANCE.serializer(), body);
            String strA = a.a();
            String sessionKey = cronSessionStartRequest.getSessionKey();
            if (sessionKey != null) {
                if (n.t1(sessionKey)) {
                    sessionKey = null;
                }
                if (sessionKey != null && (reporter = ClawReportBridge.INSTANCE.getReporter()) != null) {
                    reporter.seedTraceId(sessionKey, strA);
                }
            }
            ALog.i$default(TAG, "[trace] cron_session_start: sessionKey=" + cronSessionStartRequest.getSessionKey() + " jobId=" + cronSessionStartRequest.getJobId() + " traceId=" + strA, null, 4, null);
            return json2.encodeToString(CronSessionStartResponse.INSTANCE.serializer(), new CronSessionStartResponse(strA));
        } catch (Exception e9) {
            ALog.w(TAG, "cron_session_start error: " + e9.getMessage(), e9);
            return f.d("{\"traceId\":\"", a.a(), "\"}");
        }
    }

    public final String handleLlmInput(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            LlmInputRequest llmInputRequest = (LlmInputRequest) json2.decodeFromString(LlmInputRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "[trace] llm_input: sessionKey=" + llmInputRequest.getSessionKey() + " model=" + llmInputRequest.getModel() + " traceId=" + llmInputRequest.getTraceId(), null, 4, null);
            ClawReporter reporter = ClawReportBridge.INSTANCE.getReporter();
            if (reporter != null) {
                String sessionKey = llmInputRequest.getSessionKey();
                String runId = llmInputRequest.getRunId();
                String llmRequestId = llmInputRequest.getLlmRequestId();
                Integer requestSeq = llmInputRequest.getRequestSeq();
                String provider = llmInputRequest.getProvider();
                String model = llmInputRequest.getModel();
                String systemPrompt = llmInputRequest.getSystemPrompt();
                String prompt = llmInputRequest.getPrompt();
                JsonElement finalRequestPayload = llmInputRequest.getFinalRequestPayload();
                String string = finalRequestPayload != null ? finalRequestPayload.toString() : null;
                JsonElement requestEnvelope = llmInputRequest.getRequestEnvelope();
                reporter.onLlmInput(sessionKey, runId, llmRequestId, requestSeq, provider, model, systemPrompt, prompt, string, requestEnvelope != null ? requestEnvelope.toString() : null, llmInputRequest.getAgentId(), llmInputRequest.getAgentName(), llmInputRequest.getSessionKey(), llmInputRequest.getTraceId());
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("llm_input error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }

    public final String handleLlmOutput(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            LlmOutputRequest llmOutputRequest = (LlmOutputRequest) json2.decodeFromString(LlmOutputRequest.INSTANCE.serializer(), body);
            String sessionKey = llmOutputRequest.getSessionKey();
            String model = llmOutputRequest.getModel();
            String traceId = llmOutputRequest.getTraceId();
            LlmUsage usage = llmOutputRequest.getUsage();
            Integer input = usage != null ? usage.getInput() : null;
            LlmUsage usage2 = llmOutputRequest.getUsage();
            Integer output = usage2 != null ? usage2.getOutput() : null;
            LlmUsage usage3 = llmOutputRequest.getUsage();
            Integer cacheRead = usage3 != null ? usage3.getCacheRead() : null;
            LlmUsage usage4 = llmOutputRequest.getUsage();
            Integer cacheWrite = usage4 != null ? usage4.getCacheWrite() : null;
            LlmUsage usage5 = llmOutputRequest.getUsage();
            ALog.d$default(TAG, "[trace] llm_output: sessionKey=" + sessionKey + " model=" + model + " traceId=" + traceId + " usage=[in=" + input + " out=" + output + " cache_r=" + cacheRead + " cache_w=" + cacheWrite + " total=" + (usage5 != null ? usage5.getTotal() : null) + "]", null, 4, null);
            JSONObject jSONObject = new JSONObject(body);
            LlmUsage usage6 = llmOutputRequest.getUsage();
            ClawReporter reporter = ClawReportBridge.INSTANCE.getReporter();
            if (reporter != null) {
                String sessionKey2 = llmOutputRequest.getSessionKey();
                String strFirstNonBlankJsonString = firstNonBlankJsonString(jSONObject, "runId", "run_id");
                if (strFirstNonBlankJsonString == null) {
                    strFirstNonBlankJsonString = llmOutputRequest.getRunId();
                }
                String str = strFirstNonBlankJsonString;
                String strFirstNonBlankJsonString2 = firstNonBlankJsonString(jSONObject, "llmRequestId", "llm_request_id");
                if (strFirstNonBlankJsonString2 == null) {
                    strFirstNonBlankJsonString2 = llmOutputRequest.getLlmRequestId();
                }
                String str2 = strFirstNonBlankJsonString2;
                String provider = llmOutputRequest.getProvider();
                String model2 = llmOutputRequest.getModel();
                String response = llmOutputRequest.getResponse();
                String str3 = response == null ? body : response;
                JsonElement sessionResponse = llmOutputRequest.getSessionResponse();
                reporter.onLlmOutput(sessionKey2, str, str2, provider, model2, str3, sessionResponse != null ? sessionResponse.toString() : null, llmOutputRequest.getAgentId(), llmOutputRequest.getAgentName(), llmOutputRequest.getSessionKey(), llmOutputRequest.getTraceId(), usage6 != null, usage6 != null ? usage6.getInput() : null, usage6 != null ? usage6.getOutput() : null, usage6 != null ? usage6.getCacheRead() : null);
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("llm_output error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }
}
