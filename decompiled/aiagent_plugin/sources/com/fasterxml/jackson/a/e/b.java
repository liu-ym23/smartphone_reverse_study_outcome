package com.fasterxml.jackson.a.e;

import com.fasterxml.jackson.a.h;
import com.fasterxml.jackson.a.h.i;
import com.fasterxml.jackson.a.o;
import com.fasterxml.jackson.a.q;
import com.fasterxml.jackson.a.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JsonGeneratorImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends com.fasterxml.jackson.a.a.a {
    protected static final int[] k = null;
    protected static final i<s> l = null;
    protected final com.fasterxml.jackson.a.d.e m;
    protected int[] n;
    protected int o;
    protected com.fasterxml.jackson.a.d.c p;
    protected q q;
    protected boolean r;

    static {
        k = com.fasterxml.jackson.a.d.b.c();
        l = f12078b;
    }

    public b(com.fasterxml.jackson.a.d.e r1, int r2, o r3) {
        super(r2, r3);
        this.n = k;
        this.q = com.fasterxml.jackson.a.h.e.f12102c;
        this.m = r1;
        if (h.a.f.a(r2) == false) goto L5;
        this.o = 127;
    L5:
        this.r = !h.a.f12085d.a(r2);
    }

    @Override // com.fasterxml.jackson.a.a.a, com.fasterxml.jackson.a.h
    public h a(h.a r2) {
        super.a(r2);
        if (r2 != h.a.f12085d) goto L5;
        this.r = true;
    L5:
        return this;
    }

    @Override // com.fasterxml.jackson.a.a.a
    public void c(int r1, int r2) {
        super.c(r1, r2);
        this.r = !h.a.f12085d.a(r1);
    }

    @Override // com.fasterxml.jackson.a.h
    public h b(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 0;
    L4:
        this.o = r1;
        return this;
    }

    @Override // com.fasterxml.jackson.a.h
    public h a(com.fasterxml.jackson.a.d.c r1) {
        this.p = r1;
        if (r1 != null) goto L5;
        this.n = k;
    L6:
        return this;
    L5:
        this.n = r1.a();
        goto L6
    }

    @Override // com.fasterxml.jackson.a.h
    public h a(q r3) {
        this.q = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        return this;
    }

    public void a(String r2, int r3) {
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L6;
        this.f12080d.f(this);
        return;
    L6:
        if (r3 != 2) goto L8;
        this.f12080d.d(this);
        return;
    L8:
        if (r3 != 3) goto L10;
        this.f12080d.a(this);
        return;
    L10:
        if (r3 == 5) goto L12;
        m();
        return;
    L12:
        i(r2);
        return;
    L17:
        if (this.i.b() == false) goto L20;
        this.f12080d.g(this);
        return;
    L20:
        if (this.i.d() == false) goto L29;
        this.f12080d.h(this);
        return;
    }

    public void i(String r3) {
        g(String.format("Can not %s, expecting field name (context: %s)", new Object[]{r3, this.i.e()}));
    }
}
