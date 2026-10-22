package org.chromium;

import com.ttnet.org.chromium.base.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f23038b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f23039a;

    public c() {
    }

    public static c N() {
        if (f23038b != null) goto L16;
        monitor-enter(c.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f23038b != null) goto L11;
        f23038b = new c();     // Catch: Throwable -> L9
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L16:
        return f23038b;
    }

    public String A() {
        return D("getSdkVersion");
    }

    public String B() {
        return D("getStoreIdc");
    }

    public String C() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (String) m.i(r10).b("getStoreIdcRuleJSON").f();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final String D(String r10) {
        Object r11 = this.f23039a;     // Catch: Throwable -> L8
        if (r11 != null) goto L6;
        return "";
    L6:
        return (String) m.i(r11).b(r10).f();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public String E() {
        return D("getSysRegion");
    }

    public String F() {
        return D("getTNCRequestFlags");
    }

    public Map G() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (Map) m.i(r10).b("getTNCRequestHeader").f();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public Map H() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (Map) m.i(r10).b("getTNCRequestQuery").f();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String I() {
        return D("getUpdateVersionCode");
    }

    public String J() {
        return D("getUserId");
    }

    public String K() {
        return D("getVersionCode");
    }

    public String L() {
        return D("getVersionName");
    }

    public void M(boolean r25, String r26, String r27, String r28, long r29, long r31, long r33, long r35, long r37, long r39, long r41, long r43, long r45, long r47, boolean r49, long r50, long r52, String r54, String r55, String r56, int r57, int r58, String r59) {
        if (d.a().loggerDebug() == false) goto L17;
        d.a().loggerD("CronetAppProviderManager", "handleApiResult ");
    L17:
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (this.f23039a != null) goto L8;
        return;
    L8:
        if (r25 == true) goto L12;
        IOException r10 = f.h(f.a(r57, r58, r59));     // Catch: Throwable -> L10
    L13:
        m r11 = m.i(this.f23039a);     // Catch: Throwable -> L10
        Class r17 = Boolean.TYPE;     // Catch: Throwable -> L10
        Class r20 = Long.TYPE;     // Catch: Throwable -> L10
        r11.c("handleApiResult", new Class[]{r17, String.class, String.class, String.class, r20, r20, r20, r20, r20, r20, r20, r20, r20, r20, r17, r20, r20, r20, String.class, String.class, Exception.class}, new Object[]{Boolean.valueOf(r25), r26, r27, r28, Long.valueOf(r29), Long.valueOf(r31), Long.valueOf(r33), Long.valueOf(r35), Long.valueOf(r37), Long.valueOf(r39), Long.valueOf(r41), Long.valueOf(r43), Long.valueOf(r45), Long.valueOf(r47), Boolean.valueOf(r49), Long.valueOf(r50), Long.valueOf(r52), r54, r55, r56, r10});     // Catch: Throwable -> L10
        return;
    L12:
        r10 = null;
        goto L13
    }

    public boolean O() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return false;
    L6:
        return ((Boolean) m.i(r10).b("isBOEProxyEnabled").f()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean P() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return false;
    L6:
        return ((Boolean) m.i(r10).b("isEnableBrotli").f()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean Q() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return false;
    L6:
        return ((Boolean) m.i(r10).b("isEnableHttp2").f()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean R() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return false;
    L6:
        return ((Boolean) m.i(r10).b("isEnableQuic").f()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean S() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return false;
    L6:
        return ((Boolean) m.i(r10).b("needCustomLoadLibrary").f()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public Map T(String r10, Map r11) {
        if (d.a().loggerDebug() == false) goto L14;
        d.a().loggerD("CronetAppProviderManager", "onCallToAddSecurityFactor info url = " + r10);
    L14:
        Object r12 = this.f23039a;     // Catch: Throwable -> L11
        if (r12 != null) goto L9;
        return null;
    L9:
        return (Map) m.i(r12).c("onCallToAddSecurityFactor", new Class[]{String.class, Map.class}, new Object[]{r10, r11}).f();
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void U(String r10) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onClientIPChanged ");
    L13:
        Object r11 = this.f23039a;     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        return;
    L8:
        m.i(r11).c("onClientIPChanged", new Class[]{String.class}, new Object[]{r10});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void V() {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onColdStartFinish ");
    L13:
        Object r10 = this.f23039a;     // Catch: Throwable -> L10
        if (r10 != null) goto L8;
        return;
    L8:
        m.i(r10).b("onColdStartFinish");     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void W() {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onCronetBootSucceed ");
    L13:
        Object r10 = this.f23039a;     // Catch: Throwable -> L10
        if (r10 != null) goto L8;
        return;
    L8:
        m.i(r10).b("onCronetBootSucceed");     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void X(int r10) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onEffectiveConnectionTypeChanged type = " + r10);
    L13:
        Object r11 = this.f23039a;     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        return;
    L8:
        m.i(r11).c("onEffectiveConnectionTypeChanged", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r10)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void Y(String r10, int r11) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onMappingRequestStatus key = " + r10 + " status = " + r11);
    L13:
        Object r12 = this.f23039a;     // Catch: Throwable -> L10
        if (r12 != null) goto L8;
        return;
    L8:
        m.i(r12).c("onMappingRequestStatus", new Class[]{String.class, Integer.TYPE}, new Object[]{r10, Integer.valueOf(r11)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void Z(int r10, int r11) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onMultiNetworkStateChanged, prev state = " + r10 + ", curr state = " + r11);
    L13:
        Object r12 = this.f23039a;     // Catch: Throwable -> L10
        if (r12 != null) goto L8;
        return;
    L8:
        m r13 = m.i(r12);     // Catch: Throwable -> L10
        Class r14 = Integer.TYPE;     // Catch: Throwable -> L10
        r13.c("onMultiNetworkStateChanged", new Class[]{r14, r14}, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)}).f();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void a(String r10) {
        Object r11 = this.f23039a;     // Catch: Throwable -> L7
        if (r11 != null) goto L5;
        return;
    L5:
        m.i(r11).c("doLoadLibrary", new Class[]{String.class}, new Object[]{r10});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public void a0(int r10) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityLevelChanged, nql: " + r10);
    L13:
        Object r11 = this.f23039a;     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        return;
    L8:
        m.i(r11).c("onNetworkQualityLevelChanged", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r10)}).f();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String b() {
        return D("getAbi");
    }

    public void b0(int r10, int r11, int r12) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityRttAndThroughputNotified, effectiveHrttMs: " + r10 + ", effectiveTrttMs: " + r11 + ", effectiveRxThroughputKbps: " + r12);
    L13:
        Object r13 = this.f23039a;     // Catch: Throwable -> L10
        if (r13 != null) goto L8;
        return;
    L8:
        m r14 = m.i(r13);     // Catch: Throwable -> L10
        Class r15 = Integer.TYPE;     // Catch: Throwable -> L10
        r14.c("onNetworkQualityRttAndThroughputNotified", new Class[]{r15, r15, r15}, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12)}).f();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String c() {
        return D("getAppId");
    }

    public void c0(int r10, double r11, double r12, double r13, double r14) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onPacketLossComputed protocol = " + r10 + ", upstreamLossRate = " + r11 + ", upstreamLossRateVariance = " + r12 + ", downstreamLossRate = " + r13 + ", downstreamLossRateVariance = " + r14);
    L13:
        Object r15 = this.f23039a;     // Catch: Throwable -> L10
        if (r15 != null) goto L8;
        return;
    L8:
        m r16 = m.i(r15);     // Catch: Throwable -> L10
        Class r17 = Integer.TYPE;     // Catch: Throwable -> L10
        Class r18 = Double.TYPE;     // Catch: Throwable -> L10
        r16.c("onPacketLossComputed", new Class[]{r17, r18, r18, r18, r18}, new Object[]{Integer.valueOf(r10), Double.valueOf(r11), Double.valueOf(r12), Double.valueOf(r13), Double.valueOf(r14)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String d() {
        return D("getAppName");
    }

    public void d0(List r10, List r11) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onPublicIPsChanged ");
    L13:
        Object r12 = this.f23039a;     // Catch: Throwable -> L10
        if (r12 != null) goto L8;
        return;
    L8:
        m.i(r12).c("onPublicIPsChanged", new Class[]{List.class, List.class}, new Object[]{r10, r11});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String e() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (String) m.i(r10).b("getBypassBOEJSON").f();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void e0(int r10, int r11, int r12) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onRTTOrThroughputEstimatesComputed httpRtt = " + r10 + ", transportRttMs = " + r11 + ",downstreamThroughputKbps = " + r12);
    L13:
        Object r13 = this.f23039a;     // Catch: Throwable -> L10
        if (r13 != null) goto L8;
        return;
    L8:
        m r14 = m.i(r13);     // Catch: Throwable -> L10
        Class r15 = Integer.TYPE;     // Catch: Throwable -> L10
        r14.c("onRTTOrThroughputEstimatesComputed", new Class[]{r15, r15, r15}, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String f() {
        return D("getCarrierRegion");
    }

    public void f0(String r10, String r11, String r12) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onServerConfigUpdated json = " + r10);
    L13:
        Object r13 = this.f23039a;     // Catch: Throwable -> L10
        if (r13 != null) goto L8;
        return;
    L8:
        m.i(r13).c("onServerConfigEtagChanged", new Class[]{String.class}, new Object[]{r11});     // Catch: Throwable -> L10
        m.i(this.f23039a).c("onServerConfigABTestChanged", new Class[]{String.class}, new Object[]{r12});     // Catch: Throwable -> L10
        m.i(this.f23039a).c("onServerConfigUpdated", new Class[]{String.class}, new Object[]{r10});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String g() {
        return D("getChannel");
    }

    public void g0(String r10, String r11, String r12) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onStoreIdcChanged ");
    L13:
        Object r13 = this.f23039a;     // Catch: Throwable -> L10
        if (r13 != null) goto L8;
        return;
    L8:
        m.i(r13).c("onStoreIdcChanged", new Class[]{String.class, String.class, String.class}, new Object[]{r10, r11, r12});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public Map h() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (Map) m.i(r10).b("getClientOpaqueData").f();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void h0(String[] r10, String r11) {
        if (d.a().loggerDebug() == false) goto L21;
        d.a().loggerD("CronetAppProviderManager", "onTNCUpdateFailed ");
    L21:
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (this.f23039a == null) goto L18;
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.length <= 0) goto L25;
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L14
        int r13 = r10.length;     // Catch: Throwable -> L14
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L16;
        r12.add(r10[r14]);     // Catch: Throwable -> L14
        r14 = r14 + 1;     // Catch: Throwable -> L14
        goto L12
    L16:
        m.i(this.f23039a).c("onTNCUpdateFailed", new Class[]{ArrayList.class, String.class}, new Object[]{r12, r11});     // Catch: Throwable -> L14
        return;
    L25:
        return;
    }

    public String i() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (String) m.i(r10).b("getCronetSoPath").f();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void i0(String r13, String r14, int r15, int r16, int r17, List r18, String r19) {
        if (d.a().loggerDebug() == false) goto L15;
        d.a().loggerD("CronetAppProviderManager", "onTTDnsResolveResult info uuid = " + r13 + " host: " + r14);
    L15:
        Object r10 = this.f23039a;     // Catch: Throwable -> L12
        if (r10 != null) goto L10;
        return;
    L10:
        m r11 = m.i(r10);     // Catch: Throwable -> L12
        Class r12 = Integer.TYPE;     // Catch: Throwable -> L12
        r11.c("onTTDnsResolveResult", new Class[]{String.class, String.class, r12, r12, r12, List.class, String.class}, new Object[]{r13, r14, Integer.valueOf(r15), Integer.valueOf(r16), Integer.valueOf(r17), r18, r19});     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
    }

    public String j() {
        return D("getDeviceBrand");
    }

    public void j0(String r10) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onTTNetDetectInfoChanged info str = " + r10);
    L13:
        Object r11 = this.f23039a;     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        return;
    L8:
        m.i(r11).c("onTTNetDetectInfoChanged", new Class[]{String.class}, new Object[]{r10});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String k() {
        return D("getDeviceId");
    }

    public void k0(String r10, String r11) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "Send monitor json = " + r10 + ", log type =" + r11);
    L13:
        Object r12 = this.f23039a;     // Catch: Throwable -> L10
        if (r12 != null) goto L8;
        return;
    L8:
        m.i(r12).c("sendAppMonitorEvent", new Class[]{String.class, String.class}, new Object[]{r10, r11});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String l() {
        return D("getDeviceModel");
    }

    public void l0(Object r10) {
        if (r10 == null) goto L29;
        List r11 = f.b(r10.getClass());     // Catch: Throwable -> L16
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.isEmpty() == true) goto L28;
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L16
    L10:
        if (r12.hasNext() == false) goto L31;
        if ("com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider".equals(((Class) r12.next()).getName()) == false) goto L10;
        if (d.a().loggerDebug() == false) goto L18;
        d.a().loggerD("CronetAppProviderManager", "inject CronetAppProviderManager success");     // Catch: Throwable -> L16
    L18:
        this.f23039a = r10;     // Catch: Throwable -> L16
        return;
    L31:
        return;
    L28:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public String m() {
        return D("getDevicePlatform");
    }

    public String n() {
        return D("getDeviceType");
    }

    public String o() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (String) m.i(r10).b("getGetDomainDefaultJSON").f();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public Map p() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L6
        if (r10 != null) goto L9;
        return Collections.emptyMap();
    L9:
        return (Map) m.i(r10).b("getGetDomainDependHostMap").f();
    L6:
        th = move-exception;
        th.printStackTrace();
        return Collections.emptyMap();
    }

    public String q() {
        return D("getHttpDnsRequestFlags");
    }

    public String r() {
        return D("getManifestVersionCode");
    }

    public String s() {
        return D("getNetAccessType");
    }

    public String t() {
        return D("getOSApi");
    }

    public String u() {
        return D("getOSVersion");
    }

    public ArrayList v() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (ArrayList) m.i(r10).b("getOpaqueData").f();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public int w() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return 0;
    L6:
        return ((Integer) m.i(r10).b("getProcessFlag").f()).intValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public Map x() {
        Object r10 = this.f23039a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (Map) m.i(r10).b("getQuicHint").f();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String y() {
        return D("getRegion");
    }

    public String z() {
        return D("getSdkAppId");
    }
}
