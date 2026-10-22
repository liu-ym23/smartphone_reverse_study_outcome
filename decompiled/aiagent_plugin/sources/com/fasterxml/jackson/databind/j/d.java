package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.aa;
import com.fasterxml.jackson.databind.ab;
import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.w;
import com.fasterxml.jackson.databind.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: compiled from: BeanPropertyWriter.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class d extends o implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f12939c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.a.d.m f12940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final x f12941e;
    protected final com.fasterxml.jackson.databind.k f;
    protected final com.fasterxml.jackson.databind.k g;
    protected com.fasterxml.jackson.databind.k h;
    protected final transient com.fasterxml.jackson.databind.l.b i;
    protected final com.fasterxml.jackson.databind.e.j j;
    protected transient Method k;
    protected transient Field l;
    protected com.fasterxml.jackson.databind.p<Object> m;
    protected com.fasterxml.jackson.databind.p<Object> n;
    protected com.fasterxml.jackson.databind.h.h o;
    protected transient com.fasterxml.jackson.databind.j.a.k p;
    protected final boolean q;
    protected final Object r;
    protected final Class<?>[] s;
    protected transient HashMap<Object, Object> v;

    static {
        f12939c = JsonInclude.Include.NON_EMPTY;
    }

    public d(com.fasterxml.jackson.databind.e.t r3, com.fasterxml.jackson.databind.e.j r4, com.fasterxml.jackson.databind.l.b r5, com.fasterxml.jackson.databind.k r6, com.fasterxml.jackson.databind.p<?> r7, com.fasterxml.jackson.databind.h.h r8, com.fasterxml.jackson.databind.k r9, boolean r10, Object r11, Class<?>[] r12) {
        com.fasterxml.jackson.databind.l.b r13 = (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin");
        super(r3);
        this.j = r4;
        this.i = r13;
        this.f12940d = new com.fasterxml.jackson.a.d.m(r3.a());
        this.f12941e = r3.c();
        this.f = r6;
        this.m = r7;
        if (r7 != null) goto L5;
        com.fasterxml.jackson.databind.j.a.k r14 = com.fasterxml.jackson.databind.j.a.k.a();
    L6:
        this.p = r14;
        this.o = r8;
        this.g = r9;
        if (ZeusTransformUtils.instanceOf(r4, com.fasterxml.jackson.databind.e.h.class) == false) goto L10;
        this.k = null;
        this.l = (Field) ZeusTransformUtils.preCheckCast(r4.g(), Field.class, "com.obric.aiagent.plugin");
    L13:
        this.q = r10;
        this.r = r11;
        this.n = null;
        this.s = r12;
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, com.fasterxml.jackson.databind.e.k.class) == false) goto L12;
        this.k = (Method) ZeusTransformUtils.preCheckCast(r4.g(), Method.class, "com.obric.aiagent.plugin");
        this.l = null;
        goto L13
    L12:
        this.k = null;
        this.l = null;
        goto L13
    L5:
        r14 = null;
        goto L6
    }

    public d() {
        super(w.f13127c);
        this.j = null;
        this.i = null;
        this.f12940d = null;
        this.f12941e = null;
        this.s = null;
        this.f = null;
        this.m = null;
        this.p = null;
        this.o = null;
        this.g = null;
        this.k = null;
        this.l = null;
        this.q = false;
        this.r = null;
        this.n = null;
    }

    public d(d r2) {
        this(r2, r2.f12940d);
    }

    public d(d r2, x r3) {
        super(r2);
        this.f12940d = new com.fasterxml.jackson.a.d.m(r3.b());
        this.f12941e = r2.f12941e;
        this.i = r2.i;
        this.f = r2.f;
        this.j = r2.j;
        this.k = r2.k;
        this.l = r2.l;
        this.m = r2.m;
        this.n = r2.n;
        if (r2.v == null) goto L5;
        this.v = new HashMap(r2.v);
    L5:
        this.g = r2.g;
        this.p = r2.p;
        this.q = r2.q;
        this.r = r2.r;
        this.s = r2.s;
        this.o = r2.o;
        this.h = r2.h;
    }

    public d(d r2, com.fasterxml.jackson.a.d.m r3) {
        super(r2);
        this.f12940d = r3;
        this.f12941e = r2.f12941e;
        this.j = r2.j;
        this.i = r2.i;
        this.f = r2.f;
        this.k = r2.k;
        this.l = r2.l;
        this.m = r2.m;
        this.n = r2.n;
        if (r2.v == null) goto L5;
        this.v = new HashMap(r2.v);
    L5:
        this.g = r2.g;
        this.p = r2.p;
        this.q = r2.q;
        this.r = r2.r;
        this.s = r2.s;
        this.o = r2.o;
        this.h = r2.h;
    }

    public d a(com.fasterxml.jackson.databind.l.q r2) {
        String r3 = r2.a(this.f12940d.a());
        if (r3.equals(this.f12940d.toString()) == false) goto L6;
        return this;
    L6:
        return a(x.a(r3));
    }

    public d a(x r2) {
        return new d(this, r2);
    }

    public void a(com.fasterxml.jackson.databind.h.h r1) {
        this.o = r1;
    }

    public void a(com.fasterxml.jackson.databind.p<Object> r4) {
        com.fasterxml.jackson.databind.p<Object> r0 = this.m;
        if (r0 == null) goto L8;
        if (r0 == r4) goto L8;
        throw new IllegalStateException(String.format("Cannot override _serializer: had a %s, trying to set to %s", new Object[]{com.fasterxml.jackson.databind.l.h.d(this.m), com.fasterxml.jackson.databind.l.h.d(r4)}));
    L8:
        this.m = r4;
    }

    public void b(com.fasterxml.jackson.databind.p<Object> r4) {
        com.fasterxml.jackson.databind.p<Object> r0 = this.n;
        if (r0 == null) goto L8;
        if (r0 == r4) goto L8;
        throw new IllegalStateException(String.format("Cannot override _nullSerializer: had a %s, trying to set to %s", new Object[]{com.fasterxml.jackson.databind.l.h.d(this.n), com.fasterxml.jackson.databind.l.h.d(r4)}));
    L8:
        this.n = r4;
    }

    public d b(com.fasterxml.jackson.databind.l.q r2) {
        return new com.fasterxml.jackson.databind.j.a.s(this, r2);
    }

    public void a(com.fasterxml.jackson.databind.k r1) {
        this.h = r1;
    }

    public void a(aa r2) {
        this.j.a(r2.a(com.fasterxml.jackson.databind.r.o));
    }

    @Override // com.fasterxml.jackson.databind.d, com.fasterxml.jackson.databind.l.r
    public String a() {
        return this.f12940d.a();
    }

    @Override // com.fasterxml.jackson.databind.d
    public x b() {
        return new x(this.f12940d.a());
    }

    @Override // com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.k getType() {
        return this.f;
    }

    @Override // com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.e.j d() {
        return this.j;
    }

    public boolean e() {
        if (this.m == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean f() {
        if (this.n == null) goto L5;
        return true;
    L5:
        return false;
    }

    public com.fasterxml.jackson.databind.h.h g() {
        return this.o;
    }

    public boolean h() {
        return this.q;
    }

    public boolean b(x r2) {
        x r0 = this.f12941e;
        if (r0 == null) goto L7;
        return r0.equals(r2);
    L7:
        if (r2.c(this.f12940d.a()) == true) goto L9;
    L11:
        return false;
    L9:
        if (r2.d() == true) goto L11;
        return true;
    }

    public com.fasterxml.jackson.databind.k i() {
        return this.g;
    }

    public Class<?>[] j() {
        return this.s;
    }

    @Override // com.fasterxml.jackson.databind.j.o
    public void a(Object r5, com.fasterxml.jackson.a.h r6, ac r7) {
        Method r0 = this.k;
        if (r0 != null) goto L5;
        Object r1 = this.l.get(r5);
    L6:
        if (r1 == null) goto L8;
        com.fasterxml.jackson.databind.p<?> r2 = this.m;
        if (r2 != null) goto L17;
        Class<?> r3 = r1.getClass();
        com.fasterxml.jackson.databind.j.a.k r4 = this.p;
        com.fasterxml.jackson.databind.p<?> r8 = r4.a(r3);
        if (r8 != null) goto L16;
        r2 = a(r4, r3, r7);
        goto L17
    L16:
        r2 = r8;
    L17:
        Object r9 = this.r;
        if (r9 != null) goto L20;
    L27:
        if (r1 == r5) goto L29;
    L31:
        r6.b(this.f12940d);
        com.fasterxml.jackson.databind.h.h r10 = this.o;
        if (r10 != null) goto L34;
        r2.a(r1, r6, r7);
        return;
    L34:
        r2.a(r1, r6, r7, r10);
        return;
    L29:
        if (a(r5, r6, r7, r2) == false) goto L31;
        return;
    L20:
        if (f12939c != r9) goto L25;
        if (r2.a(r7, r1) == false) goto L27;
        return;
    L25:
        if (r9.equals(r1) == false) goto L27;
        return;
    L8:
        if (this.n == null) goto L36;
        r6.b(this.f12940d);
        this.n.a(null, r6, r7);
        return;
    L36:
        return;
    L5:
        r1 = r0.invoke(r5, (Object[]) ZeusTransformUtils.preCheckCast(null, Object[].class, "com.obric.aiagent.plugin"));
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.j.o
    public void b(Object r1, com.fasterxml.jackson.a.h r2, ac r3) {
        if (r2.g() == true) goto L6;
        r2.f(this.f12940d.a());
        return;
    }

    public void c(Object r5, com.fasterxml.jackson.a.h r6, ac r7) {
        Method r0 = this.k;
        if (r0 != null) goto L5;
        Object r1 = this.l.get(r5);
    L6:
        if (r1 != null) goto L12;
        com.fasterxml.jackson.databind.p<Object> r4 = this.n;
        if (r4 == null) goto L10;
        r4.a(null, r6, r7);
        return;
    L10:
        r6.l();
        return;
    L12:
        com.fasterxml.jackson.databind.p<?> r2 = this.m;
        if (r2 != null) goto L18;
        Class<?> r3 = r1.getClass();
        com.fasterxml.jackson.databind.j.a.k r8 = this.p;
        com.fasterxml.jackson.databind.p<?> r9 = r8.a(r3);
        if (r9 != null) goto L17;
        r2 = a(r8, r3, r7);
        goto L18
    L17:
        r2 = r9;
    L18:
        Object r10 = this.r;
        if (r10 != null) goto L21;
    L30:
        if (r1 == r5) goto L32;
    L34:
        com.fasterxml.jackson.databind.h.h r11 = this.o;
        if (r11 != null) goto L37;
        r2.a(r1, r6, r7);
        return;
    L37:
        r2.a(r1, r6, r7, r11);
        return;
    L32:
        if (a(r5, r6, r7, r2) == false) goto L34;
        return;
    L21:
        if (f12939c != r10) goto L27;
        if (r2.a(r7, r1) == false) goto L30;
        d(r5, r6, r7);
        return;
    L27:
        if (r10.equals(r1) == false) goto L30;
        d(r5, r6, r7);
        return;
    L5:
        r1 = r0.invoke(r5, (Object[]) ZeusTransformUtils.preCheckCast(null, Object[].class, "com.obric.aiagent.plugin"));
        goto L6
    }

    public void d(Object r1, com.fasterxml.jackson.a.h r2, ac r3) {
        com.fasterxml.jackson.databind.p<Object> r0 = this.n;
        if (r0 == null) goto L5;
        r0.a(null, r2, r3);
        return;
    L5:
        r2.l();
    }

    public com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.j.a.k r2, Class<?> r3, ac r4) {
        com.fasterxml.jackson.databind.k r0 = this.h;
        if (r0 == null) goto L5;
        com.fasterxml.jackson.databind.j.a.k.d r5 = r2.a(r4.a(r0, r3), r4, this);
    L7:
        if (r2 == r5.f12828b) goto L10;
        this.p = r5.f12828b;
    L10:
        return r5.f12827a;
    L5:
        r5 = r2.a(r3, r4, this);
        goto L7
    }

    public final Object a(Object r4) {
        Method r0 = this.k;
        if (r0 != null) goto L6;
        return this.l.get(r4);
    L6:
        return r0.invoke(r4, (Object[]) ZeusTransformUtils.preCheckCast(null, Object[].class, "com.obric.aiagent.plugin"));
    }

    public boolean a(Object r1, com.fasterxml.jackson.a.h r2, ac r3, com.fasterxml.jackson.databind.p<?> r4) {
        if (r4.b() == false) goto L5;
        return false;
    L5:
        if (r3.a(ab.f12248d) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, com.fasterxml.jackson.databind.j.b.d.class) == false) goto L22;
        r3.b(getType(), "Direct self-reference leading to cycle");
        return false;
    L22:
        return false;
    L10:
        if (r3.a(ab.g) == true) goto L12;
        return false;
    L12:
        if (this.n != null) goto L14;
        return true;
    L14:
        if (r2.a().b() == true) goto L16;
        r2.b(this.f12940d);
    L16:
        this.n.a(null, r2, r3);
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(40);
        r0.append("property '").append(a()).append("' (");
        if (this.k == null) goto L6;
        r0.append("via method ").append(this.k.getDeclaringClass().getName()).append("#").append(this.k.getName());
    L10:
        if (this.m != null) goto L12;
        r0.append(", no static serializer");
    L13:
        r0.append(')');
        return r0.toString();
    L12:
        r0.append(", static serializer of type " + this.m.getClass().getName());
        goto L13
    L6:
        if (this.l == null) goto L8;
        r0.append("field \"").append(this.l.getDeclaringClass().getName()).append("#").append(this.l.getName());
        goto L10
    L8:
        r0.append("virtual");
        goto L10
    }
}
