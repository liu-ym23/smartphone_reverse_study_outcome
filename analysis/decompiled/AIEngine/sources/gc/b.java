package gc;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements fc.i<dc.e> {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f9112a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9113b;

    /* renamed from: c, reason: collision with root package name */
    public final zb.p<CharSequence, Integer, Pair<Integer, Integer>> f9114c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Iterator<dc.e>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public int f9115a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f9116b;

        /* renamed from: c, reason: collision with root package name */
        public int f9117c;

        /* renamed from: d, reason: collision with root package name */
        public dc.e f9118d;

        /* renamed from: e, reason: collision with root package name */
        public int f9119e;

        public a() {
            int iA0 = dc.h.a0(0, 0, b.this.f9112a.length());
            this.f9116b = iA0;
            this.f9117c = iA0;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a() {
            /*
                r7 = this;
                int r0 = r7.f9117c
                r1 = 0
                if (r0 >= 0) goto Lb
                r7.f9115a = r1
                r0 = 0
                r7.f9118d = r0
                return
            Lb:
                gc.b r2 = gc.b.this
                int r3 = r2.f9113b
                r4 = -1
                r5 = 1
                if (r3 <= 0) goto L1a
                int r6 = r7.f9119e
                int r6 = r6 + r5
                r7.f9119e = r6
                if (r6 >= r3) goto L22
            L1a:
                java.lang.CharSequence r3 = r2.f9112a
                int r3 = r3.length()
                if (r0 <= r3) goto L34
            L22:
                dc.e r0 = new dc.e
                int r1 = r7.f9116b
                java.lang.CharSequence r2 = r2.f9112a
                int r2 = gc.q.n0(r2)
                r0.<init>(r1, r2, r5)
                r7.f9118d = r0
                r7.f9117c = r4
                goto L79
            L34:
                zb.p<java.lang.CharSequence, java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> r0 = r2.f9114c
                java.lang.CharSequence r3 = r2.f9112a
                int r6 = r7.f9117c
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                java.lang.Object r0 = r0.invoke(r3, r6)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L58
                dc.e r0 = new dc.e
                int r1 = r7.f9116b
                java.lang.CharSequence r2 = r2.f9112a
                int r2 = gc.q.n0(r2)
                r0.<init>(r1, r2, r5)
                r7.f9118d = r0
                r7.f9117c = r4
                goto L79
            L58:
                A r2 = r0.f9985a
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                B r0 = r0.f9986b
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r3 = r7.f9116b
                dc.e r3 = dc.h.e0(r3, r2)
                r7.f9118d = r3
                int r2 = r2 + r0
                r7.f9116b = r2
                if (r0 != 0) goto L76
                r1 = r5
            L76:
                int r2 = r2 + r1
                r7.f9117c = r2
            L79:
                r7.f9115a = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: gc.b.a.a():void");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f9115a == -1) {
                a();
            }
            return this.f9115a == 1;
        }

        @Override // java.util.Iterator
        public final dc.e next() {
            if (this.f9115a == -1) {
                a();
            }
            if (this.f9115a == 0) {
                throw new NoSuchElementException();
            }
            dc.e eVar = this.f9118d;
            kotlin.jvm.internal.g.d(eVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f9118d = null;
            this.f9115a = -1;
            return eVar;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(CharSequence input, int i10, zb.p pVar) {
        kotlin.jvm.internal.g.f(input, "input");
        this.f9112a = input;
        this.f9113b = i10;
        this.f9114c = pVar;
    }

    @Override // fc.i
    public final Iterator<dc.e> iterator() {
        return new a();
    }
}
