package ob;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final g f7952a = new g();

    public static final boolean a(int i2, int i10, int i11, byte[] bArr, byte[] bArr2) {
        q7.k.e(bArr, "a");
        q7.k.e(bArr2, "b");
        for (int i12 = 0; i12 < i11; i12++) {
            if (bArr[i12 + i2] != bArr2[i12 + i10]) {
                return false;
            }
        }
        return true;
    }

    public static final c0 b(i0 i0Var) {
        q7.k.e(i0Var, "<this>");
        return new c0(i0Var);
    }

    public static final e0 c(k0 k0Var) {
        q7.k.e(k0Var, "<this>");
        return new e0(k0Var);
    }

    public static void d(long j2, h hVar, int i2, ArrayList arrayList, int i10, int i11, ArrayList arrayList2) {
        int i12;
        int i13;
        ArrayList arrayList3;
        long j4;
        int i14;
        int i15 = i2;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i10 >= i11) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i16 = i10; i16 < i11; i16++) {
            if (((k) arrayList4.get(i16)).d() < i15) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        k kVar = (k) arrayList.get(i10);
        k kVar2 = (k) arrayList4.get(i11 - 1);
        if (i15 == kVar.d()) {
            int iIntValue = ((Number) arrayList5.get(i10)).intValue();
            int i17 = i10 + 1;
            k kVar3 = (k) arrayList4.get(i17);
            i12 = i17;
            i13 = iIntValue;
            kVar = kVar3;
        } else {
            i12 = i10;
            i13 = -1;
        }
        if (kVar.i(i15) == kVar2.i(i15)) {
            int iMin = Math.min(kVar.d(), kVar2.d());
            int i18 = 0;
            for (int i19 = i15; i19 < iMin && kVar.i(i19) == kVar2.i(i19); i19++) {
                i18++;
            }
            long j10 = 4;
            long j11 = (hVar.f7993g / j10) + j2 + 2 + i18 + 1;
            hVar.S(-i18);
            hVar.S(i13);
            int i20 = i15 + i18;
            while (i15 < i20) {
                hVar.S(kVar.i(i15) & 255);
                i15++;
            }
            if (i12 + 1 == i11) {
                if (i20 != ((k) arrayList4.get(i12)).d()) {
                    throw new IllegalStateException("Check failed.");
                }
                hVar.S(((Number) arrayList5.get(i12)).intValue());
                return;
            } else {
                h hVar2 = new h();
                hVar.S(((int) ((hVar2.f7993g / j10) + j11)) * (-1));
                d(j11, hVar2, i20, arrayList4, i12, i11, arrayList5);
                hVar.K(hVar2);
                return;
            }
        }
        int i21 = 1;
        for (int i22 = i12 + 1; i22 < i11; i22++) {
            if (((k) arrayList4.get(i22 - 1)).i(i15) != ((k) arrayList4.get(i22)).i(i15)) {
                i21++;
            }
        }
        long j12 = 4;
        long j13 = (hVar.f7993g / j12) + j2 + 2 + (i21 * 2);
        hVar.S(i21);
        hVar.S(i13);
        for (int i23 = i12; i23 < i11; i23++) {
            int i24 = ((k) arrayList4.get(i23)).i(i15);
            if (i23 == i12 || i24 != ((k) arrayList4.get(i23 - 1)).i(i15)) {
                hVar.S(i24 & 255);
            }
        }
        h hVar3 = new h();
        int i25 = i12;
        while (i25 < i11) {
            byte bI = ((k) arrayList4.get(i25)).i(i15);
            int i26 = i25 + 1;
            int i27 = i26;
            while (true) {
                if (i27 >= i11) {
                    i27 = i11;
                    break;
                } else if (bI != ((k) arrayList4.get(i27)).i(i15)) {
                    break;
                } else {
                    i27++;
                }
            }
            if (i26 == i27 && i15 + 1 == ((k) arrayList4.get(i25)).d()) {
                hVar.S(((Number) arrayList5.get(i25)).intValue());
                arrayList3 = arrayList5;
                j4 = j13;
                i14 = i27;
            } else {
                hVar.S(((int) ((hVar3.f7993g / j12) + j13)) * (-1));
                arrayList3 = arrayList5;
                j4 = j13;
                i14 = i27;
                d(j4, hVar3, i15 + 1, arrayList, i25, i14, arrayList3);
                arrayList4 = arrayList;
            }
            j13 = j4;
            i25 = i14;
            arrayList5 = arrayList3;
        }
        hVar.K(hVar3);
    }

    public static final void e(long j2, long j4, long j10) {
        if ((j4 | j10) < 0 || j4 > j2 || j2 - j4 < j10) {
            throw new ArrayIndexOutOfBoundsException("size=" + j2 + " offset=" + j4 + " byteCount=" + j10);
        }
    }

    public static final boolean f(AssertionError assertionError) {
        Logger logger = x.f8039a;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? ga.k.k0(message, "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e0, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ob.y g(ob.k... r11) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ob.b.g(ob.k[]):ob.y");
    }

    public static final d h(Socket socket) throws IOException {
        Logger logger = x.f8039a;
        j0 j0Var = new j0(socket);
        OutputStream outputStream = socket.getOutputStream();
        q7.k.d(outputStream, "getOutputStream(...)");
        return new d(j0Var, new d(outputStream, j0Var));
    }

    public static final e i(Socket socket) throws IOException {
        Logger logger = x.f8039a;
        j0 j0Var = new j0(socket);
        InputStream inputStream = socket.getInputStream();
        q7.k.d(inputStream, "getInputStream(...)");
        return new e(0, j0Var, new e(1, inputStream, j0Var));
    }
}
