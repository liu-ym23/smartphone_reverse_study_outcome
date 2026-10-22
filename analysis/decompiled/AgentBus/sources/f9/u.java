package f9;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

/* loaded from: classes.dex */
public class u extends d {

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f3600g;

    /* renamed from: h, reason: collision with root package name */
    public int f3601h = 0;

    public u(byte[] bArr) {
        this.f3600g = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d) || size() != ((d) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof u) {
            return t((u) obj, 0, size());
        }
        if (obj instanceof z) {
            return obj.equals(this);
        }
        String strValueOf = String.valueOf(obj.getClass());
        throw new IllegalArgumentException(a1.a.m(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
    }

    public final int hashCode() {
        int iN = this.f3601h;
        if (iN == 0) {
            int size = size();
            iN = n(size, 0, size);
            if (iN == 0) {
                iN = 1;
            }
            this.f3601h = iN;
        }
        return iN;
    }

    @Override // f9.d
    public void i(int i2, int i10, int i11, byte[] bArr) {
        System.arraycopy(this.f3600g, i2, bArr, i10, i11);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new androidx.datastore.preferences.protobuf.d(this);
    }

    @Override // f9.d
    public final int j() {
        return 0;
    }

    @Override // f9.d
    public final boolean k() {
        return true;
    }

    @Override // f9.d
    public final boolean l() {
        byte[] bArr = this.f3600g;
        return d0.c(bArr, 0, bArr.length) == 0;
    }

    @Override // f9.d
    public final int n(int i2, int i10, int i11) {
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            i2 = (i2 * 31) + this.f3600g[i12];
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        if (r6[r8] > (-65)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        if (r6[r8] > (-65)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0092, code lost:
    
        if (r6[r7] > (-65)) goto L59;
     */
    @Override // f9.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int o(int r7, int r8, int r9) {
        /*
            r6 = this;
            int r9 = r9 + r8
            byte[] r6 = r6.f3600g
            if (r7 == 0) goto L95
            if (r8 < r9) goto L8
            return r7
        L8:
            byte r0 = (byte) r7
            r1 = -32
            r2 = -1
            r3 = -65
            if (r0 >= r1) goto L1f
            r7 = -62
            if (r0 < r7) goto L94
            int r7 = r8 + 1
            r8 = r6[r8]
            if (r8 <= r3) goto L1c
            goto L94
        L1c:
            r8 = r7
            goto L95
        L1f:
            r4 = -16
            if (r0 >= r4) goto L4c
            int r7 = r7 >> 8
            int r7 = ~r7
            byte r7 = (byte) r7
            if (r7 != 0) goto L37
            int r7 = r8 + 1
            r8 = r6[r8]
            if (r7 < r9) goto L34
            int r6 = f9.d0.a(r0, r8)
            return r6
        L34:
            r5 = r8
            r8 = r7
            r7 = r5
        L37:
            if (r7 > r3) goto L94
            r4 = -96
            if (r0 != r1) goto L3f
            if (r7 < r4) goto L94
        L3f:
            r1 = -19
            if (r0 != r1) goto L45
            if (r7 >= r4) goto L94
        L45:
            int r7 = r8 + 1
            r8 = r6[r8]
            if (r8 <= r3) goto L1c
            goto L94
        L4c:
            int r1 = r7 >> 8
            int r1 = ~r1
            byte r1 = (byte) r1
            if (r1 != 0) goto L5f
            int r7 = r8 + 1
            r1 = r6[r8]
            if (r7 < r9) goto L5d
            int r6 = f9.d0.a(r0, r1)
            return r6
        L5d:
            r8 = 0
            goto L65
        L5f:
            int r7 = r7 >> 16
            byte r7 = (byte) r7
            r5 = r8
            r8 = r7
            r7 = r5
        L65:
            if (r8 != 0) goto L81
            int r8 = r7 + 1
            r7 = r6[r7]
            if (r8 < r9) goto L7e
            r6 = -12
            if (r0 > r6) goto L7d
            if (r1 > r3) goto L7d
            if (r7 <= r3) goto L76
            goto L7d
        L76:
            int r6 = r1 << 8
            r6 = r6 ^ r0
            int r7 = r7 << 16
            r6 = r6 ^ r7
            return r6
        L7d:
            return r2
        L7e:
            r5 = r8
            r8 = r7
            r7 = r5
        L81:
            if (r1 > r3) goto L94
            int r0 = r0 << 28
            int r1 = r1 + 112
            int r1 = r1 + r0
            int r0 = r1 >> 30
            if (r0 != 0) goto L94
            if (r8 > r3) goto L94
            int r8 = r7 + 1
            r7 = r6[r7]
            if (r7 <= r3) goto L95
        L94:
            return r2
        L95:
            int r6 = f9.d0.c(r6, r8, r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.u.o(int, int, int):int");
    }

    @Override // f9.d
    public final int p() {
        return this.f3601h;
    }

    @Override // f9.d
    public final String q() {
        byte[] bArr = this.f3600g;
        return new String(bArr, 0, bArr.length, "UTF-8");
    }

    @Override // f9.d
    public final void s(OutputStream outputStream, int i2, int i10) throws IOException {
        outputStream.write(this.f3600g, i2, i10);
    }

    @Override // f9.d
    public int size() {
        return this.f3600g.length;
    }

    public final boolean t(u uVar, int i2, int i10) {
        byte[] bArr = uVar.f3600g;
        int length = bArr.length;
        byte[] bArr2 = this.f3600g;
        if (i10 > length) {
            int length2 = bArr2.length;
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i10);
            sb2.append(length2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i2 + i10 <= bArr.length) {
            int i11 = 0;
            while (i11 < i10) {
                if (bArr2[i11] != bArr[i2]) {
                    return false;
                }
                i11++;
                i2++;
            }
            return true;
        }
        int length3 = uVar.f3600g.length;
        StringBuilder sb3 = new StringBuilder(59);
        sb3.append("Ran off end of other: ");
        sb3.append(i2);
        sb3.append(", ");
        sb3.append(i10);
        sb3.append(", ");
        sb3.append(length3);
        throw new IllegalArgumentException(sb3.toString());
    }
}
