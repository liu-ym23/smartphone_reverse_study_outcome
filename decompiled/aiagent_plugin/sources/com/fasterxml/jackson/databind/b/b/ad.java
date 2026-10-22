package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StdKeyDeserializers.java */
/* JADX INFO: loaded from: classes2.dex */
public class ad implements com.fasterxml.jackson.databind.b.r, Serializable {
    public static /* synthetic */ boolean lambda$6O7Di6SHQS4e5U9DtHBQS5yEheI(com.fasterxml.jackson.databind.e.c r0) {
        return a(r0);
    }

    public ad() {
    }

    public static com.fasterxml.jackson.databind.q a(com.fasterxml.jackson.databind.l.k r2) {
        return new ac.b(r2, null);
    }

    public static com.fasterxml.jackson.databind.q a(com.fasterxml.jackson.databind.l.k r1, com.fasterxml.jackson.databind.e.k r2) {
        return new ac.b(r1, r2);
    }

    public static com.fasterxml.jackson.databind.q a(com.fasterxml.jackson.databind.g r0, com.fasterxml.jackson.databind.k r1, com.fasterxml.jackson.databind.l<?> r2) {
        return new ac.a(r1.e(), r2);
    }

    public static com.fasterxml.jackson.databind.q a(com.fasterxml.jackson.databind.g r3, com.fasterxml.jackson.databind.k r4) {
        com.fasterxml.jackson.databind.c r5 = r3.b(r4);
        com.fasterxml.jackson.databind.e.c<com.fasterxml.jackson.databind.e.f, JsonCreator.Mode> r0 = a(r5);
        if (r0 != null) goto L5;
    L8:
        List<com.fasterxml.jackson.databind.e.c<com.fasterxml.jackson.databind.e.k, JsonCreator.Mode>> r6 = r5.m();
        r6.removeIf($$Lambda$ad$6O7Di6SHQS4e5U9DtHBQS5yEheI.INSTANCE);
        com.fasterxml.jackson.databind.e.k r2 = a(r6);
        if (r2 != null) goto L11;
        if (r0 == null) goto L16;
        return a(r3, (com.fasterxml.jackson.databind.e.j) ZeusTransformUtils.preCheckCast(r0.f12608a, com.fasterxml.jackson.databind.e.j.class, "com.obric.aiagent.plugin"));
    L16:
        if (r6.isEmpty() == false) goto L18;
        return null;
    L18:
        return a(r3, (com.fasterxml.jackson.databind.e.j) ZeusTransformUtils.preCheckCast(((com.fasterxml.jackson.databind.e.c) ZeusTransformUtils.preCheckCast(r6.get(0), com.fasterxml.jackson.databind.e.c.class, "com.obric.aiagent.plugin")).f12608a, com.fasterxml.jackson.databind.e.j.class, "com.obric.aiagent.plugin"));
    L11:
        return a(r3, r2);
    L5:
        if (r0.f12609b == null) goto L8;
        return a(r3, (com.fasterxml.jackson.databind.e.j) ZeusTransformUtils.preCheckCast(r0.f12608a, com.fasterxml.jackson.databind.e.j.class, "com.obric.aiagent.plugin"));
    }

    private static /* synthetic */ boolean a(com.fasterxml.jackson.databind.e.c r5) {
        if (((com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r5.f12608a, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin")).e() != 1) goto L9;
        if (((com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r5.f12608a, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin")).a(0) != String.class) goto L9;
        if (r5.f12609b == JsonCreator.Mode.PROPERTIES) goto L9;
        return false;
    L9:
        return true;
    }

    private static com.fasterxml.jackson.databind.q a(com.fasterxml.jackson.databind.g r2, com.fasterxml.jackson.databind.e.j r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.fasterxml.jackson.databind.e.f.class) == false) goto L9;
        Constructor<?> r4 = ((com.fasterxml.jackson.databind.e.f) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.e.f.class, "com.obric.aiagent.plugin")).d();
        if (r2.g() == false) goto L8;
        com.fasterxml.jackson.databind.l.h.a(r4, r2.a(com.fasterxml.jackson.databind.r.o));
    L8:
        return new ac.c(r4);
    L9:
        Method r5 = ((com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin")).d();
        if (r2.g() == false) goto L13;
        com.fasterxml.jackson.databind.l.h.a(r5, r2.a(com.fasterxml.jackson.databind.r.o));
    L13:
        return new ac.d(r5);
    }

    private static com.fasterxml.jackson.databind.e.c<com.fasterxml.jackson.databind.e.f, JsonCreator.Mode> a(com.fasterxml.jackson.databind.c r4) {
        Iterator<com.fasterxml.jackson.databind.e.c<com.fasterxml.jackson.databind.e.f, JsonCreator.Mode>> r5 = r4.k().iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        com.fasterxml.jackson.databind.e.c<com.fasterxml.jackson.databind.e.f, JsonCreator.Mode> r0 = (com.fasterxml.jackson.databind.e.c) ZeusTransformUtils.preCheckCast(r5.next(), com.fasterxml.jackson.databind.e.c.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.e.f r1 = (com.fasterxml.jackson.databind.e.f) ZeusTransformUtils.preCheckCast(r0.f12608a, com.fasterxml.jackson.databind.e.f.class, "com.obric.aiagent.plugin");
        if (r1.e() != 1) goto L4;
        if (String.class != r1.a(0)) goto L4;
        return r0;
    L10:
        return null;
    }

    private static com.fasterxml.jackson.databind.e.k a(List<com.fasterxml.jackson.databind.e.c<com.fasterxml.jackson.databind.e.k, JsonCreator.Mode>> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin")).iterator();
        com.fasterxml.jackson.databind.e.k r0 = null;
    L4:
        if (r5.hasNext() == false) goto L11;
        com.fasterxml.jackson.databind.e.c r2 = (com.fasterxml.jackson.databind.e.c) ZeusTransformUtils.preCheckCast(r5.next(), com.fasterxml.jackson.databind.e.c.class, "com.obric.aiagent.plugin");
        if (r2.f12609b == 0) goto L4;
        if (r0 != null) goto L10;
        r0 = (com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r2.f12608a, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin");
        goto L4
    L10:
        throw new IllegalArgumentException("Multiple suitable annotated Creator factory methods to be used as the Key deserializer for type " + com.fasterxml.jackson.databind.l.h.h(((com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r2.f12608a, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin")).f()));
    L11:
        return r0;
    }

    @Override // com.fasterxml.jackson.databind.b.r
    public com.fasterxml.jackson.databind.q a(com.fasterxml.jackson.databind.k r1, com.fasterxml.jackson.databind.g r2, com.fasterxml.jackson.databind.c r3) {
        Class<?> r0 = r1.e();
        if (r0.isPrimitive() == false) goto L6;
        r0 = com.fasterxml.jackson.databind.l.h.j(r0);
    L6:
        return ac.a(r0);
    }
}
