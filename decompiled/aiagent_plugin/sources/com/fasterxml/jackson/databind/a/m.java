package com.fasterxml.jackson.databind.a;

import com.fasterxml.jackson.a.q;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.a.m;
import com.fasterxml.jackson.databind.e.ab;
import com.fasterxml.jackson.databind.e.ai;
import com.fasterxml.jackson.databind.e.u;
import com.fasterxml.jackson.databind.r;
import com.fasterxml.jackson.databind.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: MapperConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m<T extends m<T>> implements u.a, Serializable {
    protected static final JsonInclude.Value j = null;
    protected static final JsonFormat.Value k = null;
    protected final long l;
    protected final a m;

    public abstract JsonInclude.Value a(Class<?> r1, Class<?> r2);

    public abstract ai<?> a(Class<?> r1, com.fasterxml.jackson.databind.e.d r2);

    public abstract g d(Class<?> r1);

    public abstract JsonInclude.Value e(Class<?> r1);

    public abstract JsonFormat.Value f(Class<?> r1);

    public abstract JsonSetter.Value p();

    public abstract Boolean q();

    static {
        j = JsonInclude.Value.empty();
        k = JsonFormat.Value.empty();
    }

    public m(a r1, long r2) {
        this.m = r1;
        this.l = r2;
    }

    public m(m<T> r1, long r2) {
        this.m = r1.m;
        this.l = r2;
    }

    public static <F extends Enum<F> & f> int a(Class<F> r6) {
        Enum[] r7 = (Enum[]) ZeusTransformUtils.preCheckCast(r6.getEnumConstants(), Enum[].class, "com.obric.aiagent.plugin");
        int r0 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L8;
        Enum r4 = r7[r2];
        if (((f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin")).a() == false) goto L7;
        r3 = r3 | ((f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin")).b();
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r3;
    }

    public final boolean a(r r3) {
        return r3.a(this.l);
    }

    public final boolean f() {
        return a(r.f13096a);
    }

    public final boolean g() {
        return a(r.n);
    }

    public final boolean h() {
        return a(r.t);
    }

    public q a(String r1) {
        return new com.fasterxml.jackson.a.d.m(r1);
    }

    public u i() {
        return this.m.a();
    }

    public com.fasterxml.jackson.databind.b j() {
        if (a(r.f13096a) == false) goto L7;
        return this.m.b();
    L7:
        return ab.f12569a;
    }

    public final y k() {
        return this.m.c();
    }

    public final com.fasterxml.jackson.databind.e.a.AbstractC0271a l() {
        return this.m.d();
    }

    public final l m() {
        return this.m.i();
    }

    public final com.fasterxml.jackson.databind.h.g<?> d(com.fasterxml.jackson.databind.k r1) {
        return this.m.f();
    }

    public com.fasterxml.jackson.databind.h.c n() {
        com.fasterxml.jackson.databind.h.c r0 = this.m.g();
        if (r0 == com.fasterxml.jackson.databind.h.a.l.f12721a) goto L5;
        return r0;
    L5:
        if (a(r.E) == true) goto L7;
        return r0;
    L7:
        return new com.fasterxml.jackson.databind.h.a();
    }

    public final com.fasterxml.jackson.databind.k.o o() {
        return this.m.e();
    }

    public final com.fasterxml.jackson.databind.k b(Class<?> r1) {
        return o().a(r1);
    }

    public com.fasterxml.jackson.databind.c c(Class<?> r1) {
        return e(b(r1));
    }

    public com.fasterxml.jackson.databind.c e(com.fasterxml.jackson.databind.k r2) {
        return i().c(this, r2, this);
    }

    public JsonInclude.Value a(Class<?> r1, JsonInclude.Value r2) {
        JsonInclude.Value r0 = d(r1).c();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r2;
    }

    public JsonInclude.Value a(Class<?> r2, Class<?> r3, JsonInclude.Value r4) {
        return JsonInclude.Value.mergeAll(new JsonInclude.Value[]{r4, d(r2).c(), d(r3).d()});
    }

    public final DateFormat r() {
        return this.m.h();
    }

    public final Locale s() {
        return this.m.j();
    }

    public final TimeZone t() {
        return this.m.k();
    }

    public com.fasterxml.jackson.a.a u() {
        return this.m.l();
    }

    public com.fasterxml.jackson.databind.h.g<?> a(com.fasterxml.jackson.databind.e.b r2, Class<? extends com.fasterxml.jackson.databind.h.g<?>> r3) {
        l r0 = m();
        if (r0 == null) goto L8;
        com.fasterxml.jackson.databind.h.g<?> r4 = r0.a(this, r2, r3);
        if (r4 == null) goto L8;
        return r4;
    L8:
        return (com.fasterxml.jackson.databind.h.g) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r3, g()), com.fasterxml.jackson.databind.h.g.class, "com.obric.aiagent.plugin");
    }

    public com.fasterxml.jackson.databind.h.f b(com.fasterxml.jackson.databind.e.b r2, Class<? extends com.fasterxml.jackson.databind.h.f> r3) {
        l r0 = m();
        if (r0 == null) goto L8;
        com.fasterxml.jackson.databind.h.f r4 = r0.b(this, r2, r3);
        if (r4 == null) goto L8;
        return r4;
    L8:
        return (com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r3, g()), com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin");
    }
}
