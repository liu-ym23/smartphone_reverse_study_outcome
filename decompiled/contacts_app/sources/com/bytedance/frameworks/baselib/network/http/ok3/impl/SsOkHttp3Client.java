package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.frameworks.baselib.network.http.BaseHttpClient;
import com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Locale;
import okhttp3.OkHttpClient;
import okhttp3.internal.Version;

/* JADX INFO: loaded from: classes2.dex */
public class SsOkHttp3Client extends BaseHttpClient {
    public static final int FALL_BACK_REASON_BOOT = 3;
    public static final int FALL_BACK_REASON_CRONET_EXCEPTION = 7;
    public static final int FALL_BACK_REASON_CRONET_EXCEPTION_ONCE = 10;
    public static final int FALL_BACK_REASON_DEFAULT = -1;
    public static final int FALL_BACK_REASON_FORCE = 0;
    public static final int FALL_BACK_REASON_MODEL = 8;
    public static final int FALL_BACK_REASON_NO_PLUGIN = 6;
    public static final int FALL_BACK_REASON_NULL_APPCONFIG = 9;
    public static final int FALL_BACK_REASON_X86 = 2;
    public static final String OK3_VERSION = "tt-ok/3.12.13.2-rc.2";
    public static final String TAG = "SsOkHttp3Client";
    private static final int VERSION_CODE_UNINITIALIZED = 0;
    private static Context sContext = null;
    private static volatile String sDefaultUA = "";
    private static volatile String sFallbackMessage = "";
    private static volatile int sFallbackReason = -1;
    private static volatile SsOkHttp3Client sInstance = null;
    private static volatile boolean sNotAllowUseNetwork = false;
    private static Ok3TncBridge sOk3TncBridge = null;
    private static OkHttp3Builder sOkHttp3Builder = null;
    private static volatile IOkHttpAppInfoProvider sOkHttpAppInfoProvider = null;
    private static String sOkVersion = "tt-ok/3.10.0.2";
    private static volatile Proxy sProxy;
    private static int sVersionCode;
    private static final Object sVersionCodeLock = null;

    static /* synthetic */ Context access$000() {
        return sContext;
    }

    static /* synthetic */ IOkHttpAppInfoProvider access$100() {
        return sOkHttpAppInfoProvider;
    }

    static {
        sVersionCodeLock = new Object();
    }

