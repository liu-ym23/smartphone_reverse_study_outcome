package com.fasterxml.jackson.a.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: DefaultPrettyPrinter.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements f<e>, com.fasterxml.jackson.a.p, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.fasterxml.jackson.a.d.m f12102c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected b f12103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected b f12104e;
    protected final com.fasterxml.jackson.a.q f;
    protected boolean g;
    protected transient int h;
    protected n i;
    protected String j;

    /* JADX INFO: compiled from: DefaultPrettyPrinter.java */
    public static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12105a = null;

        @Override // com.fasterxml.jackson.a.h.e.c, com.fasterxml.jackson.a.h.e.b
        public boolean a() {
            return true;
        }

        public a() {
        }

        static {
            f12105a = new a();
        }

        @Override // com.fasterxml.jackson.a.h.e.c, com.fasterxml.jackson.a.h.e.b
        public void a(com.fasterxml.jackson.a.h r1, int r2) {
            r1.a(' ');
        }
    }

    /* JADX INFO: compiled from: DefaultPrettyPrinter.java */
    public interface b {
        void a(com.fasterxml.jackson.a.h r1, int r2);

        boolean a();
    }

    /* JADX INFO: compiled from: DefaultPrettyPrinter.java */
    public static class c implements b, Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f12106c = null;

        @Override // com.fasterxml.jackson.a.h.e.b
        public void a(com.fasterxml.jackson.a.h r1, int r2) {
        }

        @Override // com.fasterxml.jackson.a.h.e.b
        public boolean a() {
            return true;
        }

        public c() {
        }

        static {
            f12106c = new c();
        }
    }

    @Override // com.fasterxml.jackson.a.h.f
    public /* synthetic */ e b() {
        return a();
    }

    static {
        f12102c = new com.fasterxml.jackson.a.d.m(" ");
    }

    public e() {
        this(f12102c);
    }

    public e(com.fasterxml.jackson.a.q r3) {
        com.fasterxml.jackson.a.q r4 = (com.fasterxml.jackson.a.q) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.a.q.class, "com.obric.aiagent.plugin");
        this.f12103d = a.f12105a;
        this.f12104e = d.f12099b;
        this.g = true;
        this.f = r4;
        a(f12156a);
    }

    public e(e r2) {
        this(r2, r2.f);
    }

    public e(e r3, com.fasterxml.jackson.a.q r4) {
        com.fasterxml.jackson.a.q r5 = (com.fasterxml.jackson.a.q) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.a.q.class, "com.obric.aiagent.plugin");
        this.f12103d = a.f12105a;
        this.f12104e = d.f12099b;
        this.g = true;
        this.f12103d = r3.f12103d;
        this.f12104e = r3.f12104e;
        this.g = r3.g;
        this.h = r3.h;
        this.i = r3.i;
        this.j = r3.j;
        this.f = r5;
    }

    public e a(n r3) {
        this.i = r3;
        this.j = " " + r3.b() + " ";
        return this;
    }

    public e a() {
        if (getClass() != e.class) goto L7;
        return new e(this);
    L7:
        throw new IllegalStateException("Failed `createInstance()`: " + getClass().getName() + " does not override method; it has to");
    }

    @Override // com.fasterxml.jackson.a.p
    public void a(com.fasterxml.jackson.a.h r1) {
        com.fasterxml.jackson.a.q r0 = this.f;
        if (r0 == null) goto L6;
        r1.d(r0);
        return;
    }

    @Override // com.fasterxml.jackson.a.p
    public void b(com.fasterxml.jackson.a.h r2) {
        r2.a('{');
        if (this.f12104e.a() == true) goto L6;
        this.h++;
        return;
    }

    @Override // com.fasterxml.jackson.a.p
    public void h(com.fasterxml.jackson.a.h r2) {
        this.f12104e.a(r2, this.h);
    }

    @Override // com.fasterxml.jackson.a.p
    public void d(com.fasterxml.jackson.a.h r2) {
        if (this.g == false) goto L5;
        r2.c(this.j);
        return;
    L5:
        r2.a(this.i.b());
    }

    @Override // com.fasterxml.jackson.a.p
    public void c(com.fasterxml.jackson.a.h r2) {
        r2.a(this.i.c());
        this.f12104e.a(r2, this.h);
    }

    @Override // com.fasterxml.jackson.a.p
    public void a(com.fasterxml.jackson.a.h r2, int r3) {
        if (this.f12104e.a() == true) goto L5;
        this.h--;
    L5:
        if (r3 <= 0) goto L7;
        this.f12104e.a(r2, this.h);
    L8:
        r2.a('}');
        return;
    L7:
        r2.a(' ');
        goto L8
    }

    @Override // com.fasterxml.jackson.a.p
    public void e(com.fasterxml.jackson.a.h r2) {
        if (this.f12103d.a() == true) goto L5;
        this.h++;
    L5:
        r2.a('[');
    }

    @Override // com.fasterxml.jackson.a.p
    public void g(com.fasterxml.jackson.a.h r2) {
        this.f12103d.a(r2, this.h);
    }

    @Override // com.fasterxml.jackson.a.p
    public void f(com.fasterxml.jackson.a.h r2) {
        r2.a(this.i.d());
        this.f12103d.a(r2, this.h);
    }

    @Override // com.fasterxml.jackson.a.p
    public void b(com.fasterxml.jackson.a.h r2, int r3) {
        if (this.f12103d.a() == true) goto L5;
        this.h--;
    L5:
        if (r3 <= 0) goto L7;
        this.f12103d.a(r2, this.h);
    L8:
        r2.a(']');
        return;
    L7:
        r2.a(' ');
        goto L8
    }
}
