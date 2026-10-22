package com.fasterxml.jackson.databind.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: EnumResolver.java */
/* JADX INFO: loaded from: classes2.dex */
public class k implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Class<Enum<?>> f13034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Enum<?>[] f13035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashMap<String, Enum<?>> f13036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Enum<?> f13037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final boolean f13038e;
    protected final boolean f;

    /* JADX WARN: Multi-variable type inference failed */
    public static Class<Enum<?>> a(Class<?> r0) {
        return r0;
    }

    public k(Class<Enum<?>> r1, Enum<?>[] r2, HashMap<String, Enum<?>> r3, Enum<?> r4, boolean r5, boolean r6) {
        this.f13034a = r1;
        this.f13035b = r2;
        this.f13036c = r3;
        this.f13037d = r4;
        this.f13038e = r5;
        this.f = r6;
    }

    public static k a(com.fasterxml.jackson.databind.g r2, Class<?> r3) {
        return a(r3, r2.j(), r2.a(com.fasterxml.jackson.databind.r.w));
    }

    public static k a(Class<?> r13, com.fasterxml.jackson.databind.b r14, boolean r15) {
        Class<Enum<?>> r1 = a(r13);
        Enum<?>[] r2 = b(r13);
        String[] r16 = r14.a(r1, r2, new String[r2.length]);
        String[][] r0 = new String[r16.length][];
        r14.a(r1, r2, r0);
        HashMap r3 = new HashMap();
        int r4 = r2.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L17;
        Enum<?> r7 = r2[r6];
        String r8 = r16[r6];
        if (r8 != null) goto L7;
        r8 = r7.name();
    L7:
        r3.put(r8, r7);
        String[] r9 = r0[r6];
        if (r9 == null) goto L15;
        int r10 = r9.length;
        int r11 = 0;
    L10:
        if (r11 >= r10) goto L15;
        String r12 = r9[r11];
        if (r3.containsKey(r12) == true) goto L14;
        r3.put(r12, r7);
    L14:
        r11 = r11 + 1;
    L15:
        r6 = r6 + 1;
        goto L3
    L17:
        return new k(r1, r2, r3, a(r14, r1), r15, false);
    }

    public static k b(com.fasterxml.jackson.databind.g r2, Class<?> r3) {
        return b(r3, r2.j(), r2.a(com.fasterxml.jackson.databind.r.w));
    }

    public static k b(Class<?> r10, com.fasterxml.jackson.databind.b r11, boolean r12) {
        Class<Enum<?>> r1 = a(r10);
        Enum<?>[] r2 = b(r10);
        HashMap r3 = new HashMap();
        String[][] r13 = new String[r2.length][];
        if (r11 == null) goto L5;
        r11.a(r1, r2, r13);
    L5:
        int r0 = r2.length;
    L6:
        r0 = r0 - 1;
        if (r0 < 0) goto L17;
        Enum<?> r4 = r2[r0];
        r3.put(r4.toString(), r4);
        String[] r5 = r13[r0];
        if (r5 == null) goto L6;
        int r6 = r5.length;
        int r7 = 0;
    L11:
        if (r7 >= r6) goto L6;
        String r8 = r5[r7];
        if (r3.containsKey(r8) == true) goto L15;
        r3.put(r8, r4);
    L15:
        r7 = r7 + 1;
        goto L11
    L17:
        return new k(r1, r2, r3, a(r11, r1), r12, false);
    }

    public static k a(com.fasterxml.jackson.databind.g r2, Class<?> r3, com.fasterxml.jackson.databind.e.j r4) {
        return a(r3, r4, r2.j(), r2.a(com.fasterxml.jackson.databind.r.w));
    }

    public static k a(Class<?> r7, com.fasterxml.jackson.databind.e.j r8, com.fasterxml.jackson.databind.b r9, boolean r10) {
        Class<Enum<?>> r1 = a(r7);
        Enum<?>[] r2 = b(r7);
        HashMap r3 = new HashMap();
        int r11 = r2.length;
    L3:
        r11 = r11 - 1;
        if (r11 < 0) goto L14;
        Enum<?> r0 = r2[r11];
        Object r4 = r8.b(r0);     // Catch: Exception -> L10
        if (r4 == null) goto L3;
        r3.put(r4.toString(), r0);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + r0 + ": " + e.getMessage());
    L14:
        return new k(r1, r2, r3, a(r9, r1), r10, c(r8.c()));
    }

    public i a() {
        return i.a(this.f13036c);
    }

    public static Enum<?>[] b(Class<?> r3) {
        Enum<?>[] r0 = (Enum[]) ZeusTransformUtils.preCheckCast(a(r3).getEnumConstants(), Enum[].class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("No enum constants for class " + r3.getName());
    }

    public static Enum<?> a(com.fasterxml.jackson.databind.b r0, Class<?> r1) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a(a(r1));
    }

    public static boolean c(Class<?> r1) {
        if (r1.isPrimitive() == false) goto L6;
        r1 = h.j(r1);
    L6:
        if (r1 != Long.class) goto L8;
    L15:
        return true;
    L8:
        if (r1 == Integer.class) goto L15;
        if (r1 == Short.class) goto L15;
        if (r1 == Byte.class) goto L15;
        return false;
    }

    public Enum<?> a(String r4) {
        Enum<?> r0 = (Enum) ZeusTransformUtils.preCheckCast(this.f13036c.get(r4), Enum.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
    L8:
        return r0;
    L5:
        if (this.f13038e == false) goto L8;
        return b(r4);
    }

    public Enum<?> b(String r5) {
        Iterator<Map.Entry<String, Enum<?>>> r4 = this.f13036c.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r5.equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin")) == false) goto L4;
        return (Enum) ZeusTransformUtils.preCheckCast(r0.getValue(), Enum.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    public Enum<?> b() {
        return this.f13037d;
    }

    public Enum<?>[] c() {
        return this.f13035b;
    }

    public Collection<String> d() {
        return this.f13036c.keySet();
    }

    public Class<Enum<?>> e() {
        return this.f13034a;
    }

    public boolean f() {
        return this.f;
    }
}
