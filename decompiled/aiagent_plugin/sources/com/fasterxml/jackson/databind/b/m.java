package com.fasterxml.jackson.databind.b;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DefaultDeserializationContext.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends com.fasterxml.jackson.databind.h implements Serializable {
    protected transient LinkedHashMap<ObjectIdGenerator.IdKey, com.fasterxml.jackson.databind.b.a.z> n;
    private List<ObjectIdResolver> o;

    /* JADX INFO: compiled from: DefaultDeserializationContext.java */
    public static final class a extends m {
        public a(p r2) {
            super(r2, null);
        }

        private a(a r1, com.fasterxml.jackson.databind.g r2, com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.j r4) {
            super(r1, r2, r3, r4);
        }

        private a(a r1, com.fasterxml.jackson.databind.g r2) {
            super(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.m
        public m a(com.fasterxml.jackson.databind.g r2, com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.j r4) {
            return new a(this, r2, r3, r4);
        }

        @Override // com.fasterxml.jackson.databind.b.m
        public m a(com.fasterxml.jackson.databind.g r2) {
            return new a(this, r2);
        }
    }

    public abstract m a(com.fasterxml.jackson.databind.g r1);

    public abstract m a(com.fasterxml.jackson.databind.g r1, com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.j r3);

    public m(p r1, o r2) {
        super(r1, r2);
    }

    public m(m r1, com.fasterxml.jackson.databind.g r2, com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.j r4) {
        super(r1, r2, r3, r4);
    }

    public m(m r1, com.fasterxml.jackson.databind.g r2) {
        super(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.h
    public com.fasterxml.jackson.databind.b.a.z a(Object r5, ObjectIdGenerator<?> r6, ObjectIdResolver r7) {
        ObjectIdResolver r8 = (ObjectIdResolver) ZeusTransformUtils.wrapperContextForParams(r7, ObjectIdResolver.class, "com.obric.aiagent.plugin");
        ObjectIdResolver r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        ObjectIdGenerator.IdKey r9 = r6.key(r5);
        LinkedHashMap<ObjectIdGenerator.IdKey, com.fasterxml.jackson.databind.b.a.z> r10 = this.n;
        if (r10 != null) goto L8;
        this.n = new LinkedHashMap();
    L11:
        List<ObjectIdResolver> r11 = this.o;
        if (r11 != null) goto L14;
        this.o = new ArrayList(8);
    L20:
        if (r0 != null) goto L22;
        r0 = r8.newForDeserialization(this);
        this.o.add(r0);
    L22:
        com.fasterxml.jackson.databind.b.a.z r12 = a(r9);
        r12.a(r0);
        this.n.put(r9, r12);
        return r12;
    L14:
        Iterator<ObjectIdResolver> r13 = r11.iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        ObjectIdResolver r2 = (ObjectIdResolver) ZeusTransformUtils.preCheckCast(r13.next(), ObjectIdResolver.class, "com.obric.aiagent.plugin");
        if (r2.canUseFor(r8) == false) goto L16;
        r0 = r2;
        goto L20
    L8:
        com.fasterxml.jackson.databind.b.a.z r14 = (com.fasterxml.jackson.databind.b.a.z) ZeusTransformUtils.preCheckCast(r10.get(r9), com.fasterxml.jackson.databind.b.a.z.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L11;
        return r14;
    }

    public com.fasterxml.jackson.databind.b.a.z a(ObjectIdGenerator.IdKey r1) {
        return new com.fasterxml.jackson.databind.b.a.z(r1);
    }

    public void q() {
        if (this.n != null) goto L6;
        return;
    L6:
        if (a(com.fasterxml.jackson.databind.i.k) == true) goto L8;
        return;
    L8:
        w r0 = null;
        Iterator<Map.Entry<ObjectIdGenerator.IdKey, com.fasterxml.jackson.databind.b.a.z>> r1 = this.n.entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L23;
        com.fasterxml.jackson.databind.b.a.z r2 = (com.fasterxml.jackson.databind.b.a.z) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), com.fasterxml.jackson.databind.b.a.z.class, "com.obric.aiagent.plugin");
        if (r2.c() == false) goto L10;
        if (a(r2) == true) goto L10;
        if (r0 != null) goto L19;
        r0 = new w(j(), "Unresolved forward references for: ").i();
    L19:
        Object r3 = r2.a().key;
        Iterator<com.fasterxml.jackson.databind.b.a.z.a> r4 = r2.d();
    L21:
        if (r4.hasNext() == false) goto L10;
        com.fasterxml.jackson.databind.b.a.z.a r5 = (com.fasterxml.jackson.databind.b.a.z.a) ZeusTransformUtils.preCheckCast(r4.next(), com.fasterxml.jackson.databind.b.a.z.a.class, "com.obric.aiagent.plugin");
        r0.a(r3, r5.b(), r5.a());
        goto L21
    L23:
        if (r0 != null) goto L25;
        return;
    L25:
        throw r0;
    }

    public boolean a(com.fasterxml.jackson.databind.b.a.z r1) {
        return r1.a(this);
    }

    @Override // com.fasterxml.jackson.databind.h
    public com.fasterxml.jackson.databind.l<Object> b(com.fasterxml.jackson.databind.e.b r4, Object r5) {
        com.fasterxml.jackson.databind.l<?> r0 = null;
        if (r5 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, com.fasterxml.jackson.databind.l.class) == false) goto L9;
        com.fasterxml.jackson.databind.l<?> r6 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
    L25:
        if (ZeusTransformUtils.instanceOf(r6, t.class) == false) goto L27;
        ((t) ZeusTransformUtils.preCheckCast(r6, t.class, "com.obric.aiagent.plugin")).d(this);
    L27:
        return r6;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, Class.class) == false) goto L32;
        Class<?> r7 = (Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.aiagent.plugin");
        if (r7 != com.fasterxml.jackson.databind.l.a.class) goto L13;
    L30:
        return null;
    L13:
        if (com.fasterxml.jackson.databind.l.h.e(r7) == true) goto L30;
        if (com.fasterxml.jackson.databind.l.class.isAssignableFrom(r7) == false) goto L29;
        com.fasterxml.jackson.databind.a.l r1 = this.f12710c.m();
        if (r1 == null) goto L21;
        r0 = r1.a(this.f12710c, r4, r7);
    L21:
        if (r0 != null) goto L23;
        r6 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r7, this.f12710c.g()), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
        goto L25
    L23:
        r6 = r0;
        goto L25
    L29:
        throw new IllegalStateException("AnnotationIntrospector returned Class " + r7.getName() + "; expected Class<JsonDeserializer>");
    L32:
        throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + r5.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
    }

    @Override // com.fasterxml.jackson.databind.h
    public final com.fasterxml.jackson.databind.q c(com.fasterxml.jackson.databind.e.b r4, Object r5) {
        com.fasterxml.jackson.databind.q r0 = null;
        if (r5 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, com.fasterxml.jackson.databind.q.class) == false) goto L9;
        com.fasterxml.jackson.databind.q r6 = (com.fasterxml.jackson.databind.q) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.databind.q.class, "com.obric.aiagent.plugin");
    L25:
        if (ZeusTransformUtils.instanceOf(r6, t.class) == false) goto L27;
        ((t) ZeusTransformUtils.preCheckCast(r6, t.class, "com.obric.aiagent.plugin")).d(this);
    L27:
        return r6;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, Class.class) == false) goto L32;
        Class<?> r7 = (Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.aiagent.plugin");
        if (r7 != com.fasterxml.jackson.databind.q.a.class) goto L13;
    L30:
        return null;
    L13:
        if (com.fasterxml.jackson.databind.l.h.e(r7) == true) goto L30;
        if (com.fasterxml.jackson.databind.q.class.isAssignableFrom(r7) == false) goto L29;
        com.fasterxml.jackson.databind.a.l r1 = this.f12710c.m();
        if (r1 == null) goto L21;
        r0 = r1.b(this.f12710c, r4, r7);
    L21:
        if (r0 != null) goto L23;
        r6 = (com.fasterxml.jackson.databind.q) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r7, this.f12710c.g()), com.fasterxml.jackson.databind.q.class, "com.obric.aiagent.plugin");
        goto L25
    L23:
        r6 = r0;
        goto L25
    L29:
        throw new IllegalStateException("AnnotationIntrospector returned Class " + r7.getName() + "; expected Class<KeyDeserializer>");
    L32:
        throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + r5.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
    }

    public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.l<Object> r4, Object r5) {
        if (this.f12710c.a() == true) goto L5;
        if (r5 != null) goto L10;
        return r4.a(r2, this);
    L10:
        return r4.a(r2, this, r5);
    L5:
        return b(r2, r3, r4, r5);
    }

    public Object b(com.fasterxml.jackson.a.k r8, com.fasterxml.jackson.databind.k r9, com.fasterxml.jackson.databind.l<Object> r10, Object r11) {
        String r0 = this.f12710c.f(r9).b();
        if (r8.l() == com.fasterxml.jackson.a.n.f12152b) goto L6;
        a(r9, com.fasterxml.jackson.a.n.f12152b, "Current token not START_OBJECT (needed to unwrap root name %s), but %s", new Object[]{com.fasterxml.jackson.databind.l.h.b(r0), r8.l()});
    L6:
        if (r8.g() == com.fasterxml.jackson.a.n.f) goto L8;
        a(r9, com.fasterxml.jackson.a.n.f, "Current token not FIELD_NAME (to contain expected root name %s), but %s", new Object[]{com.fasterxml.jackson.databind.l.h.b(r0), r8.l()});
    L8:
        String r1 = r8.w();
        if (r0.equals(r1) == true) goto L11;
        a(r9, r1, "Root name (%s) does not match expected (%s) for type %s", new Object[]{com.fasterxml.jackson.databind.l.h.b(r1), com.fasterxml.jackson.databind.l.h.b(r0), com.fasterxml.jackson.databind.l.h.b(r9)});
    L11:
        r8.g();
        if (r11 != null) goto L14;
        Object r12 = r10.a(r8, this);
    L16:
        if (r8.g() == com.fasterxml.jackson.a.n.f12153c) goto L18;
        a(r9, com.fasterxml.jackson.a.n.f12153c, "Current token not END_OBJECT (to match wrapper object with root name %s), but %s", new Object[]{com.fasterxml.jackson.databind.l.h.b(r0), r8.l()});
    L18:
        return r12;
    L14:
        r12 = r10.a(r8, this, r11);
        goto L16
    }
}
