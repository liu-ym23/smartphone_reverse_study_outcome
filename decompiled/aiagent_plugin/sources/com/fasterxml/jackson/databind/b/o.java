package com.fasterxml.jackson.databind.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.b.b.aa;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: DeserializerCache.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l.n<com.fasterxml.jackson.databind.k, com.fasterxml.jackson.databind.l<Object>> f12529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final HashMap<com.fasterxml.jackson.databind.k, com.fasterxml.jackson.databind.l<Object>> f12530b;

    public o() {
        this(DownloadErrorCode.ERROR_CRONET_ERROR_BASE);
    }

    public o(int r3) {
        this.f12530b = new HashMap(8);
        this.f12529a = new com.fasterxml.jackson.databind.l.n(Math.min(64, r3 >> 2), r3);
    }

    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.h r2, p r3, com.fasterxml.jackson.databind.k r4) {
        com.fasterxml.jackson.databind.l<Object> r0 = a(r4);
        if (r0 != null) goto L8;
        com.fasterxml.jackson.databind.l<Object> r1 = c(r2, r3, r4);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return a(r2, r4);
    L8:
        return r0;
    }

    public com.fasterxml.jackson.databind.q b(com.fasterxml.jackson.databind.h r1, p r2, com.fasterxml.jackson.databind.k r3) {
        com.fasterxml.jackson.databind.q r4 = r2.a(r1, r3);
        if (r4 != null) goto L7;
        return b(r1, r3);
    L7:
        if (ZeusTransformUtils.instanceOf(r4, t.class) == false) goto L9;
        ((t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.aiagent.plugin")).d(r1);
    L9:
        return r4;
    }

    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.k r2) {
        if (r2 == null) goto L10;
        if (b(r2) == false) goto L8;
        return null;
    L8:
        return (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(this.f12529a.a(r2), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
    L10:
        throw new IllegalArgumentException("Null JavaType passed");
    }

    public com.fasterxml.jackson.databind.l<Object> c(com.fasterxml.jackson.databind.h r6, p r7, com.fasterxml.jackson.databind.k r8) {
        HashMap<com.fasterxml.jackson.databind.k, com.fasterxml.jackson.databind.l<Object>> r0 = this.f12530b;
        monitor-enter(r0);
        com.fasterxml.jackson.databind.l<Object> r1 = a(r8);     // Catch: Throwable -> L27
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L27
        return r1;
    L8:
        int r2 = this.f12530b.size();     // Catch: Throwable -> L27
        if (r2 <= 0) goto L30;
        com.fasterxml.jackson.databind.l<Object> r3 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(this.f12530b.get(r8), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r3 == null) goto L30;
        monitor-exit(r0);     // Catch: Throwable -> L27
        return r3;
    L30:
        com.fasterxml.jackson.databind.l<Object> r9 = d(r6, r7, r8);     // Catch: Throwable -> L21
        if (r2 == 0) goto L17;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L27
        return r9;
    L17:
        if (this.f12530b.size() <= 0) goto L19;
        this.f12530b.clear();     // Catch: Throwable -> L27
        goto L19
    L21:
        th = move-exception;
        if (r2 == 0) goto L24;
    L26:
        throw th;     // Catch: Throwable -> L27
    L24:
        if (this.f12530b.size() <= 0) goto L26;
        this.f12530b.clear();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public com.fasterxml.jackson.databind.l<Object> d(com.fasterxml.jackson.databind.h r4, p r5, com.fasterxml.jackson.databind.k r6) {
        com.fasterxml.jackson.databind.l<Object> r7 = e(r4, r5, r6);     // Catch: IllegalArgumentException -> L5
    L7:
        if (r7 != null) goto L10;
        return null;
    L10:
        if (b(r6) == false) goto L12;
    L14:
        boolean r0 = false;
    L16:
        if (ZeusTransformUtils.instanceOf(r7, t.class) == false) goto L18;
        this.f12530b.put(r6, r7);
        ((t) ZeusTransformUtils.preCheckCast(r7, t.class, "com.obric.aiagent.plugin")).d(r4);
        this.f12530b.remove(r6);
    L18:
        if (r0 == false) goto L20;
        this.f12529a.a(r6, r7);
    L20:
        return r7;
    L12:
        if (r7.c() == false) goto L14;
        r0 = true;
    L5:
        e = move-exception;
        r4.b(r6, com.fasterxml.jackson.databind.l.h.h(e));
        r7 = null;
        goto L7
    }

    public com.fasterxml.jackson.databind.l<Object> e(com.fasterxml.jackson.databind.h r5, p r6, com.fasterxml.jackson.databind.k r7) {
        com.fasterxml.jackson.databind.g r0 = r5.c();
        if (r7.g() == false) goto L5;
    L8:
        r7 = r6.a(r0, r7);
    L9:
        com.fasterxml.jackson.databind.c r1 = r0.a(r7);
        com.fasterxml.jackson.databind.l<Object> r2 = a(r5, r1.c());
        if (r2 == null) goto L12;
        return r2;
    L12:
        com.fasterxml.jackson.databind.k r3 = a(r5, r1.c(), r7);
        if (r3 == r7) goto L15;
        r1 = r0.a(r3);
        r7 = r3;
    L15:
        Class<?> r4 = r1.v();
        if (r4 != null) goto L18;
        com.fasterxml.jackson.databind.l.j<Object, Object> r8 = r1.t();
        if (r8 == null) goto L22;
        com.fasterxml.jackson.databind.k r9 = r8.a(r5.b());
        if (r9.a(r7.e()) == true) goto L27;
        r1 = r0.a(r9);
    L27:
        return new aa(r8, r9, a(r5, r6, r9, r1));
    L22:
        return a(r5, r6, r7, r1);
    L18:
        return r6.a(r5, r7, r1, r4);
    L5:
        if (r7.s() == true) goto L8;
        if (r7.r() == false) goto L9;
        goto L8
    }

    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r5, p r6, com.fasterxml.jackson.databind.k r7, com.fasterxml.jackson.databind.c r8) {
        com.fasterxml.jackson.databind.g r4 = r5.c();
        if (r7.k() == false) goto L7;
        return r6.a(r5, r7, r8);
    L7:
        if (r7.q() == false) goto L33;
        if (r7.j() == false) goto L13;
        return r6.a(r5, (com.fasterxml.jackson.databind.k.a) ZeusTransformUtils.preCheckCast(r7, com.fasterxml.jackson.databind.k.a.class, "com.obric.aiagent.plugin"), r8);
    L13:
        if (r7.s() == false) goto L23;
        if (r8.a(null).getShape() == JsonFormat.Shape.OBJECT) goto L23;
        com.fasterxml.jackson.databind.k.g r9 = (com.fasterxml.jackson.databind.k.g) ZeusTransformUtils.preCheckCast(r7, com.fasterxml.jackson.databind.k.g.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, com.fasterxml.jackson.databind.k.h.class) == false) goto L21;
        return r6.a(r5, (com.fasterxml.jackson.databind.k.h) ZeusTransformUtils.preCheckCast(r9, com.fasterxml.jackson.databind.k.h.class, "com.obric.aiagent.plugin"), r8);
    L21:
        return r6.a(r5, r9, r8);
    L23:
        if (r7.r() == false) goto L33;
        if (r8.a(null).getShape() == JsonFormat.Shape.OBJECT) goto L33;
        com.fasterxml.jackson.databind.k.d r10 = (com.fasterxml.jackson.databind.k.d) ZeusTransformUtils.preCheckCast(r7, com.fasterxml.jackson.databind.k.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, com.fasterxml.jackson.databind.k.e.class) == false) goto L31;
        return r6.a(r5, (com.fasterxml.jackson.databind.k.e) ZeusTransformUtils.preCheckCast(r10, com.fasterxml.jackson.databind.k.e.class, "com.obric.aiagent.plugin"), r8);
    L31:
        return r6.a(r5, r10, r8);
    L33:
        if (r7.a() == false) goto L37;
        return r6.a(r5, (com.fasterxml.jackson.databind.k.j) ZeusTransformUtils.preCheckCast(r7, com.fasterxml.jackson.databind.k.j.class, "com.obric.aiagent.plugin"), r8);
    L37:
        if (com.fasterxml.jackson.databind.n.class.isAssignableFrom(r7.e()) == false) goto L41;
        return r6.a(r4, r7, r8);
    L41:
        return r6.d(r5, r7, r8);
    }

    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.e.b r3) {
        Object r0 = r2.f().x(r3);
        if (r0 != null) goto L7;
        return null;
    L7:
        return a(r2, r3, r2.b(r3, r0));
    }

    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.e.b r2, com.fasterxml.jackson.databind.l<Object> r3) {
        com.fasterxml.jackson.databind.l.j<Object, Object> r0 = b(r1, r2);
        if (r0 != null) goto L6;
        return r3;
    L6:
        return new aa(r0, r0.a(r1.b()), r3);
    }

    public com.fasterxml.jackson.databind.l.j<Object, Object> b(com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.e.b r2) {
        Object r0 = r1.f().A(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r1.a(r2, r0);
    }

    private com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.h r6, com.fasterxml.jackson.databind.e.b r7, com.fasterxml.jackson.databind.k r8) {
        com.fasterxml.jackson.databind.b r0 = r6.f();
        if (r0 != null) goto L6;
        return r8;
    L6:
        if (r8.s() == false) goto L16;
        com.fasterxml.jackson.databind.k r1 = r8.w();
        if (r1 == null) goto L16;
        if (r1.D() != null) goto L16;
        Object r2 = r0.y(r7);
        if (r2 == null) goto L16;
        com.fasterxml.jackson.databind.q r3 = r6.c(r7, r2);
        if (r3 == null) goto L16;
        r8 = ((com.fasterxml.jackson.databind.k.g) ZeusTransformUtils.preCheckCast(r8, com.fasterxml.jackson.databind.k.g.class, "com.obric.aiagent.plugin")).i(r3);
    L16:
        com.fasterxml.jackson.databind.k r4 = r8.x();
        if (r4 == null) goto L31;
        if (r4.D() != null) goto L31;
        Object r5 = r0.z(r7);
        if (r5 == null) goto L31;
        com.fasterxml.jackson.databind.l<Object> r9 = null;
        if (ZeusTransformUtils.instanceOf(r5, com.fasterxml.jackson.databind.l.class) == false) goto L25;
        r9 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
    L28:
        if (r9 == null) goto L31;
        r8 = r8.d(r9);
        goto L31
    L25:
        Class<?> r10 = a(r5, "findContentDeserializer", com.fasterxml.jackson.databind.l.a.class);
        if (r10 == null) goto L28;
        r9 = r6.b(r7, r10);
    L31:
        return r0.b(r6.c(), r7, r8);
    }

    private boolean b(com.fasterxml.jackson.databind.k r3) {
        if (r3.q() == false) goto L16;
        com.fasterxml.jackson.databind.k r2 = r3.x();
        if (r2 == null) goto L12;
        if (r2.D() == null) goto L9;
    L10:
        return true;
    L9:
        if (r2.E() != null) goto L10;
    L12:
        if (r3.s() == true) goto L14;
        return false;
    L14:
        if (r3.w().D() == null) goto L19;
        return true;
    L19:
        return false;
    L16:
        return false;
    }

    private Class<?> a(Object r2, String r3, Class<?> r4) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, Class.class) == false) goto L15;
        Class<?> r5 = (Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.aiagent.plugin");
        if (r5 != r4) goto L10;
    L13:
        return null;
    L10:
        if (com.fasterxml.jackson.databind.l.h.e(r5) == true) goto L13;
        return r5;
    L15:
        throw new IllegalStateException("AnnotationIntrospector." + r3 + "() returned value of type " + r2.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
    }

    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.k r4) {
        if (com.fasterxml.jackson.databind.l.h.d(r4.e()) == true) goto L7;
        return (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r3.b(r4, "Cannot find a Value deserializer for abstract type " + r4), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
    L7:
        return (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r3.b(r4, "Cannot find a Value deserializer for type " + r4), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
    }

    public com.fasterxml.jackson.databind.q b(com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.k r3) {
        return (com.fasterxml.jackson.databind.q) ZeusTransformUtils.preCheckCast(r2.b(r3, "Cannot find a (Map) Key deserializer for type " + r3), com.fasterxml.jackson.databind.q.class, "com.obric.aiagent.plugin");
    }
}
