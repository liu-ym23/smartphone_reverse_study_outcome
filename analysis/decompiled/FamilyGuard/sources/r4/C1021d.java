package r4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import k4.InterfaceC0814a;
import q4.InterfaceC0988b;

/* renamed from: r4.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C1021d implements InterfaceC0988b<kotlin.ranges.h> {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f20089a;

    /* renamed from: b, reason: collision with root package name */
    private final int f20090b;

    /* renamed from: c, reason: collision with root package name */
    private final int f20091c;

    /* renamed from: d, reason: collision with root package name */
    private final i4.p<CharSequence, Integer, V3.m<Integer, Integer>> f20092d;

    /* renamed from: r4.d$a */
    public static final class a implements Iterator<kotlin.ranges.h>, InterfaceC0814a {

        /* renamed from: a, reason: collision with root package name */
        private int f20093a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f20094b;

        /* renamed from: c, reason: collision with root package name */
        private int f20095c;

        /* renamed from: d, reason: collision with root package name */
        private kotlin.ranges.h f20096d;

        /* renamed from: e, reason: collision with root package name */
        private int f20097e;

        a() {
            int iH = kotlin.ranges.l.h(C1021d.this.f20090b, 0, C1021d.this.f20089a.length());
            this.f20094b = iH;
            this.f20095c = iH;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void b() {
            /*
                r6 = this;
                int r0 = r6.f20095c
                r1 = 0
                if (r0 >= 0) goto Lb
                r6.f20093a = r1
                r0 = 0
                r6.f20096d = r0
                return
            Lb:
                r4.d r0 = r4.C1021d.this
                int r0 = r4.C1021d.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L22
                int r0 = r6.f20097e
                int r0 = r0 + r3
                r6.f20097e = r0
                r4.d r4 = r4.C1021d.this
                int r4 = r4.C1021d.c(r4)
                if (r0 >= r4) goto L30
            L22:
                int r0 = r6.f20095c
                r4.d r4 = r4.C1021d.this
                java.lang.CharSequence r4 = r4.C1021d.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L46
            L30:
                kotlin.ranges.h r0 = new kotlin.ranges.h
                int r1 = r6.f20094b
                r4.d r4 = r4.C1021d.this
                java.lang.CharSequence r4 = r4.C1021d.b(r4)
                int r4 = r4.C1015B.w(r4)
                r0.<init>(r1, r4)
                r6.f20096d = r0
                r6.f20095c = r2
                goto L9b
            L46:
                r4.d r0 = r4.C1021d.this
                i4.p r0 = r4.C1021d.a(r0)
                r4.d r4 = r4.C1021d.this
                java.lang.CharSequence r4 = r4.C1021d.b(r4)
                int r5 = r6.f20095c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                V3.m r0 = (V3.m) r0
                if (r0 != 0) goto L76
                kotlin.ranges.h r0 = new kotlin.ranges.h
                int r1 = r6.f20094b
                r4.d r4 = r4.C1021d.this
                java.lang.CharSequence r4 = r4.C1021d.b(r4)
                int r4 = r4.C1015B.w(r4)
                r0.<init>(r1, r4)
                r6.f20096d = r0
                r6.f20095c = r2
                goto L9b
            L76:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f20094b
                kotlin.ranges.h r4 = kotlin.ranges.l.j(r4, r2)
                r6.f20096d = r4
                int r2 = r2 + r0
                r6.f20094b = r2
                if (r0 != 0) goto L98
                r1 = r3
            L98:
                int r2 = r2 + r1
                r6.f20095c = r2
            L9b:
                r6.f20093a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: r4.C1021d.a.b():void");
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public kotlin.ranges.h next() {
            if (this.f20093a == -1) {
                b();
            }
            if (this.f20093a == 0) {
                throw new NoSuchElementException();
            }
            kotlin.ranges.h hVar = this.f20096d;
            j4.k.e(hVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f20096d = null;
            this.f20093a = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20093a == -1) {
                b();
            }
            return this.f20093a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1021d(CharSequence charSequence, int i5, int i6, i4.p<? super CharSequence, ? super Integer, V3.m<Integer, Integer>> pVar) {
        j4.k.g(charSequence, "input");
        j4.k.g(pVar, "getNextMatch");
        this.f20089a = charSequence;
        this.f20090b = i5;
        this.f20091c = i6;
        this.f20092d = pVar;
    }

    @Override // q4.InterfaceC0988b
    public Iterator<kotlin.ranges.h> iterator() {
        return new a();
    }
}
