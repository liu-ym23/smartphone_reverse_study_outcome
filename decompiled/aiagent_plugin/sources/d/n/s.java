package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class s<T> implements e<T>, j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j<T> f38607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f38608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f38609c;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements d.h.b.a.a, Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ s<T> f38610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterator<T> f38611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f38612c;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(s<T> r1) {
            this.f38610a = r1;
            this.f38611b = s.a(r1).a();
        }

        private final void a() {
        L3:
            if (this.f38612c >= s.b(this.f38610a)) goto L7;
            if (this.f38611b.hasNext() == false) goto L10;
            this.f38611b.next();
            this.f38612c++;
            goto L3
        L10:
            return;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            if (this.f38612c < s.c(this.f38610a)) goto L5;
        L7:
            return false;
        L5:
            if (this.f38611b.hasNext() == false) goto L7;
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (this.f38612c >= s.c(this.f38610a)) goto L7;
            this.f38612c++;
            return this.f38611b.next();
        L7:
            throw new NoSuchElementException();
        }
    }

    public s(j<? extends T> r3, int r4, int r5) {
        j<T> r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "sequence");
        this.f38607a = r6;
        this.f38608b = r4;
        this.f38609c = r5;
        boolean r2 = true;
        if (r4 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L21;
        if (r5 < 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L19;
        if (r5 >= r4) goto L14;
        r2 = false;
    L14:
        if (r2 == false) goto L17;
        return;
    L17:
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + r5 + " < " + r4).toString());
    L19:
        throw new IllegalArgumentException(("endIndex should be non-negative, but is " + r5).toString());
    L9:
        r1 = false;
        goto L10
    L21:
        throw new IllegalArgumentException(("startIndex should be non-negative, but is " + r4).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final /* synthetic */ j a(s r0) {
        return r0.f38607a;
    }

    public static final /* synthetic */ int b(s r0) {
        return r0.f38608b;
    }

    public static final /* synthetic */ int c(s r0) {
        return r0.f38609c;
    }

    private final int b() {
        return this.f38609c - this.f38608b;
    }

    @Override // d.n.e
    public j<T> a(int r4) {
        if (r4 < b()) goto L6;
        return m.a();
    L6:
        return (j) ZeusTransformUtils.preCheckCast(new s(this.f38607a, this.f38608b + r4, this.f38609c), j.class, "com.obric.aiagent.plugin");
    }

    @Override // d.n.e
    public j<T> b(int r4) {
        if (r4 < b()) goto L5;
        Object r3 = ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");
    L7:
        return (j) r3;
    L5:
        j<T> r2 = this.f38607a;
        int r5 = this.f38608b;
        r3 = ZeusTransformUtils.preCheckCast(new s(r2, r5, r4 + r5), j.class, "com.obric.aiagent.plugin");
        goto L7
    }

    @Override // d.n.j
    public Iterator<T> a() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new a(this), Iterator.class, "com.obric.aiagent.plugin");
    }
}
