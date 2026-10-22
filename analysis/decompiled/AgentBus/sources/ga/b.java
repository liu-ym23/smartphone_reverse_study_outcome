package ga;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public int f4008f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f4009g;

    /* renamed from: h, reason: collision with root package name */
    public int f4010h;

    /* renamed from: i, reason: collision with root package name */
    public v7.d f4011i;

    /* renamed from: j, reason: collision with root package name */
    public int f4012j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ c f4013k;

    public b(c cVar) {
        this.f4013k = cVar;
        int iK = nb.i.k(0, 0, cVar.f4014a.length());
        this.f4009g = iK;
        this.f4010h = iK;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r7 = this;
            int r0 = r7.f4010h
            r1 = 0
            if (r0 >= 0) goto Lb
            r7.f4008f = r1
            r0 = 0
            r7.f4011i = r0
            return
        Lb:
            ga.c r2 = r7.f4013k
            int r3 = r2.f4015b
            r4 = -1
            r5 = 1
            if (r3 <= 0) goto L1a
            int r6 = r7.f4012j
            int r6 = r6 + r5
            r7.f4012j = r6
            if (r6 >= r3) goto L22
        L1a:
            java.lang.CharSequence r3 = r2.f4014a
            int r3 = r3.length()
            if (r0 <= r3) goto L34
        L22:
            v7.d r0 = new v7.d
            int r1 = r7.f4009g
            java.lang.CharSequence r2 = r2.f4014a
            int r2 = ga.k.o0(r2)
            r0.<init>(r1, r2, r5)
            r7.f4011i = r0
            r7.f4010h = r4
            goto L79
        L34:
            p7.n r0 = r2.f4016c
            java.lang.CharSequence r3 = r2.f4014a
            int r6 = r7.f4010h
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r0 = r0.invoke(r3, r6)
            c7.j r0 = (c7.j) r0
            if (r0 != 0) goto L58
            v7.d r0 = new v7.d
            int r1 = r7.f4009g
            java.lang.CharSequence r2 = r2.f4014a
            int r2 = ga.k.o0(r2)
            r0.<init>(r1, r2, r5)
            r7.f4011i = r0
            r7.f4010h = r4
            goto L79
        L58:
            java.lang.Object r2 = r0.f1973f
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.f1974g
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r3 = r7.f4009g
            v7.d r3 = nb.i.N(r3, r2)
            r7.f4011i = r3
            int r2 = r2 + r0
            r7.f4009g = r2
            if (r0 != 0) goto L76
            r1 = r5
        L76:
            int r2 = r2 + r1
            r7.f4010h = r2
        L79:
            r7.f4008f = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ga.b.a():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f4008f == -1) {
            a();
        }
        return this.f4008f == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f4008f == -1) {
            a();
        }
        if (this.f4008f == 0) {
            throw new NoSuchElementException();
        }
        v7.d dVar = this.f4011i;
        q7.k.c(dVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.f4011i = null;
        this.f4008f = -1;
        return dVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
