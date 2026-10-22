package gc;

import android.content.Context;
import android.util.Log;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.i;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.obric.matrix.platform.sdk.ones.IMatrixBridge;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.k0;
import kotlin.collections.s;
import kotlin.d;
import kotlin.jvm.internal.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20042a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f20043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f20044c;

    public static final class a implements SDKMonitor.IGetExtendParams {
        public a() {
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public Map getCommonParams() {
            if (b.a(b.f20042a) == false) goto L5;
            String r10 = "1";
        L6:
            IMatrixBridge r11 = ac.a.f80a.b();
            if (r11 == null) goto L10;
            String r12 = r11.appId();
            if (r12 == null) goto L10;
        L12:
            return k0.l(new Pair[]{d.a("host_aid", r12), d.a("oversea", r10)});
        L10:
            r12 = "";
            goto L12
        L5:
            r10 = AdReportParam.ClickPosType.SKIP;
            goto L6
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public String getSessionId() {
            return null;
        }
    }

    static {
        f20042a = new b();
        f20044c = "ones_sdk";
    }

    public b() {
    }

    public static final /* synthetic */ boolean a(b r10) {
        return r10.i();
    }

    public final String b() {
        return "release";
    }

    public final String c() {
        if (i() == false) goto L5;
        return "https://mon.isnssdk.com/monitor/appmonitor/v2/settings";
    L5:
        return "https://mon.snssdk.com/monitor/appmonitor/v2/settings";
    }

    public final String d() {
        if (i() == false) goto L5;
        return "https://mon.isnssdk.com/monitor/collect/";
    L5:
        return "https://mon.snssdk.com/monitor/collect/";
    }

    public final String e() {
        i();
        return "568500";
    }

    public final int f() {
        return 1062943;
    }

    public final String g() {
        return "1.6.29-alpha.23";
    }

    public final void h(Context r10) {
        q.g(r10, "context");
        i.d(e(), s.e(c()));
        i.e(e(), s.e(d()));
        String r11 = null;
        hc.b.b("SdkMonitorManager", "sdk aid " + e() + " , config url " + c() + " \n , reporturl " + d(), null, 4, null);
        JSONObject r12 = new JSONObject();
        ac.a r13 = ac.a.f80a;
        IMatrixBridge r14 = r13.b();
        if (r14 == null) goto L5;
        String r15 = r14.did();
    L6:
        hc.b.b("SdkMonitorManager", "device_id = " + r15, null, 4, null);
        if (r15 != null) goto L9;
    L20:
        f20043b = false;
        return;
    L9:
        if (r15.length() == 0) goto L20;
        r12.put("device_id", r15);
        r12.put(WsConstants.KEY_SDK_VERSION, g());
        hc.b.b("SdkMonitorManager", "sdk version = " + g(), null, 4, null);
        IMatrixBridge r16 = r13.b();
        if (r16 == null) goto L14;
        String r17 = r16.appId();
    L15:
        r12.put("host_aid", r17);
        IMatrixBridge r18 = r13.b();
        if (r18 == null) goto L18;
        r11 = r18.appVersionCode();
    L18:
        r12.put("app_version", r11);
        r12.put("channel", b());
        i.c(r10, e(), r12, new a());
        f20043b = true;
        return;
    L14:
        r17 = null;
        goto L15
    L5:
        r15 = null;
        goto L6
    }

    public final boolean i() {
        IMatrixBridge r10 = ac.a.f80a.b();
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.isOverSea();
    }

    public final void j(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        q.g(r10, "eventName");
        q.g(r11, "category");
        q.g(r12, CommonKey.KEY_METRIC);
        q.g(r13, "logExtr");
    L8:
        e = move-exception;
        hc.b.b("SdkMonitorManager", "event report exception " + Log.getStackTraceString(e), null, 4, null);
        return;
    L4:
        if (f20043b == true) goto L21;
        ac.a r14 = ac.a.f80a;     // Catch: Exception -> L8
        IMatrixBridge r15 = r14.b();     // Catch: Exception -> L8
        if (r15 == null) goto L10;
        String r16 = r15.did();     // Catch: Exception -> L8
    L11:
        hc.b.b("SdkMonitorManager", "on event device_id = " + r16, null, 4, null);     // Catch: Exception -> L8
        if (r16 != null) goto L14;
    L19:
        f20043b = false;     // Catch: Exception -> L8
        return;
    L14:
        if (r16.length() == 0) goto L19;
        Context r17 = r14.c();     // Catch: Exception -> L8
        if (r17 == null) goto L21;
        f20042a.h(r17);     // Catch: Exception -> L8
        goto L21
    L10:
        r16 = null;
    L21:
        r11.put("sdk_version_code", f());     // Catch: Exception -> L8
        r11.put("sdk_name", f20044c);     // Catch: Exception -> L8
        hc.b.b("SdkMonitorManager", "event " + r10 + ", category: " + r11 + ", metric " + r12 + ", logExtr " + r13, null, 4, null);     // Catch: Exception -> L8
        i.b(e()).G(r10, r11, r12, r13);     // Catch: Exception -> L8
    }
}
