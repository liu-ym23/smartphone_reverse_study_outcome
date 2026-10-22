package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f2455a = {112, 114, 111, 0};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f2456b = {112, 114, 109, 0};

    public static byte[] a(t1.a[] aVarArr, byte[] bArr) throws IOException {
        int i10 = 0;
        int length = 0;
        for (t1.a aVar : aVarArr) {
            length += ((((aVar.f12925g * 2) + 7) & (-8)) / 8) + (aVar.f12923e * 2) + b(aVar.f12919a, bArr, aVar.f12920b).getBytes(StandardCharsets.UTF_8).length + 16 + aVar.f12924f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, t1.d.f12930c)) {
            int length2 = aVarArr.length;
            while (i10 < length2) {
                t1.a aVar2 = aVarArr[i10];
                k(byteArrayOutputStream, aVar2, b(aVar2.f12919a, bArr, aVar2.f12920b));
                j(byteArrayOutputStream, aVar2);
                i10++;
            }
        } else {
            for (t1.a aVar3 : aVarArr) {
                k(byteArrayOutputStream, aVar3, b(aVar3.f12919a, bArr, aVar3.f12920b));
            }
            int length3 = aVarArr.length;
            while (i10 < length3) {
                j(byteArrayOutputStream, aVarArr[i10]);
                i10++;
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + length);
    }

    public static String b(String str, byte[] bArr, String str2) {
        byte[] bArr2 = t1.d.f12932e;
        boolean zEquals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = t1.d.f12931d;
        String str3 = (zEquals || Arrays.equals(bArr, bArr3)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(str3)) {
                return str2.replace(":", "!");
            }
            if (":".equals(str3)) {
                return str2.replace("!", ":");
            }
        } else {
            if (str2.equals("classes.dex")) {
                return str;
            }
            if (str2.contains("!") || str2.contains(":")) {
                if ("!".equals(str3)) {
                    return str2.replace(":", "!");
                }
                if (":".equals(str3)) {
                    return str2.replace("!", ":");
                }
            } else if (!str2.endsWith(".apk")) {
                return ai.onnxruntime.a.o(v1.d.b(str), (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ":" : "!", str2);
            }
        }
        return str2;
    }

    public static int[] c(ByteArrayInputStream byteArrayInputStream, int i10) {
        int[] iArr = new int[i10];
        int I = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            I += (int) y.I(byteArrayInputStream, 2);
            iArr[i11] = I;
        }
        return iArr;
    }

    public static t1.a[] d(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, t1.a[] aVarArr) throws IOException {
        byte[] bArr3 = t1.d.f12933f;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, t1.d.f12934g)) {
                throw new IllegalStateException("Unsupported meta version");
            }
            int I = (int) y.I(fileInputStream, 2);
            byte[] bArrH = y.H(fileInputStream, (int) y.I(fileInputStream, 4), (int) y.I(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                throw new IllegalStateException("Content found after the end of file");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrH);
            try {
                t1.a[] aVarArrF = f(byteArrayInputStream, bArr2, I, aVarArr);
                byteArrayInputStream.close();
                return aVarArrF;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(t1.d.f12928a, bArr2)) {
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (!Arrays.equals(bArr, bArr3)) {
            throw new IllegalStateException("Unsupported meta version");
        }
        int I2 = (int) y.I(fileInputStream, 1);
        byte[] bArrH2 = y.H(fileInputStream, (int) y.I(fileInputStream, 4), (int) y.I(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrH2);
        try {
            t1.a[] aVarArrE = e(byteArrayInputStream2, I2, aVarArr);
            byteArrayInputStream2.close();
            return aVarArrE;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static t1.a[] e(ByteArrayInputStream byteArrayInputStream, int i10, t1.a[] aVarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new t1.a[0];
        }
        if (i10 != aVarArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i10];
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int I = (int) y.I(byteArrayInputStream, 2);
            iArr[i11] = (int) y.I(byteArrayInputStream, 2);
            strArr[i11] = new String(y.G(byteArrayInputStream, I), StandardCharsets.UTF_8);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            t1.a aVar = aVarArr[i12];
            if (!aVar.f12920b.equals(strArr[i12])) {
                throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
            }
            int i13 = iArr[i12];
            aVar.f12923e = i13;
            aVar.h = c(byteArrayInputStream, i13);
        }
        return aVarArr;
    }

    public static t1.a[] f(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i10, t1.a[] aVarArr) throws IOException {
        if (byteArrayInputStream.available() == 0) {
            return new t1.a[0];
        }
        if (i10 != aVarArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            y.I(byteArrayInputStream, 2);
            String str = new String(y.G(byteArrayInputStream, (int) y.I(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long jI = y.I(byteArrayInputStream, 4);
            int I = (int) y.I(byteArrayInputStream, 2);
            t1.a aVar = null;
            if (aVarArr.length > 0) {
                int iIndexOf = str.indexOf("!");
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(":");
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                int i12 = 0;
                while (true) {
                    if (i12 >= aVarArr.length) {
                        break;
                    }
                    if (aVarArr[i12].f12920b.equals(strSubstring)) {
                        aVar = aVarArr[i12];
                        break;
                    }
                    i12++;
                }
            }
            if (aVar == null) {
                throw new IllegalStateException("Missing profile key: ".concat(str));
            }
            aVar.f12922d = jI;
            int[] iArrC = c(byteArrayInputStream, I);
            if (Arrays.equals(bArr, t1.d.f12932e)) {
                aVar.f12923e = I;
                aVar.h = iArrC;
            }
        }
        return aVarArr;
    }

    public static t1.a[] g(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, t1.d.f12929b)) {
            throw new IllegalStateException("Unsupported version");
        }
        int I = (int) y.I(fileInputStream, 1);
        byte[] bArrH = y.H(fileInputStream, (int) y.I(fileInputStream, 4), (int) y.I(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrH);
        try {
            t1.a[] aVarArrH = h(byteArrayInputStream, str, I);
            byteArrayInputStream.close();
            return aVarArrH;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static t1.a[] h(ByteArrayInputStream byteArrayInputStream, String str, int i10) throws IOException {
        int i11 = 0;
        if (byteArrayInputStream.available() == 0) {
            return new t1.a[0];
        }
        t1.a[] aVarArr = new t1.a[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            int I = (int) y.I(byteArrayInputStream, 2);
            int I2 = (int) y.I(byteArrayInputStream, 2);
            aVarArr[i12] = new t1.a(str, new String(y.G(byteArrayInputStream, I), StandardCharsets.UTF_8), y.I(byteArrayInputStream, 4), I2, (int) y.I(byteArrayInputStream, 4), (int) y.I(byteArrayInputStream, 4), new int[I2], new TreeMap());
        }
        int i13 = 0;
        while (i13 < i10) {
            t1.a aVar = aVarArr[i13];
            int iAvailable = byteArrayInputStream.available();
            int i14 = aVar.f12924f;
            int i15 = aVar.f12925g;
            TreeMap<Integer, Integer> treeMap = aVar.f12926i;
            int i16 = iAvailable - i14;
            int I3 = i11;
            while (byteArrayInputStream.available() > i16) {
                I3 += (int) y.I(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(I3), 1);
                int I4 = (int) y.I(byteArrayInputStream, 2);
                while (I4 > 0) {
                    y.I(byteArrayInputStream, 2);
                    int I5 = (int) y.I(byteArrayInputStream, 1);
                    if (I5 != 6 && I5 != 7) {
                        while (I5 > 0) {
                            y.I(byteArrayInputStream, 1);
                            int i17 = i11;
                            int i18 = i13;
                            for (int I6 = (int) y.I(byteArrayInputStream, 1); I6 > 0; I6--) {
                                y.I(byteArrayInputStream, 2);
                            }
                            I5--;
                            i11 = i17;
                            i13 = i18;
                        }
                    }
                    I4--;
                    i11 = i11;
                    i13 = i13;
                }
            }
            int i19 = i11;
            int i20 = i13;
            if (byteArrayInputStream.available() != i16) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            aVar.h = c(byteArrayInputStream, aVar.f12923e);
            BitSet bitSetValueOf = BitSet.valueOf(y.G(byteArrayInputStream, (((i15 * 2) + 7) & (-8)) / 8));
            for (int i21 = i19; i21 < i15; i21++) {
                int i22 = bitSetValueOf.get(i21) ? 2 : i19;
                if (bitSetValueOf.get(i21 + i15)) {
                    i22 |= 4;
                }
                if (i22 != 0) {
                    Integer numValueOf = treeMap.get(Integer.valueOf(i21));
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(i19);
                    }
                    treeMap.put(Integer.valueOf(i21), Integer.valueOf(i22 | numValueOf.intValue()));
                }
            }
            i13 = i20 + 1;
            i11 = i19;
        }
        return aVarArr;
    }

    /* JADX WARN: Finally extract failed */
    public static boolean i(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, t1.a[] aVarArr) throws IOException {
        ArrayList arrayList;
        int length;
        byte[] bArr2 = t1.d.f12928a;
        int i10 = 0;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = t1.d.f12929b;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] bArrA = a(aVarArr, bArr3);
                y.R(byteArrayOutputStream, aVarArr.length, 1);
                y.R(byteArrayOutputStream, bArrA.length, 4);
                byte[] bArrR = y.r(bArrA);
                y.R(byteArrayOutputStream, bArrR.length, 4);
                byteArrayOutputStream.write(bArrR);
                return true;
            }
            byte[] bArr4 = t1.d.f12931d;
            if (Arrays.equals(bArr, bArr4)) {
                y.R(byteArrayOutputStream, aVarArr.length, 1);
                for (t1.a aVar : aVarArr) {
                    int size = aVar.f12926i.size() * 4;
                    String strB = b(aVar.f12919a, bArr4, aVar.f12920b);
                    Charset charset = StandardCharsets.UTF_8;
                    y.S(byteArrayOutputStream, strB.getBytes(charset).length);
                    y.S(byteArrayOutputStream, aVar.h.length);
                    y.R(byteArrayOutputStream, size, 4);
                    y.R(byteArrayOutputStream, aVar.f12921c, 4);
                    byteArrayOutputStream.write(strB.getBytes(charset));
                    Iterator<Integer> it = aVar.f12926i.keySet().iterator();
                    while (it.hasNext()) {
                        y.S(byteArrayOutputStream, it.next().intValue());
                        y.S(byteArrayOutputStream, 0);
                    }
                    for (int i11 : aVar.h) {
                        y.S(byteArrayOutputStream, i11);
                    }
                }
                return true;
            }
            byte[] bArr5 = t1.d.f12930c;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] bArrA2 = a(aVarArr, bArr5);
                y.R(byteArrayOutputStream, aVarArr.length, 1);
                y.R(byteArrayOutputStream, bArrA2.length, 4);
                byte[] bArrR2 = y.r(bArrA2);
                y.R(byteArrayOutputStream, bArrR2.length, 4);
                byteArrayOutputStream.write(bArrR2);
                return true;
            }
            byte[] bArr6 = t1.d.f12932e;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            y.S(byteArrayOutputStream, aVarArr.length);
            for (t1.a aVar2 : aVarArr) {
                String str = aVar2.f12919a;
                TreeMap<Integer, Integer> treeMap = aVar2.f12926i;
                String strB2 = b(str, bArr6, aVar2.f12920b);
                Charset charset2 = StandardCharsets.UTF_8;
                y.S(byteArrayOutputStream, strB2.getBytes(charset2).length);
                y.S(byteArrayOutputStream, treeMap.size());
                y.S(byteArrayOutputStream, aVar2.h.length);
                y.R(byteArrayOutputStream, aVar2.f12921c, 4);
                byteArrayOutputStream.write(strB2.getBytes(charset2));
                Iterator<Integer> it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    y.S(byteArrayOutputStream, it2.next().intValue());
                }
                for (int i12 : aVar2.h) {
                    y.S(byteArrayOutputStream, i12);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            y.S(byteArrayOutputStream2, aVarArr.length);
            int i13 = 2;
            int i14 = 2;
            for (t1.a aVar3 : aVarArr) {
                y.R(byteArrayOutputStream2, aVar3.f12921c, 4);
                y.R(byteArrayOutputStream2, aVar3.f12922d, 4);
                y.R(byteArrayOutputStream2, aVar3.f12925g, 4);
                String strB3 = b(aVar3.f12919a, bArr2, aVar3.f12920b);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = strB3.getBytes(charset3).length;
                y.S(byteArrayOutputStream2, length2);
                i14 = i14 + 14 + length2;
                byteArrayOutputStream2.write(strB3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i14 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i14 + ", does not match actual size " + byteArray.length);
            }
            f fVar = new f(FileSectionType.f2441b, byteArray, false);
            byteArrayOutputStream2.close();
            arrayList2.add(fVar);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i15 = 0;
            for (int i16 = 0; i16 < aVarArr.length; i16++) {
                try {
                    t1.a aVar4 = aVarArr[i16];
                    y.S(byteArrayOutputStream3, i16);
                    y.S(byteArrayOutputStream3, aVar4.f12923e);
                    i15 = i15 + 4 + (aVar4.f12923e * i13);
                    int[] iArr = aVar4.h;
                    int length3 = iArr.length;
                    int i17 = 0;
                    int i18 = 0;
                    while (i17 < length3) {
                        int i19 = iArr[i17];
                        y.S(byteArrayOutputStream3, i19 - i18);
                        i17++;
                        i13 = i13;
                        i18 = i19;
                    }
                } catch (Throwable th) {
                }
            }
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i15 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i15 + ", does not match actual size " + byteArray2.length);
            }
            f fVar2 = new f(FileSectionType.f2442c, byteArray2, true);
            byteArrayOutputStream3.close();
            arrayList2.add(fVar2);
            byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i20 = 0;
            int i21 = 0;
            while (i20 < aVarArr.length) {
                try {
                    t1.a aVar5 = aVarArr[i20];
                    Iterator<Map.Entry<Integer, Integer>> it3 = aVar5.f12926i.entrySet().iterator();
                    int iIntValue = i10;
                    while (it3.hasNext()) {
                        iIntValue |= it3.next().getValue().intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    try {
                        l(byteArrayOutputStream4, iIntValue, aVar5);
                        byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                        byteArrayOutputStream4.close();
                        byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            m(byteArrayOutputStream4, aVar5);
                            byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                            byteArrayOutputStream4.close();
                            y.S(byteArrayOutputStream3, i20);
                            int length4 = byteArray3.length + 2 + byteArray4.length;
                            int i22 = i21 + 6;
                            ArrayList arrayList4 = arrayList3;
                            y.R(byteArrayOutputStream3, length4, 4);
                            y.S(byteArrayOutputStream3, iIntValue);
                            byteArrayOutputStream3.write(byteArray3);
                            byteArrayOutputStream3.write(byteArray4);
                            i21 = i22 + length4;
                            i20++;
                            arrayList3 = arrayList4;
                            i10 = 0;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
            if (i21 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i21 + ", does not match actual size " + byteArray5.length);
            }
            f fVar3 = new f(FileSectionType.f2443d, byteArray5, true);
            byteArrayOutputStream3.close();
            arrayList2.add(fVar3);
            long j10 = 4;
            long size2 = j10 + j10 + 4 + (arrayList2.size() * 16);
            y.R(byteArrayOutputStream, arrayList2.size(), 4);
            int i23 = 0;
            while (i23 < arrayList2.size()) {
                f fVar4 = (f) arrayList2.get(i23);
                FileSectionType fileSectionType = fVar4.f2464a;
                byte[] bArr7 = fVar4.f2465b;
                y.R(byteArrayOutputStream, fileSectionType.f2445a, 4);
                y.R(byteArrayOutputStream, size2, 4);
                if (fVar4.f2466c) {
                    long length5 = bArr7.length;
                    byte[] bArrR3 = y.r(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(bArrR3);
                    y.R(byteArrayOutputStream, bArrR3.length, 4);
                    y.R(byteArrayOutputStream, length5, 4);
                    length = bArrR3.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    y.R(byteArrayOutputStream, bArr7.length, 4);
                    y.R(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += length;
                i23++;
                arrayList5 = arrayList;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i24 = 0; i24 < arrayList6.size(); i24++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i24));
            }
            return true;
        } catch (Throwable th3) {
            try {
                byteArrayOutputStream2.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    public static void j(ByteArrayOutputStream byteArrayOutputStream, t1.a aVar) throws IOException {
        m(byteArrayOutputStream, aVar);
        int i10 = aVar.f12925g;
        int[] iArr = aVar.h;
        int length = iArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = iArr[i11];
            y.S(byteArrayOutputStream, i13 - i12);
            i11++;
            i12 = i13;
        }
        byte[] bArr = new byte[(((i10 * 2) + 7) & (-8)) / 8];
        for (Map.Entry<Integer, Integer> entry : aVar.f12926i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            if ((iIntValue2 & 2) != 0) {
                int i14 = iIntValue / 8;
                bArr[i14] = (byte) (bArr[i14] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i15 = iIntValue + i10;
                int i16 = i15 / 8;
                bArr[i16] = (byte) ((1 << (i15 % 8)) | bArr[i16]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void k(ByteArrayOutputStream byteArrayOutputStream, t1.a aVar, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        y.S(byteArrayOutputStream, str.getBytes(charset).length);
        y.S(byteArrayOutputStream, aVar.f12923e);
        y.R(byteArrayOutputStream, aVar.f12924f, 4);
        y.R(byteArrayOutputStream, aVar.f12921c, 4);
        y.R(byteArrayOutputStream, aVar.f12925g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void l(ByteArrayOutputStream byteArrayOutputStream, int i10, t1.a aVar) throws IOException {
        int i11 = aVar.f12925g;
        byte[] bArr = new byte[(((Integer.bitCount(i10 & (-2)) * i11) + 7) & (-8)) / 8];
        for (Map.Entry<Integer, Integer> entry : aVar.f12926i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            int i12 = 0;
            for (int i13 = 1; i13 <= 4; i13 <<= 1) {
                if (i13 != 1 && (i13 & i10) != 0) {
                    if ((i13 & iIntValue2) == i13) {
                        int i14 = (i12 * i11) + iIntValue;
                        int i15 = i14 / 8;
                        bArr[i15] = (byte) ((1 << (i14 % 8)) | bArr[i15]);
                    }
                    i12++;
                }
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void m(ByteArrayOutputStream byteArrayOutputStream, t1.a aVar) throws IOException {
        int i10 = 0;
        for (Map.Entry<Integer, Integer> entry : aVar.f12926i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                y.S(byteArrayOutputStream, iIntValue - i10);
                y.S(byteArrayOutputStream, 0);
                i10 = iIntValue;
            }
        }
    }
}
