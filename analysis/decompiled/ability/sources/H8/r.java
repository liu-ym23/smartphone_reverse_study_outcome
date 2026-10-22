package H8;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class r extends AbstractC0244e {
    public final byte[] b;
    public int c = 0;

    public r(byte[] bArr) {
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0244e) || size() != ((AbstractC0244e) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof r) {
            return s((r) obj, 0, size());
        }
        if (obj instanceof w) {
            return obj.equals(this);
        }
        String strValueOf = String.valueOf(obj.getClass());
        throw new IllegalArgumentException(B7.a.q(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
    }

    @Override // H8.AbstractC0244e
    public void f(byte[] bArr, int i, int i6, int i10) {
        System.arraycopy(this.b, i, bArr, i6, i10);
    }

    @Override // H8.AbstractC0244e
    public final int g() {
        return 0;
    }

    @Override // H8.AbstractC0244e
    public final boolean h() {
        return true;
    }

    public final int hashCode() {
        int iL = this.c;
        if (iL == 0) {
            int size = size();
            iL = l(size, 0, size);
            if (iL == 0) {
                iL = 1;
            }
            this.c = iL;
        }
        return iL;
    }

    @Override // H8.AbstractC0244e
    public final boolean i() {
        byte[] bArr = this.b;
        return A.c(bArr, 0, bArr.length) == 0;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new q(this);
    }

    @Override // H8.AbstractC0244e
    public final int l(int i, int i6, int i10) {
        for (int i11 = i6; i11 < i6 + i10; i11++) {
            i = (i * 31) + this.b[i11];
        }
        return i;
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
    @Override // H8.AbstractC0244e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int n(int r7, int r8, int r9) {
        /*
            r6 = this;
            int r9 = r9 + r8
            byte[] r6 = r6.b
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
            int r6 = H8.A.a(r0, r8)
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
            int r6 = H8.A.a(r0, r1)
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
            int r6 = H8.A.c(r6, r8, r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: H8.r.n(int, int, int):int");
    }

    @Override // H8.AbstractC0244e
    public final int o() {
        return this.c;
    }

    @Override // H8.AbstractC0244e
    public final String p() {
        byte[] bArr = this.b;
        return new String(bArr, 0, bArr.length, "UTF-8");
    }

    @Override // H8.AbstractC0244e
    public final void r(OutputStream outputStream, int i, int i6) throws IOException {
        outputStream.write(this.b, i, i6);
    }

    public final boolean s(r rVar, int i, int i6) {
        byte[] bArr = rVar.b;
        int length = bArr.length;
        byte[] bArr2 = this.b;
        if (i6 > length) {
            int length2 = bArr2.length;
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i6);
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i + i6 <= bArr.length) {
            int i10 = 0;
            while (i10 < i6) {
                if (bArr2[i10] != bArr[i]) {
                    return false;
                }
                i10++;
                i++;
            }
            return true;
        }
        int length3 = rVar.b.length;
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("Ran off end of other: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i6);
        sb2.append(", ");
        sb2.append(length3);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // H8.AbstractC0244e
    public int size() {
        return this.b.length;
    }
}
