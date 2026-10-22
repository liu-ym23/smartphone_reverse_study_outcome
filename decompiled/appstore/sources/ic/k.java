package ic;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.article.common.network.SSNetworkClient;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.matrix.sdk.network.InterfaceRequestListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.apache.http.message.TokenParser;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f20573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f20574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static InterfaceRequestListener f20575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f20576d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final NetworkParams.MonitorProcessHook f20577e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final NetworkParams.ApiProcessHook f20578f = null;

    public static final class a implements NetworkParams.ApiProcessHook {
        public a() {
        }

        public void a(String r10, Throwable r11, long r12, p6.b r13) {
            q.g(r10, "url");
            q.g(r11, "e");
            q.g(r13, ServerElements.INFO);
            r11.printStackTrace();
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public String addCommonParams(String r10, boolean r11) {
            q.g(r10, "url");
            return r10;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public String addRequestVertifyParams(String r10, boolean r11, Object... r12) {
            q.g(r10, "url");
            q.g(r12, WsConstants.KEY_EXTRA);
            return r10;
        }

        public void b(String r10, long r11, p6.b r12) {
            q.g(r10, "url");
            q.g(r12, ServerElements.INFO);
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public Map getCommonParamsByLevel(int r10) {
            return new HashMap();
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public /* bridge */ /* synthetic */ void handleApiError(String r10, Throwable r11, long r12, BaseHttpRequestInfo r13) {
            a(r10, r11, r12, (p6.b) r13);
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public /* bridge */ /* synthetic */ void handleApiOk(String r10, long r11, BaseHttpRequestInfo r12) {
            b(r10, r11, (p6.b) r12);
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public void onTryInit() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public void putCommonParams(Map r10, boolean r11) {
            q.g(r10, "params");
        }
    }

    public static final class b implements NetworkParams.MonitorProcessHook {
        public b() {
        }

        public void a(long r27, long r29, String r31, String r32, p6.b r33, Throwable r34) {
            String r10 = r31;
            String r11 = r32;
            Log.e("matrix_network_TTNetInitHelper", "monitorApiError: " + r10);
            k r15 = k.f20573a;
            k.c(r15, true, r32, r31, r27, r29, r33);
            String[] r12 = new String[1];     // Catch: Throwable -> L12
            int r13 = ic.b.a(r34, r12);     // Catch: Throwable -> L12
            Log.i("matrix_network_TTNetInitHelper", "monitorApiError: error_status= " + r13);     // Catch: Throwable -> L12
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L12
            if (r34 == null) goto L19;
            if (com.bytedance.common.utility.e.b(r34.getClass().getName()) == true) goto L19;
            r14.put("ex_name", r34.getClass().getName());     // Catch: Throwable -> L12
            if (r13 != 1) goto L19;
            String r16 = com.bytedance.ttnet.utils.c.b(r34);     // Catch: Throwable -> L12
            if (com.bytedance.common.utility.e.b(r16) == true) goto L14;
            r14.put("ex_message", r16);     // Catch: Throwable -> L12
        L14:
            String r17 = HttpClient.a();     // Catch: Throwable -> L12
            if (com.bytedance.common.utility.e.b(r17) == true) goto L19;
            r14.put("cronet_init_ex_message", r17);     // Catch: Throwable -> L12
        L19:
            if (com.bytedance.common.utility.e.b(r12[0]) == false) goto L26;
            if (r33 == null) goto L22;
            String r18 = r33.f7162a;     // Catch: Throwable -> L12
        L23:
            if (r18 != null) goto L25;
            r18 = "";
        L25:
            r12[0] = r18;     // Catch: Throwable -> L12
            goto L26
        L22:
            r18 = null;
        L26:
            k.d(r15, r33, r14);     // Catch: Throwable -> L12
            if (r34 == null) goto L29;
            Log.e("matrix_network_TTNetInitHelper", "monitorApiError: " + r10 + TokenParser.SP + r11, r34);     // Catch: Throwable -> L12
        L29:
            InterfaceRequestListener r19 = k.b();     // Catch: Throwable -> L12
            if (r19 == null) goto L42;
            if (r10 != null) goto L33;
            String r21 = "";
        L34:
            String r20 = r12[0];     // Catch: Throwable -> L12
            if (r20 != null) goto L37;
            String r22 = "";
        L38:
            if (r11 != null) goto L40;
            String r23 = "";
        L41:
            r19.onApiError(r27, r29, r21, r22, r23, r13, r14);     // Catch: Throwable -> L12
            goto L42
        L40:
            r23 = r11;
            goto L41
        L37:
            r22 = r20;
            goto L38
        L33:
            r21 = r10;
        L42:
            InterfaceRequestListener r24 = k.b();     // Catch: Throwable -> L12
            if (r24 == null) goto L57;
            if (r10 != null) goto L46;
            r10 = "";
        L46:
            String r25 = r12[0];     // Catch: Throwable -> L12
            if (r25 != null) goto L49;
            r25 = "";
        L49:
            if (r11 != null) goto L51;
            r11 = "";
        L51:
            r24.onApiDuration(r27, r29, r10, r25, r11, r13, r14);     // Catch: Throwable -> L12
            return;
        L57:
            return;
        L12:
            th = move-exception;
            th.printStackTrace();
        }

        public void b(long r14, long r16, String r18, String r19, p6.b r20) {
            Log.i("matrix_network_TTNetInitHelper", "monitorApiOk: " + r18);
            k r11 = k.f20573a;
            k.c(r11, false, r19, r18, r14, r16, r20);
            String[] r10 = new String[1];     // Catch: Throwable -> L8
            JSONObject r12 = new JSONObject();     // Catch: Throwable -> L8
            if (com.bytedance.common.utility.e.b(r10[0]) == false) goto L14;
            if (r20 == null) goto L10;
            String r13 = r20.f7162a;     // Catch: Throwable -> L8
        L11:
            if (r13 != null) goto L13;
            r13 = "";
        L13:
            r10[0] = r13;     // Catch: Throwable -> L8
            goto L14
        L10:
            r13 = null;
        L14:
            k.d(r11, r20, r12);     // Catch: Throwable -> L8
            InterfaceRequestListener r15 = k.b();     // Catch: Throwable -> L8
            if (r15 == null) goto L26;
            String r17 = r10[0];     // Catch: Throwable -> L8
            if (r17 != null) goto L19;
            String r21 = "";
        L20:
            r15.onApiDuration(r14, r16, r18, r21, r19, 200, r12);     // Catch: Throwable -> L8
            return;
        L19:
            r21 = r17;
            goto L20
        L26:
            return;
        L8:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.MonitorProcessHook
        public /* bridge */ /* synthetic */ void monitorApiError(long r10, long r11, String r12, String r13, BaseHttpRequestInfo r14, Throwable r15) {
            a(r10, r11, r12, r13, (p6.b) r14, r15);
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.MonitorProcessHook
        public /* bridge */ /* synthetic */ void monitorApiOk(long r10, long r11, String r12, String r13, BaseHttpRequestInfo r14) {
            b(r10, r11, r12, r13, (p6.b) r14);
        }
    }

    static {
        f20573a = new k();
        f20576d = new ConcurrentHashMap(4, 0.9f, 1);
        f20577e = new b();
        f20578f = new a();
    }

    public k() {
    }

    public static /* synthetic */ f6.f a(Interceptor.Chain r10) {
        return f(r10);
    }

    public static final /* synthetic */ InterfaceRequestListener b() {
        return f20575c;
    }

    public static final /* synthetic */ void c(k r10, boolean r11, String r12, String r13, long r14, long r15, p6.b r16) {
        r10.g(r11, r12, r13, r14, r15, r16);
    }

    public static final /* synthetic */ void d(k r10, p6.b r11, JSONObject r12) {
        r10.h(r11, r12);
    }

    public static final f6.f f(Interceptor.Chain r10) {
        g6.b r11 = r10.request();
        String r12 = r11.D().toString();
        Iterator r13 = f20576d.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Map.Entry r14 = (Map.Entry) r13.next();
        if (o.B(r12, (String) r14.getKey(), false, 2, null) == false) goto L4;
        long r15 = ((Number) r14.getValue()).longValue();
    L9:
        p6.d r16 = new p6.d();
        r16.f22480c = r15;
        r16.f22481d = r15;
        r16.f22482e = r15;
        r16.f22483f = r15;
        r16.f22485h = r15;
        r16.f22484g = r15;
        r11.M(r16);
        return r10.proceed(r11);
    L8:
        r15 = 120000;
        goto L9
    }

    public final void e(Context r11, Application r12) {
        q.g(r11, "context");
        q.g(r12, "application");
        Log.i("matrix_network_TTNetInitHelper", "initTTNet start");     // Catch: Throwable -> L5
        f20574b = r12;     // Catch: Throwable -> L5
        h r10 = h.f20570a;     // Catch: Throwable -> L5
        r10.e();     // Catch: Throwable -> L5
        TTNetInit.setTTNetDepend(new i(r11));     // Catch: Throwable -> L5
        TTNetInit.tryInitTTNet(r11, r12, f20578f, f20577e, null, true, new boolean[]{false});     // Catch: Throwable -> L5
        TTNetInit.setCronetDepend(r10);     // Catch: Throwable -> L5
        TTNetInit.preInitCronetKernel();     // Catch: Throwable -> L5
        RetrofitUtils.a(new j());     // Catch: Throwable -> L5
        com.bytedance.common.utility.d.setDefault(new c());     // Catch: Throwable -> L5
        Log.i("matrix_network_TTNetInitHelper", "initTTNet end");     // Catch: Throwable -> L5
    L7:
        com.bytedance.common.utility.d.setDefault(new SSNetworkClient());
        return;
    L5:
        th = move-exception;
        Log.e("matrix_network_TTNetInitHelper", "initTTNet error", th);
        goto L7
    }

    public final void g(boolean r10, String r11, String r12, long r13, long r14, p6.b r15) {
        Log.i("matrix_network_TTNetInitHelper", "[TTNet headers - isError=" + r10 + ']');
        Log.i("matrix_network_TTNetInitHelper", " - [url|traceCode|duration|sendTime] = " + r12 + " | " + r11 + " | " + r13 + " | " + r14);
        if (r15 == null) goto L7;
        String r16 = r15.B;
        if (r16 == null) goto L7;
        i(r16);
    L7:
        if (r15 == null) goto L12;
        String r17 = r15.C;
        if (r17 == null) goto L13;
        i(r17);
        return;
    L13:
        return;
    }

    public final void h(p6.b r10, JSONObject r11) {
        if (r10 == null) goto L20;
        if (r11 == null) goto L21;
        Log.i("matrix_network_TTNetInitHelper", "[packageRequestParamters] responseHeaders= " + r10.C);     // Catch: JSONException -> L9
        r11.put("cronet_plugin_install", TTNetInit.getTTNetDepend().isCronetPluginInstalled());     // Catch: JSONException -> L9
        r11.put("appLevelRequestStart", r10.f7164c);     // Catch: JSONException -> L9
        r11.put("beforeAllInterceptors", r10.f7165d);     // Catch: JSONException -> L9
        r11.put("requestStart", r10.f7166e);     // Catch: JSONException -> L9
        r11.put("responseBack", r10.f7167f);     // Catch: JSONException -> L9
        r11.put("completeReadResponse", r10.f7168g);     // Catch: JSONException -> L9
        r11.put("requestEnd", r10.f7169h);     // Catch: JSONException -> L9
        r11.put("recycleCount", r10.f7170i);     // Catch: JSONException -> L9
        if (r10.f7183v != 0) goto L11;
        r11.put("timing_dns", r10.f7171j);     // Catch: JSONException -> L9
        r11.put("timing_connect", r10.f7172k);     // Catch: JSONException -> L9
        r11.put("timing_ssl", r10.f7173l);     // Catch: JSONException -> L9
        r11.put("timing_send", r10.f7174m);     // Catch: JSONException -> L9
        r11.put("timing_waiting", r10.f7178q);     // Catch: JSONException -> L9
        r11.put("timing_receive", r10.f7176o);     // Catch: JSONException -> L9
        r11.put("timing_total", r10.f7179r);     // Catch: JSONException -> L9
        r11.put("timing_isSocketReused", r10.f7177p);     // Catch: JSONException -> L9
        r11.put(TrafficConsts.KEY_SENT_BYTES, r10.f7180s);     // Catch: JSONException -> L9
        r11.put(TrafficConsts.KEY_RECEIVED_BYTES, r10.f7181t);     // Catch: JSONException -> L9
        r11.put("timing_remoteIP", r10.f7162a);     // Catch: JSONException -> L9
        r11.put("request_log", r10.f7186y);     // Catch: JSONException -> L9
        Log.i("matrix_network_TTNetInitHelper", "[packageRequestParamters] timing_dns: " + r10.f7171j + " timing_connect: " + r10.f7172k + " timing_ssl: " + r10.f7173l + " timing_send: " + r10.f7174m + " timing_waiting: " + r10.f7178q + " timing_receive: " + r10.f7176o + " timing_total: " + r10.f7179r + " timing_isSocketReused: " + r10.f7177p + " timing_totalSendBytes: " + r10.f7180s + " timing_totalReceivedBytes: " + r10.f7181t + " timing_remoteIP: " + r10.f7162a);     // Catch: JSONException -> L9
    L11:
        JSONObject r12 = r10.f7187z;     // Catch: JSONException -> L9
        if (r12 == null) goto L14;
        r11.put("req_info", r12);     // Catch: JSONException -> L9
    L14:
        r11.put("streaming", r10.A);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        Log.e("matrix_network_TTNetInitHelper", "[packageRequestParamters] json op error. ", e);
        return;
    L21:
        return;
    }

    public final void i(String r10) {
        JSONObject r11 = new JSONObject(r10);     // Catch: Throwable -> L8
        Iterator<String> r12 = r11.keys();     // Catch: Throwable -> L8
        q.f(r12, "json.keys()");     // Catch: Throwable -> L8
    L4:
        if (r12.hasNext() == false) goto L13;
        String r13 = r12.next();     // Catch: Throwable -> L8
        q.f(r13, "key");     // Catch: Throwable -> L8
        String r14 = r13.toLowerCase();     // Catch: Throwable -> L8
        q.f(r14, "this as java.lang.String).toLowerCase()");     // Catch: Throwable -> L8
        r11.get(r14);     // Catch: Throwable -> L8
    L13:
        return;
    }

    public final void j(InterfaceRequestListener r10) {
        f20575c = r10;
    }
}
