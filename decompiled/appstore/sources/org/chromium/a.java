package org.chromium;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.bytedance.ttnet.TTNetInit;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import java.net.CookieHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class a extends TTAppInfoProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f23034c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTAppInfoProvider.AppInfo f23035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f23036b;

    public a(Context r10) {
        this.f23036b = r10.getApplicationContext();
    }

    public static a c(Context r10) {
        if (f23034c != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f23034c != null) goto L11;
        f23034c = new a(r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f23034c;
    }

    @Override // com.ttnet.org.chromium.net.TTAppInfoProvider
    public TTAppInfoProvider.AppInfo a() {
        monitor-enter(a.class);     // Catch: Throwable -> L13
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L5:
        if (this.f23035a != null) goto L9;
        this.f23035a = new TTAppInfoProvider.AppInfo();     // Catch: Throwable -> L7
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L7
        this.f23035a.b(c.N().c());     // Catch: Throwable -> L13
        this.f23035a.c(c.N().d());     // Catch: Throwable -> L13
        this.f23035a.y(c.N().z());     // Catch: Throwable -> L13
        this.f23035a.z(c.N().A());     // Catch: Throwable -> L13
        this.f23035a.e(c.N().g());     // Catch: Throwable -> L13
        this.f23035a.g(c.N().k());     // Catch: Throwable -> L13
        if (f.f(this.f23036b) == false) goto L15;
        this.f23035a.s("1");     // Catch: Throwable -> L13
    L16:
        this.f23035a.a(c.N().b());     // Catch: Throwable -> L13
        this.f23035a.i(c.N().m());     // Catch: Throwable -> L13
        this.f23035a.j(c.N().n());     // Catch: Throwable -> L13
        this.f23035a.f(c.N().j());     // Catch: Throwable -> L13
        this.f23035a.h(c.N().l());     // Catch: Throwable -> L13
        this.f23035a.u(c.N().s());     // Catch: Throwable -> L13
        this.f23035a.v(c.N().t());     // Catch: Throwable -> L13
        this.f23035a.w(c.N().u());     // Catch: Throwable -> L13
        this.f23035a.G(c.N().J());     // Catch: Throwable -> L13
        this.f23035a.H(c.N().K());     // Catch: Throwable -> L13
        this.f23035a.I(c.N().L());     // Catch: Throwable -> L13
        this.f23035a.F(c.N().I());     // Catch: Throwable -> L13
        this.f23035a.t(c.N().r());     // Catch: Throwable -> L13
        this.f23035a.A(c.N().B());     // Catch: Throwable -> L13
        this.f23035a.x(c.N().y());     // Catch: Throwable -> L13
        this.f23035a.B(c.N().E());     // Catch: Throwable -> L13
        this.f23035a.d(c.N().f());     // Catch: Throwable -> L13
        this.f23035a.C(c.N().F());     // Catch: Throwable -> L13
        this.f23035a.r(c.N().q());     // Catch: Throwable -> L13
        Map r10 = c.N().p();     // Catch: Throwable -> L13
        if (r10 != null) goto L19;
    L21:
        Map r11 = c.N().G();     // Catch: Throwable -> L13
        String r12 = "";
        if (r11 != null) goto L24;
    L29:
        String r13 = b((String) r10.get("first"));     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r13) == true) goto L32;
        r12 = "Cookie:" + r13 + "\r\n" + r12;     // Catch: Throwable -> L13
    L32:
        this.f23035a.D(r12);     // Catch: Throwable -> L13
        Map r14 = c.N().H();     // Catch: Throwable -> L13
        String r15 = "";
        if (r14 != null) goto L35;
    L40:
        this.f23035a.E(r15);     // Catch: Throwable -> L13
        if (d.a().loggerDebug() == false) goto L48;
        String r16 = "AppInfo{, mUserId='" + this.f23035a.getUserId() + "', mAppId='" + this.f23035a.getAppId() + "', mOSApi='" + this.f23035a.getOSApi() + "', mDeviceId='" + this.f23035a.getDeviceId() + "', mNetAccessType='" + this.f23035a.getNetAccessType() + "', mVersionCode='" + this.f23035a.getVersionCode() + "', mDeviceType='" + this.f23035a.getDeviceType() + "', mAppName='" + this.f23035a.getAppName() + "', mSdkAppID='" + this.f23035a.getSdkAppID() + "', mSdkVersion='" + this.f23035a.getSdkVersion() + "', mChannel='" + this.f23035a.getChannel() + "', mOSVersion='" + this.f23035a.getOSVersion() + "', mAbi='" + this.f23035a.getAbi() + "', mDevicePlatform='" + this.f23035a.getDevicePlatform() + "', mDeviceBrand='" + this.f23035a.getDeviceBrand() + "', mDeviceModel='" + this.f23035a.getDeviceModel() + "', mVersionName='" + this.f23035a.getVersionName() + "', mUpdateVersionCode='" + this.f23035a.getUpdateVersionCode() + "', mManifestVersionCode='" + this.f23035a.getManifestVersionCode() + "', mHostFirst='" + this.f23035a.getHostFirst() + "', mHostSecond='" + this.f23035a.getHostSecond() + "', mHostThird='" + this.f23035a.getHostThird() + "', mDomainHttpDns='" + this.f23035a.getDomainHttpDns() + "', mDomainNetlog='" + this.f23035a.getDomainNetlog() + "', mDomainBoe='" + this.f23035a.getDomainBoe() + "'}";     // Catch: Throwable -> L13
        d.a().loggerD("CronetAppInfoProvider", "get appinfo = " + r16);     // Catch: Throwable -> L13
    L48:
        return this.f23035a;
    L35:
        if (r14.isEmpty() == true) goto L40;
        Iterator r17 = r14.entrySet().iterator();     // Catch: Throwable -> L13
    L38:
        if (r17.hasNext() == false) goto L40;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L13
        r15 = ((String) r18.getKey()) + ":" + ((String) r18.getValue()) + "\r\n" + r15;     // Catch: Throwable -> L13
        goto L38
    L24:
        if (r11.isEmpty() == true) goto L29;
        Iterator r19 = r11.entrySet().iterator();     // Catch: Throwable -> L13
    L27:
        if (r19.hasNext() == false) goto L29;
        Map.Entry r20 = (Map.Entry) r19.next();     // Catch: Throwable -> L13
        r12 = ((String) r20.getKey()) + ":" + ((String) r20.getValue()) + "\r\n" + r12;     // Catch: Throwable -> L13
        goto L27
    L19:
        if (r10.isEmpty() == true) goto L21;
        this.f23035a.o((String) r10.get("first"));     // Catch: Throwable -> L13
        this.f23035a.p((String) r10.get("second"));     // Catch: Throwable -> L13
        this.f23035a.q((String) r10.get("third"));     // Catch: Throwable -> L13
        this.f23035a.m((String) r10.get("httpdns"));     // Catch: Throwable -> L13
        this.f23035a.n((String) r10.get(TTNetInit.DOMAIN_NETLOG_KEY));     // Catch: Throwable -> L13
        this.f23035a.k((String) r10.get(TTNetInit.DOMAIN_BOE_KEY));     // Catch: Throwable -> L13
        this.f23035a.l((String) r10.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY));     // Catch: Throwable -> L13
        goto L21
    L15:
        this.f23035a.s(AdReportParam.ClickPosType.SKIP);     // Catch: Throwable -> L13
        goto L16
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L48
    }

    public final String b(String r10) {
        CookieHandler r11 = CookieHandler.getDefault();
        if (TextUtils.isEmpty(r10) == true) goto L26;
        if (r11 == null) goto L26;
        Map<String, List<String>> r12 = r11.get(g.a("https://" + r10), null);     // Catch: Throwable -> L27
        if (r12 == null) goto L26;
        if (r12.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r13 = r12.entrySet().iterator();     // Catch: Throwable -> L27
    L12:
        if (r13.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r14 = r13.next();     // Catch: Throwable -> L27
        if ("Cookie".equalsIgnoreCase(r14.getKey()) == false) goto L12;
        if (r14.getValue().isEmpty() == true) goto L12;
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L27
        Iterator<String> r16 = r14.getValue().iterator();     // Catch: Throwable -> L27
        int r17 = 0;
    L19:
        if (r16.hasNext() == false) goto L24;
        String r18 = r16.next();     // Catch: Throwable -> L27
        if (r17 <= 0) goto L23;
        r15.append("; ");     // Catch: Throwable -> L27
    L23:
        r15.append(r18);     // Catch: Throwable -> L27
        r17 = r17 + 1;     // Catch: Throwable -> L27
        goto L19
    L24:
        return r15.toString();
    L26:
        return null;
    }
}
