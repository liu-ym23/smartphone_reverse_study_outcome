package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: BeanPropertyMap.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements Serializable, Iterable<com.fasterxml.jackson.databind.b.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final boolean f12274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object[] f12278e;
    private final com.fasterxml.jackson.databind.b.v[] f;
    private final Map<String, List<com.fasterxml.jackson.databind.x>> g;
    private final Map<String, String> h;
    private final Locale i;

    private static final int a(int r1) {
        if (r1 > 5) goto L7;
        return 8;
    L7:
        if (r1 > 12) goto L10;
        return 16;
    L10:
        int r0 = 32;
    L11:
        if (r0 >= (r1 + (r1 >> 2))) goto L13;
        r0 = r0 + r0;
        goto L11
    L13:
        return r0;
    }

    public c(boolean r4, Collection<com.fasterxml.jackson.databind.b.v> r5, Map<String, List<com.fasterxml.jackson.databind.x>> r6, Locale r7) {
        Collection<com.fasterxml.jackson.databind.b.v> r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        Map<String, List<com.fasterxml.jackson.databind.x>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        this.f12274a = r4;
        this.f = (com.fasterxml.jackson.databind.b.v[]) ZeusTransformUtils.preCheckCast(r8.toArray(new com.fasterxml.jackson.databind.b.v[r8.size()]), com.fasterxml.jackson.databind.b.v[].class, "com.obric.aiagent.plugin");
        this.g = r9;
        this.i = r7;
        this.h = a(r9, r4, r7);
        a(r8);
    }

    private c(c r3, com.fasterxml.jackson.databind.b.v r4, int r5, int r6) {
        this.f12274a = r3.f12274a;
        this.i = r3.i;
        this.f12275b = r3.f12275b;
        this.f12276c = r3.f12276c;
        this.f12277d = r3.f12277d;
        this.g = r3.g;
        this.h = r3.h;
        Object[] r0 = r3.f12278e;
        this.f12278e = Arrays.copyOf(r0, r0.length);
        com.fasterxml.jackson.databind.b.v[] r7 = r3.f;
        com.fasterxml.jackson.databind.b.v[] r8 = (com.fasterxml.jackson.databind.b.v[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r7, r7.length), com.fasterxml.jackson.databind.b.v[].class, "com.obric.aiagent.plugin");
        this.f = r8;
        this.f12278e[r5] = r4;
        r8[r6] = r4;
    }

    private c(c r4, com.fasterxml.jackson.databind.b.v r5, String r6, int r7) {
        this.f12274a = r4.f12274a;
        this.i = r4.i;
        this.f12275b = r4.f12275b;
        this.f12276c = r4.f12276c;
        this.f12277d = r4.f12277d;
        this.g = r4.g;
        this.h = r4.h;
        Object[] r0 = r4.f12278e;
        this.f12278e = Arrays.copyOf(r0, r0.length);
        com.fasterxml.jackson.databind.b.v[] r8 = r4.f;
        int r1 = r8.length;
        com.fasterxml.jackson.databind.b.v[] r9 = (com.fasterxml.jackson.databind.b.v[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r8, r1 + 1), com.fasterxml.jackson.databind.b.v[].class, "com.obric.aiagent.plugin");
        this.f = r9;
        r9[r1] = r5;
        int r10 = this.f12275b + 1;
        int r2 = r7 << 1;
        Object[] r3 = this.f12278e;
        if (r3[r2] == null) goto L9;
        r2 = ((r7 >> 1) + r10) << 1;
        if (r3[r2] == null) goto L9;
        int r11 = (r10 + (r10 >> 1)) << 1;
        int r12 = this.f12277d;
        r2 = r11 + r12;
        this.f12277d = r12 + 2;
        if (r2 < r3.length) goto L9;
        this.f12278e = Arrays.copyOf(r3, r3.length + 4);
    L9:
        Object[] r13 = this.f12278e;
        r13[r2] = r6;
        r13[r2 + 1] = r5;
    }

    public c(c r2, boolean r3) {
        this.f12274a = r3;
        this.i = r2.i;
        this.g = r2.g;
        this.h = r2.h;
        com.fasterxml.jackson.databind.b.v[] r4 = r2.f;
        com.fasterxml.jackson.databind.b.v[] r5 = (com.fasterxml.jackson.databind.b.v[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), com.fasterxml.jackson.databind.b.v[].class, "com.obric.aiagent.plugin");
        this.f = r5;
        a(Arrays.asList(r5));
    }

    public c a(boolean r2) {
        if (this.f12274a != r2) goto L6;
        return this;
    L6:
        return new c(this, r2);
    }

    public void a(Collection<com.fasterxml.jackson.databind.b.v> r11) {
        Collection r12 = (Collection) ZeusTransformUtils.wrapperContextForParams(r11, Collection.class, "com.obric.aiagent.plugin");
        int r0 = r12.size();
        this.f12276c = r0;
        int r1 = a(r0);
        this.f12275b = r1 - 1;
        int r2 = (r1 >> 1) + r1;
        Object[] r3 = new Object[r2 * 2];
        Iterator r13 = r12.iterator();
        int r4 = 0;
    L4:
        if (r13.hasNext() == false) goto L16;
        com.fasterxml.jackson.databind.b.v r5 = (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(r13.next(), com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L4;
        String r6 = c(r5);
        int r7 = c(r6);
        int r8 = r7 << 1;
        if (r3[r8] == null) goto L15;
        r8 = ((r7 >> 1) + r1) << 1;
        if (r3[r8] == null) goto L15;
        r8 = (r2 << 1) + r4;
        r4 = r4 + 2;
        if (r8 < r3.length) goto L15;
        r3 = Arrays.copyOf(r3, r3.length + 4);
    L15:
        r3[r8] = r6;
        r3[r8 + 1] = r5;
        goto L4
    L16:
        this.f12278e = r3;
        this.f12277d = r4;
    }

    public static c a(com.fasterxml.jackson.databind.a.m<?> r2, Collection<com.fasterxml.jackson.databind.b.v> r3, Map<String, List<com.fasterxml.jackson.databind.x>> r4, boolean r5) {
        return new c(r5, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"), r2.s());
    }

    public c a(com.fasterxml.jackson.databind.b.v r7) {
        String r0 = c(r7);
        int r1 = this.f12278e.length;
        int r2 = 1;
    L3:
        if (r2 >= r1) goto L12;
        com.fasterxml.jackson.databind.b.v r3 = (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(this.f12278e[r2], com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L10;
        if (r3.a().equals(r0) == false) goto L10;
        return new c(this, r7, r2, d(r3));
    L10:
        r2 = r2 + 2;
        goto L3
    L12:
        return new c(this, r7, r0, c(r0));
    }

    public c a() {
        int r0 = this.f12278e.length;
        int r1 = 1;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L8;
        com.fasterxml.jackson.databind.b.v r3 = (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(this.f12278e[r1], com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        r3.a(r2);
        r2 = r2 + 1;
    L7:
        r1 = r1 + 2;
        goto L3
    L8:
        return this;
    }

    public c a(com.fasterxml.jackson.databind.l.q r5) {
        if (r5 != null) goto L4;
    L15:
        return this;
    L4:
        if (r5 == com.fasterxml.jackson.databind.l.q.f13048a) goto L15;
        int r0 = this.f.length;
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L14;
        com.fasterxml.jackson.databind.b.v r3 = this.f[r2];
        if (r3 != null) goto L11;
        r1.add(r3);
    L12:
        r2 = r2 + 1;
        goto L7
    L11:
        r1.add(a(r3, r5));
        goto L12
    L14:
        return new c(this.f12274a, r1, this.g, this.i);
    }

    public c a(Collection<String> r6, Collection<String> r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
    L6:
        if (r9 != null) goto L8;
        return this;
    L8:
        int r0 = this.f.length;
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L17;
        com.fasterxml.jackson.databind.b.v r3 = this.f[r2];
        if (r3 == null) goto L15;
        if (com.fasterxml.jackson.databind.l.m.a(r3.a(), r8, r9) == true) goto L15;
        r1.add(r3);
    L15:
        r2 = r2 + 1;
        goto L9
    L17:
        return new c(this.f12274a, r1, this.g, this.i);
    L5:
        if (r8.isEmpty() == false) goto L8;
        goto L6
    }

    public void a(com.fasterxml.jackson.databind.b.v r5, com.fasterxml.jackson.databind.b.v r6) {
        int r0 = this.f12278e.length;
        int r1 = 1;
    L3:
        if (r1 >= r0) goto L10;
        Object[] r2 = this.f12278e;
        if (r2[r1] == r5) goto L6;
        r1 = r1 + 2;
        goto L3
    L6:
        r2[r1] = r6;
        this.f[d(r5)] = r6;
        return;
    L10:
        throw new NoSuchElementException("No entry '" + r5.a() + "' found, can't replace");
    }

    public void b(com.fasterxml.jackson.databind.b.v r9) {
        ArrayList r0 = new ArrayList(this.f12276c);
        String r1 = c(r9);
        int r2 = this.f12278e.length;
        int r3 = 1;
        boolean r4 = false;
    L3:
        if (r3 >= r2) goto L13;
        com.fasterxml.jackson.databind.b.v r5 = (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(this.f12278e[r3], com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        if (r4 == true) goto L11;
        r4 = r1.equals(this.f12278e[r3 - 1]);
        if (r4 == false) goto L11;
        this.f[d(r5)] = null;
    L11:
        r0.add(r5);
    L12:
        r3 = r3 + 2;
        goto L3
    L13:
        if (r4 == false) goto L17;
        a(r0);
        return;
    L17:
        throw new NoSuchElementException("No entry '" + r9.a() + "' found, can't remove");
    }

    public int b() {
        return this.f12276c;
    }

    public boolean c() {
        return this.f12274a;
    }

    @Override // java.lang.Iterable
    public Iterator<com.fasterxml.jackson.databind.b.v> iterator() {
        return e().iterator();
    }

    private List<com.fasterxml.jackson.databind.b.v> e() {
        ArrayList r0 = new ArrayList(this.f12276c);
        int r1 = this.f12278e.length;
        int r2 = 1;
    L3:
        if (r2 >= r1) goto L8;
        com.fasterxml.jackson.databind.b.v r3 = (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(this.f12278e[r2], com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        r0.add(r3);
    L7:
        r2 = r2 + 2;
        goto L3
    L8:
        return r0;
    }

    public com.fasterxml.jackson.databind.b.v[] d() {
        return this.f;
    }

    public final String c(com.fasterxml.jackson.databind.b.v r2) {
        if (this.f12274a == false) goto L6;
        return r2.a().toLowerCase(this.i);
    L6:
        return r2.a();
    }

    public com.fasterxml.jackson.databind.b.v a(String r5) {
        if (r5 == null) goto L16;
        if (this.f12274a == false) goto L6;
        r5 = r5.toLowerCase(this.i);
    L6:
        int r0 = r5.hashCode() & this.f12275b;
        int r1 = r0 << 1;
        Object r2 = this.f12278e[r1];
        if (r2 == r5) goto L14;
        if (r5.equals(r2) == true) goto L14;
        return a(r5, r0, r2);
    L14:
        return (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(this.f12278e[r1 + 1], com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
    L16:
        throw new IllegalArgumentException("Cannot pass null property name");
    }

    private final com.fasterxml.jackson.databind.b.v a(String r4, int r5, Object r6) {
        if (r6 == null) goto L5;
        int r7 = this.f12275b + 1;
        int r8 = ((r5 >> 1) + r7) << 1;
        Object r1 = this.f12278e[r8];
        if (r4.equals(r1) == true) goto L9;
        if (r1 == null) goto L22;
        int r9 = (r7 + (r7 >> 1)) << 1;
        int r10 = this.f12277d + r9;
    L12:
        if (r9 >= r10) goto L22;
        Object r2 = this.f12278e[r9];
        if (r2 == r4) goto L20;
        if (r4.equals(r2) == true) goto L20;
        r9 = r9 + 2;
    L20:
        return (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(this.f12278e[r9 + 1], com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
    L22:
        return b((String) ZeusTransformUtils.preCheckCast(this.h.get(r4), String.class, "com.obric.aiagent.plugin"));
    L9:
        return (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(this.f12278e[r8 + 1], com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
    L5:
        return b((String) ZeusTransformUtils.preCheckCast(this.h.get(r4), String.class, "com.obric.aiagent.plugin"));
    }

    private com.fasterxml.jackson.databind.b.v b(String r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        int r1 = c(r6);
        int r2 = r1 << 1;
        Object r3 = this.f12278e[r2];
        if (r6.equals(r3) == true) goto L8;
        if (r3 != null) goto L12;
        return null;
    L12:
        return b(r6, r1, r3);
    L8:
        return (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(this.f12278e[r2 + 1], com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
    }

    private com.fasterxml.jackson.databind.b.v b(String r4, int r5, Object r6) {
        int r7 = this.f12275b + 1;
        int r8 = ((r5 >> 1) + r7) << 1;
        Object r0 = this.f12278e[r8];
        if (r4.equals(r0) == true) goto L5;
        if (r0 == null) goto L17;
        int r9 = (r7 + (r7 >> 1)) << 1;
        int r10 = this.f12277d + r9;
    L8:
        if (r9 >= r10) goto L22;
        Object r1 = this.f12278e[r9];
        if (r1 == r4) goto L16;
        if (r4.equals(r1) == true) goto L16;
        r9 = r9 + 2;
    L16:
        return (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(this.f12278e[r9 + 1], com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
    L22:
        return null;
    L17:
        return null;
    L5:
        return (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(this.f12278e[r8 + 1], com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Properties=[");
        Iterator<com.fasterxml.jackson.databind.b.v> r1 = iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L9;
        com.fasterxml.jackson.databind.b.v r3 = (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(r1.next(), com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
        int r4 = r2 + 1;
        if (r2 <= 0) goto L8;
        r0.append(", ");
    L8:
        r0.append(r3.a());
        r0.append('(');
        r0.append(r3.getType());
        r0.append(')');
        r2 = r4;
        goto L4
    L9:
        r0.append(']');
        if (this.g.isEmpty() == true) goto L13;
        r0.append("(aliases: ");
        r0.append(this.g);
        r0.append(")");
    L13:
        return r0.toString();
    }

    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.b.v r1, com.fasterxml.jackson.databind.l.q r2) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        com.fasterxml.jackson.databind.b.v r0 = r1.a(r2.a(r1.a()));
        com.fasterxml.jackson.databind.l<Object> r3 = r0.o();
        if (r3 == null) goto L10;
        com.fasterxml.jackson.databind.l<Object> r4 = r3.a(r2);
        if (r4 != r3) goto L9;
        return r0;
    L9:
        return r0.a(r4);
    L10:
        return r0;
    }

    private final int d(com.fasterxml.jackson.databind.b.v r4) {
        int r0 = this.f.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (this.f[r1] == r4) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L9:
        throw new IllegalStateException("Illegal state: property '" + r4.a() + "' missing from _propsInOrder");
    }

    private final int c(String r1) {
        int r2 = r1.hashCode();
        return this.f12275b & r2;
    }

    private Map<String, String> a(Map<String, List<com.fasterxml.jackson.databind.x>> r6, boolean r7, Locale r8) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L22;
        if (r5.isEmpty() == true) goto L22;
        HashMap r9 = new HashMap();
        Iterator r10 = r5.entrySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L20;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L13;
        r2 = r2.toLowerCase(r8);
    L13:
        Iterator r3 = ((List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();
    L15:
        if (r3.hasNext() == false) goto L9;
        String r4 = ((com.fasterxml.jackson.databind.x) ZeusTransformUtils.preCheckCast(r3.next(), com.fasterxml.jackson.databind.x.class, "com.obric.aiagent.plugin")).b();
        if (r7 == false) goto L19;
        r4 = r4.toLowerCase(r8);
    L19:
        r9.put(r4, r2);
        goto L15
    L20:
        return r9;
    L22:
        return Collections.emptyMap();
    }
}
