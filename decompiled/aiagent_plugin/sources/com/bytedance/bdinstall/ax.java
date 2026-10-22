package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: Register.java */
/* JADX INFO: loaded from: classes.dex */
class ax extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final long[] f6156e = null;
    private static final long[] f = null;
    private static final long[] g = null;
    private final com.bytedance.bdinstall.appstate.a h;
    private final u i;
    private final com.bytedance.bdinstall.a.g j;
    private final com.bytedance.bdinstall.g.a k;
    private final com.bytedance.bdinstall.d.m l;
    private final an m;

    @Override // com.bytedance.bdinstall.k
    public boolean a() {
        return true;
    }

    @Override // com.bytedance.bdinstall.k
    public boolean e() {
        return true;
    }

    @Override // com.bytedance.bdinstall.k
    public String f() {
        return DownloadFileUtils.MODE_READ;
    }

    static {
        f6156e = new long[]{10000, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, 60000, 120000, 120000, 120000, 180000, 180000};
        f = new long[]{180000, 360000, 540000, 540000, 900000, 1800000};
        g = new long[]{100, 15000, 20000, 20000, 60000, 60000, 180000, 180000, 540000, 540000};
    }

    ax(an r5, com.bytedance.bdinstall.d.m r6, u r7, com.bytedance.bdinstall.appstate.a r8) {
        com.bytedance.bdinstall.appstate.a r9 = (com.bytedance.bdinstall.appstate.a) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.bdinstall.appstate.a.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, r6, r7));
        this.l = r6;
        this.m = r5;
        this.h = r9;
        this.i = r7;
        this.j = r6;
        this.k = (com.bytedance.bdinstall.g.a) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.a.class, String.valueOf(r5.a())), com.bytedance.bdinstall.g.a.class, "com.obric.aiagent.plugin");
    }

    private static long a(Context r4, an r5, com.bytedance.bdinstall.d.m r6, u r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return 0;
    L5:
        SharedPreferences r9 = r7.a(r5);
        if (r9 != null) goto L8;
        return 0;
    L8:
        long r2 = r9.getLong("register_time", 0);
        am r10 = r6.h();
        if (r10 == null) goto L15;
        if (ba.c(r10.f()) == false) goto L15;
        if (ba.c(r10.c()) == false) goto L15;
    L18:
        return r2;
    L15:
        if (r2 == 0) goto L18;
        r9.edit().putLong("register_time", 0).apply();
        return 0;
    }

    @Override // com.bytedance.bdinstall.k
    public long b() {
        if (this.h.isForeground() == false) goto L5;
        return 21600000;
    L5:
        return 43200000;
    }

    @Override // com.bytedance.bdinstall.k
    public long[] c() {
        int r1 = this.l.f();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        t.a(null);
        return f;
    L14:
        return f6156e;
    L15:
        return f;
    L12:
        return g;
    }

    @Override // com.bytedance.bdinstall.k
    public boolean d() {
        t.a("Register#doRegister");
        com.bytedance.bdinstall.e.a r0 = n();
        if (t.a() == false) goto L5;
        t.a("Register#doRegister result = " + r0);
    L5:
        if (r0 == null) goto L10;
        boolean r1 = this.j.a(r0, this.i, this.k);
        if (r1 == false) goto L9;
        a(System.currentTimeMillis());
    L9:
        return r1;
    L10:
        return false;
    }

    private void a(long r2) {
        SharedPreferences r1 = this.i.a(this.m);
        if (r1 == null) goto L6;
        r1.edit().putLong("register_time", r2).apply();
        return;
    }

    public com.bytedance.bdinstall.e.a n() {
        String r0 = "";
        JSONObject r1 = o();
        com.bytedance.bdinstall.e.a r2 = null;
        if (r1 != null) goto L5;
        return null;
    L5:
        JSONObject r6 = new JSONObject();
        r6.put("header", r1);
        r6.put("magic_tag", "ss_app_log");
        r6.put("_gen_time", System.currentTimeMillis());
        if (t.a() == false) goto L8;
        t.a("register request header = " + r6);
    L8:
        String r5 = Uri.parse(this.i.a().a()).buildUpon().appendQueryParameter("req_id", com.bytedance.bdinstall.j.o.a()).build().toString();
        this.f6360d.a().b(true);
        if (TextUtils.isEmpty(r1.optString("device_id")) == false) goto L11;
    L13:
        boolean r9 = false;
    L31:
        com.bytedance.bdinstall.b.c r12 = com.bytedance.bdinstall.j.e.a().c(this.m.a());     // Catch: Throwable -> L25
        if (r12 == null) goto L17;
        r12.j();     // Catch: Throwable -> L25
    L17:
        r2 = d.a(this.m.c(), i.f().a(), r5, r6, this.m.B(), this.m.K(), r9, this.l.q().a(r5, true, true));     // Catch: Throwable -> L25
        if (r12 == null) goto L20;
        r12.k();     // Catch: Throwable -> L25
    L20:
        this.f6360d.a().b(false);
        an r14 = this.m;
        if (r2 == null) goto L23;
        r0 = r2.b();
    L23:
        com.bytedance.bdinstall.j.e.a(r14, r1, new JSONObject(r0));
        return r2;
    L25:
        th = move-exception;
        this.f6360d.a().b(false);
        an r15 = this.m;
        if (r2 == null) goto L29;
        r0 = r2.b();
    L29:
        com.bytedance.bdinstall.j.e.a(r15, r1, new JSONObject(r0));
        throw th;
    L11:
        if (TextUtils.isEmpty(r1.optString("install_id")) == true) goto L13;
        r9 = true;
        goto L31
    }

    JSONObject o() {
        JSONObject r0 = this.l.d();
        JSONObject r1 = new JSONObject();
        ba.a(r1, r0);
        this.l.a(r1, this.i);
        return r1;
    }

    @Override // com.bytedance.bdinstall.k
    public void a(int r2) {
        com.bytedance.bdinstall.b.c r1 = com.bytedance.bdinstall.j.e.a().c(this.f6358b.a());
        if (r1 == null) goto L6;
        r1.c(r2);
        return;
    }

    @Override // com.bytedance.bdinstall.k
    public void g() {
        com.bytedance.bdinstall.b.c r0 = com.bytedance.bdinstall.j.e.a().c(this.m.a());
        SharedPreferences r1 = com.bytedance.bdinstall.j.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.m.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.m);
        SharedPreferences.Editor r2 = r1.edit();
        if (r1.getBoolean("is_first_register_for_app", false) == true) goto L6;
        if (r2 == null) goto L6;
        r2.putBoolean("is_first_register_for_app", true);
        r2.apply();
        r0.a(true);
    L6:
        com.bytedance.bdinstall.j.e.b(this.m);
    }

    @Override // com.bytedance.bdinstall.k
    public void a(boolean r2) {
        com.bytedance.bdinstall.j.e.a().c(this.m.a()).setResult(r2);
    }
}
