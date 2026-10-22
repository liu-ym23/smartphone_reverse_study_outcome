package l5;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final h f10243a;

    /* renamed from: b, reason: collision with root package name */
    public final g f10244b;

    /* renamed from: c, reason: collision with root package name */
    public final a f10245c;

    /* renamed from: d, reason: collision with root package name */
    public final a f10246d;

    /* renamed from: e, reason: collision with root package name */
    public b[] f10247e;

    /* renamed from: f, reason: collision with root package name */
    public int f10248f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10249g;
    public int[] h;

    /* renamed from: i, reason: collision with root package name */
    public int f10250i;

    /* renamed from: j, reason: collision with root package name */
    public d f10251j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final b[] f10252a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f10253b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f10254c;

        /* renamed from: d, reason: collision with root package name */
        public int f10255d;

        public a(int i10) {
            this.f10254c = new int[i10];
            this.f10253b = new int[i10];
            this.f10252a = new b[i10];
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("{");
            for (int i10 = 0; i10 < this.f10255d; i10++) {
                if (i10 != 0) {
                    sb2.append(", ");
                }
                sb2.append(this.f10253b[i10]);
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int[] f10256a;

        /* renamed from: b, reason: collision with root package name */
        public c f10257b;
    }

    public d(h hVar) {
        this.f10247e = new b[10];
        g gVar = hVar.f10266b;
        this.f10244b = gVar;
        this.f10243a = hVar;
        this.f10245c = new a(gVar.f10262b);
        this.f10246d = new a(gVar.f10262b);
        int i10 = gVar.f10264d;
        this.h = new int[i10 < 2 ? 2 : i10];
    }

    public final b a(a aVar, int i10, int i11, int[] iArr, int i12, b bVar) {
        b bVar2;
        int[] iArr2;
        b bVar3;
        if (i10 != 0) {
            int[] iArr3 = aVar.f10254c;
            b[] bVarArr = aVar.f10252a;
            int[] iArr4 = aVar.f10253b;
            int i13 = iArr3[i10];
            int i14 = aVar.f10255d;
            if (i13 >= i14 || iArr4[i13] != i10) {
                aVar.f10255d = i14 + 1;
                iArr3[i10] = i14;
                bVarArr[i14] = null;
                iArr4[i14] = i10;
                c cVar = this.f10244b.f10261a[i10];
                switch (cVar.f10239a) {
                    case 1:
                    case 2:
                        return a(aVar, cVar.f10241c, i11, iArr, i12, a(aVar, cVar.f10240b, i11, iArr, i12, bVar));
                    case 3:
                        int i15 = cVar.f10241c;
                        if (i15 >= this.f10250i) {
                            return a(aVar, cVar.f10240b, i11, iArr, i12, bVar);
                        }
                        int i16 = iArr[i15];
                        iArr[i15] = i11;
                        a(aVar, cVar.f10240b, i11, iArr, i12, null);
                        iArr[cVar.f10241c] = i16;
                        return bVar;
                    case 4:
                        return (cVar.f10241c & (~i12)) == 0 ? a(aVar, cVar.f10240b, i11, iArr, i12, bVar) : bVar;
                    case 5:
                        break;
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        if (bVar == null) {
                            int i17 = this.f10248f;
                            if (i17 > 0) {
                                int i18 = i17 - 1;
                                this.f10248f = i18;
                                bVar3 = this.f10247e[i18];
                            } else {
                                int length = this.h.length;
                                bVar3 = new b();
                                bVar3.f10256a = new int[length];
                            }
                            bVar2 = bVar3;
                            bVar2.f10257b = cVar;
                        } else {
                            bVar.f10257b = cVar;
                            bVar2 = bVar;
                        }
                        int i19 = this.f10250i;
                        if (i19 > 0 && (iArr2 = bVar2.f10256a) != iArr) {
                            System.arraycopy(iArr, 0, iArr2, 0, i19);
                        }
                        bVarArr[i14] = bVar2;
                        return null;
                    case 7:
                        return a(aVar, cVar.f10240b, i11, iArr, i12, bVar);
                    default:
                        throw new IllegalStateException("unhandled");
                }
            }
        }
        return bVar;
    }

    public final void b(a aVar, int i10) {
        int i11 = this.f10248f + (aVar.f10255d - i10);
        b[] bVarArr = this.f10247e;
        if (bVarArr.length < i11) {
            this.f10247e = (b[]) Arrays.copyOf(bVarArr, Math.max(bVarArr.length * 2, i11));
        }
        while (i10 < aVar.f10255d) {
            b bVar = aVar.f10252a[i10];
            if (bVar != null) {
                b[] bVarArr2 = this.f10247e;
                int i12 = this.f10248f;
                bVarArr2[i12] = bVar;
                this.f10248f = i12 + 1;
            }
            i10++;
        }
        aVar.f10255d = 0;
    }

    public final void c(b bVar) {
        b[] bVarArr = this.f10247e;
        if (bVarArr.length <= this.f10248f) {
            this.f10247e = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
        }
        b[] bVarArr2 = this.f10247e;
        int i10 = this.f10248f;
        bVarArr2[i10] = bVar;
        this.f10248f = i10 + 1;
    }

    public d(d dVar) {
        this.f10247e = new b[10];
        this.f10243a = dVar.f10243a;
        this.f10244b = dVar.f10244b;
        this.f10245c = dVar.f10245c;
        this.f10246d = dVar.f10246d;
        this.f10247e = dVar.f10247e;
        this.f10248f = dVar.f10248f;
        this.f10249g = dVar.f10249g;
        this.h = dVar.h;
        this.f10250i = dVar.f10250i;
    }
}
