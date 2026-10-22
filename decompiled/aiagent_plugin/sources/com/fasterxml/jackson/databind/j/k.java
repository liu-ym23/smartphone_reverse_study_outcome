package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.aa;
import com.fasterxml.jackson.databind.ab;
import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.j.a.u;
import com.fasterxml.jackson.databind.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: compiled from: DefaultSerializerProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends ac implements Serializable {
    protected transient Map<Object, u> o;
    protected transient ArrayList<ObjectIdGenerator<?>> p;
    protected transient com.fasterxml.jackson.a.h q;

    /* JADX INFO: compiled from: DefaultSerializerProvider.java */
    public static final class a extends k {
        @Override // com.fasterxml.jackson.databind.j.k
        public /* synthetic */ k a(aa r1, r r2) {
            return b(r1, r2);
        }

        public a() {
        }

        public a(ac r1, aa r2, r r3) {
            super(r1, r2, r3);
        }

        public a b(aa r2, r r3) {
            return new a(this, r2, r3);
        }
    }

    public abstract k a(aa r1, r r2);

    public k() {
    }

    public k(ac r1, aa r2, r r3) {
        super(r1, r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.ac
    public com.fasterxml.jackson.databind.p<Object> b(com.fasterxml.jackson.databind.e.b r6, Object r7) {
        com.fasterxml.jackson.databind.p<?> r0 = null;
        if (r7 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, com.fasterxml.jackson.databind.p.class) == false) goto L9;
        com.fasterxml.jackson.databind.p<?> r8 = (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(r7, com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");
    L27:
        return a(r8);
    L9:
        if (ZeusTransformUtils.instanceOf(r7, Class.class) == true) goto L11;
        b(r6.getType(), "AnnotationIntrospector returned serializer definition of type " + r7.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
    L11:
        Class<?> r9 = (Class) ZeusTransformUtils.preCheckCast(r7, Class.class, "com.obric.aiagent.plugin");
        if (r9 != com.fasterxml.jackson.databind.p.a.class) goto L14;
    L28:
        return null;
    L14:
        if (com.fasterxml.jackson.databind.l.h.e(r9) == true) goto L28;
        if (com.fasterxml.jackson.databind.p.class.isAssignableFrom(r9) == true) goto L19;
        b(r6.getType(), "AnnotationIntrospector returned Class " + r9.getName() + "; expected Class<JsonSerializer>");
    L19:
        com.fasterxml.jackson.databind.a.l r1 = this.f12252c.m();
        if (r1 == null) goto L23;
        r0 = r1.a(this.f12252c, r6, r9);
    L23:
        if (r0 != null) goto L25;
        r8 = (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r9, this.f12252c.g()), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");
        goto L27
    L25:
        r8 = r0;
        goto L27
    }

    @Override // com.fasterxml.jackson.databind.ac
    public Object a(com.fasterxml.jackson.databind.e.t r3, Class<?> r4) {
        Object r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        com.fasterxml.jackson.databind.a.l r1 = this.f12252c.m();
        if (r1 == null) goto L9;
        r0 = r1.a(this.f12252c, r3, r4);
    L9:
        if (r0 == null) goto L11;
        return r0;
    L11:
        return com.fasterxml.jackson.databind.l.h.b(r4, this.f12252c.g());
    }

    @Override // com.fasterxml.jackson.databind.ac
    public boolean b(Object r6) {
        if (r6 != null) goto L11;
        return true;
    L11:
        return r6.equals(null);
    L8:
        th = move-exception;
        a(r6.getClass(), String.format("Problem determining whether filter of type '%s' should filter out `null` values: (%s) %s", new Object[]{r6.getClass().getName(), th.getClass().getName(), com.fasterxml.jackson.databind.l.h.h(th)}), th);
        return false;
    }

    @Override // com.fasterxml.jackson.databind.ac
    public u a(Object r7, ObjectIdGenerator<?> r8) {
        Map<Object, u> r0 = this.o;
        if (r0 != null) goto L5;
        this.o = m();
    L8:
        ObjectIdGenerator<?> r1 = null;
        ArrayList<ObjectIdGenerator<?>> r2 = this.p;
        if (r2 != null) goto L11;
        this.p = new ArrayList(8);
    L17:
        if (r1 != null) goto L19;
        r1 = r8.newForSerialization(this);
        this.p.add(r1);
    L19:
        u r9 = new u(r1);
        this.o.put(r7, r9);
        return r9;
    L11:
        int r3 = 0;
        int r4 = r2.size();
    L12:
        if (r3 >= r4) goto L17;
        ObjectIdGenerator<?> r5 = (ObjectIdGenerator) ZeusTransformUtils.preCheckCast(this.p.get(r3), ObjectIdGenerator.class, "com.obric.aiagent.plugin");
        if (r5.canUseFor(r8) == true) goto L15;
        r3 = r3 + 1;
        goto L12
    L15:
        r1 = r5;
        goto L17
    L5:
        u r6 = (u) ZeusTransformUtils.preCheckCast(r0.get(r7), u.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L8;
        return r6;
    }

    public Map<Object, u> m() {
        if (a(ab.z) == false) goto L7;
        return new HashMap();
    L7:
        return new IdentityHashMap();
    }

    @Override // com.fasterxml.jackson.databind.ac
    public com.fasterxml.jackson.a.h j() {
        return this.q;
    }

    public void a(com.fasterxml.jackson.a.h r5, Object r6) {
        this.q = r5;
        if (r6 != null) goto L6;
        b(r5);
        return;
    L6:
        Class<?> r0 = r6.getClass();
        com.fasterxml.jackson.databind.p<Object> r1 = a(r0, true, null);
        x r2 = this.f12252c.w();
        if (r2 != null) goto L13;
        if (this.f12252c.a(ab.f12245a) == false) goto L16;
        a(r5, r6, r1, this.f12252c.i(r0));
        return;
    L16:
        a(r5, r6, r1);
        return;
    L13:
        if (r2.e() == true) goto L16;
        a(r5, r6, r1, r2);
    }

    public void a(com.fasterxml.jackson.a.h r4, Object r5, com.fasterxml.jackson.databind.k r6) {
        this.q = r4;
        if (r5 != null) goto L7;
        b(r4);
        return;
    L7:
        if (r6.e().isAssignableFrom(r5.getClass()) == true) goto L9;
        a(r5, r6);
    L9:
        com.fasterxml.jackson.databind.p<Object> r0 = a(r6, true, null);
        x r1 = this.f12252c.w();
        if (r1 != null) goto L16;
        if (this.f12252c.a(ab.f12245a) == false) goto L19;
        a(r4, r5, r0, this.f12252c.f(r6));
        return;
    L19:
        a(r4, r5, r0);
        return;
    L16:
        if (r1.e() == true) goto L19;
        a(r4, r5, r0, r1);
    }

    public void a(com.fasterxml.jackson.a.h r3, Object r4, com.fasterxml.jackson.databind.k r5, com.fasterxml.jackson.databind.p<Object> r6) {
        this.q = r3;
        if (r4 != null) goto L6;
        b(r3);
        return;
    L6:
        if (r5 != null) goto L8;
    L10:
        if (r6 != null) goto L12;
        r6 = a(r5, true, null);
    L12:
        x r0 = this.f12252c.w();
        if (r0 != null) goto L22;
        if (this.f12252c.a(ab.f12245a) == false) goto L25;
        if (r5 != null) goto L18;
        x r7 = this.f12252c.i(r4.getClass());
    L19:
        a(r3, r4, r6, r7);
        return;
    L18:
        r7 = this.f12252c.f(r5);
    L25:
        a(r3, r4, r6);
        return;
    L22:
        if (r0.e() == true) goto L25;
        a(r3, r4, r6, r0);
        return;
    L8:
        if (r5.e().isAssignableFrom(r4.getClass()) == true) goto L10;
        a(r4, r5);
        goto L10
    }

    public void a(com.fasterxml.jackson.a.h r3, Object r4, com.fasterxml.jackson.databind.k r5, com.fasterxml.jackson.databind.p<Object> r6, com.fasterxml.jackson.databind.h.h r7) {
        this.q = r3;
        if (r4 != null) goto L6;
        b(r3);
        return;
    L6:
        if (r5 != null) goto L8;
    L10:
        if (r6 == null) goto L12;
    L17:
        x r8 = this.f12252c.w();
        if (r8 != null) goto L23;
        boolean r9 = this.f12252c.a(ab.f12245a);
        if (r9 == false) goto L33;
        r3.j();
        r3.b(this.f12252c.i(r4.getClass()).a(this.f12252c));
    L33:
        r6.a(r4, r3, this, r7);     // Catch: Exception -> L30
        if (r9 == false) goto L35;
        r3.k();     // Catch: Exception -> L30
        return;
    L35:
        return;
    L30:
        e = move-exception;
        throw a(r3, e);
    L23:
        if (r8.e() == false) goto L25;
        r9 = false;
        goto L33
    L25:
        r3.j();
        r3.a(r8.b());
        r9 = true;
        goto L33
    L12:
        if (r5 != null) goto L14;
    L16:
        r6 = a(r4.getClass(), null);
        goto L17
    L14:
        if (r5.q() == false) goto L16;
        r6 = a(r5, null);
        goto L17
    L8:
        if (r5.e().isAssignableFrom(r4.getClass()) == true) goto L10;
        a(r4, r5);
        goto L10
    }

    private final void a(com.fasterxml.jackson.a.h r2, Object r3, com.fasterxml.jackson.databind.p<Object> r4, x r5) {
        r2.j();     // Catch: Exception -> L4
        r2.b(r5.a(this.f12252c));     // Catch: Exception -> L4
        r4.a(r3, r2, this);     // Catch: Exception -> L4
        r2.k();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw a(r2, e);
    }

    private final void a(com.fasterxml.jackson.a.h r1, Object r2, com.fasterxml.jackson.databind.p<Object> r3) {
        r3.a(r2, r1, this);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw a(r1, e);
    }

    public void b(com.fasterxml.jackson.a.h r3) {
        k().a(null, r3, this);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw a(r3, e);
    }

    private IOException a(com.fasterxml.jackson.a.h r2, Exception r3) {
        if (ZeusTransformUtils.instanceOf(r3, IOException.class) == true) goto L5;
        String r1 = com.fasterxml.jackson.databind.l.h.h(r3);
        if (r1 != null) goto L10;
        r1 = "[no message for " + r3.getClass().getName() + "]";
    L10:
        return new com.fasterxml.jackson.databind.m(r2, r1, r3);
    L5:
        return (IOException) ZeusTransformUtils.preCheckCast(r3, IOException.class, "com.obric.aiagent.plugin");
    }
}
