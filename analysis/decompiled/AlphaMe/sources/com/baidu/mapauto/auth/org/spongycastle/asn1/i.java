package com.baidu.mapauto.auth.org.spongycastle.asn1;

import androidx.room.AbstractC0351g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class i extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final int f7720a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7721b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[][] f7722c;

    public i(int i4, InputStream inputStream) {
        this(inputStream, i4, false);
    }

    public static int a(int i4, InputStream inputStream) throws IOException {
        int i5 = inputStream.read();
        if (i5 < 0) {
            throw new EOFException("EOF found when length expected");
        }
        if (i5 == 128) {
            return -1;
        }
        if (i5 <= 127) {
            return i5;
        }
        int i6 = i5 & 127;
        if (i6 > 4) {
            throw new IOException(AbstractC0351g.m("DER length more than 4 bytes: ", i6));
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            int i9 = inputStream.read();
            if (i9 < 0) {
                throw new EOFException("EOF found reading length");
            }
            i7 = (i7 << 8) + i9;
        }
        if (i7 < 0) {
            throw new IOException("corrupted stream - negative length found");
        }
        if (i7 < i4) {
            return i7;
        }
        throw new IOException("corrupted stream - out of bounds length found");
    }

    public static int b(int i4, InputStream inputStream) throws IOException {
        int i5 = i4 & 31;
        if (i5 != 31) {
            return i5;
        }
        int i6 = inputStream.read();
        if ((i6 & 127) == 0) {
            throw new IOException("corrupted stream - invalid high tag number found");
        }
        int i7 = 0;
        while (i6 >= 0 && (i6 & 128) != 0) {
            i7 = ((i6 & 127) | i7) << 7;
            i6 = inputStream.read();
        }
        if (i6 >= 0) {
            return (i6 & 127) | i7;
        }
        throw new EOFException("EOF found inside tag value.");
    }

    public i(InputStream inputStream, int i4, boolean z4) {
        super(inputStream);
        this.f7720a = i4;
        this.f7721b = z4;
        this.f7722c = new byte[11][];
    }

    public i(byte[] bArr) {
        this(bArr.length, new ByteArrayInputStream(bArr));
    }

    public i(byte[] bArr, int i4) {
        this(new ByteArrayInputStream(bArr), bArr.length, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.baidu.mapauto.auth.org.spongycastle.asn1.r a(int r6, com.baidu.mapauto.auth.org.spongycastle.asn1.o1 r7, byte[][] r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapauto.auth.org.spongycastle.asn1.i.a(int, com.baidu.mapauto.auth.org.spongycastle.asn1.o1, byte[][]):com.baidu.mapauto.auth.org.spongycastle.asn1.r");
    }

    public static e a(o1 o1Var) throws IOException {
        i iVar = new i(o1Var, u1.a(o1Var), false);
        e eVar = new e();
        while (true) {
            r rVarA = iVar.a();
            if (rVarA == null) {
                return eVar;
            }
            eVar.f7709a.addElement(rVarA);
        }
    }

    public final r a(int i4, int i5, int i6) throws IOException {
        boolean z4 = (i4 & 32) != 0;
        o1 o1Var = new o1(i6, this);
        if ((i4 & 64) != 0) {
            return new k0(z4, i5, o1Var.c());
        }
        if ((i4 & 128) != 0) {
            return new v(u1.a(o1Var), o1Var).a(z4, i5);
        }
        if (!z4) {
            return a(i5, o1Var, this.f7722c);
        }
        if (i5 == 4) {
            e eVarA = a(o1Var);
            int size = eVarA.f7709a.size();
            n[] nVarArr = new n[size];
            for (int i7 = 0; i7 != size; i7++) {
                nVarArr[i7] = (n) eVarA.a(i7);
            }
            return new b0(nVarArr);
        }
        if (i5 == 8) {
            return new n0(a(o1Var));
        }
        if (i5 == 16) {
            if (this.f7721b) {
                return new s1(o1Var.c());
            }
            e eVarA2 = a(o1Var);
            return eVarA2.f7709a.size() < 1 ? p0.f7751a : new l1(eVarA2);
        }
        if (i5 != 17) {
            throw new IOException(B0.g.j("unknown tag ", i5, " encountered"));
        }
        e eVarA3 = a(o1Var);
        z0 z0Var = p0.f7751a;
        return eVarA3.f7709a.size() < 1 ? p0.f7752b : new m1(eVarA3);
    }

    public final r a() throws IOException {
        int i4 = read();
        if (i4 <= 0) {
            if (i4 != 0) {
                return null;
            }
            throw new IOException("unexpected end-of-contents marker");
        }
        int iB = b(i4, this);
        boolean z4 = (i4 & 32) != 0;
        int iA = a(this.f7720a, this);
        if (iA >= 0) {
            try {
                return a(i4, iB, iA);
            } catch (IllegalArgumentException e4) {
                throw new g("corrupted stream detected", e4);
            }
        }
        if (z4) {
            v vVar = new v(this.f7720a, new q1(this.f7720a, this));
            if ((i4 & 64) != 0) {
                return new y(iB, vVar.b());
            }
            if ((i4 & 128) != 0) {
                return vVar.a(true, iB);
            }
            if (iB != 4) {
                if (iB == 8) {
                    try {
                        return new n0(vVar.b());
                    } catch (IllegalArgumentException e5) {
                        throw new g(e5.getMessage(), e5);
                    }
                }
                if (iB == 16) {
                    return new d0(vVar.b());
                }
                if (iB == 17) {
                    return new f0(vVar.b());
                }
                throw new IOException("unknown BER object encountered");
            }
            j0 j0Var = new j0(vVar);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int i5 = j0Var.read(bArr, 0, 4096);
                if (i5 < 0) {
                    return new b0(byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(bArr, 0, i5);
            }
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }
}
