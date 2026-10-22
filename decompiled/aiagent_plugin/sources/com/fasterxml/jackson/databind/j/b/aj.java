package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: compiled from: StdSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class aj<T> extends com.fasterxml.jackson.databind.p<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f12884a = null;
    protected final Class<T> r;

    public static final boolean a(Object r0, Object r1) {
        if (r0 == null) goto L5;
        if (r1 == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.p
    public abstract void a(T r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3);

    static {
        f12884a = new Object();
    }

    public aj(Class<T> r1) {
        this.r = r1;
    }

    public aj(com.fasterxml.jackson.databind.k r1) {
        this.r = (Class<T>) r1.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public aj(Class<?> r1, boolean r2) {
        this.r = r1;
    }

    public aj(aj<?> r1) {
        this.r = (Class<T>) r1.r;
    }

    @Override // com.fasterxml.jackson.databind.p
    public Class<T> a() {
        return this.r;
    }

    public void a(com.fasterxml.jackson.databind.ac r1, Throwable r2, Object r3, String r4) {
    L3:
        if (ZeusTransformUtils.instanceOf(r2, InvocationTargetException.class) == false) goto L7;
        if (r2.getCause() == null) goto L7;
        r2 = r2.getCause();
    L7:
        com.fasterxml.jackson.databind.l.h.a(r2);
        if (r1 != null) goto L10;
    L13:
        boolean r0 = true;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, IOException.class) == false) goto L21;
        if (r0 == false) goto L20;
        if (ZeusTransformUtils.instanceOf(r2, com.fasterxml.jackson.a.e.class) == false) goto L20;
    L24:
        throw com.fasterxml.jackson.databind.m.a(r2, r3, r4);
    L20:
        throw ((IOException) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.aiagent.plugin"));
    L21:
        if (r0 == true) goto L24;
        com.fasterxml.jackson.databind.l.h.b(r2);
        goto L24
    L10:
        if (r1.a(com.fasterxml.jackson.databind.ab.f12249e) == true) goto L13;
        r0 = false;
        goto L15
    }

    public void a(com.fasterxml.jackson.databind.ac r1, Throwable r2, Object r3, int r4) {
    L3:
        if (ZeusTransformUtils.instanceOf(r2, InvocationTargetException.class) == false) goto L7;
        if (r2.getCause() == null) goto L7;
        r2 = r2.getCause();
    L7:
        com.fasterxml.jackson.databind.l.h.a(r2);
        if (r1 != null) goto L10;
    L13:
        boolean r0 = true;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, IOException.class) == false) goto L21;
        if (r0 == false) goto L20;
        if (ZeusTransformUtils.instanceOf(r2, com.fasterxml.jackson.a.e.class) == false) goto L20;
    L24:
        throw com.fasterxml.jackson.databind.m.a(r2, r3, r4);
    L20:
        throw ((IOException) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.aiagent.plugin"));
    L21:
        if (r0 == true) goto L24;
        com.fasterxml.jackson.databind.l.h.b(r2);
        goto L24
    L10:
        if (r1.a(com.fasterxml.jackson.databind.ab.f12249e) == true) goto L13;
        r0 = false;
        goto L15
    }

    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.d r6, com.fasterxml.jackson.databind.p<?> r7) {
        com.fasterxml.jackson.databind.d r8 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r6, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        Object r0 = f12884a;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(r5.a(r0), Map.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        r1 = new IdentityHashMap();
        r5.a(r0, r1);
    L8:
        r1.put(r8, Boolean.TRUE);
        com.fasterxml.jackson.databind.p<?> r4 = b(r5, r8, r7);     // Catch: Throwable -> L16
        if (r4 == null) goto L14;
        com.fasterxml.jackson.databind.p<?> r9 = r5.b(r4, r8);     // Catch: Throwable -> L16
        r1.remove(r8);
        return r9;
    L14:
        r1.remove(r8);
        return r7;
    L16:
        th = move-exception;
        r1.remove(r8);
        throw th;
    L5:
        if (r1.get(r8) == null) goto L8;
        return r7;
    }

    @Deprecated
    public com.fasterxml.jackson.databind.p<?> b(com.fasterxml.jackson.databind.ac r2, com.fasterxml.jackson.databind.d r3, com.fasterxml.jackson.databind.p<?> r4) {
        com.fasterxml.jackson.databind.d r1 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b r5 = r2.d();
        if (a(r5, r1) == false) goto L15;
        com.fasterxml.jackson.databind.e.j r0 = r1.d();
        if (r0 == null) goto L15;
        Object r6 = r5.i(r0);
        if (r6 == null) goto L15;
        com.fasterxml.jackson.databind.l.j<Object, Object> r7 = r2.a(r1.d(), r6);
        com.fasterxml.jackson.databind.k r8 = r7.b(r2.b());
        if (r4 != null) goto L14;
        if (r8.t() == true) goto L14;
        r4 = r2.a(r8);
    L14:
        return new ae(r7, r8, r4);
    L15:
        return r4;
    }

    public com.fasterxml.jackson.databind.j.n a(com.fasterxml.jackson.databind.ac r2, Object r3, Object r4) {
        com.fasterxml.jackson.databind.j.l r0 = r2.i();
        if (r0 != null) goto L7;
        return (com.fasterxml.jackson.databind.j.n) ZeusTransformUtils.preCheckCast(r2.a(a(), "Cannot resolve PropertyFilter with id '" + r3 + "'; no FilterProvider configured"), com.fasterxml.jackson.databind.j.n.class, "com.obric.aiagent.plugin");
    L7:
        return r0.a(r3, r4);
    }

    public JsonFormat.Value a(com.fasterxml.jackson.databind.ac r2, com.fasterxml.jackson.databind.d r3, Class<?> r4) {
        com.fasterxml.jackson.databind.d r1 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return r1.a(r2.c(), r4);
    L7:
        return r2.a(r4);
    }

    public Boolean a(com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.d r4, Class<?> r5, JsonFormat.Feature r6) {
        JsonFormat.Value r2 = a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r5);
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.getFeature(r6);
    }

    public JsonInclude.Value b(com.fasterxml.jackson.databind.ac r2, com.fasterxml.jackson.databind.d r3, Class<?> r4) {
        com.fasterxml.jackson.databind.d r1 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return r1.b(r2.c(), r4);
    L7:
        return r2.b(r4);
    }

    public com.fasterxml.jackson.databind.p<?> b(com.fasterxml.jackson.databind.ac r2, com.fasterxml.jackson.databind.d r3) {
        com.fasterxml.jackson.databind.d r1 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L10;
        com.fasterxml.jackson.databind.e.j r4 = r1.d();
        com.fasterxml.jackson.databind.b r5 = r2.d();
        if (r4 == null) goto L12;
        Object r6 = r5.o(r4);
        if (r6 != null) goto L9;
        return null;
    L9:
        return r2.b(r4, r6);
    L12:
        return null;
    L10:
        return null;
    }

    public boolean a(com.fasterxml.jackson.databind.p<?> r1) {
        return com.fasterxml.jackson.databind.l.h.e(r1);
    }

    public static final boolean b(Collection<?> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.isEmpty() == true) goto L7;
        return true;
    }
}
