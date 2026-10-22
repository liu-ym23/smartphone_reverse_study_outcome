package j9;

import g1.AbstractC1451a;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: j9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1608b implements Iterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public int f4779a = -1;
    public int b;
    public int c;
    public Y7.f d;
    public int e;
    public final /* synthetic */ C1609c f;

    public C1608b(C1609c c1609c) {
        this.f = c1609c;
        int iU = AbstractC1451a.u(0, 0, c1609c.f4780a.length());
        this.b = iU;
        this.c = iU;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r7 = this;
            int r0 = r7.c
            r1 = 0
            if (r0 >= 0) goto Lb
            r7.f4779a = r1
            r0 = 0
            r7.d = r0
            return
        Lb:
            j9.c r2 = r7.f
            int r3 = r2.b
            r4 = -1
            r5 = 1
            if (r3 <= 0) goto L1a
            int r6 = r7.e
            int r6 = r6 + r5
            r7.e = r6
            if (r6 >= r3) goto L22
        L1a:
            java.lang.CharSequence r3 = r2.f4780a
            int r3 = r3.length()
            if (r0 <= r3) goto L34
        L22:
            Y7.f r0 = new Y7.f
            int r1 = r7.b
            java.lang.CharSequence r2 = r2.f4780a
            int r2 = j9.m.m0(r2)
            r0.<init>(r1, r2, r5)
            r7.d = r0
            r7.c = r4
            goto L79
        L34:
            S7.n r0 = r2.c
            java.lang.CharSequence r3 = r2.f4780a
            int r6 = r7.c
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r0 = r0.invoke(r3, r6)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L58
            Y7.f r0 = new Y7.f
            int r1 = r7.b
            java.lang.CharSequence r2 = r2.f4780a
            int r2 = j9.m.m0(r2)
            r0.<init>(r1, r2, r5)
            r7.d = r0
            r7.c = r4
            goto L79
        L58:
            java.lang.Object r2 = r0.f4886a
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.b
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r3 = r7.b
            Y7.f r3 = g1.AbstractC1451a.X(r3, r2)
            r7.d = r3
            int r2 = r2 + r0
            r7.b = r2
            if (r0 != 0) goto L76
            r1 = r5
        L76:
            int r2 = r2 + r1
            r7.c = r2
        L79:
            r7.f4779a = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.C1608b.a():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f4779a == -1) {
            a();
        }
        return this.f4779a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f4779a == -1) {
            a();
        }
        if (this.f4779a == 0) {
            throw new NoSuchElementException();
        }
        Y7.f fVar = this.d;
        kotlin.jvm.internal.k.d(fVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.d = null;
        this.f4779a = -1;
        return fVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
