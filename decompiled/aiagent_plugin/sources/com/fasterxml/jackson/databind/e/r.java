package com.fasterxml.jackson.databind.e;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: BasicBeanDescription.java */
/* JADX INFO: loaded from: classes2.dex */
public class r extends com.fasterxml.jackson.databind.c {
    private static final Class<?>[] j = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final ad f12659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.a.m<?> f12660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b f12661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final d f12662e;
    protected Class<?>[] f;
    protected boolean g;
    protected List<t> h;
    protected ac i;

    static {
        j = new Class[0];
    }

    public r(ad r1, com.fasterxml.jackson.databind.k r2, d r3) {
        super(r2);
        this.f12659b = r1;
        com.fasterxml.jackson.databind.a.m<?> r4 = r1.a();
        this.f12660c = r4;
        if (r4 != null) goto L5;
        this.f12661d = null;
    L6:
        this.f12662e = r3;
        return;
    L5:
        this.f12661d = r4.j();
        goto L6
    }

    public r(com.fasterxml.jackson.databind.a.m<?> r3, com.fasterxml.jackson.databind.k r4, d r5, List<t> r6) {
        List<t> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        super(r4);
        this.f12659b = null;
        this.f12660c = r3;
        if (r3 != null) goto L5;
        this.f12661d = null;
    L6:
        this.f12662e = r5;
        this.h = r7;
        return;
    L5:
        this.f12661d = r3.j();
        goto L6
    }

    public r(ad r3) {
        this(r3, r3.getType(), r3.b());
        this.i = r3.l();
    }

    public static r a(ad r1) {
        return new r(r1);
    }

    public static r b(ad r1) {
        return new r(r1);
    }

    public static r a(com.fasterxml.jackson.databind.a.m<?> r2, com.fasterxml.jackson.databind.k r3, d r4) {
        return new r(r2, r3, r4, Collections.emptyList());
    }

    public List<t> y() {
        if (this.h != null) goto L6;
        this.h = this.f12659b.c();
    L6:
        return this.h;
    }

