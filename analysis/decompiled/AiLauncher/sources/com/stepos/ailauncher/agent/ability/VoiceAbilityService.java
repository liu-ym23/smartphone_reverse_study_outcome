package com.stepos.ailauncher.agent.ability;

import La.C;
import La.H;
import N5.CardEnvelope;
import N5.z;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import com.stepos.agentframework.chatcore.session.list.SessionActivityTracker;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.chat.lockscreen.LockScreenChatActivity;
import com.stepos.ailauncher.chat.lockscreen.x;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.session.ChatRoundUserDecisionHold;
import com.stepos.ailauncher.common.utils.C3202f;
import com.stepos.ailauncher.common.utils.E;
import com.stepos.ailauncher.common.utils.y;
import com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService;
import com.stepos.ailauncher.mcpservice.risk.RiskStatementButton;
import com.stepos.ailauncher.mcpservice.risk.RiskStatementParams;
import com.stepos.ailauncher.mcpservice.risk.UnlockSceneResult;
import com.stepos.ailauncher.mcpservice.risk.q;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.mcp.sdk.java.service.AbsMCPService;
import h8.C4148a;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import o6.C5009a;
import org.json.JSONException;
import org.json.JSONObject;
import p7.AbilityResult;
import p7.AppUI;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import qb.D;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \\2\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0003J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u001eH\u0002¢\u0006\u0004\b(\u0010)J/\u0010-\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010+0*H\u0002¢\u0006\u0004\b-\u0010.J/\u0010/\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010+0*H\u0002¢\u0006\u0004\b/\u0010.J/\u00101\u001a\u0002002\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010+0*H\u0002¢\u0006\u0004\b1\u00102J)\u00105\u001a\u0004\u0018\u00010\u00132\u0016\u00104\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+03\"\u0004\u0018\u00010+H\u0002¢\u0006\u0004\b5\u00106J\u001f\u00107\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b9\u0010:J\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010;\u001a\u00020\u0013H\u0002¢\u0006\u0004\b<\u0010=J\u001f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?2\b\u0010>\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\bA\u0010BJ\u0019\u0010D\u001a\u0004\u0018\u00010@2\u0006\u0010C\u001a\u00020\u0013H\u0002¢\u0006\u0004\bD\u0010EJ\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\bF\u0010\u0010JC\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010G\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u00132\u0014\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010+0*2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ)\u0010O\u001a\u00020\u0013*\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010+0*2\u0006\u0010N\u001a\u00020\u0013H\u0002¢\u0006\u0004\bO\u0010PR\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010T\u001a\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\bT\u0010UR\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lcom/stepos/ailauncher/agent/ability/VoiceAbilityService;", "Lcom/stepos/mcp/sdk/java/service/AbsMCPService;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "LY8/t;", "c", "Lio/modelcontextprotocol/spec/McpSchema$CallToolRequest;", "request", "Lreactor/core/publisher/Mono;", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "D", "(Lio/modelcontextprotocol/spec/McpSchema$CallToolRequest;)Lreactor/core/publisher/Mono;", "C", "F", "", "label", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)V", "requestId", "phase", "toolResult", "U", "(Ljava/lang/String;Ljava/lang/String;Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;)V", "Lcom/stepos/ailauncher/mcpservice/risk/p;", "params", "", "a0", "(Lcom/stepos/ailauncher/mcpservice/risk/p;)Z", "sessionId", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/String;)Z", "Lcom/stepos/ailauncher/mcpservice/risk/q;", "result", ExifInterface.LONGITUDE_WEST, "(Lcom/stepos/ailauncher/mcpservice/risk/p;Lcom/stepos/ailauncher/mcpservice/risk/q;)V", "R", "()Z", "", "", "args", "x", "(Lio/modelcontextprotocol/spec/McpSchema$CallToolRequest;Ljava/util/Map;)Ljava/lang/String;", "z", "", "y", "(Lio/modelcontextprotocol/spec/McpSchema$CallToolRequest;Ljava/util/Map;)J", "", "values", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "([Ljava/lang/Object;)Ljava/lang/String;", "t", "(Lcom/stepos/ailauncher/mcpservice/risk/p;Lcom/stepos/ailauncher/mcpservice/risk/q;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "u", "(Lcom/stepos/ailauncher/mcpservice/risk/q;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "message", "w", "(Ljava/lang/String;)Lreactor/core/publisher/Mono;", "raw", "", "Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton;", "X", "(Ljava/lang/Object;)Ljava/util/List;", "tag", "c0", "(Ljava/lang/String;)Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton;", ExifInterface.LONGITUDE_EAST, "templateType", "taskId", "customData", "LN5/d;", "existing", "Y", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;LN5/d;)Lreactor/core/publisher/Mono;", "key", "b0", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "riskTag", "Ljava/lang/String;", "Lcom/google/gson/Gson;", "envelopeGson$delegate", "LY8/h;", "B", "()Lcom/google/gson/Gson;", "envelopeGson", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceAbilityService extends AbsMCPService {
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_LEVEL = "level";
    private static final String ARG_SCENE = "scene";
    private static final String ARG_TAGS = "tags";
    private static final String ARG_TITLE = "title";
    private static final String CHAT_PACKAGE_PREFIX = "com.stepos.ailauncher.chat.";
    private static final String META_SESSION_ID_CAMEL = "sessionId";
    private static final String META_SESSION_ID_SNAKE = "session_id";
    private static final String META_SESSION_ID_UPPER = "SESSION_ID";
    private static final String META_TIMEOUT_MS_CAMEL = "timeoutMs";
    private static final String META_TIMEOUT_MS_SNAKE = "timeout_ms";
    private static final String META_TIMEOUT_MS_UPPER = "TIMEOUT_MS";
    private static final String META_TOOL_CALL_ID_CAMEL = "toolCallId";
    private static final String META_TOOL_CALL_ID_SNAKE = "tool_call_id";
    private static final String META_TOOL_CALL_ID_UPPER = "TOOL_CALL_ID";
    public static final String PARAM_VOICE_ID = "voice_id";
    private static final long RISK_STATEMENT_TIMEOUT_MAX_MS = 1800000;
    private static final long RISK_STATEMENT_TIMEOUT_MIN_MS = 30000;
    private static final long RISK_STATEMENT_TIMEOUT_MS = 600000;
    private static final String TAG = "VoiceAbilityService";
    private static final String TAG_ALLOW_ONCE = "allow_once";
    private static final String TAG_ALWAYS_ALLOW = "always_allow";
    private static final String TAG_REJECT = "reject";
    public static final String TOOL_CHANGE_VOICE_ID = "assistant_change_voice_id";
    public static final String TOOL_GET_VOICE_LIST = "assistant_get_voice_list";
    public static final String TOOL_LOAD_TRIPARTITE_COMMON_CARD = "ailauncher_load_tripartite_common_card";
    public static final String TOOL_SHOW_RISK_STATEMENT = "assistant_show_risk_statement";
    private static final List<String> ENVELOPE_KEYS = C1173v.p("templateType", "taskId", "sessionId", "taskTitle", D6.a.KEY_TASK_STATUS, "displayMode", "bizChannel", c.a.COL_SUMMARY, "links", "searchSource", "businessData", "error");
    private static final List<String> SUPPORTED_VOICE_IDS = C1173v.p("livelybreezy-female", "zhengpaiqingnian", "shuangkuainansheng", "ganliannvsheng", "qinhenvsheng", "huolinvsheng", "elegantgentle-female", "wenrounansheng", "jingdiannvsheng", "wenroushunv", "tianmeinvsheng", "qingchunshaonv", "yuanqinansheng", "cixingnansheng", "xingjiejie");
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final String riskTag = "RiskTool";

    /* renamed from: envelopeGson$delegate, reason: from kotlin metadata */
    private final Y8.h envelopeGson = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.ability.r
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return VoiceAbilityService.v();
        }
    });

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UnlockSceneResult.values().length];
            try {
                iArr[UnlockSceneResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UnlockSceneResult.ALREADY_UNLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void G(final RiskStatementParams riskStatementParams, final VoiceAbilityService voiceAbilityService, final long j10, final String str, final MonoSink monoSink) {
        U5.b.INSTANCE.w(riskStatementParams.getRiskLevel(), true);
        voiceAbilityService.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.agent.ability.u
            @Override // java.lang.Runnable
            public final void run() {
                VoiceAbilityService.H(this.f23894a, riskStatementParams, j10, monoSink, str);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void H(final com.stepos.ailauncher.agent.ability.VoiceAbilityService r18, final com.stepos.ailauncher.mcpservice.risk.RiskStatementParams r19, final long r20, final reactor.core.publisher.MonoSink r22, final java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.ability.VoiceAbilityService.H(com.stepos.ailauncher.agent.ability.VoiceAbilityService, com.stepos.ailauncher.mcpservice.risk.p, long, reactor.core.publisher.MonoSink, java.lang.String):void");
    }

    public static final void I(VoiceAbilityService voiceAbilityService, RiskStatementParams riskStatementParams, long j10) {
        C4148a.u(voiceAbilityService.riskTag, "timeout: req=" + riskStatementParams.getRequestId() + ", waited=" + j10 + "ms, deliver Cancelled to bridge", false, 4, null);
        U5.b.INSTANCE.w(riskStatementParams.getRiskLevel(), false);
        com.stepos.ailauncher.mcpservice.risk.f.INSTANCE.d(riskStatementParams.getRequestId(), q.a.INSTANCE);
    }

    public static final void J(final VoiceAbilityService voiceAbilityService, final RiskStatementParams riskStatementParams, final long j10, final Runnable runnable, final String str) {
        voiceAbilityService.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.agent.ability.n
            @Override // java.lang.Runnable
            public final void run() {
                VoiceAbilityService.K(this.f23879a, riskStatementParams, j10, runnable, str);
            }
        });
    }

    public static final void K(VoiceAbilityService voiceAbilityService, RiskStatementParams riskStatementParams, long j10, Runnable runnable, String str) {
        Object objB;
        Y8.t tVar = null;
        C4148a.u(voiceAbilityService.riskTag, "tool cancelled by subscriber | req=" + riskStatementParams.getRequestId() + ", waited=" + j10 + "ms, clean up", false, 4, null);
        voiceAbilityService.mainHandler.removeCallbacks(runnable);
        ChatRoundUserDecisionHold chatRoundUserDecisionHold = ChatRoundUserDecisionHold.INSTANCE;
        if (H.x0(str)) {
            String sessionId = riskStatementParams.getSessionId();
            if (sessionId == null) {
                sessionId = "";
            }
            str = sessionId;
        }
        chatRoundUserDecisionHold.m(str, riskStatementParams.getRequestId(), "risk.onCancel");
        U5.b.INSTANCE.w(riskStatementParams.getRiskLevel(), false);
        String sessionId2 = riskStatementParams.getSessionId();
        if (sessionId2 != null) {
            String str2 = !H.x0(sessionId2) ? sessionId2 : null;
            if (str2 != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    IRiskLiveNotificationService iRiskLiveNotificationService = (IRiskLiveNotificationService) D5.a.INSTANCE.a(IRiskLiveNotificationService.class);
                    if (iRiskLiveNotificationService != null) {
                        IRiskLiveNotificationService.dismissSessionRiskCard$default(iRiskLiveNotificationService, str2, false, null, true, 6, null);
                        tVar = Y8.t.f7040a;
                    }
                    objB = Result.b(tVar);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Result.a(objB);
            }
        }
        com.stepos.ailauncher.mcpservice.risk.notification.a aVar = com.stepos.ailauncher.mcpservice.risk.notification.a.INSTANCE;
        Context applicationContext = voiceAbilityService.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        aVar.d(applicationContext, riskStatementParams.getRequestId());
        com.stepos.ailauncher.mcpservice.risk.o.INSTANCE.a(riskStatementParams.getRequestId());
        com.stepos.ailauncher.mcpservice.risk.f.INSTANCE.l(riskStatementParams.getRequestId());
    }

    public static final Y8.t L(VoiceAbilityService voiceAbilityService, Runnable runnable, String str, RiskStatementParams riskStatementParams, MonoSink monoSink, com.stepos.ailauncher.mcpservice.risk.q result) throws JSONException {
        String sessionId;
        Object objB;
        Y8.t tVar;
        IRiskLiveNotificationService iRiskLiveNotificationService;
        kotlin.jvm.internal.p.i(result, "result");
        voiceAbilityService.mainHandler.removeCallbacks(runnable);
        ChatRoundUserDecisionHold chatRoundUserDecisionHold = ChatRoundUserDecisionHold.INSTANCE;
        if (H.x0(str)) {
            sessionId = riskStatementParams.getSessionId();
            if (sessionId == null) {
                sessionId = "";
            }
        } else {
            sessionId = str;
        }
        chatRoundUserDecisionHold.m(sessionId, riskStatementParams.getRequestId(), "risk.onResult");
        String sessionId2 = riskStatementParams.getSessionId();
        if (sessionId2 != null) {
            String str2 = !H.x0(sessionId2) ? sessionId2 : null;
            if (str2 != null) {
                boolean z10 = (riskStatementParams.i() || (iRiskLiveNotificationService = (IRiskLiveNotificationService) D5.a.INSTANCE.a(IRiskLiveNotificationService.class)) == null || !iRiskLiveNotificationService.sessionTasksAllTerminal(str2)) ? false : true;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    IRiskLiveNotificationService iRiskLiveNotificationService2 = (IRiskLiveNotificationService) D5.a.INSTANCE.a(IRiskLiveNotificationService.class);
                    if (iRiskLiveNotificationService2 != null) {
                        IRiskLiveNotificationService.dismissSessionRiskCard$default(iRiskLiveNotificationService2, str2, false, riskStatementParams.getRequestId(), z10, 2, null);
                        tVar = Y8.t.f7040a;
                    } else {
                        tVar = null;
                    }
                    objB = Result.b(tVar);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.t(voiceAbilityService.riskTag, "dismiss session risk card failed | req=" + riskStatementParams.getRequestId(), thE, false, 8, null);
                }
                Result.a(objB);
            }
        }
        com.stepos.ailauncher.mcpservice.risk.notification.a aVar = com.stepos.ailauncher.mcpservice.risk.notification.a.INSTANCE;
        Context applicationContext = voiceAbilityService.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        aVar.d(applicationContext, riskStatementParams.getRequestId());
        McpSchema.CallToolResult callToolResultT = voiceAbilityService.t(riskStatementParams, result);
        List<McpSchema.Content> listContent = callToolResultT.content();
        kotlin.jvm.internal.p.h(listContent, "content(...)");
        String strA0 = F.A0(listContent, null, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.ability.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return VoiceAbilityService.M((McpSchema.Content) obj);
            }
        }, 31, null);
        C4148a.k(voiceAbilityService.riskTag, "user result=" + result + " for req=" + riskStatementParams.getRequestId() + " | <<< out: isError=" + callToolResultT.isError() + ", content=[" + strA0 + "]", false, 4, null);
        U5.b bVar = U5.b.INSTANCE;
        bVar.w(riskStatementParams.getRiskLevel(), false);
        if (result instanceof q.Chosen) {
            bVar.t(riskStatementParams.getRiskLevel(), ((q.Chosen) result).getButtonId());
        }
        voiceAbilityService.W(riskStatementParams, result);
        monoSink.success(callToolResultT);
        return Y8.t.f7040a;
    }

    public static final CharSequence M(McpSchema.Content content) {
        String strText;
        McpSchema.TextContent textContent = content instanceof McpSchema.TextContent ? (McpSchema.TextContent) content : null;
        return (textContent == null || (strText = textContent.text()) == null) ? content.toString() : strText;
    }

    public static final Mono N(VoiceAbilityService voiceAbilityService, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
        return voiceAbilityService.C(callToolRequest);
    }

    public static final Mono O(VoiceAbilityService voiceAbilityService, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
        kotlin.jvm.internal.p.f(callToolRequest);
        return voiceAbilityService.D(callToolRequest);
    }

    public static final Mono P(VoiceAbilityService voiceAbilityService, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
        return voiceAbilityService.F(callToolRequest);
    }

    public static final Mono Q(VoiceAbilityService voiceAbilityService, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
        kotlin.jvm.internal.p.f(callToolRequest);
        return voiceAbilityService.E(callToolRequest);
    }

    public static final CharSequence V(McpSchema.Content content) {
        McpSchema.TextContent textContent = content instanceof McpSchema.TextContent ? (McpSchema.TextContent) content : null;
        String strText = textContent != null ? textContent.text() : null;
        return strText == null ? "" : strText;
    }

    public static final void Z(N5.d dVar, CardEnvelope cardEnvelope, N5.n nVar) {
        dVar.h(cardEnvelope, nVar);
    }

    public static final Gson v() {
        return new Gson();
    }

    public final String A(Object... values) {
        String string;
        int length = values.length;
        int i10 = 0;
        while (true) {
            String string2 = null;
            if (i10 >= length) {
                return null;
            }
            Object obj = values[i10];
            if (obj != null && (string = obj.toString()) != null) {
                string2 = H.D1(string).toString();
            }
            if (string2 == null) {
                string2 = "";
            }
            if (!H.x0(string2)) {
                return string2;
            }
            i10++;
        }
    }

    public final Gson B() {
        return (Gson) this.envelopeGson.getValue();
    }

    public final Mono<McpSchema.CallToolResult> C(McpSchema.CallToolRequest request) {
        Map<String, Object> mapArguments;
        Object obj;
        String string = (request == null || (mapArguments = request.arguments()) == null || (obj = mapArguments.get(PARAM_VOICE_ID)) == null) ? null : obj.toString();
        C4148a.d(TAG, "change_voice_id called, voiceId=" + string, false, 4, null);
        if (string == null || H.x0(string)) {
            return Mono.just(McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent("参数 voice_id 不能为空"))).isError(Boolean.TRUE).build());
        }
        if (!SUPPORTED_VOICE_IDS.contains(string)) {
            C4148a.u(TAG, "unsupported voiceId=" + string, false, 4, null);
            return Mono.just(McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent("暂不支持此音色"))).isError(Boolean.TRUE).build());
        }
        C5009a.INSTANCE.F("tts_voice_id", string, false);
        C4148a.d(TAG, "voice switched to " + string, false, 4, null);
        return Mono.just(McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent("音色已切换，快来试试吧"))).isError(Boolean.FALSE).build());
    }

    public final Mono<McpSchema.CallToolResult> D(McpSchema.CallToolRequest request) {
        C4148a.d(TAG, "get_voice_list called", false, 4, null);
        Mono<McpSchema.CallToolResult> monoJust = Mono.just(McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent("当前支持的说话声音音色有：\n\n## 支持的音色(voice_id)和描述\n-livelybreezy-female: 活力轻快女声，阳光感染力强，适合营销推广场景。\n-zhengpaiqingnian: 正派青年男声，阳光正气专业，传递信任感和说服力。\n-shuangkuainansheng: 爽快男声，干脆有力，适合电话客服和业务催收。\n-ganliannvsheng: 干练女声，专业果断清晰，适合高效处理业务场景。\n-qinhenvsheng: 亲和女声，温暖亲切耐心，能有效安抚用户情绪。\n-huolinvsheng: 活力女声，热情饱满积极，提升客服互动体验。\n-elegantgentle-female: 气质温婉女声，优雅柔和沉着，适合正式服务场景。\n-wenrounansheng: 温柔男声，柔和细腻关怀，舒适度高适合陪伴类场景。\n-jingdiannvsheng: 经典女声，沉稳大气标准，广泛适用多种通用场景。\n-wenroushunv: 温柔熟女，成熟温柔包容，易建立用户信任感。\n-tianmeinvsheng: 甜美女声，清甜可人亲近，提升品牌亲和力。\n-qingchunshaonv: 清纯少女，清新灵动青春，富有朝气和亲近感。\n-yuanqinansheng: 元气男声，朝气蓬勃正能量，适合年轻化互动场景。\n-cixingnansheng: 慈兴男声，沉稳有韵律感，适合叙述朗读类场景。\n-xingjiejie: 星姐姐，亲切自然流畅，适合视频配音口播和语音助手"))).isError(Boolean.FALSE).build());
        kotlin.jvm.internal.p.h(monoJust, "just(...)");
        return monoJust;
    }

    public final Mono<McpSchema.CallToolResult> E(McpSchema.CallToolRequest request) {
        String string;
        String string2;
        Map<String, Object> mapArguments = request.arguments();
        if (mapArguments == null) {
            mapArguments = kotlin.collections.a.i();
        }
        C4148a.k(TAG, "handleLoadTripartiteCommonCard: " + mapArguments, false, 4, null);
        Object obj = mapArguments.get("templateType");
        if (obj == null || (string = obj.toString()) == null) {
            Mono<McpSchema.CallToolResult> monoJust = Mono.just(McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent("Params Error: templateType"))).isError(Boolean.TRUE).build());
            kotlin.jvm.internal.p.h(monoJust, "just(...)");
            return monoJust;
        }
        Object obj2 = mapArguments.get("taskId");
        if (obj2 == null || (string2 = obj2.toString()) == null) {
            Mono<McpSchema.CallToolResult> monoJust2 = Mono.just(McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent("Params Error: taskId"))).isError(Boolean.TRUE).build());
            kotlin.jvm.internal.p.h(monoJust2, "just(...)");
            return monoJust2;
        }
        R5.b bVar = R5.b.INSTANCE;
        bVar.f(string2);
        bVar.c("svc.enter", Y8.j.a("taskId", string2), Y8.j.a("templateType", string), Y8.j.a("bizChannel", mapArguments.get("bizChannel")), Y8.j.a("argsKeys", Integer.valueOf(mapArguments.keySet().size())));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : ENVELOPE_KEYS) {
            if (mapArguments.containsKey(str)) {
                linkedHashMap.put(str, mapArguments.get(str));
            }
        }
        N5.d dVarA = z.INSTANCE.a(string2);
        if (dVarA != null) {
            R5.b.INSTANCE.c("svc.refresh", Y8.j.a("taskId", string2), Y8.j.a("templateType", string));
            return Y(string, string2, linkedHashMap, dVarA);
        }
        R5.b bVar2 = R5.b.INSTANCE;
        bVar2.c("svc.create", Y8.j.a("taskId", string2), Y8.j.a("templateType", string));
        String packageName = getPackageName();
        kotlin.jvm.internal.p.h(packageName, "getPackageName(...)");
        AppUI appUI = new AppUI(AppUI.TYPE_CUSTOM, packageName, TripartiteAppUiCoercion.CARD_CENTER_ALIAS, "", "", false);
        AbilityResult abilityResultA = AbilityResult.INSTANCE.a(TOOL_LOAD_TRIPARTITE_COMMON_CARD, "加载三方通用卡片[" + string + "]", appUI, linkedHashMap);
        C4148a.j(TAG, "structuredContent: " + abilityResultA.getCustomData() + ", result：" + abilityResultA.c() + ", meta：" + abilityResultA.b(), true);
        Long lG = bVar2.g(string2);
        bVar2.c("svc.return", Y8.j.a("taskId", string2), Y8.j.a("templateType", string), Y8.j.a("path", "create"), Y8.j.a("elapsedMs", lG));
        R5.a.INSTANCE.d(string2, "create", lG);
        List listE = C1172u.e(new McpSchema.TextContent((String) abilityResultA.c()));
        Boolean bool = Boolean.FALSE;
        Object customData = abilityResultA.getCustomData();
        Map<String, Object> mapB = abilityResultA.b();
        if (mapB == null) {
            mapB = new D(kotlin.collections.a.i());
        }
        Mono<McpSchema.CallToolResult> monoJust3 = Mono.just(new McpSchema.CallToolResult(listE, bool, customData, mapB));
        kotlin.jvm.internal.p.h(monoJust3, "let(...)");
        return monoJust3;
    }

    public final Mono<McpSchema.CallToolResult> F(McpSchema.CallToolRequest request) throws JSONException {
        String string;
        IRiskLiveNotificationService iRiskLiveNotificationService;
        Map<String, Object> mapArguments = request != null ? request.arguments() : null;
        if (mapArguments == null) {
            mapArguments = kotlin.collections.a.i();
        }
        final String strX = x(request, mapArguments);
        String strZ = z(request, mapArguments);
        Map<String, Object> mapMeta = request != null ? request.meta() : null;
        if (mapMeta == null) {
            mapMeta = kotlin.collections.a.i();
        }
        long jY = y(request, mapArguments);
        Map<String, Object> map = mapMeta;
        C4148a.k(this.riskTag, ">>> in: tool=assistant_show_risk_statement, sessionId='" + strX + "', toolCallId='" + strZ + "', metaKeys=" + mapMeta.keySet() + ", timeoutMs=" + jY + ", argLevel='" + b0(mapArguments, ARG_LEVEL) + "', argTitle='" + b0(mapArguments, "title") + "', argDescription='" + b0(mapArguments, ARG_DESCRIPTION) + "', argTags=" + mapArguments.get(ARG_TAGS), false, 4, null);
        String strB0 = b0(mapArguments, "title");
        String strB02 = b0(mapArguments, ARG_DESCRIPTION);
        if (H.x0(strB0) || H.x0(strB02)) {
            C4148a.u(this.riskTag, "reject: 参数 title / description 不能为空 | titleBlank=" + H.x0(strB0) + ", descBlank=" + H.x0(strB02) + " | <<< out: isError=true, content=[参数 title / description 不能为空]", false, 4, null);
            return w("参数 title / description 不能为空");
        }
        List<RiskStatementButton> listE = com.stepos.ailauncher.mcpservice.risk.notification.b.e(X(mapArguments.get(ARG_TAGS)));
        int size = listE.size();
        if (2 > size || size >= 4) {
            String str = "tags 数量必须为 2 或 3，实际：" + listE.size();
            String str2 = this.riskTag;
            List<RiskStatementButton> list = listE;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((RiskStatementButton) it.next()).getId());
            }
            C4148a.u(str2, "reject: " + str + " | parsedButtons=" + arrayList + " | <<< out: isError=true, content=[" + str + "]", false, 4, null);
            return w(str);
        }
        String strB03 = b0(mapArguments, "scene");
        if (H.x0(strB03)) {
            strB03 = null;
        }
        if (strB03 != null && !kotlin.jvm.internal.p.d(strB03, RiskStatementParams.SCENE_UNLOCK)) {
            C4148a.u(TAG, "risk validation failed | reason=unsupported scene, scene=" + strB03, false, 4, null);
            return w("参数 scene 不支持: " + strB03);
        }
        if (H.x0(strZ)) {
            string = UUID.randomUUID().toString();
            kotlin.jvm.internal.p.h(string, "toString(...)");
        } else {
            string = strZ;
        }
        if (H.x0(strZ)) {
            C4148a.u(this.riskTag, "tool_call_id missing in _meta, fallback UUID req=" + string + " metaKeys=" + map.keySet(), false, 4, null);
        } else {
            C4148a.k(this.riskTag, "popup id from TOOL_CALL_ID | req=" + string, false, 4, null);
        }
        String strB04 = b0(mapArguments, ARG_LEVEL);
        if (H.x0(strB04)) {
            strB04 = "medium";
        }
        final RiskStatementParams riskStatementParams = new RiskStatementParams(string, strB04, strB0, strB02, listE, strB03, H.x0(strX) ? null : strX, Long.valueOf(jY));
        String str3 = this.riskTag;
        String requestId = riskStatementParams.getRequestId();
        String riskLevel = riskStatementParams.getRiskLevel();
        String title = riskStatementParams.getTitle();
        String body = riskStatementParams.getBody();
        String sessionId = riskStatementParams.getSessionId();
        Long timeoutMs = riskStatementParams.getTimeoutMs();
        List<RiskStatementButton> listB = riskStatementParams.b();
        ArrayList arrayList2 = new ArrayList(C1174w.x(listB, 10));
        for (RiskStatementButton riskStatementButton : listB) {
            arrayList2.add(riskStatementButton.getId() + "(" + riskStatementButton.getStyle() + ")");
            jY = jY;
        }
        final long j10 = jY;
        C4148a.k(str3, "params built: req=" + requestId + ", level=" + riskLevel + ", title='" + title + "', body='" + body + "', sessionId='" + sessionId + "', timeoutMs=" + timeoutMs + ", buttons=" + arrayList2, false, 4, null);
        if (riskStatementParams.i()) {
            T("unlock scene device check");
        }
        if (riskStatementParams.i()) {
            com.stepos.ailauncher.mcpservice.risk.a aVar = com.stepos.ailauncher.mcpservice.risk.a.INSTANCE;
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            if (aVar.e(applicationContext)) {
                C4148a.k(this.riskTag, "unlock scene shortcut | req=" + riskStatementParams.getRequestId() + ", skip UI because device unlocked and screen on", false, 4, null);
                McpSchema.CallToolResult callToolResultT = t(riskStatementParams, new q.Unlock(UnlockSceneResult.ALREADY_UNLOCKED));
                U(riskStatementParams.getRequestId(), "shortcut_already_unlocked", callToolResultT);
                Mono<McpSchema.CallToolResult> monoJust = Mono.just(callToolResultT);
                kotlin.jvm.internal.p.h(monoJust, "just(...)");
                return monoJust;
            }
        }
        if (riskStatementParams.i() || H.x0(strX) || (iRiskLiveNotificationService = (IRiskLiveNotificationService) D5.a.INSTANCE.a(IRiskLiveNotificationService.class)) == null || !iRiskLiveNotificationService.sessionTasksAllTerminal(strX) || SessionActivityTracker.INSTANCE.g(strX)) {
            Mono<McpSchema.CallToolResult> monoCreate = Mono.create(new Consumer() { // from class: com.stepos.ailauncher.agent.ability.s
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    VoiceAbilityService.G(riskStatementParams, this, j10, strX, (MonoSink) obj);
                }
            });
            kotlin.jvm.internal.p.h(monoCreate, "create(...)");
            return monoCreate;
        }
        C4148a.k(this.riskTag, "skip UI: session tasks already terminal | req=" + riskStatementParams.getRequestId() + ", sessionId='" + strX + "'", false, 4, null);
        McpSchema.CallToolResult callToolResultT2 = t(riskStatementParams, q.a.INSTANCE);
        U(riskStatementParams.getRequestId(), "session_tasks_terminal", callToolResultT2);
        Mono<McpSchema.CallToolResult> monoJust2 = Mono.just(callToolResultT2);
        kotlin.jvm.internal.p.h(monoJust2, "just(...)");
        return monoJust2;
    }

    public final boolean R() {
        C3202f c3202f = C3202f.INSTANCE;
        String strD = c3202f.d();
        return strD != null && c3202f.e() && La.D.X(strD, CHAT_PACKAGE_PREFIX, false, 2, null);
    }

    public final boolean S(String sessionId) {
        String strM = ConversationSessionIds.INSTANCE.m(sessionId);
        com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
        if (vVar.p(sessionId) || vVar.p(strM)) {
            return true;
        }
        InputViewManager inputViewManager = InputViewManager.INSTANCE;
        return inputViewManager.L0(sessionId) || inputViewManager.L0(strM);
    }

    public final void T(String label) {
        com.stepos.ailauncher.mcpservice.risk.a aVar = com.stepos.ailauncher.mcpservice.risk.a.INSTANCE;
        Context applicationContext = getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        aVar.f(applicationContext, label);
    }

    public final void U(String requestId, String phase, McpSchema.CallToolResult toolResult) {
        List<McpSchema.Content> listContent = toolResult.content();
        String strA0 = listContent != null ? F.A0(listContent, " | ", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.ability.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return VoiceAbilityService.V((McpSchema.Content) obj);
            }
        }, 30, null) : null;
        if (strA0 == null) {
            strA0 = "";
        }
        C4148a.k(TAG, "risk toolcall response | phase=" + phase + ", requestId=" + requestId + ", isError=" + toolResult.isError() + ", content=" + strA0, false, 4, null);
    }

    public final void W(RiskStatementParams params, com.stepos.ailauncher.mcpservice.risk.q result) {
        UnlockSceneResult result2;
        if (params.i() && LockScreenChatActivity.INSTANCE.b()) {
            q.Unlock unlock = result instanceof q.Unlock ? (q.Unlock) result : null;
            if (unlock == null || (result2 = unlock.getResult()) == null) {
                return;
            }
            int i10 = b.$EnumSwitchMapping$0[result2.ordinal()];
            if (i10 == 1 || i10 == 2) {
                C4148a.k(this.riskTag, "risk unlock completed on lock screen chat -> handoff | req=" + params.getRequestId() + ", unlockResult=" + result2, false, 4, null);
                x xVar = x.INSTANCE;
                Context applicationContext = getApplicationContext();
                kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
                xVar.h(applicationContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.stepos.ailauncher.mcpservice.risk.RiskStatementButton> X(java.lang.Object r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof java.util.List
            r1 = 0
            if (r0 == 0) goto L8
            java.util.List r5 = (java.util.List) r5
            goto L9
        L8:
            r5 = r1
        L9:
            if (r5 != 0) goto L10
            java.util.List r4 = Z8.C1173v.m()
            return r4
        L10:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L1b:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L5e
            java.lang.Object r2 = r5.next()
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L2c
            java.lang.String r2 = (java.lang.String) r2
            goto L2d
        L2c:
            r2 = r1
        L2d:
            if (r2 == 0) goto L57
            java.lang.CharSequence r2 = La.H.D1(r2)
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L57
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r2 = r2.toLowerCase(r3)
            java.lang.String r3 = "toLowerCase(...)"
            kotlin.jvm.internal.p.h(r2, r3)
            if (r2 == 0) goto L57
            boolean r3 = La.H.x0(r2)
            if (r3 != 0) goto L4e
            goto L4f
        L4e:
            r2 = r1
        L4f:
            if (r2 != 0) goto L52
            goto L57
        L52:
            com.stepos.ailauncher.mcpservice.risk.RiskStatementButton r2 = r4.c0(r2)
            goto L58
        L57:
            r2 = r1
        L58:
            if (r2 == 0) goto L1b
            r0.add(r2)
            goto L1b
        L5e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.ability.VoiceAbilityService.X(java.lang.Object):java.util.List");
    }

    public final Mono<McpSchema.CallToolResult> Y(String templateType, String taskId, Map<String, ? extends Object> customData, final N5.d existing) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((CardEnvelope) B().fromJson(B().toJsonTree(customData), CardEnvelope.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "refresh card parse envelope failed, taskId=" + taskId, thE, false, 8, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        final CardEnvelope cardEnvelope = (CardEnvelope) objB;
        if (cardEnvelope == null) {
            Mono<McpSchema.CallToolResult> monoJust = Mono.just(McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent("Params Error: envelope"))).isError(Boolean.TRUE).build());
            kotlin.jvm.internal.p.h(monoJust, "just(...)");
            return monoJust;
        }
        N5.v vVarB = N5.g.INSTANCE.b(cardEnvelope.getTemplateType());
        final N5.n nVarB = vVarB != null ? vVarB.b(cardEnvelope) : null;
        this.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.agent.ability.t
            @Override // java.lang.Runnable
            public final void run() {
                VoiceAbilityService.Z(existing, cardEnvelope, nVarB);
            }
        });
        C4148a.k(TAG, "refresh tripartite card: taskId=" + taskId + ", templateType=" + templateType, false, 4, null);
        R5.b bVar = R5.b.INSTANCE;
        Long lG = bVar.g(taskId);
        bVar.c("svc.return", Y8.j.a("taskId", taskId), Y8.j.a("templateType", templateType), Y8.j.a("path", com.stepos.ailauncher.chat.trace.g.ACTION_REFRESH), Y8.j.a("elapsedMs", lG));
        R5.a.INSTANCE.d(taskId, com.stepos.ailauncher.chat.trace.g.ACTION_REFRESH, lG);
        Mono<McpSchema.CallToolResult> monoJust2 = Mono.just(McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent("已更新三方卡片[" + templateType + "]"))).isError(Boolean.FALSE).build());
        kotlin.jvm.internal.p.h(monoJust2, "just(...)");
        return monoJust2;
    }

    public final boolean a0(RiskStatementParams params) {
        if (!params.i()) {
            com.stepos.ailauncher.mcpservice.risk.a aVar = com.stepos.ailauncher.mcpservice.risk.a.INSTANCE;
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            if (aVar.c(applicationContext)) {
                return false;
            }
        }
        if (params.i()) {
            return true;
        }
        String sessionId = params.getSessionId();
        if (sessionId != null) {
            if (H.x0(sessionId)) {
                sessionId = null;
            }
            if (sessionId != null && S(sessionId)) {
                return R() || E.INSTANCE.f() || y.INSTANCE.d();
            }
            return false;
        }
        return false;
    }

    public final String b0(Map<String, ? extends Object> map, String str) {
        Object obj = map.get(str);
        String str2 = obj instanceof String ? (String) obj : null;
        String string = str2 != null ? H.D1(str2).toString() : null;
        return string == null ? "" : string;
    }

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService
    public void c() {
        this.mcpServer.c(TOOL_CHANGE_VOICE_ID, new BiFunction() { // from class: com.stepos.ailauncher.agent.ability.j
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return VoiceAbilityService.N(this.f23868a, (McpAsyncServerExchange) obj, (McpSchema.CallToolRequest) obj2);
            }
        });
        this.mcpServer.c(TOOL_GET_VOICE_LIST, new BiFunction() { // from class: com.stepos.ailauncher.agent.ability.o
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return VoiceAbilityService.O(this.f23884a, (McpAsyncServerExchange) obj, (McpSchema.CallToolRequest) obj2);
            }
        });
        this.mcpServer.c(TOOL_SHOW_RISK_STATEMENT, new BiFunction() { // from class: com.stepos.ailauncher.agent.ability.p
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return VoiceAbilityService.P(this.f23885a, (McpAsyncServerExchange) obj, (McpSchema.CallToolRequest) obj2);
            }
        });
        this.mcpServer.c(TOOL_LOAD_TRIPARTITE_COMMON_CARD, new BiFunction() { // from class: com.stepos.ailauncher.agent.ability.q
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return VoiceAbilityService.Q(this.f23886a, (McpAsyncServerExchange) obj, (McpSchema.CallToolRequest) obj2);
            }
        });
    }

    public final RiskStatementButton c0(String tag) {
        int iHashCode = tag.hashCode();
        if (iHashCode == -1341859401) {
            if (!tag.equals(TAG_ALLOW_ONCE)) {
                return null;
            }
            String string = getApplicationContext().getString(R$string.perm_allow_once_agent);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return new RiskStatementButton(TAG_ALLOW_ONCE, string, null, RiskStatementButton.Style.NORMAL, 4, null);
        }
        if (iHashCode == -934710369) {
            if (!tag.equals(TAG_REJECT)) {
                return null;
            }
            String string2 = getApplicationContext().getString(R$string.perm_deny_agent);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            return new RiskStatementButton(TAG_REJECT, string2, null, RiskStatementButton.Style.REJECT, 4, null);
        }
        if (iHashCode != -77754087 || !tag.equals(TAG_ALWAYS_ALLOW)) {
            return null;
        }
        String string3 = getApplicationContext().getString(R$string.perm_allow_always_agent);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        return new RiskStatementButton(TAG_ALWAYS_ALLOW, string3, null, RiskStatementButton.Style.EMPHASIS, 4, null);
    }

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService, android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinderOnBind = super.onBind(intent);
        if (iBinderOnBind == null) {
            return null;
        }
        return C5.a.c(this, TAG, iBinderOnBind, null, 8, null);
    }

    public final McpSchema.CallToolResult t(RiskStatementParams params, com.stepos.ailauncher.mcpservice.risk.q result) throws JSONException {
        if (params.i()) {
            return u(result);
        }
        if (result instanceof q.Chosen) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("trace_id", params.getRequestId());
            String upperCase = ((q.Chosen) result).getButtonId().toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
            jSONObject.put("choice", upperCase);
            jSONObject.put("title", params.getTitle());
            jSONObject.put(ARG_LEVEL, params.getRiskLevel());
            if (!H.x0(params.getBody())) {
                jSONObject.put(ARG_DESCRIPTION, params.getBody());
            }
            String string = jSONObject.toString();
            kotlin.jvm.internal.p.h(string, "toString(...)");
            McpSchema.CallToolResult callToolResultBuild = McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent(string))).isError(Boolean.FALSE).build();
            kotlin.jvm.internal.p.f(callToolResultBuild);
            return callToolResultBuild;
        }
        if (!kotlin.jvm.internal.p.d(result, q.a.INSTANCE)) {
            if (!(result instanceof q.Unlock)) {
                throw new NoWhenBranchMatchedException();
            }
            McpSchema.CallToolResult callToolResultBuild2 = McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent("unexpected unlock result in default scene"))).isError(Boolean.TRUE).build();
            kotlin.jvm.internal.p.h(callToolResultBuild2, "build(...)");
            return callToolResultBuild2;
        }
        McpSchema.CallToolResult callToolResultBuild3 = McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent("user cancelled risk statement: " + params.getRequestId()))).isError(Boolean.TRUE).build();
        kotlin.jvm.internal.p.h(callToolResultBuild3, "build(...)");
        return callToolResultBuild3;
    }

    public final McpSchema.CallToolResult u(com.stepos.ailauncher.mcpservice.risk.q result) throws JSONException {
        UnlockSceneResult result2;
        if (result instanceof q.Unlock) {
            result2 = ((q.Unlock) result).getResult();
        } else if (kotlin.jvm.internal.p.d(result, q.a.INSTANCE)) {
            result2 = UnlockSceneResult.CANCELLED;
        } else {
            if (!(result instanceof q.Chosen)) {
                throw new NoWhenBranchMatchedException();
            }
            result2 = UnlockSceneResult.SUCCESS;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("scene", RiskStatementParams.SCENE_UNLOCK);
        jSONObject.put("result", result2.toJsonValue());
        String string = jSONObject.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        McpSchema.CallToolResult callToolResultBuild = McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent(string))).isError(Boolean.valueOf((result2 == UnlockSceneResult.SUCCESS || result2 == UnlockSceneResult.ALREADY_UNLOCKED) ? false : true)).build();
        kotlin.jvm.internal.p.h(callToolResultBuild, "build(...)");
        return callToolResultBuild;
    }

    public final Mono<McpSchema.CallToolResult> w(String message) {
        C4148a.u(TAG, "risk error response | message=" + message, false, 4, null);
        Mono<McpSchema.CallToolResult> monoJust = Mono.just(McpSchema.CallToolResult.builder().content(C1172u.e(new McpSchema.TextContent(message))).isError(Boolean.TRUE).build());
        kotlin.jvm.internal.p.h(monoJust, "just(...)");
        return monoJust;
    }

    public final String x(McpSchema.CallToolRequest request, Map<String, ? extends Object> args) {
        Map<String, Object> mapMeta = request != null ? request.meta() : null;
        if (mapMeta == null) {
            mapMeta = kotlin.collections.a.i();
        }
        String strA = A(mapMeta.get("SESSION_ID"), mapMeta.get("session_id"), mapMeta.get("sessionId"), args.get("SESSION_ID"), args.get("session_id"), args.get("sessionId"));
        return strA != null ? strA : "";
    }

    public final long y(McpSchema.CallToolRequest request, Map<String, ? extends Object> args) {
        Map<String, Object> mapMeta = request != null ? request.meta() : null;
        if (mapMeta == null) {
            mapMeta = kotlin.collections.a.i();
        }
        Object obj = mapMeta.get(META_TIMEOUT_MS_UPPER);
        if (obj == null) {
            Object obj2 = mapMeta.get(META_TIMEOUT_MS_SNAKE);
            if (obj2 == null) {
                Object obj3 = mapMeta.get(META_TIMEOUT_MS_CAMEL);
                if (obj3 == null && (obj3 = args.get(META_TIMEOUT_MS_UPPER)) == null) {
                    obj = args.get(META_TIMEOUT_MS_SNAKE);
                    if (obj == null) {
                        obj = args.get(META_TIMEOUT_MS_CAMEL);
                    }
                } else {
                    obj = obj3;
                }
            } else {
                obj = obj2;
            }
        }
        Long lValueOf = obj instanceof Number ? Long.valueOf(((Number) obj).longValue()) : obj instanceof String ? C.y(H.D1((String) obj).toString()) : null;
        if (lValueOf == null || lValueOf.longValue() <= 0) {
            return 600000L;
        }
        long jO = C5685n.o(lValueOf.longValue(), 30000L, 1800000L);
        if (jO != lValueOf.longValue()) {
            C4148a.u(this.riskTag, "timeoutMs out of range, clamped | raw=" + lValueOf + " -> " + jO + " (allowed 30000..1800000)", false, 4, null);
        }
        return jO;
    }

    public final String z(McpSchema.CallToolRequest request, Map<String, ? extends Object> args) {
        Map<String, Object> mapMeta = request != null ? request.meta() : null;
        if (mapMeta == null) {
            mapMeta = kotlin.collections.a.i();
        }
        String strA = A(mapMeta.get(META_TOOL_CALL_ID_UPPER), mapMeta.get(META_TOOL_CALL_ID_SNAKE), mapMeta.get(META_TOOL_CALL_ID_CAMEL), args.get(META_TOOL_CALL_ID_UPPER), args.get(META_TOOL_CALL_ID_SNAKE), args.get(META_TOOL_CALL_ID_CAMEL));
        return strA != null ? strA : "";
    }
}
