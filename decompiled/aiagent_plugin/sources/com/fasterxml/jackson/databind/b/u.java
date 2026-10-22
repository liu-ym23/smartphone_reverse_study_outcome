package com.fasterxml.jackson.databind.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: SettableAnyProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public class u implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.d f12532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.j f12533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f12534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.l<Object> f12536e;
    protected final com.fasterxml.jackson.databind.h.e f;
    protected final com.fasterxml.jackson.databind.q g;

    /* JADX INFO: compiled from: SettableAnyProperty.java */
    private static class a extends com.fasterxml.jackson.databind.b.a.z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final u f12537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f12538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f12539c;

        public a(u r1, w r2, Class<?> r3, Object r4, String r5) {
            super(r2, r3);
            this.f12537a = r1;
            this.f12538b = r4;
            this.f12539c = r5;
        }

        @Override // com.fasterxml.jackson.databind.b.a.z.a
        public void a(Object r2, Object r3) {
            if (b(r2) == false) goto L7;
            this.f12537a.a(this.f12538b, this.f12539c, r3);
            return;
        L7:
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + r2.toString() + "] that wasn't previously registered.");
        }
    }

    public u(com.fasterxml.jackson.databind.d r3, com.fasterxml.jackson.databind.e.j r4, com.fasterxml.jackson.databind.k r5, com.fasterxml.jackson.databind.q r6, com.fasterxml.jackson.databind.l<Object> r7, com.fasterxml.jackson.databind.h.e r8) {
        this.f12532a = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        this.f12533b = r4;
        this.f12535d = r5;
        this.f12536e = r7;
        this.f = r8;
        this.g = r6;
        this.f12534c = ZeusTransformUtils.instanceOf(r4, com.fasterxml.jackson.databind.e.h.class);
    }

    public u a(com.fasterxml.jackson.databind.l<Object> r9) {
        return new u(this.f12532a, this.f12533b, this.f12535d, this.g, r9, this.f);
    }

    public void a(com.fasterxml.jackson.databind.g r2) {
        this.f12533b.a(r2.a(com.fasterxml.jackson.databind.r.o));
    }

    public com.fasterxml.jackson.databind.d a() {
        return this.f12532a;
    }

    public boolean b() {
        if (this.f12536e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public com.fasterxml.jackson.databind.k getType() {
        return this.f12535d;
    }

    public final void a(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8, Object r9, String r10) {
        com.fasterxml.jackson.databind.q r0 = this.g;     // Catch: w -> L8
        if (r0 != null) goto L5;
        Object r1 = r10;
    L6:
        a(r9, r1, a(r7, r8));     // Catch: w -> L8
        return;
    L5:
        r1 = r0.a(r10, r8);     // Catch: w -> L8
    L8:
        e = move-exception;
        if (this.f12536e.f() == null) goto L14;
        a r11 = new a(this, e, this.f12535d.e(), r9, r10);
        e.f().a(r11);
        return;
    L14:
        throw com.fasterxml.jackson.databind.m.a(r7, "Unresolved forward reference but no identity info.", e);
    }

    public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        if (r2.a(com.fasterxml.jackson.a.n.m) == true) goto L5;
        com.fasterxml.jackson.databind.h.e r0 = this.f;
        if (r0 == null) goto L11;
        return this.f12536e.a(r2, r3, r0);
    L11:
        return this.f12536e.a(r2, r3);
    L5:
        return this.f12536e.a(r3);
    }

    public void a(Object r4, Object r5, Object r6) {
    L10:
        e = move-exception;
        a(e, r5, r6);
        return;
    L4:
        if (this.f12534c == false) goto L8;
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(((com.fasterxml.jackson.databind.e.h) ZeusTransformUtils.preCheckCast(this.f12533b, com.fasterxml.jackson.databind.e.h.class, "com.obric.aiagent.plugin")).b(r4), Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
        if (r7 == null) goto L13;
        r7.put(r5, r6);     // Catch: Exception -> L10
    L13:
        return;
    L8:
        ((com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(this.f12533b, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin")).a(r4, new Object[]{r5, r6});     // Catch: Exception -> L10
        goto L13
    }

    public void a(Exception r4, Object r5, Object r6) {
        if (ZeusTransformUtils.instanceOf(r4, IllegalArgumentException.class) == false) goto L10;
        String r7 = com.fasterxml.jackson.databind.l.h.d(r6);
        StringBuilder r8 = new StringBuilder("Problem deserializing \"any\" property '").append(r5);
        r8.append("' of class " + c() + " (expected type: ").append(this.f12535d);
        r8.append("; actual type: ").append(r7).append(")");
        String r3 = com.fasterxml.jackson.databind.l.h.h(r4);
        if (r3 == null) goto L7;
        r8.append(", problem: ").append(r3);
    L9:
        throw new com.fasterxml.jackson.databind.m(null, r8.toString(), r4);
    L7:
        r8.append(" (no error message provided)");
        goto L9
    L10:
        com.fasterxml.jackson.databind.l.h.c(r4);
        com.fasterxml.jackson.databind.l.h.b(r4);
        Throwable r9 = com.fasterxml.jackson.databind.l.h.d(r4);
        throw new com.fasterxml.jackson.databind.m(null, com.fasterxml.jackson.databind.l.h.h(r9), r9);
    }

    private String c() {
        return this.f12533b.f().getName();
    }

    public String toString() {
        return "[any property on class " + c() + "]";
    }
}
