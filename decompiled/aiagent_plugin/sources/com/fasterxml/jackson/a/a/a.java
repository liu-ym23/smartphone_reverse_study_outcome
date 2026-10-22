package com.fasterxml.jackson.a.a;

import com.fasterxml.jackson.a.e.e;
import com.fasterxml.jackson.a.h;
import com.fasterxml.jackson.a.m;
import com.fasterxml.jackson.a.o;
import com.fasterxml.jackson.a.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.math.BigDecimal;

/* JADX INFO: compiled from: GeneratorBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final int f11973e = 0;
    protected o f;
    protected int g;
    protected boolean h;
    protected e i;
    protected boolean j;

    public abstract void h(String r1);

    static {
        f11973e = (h.a.g.c() | h.a.f.c()) | h.a.i.c();
    }

    public a(int r1, o r2) {
        this.g = r1;
        this.f = r2;
        if (h.a.i.a(r1) == false) goto L5;
        com.fasterxml.jackson.a.e.a r3 = com.fasterxml.jackson.a.e.a.a(this);
    L6:
        this.i = e.b(r3);
        this.h = h.a.g.a(r1);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(Object r1) {
        e r0 = this.i;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // com.fasterxml.jackson.a.h
    public final boolean b(h.a r1) {
        if ((this.g & r1.c()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.a.h
    public int b() {
        return this.g;
    }

    @Override // com.fasterxml.jackson.a.h
    public h a(h.a r4) {
        int r0 = r4.c();
        this.g &= ~r0;
        if ((r0 & f11973e) != 0) goto L5;
    L13:
        return this;
    L5:
        if (r4 != h.a.g) goto L8;
        this.h = false;
        goto L13
    L8:
        if (r4 != h.a.f) goto L11;
        b(0);
        goto L13
    L11:
        if (r4 != h.a.i) goto L13;
        this.i = this.i.a(null);
        goto L13
    }

    @Override // com.fasterxml.jackson.a.h
    @Deprecated
    public h a(int r2) {
        int r0 = this.g ^ r2;
        this.g = r2;
        if (r0 == 0) goto L5;
        c(r2, r0);
    L5:
        return this;
    }

    @Override // com.fasterxml.jackson.a.h
    public h a(int r3, int r4) {
        int r0 = this.g;
        int r5 = r3 & r4;
        int r6 = r5 | ((~r4) & r0);
        int r7 = r0 ^ r6;
        if (r7 == 0) goto L5;
        this.g = r6;
        c(r6, r7);
    L5:
        return this;
    }

    public void c(int r2, int r3) {
        if ((f11973e & r3) != 0) goto L5;
        return;
    L5:
        this.h = h.a.g.a(r2);
        if (h.a.f.a(r3) == false) goto L12;
        if (h.a.f.a(r2) == false) goto L10;
        b(127);
        goto L12
    L10:
        b(0);
    L12:
        if (h.a.i.a(r3) == true) goto L14;
        return;
    L14:
        if (h.a.i.a(r2) == true) goto L16;
        this.i = this.i.a(null);
        return;
    L16:
        if (this.i.n() != null) goto L21;
        this.i = this.i.a(com.fasterxml.jackson.a.e.a.a(this));
        return;
    }

    @Override // com.fasterxml.jackson.a.h
    public m a() {
        return this.i;
    }

    @Override // com.fasterxml.jackson.a.h
    public void c(Object r1) {
        j();
        if (r1 == null) goto L6;
        a(r1);
        return;
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(q r3) {
        a(((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin")).a());
    }

    @Override // com.fasterxml.jackson.a.h
    public void c(q r3) {
        b(((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin")).a());
    }

    @Override // com.fasterxml.jackson.a.h
    public void d(String r2) {
        h("write raw value");
        c(r2);
    }

    @Override // com.fasterxml.jackson.a.h
    public void e(q r3) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        h("write raw value");
        d(r4);
    }

    @Override // com.fasterxml.jackson.a.h
    public int a(com.fasterxml.jackson.a.a r1, InputStream r2, int r3) {
        n();
        return 0;
    }

    @Override // com.fasterxml.jackson.a.h
    public void h(Object r2) {
        if (r2 != null) goto L4;
        l();
        return;
    L4:
        o r0 = this.f;
        if (r0 == null) goto L8;
        r0.a(this, r2);
        return;
    L8:
        i(r2);
    }

    @Override // com.fasterxml.jackson.a.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.j = true;
    }

    public boolean o() {
        return this.j;
    }

    public String b(BigDecimal r5) {
        if (h.a.h.a(this.g) == false) goto L11;
        int r0 = r5.scale();
        if (r0 < (-9999)) goto L7;
        if (r0 > 9999) goto L7;
    L9:
        return r5.toPlainString();
    L7:
        g(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", new Object[]{Integer.valueOf(r0), 9999, 9999}));
        goto L9
    L11:
        return r5.toString();
    }
}
