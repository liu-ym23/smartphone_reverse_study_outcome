package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h<T, R, E> implements j<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j<T> f38581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<T, R> f38582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<R, Iterator<E>> f38583c;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements d.h.b.a.a, Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h<T, R, E> f38584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterator<T> f38585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Iterator<? extends E> f38586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f38587d;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(h<T, R, E> r1) {
            this.f38584a = r1;
            this.f38585b = h.a(r1).a();
        }

        @Override // java.util.Iterator
        public E next() {
            int r0 = this.f38587d;
            if (r0 == 2) goto L13;
            if (r0 == 0) goto L6;
        L10:
            this.f38587d = 0;
            Iterator<? extends E> r2 = this.f38586c;
            d.h.b.o.a(r2);
            return r2.next();
        L6:
            if (a() == true) goto L10;
            throw new NoSuchElementException();
        L13:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int r0 = this.f38587d;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 2) goto L10;
            return false;
        L10:
            return a();
        }

        private final boolean a() {
            Iterator<? extends E> r0 = this.f38586c;
            if (r0 == null) goto L9;
            if (r0.hasNext() == false) goto L9;
            this.f38587d = 1;
            return true;
        L9:
            if (this.f38585b.hasNext() == false) goto L14;
            T r1 = this.f38585b.next();
            Iterator<? extends E> r2 = (Iterator) ZeusTransformUtils.preCheckCast(h.b(this.f38584a).invoke(h.c(this.f38584a).invoke(r1)), Iterator.class, "com.obric.aiagent.plugin");
            if (r2.hasNext() == false) goto L9;
            this.f38586c = r2;
            this.f38587d = 1;
            return true;
        L14:
            this.f38587d = 2;
            this.f38586c = null;
            return false;
        }
    }

    public h(j<? extends T> r3, d.h.a.b<? super T, ? extends R> r4, d.h.a.b<? super R, ? extends Iterator<? extends E>> r5) {
        j<T> r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.a.b<T, R> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<R, Iterator<E>> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "sequence");
        d.h.b.o.e(r7, "transformer");
        d.h.b.o.e(r8, "iterator");
        this.f38581a = r6;
        this.f38582b = r7;
        this.f38583c = r8;
    }

    public static final /* synthetic */ j a(h r0) {
        return r0.f38581a;
    }

    public static final /* synthetic */ d.h.a.b b(h r0) {
        return r0.f38583c;
    }

    public static final /* synthetic */ d.h.a.b c(h r0) {
        return r0.f38582b;
    }

    @Override // d.n.j
    public Iterator<E> a() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new a(this), Iterator.class, "com.obric.aiagent.plugin");
    }
}
