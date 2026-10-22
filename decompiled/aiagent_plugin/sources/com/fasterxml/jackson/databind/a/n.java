package com.fasterxml.jackson.databind.a;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.a.f;
import com.fasterxml.jackson.databind.a.n;
import com.fasterxml.jackson.databind.e.af;
import com.fasterxml.jackson.databind.e.ai;
import com.fasterxml.jackson.databind.l.v;
import com.fasterxml.jackson.databind.r;
import com.fasterxml.jackson.databind.x;
import java.io.Serializable;

/* JADX INFO: compiled from: MapperConfigBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class n<CFG extends f, T extends n<CFG, T>> extends m<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f12233a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f12234b = 0;
    protected static final g n = null;
    protected final af o;
    protected final com.fasterxml.jackson.databind.h.d p;
    protected final x q;
    protected final Class<?> r;
    protected final j s;
    protected final v t;
    protected final h u;

    public abstract T b(long r1);

    static {
        n = g.a();
        f12233a = r.c();
        f12234b = (((r.f13100e.d() | r.f.d()) | r.g.d()) | r.h.d()) | r.f13099d.d();
    }

    public n(a r3, com.fasterxml.jackson.databind.h.d r4, af r5, v r6, h r7) {
        super(r3, f12233a);
        this.o = r5;
        this.p = r4;
        this.t = r6;
        this.q = null;
        this.r = null;
        this.s = j.a();
        this.u = r7;
    }

    public n(n<CFG, T> r1, long r2) {
        super(r1, r2);
        this.o = r1.o;
        this.p = r1.p;
        this.t = r1.t;
        this.q = r1.q;
        this.r = r1.r;
        this.s = r1.s;
        this.u = r1.u;
    }

    public final T a(r... r7) {
        long r0 = this.l;
        int r2 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L6;
        r0 = r0 | r7[r3].d();
        r3 = r3 + 1;
        goto L3
    L6:
        if (r0 != this.l) goto L9;
        return this;
    L9:
        return (T) b(r0);
    }

    public final T b(r... r7) {
        long r0 = this.l;
        int r2 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L6;
        r0 = r0 & (~r7[r3].d());
        r3 = r3 + 1;
        goto L3
    L6:
        if (r0 != this.l) goto L9;
        return this;
    L9:
        return (T) b(r0);
    }

    public final com.fasterxml.jackson.databind.h.d v() {
        return this.p;
    }

    public final x w() {
        return this.q;
    }

    public final Class<?> x() {
        return this.r;
    }

    public final j y() {
        return this.s;
    }

    @Override // com.fasterxml.jackson.databind.a.m
    public final g d(Class<?> r1) {
        g r0 = this.u.a(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return n;
    }

    public final JsonInclude.Value z() {
        return this.u.a();
    }

    @Override // com.fasterxml.jackson.databind.a.m
    public final JsonInclude.Value e(Class<?> r1) {
        JsonInclude.Value r2 = d(r1).c();
        JsonInclude.Value r0 = z();
        if (r0 != null) goto L6;
        return r2;
    L6:
        return r0.withOverrides(r2);
    }

    @Override // com.fasterxml.jackson.databind.a.m
    public final JsonInclude.Value a(Class<?> r1, Class<?> r2) {
        JsonInclude.Value r3 = d(r2).d();
        JsonInclude.Value r0 = e(r1);
        if (r0 != null) goto L6;
        return r3;
    L6:
        return r0.withOverrides(r3);
    }

    @Override // com.fasterxml.jackson.databind.a.m
    public final JsonFormat.Value f(Class<?> r1) {
        return this.u.b(r1);
    }

    public final JsonIgnoreProperties.Value g(Class<?> r1) {
        g r0 = this.u.a(r1);
        if (r0 == null) goto L7;
        JsonIgnoreProperties.Value r2 = r0.e();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return null;
    L7:
        return null;
    }

    public final JsonIgnoreProperties.Value b(Class<?> r2, com.fasterxml.jackson.databind.e.d r3) {
        com.fasterxml.jackson.databind.b r0 = j();
        if (r0 != null) goto L5;
        JsonIgnoreProperties.Value r4 = null;
    L7:
        return JsonIgnoreProperties.Value.merge(r4, g(r2));
    L5:
        r4 = r0.a(this, r3);
        goto L7
    }

    public final JsonIncludeProperties.Value c(Class<?> r1, com.fasterxml.jackson.databind.e.d r2) {
        com.fasterxml.jackson.databind.b r3 = j();
        if (r3 != null) goto L6;
        return null;
    L6:
        return r3.b(this, r2);
    }

    public final ai<?> A() {
        ai<?> r0 = this.u.d();
        long r1 = this.l;
        long r3 = f12234b;
        if ((r1 & r3) != r3) goto L5;
        return r0;
    L5:
        if (a(r.f13100e) == true) goto L8;
        r0 = r0.e(JsonAutoDetect.Visibility.NONE);
    L8:
        if (a(r.f) == true) goto L11;
        r0 = r0.a(JsonAutoDetect.Visibility.NONE);
    L11:
        if (a(r.g) == true) goto L14;
        r0 = r0.b(JsonAutoDetect.Visibility.NONE);
    L14:
        if (a(r.h) == true) goto L17;
        r0 = r0.c(JsonAutoDetect.Visibility.NONE);
    L17:
        if (a(r.f13099d) == false) goto L19;
        return r0;
    L19:
        return r0.d(JsonAutoDetect.Visibility.NONE);
    }

    @Override // com.fasterxml.jackson.databind.a.m
    public final ai<?> a(Class<?> r3, com.fasterxml.jackson.databind.e.d r4) {
        if (com.fasterxml.jackson.databind.l.h.o(r3) == false) goto L5;
        ai<?> r0 = ai.a.b();
    L6:
        com.fasterxml.jackson.databind.b r1 = j();
        if (r1 == null) goto L9;
        r0 = r1.a(r4, r0);
    L9:
        g r2 = this.u.a(r3);
        if (r2 != null) goto L12;
        return r0;
    L12:
        return r0.a(r2.h());
    L5:
        r0 = A();
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.a.m
    public final JsonSetter.Value p() {
        return this.u.b();
    }

    @Override // com.fasterxml.jackson.databind.a.m
    public Boolean q() {
        return this.u.c();
    }

    public Boolean h(Class<?> r2) {
        g r3 = this.u.a(r2);
        if (r3 == null) goto L8;
        Boolean r4 = r3.i();
        if (r4 == null) goto L8;
        return r4;
    L8:
        return this.u.c();
    }

    public x f(com.fasterxml.jackson.databind.k r2) {
        x r0 = this.q;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.t.a(r2, this);
    }

    public x i(Class<?> r2) {
        x r0 = this.q;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.t.a(r2, this);
    }

    @Override // com.fasterxml.jackson.databind.e.u.a
    public final Class<?> j(Class<?> r1) {
        return this.o.j(r1);
    }
}
