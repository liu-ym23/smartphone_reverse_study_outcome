package com.stepos.stepclaw.edge.intercept.handlers;

import a.a;
import a8.b;
import b5.a0;
import b5.g;
import b5.h;
import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.track.ClawReportBridge;
import com.stepos.stepclaw.base.track.ClawReporter;
import com.stepos.stepclaw.base.track.ToolCallReportPhase;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.edge.intercept.model.AfterToolCallRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforeMessageWriteRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforeMessageWriteResponse;
import com.stepos.stepclaw.edge.intercept.model.BeforeToolCallRequest;
import com.stepos.stepclaw.edge.intercept.model.BeforeToolCallResponse;
import com.stepos.stepclaw.edge.intercept.model.HookResponseJson;
import com.stepos.stepclaw.edge.intercept.model.ToolResultPersistRequest;
import com.stepos.stepclaw.edge.intercept.model.ToolResultPersistResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import m0.f;
import org.json.JSONObject;
import x5.j;
import x5.l;
import x5.m;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\n\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014JI\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u0011J!\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\"\u0010\rJ#\u0010#\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b%\u0010\u0014J%\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0&2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t¢\u0006\u0004\b*\u0010\u0014J\u0015\u0010+\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t¢\u0006\u0004\b+\u0010\u0014J\u0015\u0010,\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t¢\u0006\u0004\b,\u0010\u0014J\u0015\u0010-\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t¢\u0006\u0004\b-\u0010\u0014J\u0015\u0010.\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t¢\u0006\u0004\b.\u0010\u0014¨\u00060"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/handlers/ToolHookHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallRequest;", "request", "Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallResponse;", "evaluateRules", "(Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallRequest;)Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "filePath", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isMemoryFile", "(Ljava/lang/String;)Z", "Lkotlinx/serialization/json/JsonElement;", "params", "extractExecCommand", "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/String;", "command", "detectDangerousSdCardDeleteCommand", "(Ljava/lang/String;)Ljava/lang/String;", "sessionId", "sessionKey", "runId", "hookTraceId", "toolCallId", "Lb5/a0;", "reportMemorySearchDownlinkFromAppendMmr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;)V", "extractMemoryAppendMmrContent", "toolName", "extractFilePath", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/String;", "paramsStr", "isJsonObjectSingleKeyPair", "isSkillMarkdownRead", "(Ljava/lang/String;Ljava/lang/String;)Z", "parseSkillIdFromSkillMdPath", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "skillConfigMapForSkillMdRead", "(Ljava/lang/String;)Ljava/util/Map;", "body", "handleBeforeToolCall", "handleAfterToolCall", "handleToolClientCorrelation", "handleToolResultPersist", "handleBeforeMessageWrite", "Companion", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ToolHookHandler {
    private static final l CD_TO_SD_CARD_WITH_FIND_DELETE_REGEX;
    private static final l CD_TO_SD_CARD_WITH_RM_REGEX;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXEC_SD_CARD_DELETE_BLOCK_REASON = "删除手机存储文件必须使用 ability.call file_safe_delete（先 ability.list 拿到方法名），禁止直接使用 shell 删除命令；请先枚举目标文件，再逐个走回收站链路。";
    private static final l FIND_DELETE_ON_SD_CARD_REGEX;
    private static final l FIND_EXEC_RM_ON_SD_CARD_REGEX;
    private static final l FIND_XARGS_RM_ON_SD_CARD_REGEX;
    private static final int LOG_CHUNK_SIZE = 3500;
    private static final l RM_ON_SD_CARD_REGEX;
    private static final l SKILL_MD_PATH_REGEX;
    private static final String TAG = "ToolHookHandler";
    private static final String TOOL_STEPCLAW_MEMORY_APPEND_MMR = "stepclaw_memory_append_mmr";
    private static final Json json;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u0004*\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u0004*\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0004*\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010!\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010$R\u0014\u0010)\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010$R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010.\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010,R\u0014\u0010/\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010,R\u0014\u00100\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010,R\u0014\u00101\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010,R\u0014\u00102\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010,R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/handlers/ToolHookHandler$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "body", "Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallRequest;", "parseBeforeToolCallRequest", "(Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallRequest;", "Lcom/stepos/stepclaw/edge/intercept/model/AfterToolCallRequest;", "parseAfterToolCallRequest", "(Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/AfterToolCallRequest;", "Lkotlinx/serialization/json/JsonObject;", "key", "stringOrNull", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/String;", "primitiveStringOrNull", "toolCallIdFromHookBody", "(Lkotlinx/serialization/json/JsonObject;)Ljava/lang/String;", "request", "resolveToolCallIdForBefore", "(Lcom/stepos/stepclaw/edge/intercept/model/BeforeToolCallRequest;)Ljava/lang/String;", "resolveToolCallIdForAfter", "(Lcom/stepos/stepclaw/edge/intercept/model/AfterToolCallRequest;)Ljava/lang/String;", "Lkotlinx/serialization/json/JsonElement;", "el", "extractToolCallIdFromJsonElement", "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/String;", "Lkotlin/Function1;", "Lb5/a0;", "log", "label", "text", "logChunked", "(Lp5/l;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "LOG_CHUNK_SIZE", "I", "TOOL_STEPCLAW_MEMORY_APPEND_MMR", "EXEC_SD_CARD_DELETE_BLOCK_REASON", "Lx5/l;", "SKILL_MD_PATH_REGEX", "Lx5/l;", "FIND_DELETE_ON_SD_CARD_REGEX", "FIND_EXEC_RM_ON_SD_CARD_REGEX", "FIND_XARGS_RM_ON_SD_CARD_REGEX", "RM_ON_SD_CARD_REGEX", "CD_TO_SD_CARD_WITH_RM_REGEX", "CD_TO_SD_CARD_WITH_FIND_DELETE_REGEX", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/Json;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private final String extractToolCallIdFromJsonElement(JsonElement el) {
            Object objO;
            if (!p.a(el, JsonNull.INSTANCE)) {
                JsonObject jsonObject = el instanceof JsonObject ? (JsonObject) el : null;
                if (jsonObject != null) {
                    Iterator it = c5.l.S(new String[]{"toolCallId", "tool_call_id"}).iterator();
                    while (it.hasNext()) {
                        Object obj = jsonObject.get(it.next());
                        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
                        if (jsonPrimitive != null) {
                            try {
                                objO = jsonPrimitive.getContent();
                            } catch (Throwable th) {
                                objO = a.o(th);
                            }
                            if (objO instanceof h) {
                                objO = null;
                            }
                            String str = (String) objO;
                            String string = str != null ? n.T1(str).toString() : null;
                            if (string == null) {
                                string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                            }
                            if (string.length() > 0) {
                                return string;
                            }
                        }
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void logChunked(p5.l log, String label, String text) {
            if (text == null || text.length() == 0) {
                log.invoke(label + ": <empty>");
                return;
            }
            if (text.length() <= ToolHookHandler.LOG_CHUNK_SIZE) {
                log.invoke(label + ": " + text);
                return;
            }
            int length = (text.length() + 3499) / ToolHookHandler.LOG_CHUNK_SIZE;
            int i8 = 0;
            int i9 = 0;
            while (i8 < text.length()) {
                int iMin = Math.min(i8 + ToolHookHandler.LOG_CHUNK_SIZE, text.length());
                i9++;
                String strSubstring = text.substring(i8, iMin);
                p.d(strSubstring, "substring(...)");
                log.invoke(label + " [" + i9 + "/" + length + "]: " + strSubstring);
                i8 = iMin;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AfterToolCallRequest parseAfterToolCallRequest(String body) throws Exception {
            try {
                return (AfterToolCallRequest) ToolHookHandler.json.decodeFromString(AfterToolCallRequest.INSTANCE.serializer(), body);
            } catch (Exception e9) {
                ALog.w$default(ToolHookHandler.TAG, f.c("AfterToolCallRequest decode failed, lenient parse: ", e9.getMessage()), null, 4, null);
                try {
                    JsonElement toJsonElement = Json.INSTANCE.parseToJsonElement(body);
                    JsonObject jsonObject = toJsonElement instanceof JsonObject ? (JsonObject) toJsonElement : null;
                    if (jsonObject == null) {
                        throw e9;
                    }
                    String strStringOrNull = stringOrNull(jsonObject, "sessionId");
                    String strStringOrNull2 = stringOrNull(jsonObject, "sessionKey");
                    String strPrimitiveStringOrNull = primitiveStringOrNull(jsonObject, "runId");
                    String strStringOrNull3 = stringOrNull(jsonObject, "toolName");
                    String str = toolCallIdFromHookBody(jsonObject);
                    JsonElement jsonElement = (JsonElement) jsonObject.get("params");
                    if (jsonElement == null) {
                        jsonElement = JsonNull.INSTANCE;
                    }
                    JsonElement jsonElement2 = jsonElement;
                    JsonElement jsonElement3 = (JsonElement) jsonObject.get("result");
                    if (jsonElement3 == null) {
                        jsonElement3 = JsonNull.INSTANCE;
                    }
                    return new AfterToolCallRequest(strStringOrNull, strStringOrNull2, strPrimitiveStringOrNull, strStringOrNull3, str, jsonElement2, jsonElement3, stringOrNull(jsonObject, "error"), stringOrNull(jsonObject, "timestamp"), stringOrNull(jsonObject, "traceId"));
                } catch (Exception e10) {
                    ALog.w$default(ToolHookHandler.TAG, f.c("AfterToolCallRequest lenient parse failed: ", e10.getMessage()), null, 4, null);
                    throw e9;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BeforeToolCallRequest parseBeforeToolCallRequest(String body) throws Exception {
            try {
                return (BeforeToolCallRequest) ToolHookHandler.json.decodeFromString(BeforeToolCallRequest.INSTANCE.serializer(), body);
            } catch (Exception e9) {
                ALog.w$default(ToolHookHandler.TAG, f.c("BeforeToolCallRequest decode failed, lenient parse: ", e9.getMessage()), null, 4, null);
                try {
                    JsonElement toJsonElement = Json.INSTANCE.parseToJsonElement(body);
                    JsonObject jsonObject = toJsonElement instanceof JsonObject ? (JsonObject) toJsonElement : null;
                    if (jsonObject == null) {
                        throw e9;
                    }
                    String strStringOrNull = stringOrNull(jsonObject, "sessionId");
                    String strStringOrNull2 = stringOrNull(jsonObject, "sessionKey");
                    String strStringOrNull3 = stringOrNull(jsonObject, "toolName");
                    String strPrimitiveStringOrNull = primitiveStringOrNull(jsonObject, "runId");
                    String str = toolCallIdFromHookBody(jsonObject);
                    JsonElement jsonElement = (JsonElement) jsonObject.get("params");
                    if (jsonElement == null) {
                        jsonElement = JsonNull.INSTANCE;
                    }
                    return new BeforeToolCallRequest(strStringOrNull, strStringOrNull2, strStringOrNull3, strPrimitiveStringOrNull, str, jsonElement, stringOrNull(jsonObject, "timestamp"), stringOrNull(jsonObject, "traceId"));
                } catch (Exception e10) {
                    ALog.w$default(ToolHookHandler.TAG, f.c("BeforeToolCallRequest lenient parse failed: ", e10.getMessage()), null, 4, null);
                    throw e9;
                }
            }
        }

        private final String primitiveStringOrNull(JsonObject jsonObject, String str) {
            Object objO;
            String string;
            JsonElement jsonElement = (JsonElement) jsonObject.get((Object) str);
            if (jsonElement != null) {
                JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
                if (jsonPrimitive != null) {
                    try {
                        objO = jsonPrimitive.getContent();
                    } catch (Throwable th) {
                        objO = a.o(th);
                    }
                    if (objO instanceof h) {
                        objO = null;
                    }
                    String str2 = (String) objO;
                    if (str2 == null || (string = n.T1(str2).toString()) == null || string.length() <= 0) {
                        return null;
                    }
                    return string;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String resolveToolCallIdForAfter(AfterToolCallRequest request) {
            String string;
            String toolCallId = request.getToolCallId();
            if (toolCallId != null && (string = n.T1(toolCallId).toString()) != null) {
                if (string.length() <= 0) {
                    string = null;
                }
                if (string != null) {
                    return string;
                }
            }
            String strExtractToolCallIdFromJsonElement = extractToolCallIdFromJsonElement(request.getParams());
            if (strExtractToolCallIdFromJsonElement != null) {
                return strExtractToolCallIdFromJsonElement;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String resolveToolCallIdForBefore(BeforeToolCallRequest request) {
            String string;
            String toolCallId = request.getToolCallId();
            if (toolCallId != null && (string = n.T1(toolCallId).toString()) != null) {
                if (string.length() <= 0) {
                    string = null;
                }
                if (string != null) {
                    return string;
                }
            }
            String strExtractToolCallIdFromJsonElement = extractToolCallIdFromJsonElement(request.getParams());
            if (strExtractToolCallIdFromJsonElement != null) {
                return strExtractToolCallIdFromJsonElement;
            }
            return null;
        }

        private final String stringOrNull(JsonObject jsonObject, String str) {
            Object objO;
            JsonElement jsonElement = (JsonElement) jsonObject.get((Object) str);
            if (jsonElement == null) {
                return null;
            }
            try {
                objO = JsonElementKt.getJsonPrimitive(jsonElement).getContent();
            } catch (Throwable th) {
                objO = a.o(th);
            }
            if (objO instanceof h) {
                objO = null;
            }
            String str2 = (String) objO;
            if (str2 == null || str2.length() <= 0) {
                return null;
            }
            return str2;
        }

        private final String toolCallIdFromHookBody(JsonObject jsonObject) {
            String string;
            Object objO;
            Iterator it = c5.l.S(new String[]{"toolCallId", "tool_call_id"}).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JsonElement jsonElement = (JsonElement) jsonObject.get(it.next());
                if (jsonElement != null) {
                    JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
                    if (jsonPrimitive == null) {
                        continue;
                    } else {
                        try {
                            objO = jsonPrimitive.getContent();
                        } catch (Throwable th) {
                            objO = a.o(th);
                        }
                        if (objO instanceof h) {
                            objO = null;
                        }
                        String str = (String) objO;
                        string = str != null ? n.T1(str).toString() : null;
                        if (string == null) {
                            string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        if (string.length() > 0) {
                            break;
                        }
                    }
                }
            }
            return string;
        }

        private Companion() {
        }
    }

    static {
        m mVar = m.f6302b;
        SKILL_MD_PATH_REGEX = new l("skills/([^/]+)/SKILL\\.md$", mVar);
        m mVar2 = m.d;
        FIND_DELETE_ON_SD_CARD_REGEX = new l("\\bfind\\b[^\\n]*(/sdcard|/storage/emulated/0)[^\\n]*\\s-delete(\\s|$)", c5.l.k0(new m[]{mVar, mVar2}));
        FIND_EXEC_RM_ON_SD_CARD_REGEX = new l("\\bfind\\b[^\\n]*(/sdcard|/storage/emulated/0)[^\\n]*\\s-exec\\s+(/bin/rm|rm)\\b", c5.l.k0(new m[]{mVar, mVar2}));
        FIND_XARGS_RM_ON_SD_CARD_REGEX = new l("\\bfind\\b[^\\n]*(/sdcard|/storage/emulated/0)[^\\n]*\\|\\s*xargs\\s+(/bin/rm|rm)\\b", c5.l.k0(new m[]{mVar, mVar2}));
        RM_ON_SD_CARD_REGEX = new l("(^|[;&|()]\\s*|\\s)(/bin/rm|rm)\\b[^\\n]*(/sdcard|/storage/emulated/0)", c5.l.k0(new m[]{mVar, mVar2}));
        CD_TO_SD_CARD_WITH_RM_REGEX = new l("\\bcd\\s+(/sdcard|/storage/emulated/0)(/|\\b)[^\\n]*(&&|;)[^\\n]*\\b(/bin/rm|rm)\\b", c5.l.k0(new m[]{mVar, mVar2}));
        CD_TO_SD_CARD_WITH_FIND_DELETE_REGEX = new l("\\bcd\\s+(/sdcard|/storage/emulated/0)(/|\\b)[^\\n]*(&&|;)[^\\n]*\\bfind\\b[^\\n]*\\s-delete(\\s|$)", c5.l.k0(new m[]{mVar, mVar2}));
        json = JsonKt.Json$default(null, new o3.a(0), 1, null);
    }

    private final String detectDangerousSdCardDeleteCommand(String command) {
        if (command == null || n.t1(command)) {
            return null;
        }
        if (FIND_DELETE_ON_SD_CARD_REGEX.a(command) || CD_TO_SD_CARD_WITH_FIND_DELETE_REGEX.a(command) || FIND_EXEC_RM_ON_SD_CARD_REGEX.a(command) || FIND_XARGS_RM_ON_SD_CARD_REGEX.a(command) || RM_ON_SD_CARD_REGEX.a(command) || CD_TO_SD_CARD_WITH_RM_REGEX.a(command)) {
            return EXEC_SD_CARD_DELETE_BLOCK_REASON;
        }
        return null;
    }

    private final BeforeToolCallResponse evaluateRules(BeforeToolCallRequest request) {
        String strExtractExecCommand;
        String strDetectDangerousSdCardDeleteCommand;
        String toolName = request.getToolName();
        if (toolName == null) {
            toolName = "unknown";
        }
        if (toolName.equalsIgnoreCase("exec") && (strDetectDangerousSdCardDeleteCommand = detectDangerousSdCardDeleteCommand((strExtractExecCommand = extractExecCommand(request.getParams())))) != null) {
            StringBuilder sbV = b.v("before_tool_call: blocking dangerous exec delete sessionKey=", request.getSessionKey(), " runId=", request.getRunId(), " reason=");
            sbV.append(strDetectDangerousSdCardDeleteCommand);
            ALog.w$default(TAG, sbV.toString(), null, 4, null);
            INSTANCE.logChunked(new o3.a(1), "Blocked exec command", strExtractExecCommand);
            return BeforeToolCallResponse.INSTANCE.block(strDetectDangerousSdCardDeleteCommand);
        }
        String strExtractFilePath = extractFilePath(toolName, request.getParams());
        if (toolName.equals("cron")) {
            ALog.d$default(TAG, f.d("before_tool_call: cron, sessionKey=", request.getSessionKey(), " (delivery handled by android-node)"), null, 4, null);
            return BeforeToolCallResponse.INSTANCE.allow();
        }
        if (isMemoryFile(strExtractFilePath) && c5.n.k0("read", "edit", "write", "apply_patch").contains(toolName)) {
            ALog.i$default(TAG, b.p("Memory file operation: tool=", toolName, " file=", strExtractFilePath), null, 4, null);
            return BeforeToolCallResponse.INSTANCE.allow();
        }
        ALog.d$default(TAG, "before_tool_call: allowing ".concat(toolName), null, 4, null);
        return BeforeToolCallResponse.INSTANCE.allow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 evaluateRules$lambda$0$0(String it) {
        p.e(it, "it");
        ALog.w$default(TAG, it, null, 4, null);
        return a0.f883a;
    }

    private final String extractExecCommand(JsonElement params) {
        String strOptString;
        String string;
        try {
            JSONObject jSONObject = params instanceof JsonObject ? new JSONObject(((JsonObject) params).toString()) : ((params instanceof JsonPrimitive) && ((JsonPrimitive) params).getIsString()) ? new JSONObject(((JsonPrimitive) params).getContent()) : null;
            if (jSONObject != null && (strOptString = jSONObject.optString("command")) != null && (string = n.T1(strOptString).toString()) != null) {
                if (string.length() > 0) {
                    return string;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private final String extractFilePath(String toolName, JsonElement params) {
        String strOptString;
        String strOptString2;
        String string;
        String strOptString3;
        try {
            JSONObject jSONObject = params instanceof JsonObject ? new JSONObject(((JsonObject) params).toString()) : ((params instanceof JsonPrimitive) && ((JsonPrimitive) params).getIsString()) ? new JSONObject(((JsonPrimitive) params).getContent()) : null;
            switch (toolName.hashCode()) {
                case -1526776777:
                    if (toolName.equals("apply_patch")) {
                        if (jSONObject != null && (strOptString = jSONObject.optString("file")) != null) {
                            return strOptString;
                        }
                        if (jSONObject != null) {
                            return jSONObject.optString("filePath");
                        }
                        return null;
                    }
                    return null;
                case 3108362:
                    if (!toolName.equals("edit")) {
                        return null;
                    }
                    break;
                case 3496342:
                    if (!toolName.equals("read")) {
                        return null;
                    }
                    break;
                case 113399775:
                    if (toolName.equals("write")) {
                        break;
                    }
                    return null;
                default:
                    return null;
            }
            String string2 = (jSONObject == null || (strOptString3 = jSONObject.optString("file_path")) == null) ? null : n.T1(strOptString3).toString();
            if (string2 == null) {
                string2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            if (string2.length() > 0) {
                return string2;
            }
            if (jSONObject == null || (strOptString2 = jSONObject.optString("path")) == null || (string = n.T1(strOptString2).toString()) == null || string.length() <= 0) {
                return null;
            }
            return string;
        } catch (Exception unused) {
            return null;
        }
    }

    private final String extractMemoryAppendMmrContent(JsonElement params) {
        String string;
        String strOptString;
        try {
            JSONObject jSONObject = params instanceof JsonObject ? new JSONObject(((JsonObject) params).toString()) : ((params instanceof JsonPrimitive) && ((JsonPrimitive) params).getIsString()) ? new JSONObject(((JsonPrimitive) params).getContent()) : null;
            string = (jSONObject == null || (strOptString = jSONObject.optString("content")) == null) ? null : n.T1(strOptString).toString();
            if (string == null) {
                string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
        } catch (Exception unused) {
        }
        if (string.length() > 0) {
            return string;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 handleAfterToolCall$lambda$0(String it) {
        p.e(it, "it");
        ALog.i$default(TAG, it, null, 4, null);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 handleBeforeToolCall$lambda$0(String it) {
        p.e(it, "it");
        ALog.d$default(TAG, it, null, 4, null);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 handleToolClientCorrelation$lambda$0(String it) {
        p.e(it, "it");
        ALog.i$default(TAG, it, null, 4, null);
        return a0.f883a;
    }

    private final boolean isJsonObjectSingleKeyPair(String paramsStr) {
        if (paramsStr != null && !n.t1(paramsStr)) {
            try {
                if (new JSONObject(n.T1(paramsStr).toString()).length() == 1) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private final boolean isMemoryFile(String filePath) {
        if (filePath != null && !n.t1(filePath)) {
            String strA1 = u.a1(filePath, "\\", "/");
            if (!n.g1(strA1, "MEMORY.md", true) && !n.g1(strA1, "/memory/", false) && !n.g1(strA1, ".openclaw/memory/", false)) {
                Pattern patternCompile = Pattern.compile("^.*/memory/\\d{4}-\\d{2}-\\d{2}\\.md$");
                p.d(patternCompile, "compile(...)");
                if (patternCompile.matcher(strA1).matches()) {
                }
            }
            return true;
        }
        return false;
    }

    private final boolean isSkillMarkdownRead(String toolName, String filePath) {
        if (!u.W0(toolName, "read") || filePath == null || n.t1(filePath)) {
            return false;
        }
        return SKILL_MD_PATH_REGEX.a(n.T1(u.a1(filePath, "\\", "/")).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setEncodeDefaults(true);
        Json.setLenient(true);
        return a0.f883a;
    }

    private final String parseSkillIdFromSkillMdPath(String filePath) {
        String str;
        if (filePath == null || n.t1(filePath)) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        j jVarB = l.b(SKILL_MD_PATH_REGEX, n.T1(u.a1(filePath, "\\", "/")).toString());
        String string = (jVarB == null || (str = (String) c5.m.w0(1, jVarB.a())) == null) ? null : n.T1(str).toString();
        return string == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : string;
    }

    private final void reportMemorySearchDownlinkFromAppendMmr(String sessionId, String sessionKey, String runId, JsonElement params, String hookTraceId, String toolCallId) {
        ClawReporter reporter;
        String strExtractMemoryAppendMmrContent = extractMemoryAppendMmrContent(params);
        if (strExtractMemoryAppendMmrContent == null || (reporter = ClawReportBridge.INSTANCE.getReporter()) == null) {
            return;
        }
        if (reporter.hasMemorySearchUplinkReported(sessionId, runId, sessionKey)) {
            reporter.onToolCall(sessionId, runId, "memory_search", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, strExtractMemoryAppendMmrContent, null, toolCallId, null, ToolCallReportPhase.AFTER, sessionKey, hookTraceId);
        } else {
            ALog.d$default(TAG, "memory_search downlink (append_mmr): skip, no memory_search uplink for this session/run", null, 4, null);
        }
    }

    private final Map<String, String> skillConfigMapForSkillMdRead(String filePath) {
        String skillIdFromSkillMdPath = parseSkillIdFromSkillMdPath(filePath);
        return z.U(new g("skill_id", skillIdFromSkillMdPath), new g("skill_name", skillIdFromSkillMdPath), new g("skill_source", "skill_md_read"));
    }

    public final String handleAfterToolCall(String body) {
        String str;
        ClawReporter reporter;
        p.e(body, "body");
        try {
            Companion companion = INSTANCE;
            AfterToolCallRequest afterToolCallRequest = companion.parseAfterToolCallRequest(body);
            ALog.d$default(TAG, "[trace] after_tool_call: sessionId=" + afterToolCallRequest.getSessionId() + " runId=" + afterToolCallRequest.getRunId() + " traceId=" + afterToolCallRequest.getTraceId() + " toolName=" + afterToolCallRequest.getToolName() + " toolCallId=" + afterToolCallRequest.getToolCallId(), null, 4, null);
            String resultText = afterToolCallRequest.getResultText();
            if (resultText != null) {
                str = resultText;
            } else if (p.a(afterToolCallRequest.getResult(), JsonNull.INSTANCE)) {
                str = null;
            } else {
                resultText = afterToolCallRequest.getResult().toString();
                str = resultText;
            }
            companion.logChunked(new o3.a(4), "Tool result", str);
            String error = afterToolCallRequest.getError();
            if (error != null) {
                if (n.t1(error)) {
                    error = null;
                }
                if (error != null) {
                    ALog.w$default(TAG, "Tool error: ".concat(error), null, 4, null);
                }
            }
            String string = p.a(afterToolCallRequest.getParams(), JsonNull.INSTANCE) ? null : afterToolCallRequest.getParams().toString();
            String strResolveToolCallIdForAfter = companion.resolveToolCallIdForAfter(afterToolCallRequest);
            String toolName = afterToolCallRequest.getToolName();
            String string2 = toolName != null ? n.T1(toolName).toString() : null;
            if (string2 == null) {
                string2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            if (!string2.equalsIgnoreCase(TOOL_STEPCLAW_MEMORY_APPEND_MMR) && (reporter = ClawReportBridge.INSTANCE.getReporter()) != null) {
                reporter.onToolCall(afterToolCallRequest.getSessionId(), afterToolCallRequest.getRunId(), afterToolCallRequest.getToolName(), string, str, afterToolCallRequest.getError(), strResolveToolCallIdForAfter, null, ToolCallReportPhase.AFTER, afterToolCallRequest.getSessionKey(), afterToolCallRequest.getTraceId());
            }
            String toolName2 = afterToolCallRequest.getToolName();
            if (toolName2 == null) {
                toolName2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            String strExtractFilePath = extractFilePath(toolName2, afterToolCallRequest.getParams());
            if (isJsonObjectSingleKeyPair(string) && isSkillMarkdownRead(afterToolCallRequest.getToolName(), strExtractFilePath)) {
                String error2 = afterToolCallRequest.getError();
                String string3 = error2 != null ? n.T1(error2).toString() : null;
                if (string3 == null) {
                    string3 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                }
                if (str == null || n.t1(str)) {
                    str = string3.length() > 0 ? string3 : ConfigIpcContract.KEY_OK;
                }
                ALog.d$default(TAG, "skill_call: onSkillEnd (read SKILL.md) path=" + strExtractFilePath, null, 4, null);
                ClawReporter reporter2 = ClawReportBridge.INSTANCE.getReporter();
                if (reporter2 != null) {
                    reporter2.onSkillEnd(afterToolCallRequest.getSessionId(), afterToolCallRequest.getSessionId(), str, afterToolCallRequest.getTraceId());
                }
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("after_tool_call error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }

    public final String handleBeforeMessageWrite(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            BeforeMessageWriteRequest beforeMessageWriteRequest = (BeforeMessageWriteRequest) json2.decodeFromString(BeforeMessageWriteRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "[trace] before_message_write: sessionId=" + beforeMessageWriteRequest.getSessionId() + " traceId=" + beforeMessageWriteRequest.getTraceId(), null, 4, null);
            BeforeMessageWriteResponse.Companion companion = BeforeMessageWriteResponse.INSTANCE;
            return json2.encodeToString(companion.serializer(), companion.empty());
        } catch (Exception e9) {
            f.l("before_message_write error: ", e9.getMessage(), TAG, e9);
            Json json3 = json;
            BeforeMessageWriteResponse.Companion companion2 = BeforeMessageWriteResponse.INSTANCE;
            return json3.encodeToString(companion2.serializer(), companion2.empty());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012a A[Catch: Exception -> 0x0095, TryCatch #0 {Exception -> 0x0095, blocks: (B:3:0x000d, B:7:0x007b, B:9:0x008c, B:17:0x009f, B:19:0x00a7, B:24:0x00f3, B:27:0x00fb, B:29:0x0109, B:31:0x0113, B:33:0x012a, B:34:0x013e, B:21:0x00c3, B:23:0x00cf, B:6:0x0072), top: B:38:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String handleBeforeToolCall(java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.edge.intercept.handlers.ToolHookHandler.handleBeforeToolCall(java.lang.String):java.lang.String");
    }

    public final String handleToolClientCorrelation(String body) {
        p.e(body, "body");
        try {
            Companion companion = INSTANCE;
            AfterToolCallRequest afterToolCallRequest = companion.parseAfterToolCallRequest(body);
            ALog.d$default(TAG, "[trace] tool_client_correlation: sessionId=" + afterToolCallRequest.getSessionId() + " runId=" + afterToolCallRequest.getRunId() + " traceId=" + afterToolCallRequest.getTraceId() + " toolName=" + afterToolCallRequest.getToolName(), null, 4, null);
            String resultText = afterToolCallRequest.getResultText();
            if (resultText == null) {
                resultText = p.a(afterToolCallRequest.getResult(), JsonNull.INSTANCE) ? null : afterToolCallRequest.getResult().toString();
            }
            companion.logChunked(new o3.a(3), "Tool result (correlation, pre-WS)", resultText);
            String error = afterToolCallRequest.getError();
            if (error != null) {
                if (n.t1(error)) {
                    error = null;
                }
                if (error != null) {
                    ALog.w$default(TAG, "Tool error (correlation): ".concat(error), null, 4, null);
                }
            }
            return HookResponseJson.INSTANCE.accepted();
        } catch (Exception e9) {
            f.l("tool_client_correlation error: ", e9.getMessage(), TAG, e9);
            HookResponseJson hookResponseJson = HookResponseJson.INSTANCE;
            String message = e9.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return hookResponseJson.error(message);
        }
    }

    public final String handleToolResultPersist(String body) {
        p.e(body, "body");
        try {
            Json json2 = json;
            json2.getSerializersModule();
            ToolResultPersistRequest toolResultPersistRequest = (ToolResultPersistRequest) json2.decodeFromString(ToolResultPersistRequest.INSTANCE.serializer(), body);
            ALog.d$default(TAG, "[trace] tool_result_persist: sessionId=" + toolResultPersistRequest.getSessionId() + " traceId=" + toolResultPersistRequest.getTraceId() + " toolName=" + toolResultPersistRequest.getToolName(), null, 4, null);
            ToolResultPersistResponse.Companion companion = ToolResultPersistResponse.INSTANCE;
            return json2.encodeToString(companion.serializer(), companion.empty());
        } catch (Exception e9) {
            f.l("tool_result_persist error: ", e9.getMessage(), TAG, e9);
            Json json3 = json;
            ToolResultPersistResponse.Companion companion2 = ToolResultPersistResponse.INSTANCE;
            return json3.encodeToString(companion2.serializer(), companion2.empty());
        }
    }
}
