package com.stepos.taskrobot.llmapi.stepfun.trace;

import D7.v;
import H4.o;
import J7.c;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.taskrobot.base.datareport.DataReportLogLevel;
import j9.m;
import j9.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.MapBuilder;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import org.java_websocket.WebSocketImpl;
import stepai.aios.guiagent.config.GuiAgentConfigKt;
import stepai.aios.guiagent.tracer.GuiTaskTreeTraceSnapshot;
import stepai.aios.guiagent.tracer.GuiTracerManager;
import stepai.aios.guiagent.tracer.remote.GuiTraceRecord;
import stepai.aios.guiagent.tracer.remote.GuiTraceTreeRecord;
import stepai.aios.guiagent.tracer.remote.IUpload;
import stepai.aios.guiagent.tracer.remote.LlmTraceCache;
import stepai.android.llm.base.twoway.FlowType;
import ua.C2052a;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001}B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jz\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u000f\u0010\u0010JZ\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJA\u0010!\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"JK\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b&\u0010'J!\u0010.\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b,\u0010-J#\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010/\u001a\u00020)H\u0002¢\u0006\u0004\b0\u00101J\u001f\u00106\u001a\u0002052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020)H\u0002¢\u0006\u0004\b6\u00107J\u001f\u00109\u001a\u00020\u00042\u0006\u00104\u001a\u00020)2\u0006\u00108\u001a\u000205H\u0002¢\u0006\u0004\b9\u0010:J\u001d\u0010=\u001a\u0004\u0018\u00010<*\u00020)2\u0006\u0010;\u001a\u00020\u0004H\u0002¢\u0006\u0004\b=\u0010>J\u001d\u0010?\u001a\u0004\u0018\u00010\u0004*\u00020)2\u0006\u0010;\u001a\u00020\u0004H\u0002¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020A2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020<H\u0082@¢\u0006\u0004\bD\u0010EJ>\u0010H\u001a\u0002022\u0006\u0010F\u001a\u00020A2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010G\u001a\u00020<2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0004\bH\u0010IJF\u0010N\u001a\u00020J2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010G\u001a\u00020<2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0004\bN\u0010OJ@\u0010P\u001a\u0004\u0018\u00010\u00042\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0004\bP\u0010QJ#\u0010S\u001a\u0004\u0018\u00010\u00042\b\u0010R\u001a\u0004\u0018\u00010\u00042\u0006\u0010G\u001a\u00020<H\u0002¢\u0006\u0004\bS\u0010TJ%\u0010X\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010U2\b\u0010W\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bX\u0010YJ\u0017\u0010[\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020\u0004H\u0002¢\u0006\u0004\b[\u0010\\J\u001b\u0010]\u001a\u0004\u0018\u00010\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b]\u0010^J\u0019\u0010`\u001a\u00020\u000b2\b\u0010_\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b`\u0010aJG\u0010e\u001a\u00020)2\b\u0010b\u001a\u0004\u0018\u00010\u00012\b\u0010c\u001a\u0004\u0018\u00010\u00012\u0006\u00103\u001a\u0002022\u0006\u0010d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\be\u0010fJ\u001b\u0010g\u001a\u0004\u0018\u00010\u001f2\b\u0010b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\bg\u0010hJ\u001f\u0010k\u001a\u00020\u000b2\u0006\u0010i\u001a\u00020)2\u0006\u0010j\u001a\u00020\u0004H\u0002¢\u0006\u0004\bk\u0010-J\u0017\u0010m\u001a\u00020\u000b2\u0006\u0010l\u001a\u00020)H\u0002¢\u0006\u0004\bm\u0010nR\u001c\u0010q\u001a\n p*\u0004\u0018\u00010o0o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010u\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bu\u0010tR\u0014\u0010v\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bv\u0010tR\u0014\u0010w\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bw\u0010tR\u0014\u0010x\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bx\u0010tR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010yR \u0010{\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020U0z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|¨\u0006~"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/trace/GuiAgentTraceManagerV2;", "", AppAgent.CONSTRUCT, "()V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, AgentBusWakeContract.EXTRA_TRACE_ID, "", "metadata", "headers", "Lkotlin/Function1;", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "subSessionId", "Lkotlin/Result;", "postExecution-bMdYcbs", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;LS7/k;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "postExecution", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "appName", "postTaskStart-bMdYcbs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "postTaskStart", "Lstepai/aios/guiagent/tracer/remote/IUpload;", "uploader", "registerUploader", "(Lstepai/aios/guiagent/tracer/remote/IUpload;)V", "request", "response", "", "costTimeMs", "Lcom/google/gson/JsonElement;", "fullResponse", "cacheLlmTrace", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;JLcom/google/gson/JsonElement;)V", "msgType", "inputText", "outputText", "buildCommonFields$stepfun_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "buildCommonFields", "Lcom/google/gson/JsonObject;", TypedValues.AttributesType.S_TARGET, "sessionId", "injectSessionId$stepfun_release", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)V", "injectSessionId", "jsonObject", "jsonObjectToMap", "(Lcom/google/gson/JsonObject;)Ljava/util/Map;", "Lstepai/aios/guiagent/tracer/remote/GuiTraceTreeRecord;", "record", "traceJson", "Lcom/stepos/taskrobot/llmapi/stepfun/trace/GuiAgentTraceManagerV2$ReportOutcome;", "deriveReportOutcome", "(Lstepai/aios/guiagent/tracer/remote/GuiTraceTreeRecord;Lcom/google/gson/JsonObject;)Lcom/stepos/taskrobot/llmapi/stepfun/trace/GuiAgentTraceManagerV2$ReportOutcome;", "outcome", "buildTraceLogPayload", "(Lcom/google/gson/JsonObject;Lcom/stepos/taskrobot/llmapi/stepfun/trace/GuiAgentTraceManagerV2$ReportOutcome;)Ljava/lang/String;", "key", "", "getBooleanOrNull", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "getStringOrNull", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;", "Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", "fetchTraceSnapshot", "(Ljava/lang/String;)Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", "syncLlmTraceBuffer", "(LH7/c;)Ljava/lang/Object;", RequestInfo.FUNCTION_SNAPSHOT, "allowRemoteFetch", "buildTraceRecordsWithUploadedScreenshots", "(Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;Ljava/lang/String;ZLjava/util/Map;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/tracer/remote/GuiTraceStep;", "step", "Ljava/io/File;", "sessionDir", "processStep", "(Lstepai/aios/guiagent/tracer/remote/GuiTraceStep;Ljava/io/File;Ljava/lang/String;ZLjava/util/Map;LH7/c;)Ljava/lang/Object;", "uploadStepScreenshot", "(Lstepai/aios/guiagent/tracer/remote/GuiTraceStep;Ljava/io/File;Ljava/lang/String;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "llmTraceId", "getLlmTrace", "(Ljava/lang/String;Z)Ljava/lang/String;", "Lstepai/aios/guiagent/tracer/remote/RequestAndResponse;", "localTrace", "remoteTraceRaw", "mergeRequestAndResponse", "(Lstepai/aios/guiagent/tracer/remote/RequestAndResponse;Ljava/lang/String;)Lstepai/aios/guiagent/tracer/remote/RequestAndResponse;", "raw", "parseRemoteTraceRaw", "(Ljava/lang/String;)Lcom/google/gson/JsonElement;", "sanitizeRequestBase64", "(Ljava/lang/Object;)Ljava/lang/Object;", "element", "sanitizeJsonBase64InPlace", "(Lcom/google/gson/JsonElement;)V", "experienceResult", "injectExperienceResult", Key.KEY_TOOL_CALL_ID, "toJsonWithParsedLlmExtra", "(Ljava/lang/Object;Ljava/lang/Object;Lstepai/aios/guiagent/tracer/remote/GuiTraceTreeRecord;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/google/gson/JsonObject;", "formartExperienceResult", "(Ljava/lang/Object;)Lcom/google/gson/JsonElement;", "jsonObj", "fieldName", "formatTimeField", "stepObj", "parseLlmExtraInStep", "(Lcom/google/gson/JsonObject;)V", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "TAG", "Ljava/lang/String;", "MSG_TYPE_TRACE_LOG", "MSG_TYPE_UPLINK", "MSG_TYPE_DOWNLINK", "NODE_NAME_GUI_AGENT_CALL", "Lstepai/aios/guiagent/tracer/remote/IUpload;", "", "localLlmTraceCache", "Ljava/util/Map;", "ReportOutcome", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GuiAgentTraceManagerV2 {
    private static final String MSG_TYPE_DOWNLINK = "downlink";
    private static final String MSG_TYPE_TRACE_LOG = "trace_log";
    private static final String MSG_TYPE_UPLINK = "uplink";
    private static final String NODE_NAME_GUI_AGENT_CALL = "gui_agent_call";
    private static final String TAG = "RobotTraceV2";
    private static IUpload uploader;
    public static final GuiAgentTraceManagerV2 INSTANCE = new GuiAgentTraceManagerV2();
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private static final Map<String, stepai.aios.guiagent.tracer.remote.RequestAndResponse> localLlmTraceCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/trace/GuiAgentTraceManagerV2$ReportOutcome;", "", "success", "", "statusCode", "", "logLevel", "Lcom/stepos/taskrobot/base/datareport/DataReportLogLevel;", "failureReason", "", AppAgent.CONSTRUCT, "(ZILcom/stepos/taskrobot/base/datareport/DataReportLogLevel;Ljava/lang/String;)V", "getSuccess", "()Z", "getStatusCode", "()I", "getLogLevel", "()Lcom/stepos/taskrobot/base/datareport/DataReportLogLevel;", "getFailureReason", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ReportOutcome {
        private final String failureReason;
        private final DataReportLogLevel logLevel;
        private final int statusCode;
        private final boolean success;

        public ReportOutcome(boolean z10, int i, DataReportLogLevel logLevel, String str) {
            k.f(logLevel, "logLevel");
            this.success = z10;
            this.statusCode = i;
            this.logLevel = logLevel;
            this.failureReason = str;
        }

        public static /* synthetic */ ReportOutcome copy$default(ReportOutcome reportOutcome, boolean z10, int i, DataReportLogLevel dataReportLogLevel, String str, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                z10 = reportOutcome.success;
            }
            if ((i6 & 2) != 0) {
                i = reportOutcome.statusCode;
            }
            if ((i6 & 4) != 0) {
                dataReportLogLevel = reportOutcome.logLevel;
            }
            if ((i6 & 8) != 0) {
                str = reportOutcome.failureReason;
            }
            return reportOutcome.copy(z10, i, dataReportLogLevel, str);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        /* renamed from: component2, reason: from getter */
        public final int getStatusCode() {
            return this.statusCode;
        }

        /* renamed from: component3, reason: from getter */
        public final DataReportLogLevel getLogLevel() {
            return this.logLevel;
        }

        /* renamed from: component4, reason: from getter */
        public final String getFailureReason() {
            return this.failureReason;
        }

        public final ReportOutcome copy(boolean success, int statusCode, DataReportLogLevel logLevel, String failureReason) {
            k.f(logLevel, "logLevel");
            return new ReportOutcome(success, statusCode, logLevel, failureReason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReportOutcome)) {
                return false;
            }
            ReportOutcome reportOutcome = (ReportOutcome) other;
            return this.success == reportOutcome.success && this.statusCode == reportOutcome.statusCode && this.logLevel == reportOutcome.logLevel && k.b(this.failureReason, reportOutcome.failureReason);
        }

        public final String getFailureReason() {
            return this.failureReason;
        }

        public final DataReportLogLevel getLogLevel() {
            return this.logLevel;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public int hashCode() {
            int iHashCode = (this.logLevel.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.statusCode, Boolean.hashCode(this.success) * 31, 31)) * 31;
            String str = this.failureReason;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ReportOutcome(success=" + this.success + ", statusCode=" + this.statusCode + ", logLevel=" + this.logLevel + ", failureReason=" + this.failureReason + ")";
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2", f = "GuiAgentTraceManagerV2.kt", l = {TypedValues.CycleType.TYPE_WAVE_PHASE}, m = "buildTraceRecordsWithUploadedScreenshots", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$buildTraceRecordsWithUploadedScreenshots$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GuiAgentTraceManagerV2.this.buildTraceRecordsWithUploadedScreenshots(null, null, false, null, this);
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2", f = "GuiAgentTraceManagerV2.kt", l = {WebSocketImpl.DEFAULT_WSS_PORT}, m = "processStep", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$processStep$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11931 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C11931(H7.c<? super C11931> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GuiAgentTraceManagerV2.this.processStep(null, null, null, false, null, this);
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2", f = "GuiAgentTraceManagerV2.kt", l = {398}, m = "syncLlmTraceBuffer", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$syncLlmTraceBuffer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11941 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C11941(H7.c<? super C11941> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GuiAgentTraceManagerV2.this.syncLlmTraceBuffer(this);
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2", f = "GuiAgentTraceManagerV2.kt", l = {489}, m = "uploadStepScreenshot", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$uploadStepScreenshot$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11951 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C11951(H7.c<? super C11951> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GuiAgentTraceManagerV2.this.uploadStepScreenshot(null, null, null, null, this);
        }
    }

    private GuiAgentTraceManagerV2() {
    }

    public static /* synthetic */ Map buildCommonFields$stepfun_release$default(GuiAgentTraceManagerV2 guiAgentTraceManagerV2, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        return guiAgentTraceManagerV2.buildCommonFields$stepfun_release(str, str2, str3, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildTraceLogPayload(JsonObject traceJson, ReportOutcome outcome) {
        JsonObject jsonObjectDeepCopy = traceJson.deepCopy();
        jsonObjectDeepCopy.addProperty("success", Boolean.valueOf(outcome.getSuccess()));
        jsonObjectDeepCopy.addProperty("statusCode", Integer.valueOf(outcome.getStatusCode()));
        String failureReason = outcome.getFailureReason();
        if (failureReason != null) {
            if (m.s0(failureReason)) {
                failureReason = null;
            }
            if (failureReason != null) {
                jsonObjectDeepCopy.addProperty("failureReason", failureReason);
            }
        }
        String json = gson.toJson((JsonElement) jsonObjectDeepCopy);
        k.e(json, "toJson(...)");
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00f0 -> B:20:0x0127). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0197 -> B:26:0x01a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object buildTraceRecordsWithUploadedScreenshots(stepai.aios.guiagent.tracer.GuiTaskTreeTraceSnapshot r40, java.lang.String r41, boolean r42, java.util.Map<java.lang.String, java.lang.String> r43, H7.c<? super stepai.aios.guiagent.tracer.remote.GuiTraceTreeRecord> r44) {
        /*
            Method dump skipped, instructions count: 555
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2.buildTraceRecordsWithUploadedScreenshots(stepai.aios.guiagent.tracer.GuiTaskTreeTraceSnapshot, java.lang.String, boolean, java.util.Map, H7.c):java.lang.Object");
    }

    public static /* synthetic */ void cacheLlmTrace$default(GuiAgentTraceManagerV2 guiAgentTraceManagerV2, String str, Object obj, String str2, long j5, JsonElement jsonElement, int i, Object obj2) {
        if ((i & 8) != 0) {
            j5 = 0;
        }
        long j6 = j5;
        if ((i & 16) != 0) {
            jsonElement = null;
        }
        guiAgentTraceManagerV2.cacheLlmTrace(str, obj, str2, j6, jsonElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReportOutcome deriveReportOutcome(GuiTraceTreeRecord record, JsonObject traceJson) {
        boolean z10;
        String lastErrorMessage;
        boolean z11;
        Object next;
        Boolean booleanOrNull = getBooleanOrNull(traceJson, "success");
        if (booleanOrNull == null) {
            booleanOrNull = record.getSuccess();
        }
        Boolean booleanOrNull2 = getBooleanOrNull(traceJson, FlowType.COMPLETED);
        boolean zBooleanValue = booleanOrNull2 != null ? booleanOrNull2.booleanValue() : record.getCompleted();
        List<GuiTraceRecord> nodes = record.getNodes();
        if ((nodes instanceof Collection) && nodes.isEmpty()) {
            z10 = false;
        } else {
            for (GuiTraceRecord guiTraceRecord : nodes) {
                if (k.b(guiTraceRecord.getState(), "FAILED") || k.b(guiTraceRecord.getState(), "CANCELLED") || k.b(guiTraceRecord.getLastResultSuccess(), Boolean.FALSE) || ((lastErrorMessage = guiTraceRecord.getLastErrorMessage()) != null && !m.s0(lastErrorMessage))) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        if (record.getNodes().isEmpty()) {
            z11 = false;
            break;
        }
        List<GuiTraceRecord> nodes2 = record.getNodes();
        if (!(nodes2 instanceof Collection) || !nodes2.isEmpty()) {
            for (GuiTraceRecord guiTraceRecord2 : nodes2) {
                if (!k.b(guiTraceRecord2.getState(), "COMPLETED") || k.b(guiTraceRecord2.getLastResultSuccess(), Boolean.FALSE)) {
                    z11 = false;
                    break;
                }
            }
        }
        z11 = true;
        boolean zBooleanValue2 = booleanOrNull != null ? booleanOrNull.booleanValue() : !z10 && zBooleanValue && z11;
        String failureReason = record.getFailureReason();
        String lastErrorMessage2 = null;
        if (failureReason == null || m.s0(failureReason)) {
            failureReason = null;
        }
        if (failureReason == null) {
            String stringOrNull = getStringOrNull(traceJson, "failureReason");
            if (stringOrNull == null) {
                Iterator<T> it = record.getNodes().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    String lastErrorMessage3 = ((GuiTraceRecord) next).getLastErrorMessage();
                    if (!(lastErrorMessage3 == null || m.s0(lastErrorMessage3))) {
                        break;
                    }
                }
                GuiTraceRecord guiTraceRecord3 = (GuiTraceRecord) next;
                if (guiTraceRecord3 != null) {
                    lastErrorMessage2 = guiTraceRecord3.getLastErrorMessage();
                }
            } else {
                lastErrorMessage2 = stringOrNull;
            }
        } else {
            lastErrorMessage2 = failureReason;
        }
        return new ReportOutcome(zBooleanValue2, zBooleanValue2 ? 200 : 500, zBooleanValue2 ? DataReportLogLevel.f4025a : (zBooleanValue || z10) ? DataReportLogLevel.c : DataReportLogLevel.b, lastErrorMessage2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuiTaskTreeTraceSnapshot fetchTraceSnapshot(String traceId) {
        Object objA;
        stepai.aios.guiagent.runtime.a aVar;
        try {
            aVar = C2052a.c;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        if (aVar == null) {
            throw new IllegalStateException("GuiAgentManager is not initialized");
        }
        k.f(traceId, "treeId");
        GuiTracerManager guiTracerManager = aVar.e;
        objA = guiTracerManager != null ? guiTracerManager.getTaskTreeTrace(traceId) : null;
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e(TAG, "Failed to fetch task traces", thA);
        }
        b.b(objA);
        GuiTaskTreeTraceSnapshot guiTaskTreeTraceSnapshot = (GuiTaskTreeTraceSnapshot) objA;
        return guiTaskTreeTraceSnapshot == null ? new GuiTaskTreeTraceSnapshot("", 0, EmptyList.f4893a, 0L, 0L, false, Boolean.FALSE, "") : guiTaskTreeTraceSnapshot;
    }

    private final JsonElement formartExperienceResult(Object experienceResult) {
        if (experienceResult == null) {
            return null;
        }
        try {
            return experienceResult instanceof String ? JsonParser.parseString((String) experienceResult).getAsJsonArray() : experienceResult instanceof List ? gson.toJsonTree(experienceResult).getAsJsonArray() : gson.toJsonTree(experienceResult).getAsJsonObject();
        } catch (Exception e) {
            Log.e(TAG, "formartExperienceActionsList error", e);
            return null;
        }
    }

    private final void formatTimeField(JsonObject jsonObj, String fieldName) {
        JsonElement jsonElement = jsonObj.get(fieldName);
        if (jsonElement != null && jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
            long asLong = jsonElement.getAsLong();
            if (asLong > 0) {
                jsonObj.addProperty(fieldName, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(asLong)));
            }
        }
    }

    private final Boolean getBooleanOrNull(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || !jsonElement.isJsonPrimitive()) {
            return null;
        }
        JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
        if (asJsonPrimitive.isBoolean()) {
            return Boolean.valueOf(asJsonPrimitive.getAsBoolean());
        }
        return null;
    }

    private final String getLlmTrace(String llmTraceId, boolean allowRemoteFetch) {
        if (llmTraceId == null || m.s0(llmTraceId)) {
            Log.e(TAG, "llmTraceId 为null");
            return null;
        }
        stepai.aios.guiagent.tracer.remote.RequestAndResponse requestAndResponse = LlmTraceCache.INSTANCE.get(llmTraceId);
        if (requestAndResponse != null) {
            String strConcat = "命中本地llm trace缓存, traceId=".concat(llmTraceId);
            k.f(strConcat, "<this>");
            Log.i(TAG, strConcat);
        }
        if (requestAndResponse != null) {
            return gson.toJson(requestAndResponse);
        }
        String strConcat2 = "不需要处理llm数据，且本地缓存未命中 traceId=".concat(llmTraceId);
        k.f(strConcat2, "<this>");
        Log.i(TAG, strConcat2);
        return null;
    }

    private final String getStringOrNull(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || !jsonElement.isJsonPrimitive()) {
            return null;
        }
        String asString = jsonElement.getAsString();
        k.c(asString);
        if (m.s0(asString)) {
            return null;
        }
        return asString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> jsonObjectToMap(JsonObject jsonObject) {
        Pair pair;
        Pair pair2;
        Set<Map.Entry<String, JsonElement>> setEntrySet = jsonObject.entrySet();
        k.e(setEntrySet, "entrySet(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            k.c(entry);
            String str = (String) entry.getKey();
            JsonElement jsonElement = (JsonElement) entry.getValue();
            if (jsonElement.isJsonNull()) {
                pair2 = null;
            } else {
                if (jsonElement.isJsonPrimitive()) {
                    JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                    pair = new Pair(str, asJsonPrimitive.isString() ? asJsonPrimitive.getAsString() : asJsonPrimitive.isNumber() ? asJsonPrimitive.getAsNumber() : asJsonPrimitive.isBoolean() ? Boolean.valueOf(asJsonPrimitive.getAsBoolean()) : asJsonPrimitive.getAsString());
                } else {
                    pair = new Pair(str, gson.toJsonTree(jsonElement));
                }
                pair2 = pair;
            }
            if (pair2 != null) {
                arrayList.add(pair2);
            }
        }
        return kotlin.collections.a.X(arrayList);
    }

    private final stepai.aios.guiagent.tracer.remote.RequestAndResponse mergeRequestAndResponse(stepai.aios.guiagent.tracer.remote.RequestAndResponse localTrace, String remoteTraceRaw) {
        if (localTrace == null && (remoteTraceRaw == null || m.s0(remoteTraceRaw))) {
            return null;
        }
        stepai.aios.guiagent.tracer.remote.RequestAndResponse requestAndResponse = localTrace == null ? new stepai.aios.guiagent.tracer.remote.RequestAndResponse(null, null, 0L, null, null, 16, null) : localTrace;
        return (remoteTraceRaw == null || m.s0(remoteTraceRaw)) ? stepai.aios.guiagent.tracer.remote.RequestAndResponse.copy$default(requestAndResponse, null, null, 0L, null, null, 23, null) : stepai.aios.guiagent.tracer.remote.RequestAndResponse.copy$default(requestAndResponse, null, null, 0L, parseRemoteTraceRaw(remoteTraceRaw), null, 23, null);
    }

    private final void parseLlmExtraInStep(JsonObject stepObj) {
        Object objA;
        JsonElement jsonElement = stepObj.get("llmExtra");
        if (jsonElement != null && jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
            try {
                objA = (stepai.aios.guiagent.tracer.remote.RequestAndResponse) gson.fromJson(jsonElement.getAsString(), stepai.aios.guiagent.tracer.remote.RequestAndResponse.class);
            } catch (Throwable th) {
                objA = b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Log.e(TAG, "llmExtra parse error", thA);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            stepai.aios.guiagent.tracer.remote.RequestAndResponse requestAndResponse = (stepai.aios.guiagent.tracer.remote.RequestAndResponse) objA;
            if (requestAndResponse != null) {
                stepObj.add("llmExtra", gson.toJsonTree(requestAndResponse));
            }
        }
    }

    private final JsonElement parseRemoteTraceRaw(String raw) {
        Object objA;
        try {
            objA = JsonParser.parseString(raw);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        if (Result.a(objA) != null) {
            objA = new JsonPrimitive(raw);
        }
        k.e(objA, "getOrElse(...)");
        return (JsonElement) objA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: postExecution-bMdYcbs$default, reason: not valid java name */
    public static /* synthetic */ Object m7352postExecutionbMdYcbs$default(GuiAgentTraceManagerV2 guiAgentTraceManagerV2, String str, String str2, Map map, Map map2, S7.k kVar, String str3, H7.c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            map2 = null;
        }
        if ((i & 16) != 0) {
            kVar = null;
        }
        if ((i & 32) != 0) {
            str3 = null;
        }
        return guiAgentTraceManagerV2.m7354postExecutionbMdYcbs(str, str2, map, map2, kVar, str3, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: postTaskStart-bMdYcbs$default, reason: not valid java name */
    public static /* synthetic */ Object m7353postTaskStartbMdYcbs$default(GuiAgentTraceManagerV2 guiAgentTraceManagerV2, String str, String str2, String str3, String str4, Map map, String str5, H7.c cVar, int i, Object obj) {
        if ((i & 16) != 0) {
            map = null;
        }
        if ((i & 32) != 0) {
            str5 = null;
        }
        return guiAgentTraceManagerV2.m7355postTaskStartbMdYcbs(str, str2, str3, str4, map, str5, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processStep(stepai.aios.guiagent.tracer.remote.GuiTraceStep r24, java.io.File r25, java.lang.String r26, boolean r27, java.util.Map<java.lang.String, java.lang.String> r28, H7.c<? super stepai.aios.guiagent.tracer.remote.GuiTraceStep> r29) {
        /*
            r23 = this;
            r0 = r23
            r1 = r29
            boolean r2 = r1 instanceof com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2.C11931
            if (r2 == 0) goto L18
            r2 = r1
            com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$processStep$1 r2 = (com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2.C11931) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r5 = r2
            goto L1e
        L18:
            com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$processStep$1 r2 = new com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$processStep$1
            r2.<init>(r1)
            goto L16
        L1e:
            java.lang.Object r1 = r5.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r5.label
            r3 = 1
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            boolean r2 = r5.Z$0
            java.lang.Object r3 = r5.L$3
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r3 = r5.L$2
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r3 = r5.L$1
            java.io.File r3 = (java.io.File) r3
            java.lang.Object r3 = r5.L$0
            stepai.aios.guiagent.tracer.remote.GuiTraceStep r3 = (stepai.aios.guiagent.tracer.remote.GuiTraceStep) r3
            kotlin.b.b(r1)
            r7 = r3
            goto L6d
        L40:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L48:
            kotlin.b.b(r1)
            r1 = r24
            r5.L$0 = r1
            r2 = 0
            r5.L$1 = r2
            r5.L$2 = r2
            r5.L$3 = r2
            r7 = r27
            r5.Z$0 = r7
            r5.label = r3
            r2 = r25
            r3 = r26
            r4 = r28
            java.lang.Object r2 = r0.uploadStepScreenshot(r1, r2, r3, r4, r5)
            if (r2 != r6) goto L69
            return r6
        L69:
            r1 = r2
            r2 = r7
            r7 = r24
        L6d:
            r16 = r1
            java.lang.String r16 = (java.lang.String) r16
            java.lang.String r1 = r7.getLlmTraceId()
            java.lang.String r18 = r0.getLlmTrace(r1, r2)
            r21 = 3455(0xd7f, float:4.841E-42)
            r22 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            stepai.aios.guiagent.tracer.remote.GuiTraceStep r0 = stepai.aios.guiagent.tracer.remote.GuiTraceStep.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2.processStep(stepai.aios.guiagent.tracer.remote.GuiTraceStep, java.io.File, java.lang.String, boolean, java.util.Map, H7.c):java.lang.Object");
    }

    private final void sanitizeJsonBase64InPlace(JsonElement element) {
        if (element == null || element.isJsonNull()) {
            return;
        }
        if (!element.isJsonObject()) {
            if (element.isJsonArray()) {
                JsonArray asJsonArray = element.getAsJsonArray();
                k.e(asJsonArray, "getAsJsonArray(...)");
                Iterator<JsonElement> it = asJsonArray.iterator();
                while (it.hasNext()) {
                    INSTANCE.sanitizeJsonBase64InPlace(it.next());
                }
                return;
            }
            return;
        }
        JsonObject asJsonObject = element.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> setEntrySet = asJsonObject.entrySet();
        k.e(setEntrySet, "entrySet(...)");
        for (Map.Entry entry : v.f1(setEntrySet)) {
            k.c(entry);
            String str = (String) entry.getKey();
            JsonElement jsonElement = (JsonElement) entry.getValue();
            if (t.X(str, "base64")) {
                asJsonObject.addProperty(str, "");
            } else {
                INSTANCE.sanitizeJsonBase64InPlace(jsonElement);
            }
        }
    }

    private final Object sanitizeRequestBase64(Object request) {
        Object objA;
        if (request == null) {
            return null;
        }
        try {
            JsonElement jsonTree = gson.toJsonTree(request);
            sanitizeJsonBase64InPlace(jsonTree);
            objA = jsonTree;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA == null) {
            return objA;
        }
        Log.e(TAG, "sanitize request base64 failed", thA);
        return request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object syncLlmTraceBuffer(H7.c<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2.C11941
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$syncLlmTraceBuffer$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2.C11941) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$syncLlmTraceBuffer$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$syncLlmTraceBuffer$1
            r0.<init>(r5)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.b.b(r4)
            goto L3d
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r4)
            r0.label = r2
            stepai.aios.guiagent.util.b r4 = stepai.aios.guiagent.util.b.f6178a
            java.lang.Object r4 = r4.a(r0)
            if (r4 != r5) goto L3d
            return r5
        L3d:
            stepai.android.mindx.client.StepLLMClient r4 = stepai.android.mindx.client.StepLLMClient.INSTANCE
            boolean r5 = r4.isServiceConnected()
            java.lang.String r0 = "RobotTraceV2"
            if (r5 == 0) goto L6a
            boolean r4 = r4.syncTraceBuffer()     // Catch: java.lang.Throwable -> L50
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L50
            goto L55
        L50:
            r4 = move-exception
            kotlin.Result$Failure r4 = kotlin.b.a(r4)
        L55:
            java.lang.Throwable r5 = kotlin.Result.a(r4)
            if (r5 == 0) goto L60
            java.lang.String r1 = "syncTraceBuffer failed"
            android.util.Log.e(r0, r1, r5)
        L60:
            kotlin.b.b(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            goto L70
        L6a:
            java.lang.String r4 = "Client 没有连接"
            android.util.Log.e(r0, r4)
            r4 = 0
        L70:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2.syncLlmTraceBuffer(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonObject toJsonWithParsedLlmExtra(Object experienceResult, Object injectExperienceResult, GuiTraceTreeRecord record, String toolCallId, String taskId, String subSessionId) {
        JsonObject asJsonObject = gson.toJsonTree(record).getAsJsonObject();
        k.c(asJsonObject);
        formatTimeField(asJsonObject, "createdAt");
        formatTimeField(asJsonObject, "updatedAt");
        JsonArray asJsonArray = asJsonObject.getAsJsonArray("nodes");
        if (asJsonArray == null) {
            return asJsonObject;
        }
        int i = 0;
        for (JsonElement jsonElement : asJsonArray) {
            int i6 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            JsonObject asJsonObject2 = jsonElement.getAsJsonObject();
            GuiAgentTraceManagerV2 guiAgentTraceManagerV2 = INSTANCE;
            k.c(asJsonObject2);
            guiAgentTraceManagerV2.formatTimeField(asJsonObject2, "createdAt");
            guiAgentTraceManagerV2.formatTimeField(asJsonObject2, "updatedAt");
            JsonArray asJsonArray2 = asJsonObject2.getAsJsonArray("steps");
            if (asJsonArray2 != null) {
                Iterator<JsonElement> it = asJsonArray2.iterator();
                while (it.hasNext()) {
                    JsonObject asJsonObject3 = it.next().getAsJsonObject();
                    GuiAgentTraceManagerV2 guiAgentTraceManagerV22 = INSTANCE;
                    k.c(asJsonObject3);
                    guiAgentTraceManagerV22.formatTimeField(asJsonObject3, "updatedAt");
                    guiAgentTraceManagerV22.parseLlmExtraInStep(asJsonObject3);
                }
                if (i == 0) {
                    JsonElement jsonElementFormartExperienceResult = INSTANCE.formartExperienceResult(experienceResult);
                    if (jsonElementFormartExperienceResult != null) {
                        asJsonObject2.add("experienceResult", jsonElementFormartExperienceResult);
                    }
                    JsonElement jsonTree = gson.toJsonTree(injectExperienceResult);
                    JsonElement jsonElement2 = jsonTree.isJsonNull() ? null : jsonTree;
                    if (jsonElement2 != null) {
                        asJsonObject2.add("inject_experience_result", jsonElement2);
                    }
                }
            }
            i = i6;
        }
        asJsonObject.addProperty(GuiAgentConfigKt.META_KEY_TOOL_CALL_ID, toolCallId);
        asJsonObject.addProperty("task_id", taskId);
        asJsonObject.add("metadata", GuiAgentTraceManagerV2Kt.buildLocalAppMetadata());
        injectSessionId$stepfun_release(asJsonObject, subSessionId);
        return asJsonObject;
    }

    public static /* synthetic */ JsonObject toJsonWithParsedLlmExtra$default(GuiAgentTraceManagerV2 guiAgentTraceManagerV2, Object obj, Object obj2, GuiTraceTreeRecord guiTraceTreeRecord, String str, String str2, String str3, int i, Object obj3) {
        if ((i & 32) != 0) {
            str3 = null;
        }
        return guiAgentTraceManagerV2.toJsonWithParsedLlmExtra(obj, obj2, guiTraceTreeRecord, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadStepScreenshot(stepai.aios.guiagent.tracer.remote.GuiTraceStep r14, java.io.File r15, java.lang.String r16, java.util.Map<java.lang.String, java.lang.String> r17, H7.c<? super java.lang.String> r18) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2.uploadStepScreenshot(stepai.aios.guiagent.tracer.remote.GuiTraceStep, java.io.File, java.lang.String, java.util.Map, H7.c):java.lang.Object");
    }

    public final Map<String, Object> buildCommonFields$stepfun_release(String traceId, String msgType, String inputText, String outputText, String subSessionId) {
        k.f(traceId, "traceId");
        k.f(msgType, "msgType");
        k.f(inputText, "inputText");
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.put(Key.KEY_TRACE_ID, traceId);
        if (subSessionId != null) {
            if (m.s0(subSessionId)) {
                subSessionId = null;
            }
            if (subSessionId != null) {
                mapBuilder.put("session_id", subSessionId);
            }
        }
        mapBuilder.put("msg_type", msgType);
        mapBuilder.put("node_name", NODE_NAME_GUI_AGENT_CALL);
        mapBuilder.put("input_type", "text");
        mapBuilder.put("output_type", "text");
        mapBuilder.put("input_text", inputText);
        if (outputText != null) {
            mapBuilder.put("output_text", outputText);
        }
        return mapBuilder.b();
    }

    public final void cacheLlmTrace(String traceId, Object request, String response, long costTimeMs, JsonElement fullResponse) {
        if (traceId == null || m.s0(traceId)) {
            return;
        }
        localLlmTraceCache.put(traceId, new stepai.aios.guiagent.tracer.remote.RequestAndResponse(sanitizeRequestBase64(request), response, costTimeMs, null, fullResponse, 8, null));
    }

    public final void injectSessionId$stepfun_release(JsonObject target, String sessionId) {
        k.f(target, "target");
        if (sessionId != null) {
            if (m.s0(sessionId)) {
                sessionId = null;
            }
            if (sessionId != null) {
                target.addProperty("session_id", sessionId);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* renamed from: postExecution-bMdYcbs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7354postExecutionbMdYcbs(java.lang.String r13, java.lang.String r14, java.util.Map<java.lang.String, ? extends java.lang.Object> r15, java.util.Map<java.lang.String, java.lang.String> r16, S7.k r17, java.lang.String r18, H7.c<? super kotlin.Result<C7.r>> r19) throws java.lang.Throwable {
        /*
            r12 = this;
            r0 = r19
            boolean r1 = r0 instanceof com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postExecution$1
            if (r1 == 0) goto L15
            r1 = r0
            com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postExecution$1 r1 = (com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postExecution$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postExecution$1 r1 = new com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postExecution$1
            r1.<init>(r12, r0)
        L1a:
            java.lang.Object r12 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r1.label
            r3 = 1
            if (r2 == 0) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r13 = r1.L$5
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r13 = r1.L$4
            S7.k r13 = (S7.k) r13
            java.lang.Object r13 = r1.L$3
            java.util.Map r13 = (java.util.Map) r13
            java.lang.Object r13 = r1.L$2
            java.util.Map r13 = (java.util.Map) r13
            java.lang.Object r13 = r1.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r13 = r1.L$0
            java.lang.String r13 = (java.lang.String) r13
            kotlin.b.b(r12)
            goto L75
        L41:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L49:
            kotlin.b.b(r12)
            u9.d r12 = m9.AbstractC1691I.f5315a
            u9.c r12 = u9.c.f6743a
            com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postExecution$2 r4 = new com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postExecution$2
            r11 = 0
            r6 = r13
            r7 = r14
            r5 = r15
            r9 = r16
            r8 = r17
            r10 = r18
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r13 = 0
            r1.L$0 = r13
            r1.L$1 = r13
            r1.L$2 = r13
            r1.L$3 = r13
            r1.L$4 = r13
            r1.L$5 = r13
            r1.label = r3
            java.lang.Object r12 = m9.AbstractC1683A.w(r12, r4, r1)
            if (r12 != r0) goto L75
            return r0
        L75:
            kotlin.Result r12 = (kotlin.Result) r12
            java.lang.Object r12 = r12.f4887a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2.m7354postExecutionbMdYcbs(java.lang.String, java.lang.String, java.util.Map, java.util.Map, S7.k, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* renamed from: postTaskStart-bMdYcbs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7355postTaskStartbMdYcbs(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.util.Map<java.lang.String, ? extends java.lang.Object> r17, java.lang.String r18, H7.c<? super kotlin.Result<C7.r>> r19) throws java.lang.Throwable {
        /*
            r12 = this;
            r0 = r19
            boolean r1 = r0 instanceof com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postTaskStart$1
            if (r1 == 0) goto L15
            r1 = r0
            com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postTaskStart$1 r1 = (com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postTaskStart$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postTaskStart$1 r1 = new com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postTaskStart$1
            r1.<init>(r12, r0)
        L1a:
            java.lang.Object r12 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r1.label
            r3 = 1
            if (r2 == 0) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r13 = r1.L$5
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r13 = r1.L$4
            java.util.Map r13 = (java.util.Map) r13
            java.lang.Object r13 = r1.L$3
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r13 = r1.L$2
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r13 = r1.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r13 = r1.L$0
            java.lang.String r13 = (java.lang.String) r13
            kotlin.b.b(r12)
            goto L75
        L41:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L49:
            kotlin.b.b(r12)
            u9.d r12 = m9.AbstractC1691I.f5315a
            u9.c r12 = u9.c.f6743a
            com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postTaskStart$2 r4 = new com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postTaskStart$2
            r11 = 0
            r6 = r13
            r7 = r14
            r9 = r15
            r8 = r16
            r5 = r17
            r10 = r18
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r13 = 0
            r1.L$0 = r13
            r1.L$1 = r13
            r1.L$2 = r13
            r1.L$3 = r13
            r1.L$4 = r13
            r1.L$5 = r13
            r1.label = r3
            java.lang.Object r12 = m9.AbstractC1683A.w(r12, r4, r1)
            if (r12 != r0) goto L75
            return r0
        L75:
            kotlin.Result r12 = (kotlin.Result) r12
            java.lang.Object r12 = r12.f4887a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2.m7355postTaskStartbMdYcbs(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.lang.String, H7.c):java.lang.Object");
    }

    public final void registerUploader(IUpload uploader2) {
        k.f(uploader2, "uploader");
        uploader = uploader2;
    }
}
