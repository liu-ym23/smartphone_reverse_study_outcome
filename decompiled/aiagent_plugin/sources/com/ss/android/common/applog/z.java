package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.bdinstall.ar;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: NetUtilWrapper.java */
/* JADX INFO: loaded from: classes4.dex */
public class z {
    private static final String TAG = "AppLog";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f37258a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f37259b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f37260c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static y.a f37261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static com.bytedance.bdinstall.c.c f37262e;
    private static com.ss.android.common.a f;
    private static volatile boolean g;
    private static volatile boolean h;
    private static volatile int i;
    private static Object j;
    private static volatile String k;
    private static final ConcurrentHashMap<String, String> l = null;
    private static final ConcurrentHashMap<String, String> m = null;
    private static volatile y.b n;
    private static a o;
    private static k p;

    /* JADX INFO: compiled from: NetUtilWrapper.java */
    public interface a {
        com.bytedance.common.utility.i.b a();
    }

    static {
        f37258a = new String[]{WsConstants.KEY_APP_ID, WsConstants.KEY_APP_VERSION, "tt_data", "device_id"};
        f37259b = new String[]{"tt_data", "device_platform", WsConstants.KEY_APP_ID, "device_id", WsConstants.KEY_INSTALL_ID};
        f37260c = new String[]{WsConstants.KEY_APP_ID, "version_code", "ab_version", "device_id", WsConstants.KEY_INSTALL_ID, "device_platform"};
        f = null;
        j = new Object();
        k = "app_log_encrypt_switch_count";
        l = new ConcurrentHashMap();
        m = new ConcurrentHashMap();
    }

