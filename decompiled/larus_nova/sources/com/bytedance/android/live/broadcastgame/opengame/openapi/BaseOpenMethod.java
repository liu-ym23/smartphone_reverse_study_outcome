package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.broadcastgame.opengame.network.model.OpenPlatformRespExtra;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.livesdk.config.vd0;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Queue;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public abstract class BaseOpenMethod<P> extends com.bytedance.ies.web.jsbridge2.f<P, JSONObject> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f60302g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f60303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f60304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f60305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PluginContext f60306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Queue<Long> f60307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i20.a f60308f;

    public static final class a {
    }

    public abstract void call(P r100, CallContext r101);

    public abstract String getMethodName();

    public final void j(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        this.f60308f.a(r100);
    }

    public void l() {
        this.f60308f.b();
    }

    static {
        f60302g = OpenApiErrorInfo.INCORRECT_PARAMS.getErrorCode();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        this.f60304b = false;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        l();
    }

    public final synchronized boolean k(String r110) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, com.alipay.sdk.m.p.e.f25671s);     // Catch: Throwable -> L39
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L6;
    L9:
        p r100 = ((BootInfoService) this.f60306d.o(BootInfoService.class)).d(r110);     // Catch: Throwable -> L39
        if (r100 != null) goto L14;
        OpenApiErrorInfo r111 = OpenApiErrorInfo.NO_REQUEST_PERMISSION;     // Catch: Throwable -> L39
        n(r111, null);     // Catch: Throwable -> L39
        ((OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class)).i(getMethodName(), 1, Integer.valueOf(r111.getErrorCode()), "没有调用权限");     // Catch: Throwable -> L39
        monitor-exit(this);
        return false;
    L14:
        int r101 = r100.f60530a;     // Catch: Throwable -> L39
        int r102 = r100.f60531b;     // Catch: Throwable -> L39
        if (this.f60303a.contains(r110) == true) goto L37;
        if (r102 == 0) goto L37;
        if (this.f60307e == null) goto L37;
        if (r101 != 0) goto L24;
        OpenPlatformMonitorService r112 = (OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class);     // Catch: Throwable -> L39
        String r103 = getMethodName();     // Catch: Throwable -> L39
        OpenApiErrorInfo r104 = OpenApiErrorInfo.NO_REQUEST_PERMISSION;     // Catch: Throwable -> L39
        r112.i(r103, 1, Integer.valueOf(r104.getErrorCode()), "没有调用权限");     // Catch: Throwable -> L39
        n(r104, null);     // Catch: Throwable -> L39
        monitor-exit(this);
        return false;
    L24:
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L39
        if (this.f60307e.size() >= r101) goto L30;
        this.f60307e.offer(Long.valueOf(r105));     // Catch: Throwable -> L39
        monitor-exit(this);
        return true;
    L30:
        if ((r105 - this.f60307e.peek().longValue()) > (r102 * 1000)) goto L34;
        OpenPlatformMonitorService r113 = (OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class);     // Catch: Throwable -> L39
        String r106 = getMethodName();     // Catch: Throwable -> L39
        OpenApiErrorInfo r107 = OpenApiErrorInfo.EXCEED_FREQ_LIMIT;     // Catch: Throwable -> L39
        r113.i(r106, 1, Integer.valueOf(r107.getErrorCode()), "超出调用频率限制");     // Catch: Throwable -> L39
        n(r107, null);     // Catch: Throwable -> L39
        monitor-exit(this);
        return false;
    L34:
        this.f60307e.poll();     // Catch: Throwable -> L39
        this.f60307e.offer(Long.valueOf(r105));     // Catch: Throwable -> L39
        monitor-exit(this);
        return true;
    L37:
        monitor-exit(this);
        return true;
    L6:
        if (Intrinsics.areEqual(vd0.f121440a.getValue(), Boolean.FALSE) == false) goto L9;
        monitor-exit(this);
        return true;
    L39:
        th = move-exception;
        throw th;
    }

    public final void o(Throwable r100) {
        boolean r101 = false;
        if ((r100 instanceof CustomApiServerException) == false) goto L27;
        CustomApiServerException r102 = (CustomApiServerException) r100;
        Function2<Integer, String, Unit> r103 = new BaseOpenMethod$fail$1(this);
        Intrinsics.checkNotNullParameter(r102, "$this$getError");
        Intrinsics.checkNotNullParameter(r103, "action");
        String r104 = r102.getExtra();
        if (r104 != null) goto L7;
    L25:
        OpenApiErrorInfo r105 = OpenApiErrorInfo.INTERNAL_ERROR;
        r103.invoke(Integer.valueOf(r105.getErrorCode()), r105.getErrorMsg());
        return;
    L7:
        if (r104.length() <= 0) goto L9;
        r101 = true;
    L9:
        if (r101 != true) goto L25;
        JsonElement r106 = GsonHelper.parser().parse(r104);     // Catch: Exception -> L24
        if (r106 == null) goto L47;
        JsonObject r107 = r106.getAsJsonObject();     // Catch: Exception -> L24
        if (r107 == null) goto L48;
        OpenPlatformRespExtra r108 = (OpenPlatformRespExtra) GsonHelper.get().fromJson(r107, OpenPlatformRespExtra.class);     // Catch: Exception -> L24
        if (r108 == null) goto L17;
        int r109 = r108.errorCode;     // Catch: Exception -> L24
    L18:
        if (r108 == null) goto L21;
        String r110 = r108.errorMsg;     // Catch: Exception -> L24
        if (r110 == null) goto L21;
    L22:
        r103.invoke(Integer.valueOf(r109), r110);     // Catch: Exception -> L24
        return;
    L21:
        r110 = OpenApiErrorInfo.INTERNAL_ERROR.getErrorMsg();     // Catch: Exception -> L24
        goto L22
    L17:
        r109 = OpenApiErrorInfo.INTERNAL_ERROR.getErrorCode();     // Catch: Exception -> L24
        goto L18
    L48:
        return;
    L47:
        return;
    L24:
        OpenApiErrorInfo r111 = OpenApiErrorInfo.INTERNAL_ERROR;
        r103.invoke(Integer.valueOf(r111.getErrorCode()), r111.getErrorMsg());
        return;
    L27:
        if ((r100 instanceof NetworkErrorException) == false) goto L29;
    L43:
        n(OpenApiErrorInfo.NETWORK_ERROR, null);
        return;
    L29:
        if ((r100 instanceof SocketTimeoutException) == true) goto L43;
        OpenApiErrorInfo r112 = OpenApiErrorInfo.INTERNAL_ERROR;
        int r113 = r112.getErrorCode();
        if (r100 == null) goto L41;
        String r114 = r100.toString();
        if (r114 == null) goto L41;
        if (r114.length() != 0) goto L38;
        r101 = true;
    L38:
        if (r101 == false) goto L40;
        r114 = r112.getErrorMsg();
    L40:
        if (r114 == null) goto L41;
    L42:
        p(this, r113, r114, r100, 8);
        return;
    L41:
        r114 = r112.getErrorMsg();
        goto L42
    }

    public final void r(JSONObject r100) {
        OpenPlatformMonitorService r101 = (OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class);
        String r102 = getMethodName();
        Intrinsics.checkNotNullParameter(r102, com.alipay.sdk.m.p.e.f25671s);
        r101.o(r102, "ttlive_open_platform_openapi_execute", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, null, null).c();
        JSONObject r103 = new JSONObject();
        r103.put("errCode", 0);
        if (r100 != null) goto L5;
        finishWithResult(r103);
        return;
    L5:
        r100.put("errCode", 0);
        Unit r104 = Unit.INSTANCE;
        finishWithResult(r100);
    }

    public BaseOpenMethod(PluginContext r100, Queue<Long> r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        this.f60308f = new i20.a();
        this.f60306d = r100;
        this.f60307e = r101;
        this.f60303a = CollectionsKt.mutableListOf(new String[]{"log"});
        this.f60304b = true;
        this.f60305c = "";
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public void invoke(P r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        OpenPlatformMonitorService r102 = (OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class);
        String r103 = getMethodName();
        Intrinsics.checkNotNullParameter(r103, com.alipay.sdk.m.p.e.f25671s);
        OpenPlatformMonitorService.p(r102, r103, "ttlive_open_platform_openapi_call", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 56).c();
        if (k(getMethodName()) == false) goto L14;
        boolean r104 = false;
        ((OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class)).i(getMethodName(), 0, null, null);
        if (this.f60305c.length() != 0) goto L7;
        r104 = true;
    L7:
        if (r104 == false) goto L12;
        String r105 = r101.f249267b;
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        this.f60305c = r105;
    L12:
        call(r100, r101);
        return;
    }

    public final void n(OpenApiErrorInfo r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "errorInfo");
        p(this, r100.getErrorCode(), r100.getErrorMsg(), r101, 8);
    }

    public static void q(BaseOpenMethod r100, JSONObject r101, OpenApiErrorInfo r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "errorInfo");
        r100.m(r102.getErrorCode(), r102.getErrorMsg(), r101);
    }

    public final void m(int r110, String r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r111, "errMsg");
        switch(r110) {
            case 408: goto L25;
            case 10001: goto L24;
            case 10002: goto L24;
            case 10003: goto L23;
            case 10004: goto L22;
            case 10011: goto L21;
            case 10013: goto L20;
            case 20003: goto L19;
            case 20087: goto L18;
            case 40023: goto L17;
            case 40033: goto L16;
            case 41001: goto L15;
            case 90203: goto L14;
            case 90204: goto L14;
            case 90504: goto L13;
            case 4001010: goto L24;
            case 4001011: goto L24;
            case 4005024: goto L16;
            case 4008074: goto L12;
            case 4014016: goto L11;
            case 4014023: goto L10;
            case 4014031: goto L22;
            case 4014034: goto L9;
            case 4014035: goto L8;
            case 4014036: goto L7;
            case 4014038: goto L21;
            case 4014040: goto L22;
            case 4014044: goto L6;
            case 4014045: goto L16;
            case 4014047: goto L13;
            case 4014048: goto L13;
            case 4014052: goto L13;
            case 4019001: goto L5;
            default: goto L4;
        };
    L4:
        OpenApiErrorInfo r100 = null;
    L26:
        if (r100 == null) goto L28;
        int r101 = r100.getErrorCode();
        String r102 = r100.getErrorMsg();
    L29:
        boolean r103 = true;
        if (r112 != null) goto L38;
        JSONObject r113 = new JSONObject();
        r113.put("errCode", r101);
        if (r111.length() > 0) goto L35;
        r103 = false;
    L35:
        if (r103 == false) goto L37;
        r113.put("errMsg", r102);
    L37:
        Unit r104 = Unit.INSTANCE;
        finishWithResult(r113);
    L45:
        OpenPlatformMonitorService r105 = (OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class);
        String r106 = getMethodName();
        Integer r107 = Integer.valueOf(r110);
        Intrinsics.checkNotNullParameter(r106, com.alipay.sdk.m.p.e.f25671s);
        r105.o(r106, "ttlive_open_platform_openapi_execute", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 1, r107, r111).c();
        return;
    L38:
        r112.put("errCode", r101);
        if (r111.length() > 0) goto L42;
        r103 = false;
    L42:
        if (r103 == false) goto L44;
        r112.put("errMsg", r102);
    L44:
        Unit r108 = Unit.INSTANCE;
        finishWithResult(r112);
        goto L45
    L28:
        r101 = r110;
        r102 = r111;
        goto L29
    L5:
        r100 = OpenApiErrorInfo.LOGIN_OUT_DATE;
        goto L26
    L6:
        r100 = OpenApiErrorInfo.PAY_DIAMONDS_REACH_LIMIT;
        goto L26
    L7:
        r100 = OpenApiErrorInfo.INVALID_ACCESS_TOKEN;
        goto L26
    L8:
        r100 = OpenApiErrorInfo.SENSITIVE_WORD_DETECTED;
        goto L26
    L9:
        r100 = OpenApiErrorInfo.EXCEED_FREQ_LIMIT;
        goto L26
    L10:
        r100 = OpenApiErrorInfo.USER_NOT_IN_ROOM;
        goto L26
    L11:
        r100 = OpenApiErrorInfo.APP_NOT_LAUNCH;
        goto L26
    L12:
        r100 = OpenApiErrorInfo.REWARD_REACH_LIMIT;
        goto L26
    L13:
        r100 = OpenApiErrorInfo.INCORRECT_PARAMS;
        goto L26
    L14:
        r100 = OpenApiErrorInfo.NET_REQUEST_CONCURRENCY_EXCEED_LIMIT;
        goto L26
    L15:
        r100 = OpenApiErrorInfo.ACCOUNT_EXCEPTION;
        goto L26
    L16:
        r100 = OpenApiErrorInfo.DATA_ALREADY_EXIST;
        goto L26
    L17:
        r100 = OpenApiErrorInfo.NET_REQUEST_RESPONSE_INCOMPATIBLE;
        goto L26
    L18:
        r100 = OpenApiErrorInfo.ILLEGAL_APP_ID;
        goto L26
    L19:
        r100 = OpenApiErrorInfo.NOT_LOGIN;
        goto L26
    L20:
        r100 = OpenApiErrorInfo.INVALID_URL_PARAMS;
        goto L26
    L21:
        r100 = OpenApiErrorInfo.INCORRECT_PARAMS;
        goto L26
    L22:
        r100 = OpenApiErrorInfo.DATA_NOT_EXIST;
        goto L26
    L23:
        r100 = OpenApiErrorInfo.SIGNATURE_ERROR;
        goto L26
    L24:
        r100 = OpenApiErrorInfo.INTERNAL_ERROR;
        goto L26
    L25:
        r100 = OpenApiErrorInfo.NET_REQUEST_TIMEOUT;
        goto L26
    }

    public static /* synthetic */ void p(BaseOpenMethod r100, int r101, String r102, Throwable r103, int r104) {
        if ((r104 & 2) == 0) goto L5;
        r102 = "";
    L5:
        r100.m(r101, r102, null);
    }
}
