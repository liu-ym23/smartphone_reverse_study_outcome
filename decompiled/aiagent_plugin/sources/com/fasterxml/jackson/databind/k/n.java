package com.fasterxml.jackson.databind.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TypeBindings.java */
/* JADX INFO: loaded from: classes2.dex */
public class n implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f12972a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.fasterxml.jackson.databind.k[] f12973b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final n f12974c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f12975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.fasterxml.jackson.databind.k[] f12976e;
    private final String[] f;
    private final int g;

    /* JADX INFO: compiled from: TypeBindings.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<?> f12977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.k[] f12978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f12979c;

        public a(Class<?> r1, com.fasterxml.jackson.databind.k[] r2, int r3) {
            this.f12977a = r1;
            this.f12978b = r2;
            this.f12979c = r3;
        }

        public int hashCode() {
            return this.f12979c;
        }

        public boolean equals(Object r7) {
            if (r7 != this) goto L6;
            return true;
        L6:
            if (r7 != null) goto L9;
            return false;
        L9:
            if (r7.getClass() == getClass()) goto L11;
            return false;
        L11:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (this.f12979c == r8.f12979c) goto L14;
        L24:
            return false;
        L14:
            if (this.f12977a != r8.f12977a) goto L24;
            com.fasterxml.jackson.databind.k[] r9 = r8.f12978b;
            int r2 = this.f12978b.length;
            if (r2 != r9.length) goto L24;
            int r3 = 0;
        L18:
            if (r3 >= r2) goto L23;
            if (this.f12978b[r3].equals(r9[r3]) == false) goto L21;
            r3 = r3 + 1;
            goto L18
        L21:
            return false;
        L23:
            return true;
        }

        public String toString() {
            return this.f12977a.getName() + "<>";
        }
    }

    /* JADX INFO: compiled from: TypeBindings.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final TypeVariable<?>[] f12980a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final TypeVariable<?>[] f12981b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final TypeVariable<?>[] f12982c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final TypeVariable<?>[] f12983d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final TypeVariable<?>[] f12984e = null;
        private static final TypeVariable<?>[] f = null;
        private static final TypeVariable<?>[] g = null;
        private static final TypeVariable<?>[] h = null;

        static {
            f12980a = AbstractList.class.getTypeParameters();
            f12981b = Collection.class.getTypeParameters();
            f12982c = Iterable.class.getTypeParameters();
            f12983d = List.class.getTypeParameters();
            f12984e = ArrayList.class.getTypeParameters();
            f = Map.class.getTypeParameters();
            g = HashMap.class.getTypeParameters();
            h = LinkedHashMap.class.getTypeParameters();
        }

        public static TypeVariable<?>[] a(Class<?> r1) {
            if (r1 != Collection.class) goto L7;
            return f12981b;
        L7:
            if (r1 != List.class) goto L11;
            return f12983d;
        L11:
            if (r1 != ArrayList.class) goto L15;
            return f12984e;
        L15:
            if (r1 != AbstractList.class) goto L19;
            return f12980a;
        L19:
            if (r1 != Iterable.class) goto L23;
            return f12982c;
        L23:
            return r1.getTypeParameters();
        }

        public static TypeVariable<?>[] b(Class<?> r1) {
            if (r1 != Map.class) goto L7;
            return f;
        L7:
            if (r1 != HashMap.class) goto L11;
            return g;
        L11:
            if (r1 != LinkedHashMap.class) goto L15;
            return h;
        L15:
            return r1.getTypeParameters();
        }
    }

    static {
        String[] r1 = new String[0];
        f12972a = r1;
        com.fasterxml.jackson.databind.k[] r0 = new com.fasterxml.jackson.databind.k[0];
        f12973b = r0;
        f12974c = new n(r1, r0, null);
    }

    private n(String[] r3, com.fasterxml.jackson.databind.k[] r4, String[] r5) {
        if (r3 != null) goto L5;
        r3 = f12972a;
    L5:
        this.f12975d = r3;
        if (r4 != null) goto L8;
        r4 = f12973b;
    L8:
        this.f12976e = r4;
        if (r3.length != r4.length) goto L16;
        int r6 = 0;
        int r7 = r4.length;
        int r0 = 1;
    L11:
        if (r6 >= r7) goto L13;
        r0 = r0 + this.f12976e[r6].hashCode();
        r6 = r6 + 1;
        goto L11
    L13:
        this.f = r5;
        this.g = r0;
        return;
    L16:
        throw new IllegalArgumentException("Mismatching names (" + r3.length + "), types (" + r4.length + ")");
    }

    public static n a() {
        return f12974c;
    }

    public static n a(Class<?> r2, List<com.fasterxml.jackson.databind.k> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
    L8:
        com.fasterxml.jackson.databind.k[] r5 = f12973b;
    L10:
        return a(r2, r5);
    L5:
        if (r4.isEmpty() == true) goto L8;
        r5 = (com.fasterxml.jackson.databind.k[]) ZeusTransformUtils.preCheckCast(r4.toArray(f12973b), com.fasterxml.jackson.databind.k[].class, "com.obric.aiagent.plugin");
        goto L10
    }

    public static n a(Class<?> r6, com.fasterxml.jackson.databind.k[] r7) {
        int r0 = 0;
        if (r7 != null) goto L5;
        r7 = f12973b;
    L9:
        TypeVariable<Class<?>>[] r2 = r6.getTypeParameters();
        if (r2 != null) goto L12;
    L17:
        String[] r4 = f12972a;
    L19:
        if (r4.length == r7.length) goto L27;
        StringBuilder r8 = new StringBuilder().append("Cannot create TypeBindings for class ").append(r6.getName()).append(" with ").append(r7.length).append(" type parameter");
        if (r7.length != 1) goto L23;
        String r9 = "";
    L25:
        throw new IllegalArgumentException(r8.append(r9).append(": class expects ").append(r4.length).toString());
    L23:
        r9 = "s";
        goto L25
    L27:
        return new n(r4, r7, null);
    L12:
        if (r2.length == 0) goto L17;
        int r3 = r2.length;
        r4 = new String[r3];
    L15:
        if (r0 >= r3) goto L19;
        r4[r0] = r2[r0].getName();
        r0 = r0 + 1;
        goto L15
    L5:
        int r5 = r7.length;
        if (r5 == 1) goto L31;
        if (r5 != 2) goto L9;
        return a(r6, r7[0], r7[1]);
    L31:
        return a(r6, r7[0]);
    }

    public static n a(Class<?> r4, com.fasterxml.jackson.databind.k r5) {
        TypeVariable<?>[] r0 = b.a(r4);
        if (r0 != null) goto L5;
        int r2 = 0;
    L7:
        if (r2 != 1) goto L11;
        return new n(new String[]{r0[0].getName()}, new com.fasterxml.jackson.databind.k[]{r5}, null);
    L11:
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + r4.getName() + " with 1 type parameter: class expects " + r2);
    L5:
        r2 = r0.length;
        goto L7
    }

    public static n a(Class<?> r5, com.fasterxml.jackson.databind.k r6, com.fasterxml.jackson.databind.k r7) {
        TypeVariable<?>[] r0 = b.b(r5);
        if (r0 != null) goto L5;
        int r2 = 0;
    L7:
        if (r2 != 2) goto L11;
        return new n(new String[]{r0[0].getName(), r0[1].getName()}, new com.fasterxml.jackson.databind.k[]{r6, r7}, null);
    L11:
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + r5.getName() + " with 2 type parameters: class expects " + r2);
    L5:
        r2 = r0.length;
        goto L7
    }

    public static n a(List<String> r3, List<com.fasterxml.jackson.databind.k> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L13;
        if (r5.isEmpty() == true) goto L13;
        if (r6 == null) goto L13;
        if (r6.isEmpty() == true) goto L13;
        return new n((String[]) ZeusTransformUtils.preCheckCast(r5.toArray(f12972a), String[].class, "com.obric.aiagent.plugin"), (com.fasterxml.jackson.databind.k[]) ZeusTransformUtils.preCheckCast(r6.toArray(f12973b), com.fasterxml.jackson.databind.k[].class, "com.obric.aiagent.plugin"), null);
    L13:
        return f12974c;
    }

    public static n b(Class<?> r4, com.fasterxml.jackson.databind.k r5) {
        TypeVariable<Class<?>>[] r0 = r4.getTypeParameters();
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        if (r2 != 0) goto L10;
        return f12974c;
    L10:
        if (r2 != 1) goto L14;
        return new n(new String[]{r0[0].getName()}, new com.fasterxml.jackson.databind.k[]{r5}, null);
    L14:
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + r4.getName() + " with 1 type parameter: class expects " + r2);
    L5:
        r2 = r0.length;
        goto L6
    }

    public static n b(Class<?> r5, com.fasterxml.jackson.databind.k[] r6) {
        TypeVariable<Class<?>>[] r0 = r5.getTypeParameters();
        if (r0 == null) goto L23;
        if (r0.length == 0) goto L23;
        if (r6 != null) goto L9;
        r6 = f12973b;
    L9:
        int r1 = r0.length;
        String[] r2 = new String[r1];
        int r3 = 0;
    L10:
        if (r3 >= r1) goto L13;
        r2[r3] = r0[r3].getName();
        r3 = r3 + 1;
        goto L10
    L13:
        if (r1 == r6.length) goto L21;
        StringBuilder r7 = new StringBuilder().append("Cannot create TypeBindings for class ").append(r5.getName()).append(" with ").append(r6.length).append(" type parameter");
        if (r6.length != 1) goto L17;
        String r8 = "";
    L19:
        throw new IllegalArgumentException(r7.append(r8).append(": class expects ").append(r1).toString());
    L17:
        r8 = "s";
        goto L19
    L21:
        return new n(r2, r6, null);
    L23:
        return f12974c;
    }

    public n a(String r5) {
        String[] r0 = this.f;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        if (r1 != 0) goto L8;
        String[] r2 = new String[1];
    L9:
        r2[r1] = r5;
        return new n(this.f12975d, this.f12976e, r2);
    L8:
        r2 = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r0, r1 + 1), String[].class, "com.obric.aiagent.plugin");
        goto L9
    L5:
        r1 = r0.length;
        goto L6
    }

    public com.fasterxml.jackson.databind.k b(String r4) {
        int r0 = this.f12975d.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        if (r4.equals(this.f12975d[r1]) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        com.fasterxml.jackson.databind.k r3 = this.f12976e[r1];
        if (ZeusTransformUtils.instanceOf(r3, k.class) == false) goto L17;
        com.fasterxml.jackson.databind.k r5 = ((k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.aiagent.plugin")).H();
        if (r5 != null) goto L11;
        return r3;
    L11:
        return r5;
    L17:
        return r3;
    L13:
        return null;
    }

    public boolean b() {
        if (this.f12976e.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int c() {
        return this.f12976e.length;
    }

    public com.fasterxml.jackson.databind.k a(int r2) {
        if (r2 < 0) goto L8;
        com.fasterxml.jackson.databind.k[] r1 = this.f12976e;
        if (r2 < r1.length) goto L7;
        return null;
    L7:
        return r1[r2];
    L8:
        return null;
    }

    public List<com.fasterxml.jackson.databind.k> d() {
        com.fasterxml.jackson.databind.k[] r1 = this.f12976e;
        if (r1.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return Arrays.asList(r1);
    }

    public boolean c(String r3) {
        String[] r0 = this.f;
        if (r0 == null) goto L11;
        int r1 = r0.length;
    L5:
        r1 = r1 - 1;
        if (r1 < 0) goto L16;
        if (r3.equals(this.f[r1]) == false) goto L5;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    public Object a(Class<?> r3) {
        return new a(r3, this.f12976e, this.g);
    }

    public String toString() {
        if (this.f12976e.length != 0) goto L6;
        return "<>";
    L6:
        StringBuilder r0 = new StringBuilder();
        r0.append('<');
        int r1 = 0;
        int r2 = this.f12976e.length;
    L7:
        if (r1 >= r2) goto L11;
        if (r1 <= 0) goto L10;
        r0.append(',');
    L10:
        r0.append(this.f12976e[r1].G());
        r1 = r1 + 1;
        goto L7
    L11:
        r0.append('>');
        return r0.toString();
    }

    public int hashCode() {
        return this.g;
    }

    public boolean equals(Object r7) {
        if (r7 != this) goto L6;
        return true;
    L6:
        if (com.fasterxml.jackson.databind.l.h.a(r7, getClass()) == true) goto L8;
        return false;
    L8:
        n r8 = (n) ZeusTransformUtils.preCheckCast(r7, n.class, "com.obric.aiagent.plugin");
        int r1 = this.f12976e.length;
        if (r1 == r8.c()) goto L11;
        return false;
    L11:
        com.fasterxml.jackson.databind.k[] r9 = r8.f12976e;
        int r3 = 0;
    L12:
        if (r3 >= r1) goto L17;
        if (r9[r3].equals(this.f12976e[r3]) == false) goto L15;
        r3 = r3 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    public com.fasterxml.jackson.databind.k[] e() {
        return this.f12976e;
    }
}
