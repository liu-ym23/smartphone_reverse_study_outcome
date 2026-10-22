package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
class n {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f11314a = {112, 114, 111, 0};

    /* renamed from: b, reason: collision with root package name */
    static final byte[] f11315b = {112, 114, 109, 0};

    private static void A(InputStream inputStream) {
        e.h(inputStream);
        int iJ = e.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            e.j(inputStream);
            for (int iJ2 = e.j(inputStream); iJ2 > 0; iJ2--) {
                e.h(inputStream);
            }
            iJ--;
        }
    }

    static boolean B(OutputStream outputStream, byte[] bArr, d[] dVarArr) throws IOException {
        if (Arrays.equals(bArr, p.f11326a)) {
            N(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, p.f11327b)) {
            M(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, p.f11329d)) {
            K(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, p.f11328c)) {
            L(outputStream, dVarArr);
            return true;
        }
        if (!Arrays.equals(bArr, p.f11330e)) {
            return false;
        }
        J(outputStream, dVarArr);
        return true;
    }

    private static void C(OutputStream outputStream, d dVar) throws IOException {
        int[] iArr = dVar.f11295h;
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = iArr[i5];
            e.p(outputStream, i7 - i6);
            i5++;
            i6 = i7;
        }
    }

    private static q D(d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e.p(byteArrayOutputStream, dVarArr.length);
            int i5 = 2;
            for (d dVar : dVarArr) {
                e.q(byteArrayOutputStream, dVar.f11290c);
                e.q(byteArrayOutputStream, dVar.f11291d);
                e.q(byteArrayOutputStream, dVar.f11294g);
                String strJ = j(dVar.f11288a, dVar.f11289b, p.f11326a);
                int iK = e.k(strJ);
                e.p(byteArrayOutputStream, iK);
                i5 = i5 + 14 + iK;
                e.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i5 == byteArray.length) {
                q qVar = new q(f.DEX_FILES, i5, byteArray, false);
                byteArrayOutputStream.close();
                return qVar;
            }
            throw e.c("Expected size " + i5 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    static void E(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f11314a);
        outputStream.write(bArr);
    }

    private static void F(OutputStream outputStream, d dVar) throws IOException {
        I(outputStream, dVar);
        C(outputStream, dVar);
        H(outputStream, dVar);
    }

    private static void G(OutputStream outputStream, d dVar, String str) throws IOException {
        e.p(outputStream, e.k(str));
        e.p(outputStream, dVar.f11292e);
        e.q(outputStream, dVar.f11293f);
        e.q(outputStream, dVar.f11290c);
        e.q(outputStream, dVar.f11294g);
        e.n(outputStream, str);
    }

    private static void H(OutputStream outputStream, d dVar) throws IOException {
        byte[] bArr = new byte[k(dVar.f11294g)];
        for (Map.Entry<Integer, Integer> entry : dVar.f11296i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            if ((iIntValue2 & 2) != 0) {
                z(bArr, 2, iIntValue, dVar);
            }
            if ((iIntValue2 & 4) != 0) {
                z(bArr, 4, iIntValue, dVar);
            }
        }
        outputStream.write(bArr);
    }

    private static void I(OutputStream outputStream, d dVar) throws IOException {
        int i5 = 0;
        for (Map.Entry<Integer, Integer> entry : dVar.f11296i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                e.p(outputStream, iIntValue - i5);
                e.p(outputStream, 0);
                i5 = iIntValue;
            }
        }
    }

    private static void J(OutputStream outputStream, d[] dVarArr) throws IOException {
        e.p(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            String strJ = j(dVar.f11288a, dVar.f11289b, p.f11330e);
            e.p(outputStream, e.k(strJ));
            e.p(outputStream, dVar.f11296i.size());
            e.p(outputStream, dVar.f11295h.length);
            e.q(outputStream, dVar.f11290c);
            e.n(outputStream, strJ);
            Iterator<Integer> it = dVar.f11296i.keySet().iterator();
            while (it.hasNext()) {
                e.p(outputStream, it.next().intValue());
            }
            for (int i5 : dVar.f11295h) {
                e.p(outputStream, i5);
            }
        }
    }

    private static void K(OutputStream outputStream, d[] dVarArr) throws IOException {
        e.r(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            int size = dVar.f11296i.size() * 4;
            String strJ = j(dVar.f11288a, dVar.f11289b, p.f11329d);
            e.p(outputStream, e.k(strJ));
            e.p(outputStream, dVar.f11295h.length);
            e.q(outputStream, size);
            e.q(outputStream, dVar.f11290c);
            e.n(outputStream, strJ);
            Iterator<Integer> it = dVar.f11296i.keySet().iterator();
            while (it.hasNext()) {
                e.p(outputStream, it.next().intValue());
                e.p(outputStream, 0);
            }
            for (int i5 : dVar.f11295h) {
                e.p(outputStream, i5);
            }
        }
    }

    private static void L(OutputStream outputStream, d[] dVarArr) throws IOException {
        byte[] bArrB = b(dVarArr, p.f11328c);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, bArrB);
    }

    private static void M(OutputStream outputStream, d[] dVarArr) throws IOException {
        byte[] bArrB = b(dVarArr, p.f11327b);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, bArrB);
    }

    private static void N(OutputStream outputStream, d[] dVarArr) throws IOException {
        O(outputStream, dVarArr);
    }

    private static void O(OutputStream outputStream, d[] dVarArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(dVarArr));
        arrayList.add(c(dVarArr));
        arrayList.add(d(dVarArr));
        long length2 = p.f11326a.length + f11314a.length + 4 + (arrayList.size() * 16);
        e.q(outputStream, arrayList.size());
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            q qVar = (q) arrayList.get(i5);
            e.q(outputStream, qVar.f11333a.d());
            e.q(outputStream, length2);
            if (qVar.f11336d) {
                byte[] bArr = qVar.f11335c;
                long length3 = bArr.length;
                byte[] bArrB = e.b(bArr);
                arrayList2.add(bArrB);
                e.q(outputStream, bArrB.length);
                e.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(qVar.f11335c);
                e.q(outputStream, qVar.f11335c.length);
                e.q(outputStream, 0L);
                length = qVar.f11335c.length;
            }
            length2 += length;
        }
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            outputStream.write((byte[]) arrayList2.get(i6));
        }
    }

    private static int a(d dVar) {
        Iterator<Map.Entry<Integer, Integer>> it = dVar.f11296i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= it.next().getValue().intValue();
        }
        return iIntValue;
    }

    private static byte[] b(d[] dVarArr, byte[] bArr) throws IOException {
        int i5 = 0;
        int iK = 0;
        for (d dVar : dVarArr) {
            iK += e.k(j(dVar.f11288a, dVar.f11289b, bArr)) + 16 + (dVar.f11292e * 2) + dVar.f11293f + k(dVar.f11294g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, p.f11328c)) {
            int length = dVarArr.length;
            while (i5 < length) {
                d dVar2 = dVarArr[i5];
                G(byteArrayOutputStream, dVar2, j(dVar2.f11288a, dVar2.f11289b, bArr));
                F(byteArrayOutputStream, dVar2);
                i5++;
            }
        } else {
            for (d dVar3 : dVarArr) {
                G(byteArrayOutputStream, dVar3, j(dVar3.f11288a, dVar3.f11289b, bArr));
            }
            int length2 = dVarArr.length;
            while (i5 < length2) {
                F(byteArrayOutputStream, dVarArr[i5]);
                i5++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw e.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    private static q c(d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = 0;
        for (int i6 = 0; i6 < dVarArr.length; i6++) {
            try {
                d dVar = dVarArr[i6];
                e.p(byteArrayOutputStream, i6);
                e.p(byteArrayOutputStream, dVar.f11292e);
                i5 = i5 + 4 + (dVar.f11292e * 2);
                C(byteArrayOutputStream, dVar);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i5 == byteArray.length) {
            q qVar = new q(f.CLASSES, i5, byteArray, true);
            byteArrayOutputStream.close();
            return qVar;
        }
        throw e.c("Expected size " + i5 + ", does not match actual size " + byteArray.length);
    }

    private static q d(d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = 0;
        for (int i6 = 0; i6 < dVarArr.length; i6++) {
            try {
                d dVar = dVarArr[i6];
                int iA = a(dVar);
                byte[] bArrE = e(dVar);
                byte[] bArrF = f(dVar);
                e.p(byteArrayOutputStream, i6);
                int length = bArrE.length + 2 + bArrF.length;
                e.q(byteArrayOutputStream, length);
                e.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i5 = i5 + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i5 == byteArray.length) {
            q qVar = new q(f.METHODS, i5, byteArray, true);
            byteArrayOutputStream.close();
            return qVar;
        }
        throw e.c("Expected size " + i5 + ", does not match actual size " + byteArray.length);
    }

    private static byte[] e(d dVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] f(d dVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    private static String h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    private static d i(d[] dVarArr, String str) {
        if (dVarArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i5 = 0; i5 < dVarArr.length; i5++) {
            if (dVarArr[i5].f11289b.equals(strH)) {
                return dVarArr[i5];
            }
        }
        return null;
    }

    private static String j(String str, String str2, byte[] bArr) {
        String strA = p.a(bArr);
        if (str.length() <= 0) {
            return g(str2, strA);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, strA);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + p.a(bArr) + str2;
    }

    private static int k(int i5) {
        return y(i5 * 2) / 8;
    }

    private static int l(int i5, int i6, int i7) {
        if (i5 == 1) {
            throw e.c("HOT methods are not stored in the bitmap");
        }
        if (i5 == 2) {
            return i6;
        }
        if (i5 == 4) {
            return i6 + i7;
        }
        throw e.c("Unexpected flag: " + i5);
    }

    private static int[] m(InputStream inputStream, int i5) {
        int[] iArr = new int[i5];
        int iH = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            iH += e.h(inputStream);
            iArr[i6] = iH;
        }
        return iArr;
    }

    private static int n(BitSet bitSet, int i5, int i6) {
        int i7 = bitSet.get(l(2, i5, i6)) ? 2 : 0;
        return bitSet.get(l(4, i5, i6)) ? i7 | 4 : i7;
    }

    static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, e.d(inputStream, bArr.length))) {
            return e.d(inputStream, p.f11327b.length);
        }
        throw e.c("Invalid magic");
    }

    private static void p(InputStream inputStream, d dVar) {
        int iAvailable = inputStream.available() - dVar.f11293f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += e.h(inputStream);
            dVar.f11296i.put(Integer.valueOf(iH), 1);
            for (int iH2 = e.h(inputStream); iH2 > 0; iH2--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw e.c("Read too much data during profile line parse");
        }
    }

    static d[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, d[] dVarArr) {
        if (Arrays.equals(bArr, p.f11331f)) {
            if (Arrays.equals(p.f11326a, bArr2)) {
                throw e.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return r(inputStream, bArr, dVarArr);
        }
        if (Arrays.equals(bArr, p.f11332g)) {
            return t(inputStream, bArr2, dVarArr);
        }
        throw e.c("Unsupported meta version");
    }

    static d[] r(InputStream inputStream, byte[] bArr, d[] dVarArr) throws IOException {
        if (!Arrays.equals(bArr, p.f11331f)) {
            throw e.c("Unsupported meta version");
        }
        int iJ = e.j(inputStream);
        byte[] bArrE = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() > 0) {
            throw e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            d[] dVarArrS = s(byteArrayInputStream, iJ, dVarArr);
            byteArrayInputStream.close();
            return dVarArrS;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static d[] s(InputStream inputStream, int i5, d[] dVarArr) {
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i5 != dVarArr.length) {
            throw e.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i5];
        int[] iArr = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int iH = e.h(inputStream);
            iArr[i6] = e.h(inputStream);
            strArr[i6] = e.f(inputStream, iH);
        }
        for (int i7 = 0; i7 < i5; i7++) {
            d dVar = dVarArr[i7];
            if (!dVar.f11289b.equals(strArr[i7])) {
                throw e.c("Order of dexfiles in metadata did not match baseline");
            }
            int i8 = iArr[i7];
            dVar.f11292e = i8;
            dVar.f11295h = m(inputStream, i8);
        }
        return dVarArr;
    }

    static d[] t(InputStream inputStream, byte[] bArr, d[] dVarArr) throws IOException {
        int iH = e.h(inputStream);
        byte[] bArrE = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() > 0) {
            throw e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            d[] dVarArrU = u(byteArrayInputStream, bArr, iH, dVarArr);
            byteArrayInputStream.close();
            return dVarArrU;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static d[] u(InputStream inputStream, byte[] bArr, int i5, d[] dVarArr) {
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i5 != dVarArr.length) {
            throw e.c("Mismatched number of dex files found in metadata");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            e.h(inputStream);
            String strF = e.f(inputStream, e.h(inputStream));
            long jI = e.i(inputStream);
            int iH = e.h(inputStream);
            d dVarI = i(dVarArr, strF);
            if (dVarI == null) {
                throw e.c("Missing profile key: " + strF);
            }
            dVarI.f11291d = jI;
            int[] iArrM = m(inputStream, iH);
            if (Arrays.equals(bArr, p.f11330e)) {
                dVarI.f11292e = iH;
                dVarI.f11295h = iArrM;
            }
        }
        return dVarArr;
    }

    private static void v(InputStream inputStream, d dVar) {
        BitSet bitSetValueOf = BitSet.valueOf(e.d(inputStream, e.a(dVar.f11294g * 2)));
        int i5 = 0;
        while (true) {
            int i6 = dVar.f11294g;
            if (i5 >= i6) {
                return;
            }
            int iN = n(bitSetValueOf, i5, i6);
            if (iN != 0) {
                Integer num = dVar.f11296i.get(Integer.valueOf(i5));
                if (num == null) {
                    num = 0;
                }
                dVar.f11296i.put(Integer.valueOf(i5), Integer.valueOf(iN | num.intValue()));
            }
            i5++;
        }
    }

    static d[] w(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, p.f11327b)) {
            throw e.c("Unsupported version");
        }
        int iJ = e.j(inputStream);
        byte[] bArrE = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() > 0) {
            throw e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            d[] dVarArrX = x(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return dVarArrX;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static d[] x(InputStream inputStream, String str, int i5) {
        if (inputStream.available() == 0) {
            return new d[0];
        }
        d[] dVarArr = new d[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int iH = e.h(inputStream);
            int iH2 = e.h(inputStream);
            dVarArr[i6] = new d(str, e.f(inputStream, iH), e.i(inputStream), 0L, iH2, (int) e.i(inputStream), (int) e.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i7 = 0; i7 < i5; i7++) {
            d dVar = dVarArr[i7];
            p(inputStream, dVar);
            dVar.f11295h = m(inputStream, dVar.f11292e);
            v(inputStream, dVar);
        }
        return dVarArr;
    }

    private static int y(int i5) {
        return (i5 + 7) & (-8);
    }

    private static void z(byte[] bArr, int i5, int i6, d dVar) {
        int iL = l(i5, i6, dVar.f11294g);
        int i7 = iL / 8;
        bArr[i7] = (byte) ((1 << (iL % 8)) | bArr[i7]);
    }
}
