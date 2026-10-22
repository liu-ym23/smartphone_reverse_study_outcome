package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import D7.w;
import F9.AbstractC0226d;
import F9.B;
import F9.E;
import F9.F;
import F9.G;
import F9.J;
import F9.K;
import F9.M;
import F9.P;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.aiengine.algorithm.highlight.HighlightCallback;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.taskrobot.taskmanager.experiencelib.model.Action;
import com.stepos.taskrobot.taskmanager.experiencelib.model.SpeculationLabel;
import f6.AbstractC1436a;
import io.modelcontextprotocol.spec.HttpHeaders;
import j9.AbstractC1607a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import okhttp3.logging.HttpLoggingInterceptor$Level;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010 J4\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086@¢\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010*\u001a\u00020)8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010'R\u001c\u00100\u001a\n /*\u0004\u0018\u00010.0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/TrajectorySpeculationLabeler;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "loadPrompt", "(Landroid/content/Context;)Ljava/lang/String;", HighlightArgsBundle.KEY_PROMPT, "Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;", "guiTaskRecord", "", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Action;", "actions", "buildRequestBody", "(Ljava/lang/String;Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;Ljava/util/List;)Ljava/lang/String;", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "requestBody", "requestLabels", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "rawContent", "", "expectedCount", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SpeculationLabel$Label;", "parseLabels", "(Ljava/lang/String;I)Ljava/util/List;", "reason", "applyFallbackLabels", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "normalizeActionForLabel", "(Ljava/lang/String;)Ljava/lang/String;", "labelActions", "(Landroid/content/Context;Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "LC7/r;", "dumpModelAvailability", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "PROMPT_ASSET_PATH", "", "LABEL_REQUEST_TIMEOUT_MS", "J", "LABEL_API_URL", "LABEL_MODEL_ID", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "LF9/B;", "JSON_MEDIA_TYPE", "LF9/B;", "LF9/F;", "labelHttpClient$delegate", "LC7/f;", "getLabelHttpClient", "()LF9/F;", "labelHttpClient", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TrajectorySpeculationLabeler {
    private static final B JSON_MEDIA_TYPE;
    private static final String LABEL_API_URL = "https://biz-gw.stepaos.com/gui-agent-service/api/llm/chat/completions";
    private static final String LABEL_MODEL_ID = "doubao-seed-1.8";
    private static final long LABEL_REQUEST_TIMEOUT_MS = 15000;
    private static final String PROMPT_ASSET_PATH = "prompts/is_reuse_label_tag_prompt.md";
    private static final String TAG = "TrajectorySpecLabeler";

    /* renamed from: labelHttpClient$delegate, reason: from kotlin metadata */
    private static final C7.f labelHttpClient;
    public static final TrajectorySpeculationLabeler INSTANCE = new TrajectorySpeculationLabeler();
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.TrajectorySpeculationLabeler", f = "TrajectorySpeculationLabeler.kt", l = {88}, m = "labelActions", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.TrajectorySpeculationLabeler$labelActions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TrajectorySpeculationLabeler.this.labelActions(null, null, null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.TrajectorySpeculationLabeler$requestLabels$2", f = "TrajectorySpeculationLabeler.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.TrajectorySpeculationLabeler$requestLabels$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements S7.n {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $requestBody;
        final /* synthetic */ String $taskId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Context context, String str2, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$requestBody = str;
            this.$context = context;
            this.$taskId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$requestBody, this.$context, this.$taskId, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            JSONObject jSONObjectOptJSONObject;
            JSONObject jSONObjectOptJSONObject2;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            K1.a aVar = new K1.a();
            aVar.s(TrajectorySpeculationLabeler.LABEL_API_URL);
            aVar.b(HttpHeaders.CONTENT_TYPE, "application/json");
            J j5 = K.Companion;
            String str = this.$requestBody;
            B b = TrajectorySpeculationLabeler.JSON_MEDIA_TYPE;
            j5.getClass();
            aVar.i(J.b(str, b));
            G gD = aVar.d();
            TaskEvidenceStore taskEvidenceStore = TaskEvidenceStore.INSTANCE;
            Context context = this.$context;
            String str2 = this.$taskId;
            String json = TrajectorySpeculationLabeler.gson.toJson(kotlin.collections.a.R(new Pair(BffConstant.Type.Url, TrajectorySpeculationLabeler.LABEL_API_URL), new Pair(AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, TrajectorySpeculationLabeler.LABEL_MODEL_ID), new Pair("requestBodyBytes", new Integer(this.$requestBody.length()))));
            kotlin.jvm.internal.k.e(json, "toJson(...)");
            taskEvidenceStore.writeText(context, str2, "label_request_dispatch.json", json);
            F labelHttpClient = TrajectorySpeculationLabeler.INSTANCE.getLabelHttpClient();
            labelHttpClient.getClass();
            M mD = new J9.i(labelHttpClient, gD).d();
            int i = mD.d;
            P p = mD.g;
            String strG = p != null ? p.g() : null;
            taskEvidenceStore.writeText(this.$context, this.$taskId, "label_response_raw.json", strG == null ? "(null)" : strG);
            if (!mD.c() || strG == null) {
                AbstractC1436a.b(TrajectorySpeculationLabeler.TAG, androidx.constraintlayout.core.dsl.a.c(i, "requestLabels HTTP failed: code=", " body=", strG != null ? j9.m.N0(200, strG) : null), true);
                Context context2 = this.$context;
                String str3 = this.$taskId;
                String json2 = TrajectorySpeculationLabeler.gson.toJson(kotlin.collections.a.R(new Pair("httpCode", new Integer(i)), new Pair("success", Boolean.FALSE), new Pair("error", strG != null ? j9.m.N0(500, strG) : "null body")));
                kotlin.jvm.internal.k.e(json2, "toJson(...)");
                taskEvidenceStore.writeText(context2, str3, "label_response_summary.json", json2);
                return null;
            }
            AbstractC1436a.a(TrajectorySpeculationLabeler.TAG, androidx.compose.foundation.b.n(i, strG.length(), "requestLabels HTTP success: code=", " bodyLen="), true);
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(strG).optJSONArray("choices");
                objA = (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("message")) == null) ? null : jSONObjectOptJSONObject2.optString("content");
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                AbstractC1436a.b(TrajectorySpeculationLabeler.TAG, "requestLabels parse response JSON failed: " + thA.getMessage(), true);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            String str4 = (String) objA;
            TaskEvidenceStore taskEvidenceStore2 = TaskEvidenceStore.INSTANCE;
            Context context3 = this.$context;
            String str5 = this.$taskId;
            String json3 = TrajectorySpeculationLabeler.gson.toJson(kotlin.collections.a.R(new Pair("httpCode", new Integer(i)), new Pair("success", Boolean.TRUE), new Pair("contentLength", new Integer(str4 != null ? str4.length() : 0)), new Pair("contentPreview", str4 != null ? j9.m.N0(200, str4) : "")));
            kotlin.jvm.internal.k.e(json3, "toJson(...)");
            taskEvidenceStore2.writeText(context3, str5, "label_response_summary.json", json3);
            if (str4 != null && !j9.m.s0(str4)) {
                return str4;
            }
            AbstractC1436a.e(TrajectorySpeculationLabeler.TAG, "requestLabels: content is empty in response", true);
            return null;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super String> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    static {
        Pattern pattern = B.e;
        JSON_MEDIA_TYPE = AbstractC0226d.g("application/json; charset=utf-8");
        labelHttpClient = kotlin.a.a(new i(2));
    }

    private TrajectorySpeculationLabeler() {
    }

    private final List<Action> applyFallbackLabels(List<Action> actions, String reason) {
        List<Action> list = actions;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i6 = i + 1;
            if (i < 0) {
                H4.o.X();
                throw null;
            }
            arrayList.add(Action.copy$default((Action) obj, null, null, null, 0, null, false, null, null, null, new SpeculationLabel(H4.o.M(new SpeculationLabel.Label(i6, false, 0.0d, reason))), 511, null));
            i = i6;
        }
        return arrayList;
    }

    private final String buildRequestBody(String prompt, GuiTaskRecord guiTaskRecord, List<Action> actions) {
        Pair pair = new Pair("task", guiTaskRecord.getTaskName());
        String appName = guiTaskRecord.getAppName();
        if (appName == null) {
            appName = "";
        }
        Pair pair2 = new Pair("app", appName);
        String traceId = guiTaskRecord.getTraceId();
        if (traceId == null) {
            traceId = "";
        }
        Pair pair3 = new Pair(Key.KEY_TRACE_ID, traceId);
        List<Action> list = actions;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i6 = i + 1;
            if (i < 0) {
                H4.o.X();
                throw null;
            }
            Action action = (Action) next;
            Pair pair4 = new Pair("step", Integer.valueOf(i6));
            Pair pair5 = new Pair(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, INSTANCE.normalizeActionForLabel(action.getAction()));
            String explain = action.getExplain();
            if (explain == null) {
                explain = "";
            }
            Pair pair6 = new Pair("explain", explain);
            String summary = action.getSummary();
            if (summary == null) {
                summary = "";
            }
            Pair pair7 = new Pair("summary", summary);
            Pair pair8 = new Pair("value", action.getValue());
            Pair pair9 = new Pair("point", action.getPoint());
            String actionSource = action.getActionSource();
            if (actionSource == null) {
                actionSource = "";
            }
            arrayList.add(kotlin.collections.a.R(pair4, pair5, pair6, pair7, pair8, pair9, new Pair("actionsource", actionSource), new Pair("clickregionxmlinfo", action.getRegionXmlInfo())));
            it = it;
            i = i6;
        }
        Map mapR = kotlin.collections.a.R(pair, pair2, pair3, new Pair("steps", arrayList));
        Pair pair10 = new Pair(AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, LABEL_MODEL_ID);
        Map mapR2 = kotlin.collections.a.R(new Pair("role", "system"), new Pair("content", prompt));
        Pair pair11 = new Pair("role", BffConstant.Role.User);
        Gson gson2 = gson;
        String json = gson2.toJson(kotlin.collections.a.R(pair10, new Pair("messages", H4.o.N(mapR2, kotlin.collections.a.R(pair11, new Pair("content", gson2.toJson(mapR))))), new Pair(LlmRuntimeArgsBundle.KEY_TEMPERATURE, Double.valueOf(0.1d)), new Pair("top_p", Double.valueOf(0.7d)), new Pair(HighlightCallback.ARG_MAX_TOKENS, 2048), new Pair("think", Boolean.FALSE)));
        kotlin.jvm.internal.k.e(json, "toJson(...)");
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final F getLabelHttpClient() {
        return (F) labelHttpClient.getF4884a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final F labelHttpClient_delegate$lambda$0() {
        T9.b bVar = new T9.b(new k());
        bVar.b = HttpLoggingInterceptor$Level.c;
        E e = new E();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e.b(15L, timeUnit);
        e.c(60L, timeUnit);
        e.e(15L, timeUnit);
        e.a(bVar);
        return new F(e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void labelHttpClient_delegate$lambda$0$0(String message) {
        kotlin.jvm.internal.k.f(message, "message");
        AbstractC1436a.a(TAG, message, true);
    }

    private final String loadPrompt(Context context) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(PROMPT_ASSET_PATH);
        kotlin.jvm.internal.k.e(inputStreamOpen, "open(...)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, AbstractC1607a.f4778a), 8192);
        try {
            String strO1 = S0.b.o1(bufferedReader);
            bufferedReader.close();
            return j9.m.R0(strO1).toString();
        } finally {
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    private final String normalizeActionForLabel(String action) {
        Locale locale = Locale.ROOT;
        String lowerCase = action.toLowerCase(locale);
        kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -1263343069:
                if (lowerCase.equals("systemnavigation_back")) {
                    return "BACK";
                }
                break;
            case -1263192169:
                if (lowerCase.equals("openapp")) {
                    return "AWAKE";
                }
                break;
            case -1263150565:
                if (lowerCase.equals("systemnavigation_home")) {
                    return "HOME";
                }
                break;
            case -909389910:
                if (lowerCase.equals("pressback")) {
                    return "BACK";
                }
                break;
            case -909197406:
                if (lowerCase.equals("presshome")) {
                    return "HOME";
                }
                break;
            case 94750088:
                if (lowerCase.equals(RequestInfo.FUNCTION_CLICK)) {
                    return "CLICK";
                }
                break;
            case 100358090:
                if (lowerCase.equals("input")) {
                    return "TYPE";
                }
                break;
            case 109854522:
                if (lowerCase.equals(RequestInfo.FUNCTION_SWIPE)) {
                    return "SLIDE";
                }
                break;
            case 131574924:
                if (lowerCase.equals("longclick")) {
                    return "LONGPRESS";
                }
                break;
        }
        String upperCase = action.toUpperCase(locale);
        kotlin.jvm.internal.k.e(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private final List<SpeculationLabel.Label> parseLabels(String rawContent, int expectedCount) {
        int asInt;
        String asString;
        JsonArray asJsonArray = JsonParser.parseString(j9.m.R0(j9.m.z0(j9.m.y0("```", j9.m.y0("```json", j9.m.R0(rawContent).toString())), "```")).toString()).getAsJsonObject().getAsJsonArray("labels");
        if (asJsonArray != null && asJsonArray.size() == expectedCount) {
            ArrayList arrayList = new ArrayList(w.c0(asJsonArray, 10));
            int i = 0;
            for (JsonElement jsonElement : asJsonArray) {
                int i6 = i + 1;
                if (i < 0) {
                    H4.o.X();
                    throw null;
                }
                JsonObject asJsonObject = jsonElement.getAsJsonObject();
                JsonElement jsonElement2 = asJsonObject.get("step");
                if (jsonElement2 != null && (asInt = jsonElement2.getAsInt()) == i6) {
                    JsonElement jsonElement3 = asJsonObject.get("is_speculation");
                    boolean asBoolean = jsonElement3 != null ? jsonElement3.getAsBoolean() : false;
                    JsonElement jsonElement4 = asJsonObject.get("spec_confidence");
                    double asDouble = jsonElement4 != null ? jsonElement4.getAsDouble() : 0.0d;
                    JsonElement jsonElement5 = asJsonObject.get("spec_reason");
                    if (jsonElement5 == null || (asString = jsonElement5.getAsString()) == null) {
                        asString = "";
                    }
                    arrayList.add(new SpeculationLabel.Label(asInt, asBoolean, asDouble, asString));
                    i = i6;
                }
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestLabels(Context context, String str, String str2, H7.c<? super String> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(str2, context, str, null), cVar);
    }

    public final void dumpModelAvailability(Context context, String taskId) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        TaskEvidenceStore taskEvidenceStore = TaskEvidenceStore.INSTANCE;
        String json = gson.toJson(kotlin.collections.a.R(new Pair("labelModelId", LABEL_MODEL_ID), new Pair("labelApiUrl", LABEL_API_URL), new Pair(AgentBusWakeContract.EXTRA_SOURCE, "direct_http (not BFF)")));
        kotlin.jvm.internal.k.e(json, "toJson(...)");
        taskEvidenceStore.writeText(context, taskId, "label_model_availability.json", json);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object labelActions(android.content.Context r26, com.stepos.taskrobot.llmapi.stepfun.GuiTaskRecord r27, java.util.List<com.stepos.taskrobot.taskmanager.experiencelib.model.Action> r28, H7.c<? super java.util.List<com.stepos.taskrobot.taskmanager.experiencelib.model.Action>> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.TrajectorySpeculationLabeler.labelActions(android.content.Context, com.stepos.taskrobot.llmapi.stepfun.GuiTaskRecord, java.util.List, H7.c):java.lang.Object");
    }
}
