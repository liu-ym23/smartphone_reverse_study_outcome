package x5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import k4.v;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements Iterator, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public int f6279a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f6280b;

    /* renamed from: c, reason: collision with root package name */
    public int f6281c;
    public u5.f d;

    /* renamed from: e, reason: collision with root package name */
    public int f6282e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f6283f;

    public b(c cVar) {
        this.f6283f = cVar;
        int iN = v.n(0, 0, cVar.f6284a.length());
        this.f6280b = iN;
        this.f6281c = iN;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r7 = this;
            int r0 = r7.f6281c
            r1 = 0
            if (r0 >= 0) goto Lb
            r7.f6279a = r1
            r0 = 0
            r7.d = r0
            return
        Lb:
            x5.c r2 = r7.f6283f
            int r3 = r2.f6285b
            r4 = -1
            r5 = 1
            if (r3 <= 0) goto L1a
            int r6 = r7.f6282e
            int r6 = r6 + r5
            r7.f6282e = r6
            if (r6 >= r3) goto L22
        L1a:
            java.lang.CharSequence r3 = r2.f6284a
            int r3 = r3.length()
            if (r0 <= r3) goto L34
        L22:
            u5.f r0 = new u5.f
            int r1 = r7.f6280b
            java.lang.CharSequence r2 = r2.f6284a
            int r2 = x5.n.n1(r2)
            r0.<init>(r1, r2, r5)
            r7.d = r0
            r7.f6281c = r4
            goto L79
        L34:
            p5.p r0 = r2.f6286c
            java.lang.CharSequence r3 = r2.f6284a
            int r6 = r7.f6281c
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r0 = r0.invoke(r3, r6)
            b5.g r0 = (b5.g) r0
            if (r0 != 0) goto L58
            u5.f r0 = new u5.f
            int r1 = r7.f6280b
            java.lang.CharSequence r2 = r2.f6284a
            int r2 = x5.n.n1(r2)
            r0.<init>(r1, r2, r5)
            r7.d = r0
            r7.f6281c = r4
            goto L79
        L58:
            java.lang.Object r2 = r0.f892a
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.f893b
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r3 = r7.f6280b
            u5.f r3 = k4.v.r0(r3, r2)
            r7.d = r3
            int r2 = r2 + r0
            r7.f6280b = r2
            if (r0 != 0) goto L76
            r1 = r5
        L76:
            int r2 = r2 + r1
            r7.f6281c = r2
        L79:
            r7.f6279a = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.b.a():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f6279a == -1) {
            a();
        }
        return this.f6279a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f6279a == -1) {
            a();
        }
        if (this.f6279a == 0) {
            throw new NoSuchElementException();
        }
        u5.f fVar = this.d;
        kotlin.jvm.internal.p.c(fVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.d = null;
        this.f6279a = -1;
        return fVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
