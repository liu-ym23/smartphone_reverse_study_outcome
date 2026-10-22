package stepai.aios.guiagent.tracer.remote;

import D7.v;
import D7.w;
import H4.o;
import J7.c;
import N9.j;
import androidx.compose.runtime.ComposerKt;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import j9.m;
import j9.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.GuiAgentConfigKt;
import stepai.aios.guiagent.runtime.a;
import stepai.aios.guiagent.tracer.GuiTaskNodeTraceSnapshot;
import stepai.aios.guiagent.tracer.GuiTaskTreeTraceSnapshot;
import stepai.aios.guiagent.tracer.GuiTracerManager;
import ua.C2052a;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jf\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0086@¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013JA\u0010\u001b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010!\u001a\u00020\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001f¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&H\u0082@¢\u0006\u0004\b'\u0010(J>\u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010*\u001a\u00020&2\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0004\b,\u0010-JF\u00102\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010*\u001a\u00020&2\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0004\b2\u00103J\u001f\u00106\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u0010*\u001a\u00020&H\u0002¢\u0006\u0004\b6\u00107J@\u00108\u001a\u0004\u0018\u00010\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0004\b8\u00109J#\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010:\u001a\u0004\u0018\u00010\u00042\u0006\u0010*\u001a\u00020&H\u0002¢\u0006\u0004\b;\u0010<J%\u0010@\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010=2\b\u0010?\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u0004H\u0002¢\u0006\u0004\bC\u0010DJ\u001b\u0010E\u001a\u0004\u0018\u00010\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\bE\u0010FJ\u0019\u0010H\u001a\u00020\n2\b\u0010G\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\bH\u0010IJ;\u0010N\u001a\u00020\u00042\b\u0010J\u001a\u0004\u0018\u00010\u00012\b\u0010K\u001a\u0004\u0018\u00010\u00012\u0006\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bN\u0010OJ\u001b\u0010Q\u001a\u0004\u0018\u00010\u00192\b\u0010P\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\bQ\u0010RJ\u001b\u0010S\u001a\u0004\u0018\u00010\u00192\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\bS\u0010RJ\u001f\u0010W\u001a\u00020\n2\u0006\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020\u0004H\u0002¢\u0006\u0004\bW\u0010XJ\u0017\u0010Z\u001a\u00020\n2\u0006\u0010Y\u001a\u00020TH\u0002¢\u0006\u0004\bZ\u0010[J\u001f\u0010\\\u001a\u00020\n2\u0006\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\\\u0010XR\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010`\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010b¨\u0006c"}, d2 = {"Lstepai/aios/guiagent/tracer/remote/GuiAgentTraceManager;", "", AppAgent.CONSTRUCT, "()V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "", "metadata", "headers", "Lkotlin/Function1;", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "Lkotlin/Result;", "postExecution-yxL6bBk", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;LS7/k;LH7/c;)Ljava/lang/Object;", "postExecution", "Lstepai/aios/guiagent/tracer/remote/IUpload;", "uploader", "registerUploader", "(Lstepai/aios/guiagent/tracer/remote/IUpload;)V", AgentBusWakeContract.EXTRA_TRACE_ID, "request", "response", "", "costTimeMs", "Lcom/google/gson/JsonElement;", "fullResponse", "cacheLlmTrace", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;JLcom/google/gson/JsonElement;)V", "removeLlmTrace", "(Ljava/lang/String;)V", "", "traceIds", "evictLlmTraceCache", "(Ljava/util/Collection;)V", "Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", "fetchTraceSnapshot", "(Ljava/lang/String;)Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", "", "syncLlmTraceBuffer", "(LH7/c;)Ljava/lang/Object;", RequestInfo.FUNCTION_SNAPSHOT, "allowRemoteFetch", "Lstepai/aios/guiagent/tracer/remote/GuiTraceTreeRecord;", "buildTraceRecordsWithUploadedScreenshots", "(Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;Ljava/lang/String;ZLjava/util/Map;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/tracer/remote/GuiTraceStep;", "step", "Ljava/io/File;", "sessionDir", "processStep", "(Lstepai/aios/guiagent/tracer/remote/GuiTraceStep;Ljava/io/File;Ljava/lang/String;ZLjava/util/Map;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/tracer/remote/GuiTraceCompressionEvent;", NotificationCompat.CATEGORY_EVENT, "processCompressionEvent", "(Lstepai/aios/guiagent/tracer/remote/GuiTraceCompressionEvent;Z)Lstepai/aios/guiagent/tracer/remote/GuiTraceCompressionEvent;", "uploadStepScreenshot", "(Lstepai/aios/guiagent/tracer/remote/GuiTraceStep;Ljava/io/File;Ljava/lang/String;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "llmTraceId", "getLlmTrace", "(Ljava/lang/String;Z)Ljava/lang/String;", "Lstepai/aios/guiagent/tracer/remote/RequestAndResponse;", "localTrace", "remoteTraceRaw", "mergeRequestAndResponse", "(Lstepai/aios/guiagent/tracer/remote/RequestAndResponse;Ljava/lang/String;)Lstepai/aios/guiagent/tracer/remote/RequestAndResponse;", "raw", "parseRemoteTraceRaw", "(Ljava/lang/String;)Lcom/google/gson/JsonElement;", "sanitizeRequestBase64", "(Ljava/lang/Object;)Ljava/lang/Object;", "element", "sanitizeJsonBase64InPlace", "(Lcom/google/gson/JsonElement;)V", "experienceResult", "injectExperienceResult", "record", Key.KEY_TOOL_CALL_ID, "toJsonWithParsedLlmExtra", "(Ljava/lang/Object;Ljava/lang/Object;Lstepai/aios/guiagent/tracer/remote/GuiTraceTreeRecord;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "experienceRequest", "formartExperienceRequest", "(Ljava/lang/Object;)Lcom/google/gson/JsonElement;", "formartExperienceResult", "Lcom/google/gson/JsonObject;", "jsonObj", "fieldName", "formatTimeField", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)V", "stepObj", "parseLlmExtraInStep", "(Lcom/google/gson/JsonObject;)V", "parseLlmExtraField", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "TAG", "Ljava/lang/String;", "Lstepai/aios/guiagent/tracer/remote/IUpload;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuiAgentTraceManager {
    private static final String TAG = "RobotTrace";
    private static IUpload uploader;
    public static final GuiAgentTraceManager INSTANCE = new GuiAgentTraceManager();
    private static final Gson gson = new Gson();

    @c(c = "stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager", f = "GuiAgentTraceManager.kt", l = {ComposerKt.providerKey}, m = "buildTraceRecordsWithUploadedScreenshots", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$buildTraceRecordsWithUploadedScreenshots$1, reason: invalid class name */
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
            return GuiAgentTraceManager.this.buildTraceRecordsWithUploadedScreenshots(null, null, false, null, this);
        }
    }

    @c(c = "stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager", f = "GuiAgentTraceManager.kt", l = {222}, m = "processStep", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$processStep$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C19451(H7.c<? super C19451> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GuiAgentTraceManager.this.processStep(null, null, null, false, null, this);
        }
    }

    @c(c = "stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager", f = "GuiAgentTraceManager.kt", l = {176}, m = "syncLlmTraceBuffer", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$syncLlmTraceBuffer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19461 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C19461(H7.c<? super C19461> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GuiAgentTraceManager.this.syncLlmTraceBuffer(this);
        }
    }

    @c(c = "stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager", f = "GuiAgentTraceManager.kt", l = {276}, m = "uploadStepScreenshot", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$uploadStepScreenshot$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19471 extends ContinuationImpl {
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

        public C19471(H7.c<? super C19471> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GuiAgentTraceManager.this.uploadStepScreenshot(null, null, null, null, this);
        }
    }

    private GuiAgentTraceManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r13v11, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r14v9, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00f1 -> B:20:0x0128). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0198 -> B:26:0x01a5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object buildTraceRecordsWithUploadedScreenshots(stepai.aios.guiagent.tracer.GuiTaskTreeTraceSnapshot r40, java.lang.String r41, boolean r42, java.util.Map<java.lang.String, java.lang.String> r43, H7.c<? super stepai.aios.guiagent.tracer.remote.GuiTraceTreeRecord> r44) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager.buildTraceRecordsWithUploadedScreenshots(stepai.aios.guiagent.tracer.GuiTaskTreeTraceSnapshot, java.lang.String, boolean, java.util.Map, H7.c):java.lang.Object");
    }

    public static /* synthetic */ void cacheLlmTrace$default(GuiAgentTraceManager guiAgentTraceManager, String str, Object obj, String str2, long j5, JsonElement jsonElement, int i, Object obj2) {
        if ((i & 8) != 0) {
            j5 = 0;
        }
        long j6 = j5;
        if ((i & 16) != 0) {
            jsonElement = null;
        }
        guiAgentTraceManager.cacheLlmTrace(str, obj, str2, j6, jsonElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuiTaskTreeTraceSnapshot fetchTraceSnapshot(String traceId) {
        Object objA;
        a aVar;
        List<GuiTaskNodeTraceSnapshot> nodeTraces;
        List<GuiTaskNodeTraceSnapshot> nodeTraces2;
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
        ArrayList arrayList = null;
        GuiTaskTreeTraceSnapshot taskTreeTrace = guiTracerManager != null ? guiTracerManager.getTaskTreeTrace(traceId) : null;
        String treeId = taskTreeTrace != null ? taskTreeTrace.getTreeId() : null;
        Integer numValueOf = (taskTreeTrace == null || (nodeTraces2 = taskTreeTrace.getNodeTraces()) == null) ? null : Integer.valueOf(nodeTraces2.size());
        if (taskTreeTrace != null && (nodeTraces = taskTreeTrace.getNodeTraces()) != null) {
            List<GuiTaskNodeTraceSnapshot> list = nodeTraces;
            arrayList = new ArrayList(w.c0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((GuiTaskNodeTraceSnapshot) it.next()).getTaskInfo().c.name());
            }
        }
        j.H("fetchTraceSnapshot: traceId=" + traceId + ", snapshot=" + treeId + ", nodes=" + numValueOf + ", nodeStates=" + arrayList, TAG);
        objA = taskTreeTrace;
        Throwable thA = Result.a(objA);
        if (thA != null) {
            U7.a.L("Failed to fetch task traces", thA);
        }
        b.b(objA);
        GuiTaskTreeTraceSnapshot guiTaskTreeTraceSnapshot = (GuiTaskTreeTraceSnapshot) objA;
        if (guiTaskTreeTraceSnapshot != null) {
            return guiTaskTreeTraceSnapshot;
        }
        throw new IllegalArgumentException("fetchTraceSnapshot snapshots is null");
    }

    private final JsonElement formartExperienceRequest(Object experienceRequest) {
        if (experienceRequest == null) {
            return null;
        }
        try {
            return experienceRequest instanceof String ? JsonParser.parseString((String) experienceRequest).getAsJsonObject() : experienceRequest instanceof Map ? gson.toJsonTree(experienceRequest).getAsJsonObject() : gson.toJsonTree(experienceRequest).getAsJsonObject();
        } catch (Exception e) {
            U7.a.L("formartExperienceRequest error", e);
            return null;
        }
    }

    private final JsonElement formartExperienceResult(Object experienceResult) {
        if (experienceResult == null) {
            return null;
        }
        try {
            return experienceResult instanceof String ? JsonParser.parseString((String) experienceResult).getAsJsonArray() : experienceResult instanceof List ? gson.toJsonTree(experienceResult).getAsJsonArray() : gson.toJsonTree(experienceResult).getAsJsonObject();
        } catch (Exception e) {
            U7.a.L("formartExperienceActionsList error", e);
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

    private final String getLlmTrace(String llmTraceId, boolean allowRemoteFetch) {
        if (llmTraceId == null || m.s0(llmTraceId)) {
            j.G("llmTraceId 为null", TAG);
            return null;
        }
        RequestAndResponse requestAndResponse = LlmTraceCache.INSTANCE.get(llmTraceId);
        if (requestAndResponse != null) {
            j.H("命中本地llm trace缓存, traceId=" + llmTraceId, TAG);
        }
        if (requestAndResponse != null) {
            return gson.toJson(requestAndResponse);
        }
        j.H("不需要处理llm数据，且本地缓存未命中 traceId=" + llmTraceId, TAG);
        return null;
    }

    private final RequestAndResponse mergeRequestAndResponse(RequestAndResponse localTrace, String remoteTraceRaw) {
        if (localTrace == null && (remoteTraceRaw == null || m.s0(remoteTraceRaw))) {
            return null;
        }
        RequestAndResponse requestAndResponse = localTrace == null ? new RequestAndResponse(null, null, 0L, null, null, 16, null) : localTrace;
        return (remoteTraceRaw == null || m.s0(remoteTraceRaw)) ? RequestAndResponse.copy$default(requestAndResponse, null, null, 0L, null, null, 23, null) : RequestAndResponse.copy$default(requestAndResponse, null, null, 0L, parseRemoteTraceRaw(remoteTraceRaw), null, 23, null);
    }

    private final void parseLlmExtraField(JsonObject jsonObj, String fieldName) {
        Object objA;
        JsonElement jsonElement = jsonObj.get(fieldName);
        if (jsonElement != null && jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
            try {
                objA = (RequestAndResponse) gson.fromJson(jsonElement.getAsString(), RequestAndResponse.class);
            } catch (Throwable th) {
                objA = b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                U7.a.L(fieldName + " parse error", thA);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            RequestAndResponse requestAndResponse = (RequestAndResponse) objA;
            if (requestAndResponse != null) {
                jsonObj.add(fieldName, gson.toJsonTree(requestAndResponse));
            }
        }
    }

    private final void parseLlmExtraInStep(JsonObject stepObj) {
        parseLlmExtraField(stepObj, "llmExtra");
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
    /* renamed from: postExecution-yxL6bBk$default, reason: not valid java name */
    public static /* synthetic */ Object m7365postExecutionyxL6bBk$default(GuiAgentTraceManager guiAgentTraceManager, String str, Map map, Map map2, S7.k kVar, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        if ((i & 4) != 0) {
            map2 = null;
        }
        if ((i & 8) != 0) {
            kVar = null;
        }
        return guiAgentTraceManager.m7366postExecutionyxL6bBk(str, map, map2, kVar, cVar);
    }

    private final GuiTraceCompressionEvent processCompressionEvent(GuiTraceCompressionEvent event, boolean allowRemoteFetch) {
        return GuiTraceCompressionEvent.copy$default(event, null, 0, null, null, 0L, null, getLlmTrace(event.getLlmTraceId(), allowRemoteFetch), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388543, null);
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
            boolean r2 = r1 instanceof stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager.C19451
            if (r2 == 0) goto L18
            r2 = r1
            stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$processStep$1 r2 = (stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager.C19451) r2
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
            stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$processStep$1 r2 = new stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$processStep$1
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
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager.processStep(stepai.aios.guiagent.tracer.remote.GuiTraceStep, java.io.File, java.lang.String, boolean, java.util.Map, H7.c):java.lang.Object");
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
        U7.a.L("sanitize request base64 failed", thA);
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
            boolean r0 = r5 instanceof stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager.C19461
            if (r0 == 0) goto L13
            r0 = r5
            stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$syncLlmTraceBuffer$1 r0 = (stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager.C19461) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$syncLlmTraceBuffer$1 r0 = new stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$syncLlmTraceBuffer$1
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
            if (r5 == 0) goto L68
            boolean r4 = r4.syncTraceBuffer()     // Catch: java.lang.Throwable -> L4e
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L4e
            goto L53
        L4e:
            r4 = move-exception
            kotlin.Result$Failure r4 = kotlin.b.a(r4)
        L53:
            java.lang.Throwable r5 = kotlin.Result.a(r4)
            if (r5 == 0) goto L5e
            java.lang.String r0 = "syncTraceBuffer failed"
            U7.a.L(r0, r5)
        L5e:
            kotlin.b.b(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            goto L70
        L68:
            java.lang.String r4 = "Client 没有连接"
            java.lang.String r5 = "RobotTrace"
            N9.j.G(r4, r5)
            r4 = 0
        L70:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager.syncLlmTraceBuffer(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toJsonWithParsedLlmExtra(Object experienceResult, Object injectExperienceResult, GuiTraceTreeRecord record, String toolCallId, String taskId) {
        Gson gson2 = gson;
        JsonObject asJsonObject = gson2.toJsonTree(record).getAsJsonObject();
        k.c(asJsonObject);
        formatTimeField(asJsonObject, "createdAt");
        formatTimeField(asJsonObject, "updatedAt");
        JsonArray asJsonArray = asJsonObject.getAsJsonArray("nodes");
        if (asJsonArray == null) {
            String json = gson2.toJson((JsonElement) asJsonObject);
            k.e(json, "toJson(...)");
            return json;
        }
        int i = 0;
        for (JsonElement jsonElement : asJsonArray) {
            int i6 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            JsonObject asJsonObject2 = jsonElement.getAsJsonObject();
            GuiAgentTraceManager guiAgentTraceManager = INSTANCE;
            k.c(asJsonObject2);
            guiAgentTraceManager.formatTimeField(asJsonObject2, "createdAt");
            guiAgentTraceManager.formatTimeField(asJsonObject2, "updatedAt");
            JsonArray asJsonArray2 = asJsonObject2.getAsJsonArray("steps");
            if (asJsonArray2 != null) {
                Iterator<JsonElement> it = asJsonArray2.iterator();
                while (it.hasNext()) {
                    JsonObject asJsonObject3 = it.next().getAsJsonObject();
                    GuiAgentTraceManager guiAgentTraceManager2 = INSTANCE;
                    k.c(asJsonObject3);
                    guiAgentTraceManager2.formatTimeField(asJsonObject3, "updatedAt");
                    guiAgentTraceManager2.parseLlmExtraInStep(asJsonObject3);
                }
                JsonArray asJsonArray3 = asJsonObject2.getAsJsonArray("compressionEvents");
                if (asJsonArray3 != null) {
                    Iterator<JsonElement> it2 = asJsonArray3.iterator();
                    while (it2.hasNext()) {
                        JsonObject asJsonObject4 = it2.next().getAsJsonObject();
                        GuiAgentTraceManager guiAgentTraceManager3 = INSTANCE;
                        k.c(asJsonObject4);
                        guiAgentTraceManager3.formatTimeField(asJsonObject4, "updatedAt");
                        guiAgentTraceManager3.parseLlmExtraField(asJsonObject4, "llmExtra");
                    }
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
        asJsonObject.add("metadata", TraceMetadataKt.buildAppMetadata());
        String json2 = gson.toJson((JsonElement) asJsonObject);
        k.e(json2, "toJson(...)");
        return json2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadStepScreenshot(stepai.aios.guiagent.tracer.remote.GuiTraceStep r14, java.io.File r15, java.lang.String r16, java.util.Map<java.lang.String, java.lang.String> r17, H7.c<? super java.lang.String> r18) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager.uploadStepScreenshot(stepai.aios.guiagent.tracer.remote.GuiTraceStep, java.io.File, java.lang.String, java.util.Map, H7.c):java.lang.Object");
    }

    public final void cacheLlmTrace(String traceId, Object request, String response, long costTimeMs, JsonElement fullResponse) {
        if (traceId == null || m.s0(traceId)) {
            return;
        }
        LlmTraceCache.INSTANCE.put(traceId, new RequestAndResponse(sanitizeRequestBase64(request), response, costTimeMs, null, fullResponse, 8, null));
    }

    public final void evictLlmTraceCache(Collection<String> traceIds) {
        k.f(traceIds, "traceIds");
        if (traceIds.isEmpty()) {
            return;
        }
        LlmTraceCache llmTraceCache = LlmTraceCache.INSTANCE;
        int size = llmTraceCache.size();
        llmTraceCache.removeAll(traceIds);
        int size2 = size - llmTraceCache.size();
        int size3 = traceIds.size();
        int size4 = llmTraceCache.size();
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(size2, "evictLlmTraceCache: removed ", size3, " entries (requested=", ", remaining=");
        sbS.append(size4);
        sbS.append(")");
        j.H(sbS.toString(), TAG);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: postExecution-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7366postExecutionyxL6bBk(java.lang.String r10, java.util.Map<java.lang.String, ? extends java.lang.Object> r11, java.util.Map<java.lang.String, java.lang.String> r12, S7.k r13, H7.c<? super kotlin.Result<java.lang.String>> r14) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r14 instanceof stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$postExecution$1
            if (r0 == 0) goto L13
            r0 = r14
            stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$postExecution$1 r0 = (stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$postExecution$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$postExecution$1 r0 = new stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$postExecution$1
            r0.<init>(r9, r14)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r14 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r10 = r0.L$3
            S7.k r10 = (S7.k) r10
            java.lang.Object r10 = r0.L$2
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r10 = r0.L$1
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.b.b(r9)
            goto L62
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3f:
            kotlin.b.b(r9)
            u9.d r9 = m9.AbstractC1691I.f5315a
            u9.c r9 = u9.c.f6743a
            stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$postExecution$2 r3 = new stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager$postExecution$2
            r8 = 0
            r5 = r10
            r4 = r11
            r7 = r12
            r6 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            r10 = 0
            r0.L$0 = r10
            r0.L$1 = r10
            r0.L$2 = r10
            r0.L$3 = r10
            r0.label = r2
            java.lang.Object r9 = m9.AbstractC1683A.w(r9, r3, r0)
            if (r9 != r14) goto L62
            return r14
        L62:
            kotlin.Result r9 = (kotlin.Result) r9
            java.lang.Object r9 = r9.f4887a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager.m7366postExecutionyxL6bBk(java.lang.String, java.util.Map, java.util.Map, S7.k, H7.c):java.lang.Object");
    }

    public final void registerUploader(IUpload uploader2) {
        k.f(uploader2, "uploader");
        uploader = uploader2;
    }

    public final void removeLlmTrace(String traceId) {
        if (traceId == null || m.s0(traceId)) {
            return;
        }
        LlmTraceCache.INSTANCE.remove(traceId);
    }
}
