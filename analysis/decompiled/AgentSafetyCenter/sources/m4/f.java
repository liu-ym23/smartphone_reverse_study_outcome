package m4;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.VarHandle;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f8.b f8217a = new f8.b(17);

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f8218b = {112, 114, 111, 0};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f8219c = {112, 114, 109, 0};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f8220d = {48, 49, 53, 0};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f8221e = {48, 49, 48, 0};

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f8222f = {48, 48, 57, 0};

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f8223g = {48, 48, 53, 0};

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f8224h = {48, 48, 49, 0};
    public static final byte[] i = {48, 48, 49, 0};

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f8225j = {48, 48, 50, 0};

    public static byte[] a(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static byte[] b(c[] cVarArr, byte[] bArr) throws IOException {
        int i3 = 0;
        int length = 0;
        for (c cVar : cVarArr) {
            length += ((((cVar.f8214g * 2) + 7) & (-8)) / 8) + (cVar.f8212e * 2) + d(cVar.f8208a, cVar.f8209b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + cVar.f8213f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, f8222f)) {
            int length2 = cVarArr.length;
            while (i3 < length2) {
                c cVar2 = cVarArr[i3];
                r(byteArrayOutputStream, cVar2, d(cVar2.f8208a, cVar2.f8209b, bArr));
                q(byteArrayOutputStream, cVar2);
                i3++;
            }
        } else {
            for (c cVar3 : cVarArr) {
                r(byteArrayOutputStream, cVar3, d(cVar3.f8208a, cVar3.f8209b, bArr));
            }
            int length3 = cVarArr.length;
            while (i3 < length3) {
                q(byteArrayOutputStream, cVarArr[i3]);
                i3++;
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + length);
    }

    public static boolean c(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z10 = true;
        for (File file2 : fileArrListFiles) {
            z10 = c(file2) && z10;
        }
        return z10;
    }

    public static String d(String str, String str2, byte[] bArr) {
        byte[] bArr2 = f8224h;
        boolean zEquals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = f8223g;
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
                return androidx.activity.b.n(w2.c.c(str), (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ":" : "!", str2);
            }
        }
        return str2;
    }

    public static void e(PackageInfo packageInfo, File file) throws IOException {
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

    public static byte[] f(InputStream inputStream, int i3) throws IOException {
        byte[] bArr = new byte[i3];
        int i10 = 0;
        while (i10 < i3) {
            int i11 = inputStream.read(bArr, i10, i3 - i10);
            if (i11 < 0) {
                od.f.e(k0.a.j(i3, "Not enough bytes to read: "));
                return null;
            }
            i10 += i11;
        }
        return bArr;
    }

    public static int[] g(ByteArrayInputStream byteArrayInputStream, int i3) {
        int[] iArr = new int[i3];
        int iM = 0;
        for (int i10 = 0; i10 < i3; i10++) {
            iM += (int) m(byteArrayInputStream, 2);
            iArr[i10] = iM;
        }
        return iArr;
    }

    public static byte[] h(FileInputStream fileInputStream, int i3, int i10) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i10];
            byte[] bArr2 = new byte[RecyclerView.ItemAnimator.FLAG_MOVED];
            int i11 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i11 < i3) {
                int i12 = fileInputStream.read(bArr2);
                if (i12 < 0) {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i3 + " bytes");
                }
                inflater.setInput(bArr2, 0, i12);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i10 - iInflate);
                    i11 += i12;
                } catch (DataFormatException e10) {
                    throw new IllegalStateException(e10.getMessage());
                }
            }
            if (i11 == i3) {
                if (inflater.finished()) {
                    return bArr;
                }
                throw new IllegalStateException("Inflater did not finish");
            }
            throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i3 + " actual=" + i11);
        } finally {
            inflater.end();
        }
    }

    public static c[] i(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, c[] cVarArr) throws IOException {
        byte[] bArr3 = i;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, f8225j)) {
                od.f.e("Unsupported meta version");
                return null;
            }
            int iM = (int) m(fileInputStream, 2);
            byte[] bArrH = h(fileInputStream, (int) m(fileInputStream, 4), (int) m(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                od.f.e("Content found after the end of file");
                return null;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrH);
            try {
                c[] cVarArrK = k(byteArrayInputStream, bArr2, iM, cVarArr);
                byteArrayInputStream.close();
                return cVarArrK;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(f8220d, bArr2)) {
            od.f.e("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            return null;
        }
        if (!Arrays.equals(bArr, bArr3)) {
            od.f.e("Unsupported meta version");
            return null;
        }
        int iM2 = (int) m(fileInputStream, 1);
        byte[] bArrH2 = h(fileInputStream, (int) m(fileInputStream, 4), (int) m(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            od.f.e("Content found after the end of file");
            return null;
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrH2);
        try {
            c[] cVarArrJ = j(byteArrayInputStream2, iM2, cVarArr);
            byteArrayInputStream2.close();
            return cVarArrJ;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static c[] j(ByteArrayInputStream byteArrayInputStream, int i3, c[] cVarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new c[0];
        }
        if (i3 != cVarArr.length) {
            od.f.e("Mismatched number of dex files found in metadata");
            return null;
        }
        String[] strArr = new String[i3];
        int[] iArr = new int[i3];
        for (int i10 = 0; i10 < i3; i10++) {
            int iM = (int) m(byteArrayInputStream, 2);
            iArr[i10] = (int) m(byteArrayInputStream, 2);
            strArr[i10] = new String(f(byteArrayInputStream, iM), StandardCharsets.UTF_8);
        }
        for (int i11 = 0; i11 < i3; i11++) {
            c cVar = cVarArr[i11];
            if (!cVar.f8209b.equals(strArr[i11])) {
                od.f.e("Order of dexfiles in metadata did not match baseline");
                return null;
            }
            int i12 = iArr[i11];
            cVar.f8212e = i12;
            cVar.f8215h = g(byteArrayInputStream, i12);
        }
        return cVarArr;
    }

    public static c[] k(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i3, c[] cVarArr) throws IOException {
        if (byteArrayInputStream.available() == 0) {
            return new c[0];
        }
        if (i3 != cVarArr.length) {
            od.f.e("Mismatched number of dex files found in metadata");
            return null;
        }
        for (int i10 = 0; i10 < i3; i10++) {
            m(byteArrayInputStream, 2);
            String str = new String(f(byteArrayInputStream, (int) m(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long jM = m(byteArrayInputStream, 4);
            int iM = (int) m(byteArrayInputStream, 2);
            c cVar = null;
            if (cVarArr.length > 0) {
                int iIndexOf = str.indexOf("!");
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(":");
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                int i11 = 0;
                while (true) {
                    if (i11 >= cVarArr.length) {
                        break;
                    }
                    if (cVarArr[i11].f8209b.equals(strSubstring)) {
                        cVar = cVarArr[i11];
                        break;
                    }
                    i11++;
                }
            }
            if (cVar == null) {
                od.f.e("Missing profile key: ".concat(str));
                return null;
            }
            cVar.f8211d = jM;
            int[] iArrG = g(byteArrayInputStream, iM);
            if (Arrays.equals(bArr, f8224h)) {
                cVar.f8212e = iM;
                cVar.f8215h = iArrG;
            }
        }
        return cVarArr;
    }

    public static c[] l(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, f8221e)) {
            od.f.e("Unsupported version");
            return null;
        }
        int iM = (int) m(fileInputStream, 1);
        byte[] bArrH = h(fileInputStream, (int) m(fileInputStream, 4), (int) m(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            od.f.e("Content found after the end of file");
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrH);
        try {
            c[] cVarArrN = n(byteArrayInputStream, str, iM);
            byteArrayInputStream.close();
            return cVarArrN;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long m(InputStream inputStream, int i3) throws IOException {
        byte[] bArrF = f(inputStream, i3);
        long j10 = 0;
        for (int i10 = 0; i10 < i3; i10++) {
            j10 += (bArrF[i10] & 255) << (i10 * 8);
        }
        return j10;
    }

    public static c[] n(ByteArrayInputStream byteArrayInputStream, String str, int i3) throws IOException {
        int i10 = 0;
        if (byteArrayInputStream.available() == 0) {
            return new c[0];
        }
        c[] cVarArr = new c[i3];
        for (int i11 = 0; i11 < i3; i11++) {
            int iM = (int) m(byteArrayInputStream, 2);
            int iM2 = (int) m(byteArrayInputStream, 2);
            long jM = m(byteArrayInputStream, 4);
            long jM2 = m(byteArrayInputStream, 4);
            long jM3 = m(byteArrayInputStream, 4);
            String str2 = new String(f(byteArrayInputStream, iM), StandardCharsets.UTF_8);
            int i12 = (int) jM;
            int i13 = (int) jM3;
            TreeMap treeMap = new TreeMap();
            c cVar = new c();
            cVar.f8208a = str;
            cVar.f8209b = str2;
            cVar.f8210c = jM2;
            cVar.f8211d = 0L;
            cVar.f8212e = iM2;
            cVar.f8213f = i12;
            cVar.f8214g = i13;
            cVar.f8215h = new int[iM2];
            cVar.i = treeMap;
            VarHandle.storeStoreFence();
            cVarArr[i11] = cVar;
        }
        int i14 = 0;
        while (i14 < i3) {
            c cVar2 = cVarArr[i14];
            int iAvailable = byteArrayInputStream.available();
            int i15 = cVar2.f8213f;
            int i16 = cVar2.f8214g;
            TreeMap treeMap2 = cVar2.i;
            int i17 = iAvailable - i15;
            int iM3 = i10;
            while (byteArrayInputStream.available() > i17) {
                iM3 += (int) m(byteArrayInputStream, 2);
                treeMap2.put(Integer.valueOf(iM3), 1);
                int iM4 = (int) m(byteArrayInputStream, 2);
                while (iM4 > 0) {
                    m(byteArrayInputStream, 2);
                    int iM5 = (int) m(byteArrayInputStream, 1);
                    if (iM5 != 6 && iM5 != 7) {
                        while (iM5 > 0) {
                            m(byteArrayInputStream, 1);
                            int i18 = i10;
                            int i19 = i14;
                            for (int iM6 = (int) m(byteArrayInputStream, 1); iM6 > 0; iM6--) {
                                m(byteArrayInputStream, 2);
                            }
                            iM5--;
                            i14 = i19;
                            i10 = i18;
                        }
                    }
                    iM4--;
                    i14 = i14;
                    i10 = i10;
                }
            }
            int i20 = i10;
            int i21 = i14;
            if (byteArrayInputStream.available() != i17) {
                od.f.e("Read too much data during profile line parse");
                return null;
            }
            cVar2.f8215h = g(byteArrayInputStream, cVar2.f8212e);
            BitSet bitSetValueOf = BitSet.valueOf(f(byteArrayInputStream, (((i16 * 2) + 7) & (-8)) / 8));
            for (int i22 = i20; i22 < i16; i22++) {
                int i23 = bitSetValueOf.get(i22) ? 2 : i20;
                if (bitSetValueOf.get(i22 + i16)) {
                    i23 |= 4;
                }
                if (i23 != 0) {
                    Integer numValueOf = (Integer) treeMap2.get(Integer.valueOf(i22));
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(i20);
                    }
                    treeMap2.put(Integer.valueOf(i22), Integer.valueOf(i23 | numValueOf.intValue()));
                }
            }
            i14 = i21 + 1;
            i10 = i20;
        }
        return cVarArr;
    }

    public static void o(Executor executor, a1.g gVar, int i3, PackageManager.NameNotFoundException nameNotFoundException) {
        a aVar = new a(1);
        aVar.f8200h = gVar;
        aVar.f8198f = i3;
        aVar.f8199g = nameNotFoundException;
        VarHandle.storeStoreFence();
        executor.execute(aVar);
    }

    /* JADX WARN: Finally extract failed */
    public static boolean p(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, c[] cVarArr) throws IOException {
        long j10;
        ArrayList arrayList;
        int length;
        byte[] bArr2 = f8220d;
        int i3 = 0;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = f8221e;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] bArrB = b(cVarArr, bArr3);
                v(byteArrayOutputStream, cVarArr.length, 1);
                v(byteArrayOutputStream, bArrB.length, 4);
                byte[] bArrA = a(bArrB);
                v(byteArrayOutputStream, bArrA.length, 4);
                byteArrayOutputStream.write(bArrA);
                return true;
            }
            byte[] bArr4 = f8223g;
            if (Arrays.equals(bArr, bArr4)) {
                v(byteArrayOutputStream, cVarArr.length, 1);
                for (c cVar : cVarArr) {
                    int size = cVar.i.size() * 4;
                    String strD = d(cVar.f8208a, cVar.f8209b, bArr4);
                    Charset charset = StandardCharsets.UTF_8;
                    w(byteArrayOutputStream, strD.getBytes(charset).length);
                    w(byteArrayOutputStream, cVar.f8215h.length);
                    v(byteArrayOutputStream, size, 4);
                    v(byteArrayOutputStream, cVar.f8210c, 4);
                    byteArrayOutputStream.write(strD.getBytes(charset));
                    Iterator it = cVar.i.keySet().iterator();
                    while (it.hasNext()) {
                        w(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        w(byteArrayOutputStream, 0);
                    }
                    for (int i10 : cVar.f8215h) {
                        w(byteArrayOutputStream, i10);
                    }
                }
                return true;
            }
            byte[] bArr5 = f8222f;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] bArrB2 = b(cVarArr, bArr5);
                v(byteArrayOutputStream, cVarArr.length, 1);
                v(byteArrayOutputStream, bArrB2.length, 4);
                byte[] bArrA2 = a(bArrB2);
                v(byteArrayOutputStream, bArrA2.length, 4);
                byteArrayOutputStream.write(bArrA2);
                return true;
            }
            byte[] bArr6 = f8224h;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            w(byteArrayOutputStream, cVarArr.length);
            for (c cVar2 : cVarArr) {
                String str = cVar2.f8208a;
                TreeMap treeMap = cVar2.i;
                String strD2 = d(str, cVar2.f8209b, bArr6);
                Charset charset2 = StandardCharsets.UTF_8;
                w(byteArrayOutputStream, strD2.getBytes(charset2).length);
                w(byteArrayOutputStream, treeMap.size());
                w(byteArrayOutputStream, cVar2.f8215h.length);
                v(byteArrayOutputStream, cVar2.f8210c, 4);
                byteArrayOutputStream.write(strD2.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    w(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i11 : cVar2.f8215h) {
                    w(byteArrayOutputStream, i11);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            w(byteArrayOutputStream2, cVarArr.length);
            int i12 = 2;
            int i13 = 2;
            for (c cVar3 : cVarArr) {
                v(byteArrayOutputStream2, cVar3.f8210c, 4);
                v(byteArrayOutputStream2, cVar3.f8211d, 4);
                v(byteArrayOutputStream2, cVar3.f8214g, 4);
                String strD3 = d(cVar3.f8208a, cVar3.f8209b, bArr2);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = strD3.getBytes(charset3).length;
                w(byteArrayOutputStream2, length2);
                i13 = i13 + 14 + length2;
                byteArrayOutputStream2.write(strD3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i13 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i13 + ", does not match actual size " + byteArray.length);
            }
            j jVar = new j(1, byteArray, false);
            byteArrayOutputStream2.close();
            arrayList2.add(jVar);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i14 = 0;
            int i15 = 0;
            while (i14 < cVarArr.length) {
                try {
                    c cVar4 = cVarArr[i14];
                    w(byteArrayOutputStream3, i14);
                    w(byteArrayOutputStream3, cVar4.f8212e);
                    i15 = i15 + 4 + (cVar4.f8212e * i12);
                    int[] iArr = cVar4.f8215h;
                    int length3 = iArr.length;
                    int i16 = i3;
                    int i17 = i12;
                    int i18 = i16;
                    while (i18 < length3) {
                        int i19 = iArr[i18];
                        w(byteArrayOutputStream3, i19 - i16);
                        i18++;
                        i16 = i19;
                    }
                    i14++;
                    i12 = i17;
                    i3 = 0;
                } catch (Throwable th) {
                }
            }
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i15 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i15 + ", does not match actual size " + byteArray2.length);
            }
            j jVar2 = new j(3, byteArray2, true);
            byteArrayOutputStream3.close();
            arrayList2.add(jVar2);
            byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i20 = 0;
            int i21 = 0;
            while (i20 < cVarArr.length) {
                try {
                    c cVar5 = cVarArr[i20];
                    Iterator it3 = cVar5.i.entrySet().iterator();
                    int iIntValue = 0;
                    while (it3.hasNext()) {
                        iIntValue |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    try {
                        s(byteArrayOutputStream4, iIntValue, cVar5);
                        byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                        byteArrayOutputStream4.close();
                        byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            t(byteArrayOutputStream4, cVar5);
                            byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                            byteArrayOutputStream4.close();
                            w(byteArrayOutputStream3, i20);
                            int length4 = byteArray3.length + 2 + byteArray4.length;
                            int i22 = i21 + 6;
                            ArrayList arrayList4 = arrayList3;
                            v(byteArrayOutputStream3, length4, 4);
                            w(byteArrayOutputStream3, iIntValue);
                            byteArrayOutputStream3.write(byteArray3);
                            byteArrayOutputStream3.write(byteArray4);
                            i21 = i22 + length4;
                            i20++;
                            arrayList3 = arrayList4;
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
            j jVar3 = new j(4, byteArray5, true);
            byteArrayOutputStream3.close();
            arrayList2.add(jVar3);
            long j11 = 4;
            long size2 = j11 + j11 + 4 + (arrayList2.size() * 16);
            v(byteArrayOutputStream, arrayList2.size(), 4);
            int i23 = 0;
            while (i23 < arrayList2.size()) {
                j jVar4 = (j) arrayList2.get(i23);
                int i24 = jVar4.f8235a;
                byte[] bArr7 = jVar4.f8236b;
                if (i24 == 1) {
                    j10 = 0;
                } else if (i24 == 2) {
                    j10 = 1;
                } else if (i24 == 3) {
                    j10 = 2;
                } else if (i24 == 4) {
                    j10 = 3;
                } else {
                    if (i24 != 5) {
                        throw null;
                    }
                    j10 = 4;
                }
                v(byteArrayOutputStream, j10, 4);
                v(byteArrayOutputStream, size2, 4);
                if (jVar4.f8237c) {
                    long length5 = bArr7.length;
                    byte[] bArrA3 = a(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(bArrA3);
                    v(byteArrayOutputStream, bArrA3.length, 4);
                    v(byteArrayOutputStream, length5, 4);
                    length = bArrA3.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    v(byteArrayOutputStream, bArr7.length, 4);
                    v(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += length;
                i23++;
                arrayList5 = arrayList;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i25 = 0; i25 < arrayList6.size(); i25++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i25));
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

    public static void q(ByteArrayOutputStream byteArrayOutputStream, c cVar) throws IOException {
        t(byteArrayOutputStream, cVar);
        int i3 = cVar.f8214g;
        int[] iArr = cVar.f8215h;
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = iArr[i10];
            w(byteArrayOutputStream, i12 - i11);
            i10++;
            i11 = i12;
        }
        byte[] bArr = new byte[(((i3 * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : cVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                int i13 = iIntValue / 8;
                bArr[i13] = (byte) (bArr[i13] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i14 = iIntValue + i3;
                int i15 = i14 / 8;
                bArr[i15] = (byte) ((1 << (i14 % 8)) | bArr[i15]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void r(ByteArrayOutputStream byteArrayOutputStream, c cVar, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        w(byteArrayOutputStream, str.getBytes(charset).length);
        w(byteArrayOutputStream, cVar.f8212e);
        v(byteArrayOutputStream, cVar.f8213f, 4);
        v(byteArrayOutputStream, cVar.f8210c, 4);
        v(byteArrayOutputStream, cVar.f8214g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void s(ByteArrayOutputStream byteArrayOutputStream, int i3, c cVar) throws IOException {
        int i10 = cVar.f8214g;
        byte[] bArr = new byte[(((Integer.bitCount(i3 & (-2)) * i10) + 7) & (-8)) / 8];
        for (Map.Entry entry : cVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            int i11 = 0;
            for (int i12 = 1; i12 <= 4; i12 <<= 1) {
                if (i12 != 1 && (i12 & i3) != 0) {
                    if ((i12 & iIntValue2) == i12) {
                        int i13 = (i11 * i10) + iIntValue;
                        int i14 = i13 / 8;
                        bArr[i14] = (byte) ((1 << (i13 % 8)) | bArr[i14]);
                    }
                    i11++;
                }
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void t(ByteArrayOutputStream byteArrayOutputStream, c cVar) throws IOException {
        int i3 = 0;
        for (Map.Entry entry : cVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                w(byteArrayOutputStream, iIntValue - i3);
                w(byteArrayOutputStream, 0);
                i3 = iIntValue;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void u(android.content.Context r16, java.util.concurrent.Executor r17, m4.e r18, boolean r19) throws android.content.pm.PackageManager.NameNotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.f.u(android.content.Context, java.util.concurrent.Executor, m4.e, boolean):void");
    }

    public static void v(ByteArrayOutputStream byteArrayOutputStream, long j10, int i3) throws IOException {
        byte[] bArr = new byte[i3];
        for (int i10 = 0; i10 < i3; i10++) {
            bArr[i10] = (byte) ((j10 >> (i10 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void w(ByteArrayOutputStream byteArrayOutputStream, int i3) throws IOException {
        v(byteArrayOutputStream, i3, 2);
    }
}
