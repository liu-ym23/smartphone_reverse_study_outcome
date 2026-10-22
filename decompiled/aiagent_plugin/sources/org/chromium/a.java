package org.chromium;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.i.j;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.CookieHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CronetAppInfoProvider.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends TTAppInfoProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f40522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TTAppInfoProvider.AppInfo f40523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f40524c;

    public static a a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f40522a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f40522a != null) goto L9;
        f40522a = new a(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f40522a;
    }

    private a(Context r3) {
        this.f40524c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    private String a(String r6) {
        CookieHandler r0 = CookieHandler.getDefault();
        if (TextUtils.isEmpty(r6) == true) goto L26;
        if (r0 == null) goto L26;
        Map<String, List<String>> r7 = r0.get(j.b("https://" + r6), null);     // Catch: Throwable -> L27
        if (r7 == null) goto L26;
        if (r7.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r8 = r7.entrySet().iterator();     // Catch: Throwable -> L27
    L12:
        if (r8.hasNext() == false) goto L26;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if ("Cookie".equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin")) == false) goto L12;
        if (((List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L12;
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L27
        int r2 = 0;
        Iterator r3 = ((List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L27
    L19:
        if (r3.hasNext() == false) goto L24;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r2 <= 0) goto L23;
        r9.append("; ");     // Catch: Throwable -> L27
    L23:
        r9.append(r4);     // Catch: Throwable -> L27
        r2 = r2 + 1;     // Catch: Throwable -> L27
        goto L19
    L24:
        return r9.toString();
    L26:
        return null;
    }

    private static String b(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return r1;
    L6:
        return r1.toLowerCase();
    }

    @Override // com.ttnet.org.chromium.net.TTAppInfoProvider
    public TTAppInfoProvider.AppInfo a() {
        monitor-enter(a.class);     // Catch: Throwable -> L64
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L5:
        if (this.f40523b != null) goto L7;
        this.f40523b = new TTAppInfoProvider.AppInfo();     // Catch: Throwable -> L61
    L7:
        monitor-exit(a.class);     // Catch: Throwable -> L61
        this.f40523b.b(c.a().e());     // Catch: Throwable -> L64
        this.f40523b.h(c.a().k());     // Catch: Throwable -> L64
        this.f40523b.i(c.a().l());     // Catch: Throwable -> L64
        this.f40523b.j(c.a().m());     // Catch: Throwable -> L64
        this.f40523b.k(c.a().n());     // Catch: Throwable -> L64
        this.f40523b.d(c.a().g());     // Catch: Throwable -> L64
        this.f40523b.z(c.a().S());     // Catch: Throwable -> L64
        this.f40523b.s(c.a().p());     // Catch: Throwable -> L64
        this.f40523b.m(c.a().q());     // Catch: Throwable -> L64
        this.f40523b.g(c.a().j());     // Catch: Throwable -> L64
        this.f40523b.n(c.a().r());     // Catch: Throwable -> L64
        this.f40523b.o(c.a().s());     // Catch: Throwable -> L64
        this.f40523b.e(c.a().h());     // Catch: Throwable -> L64
        this.f40523b.c(c.a().f());     // Catch: Throwable -> L64
        this.f40523b.l(c.a().o());     // Catch: Throwable -> L64
        this.f40523b.a(c.a().d());     // Catch: Throwable -> L64
        this.f40523b.f(c.a().i());     // Catch: Throwable -> L64
        this.f40523b.p(c.a().t());     // Catch: Throwable -> L64
        this.f40523b.q(c.a().u());     // Catch: Throwable -> L64
        this.f40523b.r(c.a().v());     // Catch: Throwable -> L64
        this.f40523b.A(c.a().w());     // Catch: Throwable -> L64
        this.f40523b.B(b(c.a().x()));     // Catch: Throwable -> L64
        this.f40523b.C(b(c.a().y()));     // Catch: Throwable -> L64
        this.f40523b.D(b(c.a().z()));     // Catch: Throwable -> L64
        this.f40523b.E(c.a().A());     // Catch: Throwable -> L64
        this.f40523b.H(c.a().B());     // Catch: Throwable -> L64
        this.f40523b.I(c.a().C());     // Catch: Throwable -> L64
        TTAppInfoProvider.AppInfo r0 = this.f40523b;     // Catch: Throwable -> L64
        if (com.bytedance.frameworks.baselib.network.http.h.b.f() == false) goto L11;
        String r1 = "1";
    L12:
        r0.J(r1);     // Catch: Throwable -> L64
        Map<String, String> r2 = c.a().D();     // Catch: Throwable -> L64
        if (r2 != null) goto L15;
    L17:
        Map<String, String> r3 = c.a().J();     // Catch: Throwable -> L64
        String r4 = "";
        if (r3 != null) goto L20;
    L25:
        String r5 = "";
        if (r2 == null) goto L31;
        if (r2.isEmpty() == true) goto L31;
        r5 = a((String) ZeusTransformUtils.preCheckCast(r2.get("first"), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L64
    L31:
        if (TextUtils.isEmpty(r5) == true) goto L33;
        r4 = "Cookie:" + r5 + "\r\n" + r4;     // Catch: Throwable -> L64
    L33:
        this.f40523b.F(r4);     // Catch: Throwable -> L64
        Map<String, String> r6 = c.a().K();     // Catch: Throwable -> L64
        String r7 = "";
        if (r6 != null) goto L36;
    L41:
        this.f40523b.G(r7);     // Catch: Throwable -> L64
        List<String> r8 = c.a().Z();     // Catch: Throwable -> L64
        String r9 = "";
        if (r8 != null) goto L44;
    L57:
        this.f40523b.K(r9);     // Catch: Throwable -> L64
        if (d.a().loggerDebug() == false) goto L67;
        d.a().loggerD("CronetAppInfoProvider", "get appinfo = " + ("AppInfo{, mUserId='" + this.f40523b.getUserId() + "', mAppId='" + this.f40523b.getAppId() + "', mOSApi='" + this.f40523b.getOSApi() + "', mDeviceId='" + this.f40523b.getDeviceId() + "', mNetAccessType='" + this.f40523b.getNetAccessType() + "', mVersionCode='" + this.f40523b.getVersionCode() + "', mDeviceType='" + this.f40523b.getDeviceType() + "', mAppName='" + this.f40523b.getAppName() + "', mSdkAppID='" + this.f40523b.getSdkAppID() + "', mSdkVersion='" + this.f40523b.getSdkVersion() + "', mChannel='" + this.f40523b.getChannel() + "', mOSVersion='" + this.f40523b.getOSVersion() + "', mAbi='" + this.f40523b.getAbi() + "', mDevicePlatform='" + this.f40523b.getDevicePlatform() + "', mDeviceBrand='" + this.f40523b.getDeviceBrand() + "', mDeviceModel='" + this.f40523b.getDeviceModel() + "', mVersionName='" + this.f40523b.getVersionName() + "', mUpdateVersionCode='" + this.f40523b.getUpdateVersionCode() + "', mManifestVersionCode='" + this.f40523b.getManifestVersionCode() + "'}"));     // Catch: Throwable -> L64
    L67:
        return this.f40523b;
    L44:
        if (r8.size() > 5) goto L46;
    L48:
        int r10 = 0;
        Iterator<String> r11 = r8.iterator();     // Catch: Throwable -> L64
    L50:
        if (r11.hasNext() == false) goto L57;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64
        r10 = r10 + 1;     // Catch: Throwable -> L64
        if (r10 > 5) goto L57;
        if (TextUtils.isEmpty(r12) == true) goto L50;
        r9 = r9 + r12 + ",";     // Catch: Throwable -> L64
        goto L50
    L46:
        if (d.a().loggerDebug() == false) goto L48;
        d.a().loggerD("CronetAppInfoProvider", "ab sdk version count must less than 5");     // Catch: Throwable -> L64
        goto L48
    L36:
        if (r6.isEmpty() == true) goto L41;
        Iterator<Map.Entry<String, String>> r13 = r6.entrySet().iterator();     // Catch: Throwable -> L64
    L39:
        if (r13.hasNext() == false) goto L41;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64
        r7 = ((String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.aiagent.plugin")) + ":" + ((String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.aiagent.plugin")) + "\r\n" + r7;     // Catch: Throwable -> L64
        goto L39
    L20:
        if (r3.isEmpty() == true) goto L25;
        Iterator<Map.Entry<String, String>> r15 = r3.entrySet().iterator();     // Catch: Throwable -> L64
    L23:
        if (r15.hasNext() == false) goto L25;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64
        r4 = ((String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.aiagent.plugin")) + ":" + ((String) ZeusTransformUtils.preCheckCast(r16.getValue(), String.class, "com.obric.aiagent.plugin")) + "\r\n" + r4;     // Catch: Throwable -> L64
        goto L23
    L15:
        if (r2.isEmpty() == true) goto L17;
        this.f40523b.t((String) ZeusTransformUtils.preCheckCast(r2.get("first"), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L64
        this.f40523b.u((String) ZeusTransformUtils.preCheckCast(r2.get("second"), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L64
        this.f40523b.v((String) ZeusTransformUtils.preCheckCast(r2.get("third"), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L64
        this.f40523b.w((String) ZeusTransformUtils.preCheckCast(r2.get(TTNetInit.DOMAIN_HTTPDNS_KEY), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L64
        this.f40523b.x((String) ZeusTransformUtils.preCheckCast(r2.get(TTNetInit.DOMAIN_BOE_KEY), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L64
        this.f40523b.y((String) ZeusTransformUtils.preCheckCast(r2.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L64
        goto L17
    L11:
        r1 = "0";
        goto L12
    L64:
        th = move-exception;
        th.printStackTrace();
        goto L67
    }
}
