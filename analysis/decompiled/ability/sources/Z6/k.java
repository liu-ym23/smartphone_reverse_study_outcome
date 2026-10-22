package Z6;

import D7.D;
import D7.E;
import D7.s;
import D7.v;
import D7.w;
import D9.t;
import X8.A;
import a.AbstractC0291a;
import a7.AbstractC0307c;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import c7.C0881a;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.fasterxml.jackson.core.JsonPointer;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.model.object.CopyEvent;
import com.volcengine.tos.model.object.CopyEventListener;
import com.volcengine.tos.model.object.DownloadEvent;
import com.volcengine.tos.model.object.DownloadEventListener;
import com.volcengine.tos.model.object.UploadEvent;
import com.volcengine.tos.model.object.UploadEventListener;
import f8.C1442c;
import f8.C1444e;
import h8.AbstractC1532o;
import h8.InterfaceC1503K;
import h8.InterfaceC1507O;
import h8.InterfaceC1523f;
import i8.C1560f;
import i8.InterfaceC1561g;
import j9.m;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import k8.Q;
import k8.u;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlinx.coroutines.channels.BufferOverflow;
import m8.C1682b;
import o9.C1778d;
import o9.C1784j;
import o9.InterfaceC1779e;
import org.json.JSONException;
import org.json.JSONObject;
import t8.C2024a;
import t8.InterfaceC2028e;
import u1.C2031a;