    public static SsOkHttp3Client inst(Context r2) {
        if (sInstance != null) goto L15;
        monitor-enter(SsOkHttp3Client.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SsOkHttp3Client(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SsOkHttp3Client.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private SsOkHttp3Client(Context r5) {
        String r0 = Version.userAgent();     // Catch: Throwable -> L5
    L11:
        if (TextUtils.isEmpty(r0) == false) goto L13;
    L17:
        sContext = r5.getApplicationContext();
        sOkHttp3Builder = new OkHttp3Builder();
        URLDispatcher.inst().loadLocalConfig(sContext);
        HttpDns.getService().setHttpDnsDepend(new AnonymousClass1(this));
        return;
    L13:
        if (r0.startsWith("okhttp/") == false) goto L15;
        String r1 = r0.replaceFirst("okhttp/", "tt-ok/");
    L16:
        sOkVersion = r1;
        goto L17
    L15:
        r1 = "tt-ok/" + r0;
    L5:
        r0 = null;
        Field r2 = Class.forName("okhttp3.internal.Util").getDeclaredField("userAgent");     // Catch: Throwable -> L8
        r2.setAccessible(true);     // Catch: Throwable -> L8
        r0 = (String) r2.get(null);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    public OkHttpClient getOkHttpClient() throws IllegalArgumentException {
        return getOkHttpClient(true);
    }

    public static OkHttpClient constructOkHttpClient() {
        return sOkHttp3Builder.build(false);
    }

    public OkHttpClient getOkHttpClient(boolean r1) throws IllegalArgumentException {
        OkHttp3Builder r0 = sOkHttp3Builder;
        if (r0 == null) goto L7;
        return r0.build(r1);
    L7:
        throw new IllegalArgumentException("SsOkHttp3Client is not init !!!");
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(Request r6) throws IOException {
        Request r5 = StoreRegionManager.inst().addStoreRegionHeaderForOkHttp(r6);     // Catch: Throwable -> L12
        if (r5 == null) goto L5;
        r6 = r5;
    L5:
        long r0 = SystemClock.uptimeMillis();
        Request r7 = QueryFilterEngine.inst().filterQuery(r6);
        if (r6.getMetrics() == null) goto L8;
        RetrofitMetrics r2 = r6.getMetrics();
        r2.queryFilterDuration = SystemClock.uptimeMillis() - r0;
    L8:
        if (r7 == null) goto L11;
        r6 = r7;
    L11:
        return new Ok3SsCall(r6);
    }

    public static String getDefaultOkhttpUA() {
        if (TextUtils.isEmpty(sDefaultUA) == false) goto L12;
        StringBuilder r0 = new StringBuilder();
        r0.append(sContext.getPackageName());
        r0.append('/');
        r0.append(versionFromContext(sContext));
        r0.append(" (Linux; U; Android ");
        r0.append(Build.VERSION.RELEASE);
        r0.append("; ");
        r0.append(Locale.getDefault().toString());
        String r2 = Build.MODEL;
        if (r2.length() <= 0) goto L7;
        r0.append("; ");
        r0.append(r2);
    L7:
        String r1 = Build.ID;
        if (r1.length() <= 0) goto L10;
        r0.append("; Build/");
        r0.append(r1);
    L10:
        r0.append(";");
        r0.append(sOkVersion);
        r0.append(')');
        sDefaultUA = r0.toString();
    L12:
        return sDefaultUA;
    }

    private static int versionFromContext(Context r3) {
        Object r0 = sVersionCodeLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sVersionCode == 0) goto L16;
    L9:
        int r4 = sVersionCode;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L16:
        sVersionCode = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L15 Throwable -> L12
        goto L9
    }

    public void setOk3TncBridge(Ok3TncBridge r1) {
        sOk3TncBridge = r1;
    }

    public static Ok3TncBridge getOk3TncBridge() {
        return sOk3TncBridge;
    }

    public static void setNotAllowUseNetwork(boolean r0) {
        sNotAllowUseNetwork = r0;
    }

    public static boolean getNotAllowUseNetwork() {
        return sNotAllowUseNetwork;
    }

    public static void setFallbackReason(int r0) {
        sFallbackReason = r0;
    }

    public static int getFallbackReason() {
        return sFallbackReason;
    }

    public static void setFallbackMessage(String r0) {
        sFallbackMessage = r0;
    }

    public static String getFallbackMessage() {
        return sFallbackMessage;
    }

    public static void setProxy(String r7) throws IllegalArgumentException {
        if (r7 != null) goto L5;
        sProxy = null;
        return;
    L5:
        String[] r0 = r7.split(";");
        if (r0.length <= 0) goto L30;
        String[] r1 = r0[0].trim().split("=");
        if (r1.length != 2) goto L28;
        String r3 = r1[0].trim().toLowerCase();
        String[] r2 = r1[1].trim().split(SimContactsConstants.ANR_SEP);
        if (r2.length != 2) goto L26;
        InetSocketAddress r4 = new InetSocketAddress(r2[0], Integer.parseInt(r2[1]));
        if (r3.equals(HttpHost.DEFAULT_SCHEME_NAME) == false) goto L14;
    L23:
        sProxy = new Proxy(Proxy.Type.HTTP, r4);
        return;
    L14:
        if (r3.equals("https") == true) goto L23;
        if (r3.equals("socks") == false) goto L19;
    L22:
        sProxy = new Proxy(Proxy.Type.SOCKS, r4);
        return;
    L19:
        if (r3.equals("socks4") == true) goto L22;
        if (r3.equals("socks5") == true) goto L22;
        return;
    L26:
        throw new IllegalArgumentException("Invalid proxy rule:" + r7);
    L28:
        throw new IllegalArgumentException("Invalid proxy rule:" + r7);
    L30:
        throw new IllegalArgumentException("Invalid proxy rule:" + r7);
    }

    public static Proxy getProxy() {
        return sProxy;
    }

    public static void injectAppInfoProvider(IOkHttpAppInfoProvider r0) {
        sOkHttpAppInfoProvider = r0;
    }

    public static String getOkVersion() {
        return sOkVersion;
    }

    public static IOkHttpAppInfoProvider getOkHttpAppInfoProvider() {
        return sOkHttpAppInfoProvider;
    }

    public static Context getContext() {
        return sContext;
    }

    public static String getFallbackReasonHeaderValue(Request r3) {
        if (r3 != null) goto L4;
        return "null-metrics";
    L4:
        if (r3.getMetrics() != null) goto L7;
        return "null-metrics";
    L7:
        return "fallback_reason=" + sFallbackReason + ",fallback-message=" + Base64.encodeToString(sFallbackMessage.getBytes(), 2) + ",request-fallback-reason=" + r3.getMetrics().requestFallbackReason + ",request-fallback-message=" + Base64.encodeToString(r3.getMetrics().requestFallbackMessage.getBytes(), 2);
    }
}
