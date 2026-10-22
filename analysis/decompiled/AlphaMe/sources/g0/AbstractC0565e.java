package g0;

import android.content.pm.PackageInfo;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import t0.J;

/* renamed from: g0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0565e {

    /* renamed from: a, reason: collision with root package name */
    public static final E3.b f12635a = new E3.b(1);

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f12636b = {112, 114, 111, 0};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f12637c = {112, 114, 109, 0};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f12638d = {48, 49, 53, 0};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f12639e = {48, 49, 48, 0};

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f12640f = {48, 48, 57, 0};

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f12641g = {48, 48, 53, 0};

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f12642h = {48, 48, 49, 0};

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f12643i = {48, 48, 49, 0};

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f12644j = {48, 48, 50, 0};

    public static byte[] a(C0563c[] c0563cArr, byte[] bArr) throws IOException {
        int length = 0;
        for (C0563c c0563c : c0563cArr) {
            length += ((((c0563c.f12632g * 2) + 7) & (-8)) / 8) + (c0563c.f12630e * 2) + b(c0563c.f12626a, c0563c.f12627b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + c0563c.f12631f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, f12640f)) {
            for (C0563c c0563c2 : c0563cArr) {
                l(byteArrayOutputStream, c0563c2, b(c0563c2.f12626a, c0563c2.f12627b, bArr));
                n(byteArrayOutputStream, c0563c2);
                int[] iArr = c0563c2.f12633h;
                int length2 = iArr.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length2) {
                    int i6 = iArr[i4];
                    J.Y(byteArrayOutputStream, i6 - i5);
                    i4++;
                    i5 = i6;
                }
                m(byteArrayOutputStream, c0563c2);
            }
        } else {
            for (C0563c c0563c3 : c0563cArr) {
                l(byteArrayOutputStream, c0563c3, b(c0563c3.f12626a, c0563c3.f12627b, bArr));
            }
            for (C0563c c0563c4 : c0563cArr) {
                n(byteArrayOutputStream, c0563c4);
                int[] iArr2 = c0563c4.f12633h;
                int length3 = iArr2.length;
                int i7 = 0;
                int i8 = 0;
                while (i7 < length3) {
                    int i9 = iArr2[i7];
                    J.Y(byteArrayOutputStream, i9 - i8);
                    i7++;
                    i8 = i9;
                }
                m(byteArrayOutputStream, c0563c4);
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + length);
    }

    public static String b(String str, String str2, byte[] bArr) {
        byte[] bArr2 = f12642h;
        boolean zEquals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = f12641g;
        Object obj = (zEquals || Arrays.equals(bArr, bArr3)) ? AwarenessDataItem.USERID_SPLITTER : "!";
        if (str.length() <= 0) {
            return "!".equals(obj) ? str2.replace(AwarenessDataItem.USERID_SPLITTER, "!") : AwarenessDataItem.USERID_SPLITTER.equals(obj) ? str2.replace("!", AwarenessDataItem.USERID_SPLITTER) : str2;
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(AwarenessDataItem.USERID_SPLITTER)) {
            return "!".equals(obj) ? str2.replace(AwarenessDataItem.USERID_SPLITTER, "!") : AwarenessDataItem.USERID_SPLITTER.equals(obj) ? str2.replace("!", AwarenessDataItem.USERID_SPLITTER) : str2;
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return B0.g.r(B0.g.s(str), (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? AwarenessDataItem.USERID_SPLITTER : "!", str2);
    }

    public static int c(int i4, int i5, int i6) {
        if (i4 == 1) {
            throw new IllegalStateException("HOT methods are not stored in the bitmap");
        }
        if (i4 == 2) {
            return i5;
        }
        if (i4 == 4) {
            return i5 + i6;
        }
        throw new IllegalStateException(AbstractC0351g.m("Unexpected flag: ", i4));
    }

    public static void d(PackageInfo packageInfo, File file) throws IOException {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static int[] e(ByteArrayInputStream byteArrayInputStream, int i4) {
        int[] iArr = new int[i4];
        int iL = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            iL += (int) J.L(byteArrayInputStream, 2);
            iArr[i5] = iL;
        }
        return iArr;
    }

    public static C0563c[] f(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, C0563c[] c0563cArr) throws IOException {
        byte[] bArr3 = f12643i;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, f12644j)) {
                throw new IllegalStateException("Unsupported meta version");
            }
            int iL = (int) J.L(fileInputStream, 2);
            byte[] bArrK = J.K(fileInputStream, (int) J.L(fileInputStream, 4), (int) J.L(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                throw new IllegalStateException("Content found after the end of file");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrK);
            try {
                C0563c[] c0563cArrH = h(byteArrayInputStream, bArr2, iL, c0563cArr);
                byteArrayInputStream.close();
                return c0563cArrH;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(f12638d, bArr2)) {
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (!Arrays.equals(bArr, bArr3)) {
            throw new IllegalStateException("Unsupported meta version");
        }
        int iL2 = (int) J.L(fileInputStream, 1);
        byte[] bArrK2 = J.K(fileInputStream, (int) J.L(fileInputStream, 4), (int) J.L(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrK2);
        try {
            C0563c[] c0563cArrG = g(byteArrayInputStream2, iL2, c0563cArr);
            byteArrayInputStream2.close();
            return c0563cArrG;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static C0563c[] g(ByteArrayInputStream byteArrayInputStream, int i4, C0563c[] c0563cArr) {
        if (byteArrayInputStream.available() == 0) {
            return new C0563c[0];
        }
        if (i4 != c0563cArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i4];
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int iL = (int) J.L(byteArrayInputStream, 2);
            iArr[i5] = (int) J.L(byteArrayInputStream, 2);
            strArr[i5] = new String(J.I(byteArrayInputStream, iL), StandardCharsets.UTF_8);
        }
        for (int i6 = 0; i6 < i4; i6++) {
            C0563c c0563c = c0563cArr[i6];
            if (!c0563c.f12627b.equals(strArr[i6])) {
                throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
            }
            int i7 = iArr[i6];
            c0563c.f12630e = i7;
            c0563c.f12633h = e(byteArrayInputStream, i7);
        }
        return c0563cArr;
    }

    public static C0563c[] h(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i4, C0563c[] c0563cArr) throws IOException {
        if (byteArrayInputStream.available() == 0) {
            return new C0563c[0];
        }
        if (i4 != c0563cArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            J.L(byteArrayInputStream, 2);
            String str = new String(J.I(byteArrayInputStream, (int) J.L(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long jL = J.L(byteArrayInputStream, 4);
            int iL = (int) J.L(byteArrayInputStream, 2);
            C0563c c0563c = null;
            if (c0563cArr.length > 0) {
                int iIndexOf = str.indexOf("!");
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(AwarenessDataItem.USERID_SPLITTER);
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                int i6 = 0;
                while (true) {
                    if (i6 >= c0563cArr.length) {
                        break;
                    }
                    if (c0563cArr[i6].f12627b.equals(strSubstring)) {
                        c0563c = c0563cArr[i6];
                        break;
                    }
                    i6++;
                }
            }
            if (c0563c == null) {
                throw new IllegalStateException("Missing profile key: ".concat(str));
            }
            c0563c.f12629d = jL;
            int[] iArrE = e(byteArrayInputStream, iL);
            if (Arrays.equals(bArr, f12642h)) {
                c0563c.f12630e = iL;
                c0563c.f12633h = iArrE;
            }
        }
        return c0563cArr;
    }

    public static C0563c[] i(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, f12639e)) {
            throw new IllegalStateException("Unsupported version");
        }
        int iL = (int) J.L(fileInputStream, 1);
        byte[] bArrK = J.K(fileInputStream, (int) J.L(fileInputStream, 4), (int) J.L(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrK);
        try {
            C0563c[] c0563cArrJ = j(byteArrayInputStream, str, iL);
            byteArrayInputStream.close();
            return c0563cArrJ;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C0563c[] j(ByteArrayInputStream byteArrayInputStream, String str, int i4) throws IOException {
        TreeMap treeMap;
        if (byteArrayInputStream.available() == 0) {
            return new C0563c[0];
        }
        C0563c[] c0563cArr = new C0563c[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int iL = (int) J.L(byteArrayInputStream, 2);
            int iL2 = (int) J.L(byteArrayInputStream, 2);
            c0563cArr[i5] = new C0563c(str, new String(J.I(byteArrayInputStream, iL), StandardCharsets.UTF_8), J.L(byteArrayInputStream, 4), iL2, (int) J.L(byteArrayInputStream, 4), (int) J.L(byteArrayInputStream, 4), new int[iL2], new TreeMap());
        }
        for (int i6 = 0; i6 < i4; i6++) {
            C0563c c0563c = c0563cArr[i6];
            int iAvailable = byteArrayInputStream.available() - c0563c.f12631f;
            int iL3 = 0;
            while (true) {
                int iAvailable2 = byteArrayInputStream.available();
                treeMap = c0563c.f12634i;
                if (iAvailable2 <= iAvailable) {
                    break;
                }
                iL3 += (int) J.L(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(iL3), 1);
                for (int iL4 = (int) J.L(byteArrayInputStream, 2); iL4 > 0; iL4--) {
                    J.L(byteArrayInputStream, 2);
                    int iL5 = (int) J.L(byteArrayInputStream, 1);
                    if (iL5 != 6 && iL5 != 7) {
                        while (iL5 > 0) {
                            J.L(byteArrayInputStream, 1);
                            for (int iL6 = (int) J.L(byteArrayInputStream, 1); iL6 > 0; iL6--) {
                                J.L(byteArrayInputStream, 2);
                            }
                            iL5--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() != iAvailable) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            c0563c.f12633h = e(byteArrayInputStream, c0563c.f12630e);
            int i7 = c0563c.f12632g;
            BitSet bitSetValueOf = BitSet.valueOf(J.I(byteArrayInputStream, (((i7 * 2) + 7) & (-8)) / 8));
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = bitSetValueOf.get(c(2, i8, i7)) ? 2 : 0;
                if (bitSetValueOf.get(c(4, i8, i7))) {
                    i9 |= 4;
                }
                if (i9 != 0) {
                    Integer num = (Integer) treeMap.get(Integer.valueOf(i8));
                    if (num == null) {
                        num = 0;
                    }
                    treeMap.put(Integer.valueOf(i8), Integer.valueOf(i9 | num.intValue()));
                }
            }
        }
        return c0563cArr;
    }

    /* JADX WARN: Finally extract failed */
    public static boolean k(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, C0563c[] c0563cArr) throws IOException {
        ArrayList arrayList;
        int length;
        byte[] bArr2 = f12638d;
        int i4 = 0;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = f12639e;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] bArrA = a(c0563cArr, bArr3);
                J.X(byteArrayOutputStream, c0563cArr.length, 1);
                J.X(byteArrayOutputStream, bArrA.length, 4);
                byte[] bArrM = J.m(bArrA);
                J.X(byteArrayOutputStream, bArrM.length, 4);
                byteArrayOutputStream.write(bArrM);
                return true;
            }
            byte[] bArr4 = f12641g;
            if (Arrays.equals(bArr, bArr4)) {
                J.X(byteArrayOutputStream, c0563cArr.length, 1);
                for (C0563c c0563c : c0563cArr) {
                    int size = c0563c.f12634i.size() * 4;
                    String strB = b(c0563c.f12626a, c0563c.f12627b, bArr4);
                    Charset charset = StandardCharsets.UTF_8;
                    J.Y(byteArrayOutputStream, strB.getBytes(charset).length);
                    J.Y(byteArrayOutputStream, c0563c.f12633h.length);
                    J.X(byteArrayOutputStream, size, 4);
                    J.X(byteArrayOutputStream, c0563c.f12628c, 4);
                    byteArrayOutputStream.write(strB.getBytes(charset));
                    Iterator it = c0563c.f12634i.keySet().iterator();
                    while (it.hasNext()) {
                        J.Y(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        J.Y(byteArrayOutputStream, 0);
                    }
                    for (int i5 : c0563c.f12633h) {
                        J.Y(byteArrayOutputStream, i5);
                    }
                }
                return true;
            }
            byte[] bArr5 = f12640f;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] bArrA2 = a(c0563cArr, bArr5);
                J.X(byteArrayOutputStream, c0563cArr.length, 1);
                J.X(byteArrayOutputStream, bArrA2.length, 4);
                byte[] bArrM2 = J.m(bArrA2);
                J.X(byteArrayOutputStream, bArrM2.length, 4);
                byteArrayOutputStream.write(bArrM2);
                return true;
            }
            byte[] bArr6 = f12642h;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            J.Y(byteArrayOutputStream, c0563cArr.length);
            for (C0563c c0563c2 : c0563cArr) {
                String strB2 = b(c0563c2.f12626a, c0563c2.f12627b, bArr6);
                Charset charset2 = StandardCharsets.UTF_8;
                J.Y(byteArrayOutputStream, strB2.getBytes(charset2).length);
                TreeMap treeMap = c0563c2.f12634i;
                J.Y(byteArrayOutputStream, treeMap.size());
                J.Y(byteArrayOutputStream, c0563c2.f12633h.length);
                J.X(byteArrayOutputStream, c0563c2.f12628c, 4);
                byteArrayOutputStream.write(strB2.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    J.Y(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i6 : c0563c2.f12633h) {
                    J.Y(byteArrayOutputStream, i6);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            J.Y(byteArrayOutputStream2, c0563cArr.length);
            int i7 = 2;
            int i8 = 2;
            for (C0563c c0563c3 : c0563cArr) {
                J.X(byteArrayOutputStream2, c0563c3.f12628c, 4);
                J.X(byteArrayOutputStream2, c0563c3.f12629d, 4);
                J.X(byteArrayOutputStream2, c0563c3.f12632g, 4);
                String strB3 = b(c0563c3.f12626a, c0563c3.f12627b, bArr2);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = strB3.getBytes(charset3).length;
                J.Y(byteArrayOutputStream2, length2);
                i8 = i8 + 14 + length2;
                byteArrayOutputStream2.write(strB3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i8 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i8 + ", does not match actual size " + byteArray.length);
            }
            C0572l c0572l = new C0572l(1, byteArray, false);
            byteArrayOutputStream2.close();
            arrayList2.add(c0572l);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i9 = 0;
            int i10 = 0;
            while (i9 < c0563cArr.length) {
                try {
                    C0563c c0563c4 = c0563cArr[i9];
                    J.Y(byteArrayOutputStream3, i9);
                    J.Y(byteArrayOutputStream3, c0563c4.f12630e);
                    i10 = i10 + 4 + (c0563c4.f12630e * 2);
                    int[] iArr = c0563c4.f12633h;
                    int length3 = iArr.length;
                    int i11 = i4;
                    while (i4 < length3) {
                        int i12 = iArr[i4];
                        J.Y(byteArrayOutputStream3, i12 - i11);
                        i4++;
                        i11 = i12;
                    }
                    i9++;
                    i4 = 0;
                } catch (Throwable th) {
                }
            }
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i10 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i10 + ", does not match actual size " + byteArray2.length);
            }
            C0572l c0572l2 = new C0572l(3, byteArray2, true);
            byteArrayOutputStream3.close();
            arrayList2.add(c0572l2);
            byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i13 = 0;
            int i14 = 0;
            while (i13 < c0563cArr.length) {
                try {
                    C0563c c0563c5 = c0563cArr[i13];
                    Iterator it3 = c0563c5.f12634i.entrySet().iterator();
                    int iIntValue = 0;
                    while (it3.hasNext()) {
                        iIntValue |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    try {
                        m(byteArrayOutputStream4, c0563c5);
                        byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                        byteArrayOutputStream4.close();
                        byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            n(byteArrayOutputStream4, c0563c5);
                            byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                            byteArrayOutputStream4.close();
                            J.Y(byteArrayOutputStream3, i13);
                            int length4 = byteArray3.length + i7 + byteArray4.length;
                            int i15 = i14 + 6;
                            ArrayList arrayList4 = arrayList3;
                            J.X(byteArrayOutputStream3, length4, 4);
                            J.Y(byteArrayOutputStream3, iIntValue);
                            byteArrayOutputStream3.write(byteArray3);
                            byteArrayOutputStream3.write(byteArray4);
                            i14 = i15 + length4;
                            i13++;
                            arrayList3 = arrayList4;
                            i7 = 2;
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
            if (i14 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i14 + ", does not match actual size " + byteArray5.length);
            }
            C0572l c0572l3 = new C0572l(4, byteArray5, true);
            byteArrayOutputStream3.close();
            arrayList2.add(c0572l3);
            long j4 = 4;
            long size2 = j4 + j4 + 4 + (arrayList2.size() * 16);
            int i16 = 4;
            J.X(byteArrayOutputStream, arrayList2.size(), 4);
            int i17 = 0;
            while (i17 < arrayList2.size()) {
                C0572l c0572l4 = (C0572l) arrayList2.get(i17);
                J.X(byteArrayOutputStream, AbstractC0351g.a(c0572l4.f12654a), i16);
                J.X(byteArrayOutputStream, size2, i16);
                boolean z4 = c0572l4.f12656c;
                byte[] bArr7 = c0572l4.f12655b;
                if (z4) {
                    long length5 = bArr7.length;
                    byte[] bArrM3 = J.m(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(bArrM3);
                    J.X(byteArrayOutputStream, bArrM3.length, 4);
                    J.X(byteArrayOutputStream, length5, 4);
                    length = bArrM3.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    J.X(byteArrayOutputStream, bArr7.length, 4);
                    J.X(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += length;
                i17++;
                arrayList5 = arrayList;
                i16 = 4;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i18 = 0; i18 < arrayList6.size(); i18++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i18));
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

    public static void l(ByteArrayOutputStream byteArrayOutputStream, C0563c c0563c, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        J.Y(byteArrayOutputStream, str.getBytes(charset).length);
        J.Y(byteArrayOutputStream, c0563c.f12630e);
        J.X(byteArrayOutputStream, c0563c.f12631f, 4);
        J.X(byteArrayOutputStream, c0563c.f12628c, 4);
        J.X(byteArrayOutputStream, c0563c.f12632g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void m(ByteArrayOutputStream byteArrayOutputStream, C0563c c0563c) throws IOException {
        byte[] bArr = new byte[(((c0563c.f12632g * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : c0563c.f12634i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            int i4 = iIntValue2 & 2;
            int i5 = c0563c.f12632g;
            if (i4 != 0) {
                int iC = c(2, iIntValue, i5);
                int i6 = iC / 8;
                bArr[i6] = (byte) ((1 << (iC % 8)) | bArr[i6]);
            }
            if ((iIntValue2 & 4) != 0) {
                int iC2 = c(4, iIntValue, i5);
                int i7 = iC2 / 8;
                bArr[i7] = (byte) ((1 << (iC2 % 8)) | bArr[i7]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void n(ByteArrayOutputStream byteArrayOutputStream, C0563c c0563c) throws IOException {
        int i4 = 0;
        for (Map.Entry entry : c0563c.f12634i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                J.Y(byteArrayOutputStream, iIntValue - i4);
                J.Y(byteArrayOutputStream, 0);
                i4 = iIntValue;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01c2 A[PHI: r6
      0x01c2: PHI (r6v8 ??) = (r6v7 ??), (r6v30 ?? I:??[int, float, short, byte, char]), (r6v25 ??), (r6v24 ??) binds: [B:86:0x015b, B:88:0x0161, B:124:0x01bf, B:92:0x0169] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0294 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015d  */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void o(android.content.Context r19, l.ExecutorC0743a r20, g0.InterfaceC0564d r21, boolean r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.AbstractC0565e.o(android.content.Context, l.a, g0.d, boolean):void");
    }
}
