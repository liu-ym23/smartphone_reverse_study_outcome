package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: Activator.java */
/* JADX INFO: loaded from: classes.dex */
class c extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6200e;
    private final an f;
    private final u g;
    private f h;

    @Override // com.bytedance.bdinstall.k
    public boolean a() {
        return true;
    }

    @Override // com.bytedance.bdinstall.k
    public long b() {
        return 0;
    }

    @Override // com.bytedance.bdinstall.k
    public boolean e() {
        return true;
    }

    @Override // com.bytedance.bdinstall.k
    public String f() {
        return "ac";
    }

    c(an r4, u r5) {
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
        this.f6200e = false;
        this.f = r4;
        this.g = r5;
        if (this.f6360d == null) goto L6;
        this.h = this.f6360d.b();
        return;
    }

    @Override // com.bytedance.bdinstall.k
    public long[] c() {
        return ax.f6156e;
    }

    @Override // com.bytedance.bdinstall.k
    public boolean d() {
        String r2 = n();
        if (TextUtils.isEmpty(r2) == false) goto L27;
        return false;
    L27:
    L22:
        th = move-exception;
        if (this.f6360d == null) goto L26;
        this.f6360d.a().a(false);
    L26:
        throw th;
    L6:
        if (this.f6360d == null) goto L8;
        this.f6360d.a().a(true);     // Catch: Throwable -> L22
    L8:
        com.bytedance.bdinstall.b.a r8 = com.bytedance.bdinstall.j.e.a().d(this.f.a());     // Catch: Throwable -> L22
        if (r8 == null) goto L11;
        r8.g();     // Catch: Throwable -> L22
    L11:
        boolean r0 = d.a(this.f.c(), i.f().a(), r2, this.f.B(), this.f.K(), this.f6200e);     // Catch: Throwable -> L22
        if (r8 == null) goto L14;
        r8.h();     // Catch: Throwable -> L22
    L14:
        if (r0 == false) goto L17;
        this.f6200e = true;     // Catch: Throwable -> L22
    L17:
        if (this.f6360d == null) goto L19;
        this.f6360d.a().a(false);
    L19:
        if (r0 == false) goto L21;
        h();
    L21:
        return r0;
    }

    private String n() {
        String r0 = this.g.a().b();
        f r1 = this.h;
        if (r1 == null) goto L5;
        r0 = r1.a(this.f6357a, new StringBuilder(r0), null, true, ar.f6144a);
    L5:
        StringBuilder r2 = new StringBuilder(r0);
        float r3 = p();     // Catch: Throwable -> L27
        d.a(r2, "req_id", com.bytedance.bdinstall.j.o.a());     // Catch: Throwable -> L27
        com.bytedance.bdinstall.c.b r4 = this.f.N();     // Catch: Throwable -> L27
        if (r4 == null) goto L10;
        d.a(r2, "app_trait", r4.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L27
    L10:
        d.a(r2, "timezone", r3 + "");     // Catch: Throwable -> L27
        String r5 = this.f.d();     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r5) == true) goto L30;
        d.a(r2, "package", r5);     // Catch: Throwable -> L27
        d.a(r2, "real_package_name", this.f6357a.getPackageName());     // Catch: Throwable -> L27
    L30:
        d.a(r2, "carrier", com.bytedance.bdinstall.j.q.a(this.f));     // Catch: Exception -> L15 Throwable -> L27
        d.a(r2, "mcc_mnc", com.bytedance.bdinstall.j.q.b(this.f));     // Catch: Exception -> L15 Throwable -> L27
        d.a(r2, "sim_region", com.bytedance.bdinstall.j.q.c(this.f));     // Catch: Exception -> L15 Throwable -> L27
    L17:
        e.a(this.f6357a, this.f, r2);     // Catch: Throwable -> L27
        d.a(r2, "app_version_minor", this.f.f());     // Catch: Throwable -> L27
        d.a(r2, "custom_bt", String.valueOf(o()));     // Catch: Throwable -> L27
        af r7 = this.f.S();     // Catch: Throwable -> L27
        if (r7 == null) goto L25;
        HashMap<String, String> r8 = r7.getExtraParams(ar.f6144a);     // Catch: Throwable -> L27
        if (r8 == null) goto L25;
        Iterator<Map.Entry<String, String>> r9 = r8.entrySet().iterator();     // Catch: Throwable -> L27
    L23:
        if (r9.hasNext() == false) goto L25;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        d.a(r2, (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27
    L25:
        return r2.toString();
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        t.a(th);
        return r2.toString();
    }

    private long o() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    private float p() {
        float r2 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
        if (r2 >= (-12.0f)) goto L6;
        r2 = -12.0f;
    L6:
        if (r2 > 12.0f) goto L8;
        return r2;
    L8:
        return 12.0f;
    }

    @Override // com.bytedance.bdinstall.k
    public void a(int r3) {
        com.bytedance.bdinstall.b.a r2 = com.bytedance.bdinstall.j.e.a().d(this.f6358b.a());
        if (r2 == null) goto L6;
        r2.a(r3);
        return;
    }

    @Override // com.bytedance.bdinstall.k
    public void g() {
        com.bytedance.bdinstall.b.a r0 = com.bytedance.bdinstall.j.e.a().d(this.f.a());
        SharedPreferences r1 = com.bytedance.bdinstall.j.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f);
        SharedPreferences.Editor r2 = r1.edit();
        if (r1.getBoolean("is_first_activate_for_app", false) == true) goto L6;
        if (r2 == null) goto L6;
        r2.putBoolean("is_first_activate_for_app", true);
        r2.apply();
        r0.a(true);
    L6:
        com.bytedance.bdinstall.j.e.c(this.f);
    }

    @Override // com.bytedance.bdinstall.k
    public void a(boolean r2) {
        com.bytedance.bdinstall.j.e.a().d(this.f.a()).setResult(r2);
    }
}
