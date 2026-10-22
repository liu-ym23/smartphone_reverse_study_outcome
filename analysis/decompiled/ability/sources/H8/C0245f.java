package H8;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* renamed from: H8.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0245f {
    public int c;
    public final InputStream e;
    public int f;
    public int i;
    public int h = Integer.MAX_VALUE;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f770a = new byte[4096];
    public int b = 0;
    public int d = 0;
    public int g = 0;

    public C0245f(InputStream inputStream) {
        this.e = inputStream;
    }

    public final void a(int i) throws InvalidProtocolBufferException {
        if (this.f != i) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final int b() {
        int i = this.h;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.g + this.d);
    }

    public final void c(int i) {
        this.h = i;
        o();
    }

    public final int d(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i6 = this.g + this.d + i;
        int i10 = this.h;
        if (i6 > i10) {
            throw InvalidProtocolBufferException.a();
        }
        this.h = i6;
        o();
        return i10;
    }

    public final r e() {
        int iK = k();
        int i = this.b;
        int i6 = this.d;
        if (iK > i - i6 || iK <= 0) {
            return iK == 0 ? AbstractC0244e.f769a : new r(h(iK));
        }
        byte[] bArr = new byte[iK];
        System.arraycopy(this.f770a, i6, bArr, 0, iK);
        r rVar = new r(bArr);
        this.d += iK;
        return rVar;
    }

    public final int f() {
        return k();
    }

    public final AbstractC0241b g(t tVar, h hVar) throws InvalidProtocolBufferException {
        int iK = k();
        if (this.i >= 64) {
            throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iD = d(iK);
        this.i++;
        AbstractC0241b abstractC0241b = (AbstractC0241b) tVar.a(this, hVar);
        a(0);
        this.i--;
        c(iD);
        return abstractC0241b;
    }

    public final byte[] h(int i) throws IOException {
        if (i <= 0) {
            if (i == 0) {
                return n.f777a;
            }
            throw new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i6 = this.g;
        int i10 = this.d;
        int i11 = i6 + i10 + i;
        int i12 = this.h;
        if (i11 > i12) {
            r((i12 - i6) - i10);
            throw InvalidProtocolBufferException.a();
        }
        byte[] bArr = this.f770a;
        if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i13 = this.b - i10;
            System.arraycopy(bArr, i10, bArr2, 0, i13);
            this.d = this.b;
            int i14 = i - i13;
            if (i14 > 0) {
                p(i14);
            }
            System.arraycopy(bArr, 0, bArr2, i13, i14);
            this.d = i14;
            return bArr2;
        }
        int i15 = this.b;
        this.g = i6 + i15;
        this.d = 0;
        this.b = 0;
        int length = i15 - i10;
        int i16 = i - length;
        ArrayList arrayList = new ArrayList();
        while (i16 > 0) {
            int iMin = Math.min(i16, 4096);
            byte[] bArr3 = new byte[iMin];
            int i17 = 0;
            while (i17 < iMin) {
                int i18 = this.e.read(bArr3, i17, iMin - i17);
                if (i18 == -1) {
                    throw InvalidProtocolBufferException.a();
                }
                this.g += i18;
                i17 += i18;
            }
            i16 -= iMin;
            arrayList.add(bArr3);
        }
        byte[] bArr4 = new byte[i];
        System.arraycopy(bArr, i10, bArr4, 0, length);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            byte[] bArr5 = (byte[]) it.next();
            System.arraycopy(bArr5, 0, bArr4, length, bArr5.length);
            length += bArr5.length;
        }
        return bArr4;
    }

    public final int i() throws InvalidProtocolBufferException {
        int i = this.d;
        if (this.b - i < 4) {
            p(4);
            i = this.d;
        }
        this.d = i + 4;
        byte[] bArr = this.f770a;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long j() throws InvalidProtocolBufferException {
        int i = this.d;
        if (this.b - i < 8) {
            p(8);
            i = this.d;
        }
        this.d = i + 8;
        byte[] bArr = this.f770a;
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    public final int k() {
        int i;
        int i6 = this.d;
        int i10 = this.b;
        if (i10 != i6) {
            int i11 = i6 + 1;
            byte[] bArr = this.f770a;
            byte b = bArr[i6];
            if (b >= 0) {
                this.d = i11;
                return b;
            }
            if (i10 - i11 >= 9) {
                int i12 = i6 + 2;
                int i13 = (bArr[i11] << 7) ^ b;
                long j5 = i13;
                if (j5 < 0) {
                    i = (int) ((-128) ^ j5);
                } else {
                    int i14 = i6 + 3;
                    int i15 = (bArr[i12] << 14) ^ i13;
                    long j6 = i15;
                    if (j6 >= 0) {
                        i = (int) (16256 ^ j6);
                    } else {
                        int i16 = i6 + 4;
                        long j10 = i15 ^ (bArr[i14] << 21);
                        if (j10 < 0) {
                            i = (int) ((-2080896) ^ j10);
                        } else {
                            i14 = i6 + 5;
                            int i17 = (int) ((r1 ^ (r2 << 28)) ^ 266354560);
                            if (bArr[i16] < 0) {
                                i16 = i6 + 6;
                                if (bArr[i14] < 0) {
                                    i14 = i6 + 7;
                                    if (bArr[i16] < 0) {
                                        i16 = i6 + 8;
                                        if (bArr[i14] < 0) {
                                            i14 = i6 + 9;
                                            if (bArr[i16] < 0) {
                                                int i18 = i6 + 10;
                                                if (bArr[i14] >= 0) {
                                                    i12 = i18;
                                                    i = i17;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i17;
                            }
                            i = i17;
                        }
                        i12 = i16;
                    }
                    i12 = i14;
                }
                this.d = i12;
                return i;
            }
        }
        return (int) m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
    
        if (r3[r2] < 0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long l() {
        /*
            Method dump skipped, instructions count: 196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H8.C0245f.l():long");
    }

    public final long m() throws InvalidProtocolBufferException {
        long j5 = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.d == this.b) {
                p(1);
            }
            int i6 = this.d;
            this.d = i6 + 1;
            j5 |= (r3 & 127) << i;
            if ((this.f770a[i6] & 128) == 0) {
                return j5;
            }
        }
        throw new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }

    public final int n() throws InvalidProtocolBufferException {
        if (this.d == this.b && !s(1)) {
            this.f = 0;
            return 0;
        }
        int iK = k();
        this.f = iK;
        if ((iK >>> 3) != 0) {
            return iK;
        }
        throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    public final void o() {
        int i = this.b + this.c;
        this.b = i;
        int i6 = this.g + i;
        int i10 = this.h;
        if (i6 <= i10) {
            this.c = 0;
            return;
        }
        int i11 = i6 - i10;
        this.c = i11;
        this.b = i - i11;
    }

    public final void p(int i) throws InvalidProtocolBufferException {
        if (!s(i)) {
            throw InvalidProtocolBufferException.a();
        }
    }

    public final boolean q(int i, A0.d dVar) throws IOException {
        int iN;
        int i6 = i & 7;
        if (i6 == 0) {
            long jL = l();
            dVar.z(i);
            dVar.A(jL);
            return true;
        }
        if (i6 == 1) {
            long j5 = j();
            dVar.z(i);
            dVar.y(j5);
            return true;
        }
        if (i6 == 2) {
            r rVarE = e();
            dVar.z(i);
            dVar.z(rVarE.size());
            dVar.v(rVarE);
            return true;
        }
        if (i6 != 3) {
            if (i6 == 4) {
                return false;
            }
            if (i6 != 5) {
                throw new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
            }
            int i10 = i();
            dVar.z(i);
            dVar.x(i10);
            return true;
        }
        dVar.z(i);
        do {
            iN = n();
            if (iN == 0) {
                break;
            }
        } while (q(iN, dVar));
        int i11 = ((i >>> 3) << 3) | 4;
        a(i11);
        dVar.z(i11);
        return true;
    }

    public final void r(int i) throws InvalidProtocolBufferException {
        int i6 = this.b;
        int i10 = this.d;
        int i11 = i6 - i10;
        if (i <= i11 && i >= 0) {
            this.d = i10 + i;
            return;
        }
        if (i < 0) {
            throw new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i12 = this.g;
        int i13 = i12 + i10 + i;
        int i14 = this.h;
        if (i13 > i14) {
            r((i14 - i12) - i10);
            throw InvalidProtocolBufferException.a();
        }
        this.d = i6;
        p(1);
        while (true) {
            int i15 = i - i11;
            int i16 = this.b;
            if (i15 <= i16) {
                this.d = i15;
                return;
            } else {
                i11 += i16;
                this.d = i16;
                p(1);
            }
        }
    }

    public final boolean s(int i) throws IOException {
        InputStream inputStream;
        int i6 = this.d;
        int i10 = i6 + i;
        int i11 = this.b;
        if (i10 <= i11) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        if (this.g + i6 + i <= this.h && (inputStream = this.e) != null) {
            byte[] bArr = this.f770a;
            if (i6 > 0) {
                if (i11 > i6) {
                    System.arraycopy(bArr, i6, bArr, 0, i11 - i6);
                }
                this.g += i6;
                this.b -= i6;
                this.d = 0;
            }
            int i12 = this.b;
            int i13 = inputStream.read(bArr, i12, bArr.length - i12);
            if (i13 == 0 || i13 < -1 || i13 > bArr.length) {
                StringBuilder sb2 = new StringBuilder(102);
                sb2.append("InputStream#read(byte[]) returned invalid result: ");
                sb2.append(i13);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (i13 > 0) {
                this.b += i13;
                if ((this.g + i) - AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL > 0) {
                    throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
                }
                o();
                if (this.b >= i) {
                    return true;
                }
                return s(i);
            }
        }
        return false;
    }
}
