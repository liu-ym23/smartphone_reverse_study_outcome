package com.obric.aiagent.ttnet;

import android.app.Application;
import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import androidx.lifecycle.v;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.bdinstall.ar;
import com.bytedance.compression.zstd.Zstd;
import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.TTWiFiCellSwitcher;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.n;
import d.s;
import d.x;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTNetExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f22239a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f22240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, String> f22241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<b> f22242d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f22243e;
    private static boolean f;

    /* JADX INFO: compiled from: TTNetExt.kt */
    public static final class a implements com.bytedance.frameworks.baselib.network.http.g.d<com.bytedance.ttnet.d.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22244a = null;

        static {
            f22244a = new a();
        }

        @Override // com.bytedance.frameworks.baselib.network.http.g.d
        public String a(String r1, boolean r2, Object... r3) {
            o.e(r1, "url");
            o.e(r3, "extra");
            return r1;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.g.d
        public Map<String, String> a(int r1) {
            return null;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.g.d
        public void a() {
        }

        private a() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.g.d
        public String a(String r4, boolean r5) {
            o.e(r4, "url");
            a(r4);
            IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L11;
            com.bytedance.applog.h r6 = r3.inst();
            if (r6 == null) goto L12;
            String r7 = r6.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, r5, ar.f6145b);
            if (r7 != null) goto L10;
            return r4;
        L10:
            return r7;
        L12:
            return r4;
        L11:
            return r4;
        }

        public final synchronized void a(String r10) {
            monitor-enter(this);
            o.e(r10, "url");     // Catch: Throwable -> L74
            monitor-enter(this);     // Catch: Throwable -> L74
            IAppLog r0 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
            String r1 = null;
            if (r0 == null) goto L10;
            com.bytedance.applog.h r2 = r0.inst();     // Catch: Throwable -> L71
            if (r2 == null) goto L10;
            String r3 = r2.l();     // Catch: Throwable -> L71
        L11:
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
            if (r4 != null) goto L14;
        L17:
            boolean r5 = true;
        L18:
            if (r5 == false) goto L67;
            ILogDepend.Companion r6 = ILogDepend.Companion;     // Catch: Throwable -> L71
            StringBuilder r7 = new StringBuilder().append("waitDidandBDAccountCallback, did:");     // Catch: Throwable -> L71
            IAppLog r8 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
            if (r8 == null) goto L24;
            com.bytedance.applog.h r9 = r8.inst();     // Catch: Throwable -> L71
            if (r9 == null) goto L24;
            String r11 = r9.l();     // Catch: Throwable -> L71
        L25:
            StringBuilder r12 = r7.append(r11).append(" callback:");     // Catch: Throwable -> L71
            IAppLog r13 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
            if (r13 == null) goto L30;
            com.bytedance.applog.h r14 = r13.inst();     // Catch: Throwable -> L71
            if (r14 == null) goto L30;
            IBDAccountCallback r15 = r14.w();     // Catch: Throwable -> L71
        L31:
            r6.d("ApiProcessHook", r12.append(r15).toString());     // Catch: Throwable -> L71
            ILogDepend.Companion.e("ApiProcessHook", "No did, wait it, url = " + r10);     // Catch: Throwable -> L71
            n.a r16 = n.f38560a;     // Catch: Throwable -> L65
            int r17 = 0;
        L34:
            IAppLog r18 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
            if (r18 == null) goto L39;
            com.bytedance.applog.h r19 = r18.inst();     // Catch: Throwable -> L65
            if (r19 == null) goto L39;
            String r20 = r19.l();     // Catch: Throwable -> L65
        L40:
            CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
            if (r21 != null) goto L43;
        L46:
            boolean r22 = true;
        L47:
            if (r22 == true) goto L56;
            IAppLog r23 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
            if (r23 == null) goto L53;
            com.bytedance.applog.h r24 = r23.inst();     // Catch: Throwable -> L65
            if (r24 == null) goto L53;
            IBDAccountCallback r25 = r24.w();     // Catch: Throwable -> L65
        L54:
            if (r25 == null) goto L56;
        L58:
            ILogDepend.Companion r26 = ILogDepend.Companion;     // Catch: Throwable -> L65
            StringBuilder r27 = new StringBuilder().append(r17).append(" ms later, get did ");     // Catch: Throwable -> L65
            IAppLog r28 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
            if (r28 == null) goto L63;
            com.bytedance.applog.h r29 = r28.inst();     // Catch: Throwable -> L65
            if (r29 == null) goto L63;
            r1 = r29.l();     // Catch: Throwable -> L65
        L63:
            r26.i("ApiProcessHook", r27.append(r1).append(",url = ").append(r10).toString());     // Catch: Throwable -> L65
            n.f(x.f38692a);     // Catch: Throwable -> L65
        L53:
            r25 = null;
        L56:
            if (r17 >= 5000) goto L58;
            r17 = r17 + 50;     // Catch: Throwable -> L65
            Thread.sleep(50);     // Catch: Throwable -> L65
            goto L34
        L43:
            if (r21.length() == 0) goto L46;
            r22 = false;
        L39:
            r20 = null;
        L65:
            th = move-exception;
            n.a r30 = n.f38560a;     // Catch: Throwable -> L71
            n.f(d.o.a(th));     // Catch: Throwable -> L71
        L30:
            r15 = null;
        L24:
            r11 = null;
        L67:
            x r110 = x.f38692a;     // Catch: Throwable -> L71
            monitor-exit(this);     // Catch: Throwable -> L74
            monitor-exit(this);
            return;
        L14:
            if (r4.length() == 0) goto L17;
            r5 = false;
        L10:
            r3 = null;
        L71:
            th = move-exception;
            throw th;     // Catch: Throwable -> L74
        L74:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: TTNetExt.kt */
    public interface b {
        void a(int r1);
    }

    /* JADX INFO: compiled from: TTNetExt.kt */
    public static final class c extends com.bytedance.ttnet.b.a {
        private static final String TAG = "CronetDependAdapter";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f22245a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static long f22246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static long f22247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final v<Integer> f22248d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final a f22249e = null;

        /* JADX INFO: compiled from: TTNetExt.kt */
        public static final class a implements TTWiFiCellSwitcher.b {
            a() {
            }

            @Override // com.bytedance.ttnet.TTWiFiCellSwitcher.b
            public void a(TTWiFiCellSwitcher.d r8, TTWiFiCellSwitcher.d r9) {
                o.e(r8, "previousState");
                o.e(r9, "currentState");
                c.f22245a.a().a(Integer.valueOf(r9.a()));
                if (r8 != TTWiFiCellSwitcher.d.i) goto L8;
                ILogDepend.Companion.d(c.TAG, "auto 4G state end");
                IAppLog r7 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
                if (r7 == null) goto L8;
                r7.report("flow_network_auto_4g_end", androidx.core.os.e.a(new d.m[]{s.a("duration", Long.valueOf((SystemClock.elapsedRealtime() - c.b()) / ((long) 1000))), s.a("data_size", Long.valueOf((c.a(c.f22245a) - c.c()) / ((long) 1024)))}));
            L8:
                if (r9 != TTWiFiCellSwitcher.d.h) goto L11;
                ILogDepend.Companion.d(c.TAG, "wifi is weak, ready for 4G");
                TTWiFiCellSwitcher.inst().triggerSwitchingToNetwork(TTWiFiCellSwitcher.a.f11237b);
                return;
            L11:
                if (r9 != TTWiFiCellSwitcher.d.i) goto L16;
                ILogDepend.Companion.d(c.TAG, "switch to 4G success");
                c r10 = c.f22245a;
                c.a(SystemClock.elapsedRealtime());
                c r11 = c.f22245a;
                c.b(c.a(c.f22245a));
                IAppLog r12 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
                if (r12 == null) goto L20;
                r12.report("flow_network_auto_4g_start", androidx.core.os.e.a());
                return;
            L20:
                return;
            L16:
                if (r9 != TTWiFiCellSwitcher.d.k) goto L22;
                ILogDepend.Companion.d(c.TAG, "ready switch back to WiFi");
                TTWiFiCellSwitcher.inst().triggerSwitchingToNetwork(TTWiFiCellSwitcher.a.f11236a);
                return;
            }
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public void doLoadLibrary(String r1) {
            o.e(r1, "s");
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getGetDomainDefaultJSON() {
            return "{    \"data\":{        \"chromium_open\":1,        \"opaque_data_enabled\":1,        \"ttnet_h2_enabled\":1,        \"ttnet_http_dns_enabled\":1,        \"ttnet_http_dns_google\":1,        \"ttnet_http_dns_prefer\":0,        \"ttnet_http_dns_timeout\":5,        \"ttnet_local_dns_time_out\":5,        \"ttnet_quic_enabled\":1,        \"ttnet_socket_config\":{            \"enable_ws_fast_connect\":1,            \"ws_reconnect_timeout\":900        },\n        \"ttnet_websocket_config\":{            \"enable_connection_attempts\":1        }    }}";
        }

        private c() {
        }

        public static final /* synthetic */ long a(c r2) {
            return r2.d();
        }

        public static final /* synthetic */ void a(long r0) {
            f22246b = r0;
        }

        public static final /* synthetic */ long b() {
            return f22246b;
        }

        public static final /* synthetic */ void b(long r0) {
            f22247c = r0;
        }

        public static final /* synthetic */ long c() {
            return f22247c;
        }

        static {
            f22245a = new c();
            f22248d = new v(Integer.valueOf(TTWiFiCellSwitcher.d.f11242b.a()));
            a r0 = new a();
            f22249e = r0;
            n.a r1 = n.f38560a;     // Catch: Throwable -> L5
            TTWiFiCellSwitcher.inst().registerObserver((TTWiFiCellSwitcher.b) ZeusTransformUtils.preCheckCast(r0, TTWiFiCellSwitcher.b.class, "com.obric.aiagent.plugin"), null);     // Catch: Throwable -> L5
            TTWiFiCellSwitcher.inst().start();     // Catch: Throwable -> L5
            n.f(x.f38692a);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            n.a r2 = n.f38560a;
            n.f(d.o.a(th));
        }

        public final v<Integer> a() {
            return f22248d;
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public void sendAppMonitorEvent(String r4, String r5) {
            o.e(r4, "logContent");
            o.e(r5, "logType");
        L8:
            th = move-exception;
            th.printStackTrace();
            return;
        L4:
            if (h.f22239a.d() == false) goto L6;
            ILogDepend.Companion.d(TAG, "Get monitor json = " + r4 + " logType = " + r5);     // Catch: Throwable -> L8
        L6:
            com.bytedance.apm.b.a(r5, new JSONObject(r4));     // Catch: Throwable -> L8
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public void onEffectiveConnectionTypeChanged(int r4) {
            ILogDepend.Companion.i(TAG, "[network status change] : type is " + r4);
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(h.f22239a.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.aiagent.plugin")).a(r4);
            goto L4
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
        public boolean loggerDebug() {
            if (IAppContext.Companion.isDebug() == false) goto L5;
        L10:
            boolean r3 = true;
        L11:
            ILogDepend.Companion.i(TAG, "ttnet debug " + r3);
            return r3;
        L5:
            if (IAppContext.Companion.isReleaseChannel() == false) goto L10;
            if (o.a(com.bytedance.watson.assist.d.e.a("persist.sys.ttnet_debug", "false"), "true") == true) goto L10;
            r3 = false;
            goto L11
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getIId() {
            return ITraceDepend.Companion.getInstallId();
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getDeviceId() {
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L5;
            String r3 = r2.getFlowDid();
        L6:
            if (r3 != null) goto L9;
            return "";
        L9:
            return r3;
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getUserId() {
            return ITraceDepend.Companion.getUserID();
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getAppId() {
            return String.valueOf(IAppContext.Companion.getAppId());
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getAppName() {
            return IAppContext.Companion.getAppName();
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getSdkAppId() {
            return String.valueOf(IAppContext.Companion.getAppId());
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getSdkVersion() {
            return IAppContext.Companion.getVersionName();
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getChannel() {
            return IAppContext.Companion.getBuildChannel();
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getVersionCode() {
            return String.valueOf(IAppContext.Companion.getVersionCode());
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getVersionName() {
            return IAppContext.Companion.getVersionName();
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getUpdateVersionCode() {
            return String.valueOf(IAppContext.Companion.getUpdateVersionCode());
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getManifestVersionCode() {
            return String.valueOf(IAppContext.Companion.getManifestVersionCode());
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getRegion() {
            String r1 = Locale.CHINA.getCountry();
            o.c(r1, "getCountry(...)");
            return r1;
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getSysRegion() {
            String r1 = Locale.CHINA.getCountry();
            o.c(r1, "getCountry(...)");
            return r1;
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getCarrierRegion() {
            String r0 = com.obric.aiagent.ttnet.b.a.f22203a.a();
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public String getLanguage() {
            String r1 = Locale.CHINA.getLanguage();
            o.c(r1, "getLanguage(...)");
            return r1;
        }

        @Override // com.bytedance.ttnet.b.a, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
        public ArrayList<byte[]> getOpaqueData() {
            if (h.f22239a.d() == false) goto L5;
        L8:
            ArrayList<byte[]> r3 = super.getOpaqueData();
        L9:
            com.obric.aiagent.ttnet.b.c r0 = com.obric.aiagent.ttnet.b.c.f22207a;
            StringBuilder r1 = new StringBuilder().append("getOpaqueData ").append(h.f22239a.d()).append(' ');
            if (r3 == null) goto L12;
            int r2 = r3.size();
        L13:
            r0.a("TTNetDependency", r1.append(r2).toString());
            return r3;
        L12:
            r2 = 0;
            goto L13
        L5:
            if (h.f22239a.c() == false) goto L8;
            r3 = com.obric.aiagent.ttnet.b.e.f22208a.a();
            goto L9
        }

        private final long d() {
            return TrafficStats.getUidRxBytes(Process.myUid()) + TrafficStats.getUidTxBytes(Process.myUid());
        }
    }

    /* JADX INFO: compiled from: TTNetExt.kt */
    public static final class d implements com.bytedance.frameworks.baselib.network.http.g.l<com.bytedance.ttnet.d.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f22250a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.obric.aiagent.ttnet.b.b f22251b = null;

        private d() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.g.l
        public /* synthetic */ void a(long r9, long r11, String r13, String r14, com.bytedance.frameworks.baselib.network.http.b r15) {
            a(r9, r11, r13, r14, (com.bytedance.ttnet.d.b) ZeusTransformUtils.preCheckCast(r15, com.bytedance.ttnet.d.b.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.bytedance.frameworks.baselib.network.http.g.l
        public /* synthetic */ void a(long r11, long r13, String r15, String r16, com.bytedance.frameworks.baselib.network.http.b r17, Throwable r18) {
            a(r11, r13, r15, r16, (com.bytedance.ttnet.d.b) ZeusTransformUtils.preCheckCast(r17, com.bytedance.ttnet.d.b.class, "com.obric.aiagent.plugin"), r18);
        }

        static {
            f22250a = new d();
            f22251b = new com.obric.aiagent.ttnet.b.b("api_trace");
        }

        private final boolean a(String r4) {
            return !d.o.o.b(r4, "https://log.snssdk.com", false, 2, null);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void a(long r18, long r20, String r22, String r23, com.bytedance.ttnet.d.b r24, Throwable r25) {
            String[] r12 = new String[1];     // Catch: Throwable -> L35
            int r13 = com.obric.aiagent.ttnet.b.d.a(r25, r12);     // Catch: Throwable -> L35
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L35
            if (r25 == null) goto L20;
            if (com.bytedance.common.utility.j.a(r25.getClass().getName()) == true) goto L20;
            r14.put("ex_name", r25.getClass().getName());     // Catch: Throwable -> L35
            if (r13 != 1) goto L12;
            if (ApmDelegate.a().a("ex_message_open") == false) goto L12;
        L13:
            String r1 = com.bytedance.ttnet.utils.e.a(r25);     // Catch: Throwable -> L35
            if (com.bytedance.common.utility.j.a(r1) == true) goto L16;
            r14.put("ex_message", r1);     // Catch: Throwable -> L35
        L16:
            String r2 = com.bytedance.ttnet.c.a();     // Catch: Throwable -> L35
            if (com.bytedance.common.utility.j.a(r2) == true) goto L20;
            r14.put("cronet_init_ex_message", r2);     // Catch: Throwable -> L35
        L12:
            if (ApmDelegate.a().a("debug_ex_message_open") == true) goto L13;
        L20:
            if (com.bytedance.common.utility.j.a(r12[0]) == false) goto L22;
            o.a(r24);     // Catch: Throwable -> L35
            r12[0] = r24.w;     // Catch: Throwable -> L35
        L22:
            a(r24, r14);     // Catch: Throwable -> L35
            com.bytedance.apm.b.b(r18, r20, r22, r12[0], r23, r13, r14);     // Catch: Throwable -> L35
            com.bytedance.apm.b.a(r18, r20, r22, r12[0], r23, r13, r14);     // Catch: Throwable -> L35
            if (r22 != null) goto L25;
        L28:
            f22251b.a("monitorApiError", r22 + ' ' + r20 + ' ' + r18 + ' ' + r12[0] + ' ' + r23 + ' ' + r13 + ' ' + r14);     // Catch: Throwable -> L35
        L29:
            com.obric.aiagent.ttnet.c.b.f22223a.b(Long.valueOf(r18), Long.valueOf(r20), r22, r12[0], r23, Integer.valueOf(r13), r14);     // Catch: Throwable -> L35
            com.obric.aiagent.ttnet.c.a r0 = com.obric.aiagent.ttnet.c.a.f22214a;     // Catch: Throwable -> L35
            Long r3 = Long.valueOf(r18);     // Catch: Throwable -> L35
            Long r4 = Long.valueOf(r20);     // Catch: Throwable -> L35
            String r5 = r12[0];     // Catch: Throwable -> L35
            Integer r6 = Integer.valueOf(r13);     // Catch: Throwable -> L35
            if (r24 == null) goto L32;
            String r7 = r24.f8134J;     // Catch: Throwable -> L35
        L33:
            r0.a(r3, r4, r22, r5, r23, r6, r14, r7);     // Catch: Throwable -> L35
            return;
        L32:
            r7 = null;
            goto L33
        L25:
            if (a(r22) == false) goto L29;
        }

        public void a(long r20, long r22, String r24, String r25, com.bytedance.ttnet.d.b r26) {
            n.a r0 = n.f38560a;     // Catch: Throwable -> L32
            if (r24 != null) goto L6;
        L7:
            if (r26 == null) goto L11;
            String r1 = r26.N;     // Catch: Throwable -> L32
            if (r1 == null) goto L11;
            JSONObject r2 = new JSONObject(r1);     // Catch: Throwable -> L32
        L12:
            if (r2 == null) goto L28;
            Iterator<String> r3 = r2.keys();     // Catch: Throwable -> L32
            if (r3 == null) goto L28;
        L16:
            if (r3.hasNext() == false) goto L28;
            String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
            o.a(r4);     // Catch: Throwable -> L32
            String r5 = r4.toLowerCase();     // Catch: Throwable -> L32
            o.c(r5, "toLowerCase(...)");     // Catch: Throwable -> L32
            if (o.a(r5, "x-tt-logid") == false) goto L16;
            String r6 = r2.optString(r4, "Unknown");     // Catch: Throwable -> L32
            f22251b.a("monitorApiOk", r24 + " logId=" + r6 + ' ' + r22 + ' ' + r20);     // Catch: Throwable -> L30
        L30:
            th = th;
        L34:
            n.a r7 = n.f38560a;
            n.f(d.o.a(th));
        L48:
            String[] r8 = new String[1];     // Catch: Throwable -> L45
            JSONObject r9 = new JSONObject();     // Catch: Throwable -> L45
            if (com.bytedance.common.utility.j.a(r8[0]) == false) goto L39;
            o.a(r26);     // Catch: Throwable -> L45
            r8[0] = r26.w;     // Catch: Throwable -> L45
        L39:
            a(r26, r9);     // Catch: Throwable -> L45
            com.bytedance.apm.b.a(r20, r22, r24, r8[0], r25, 200, r9);     // Catch: Throwable -> L45
            com.obric.aiagent.ttnet.c.b.f22223a.a(Long.valueOf(r20), Long.valueOf(r22), r24, r8[0], r25, 200, r9);     // Catch: Throwable -> L45
            com.obric.aiagent.ttnet.c.a r10 = com.obric.aiagent.ttnet.c.a.f22214a;     // Catch: Throwable -> L45
            Long r11 = Long.valueOf(r20);     // Catch: Throwable -> L45
            Long r12 = Long.valueOf(r22);     // Catch: Throwable -> L45
            String r13 = r8[0];     // Catch: Throwable -> L45
            if (r26 == null) goto L42;
            String r14 = r26.f8134J;     // Catch: Throwable -> L45
        L43:
            r10.b(r11, r12, r24, r13, r25, 200, r9, r14);     // Catch: Throwable -> L45
            return;
        L42:
            r14 = null;
        L56:
            return;
        L24:
            th = th;
        L28:
            n.f(x.f38692a);     // Catch: Throwable -> L30
        L11:
            r2 = null;
            goto L12
        L6:
            if (f22250a.a(r24) == false) goto L28;
        L32:
            th = th;
            goto L34
        }

        private final void a(com.bytedance.ttnet.d.b r3, JSONObject r4) {
            if (r3 == null) goto L18;
            if (r4 == null) goto L19;
            r4.put("cronet_plugin_install", TTNetInit.getTTNetDepend().a());     // Catch: JSONException -> L13
            r4.put("appLevelRequestStart", r3.f8139e);     // Catch: JSONException -> L13
            r4.put("beforeAllInterceptors", r3.f);     // Catch: JSONException -> L13
            r4.put("requestStart", r3.g);     // Catch: JSONException -> L13
            r4.put("responseBack", r3.h);     // Catch: JSONException -> L13
            r4.put("completeReadResponse", r3.i);     // Catch: JSONException -> L13
            r4.put("requestEnd", r3.j);     // Catch: JSONException -> L13
            r4.put("recycleCount", r3.C);     // Catch: JSONException -> L13
            if (r3.G != 0) goto L9;
            r4.put("timing_dns", r3.n);     // Catch: JSONException -> L13
            r4.put("timing_connect", r3.o);     // Catch: JSONException -> L13
            r4.put("timing_ssl", r3.p);     // Catch: JSONException -> L13
            r4.put("timing_send", r3.q);     // Catch: JSONException -> L13
            r4.put("timing_waiting", r3.s);     // Catch: JSONException -> L13
            r4.put("timing_receive", r3.t);     // Catch: JSONException -> L13
            r4.put("timing_total", r3.u);     // Catch: JSONException -> L13
            r4.put("timing_isSocketReused", r3.D);     // Catch: JSONException -> L13
            r4.put("timing_totalSendBytes", r3.x);     // Catch: JSONException -> L13
            r4.put("timing_totalReceivedBytes", r3.y);     // Catch: JSONException -> L13
            r4.put("timing_remoteIP", r3.w);     // Catch: JSONException -> L13
            r4.put(MonitorConstants.REQUEST_LOG, r3.f8134J);     // Catch: JSONException -> L13
            JSONObject r2 = new JSONObject();     // Catch: JSONException -> L13
            r2.put("retrofit", r3.f8138d.aE.b());     // Catch: JSONException -> L13
            r2.put("networklib", r3.f8138d.aF.a());     // Catch: JSONException -> L13
            r4.put("ttnet", r2);     // Catch: JSONException -> L13
        L9:
            if (r3.K == null) goto L11;
            r4.put("req_info", r3.K);     // Catch: JSONException -> L13
        L11:
            r4.put("streaming", r3.L);     // Catch: JSONException -> L13
            return;
        L13:
            e = move-exception;
            ILogDepend.Companion.w("MonitorProcessHook", "[packageRequestParamters] json op error. ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return;
        L19:
            return;
        }
    }

    /* JADX INFO: compiled from: TTNetExt.kt */
    public static final class e implements com.bytedance.ttnet.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f22252a = null;

        static {
            f22252a = new e();
        }

        @Override // com.bytedance.ttnet.d
        public int a(Context r1, String r2, int r3) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin"), "context");
            o.e(r2, "key");
            return 0;
        }

        @Override // com.bytedance.ttnet.d
        public String a(Context r2, String r3, String r4) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
            o.e(r3, "key");
            o.e(r4, "defaultValue");
            return "";
        }

        @Override // com.bytedance.ttnet.d
        public void a(Context r2, String r3, String r4, JSONObject r5) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
            o.e(r3, "eventName");
            o.e(r4, "labelName");
            o.e(r5, "extraJson");
        }

        @Override // com.bytedance.ttnet.d
        public void a(Context r2, Map<String, ?> r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
        }

        @Override // com.bytedance.ttnet.d
        public void a(Context r2, JSONObject r3) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
            o.e(r3, "ext_json");
        }

        @Override // com.bytedance.ttnet.d
        public void a(String r1) {
        }

        @Override // com.bytedance.ttnet.d
        public boolean a() {
            return true;
        }

        @Override // com.bytedance.ttnet.d
        public String[] b() {
            return new String[0];
        }

        @Override // com.bytedance.ttnet.d
        public String c() {
            return "snssdk.com";
        }

        @Override // com.bytedance.ttnet.d
        public String d() {
            return null;
        }

        @Override // com.bytedance.ttnet.d
        public void e() {
        }

        @Override // com.bytedance.ttnet.d
        public ArrayList<String> f() {
            return null;
        }

        private e() {
        }

        @Override // com.bytedance.ttnet.d
        public Context getContext() {
            return (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.ttnet.d
        public void a(String r1, JSONObject r2) {
            o.e(r1, "logType");
            o.e(r2, "json");
            com.bytedance.apm.b.a(r1, r2);
        }

        @Override // com.bytedance.ttnet.d
        public int g() {
            return IAppContext.Companion.getAppId();
        }

        @Override // com.bytedance.ttnet.d
        public Map<String, String> h() {
            return h.f22239a.a();
        }
    }

    /* JADX INFO: compiled from: TTNetExt.kt */
    public static final class f implements com.bytedance.frameworks.baselib.network.http.g.h {
        @Override // com.bytedance.frameworks.baselib.network.http.g.h
        public String a() {
            return "";
        }

        @Override // com.bytedance.frameworks.baselib.network.http.g.h
        public void a(List<String> r2) {
            o.e((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), "values");
        }

        f() {
        }
    }

    /* JADX INFO: compiled from: TTNetExt.kt */
    public static final class g implements com.bytedance.retrofit2.e.f.a {
        g() {
        }

        @Override // com.bytedance.retrofit2.e.f.a
        public byte[] a(byte[] r3, int r4) {
            o.e(r3, "src");
            return ZstdCompress.compress(r3, r4);
        L5:
            e = move-exception;
            ILogDepend.Companion.e(h.e(), "decompress error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        }
    }

    public static /* synthetic */ void lambda$Tmv0fU2DShF53zvm7CXnJe3UkOI() {
        g();
    }

    private h() {
    }

    public static final /* synthetic */ String e() {
        return TAG;
    }

    static {
        f22239a = new h();
        TAG = "TTNetExt";
        f22240b = new String[0];
        f22241c = ao.b();
        f22242d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        f22243e = true;
    }

    public final Map<String, String> a() {
        return f22241c;
    }

    public final List<b> b() {
        return f22242d;
    }

    public final boolean c() {
        return f22243e;
    }

    public final boolean d() {
        return f;
    }

    public final void a(com.obric.aiagent.ttnet.g r10) {
        o.e(r10, "config");
        f = r10.a();
        f22240b = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r10.b(), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        f22241c = r10.c();
        f22243e = r10.d();
        ILogDepend.Companion r9 = ILogDepend.Companion;
        String r11 = TAG;
        r9.i(r11, "init ttnet.");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L8
        org.chromium.d.a().setAdapter((ICronetDepend) ZeusTransformUtils.preCheckCast(c.f22245a, ICronetDepend.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        org.chromium.c.a().a(c.f22245a);     // Catch: Throwable -> L8
        TTNetInit.setTTNetDepend((com.bytedance.ttnet.d) ZeusTransformUtils.preCheckCast(e.f22252a, com.bytedance.ttnet.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        ILogDepend.Companion.i(r11, "setTTNetDepend success.");     // Catch: Throwable -> L8
        com.bytedance.frameworks.baselib.network.http.h.b.a(true);     // Catch: Throwable -> L8
        TTNetInit.setCronetDepend((ICronetAppProvider) ZeusTransformUtils.preCheckCast(c.f22245a, ICronetAppProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        TTNetInit.setBypassOfflineCheck(true);     // Catch: Throwable -> L8
        com.bytedance.frameworks.baselib.network.http.b.a.a();     // Catch: Throwable -> L8
        TTNetInit.tryInitTTNet((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), (com.bytedance.frameworks.baselib.network.http.g.d) ZeusTransformUtils.preCheckCast(a.f22244a, com.bytedance.frameworks.baselib.network.http.g.d.class, "com.obric.aiagent.plugin"), (com.bytedance.frameworks.baselib.network.http.g.l) ZeusTransformUtils.preCheckCast(d.f22250a, com.bytedance.frameworks.baselib.network.http.g.l.class, "com.obric.aiagent.plugin"), (com.bytedance.frameworks.baselib.network.http.g.h) ZeusTransformUtils.preCheckCast(new f(), com.bytedance.frameworks.baselib.network.http.g.h.class, "com.obric.aiagent.plugin"), true, new boolean[]{true});     // Catch: Throwable -> L8
        TTNetInit.preInitCronetKernel();     // Catch: Throwable -> L8
        com.bytedance.common.utility.a.c.a($$Lambda$h$Tmv0fU2DShF53zvm7CXnJe3UkOI.INSTANCE);     // Catch: Throwable -> L8
        if (com.obric.aiagent.product.a.a.f18769a.a() == true) goto L6;
        f22239a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L6:
        Object r12 = n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = n.c(r12);
        if (r13 == null) goto L14;
        ILogDepend.Companion.e("TTNetExt", "init error", r13);
    L14:
        com.bytedance.common.utility.g.a((com.bytedance.common.utility.g) ZeusTransformUtils.preCheckCast(new com.bytedance.article.common.network.a(), com.bytedance.common.utility.g.class, "com.obric.aiagent.plugin"));
        com.ttnet.org.chromium.net.urlconnection.g.a(true);
        return;
    L8:
        th = move-exception;
        n.a r0 = n.f38560a;
        r12 = n.f(d.o.a(th));
        goto L10
    }

    private static final void g() {
        f22239a.f();
    }

    private final void a(Context r11) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        String[] r3 = {com.obric.aiagent.product.a.a.f18769a.b()};
        android.security.a.a.a r12 = android.security.a.a.a.b();
        ILogDepend.Companion r0 = ILogDepend.Companion;
        String r4 = TAG;
        r0.i(r4, "setTLSAuth start.");
        List<X509Certificate> r1 = r12.a("SYSTEM_Device_TLS_cert");     // Catch: Throwable -> L21
        byte[] r5 = null;
        if (r1 == null) goto L6;
        X509Certificate r6 = (X509Certificate) ZeusTransformUtils.preCheckCast(p.l(r1), X509Certificate.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
    L7:
        if (r6 != null) goto L11;
        ILogDepend.Companion.w(r4, "setTLSAuth skipped: empty certChain");     // Catch: Throwable -> L21
        return;
    L11:
        if (r12.d("SYSTEM_Device_TLS_pkey") == false) goto L13;
        ILogDepend.Companion.i(r4, "setTLSAuth TLS_PRO_PKEY.");     // Catch: Throwable -> L21
        TTNetInit.addClientOpaqueDataV1(r2, r3, r6.getEncoded(), null, r12.a(), r12.c("SYSTEM_Device_TLS_pkey"));     // Catch: Throwable -> L21
        return;
    L13:
        ILogDepend.Companion.i(r4, "setTLSAuth not TLS_PRO_PKEY.");     // Catch: Throwable -> L21
        PrivateKey r10 = r12.b("SYSTEM_Device_TLS_pkey");     // Catch: Throwable -> L21
        if (r10 == null) goto L16;
        r5 = r10.getEncoded();     // Catch: Throwable -> L21
    L16:
        if (r5 != null) goto L19;
        ILogDepend.Companion.w(r4, "setTLSAuth skipped: empty privateKey");     // Catch: Throwable -> L21
        return;
    L19:
        TTNetInit.addClientOpaqueDataV1(r2, r3, r6.getEncoded(), r5);     // Catch: Throwable -> L21
        return;
    L6:
        r6 = null;
    L21:
        th = move-exception;
        th.printStackTrace();
    }

    private final void f() {
        long[] r0 = Zstd.getFunAddressesBySymbols(new String[]{"ZSTD_createDCtx", "ZSTD_decompressStream", "ZSTD_freeDCtx", "ZSTD_isError", "ZSTD_createDDict", "ZSTD_DCtx_refDDict", "ZSTD_freeDDict", "ZSTD_DCtx_reset"});
        if (r0 != null) goto L5;
    L26:
        com.bytedance.retrofit2.e.f.a((com.bytedance.retrofit2.e.f.a) ZeusTransformUtils.preCheckCast(new g(), com.bytedance.retrofit2.e.f.a.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (r0.length != 8) goto L26;
        if (r0[0] == 0) goto L26;
        if (r0[1] == 0) goto L26;
        if (r0[2] == 0) goto L26;
        if (r0[3] == 0) goto L26;
        if (r0[4] == 0) goto L26;
        if (r0[5] == 0) goto L26;
        if (r0[6] == 0) goto L26;
        if (r0[7] == 0) goto L26;
        TTNetInit.setZstdFuncAddr(r0[0], r0[1], r0[2], r0[3], r0[4], r0[5], r0[6], r0[7]);     // Catch: Exception -> L24
        ILogDepend.Companion.i(TAG, "initZstd Success");     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "init error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L26
    }
}
