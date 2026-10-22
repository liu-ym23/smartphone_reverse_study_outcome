package com.bytedance.crash.upload;

import android.content.Context;
import android.os.FileObserver;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.crash.NativeCrashSummary;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.r;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkDisasterManager.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    private static k g = null;
    private static boolean h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, i> f7813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f7814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f7816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FileObserver f7817e;
    private File f;

    static {
    }

    private long b(int r1) {
        if (r1 > 0) goto L5;
        r1 = 0;
    L5:
        if (r1 <= 6) goto L9;
        return 1800000;
    L9:
        return ((r1 * 5) * 60) * 1000;
    }

    static /* synthetic */ boolean a(k r0) {
        return r0.f7816d;
    }

    static /* synthetic */ boolean a(k r0, boolean r1) {
        r0.f7816d = r1;
        return r1;
    }

    static /* synthetic */ void b(k r0) {
        r0.f();
    }

    static /* synthetic */ void c(k r0) {
        r0.l();
    }

    public static void a() {
        k r0 = c();
        if (r0 == null) goto L9;
        r0.h();
        if (r0.e() == false) goto L7;
        r0.b();
        r0.k();
    L7:
        r0.d();
        return;
    }

    public static void a(boolean r0) {
        h = r0;
    }

    private void b() {
        if (h == false) goto L6;
        r.b("Disaster:disable network disaster!!!");
        m();
        return;
    }

    private static k c() {
        monitor-enter(k.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (g != null) goto L7;
        g = new k();     // Catch: Throwable -> L10
    L7:
        monitor-exit(k.class);     // Catch: Throwable -> L10
        return g;
    }

    public static String a(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return "";
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L7;
        return r1 + "_" + r2;
    }

    private k() {
        r.b("Disaster:init");
        File r0 = com.bytedance.crash.o.i.b(new File(com.bytedance.crash.i.d(), "network_disaster"));
        File r1 = new File(r0, "networkStatef");
        this.f7814b = r1;
        this.f7813a = new ConcurrentHashMap();
        this.f7815c = false;
        this.f7816d = false;
        final String r2 = r1.getAbsolutePath();     // Catch: Throwable -> L5
        final int r3 = DownloadErrorCode.ERROR_CHUNK_COUNT_ERROR;
        this.f7817e = new NetworkDisasterManager$1(this, r2, r3);     // Catch: Throwable -> L5
    L7:
        this.f = new File(r0, "disasterLock");
        return;
    L5:
        th = move-exception;
        r.b(th);
        goto L7
    }

    private void d() {
        com.bytedance.crash.o.i.a(this.f7814b);
        FileObserver r1 = this.f7817e;
        if (r1 == null) goto L6;
        r1.startWatching();
        return;
    }

    private boolean e() {
        if (this.f7813a.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void f() {
        h();
    }

    private void a(JSONArray r8) {
        r.b("disaster: writeToFile");
        boolean r2 = true;
        int r3 = 0;
    L3:
        if (r2 == false) goto L20;
        if (r3 >= 20) goto L20;
        r3 = r3 + 1;
        int r4 = n();     // Catch: Throwable -> L22
        if (r4 == (-1)) goto L9;
        r.b("disaster:write got flock");     // Catch: Throwable -> L22
        this.f7816d = true;     // Catch: Throwable -> L22
        com.bytedance.crash.o.j.b(this.f7814b, r8, false);     // Catch: Throwable -> L22
        a(r4);     // Catch: Throwable -> L22
        r.b("disaster:write unlock flock");     // Catch: Throwable -> L22
        boolean r5 = true;
        int r6 = 0;
    L12:
        if (this.f7816d == false) goto L14;
        r.b("disaster:waiting 20ms");     // Catch: Throwable -> L22
        Thread.sleep(20);     // Catch: Throwable -> L22
        r6 = r6 + 1;     // Catch: Throwable -> L22
    L16:
        if (r5 == false) goto L19;
        if (r6 < 50) goto L12;
    L14:
        r.b("disaster: breakout");     // Catch: Throwable -> L22
        r5 = false;
        goto L16
    L9:
        r.b("disaster:write did not got flock, sleep 50ms and retry");     // Catch: Throwable -> L22
        Thread.sleep(50);     // Catch: Throwable -> L22
        r2 = true;
    L19:
        r2 = false;
    L20:
        this.f7816d = false;
    }

    private String g() {
        r.b("disaster: readFromFile");
        String r1 = "";
        int r2 = 0;
    L3:
        boolean r3 = true;
        r2 = r2 + 1;
        int r4 = n();     // Catch: Throwable -> L14
        if (r4 <= 0) goto L7;
        r.b("disaster: read got flock");     // Catch: Throwable -> L14
        r1 = com.bytedance.crash.o.j.d(this.f7814b);     // Catch: Throwable -> L14
        a(r4);     // Catch: Throwable -> L14
        r.b("disaster: read unlock flock");     // Catch: Throwable -> L14
        goto L9
    L7:
        r.b("disaster:read did not got flock, sleep 500ms and retry");     // Catch: Throwable -> L14
        Thread.sleep(50);     // Catch: Throwable -> L14
    L10:
        if (r3 == false) goto L13;
        if (r2 < 10) goto L3;
    L13:
        return r1;
    L9:
        r3 = false;
        goto L10
    }

    private void h() {
    L13:
        th = move-exception;
        this.f7813a.clear();
        i();
        a(null);
        r.b(th);
        return;
    L3:
        if (this.f7814b.exists() == true) goto L5;
    L11:
        this.f7813a.clear();     // Catch: Throwable -> L13
        i();     // Catch: Throwable -> L13
        return;
    L5:
        if (this.f7814b.length() == 0) goto L11;
        JSONArray r1 = new JSONArray(g());     // Catch: Throwable -> L13
        r.b("Disaster:syncNetworkStateFromFile mJsonArray=" + r1.toString());     // Catch: Throwable -> L13
        int r0 = 0;
    L9:
        if (r0 >= r1.length()) goto L18;
        JSONObject r2 = r1.getJSONObject(r0);     // Catch: Throwable -> L13
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.keys().next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        this.f7813a.put(r3, new i(r2.getJSONObject(r3)));     // Catch: Throwable -> L13
        i();     // Catch: Throwable -> L13
        r0 = r0 + 1;     // Catch: Throwable -> L13
        goto L9
    }

    private void i() {
        if (b(null, "/monitor/collect/c/crash") == false) goto L5;
        com.bytedance.crash.anr.e.c(true);
        com.bytedance.crash.crash.d.d(true);
        com.bytedance.crash.crash.c.a(true);
        com.bytedance.crash.e.a.a(true);
        com.bytedance.crash.b.a.a(true);
    L6:
        com.bytedance.crash.d.e.a(b(null, "/monitor/collect/c/exception"));
        NativeBridge.b(b(null, "/monitor/collect/c/native_bin_crash") ? 1 : 0);
        return;
    L5:
        com.bytedance.crash.anr.e.c(false);
        com.bytedance.crash.crash.c.a(false);
        com.bytedance.crash.e.a.a(false);
        com.bytedance.crash.b.a.a(false);
        com.bytedance.crash.crash.d.d(false);
        goto L6
    }

    private void j() {
        ConcurrentHashMap<String, i> r0 = this.f7813a;
        monitor-enter(r0);
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L21
        Iterator<Map.Entry<String, i>> r3 = this.f7813a.entrySet().iterator();     // Catch: Throwable -> L18
    L8:
        if (r3.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r4 == null) goto L8;
        r1.put(((i) ZeusTransformUtils.preCheckCast(r4.getValue(), i.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L18
        goto L8
    L14:
        if (r1.length() > 0) goto L16;
        this.f7813a.clear();     // Catch: Throwable -> L18
        i();     // Catch: Throwable -> L18
        a(null);     // Catch: Throwable -> L18
        r.b("Disaster:syncNetworkStateToFile delete strategy file");     // Catch: Throwable -> L18
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L16:
        a(r1);     // Catch: Throwable -> L18
        r.b("Disaster:syncNetworkStateToFile mJsonArray=" + r1.toString());     // Catch: Throwable -> L18
    L18:
        this.f7813a.clear();     // Catch: Throwable -> L21
        i();     // Catch: Throwable -> L21
        a(null);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public static boolean b(String r1, String r2) {
        k r0 = c();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.c(r1, r2);
    }

    private boolean c(String r3, String r4) {
        if (e() == true) goto L5;
        return false;
    L5:
        if (h == true) goto L24;
    L16:
        th = move-exception;
        r.b(th);
        return false;
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L10;
        r3 = com.bytedance.crash.monitor.h.a().e();     // Catch: Throwable -> L16
    L10:
        int r2 = d(a(r3, r4));     // Catch: Throwable -> L16
        if (r2 == 4) goto L23;
        if (r2 == 5) goto L23;
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    public static long a(String r1, URL r2) {
        k r0 = c();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b(r1, r2);
    }

    private long b(String r5, URL r6) {
        long r1 = 0;
        if (e() == true) goto L5;
    L24:
        return r1;
    L5:
        if (h == true) goto L24;
        r.b("Disaster:checkPermission url=" + r6);
    L21:
        th = move-exception;
        r.b(th);
    L23:
        r.b("Disaster:checkPermission return timeout=" + r1);
        goto L24
    L9:
        if (TextUtils.isEmpty(r5) == false) goto L12;
        r5 = a(r6, WsConstants.KEY_APP_ID);     // Catch: Throwable -> L21
    L12:
        if (TextUtils.isEmpty(r5) == false) goto L15;
        r.b("Disaster:checkPermission aid==null");     // Catch: Throwable -> L21
        return -1;
    L15:
        i r7 = (i) ZeusTransformUtils.preCheckCast(this.f7813a.get(a(r5, r6.getPath())), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r7 != null) goto L19;
        r.b("Disaster:checkPermission normal");     // Catch: Throwable -> L21
        return 0;
    L19:
        r1 = b(r7);     // Catch: Throwable -> L21
        goto L23
    }

    public static int a(URL r4, l r5) {
        k r0 = c();
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (h == false) goto L9;
        return 0;
    L9:
        if (r4 == null) goto L19;
        if (r5 == null) goto L19;
        r.a("Disaster:updateNetworkState url=" + r4);
        String r2 = a(r4, WsConstants.KEY_APP_ID);     // Catch: Throwable -> L18
        String r6 = r4.getPath();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r2) == false) goto L16;
        return -1;
    L16:
        return r0.a(r2, r6, r5);
    L18:
        return -1;
    L19:
        r.a("Disaster:updateNetworkState param is invalid");
        return -1;
    }

    private int a(String r18, String r19, l r20) {
        if (TextUtils.isEmpty(r18) == false) goto L5;
    L69:
        r.a("Disaster:updateNetworkStateInner param is invalid");
        return -1;
    L5:
        if (TextUtils.isEmpty(r19) == true) goto L69;
        if (r20 == null) goto L69;
        String r0 = a(r18, r19);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r18) == true) goto L68;
        if (TextUtils.isEmpty(r19) == true) goto L68;
        int r9 = 0;
        if (r19.equals(new URL(com.bytedance.crash.config.f.c()).getPath()) == false) goto L16;
        return 0;
    L16:
        r.a("Disaster:updateNetworkStateInner keyId:" + r0 + " rsp:" + r20.toString());     // Catch: Throwable -> L71
        int r1 = d(r0);     // Catch: Throwable -> L71
        int r2 = r20.e();     // Catch: Throwable -> L71
        JSONObject r3 = r20.c();     // Catch: Throwable -> L71
        long r4 = 0;
        boolean r10 = r19.equals(new URL(com.bytedance.crash.config.f.b()).getPath());     // Catch: Throwable -> L71
        int r13 = 3;
        if (r2 != 200) goto L54;
        if (r3 != null) goto L21;
        a(r18, r19, 0, 0, 0);     // Catch: Throwable -> L71
        return 0;
    L21:
        String r5 = r3.optString("message");     // Catch: Throwable -> L71
        String r6 = r3.optString("redirect");     // Catch: Throwable -> L71
        r4 = r3.optLong("delay");     // Catch: Throwable -> L71
        String r7 = r3.optString("Alog_quota");     // Catch: Throwable -> L71
        String r8 = r3.optString("quota_status");     // Catch: Throwable -> L71
        if (r10 == true) goto L28;
        if (TextUtils.isEmpty(r8) == true) goto L28;
        r5 = r8;
    L28:
        if (TextUtils.isEmpty(r5) == false) goto L30;
    L44:
        int r11 = 0;
    L45:
        TextUtils.isEmpty(r6);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r7) == false) goto L48;
        int r12 = 0;
        r9 = 0;
    L52:
        r13 = r11;
        r9 = r12;
    L60:
        if (r13 != (-2)) goto L64;
        if (r10 == false) goto L63;
        r.a("Disaster:quota path error!!!");     // Catch: Throwable -> L71
        this.f7815c = true;     // Catch: Throwable -> L71
    L63:
        return r1;
    L64:
        a(r18, r19, r13, r4, r9);     // Catch: Throwable -> L71
        if (r9 == 0) goto L67;
        a(r18, new URL(com.bytedance.crash.config.f.m()).getPath(), r9, r4, r9);     // Catch: Throwable -> L71
    L67:
        return r13;
    L48:
        if ("long escape".equals(r7) == false) goto L50;
        r12 = 1;
        r9 = 3;
        goto L52
    L50:
        r12 = 1;
        goto L52
    L30:
        if ("success".equals(r5) == true) goto L44;
        if ("long escape".equals(r5) == false) goto L36;
        r11 = 3;
        goto L45
    L36:
        if ("ignore data".equals(r5) == false) goto L39;
    L37:
        r11 = -2;
        goto L45
    L39:
        if ("drop data".equals(r5) == false) goto L42;
        r11 = 4;
        goto L45
    L42:
        if ("drop all data".equals(r5) == false) goto L37;
        r11 = 5;
        goto L45
    L54:
        if (500 <= r2) goto L56;
    L58:
        r13 = -2;
    L59:
        r9 = 0;
        goto L60
    L56:
        if (r2 > 600) goto L58;
    L68:
        return -1;
    }

    private void a(String r6, String r7, int r8, long r9, int r11) {
        String r0 = a(r6, r7);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        if (r8 == 0) goto L9;
        i r2 = (i) ZeusTransformUtils.preCheckCast(this.f7813a.get(r0), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r2 != null) goto L14;
        a(r6, r7, false, r8);     // Catch: Throwable -> L23
        r2 = new i(r6, r7);     // Catch: Throwable -> L23
    L14:
        r2.a(r8);     // Catch: Throwable -> L23
        r2.b(r11);     // Catch: Throwable -> L23
        if (r8 != 1) goto L18;
        r2.a(r9);     // Catch: Throwable -> L23
    L18:
        if (r8 != 5) goto L20;
        b(r7);     // Catch: Throwable -> L23
    L20:
        r2.b(System.currentTimeMillis());     // Catch: Throwable -> L23
        this.f7813a.put(r0, r2);     // Catch: Throwable -> L23
        i();     // Catch: Throwable -> L23
        j();     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L9:
        if (this.f7813a.containsKey(r0) == false) goto L21;
        c(r0);     // Catch: Throwable -> L23
        a(r6, r7, true, -1);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private void b(String r6) {
        r.b("disaster: clearCacheLog");
        int r1 = 0;
    L3:
        boolean r2 = true;
        r1 = r1 + 1;
        int r3 = n();     // Catch: Throwable -> L14
        if (r3 <= 0) goto L7;
        r.b("disaster: got flock");     // Catch: Throwable -> L14
        a(r6);     // Catch: Throwable -> L14
        a(r3);     // Catch: Throwable -> L14
        goto L9
    L7:
        r.b("disaster: did not got flock, sleep 500ms and retry");     // Catch: Throwable -> L14
        Thread.sleep(50);     // Catch: Throwable -> L14
    L10:
        if (r2 == false) goto L13;
        if (r1 < 10) goto L3;
        return;
    L13:
        return;
    L9:
        r2 = false;
        goto L10
    }

    private void d(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L13:
        r.a("Disaster:syncNetworkStateByNet aid or path is null");
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L13;
        r.b("Disaster:syncNetworkStateByNet path=" + r5);
        l r0 = e(r4, r5);
        r.b("Disaster:syncNetworkStateByNet rsp=" + r0.toString());
        a(r4, r5, r0);
        if (this.f7815c == false) goto L10;
    L11:
        this.f7815c = false;
        m();
        r.b("disaster:syncNetworkStateByNet, quota path error");
        return;
    L10:
        if (r0.d() != 0) goto L11;
    }

    private l e(String r3, String r4) {
        String r2 = com.bytedance.crash.config.f.b();
        JSONObject r0 = new JSONObject();
        r0.put(WsConstants.KEY_APP_ID, Integer.valueOf(r3));     // Catch: JSONException -> L5
        r0.put(RomInfo.KEY_OS_TYPE, "Android");     // Catch: JSONException -> L5
        r0.put(DownloadConstants.PATH_KEY, r4);     // Catch: JSONException -> L5
        return b.a(r2, r0.toString());
    L5:
        e = move-exception;
        r.b(e);
        return new l(207);
    }

    private void k() {
        if (com.bytedance.crash.o.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L6;
        r.b("disaster:not main process");
        return;
    L6:
        DefaultWorkThread.post(new AnonymousClass1(this));
    }

    private void l() {
        r.b("disaster:checkNetworkRestore");
        if (this.f7813a.size() > 0) goto L6;
        return;
    L6:
        HashMap r0 = new HashMap();     // Catch: Throwable -> L25
        Iterator<Map.Entry<String, i>> r1 = this.f7813a.entrySet().iterator();     // Catch: Throwable -> L25
    L9:
        if (r1.hasNext() == false) goto L19;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L9;
        i r3 = (i) ZeusTransformUtils.preCheckCast(r2.getValue(), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r3 == null) goto L9;
        if (b(r3) > 0) goto L9;
        r0.put(r3.f(), r3.g());     // Catch: Throwable -> L25
        goto L9
    L19:
        Iterator r4 = r0.entrySet().iterator();     // Catch: Throwable -> L25
    L20:
        if (r4.hasNext() == false) goto L40;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        d((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r5.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L25
        goto L20
    L40:
        return;
    }

    private void c(String r2) {
        monitor-enter(this);
        if (this.f7813a.containsKey(r2) == false) goto L14;
        this.f7813a.remove(r2);     // Catch: Throwable -> L11
        i();     // Catch: Throwable -> L11
        j();     // Catch: Throwable -> L11
    L14:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void m() {
        monitor-enter(this);     // Catch: Throwable -> L12
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
        goto L17
    L4:
        if (this.f7813a.size() <= 0) goto L6;
        this.f7813a.clear();     // Catch: Throwable -> L8
        i();     // Catch: Throwable -> L8
        j();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        goto L17
    L11:
        return;
    }

    private int n() {
        this.f.createNewFile();     // Catch: Throwable -> L4
        return NativeBridge.b(this.f.getAbsolutePath());
    L4:
        return -1;
    }

    private void a(int r1) {
        if (r1 <= 0) goto L5;
        NativeBridge.a(r1);
        return;
    }

    private int d(String r3) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r3) == true) goto L6;
        i r4 = (i) ZeusTransformUtils.preCheckCast(this.f7813a.get(r3), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r4 == null) goto L11;
        int r5 = r4.c();     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r5;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L16
        return 0;
    L6:
        monitor-exit(this);     // Catch: Throwable -> L16
        return -1;
    }

    private long a(i r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r2 = r5.c();
        if (r2 != 1) goto L9;
        return r5.d();
    L9:
        if (r2 == 3) goto L15;
        if (r2 == 4) goto L15;
        if (r2 == 5) goto L15;
        return 0;
    L15:
        return b(r5.b());
    }

    private void a(long r5) {
        monitor-enter(this);
        Iterator<Map.Entry<String, i>> r0 = this.f7813a.entrySet().iterator();     // Catch: Throwable -> L12
    L5:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r1 == null) goto L5;
        ((i) ZeusTransformUtils.preCheckCast(r1.getValue(), i.class, "com.obric.aiagent.plugin")).b(r5);     // Catch: Throwable -> L12
        goto L5
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private long b(i r9) {
        long r0 = System.currentTimeMillis();
        long r2 = r9.e();
        long r4 = a(r9);
        if (r4 != 0) goto L6;
        return 0;
    L6:
        if (r0 >= r2) goto L8;
        a(r0);
        j();
        r2 = r0;
    L8:
        long r1 = r0 - r2;
        if (r1 < r4) goto L11;
        return 0;
    L11:
        return r4 - r1;
    }

    private static String a(URL r9, String r10) {
        String r3 = "";
        String r11 = r9.getQuery();     // Catch: Throwable -> L23
        if (r11 != null) goto L6;
    L25:
        return r3;
    L6:
        if (r11.contains("&") == false) goto L25;
        if (r11.contains("=") == false) goto L25;
        String[] r12 = r11.split("&");     // Catch: Throwable -> L23
        int r2 = r12.length;     // Catch: Throwable -> L23
        int r5 = 0;
    L10:
        if (r5 >= r2) goto L25;
        String[] r6 = r12[r5].split("=");     // Catch: Throwable -> L23
        if (r6 == null) goto L22;
        if (r6.length < 2) goto L22;
    L20:
        e = move-exception;
        r.b(e);     // Catch: Throwable -> L23
        goto L22
    L17:
        if (URLDecoder.decode(r6[0], "UTF-8").equals(r10) == false) goto L22;
        r3 = URLDecoder.decode(r6[1], "UTF-8");     // Catch: UnsupportedEncodingException -> L20 Throwable -> L23
        r.b("getQueryParams value = " + r3);     // Catch: UnsupportedEncodingException -> L20 Throwable -> L23
    L22:
        r5 = r5 + 1;
    L23:
        th = move-exception;
        r.b(th);
        goto L25
    }

    private static void a(String r4, String r5, boolean r6, int r7) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return;
    L8:
        if (r4.equals("2010") == true) goto L22;
        String r1 = a(r4, r5);     // Catch: Throwable -> L17
        String r0 = com.bytedance.crash.o.b.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L17
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L17
        com.bytedance.crash.o.l.a(r2, DownloadConstants.PATH_KEY, r1);     // Catch: Throwable -> L17
        if (r6 == false) goto L14;
        com.bytedance.crash.o.l.a(r2, "state", "exit");     // Catch: Throwable -> L17
    L15:
        com.bytedance.crash.o.l.a(r2, "strategy", String.valueOf(r7));     // Catch: Throwable -> L17
        com.bytedance.crash.o.l.a(r2, "pname", r0);     // Catch: Throwable -> L17
        r.b("disaster:reportEvent aid=" + r4 + " path=" + r5 + " isRestore" + r6 + " strategy=" + r7);     // Catch: Throwable -> L17
        return;
    L14:
        com.bytedance.crash.o.l.a(r2, "state", "enter");     // Catch: Throwable -> L17
        goto L15
    L22:
        return;
    }

    public static void a(String r2) {
    L18:
        th = move-exception;
        r.b(th);
        return;
    L3:
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        r.a("deleteCrashLog:" + r2);     // Catch: Throwable -> L18
        if (new URL(com.bytedance.crash.config.f.j()).getPath().equals(r2) == false) goto L9;
        a(CrashType.JAVA);     // Catch: Throwable -> L18
        a(CrashType.ANR);     // Catch: Throwable -> L18
        return;
    L9:
        if (new URL(com.bytedance.crash.config.f.e()).getPath().equals(r2) == false) goto L15;
        com.bytedance.crash.resource.a.a();     // Catch: Throwable -> L18
        File r3 = com.bytedance.crash.config.e.b();     // Catch: Throwable -> L18
        if (r3 == null) goto L13;
        com.bytedance.crash.o.j.a(r3);     // Catch: Throwable -> L18
    L13:
        a(CrashType.LAUNCH);     // Catch: Throwable -> L18
        return;
    L15:
        if (new URL(com.bytedance.crash.config.f.d()).getPath().equals(r2) == false) goto L24;
        a(CrashType.NATIVE);     // Catch: Throwable -> L18
        return;
    }

    public static void a(CrashType r5) {
        if (r5 != CrashType.JAVA) goto L14;
        List<File> r6 = e(com.bytedance.crash.crash.e.f7328a);
        if (r6 == null) goto L29;
        ArrayList r0 = new ArrayList();
        Iterator<File> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        File r3 = (File) ZeusTransformUtils.preCheckCast(r7.next(), File.class, "com.obric.aiagent.plugin");
        if (new File(r3, "launch").exists() == true) goto L8;
        r0.add(r3);
    L12:
        r6 = r0;
    L29:
        if (r6 != null) goto L31;
        return;
    L31:
        if (r6.size() <= 0) goto L57;
        Iterator<File> r8 = r6.iterator();
    L35:
        if (r8.hasNext() == false) goto L58;
        File r1 = (File) ZeusTransformUtils.preCheckCast(r8.next(), File.class, "com.obric.aiagent.plugin");
        if (r1.isFile() == true) goto L35;
        com.bytedance.crash.o.j.a(r1);
        goto L35
    L58:
        return;
    L57:
        return;
    L14:
        if (r5 != CrashType.LAUNCH) goto L24;
        r6 = e(com.bytedance.crash.crash.e.f7328a);
        if (r6 == null) goto L29;
        r0 = new ArrayList();
        Iterator<File> r9 = r6.iterator();
    L19:
        if (r9.hasNext() == false) goto L12;
        File r4 = (File) ZeusTransformUtils.preCheckCast(r9.next(), File.class, "com.obric.aiagent.plugin");
        if (new File(r4, "launch").exists() == false) goto L19;
        r0.add(r4);
        goto L19
    L24:
        if (r5 != CrashType.NATIVE) goto L27;
        r6 = e(NativeCrashSummary.FILE_NAME);
        goto L29
    L27:
        if (r5 != CrashType.ANR) goto L40;
        r6 = e(com.bytedance.crash.anr.h.f7231a);
        goto L29
    }

    private static List<File> e(final String r7) {
        File r0 = com.bytedance.crash.crash.b.a();
        if (r0 != null) goto L5;
        return null;
    L5:
        File[] r1 = r0.listFiles();
        if (r1 != null) goto L8;
        return null;
    L8:
        ArrayList r2 = new ArrayList();
        int r3 = r1.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        File r5 = r1[r4];
        if (r5.listFiles(new AnonymousClass2(r7)) == null) goto L12;
        r2.add(r5);
        r4 = r4 + 1;
        goto L9
    L12:
        return null;
    L14:
        return r2;
    }
}
