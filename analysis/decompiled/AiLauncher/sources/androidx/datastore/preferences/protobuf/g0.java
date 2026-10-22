package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: f, reason: collision with root package name */
    public static final g0 f13549f = new g0(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f13550a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f13551b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f13552c;

    /* renamed from: d, reason: collision with root package name */
    public int f13553d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13554e;

    public g0() {
        this(0, new int[8], new Object[8], true);
    }

    public static boolean c(int[] iArr, int[] iArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(Object[] objArr, Object[] objArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (!objArr[i11].equals(objArr2[i11])) {
                return false;
            }
        }
        return true;
    }

    public static g0 e() {
        return f13549f;
    }

    public static int h(int[] iArr, int i10) {
        int i11 = 17;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        return i11;
    }

    public static int i(Object[] objArr, int i10) {
        int iHashCode = 17;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode = (iHashCode * 31) + objArr[i11].hashCode();
        }
        return iHashCode;
    }

    public static g0 k(g0 g0Var, g0 g0Var2) {
        int i10 = g0Var.f13550a + g0Var2.f13550a;
        int[] iArrCopyOf = Arrays.copyOf(g0Var.f13551b, i10);
        System.arraycopy(g0Var2.f13551b, 0, iArrCopyOf, g0Var.f13550a, g0Var2.f13550a);
        Object[] objArrCopyOf = Arrays.copyOf(g0Var.f13552c, i10);
        System.arraycopy(g0Var2.f13552c, 0, objArrCopyOf, g0Var.f13550a, g0Var2.f13550a);
        return new g0(i10, iArrCopyOf, objArrCopyOf, true);
    }

    public static g0 l() {
        return new g0();
    }

    public static void p(int i10, Object obj, Writer writer) throws IOException {
        int iA = WireFormat.a(i10);
        int iB = WireFormat.b(i10);
        if (iB == 0) {
            writer.writeInt64(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            writer.writeFixed64(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            writer.b(iA, (ByteString) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(InvalidProtocolBufferException.d());
            }
            writer.writeFixed32(iA, ((Integer) obj).intValue());
        } else if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            writer.writeStartGroup(iA);
            ((g0) obj).q(writer);
            writer.writeEndGroup(iA);
        } else {
            writer.writeEndGroup(iA);
            ((g0) obj).q(writer);
            writer.writeStartGroup(iA);
        }
    }

    public void a() {
        if (!this.f13554e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b() {
        int i10 = this.f13550a;
        int[] iArr = this.f13551b;
        if (i10 == iArr.length) {
            int i11 = i10 + (i10 < 4 ? 8 : i10 >> 1);
            this.f13551b = Arrays.copyOf(iArr, i11);
            this.f13552c = Arrays.copyOf(this.f13552c, i11);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        int i10 = this.f13550a;
        return i10 == g0Var.f13550a && c(this.f13551b, g0Var.f13551b, i10) && d(this.f13552c, g0Var.f13552c, this.f13550a);
    }

    public int f() {
        int iY;
        int i10 = this.f13553d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f13550a; i12++) {
            int i13 = this.f13551b[i12];
            int iA = WireFormat.a(i13);
            int iB = WireFormat.b(i13);
            if (iB == 0) {
                iY = CodedOutputStream.Y(iA, ((Long) this.f13552c[i12]).longValue());
            } else if (iB == 1) {
                iY = CodedOutputStream.o(iA, ((Long) this.f13552c[i12]).longValue());
            } else if (iB == 2) {
                iY = CodedOutputStream.g(iA, (ByteString) this.f13552c[i12]);
            } else if (iB == 3) {
                iY = (CodedOutputStream.V(iA) * 2) + ((g0) this.f13552c[i12]).f();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.d());
                }
                iY = CodedOutputStream.m(iA, ((Integer) this.f13552c[i12]).intValue());
            }
            i11 += iY;
        }
        this.f13553d = i11;
        return i11;
    }

    public int g() {
        int i10 = this.f13553d;
        if (i10 != -1) {
            return i10;
        }
        int iJ = 0;
        for (int i11 = 0; i11 < this.f13550a; i11++) {
            iJ += CodedOutputStream.J(WireFormat.a(this.f13551b[i11]), (ByteString) this.f13552c[i11]);
        }
        this.f13553d = iJ;
        return iJ;
    }

    public int hashCode() {
        int i10 = this.f13550a;
        return ((((527 + i10) * 31) + h(this.f13551b, i10)) * 31) + i(this.f13552c, this.f13550a);
    }

    public void j() {
        this.f13554e = false;
    }

    public final void m(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f13550a; i11++) {
            M.c(sb2, i10, String.valueOf(WireFormat.a(this.f13551b[i11])), this.f13552c[i11]);
        }
    }

    public void n(int i10, Object obj) {
        a();
        b();
        int[] iArr = this.f13551b;
        int i11 = this.f13550a;
        iArr[i11] = i10;
        this.f13552c[i11] = obj;
        this.f13550a = i11 + 1;
    }

    public void o(Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (int i10 = this.f13550a - 1; i10 >= 0; i10--) {
                writer.writeMessageSetItem(WireFormat.a(this.f13551b[i10]), this.f13552c[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.f13550a; i11++) {
            writer.writeMessageSetItem(WireFormat.a(this.f13551b[i11]), this.f13552c[i11]);
        }
    }

    public void q(Writer writer) throws IOException {
        if (this.f13550a == 0) {
            return;
        }
        if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            for (int i10 = 0; i10 < this.f13550a; i10++) {
                p(this.f13551b[i10], this.f13552c[i10], writer);
            }
            return;
        }
        for (int i11 = this.f13550a - 1; i11 >= 0; i11--) {
            p(this.f13551b[i11], this.f13552c[i11], writer);
        }
    }

    public g0(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f13553d = -1;
        this.f13550a = i10;
        this.f13551b = iArr;
        this.f13552c = objArr;
        this.f13554e = z10;
    }
}
