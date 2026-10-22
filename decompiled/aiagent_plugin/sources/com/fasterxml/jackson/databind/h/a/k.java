package com.fasterxml.jackson.databind.h.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.EnumMap;
import java.util.EnumSet;

/* JADX INFO: compiled from: ClassNameIdResolver.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.c f12720a;

    @Override // com.fasterxml.jackson.databind.h.a.r, com.fasterxml.jackson.databind.h.f
    public String b() {
        return "class name used as type id";
    }

    public k(com.fasterxml.jackson.databind.k r1, com.fasterxml.jackson.databind.k.o r2, com.fasterxml.jackson.databind.h.c r3) {
        super(r1, r2);
        this.f12720a = r3;
    }

    public static k a(com.fasterxml.jackson.databind.k r1, com.fasterxml.jackson.databind.a.m<?> r2, com.fasterxml.jackson.databind.h.c r3) {
        return new k(r1, r2.o(), r3);
    }

    @Override // com.fasterxml.jackson.databind.h.f
    public String a(Object r3) {
        return a(r3, r3.getClass(), this.f12738d);
    }

    @Override // com.fasterxml.jackson.databind.h.f
    public String a(Object r2, Class<?> r3) {
        return a(r2, r3, this.f12738d);
    }

    @Override // com.fasterxml.jackson.databind.h.a.r, com.fasterxml.jackson.databind.h.f
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.e r1, String r2) {
        return a(r2, r1);
    }

    public com.fasterxml.jackson.databind.k a(String r3, com.fasterxml.jackson.databind.e r4) {
        com.fasterxml.jackson.databind.k r0 = r4.a(this.f12739e, r3, this.f12720a);
        if (r0 == null) goto L5;
    L8:
        return r0;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, com.fasterxml.jackson.databind.h.class) == false) goto L8;
        return ((com.fasterxml.jackson.databind.h) ZeusTransformUtils.preCheckCast(r4, com.fasterxml.jackson.databind.h.class, "com.obric.aiagent.plugin")).a(this.f12739e, r3, this, "no such class found");
    }

    public String a(Object r3, Class<?> r4, com.fasterxml.jackson.databind.k.o r5) {
        if (com.fasterxml.jackson.databind.l.h.l(r4) == true) goto L5;
    L7:
        String r0 = r4.getName();
        if (r0.startsWith("java.util.") == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r3, EnumSet.class) == false) goto L13;
        return r5.a(EnumSet.class, com.fasterxml.jackson.databind.l.h.a((EnumSet) ZeusTransformUtils.preCheckCast(r3, EnumSet.class, "com.obric.aiagent.plugin"))).c();
    L13:
        if (ZeusTransformUtils.instanceOf(r3, EnumMap.class) == true) goto L25;
        return r0;
    L25:
        return r5.a(EnumMap.class, com.fasterxml.jackson.databind.l.h.a((EnumMap) ZeusTransformUtils.preCheckCast(r3, EnumMap.class, "com.obric.aiagent.plugin")), Object.class).c();
    L16:
        if (r0.indexOf(36) >= 0) goto L18;
        return r0;
    L18:
        if (com.fasterxml.jackson.databind.l.h.b(r4) != null) goto L20;
        return r0;
    L20:
        if (com.fasterxml.jackson.databind.l.h.b(this.f12739e.e()) == null) goto L22;
        return r0;
    L22:
        return this.f12739e.e().getName();
    L5:
        if (r4.isEnum() == true) goto L7;
        r4 = r4.getSuperclass();
        goto L7
    }
}