    public boolean a(String r4) {
        Iterator<t> r3 = y().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((t) ZeusTransformUtils.preCheckCast(r3.next(), t.class, "com.obric.aiagent.plugin")).a().equals(r4) == false) goto L4;
        r3.remove();
        return true;
    L9:
        return false;
    }

    public boolean a(t r2) {
        if (a(r2.b()) == false) goto L6;
        return false;
    L6:
        y().add(r2);
        return true;
    }

    public boolean a(com.fasterxml.jackson.databind.x r1) {
        if (b(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public t b(com.fasterxml.jackson.databind.x r4) {
        Iterator<t> r3 = y().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        t r0 = (t) ZeusTransformUtils.preCheckCast(r3.next(), t.class, "com.obric.aiagent.plugin");
        if (r0.a(r4) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.c
    public d c() {
        return this.f12662e;
    }

    @Override // com.fasterxml.jackson.databind.c
    public ac d() {
        return this.i;
    }

    @Override // com.fasterxml.jackson.databind.c
    public List<t> g() {
        return y();
    }

    @Override // com.fasterxml.jackson.databind.c
    public j o() {
        ad r0 = this.f12659b;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.e();
    }

    @Override // com.fasterxml.jackson.databind.c
    public j p() {
        ad r0 = this.f12659b;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.f();
    }

    @Override // com.fasterxml.jackson.databind.c
    public Set<String> h() {
        ad r0 = this.f12659b;
        if (r0 != null) goto L5;
        Set<String> r1 = null;
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return Collections.emptySet();
    L5:
        r1 = r0.k();
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.c
    public boolean e() {
        return this.f12662e.f();
    }

    @Override // com.fasterxml.jackson.databind.c
    public com.fasterxml.jackson.databind.l.b f() {
        return this.f12662e.e();
    }

    @Override // com.fasterxml.jackson.databind.c
    public f n() {
        return this.f12662e.g();
    }

    @Override // com.fasterxml.jackson.databind.c
    public j r() {
        ad r0 = this.f12659b;
        if (r0 == null) goto L21;
        k r1 = r0.j();
        if (r1 == null) goto L14;
        Class<?> r5 = r1.a(0);
        if (r5 != String.class) goto L9;
    L13:
        return r1;
    L9:
        if (r5 == Object.class) goto L13;
        throw new IllegalArgumentException(String.format("Invalid 'any-setter' annotation on method '%s()': first argument not of type String or Object, but %s", new Object[]{r1.b(), r5.getName()}));
    L14:
        j r6 = this.f12659b.i();
        if (r6 != null) goto L17;
        return null;
    L17:
        if (Map.class.isAssignableFrom(r6.c()) == false) goto L20;
        return r6;
    L20:
        throw new IllegalArgumentException(String.format("Invalid 'any-setter' annotation on field '%s': type is not instance of java.util.Map", new Object[]{r6.b()}));
    L21:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.c
    public Map<Object, j> u() {
        ad r0 = this.f12659b;
        if (r0 == null) goto L7;
        return r0.d();
    L7:
        return Collections.emptyMap();
    }

    @Override // com.fasterxml.jackson.databind.c
    public List<f> j() {
        return this.f12662e.h();
    }

    @Override // com.fasterxml.jackson.databind.c
    public List<c<f, JsonCreator.Mode>> k() {
        List<f> r0 = this.f12662e.h();
        if (r0.isEmpty() == true) goto L5;
        ArrayList r1 = new ArrayList();
        Iterator<f> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        f r3 = (f) ZeusTransformUtils.preCheckCast(r2.next(), f.class, "com.obric.aiagent.plugin");
        JsonCreator.Mode r4 = this.f12661d.d(this.f12660c, r3);
        if (r4 == JsonCreator.Mode.DISABLED) goto L8;
        r1.add(c.a(r3, r4));
        goto L8
    L13:
        return r1;
    L5:
        return Collections.emptyList();
    }

    @Override // com.fasterxml.jackson.databind.c
    public Object a(boolean r4) {
        f r0 = this.f12662e.g();
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r4 == false) goto L16;
        r0.a(this.f12660c.a(com.fasterxml.jackson.databind.r.o));
    L16:
        return r0.call();
    L10:
        e = e;
    L12:
        if (e.getCause() == null) goto L14;
        e = e.getCause();
        goto L12
    L14:
        com.fasterxml.jackson.databind.l.h.a(e);
        com.fasterxml.jackson.databind.l.h.b(e);
        throw new IllegalArgumentException("Failed to instantiate bean of type " + this.f12662e.d().getName() + ": (" + e.getClass().getName() + ") " + com.fasterxml.jackson.databind.l.h.h(e), e);
    }

    @Override // com.fasterxml.jackson.databind.c
    public k a(String r1, Class<?>[] r2) {
        return this.f12662e.a(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.c
    public JsonFormat.Value a(JsonFormat.Value r3) {
        com.fasterxml.jackson.databind.b r0 = this.f12661d;
        if (r0 == null) goto L9;
        JsonFormat.Value r1 = r0.f(this.f12662e);
        if (r1 == null) goto L9;
        if (r3 != null) goto L8;
        r3 = r1;
        goto L9
    L8:
        r3 = r3.withOverrides(r1);
    L9:
        JsonFormat.Value r2 = this.f12660c.f(this.f12662e.c());
        if (r2 == null) goto L15;
        if (r3 != null) goto L14;
        return r2;
    L14:
        return r3.withOverrides(r2);
    L15:
        return r3;
    }

    @Override // com.fasterxml.jackson.databind.c
    public Class<?>[] x() {
        if (this.g == true) goto L14;
        this.g = true;
        com.fasterxml.jackson.databind.b r0 = this.f12661d;
        if (r0 != null) goto L7;
        Class<?>[] r1 = null;
    L8:
        if (r1 == null) goto L10;
    L12:
        this.f = r1;
        goto L14
    L10:
        if (this.f12660c.a(com.fasterxml.jackson.databind.r.s) == true) goto L12;
        r1 = j;
        goto L12
    L7:
        r1 = r0.e(this.f12662e);
    L14:
        return this.f;
    }

    @Override // com.fasterxml.jackson.databind.c
    public com.fasterxml.jackson.databind.l.j<Object, Object> s() {
        com.fasterxml.jackson.databind.b r0 = this.f12661d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return a(r0.r(this.f12662e));
    }

    @Override // com.fasterxml.jackson.databind.c
    public JsonInclude.Value a(JsonInclude.Value r2) {
        com.fasterxml.jackson.databind.b r0 = this.f12661d;
        if (r0 == null) goto L10;
        JsonInclude.Value r1 = r0.s(this.f12662e);
        if (r1 == null) goto L10;
        if (r2 != null) goto L9;
        return r1;
    L9:
        return r2.withOverrides(r1);
    L10:
        return r2;
    }

    @Override // com.fasterxml.jackson.databind.c
    public j q() {
        ad r0 = this.f12659b;
        if (r0 == null) goto L18;
        j r1 = r0.h();
        if (r1 != null) goto L7;
        j r4 = this.f12659b.g();
        if (r4 != null) goto L14;
        return null;
    L14:
        if (Map.class.isAssignableFrom(r4.c()) == false) goto L17;
        return r4;
    L17:
        throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", new Object[]{r4.b()}));
    L7:
        if (Map.class.isAssignableFrom(r1.c()) == false) goto L10;
        return r1;
    L10:
        throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", new Object[]{r1.b()}));
    L18:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.c
    public List<t> i() {
        Iterator<t> r5 = y().iterator();
        ArrayList r0 = null;
        HashSet r1 = null;
    L4:
        if (r5.hasNext() == false) goto L18;
        t r2 = (t) ZeusTransformUtils.preCheckCast(r5.next(), t.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b.a r3 = r2.x();
        if (r3 == null) goto L4;
        if (r3.c() == false) goto L4;
        String r4 = r3.a();
        if (r0 != null) goto L14;
        r0 = new ArrayList();
        r1 = new HashSet();
        r1.add(r4);
    L15:
        r0.add(r2);
        goto L4
    L14:
        if (r1.add(r4) == true) goto L15;
        throw new IllegalArgumentException("Multiple back-reference properties with name " + com.fasterxml.jackson.databind.l.h.b(r4));
    L18:
        return r0;
    }

    @Override // com.fasterxml.jackson.databind.c
    public List<k> l() {
        List<k> r0 = this.f12662e.i();
        if (r0.isEmpty() == false) goto L5;
        return r0;
    L5:
        ArrayList r1 = null;
        Iterator<k> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        k r3 = (k) ZeusTransformUtils.preCheckCast(r2.next(), k.class, "com.obric.aiagent.plugin");
        if (a(r3) == false) goto L7;
        if (r1 != null) goto L12;
        r1 = new ArrayList();
    L12:
        r1.add(r3);
        goto L7
    L13:
        if (r1 == null) goto L15;
        return r1;
    L15:
        return Collections.emptyList();
    }

    @Override // com.fasterxml.jackson.databind.c
    public List<c<k, JsonCreator.Mode>> m() {
        List<k> r0 = this.f12662e.i();
        if (r0.isEmpty() == true) goto L5;
        ArrayList r1 = null;
        Iterator<k> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        c<k, JsonCreator.Mode> r3 = b((k) ZeusTransformUtils.preCheckCast(r2.next(), k.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L8;
        if (r1 != null) goto L13;
        r1 = new ArrayList();
    L13:
        r1.add(r3);
        goto L8
    L14:
        if (r1 == null) goto L16;
        return r1;
    L16:
        return Collections.emptyList();
    L5:
        return Collections.emptyList();
    }

    public boolean a(k r4) {
        Class<?> r0 = r4.l();
        if (a().isAssignableFrom(r0) == true) goto L5;
        return false;
    L5:
        JsonCreator.Mode r3 = this.f12661d.d(this.f12660c, r4);
        if (r3 != null) goto L8;
    L10:
        String r5 = r4.b();
        if ("valueOf".equals(r5) == false) goto L16;
        if (r4.e() != 1) goto L16;
        return true;
    L16:
        if ("fromString".equals(r5) == true) goto L18;
    L24:
        return false;
    L18:
        if (r4.e() != 1) goto L24;
        Class<?> r6 = r4.a(0);
        if (r6 != String.class) goto L22;
    L23:
        return true;
    L22:
        if (CharSequence.class.isAssignableFrom(r6) == false) goto L24;
    L8:
        if (r3 == JsonCreator.Mode.DISABLED) goto L10;
        return true;
    }

    public c<k, JsonCreator.Mode> b(k r5) {
        Class<?> r0 = r5.l();
        if (a().isAssignableFrom(r0) == true) goto L5;
        return null;
    L5:
        JsonCreator.Mode r4 = this.f12661d.d(this.f12660c, r5);
        if (r4 != null) goto L8;
        String r1 = r5.b();
        if ("valueOf".equals(r1) == false) goto L19;
        if (r5.e() != 1) goto L19;
        return c.a(r5, r4);
    L19:
        if ("fromString".equals(r1) == true) goto L21;
    L28:
        return null;
    L21:
        if (r5.e() != 1) goto L28;
        Class<?> r2 = r5.a(0);
        if (r2 == String.class) goto L27;
        if (CharSequence.class.isAssignableFrom(r2) == false) goto L28;
    L27:
        return c.a(r5, r4);
    L8:
        if (r4 != JsonCreator.Mode.DISABLED) goto L11;
        return null;
    L11:
        return c.a(r5, r4);
    }

    @Override // com.fasterxml.jackson.databind.c
    public Class<?> v() {
        com.fasterxml.jackson.databind.b r0 = this.f12661d;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.g(this.f12662e);
    }

    @Override // com.fasterxml.jackson.databind.c
    public JsonPOJOBuilder.Value w() {
        com.fasterxml.jackson.databind.b r0 = this.f12661d;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.h(this.f12662e);
    }

    @Override // com.fasterxml.jackson.databind.c
    public com.fasterxml.jackson.databind.l.j<Object, Object> t() {
        com.fasterxml.jackson.databind.b r0 = this.f12661d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return a(r0.A(this.f12662e));
    }

    public com.fasterxml.jackson.databind.l.j<Object, Object> a(Object r5) {
        com.fasterxml.jackson.databind.l.j<?, ?> r0 = null;
        if (r5 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, com.fasterxml.jackson.databind.l.j.class) == false) goto L10;
        return (com.fasterxml.jackson.databind.l.j) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.databind.l.j.class, "com.obric.aiagent.plugin");
    L10:
        if (ZeusTransformUtils.instanceOf(r5, Class.class) == false) goto L29;
        Class<?> r6 = (Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.aiagent.plugin");
        if (r6 != com.fasterxml.jackson.databind.l.j.a.class) goto L14;
    L27:
        return null;
    L14:
        if (com.fasterxml.jackson.databind.l.h.e(r6) == true) goto L27;
        if (com.fasterxml.jackson.databind.l.j.class.isAssignableFrom(r6) == false) goto L26;
        com.fasterxml.jackson.databind.a.l r1 = this.f12660c.m();
        if (r1 == null) goto L22;
        r0 = r1.g(this.f12660c, this.f12662e, r6);
    L22:
        if (r0 == null) goto L24;
        return r0;
    L24:
        return (com.fasterxml.jackson.databind.l.j) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r6, this.f12660c.g()), com.fasterxml.jackson.databind.l.j.class, "com.obric.aiagent.plugin");
    L26:
        throw new IllegalStateException("AnnotationIntrospector returned Class " + r6.getName() + "; expected Class<Converter>");
    L29:
        throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + r5.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }
}
