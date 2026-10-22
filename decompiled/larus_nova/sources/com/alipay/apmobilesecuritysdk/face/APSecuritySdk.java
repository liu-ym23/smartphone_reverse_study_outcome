package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.m.a0.f;
import com.alipay.sdk.m.l.b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class APSecuritySdk implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static APSecuritySdk f25114a;
    public static APSecBgCheckerInterface bgChecker;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static IDeviceInfo f25115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object f25116d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f25117b;

    public interface InitResultListener {
        void onResult(TokenResult r100);
    }

    public class TokenResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ APSecuritySdk f25121a;
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult(APSecuritySdk r100) {
            this.f25121a = r100;
        }
    }

    static {
        f25116d = new Object();
    }

    public APSecuritySdk(Context r100) {
        this.f25117b = r100;
    }

    public static /* synthetic */ Context a(APSecuritySdk r100) {
        return r100.f25117b;
    }

    public static IDeviceInfo getDeviceInfo() {
        return f25115c;
    }

    public static APSecuritySdk getInstance(Context r100) {
        if (f25114a != null) goto L15;
        Object r101 = f25116d;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f25114a != null) goto L9;
        f25114a = new APSecuritySdk(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L15:
        return f25114a;
    }

    public static String getUtdid(Context r100) {
        return UtdidWrapper.getUtdid(r100);
    }

    public static void registerBgChecker(APSecBgCheckerInterface r100) {
        bgChecker = r100;
    }

    public static void registerDeviceInfo(IDeviceInfo r100) {
        f25115c = r100;
    }

    @Override // com.alipay.sdk.m.a0.f
    public String getAndroidId() {
        IDeviceInfo r100 = f25115c;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getAndroidId();
    }

    public String getApdidToken() {
        String r100 = a.a(this.f25117b, "");
        if (com.alipay.sdk.m.z.a.a(r100) == false) goto L5;
        initToken(0, new HashMap(), null);
    L5:
        return r100;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public String getSdkVersion() {
        return "3.4.0.202303020703";
    }

    @Override // com.alipay.sdk.m.a0.f
    public String getSubscriberId() {
        IDeviceInfo r100 = f25115c;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getSubscriberId();
    }

    public synchronized TokenResult getTokenResult() {
        monitor-enter(this);
        TokenResult r100 = new TokenResult(this);     // Catch: Throwable -> L13
        r100.apdidToken = a.a(this.f25117b, "");     // Catch: Throwable -> L16
        r100.clientKey = h.f(this.f25117b);     // Catch: Throwable -> L16
        r100.apdid = a.a(this.f25117b);     // Catch: Throwable -> L16
        r100.umidToken = UmidSdkWrapper.getSecurityToken(this.f25117b);     // Catch: Throwable -> L16
        if (com.alipay.sdk.m.z.a.a(r100.apdid) == false) goto L7;
    L10:
        initToken(0, new HashMap(), null);     // Catch: Throwable -> L16
        goto L11
    L7:
        if (com.alipay.sdk.m.z.a.a(r100.apdidToken) == true) goto L10;
        if (com.alipay.sdk.m.z.a.a(r100.clientKey) == true) goto L10;
    L11:
        monitor-exit(this);
        return r100;
    L13:
        th = move-exception;
        throw th;
    }

    public void initToken(int r100, Map<String, String> r101, final InitResultListener r102) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(r100);
        String r103 = h.b(this.f25117b);
        String r104 = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (com.alipay.sdk.m.z.a.b(r103) == false) goto L8;
        if (com.alipay.sdk.m.z.a.a(r103, r104) == true) goto L8;
        com.alipay.apmobilesecuritysdk.e.a.a(this.f25117b);
        d.a(this.f25117b);
        g.a(this.f25117b);
        i.h();
    L8:
        if (com.alipay.sdk.m.z.a.a(r103, r104) == true) goto L10;
        h.c(this.f25117b, r104);
    L10:
        String r105 = com.alipay.sdk.m.z.a.a(r101, b.f25485g, "");
        String r106 = com.alipay.sdk.m.z.a.a(r101, "tid", "");
        String r107 = com.alipay.sdk.m.z.a.a(r101, "userId", "");
        if (com.alipay.sdk.m.z.a.a(r105) == false) goto L13;
        r105 = UtdidWrapper.getUtdid(this.f25117b);
    L13:
        final HashMap r108 = new HashMap();
        r108.put(b.f25485g, r105);
        r108.put("tid", r106);
        r108.put("userId", r107);
        r108.put("appName", "");
        r108.put("appKeyClient", "");
        r108.put("appchannel", "");
        r108.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a(new AnonymousClass1(this, r108, r102));
    }

    @Override // com.alipay.sdk.m.a0.f
    public boolean isBackgroundRunning() {
        APSecBgCheckerInterface r100 = bgChecker;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isBackgroundRunning();
    }
}
