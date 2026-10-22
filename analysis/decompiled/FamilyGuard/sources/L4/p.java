package L4;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class p extends AbstractList<h> implements RandomAccess {

    /* renamed from: c, reason: collision with root package name */
    public static final a f3961c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final h[] f3962a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f3963b;

    public static final class a {
        private a() {
        }

        private final void a(long j5, e eVar, int i5, List<? extends h> list, int i6, int i7, List<Integer> list2) {
            int i8;
            int i9;
            int i10;
            long j6;
            int i11 = i5;
            if (i6 >= i7) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i12 = i6; i12 < i7; i12++) {
                if (list.get(i12).w() < i11) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            h hVar = list.get(i6);
            h hVar2 = list.get(i7 - 1);
            if (i11 == hVar.w()) {
                int iIntValue = list2.get(i6).intValue();
                int i13 = i6 + 1;
                h hVar3 = list.get(i13);
                i8 = i13;
                i9 = iIntValue;
                hVar = hVar3;
            } else {
                i8 = i6;
                i9 = -1;
            }
            if (hVar.i(i11) == hVar2.i(i11)) {
                int iMin = Math.min(hVar.w(), hVar2.w());
                int i14 = 0;
                for (int i15 = i11; i15 < iMin && hVar.i(i15) == hVar2.i(i15); i15++) {
                    i14++;
                }
                long jC = j5 + c(eVar) + 2 + i14 + 1;
                eVar.writeInt(-i14);
                eVar.writeInt(i9);
                int i16 = i11 + i14;
                while (i11 < i16) {
                    eVar.writeInt(hVar.i(i11) & 255);
                    i11++;
                }
                if (i8 + 1 == i7) {
                    if (i16 != list.get(i8).w()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    eVar.writeInt(list2.get(i8).intValue());
                    return;
                } else {
                    e eVar2 = new e();
                    eVar.writeInt(((int) (c(eVar2) + jC)) * (-1));
                    a(jC, eVar2, i16, list, i8, i7, list2);
                    eVar.k0(eVar2);
                    return;
                }
            }
            int i17 = 1;
            for (int i18 = i8 + 1; i18 < i7; i18++) {
                if (list.get(i18 - 1).i(i11) != list.get(i18).i(i11)) {
                    i17++;
                }
            }
            long jC2 = j5 + c(eVar) + 2 + (i17 * 2);
            eVar.writeInt(i17);
            eVar.writeInt(i9);
            for (int i19 = i8; i19 < i7; i19++) {
                byte bI = list.get(i19).i(i11);
                if (i19 == i8 || bI != list.get(i19 - 1).i(i11)) {
                    eVar.writeInt(bI & 255);
                }
            }
            e eVar3 = new e();
            while (i8 < i7) {
                byte bI2 = list.get(i8).i(i11);
                int i20 = i8 + 1;
                int i21 = i20;
                while (true) {
                    if (i21 >= i7) {
                        i10 = i7;
                        break;
                    } else {
                        if (bI2 != list.get(i21).i(i11)) {
                            i10 = i21;
                            break;
                        }
                        i21++;
                    }
                }
                if (i20 == i10 && i11 + 1 == list.get(i8).w()) {
                    eVar.writeInt(list2.get(i8).intValue());
                    j6 = jC2;
                } else {
                    eVar.writeInt(((int) (c(eVar3) + jC2)) * (-1));
                    j6 = jC2;
                    a(j6, eVar3, i11 + 1, list, i8, i10, list2);
                }
                jC2 = j6;
                i8 = i10;
            }
            eVar.k0(eVar3);
        }

        static /* bridge */ /* synthetic */ void b(a aVar, long j5, e eVar, int i5, List list, int i6, int i7, List list2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                j5 = 0;
            }
            aVar.a(j5, eVar, (i8 & 4) != 0 ? 0 : i5, list, (i8 & 16) != 0 ? 0 : i6, (i8 & 32) != 0 ? list.size() : i7, list2);
        }

        private final long c(e eVar) {
            return eVar.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x00db, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final L4.p d(L4.h... r17) {
            /*
                Method dump skipped, instructions count: 291
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: L4.p.a.d(L4.h[]):L4.p");
        }

        public /* synthetic */ a(j4.g gVar) {
            this();
        }
    }

    public /* synthetic */ p(h[] hVarArr, int[] iArr, j4.g gVar) {
        this(hVarArr, iArr);
    }

    public static final p o(h... hVarArr) {
        return f3961c.d(hVarArr);
    }

    public /* bridge */ boolean a(h hVar) {
        return super.contains(hVar);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h get(int i5) {
        return this.f3962a[i5];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj != null ? obj instanceof h : true) {
            return a((h) obj);
        }
        return false;
    }

    public final h[] f() {
        return this.f3962a;
    }

    public int h() {
        return this.f3962a.length;
    }

    public final int[] i() {
        return this.f3963b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj != null ? obj instanceof h : true) {
            return m((h) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj != null ? obj instanceof h : true) {
            return n((h) obj);
        }
        return -1;
    }

    public /* bridge */ int m(h hVar) {
        return super.indexOf(hVar);
    }

    public /* bridge */ int n(h hVar) {
        return super.lastIndexOf(hVar);
    }

    public /* bridge */ boolean p(h hVar) {
        return super.remove(hVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj != null ? obj instanceof h : true) {
            return p((h) obj);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return h();
    }

    private p(h[] hVarArr, int[] iArr) {
        this.f3962a = hVarArr;
        this.f3963b = iArr;
    }
}
