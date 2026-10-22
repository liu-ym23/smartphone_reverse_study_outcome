package f9;

import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e implements NetworkParams.MonitorProcessHook {
    public e() {
    }

    public final String a(Throwable r10) {
        StringWriter r11 = new StringWriter();
        r10.printStackTrace(new PrintWriter(r11));
        return r11.toString();
    }

    public final void b(boolean r10, String r11, String r12, long r13, long r14, p6.b r15) {
        re.a.q("MonitorProcessHookImpl", "[TTNet headers - isError=" + r10 + "]");
        re.a.q("MonitorProcessHookImpl", " - [url|traceCode] = " + r12 + " | " + r11);
        re.a.q("MonitorProcessHookImpl", " - [duration|sendTime] = " + r13 + " | " + r14);
        if (r15 == null) goto L11;
        String r16 = r15.B;
        if (r16 == null) goto L7;
        f(r16);
    L7:
        String r17 = r15.C;
        if (r17 == null) goto L12;
        f(r17);
        return;
    L12:
        return;
    }

    public void c(long r15, long r17, String r19, String r20, p6.b r21, Throwable r22) {
        b(true, r20, r19, r15, r17, r21);
        String[] r10 = new String[1];     // Catch: Throwable -> L12
        int r12 = d.a(r22, r10);     // Catch: Throwable -> L12
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L12
        if (r22 == null) goto L23;
        if (TextUtils.isEmpty(r22.getClass().getName()) == true) goto L23;
        r13.put("ex_name", r22.getClass().getName());     // Catch: Throwable -> L12
        if (r12 != 1) goto L15;
        if (ApmDelegate.j().k("ex_message_open") == false) goto L15;
    L16:
        String r11 = a(r22);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r11) == true) goto L19;
        r13.put("ex_message", r11);     // Catch: Throwable -> L12
    L19:
        String r14 = HttpClient.a();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r14) == true) goto L23;
        r13.put("cronet_init_ex_message", r14);     // Catch: Throwable -> L12
    L15:
        if (ApmDelegate.j().k("debug_ex_message_open") == true) goto L16;
    L23:
        if (TextUtils.isEmpty(r10[0]) == false) goto L28;
        if (r21 == null) goto L26;
        String r16 = r21.f7162a;     // Catch: Throwable -> L12
    L27:
        r10[0] = r16;     // Catch: Throwable -> L12
        goto L28
    L26:
        r16 = "";
    L28:
        e(r21, r13);     // Catch: Throwable -> L12
        ApmAgent.d(r15, r17, r19, r10[0], r20, r12, r13);     // Catch: Throwable -> L12
        ApmAgent.j(r15, r17, r19, r10[0], r20, r12, r13);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
    }

    public void d(long r12, long r14, String r16, String r17, p6.b r18) {
        b(false, r17, r16, r12, r14, r18);
        String[] r10 = new String[1];     // Catch: Throwable -> L7
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r10[0]) == false) goto L11;
        if (r18 == null) goto L9;
        String r13 = r18.f7162a;     // Catch: Throwable -> L7
    L10:
        r10[0] = r13;     // Catch: Throwable -> L7
        goto L11
    L9:
        r13 = "";
    L11:
        e(r18, r11);     // Catch: Throwable -> L7
        ApmAgent.j(r12, r14, r16, r10[0], r17, 200, r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public final void e(p6.b r10, JSONObject r11) {
        if (r10 == null) goto L19;
        if (r11 == null) goto L20;
        r11.put("cronet_plugin_install", TTNetInit.getTTNetDepend().isCronetPluginInstalled());     // Catch: Exception -> L8
        r11.put("appLevelRequestStart", r10.f7164c);     // Catch: Exception -> L8
        r11.put("beforeAllInterceptors", r10.f7165d);     // Catch: Exception -> L8
        r11.put("requestStart", r10.f7166e);     // Catch: Exception -> L8
        r11.put("responseBack", r10.f7167f);     // Catch: Exception -> L8
        r11.put("completeReadResponse", r10.f7168g);     // Catch: Exception -> L8
        r11.put("requestEnd", r10.f7169h);     // Catch: Exception -> L8
        r11.put("recycleCount", r10.f7170i);     // Catch: Exception -> L8
        if (r10.f7183v != 0) goto L10;
        r11.put("timing_dns", r10.f7171j);     // Catch: Exception -> L8
        r11.put("timing_connect", r10.f7172k);     // Catch: Exception -> L8
        r11.put("timing_ssl", r10.f7173l);     // Catch: Exception -> L8
        r11.put("timing_send", r10.f7174m);     // Catch: Exception -> L8
        r11.put("timing_waiting", r10.f7178q);     // Catch: Exception -> L8
        r11.put("timing_receive", r10.f7176o);     // Catch: Exception -> L8
        r11.put("timing_total", r10.f7179r);     // Catch: Exception -> L8
        r11.put("timing_isSocketReused", r10.f7177p);     // Catch: Exception -> L8
        r11.put(TrafficConsts.KEY_SENT_BYTES, r10.f7180s);     // Catch: Exception -> L8
        r11.put(TrafficConsts.KEY_RECEIVED_BYTES, r10.f7181t);     // Catch: Exception -> L8
        r11.put("timing_remoteIP", r10.f7162a);     // Catch: Exception -> L8
        r11.put("request_log", r10.f7186y);     // Catch: Exception -> L8
    L10:
        JSONObject r12 = r10.f7187z;     // Catch: Exception -> L8
        if (r12 == null) goto L13;
        r11.put("req_info", r12);     // Catch: Exception -> L8
    L13:
        r11.put("streaming", r10.A);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        re.a.k("MonitorProcessHookImpl", "[packageRequestParamters] json op error. ", e);
        return;
    L20:
        return;
    }

    public final void f(String r10) {
        if (r10 != null) goto L13;
        return;
    L13:
        JSONObject r11 = new JSONObject(r10);     // Catch: Exception -> L12
        Iterator<String> r12 = r11.keys();     // Catch: Exception -> L12
    L6:
        if (r12.hasNext() == false) goto L20;
        String r13 = r12.next();     // Catch: Exception -> L12
        String r14 = r13.toLowerCase();     // Catch: Exception -> L12
        if (r14.startsWith("x-tt") == false) goto L6;
        re.a.q("MonitorProcessHookImpl", " - [header] `" + r14 + "` = " + r11.get(r13));     // Catch: Exception -> L12
    L20:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.MonitorProcessHook
    public /* bridge */ /* synthetic */ void monitorApiError(long r10, long r11, String r12, String r13, BaseHttpRequestInfo r14, Throwable r15) {
        c(r10, r11, r12, r13, (p6.b) r14, r15);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.MonitorProcessHook
    public /* bridge */ /* synthetic */ void monitorApiOk(long r10, long r11, String r12, String r13, BaseHttpRequestInfo r14) {
        d(r10, r11, r12, r13, (p6.b) r14);
    }
}
