package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.databind.aa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: BeanSerializerBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private static final d[] i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.c f12942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected aa f12943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List<d> f12944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected d[] f12945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected a f12946e;
    protected Object f;
    protected com.fasterxml.jackson.databind.e.j g;
    protected com.fasterxml.jackson.databind.j.a.i h;

    static {
        i = new d[0];
    }

    public f(com.fasterxml.jackson.databind.c r2) {
        this.f12944c = Collections.emptyList();
        this.f12942a = r2;
    }

    public void a(aa r1) {
        this.f12943b = r1;
    }

    public void a(List<d> r3) {
        this.f12944c = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public void a(d[] r4) {
        if (r4 != null) goto L4;
    L8:
        this.f12945d = r4;
        return;
    L4:
        if (r4.length == this.f12944c.size()) goto L8;
        throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", new Object[]{Integer.valueOf(r4.length), Integer.valueOf(this.f12944c.size())}));
    }

    public void a(a r1) {
        this.f12946e = r1;
    }

    public void a(Object r1) {
        this.f = r1;
    }

    public void a(com.fasterxml.jackson.databind.e.j r4) {
        if (this.g != null) goto L7;
        this.g = r4;
        return;
    L7:
        throw new IllegalArgumentException("Multiple type ids specified with " + this.g + " and " + r4);
    }

    public void a(com.fasterxml.jackson.databind.j.a.i r1) {
        this.h = r1;
    }

    public com.fasterxml.jackson.databind.c a() {
        return this.f12942a;
    }

    public List<d> b() {
        return this.f12944c;
    }

    public a c() {
        return this.f12946e;
    }

    public Object d() {
        return this.f;
    }

    public com.fasterxml.jackson.databind.e.j e() {
        return this.g;
    }

    public com.fasterxml.jackson.databind.j.a.i f() {
        return this.h;
    }

    public com.fasterxml.jackson.databind.p<?> g() {
        if (this.g != null) goto L5;
    L7:
        a r0 = this.f12946e;
        if (r0 == null) goto L10;
        r0.a(this.f12943b);
    L10:
        List<d> r1 = this.f12944c;
        if (r1 == null) goto L21;
        if (r1.isEmpty() == true) goto L21;
        List<d> r2 = this.f12944c;
        d[] r3 = (d[]) ZeusTransformUtils.preCheckCast(r2.toArray(new d[r2.size()]), d[].class, "com.obric.aiagent.plugin");
        if (this.f12943b.a(com.fasterxml.jackson.databind.r.n) == false) goto L27;
        int r4 = r3.length;
        int r5 = 0;
    L18:
        if (r5 >= r4) goto L27;
        r3[r5].a(this.f12943b);
        r5 = r5 + 1;
    L27:
        d[] r6 = this.f12945d;
        if (r6 == null) goto L35;
        if (r6.length == this.f12944c.size()) goto L35;
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", new Object[]{Integer.valueOf(this.f12944c.size()), Integer.valueOf(this.f12945d.length)}));
    L35:
        return new e(this.f12942a.getType(), this, r3, this.f12945d);
    L21:
        if (this.f12946e == null) goto L23;
    L26:
        r3 = i;
        goto L27
    L23:
        if (this.h != null) goto L26;
        return null;
    L5:
        if (this.f12943b.a(com.fasterxml.jackson.databind.r.n) == false) goto L7;
        this.g.a(this.f12943b.a(com.fasterxml.jackson.databind.r.o));
        goto L7
    }

    public e h() {
        return e.a(this.f12942a.getType(), this);
    }
}
