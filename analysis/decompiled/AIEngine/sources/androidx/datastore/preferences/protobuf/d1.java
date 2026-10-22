package androidx.datastore.preferences.protobuf;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d1 {

    /* renamed from: f, reason: collision with root package name */
    public static final d1 f1800f = new d1(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f1801a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1802b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f1803c;

    /* renamed from: d, reason: collision with root package name */
    public int f1804d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1805e;

    public d1() {
        this(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iS;
        int iV;
        int iN;
        int i10 = this.f1804d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f1801a; i12++) {
            int i13 = this.f1802b[i12];
            int i14 = i13 >>> 3;
            int i15 = i13 & 7;
            if (i15 != 0) {
                if (i15 == 1) {
                    ((Long) this.f1803c[i12]).getClass();
                    iN = CodedOutputStream.n(i14);
                } else if (i15 == 2) {
                    iN = CodedOutputStream.k(i14, (ByteString) this.f1803c[i12]);
                } else if (i15 == 3) {
                    iS = CodedOutputStream.s(i14) * 2;
                    iV = ((d1) this.f1803c[i12]).a();
                } else {
                    if (i15 != 5) {
                        throw new IllegalStateException(InvalidProtocolBufferException.b());
                    }
                    ((Integer) this.f1803c[i12]).getClass();
                    iN = CodedOutputStream.m(i14);
                }
                i11 = iN + i11;
            } else {
                long jLongValue = ((Long) this.f1803c[i12]).longValue();
                iS = CodedOutputStream.s(i14);
                iV = CodedOutputStream.v(jLongValue);
            }
            i11 = iV + iS + i11;
        }
        this.f1804d = i11;
        return i11;
    }

    public final void b(int i10, Object obj) {
        if (!this.f1805e) {
            throw new UnsupportedOperationException();
        }
        int i11 = this.f1801a;
        int[] iArr = this.f1802b;
        if (i11 == iArr.length) {
            int i12 = i11 + (i11 < 4 ? 8 : i11 >> 1);
            this.f1802b = Arrays.copyOf(iArr, i12);
            this.f1803c = Arrays.copyOf(this.f1803c, i12);
        }
        int[] iArr2 = this.f1802b;
        int i13 = this.f1801a;
        iArr2[i13] = i10;
        this.f1803c[i13] = obj;
        this.f1801a = i13 + 1;
    }

    public final void c(h1 h1Var) {
        if (this.f1801a == 0) {
            return;
        }
        h1Var.getClass();
        for (int i10 = 0; i10 < this.f1801a; i10++) {
            int i11 = this.f1802b[i10];
            Object obj = this.f1803c[i10];
            int i12 = i11 >>> 3;
            int i13 = i11 & 7;
            if (i13 == 0) {
                ((j) h1Var).f1844a.R(i12, ((Long) obj).longValue());
            } else if (i13 == 1) {
                ((j) h1Var).f1844a.E(i12, ((Long) obj).longValue());
            } else if (i13 == 2) {
                ((j) h1Var).a(i12, (ByteString) obj);
            } else if (i13 == 3) {
                CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
                codedOutputStream.O(i12, 3);
                ((d1) obj).c(h1Var);
                codedOutputStream.O(i12, 4);
            } else {
                if (i13 != 5) {
                    throw new RuntimeException(InvalidProtocolBufferException.b());
                }
                ((j) h1Var).f1844a.C(i12, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d1)) {
            return false;
        }
        d1 d1Var = (d1) obj;
        int i10 = this.f1801a;
        if (i10 == d1Var.f1801a) {
            int[] iArr = this.f1802b;
            int[] iArr2 = d1Var.f1802b;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    Object[] objArr = this.f1803c;
                    Object[] objArr2 = d1Var.f1803c;
                    int i12 = this.f1801a;
                    for (int i13 = 0; i13 < i12; i13++) {
                        if (objArr[i13].equals(objArr2[i13])) {
                        }
                    }
                    return true;
                }
                if (iArr[i11] != iArr2[i11]) {
                    break;
                }
                i11++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.f1801a;
        int i11 = (527 + i10) * 31;
        int[] iArr = this.f1802b;
        int iHashCode = 17;
        int i12 = 17;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        int i14 = (i11 + i12) * 31;
        Object[] objArr = this.f1803c;
        int i15 = this.f1801a;
        for (int i16 = 0; i16 < i15; i16++) {
            iHashCode = (iHashCode * 31) + objArr[i16].hashCode();
        }
        return i14 + iHashCode;
    }

    public d1(int i10, int[] iArr, Object[] objArr, boolean z) {
        this.f1804d = -1;
        this.f1801a = i10;
        this.f1802b = iArr;
        this.f1803c = objArr;
        this.f1805e = z;
    }
}
