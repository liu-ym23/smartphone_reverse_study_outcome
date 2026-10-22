package com.stepos.statsrpk;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.HandlerThread;
import android.os.LocaleList;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.view.Window;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTemplates;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import d1.j0;
import d2.k0;
import g9.l1;
import g9.o1;
import g9.p;
import g9.p1;
import g9.t;
import g9.w0;
import g9.y0;
import g9.z0;
import hc.o;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Flow;
import kb.m;
import kc.u;
import o2.n;
import od.l;
import od.z;
import p.g0;
import reactor.core.publisher.BaseSubscriber;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static g f2863a = null;

    /* renamed from: b, reason: collision with root package name */
    public static i1.f f2864b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f2865c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f2866d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f2867e = "";

    /* renamed from: f, reason: collision with root package name */
    public static String f2868f = "";

    /* renamed from: g, reason: collision with root package name */
    public static String f2869g = "";

    public static Serializable A(String str) throws IOException {
        String string = str != null ? hc.h.w0(str).toString() : null;
        if (string == null) {
            string = "";
        }
        if (hc.h.g0(string)) {
            a9.c cVar = a9.c.f246f;
            return id.c.l(new IllegalArgumentException("INVALID_REQUEST"));
        }
        if (string.equals("/sdcard")) {
            string = "/storage/emulated/0";
        } else if (o.U(string, "/sdcard/", false)) {
            string = "/storage/emulated/0/".concat(hc.h.l0(string, "/sdcard/"));
        }
        try {
            String canonicalPath = new File(string).getCanonicalPath();
            if (k.a(canonicalPath, "/storage/emulated/0")) {
                return canonicalPath;
            }
            canonicalPath.getClass();
            if (o.U(canonicalPath, "/storage/emulated/0/", false)) {
                return canonicalPath;
            }
            a9.c cVar2 = a9.c.f246f;
            return id.c.l(new SecurityException("PATH_NOT_ALLOWED"));
        } catch (IOException unused) {
            a9.c cVar3 = a9.c.f246f;
            return id.c.l(new IllegalArgumentException("INVALID_REQUEST"));
        } catch (SecurityException unused2) {
            a9.c cVar4 = a9.c.f246f;
            return id.c.l(new SecurityException("PATH_NOT_ALLOWED"));
        }
    }

    public static w4.e B(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        String str3 = p8.a.f9923a.a(applicationContext).f9985b;
        DeterministicAeadConfig.register();
        AeadConfig.register();
        Context applicationContext2 = applicationContext.getApplicationContext();
        KeysetHandle keysetHandle = new AndroidKeysetManager.Builder().withKeyTemplate(KeyTemplates.get("AES256_SIV")).withSharedPref(applicationContext2, "__androidx_security_crypto_encrypted_prefs_key_keyset__", str).withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + str3).build().getKeysetHandle();
        KeysetHandle keysetHandle2 = new AndroidKeysetManager.Builder().withKeyTemplate(KeyTemplates.get("AES256_GCM")).withSharedPref(applicationContext2, "__androidx_security_crypto_encrypted_prefs_value_keyset__", str).withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + str3).build().getKeysetHandle();
        DeterministicAead deterministicAead = (DeterministicAead) keysetHandle.getPrimitive(DeterministicAead.class);
        Aead aead = (Aead) keysetHandle2.getPrimitive(Aead.class);
        SharedPreferences sharedPreferences = applicationContext2.getSharedPreferences(str, 0);
        w4.e eVar = new w4.e();
        eVar.f15224c = str;
        eVar.f15222a = sharedPreferences;
        eVar.f15225d = aead;
        eVar.f15226e = deterministicAead;
        eVar.f15223b = new CopyOnWriteArrayList();
        VarHandle.storeStoreFence();
        SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences(str2, 0);
        sharedPreferences2.getClass();
        Map<String, ?> all = sharedPreferences2.getAll();
        if (all.isEmpty()) {
            return eVar;
        }
        SharedPreferences.Editor editorEdit = eVar.edit();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                ((w4.d) editorEdit).putString(key, (String) value);
            } else if (value instanceof Set) {
                ((w4.d) editorEdit).putStringSet(key, (Set) value);
            } else if (value instanceof Boolean) {
                ((w4.d) editorEdit).putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Integer) {
                ((w4.d) editorEdit).putInt(key, ((Number) value).intValue());
            } else if (value instanceof Long) {
                ((w4.d) editorEdit).putLong(key, ((Number) value).longValue());
            } else if (value instanceof Float) {
                ((w4.d) editorEdit).putFloat(key, ((Number) value).floatValue());
            }
        }
        ((w4.d) editorEdit).commit();
        sharedPreferences2.edit().clear().commit();
        return eVar;
    }

    public static final long C(float f5, long j10) {
        long jFloatToRawIntBits = j10 | (Float.floatToRawIntBits(f5) & 4294967295L);
        o2.o[] oVarArr = n.f9127b;
        return jFloatToRawIntBits;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long D(int r13, java.lang.String r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.h.D(int, java.lang.String):long");
    }

    public static p E(p pVar, String str, String str2) {
        pVar.getClass();
        str.getClass();
        str2.getClass();
        List<g9.n> list = pVar.f4572a;
        ArrayList arrayList = new ArrayList(m.m0(list, 10));
        for (g9.n nVar : list) {
            List<g9.o> list2 = nVar.f4539c;
            ArrayList arrayList2 = new ArrayList(m.m0(list2, 10));
            for (g9.o oVar : list2) {
                if (oVar.f4548a.equals(str)) {
                    String str3 = oVar.f4548a;
                    String str4 = oVar.f4549b;
                    String str5 = oVar.f4550c;
                    List list3 = oVar.f4551d;
                    String str6 = oVar.f4553f;
                    boolean z10 = oVar.f4554g;
                    str4.getClass();
                    str5.getClass();
                    list3.getClass();
                    oVar = new g9.o(str3, str4, str5, list3, str2, str6, z10);
                }
                arrayList2.add(oVar);
            }
            String str7 = nVar.f4537a;
            String str8 = nVar.f4538b;
            str8.getClass();
            arrayList.add(new g9.n(str7, str8, arrayList2));
        }
        p pVar2 = new p();
        pVar2.f4572a = arrayList;
        VarHandle.storeStoreFence();
        return pVar2;
    }

    public static void F(Window window, boolean z10) {
        if (Build.VERSION.SDK_INT >= 35) {
            window.setDecorFitsSystemWindows(z10);
            return;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z10 ? systemUiVisibility & (-257) : systemUiVisibility | ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH);
        window.setDecorFitsSystemWindows(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Flow.Subscriber G(BaseSubscriber baseSubscriber) {
        if (baseSubscriber instanceof Flow.Subscriber) {
            return (Flow.Subscriber) baseSubscriber;
        }
        qd.a aVar = new qd.a();
        aVar.f10216c = baseSubscriber;
        VarHandle.storeStoreFence();
        return aVar;
    }

    public static String H(long j10) {
        int i = (int) (j10 >> 32);
        int i3 = (int) (j10 & 4294967295L);
        if (Float.intBitsToFloat(i) == Float.intBitsToFloat(i3)) {
            return "CornerRadius.circular(" + id.c.L(Float.intBitsToFloat(i)) + ')';
        }
        return "CornerRadius.elliptical(" + id.c.L(Float.intBitsToFloat(i)) + ", " + id.c.L(Float.intBitsToFloat(i3)) + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0086 A[PHI: r1
      0x0086: PHI (r1v14 g9.z0) = (r1v3 g9.z0), (r1v11 g9.z0), (r1v11 g9.z0) binds: [B:33:0x0084, B:46:0x00a2, B:49:0x00ab] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static g9.o1 I(g9.w0 r12, g9.o r13) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.h.I(g9.w0, g9.o):g9.o1");
    }

    public static String J(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }

    public static final m0.h K(g0 g0Var) {
        m0.h hVar = new m0.h();
        hVar.f8171c = g0Var;
        VarHandle.storeStoreFence();
        return hVar;
    }

    public static final long a(int i, int i3) {
        if (i < 0 || i3 < 0) {
            i2.a.a("start and end cannot be negative. [start: " + i + ", end: " + i3 + ']');
        }
        long j10 = (i3 & 4294967295L) | (i << 32);
        int i10 = k0.f3135c;
        return j10;
    }

    public static void b(Throwable th, Throwable th2) {
        th.getClass();
        th2.getClass();
        if (th != th2) {
            Integer num = sb.a.f12172a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = rb.a.f10527a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static void c(Runnable runnable) {
        if (f2863a == null) {
            synchronized (h.class) {
                HandlerThread handlerThread = new HandlerThread("com.stepos.statsrpk.apiWorker", 5);
                handlerThread.start();
                f2863a = new g(handlerThread.getLooper(), 0);
            }
        }
        f2863a.post(runnable);
    }

    public static void d(long j10, od.i iVar, int i, ArrayList arrayList, int i3, int i10, ArrayList arrayList2) {
        int i11;
        int i12;
        ArrayList arrayList3;
        long j11;
        int i13;
        int i14 = i;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i3 >= i10) {
            g5.f.s("Failed requirement.");
            return;
        }
        for (int i15 = i3; i15 < i10; i15++) {
            if (((l) arrayList4.get(i15)).c() < i14) {
                g5.f.s("Failed requirement.");
                return;
            }
        }
        l lVar = (l) arrayList.get(i3);
        l lVar2 = (l) arrayList4.get(i10 - 1);
        if (i14 == lVar.c()) {
            int iIntValue = ((Number) arrayList5.get(i3)).intValue();
            int i16 = i3 + 1;
            l lVar3 = (l) arrayList4.get(i16);
            i11 = i16;
            i12 = iIntValue;
            lVar = lVar3;
        } else {
            i11 = i3;
            i12 = -1;
        }
        if (lVar.h(i14) == lVar2.h(i14)) {
            int iMin = Math.min(lVar.c(), lVar2.c());
            int i17 = 0;
            for (int i18 = i14; i18 < iMin && lVar.h(i18) == lVar2.h(i18); i18++) {
                i17++;
            }
            long j12 = 4;
            long j13 = (iVar.f9454f / j12) + j10 + 2 + i17 + 1;
            iVar.e0(-i17);
            iVar.e0(i12);
            int i19 = i14 + i17;
            while (i14 < i19) {
                iVar.e0(lVar.h(i14) & 255);
                i14++;
            }
            if (i11 + 1 == i10) {
                if (i19 == ((l) arrayList4.get(i11)).c()) {
                    iVar.e0(((Number) arrayList5.get(i11)).intValue());
                    return;
                } else {
                    od.f.e("Check failed.");
                    return;
                }
            }
            od.i iVar2 = new od.i();
            iVar.e0(((int) ((iVar2.f9454f / j12) + j13)) * (-1));
            d(j13, iVar2, i19, arrayList4, i11, i10, arrayList5);
            iVar.a0(iVar2);
            return;
        }
        int i20 = 1;
        for (int i21 = i11 + 1; i21 < i10; i21++) {
            if (((l) arrayList4.get(i21 - 1)).h(i14) != ((l) arrayList4.get(i21)).h(i14)) {
                i20++;
            }
        }
        long j14 = 4;
        long j15 = (iVar.f9454f / j14) + j10 + 2 + (i20 * 2);
        iVar.e0(i20);
        iVar.e0(i12);
        for (int i22 = i11; i22 < i10; i22++) {
            int iH = ((l) arrayList4.get(i22)).h(i14);
            if (i22 == i11 || iH != ((l) arrayList4.get(i22 - 1)).h(i14)) {
                iVar.e0(iH & 255);
            }
        }
        od.i iVar3 = new od.i();
        int i23 = i11;
        while (i23 < i10) {
            byte bH = ((l) arrayList4.get(i23)).h(i14);
            int i24 = i23 + 1;
            int i25 = i24;
            while (true) {
                if (i25 >= i10) {
                    i25 = i10;
                    break;
                } else if (bH != ((l) arrayList4.get(i25)).h(i14)) {
                    break;
                } else {
                    i25++;
                }
            }
            if (i24 == i25 && i14 + 1 == ((l) arrayList4.get(i23)).c()) {
                iVar.e0(((Number) arrayList5.get(i23)).intValue());
                arrayList3 = arrayList5;
                j11 = j15;
                i13 = i25;
            } else {
                iVar.e0(((int) ((iVar3.f9454f / j14) + j15)) * (-1));
                arrayList3 = arrayList5;
                j11 = j15;
                i13 = i25;
                d(j11, iVar3, i14 + 1, arrayList, i23, i13, arrayList3);
                arrayList4 = arrayList;
            }
            j15 = j11;
            i23 = i13;
            arrayList5 = arrayList3;
        }
        iVar.a0(iVar3);
    }

    public static final int e(float f5) {
        return Math.round((float) Math.ceil(f5));
    }

    public static void f(int i) {
        if (2 > i || i >= 37) {
            StringBuilder sbT = k0.a.t(i, "radix ", " was not in valid range ");
            sbT.append(new ec.g(2, 36, 1));
            throw new IllegalArgumentException(sbT.toString());
        }
    }

    public static final w0.m g(w0.m mVar, j0 j0Var) {
        return androidx.compose.ui.graphics.a.d(mVar, 0.0f, j0Var, 518143);
    }

    public static final w0.m h(w0.m mVar) {
        return androidx.compose.ui.graphics.a.d(mVar, 0.0f, null, 520191);
    }

    public static final int i(x4.c cVar, String str) {
        cVar.getClass();
        int columnCount = cVar.getColumnCount();
        int i = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= columnCount) {
                i3 = -1;
                break;
            }
            if (str.equals(cVar.getColumnName(i3))) {
                break;
            }
            i3++;
        }
        if (i3 >= 0) {
            return i3;
        }
        String str2 = "`" + str + '`';
        int columnCount2 = cVar.getColumnCount();
        while (true) {
            if (i >= columnCount2) {
                i = -1;
                break;
            }
            if (str2.equals(cVar.getColumnName(i))) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return i;
        }
        return -1;
    }

    public static int j(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static int k(String str, int i, int i3, boolean z10) {
        while (i < i3) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z10)) {
                return i;
            }
            i++;
        }
        return i3;
    }

    public static final void l(od.o oVar, z zVar) throws IOException {
        try {
            IOException iOException = null;
            for (z zVar2 : oVar.g(zVar)) {
                try {
                    if (oVar.h(zVar2).f9472c) {
                        l(oVar, zVar2);
                    }
                    oVar.d(zVar2);
                } catch (IOException e10) {
                    if (iOException == null) {
                        iOException = e10;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    public static final boolean m(char c9, char c10, boolean z10) {
        if (c9 == c10) {
            return true;
        }
        if (!z10) {
            return false;
        }
        char upperCase = Character.toUpperCase(c9);
        char upperCase2 = Character.toUpperCase(c10);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static final boolean n(long j10, long j11) {
        return j10 == j11;
    }

    public static String o(androidx.datastore.preferences.protobuf.f fVar) {
        StringBuilder sb2 = new StringBuilder(fVar.size());
        for (int i = 0; i < fVar.size(); i++) {
            byte bA = fVar.a(i);
            if (bA == 34) {
                sb2.append("\\\"");
            } else if (bA == 39) {
                sb2.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((bA >>> 6) & 3) + 48));
                            sb2.append((char) (((bA >>> 3) & 7) + 48));
                            sb2.append((char) ((bA & 7) + 48));
                            break;
                        } else {
                            sb2.append((char) bA);
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    public static final int p(x4.c cVar, String str) {
        int i = i(cVar, str);
        if (i >= 0) {
            return i;
        }
        int columnCount = cVar.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i3 = 0; i3 < columnCount; i3++) {
            arrayList.add(cVar.getColumnName(i3));
        }
        b8.z.o("Column '", str, "' does not exist. Available columns: [", kb.l.B0(arrayList, null, null, null, null, 63), 93);
        return 0;
    }

    public static j2.b q() {
        p5.m mVar = j2.c.f6547a;
        LocaleList localeList = LocaleList.getDefault();
        synchronized (((f8.b) mVar.f9743h)) {
            try {
                j2.b bVar = (j2.b) mVar.f9742g;
                if (bVar != null && localeList == ((LocaleList) mVar.f9741f)) {
                    return bVar;
                }
                int size = localeList.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    arrayList.add(new j2.a(localeList.get(i)));
                }
                j2.b bVar2 = new j2.b(arrayList);
                mVar.f9741f = localeList;
                mVar.f9742g = bVar2;
                return bVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final int r(int i, int i3, int i10) {
        if (i10 > 0) {
            if (i < i3) {
                int i11 = i3 % i10;
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
                return i3 - i13;
            }
        } else {
            if (i10 >= 0) {
                g5.f.s("Step is zero.");
                return 0;
            }
            if (i > i3) {
                int i14 = -i10;
                int i15 = i % i14;
                if (i15 < 0) {
                    i15 += i14;
                }
                int i16 = i3 % i14;
                if (i16 < 0) {
                    i16 += i14;
                }
                int i17 = (i15 - i16) % i14;
                if (i17 < 0) {
                    i17 += i14;
                }
                return i17 + i3;
            }
        }
        return i3;
    }

    public static final long s(double d7) {
        return C((float) d7, 4294967296L);
    }

    public static final long t(int i) {
        return C(i, 4294967296L);
    }

    public static final boolean u(od.i iVar) {
        od.i iVar2;
        int i;
        iVar.getClass();
        try {
            iVar2 = new od.i();
            long j10 = iVar.f9454f;
            long j11 = 64;
            if (j10 <= 64) {
                j11 = j10;
            }
            iVar.r(iVar2, 0L, j11);
        } catch (EOFException unused) {
        }
        for (i = 0; i < 16; i++) {
            if (iVar2.A()) {
                return true;
            }
            int iV = iVar2.V();
            if (Character.isISOControl(iV) && !Character.isWhitespace(iV)) {
                return false;
            }
        }
        return true;
    }

    public static boolean v(char c9) {
        return Character.isWhitespace(c9) || Character.isSpaceChar(c9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static t2.m w(nb.g gVar, xb.p pVar) {
        u uVar = u.f7481c;
        gVar.getClass();
        e8.a aVar = new e8.a();
        aVar.f3602a = gVar;
        aVar.f3603b = uVar;
        aVar.f3604c = (pb.i) pVar;
        VarHandle.storeStoreFence();
        return t.n.i(aVar);
    }

    public static y0 x(p pVar) {
        p1 p1Var;
        p1 p1Var2;
        if (pVar == null) {
            List<l1> list = t.f4612c;
            ArrayList arrayList = new ArrayList();
            for (l1 l1Var : list) {
                List list2 = l1Var.f4524b;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list2) {
                    if (((w0) obj).i) {
                        arrayList2.add(obj);
                    }
                }
                if (arrayList2.isEmpty()) {
                    p1Var2 = null;
                } else {
                    int i = l1Var.f4523a;
                    ArrayList arrayList3 = new ArrayList(m.m0(arrayList2, 10));
                    int size = arrayList2.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj2 = arrayList2.get(i3);
                        i3++;
                        arrayList3.add(I((w0) obj2, null));
                    }
                    p1Var2 = new p1("", "", i, arrayList3);
                }
                if (p1Var2 != null) {
                    arrayList.add(p1Var2);
                }
            }
            return new y0(arrayList, false, false, false);
        }
        List<g9.n> list3 = pVar.f4572a;
        ArrayList arrayList4 = new ArrayList();
        for (g9.n nVar : list3) {
            List<g9.o> list4 = nVar.f4539c;
            if (list4.isEmpty()) {
                p1Var = null;
            } else {
                ArrayList arrayList5 = new ArrayList();
                Iterator it = list4.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) ((Map) t.f4614e.getValue()).get(((g9.o) it.next()).f4548a);
                    if (num != null) {
                        arrayList5.add(num);
                    }
                }
                Integer num2 = (Integer) kb.l.x0(arrayList5);
                int iIntValue = num2 != null ? num2.intValue() : 0;
                String str = nVar.f4537a;
                String str2 = nVar.f4538b;
                ArrayList arrayList6 = new ArrayList(m.m0(list4, 10));
                for (g9.o oVar : list4) {
                    arrayList6.add(I((w0) ((Map) t.f4613d.getValue()).get(oVar.f4548a), oVar));
                }
                p1Var = new p1(str, str2, iIntValue, arrayList6);
            }
            if (p1Var != null) {
                arrayList4.add(p1Var);
            }
        }
        return new y0(arrayList4, false, false, true);
    }

    public static y0 y(y0 y0Var, String str, z0 z0Var) {
        y0Var.getClass();
        str.getClass();
        z0Var.getClass();
        List<p1> list = y0Var.f4653a;
        int i = 10;
        ArrayList arrayList = new ArrayList(m.m0(list, 10));
        for (p1 p1Var : list) {
            List<o1> list2 = p1Var.f4584d;
            ArrayList arrayList2 = new ArrayList(m.m0(list2, i));
            for (o1 o1Var : list2) {
                if (o1Var.f4564b.equals(str)) {
                    o1Var = new o1(o1Var.f4563a, o1Var.f4564b, o1Var.f4565c, o1Var.f4566d, o1Var.f4567e, o1Var.f4568f, o1Var.f4569g, o1Var.f4570h, z0Var, o1Var.f4571j);
                }
                arrayList2.add(o1Var);
            }
            String str2 = p1Var.f4581a;
            String str3 = p1Var.f4582b;
            int i3 = p1Var.f4583c;
            str3.getClass();
            arrayList.add(new p1(str2, str3, i3, arrayList2));
            i = 10;
        }
        return y0.a(y0Var, arrayList, false, false, 14);
    }

    public static MappedByteBuffer z(Context context, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                parcelFileDescriptorOpenFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                parcelFileDescriptorOpenFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }
}
