package sd;

import java.util.ArrayList;
import java.util.RandomAccess;
import okio.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class w extends mb.c<ByteString> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final ByteString[] f11979a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f11980b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static void a(long j10, e eVar, int i10, ArrayList arrayList, int i11, int i12, ArrayList arrayList2) {
            int i13;
            int i14;
            ArrayList arrayList3;
            long j11;
            int i15;
            int i16 = i10;
            ArrayList arrayList4 = arrayList;
            ArrayList arrayList5 = arrayList2;
            if (i11 >= i12) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i17 = i11; i17 < i12; i17++) {
                if (((ByteString) arrayList4.get(i17)).d() < i16) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            ByteString byteString = (ByteString) arrayList.get(i11);
            ByteString byteString2 = (ByteString) arrayList4.get(i12 - 1);
            if (i16 == byteString.d()) {
                int iIntValue = ((Number) arrayList5.get(i11)).intValue();
                int i18 = i11 + 1;
                ByteString byteString3 = (ByteString) arrayList4.get(i18);
                i13 = i18;
                i14 = iIntValue;
                byteString = byteString3;
            } else {
                i13 = i11;
                i14 = -1;
            }
            if (byteString.j(i16) == byteString2.j(i16)) {
                int iMin = Math.min(byteString.d(), byteString2.d());
                int i19 = 0;
                for (int i20 = i16; i20 < iMin && byteString.j(i20) == byteString2.j(i20); i20++) {
                    i19++;
                }
                long j12 = 4;
                long j13 = (eVar.f11926b / j12) + j10 + 2 + i19 + 1;
                eVar.R0(-i19);
                eVar.R0(i14);
                int i21 = i16 + i19;
                while (i16 < i21) {
                    eVar.R0(byteString.j(i16) & 255);
                    i16++;
                }
                if (i13 + 1 == i12) {
                    if (i21 != ((ByteString) arrayList4.get(i13)).d()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    eVar.R0(((Number) arrayList5.get(i13)).intValue());
                    return;
                } else {
                    e eVar2 = new e();
                    eVar.R0(((int) ((eVar2.f11926b / j12) + j13)) * (-1));
                    a(j13, eVar2, i21, arrayList4, i13, i12, arrayList5);
                    eVar.u(eVar2);
                    return;
                }
            }
            int i22 = 1;
            for (int i23 = i13 + 1; i23 < i12; i23++) {
                if (((ByteString) arrayList4.get(i23 - 1)).j(i16) != ((ByteString) arrayList4.get(i23)).j(i16)) {
                    i22++;
                }
            }
            long j14 = 4;
            long j15 = (eVar.f11926b / j14) + j10 + 2 + (i22 * 2);
            eVar.R0(i22);
            eVar.R0(i14);
            for (int i24 = i13; i24 < i12; i24++) {
                int iJ = ((ByteString) arrayList4.get(i24)).j(i16);
                if (i24 == i13 || iJ != ((ByteString) arrayList4.get(i24 - 1)).j(i16)) {
                    eVar.R0(iJ & 255);
                }
            }
            e eVar3 = new e();
            int i25 = i13;
            while (i25 < i12) {
                byte bJ = ((ByteString) arrayList4.get(i25)).j(i16);
                int i26 = i25 + 1;
                int i27 = i26;
                while (true) {
                    if (i27 >= i12) {
                        i27 = i12;
                        break;
                    } else if (bJ != ((ByteString) arrayList4.get(i27)).j(i16)) {
                        break;
                    } else {
                        i27++;
                    }
                }
                if (i26 == i27 && i16 + 1 == ((ByteString) arrayList4.get(i25)).d()) {
                    eVar.R0(((Number) arrayList5.get(i25)).intValue());
                    arrayList3 = arrayList5;
                    j11 = j15;
                    i15 = i27;
                } else {
                    eVar.R0(((int) ((eVar3.f11926b / j14) + j15)) * (-1));
                    arrayList3 = arrayList5;
                    j11 = j15;
                    i15 = i27;
                    a(j11, eVar3, i16 + 1, arrayList, i25, i15, arrayList3);
                    arrayList4 = arrayList;
                }
                j15 = j11;
                i25 = i15;
                arrayList5 = arrayList3;
            }
            eVar.u(eVar3);
        }
    }

    public w(ByteString[] byteStringArr, int[] iArr) {
        this.f11979a = byteStringArr;
        this.f11980b = iArr;
    }

    @Override // mb.a
    public final int a() {
        return this.f11979a.length;
    }

    @Override // mb.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return super.contains((ByteString) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        return this.f11979a[i10];
    }

    @Override // mb.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // mb.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.lastIndexOf((ByteString) obj);
        }
        return -1;
    }
}
