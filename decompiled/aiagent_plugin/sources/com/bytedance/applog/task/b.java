package com.bytedance.applog.task;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.applog.k;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.applog.store.DbStore;
import com.bytedance.applog.store.g;
import com.bytedance.applog.store.i;
import com.bytedance.applog.util.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BgSessionTaskModel.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f5999a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f6000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DbStore f6001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.applog.j.c f6002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.applog.c f6003e;

    static /* synthetic */ d a(b r0) {
        return r0.c();
    }

    static {
        f5999a = Collections.singletonList("BgSessionTaskModel");
    }

    b(com.bytedance.applog.c r1, DbStore r2, com.bytedance.applog.j.c r3) {
        this.f6001c = r2;
        this.f6002d = r3;
        this.f6003e = r1;
        this.f6000b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        a();
    }

    public void a() {
        TeaThread.getInst().ensureTeaThreadLite(new AnonymousClass1(this));
    }

    private d c() {
        return d.a(this.f6000b.getSharedPreferences(d(), 0).getString("key_task_session", ""));
    }

    public void a(d r1) {
        c(r1);
    }

    public void b(d r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.f6003e.Z().b(f5999a, "[Task] saveTaskSessionToSp : {}", new Object[]{r5});
        a(r5.e());
    }

    private void a(String r3) {
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        SharedPreferences.Editor r2 = this.f6000b.getSharedPreferences(d(), 0).edit();     // Catch: Throwable -> L6
        r2.putString("key_task_session", r3);     // Catch: Throwable -> L6
        r2.apply();     // Catch: Throwable -> L6
        return;
    }

    public void b() {
        this.f6003e.Z().b(f5999a, "[Task] clear task session sp", new Object[0]);
        a("");
    }

    private String d() {
        if (this.f6003e.f() == null) goto L6;
        return this.f6003e.f().F();
    L6:
        return "applog_task@" + this.f6003e.b();
    }

    private void c(d r18) {
        if (r18 != null) goto L26;
        return;
    L26:
        i r7 = new i();     // Catch: Throwable -> L23
        this.f6003e.b(r7);     // Catch: Throwable -> L23
        r7.f5992b = r18.j();     // Catch: Throwable -> L23
        r7.f5994d = r18.f();     // Catch: Throwable -> L23
        r7.A = 1;     // Catch: Throwable -> L23
        if (r18.a() == false) goto L10;
        r7.z = r18.c();     // Catch: Throwable -> L23
    L10:
        if (r18.b() == false) goto L12;
        r7.y = r18.d();     // Catch: Throwable -> L23
    L12:
        r7.u = r18.i();     // Catch: Throwable -> L23
        r7.v = r18.h();     // Catch: Throwable -> L23
        r7.x = Integer.valueOf(r18.g());     // Catch: Throwable -> L23
        if (this.f6002d.e() == false) goto L30;
        JSONObject r5 = m.a(this.f6002d.a());     // Catch: Throwable -> L23
        k r0 = this.f6003e.s();     // Catch: Throwable -> L23
        if (r0 != null) goto L28;
    L21:
        this.f6003e.Z().b(f5999a, "[Task] save task session to db : {}", new Object[]{r18});     // Catch: Throwable -> L23
        g r1 = new g();     // Catch: Throwable -> L23
        r1.a(this.f6003e.b(), r5, null, r7, null, new JSONArray[]{null, null, null}, new long[]{-1, -1, -1}, null, null, 9);     // Catch: Throwable -> L23
        this.f6001c.a(r1, true, null, null);     // Catch: Throwable -> L23
        return;
    L28:
        r0.a(r5);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        this.f6003e.N().increaseStats(j.f5823J);     // Catch: Throwable -> L23
        this.f6003e.Z().a(f5999a, "header custom callback updateHeader error", th, new Object[0]);     // Catch: Throwable -> L23
        goto L21
    L30:
        return;
    L23:
        th = move-exception;
        this.f6003e.Z().a(f5999a, "[Task] Save task session failed", th, new Object[0]);
    }
}
