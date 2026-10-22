package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.frameworks.core.sdkmonitor.BuildConfig;
import com.bytedance.framwork.core.sdklib.a.k;
import com.bytedance.services.apm.api.IHttpService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SDKMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements com.bytedance.framwork.core.sdklib.thread.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static AtomicLong f8694a;
    private static long t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f8695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f8696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f8697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f8698e;
    private volatile int f;
    private volatile int g;
    private volatile JSONObject h;
    private volatile JSONObject i;
    private volatile IHttpService j;
    private volatile int k;
    private volatile int l;
    private volatile List<String> m;
    private volatile List<Pattern> n;
    private volatile List<String> o;
    private volatile List<Pattern> p;
    private a q;
    private Map<String, String> r;
    private List<String> s;
    private volatile boolean u;
    private volatile boolean v;
    private volatile boolean w;
    private b x;
    private String y;
    private boolean z;

    /* JADX INFO: compiled from: SDKMonitor.java */
    public interface a {
        String a();

        Map<String, String> b();
    }

    static /* synthetic */ StringBuilder a(h r0, String r1) {
        return r0.c(r1);
    }

    static /* synthetic */ void a(h r2, Context r3, JSONObject r4, a r5) {
        r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void a(h r0, JSONObject r1) {
        r0.b(r1);
    }

    static /* synthetic */ boolean a(h r0) {
        return r0.w;
    }

    static /* synthetic */ boolean a(h r0, boolean r1) {
        r0.w = r1;
        return r1;
    }

    static /* synthetic */ b b(h r0) {
        return r0.x;
    }

    static /* synthetic */ Map c(h r0) {
        return r0.r;
    }

    static /* synthetic */ List d(h r0) {
        return r0.s;
    }

    static /* synthetic */ IHttpService e(h r0) {
        return r0.c();
    }

    static /* synthetic */ boolean f(h r0) {
        return r0.u;
    }

    public h(String r3) {
        this.f8697d = 0;
        this.s = new LinkedList();
        this.u = true;
        this.y = r3;
        this.w = false;
        this.x = new b();
    }

    public boolean a(Context r5, final JSONObject r6, a r7) {
        final Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        final a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.aiagent.plugin");
        if (this.v == false) goto L5;
        return true;
    L5:
        this.v = true;
        t = System.currentTimeMillis();
        com.bytedance.framwork.core.sdklib.a.c.d.a(com.bytedance.framwork.core.sdklib.a.c.c.a());
        com.bytedance.framwork.core.sdklib.thread.a.a().a(new AnonymousClass2(this, r8, r6, r9), 5000);
        return true;
    }

    public boolean a() {
        return this.v;
    }

    private void b(Context r20, JSONObject r21, a r22) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.aiagent.plugin");
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r22, a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L32;
        if (r21 == null) goto L33;
        this.v = true;
        this.f8695b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f8696c = r21;
        r21.put(WsConstants.KEY_APP_ID, this.y);     // Catch: Exception -> L29
        this.f8696c.put(RomInfo.KEY_OS_TYPE, "Android");     // Catch: Exception -> L29
        this.f8696c.put("device_platform", "android");     // Catch: Exception -> L29
        this.f8696c.put(RomInfo.KEY_ROM_OS_VERSION, Build.VERSION.RELEASE);     // Catch: Exception -> L29
        this.f8696c.put(RomInfo.KEY_ROM_OS_API, Build.VERSION.SDK_INT);     // Catch: Exception -> L29
        this.f8696c.put(HardwareInfo.KEY_HW_VENDOR_MODEL, Build.MODEL);     // Catch: Exception -> L29
        this.f8696c.put(HardwareInfo.KEY_HW_VENDOR_BRAND, Build.BRAND);     // Catch: Exception -> L29
        this.f8696c.put(HardwareInfo.KEY_HW_VENDOR_MANUFACTURER, Build.MANUFACTURER);     // Catch: Exception -> L29
        this.f8696c.put("sdkmonitor_version", BuildConfig.VERSION_NAME);     // Catch: Exception -> L29
        this.f8696c.put("monitor_from", "sdk");     // Catch: Exception -> L29
        if (TextUtils.isEmpty(this.f8696c.optString("package_name")) == false) goto L10;
        this.f8696c.put("package_name", r2.getPackageName());     // Catch: Exception -> L29
    L10:
        PackageInfo r1 = null;
        if (TextUtils.isEmpty(this.f8696c.optString("version_name")) == false) goto L14;
        r1 = this.f8695b.getPackageManager().getPackageInfo(this.f8695b.getPackageName(), 0);     // Catch: Exception -> L29
        this.f8696c.put("version_name", r1.versionName);     // Catch: Exception -> L29
    L14:
        if (TextUtils.isEmpty(this.f8696c.optString("version_code")) == false) goto L18;
        if (r1 != null) goto L17;
        r1 = this.f8695b.getPackageManager().getPackageInfo(this.f8695b.getPackageName(), 0);     // Catch: Exception -> L29
    L17:
        this.f8696c.put("version_code", r1.versionCode);     // Catch: Exception -> L29
    L18:
        this.q = r3;     // Catch: Exception -> L29
        if (r3 != null) goto L21;
        this.q = new AnonymousClass3(this);     // Catch: Exception -> L29
    L21:
        Map<String, String> r4 = this.q.b();     // Catch: Exception -> L29
        this.r = r4;     // Catch: Exception -> L29
        if (r4 != null) goto L24;
        this.r = new HashMap();     // Catch: Exception -> L29
    L24:
        this.z = TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(this.r.get("oversea"), CharSequence.class, "com.obric.aiagent.plugin"), "1");     // Catch: Exception -> L29
        this.r.put(WsConstants.KEY_APP_ID, this.y);     // Catch: Exception -> L29
        this.r.put("device_id", this.f8696c.optString("device_id"));     // Catch: Exception -> L29
        this.r.put("device_platform", "android");     // Catch: Exception -> L29
        this.r.put("package_name", this.f8696c.optString("package_name"));     // Catch: Exception -> L29
        this.r.put("channel", this.f8696c.optString("channel"));     // Catch: Exception -> L29
        this.r.put(WsConstants.KEY_APP_VERSION, this.f8696c.optString(WsConstants.KEY_APP_VERSION));     // Catch: Exception -> L29
        this.r.put("sdkmonitor_version", BuildConfig.VERSION_NAME);     // Catch: Exception -> L29
        this.r.put("minor_version", "1");     // Catch: Exception -> L29
        if (k.d() == false) goto L27;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "initSDK:" + this.y + " " + this.r);     // Catch: Exception -> L29
    L27:
        k.a(r2);     // Catch: Exception -> L29
        k.a(this.r);     // Catch: Exception -> L29
        k.a(this.y, com.bytedance.framwork.core.sdklib.b.c.a(this.f8696c));     // Catch: Exception -> L29
        this.j = (IHttpService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IHttpService.class), IHttpService.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
        d();     // Catch: Exception -> L29
        return;
    L34:
        return;
    L33:
        return;
    }

    private IHttpService c() {
        if (this.j != null) goto L6;
        this.j = (IHttpService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IHttpService.class), IHttpService.class, "com.obric.aiagent.plugin");
    L6:
        return this.j;
    }

    void a(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (com.bytedance.framwork.core.sdklib.b.d.a(r4) == true) goto L9;
        this.s.clear();
        this.s.addAll(r4);
        return;
    }

    void b(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (com.bytedance.framwork.core.sdklib.b.d.a(r4) == true) goto L9;
        com.bytedance.framwork.core.sdklib.a.d.a().a(this.y, r4);
        return;
    }

    private void d() {
        SharedPreferences r0 = e();
        String r1 = r0.getString("monitor_net_config", null);
        this.f8697d = r0.getLong("monitor_configure_refresh_time", 0);
        if (r0.getInt("monitor_config_update", 0) != 1) goto L5;
        boolean r2 = true;
    L6:
        com.bytedance.framwork.core.sdklib.thread.a.a().a(this);
        if (TextUtils.isEmpty(r1) == false) goto L16;
    L14:
        a(false);
        return;
    L16:
        this.w = true;     // Catch: Exception -> L13
        JSONObject r3 = new JSONObject(r1);     // Catch: Exception -> L13
        if (r2 == true) goto L11;
        r3.remove("report_host_new");     // Catch: Exception -> L13
    L11:
        a(r3);     // Catch: Exception -> L13
    L13:
        a("monitor_config", "config error");
        goto L14
    L5:
        r2 = false;
        goto L6
    }

    private SharedPreferences e() {
        return this.f8695b.getSharedPreferences("monitor_config" + this.y + f.a(this.f8695b), 0);
    }

    void a(boolean r5) {
        if (this.f8698e >= 600) goto L5;
        this.f8698e = 600;
    L5:
        if (r5 == true) goto L9;
        if (f() == true) goto L9;
        return;
    L9:
        if (g.a(this.f8695b) == false) goto L25;
        final long r0 = this.f8697d;
        monitor-enter(h.class);
        this.f8697d = System.currentTimeMillis();     // Catch: Throwable -> L16
        monitor-exit(h.class);     // Catch: Throwable -> L16
        com.bytedance.framwork.core.sdklib.thread.a.a().a(new AnonymousClass4(this, r0));     // Catch: Throwable -> L20
        return;
    L27:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private boolean f() {
        if (((System.currentTimeMillis() - this.f8697d) / 1000) <= this.f8698e) goto L5;
        return true;
    L5:
        return false;
    }

    private void b(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() <= 0) goto L15;
        a(r5);     // Catch: Throwable -> L9
        SharedPreferences.Editor r0 = e().edit();     // Catch: Throwable -> L9
        r0.putLong("monitor_configure_refresh_time", System.currentTimeMillis());     // Catch: Throwable -> L9
        r0.putInt("monitor_config_update", 1);     // Catch: Throwable -> L9
        r0.putString("monitor_net_config", r5.toString());     // Catch: Throwable -> L9
        r0.apply();     // Catch: Throwable -> L9
        if (this.w == true) goto L16;
        this.w = true;     // Catch: Throwable -> L9
        this.x.a(this);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L9:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "updateToSP", th);
        return;
    }

    synchronized void a(JSONObject r9) {
        monitor-enter(this);
        if (r9 != null) goto L66;
        monitor-exit(this);
        return;
    L66:
        JSONObject r0 = com.bytedance.apm6.util.e.a(r9, e.f8688a, e.f8691d);     // Catch: Throwable -> L60
        if (r0 == null) goto L49;
        JSONObject r2 = r0.optJSONObject(e.f);     // Catch: Throwable -> L60
        if (r2 == null) goto L12;
        this.f8698e = r2.optLong(e.g, 1200);     // Catch: Throwable -> L60
    L12:
        if (this.f8698e >= 600) goto L14;
        this.f8698e = 600;     // Catch: Throwable -> L60
    L14:
        JSONObject r1 = r0.optJSONObject(e.h);     // Catch: Throwable -> L60
        if (r1 == null) goto L49;
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L60
        JSONArray r4 = r1.optJSONArray("hosts");     // Catch: Exception -> L63 Throwable -> L60
        if (r4 == null) goto L37;
        if (r4.length() <= 0) goto L37;
        int r5 = r4.length();     // Catch: Exception -> L63 Throwable -> L60
        int r6 = 0;
    L22:
        if (r6 >= r5) goto L37;
        String r7 = r4.getString(r6);     // Catch: Exception -> L63 Throwable -> L60
        if (this.z == false) goto L31;
        if (r7.contains(".snssdk.") == true) goto L29;
        if (r7.contains(".toutiao.") == false) goto L31;
    L29:
        r3.clear();     // Catch: Exception -> L63 Throwable -> L60
    L31:
        if (TextUtils.isEmpty(r7) == true) goto L35;
        if (r7.indexOf(46) <= 0) goto L35;
        r3.add(r7);     // Catch: Exception -> L63 Throwable -> L60
    L35:
        r6 = r6 + 1;
    L37:
        if (r3.isEmpty() == true) goto L39;
        com.bytedance.framwork.core.sdklib.a.d.a().a(this.y, r3);     // Catch: Throwable -> L60
    L39:
        int r8 = 60;
        this.f = r1.optInt("uploading_interval", 60);     // Catch: Throwable -> L60
        if (this.f < 0) goto L43;
        r8 = this.f;     // Catch: Throwable -> L60
    L43:
        this.f = r8;     // Catch: Throwable -> L60
        com.bytedance.framwork.core.sdklib.a.e.a().a(this.f * 1000);     // Catch: Throwable -> L60
        int r10 = 100;
        this.g = r1.optInt("once_max_count", 100);     // Catch: Throwable -> L60
        if (this.g < 0) goto L47;
        r10 = this.g;     // Catch: Throwable -> L60
    L47:
        this.g = r10;     // Catch: Throwable -> L60
        this.u = r1.optBoolean("enable_encrypt", true);     // Catch: Throwable -> L60
        com.bytedance.framwork.core.sdklib.a.d.a().a(this.y, this.u);     // Catch: Throwable -> L60
    L49:
        if (r9.length() > 0) goto L52;
        monitor-exit(this);
        return;
    L52:
        JSONObject r11 = r9.optJSONObject(e.f8689b);     // Catch: Throwable -> L60
        if (r11 == null) goto L55;
        this.h = r11.optJSONObject("allow_service_name");     // Catch: Throwable -> L60
        this.i = r11.optJSONObject("allow_log_type");     // Catch: Throwable -> L60
    L55:
        JSONObject r12 = com.bytedance.apm6.util.e.a(r9, e.f8690c, e.f8692e);     // Catch: Throwable -> L60
        if (r12 == null) goto L58;
        this.k = r12.optInt("enable_api_error_upload", 0);     // Catch: Throwable -> L60
        this.l = r12.optInt("enable_api_all_upload", 0);     // Catch: Throwable -> L60
        this.m = com.bytedance.framwork.core.sdklib.b.d.a(r12, "api_block_list");     // Catch: Throwable -> L60
        this.n = com.bytedance.framwork.core.sdklib.b.d.b(r12, "api_block_list");     // Catch: Throwable -> L60
        this.o = com.bytedance.framwork.core.sdklib.b.d.a(r12, "api_allow_list");     // Catch: Throwable -> L60
        this.p = com.bytedance.framwork.core.sdklib.b.d.b(r12, "api_allow_list");     // Catch: Throwable -> L60
    L58:
        monitor-exit(this);
        return;
    L60:
        th = move-exception;
        throw th;
    }

    public boolean a(String r3) {
        if (this.h != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.h.opt(r3) == null) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean b(String r3) {
        if (this.i != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.i.opt(r3) == null) goto L12;
        return true;
    L12:
        return false;
    }

    public int b() {
        return com.bytedance.common.utility.i.e(this.f8695b).a();
    }

    @Override // com.bytedance.framwork.core.sdklib.thread.b
    public void b(long r3) {
        if (this.f8698e > 0) goto L5;
        return;
    L5:
        a(false);
    }

    private StringBuilder c(String r5) {
        StringBuilder r0 = new StringBuilder(r5);
        if (TextUtils.isDigitsOnly(r5) == false) goto L5;
    L20:
        return r0;
    L5:
        if (this.r == null) goto L20;
        if (r5.contains("?") == true) goto L10;
        r0.append("?");
    L10:
        a(r0, "sdk_version", String.valueOf(400));
        Map<String, String> r6 = this.r;
        if (r6 == null) goto L20;
        if (r6.size() <= 0) goto L20;
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
    L16:
        if (r7.hasNext() == false) goto L20;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r1.getKey() == null) goto L16;
        a(r0, String.valueOf(r1.getKey()), String.valueOf(r1.getValue()));
        goto L16
    }

    private StringBuilder a(StringBuilder r2, String r3, String r4) {
        if (r2.charAt(r2.length() - 1) == '?') goto L5;
        r2.append("&");
    L5:
        r2.append(b(r3, "UTF-8")).append('=').append(b(r4, "UTF-8"));
        return r2;
    }

    private static String b(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "UTF-8";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private String g() {
        a r0 = this.q;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a();
    }

    public void a(String r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        if (this.w == true) goto L5;
        this.x.a(new i(r12, 0, null, r13, r14, r15, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        a(r12, 0, null, r13, r14, r15, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    public void a(String r12, int r13, JSONObject r14, JSONObject r15, JSONObject r16) {
        if (this.w == true) goto L6;
        this.x.a(new i(r12, r13, null, r14, r15, r16, System.currentTimeMillis()));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        a(r12, r13, null, r14, r15, r16, System.currentTimeMillis());     // Catch: Throwable -> L8
    }

    public void a(final long r14, final long r16, final String r18, final String r19, final String r20, final int r21, final JSONObject r22) {
        if (this.w == true) goto L6;
        this.x.a(new com.bytedance.framwork.core.sdkmonitor.a("api_all", r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        com.bytedance.framwork.core.sdklib.thread.a.a().a(new AnonymousClass5(this, r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    }

    public void b(final long r14, final long r16, final String r18, final String r19, final String r20, final int r21, final JSONObject r22) {
        if (this.w == true) goto L6;
        this.x.a(new com.bytedance.framwork.core.sdkmonitor.a("api_all", r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        com.bytedance.framwork.core.sdklib.thread.a.a().a(new AnonymousClass6(this, r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    }

    void a(final String r13, final int r14, final JSONObject r15, final JSONObject r16, final JSONObject r17, final JSONObject r18, final long r19) {
        com.bytedance.framwork.core.sdklib.thread.a.a().a(new AnonymousClass7(this, r13, r14, r15, r16, r17, r18, r19));
    }

    void b(String r4, int r5, JSONObject r6, JSONObject r7, JSONObject r8, JSONObject r9, long r10) {
        if (r9 == null) goto L21;
    L5:
        r9.put("log_type", "service_monitor");     // Catch: Throwable -> L20
        r9.put(WsConstants.KEY_SERVICE, r4);     // Catch: Throwable -> L20
        r9.put("status", r5);     // Catch: Throwable -> L20
        r9.put("network_type", b());     // Catch: Throwable -> L20
        r9.put("value", r6);     // Catch: Throwable -> L20
        if (r7 == null) goto L8;
        r9.put("category", r7);     // Catch: Throwable -> L20
    L8:
        if (r8 == null) goto L11;
        r9.put("metric", r8);     // Catch: Throwable -> L20
    L11:
        if (r9.isNull(DBHelper.COL_TIME) == false) goto L14;
        r9.put(DBHelper.COL_TIME, r10);     // Catch: Throwable -> L20
    L14:
        if (TextUtils.isEmpty(g()) == true) goto L17;
        r9.put("session_id", g());     // Catch: Throwable -> L20
    L17:
        if (a(r4) == false) goto L23;
        c(r9);     // Catch: Throwable -> L20
        com.bytedance.framwork.core.sdklib.a.h.a().a(Long.parseLong(this.y), r9);     // Catch: Throwable -> L20
        return;
    L24:
        return;
    L23:
        return;
    L21:
        r9 = new JSONObject();     // Catch: Throwable -> L20
        goto L5
    }

    public void a(String r4, JSONObject r5) {
        if (this.w == true) goto L5;
        this.x.a(new c(r4, r5, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        a(r4, r5, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    void a(final String r9, final JSONObject r10, final long r11) {
        com.bytedance.framwork.core.sdklib.thread.a.a().a(new AnonymousClass1(this, r9, r10, r11));
    }

    void b(String r4, JSONObject r5, long r6) {
        r5.put("log_type", r4);     // Catch: Throwable -> L13
        r5.put("network_type", b());     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(g()) == true) goto L7;
        r5.put("session_id", g());     // Catch: Throwable -> L13
    L7:
        if (r5.isNull(DBHelper.COL_TIME) == false) goto L10;
        r5.put(DBHelper.COL_TIME, r6);     // Catch: Throwable -> L13
    L10:
        if (b(r4) == false) goto L16;
        c(r5);     // Catch: Throwable -> L13
        com.bytedance.framwork.core.sdklib.a.h.a().a(Long.parseLong(this.y), r5);     // Catch: Throwable -> L13
        return;
    L16:
        return;
    }

    void c(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        if (e(r17) == false) goto L5;
        return;
    L5:
        if (g.a(this.f8695b) == false) goto L20;
        JSONObject r0 = a("api_all", r13, r15, r17, r18, r19, r20);
        a(r0, r21);
        if (r0 == null) goto L12;
        if (d(r17) == false) goto L12;
    L16:
        r0.put("hit_rules", 1);     // Catch: JSONException -> L15
        c(r0);     // Catch: JSONException -> L15
        com.bytedance.framwork.core.sdklib.a.h.a().a(Long.parseLong(this.y), r0);     // Catch: JSONException -> L15
        return;
    L21:
        return;
    L12:
        if (this.l != 0) goto L16;
        return;
    }

    void d(long r12, long r14, String r16, String r17, String r18, int r19, JSONObject r20) {
        if (this.k != 1) goto L5;
        return;
    L5:
        if (e(r16) == true) goto L16;
        JSONObject r0 = a("api_error", r12, r14, r16, r17, r18, r19);
        a(r0, r20);
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.length() <= 0) goto L15;
        c(r0);
        com.bytedance.framwork.core.sdklib.a.h.a().a(Long.parseLong(this.y), r0);
        return;
    L15:
        return;
    }

    private boolean d(String r3) {
        return a(r3, this.o, this.p);
    }

    private boolean e(String r3) {
        return a(r3, this.m, this.n);
    }

    private boolean a(String r5, List<String> r6, List<Pattern> r7) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return false;
    L6:
        if (com.bytedance.framwork.core.sdklib.b.d.a(r4) == true) goto L23;
        Iterator r9 = r4.iterator();
    L9:
        if (r9.hasNext() == false) goto L23;
        if (r5.contains((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return true;
    L23:
        String r10 = new URI(r5).getPath();     // Catch: Throwable -> L22
        if (com.bytedance.framwork.core.sdklib.b.d.a(r8) == true) goto L21;
        Iterator r11 = r8.iterator();     // Catch: Throwable -> L22
    L17:
        if (r11.hasNext() == false) goto L21;
        if (((Pattern) ZeusTransformUtils.preCheckCast(r11.next(), Pattern.class, "com.obric.aiagent.plugin")).matcher(r10).matches() == false) goto L17;
        return true;
    L21:
        return false;
    }

    private void a(JSONObject r4, JSONObject r5) {
        if (r4 == null) goto L19;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.length() <= 0) goto L21;
        Iterator<String> r3 = r5.keys();     // Catch: JSONException -> L12
    L9:
        if (r3.hasNext() == false) goto L22;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L12
        r4.put(r0, r5.get(r0));     // Catch: JSONException -> L12
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

    private JSONObject a(String r4, long r5, long r7, String r9, String r10, String r11, int r12) {
        if (TextUtils.isEmpty(r4) == false) goto L22;
        return null;
    L22:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L21
        r0.put("log_type", r4);     // Catch: Exception -> L21
        r0.put("duration", r5);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r9) == true) goto L9;
        r0.put("uri", Uri.parse(r9));     // Catch: Exception -> L21
    L9:
        if (r7 <= 0) goto L11;
        r0.put(DBHelper.COL_TIME, r7);     // Catch: Exception -> L21
    L11:
        r0.put("status", r12);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r10) == true) goto L16;
        r0.put("ip", r10);     // Catch: Exception -> L21
    L16:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        r0.put("trace_code", r11);     // Catch: Exception -> L21
    L19:
        r0.put("network_type", b());     // Catch: Exception -> L21
        return r0;
    L18:
        r0.put("trace_code", "");     // Catch: Exception -> L21
    L21:
        return null;
    }

    static {
        f8694a = new AtomicLong(0);
    }

    private void c(JSONObject r6) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put(WsConstants.KEY_APP_ID, this.y);     // Catch: Exception -> L4
        com.bytedance.framwork.core.sdklib.b.a.a(r0);     // Catch: Exception -> L4
        r0.put("process_name", com.bytedance.framwork.core.sdklib.b.e.a(this.f8695b));     // Catch: Exception -> L4
        r0.put("_debug_uuid", t + "_" + f8694a.getAndAdd(1));     // Catch: Exception -> L4
        r6.put("_debug_self", r0);     // Catch: Exception -> L4
        return;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
