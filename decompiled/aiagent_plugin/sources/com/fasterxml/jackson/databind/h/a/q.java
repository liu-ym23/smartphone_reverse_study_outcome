package com.fasterxml.jackson.databind.h.a;

import com.fasterxml.jackson.databind.b.b.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: TypeDeserializerBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class q extends com.fasterxml.jackson.databind.h.e implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.f f12735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.d f12737e;
    protected final com.fasterxml.jackson.databind.k f;
    protected final String g;
    protected final boolean h;
    protected final Map<String, com.fasterxml.jackson.databind.l<Object>> i;
    protected com.fasterxml.jackson.databind.l<Object> j;

    public q(com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.h.f r4, String r5, boolean r6, com.fasterxml.jackson.databind.k r7) {
        com.fasterxml.jackson.databind.h.f r8 = (com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin");
        this.f12736d = r3;
        this.f12735c = r8;
        this.g = com.fasterxml.jackson.databind.l.h.a(r5);
        this.h = r6;
        this.i = new ConcurrentHashMap(16, 0.75f, 2);
        this.f = r7;
        this.f12737e = null;
    }

    public q(q r3, com.fasterxml.jackson.databind.d r4) {
        com.fasterxml.jackson.databind.d r5 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        this.f12736d = r3.f12736d;
        this.f12735c = r3.f12735c;
        this.g = r3.g;
        this.h = r3.h;
        this.i = r3.i;
        this.f = r3.f;
        this.j = r3.j;
        this.f12737e = r5;
    }

    public String g() {
        return this.f12736d.e().getName();
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public final String b() {
        return this.g;
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public com.fasterxml.jackson.databind.h.f c() {
        return this.f12735c;
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public Class<?> d() {
        return com.fasterxml.jackson.databind.l.h.a(this.f);
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public boolean e() {
        if (this.f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public com.fasterxml.jackson.databind.k h() {
        return this.f12736d;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append('[').append(getClass().getName());
        r0.append("; base-type:").append(this.f12736d);
        r0.append("; id-resolver: ").append(this.f12735c);
        r0.append(']');
        return r0.toString();
    }

    public final com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.h r4, String r5) {
        com.fasterxml.jackson.databind.l<Object> r0 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(this.i.get(r5), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L27;
        com.fasterxml.jackson.databind.k r1 = this.f12735c.a(r4, r5);
        if (r1 != null) goto L13;
        r0 = a(r4);
        if (r0 != null) goto L26;
        com.fasterxml.jackson.databind.k r2 = b(r4, r5);
        if (r2 == null) goto L11;
        com.fasterxml.jackson.databind.l<Object> r6 = r4.a(r2, this.f12737e);
    L25:
        r0 = r6;
        goto L26
    L11:
        return u.f12467a;
    L26:
        this.i.put(r5, r0);
        goto L27
    L13:
        com.fasterxml.jackson.databind.k r3 = this.f12736d;
        if (r3 != null) goto L16;
    L24:
        r6 = r4.a(r1, this.f12737e);
        goto L25
    L16:
        if (r3.getClass() != r1.getClass()) goto L24;
        if (r1.v() == true) goto L24;
        r1 = r4.a(this.f12736d, r1.e());     // Catch: IllegalArgumentException -> L21
    L21:
        e = move-exception;
        throw r4.a(this.f12736d, r5, e.getMessage());
    L27:
        return r0;
    }

    public final com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.h r4) {
        com.fasterxml.jackson.databind.k r0 = this.f;
        if (r0 != null) goto L11;
        if (r4.a(com.fasterxml.jackson.databind.i.h) == false) goto L7;
        return null;
    L7:
        return u.f12467a;
    L11:
        if (com.fasterxml.jackson.databind.l.h.e(r0.e()) == true) goto L13;
        com.fasterxml.jackson.databind.k r1 = this.f;
        monitor-enter(r1);
    L22:
        th = move-exception;
        throw th;
    L17:
        if (this.j != null) goto L19;
        this.j = r4.a(this.f, this.f12737e);     // Catch: Throwable -> L22
    L19:
        com.fasterxml.jackson.databind.l<Object> r3 = this.j;     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        return r3;
    L13:
        return u.f12467a;
    }

    public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        if (r5 != null) goto L8;
        com.fasterxml.jackson.databind.l<Object> r6 = a(r4);
        if (r6 != null) goto L13;
        return r4.a(h(), "No (native) type id found when one was expected for polymorphic type handling", new Object[0]);
    L13:
        return r6.a(r3, r4);
    L8:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
    L11:
        r6 = a(r4, r7);
        goto L13
    L10:
        r7 = String.valueOf(r5);
        goto L11
    }

    public com.fasterxml.jackson.databind.k b(com.fasterxml.jackson.databind.h r5, String r6) {
        String r0 = this.f12735c.b();
        if (r0 != null) goto L5;
        String r1 = "type ids are not statically known";
    L6:
        com.fasterxml.jackson.databind.d r2 = this.f12737e;
        if (r2 == null) goto L10;
        r1 = String.format("%s (for POJO property '%s')", new Object[]{r1, r2.a()});
    L10:
        return r5.a(this.f12736d, r6, this.f12735c, r1);
    L5:
        r1 = "known type ids = " + r0;
        goto L6
    }

    public com.fasterxml.jackson.databind.k c(com.fasterxml.jackson.databind.h r2, String r3) {
        return r2.a(this.f12736d, this.f12735c, r3);
    }
}
