package com.bytedance.applog.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.b.d;
import com.bytedance.applog.log.l;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.applog.util.n;
import com.bytedance.applog.util.p;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.j.u;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.AppInfo;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f5663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f5664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f5665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f5666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f5667e;
    private volatile JSONObject f;
    private final SharedPreferences g;
    private final com.bytedance.applog.c h;

    static /* synthetic */ JSONObject a(c r0) {
        return r0.f;
    }

    static /* synthetic */ com.bytedance.applog.c b(c r0) {
        return r0.h;
    }

    static {
        f5663a = Collections.singletonList("DeviceManager");
    }

    public c(com.bytedance.applog.c r3, b r4, d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        this.f5666d = false;
        this.h = r3;
        this.f5667e = r4;
        this.f5664b = r6;
        this.g = r4.f();
        this.f = new JSONObject();
    }

    public JSONObject a() {
        return p.a(this.f);
    }

    public long b() {
        an r2 = this.f5664b.f();
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.g();
    }

    public String c() {
        an r0 = this.f5664b.f();
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.e();
    }

    public void a(String r1) {
        this.f5667e.c(r1);
    }

    public String d() {
        if (this.f5665c == true) goto L9;
        b r2 = this.f5667e;
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2.p();
    L9:
        return this.f.optString("user_unique_id", "");
    }

    public boolean e() {
        return this.f5666d;
    }

    public boolean a(JSONObject r4) {
        if (r4 == null) goto L10;
        String r0 = r4.optString("device_id", "");
        String r5 = r4.optString("install_id", "");
        if (p.c(r0) == true) goto L7;
        return false;
    L7:
        if (p.c(r5) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public String f() {
        return this.f5667e.o();
    }

    public long g() {
        return this.g.getLong("version_code", 0);
    L5:
        long r1 = this.g.getInt("version_code", 0);
        this.g.edit().putLong("version_code", r1).apply();
        return r1;
    }

    public void b(JSONObject r11) {
        this.h.Z().b(f5663a, "updateHeader: {}", new Object[]{r11});
        JSONObject r0 = new JSONObject();
        String r1 = this.h.i();
        monitor-enter(this);
        p.b(r0, this.f);     // Catch: Throwable -> L32
        Iterator<String> r2 = r11.keys();     // Catch: Throwable -> L32
    L6:
        if (r2.hasNext() == false) goto L35;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r4) == true) goto L6;
        r0.put(r4, a(r11, r4));     // Catch: JSONException -> L12 Throwable -> L32
    L12:
        e = move-exception;
        this.h.Z().f("updateHeader put header key:{} value failed", new Object[]{r4, e});     // Catch: Throwable -> L32
        goto L6
    L35:
        r0.put("sdk_version", 507080190);     // Catch: Throwable -> L20
        r0.put("sdk_version_code", n.f6047c);     // Catch: Throwable -> L20
        r0.put(AppInfo.KEY_NPTH_VERSION_NAME, "5.7.8-bugfix.1");     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r1) == true) goto L18;
        r0.put("ab_sdk_version", r1);     // Catch: Throwable -> L20
    L18:
        c(r0);     // Catch: Throwable -> L20
    L22:
        Iterator<String> r12 = this.h.ao().iterator();     // Catch: Throwable -> L32
    L24:
        if (r12.hasNext() == false) goto L26;
        r0.remove((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L32
        goto L24
    L26:
        this.f = r0;     // Catch: Throwable -> L32
        this.f5665c = true;     // Catch: Throwable -> L32
        j();     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        SharedPreferences.Editor r13 = this.g.edit();
        r13.putLong("version_code", this.f.optLong("version_code", 0));
        r13.putString("channel", this.f.optString("channel", ""));
        r13.apply();
        if (l.a() == true) goto L46;
        l.a("set_header", new AnonymousClass1(this));
        return;
    L46:
        return;
    L20:
        th = move-exception;
        this.h.Z().a("updateHeader put header sdk version or load harmony info failed", th, new Object[0]);     // Catch: Throwable -> L32
        this.h.N().increaseStats(j.P);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public void h() {
        b(this.f);
    }

    private Object a(JSONObject r7, String r8) {
        if (MonitorConstants.CUSTOM.equals(r8) == false) goto L22;
        if (this.h.aq() == false) goto L22;
        JSONObject r0 = r7.optJSONObject(r8);
        if (r0 == null) goto L9;
        ArrayList r9 = new ArrayList();
        Iterator<String> r10 = r0.keys();
    L12:
        if (r10.hasNext() == false) goto L16;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        if (this.f5667e.a(r1) == true) goto L12;
        r9.add(r1);
        goto L12
    L16:
        Iterator r11 = r9.iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");
        r0.remove(r12);
        this.h.Z().a(f5663a, "custom header:{} removed by header control ", new Object[]{r12});
        this.h.N().increaseStats(j.U);
        goto L18
    L20:
        return r0;
    L9:
        return r7.opt(r8);
    L22:
        return r7.opt(r8);
    }

    private void c(JSONObject r8) {
        boolean r1 = com.bytedance.applog.util.l.a();
        if (r1 == false) goto L6;
        String r4 = "Harmony";
    L18:
        r8.put(WsConstants.KEY_PLATFORM, r4);     // Catch: JSONException -> L9
    L11:
        if (r1 == true) goto L20;
        return;
    L20:
        r8.put("harmony_os_api", u.a("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L15
        r8.put("harmony_os_version", u.a("hw_sc.build.platform.version"));     // Catch: Throwable -> L15
        r8.put("harmony_release_type", u.a("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        this.h.Z().b(f5663a, "loadHarmonyInfo failed", new Object[]{th});
        return;
    L9:
        e = move-exception;
        this.h.Z().a(f5663a, "loadHarmonyInfo failed", e, new Object[0]);
        goto L11
    L6:
        r4 = "Android";
        goto L18
    }

    public boolean i() {
        if (this.f5665c == true) goto L5;
    L7:
        return false;
    L5:
        if (e() == false) goto L7;
        return true;
    }

    private void j() {
        this.f5666d = a(this.f);
    }
}
