package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: CollectionDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class h extends i<Collection<Object>> implements com.fasterxml.jackson.databind.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l<Object> f12413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.e f12414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.y f12415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l<Object> f12416d;

    /* JADX INFO: compiled from: CollectionDeserializer.java */
    private static final class a extends com.fasterxml.jackson.databind.b.a.z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Object> f12417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f12418b;

        a(b r1, com.fasterxml.jackson.databind.b.w r2, Class<?> r3) {
            super(r2, r3);
            this.f12417a = new ArrayList();
            this.f12418b = r1;
        }

        @Override // com.fasterxml.jackson.databind.b.a.z.a
        public void a(Object r1, Object r2) {
            this.f12418b.a(r1, r2);
        }
    }

    /* JADX INFO: compiled from: CollectionDeserializer.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<?> f12419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Collection<Object> f12420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<a> f12421c;

        public b(Class<?> r3, Collection<Object> r4) {
            Collection<Object> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
            this.f12421c = new ArrayList();
            this.f12419a = r3;
            this.f12420b = r5;
        }

        public void a(Object r3) {
            if (this.f12421c.isEmpty() == false) goto L5;
            this.f12420b.add(r3);
            return;
        L5:
            List<a> r2 = this.f12421c;
            ((a) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), a.class, "com.obric.aiagent.plugin")).f12417a.add(r3);
        }

        public com.fasterxml.jackson.databind.b.a.z.a a(com.fasterxml.jackson.databind.b.w r3) {
            a r0 = new a(this, r3, this.f12419a);
            this.f12421c.add(r0);
            return r0;
        }

        public void a(Object r5, Object r6) {
            Iterator<a> r0 = this.f12421c.iterator();
            Collection r4 = this.f12420b;
        L4:
            if (r0.hasNext() == false) goto L11;
            a r1 = (a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.aiagent.plugin");
            if (r1.b(r5) == true) goto L7;
            r4 = r1.f12417a;
            goto L4
        L7:
            r0.remove();
            r4.add(r6);
            r4.addAll(r1.f12417a);
            return;
        L11:
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + r5 + "] that wasn't previously seen as unresolved.");
        }
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public /* synthetic */ com.fasterxml.jackson.databind.l a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.d r4) {
        return b(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        return b(r3, r4, (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
    }

    public h(com.fasterxml.jackson.databind.k r9, com.fasterxml.jackson.databind.l<Object> r10, com.fasterxml.jackson.databind.h.e r11, com.fasterxml.jackson.databind.b.y r12) {
        this(r9, r10, r11, r12, null, null, null);
    }

    public h(com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.l<Object> r4, com.fasterxml.jackson.databind.h.e r5, com.fasterxml.jackson.databind.b.y r6, com.fasterxml.jackson.databind.l<Object> r7, com.fasterxml.jackson.databind.b.s r8, Boolean r9) {
        super(r3, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r9);
        this.f12413a = r4;
        this.f12414b = r5;
        this.f12415c = r6;
        this.f12416d = r7;
    }

    public h b(com.fasterxml.jackson.databind.l<?> r9, com.fasterxml.jackson.databind.l<?> r10, com.fasterxml.jackson.databind.h.e r11, com.fasterxml.jackson.databind.b.s r12, Boolean r13) {
        com.fasterxml.jackson.databind.b.s r6 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r12, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        return new h(this.f12422e, r10, r11, this.f12415c, r9, r6, r13);
    }

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        if (this.f12413a == null) goto L5;
    L9:
        return false;
    L5:
        if (this.f12414b != null) goto L9;
        if (this.f12416d != null) goto L9;
        return true;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12968b;
    }

    public h b(com.fasterxml.jackson.databind.h r8, com.fasterxml.jackson.databind.d r9) {
        com.fasterxml.jackson.databind.d r10 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r9, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b.y r0 = this.f12415c;
        if (r0 != null) goto L5;
    L16:
        com.fasterxml.jackson.databind.l<Object> r1 = null;
    L17:
        com.fasterxml.jackson.databind.l<Object> r2 = r1;
        Boolean r6 = a(r8, r10, Collection.class, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        com.fasterxml.jackson.databind.l<?> r3 = a(r8, r10, this.f12413a);
        com.fasterxml.jackson.databind.k r4 = this.f12422e.x();
        if (r3 != null) goto L20;
        com.fasterxml.jackson.databind.l<?> r5 = r8.a(r4, r10);
    L21:
        com.fasterxml.jackson.databind.l<?> r7 = r5;
        com.fasterxml.jackson.databind.h.e r11 = this.f12414b;
        if (r11 == null) goto L24;
        r11 = r11.a(r10);
    L24:
        com.fasterxml.jackson.databind.h.e r12 = r11;
        com.fasterxml.jackson.databind.b.s r13 = b(r8, r10, r7);
        if (Objects.equals(r6, this.h) == false) goto L37;
        if (r13 != this.f) goto L37;
        if (r2 != this.f12416d) goto L37;
        if (r7 != this.f12413a) goto L37;
        if (r12 != this.f12414b) goto L37;
        return this;
    L37:
        return b(r2, r7, r12, r13, r6);
    L20:
        r5 = r8.b(r3, r10, r4);
        goto L21
    L5:
        if (r0.l() == false) goto L11;
        com.fasterxml.jackson.databind.k r14 = this.f12415c.b(r8.c());
        if (r14 != null) goto L9;
        r8.b(this.f12422e, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[]{this.f12422e, this.f12415c.getClass().getName()}));
    L9:
        r1 = a(r8, r14, r10);
        goto L17
    L11:
        if (this.f12415c.m() == false) goto L16;
        com.fasterxml.jackson.databind.k r15 = this.f12415c.c(r8.c());
        if (r15 != null) goto L15;
        r8.b(this.f12422e, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[]{this.f12422e, this.f12415c.getClass().getName()}));
    L15:
        r1 = a(r8, r15, r10);
        goto L17
    }

    @Override // com.fasterxml.jackson.databind.b.b.i
    public com.fasterxml.jackson.databind.l<Object> h() {
        return this.f12413a;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public com.fasterxml.jackson.databind.b.y k() {
        return this.f12415c;
    }

    public Collection<Object> b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        com.fasterxml.jackson.databind.l<Object> r0 = this.f12416d;
        if (r0 == null) goto L7;
        return (Collection) ZeusTransformUtils.preCheckCast(this.f12415c.a(r3, r0.a(r2, r3)), Collection.class, "com.obric.aiagent.plugin");
    L7:
        if (r2.q() == false) goto L11;
        return a(r2, r3, d(r3));
    L11:
        if (r2.a(com.fasterxml.jackson.a.n.h) == false) goto L15;
        return a(r2, r3, r2.x());
    L15:
        return c(r2, r3, d(r3));
    }

    public Collection<Object> d(com.fasterxml.jackson.databind.h r2) {
        return (Collection) ZeusTransformUtils.preCheckCast(this.f12415c.a(r2), Collection.class, "com.obric.aiagent.plugin");
    }

    public Collection<Object> b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Collection<Object> r5) {
        Collection<Object> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        if (r3.q() == false) goto L7;
        return a(r3, r4, r6);
    L7:
        return c(r3, r4, r6);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.b(r1, r2);
    }

    public Collection<Object> a(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10, String r11) {
        Class<?> r6 = a();
        if (r11.isEmpty() == false) goto L9;
        com.fasterxml.jackson.databind.a.b r3 = a(r10, r10.a(b(), r6, com.fasterxml.jackson.databind.a.e.j), r6, r11, "empty String (\"\")");
        if (r3 == null) goto L13;
        return (Collection) ZeusTransformUtils.preCheckCast(a(r9, r10, r3, r6, "empty String (\"\")"), Collection.class, "com.obric.aiagent.plugin");
    L13:
        return c(r9, r10, d(r10));
    L9:
        if (l(r11) == false) goto L13;
        return (Collection) ZeusTransformUtils.preCheckCast(a(r9, r10, r10.a(b(), r6, com.fasterxml.jackson.databind.a.b.f12185a), r6, "blank String (all whitespace)"), Collection.class, "com.obric.aiagent.plugin");
    }

    public Collection<Object> a(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6, Collection<Object> r7) {
        Collection<Object> r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.aiagent.plugin");
        r5.a(r8);
        com.fasterxml.jackson.databind.l<Object> r0 = this.f12413a;
        if (r0.f() != null) goto L5;
        com.fasterxml.jackson.databind.h.e r1 = this.f12414b;
    L7:
        com.fasterxml.jackson.a.n r2 = r5.g();
        if (r2 == com.fasterxml.jackson.a.n.f12155e) goto L31;
        if (r2 != com.fasterxml.jackson.a.n.m) goto L15;
        if (this.g == true) goto L7;
        Object r3 = this.f.a(r6);     // Catch: Exception -> L20
    L18:
        r8.add(r3);     // Catch: Exception -> L20
        goto L7
    L15:
        if (r1 != null) goto L17;
        r3 = r0.a(r5, r6);     // Catch: Exception -> L20
        goto L18
    L17:
        r3 = r0.a(r5, r6, r1);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        if (r6 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == true) goto L30;
        com.fasterxml.jackson.databind.l.h.b(e);
    L30:
        throw com.fasterxml.jackson.databind.m.a(e, r8, r8.size());
    L23:
        if (r6.a(com.fasterxml.jackson.databind.i.p) == true) goto L26;
        r9 = false;
        goto L27
    L31:
        return r8;
    L5:
        return d(r5, r6, r8);
    }

    public final Collection<Object> c(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Collection<Object> r6) {
        Collection<Object> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        if (this.h != Boolean.TRUE) goto L5;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        com.fasterxml.jackson.databind.l<Object> r1 = this.f12413a;
        com.fasterxml.jackson.databind.h.e r2 = this.f12414b;
    L26:
        e = move-exception;
        if (r5.a(com.fasterxml.jackson.databind.i.p) == true) goto L31;
        com.fasterxml.jackson.databind.l.h.b(e);
    L31:
        throw com.fasterxml.jackson.databind.m.a(e, Object.class, r7.size());
    L16:
        if (r4.a(com.fasterxml.jackson.a.n.m) == true) goto L18;
        if (r2 != null) goto L23;
        Object r3 = r1.a(r4, r5);     // Catch: Exception -> L26
    L24:
        r7.add(r3);
        return r7;
    L23:
        r3 = r1.a(r4, r5, r2);     // Catch: Exception -> L26
        goto L24
    L18:
        if (this.g == false) goto L20;
        return r7;
    L20:
        r3 = this.f.a(r5);     // Catch: Exception -> L26
        goto L24
    L13:
        return (Collection) ZeusTransformUtils.preCheckCast(r5.a(this.f12422e, r4), Collection.class, "com.obric.aiagent.plugin");
    L5:
        if (this.h == null) goto L7;
    L9:
        r0 = false;
        goto L11
    L7:
        if (r5.a(com.fasterxml.jackson.databind.i.q) == false) goto L9;
        goto L9
    }

    public Collection<Object> d(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7, Collection<Object> r8) {
        Collection<Object> r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.aiagent.plugin");
        if (r6.q() == false) goto L5;
        r6.a(r9);
        com.fasterxml.jackson.databind.l<Object> r0 = this.f12413a;
        com.fasterxml.jackson.databind.h.e r1 = this.f12414b;
        b r2 = new b(this.f12422e.x().e(), r9);
    L7:
        com.fasterxml.jackson.a.n r3 = r6.g();
        if (r3 == com.fasterxml.jackson.a.n.f12155e) goto L33;
    L10:
        if (r3 != com.fasterxml.jackson.a.n.m) goto L15;
        if (this.g == true) goto L7;
        Object r4 = this.f.a(r7);     // Catch: Exception -> L20 com.fasterxml.jackson.databind.b.w -> L31
    L18:
        r2.a(r4);     // Catch: Exception -> L20 com.fasterxml.jackson.databind.b.w -> L31
        goto L7
    L15:
        if (r1 != null) goto L17;
        r4 = r0.a(r6, r7);     // Catch: Exception -> L20 com.fasterxml.jackson.databind.b.w -> L31
        goto L18
    L17:
        r4 = r0.a(r6, r7, r1);     // Catch: Exception -> L20 com.fasterxml.jackson.databind.b.w -> L31
    L31:
        e = move-exception;
        com.fasterxml.jackson.databind.b.a.z.a r5 = r2.a(e);
        e.f().a(r5);
    L20:
        e = move-exception;
        if (r7 != null) goto L23;
    L26:
        boolean r10 = true;
    L27:
        if (r10 == true) goto L30;
        com.fasterxml.jackson.databind.l.h.b(e);
    L30:
        throw com.fasterxml.jackson.databind.m.a(e, r9, r9.size());
    L23:
        if (r7.a(com.fasterxml.jackson.databind.i.p) == true) goto L26;
        r10 = false;
        goto L27
    L33:
        return r9;
    L5:
        return c(r6, r7, r9);
    }
}
