package com.bytedance.bdturing.setting;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.m;
import d.s;
import d.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: SettingsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h implements g.a {
    private static final String TAG = "SettingsMager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f6610a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f6611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f6612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f6613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f6614e;
    private static JSONObject f;
    private static Handler g;
    private static com.bytedance.bdturing.setting.a h;
    private static final List<g.a> i = null;
    private static final List<g.a> j = null;
    private static final Runnable k = null;
    private static f l;
    private static boolean m;

    /* JADX INFO: compiled from: SettingsManager.kt */
    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a(h.f6610a);
        }
    }

    static {
        f6610a = new h();
        f = c.f6596a.a();
        i = (List) ZeusTransformUtils.preCheckCast(new LinkedList(), List.class, "com.obric.aiagent.plugin");
        j = (List) ZeusTransformUtils.preCheckCast(new LinkedList(), List.class, "com.obric.aiagent.plugin");
        k = (Runnable) ZeusTransformUtils.preCheckCast(new a(), Runnable.class, "com.obric.aiagent.plugin");
    }

    private h() {
    }

    public static final /* synthetic */ void a(h r0) {
        r0.k();
    }

    private final boolean e() {
        if (c("common").optInt("skip_launch", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private final int f() {
        return c("common").optInt("retry_count", 0);
    }

    private final long g() {
        return c("common").optLong("retry_interval", OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS);
    }

    private final long h() {
        return c("common").optLong("period", 300000);
    }

    public final boolean a() {
        if (f6612c == true) goto L7;
        if (c("common").optInt("use_native_report", 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean b() {
        if (f6613d == true) goto L7;
        if (c("common").optInt("use_jsb_request", 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int c() {
        return c("common").optInt("use_dialog_size_v2", 0);
    }

    public final boolean d() {
        return f6614e;
    }

    private final void a(long r2) {
        f.put("available_time", r2);
    }

    private final long i() {
        return f.optLong("available_time");
    }

    public final void a(Context r5, com.bytedance.bdturing.setting.a r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.bdturing.setting.a r8 = (com.bytedance.bdturing.setting.a) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.bdturing.setting.a.class, "com.obric.aiagent.plugin");
        o.d(r7, "context");
        o.d(r8, "provider");
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (m == true) goto L24;
        h = (com.bytedance.bdturing.setting.a) ZeusTransformUtils.preCheckCast(new b(r8), com.bytedance.bdturing.setting.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        com.bytedance.bdturing.setting.a r0 = h;     // Catch: Throwable -> L27
        if (r0 != null) goto L10;
        o.c("configProvider");     // Catch: Throwable -> L27
    L10:
        g = new Handler(r0.m());     // Catch: Throwable -> L27
        com.bytedance.bdturing.setting.a r9 = h;     // Catch: Throwable -> L27
        if (r9 != null) goto L13;
        o.c("configProvider");     // Catch: Throwable -> L27
    L13:
        l = r9.b();     // Catch: Throwable -> L27
        com.bytedance.bdturing.localstorage.a.f6593a.a(r7);     // Catch: Throwable -> L27
        String r10 = com.bytedance.bdturing.localstorage.a.f6593a.a();     // Catch: Throwable -> L27
        if (r10 == null) goto L16;
        f6610a.d(r10);     // Catch: Throwable -> L27
    L16:
        d r11 = d.f6600a;     // Catch: Throwable -> L27
        com.bytedance.bdturing.setting.a r12 = h;     // Catch: Throwable -> L27
        if (r12 != null) goto L19;
        o.c("configProvider");     // Catch: Throwable -> L27
    L19:
        r11.a(r12.d());     // Catch: Throwable -> L27
        h r13 = f6610a;     // Catch: Throwable -> L27
        if (r13.e() == false) goto L22;
        r13.b(a(r13, false, 1, null));     // Catch: Throwable -> L27
    L23:
        m = true;     // Catch: Throwable -> L27
        goto L24
    L22:
        a(r13, 0, 1, null);     // Catch: Throwable -> L27
    L24:
        x r14 = x.f38692a;     // Catch: Throwable -> L27
        monitor-exit(this);
    }

    public final boolean a(g.a r2) {
        g.a r1 = (g.a) ZeusTransformUtils.wrapperContextForParams(r2, g.a.class, "com.obric.aiagent.plugin");
        o.d(r1, "pxy");
        List<g.a> r3 = i;
        monitor-enter(r3);
        boolean r4 = r3.add(r1);     // Catch: Throwable -> L7
        monitor-exit(r3);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.util.List] */
    @Override // com.bytedance.bdturing.setting.g.a
    public void a(int r7, String r8, long r9) {
        boolean r0 = true;
        if (r7 != 200) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L15;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L10;
    L13:
        if (r0 == true) goto L15;
        com.bytedance.bdturing.g.a(TAG, "pull settings success," + r8);
        d(r8);
        f6611b = 0;
    L16:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(i, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r1.hasNext() == false) goto L20;
        ((g.a) ZeusTransformUtils.preCheckCast(r1.next(), g.a.class, "com.obric.aiagent.plugin")).a(r7, r8, r9);
        goto L18
    L20:
        z.f r4 = new z.f();
        monitor-enter(this);
        ?? r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        List<g.a> r6 = j;     // Catch: Throwable -> L30
        r5.addAll((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L30
        r4.f38504a = r5;     // Catch: Throwable -> L30
        r6.clear();     // Catch: Throwable -> L30
        x r10 = x.f38692a;     // Catch: Throwable -> L30
        monitor-exit(this);
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4.f38504a, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L26:
        if (r11.hasNext() == false) goto L28;
        ((g.a) ZeusTransformUtils.preCheckCast(r11.next(), g.a.class, "com.obric.aiagent.plugin")).a(r7, r8, r9);
        goto L26
    L28:
        b(a(r2));
        return;
    L30:
        th = move-exception;
        throw th;
    L10:
        if (r3.length() == 0) goto L13;
        r0 = false;
    L15:
        com.bytedance.bdturing.g.a(TAG, "pull settings fail,code:" + r7 + ",content:" + r8);
        goto L16
    L5:
        r2 = false;
        goto L6
    }

    public final String a(String r2) {
        o.d(r2, WsConstants.KEY_SERVICE);
        return a(r2, "url");
    }

    public final String b(String r2) {
        o.d(r2, WsConstants.KEY_SERVICE);
        return a(r2, "host");
    }

    public final JSONObject c(String r3) {
        o.d(r3, WsConstants.KEY_SERVICE);
        JSONObject r2 = f.optJSONObject(r3);
        if (r2 != null) goto L6;
        r2 = c.f6596a.a().optJSONObject(r3);
    L6:
        if (r2 != null) goto L9;
        r2 = new JSONObject();
    L9:
        com.bytedance.bdturing.setting.a r0 = h;
        if (r0 != null) goto L12;
        o.c("configProvider");
    L12:
        f r1 = r0.b();
        if (r1 == null) goto L15;
        f.put(r3, r1.a(r3, r2));
    L15:
        return r2;
    }

    public final String a(String r5, String r6) {
        o.d(r5, WsConstants.KEY_SERVICE);
        o.d(r6, "type");
        JSONObject r4 = c(r5).optJSONObject(r6);
        if (r4 == null) goto L8;
        com.bytedance.bdturing.setting.a r2 = h;
        if (r2 != null) goto L7;
        o.c("configProvider");
    L7:
        String r7 = r4.optString(r2.l());
    L10:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L12;
        return r7;
    L12:
        JSONObject r8 = c.f6596a.a().optJSONObject(r5);
        if (r8 == null) goto L21;
        JSONObject r9 = r8.optJSONObject(r6);
        if (r9 == null) goto L22;
        com.bytedance.bdturing.setting.a r10 = h;
        if (r10 != null) goto L20;
        o.c("configProvider");
    L20:
        return r9.optString(r10.l());
    L22:
        return null;
    L21:
        return null;
    L8:
        r7 = null;
        goto L10
    }

    public final void a(boolean r6, g.a r7) {
        g.a r8 = (g.a) ZeusTransformUtils.wrapperContextForParams(r7, g.a.class, "com.obric.aiagent.plugin");
        o.d(r8, "callback");
        if (r6 == false) goto L5;
    L7:
        monitor-enter(this);
        List<g.a> r9 = j;     // Catch: Throwable -> L18
        if (r9.size() != 0) goto L11;
        boolean r3 = true;
    L12:
        r9.add(r8);     // Catch: Throwable -> L18
        if (r3 == false) goto L15;
        a(f6610a, 0, 1, null);     // Catch: Throwable -> L18
    L15:
        x r10 = x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L11:
        r3 = false;
    L18:
        th = move-exception;
        throw th;
    L5:
        if (j() == false) goto L7;
        r8.a(200, null, 0);
    }

    private final void d(String r5) {
        f = new JSONObject(r5);     // Catch: JSONException -> L4
        a(System.currentTimeMillis() + h());     // Catch: JSONException -> L4
        com.bytedance.bdturing.localstorage.a.f6593a.a(r5);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.bdturing.g.a((Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void a(h r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        r0.b(r1);
    }

    private final void b(long r2) {
        Handler r1 = g;
        if (r1 == null) goto L5;
        r1.removeCallbacks(k);
    L5:
        Handler r3 = g;
        if (r3 == null) goto L9;
        r3.postDelayed(k, r2);
        return;
    }

    static /* synthetic */ long a(h r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.a(r1);
    }

    private final long a(boolean r5) {
        if (r5 == true) goto L10;
        if (f6611b >= f()) goto L10;
        if (g() == 0) goto L10;
        f6611b++;
        return g();
    L10:
        return Math.max(Math.min(i() - System.currentTimeMillis(), h()), 300000);
    }

    private final boolean j() {
        if (i() <= System.currentTimeMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    private final void k() {
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
        com.bytedance.bdturing.setting.a r1 = h;
        if (r1 != null) goto L5;
        o.c("configProvider");
    L5:
        m r2 = s.a(WsConstants.KEY_APP_ID, r1.d());
        r0.put(r2.a(), r2.b());
        com.bytedance.bdturing.setting.a r3 = h;
        if (r3 != null) goto L8;
        o.c("configProvider");
    L8:
        m r4 = s.a("lang", r3.g());
        r0.put(r4.a(), r4.b());
        com.bytedance.bdturing.setting.a r5 = h;
        if (r5 != null) goto L11;
        o.c("configProvider");
    L11:
        m r6 = s.a(IBdInstall.PARAM_APP_NAME, r5.h());
        r0.put(r6.a(), r6.b());
        com.bytedance.bdturing.setting.a r7 = h;
        if (r7 != null) goto L14;
        o.c("configProvider");
    L14:
        m r8 = s.a("channel", r7.k());
        r0.put(r8.a(), r8.b());
        com.bytedance.bdturing.setting.a r9 = h;
        if (r9 != null) goto L17;
        o.c("configProvider");
    L17:
        m r10 = s.a("region", r9.l());
        r0.put(r10.a(), r10.b());
        m r11 = s.a("os_type", "0");
        r0.put(r11.a(), r11.b());
        m r12 = s.a("datetime", String.valueOf(System.currentTimeMillis()));
        r0.put(r12.a(), r12.b());
        com.bytedance.bdturing.setting.a r13 = h;
        if (r13 != null) goto L20;
        o.c("configProvider");
    L20:
        m r14 = s.a("sdk_version", r13.j());
        r0.put(r14.a(), r14.b());
        com.bytedance.bdturing.setting.a r15 = h;
        if (r15 != null) goto L23;
        o.c("configProvider");
    L23:
        m r16 = s.a(WsConstants.KEY_INSTALL_ID, r15.e());
        r0.put(r16.a(), r16.b());
        com.bytedance.bdturing.setting.a r17 = h;
        if (r17 != null) goto L26;
        o.c("configProvider");
    L26:
        m r18 = s.a(WsConstants.KEY_APP_VERSION, r17.i());
        r0.put(r18.a(), r18.b());
        m r19 = s.a("device_platform", "android");
        r0.put(r19.a(), r19.b());
        com.bytedance.bdturing.setting.a r20 = h;
        if (r20 != null) goto L29;
        o.c("configProvider");
    L29:
        m r21 = s.a("version_code", String.valueOf(r20.a()));
        r0.put(r21.a(), r21.b());
        com.bytedance.bdturing.setting.a r22 = h;
        if (r22 != null) goto L32;
        o.c("configProvider");
    L32:
        m r23 = s.a("version_name", r22.i());
        r0.put(r23.a(), r23.b());
        m r24 = s.a("os_name", "android");
        r0.put(r24.a(), r24.b());
        m r25 = s.a(RomInfo.KEY_ROM_OS_VERSION, String.valueOf(Build.VERSION.SDK_INT));
        r0.put(r25.a(), r25.b());
        com.bytedance.bdturing.setting.a r26 = h;
        if (r26 != null) goto L35;
        o.c("configProvider");
    L35:
        m r27 = s.a("did", r26.f());
        r0.put(r27.a(), r27.b());
        String r28 = Build.BRAND;
        r28 = URLEncoder.encode(r28, "utf-8");     // Catch: UnsupportedEncodingException -> L38
    L40:
        m r29 = s.a(HardwareInfo.KEY_HW_VENDOR_BRAND, r28);
        r0.put(r29.a(), r29.b());
        String r30 = b("common");
        String r31 = null;
        if (r30 == null) goto L43;
        String r32 = b(r30, "vc/setting");
    L44:
        com.bytedance.bdturing.g.g(TAG, r32);
        if (r32 == null) goto L47;
    L51:
        if (r32 == null) goto L53;
        r31 = f6610a.e(r32);
    L53:
        com.bytedance.bdturing.setting.a r33 = h;
        if (r33 != null) goto L56;
        o.c("configProvider");
    L56:
        com.bytedance.bdturing.ttnet.b r34 = r33.c();
        if (r34 != null) goto L59;
        return;
    L59:
        if (r31 != null) goto L62;
        r31 = "";
    L62:
        new g(r31, r0, (g.a) ZeusTransformUtils.preCheckCast(f6610a, g.a.class, "com.obric.aiagent.plugin"), r34).a();
        return;
    L47:
        if (com.bytedance.bdturing.g.a() == false) goto L51;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("url should not empty"), Throwable.class, "com.obric.aiagent.plugin"));
    L43:
        r32 = null;
    L38:
        e = move-exception;
        com.bytedance.bdturing.g.a((Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.aiagent.plugin"));
        goto L40
    }

    private final String e(String r8) {
        StringBuilder r0 = new StringBuilder(r8);
    L48:
        e = move-exception;
        e.printStackTrace();
    L51:
        return r0.toString();
    L5:
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), '?', 0, false, 6, null) >= 0) goto L7;
        r0.append("?");     // Catch: Exception -> L48
    L8:
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L48
        com.bytedance.bdturing.setting.a r3 = h;     // Catch: Exception -> L48
        if (r3 != null) goto L12;
        o.c("configProvider");     // Catch: Exception -> L48
    L12:
        m r2 = s.a(WsConstants.KEY_APP_ID, r3.d());     // Catch: Exception -> L48
        r9.put(r2.a(), r2.b());     // Catch: Exception -> L48
        com.bytedance.bdturing.setting.a r4 = h;     // Catch: Exception -> L48
        if (r4 != null) goto L15;
        o.c("configProvider");     // Catch: Exception -> L48
    L15:
        m r5 = s.a(IBdInstall.PARAM_APP_NAME, r4.h());     // Catch: Exception -> L48
        r9.put(r5.a(), r5.b());     // Catch: Exception -> L48
        com.bytedance.bdturing.setting.a r6 = h;     // Catch: Exception -> L48
        if (r6 != null) goto L18;
        o.c("configProvider");     // Catch: Exception -> L48
    L18:
        m r7 = s.a(WsConstants.KEY_APP_VERSION, r6.i());     // Catch: Exception -> L48
        r9.put(r7.a(), r7.b());     // Catch: Exception -> L48
        com.bytedance.bdturing.setting.a r10 = h;     // Catch: Exception -> L48
        if (r10 != null) goto L21;
        o.c("configProvider");     // Catch: Exception -> L48
    L21:
        m r11 = s.a("channel", r10.k());     // Catch: Exception -> L48
        r9.put(r11.a(), r11.b());     // Catch: Exception -> L48
        com.bytedance.bdturing.setting.a r12 = h;     // Catch: Exception -> L48
        if (r12 != null) goto L24;
        o.c("configProvider");     // Catch: Exception -> L48
    L24:
        m r13 = s.a("lang", r12.g());     // Catch: Exception -> L48
        r9.put(r13.a(), r13.b());     // Catch: Exception -> L48
        com.bytedance.bdturing.setting.a r14 = h;     // Catch: Exception -> L48
        if (r14 != null) goto L27;
        o.c("configProvider");     // Catch: Exception -> L48
    L27:
        m r15 = s.a("sdk_version", r14.j());     // Catch: Exception -> L48
        r9.put(r15.a(), r15.b());     // Catch: Exception -> L48
        com.bytedance.bdturing.setting.a r16 = h;     // Catch: Exception -> L48
        if (r16 != null) goto L30;
        o.c("configProvider");     // Catch: Exception -> L48
    L30:
        m r17 = s.a("version_code", String.valueOf(r16.a()));     // Catch: Exception -> L48
        r9.put(r17.a(), r17.b());     // Catch: Exception -> L48
        com.bytedance.bdturing.setting.a r18 = h;     // Catch: Exception -> L48
        if (r18 != null) goto L33;
        o.c("configProvider");     // Catch: Exception -> L48
    L33:
        m r19 = s.a("version_name", r18.i());     // Catch: Exception -> L48
        r9.put(r19.a(), r19.b());     // Catch: Exception -> L48
        m r20 = s.a("device_platform", "android");     // Catch: Exception -> L48
        r9.put(r20.a(), r20.b());     // Catch: Exception -> L48
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.keySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L48
    L34:
        if (r21.hasNext() == false) goto L51;
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L48
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L39;
        boolean r23 = true;
    L40:
        if (r23 == false) goto L42;
        r0.append("&");     // Catch: Exception -> L48
    L42:
        h r24 = f6610a;     // Catch: Exception -> L48
        String r25 = r24.f(r22);     // Catch: Exception -> L48
        String r26 = (String) ZeusTransformUtils.preCheckCast(r9.get(r22), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L48
        if (r26 == null) goto L45;
        String r27 = r24.f(r26);     // Catch: Exception -> L48
    L46:
        r0.append(r25).append("=").append(r27);     // Catch: Exception -> L48
        goto L34
    L45:
        r27 = null;
        goto L46
    L39:
        r23 = false;
        goto L40
    L7:
        r0.append("&");     // Catch: Exception -> L48
        goto L8
    }

    private final String f(String r1) {
        return URLEncoder.encode(r1, "UTF-8");
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private final String b(String r4, String r5) {
        if (d.o.o.c(r4, "/", false, 2, null) == false) goto L7;
        return r4 + r5;
    L7:
        return r4 + '/' + r5;
    }
}
