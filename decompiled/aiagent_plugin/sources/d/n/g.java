package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g<T> implements j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j<T> f38574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f38575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<T, Boolean> f38576c;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements d.h.b.a.a, Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g<T> f38577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterator<T> f38578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f38579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private T f38580d;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(g<T> r1) {
            this.f38577a = r1;
            this.f38578b = g.a(r1).a();
            this.f38579c = -1;
        }

        private final void a() {
        L3:
            if (this.f38578b.hasNext() == false) goto L8;
            T r0 = this.f38578b.next();
            if (((Boolean) ZeusTransformUtils.preCheckCast(g.b(this.f38577a).invoke(r0), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != g.c(this.f38577a)) goto L3;
            this.f38580d = r0;
            this.f38579c = 1;
            return;
        L8:
            this.f38579c = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f38579c != (-1)) goto L6;
            a();
        L6:
            if (this.f38579c == 0) goto L10;
            T r0 = this.f38580d;
            this.f38580d = null;
            this.f38579c = -1;
            return r0;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38579c != (-1)) goto L6;
            a();
        L6:
            if (this.f38579c == 1) goto L10;
            return false;
        L10:
            return true;
        }
    }

    public g(j<? extends T> r3, boolean r4, d.h.a.b<? super T, Boolean> r5) {
        j<T> r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.a.b<T, Boolean> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "sequence");
        d.h.b.o.e(r7, "predicate");
        this.f38574a = r6;
        this.f38575b = r4;
        this.f38576c = r7;
    }

    public static final /* synthetic */ j a(g r0) {
        return r0.f38574a;
    }

    public static final /* synthetic */ d.h.a.b b(g r0) {
        return r0.f38576c;
    }

    public static final /* synthetic */ boolean c(g r0) {
        return r0.f38575b;
    }

    @Override // d.n.j
    public Iterator<T> a() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new a(this), Iterator.class, "com.obric.aiagent.plugin");
    }
}
