package com.stepos.ailauncher.sla;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.UsageStatsProxy3;
import h8.C4148a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJQ\u0010\u0016\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J;\u0010\u0019\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ9\u0010\u001d\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ;\u0010\"\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\"\u0010\u001aJ-\u0010%\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010$H\u0002¢\u0006\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010(R\u0014\u0010/\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010(R\u0014\u00100\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010(R\u0014\u00101\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010(R\u0014\u00102\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010(R\u0014\u00103\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010(R\u0014\u00104\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010(R\u0014\u00105\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010(R\u0014\u00106\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u0010(R\u0014\u00107\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u0010(R\u0014\u00108\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u0010(R\u0014\u00109\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u0010(R\u0014\u0010:\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u0010(R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lcom/stepos/ailauncher/sla/G;", "", "<init>", "()V", "", "sessionId", "conversationId", "inputType", "network", "lockState", "", "conversationRound", "entrySource", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "judgeResult", "functionName", "params", "", "latencyMs", "modelVersion", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "instructionName", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "executeResult", "failReason", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "feedbackType", "targetPage", "showSuccess", "c", "event", "", "f", "(Ljava/lang/String;Ljava/util/Map;)V", "TAG", "Ljava/lang/String;", "PAGE_NAME", "EVENT_START", "EVENT_JUDGE_RESULT", "EVENT_EXECUTE_START", "EVENT_EXECUTE_RESULT", "EVENT_FEEDBACK_SHOW", "INPUT_VOICE", "INPUT_TEXT", "JUDGE_HIT", "JUDGE_FALLBACK_OPENCLAW", "EXEC_SUCCESS", "EXEC_FAIL", "LOCK_LOCKED", "LOCK_UNLOCKED", "NETWORK_ONLINE", "NETWORK_OFFLINE", "COLD_START_YES", "COLD_START_NO", "Ljava/util/concurrent/atomic/AtomicBoolean;", "firstChainPending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "currentChainColdStart", "Z", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class G {
    public static final String COLD_START_NO = "no";
    public static final String COLD_START_YES = "yes";
    private static final String EVENT_EXECUTE_RESULT = "sla_execute_result";
    private static final String EVENT_EXECUTE_START = "sla_execute_start";
    private static final String EVENT_FEEDBACK_SHOW = "sla_feedback_show";
    private static final String EVENT_JUDGE_RESULT = "sla_judge_result";
    private static final String EVENT_START = "sla_start";
    public static final String EXEC_FAIL = "fail";
    public static final String EXEC_SUCCESS = "success";
    public static final String INPUT_TEXT = "text";
    public static final String INPUT_VOICE = "voice";
    public static final String JUDGE_FALLBACK_OPENCLAW = "fallback_openclaw";
    public static final String JUDGE_HIT = "hit";
    public static final String LOCK_LOCKED = "locked";
    public static final String LOCK_UNLOCKED = "unlocked";
    public static final String NETWORK_OFFLINE = "offline";
    public static final String NETWORK_ONLINE = "online";
    private static final String PAGE_NAME = "chatview";
    private static final String TAG = "SlaTracker";
    private static volatile boolean currentChainColdStart;
    public static final G INSTANCE = new G();
    private static final AtomicBoolean firstChainPending = new AtomicBoolean(true);

    public static /* synthetic */ void e(G g10, String str, String str2, String str3, String str4, Long l10, String str5, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        if ((i10 & 8) != 0) {
            str4 = null;
        }
        if ((i10 & 16) != 0) {
            l10 = null;
        }
        if ((i10 & 32) != 0) {
            str5 = null;
        }
        g10.d(str, str2, str3, str4, l10, str5);
    }

    public final void a(String sessionId, String executeResult, String failReason, Long latencyMs) {
        f(EVENT_EXECUTE_RESULT, kotlin.collections.a.m(Y8.j.a("session_id", sessionId), Y8.j.a("execute_result", executeResult), Y8.j.a("fail_reason", failReason), Y8.j.a("latency_ms", latencyMs)));
    }

    public final void b(String sessionId, String instructionName, String functionName, String params) {
        f(EVENT_EXECUTE_START, kotlin.collections.a.m(Y8.j.a("session_id", sessionId), Y8.j.a("instruction_name", instructionName), Y8.j.a("function_name", functionName), Y8.j.a("sla_params", params)));
    }

    public final void c(String sessionId, String feedbackType, String targetPage, String showSuccess) {
        f(EVENT_FEEDBACK_SHOW, kotlin.collections.a.m(Y8.j.a("session_id", sessionId), Y8.j.a("feedback_type", feedbackType), Y8.j.a("target_page", targetPage), Y8.j.a("show_success", showSuccess), Y8.j.a("cold_start", currentChainColdStart ? "yes" : "no")));
    }

    public final void d(String sessionId, String judgeResult, String functionName, String params, Long latencyMs, String modelVersion) {
        f(EVENT_JUDGE_RESULT, kotlin.collections.a.m(Y8.j.a("session_id", sessionId), Y8.j.a("judge_result", judgeResult), Y8.j.a("function_name", functionName), Y8.j.a("sla_params", params), Y8.j.a("latency_ms", latencyMs), Y8.j.a("model_version", modelVersion)));
    }

    public final void f(String event, Map<String, ? extends Object> params) {
        Object objB;
        HashMap map = new HashMap();
        Iterator<Map.Entry<String, ? extends Object>> it = params.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ? extends Object> next = it.next();
            String key = next.getKey();
            Object value = next.getValue();
            String string = value != null ? value.toString() : null;
            if (string != null && string.length() != 0) {
                map.put(key, string);
            }
        }
        map.put("page_name", "chatview");
        C4148a.d("Track", event + " page=chatview " + map, false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            UsageStatsProxy3.getInstance().onEvent(event, "chatview", map);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, "sla track fail: event=" + event + ", " + thE.getMessage(), false, 4, null);
        }
    }

    public final void g(String sessionId, String conversationId, String inputType, String network, String lockState, Integer conversationRound, String entrySource) {
        currentChainColdStart = firstChainPending.compareAndSet(true, false);
        f(EVENT_START, kotlin.collections.a.m(Y8.j.a("session_id", sessionId), Y8.j.a("conversation_id", conversationId), Y8.j.a("input_type", inputType), Y8.j.a("network_status", network), Y8.j.a("lock_state", lockState), Y8.j.a("conversation_round", conversationRound), Y8.j.a("entry_source", entrySource)));
    }
}
