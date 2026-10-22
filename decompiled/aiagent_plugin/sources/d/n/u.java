package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class u<T, R> implements j<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j<T> f38617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<T, R> f38618b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements d.h.b.a.a, Iterator<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u<T, R> f38619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterator<T> f38620b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(u<T, R> r1) {
            this.f38619a = r1;
            this.f38620b = u.a(r1).a();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) u.b(this.f38619a).invoke(this.f38620b.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38620b.hasNext();
        }
    }

    public u(j<? extends T> r3, d.h.a.b<? super T, ? extends R> r4) {
        j<T> r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.a.b<T, R> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "sequence");
        d.h.b.o.e(r6, "transformer");
        this.f38617a = r5;
        this.f38618b = r6;
    }

    public static final /* synthetic */ j a(u r0) {
        return r0.f38617a;
    }

    public static final /* synthetic */ d.h.a.b b(u r0) {
        return r0.f38618b;
    }

    @Override // d.n.j
    public Iterator<R> a() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new a(this), Iterator.class, "com.obric.aiagent.plugin");
    }
}