/* loaded from: classes3.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static long f1608a = -1;
    public static String c = null;
    public static Field d = null;
    public static Field e = null;
    public static String f = "https://";
    public static G0.a b = new M0.h(2);
    public static final x.d g = new x.d(0);

    public static final int D(int i, int i6, int i10) {
        if (i10 > 0) {
            if (i < i6) {
                int i11 = i6 % i10;
                if (i11 < 0) {
                    i11 += i10;
                }
                int i12 = i % i10;
                if (i12 < 0) {
                    i12 += i10;
                }
                int i13 = (i11 - i12) % i10;
                if (i13 < 0) {
                    i13 += i10;
                }
                return i6 - i13;
            }
        } else {
            if (i10 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i > i6) {
                int i14 = -i10;
                int i15 = i % i14;
                if (i15 < 0) {
                    i15 += i14;
                }
                int i16 = i6 % i14;
                if (i16 < 0) {
                    i16 += i14;
                }
                int i17 = (i15 - i16) % i14;
                if (i17 < 0) {
                    i17 += i14;
                }
                return i17 + i6;
            }
        }
        return i6;
    }

    public static boolean I(int i) {
        return i == 403 || i == 404 || i == 405;
    }

    public static String J(String str, String str2) {
        AbstractC0307c.a(str, "filePath");
        File file = new File(str);
        if (file.exists()) {
            if (file.isDirectory()) {
                return j(str, str2);
            }
        } else {
            if (str.endsWith(File.separator)) {
                return j(str, str2);
            }
            if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                throw new TosClientException("tos: can not create directory in: " + file.getParentFile().getPath(), null);
            }
        }
        return str;
    }

    public static void K(CopyEventListener copyEventListener, CopyEvent copyEvent) {
        if (copyEventListener == null || copyEvent == null) {
            return;
        }
        copyEventListener.eventChange(copyEvent);
    }

    public static void L(DownloadEventListener downloadEventListener, DownloadEvent downloadEvent) {
        if (downloadEventListener == null || downloadEvent == null) {
            return;
        }
        downloadEventListener.eventChange(downloadEvent);
    }

    public static void M(UploadEventListener uploadEventListener, UploadEvent uploadEvent) {
        if (uploadEventListener == null || uploadEvent == null) {
            return;
        }
        uploadEventListener.eventChange(uploadEvent);
    }

    public static final double O(long j5) {
        return ((j5 >>> 11) * 2048) + (j5 & 2047);
    }

    public static void Q(long j5) {
        if (j5 < 5242880 || j5 > 5368709120L) {
            throw new TosClientException("invalid part size, the size must be [5242880, 5368709120]", null);
        }
    }

    public static I8.g R(S7.k changeOptions) {
        kotlin.jvm.internal.k.f(changeOptions, "changeOptions");
        I8.j jVar = new I8.j();
        changeOptions.invoke(jVar);
        jVar.f839a = true;
        return new I8.g(jVar);
    }

    public static void a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static kotlinx.coroutines.channels.a b(int i, int i6, BufferOverflow bufferOverflow) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            bufferOverflow = BufferOverflow.f5184a;
        }
        if (i == -2) {
            if (bufferOverflow != BufferOverflow.f5184a) {
                return new C1784j(1, bufferOverflow);
            }
            InterfaceC1779e.f5455J.getClass();
            return new kotlinx.coroutines.channels.a(C1778d.b);
        }
        if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? bufferOverflow == BufferOverflow.f5184a ? new kotlinx.coroutines.channels.a(i) : new C1784j(i, bufferOverflow) : new kotlinx.coroutines.channels.a(Integer.MAX_VALUE) : bufferOverflow == BufferOverflow.f5184a ? new kotlinx.coroutines.channels.a(0) : new C1784j(1, bufferOverflow);
        }
        if (bufferOverflow == BufferOverflow.f5184a) {
            return new C1784j(1, BufferOverflow.b);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static float c() {
        BigDecimal bigDecimal = new BigDecimal(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        long jMaxMemory = f1608a;
        if (jMaxMemory == -1) {
            jMaxMemory = Runtime.getRuntime().maxMemory();
            f1608a = jMaxMemory;
        }
        return ((float) bigDecimal.divide(new BigDecimal(jMaxMemory), 4, 4).doubleValue()) * 100.0f;
    }

    public static long d() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            String[] strArrSplit = line.split(" ");
            long j5 = Long.parseLong(strArrSplit[13]) + Long.parseLong(strArrSplit[14]);
            try {
                bufferedReader.close();
            } catch (Throwable unused2) {
            }
            return j5;
        } catch (Throwable unused3) {
            if (bufferedReader == null) {
                return -1L;
            }
            try {
                bufferedReader.close();
                return -1L;
            } catch (Throwable unused4) {
                return -1L;
            }
        }
    }

    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void f(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file.isDirectory()) {
                    f(file2);
                }
            }
        }
        file.delete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(File file, String str, ZipOutputStream zipOutputStream) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        BufferedInputStream bufferedInputStream;
        if (file.isDirectory()) {
            StringBuilder sbV = androidx.compose.foundation.b.v(str);
            sbV.append(file.getName());
            sbV.append(File.separator);
            String string = sbV.toString();
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    g(file2, string, zipOutputStream);
                }
                return;
            }
            return;
        }
        if (AbstractC0291a.c) {
            AbstractC0291a.m("压缩：" + str + file.getName());
        }
        if (!file.exists()) {
            return;
        }
        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream2);
                } catch (Exception e6) {
                    e = e6;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = bufferedInputStream.read(bArr, 0, 8192);
                    if (i == -1) {
                        e(bufferedInputStream);
                        e(fileInputStream2);
                        return;
                    }
                    zipOutputStream.write(bArr, 0, i);
                }
            } catch (Exception e9) {
                e = e9;
                fileInputStream3 = bufferedInputStream;
                throw new RuntimeException(e);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream3 = bufferedInputStream;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                e(fileInputStream);
                e(fileInputStream3);
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            fileInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            e(fileInputStream);
            e(fileInputStream3);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable, java.io.OutputStream, java.util.zip.CheckedOutputStream] */
    public static void h(String str, String... strArr) throws Throwable {
        ?? r02;
        Closeable closeable;
        File file;
        Exception e6;
        FileOutputStream fileOutputStream;
        ?? checkedOutputStream;
        File file2 = new File(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    checkedOutputStream = new CheckedOutputStream(fileOutputStream, new CRC32());
                } catch (Exception e9) {
                    e = e9;
                } catch (Throwable th) {
                    th = th;
                    file = null;
                    closeable = null;
                }
            } catch (Throwable th2) {
                th = th2;
                file = file2;
            }
        } catch (Exception e10) {
            e = e10;
        } catch (Throwable th3) {
            th = th3;
            r02 = 0;
            closeable = null;
            e(closeable);
            e(r02);
            e(fileOutputStream2);
            throw th;
        }
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
            try {
                for (String str2 : strArr) {
                    File file3 = new File(str2);
                    if (!file3.exists()) {
                        throw new RuntimeException(str2 + "不存在！");
                    }
                    g(file3, "", zipOutputStream);
                }
                e(zipOutputStream);
                e(checkedOutputStream);
                e(fileOutputStream);
            } catch (Exception e11) {
                e6 = e11;
                throw new RuntimeException(e6);
            }
        } catch (Exception e12) {
            e = e12;
            e6 = e;
            throw new RuntimeException(e6);
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            file = checkedOutputStream;
            fileOutputStream2 = fileOutputStream;
            r02 = file;
            e(closeable);
            e(r02);
            e(fileOutputStream2);
            throw th;
        }
    }

    public static void i(n2.a aVar, Header header, CrashType crashType) {
        JSONObject jSONObject;
        if (aVar == null || (jSONObject = aVar.f5345a) == null || crashType == null) {
            return;
        }
        long jOptLong = jSONObject.optLong("crash_time");
        String strH = com.apm.insight.g.e().h();
        if (jOptLong <= 0 || TextUtils.isEmpty(crashType.getName())) {
            return;
        }
        try {
            String str = "android__" + strH + "_" + jOptLong + "_" + crashType;
            if (header == null || (jSONObject = header.f2158a) != null) {
                jSONObject.put("unique_key", str);
            }
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    public static String j(String str, String str2) {
        String str3;
        String str4 = File.separator;
        if (str.endsWith(str4)) {
            new File(str).mkdirs();
            str3 = "";
        } else {
            str3 = str4;
        }
        String strB = B7.a.B(str, str3, str2);
        if (!AbstractC0291a.y(strB) || !strB.endsWith(str4)) {
            return strB;
        }
        if (new File(strB).mkdirs()) {
            return "";
        }
        throw new TosClientException("tos: can not create directory in: ".concat(strB), null);
    }

    public static void m(Object obj, boolean z10) throws NoSuchFieldException, SecurityException {
        if (!z10 || e == null) {
            if (z10 || d == null) {
                Field declaredField = null;
                try {
                    declaredField = obj.getClass().getDeclaredField("mStateSaved");
                    declaredField.setAccessible(true);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                if (z10) {
                    e = declaredField;
                } else {
                    d = declaredField;
                }
            }
        }
    }

    public static String n(String str, String str2, String str3) {
        StringBuilder sbV = B7.a.v(str, ".", str2);
        if (AbstractC0291a.y(str3)) {
            sbV.append(".");
            sbV.append(str3);
        }
        try {
            return new String(C0881a.c(MessageDigest.getInstance("MD5").digest(sbV.toString().getBytes()))).replace('+', '-').replace(JsonPointer.SEPARATOR, '_');
        } catch (NoSuchAlgorithmException e6) {
            throw new TosClientException("tos: unable to compute md5", e6);
        }
    }

    public static K1.a o(K1.a aVar, InterfaceC1523f interfaceC1523f, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a aVar2, int i) {
        if ((i & 2) != 0) {
            aVar2 = null;
        }
        kotlin.jvm.internal.k.f(aVar, "<this>");
        return new K1.a((C2024a) aVar.f903a, aVar2 != null ? new t(aVar, interfaceC1523f, aVar2, 0) : (InterfaceC2028e) aVar.b, kotlin.a.b(LazyThreadSafetyMode.c, new J4.e(17, aVar, interfaceC1523f)));
    }

    public static String p(String str) {
        String string;
        if (str == null || (string = m.R0(str).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    public static String q(String str, String str2) {
        String string;
        if (str != null && (string = m.R0(str).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                return string;
            }
        }
        return str2 == null ? "" : str2;
    }

    public static final K1.a r(K1.a aVar, InterfaceC1561g additionalAnnotations) {
        kotlin.jvm.internal.k.f(aVar, "<this>");
        kotlin.jvm.internal.k.f(additionalAnnotations, "additionalAnnotations");
        return additionalAnnotations.isEmpty() ? aVar : new K1.a((C2024a) aVar.f903a, (InterfaceC2028e) aVar.b, kotlin.a.b(LazyThreadSafetyMode.c, new J4.e(18, aVar, additionalAnnotations)));
    }

    public static C1444e s(C1442c functionClass, boolean z10) {
        String lowerCase;
        kotlin.jvm.internal.k.f(functionClass, "functionClass");
        List list = functionClass.k;
        C1444e c1444e = new C1444e(functionClass, null, CallableMemberDescriptor$Kind.f4950a, z10);
        u uVarB0 = functionClass.B0();
        EmptyList emptyList = EmptyList.f4893a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((InterfaceC1507O) obj).r() != Variance.d) {
                break;
            }
            arrayList.add(obj);
        }
        s sVarL1 = v.l1(arrayList);
        ArrayList arrayList2 = new ArrayList(w.c0(sVarL1, 10));
        Iterator it = sVarL1.iterator();
        while (true) {
            E e6 = (E) it;
            if (!e6.b.hasNext()) {
                c1444e.W0(null, uVarB0, emptyList, emptyList, arrayList2, ((InterfaceC1507O) v.K0(list)).g(), Modality.e, AbstractC1532o.e);
                C1444e c1444e2 = c1444e;
                c1444e2.f4870w = true;
                return c1444e2;
            }
            D d6 = (D) e6.next();
            int i = d6.f393a;
            InterfaceC1507O interfaceC1507O = (InterfaceC1507O) d6.b;
            String strB = interfaceC1507O.getName().b();
            kotlin.jvm.internal.k.e(strB, "asString(...)");
            if (strB.equals(ExifInterface.GPS_DIRECTION_TRUE)) {
                lowerCase = "instance";
            } else if (strB.equals(ExifInterface.LONGITUDE_EAST)) {
                lowerCase = "receiver";
            } else {
                lowerCase = strB.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
            }
            C1444e c1444e3 = c1444e;
            G8.f fVarE = G8.f.e(lowerCase);
            A aG = interfaceC1507O.g();
            kotlin.jvm.internal.k.e(aG, "getDefaultType(...)");
            arrayList2.add(new Q(c1444e3, null, i, C1560f.f4611a, fVarE, aG, false, false, false, null, InterfaceC1503K.f4577I));
            c1444e = c1444e3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static m8.C1682b t(java.lang.Class r14) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z6.k.t(java.lang.Class):m8.b");
    }

    public static synchronized void u(String str) {
        if (AbstractC0291a.x(str)) {
            return;
        }
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }

    public static final C1682b v(C2031a c2031a, G8.b classId, F8.f jvmMetadataVersion) {
        kotlin.jvm.internal.k.f(c2031a, "<this>");
        kotlin.jvm.internal.k.f(classId, "classId");
        kotlin.jvm.internal.k.f(jvmMetadataVersion, "jvmMetadataVersion");
        Q.a aVarJ = c2031a.j(classId, jvmMetadataVersion);
        if (aVarJ != null) {
            return (C1682b) aVarJ.b;
        }
        return null;
    }

    public static V6.a w(FileInputStream fileInputStream, File file, String str, long j5, long j6) throws IOException {
        if (j5 < 0) {
            throw new TosClientException("file offset is small than 0", null);
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.skip(j5);
                return new V6.a(fileInputStream, j6);
            } catch (IOException e6) {
                throw new TosClientException("getBoundedFileContent failed.", e6);
            }
        }
        if (file != null) {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                fileInputStream2.skip(j5);
                return new V6.a(fileInputStream2, j6);
            } catch (IOException e9) {
                throw new TosClientException("getBoundedFileContent failed.", e9);
            }
        }
        if (str == null) {
            throw new TosClientException("file info is not set in the input, please set filepath at least", null);
        }
        try {
            FileInputStream fileInputStream3 = new FileInputStream(str);
            fileInputStream3.skip(j5);
            return new V6.a(fileInputStream3, j6);
        } catch (IOException e10) {
            throw new TosClientException("getBoundedFileContent failed.", e10);
        }
    }

    public abstract int A();

    public abstract int B(View view);

    public abstract int C(CoordinatorLayout coordinatorLayout);

    public abstract int E();

    public abstract boolean F(float f7);

    public abstract boolean G(View view);

    public abstract boolean H(float f7, float f9);

    public abstract boolean N(View view, float f7);

    public abstract void P(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i6);

    public abstract int k(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float l(int i);

    public abstract int x();

    public abstract int y();

    public abstract int z();
}
