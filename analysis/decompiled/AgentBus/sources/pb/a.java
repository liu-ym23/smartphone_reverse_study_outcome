package pb;

import java.io.EOFException;
import ob.f0;
import q7.k;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f8576a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(ga.a.f4005a);
        k.d(bytes, "getBytes(...)");
        f8576a = bytes;
    }

    public static final boolean a(f0 f0Var, int i2, byte[] bArr, int i10) {
        int i11 = f0Var.f7977c;
        byte[] bArr2 = f0Var.f7975a;
        for (int i12 = 1; i12 < i10; i12++) {
            if (i2 == i11) {
                f0Var = f0Var.f7980f;
                k.b(f0Var);
                bArr2 = f0Var.f7975a;
                i2 = f0Var.f7976b;
                i11 = f0Var.f7977c;
            }
            if (bArr2[i2] != bArr[i12]) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static final String b(ob.h hVar, long j2) throws EOFException {
        if (j2 > 0) {
            long j4 = j2 - 1;
            if (hVar.g(j4) == 13) {
                String strT = hVar.t(j4, ga.a.f4005a);
                hVar.skip(2L);
                return strT;
            }
        }
        String strT2 = hVar.t(j2, ga.a.f4005a);
        hVar.skip(1L);
        return strT2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r18 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007e, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int c(ob.h r16, ob.y r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 173
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.a.c(ob.h, ob.y, boolean):int");
    }
}
