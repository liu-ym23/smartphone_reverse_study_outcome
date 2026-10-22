package com.fasterxml.jackson.databind.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.b.a.ae;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BeanDeserializerBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.g f12515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h f12516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.c f12517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Map<String, v> f12518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected List<ae> f12519e;
    protected HashMap<String, v> f;
    protected HashSet<String> g;
    protected HashSet<String> h;
    protected y i;
    protected com.fasterxml.jackson.databind.b.a.s j;
    protected u k;
    protected boolean l;
    protected com.fasterxml.jackson.databind.e.k m;
    protected JsonPOJOBuilder.Value n;

    public e(com.fasterxml.jackson.databind.c r2, com.fasterxml.jackson.databind.h r3) {
        this.f12518d = new LinkedHashMap();
        this.f12517c = r2;
        this.f12516b = r3;
        this.f12515a = r3.c();
    }

    public void a(v r1, boolean r2) {
        this.f12518d.put(r1.a(), r1);
    }

    public void a(v r4) {
        v r0 = (v) ZeusTransformUtils.preCheckCast(this.f12518d.put(r4.a(), r4), v.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L8;
        if (r0 != r4) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Duplicate property '" + r4.a() + "' for " + this.f12517c.getType());
    }

    public void a(String r3, v r4) {
        if (this.f != null) goto L6;
        this.f = new HashMap(4);
    L6:
        if (this.f12515a.g() == true) goto L13;
    L11:
        this.f.put(r3, r4);
        return;
    L13:
        r4.a(this.f12515a);     // Catch: IllegalArgumentException -> L9
    L9:
        e = move-exception;
        a(e);
        goto L11
    }

    public void a(com.fasterxml.jackson.databind.x r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.l.b r5, com.fasterxml.jackson.databind.e.j r6, Object r7) {
        com.fasterxml.jackson.databind.l.b r8 = (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin");
        if (this.f12519e != null) goto L6;
        this.f12519e = new ArrayList();
    L6:
        if (this.f12515a.g() == true) goto L13;
    L11:
        this.f12519e.add(new ae(r3, r4, r6, r7));
        return;
    L13:
        r6.a(this.f12515a.a(com.fasterxml.jackson.databind.r.o));     // Catch: IllegalArgumentException -> L9
    L9:
        e = move-exception;
        a(e);
        goto L11
    }

    public void a(String r2) {
        if (this.g != null) goto L5;
        this.g = new HashSet();
    L5:
        this.g.add(r2);
    }

    public void b(String r2) {
        if (this.h != null) goto L5;
        this.h = new HashSet();
    L5:
        this.h.add(r2);
    }

    public void b(v r1) {
        a(r1);
    }

    public void a(u r2) {
        if (this.k == null) goto L8;
        if (r2 == null) goto L8;
        throw new IllegalStateException("_anySetter already set to non-null");
    L8:
        this.k = r2;
    }

    public void a(boolean r1) {
        this.l = r1;
    }

    public void a(y r1) {
        this.i = r1;
    }

    public void a(com.fasterxml.jackson.databind.b.a.s r1) {
        this.j = r1;
    }

    public void a(com.fasterxml.jackson.databind.e.k r1, JsonPOJOBuilder.Value r2) {
        this.m = r1;
        this.n = r2;
    }

    public Iterator<v> a() {
        return this.f12518d.values().iterator();
    }

    public v a(com.fasterxml.jackson.databind.x r2) {
        return (v) ZeusTransformUtils.preCheckCast(this.f12518d.get(r2.b()), v.class, "com.obric.aiagent.plugin");
    }

    public u b() {
        return this.k;
    }

    public y c() {
        return this.i;
    }

    public List<ae> d() {
        return this.f12519e;
    }

    public com.fasterxml.jackson.databind.b.a.s e() {
        return this.j;
    }

    public com.fasterxml.jackson.databind.e.k f() {
        return this.m;
    }

    public boolean c(String r2) {
        return com.fasterxml.jackson.databind.l.m.a(r2, this.g, this.h);
    }

    public com.fasterxml.jackson.databind.l<?> g() {
        Collection<v> r0 = this.f12518d.values();
        a(r0);
        com.fasterxml.jackson.databind.b.a.c r1 = com.fasterxml.jackson.databind.b.a.c.a(this.f12515a, r0, b(r0), i());
        r1.a();
        boolean r2 = !this.f12515a.a(com.fasterxml.jackson.databind.r.s);
        if (r2 == true) goto L10;
        Iterator<v> r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        if (((v) ZeusTransformUtils.preCheckCast(r3.next(), v.class, "com.obric.aiagent.plugin")).r() == false) goto L6;
        boolean r13 = true;
    L12:
        if (this.j == null) goto L15;
        r1 = r1.a(new com.fasterxml.jackson.databind.b.a.u(this.j, com.fasterxml.jackson.databind.w.f13125a));
    L15:
        return new c(this, this.f12517c, r1, this.f, this.g, this.l, this.h, r13);
    L10:
        r13 = r2;
        goto L12
    }

    public a h() {
        return new a(this, this.f12517c, this.f, this.f12518d);
    }

    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.k r8, String r9) {
        com.fasterxml.jackson.databind.e.k r0 = this.m;
        boolean r3 = true;
        if (r0 == null) goto L5;
        Class<?> r10 = r0.l();
        Class<?> r1 = r8.e();
        if (r10 != r1) goto L10;
    L14:
        Collection<v> r11 = this.f12518d.values();
        a(r11);
        com.fasterxml.jackson.databind.b.a.c r2 = com.fasterxml.jackson.databind.b.a.c.a(this.f12515a, r11, b(r11), i());
        r2.a();
        boolean r4 = !this.f12515a.a(com.fasterxml.jackson.databind.r.s);
        if (r4 == true) goto L22;
        Iterator<v> r12 = r11.iterator();
    L18:
        if (r12.hasNext() == false) goto L22;
        if (((v) ZeusTransformUtils.preCheckCast(r12.next(), v.class, "com.obric.aiagent.plugin")).r() == false) goto L18;
    L24:
        if (this.j == null) goto L27;
        r2 = r2.a(new com.fasterxml.jackson.databind.b.a.u(this.j, com.fasterxml.jackson.databind.w.f13125a));
    L27:
        return a(r8, r2, r3);
    L22:
        r3 = r4;
        goto L24
    L10:
        if (r10.isAssignableFrom(r1) == true) goto L14;
        if (r1.isAssignableFrom(r10) == true) goto L14;
        this.f12516b.b(this.f12517c.getType(), String.format("Build method `%s` has wrong return type (%s), not compatible with POJO type (%s)", new Object[]{this.m.i(), com.fasterxml.jackson.databind.l.h.c(r10), com.fasterxml.jackson.databind.l.h.b(r8)}));
        goto L14
    L5:
        if (r9.isEmpty() == true) goto L14;
        this.f12516b.b(this.f12517c.getType(), String.format("Builder class %s does not have build method (name: '%s')", new Object[]{com.fasterxml.jackson.databind.l.h.b(this.f12517c.getType()), r9}));
        goto L14
    }

    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.k r12, com.fasterxml.jackson.databind.b.a.c r13, boolean r14) {
        return new h(this, this.f12517c, r12, r13, this.f, this.g, this.l, this.h, r14);
    }

    public void a(Collection<v> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        if (this.f12515a.g() == false) goto L12;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        v r0 = (v) ZeusTransformUtils.preCheckCast(r6.next(), v.class, "com.obric.aiagent.plugin");
        r0.a(this.f12515a);     // Catch: IllegalArgumentException -> L10
    L10:
        e = move-exception;
        a(e);
    L12:
        u r7 = this.k;
        if (r7 != null) goto L29;
    L18:
        com.fasterxml.jackson.databind.e.k r8 = this.m;
        if (r8 == null) goto L35;
        r8.a(this.f12515a.a(com.fasterxml.jackson.databind.r.o));     // Catch: IllegalArgumentException -> L22
        return;
    L22:
        e = move-exception;
        a(e);
        return;
    L35:
        return;
    L29:
        r7.a(this.f12515a);     // Catch: IllegalArgumentException -> L16
    L16:
        e = move-exception;
        a(e);
        goto L18
    }

    public Map<String, List<com.fasterxml.jackson.databind.x>> b(Collection<v> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b r5 = this.f12515a.j();
        HashMap r0 = null;
        if (r5 == null) goto L15;
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L15;
        v r2 = (v) ZeusTransformUtils.preCheckCast(r8.next(), v.class, "com.obric.aiagent.plugin");
        List<com.fasterxml.jackson.databind.x> r3 = r5.k(r2.d());
        if (r3 == null) goto L6;
        if (r3.isEmpty() == true) goto L6;
        if (r0 != null) goto L14;
        r0 = new HashMap();
    L14:
        r0.put(r2.a(), r3);
    L15:
        if (r0 == null) goto L17;
        return r0;
    L17:
        return Collections.emptyMap();
    }

    public boolean i() {
        Boolean r0 = this.f12517c.a(null).getFeature(JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        if (r0 != null) goto L6;
        return this.f12515a.a(com.fasterxml.jackson.databind.r.v);
    L6:
        return r0.booleanValue();
    }

    public void a(IllegalArgumentException r4) {
        this.f12516b.a(this.f12517c, r4.getMessage(), new Object[0]);     // Catch: com.fasterxml.jackson.databind.f -> L4
        return;
    L4:
        e = move-exception;
        if (e.getCause() != null) goto L8;
        e.initCause(r4);
    L8:
        throw e;
    }
}
