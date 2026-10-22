package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes4.dex */
final class i<T> implements j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.a<T> f38588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<T, T> f38589b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements d.h.b.a.a, Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i<T> f38590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private T f38591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f38592c;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(i<T> r1) {
            this.f38590a = r1;
            this.f38592c = -2;
        }

        private final void a() {
            if (this.f38592c != (-2)) goto L5;
            T r0 = (T) i.a(this.f38590a).invoke();
        L6:
            this.f38591b = r0;
            if (r0 != null) goto L9;
            int r1 = 0;
        L10:
            this.f38592c = r1;
            return;
        L9:
            r1 = 1;
            goto L10
        L5:
            d.h.a.b r2 = i.b(this.f38590a);
            T r3 = this.f38591b;
            d.h.b.o.a(r3);
            r0 = (T) r2.invoke(r3);
            goto L6
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f38592c >= 0) goto L6;
            a();
        L6:
            if (this.f38592c == 0) goto L10;
            T r0 = this.f38591b;
            d.h.b.o.a(r0, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f38592c = -1;
            return r0;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38592c >= 0) goto L6;
            a();
        L6:
            if (this.f38592c == 1) goto L10;
            return false;
        L10:
            return true;
        }
    }

    public i(d.h.a.a<? extends T> r3, d.h.a.b<? super T, ? extends T> r4) {
        d.h.a.a<T> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<T, T> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "getInitialValue");
        d.h.b.o.e(r6, "getNextValue");
        this.f38588a = r5;
        this.f38589b = r6;
    }

    public static final /* synthetic */ d.h.a.a a(i r0) {
        return r0.f38588a;
    }

    public static final /* synthetic */ d.h.a.b b(i r0) {
        return r0.f38589b;
    }

    @Override // d.n.j
    public Iterator<T> a() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new a(this), Iterator.class, "com.obric.aiagent.plugin");
    }
}
