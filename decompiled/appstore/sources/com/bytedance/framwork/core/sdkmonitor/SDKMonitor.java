package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.framwork.core.sdklib.config.IMonitorConfigure;
import com.bytedance.framwork.core.sdklib.net.ISendLog;
import com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask;
import com.bytedance.framwork.core.sdklib.util.NetUtils;
import com.bytedance.framwork.core.sdklog.LogLib;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedanceos.common.tracker.TrackerElement;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SDKMonitor implements IMonitorConfigure, ISendLog, IMonitorTimeTask {
    public volatile boolean A;
    public volatile boolean B;
    public volatile boolean C;
    public volatile long D;
    public List E;
    public com.bytedance.framwork.core.sdkmonitor.b F;
    public String G;
    public boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f7571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a5.d f7572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a5.b f7573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f7574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f7575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f7576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f7577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f7578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile int f7579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile JSONObject f7580k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile JSONObject f7581l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile IHttpService f7582m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile int f7583n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile int f7584o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile List f7585p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile List f7586q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile List f7587r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile List f7588s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile int f7589t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile long f7590u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public IGetExtendParams f7591v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map f7592w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List f7593x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f7594y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile boolean f7595z;

    public interface ICallback {
        void callback(boolean r10);
    }

    public interface IGetCommonParams {
        String getSessionId();
    }

    public interface IGetExtendParams {
        Map<String, String> getCommonParams();

        String getSessionId();
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f7597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IGetExtendParams f7598c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f7599d;

        public a(SDKMonitor r10, Context r11, JSONObject r12, IGetExtendParams r13) {
            this.f7599d = r10;
            this.f7596a = r11;
            this.f7597b = r12;
            this.f7598c = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            SDKMonitor.a(this.f7599d, this.f7596a, this.f7597b, this.f7598c);
            if (SDKMonitor.b(this.f7599d) == false) goto L6;
            SDKMonitor.d(this.f7599d).h(this.f7599d);
            return;
        }
    }

    public class b implements IGetExtendParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f7600a;

        public b(SDKMonitor r10) {
            this.f7600a = r10;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public Map getCommonParams() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public String getSessionId() {
            return null;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f7601a;

        public c(SDKMonitor r10) {
            this.f7601a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L19:
            th = move-exception;
            if (SDKMonitor.b(this.f7601a) == true) goto L23;
            SDKMonitor.c(this.f7601a, true);
            SDKMonitor.d(this.f7601a).h(this.f7601a);
        L23:
            th.printStackTrace();
            return;
        L3:
            if (SDKMonitor.e(this.f7601a) == null) goto L32;
            Iterator r10 = SDKMonitor.f(this.f7601a).iterator();     // Catch: Throwable -> L19
        L5:
            if (r10.hasNext() == false) goto L33;
            String r11 = (String) r10.next();     // Catch: Throwable -> L19
            StringBuilder r12 = SDKMonitor.g(this.f7601a, r11);     // Catch: Throwable -> L19
            r12.append("&encrypt=close");     // Catch: Throwable -> L19
            String r13 = r12.toString();     // Catch: Throwable -> L19
        L11:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L19
            goto L5
        L9:
            if (SDKMonitor.h(this.f7601a) == null) goto L13;
            byte[] r14 = SDKMonitor.h(this.f7601a).doGet(r13, null).b();     // Catch: Throwable -> L11
        L14:
            if (r14 == null) goto L34;
            SDKMonitor.j(this.f7601a, new JSONObject(new String(r14)));     // Catch: Throwable -> L11
        L35:
            return;
        L34:
            return;
        L13:
            r14 = MonitorNetUtil.e(r13, null, SDKMonitor.i(this.f7601a));     // Catch: Throwable -> L11
            goto L14
        L33:
            return;
        }
    }

    public class d implements LogLib.ILogDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f7602a;

        public d(SDKMonitor r10) {
            this.f7602a = r10;
        }

        @Override // com.bytedance.framwork.core.sdklog.LogLib.ILogDelegate
        public boolean isNetworkAvailable(Context r10) {
            return MonitorNetUtil.f(r10);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f7603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f7604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f7607e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f7608f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f7609g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f7610h;

        public e(SDKMonitor r10, long r11, long r12, String r13, String r14, String r15, int r16, JSONObject r17) {
            this.f7610h = r10;
            this.f7603a = r11;
            this.f7604b = r12;
            this.f7605c = r13;
            this.f7606d = r14;
            this.f7607e = r15;
            this.f7608f = r16;
            this.f7609g = r17;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7610h.w(this.f7603a, this.f7604b, this.f7605c, this.f7606d, this.f7607e, this.f7608f, this.f7609g);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f7611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f7612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f7613c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f7614d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f7615e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f7616f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f7617g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f7618h;

        public f(SDKMonitor r10, long r11, long r12, String r13, String r14, String r15, int r16, JSONObject r17) {
            this.f7618h = r10;
            this.f7611a = r11;
            this.f7612b = r12;
            this.f7613c = r13;
            this.f7614d = r14;
            this.f7615e = r15;
            this.f7616f = r16;
            this.f7617g = r17;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7618h.v(this.f7611a, this.f7612b, this.f7613c, this.f7614d, this.f7615e, this.f7616f, this.f7617g);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f7621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f7622d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f7623e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ JSONObject f7624f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f7625g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f7626h;

        public g(SDKMonitor r10, String r11, int r12, JSONObject r13, JSONObject r14, JSONObject r15, JSONObject r16, long r17) {
            this.f7626h = r10;
            this.f7619a = r11;
            this.f7620b = r12;
            this.f7621c = r13;
            this.f7622d = r14;
            this.f7623e = r15;
            this.f7624f = r16;
            this.f7625g = r17;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7626h.I(this.f7619a, this.f7620b, this.f7621c, this.f7622d, this.f7623e, this.f7624f, this.f7625g);
        }
    }

    public SDKMonitor(String r10) {
        this.f7574e = 0;
        this.f7589t = 1;
        this.f7593x = new LinkedList();
        this.A = true;
        this.E = new LinkedList();
        this.G = r10;
        this.C = false;
        this.F = new com.bytedance.framwork.core.sdkmonitor.b();
    }

    public static /* synthetic */ void a(SDKMonitor r10, Context r11, JSONObject r12, IGetExtendParams r13) {
        r10.A(r11, r12, r13);
    }

    public static /* synthetic */ boolean b(SDKMonitor r10) {
        return r10.C;
    }

    public static /* synthetic */ boolean c(SDKMonitor r10, boolean r11) {
        r10.C = r11;
        return r11;
    }

    public static /* synthetic */ com.bytedance.framwork.core.sdkmonitor.b d(SDKMonitor r10) {
        return r10.F;
    }

    public static /* synthetic */ Map e(SDKMonitor r10) {
        return r10.f7592w;
    }

    public static /* synthetic */ List f(SDKMonitor r10) {
        return r10.f7593x;
    }

    public static /* synthetic */ StringBuilder g(SDKMonitor r10, String r11) {
        return r10.k(r11);
    }

    public static /* synthetic */ IHttpService h(SDKMonitor r10) {
        return r10.q();
    }

    public static /* synthetic */ boolean i(SDKMonitor r10) {
        return r10.A;
    }

    public static /* synthetic */ void j(SDKMonitor r10, JSONObject r11) {
        r10.T(r11);
    }

    public static String p(String r10, String r11) {
        if (r11 != null) goto L10;
        r11 = "UTF-8";
    L10:
        return URLEncoder.encode(r10, r11);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public final void A(Context r18, JSONObject r19, IGetExtendParams r20) {
        if (r18 == null) goto L30;
        if (r19 == null) goto L31;
        this.B = true;
        this.f7570a = r18.getApplicationContext();
        this.f7571b = r19;
        r19.put("aid", this.G);     // Catch: Exception -> L27
        this.f7571b.put("os", "Android");     // Catch: Exception -> L27
        this.f7571b.put("device_platform", "android");     // Catch: Exception -> L27
        this.f7571b.put(CommonKey.KEY_OS_VERSION, Build.VERSION.RELEASE);     // Catch: Exception -> L27
        this.f7571b.put("os_api", Build.VERSION.SDK_INT);     // Catch: Exception -> L27
        this.f7571b.put("device_model", Build.MODEL);     // Catch: Exception -> L27
        this.f7571b.put("device_brand", Build.BRAND);     // Catch: Exception -> L27
        this.f7571b.put(CommonKey.KEY_DEVICE_MANUFACTURER, Build.MANUFACTURER);     // Catch: Exception -> L27
        this.f7571b.put("sdkmonitor_version", "2.0.35");     // Catch: Exception -> L27
        this.f7571b.put("monitor_from", "sdk");     // Catch: Exception -> L27
        if (TextUtils.isEmpty(this.f7571b.optString(TrackerElement.PACKAGE_NAME)) == false) goto L11;
        this.f7571b.put(TrackerElement.PACKAGE_NAME, r18.getPackageName());     // Catch: Exception -> L27
    L11:
        if (TextUtils.isEmpty(this.f7571b.optString(CommonKey.KEY_VERSION_NAME)) == false) goto L13;
        PackageInfo r10 = this.f7570a.getPackageManager().getPackageInfo(this.f7570a.getPackageName(), 0);     // Catch: Exception -> L27
        this.f7571b.put(CommonKey.KEY_VERSION_NAME, r10.versionName);     // Catch: Exception -> L27
    L15:
        if (TextUtils.isEmpty(this.f7571b.optString("version_code")) == false) goto L19;
        if (r10 != null) goto L18;
        r10 = this.f7570a.getPackageManager().getPackageInfo(this.f7570a.getPackageName(), 0);     // Catch: Exception -> L27
    L18:
        this.f7571b.put("version_code", r10.versionCode);     // Catch: Exception -> L27
    L19:
        this.f7591v = r20;     // Catch: Exception -> L27
        if (r20 != null) goto L22;
        this.f7591v = new b(this);     // Catch: Exception -> L27
    L22:
        Map<String, String> r11 = this.f7591v.getCommonParams();     // Catch: Exception -> L27
        this.f7592w = r11;     // Catch: Exception -> L27
        if (r11 != null) goto L25;
        this.f7592w = new HashMap();     // Catch: Exception -> L27
    L25:
        this.H = TextUtils.equals((CharSequence) this.f7592w.get("oversea"), "1");     // Catch: Exception -> L27
        this.f7592w.put("aid", this.G);     // Catch: Exception -> L27
        this.f7592w.put("device_id", this.f7571b.optString("device_id"));     // Catch: Exception -> L27
        this.f7592w.put("device_platform", "android");     // Catch: Exception -> L27
        this.f7592w.put(TrackerElement.PACKAGE_NAME, this.f7571b.optString(TrackerElement.PACKAGE_NAME));     // Catch: Exception -> L27
        this.f7592w.put("channel", this.f7571b.optString("channel"));     // Catch: Exception -> L27
        this.f7592w.put("app_version", this.f7571b.optString("app_version"));     // Catch: Exception -> L27
        this.f7592w.put("sdkmonitor_version", "2.0.35");     // Catch: Exception -> L27
        this.f7592w.put(SlardarSettingsConsts.KEY_QUERY_MINOR_VERSION, "1");     // Catch: Exception -> L27
        b5.b.i(this.G, this);     // Catch: Exception -> L27
        d5.b.d(this.G, this);     // Catch: Exception -> L27
        z();     // Catch: Exception -> L27
        a5.d r12 = new a5.d(this.f7570a, this.G);     // Catch: Exception -> L27
        this.f7572c = r12;     // Catch: Exception -> L27
        r12.c();     // Catch: Exception -> L27
        this.f7582m = (IHttpService) n5.b.a(IHttpService.class);     // Catch: Exception -> L27
        y();     // Catch: Exception -> L27
        return;
    L13:
        r10 = null;
    L32:
        return;
    L31:
        return;
    }

    public boolean B() {
        return this.B;
    }

    public final boolean C(String r10, List r11, List r12) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        if (com.bytedance.framwork.core.sdkmonitor.f.a(r11) == true) goto L23;
        Iterator r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L23;
        if (r10.contains((String) r13.next()) == false) goto L9;
        return true;
    L23:
        String r14 = new URI(r10).getPath();     // Catch: Throwable -> L22
        if (com.bytedance.framwork.core.sdkmonitor.f.a(r12) == true) goto L21;
        Iterator r15 = r12.iterator();     // Catch: Throwable -> L22
    L17:
        if (r15.hasNext() == false) goto L21;
        if (((Pattern) r15.next()).matcher(r14).matches() == false) goto L17;
        return true;
    L21:
        return false;
    }

    public final boolean D(String r10) {
        return C(r10, this.f7587r, this.f7588s);
    }

    public final boolean E(String r10) {
        return C(r10, this.f7585p, this.f7586q);
    }

    public void F(long r14, long r16, String r18, String r19, String r20, int r21, JSONObject r22) {
        if (this.C == true) goto L6;
        this.F.k(new com.bytedance.framwork.core.sdkmonitor.a("api_all", r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        e5.a.e().f(new f(this, r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    }

    public void G(String r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        if (this.C == true) goto L5;
        this.F.l(new j(r12, 0, null, r13, r14, r15, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        J(r12, 0, null, r13, r14, r15, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    public void H(long r14, long r16, String r18, String r19, String r20, int r21, JSONObject r22) {
        if (this.C == true) goto L6;
        this.F.k(new com.bytedance.framwork.core.sdkmonitor.a("api_all", r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        e5.a.e().f(new e(this, r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    }

    public void I(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15, long r16) {
        if (r15 == null) goto L23;
    L5:
        r15.put("log_type", "service_monitor");     // Catch: Throwable -> L22
        r15.put("service", r10);     // Catch: Throwable -> L22
        r15.put("status", r11);     // Catch: Throwable -> L22
        r15.put("network_type", r());     // Catch: Throwable -> L22
        r15.put(CommonKey.KEY_VALUE, r12);     // Catch: Throwable -> L22
        if (r13 == null) goto L8;
        r15.put("category", r13);     // Catch: Throwable -> L22
    L8:
        if (r14 == null) goto L11;
        r15.put(CommonKey.KEY_METRIC, r14);     // Catch: Throwable -> L22
    L11:
        if (r15.isNull("timestamp") == false) goto L14;
        r15.put("timestamp", r16);     // Catch: Throwable -> L22
    L14:
        if (TextUtils.isEmpty(t()) == true) goto L17;
        r15.put(CommonKey.KEY_SESSION_ID, t());     // Catch: Throwable -> L22
    L17:
        if (this.f7572c != null) goto L19;
        return;
    L19:
        if (s(r10) == false) goto L26;
        this.f7572c.d("service_monitor", "service_monitor", r15);     // Catch: Throwable -> L22
        return;
    L27:
        return;
    L26:
        return;
    L23:
        r15 = new JSONObject();     // Catch: Throwable -> L22
        goto L5
    }

    public void J(String r13, int r14, JSONObject r15, JSONObject r16, JSONObject r17, JSONObject r18, long r19) {
        e5.a.e().f(new g(this, r13, r14, r15, r16, r17, r18, r19));
    }

    public final boolean K() {
        if (((System.currentTimeMillis() - this.f7574e) / 1000) <= this.f7575f) goto L5;
        return true;
    L5:
        return false;
    }

    public final JSONObject L(String r10, long r11, long r12, String r13, String r14, String r15, int r16) {
        if (TextUtils.isEmpty(r10) == false) goto L22;
        return null;
    L22:
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L21
        r17.put("log_type", r10);     // Catch: Exception -> L21
        r17.put("duration", r11);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r13) == true) goto L9;
        r17.put("uri", Uri.parse(r13));     // Catch: Exception -> L21
    L9:
        if (r12 <= 0) goto L11;
        r17.put("timestamp", r12);     // Catch: Exception -> L21
    L11:
        r17.put("status", r16);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r14) == true) goto L16;
        r17.put("ip", r14);     // Catch: Exception -> L21
    L16:
        if (TextUtils.isEmpty(r15) == true) goto L18;
        r17.put("trace_code", r15);     // Catch: Exception -> L21
    L19:
        r17.put("network_type", MonitorNetUtil.d(this.f7570a).getValue());     // Catch: Exception -> L21
        return r17;
    L18:
        r17.put("trace_code", "");     // Catch: Exception -> L21
    L21:
        return null;
    }

    public void M(List r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (com.bytedance.framwork.core.sdkmonitor.f.a(r10) == true) goto L8;
        this.f7593x.clear();
        this.f7593x.addAll(r10);
        return;
    }

    public void N(List r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (com.bytedance.framwork.core.sdkmonitor.f.a(r10) == true) goto L8;
        this.E.clear();
        this.E.addAll(r10);
        return;
    }

    public void O() {
        this.f7573d.i();
    }

    public void P(long r10) {
        this.f7573d.k(r10);
    }

    public void Q(boolean r10) {
        this.f7572c.f(r10);
    }

    public synchronized void R(JSONObject r10) {
        monitor-enter(this);
        if (r10 != null) goto L74;
        monitor-exit(this);
        return;
    L74:
        JSONObject r11 = com.bytedance.framwork.core.sdkmonitor.e.a(r10, com.bytedance.framwork.core.sdkmonitor.g.f7642a, com.bytedance.framwork.core.sdkmonitor.g.f7645d);     // Catch: Throwable -> L11
        if (r11 == null) goto L55;
        JSONObject r12 = r11.optJSONObject(com.bytedance.framwork.core.sdkmonitor.g.f7647f);     // Catch: Throwable -> L11
        if (r12 == null) goto L14;
        this.f7575f = r12.optLong(com.bytedance.framwork.core.sdkmonitor.g.f7648g, 1200);     // Catch: Throwable -> L11
    L14:
        if (this.f7575f >= 600) goto L17;
        this.f7575f = 600;     // Catch: Throwable -> L11
    L17:
        if (K() == false) goto L20;
        monitor-exit(this);
        return;
    L20:
        JSONObject r13 = r11.optJSONObject(com.bytedance.framwork.core.sdkmonitor.g.f7649h);     // Catch: Throwable -> L11
        if (r13 == null) goto L55;
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L11
        JSONArray r15 = r13.optJSONArray(SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_HOSTS);     // Catch: Throwable -> L11 Exception -> L73
        if (r15 == null) goto L43;
        if (r15.length() <= 0) goto L43;
        int r16 = r15.length();     // Catch: Throwable -> L11 Exception -> L73
        int r17 = 0;
    L28:
        if (r17 >= r16) goto L43;
        String r18 = r15.getString(r17);     // Catch: Throwable -> L11 Exception -> L73
        if (this.H == false) goto L37;
        if (r18.contains(".snssdk.") == true) goto L35;
        if (r18.contains(".toutiao.") == false) goto L37;
    L35:
        r14.clear();     // Catch: Throwable -> L11 Exception -> L73
    L37:
        if (TextUtils.isEmpty(r18) == true) goto L41;
        if (r18.indexOf(46) <= 0) goto L41;
        r14.add(r18);     // Catch: Throwable -> L11 Exception -> L73
    L41:
        r17 = r17 + 1;
    L43:
        if (r14.isEmpty() == true) goto L45;
        this.E = i.a(r14);     // Catch: Throwable -> L11
    L45:
        int r19 = 120;
        this.f7576g = r13.optInt(SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_UOLOADING_INTERVAL, 120);     // Catch: Throwable -> L11
        if (this.f7576g < 0) goto L49;
        r19 = this.f7576g;     // Catch: Throwable -> L11
    L49:
        this.f7576g = r19;     // Catch: Throwable -> L11
        int r20 = 100;
        this.f7577h = r13.optInt(SlardarSettingsConsts.BASE_KEY_ONCE_MAX_COUNT, 100);     // Catch: Throwable -> L11
        if (this.f7577h < 0) goto L53;
        r20 = this.f7577h;     // Catch: Throwable -> L11
    L53:
        this.f7577h = r20;     // Catch: Throwable -> L11
        this.f7578i = r13.optInt(SlardarSettingsConsts.BASE_KEY_MAX_RETRY_COUNT, 4);     // Catch: Throwable -> L11
        this.f7579j = r13.optInt("report_fail_base_interval", 15);     // Catch: Throwable -> L11
        this.f7589t = r13.optInt(SlardarSettingsConsts.BASE_KEY_LOG_SEND_SWITCH, 1);     // Catch: Throwable -> L11
        this.f7590u = r13.optLong(SlardarSettingsConsts.BASE_KEY_MORE_CHANNEL_STOP_INTERVAL, 1800);     // Catch: Throwable -> L11
        this.A = r13.optBoolean(SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_ENCRYPT, true);     // Catch: Throwable -> L11
        this.D = r13.optLong(SlardarSettingsConsts.BASE_MEMORY_STORE_CACHE_MAX_COUNT, AnimationConstants.DURATION_2000L);     // Catch: Throwable -> L11
        this.f7594y = r13.optBoolean(SlardarSettingsConsts.BASE_KEY_LOG_REMOVE_SWITCH, false);     // Catch: Throwable -> L11
    L55:
        if (r10.length() > 0) goto L59;
        this.E = null;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L59:
        JSONObject r21 = r10.optJSONObject(com.bytedance.framwork.core.sdkmonitor.g.f7643b);     // Catch: Throwable -> L11
        if (r21 == null) goto L62;
        this.f7580k = r21.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_SERVICE_NAME);     // Catch: Throwable -> L11
        this.f7581l = r21.optJSONObject("allow_log_type");     // Catch: Throwable -> L11
    L62:
        JSONObject r22 = com.bytedance.framwork.core.sdkmonitor.e.a(r10, com.bytedance.framwork.core.sdkmonitor.g.f7644c, com.bytedance.framwork.core.sdkmonitor.g.f7646e);     // Catch: Throwable -> L11
        if (r22 == null) goto L66;
        this.f7583n = r22.optInt(SlardarSettingsConsts.SETTING_NET_ENABLE_API_ERROR_UPLOAD, 0);     // Catch: Throwable -> L11
        this.f7584o = r22.optInt(SlardarSettingsConsts.SETTING_NET_ENABLE_API_ALL_UPLOAD, 0);     // Catch: Throwable -> L11
        this.f7585p = com.bytedance.framwork.core.sdkmonitor.f.b(r22, SlardarSettingsConsts.SETTING_NET_API_BLOCK_LIST);     // Catch: Throwable -> L11
        this.f7586q = com.bytedance.framwork.core.sdkmonitor.f.c(r22, SlardarSettingsConsts.SETTING_NET_API_BLOCK_LIST);     // Catch: Throwable -> L11
        this.f7587r = com.bytedance.framwork.core.sdkmonitor.f.b(r22, SlardarSettingsConsts.SETTING_NET_API_ALLOW_LIST);     // Catch: Throwable -> L11
        this.f7588s = com.bytedance.framwork.core.sdkmonitor.f.c(r22, SlardarSettingsConsts.SETTING_NET_API_ALLOW_LIST);     // Catch: Throwable -> L11
    L66:
        if (this.f7573d != null) goto L68;
        a5.b r23 = new a5.b(this.f7570a, this.G);     // Catch: Throwable -> L11
        this.f7573d = r23;     // Catch: Throwable -> L11
        r23.f();     // Catch: Throwable -> L11
    L68:
        this.f7573d.o();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void S(boolean r10) {
        if (this.f7575f >= 600) goto L5;
        this.f7575f = 600;
    L5:
        if (r10 == true) goto L9;
        if (K() == true) goto L9;
        return;
    L9:
        if (MonitorNetUtil.f(this.f7570a) == true) goto L11;
        return;
    L11:
        monitor-enter(SDKMonitor.class);
        this.f7574e = System.currentTimeMillis();     // Catch: Throwable -> L16
        monitor-exit(SDKMonitor.class);     // Catch: Throwable -> L16
        e5.a.e().f(new c(this));     // Catch: Throwable -> L20
        return;
    L27:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void T(JSONObject r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.length() <= 0) goto L14;
        R(r10.getJSONObject(SlardarConfigConsts.CONFIG_RET));     // Catch: Throwable -> L10
        SharedPreferences.Editor r11 = u().edit();     // Catch: Throwable -> L10
        r11.putLong(SlardarConfigConsts.MONITOR_CONFIG_REFRESH_TIME, System.currentTimeMillis());     // Catch: Throwable -> L10
        r11.putInt("monitor_config_update", 1);     // Catch: Throwable -> L10
        r11.putString(SlardarConfigConsts.MONITOR_NET_CONFIG, r10.getJSONObject(SlardarConfigConsts.CONFIG_RET).toString());     // Catch: Throwable -> L10
        r11.apply();     // Catch: Throwable -> L10
        if (this.C == true) goto L15;
        this.C = true;     // Catch: Throwable -> L10
        this.F.h(this);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public long getMonitorLogMaxSaveCount() {
        return getMonitorLogMaxSaveCount();
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public boolean getRemoveSwitch() {
        if (this.f7595z == false) goto L6;
        return this.f7595z;
    L6:
        return this.f7594y;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public boolean isLogSendSwitch() {
        if (this.f7589t == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final StringBuilder k(String r10) {
        StringBuilder r11 = new StringBuilder(r10);
        if (TextUtils.isDigitsOnly(r10) == false) goto L5;
    L20:
        return r11;
    L5:
        if (this.f7592w == null) goto L20;
        if (r10.contains("?") == true) goto L10;
        r11.append("?");
    L10:
        l(r11, WsConstants.KEY_SDK_VERSION, String.valueOf(400));
        Map r12 = this.f7592w;
        if (r12 == null) goto L20;
        if (r12.size() <= 0) goto L20;
        Iterator r13 = r12.entrySet().iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        Map.Entry r14 = (Map.Entry) r13.next();
        if (r14.getKey() == null) goto L16;
        l(r11, String.valueOf(r14.getKey()), String.valueOf(r14.getValue()));
        goto L16
    }

    public final StringBuilder l(StringBuilder r10, String r11, String r12) {
        if (r10.charAt(r10.length() - 1) == '?') goto L5;
        r10.append("&");
    L5:
        r10.append(p(r11, "UTF-8"));
        r10.append('=');
        r10.append(p(r12, "UTF-8"));
        return r10;
    }

    public final void m(JSONObject r10, JSONObject r11) {
        if (r10 == null) goto L19;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length() <= 0) goto L21;
        Iterator<String> r12 = r11.keys();     // Catch: JSONException -> L12
    L9:
        if (r12.hasNext() == false) goto L22;
        String r13 = r12.next();     // Catch: JSONException -> L12
        r10.put(r13, r11.get(r13));     // Catch: JSONException -> L12
        goto L9
    L22:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    }

    public void n() {
        this.f7572c.a();     // Catch: Throwable -> L4
        this.f7573d.a();     // Catch: Throwable -> L4
        return;
    }

    public void o() {
        this.f7573d.c();
        this.f7595z = true;
    }

    @Override // com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask
    public void onTimeEvent(long r10) {
        if (this.f7575f > 0) goto L5;
        return;
    L5:
        S(false);
    }

    public final IHttpService q() {
        if (this.f7582m != null) goto L6;
        this.f7582m = (IHttpService) n5.b.a(IHttpService.class);
    L6:
        return this.f7582m;
    }

    public int r() {
        return NetUtils.a(this.f7570a).getValue();
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public int reportCount() {
        if (this.f7577h > 0) goto L7;
        return 100;
    L7:
        return this.f7577h;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public int reportFailRepeatBaseTime() {
        if (this.f7579j > 0) goto L7;
        return 15;
    L7:
        return this.f7579j;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public int reportFailRepeatCount() {
        if (this.f7578i > 0) goto L7;
        return 4;
    L7:
        return this.f7578i;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public int reportInterval() {
        if (this.f7576g > 0) goto L7;
        return 120;
    L7:
        return this.f7576g;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public JSONObject reportJsonHeaderInfo() {
        return this.f7571b;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public List reportUrl(String r10) {
        return this.E;
    }

    public boolean s(String r10) {
        if (this.f7580k != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        if (this.f7580k.opt(r10) == null) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.framwork.core.sdklib.net.ISendLog
    public d5.c sendLog(String r10, byte[] r11) {
        d5.c r12 = new d5.c();
        String r13 = k(r10).toString();     // Catch: Throwable -> L10
        new HashMap();     // Catch: Throwable -> L10
        if (q() == null) goto L14;
        HashMap r14 = new HashMap();     // Catch: Throwable -> L10
        byte[] r15 = MonitorNetUtil.a(r11, r14);     // Catch: Throwable -> L10
        if (this.A == false) goto L13;
        byte[] r16 = z4.a.a(r15, r15.length);     // Catch: Throwable -> L10
        if (r16 == null) goto L12;
        r13 = r13 + "&tt_data=a";     // Catch: Throwable -> L10
        r14.put("Content-Type", "application/octet-stream;tt-data=a");     // Catch: Throwable -> L10
    L12:
        i6.c r17 = q().doPost(r13, r16, r14);     // Catch: Throwable -> L10
        byte[] r18 = r17.b();     // Catch: Throwable -> L10
        Map r19 = r17.a();     // Catch: Throwable -> L10
    L15:
        if (r19 != null) goto L17;
    L19:
        String r20 = null;
    L20:
        r12.f19093a = 200;     // Catch: Throwable -> L10
        JSONObject r21 = new JSONObject(new String(r18));     // Catch: Throwable -> L10
        String r22 = r21.optString("data");     // Catch: Throwable -> L26
        if (r22.isEmpty() == true) goto L29;
        String r23 = com.bytedance.framwork.core.sdklib.util.a.a(r22.getBytes(), r20);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r23) == true) goto L28;
        r21 = new JSONObject(r23);     // Catch: Throwable -> L26
        goto L29
    L28:
        r21.put("message", "success");     // Catch: Throwable -> L26
    L29:
        r12.f19094b = r21;     // Catch: Throwable -> L26
    L32:
        r12.f19094b = r21;     // Catch: Throwable -> L10
        return r12;
    L26:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L10
        goto L32
    L17:
        if (r19.isEmpty() == true) goto L19;
        r20 = (String) r19.get("ran");     // Catch: Throwable -> L10
        goto L20
    L13:
        i6.c r24 = q().doPost(r13, r15, r14);     // Catch: Throwable -> L10
        r18 = r24.b();     // Catch: Throwable -> L10
        r19 = r24.a();     // Catch: Throwable -> L10
        goto L15
    L14:
        i6.c r25 = MonitorNetUtil.b(r13, r11, MonitorNetUtil.CompressType.GZIP, "application/json; charset=utf-8", this.A);     // Catch: Throwable -> L10
        r18 = r25.b();     // Catch: Throwable -> L10
        r19 = r25.a();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if ((th instanceof HttpResponseException) == false) goto L37;
        r12.f19093a = th.getStatusCode();
    L38:
        return r12;
    L37:
        r12.f19093a = -1;
        goto L38
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public long stopMoreChannelInterval() {
        if (this.f7590u != 0) goto L7;
        return 1800000;
    L7:
        return this.f7590u * 1000;
    }

    public final String t() {
        IGetExtendParams r10 = this.f7591v;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getSessionId();
    }

    public final SharedPreferences u() {
        String r10 = h.a(this.f7570a);
        return this.f7570a.getSharedPreferences(SlardarConfigConsts.MONITOR_CONFIG + this.G + r10, 0);
    }

    public void v(long r12, long r14, String r16, String r17, String r18, int r19, JSONObject r20) {
        if (this.f7583n != 1) goto L5;
        return;
    L5:
        if (E(r16) == true) goto L19;
        JSONObject r10 = L("api_error", r12, r14, r16, r17, r18, r19);
        m(r10, r20);
        if (r10 != null) goto L10;
        return;
    L10:
        if (r10.length() <= 0) goto L17;
        a5.d r11 = this.f7572c;
        if (r11 == null) goto L18;
        r11.d("api_error", "api_error", r10);
        return;
    L18:
        return;
    L17:
        return;
    }

    public void w(long r14, long r16, String r18, String r19, String r20, int r21, JSONObject r22) {
        if (E(r18) == false) goto L5;
        return;
    L5:
        if (MonitorNetUtil.f(this.f7570a) == false) goto L20;
        JSONObject r10 = L("api_all", r14, r16, r18, r19, r20, r21);
        m(r10, r22);
        if (r10 == null) goto L12;
        if (D(r18) == false) goto L12;
    L16:
        r10.put("hit_rules", 1);     // Catch: JSONException -> L15
        this.f7572c.d("api_all", "api_all", r10);     // Catch: JSONException -> L15
        return;
    L21:
        return;
    L12:
        if (this.f7584o != 0) goto L16;
        return;
    }

    public boolean x(Context r10, JSONObject r11, IGetExtendParams r12) {
        this.B = true;
        e5.a.e().g(new a(this, r10, r11, r12), PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);
        return true;
    }

    public final void y() {
        SharedPreferences r10 = u();
        String r11 = r10.getString(SlardarConfigConsts.MONITOR_NET_CONFIG, null);
        this.f7574e = r10.getLong(SlardarConfigConsts.MONITOR_CONFIG_REFRESH_TIME, 0);
        if (r10.getInt("monitor_config_update", 0) != 1) goto L5;
        boolean r12 = true;
    L6:
        e5.a.e().d(this);
        if (TextUtils.isEmpty(r11) == false) goto L16;
    L14:
        S(false);
        return;
    L16:
        this.C = true;     // Catch: Exception -> L13
        JSONObject r13 = new JSONObject(r11);     // Catch: Exception -> L13
        if (r12 == true) goto L11;
        r13.remove("report_host_new");     // Catch: Exception -> L13
    L11:
        R(r13);     // Catch: Exception -> L13
    L13:
        Log.e(SlardarConfigConsts.MONITOR_CONFIG, "config error");
        goto L14
    L5:
        r12 = false;
        goto L6
    }

    public final void z() {
        LogLib.a(new d(this));
    }
}
