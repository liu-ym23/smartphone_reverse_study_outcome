package com.fasterxml.jackson.databind.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: EnumValues.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<Enum<?>> f13039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Enum<?>[] f13040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.fasterxml.jackson.a.q[] f13041c;

    private l(Class<Enum<?>> r3, com.fasterxml.jackson.a.q[] r4) {
        this.f13039a = r3;
        this.f13040b = (Enum[]) ZeusTransformUtils.preCheckCast(r3.getEnumConstants(), Enum[].class, "com.obric.aiagent.plugin");
        this.f13041c = r4;
    }

    public static l a(com.fasterxml.jackson.databind.a.m<?> r7, Class<Enum<?>> r8) {
        Class<? extends Enum<?>> r0 = h.m(r8);
        Enum<?>[] r1 = (Enum[]) ZeusTransformUtils.preCheckCast(r0.getEnumConstants(), Enum[].class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L13;
        String[] r2 = r7.j().a(r0, r1, new String[r1.length]);
        com.fasterxml.jackson.a.q[] r3 = new com.fasterxml.jackson.a.q[r1.length];
        int r4 = 0;
        int r5 = r1.length;
    L5:
        if (r4 >= r5) goto L11;
        Enum<?> r6 = r1[r4];
        String r9 = r2[r4];
        if (r9 != null) goto L9;
        r9 = r6.name();
    L9:
        r3[r6.ordinal()] = r7.a(r9);
        r4 = r4 + 1;
        goto L5
    L11:
        return a(r8, r3);
    L13:
        throw new IllegalArgumentException("Cannot determine enum constants for Class " + r8.getName());
    }

    public static l a(Class<Enum<?>> r1, com.fasterxml.jackson.a.q[] r2) {
        return new l(r1, r2);
    }

    public com.fasterxml.jackson.a.q a(Enum<?> r1) {
        return this.f13041c[r1.ordinal()];
    }

    public Class<Enum<?>> a() {
        return this.f13039a;
    }
}
