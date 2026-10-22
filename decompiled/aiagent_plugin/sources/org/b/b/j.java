package org.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Queue;

/* JADX INFO: compiled from: SubstituteLogger.java */
/* JADX INFO: loaded from: classes5.dex */
public class j implements org.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f40287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f40288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile org.b.c f40289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Boolean f40290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Method f40291e;
    private org.b.a.a f;
    private final Queue<org.b.a.d> g;

    public j(String r3, Queue<org.b.a.d> r4, boolean r5) {
        Queue<org.b.a.d> r6 = (Queue) ZeusTransformUtils.wrapperContextForParams(r4, Queue.class, "com.obric.aiagent.plugin");
        this.f40288b = r3;
        this.g = r6;
        this.f40287a = r5;
    }

    @Override // org.b.c
    public String a() {
        return this.f40288b;
    }

    @Override // org.b.c
    public boolean a(org.b.a.b r1) {
        return g().a(r1);
    }

    @Override // org.b.c
    public boolean b() {
        return g().b();
    }

    @Override // org.b.c
    public boolean c() {
        return g().c();
    }

    @Override // org.b.c
    public void a(String r1, Throwable r2) {
        g().a(r1, r2);
    }

    @Override // org.b.c
    public boolean d() {
        return g().d();
    }

    @Override // org.b.c
    public boolean e() {
        return g().e();
    }

    @Override // org.b.c
    public boolean f() {
        return g().f();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L14:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L14;
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (this.f40288b.equals(r6.f40288b) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        return this.f40288b.hashCode();
    }

    public org.b.c g() {
        if (this.f40289c == null) goto L7;
        return this.f40289c;
    L7:
        if (this.f40287a == false) goto L11;
        return e.f40281a;
    L11:
        return k();
    }

    private org.b.c k() {
        if (this.f != null) goto L6;
        this.f = new org.b.a.a(this, this.g);
    L6:
        return this.f;
    }

    public void a(org.b.c r3) {
        this.f40289c = (org.b.c) ZeusTransformUtils.wrapperContextForParams(r3, org.b.c.class, "com.obric.aiagent.plugin");
    }

    public boolean h() {
        Boolean r0 = this.f40290d;
        if (r0 != null) goto L5;
        this.f40291e = this.f40289c.getClass().getMethod("log", new Class[]{org.b.a.c.class});     // Catch: NoSuchMethodException -> L8
        this.f40290d = Boolean.TRUE;     // Catch: NoSuchMethodException -> L8
    L10:
        return this.f40290d.booleanValue();
    L8:
        this.f40290d = Boolean.FALSE;
        goto L10
    L5:
        return r0.booleanValue();
    }

    public void a(org.b.a.c r4) {
        org.b.a.c r5 = (org.b.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.b.a.c.class, "com.obric.aiagent.plugin");
        if (h() == false) goto L9;
        this.f40291e.invoke(this.f40289c, new Object[]{r5});     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public boolean i() {
        if (this.f40289c != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        return ZeusTransformUtils.instanceOf(this.f40289c, e.class);
    }
}
