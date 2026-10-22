package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: _Arrays.kt */
/* JADX INFO: loaded from: classes4.dex */
class m extends l {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Iterables.kt */
    public static final class a<T> implements d.h.b.a.a, Iterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f38387a;

        public a(Object[] r1) {
            this.f38387a = r1;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return d.h.b.c.a(this.f38387a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class b<T> implements d.n.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f38388a;

        public b(Object[] r1) {
            this.f38388a = r1;
        }

        @Override // d.n.j
        public Iterator<T> a() {
            return d.h.b.c.a(this.f38388a);
        }
    }

    public static final <T> boolean b(T[] r1, T r2) {
        d.h.b.o.e(r1, "<this>");
        if (i.c(r1, r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean a(int[] r1, int r2) {
        d.h.b.o.e(r1, "<this>");
        if (i.b(r1, r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean a(char[] r1, char r2) {
        d.h.b.o.e(r1, "<this>");
        if (i.b(r1, r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final float a(float[] r2) {
        d.h.b.o.e(r2, "<this>");
        if (r2.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return r2[0];
    L10:
        throw new NoSuchElementException("Array is empty.");
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> T c(T[] r2) {
        d.h.b.o.e(r2, "<this>");
        if (r2.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        return r2[0];
    L5:
        r0 = false;
        goto L6
    }

    public static final Byte a(byte[] r2) {
        d.h.b.o.e(r2, "<this>");
        if (r2.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        return Byte.valueOf(r2[0]);
    L5:
        r0 = false;
        goto L6
    }

    public static final Integer b(int[] r2) {
        d.h.b.o.e(r2, "<this>");
        if (r2.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        return Integer.valueOf(r2[0]);
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> T b(T[] r2, int r3) {
        d.h.b.o.e(r2, "<this>");
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L11;
        return null;
    L11:
        return r2[r3];
    L5:
        if (r3 >= r2.length) goto L7;
        r0 = true;
        goto L7
    }

    public static final Float a(float[] r2, int r3) {
        d.h.b.o.e(r2, "<this>");
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L11;
        return null;
    L11:
        return Float.valueOf(r2[r3]);
    L5:
        if (r3 >= r2.length) goto L7;
        r0 = true;
        goto L7
    }

    public static final <T> int c(T[] r3, T r4) {
        d.h.b.o.e(r3, "<this>");
        int r0 = 0;
        if (r4 != null) goto L10;
        int r5 = r3.length;
    L5:
        if (r0 >= r5) goto L16;
        if (r3[r0] == null) goto L8;
        r0 = r0 + 1;
        goto L5
    L8:
        return r0;
    L16:
        return -1;
    L10:
        int r1 = r3.length;
    L11:
        if (r0 >= r1) goto L22;
        if (d.h.b.o.a(r4, r3[r0]) == true) goto L14;
        r0 = r0 + 1;
        goto L11
    L14:
        return r0;
    L22:
        return -1;
    }

    public static final int b(int[] r3, int r4) {
        d.h.b.o.e(r3, "<this>");
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r4 == r3[r1]) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    public static final int b(char[] r3, char r4) {
        d.h.b.o.e(r3, "<this>");
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r4 == r3[r1]) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    public static final float b(float[] r1) {
        d.h.b.o.e(r1, "<this>");
        if (r1.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return r1[i.c(r1)];
    L10:
        throw new NoSuchElementException("Array is empty.");
    L5:
        r0 = false;
        goto L6
    }

    public static final char a(char[] r2) {
        d.h.b.o.e(r2, "<this>");
        int r0 = r2.length;
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L9;
        return r2[0];
    L9:
        throw new IllegalArgumentException("Array has more than one element.");
    L11:
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T d(T[] r2) {
        d.h.b.o.e(r2, "<this>");
        if (r2.length == 1) goto L7;
        return null;
    L7:
        return r2[0];
    }

    public static final <T> List<T> e(T[] r3) {
        d.h.b.o.e(r3, "<this>");
        return (List) ZeusTransformUtils.preCheckCast(i.a(r3, (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin");
    }

    public static final <C extends Collection<? super T>, T> C a(T[] r3, C r4) {
        C r5 = (C) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r5, "destination");
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        T r2 = r3[r1];
        if (r2 == null) goto L7;
        r5.add(r2);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r5;
    }

    public static final byte[] a(byte[] r1, d.l.j r2) {
        d.h.b.o.e(r1, "<this>");
        d.h.b.o.e(r2, "indices");
        if (r2.d() == false) goto L7;
        return new byte[0];
    L7:
        return i.a(r1, r2.f().intValue(), r2.i().intValue() + 1);
    }

    public static final <T> List<T> c(T[] r6, int r7) {
        d.h.b.o.e(r6, "<this>");
        int r1 = 0;
        if (r7 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L26;
        if (r7 != 0) goto L11;
        return p.b();
    L11:
        if (r7 >= r6.length) goto L13;
        if (r7 == 1) goto L16;
        ArrayList r3 = new ArrayList(r7);
        int r4 = r6.length;
        int r5 = 0;
    L18:
        if (r1 >= r4) goto L24;
        r3.add(r6[r1]);
        r5 = r5 + 1;
        if (r5 == r7) goto L24;
        r1 = r1 + 1;
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    L16:
        return p.a(r6[0]);
    L13:
        return i.g(r6);
    L26:
        throw new IllegalArgumentException(("Requested element count " + r7 + " is less than zero.").toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final List<Byte> a(byte[] r6, int r7) {
        d.h.b.o.e(r6, "<this>");
        int r1 = 0;
        if (r7 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L26;
        if (r7 != 0) goto L11;
        return p.b();
    L11:
        if (r7 >= r6.length) goto L13;
        if (r7 == 1) goto L16;
        ArrayList r3 = new ArrayList(r7);
        int r4 = r6.length;
        int r5 = 0;
    L18:
        if (r1 >= r4) goto L24;
        r3.add(Byte.valueOf(r6[r1]));
        r5 = r5 + 1;
        if (r5 == r7) goto L24;
        r1 = r1 + 1;
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    L16:
        return p.a(Byte.valueOf(r6[0]));
    L13:
        return i.d(r6);
    L26:
        throw new IllegalArgumentException(("Requested element count " + r7 + " is less than zero.").toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final List<Integer> c(int[] r6, int r7) {
        d.h.b.o.e(r6, "<this>");
        int r1 = 0;
        if (r7 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L26;
        if (r7 != 0) goto L11;
        return p.b();
    L11:
        if (r7 >= r6.length) goto L13;
        if (r7 == 1) goto L16;
        ArrayList r3 = new ArrayList(r7);
        int r4 = r6.length;
        int r5 = 0;
    L18:
        if (r1 >= r4) goto L24;
        r3.add(Integer.valueOf(r6[r1]));
        r5 = r5 + 1;
        if (r5 == r7) goto L24;
        r1 = r1 + 1;
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    L16:
        return p.a(Integer.valueOf(r6[0]));
    L13:
        return i.f(r6);
    L26:
        throw new IllegalArgumentException(("Requested element count " + r7 + " is less than zero.").toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final List<Integer> c(int[] r2) {
        d.h.b.o.e(r2, "<this>");
        Integer[] r3 = i.a(r2);
        i.b((Comparable[]) ZeusTransformUtils.preCheckCast(r3, Comparable[].class, "com.obric.aiagent.plugin"));
        return i.a((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.aiagent.plugin"));
    }

    public static final <T> T[] b(T[] r2, Comparator<? super T> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r4, "comparator");
        if (r2.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r2;
    L8:
        T[] r5 = (T[]) Arrays.copyOf(r2, r2.length);
        d.h.b.o.c(r5, "copyOf(...)");
        i.a(r5, r4);
        return r5;
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> List<T> c(T[] r2, Comparator<? super T> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r4, "comparator");
        return i.a(i.b(r2, r4));
    }

    public static final d.l.j b(byte[] r2) {
        d.h.b.o.e(r2, "<this>");
        return new d.l.j(0, i.c(r2));
    }

    public static final d.l.j d(int[] r2) {
        d.h.b.o.e(r2, "<this>");
        return new d.l.j(0, i.e(r2));
    }

    public static final <T> int f(T[] r1) {
        d.h.b.o.e(r1, "<this>");
        return r1.length - 1;
    }

    public static final int c(byte[] r1) {
        d.h.b.o.e(r1, "<this>");
        return r1.length - 1;
    }

    public static final int e(int[] r1) {
        d.h.b.o.e(r1, "<this>");
        return r1.length - 1;
    }

    public static final int a(long[] r1) {
        d.h.b.o.e(r1, "<this>");
        return r1.length - 1;
    }

    public static final int c(float[] r1) {
        d.h.b.o.e(r1, "<this>");
        return r1.length - 1;
    }

    public static final int a(boolean[] r1) {
        d.h.b.o.e(r1, "<this>");
        return r1.length - 1;
    }

    public static final <T, C extends Collection<? super T>> C b(T[] r3, C r4) {
        C r5 = (C) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r5, "destination");
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.add(r3[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r5;
    }

    public static final <C extends Collection<? super Integer>> C a(int[] r3, C r4) {
        C r5 = (C) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r5, "destination");
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.add(Integer.valueOf(r3[r1]));
        r1 = r1 + 1;
        goto L3
    L5:
        return r5;
    }

    public static final <T> List<T> g(T[] r2) {
        d.h.b.o.e(r2, "<this>");
        int r0 = r2.length;
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        return i.h(r2);
    L11:
        return p.a(r2[0]);
    L9:
        return p.b();
    }

    public static final List<Byte> d(byte[] r2) {
        d.h.b.o.e(r2, "<this>");
        int r0 = r2.length;
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        return i.e(r2);
    L11:
        return p.a(Byte.valueOf(r2[0]));
    L9:
        return p.b();
    }

    public static final List<Integer> f(int[] r2) {
        d.h.b.o.e(r2, "<this>");
        int r0 = r2.length;
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        return i.g(r2);
    L11:
        return p.a(Integer.valueOf(r2[0]));
    L9:
        return p.b();
    }

    public static final List<Long> b(long[] r2) {
        d.h.b.o.e(r2, "<this>");
        int r0 = r2.length;
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        return i.c(r2);
    L11:
        return p.a(Long.valueOf(r2[0]));
    L9:
        return p.b();
    }

    public static final List<Float> d(float[] r2) {
        d.h.b.o.e(r2, "<this>");
        int r0 = r2.length;
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        return i.e(r2);
    L11:
        return p.a(Float.valueOf(r2[0]));
    L9:
        return p.b();
    }

    public static final List<Boolean> b(boolean[] r2) {
        d.h.b.o.e(r2, "<this>");
        int r0 = r2.length;
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        return i.c(r2);
    L11:
        return p.a(Boolean.valueOf(r2[0]));
    L9:
        return p.b();
    }

    public static final <T> List<T> h(T[] r2) {
        d.h.b.o.e(r2, "<this>");
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r2)), List.class, "com.obric.aiagent.plugin");
    }

    public static final List<Byte> e(byte[] r4) {
        d.h.b.o.e(r4, "<this>");
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(Byte.valueOf(r4[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }

    public static final List<Integer> g(int[] r4) {
        d.h.b.o.e(r4, "<this>");
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(Integer.valueOf(r4[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }

    public static final List<Long> c(long[] r5) {
        d.h.b.o.e(r5, "<this>");
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(Long.valueOf(r5[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }

    public static final List<Float> e(float[] r4) {
        d.h.b.o.e(r4, "<this>");
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(Float.valueOf(r4[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }

    public static final List<Boolean> c(boolean[] r4) {
        d.h.b.o.e(r4, "<this>");
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(Boolean.valueOf(r4[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }

    public static final <T> Set<T> i(T[] r3) {
        d.h.b.o.e(r3, "<this>");
        int r0 = r3.length;
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        return (Set) ZeusTransformUtils.preCheckCast(i.b(r3, (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(ao.a(r3.length)), Collection.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin");
    L11:
        return ax.a(r3[0]);
    L9:
        return ax.b();
    }

    public static final Set<Integer> h(int[] r3) {
        d.h.b.o.e(r3, "<this>");
        int r0 = r3.length;
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        return (Set) ZeusTransformUtils.preCheckCast(i.a(r3, (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(ao.a(r3.length)), Collection.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin");
    L11:
        return ax.a(Integer.valueOf(r3[0]));
    L9:
        return ax.b();
    }

    public static final <T, A extends Appendable> A a(T[] r4, A r5, CharSequence r6, CharSequence r7, CharSequence r8, int r9, CharSequence r10, d.h.a.b<? super T, ? extends CharSequence> r11) {
        A r12 = (A) ZeusTransformUtils.wrapperContextForParams(r5, Appendable.class, "com.obric.aiagent.plugin");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r17 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r12, "buffer");
        d.h.b.o.e(r13, "separator");
        d.h.b.o.e(r14, "prefix");
        d.h.b.o.e(r15, "postfix");
        d.h.b.o.e(r16, "truncated");
        r12.append(r14);
        int r18 = r4.length;
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r18) goto L10;
        T r2 = r4[r0];
        r1 = r1 + 1;
        if (r1 <= 1) goto L7;
        r12.append(r13);
    L7:
        if (r9 < 0) goto L9;
        if (r1 > r9) goto L10;
    L9:
        d.o.o.a(r12, r2, r17);
        r0 = r0 + 1;
    L10:
        if (r9 < 0) goto L13;
        if (r1 <= r9) goto L13;
        r12.append(r16);
    L13:
        r12.append(r15);
        return r12;
    }

    public static final <A extends Appendable> A a(byte[] r5, A r6, CharSequence r7, CharSequence r8, CharSequence r9, int r10, CharSequence r11, d.h.a.b<? super Byte, ? extends CharSequence> r12) {
        A r13 = (A) ZeusTransformUtils.wrapperContextForParams(r6, Appendable.class, "com.obric.aiagent.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r18 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r13, "buffer");
        d.h.b.o.e(r14, "separator");
        d.h.b.o.e(r15, "prefix");
        d.h.b.o.e(r16, "postfix");
        d.h.b.o.e(r17, "truncated");
        r13.append(r15);
        int r19 = r5.length;
        int r0 = 0;
        int r2 = 0;
    L3:
        if (r0 >= r19) goto L13;
        byte r3 = r5[r0];
        r2 = r2 + 1;
        if (r2 <= 1) goto L7;
        r13.append(r14);
    L7:
        if (r10 < 0) goto L9;
        if (r2 > r10) goto L13;
    L9:
        if (r18 == null) goto L11;
        r13.append((CharSequence) ZeusTransformUtils.preCheckCast(r18.invoke(Byte.valueOf(r3)), CharSequence.class, "com.obric.aiagent.plugin"));
    L12:
        r0 = r0 + 1;
        goto L3
    L11:
        r13.append((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r3), CharSequence.class, "com.obric.aiagent.plugin"));
    L13:
        if (r10 < 0) goto L16;
        if (r2 <= r10) goto L16;
        r13.append(r17);
    L16:
        r13.append(r16);
        return r13;
    }

    public static final <A extends Appendable> A a(int[] r5, A r6, CharSequence r7, CharSequence r8, CharSequence r9, int r10, CharSequence r11, d.h.a.b<? super Integer, ? extends CharSequence> r12) {
        A r13 = (A) ZeusTransformUtils.wrapperContextForParams(r6, Appendable.class, "com.obric.aiagent.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r18 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r13, "buffer");
        d.h.b.o.e(r14, "separator");
        d.h.b.o.e(r15, "prefix");
        d.h.b.o.e(r16, "postfix");
        d.h.b.o.e(r17, "truncated");
        r13.append(r15);
        int r19 = r5.length;
        int r0 = 0;
        int r2 = 0;
    L3:
        if (r0 >= r19) goto L13;
        int r3 = r5[r0];
        r2 = r2 + 1;
        if (r2 <= 1) goto L7;
        r13.append(r14);
    L7:
        if (r10 < 0) goto L9;
        if (r2 > r10) goto L13;
    L9:
        if (r18 == null) goto L11;
        r13.append((CharSequence) ZeusTransformUtils.preCheckCast(r18.invoke(Integer.valueOf(r3)), CharSequence.class, "com.obric.aiagent.plugin"));
    L12:
        r0 = r0 + 1;
        goto L3
    L11:
        r13.append((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r3), CharSequence.class, "com.obric.aiagent.plugin"));
    L13:
        if (r10 < 0) goto L16;
        if (r2 <= r10) goto L16;
        r13.append(r17);
    L16:
        r13.append(r16);
        return r13;
    }

    public static final <A extends Appendable> A a(long[] r6, A r7, CharSequence r8, CharSequence r9, CharSequence r10, int r11, CharSequence r12, d.h.a.b<? super Long, ? extends CharSequence> r13) {
        A r14 = (A) ZeusTransformUtils.wrapperContextForParams(r7, Appendable.class, "com.obric.aiagent.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r18 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r19 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r14, "buffer");
        d.h.b.o.e(r15, "separator");
        d.h.b.o.e(r16, "prefix");
        d.h.b.o.e(r17, "postfix");
        d.h.b.o.e(r18, "truncated");
        r14.append(r16);
        int r20 = r6.length;
        int r0 = 0;
        int r2 = 0;
    L3:
        if (r0 >= r20) goto L13;
        long r3 = r6[r0];
        r2 = r2 + 1;
        if (r2 <= 1) goto L7;
        r14.append(r15);
    L7:
        if (r11 < 0) goto L9;
        if (r2 > r11) goto L13;
    L9:
        if (r19 == null) goto L11;
        r14.append((CharSequence) ZeusTransformUtils.preCheckCast(r19.invoke(Long.valueOf(r3)), CharSequence.class, "com.obric.aiagent.plugin"));
    L12:
        r0 = r0 + 1;
        goto L3
    L11:
        r14.append((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r3), CharSequence.class, "com.obric.aiagent.plugin"));
    L13:
        if (r11 < 0) goto L16;
        if (r2 <= r11) goto L16;
        r14.append(r18);
    L16:
        r14.append(r17);
        return r14;
    }

    public static /* synthetic */ String a(Object[] r8, CharSequence r9, CharSequence r10, CharSequence r11, int r12, CharSequence r13, d.h.a.b r14, int r15, Object r16) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r15 & 1) == 0) goto L6;
        r0 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin");
    L6:
        if ((r15 & 2) == 0) goto L9;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L9:
        if ((r15 & 4) == 0) goto L12;
        r3 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        if ((r15 & 8) == 0) goto L14;
        int r6 = -1;
    L16:
        if ((r15 & 16) == 0) goto L19;
        r4 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.aiagent.plugin");
    L19:
        if ((r15 & 32) == 0) goto L22;
        r5 = null;
    L22:
        return i.a(r8, r0, r2, r3, r6, r4, r5);
    L14:
        r6 = r12;
        goto L16
    }

    public static final <T> String a(T[] r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, d.h.a.b<? super T, ? extends CharSequence> r16) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r15, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "<this>");
        d.h.b.o.e(r4, "separator");
        d.h.b.o.e(r5, "prefix");
        d.h.b.o.e(r6, "postfix");
        d.h.b.o.e(r8, "truncated");
        String r0 = ((StringBuilder) ZeusTransformUtils.preCheckCast(i.a(r10, (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin"), r4, r5, r6, r14, r8, r9), StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        d.h.b.o.c(r0, "toString(...)");
        return r0;
    }

    public static /* synthetic */ String a(byte[] r8, CharSequence r9, CharSequence r10, CharSequence r11, int r12, CharSequence r13, d.h.a.b r14, int r15, Object r16) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r15 & 1) == 0) goto L6;
        r0 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin");
    L6:
        if ((r15 & 2) == 0) goto L9;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L9:
        if ((r15 & 4) == 0) goto L12;
        r3 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        if ((r15 & 8) == 0) goto L14;
        int r6 = -1;
    L16:
        if ((r15 & 16) == 0) goto L19;
        r4 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.aiagent.plugin");
    L19:
        if ((r15 & 32) == 0) goto L22;
        r5 = null;
    L22:
        return i.a(r8, r0, r2, r3, r6, r4, r5);
    L14:
        r6 = r12;
        goto L16
    }

    public static final String a(byte[] r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, d.h.a.b<? super Byte, ? extends CharSequence> r16) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r15, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "<this>");
        d.h.b.o.e(r4, "separator");
        d.h.b.o.e(r5, "prefix");
        d.h.b.o.e(r6, "postfix");
        d.h.b.o.e(r8, "truncated");
        String r0 = ((StringBuilder) ZeusTransformUtils.preCheckCast(i.a(r10, (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin"), r4, r5, r6, r14, r8, r9), StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        d.h.b.o.c(r0, "toString(...)");
        return r0;
    }

    public static /* synthetic */ String a(int[] r8, CharSequence r9, CharSequence r10, CharSequence r11, int r12, CharSequence r13, d.h.a.b r14, int r15, Object r16) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r15 & 1) == 0) goto L6;
        r0 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin");
    L6:
        if ((r15 & 2) == 0) goto L9;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L9:
        if ((r15 & 4) == 0) goto L12;
        r3 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        if ((r15 & 8) == 0) goto L14;
        int r6 = -1;
    L16:
        if ((r15 & 16) == 0) goto L19;
        r4 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.aiagent.plugin");
    L19:
        if ((r15 & 32) == 0) goto L22;
        r5 = null;
    L22:
        return i.a(r8, r0, r2, r3, r6, r4, r5);
    L14:
        r6 = r12;
        goto L16
    }

    public static final String a(int[] r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, d.h.a.b<? super Integer, ? extends CharSequence> r16) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r15, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "<this>");
        d.h.b.o.e(r4, "separator");
        d.h.b.o.e(r5, "prefix");
        d.h.b.o.e(r6, "postfix");
        d.h.b.o.e(r8, "truncated");
        String r0 = ((StringBuilder) ZeusTransformUtils.preCheckCast(i.a(r10, (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin"), r4, r5, r6, r14, r8, r9), StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        d.h.b.o.c(r0, "toString(...)");
        return r0;
    }

    public static /* synthetic */ String a(long[] r8, CharSequence r9, CharSequence r10, CharSequence r11, int r12, CharSequence r13, d.h.a.b r14, int r15, Object r16) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r15 & 1) == 0) goto L6;
        r0 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin");
    L6:
        if ((r15 & 2) == 0) goto L9;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L9:
        if ((r15 & 4) == 0) goto L12;
        r3 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        if ((r15 & 8) == 0) goto L14;
        int r6 = -1;
    L16:
        if ((r15 & 16) == 0) goto L19;
        r4 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.aiagent.plugin");
    L19:
        if ((r15 & 32) == 0) goto L22;
        r5 = null;
    L22:
        return i.a(r8, r0, r2, r3, r6, r4, r5);
    L14:
        r6 = r12;
        goto L16
    }

    public static final String a(long[] r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, d.h.a.b<? super Long, ? extends CharSequence> r16) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r15, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "<this>");
        d.h.b.o.e(r4, "separator");
        d.h.b.o.e(r5, "prefix");
        d.h.b.o.e(r6, "postfix");
        d.h.b.o.e(r8, "truncated");
        String r0 = ((StringBuilder) ZeusTransformUtils.preCheckCast(i.a(r10, (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin"), r4, r5, r6, r14, r8, r9), StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        d.h.b.o.c(r0, "toString(...)");
        return r0;
    }

    public static final <T> Iterable<T> j(T[] r2) {
        d.h.b.o.e(r2, "<this>");
        if (r2.length != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L11;
        return (Iterable) ZeusTransformUtils.preCheckCast(p.b(), Iterable.class, "com.obric.aiagent.plugin");
    L11:
        return (Iterable) ZeusTransformUtils.preCheckCast(new a(r2), Iterable.class, "com.obric.aiagent.plugin");
    L5:
        r0 = false;
        goto L7
    }

    public static final <T> d.n.j<T> k(T[] r2) {
        d.h.b.o.e(r2, "<this>");
        if (r2.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return d.n.m.a();
    L10:
        return (d.n.j) ZeusTransformUtils.preCheckCast(new b(r2), d.n.j.class, "com.obric.aiagent.plugin");
    L5:
        r0 = false;
        goto L6
    }

    public static final float f(float[] r4) {
        d.h.b.o.e(r4, "<this>");
        int r0 = r4.length;
        float r1 = 0.0f;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = r1 + r4[r2];
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static final <T, R> List<d.m<T, R>> b(T[] r5, R[] r6) {
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "other");
        int r0 = Math.min(r5.length, r6.length);
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1.add(d.s.a(r5[r2], r6[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    }
}
