package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: compiled from: _Collections.kt */
/* JADX INFO: loaded from: classes4.dex */
class z extends y {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a<T> implements d.n.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f38390a;

        public a(Iterable r3) {
            this.f38390a = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        }

        @Override // d.n.j
        public Iterator<T> a() {
            return this.f38390a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: _Collections.kt */
    static final class b<T> extends d.h.b.p implements d.h.a.a<Iterator<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable<T> f38391a;

        b(Iterable<? extends T> r3) {
            this.f38391a = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final Iterator<T> a() {
            return this.f38391a.iterator();
        }

        @Override // d.h.a.a
        public /* synthetic */ Object invoke() {
            return a();
        }
    }

    public static final <T> boolean a(Iterable<? extends T> r2, T r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == false) goto L7;
        return ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).contains(r3);
    L7:
        if (p.b(r4, r3) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static final <T> T e(Iterable<? extends T> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, List.class) == true) goto L5;
        Iterator<T> r4 = r3.iterator();
        if (r4.hasNext() == false) goto L11;
        return r4.next();
    L11:
        throw new NoSuchElementException("Collection is empty.");
    L5:
        return (T) p.k((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> T k(List<? extends T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.isEmpty() == true) goto L7;
        return (T) r3.get(0);
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T f(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, List.class) == true) goto L5;
        Iterator<T> r5 = r4.iterator();
        if (r5.hasNext() == true) goto L13;
        return null;
    L13:
        return r5.next();
    L5:
        if (((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L8;
        return null;
    L8:
        return (T) ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).get(0);
    }

    public static final <T> T l(List<? extends T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.isEmpty() == false) goto L6;
        return null;
    L6:
        return (T) r3.get(0);
    }

    public static final <T> T d(List<? extends T> r2, int r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L11;
        return null;
    L11:
        return (T) r4.get(r3);
    L5:
        if (r3 >= r4.size()) goto L7;
        r0 = true;
        goto L7
    }

    public static final <T> int b(Iterable<? extends T> r2, T r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, List.class) == true) goto L5;
        int r0 = 0;
        Iterator<T> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L16;
        T r1 = r5.next();
        if (r0 >= 0) goto L13;
        p.c();
    L13:
        if (d.h.b.o.a(r3, r1) == true) goto L14;
        r0 = r0 + 1;
        goto L8
    L14:
        return r0;
    L16:
        return -1;
    L5:
        return ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).indexOf(r3);
    }

    public static final <T> int a(List<? extends T> r2, T r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return r4.indexOf(r3);
    }

    public static final <T> T g(Iterable<? extends T> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, List.class) == true) goto L5;
        Iterator<T> r4 = r3.iterator();
        if (r4.hasNext() == false) goto L14;
        T r0 = r4.next();
    L10:
        if (r4.hasNext() == false) goto L12;
        r0 = r4.next();
        goto L10
    L12:
        return r0;
    L14:
        throw new NoSuchElementException("Collection is empty.");
    L5:
        return (T) p.m((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> T m(List<? extends T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.isEmpty() == true) goto L7;
        return (T) r3.get(p.b(r3));
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T h(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, List.class) == true) goto L5;
        Iterator<T> r5 = r4.iterator();
        if (r5.hasNext() == true) goto L12;
        return null;
    L12:
        T r0 = r5.next();
    L14:
        if (r5.hasNext() == false) goto L16;
        r0 = r5.next();
        goto L14
    L16:
        return r0;
    L5:
        if (((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L8;
        return null;
    L8:
        return (T) ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).get(((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).size() - 1);
    }

    public static final <T> T n(List<? extends T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.isEmpty() == false) goto L6;
        return null;
    L6:
        return (T) r3.get(r3.size() - 1);
    }

    public static final <T> T i(Iterable<? extends T> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, List.class) == true) goto L5;
        Iterator<T> r4 = r3.iterator();
        if (r4.hasNext() == false) goto L14;
        T r0 = r4.next();
        if (r4.hasNext() == true) goto L12;
        return r0;
    L12:
        throw new IllegalArgumentException("Collection has more than one element.");
    L14:
        throw new NoSuchElementException("Collection is empty.");
    L5:
        return (T) p.o((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> T o(List<? extends T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        int r0 = r3.size();
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L9;
        return (T) r3.get(0);
    L9:
        throw new IllegalArgumentException("List has more than one element.");
    L11:
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T j(Iterable<? extends T> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, List.class) == true) goto L5;
        Iterator<T> r6 = r5.iterator();
        if (r6.hasNext() == true) goto L11;
        return null;
    L11:
        T r0 = r6.next();
        if (r6.hasNext() == false) goto L14;
        return null;
    L14:
        return r0;
    L5:
        if (((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin")).size() == 1) goto L7;
        return null;
    L7:
        return (T) ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin")).get(0);
    }

    public static final <T> T p(List<? extends T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.size() == 1) goto L7;
        return null;
    L7:
        return (T) r3.get(0);
    }

    public static final <T> List<T> b(Iterable<? extends T> r4, int r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        int r0 = 0;
        if (r5 < 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L43;
        if (r5 != 0) goto L11;
        return p.o(r6);
    L11:
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == false) goto L32;
        int r7 = ((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).size() - r5;
        if (r7 <= 0) goto L15;
        if (r7 == 1) goto L18;
        ArrayList r2 = new ArrayList(r7);
        if (ZeusTransformUtils.instanceOf(r6, List.class) == true) goto L22;
    L33:
        Iterator<T> r8 = r6.iterator();
    L35:
        if (r8.hasNext() == false) goto L41;
        T r9 = r8.next();
        if (r0 >= r5) goto L38;
        r0 = r0 + 1;
        goto L35
    L38:
        r2.add(r9);
        goto L35
    L41:
        return p.c((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"));
    L22:
        if (ZeusTransformUtils.instanceOf(r6, RandomAccess.class) == false) goto L26;
        int r1 = ((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).size();
    L24:
        if (r5 >= r1) goto L31;
        r2.add(((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin")).get(r5));
        r5 = r5 + 1;
    L31:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    L26:
        Iterator r10 = (Iterator) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin")).listIterator(r5), Iterator.class, "com.obric.aiagent.plugin");
    L28:
        if (r10.hasNext() == false) goto L31;
        r2.add(r10.next());
        goto L28
    L18:
        return p.a(p.g(r6));
    L15:
        return p.b();
    L32:
        r2 = new ArrayList();
        goto L33
    L43:
        throw new IllegalArgumentException(("Requested element count " + r5 + " is less than zero.").toString());
    L5:
        r3 = false;
        goto L6
    }

    public static final <T> List<T> e(List<? extends T> r3, int r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (r4 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        return p.c((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin"), d.l.n.c(r5.size() - r4, 0));
    L10:
        throw new IllegalArgumentException(("Requested element count " + r4 + " is less than zero.").toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final <T> List<T> k(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return (List) ZeusTransformUtils.preCheckCast(p.a(r4, (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin");
    }

    public static final <C extends Collection<? super T>, T> C a(Iterable<? extends T> r2, C r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        C r5 = (C) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "destination");
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        T r0 = r6.next();
        if (r0 == null) goto L4;
        r5.add(r0);
        goto L4
    L8:
        return r5;
    }

    public static final <T> List<T> c(Iterable<? extends T> r5, int r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "<this>");
        int r0 = 0;
        if (r6 < 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L27;
        if (r6 != 0) goto L11;
        return p.b();
    L11:
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L13;
    L19:
        ArrayList r4 = new ArrayList(r6);
        Iterator<T> r8 = r7.iterator();
    L21:
        if (r8.hasNext() == false) goto L25;
        r4.add(r8.next());
        r0 = r0 + 1;
        if (r0 != r6) goto L21;
    L25:
        return p.c((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"));
    L13:
        if (r6 >= ((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).size()) goto L15;
        if (r6 != 1) goto L19;
        return p.a(p.e(r7));
    L15:
        return p.o(r7);
    L27:
        throw new IllegalArgumentException(("Requested element count " + r6 + " is less than zero.").toString());
    L5:
        r3 = false;
        goto L6
    }

    public static final <T> List<T> f(List<? extends T> r4, int r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L29;
        if (r5 == 0) goto L9;
        int r3 = r6.size();
        if (r5 >= r3) goto L13;
        if (r5 == 1) goto L16;
        ArrayList r0 = new ArrayList(r5);
        if (ZeusTransformUtils.instanceOf(r6, RandomAccess.class) == false) goto L22;
        int r7 = r3 - r5;
    L20:
        if (r7 >= r3) goto L27;
        r0.add(r6.get(r7));
        r7 = r7 + 1;
    L27:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L22:
        Iterator r8 = (Iterator) ZeusTransformUtils.preCheckCast(r6.listIterator(r3 - r5), Iterator.class, "com.obric.aiagent.plugin");
    L24:
        if (r8.hasNext() == false) goto L27;
        r0.add(r8.next());
        goto L24
    L16:
        return p.a(p.m(r6));
    L13:
        return p.o((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin"));
    L9:
        return p.b();
    L29:
        throw new IllegalArgumentException(("Requested element count " + r5 + " is less than zero.").toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final <T> List<T> l(Iterable<? extends T> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L5;
    L8:
        List<T> r4 = p.p(r3);
        p.j(r4);
        return r4;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).size() > 1) goto L8;
        return p.o(r3);
    }

    public static final <T extends Comparable<? super T>> List<T> m(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
        List<T> r5 = p.p(r4);
        p.d(r5);
        return r5;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).size() <= 1) goto L7;
        Object[] r6 = ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).toArray(new Comparable[0]);
        i.b((Comparable[]) ZeusTransformUtils.preCheckCast(r6, Comparable[].class, "com.obric.aiagent.plugin"));
        return i.a(r6);
    L7:
        return p.o(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> a(Iterable<? extends T> r3, Comparator<? super T> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "comparator");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
        List<T> r7 = p.p(r5);
        p.a(r7, r6);
        return r7;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).size() <= 1) goto L7;
        Object[] r8 = ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).toArray(new Object[0]);
        i.a(r8, r6);
        return i.a(r8);
    L7:
        return p.o(r5);
    }

    public static final boolean[] b(Collection<Boolean> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        boolean[] r0 = new boolean[r6.size()];
        Iterator r7 = r6.iterator();
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L6;
        r0[r2] = ((Boolean) ZeusTransformUtils.preCheckCast(r7.next(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static final double[] c(Collection<Double> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "<this>");
        double[] r0 = new double[r7.size()];
        Iterator r8 = r7.iterator();
        int r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L6;
        r0[r2] = ((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.aiagent.plugin")).doubleValue();
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static final float[] d(Collection<Float> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        float[] r0 = new float[r6.size()];
        Iterator r7 = r6.iterator();
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L6;
        r0[r2] = ((Number) ZeusTransformUtils.preCheckCast(r7.next(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static final int[] e(Collection<Integer> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        int[] r0 = new int[r6.size()];
        Iterator r7 = r6.iterator();
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L6;
        r0[r2] = ((Number) ZeusTransformUtils.preCheckCast(r7.next(), Number.class, "com.obric.aiagent.plugin")).intValue();
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static final long[] f(Collection<Long> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "<this>");
        long[] r0 = new long[r7.size()];
        Iterator r8 = r7.iterator();
        int r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L6;
        r0[r2] = ((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.aiagent.plugin")).longValue();
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static final <T, C extends Collection<? super T>> C b(Iterable<? extends T> r2, C r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        C r5 = (C) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "destination");
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.add(r6.next());
        goto L4
    L6:
        return r5;
    }

    public static final <T> HashSet<T> n(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return (HashSet) ZeusTransformUtils.preCheckCast(p.b(r4, (Collection) ZeusTransformUtils.preCheckCast(new HashSet(ao.a(p.a(r4, 12))), Collection.class, "com.obric.aiagent.plugin")), HashSet.class, "com.obric.aiagent.plugin");
    }

    public static final <T> List<T> o(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == false) goto L17;
        int r0 = ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).size();
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L10;
        return p.g((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin"));
    L10:
        if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L12;
        Object r5 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).get(0);
    L19:
        return p.a(r5);
    L12:
        r5 = r4.iterator().next();
        goto L19
    L15:
        return p.b();
    L17:
        return p.c(p.p(r4));
    }

    public static final <T> List<T> p(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == false) goto L7;
        return p.g((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin"));
    L7:
        return (List) ZeusTransformUtils.preCheckCast(p.b(r4, (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin");
    }

    public static final <T> List<T> g(Collection<? extends T> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(r3), List.class, "com.obric.aiagent.plugin");
    }

    public static final <T> Set<T> q(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == false) goto L17;
        int r0 = ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).size();
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L10;
        return (Set) ZeusTransformUtils.preCheckCast(p.b(r4, (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(ao.a(((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).size())), Collection.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin");
    L10:
        if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L12;
        Object r5 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).get(0);
    L19:
        return ax.a(r5);
    L12:
        r5 = r4.iterator().next();
        goto L19
    L15:
        return ax.b();
    L17:
        return ax.b((Set) ZeusTransformUtils.preCheckCast(p.b(r4, (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> Iterable<ai<T>> r(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return (Iterable) ZeusTransformUtils.preCheckCast(new aj((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r4), d.h.a.a.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
    }

    public static final <T> List<T> s(Iterable<? extends T> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return p.o((Iterable) ZeusTransformUtils.preCheckCast(p.t(r3), Iterable.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> Set<T> a(Iterable<? extends T> r2, Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "other");
        Set<T> r6 = p.t(r4);
        p.b((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin"), r5);
        return r6;
    }

    public static final <T> Set<T> t(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == false) goto L6;
        return (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin");
    L6:
        return (Set) ZeusTransformUtils.preCheckCast(p.b(r4, (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin");
    }

    public static final Float u(Iterable<Float> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        Iterator r6 = r5.iterator();
        if (r6.hasNext() == true) goto L6;
        return null;
    L6:
        float r0 = ((Number) ZeusTransformUtils.preCheckCast(r6.next(), Number.class, "com.obric.aiagent.plugin")).floatValue();
    L8:
        if (r6.hasNext() == false) goto L11;
        r0 = Math.max(r0, ((Number) ZeusTransformUtils.preCheckCast(r6.next(), Number.class, "com.obric.aiagent.plugin")).floatValue());
        goto L8
    L11:
        return Float.valueOf(r0);
    }

    public static final <T extends Comparable<? super T>> T v(Iterable<? extends T> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        Iterator r6 = r5.iterator();
        if (r6.hasNext() == true) goto L6;
        return null;
    L6:
        T r0 = (T) ZeusTransformUtils.preCheckCast(r6.next(), Comparable.class, "com.obric.aiagent.plugin");
    L8:
        if (r6.hasNext() == false) goto L12;
        Comparable r2 = (Comparable) ZeusTransformUtils.preCheckCast(r6.next(), Comparable.class, "com.obric.aiagent.plugin");
        if (r0.compareTo(r2) >= 0) goto L8;
        r0 = (T) r2;
        goto L8
    L12:
        return r0;
    }

    public static final <T extends Comparable<? super T>> T w(Iterable<? extends T> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        Iterator r6 = r5.iterator();
        if (r6.hasNext() == true) goto L6;
        return null;
    L6:
        T r0 = (T) ZeusTransformUtils.preCheckCast(r6.next(), Comparable.class, "com.obric.aiagent.plugin");
    L8:
        if (r6.hasNext() == false) goto L12;
        Comparable r2 = (Comparable) ZeusTransformUtils.preCheckCast(r6.next(), Comparable.class, "com.obric.aiagent.plugin");
        if (r0.compareTo(r2) <= 0) goto L8;
        r0 = (T) r2;
        goto L8
    L12:
        return r0;
    }

    public static final <T> List<List<T>> d(Iterable<? extends T> r2, int r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return p.a(r4, r3, r3, true);
    }

    public static final <T> List<T> a(Collection<? extends T> r3, T r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        ArrayList r0 = new ArrayList(r5.size() + 1);
        r0.addAll(r5);
        r0.add(r4);
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }

    public static final <T> List<T> b(Iterable<? extends T> r3, Iterable<? extends T> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "elements");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
        ArrayList r0 = new ArrayList();
        p.a((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"), r5);
        p.a((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"), r6);
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L5:
        return p.c((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"), r6);
    }

    public static final <T> List<T> c(Collection<? extends T> r4, Iterable<? extends T> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r7, "elements");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == false) goto L6;
        ArrayList r0 = new ArrayList(r6.size() + ((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).size());
        r0.addAll(r6);
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin"));
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L6:
        ArrayList r1 = new ArrayList(r6);
        p.a((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin"), r7);
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ List a(Iterable r1, int r2, int r3, boolean r4, int r5, Object r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r1, Iterable.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return p.a(r7, r2, r3, r4);
    }

    public static final <T> List<List<T>> a(Iterable<? extends T> r11, int r12, int r13, boolean r14) {
        Iterable r15 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r11, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r15, "<this>");
        bb.a(r12, r13);
        if (ZeusTransformUtils.instanceOf(r15, RandomAccess.class) == true) goto L5;
    L25:
        ArrayList r0 = new ArrayList();
        Iterator r16 = bb.a(r15.iterator(), r12, r13, r14, false);
    L27:
        if (r16.hasNext() == false) goto L30;
        r0.add((List) ZeusTransformUtils.preCheckCast(r16.next(), List.class, "com.obric.aiagent.plugin"));
        goto L27
    L30:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L5:
        if (ZeusTransformUtils.instanceOf(r15, List.class) == false) goto L25;
        int r1 = ((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin")).size();
        int r3 = r1 / r13;
        if ((r1 % r13) != 0) goto L9;
        int r4 = 0;
    L10:
        ArrayList r5 = new ArrayList(r3 + r4);
        int r6 = 0;
    L11:
        if (r6 < 0) goto L14;
        if (r6 >= r1) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L24;
        int r8 = d.l.n.d(r12, r1 - r6);
        if (r8 >= r12) goto L19;
        if (r14 == false) goto L24;
    L19:
        ArrayList r9 = new ArrayList(r8);
        int r10 = 0;
    L20:
        if (r10 >= r8) goto L22;
        r9.add(((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin")).get(r10 + r6));
        r10 = r10 + 1;
        goto L20
    L22:
        r5.add((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"));
        r6 = r6 + r13;
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
    L14:
        r7 = false;
        goto L15
    L9:
        r4 = 1;
        goto L10
    }

    public static /* synthetic */ Appendable a(Iterable r4, Appendable r5, CharSequence r6, CharSequence r7, CharSequence r8, int r9, CharSequence r10, d.h.a.b r11, int r12, Object r13) {
        Iterable r14 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        Appendable r15 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r5, Appendable.class, "com.obric.aiagent.plugin");
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r18 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r19 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r110 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r12 & 2) == 0) goto L5;
        r16 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin");
    L5:
        CharSequence r111 = r16;
        if ((r12 & 4) == 0) goto L8;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L10:
        if ((r12 & 8) == 0) goto L12;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L14:
        if ((r12 & 16) == 0) goto L16;
        r9 = -1;
    L16:
        int r3 = r9;
        if ((r12 & 32) == 0) goto L19;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.aiagent.plugin");
    L21:
        if ((r12 & 64) == 0) goto L23;
        d.h.a.b r112 = null;
    L25:
        return p.a(r14, r15, r111, r2, r1, r3, r0, r112);
    L23:
        r112 = r110;
        goto L25
    L19:
        r0 = r19;
        goto L21
    L12:
        r1 = r18;
        goto L14
    L8:
        r2 = r17;
        goto L10
    }

    public static final <T, A extends Appendable> A a(Iterable<? extends T> r2, A r3, CharSequence r4, CharSequence r5, CharSequence r6, int r7, CharSequence r8, d.h.a.b<? super T, ? extends CharSequence> r9) {
        Iterable r10 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        A r11 = (A) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.aiagent.plugin");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r16 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "<this>");
        d.h.b.o.e(r11, "buffer");
        d.h.b.o.e(r12, "separator");
        d.h.b.o.e(r13, "prefix");
        d.h.b.o.e(r14, "postfix");
        d.h.b.o.e(r15, "truncated");
        r11.append(r13);
        Iterator<T> r17 = r10.iterator();
        int r18 = 0;
    L4:
        if (r17.hasNext() == false) goto L11;
        T r0 = r17.next();
        r18 = r18 + 1;
        if (r18 <= 1) goto L8;
        r11.append(r12);
    L8:
        if (r7 < 0) goto L10;
        if (r18 > r7) goto L11;
    L10:
        d.o.o.a(r11, r0, r16);
    L11:
        if (r7 < 0) goto L14;
        if (r18 <= r7) goto L14;
        r11.append(r15);
    L14:
        r11.append(r14);
        return r11;
    }

    public static /* synthetic */ String a(Iterable r4, CharSequence r5, CharSequence r6, CharSequence r7, int r8, CharSequence r9, d.h.a.b r10, int r11, Object r12) {
        Iterable r13 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r18 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r11 & 1) == 0) goto L5;
        r14 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin");
    L5:
        CharSequence r19 = r14;
        if ((r11 & 2) == 0) goto L8;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L10:
        if ((r11 & 4) == 0) goto L12;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L14:
        if ((r11 & 8) == 0) goto L16;
        r8 = -1;
    L16:
        int r3 = r8;
        if ((r11 & 16) == 0) goto L19;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.aiagent.plugin");
    L21:
        if ((r11 & 32) == 0) goto L23;
        d.h.a.b r110 = null;
    L25:
        return p.a(r13, r19, r2, r1, r3, r0, r110);
    L23:
        r110 = r18;
        goto L25
    L19:
        r0 = r17;
        goto L21
    L12:
        r1 = r16;
        goto L14
    L8:
        r2 = r15;
        goto L10
    }

    public static final <T> String a(Iterable<? extends T> r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, d.h.a.b<? super T, ? extends CharSequence> r16) {
        Iterable r2 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r10, Iterable.class, "com.obric.aiagent.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r15, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r4, "separator");
        d.h.b.o.e(r5, "prefix");
        d.h.b.o.e(r6, "postfix");
        d.h.b.o.e(r8, "truncated");
        String r0 = ((StringBuilder) ZeusTransformUtils.preCheckCast(p.a(r2, (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin"), r4, r5, r6, r14, r8, r9), StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        d.h.b.o.c(r0, "toString(...)");
        return r0;
    }

    public static final <T> d.n.j<T> y(Iterable<? extends T> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return (d.n.j) ZeusTransformUtils.preCheckCast(new a(r3), d.n.j.class, "com.obric.aiagent.plugin");
    }

    public static final double z(Iterable<Integer> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "<this>");
        Iterator r8 = r7.iterator();
        double r2 = 0.0d;
        int r0 = 0;
    L4:
        if (r8.hasNext() == false) goto L8;
        r2 = r2 + ((double) ((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        if (r0 >= 0) goto L4;
        p.d();
        goto L4
    L8:
        if (r0 != 0) goto L11;
        return Double.NaN;
    L11:
        return r2 / ((double) r0);
    }

    public static final double A(Iterable<Float> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "<this>");
        Iterator r8 = r7.iterator();
        double r2 = 0.0d;
        int r0 = 0;
    L4:
        if (r8.hasNext() == false) goto L8;
        r2 = r2 + ((double) ((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.aiagent.plugin")).floatValue());
        r0 = r0 + 1;
        if (r0 >= 0) goto L4;
        p.d();
        goto L4
    L8:
        if (r0 != 0) goto L11;
        return Double.NaN;
    L11:
        return r2 / ((double) r0);
    }

    public static final int B(Iterable<Integer> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        Iterator r6 = r5.iterator();
        int r0 = 0;
    L4:
        if (r6.hasNext() == false) goto L6;
        r0 = r0 + ((Number) ZeusTransformUtils.preCheckCast(r6.next(), Number.class, "com.obric.aiagent.plugin")).intValue();
        goto L4
    L6:
        return r0;
    }

    public static final long C(Iterable<Long> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "<this>");
        Iterator r8 = r7.iterator();
        long r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L6;
        r2 = r2 + ((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.aiagent.plugin")).longValue();
        goto L4
    L6:
        return r2;
    }

    public static final float D(Iterable<Float> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        Iterator r6 = r5.iterator();
        float r0 = 0.0f;
    L4:
        if (r6.hasNext() == false) goto L6;
        r0 = r0 + ((Number) ZeusTransformUtils.preCheckCast(r6.next(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        goto L4
    L6:
        return r0;
    }

    public static final <T, R> List<d.m<T, R>> c(Iterable<? extends T> r5, Iterable<? extends R> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.aiagent.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r8, "other");
        Iterator<T> r0 = r7.iterator();
        Iterator<T> r2 = r8.iterator();
        ArrayList r3 = new ArrayList(Math.min(p.a(r7, 10), p.a(r8, 10)));
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r2.hasNext() == false) goto L9;
        r3.add(d.s.a(r0.next(), r2.next()));
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    }

    public static final <T> List<d.m<T, T>> x(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        Iterator<T> r5 = r4.iterator();
        if (r5.hasNext() == false) goto L12;
        List<d.m<T, T>> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        T r1 = r5.next();
    L7:
        if (r5.hasNext() == false) goto L10;
        T r2 = r5.next();
        r0.add(d.s.a(r1, r2));
        r1 = r2;
        goto L7
    L10:
        return r0;
    L12:
        return p.b();
    }
}