    public static void a(Map<String, String> r9, boolean r10, ar r11) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        com.ss.android.common.a r0 = f;
        if (r12 == null) goto L154;
        if (r0 == null) goto L155;
        if (r11 != null) goto L8;
        return;
    L8:
        if (com.ss.android.deviceregister.g.a() == false) goto L11;
        com.bytedance.bdinstall.i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r12, r10, r11);
        return;
    L11:
        HashMap r2 = new HashMap();
    L22:
        com.ss.android.deviceregister.g.a(r2);
    L23:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.get("klink_egdi"), String.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(r4) == true) goto L26;
        r12.put("klink_egdi", r4);
    L26:
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.get("install_id"), String.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(r3) == true) goto L29;
        r12.put(WsConstants.KEY_INSTALL_ID, r3);
    L29:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.get("device_id"), String.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(r5) == true) goto L32;
        r12.put("device_id", r5);
    L32:
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L46;
        a r7 = o;
        if (r7 == null) goto L41;
        String r8 = r7.a().name();
        if (com.bytedance.common.utility.j.a(r8) == true) goto L46;
        r12.put("ac", r8);
        if (Logger.debug() == false) goto L46;
        com.ss.android.common.util.e.b("NetUtil get access from broad receiver " + r8);
        goto L46
    L41:
        String r13 = com.bytedance.common.utility.i.f(r6);
        if (com.bytedance.common.utility.j.a(r13) == true) goto L46;
        r12.put("ac", r13);
        if (Logger.debug() == false) goto L46;
        com.ss.android.common.util.e.b("NetUtil get access from access " + r13);
    L46:
        boolean r14 = com.ss.android.deviceregister.a.c.a(r6);
        String r15 = r0.d();
        if (r15 == null) goto L49;
        r12.put("channel", r15);
    L49:
        r12.put(WsConstants.KEY_APP_ID, String.valueOf(r0.i()));
        String r16 = r0.a();
        if (r16 == null) goto L52;
        r12.put(IBdInstall.PARAM_APP_NAME, r16);
    L52:
        r12.put("version_code", String.valueOf(r0.e()));
        r12.put("version_name", r0.b());
        r12.put("device_platform", "android");
        a(r12);
        String r17 = r0.l();
        if (com.bytedance.common.utility.j.a(r17) == true) goto L55;
        r12.put("ab_version", r17);
    L55:
        String r18 = r0.j();
        if (com.bytedance.common.utility.j.a(r18) == true) goto L58;
        r12.put("ab_client", r18);
    L58:
        String r19 = r0.m();
        if (com.bytedance.common.utility.j.a(r19) == true) goto L61;
        r12.put("ab_group", r19);
    L61:
        String r20 = r0.n();
        if (com.bytedance.common.utility.j.a(r20) == true) goto L64;
        r12.put("ab_feature", r20);
    L64:
        long r21 = r0.k();
        if (r21 <= 0) goto L67;
        r12.put("abflag", String.valueOf(r21));
    L67:
        if (r10 == false) goto L69;
        r12.put("ssmix", "a");
    L69:
        r12.put("device_type", Build.MODEL);
        r12.put(HardwareInfo.KEY_HW_VENDOR_BRAND, Build.BRAND);
        r12.put("language", Locale.getDefault().getLanguage());
        r12.put(RomInfo.KEY_ROM_OS_API, String.valueOf(Build.VERSION.SDK_INT));
        String r110 = Build.VERSION.RELEASE;     // Catch: Exception -> L135
        if (r110 != null) goto L73;
    L75:
        r12.put(RomInfo.KEY_ROM_OS_VERSION, r110);     // Catch: Exception -> L135
        goto L77
    L73:
        if (r110.length() <= 10) goto L75;
        r110 = r110.substring(0, 10);     // Catch: Exception -> L135
    L77:
        if (r11 == ar.f6144a) goto L79;
    L88:
        r12.put("manifest_version_code", String.valueOf(r0.h()));
        String r111 = com.bytedance.common.utility.k.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (com.bytedance.common.utility.j.a(r111) == true) goto L91;
        r12.put(HardwareInfo.KEY_HW_DISPLAY_RESOLUTION, r111);
    L91:
        int r112 = com.bytedance.common.utility.k.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r112 <= 0) goto L94;
        r12.put("dpi", String.valueOf(r112));
    L94:
        r12.put("update_version_code", String.valueOf(r0.g()));
        r12.put("_rticket", String.valueOf(System.currentTimeMillis()));
        a(l, r12);
        if (r11 != ar.f6144a) goto L139;
        a(m, r12);
    L139:
    L118:
        th = move-exception;
        th.printStackTrace();
    L120:
        String r113 = com.ss.android.deviceregister.c.a.a(r6);
        if (com.bytedance.common.utility.j.a(r113) == true) goto L124;
        r12.put("cdid", r113);
    L124:
        if (r11 != ar.f6144a) goto L127;
        com.ss.android.deviceregister.base.f.a(r6, r0, r12, r14);
    L127:
        if (com.ss.android.deviceregister.g.b(r6) == false) goto L131;
        com.ss.android.deviceregister.m r114 = (com.ss.android.deviceregister.m) ZeusTransformUtils.preCheckCast(com.ss.android.deviceregister.b.b.a(com.ss.android.deviceregister.m.class), com.ss.android.deviceregister.m.class, "com.obric.aiagent.plugin");
        if (r114 == null) goto L131;
        r114.a(r12);
    L131:
        com.bytedance.bdinstall.c.c r115 = f37262e;
        if (r115 == null) goto L156;
        r115.a(r12);
        return;
    L156:
        return;
    L98:
        if (n == null) goto L120;
        HashMap<String, String> r116 = n.a(r11);     // Catch: Throwable -> L118
        if (r116 == null) goto L120;
        if (r116.isEmpty() == true) goto L120;
        Iterator<Map.Entry<String, String>> r117 = r116.entrySet().iterator();     // Catch: Throwable -> L118
    L105:
        if (r117.hasNext() == false) goto L120;
        Map.Entry r22 = (Map.Entry) ZeusTransformUtils.preCheckCast(r117.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L118
        if (r22 == null) goto L105;
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L118
        String r24 = (String) ZeusTransformUtils.preCheckCast(r22.getValue(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L118
        if (com.bytedance.common.utility.j.a(r23) == true) goto L105;
        if (com.bytedance.common.utility.j.a(r24) == true) goto L105;
        if (r12.containsKey(r23) == true) goto L105;
        r12.put(r23, r24);     // Catch: Throwable -> L118
        goto L105
    L79:
        if (com.ss.android.deviceregister.g.b() == true) goto L83;
        String r25 = (String) ZeusTransformUtils.preCheckCast(r2.get("openudid"), String.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(r25) == true) goto L83;
        r12.put("openudid", r25);
    L83:
        k r118 = p;
        if (r118 == null) goto L88;
        String r119 = r118.a();
        if (TextUtils.isEmpty(r119) == true) goto L88;
        r12.put("aliyun_uuid", r119);
        goto L88
    L13:
        if (ToolUtils.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L20;
        y.a r26 = f37261d;     // Catch: Exception -> L22
        if (r26 == null) goto L18;
        r26.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r2);     // Catch: Exception -> L22
    L18:
        if (Logger.debug() == false) goto L23;
        com.ss.android.common.util.e.b("PushService idmap = " + com.bytedance.common.utility.j.a(r2));     // Catch: Exception -> L22
        goto L23
    L20:
        com.ss.android.deviceregister.g.a(r2);     // Catch: Exception -> L22
        goto L23
    L155:
        return;
    }

    static void a(Map<String, String> r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r6.isEmpty() == true) goto L18;
        Iterator r8 = r6.entrySet().iterator();     // Catch: Exception -> L19
    L7:
        if (r8.hasNext() == false) goto L34;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        if (r0 == null) goto L7;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        if (com.bytedance.common.utility.j.a(r2) == true) goto L7;
        if (com.bytedance.common.utility.j.a(r1) == true) goto L7;
        r7.put(r2, r1);     // Catch: Exception -> L19
    L34:
        return;
    L18:
        return;
    }

    static String a() {
        k r0 = p;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a();
    }

    static String a(com.bytedance.applog.m r4, String r5, byte[] r6, Context r7, boolean r8, String[] r9, Map<String, String> r10, String r11, boolean r12, boolean r13) {
        com.bytedance.applog.m r14 = (com.bytedance.applog.m) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.applog.m.class, "com.obric.aiagent.plugin");
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(r5) == false) goto L5;
        return null;
    L5:
        if (r6 != null) goto L7;
    L67:
        return null;
    L7:
        if (r6.length <= 0) goto L67;
        HashMap r0 = new HashMap();
        r0.put("log-encode-type", DownloadHelper.GZIP);
        if (r5.contains("/service/2/app_log/") == false) goto L41;
        if (r14 != null) goto L68;
    L26:
        if (r6 != null) goto L29;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.M);     // Catch: Throwable -> L24
        return null;
    L29:
        if (r15 == null) goto L36;
        a(r15);     // Catch: Throwable -> L24
        if (i >= 3) goto L35;
        r6 = com.bytedance.frameworks.core.encrypt.b.a(r6, r6.length);     // Catch: Throwable -> L24
        b(r15);     // Catch: Throwable -> L24
        if (r6 != null) goto L42;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.I);     // Catch: Throwable -> L24
    L42:
        if (r6 == null) goto L66;
        String r17 = r5 + "&tt_data=a";
        if (r8 == false) goto L46;
        r17 = r17 + "&config_retry=b";
    L46:
        r0.remove(DownloadHelper.CONTENT_ENCODING);
        r0.put(DownloadHelper.CONTENT_TYPE, "application/octet-stream;tt-data=a");
        if (r16 == null) goto L49;
        r0.putAll(r16);
    L49:
        if (r13 == true) goto L52;
        com.ss.android.common.util.b.a(r0, r12);
    L52:
        if (com.ss.android.deviceregister.a.a.a.c.a(r9) == false) goto L64;
        byte[] r18 = com.bytedance.common.utility.g.a().b(r17, r6, r0, null);
        if (r18 == null) goto L62;
        byte[] r19 = com.ss.android.deviceregister.a.a.a.c.a(r18, r9[0], r9[1]);
        if (r19 != null) goto L60;
        return new String(r18);
    L60:
        return new String(com.ss.android.deviceregister.a.a.a.c.a(r19));
    L62:
        throw new RuntimeException("get encrypted resp failed");
    L64:
        return com.bytedance.common.utility.g.a().a(r17, r6, r0, null);
    L66:
        throw new RuntimeException("encrypt failed");
    L35:
        r6 = null;
        goto L42
    L36:
        r6 = com.bytedance.frameworks.core.encrypt.b.a(r6, r6.length);     // Catch: Throwable -> L24
        if (r6 != null) goto L42;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.I);     // Catch: Throwable -> L24
        goto L42
    L68:
        com.bytedance.applog.e r20 = r14.a(r6);     // Catch: Throwable -> L24
        if (r20 != null) goto L15;
    L22:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.M);     // Catch: Throwable -> L24
        return null;
    L15:
        if (r20.a() == null) goto L22;
        r6 = r20.a();     // Catch: Throwable -> L24
        if (r20.c() == null) goto L26;
        if (r20.c().isEmpty() == true) goto L26;
        r0.putAll(r20.c());     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        com.ss.android.common.util.e.e("compress log data failed", th);
        goto L42
    L41:
        r6 = a(r15, r6, r11);
        goto L42
    }

    private static byte[] a(Context r2, byte[] r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        byte[] r6 = null;
        if (r3 != null) goto L5;
    L27:
        return null;
    L5:
        if (r3.length <= 0) goto L27;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = new GZIPOutputStream(r0);
        r1.write(r3);     // Catch: Throwable -> L20
        r1.close();
        byte[] r7 = r0.toByteArray();
        if (r5 == null) goto L16;
        a(r5);
        if (i >= 3) goto L19;
        r6 = com.bytedance.frameworks.core.encrypt.b.a(r7, r7.length);
        b(r5);
        if (r6 != null) goto L19;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.I);
    L19:
        return r6;
    L16:
        r6 = com.bytedance.frameworks.core.encrypt.b.a(r7, r7.length);
        if (r6 != null) goto L19;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.I);
    L20:
        th = move-exception;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.M);     // Catch: Throwable -> L24
        com.ss.android.common.util.e.e("AppLog compress with gzip exception: ", th);     // Catch: Throwable -> L24
        r1.close();
        return null;
    L24:
        th = move-exception;
        r1.close();
        throw th;
    }

    private static void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (g == true) goto L14;
        if (r5 == null) goto L20;
        Object r0 = j;
        monitor-enter(r0);
        SharedPreferences r6 = r5.getSharedPreferences(k, 0);     // Catch: Throwable -> L15
        i = r6.getInt("app_log_encrypt_faild_count", 0);     // Catch: Throwable -> L15
        SharedPreferences.Editor r7 = r6.edit();     // Catch: Throwable -> L15
        r7.putInt("app_log_encrypt_faild_count", i + 1);     // Catch: Throwable -> L15
        r7.apply();     // Catch: Throwable -> L15
        g = true;     // Catch: Throwable -> L15
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L20:
        return;
    }

    private static void b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (h == true) goto L18;
        if (r5 == null) goto L24;
        Object r0 = j;
        monitor-enter(r0);
        SharedPreferences.Editor r6 = r5.getSharedPreferences(k, 0).edit();     // Catch: Throwable -> L19
        if (i <= 2) goto L11;
        i -= 2;     // Catch: Throwable -> L19
    L12:
        r6.putInt("app_log_encrypt_faild_count", i);     // Catch: Throwable -> L19
        r6.apply();     // Catch: Throwable -> L19
        h = true;     // Catch: Throwable -> L19
        goto L22
    L11:
        i = 0;     // Catch: Throwable -> L19
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L24:
        return;
    }

    public static String a(String r6, String[] r7) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return r6;
    L5:
        Uri r8 = Uri.parse(r6);
        HashMap r0 = new HashMap(r7.length);
        int r1 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        String r3 = r7[r2];
        String r4 = r8.getQueryParameter(r3);
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r0.put(r3, r4);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        Uri.Builder r9 = r8.buildUpon();
        r9.clearQuery();
        Iterator r10 = r0.keySet().iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        r9.appendQueryParameter(r5, (String) ZeusTransformUtils.preCheckCast(r0.get(r5), String.class, "com.obric.aiagent.plugin"));
        goto L13
    L16:
        return r9.build().toString();
    }

    public static String a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r4;
    L5:
        Uri.Builder r0 = Uri.parse(a(r4, f37258a)).buildUpon();
        r0.appendQueryParameter("tt_info", new String(Base64.encode(a(null, Uri.parse(r4).getQuery().getBytes("UTF-8"), null), 8)));     // Catch: Throwable -> L8
        return r0.build().toString();
    L11:
        return r4;
    }

    private static void a(Map<String, String> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (com.ss.android.deviceregister.c.e.w() == false) goto L5;
        String r0 = "harmony";
    L6:
        r3.put(RomInfo.KEY_OS_TYPE, r0);
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (com.ss.android.deviceregister.c.e.w() == false) goto L16;
        r3.put("sub_os_api", String.valueOf(com.bytedance.bdinstall.j.u.a("hw_sc.build.os.apiversion")));     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L5:
        r0 = "android";
        goto L6
    }
}
