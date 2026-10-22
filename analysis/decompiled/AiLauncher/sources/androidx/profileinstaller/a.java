package androidx.profileinstaller;

import a1.C1204c;
import a1.C1205d;
import a1.C1212k;
import io.ktor.sse.ServerSentEventKt;
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
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f14432a = {112, 114, 111, 0};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f14433b = {112, 114, 109, 0};

    public static void A(byte[] bArr, int i10, int i11, C1204c c1204c) {
        int iM = m(i10, i11, c1204c.f7841g);
        int i12 = iM / 8;
        bArr[i12] = (byte) ((1 << (iM % 8)) | bArr[i12]);
    }

    public static void B(InputStream inputStream) throws IOException {
        C1205d.h(inputStream);
        int iJ = C1205d.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            C1205d.j(inputStream);
            for (int iJ2 = C1205d.j(inputStream); iJ2 > 0; iJ2--) {
                C1205d.h(inputStream);
            }
            iJ--;
        }
    }

    public static boolean C(OutputStream outputStream, byte[] bArr, C1204c[] c1204cArr) throws IOException {
        if (Arrays.equals(bArr, C1212k.f7861a)) {
            P(outputStream, c1204cArr);
            return true;
        }
        if (Arrays.equals(bArr, C1212k.f7862b)) {
            O(outputStream, c1204cArr);
            return true;
        }
        if (Arrays.equals(bArr, C1212k.f7864d)) {
            M(outputStream, c1204cArr);
            return true;
        }
        if (Arrays.equals(bArr, C1212k.f7863c)) {
            N(outputStream, c1204cArr);
            return true;
        }
        if (!Arrays.equals(bArr, C1212k.f7865e)) {
            return false;
        }
        L(outputStream, c1204cArr);
        return true;
    }

    public static void D(OutputStream outputStream, C1204c c1204c) throws IOException {
        int[] iArr = c1204c.f7842h;
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = iArr[i10];
            C1205d.p(outputStream, i12 - i11);
            i10++;
            i11 = i12;
        }
    }

    public static b E(C1204c[] c1204cArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            C1205d.p(byteArrayOutputStream, c1204cArr.length);
            int i10 = 2;
            for (C1204c c1204c : c1204cArr) {
                C1205d.q(byteArrayOutputStream, c1204c.f7837c);
                C1205d.q(byteArrayOutputStream, c1204c.f7838d);
                C1205d.q(byteArrayOutputStream, c1204c.f7841g);
                String strJ = j(c1204c.f7835a, c1204c.f7836b, C1212k.f7861a);
                int iK = C1205d.k(strJ);
                C1205d.p(byteArrayOutputStream, iK);
                i10 = i10 + 14 + iK;
                C1205d.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i10 == byteArray.length) {
                b bVar = new b(FileSectionType.DEX_FILES, i10, byteArray, false);
                byteArrayOutputStream.close();
                return bVar;
            }
            throw C1205d.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void F(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f14432a);
        outputStream.write(bArr);
    }

    public static void G(OutputStream outputStream, C1204c c1204c) throws IOException {
        K(outputStream, c1204c);
        D(outputStream, c1204c);
        I(outputStream, c1204c);
    }

    public static void H(OutputStream outputStream, C1204c c1204c, String str) throws IOException {
        C1205d.p(outputStream, C1205d.k(str));
        C1205d.p(outputStream, c1204c.f7839e);
        C1205d.q(outputStream, c1204c.f7840f);
        C1205d.q(outputStream, c1204c.f7837c);
        C1205d.q(outputStream, c1204c.f7841g);
        C1205d.n(outputStream, str);
    }

    public static void I(OutputStream outputStream, C1204c c1204c) throws IOException {
        byte[] bArr = new byte[k(c1204c.f7841g)];
        for (Map.Entry<Integer, Integer> entry : c1204c.f7843i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            if ((iIntValue2 & 2) != 0) {
                A(bArr, 2, iIntValue, c1204c);
            }
            if ((iIntValue2 & 4) != 0) {
                A(bArr, 4, iIntValue, c1204c);
            }
        }
        outputStream.write(bArr);
    }

    public static void J(OutputStream outputStream, int i10, C1204c c1204c) throws IOException {
        byte[] bArr = new byte[l(i10, c1204c.f7841g)];
        for (Map.Entry<Integer, Integer> entry : c1204c.f7843i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            int i11 = 0;
            for (int i12 = 1; i12 <= 4; i12 <<= 1) {
                if (i12 != 1 && (i12 & i10) != 0) {
                    if ((i12 & iIntValue2) == i12) {
                        int i13 = (c1204c.f7841g * i11) + iIntValue;
                        int i14 = i13 / 8;
                        bArr[i14] = (byte) ((1 << (i13 % 8)) | bArr[i14]);
                    }
                    i11++;
                }
            }
        }
        outputStream.write(bArr);
    }

    public static void K(OutputStream outputStream, C1204c c1204c) throws IOException {
        int i10 = 0;
        for (Map.Entry<Integer, Integer> entry : c1204c.f7843i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                C1205d.p(outputStream, iIntValue - i10);
                C1205d.p(outputStream, 0);
                i10 = iIntValue;
            }
        }
    }

    public static void L(OutputStream outputStream, C1204c[] c1204cArr) throws IOException {
        C1205d.p(outputStream, c1204cArr.length);
        for (C1204c c1204c : c1204cArr) {
            String strJ = j(c1204c.f7835a, c1204c.f7836b, C1212k.f7865e);
            C1205d.p(outputStream, C1205d.k(strJ));
            C1205d.p(outputStream, c1204c.f7843i.size());
            C1205d.p(outputStream, c1204c.f7842h.length);
            C1205d.q(outputStream, c1204c.f7837c);
            C1205d.n(outputStream, strJ);
            Iterator<Integer> it = c1204c.f7843i.keySet().iterator();
            while (it.hasNext()) {
                C1205d.p(outputStream, it.next().intValue());
            }
            for (int i10 : c1204c.f7842h) {
                C1205d.p(outputStream, i10);
            }
        }
    }

    public static void M(OutputStream outputStream, C1204c[] c1204cArr) throws IOException {
        C1205d.r(outputStream, c1204cArr.length);
        for (C1204c c1204c : c1204cArr) {
            int size = c1204c.f7843i.size() * 4;
            String strJ = j(c1204c.f7835a, c1204c.f7836b, C1212k.f7864d);
            C1205d.p(outputStream, C1205d.k(strJ));
            C1205d.p(outputStream, c1204c.f7842h.length);
            C1205d.q(outputStream, size);
            C1205d.q(outputStream, c1204c.f7837c);
            C1205d.n(outputStream, strJ);
            Iterator<Integer> it = c1204c.f7843i.keySet().iterator();
            while (it.hasNext()) {
                C1205d.p(outputStream, it.next().intValue());
                C1205d.p(outputStream, 0);
            }
            for (int i10 : c1204c.f7842h) {
                C1205d.p(outputStream, i10);
            }
        }
    }

    public static void N(OutputStream outputStream, C1204c[] c1204cArr) throws IOException {
        byte[] bArrB = b(c1204cArr, C1212k.f7863c);
        C1205d.r(outputStream, c1204cArr.length);
        C1205d.m(outputStream, bArrB);
    }

    public static void O(OutputStream outputStream, C1204c[] c1204cArr) throws IOException {
        byte[] bArrB = b(c1204cArr, C1212k.f7862b);
        C1205d.r(outputStream, c1204cArr.length);
        C1205d.m(outputStream, bArrB);
    }

    public static void P(OutputStream outputStream, C1204c[] c1204cArr) throws IOException {
        Q(outputStream, c1204cArr);
    }

    public static void Q(OutputStream outputStream, C1204c[] c1204cArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(E(c1204cArr));
        arrayList.add(c(c1204cArr));
        arrayList.add(d(c1204cArr));
        long length2 = C1212k.f7861a.length + f14432a.length + 4 + (arrayList.size() * 16);
        C1205d.q(outputStream, arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            b bVar = (b) arrayList.get(i10);
            C1205d.q(outputStream, bVar.f14434a.getValue());
            C1205d.q(outputStream, length2);
            if (bVar.f14437d) {
                byte[] bArr = bVar.f14436c;
                long length3 = bArr.length;
                byte[] bArrB = C1205d.b(bArr);
                arrayList2.add(bArrB);
                C1205d.q(outputStream, bArrB.length);
                C1205d.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(bVar.f14436c);
                C1205d.q(outputStream, bVar.f14436c.length);
                C1205d.q(outputStream, 0L);
                length = bVar.f14436c.length;
            }
            length2 += length;
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            outputStream.write((byte[]) arrayList2.get(i11));
        }
    }

    public static int a(C1204c c1204c) {
        Iterator<Map.Entry<Integer, Integer>> it = c1204c.f7843i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= it.next().getValue().intValue();
        }
        return iIntValue;
    }

    public static byte[] b(C1204c[] c1204cArr, byte[] bArr) throws IOException {
        int i10 = 0;
        int iK = 0;
        for (C1204c c1204c : c1204cArr) {
            iK += C1205d.k(j(c1204c.f7835a, c1204c.f7836b, bArr)) + 16 + (c1204c.f7839e * 2) + c1204c.f7840f + k(c1204c.f7841g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, C1212k.f7863c)) {
            int length = c1204cArr.length;
            while (i10 < length) {
                C1204c c1204c2 = c1204cArr[i10];
                H(byteArrayOutputStream, c1204c2, j(c1204c2.f7835a, c1204c2.f7836b, bArr));
                G(byteArrayOutputStream, c1204c2);
                i10++;
            }
        } else {
            for (C1204c c1204c3 : c1204cArr) {
                H(byteArrayOutputStream, c1204c3, j(c1204c3.f7835a, c1204c3.f7836b, bArr));
            }
            int length2 = c1204cArr.length;
            while (i10 < length2) {
                G(byteArrayOutputStream, c1204cArr[i10]);
                i10++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw C1205d.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    public static b c(C1204c[] c1204cArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < c1204cArr.length; i11++) {
            try {
                C1204c c1204c = c1204cArr[i11];
                C1205d.p(byteArrayOutputStream, i11);
                C1205d.p(byteArrayOutputStream, c1204c.f7839e);
                i10 = i10 + 4 + (c1204c.f7839e * 2);
                D(byteArrayOutputStream, c1204c);
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
        if (i10 == byteArray.length) {
            b bVar = new b(FileSectionType.CLASSES, i10, byteArray, true);
            byteArrayOutputStream.close();
            return bVar;
        }
        throw C1205d.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    public static b d(C1204c[] c1204cArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < c1204cArr.length; i11++) {
            try {
                C1204c c1204c = c1204cArr[i11];
                int iA = a(c1204c);
                byte[] bArrE = e(iA, c1204c);
                byte[] bArrF = f(c1204c);
                C1205d.p(byteArrayOutputStream, i11);
                int length = bArrE.length + 2 + bArrF.length;
                C1205d.q(byteArrayOutputStream, length);
                C1205d.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i10 = i10 + 6 + length;
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
        if (i10 == byteArray.length) {
            b bVar = new b(FileSectionType.METHODS, i10, byteArray, true);
            byteArrayOutputStream.close();
            return bVar;
        }
        throw C1205d.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    public static byte[] e(int i10, C1204c c1204c) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            J(byteArrayOutputStream, i10, c1204c);
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

    public static byte[] f(C1204c c1204c) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            K(byteArrayOutputStream, c1204c);
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

    public static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(ServerSentEventKt.COLON, "!") : ServerSentEventKt.COLON.equals(str2) ? str.replace("!", ServerSentEventKt.COLON) : str;
    }

    public static String h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(ServerSentEventKt.COLON);
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    public static C1204c i(C1204c[] c1204cArr, String str) {
        if (c1204cArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i10 = 0; i10 < c1204cArr.length; i10++) {
            if (c1204cArr[i10].f7836b.equals(strH)) {
                return c1204cArr[i10];
            }
        }
        return null;
    }

    public static String j(String str, String str2, byte[] bArr) {
        String strA = C1212k.a(bArr);
        if (str.length() <= 0) {
            return g(str2, strA);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(ServerSentEventKt.COLON)) {
            return g(str2, strA);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + C1212k.a(bArr) + str2;
    }

    public static int k(int i10) {
        return z(i10 * 2) / 8;
    }

    public static int l(int i10, int i11) {
        return z(Integer.bitCount(i10 & (-2)) * i11) / 8;
    }

    public static int m(int i10, int i11, int i12) {
        if (i10 == 1) {
            throw C1205d.c("HOT methods are not stored in the bitmap");
        }
        if (i10 == 2) {
            return i11;
        }
        if (i10 == 4) {
            return i11 + i12;
        }
        throw C1205d.c("Unexpected flag: " + i10);
    }

    public static int[] n(InputStream inputStream, int i10) throws IOException {
        int[] iArr = new int[i10];
        int iH = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iH += C1205d.h(inputStream);
            iArr[i11] = iH;
        }
        return iArr;
    }

    public static int o(BitSet bitSet, int i10, int i11) {
        int i12 = bitSet.get(m(2, i10, i11)) ? 2 : 0;
        return bitSet.get(m(4, i10, i11)) ? i12 | 4 : i12;
    }

    public static byte[] p(InputStream inputStream, byte[] bArr) throws IOException {
        if (Arrays.equals(bArr, C1205d.d(inputStream, bArr.length))) {
            return C1205d.d(inputStream, C1212k.f7862b.length);
        }
        throw C1205d.c("Invalid magic");
    }

    public static void q(InputStream inputStream, C1204c c1204c) throws IOException {
        int iAvailable = inputStream.available() - c1204c.f7840f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += C1205d.h(inputStream);
            c1204c.f7843i.put(Integer.valueOf(iH), 1);
            for (int iH2 = C1205d.h(inputStream); iH2 > 0; iH2--) {
                B(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw C1205d.c("Read too much data during profile line parse");
        }
    }

    public static C1204c[] r(InputStream inputStream, byte[] bArr, byte[] bArr2, C1204c[] c1204cArr) throws IOException {
        if (Arrays.equals(bArr, C1212k.f7866f)) {
            if (Arrays.equals(C1212k.f7861a, bArr2)) {
                throw C1205d.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return s(inputStream, bArr, c1204cArr);
        }
        if (Arrays.equals(bArr, C1212k.f7867g)) {
            return u(inputStream, bArr2, c1204cArr);
        }
        throw C1205d.c("Unsupported meta version");
    }

    public static C1204c[] s(InputStream inputStream, byte[] bArr, C1204c[] c1204cArr) throws IOException {
        if (!Arrays.equals(bArr, C1212k.f7866f)) {
            throw C1205d.c("Unsupported meta version");
        }
        int iJ = C1205d.j(inputStream);
        byte[] bArrE = C1205d.e(inputStream, (int) C1205d.i(inputStream), (int) C1205d.i(inputStream));
        if (inputStream.read() > 0) {
            throw C1205d.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            C1204c[] c1204cArrT = t(byteArrayInputStream, iJ, c1204cArr);
            byteArrayInputStream.close();
            return c1204cArrT;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C1204c[] t(InputStream inputStream, int i10, C1204c[] c1204cArr) throws IOException {
        if (inputStream.available() == 0) {
            return new C1204c[0];
        }
        if (i10 != c1204cArr.length) {
            throw C1205d.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i10];
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iH = C1205d.h(inputStream);
            iArr[i11] = C1205d.h(inputStream);
            strArr[i11] = C1205d.f(inputStream, iH);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            C1204c c1204c = c1204cArr[i12];
            if (!c1204c.f7836b.equals(strArr[i12])) {
                throw C1205d.c("Order of dexfiles in metadata did not match baseline");
            }
            int i13 = iArr[i12];
            c1204c.f7839e = i13;
            c1204c.f7842h = n(inputStream, i13);
        }
        return c1204cArr;
    }

    public static C1204c[] u(InputStream inputStream, byte[] bArr, C1204c[] c1204cArr) throws IOException {
        int iH = C1205d.h(inputStream);
        byte[] bArrE = C1205d.e(inputStream, (int) C1205d.i(inputStream), (int) C1205d.i(inputStream));
        if (inputStream.read() > 0) {
            throw C1205d.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            C1204c[] c1204cArrV = v(byteArrayInputStream, bArr, iH, c1204cArr);
            byteArrayInputStream.close();
            return c1204cArrV;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C1204c[] v(InputStream inputStream, byte[] bArr, int i10, C1204c[] c1204cArr) throws IOException {
        if (inputStream.available() == 0) {
            return new C1204c[0];
        }
        if (i10 != c1204cArr.length) {
            throw C1205d.c("Mismatched number of dex files found in metadata");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            C1205d.h(inputStream);
            String strF = C1205d.f(inputStream, C1205d.h(inputStream));
            long jI = C1205d.i(inputStream);
            int iH = C1205d.h(inputStream);
            C1204c c1204cI = i(c1204cArr, strF);
            if (c1204cI == null) {
                throw C1205d.c("Missing profile key: " + strF);
            }
            c1204cI.f7838d = jI;
            int[] iArrN = n(inputStream, iH);
            if (Arrays.equals(bArr, C1212k.f7865e)) {
                c1204cI.f7839e = iH;
                c1204cI.f7842h = iArrN;
            }
        }
        return c1204cArr;
    }

    public static void w(InputStream inputStream, C1204c c1204c) throws IOException {
        BitSet bitSetValueOf = BitSet.valueOf(C1205d.d(inputStream, C1205d.a(c1204c.f7841g * 2)));
        int i10 = 0;
        while (true) {
            int i11 = c1204c.f7841g;
            if (i10 >= i11) {
                return;
            }
            int iO = o(bitSetValueOf, i10, i11);
            if (iO != 0) {
                Integer num = c1204c.f7843i.get(Integer.valueOf(i10));
                if (num == null) {
                    num = 0;
                }
                c1204c.f7843i.put(Integer.valueOf(i10), Integer.valueOf(iO | num.intValue()));
            }
            i10++;
        }
    }

    public static C1204c[] x(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, C1212k.f7862b)) {
            throw C1205d.c("Unsupported version");
        }
        int iJ = C1205d.j(inputStream);
        byte[] bArrE = C1205d.e(inputStream, (int) C1205d.i(inputStream), (int) C1205d.i(inputStream));
        if (inputStream.read() > 0) {
            throw C1205d.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            C1204c[] c1204cArrY = y(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return c1204cArrY;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C1204c[] y(InputStream inputStream, String str, int i10) throws IOException {
        if (inputStream.available() == 0) {
            return new C1204c[0];
        }
        C1204c[] c1204cArr = new C1204c[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iH = C1205d.h(inputStream);
            int iH2 = C1205d.h(inputStream);
            c1204cArr[i11] = new C1204c(str, C1205d.f(inputStream, iH), C1205d.i(inputStream), 0L, iH2, (int) C1205d.i(inputStream), (int) C1205d.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i12 = 0; i12 < i10; i12++) {
            C1204c c1204c = c1204cArr[i12];
            q(inputStream, c1204c);
            c1204c.f7842h = n(inputStream, c1204c.f7839e);
            w(inputStream, c1204c);
        }
        return c1204cArr;
    }

    public static int z(int i10) {
        return (i10 + 7) & (-8);
    }
}
