package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class t<T> implements e<T>, j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j<T> f38613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f38614b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements d.h.b.a.a, Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterator<T> f38616b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(t<T> r2) {
            this.f38615a = t.a(r2);
            this.f38616b = t.b(r2).a();
        }

        @Override // java.util.Iterator
        public T next() {
            int r0 = this.f38615a;
            if (r0 == 0) goto L7;
            this.f38615a = r0 - 1;
            return this.f38616b.next();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38615a > 0) goto L5;
        L7:
            return false;
        L5:
            if (this.f38616b.hasNext() == false) goto L7;
            return true;
        }
    }

    public t(j<? extends T> r3, int r4) {
        j<T> r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "sequence");
        this.f38613a = r5;
        this.f38614b = r4;
        if (r4 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("count must be non-negative, but was " + r4 + '.').toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final /* synthetic */ int a(t r0) {
        return r0.f38614b;
    }

    public static final /* synthetic */ j b(t r0) {
        return r0.f38613a;
    }

    @Override // d.n.e
    public j<T> a(int r3) {
        if (r3 < this.f38614b) goto L6;
        return m.a();
    L6:
        return (j) ZeusTransformUtils.preCheckCast(new s(this.f38613a, r3, this.f38614b), j.class, "com.obric.aiagent.plugin");
    }

    @Override // d.n.e
    public j<T> b(int r3) {
        if (r3 < this.f38614b) goto L5;
        Object r2 = ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");
    L7:
        return (j) r2;
    L5:
        r2 = ZeusTransformUtils.preCheckCast(new t(this.f38613a, r3), j.class, "com.obric.aiagent.plugin");
        goto L7
    }

    @Override // d.n.j
    public Iterator<T> a() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new a(this), Iterator.class, "com.obric.aiagent.plugin");
    }
}
