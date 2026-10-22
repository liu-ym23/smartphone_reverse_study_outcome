package com.bytedance.crash.monitor;

import android.text.TextUtils;
import com.bytedance.crash.ah;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.crash.l.a f7591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.bytedance.crash.d.h f7592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.bytedance.crash.d.e f7593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final ah f7594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected volatile String f7595e;
    protected volatile long f;
    protected volatile String g;
    protected volatile String h;
    protected volatile String i;
    protected volatile long j;
    protected volatile long k;
    protected volatile long l;
    protected JSONObject m;

    public Map<String, Object> b() {
        return null;
    }

    f(String r11, String r12, long r13, long r15, long r17) {
        this(new ah(), r11, r12, r13, r15, r17);
    }

    f(ah r1, String r2, String r3, long r4, long r6, long r8) {
        this.f7595e = r2;
        this.i = r3;
        this.j = r4;
        this.k = r8;
        this.l = r6;
        this.f7594d = r1;
    }

    f(ah r1) {
        this.f7594d = r1;
    }

    public void a(String r1, Throwable r2) {
        c().a(r2, r1);
    }

    public com.bytedance.crash.d.e c() {
        if (this.f7593c != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f7593c != null) goto L8;
        this.f7593c = new com.bytedance.crash.d.e(this);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f7593c;
    }

    public void a(String r1, int r2, JSONObject r3, JSONObject r4) {
        m().a(r1, r2, r3, r4);
    }

    public com.bytedance.crash.d.h m() {
        if (this.f7592b != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f7592b != null) goto L8;
        this.f7592b = new com.bytedance.crash.d.h(this);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f7592b;
    }

    public ah n() {
        return this.f7594d;
    }

    public String e() {
        return this.f7595e;
    }

    public String f() {
        return this.h;
    }

    public String a(String r2) {
        if (TextUtils.isEmpty(this.g) == false) goto L6;
        return r2;
    L6:
        return this.g;
    }

    public long g() {
        return this.f;
    }

    public JSONObject o() {
        return this.m;
    }

    public c h() {
        return new c(this.j, this.l, 0, this.i);
    }

    public void b(String r1) {
        this.h = r1;
    }

    public void c(String r1) {
        this.g = r1;
    }

    public void g(long r1) {
        this.f = r1;
    }

    public void a(String r1, String r2) {
        this.f7594d.b(r1, r2);
    }

    public void a(com.bytedance.crash.l.a r3) {
        this.f7591a = (com.bytedance.crash.l.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.crash.l.a.class, "com.obric.aiagent.plugin");
    }

    public com.bytedance.crash.l.a p() {
        return this.f7591a;
    }

    public long i() {
        return this.j;
    }

    public long j() {
        return this.l;
    }

    public long k() {
        return this.k;
    }

    public String l() {
        return this.i;
    }
}
