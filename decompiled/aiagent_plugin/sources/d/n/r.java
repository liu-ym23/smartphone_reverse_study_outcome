package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: _Sequences.kt */
/* JADX INFO: loaded from: classes4.dex */
class r extends q {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Iterables.kt */
    public static final class a<T> implements d.h.b.a.a, Iterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f38600a;

        public a(j r3) {
            this.f38600a = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f38600a.a();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: _Sequences.kt */
    static final class b<T> extends d.h.b.p implements d.h.a.b<T, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f38601a = null;

        static {
            f38601a = new b();
        }

        b() {
            super(1);
        }

        @Override // d.h.a.b
        public final T invoke(T r1) {
            return r1;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: _Sequences.kt */
    static final class c<T> extends d.h.b.p implements d.h.a.b<T, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f38602a = null;

        static {
            f38602a = new c();
        }

        c() {
            super(1);
        }

        public final Boolean a(T r1) {
            if (r1 != null) goto L4;
            boolean r0 = true;
        L6:
            return Boolean.valueOf(r0);
        L4:
            r0 = false;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(Object r1) {
            return a(r1);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: _Sequences.kt */
    /* synthetic */ class d<R> extends d.h.b.l implements d.h.a.b<j<? extends R>, Iterator<? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f38603a = null;

        static {
            f38603a = new d();
        }

        d() {
            super(1, j.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        public final Iterator<R> a(j<? extends R> r2) {
            j r1 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "p0");
            return r1.a();
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(Object r3) {
            return a((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: _Sequences.kt */
    public static final class e<T> implements j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<T> f38604a;

        e(j<? extends T> r3) {
            this.f38604a = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        }

        @Override // d.n.j
        public Iterator<T> a() {
            List r0 = m.h(this.f38604a);
            d.a.p.d(r0);
            return r0.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: _Sequences.kt */
    public static final class f<T> implements j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<T> f38605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator<? super T> f38606b;

        f(j<? extends T> r3, Comparator<? super T> r4) {
            j<T> r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
            Comparator<? super T> r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.aiagent.plugin");
            this.f38605a = r5;
            this.f38606b = r6;
        }

        @Override // d.n.j
        public Iterator<T> a() {
            List r0 = m.h(this.f38605a);
            d.a.p.a(r0, this.f38606b);
            return r0.iterator();
        }
    }

    public static final <T> T a(j<? extends T> r4, int r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        if (r5 >= 0) goto L5;
        return null;
    L5:
        Iterator<T> r7 = r6.a();
        int r1 = 0;
    L7:
        if (r7.hasNext() == false) goto L12;
        T r2 = r7.next();
        int r3 = r1 + 1;
        if (r5 == r1) goto L10;
        r1 = r3;
        goto L7
    L10:
        return r2;
    L12:
        return null;
    }

    public static final <T> T c(j<? extends T> r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        Iterator<T> r4 = r3.a();
        if (r4.hasNext() == false) goto L7;
        return r4.next();
    L7:
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static final <T> T d(j<? extends T> r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        Iterator<T> r4 = r3.a();
        if (r4.hasNext() == true) goto L7;
        return null;
    L7:
        return r4.next();
    }

    public static final <T> j<T> b(j<? extends T> r2, int r3) {
        j<T> r4 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        if (r3 != 0) goto L10;
        return r4;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, d.n.e.class) == false) goto L13;
        return ((d.n.e) ZeusTransformUtils.preCheckCast(r4, d.n.e.class, "com.obric.aiagent.plugin")).a(r3);
    L13:
        return (j) ZeusTransformUtils.preCheckCast(new d.n.d(r4, r3), j.class, "com.obric.aiagent.plugin");
    L15:
        throw new IllegalArgumentException(("Requested element count " + r3 + " is less than zero.").toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> j<T> a(j<? extends T> r3, d.h.a.b<? super T, Boolean> r4) {
        j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "predicate");
        return (j) ZeusTransformUtils.preCheckCast(new g(r5, true, r6), j.class, "com.obric.aiagent.plugin");
    }

    public static final <T> j<T> b(j<? extends T> r3, d.h.a.b<? super T, Boolean> r4) {
        j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "predicate");
        return (j) ZeusTransformUtils.preCheckCast(new g(r5, false, r6), j.class, "com.obric.aiagent.plugin");
    }

    public static final <T> j<T> e(j<? extends T> r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        j<T> r5 = m.b(r4, (d.h.a.b) ZeusTransformUtils.preCheckCast(c.f38602a, d.h.a.b.class, "com.obric.aiagent.plugin"));
        d.h.b.o.a(r5, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return r5;
    }

    public static final <T> j<T> c(j<? extends T> r2, int r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        if (r3 != 0) goto L10;
        return m.a();
    L10:
        if (ZeusTransformUtils.instanceOf(r4, d.n.e.class) == false) goto L13;
        return ((d.n.e) ZeusTransformUtils.preCheckCast(r4, d.n.e.class, "com.obric.aiagent.plugin")).b(r3);
    L13:
        return (j) ZeusTransformUtils.preCheckCast(new t(r4, r3), j.class, "com.obric.aiagent.plugin");
    L15:
        throw new IllegalArgumentException(("Requested element count " + r3 + " is less than zero.").toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final <T extends Comparable<? super T>> j<T> f(j<? extends T> r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return (j) ZeusTransformUtils.preCheckCast(new e(r3), j.class, "com.obric.aiagent.plugin");
    }

    public static final <T> j<T> a(j<? extends T> r2, Comparator<? super T> r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "comparator");
        return (j) ZeusTransformUtils.preCheckCast(new f(r4, r5), j.class, "com.obric.aiagent.plugin");
    }

    public static final <T, C extends Collection<? super T>> C a(j<? extends T> r2, C r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        C r5 = (C) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "destination");
        Iterator<T> r6 = r4.a();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.add(r6.next());
        goto L4
    L6:
        return r5;
    }

    public static final <T> List<T> g(j<? extends T> r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        Iterator<T> r5 = r4.a();
        if (r5.hasNext() == false) goto L5;
        T r0 = r5.next();
        if (r5.hasNext() == false) goto L9;
        ArrayList r2 = new ArrayList();
        r2.add(r0);
    L12:
        if (r5.hasNext() == false) goto L15;
        r2.add(r5.next());
        goto L12
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    L9:
        return d.a.p.a(r0);
    L5:
        return d.a.p.b();
    }

    public static final <T> List<T> h(j<? extends T> r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return (List) ZeusTransformUtils.preCheckCast(m.a(r4, (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin");
    }

    public static final <T> Set<T> i(j<? extends T> r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        Iterator<T> r5 = r4.a();
        if (r5.hasNext() == false) goto L5;
        T r0 = r5.next();
        if (r5.hasNext() == false) goto L9;
        LinkedHashSet r2 = new LinkedHashSet();
        r2.add(r0);
    L12:
        if (r5.hasNext() == false) goto L15;
        r2.add(r5.next());
        goto L12
    L15:
        return (Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.aiagent.plugin");
    L9:
        return ax.a(r0);
    L5:
        return ax.b();
    }

    public static final <T, R> j<R> c(j<? extends T> r4, d.h.a.b<? super T, ? extends j<? extends R>> r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r7, "transform");
        return (j) ZeusTransformUtils.preCheckCast(new h(r6, r7, (d.h.a.b) ZeusTransformUtils.preCheckCast(d.f38603a, d.h.a.b.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin");
    }

    public static final <T, R> j<R> d(j<? extends T> r2, d.h.a.b<? super T, ? extends R> r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "transform");
        return (j) ZeusTransformUtils.preCheckCast(new u(r4, r5), j.class, "com.obric.aiagent.plugin");
    }

    public static final <T, R> j<R> e(j<? extends T> r2, d.h.a.b<? super T, ? extends R> r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "transform");
        return m.e((j) ZeusTransformUtils.preCheckCast(new u(r4, r5), j.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> j<T> j(j<? extends T> r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return m.f(r4, (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f38601a, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final <T, K> j<T> f(j<? extends T> r2, d.h.a.b<? super T, ? extends K> r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "selector");
        return (j) ZeusTransformUtils.preCheckCast(new d.n.c(r4, r5), j.class, "com.obric.aiagent.plugin");
    }

    public static final <T> int k(j<? extends T> r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        Iterator<T> r4 = r3.a();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L8;
        r4.next();
        r0 = r0 + 1;
        if (r0 >= 0) goto L4;
        d.a.p.d();
        goto L4
    L8:
        return r0;
    }

    public static final <T, A extends Appendable> A a(j<? extends T> r2, A r3, CharSequence r4, CharSequence r5, CharSequence r6, int r7, CharSequence r8, d.h.a.b<? super T, ? extends CharSequence> r9) {
        j r10 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
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
        Iterator<T> r17 = r10.a();
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

    public static /* synthetic */ String a(j r4, CharSequence r5, CharSequence r6, CharSequence r7, int r8, CharSequence r9, d.h.a.b r10, int r11, Object r12) {
        j r13 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.aiagent.plugin");
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
        return m.a(r13, r19, r2, r1, r3, r0, r110);
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

    public static final <T> String a(j<? extends T> r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, d.h.a.b<? super T, ? extends CharSequence> r16) {
        j r2 = (j) ZeusTransformUtils.wrapperContextForParams(r10, j.class, "com.obric.aiagent.plugin");
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
        String r0 = ((StringBuilder) ZeusTransformUtils.preCheckCast(m.a(r2, (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin"), r4, r5, r6, r14, r8, r9), StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        d.h.b.o.c(r0, "toString(...)");
        return r0;
    }

    public static final <T> Iterable<T> l(j<? extends T> r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return (Iterable) ZeusTransformUtils.preCheckCast(new a(r3), Iterable.class, "com.obric.aiagent.plugin");
    }

    public static final long m(j<Long> r6) {
        j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r6, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "<this>");
        Iterator r8 = r7.a();
        long r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L6;
        r2 = r2 + ((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.aiagent.plugin")).longValue();
        goto L4
    L6:
        return r2;
    }
}
