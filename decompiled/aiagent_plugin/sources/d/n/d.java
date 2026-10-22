package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d<T> implements e<T>, j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j<T> f38569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f38570b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements d.h.b.a.a, Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator<T> f38571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f38572b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(d<T> r2) {
            this.f38571a = d.a(r2).a();
            this.f38572b = d.b(r2);
        }

        private final void a() {
        L3:
            if (this.f38572b <= 0) goto L7;
            if (this.f38571a.hasNext() == false) goto L10;
            this.f38571a.next();
            this.f38572b--;
            goto L3
        L10:
            return;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f38571a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f38571a.hasNext();
        }
    }

    public d(j<? extends T> r3, int r4) {
        j<T> r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "sequence");
        this.f38569a = r5;
        this.f38570b = r4;
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

    public static final /* synthetic */ j a(d r0) {
        return r0.f38569a;
    }

    public static final /* synthetic */ int b(d r0) {
        return r0.f38570b;
    }

    @Override // d.n.e
    public j<T> a(int r4) {
        int r0 = this.f38570b + r4;
        if (r0 >= 0) goto L5;
        d r1 = new d((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin"), r4);
    L7:
        return (j) ZeusTransformUtils.preCheckCast(r1, j.class, "com.obric.aiagent.plugin");
    L5:
        r1 = new d(this.f38569a, r0);
        goto L7
    }

    @Override // d.n.e
    public j<T> b(int r4) {
        int r0 = this.f38570b + r4;
        if (r0 >= 0) goto L5;
        Object r3 = ZeusTransformUtils.preCheckCast(new t((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin"), r4), e.class, "com.obric.aiagent.plugin");
    L7:
        return (j) ZeusTransformUtils.preCheckCast((e) r3, j.class, "com.obric.aiagent.plugin");
    L5:
        r3 = ZeusTransformUtils.preCheckCast(new s(this.f38569a, this.f38570b, r0), e.class, "com.obric.aiagent.plugin");
        goto L7
    }

    @Override // d.n.j
    public Iterator<T> a() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new a(this), Iterator.class, "com.obric.aiagent.plugin");
    }
}
