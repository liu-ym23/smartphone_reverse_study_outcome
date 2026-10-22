package com.baidu.sec.privacy.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.utils.Consts;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static int f9449a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f9450b;

    /* renamed from: c, reason: collision with root package name */
    public PublicKey f9451c;

    public class a implements Comparator<c> {
        public a(d dVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            int i4 = cVar2.f9454c - cVar.f9454c;
            if (i4 != 0) {
                return i4;
            }
            boolean z4 = cVar.f9453b;
            if (z4 && cVar2.f9453b) {
                return 0;
            }
            if (z4) {
                return -1;
            }
            if (cVar2.f9453b) {
                return 1;
            }
            return i4;
        }
    }

    public static class b {
        public static byte[] a(byte[] bArr) {
            return a(bArr, bArr.length);
        }

        public static byte[] a(byte[] bArr, int i4) {
            byte b4;
            int i5;
            int i6 = (i4 / 4) * 3;
            if (i6 == 0) {
                return new byte[0];
            }
            byte[] bArr2 = new byte[i6];
            int i7 = i4;
            int i8 = 0;
            while (true) {
                byte b5 = bArr[i7 - 1];
                b4 = 10;
                if (b5 != 10 && b5 != 13 && b5 != 32 && b5 != 9) {
                    if (b5 != 61) {
                        break;
                    }
                    i8++;
                }
                i7--;
            }
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i9 < i7) {
                byte b6 = bArr[i9];
                if (b6 != b4 && b6 != 13 && b6 != 32 && b6 != 9) {
                    if (b6 >= 65 && b6 <= 90) {
                        i5 = b6 - 65;
                    } else if (b6 >= 97 && b6 <= 122) {
                        i5 = b6 - 71;
                    } else if (b6 >= 48 && b6 <= 57) {
                        i5 = b6 + 4;
                    } else if (b6 == 43) {
                        i5 = 62;
                    } else {
                        if (b6 != 47) {
                            return null;
                        }
                        i5 = 63;
                    }
                    i11 = ((byte) i5) | (i11 << 6);
                    if (i12 % 4 == 3) {
                        bArr2[i10] = (byte) ((16711680 & i11) >> 16);
                        int i13 = i10 + 2;
                        bArr2[i10 + 1] = (byte) ((65280 & i11) >> 8);
                        i10 += 3;
                        bArr2[i13] = (byte) (i11 & 255);
                    }
                    i12++;
                }
                i9++;
                b4 = 10;
            }
            if (i8 > 0) {
                int i14 = i11 << (i8 * 6);
                int i15 = i10 + 1;
                bArr2[i10] = (byte) ((i14 & 16711680) >> 16);
                if (i8 == 1) {
                    i10 += 2;
                    bArr2[i15] = (byte) ((i14 & 65280) >> 8);
                } else {
                    i10 = i15;
                }
            }
            byte[] bArr3 = new byte[i10];
            System.arraycopy(bArr2, 0, bArr3, 0, i10);
            return bArr3;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public ApplicationInfo f9452a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f9453b;

        /* renamed from: c, reason: collision with root package name */
        public int f9454c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f9455d;

        public /* synthetic */ c(a aVar) {
            this();
        }

        public c() {
            this.f9454c = 0;
            this.f9455d = false;
            this.f9453b = false;
        }
    }

    /* renamed from: com.baidu.sec.privacy.f.d$d, reason: collision with other inner class name */
    public static class C0053d {

        /* renamed from: a, reason: collision with root package name */
        public String f9456a;

        /* renamed from: b, reason: collision with root package name */
        public String f9457b;

        /* renamed from: c, reason: collision with root package name */
        public int f9458c = 0;

        public static boolean a(int i4) {
            return i4 >= 14;
        }

        public static boolean b(String str) {
            return TextUtils.isEmpty(str);
        }

        public boolean c() {
            return b(this.f9457b);
        }

        public boolean b() {
            return a(this.f9458c);
        }

        public static C0053d a(String str) throws JSONException {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                String str2 = "0";
                String strOptString = "0";
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!d.d("ZGV2aWNlaWQ=").equals(next) && !d.d("dmVy").equals(next)) {
                        strOptString = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(d.d("ZGV2aWNlaWQ="));
                jSONObject.getInt(d.d("dmVy"));
                int length = TextUtils.isEmpty(strOptString) ? 0 : strOptString.length();
                if (!TextUtils.isEmpty(string)) {
                    C0053d c0053d = new C0053d();
                    c0053d.f9456a = string;
                    c0053d.f9458c = length;
                    if (length >= 14) {
                        return c0053d;
                    }
                    if (!TextUtils.isEmpty(strOptString)) {
                        str2 = strOptString;
                    }
                    c0053d.f9457b = str2;
                    return c0053d;
                }
            } catch (Exception e4) {
                com.baidu.sec.privacy.f.c.a(e4);
            }
            return null;
        }

        public static C0053d b(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0053d c0053d = new C0053d();
            c0053d.f9456a = str;
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            c0053d.f9458c = length;
            if (length >= 14) {
                return c0053d;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            c0053d.f9457b = str2;
            return c0053d;
        }

        public String a() {
            String str = this.f9457b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.f9456a + Consts.SPLITTER_DETAIL + str;
        }
    }

    public static final class e {
        public static byte[] a() {
            return new byte[]{48, -126, 3, 99, 48, -126, 2, 75, -96, 3, 2, 1, 2, 2, 4, 106, -93, 120, 122, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, 14, 48, 12, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, 117, 48, 32, 23, 13, 49, 53, 49, 48, 50, 49, 48, 52, 51, 54, 51, 55, 90, 24, 15, 50, 48, 55, 48, 48, 55, 50, 52, 48, 52, 51, 54, 51, 55, 90, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, 14, 48, 12, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, 117, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -86, -91, -2, -41, ByteCompanionObject.MAX_VALUE, 37, -25, -33, 93, 51, -73, 32, -81, Base64.padSymbol, 108, 37, 126, 14, -125, 125, -55, -29, 34, -60, 84, -67, -46, 125, -93, -67, -27, 97, 54, 35, 0, -6, 83, 67, -116, 43, -24, 26, 88, -5, 33, 27, -105, 49, 76, -70, -32, 105, -48, 67, 69, 102, -111, -81, 93, -103, -18, 17, 55, 81, -34, -80, -76, -13, -84, 6, 91, 10, 48, -56, -1, 45, 9, 23, 34, 6, 103, 35, -51, 29, 70, -19, -51, 20, -39, -43, -97, 75, 23, -124, -101, -71, -75, -107, -88, -13, -71, 80, 90, -76, -119, 51, -80, 118, ByteCompanionObject.MIN_VALUE, -12, -108, 98, -29, -27, 60, -119, -74, 110, Base64.padSymbol, 51, -22, 53, 66, -99, -45, -25, 111, -121, 25, -72, ByteCompanionObject.MAX_VALUE, 3, 51, -100, 57, -90, 116, -59, -117, 74, -71, 121, 59, 19, -8, -109, 33, -14, 76, -105, -127, -23, 5, 99, -82, 22, -99, 51, 78, -26, 77, -52, -29, 121, 42, -76, 20, 2, 116, 111, -76, 2, -78, -90, -54, 81, 115, 82, 50, 124, -83, 96, 20, -40, -118, 105, 90, -70, 120, -33, -110, 12, -15, 38, 34, -125, -116, 69, -54, -103, -109, -124, 26, 94, -89, -98, -11, -66, 89, 48, -68, -51, 107, -60, 12, 114, -71, 119, 49, -31, -65, 113, -99, 3, -90, 79, -88, -38, -87, -25, -38, 41, 110, -25, 29, 49, 124, -76, -91, 77, -11, -90, 114, -63, 118, -22, -5, -124, 19, 22, -74, -75, 78, 28, 47, -69, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, -41, -108, 33, -126, -103, 35, 115, -83, 99, 110, -39, 110, -125, -118, -69, 87, -103, 30, 12, -53, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 0, -117, 0, -28, 51, 26, -4, -15, 86, ByteCompanionObject.MAX_VALUE, 14, -101, -48, 121, 115, -53, -72, -22, 4, -83, 49, 106, -15, -44, -116, -105, 19, 65, -32, 65, 92, 21, 51, Base64.padSymbol, -21, -74, 71, 91, 64, 75, -72, -48, 102, 17, -120, -23, -68, 51, 23, -104, 107, 65, -30, 109, -6, 46, -44, -46, -73, -54, -55, 63, 77, -54, -11, -51, 27, -1, 114, 86, -80, 28, -89, 29, -20, 49, -8, 57, -7, -30, Base64.padSymbol, -108, -6, -60, 113, 45, -32, -93, 19, -62, -89, 106, 91, 96, -48, 90, -59, 46, 104, 111, -88, 51, -39, 40, -36, -113, 86, -92, 25, 30, 94, -13, -15, -57, 59, -21, -111, 104, -50, -3, -121, -90, -43, Base64.padSymbol, 105, -3, 57, 69, 51, -3, -31, 105, -12, 19, 77, -82, -120, 121, 108, -63, -126, 46, -43, 14, -56, 21, 47, 63, -104, -7, 113, 57, 100, -9, -12, -101, 107, -77, -64, 91, -104, -61, 0, -7, -72, -19, 75, 12, 111, ByteCompanionObject.MAX_VALUE, -115, -46, -99, -111, -93, -67, -42, -66, 32, 81, 70, 109, -57, 10, 19, -49, -44, 59, 21, 31, -61, -59, 83, -14, 43, 73, -88, 120, -58, -46, 46, 66, 41, -2, -70, -6, -42, 103, 8, 4, 89, 110, -122, 68, -86, 62, -68, 13, -117, 35, -52, -6, 106, -91, 91, -62, -56, -26, -41, -109, 68, -102, -43, -29, 113, 43, -126, -127, 122, -47, -30, -96, -2, 78, 44, -92, -38, -124, -102, 73, -105, -66, 5, -85, -7, 56};
        }
    }

    public static final class f {
        public static byte[] a(byte[] bArr) {
            try {
                return MessageDigest.getInstance("SHA-1").digest(bArr);
            } catch (Exception e4) {
                d.b(e4);
                return new byte[0];
            }
        }
    }

    static {
        new String(b.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, Base64.padSymbol}));
        new String(b.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, Base64.padSymbol}));
    }

    public d(Context context) throws Throwable {
        this.f9450b = context.getApplicationContext();
        c();
    }

    public static void b(Throwable th) {
    }

    public static String d(String str) {
        return new String(b.a(str.getBytes()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        byteArrayInputStream2 = null;
        byteArrayInputStream2 = null;
        try {
            try {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(e.a());
                } catch (Exception e4) {
                    b(e4);
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            PublicKey publicKey = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
            this.f9451c = publicKey;
            byteArrayInputStream.close();
            byteArrayInputStream2 = publicKey;
        } catch (Exception e6) {
            e = e6;
            byteArrayInputStream2 = byteArrayInputStream;
            b(e);
            if (byteArrayInputStream2 != null) {
                byteArrayInputStream2.close();
                byteArrayInputStream2 = byteArrayInputStream2;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream2 = byteArrayInputStream;
            if (byteArrayInputStream2 != null) {
                try {
                    byteArrayInputStream2.close();
                } catch (Exception e7) {
                    b(e7);
                }
            }
            throw th;
        }
    }

    public final String e(String str) {
        return "0";
    }

    public final String f(String str) {
        try {
            return Settings.System.getString(this.f9450b.getContentResolver(), str);
        } catch (Exception e4) {
            b(e4);
            return null;
        }
    }

    public static String b(Context context) {
        C0053d c0053dA = a(context);
        return c0053dA != null ? c0053dA.a() : "";
    }

    public static String a(byte[] bArr) {
        if (bArr != null) {
            String strP = "";
            for (byte b4 : bArr) {
                String hexString = Integer.toHexString(b4 & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    strP = AbstractC0351g.q(strP, "0", hexString);
                } else {
                    strP = AbstractC0351g.p(strP, hexString);
                }
            }
            return strP.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    public final boolean b(String str) {
        return this.f9450b.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public final C0053d b() {
        return C0053d.b(f("com.baidu.deviceid"), f("bd_setting_i"));
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "";
    }

    public final String[] a(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i4 = 0; i4 < length; i4++) {
            strArr[i4] = a(f.a(signatureArr[i4].toByteArray()));
        }
        return strArr;
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    public final List<c> a(Intent intent, boolean z4) throws JSONException, PackageManager.NameNotFoundException {
        byte[] bArrA;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.f9450b.getPackageManager();
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.applicationInfo != null) {
                    try {
                        ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(activityInfo2.packageName, activityInfo2.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] bArrA2 = b.a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(bArrA2));
                                c cVar = new c(null);
                                cVar.f9454c = jSONObject.getInt("priority");
                                cVar.f9452a = resolveInfo.activityInfo.applicationInfo;
                                if (this.f9450b.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    cVar.f9453b = true;
                                }
                                if (z4) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        int length = jSONArray.length();
                                        String[] strArr = new String[length];
                                        for (int i4 = 0; i4 < length; i4++) {
                                            strArr[i4] = jSONArray.getString(i4);
                                        }
                                        if (a(strArr, a(packageInfo.signatures)) && (bArrA = a(b.a(string2.getBytes()), this.f9451c)) != null && Arrays.equals(bArrA, f.a(bArrA2))) {
                                            cVar.f9455d = true;
                                        }
                                    }
                                }
                                arrayList.add(cVar);
                            }
                        }
                    } catch (Exception e4) {
                        b(e4);
                    }
                }
            }
        }
        Collections.sort(arrayList, new a(this));
        return arrayList;
    }

    public final boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.io.File r5) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r5 = 8192(0x2000, float:1.148E-41)
            char[] r5 = new char[r5]     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            java.io.CharArrayWriter r2 = new java.io.CharArrayWriter     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            r2.<init>()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
        Lf:
            int r3 = r1.read(r5)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            if (r3 <= 0) goto L1f
            r4 = 0
            r2.write(r5, r4, r3)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            goto Lf
        L1a:
            r5 = move-exception
            r0 = r1
            goto L3e
        L1d:
            r5 = move-exception
            goto L30
        L1f:
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1d
            r1.close()     // Catch: java.lang.Exception -> L27
            goto L2b
        L27:
            r0 = move-exception
            b(r0)
        L2b:
            return r5
        L2c:
            r5 = move-exception
            goto L3e
        L2e:
            r5 = move-exception
            r1 = r0
        L30:
            b(r5)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L3d
            r1.close()     // Catch: java.lang.Exception -> L39
            goto L3d
        L39:
            r5 = move-exception
            b(r5)
        L3d:
            return r0
        L3e:
            if (r0 == 0) goto L48
            r0.close()     // Catch: java.lang.Exception -> L44
            goto L48
        L44:
            r0 = move-exception
            b(r0)
        L48:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sec.privacy.f.d.a(java.io.File):java.lang.String");
    }

    public static C0053d a(Context context) {
        return new d(context).a();
    }

    public final C0053d a() throws JSONException, PackageManager.NameNotFoundException {
        List<c> listA = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.f9450b.getPackageName()), true);
        boolean z4 = false;
        if (listA == null || listA.size() == 0) {
            for (int i4 = 0; i4 < 3; i4++) {
            }
        } else {
            boolean z5 = listA.get(0).f9455d;
            if (!z5) {
                for (int i5 = 0; i5 < 3; i5++) {
                }
            }
            z4 = z5;
        }
        File file = new File(this.f9450b.getFilesDir(), "libcuid.so");
        C0053d c0053dA = file.exists() ? C0053d.a(c(a(file))) : null;
        if (c0053dA == null) {
            f9449a |= 16;
            List<c> listA2 = a(new Intent("com.baidu.intent.action.GALAXY"), z4);
            if (listA2 != null) {
                File filesDir = this.f9450b.getFilesDir();
                String name = "files".equals(filesDir.getName()) ? "files" : filesDir.getName();
                for (c cVar : listA2) {
                    if (!cVar.f9453b) {
                        File file2 = new File(new File(cVar.f9452a.dataDir, name), "libcuid.so");
                        if (file2.exists() && (c0053dA = C0053d.a(c(a(file2)))) != null) {
                            break;
                        }
                    }
                }
            }
        }
        if (c0053dA == null) {
            c0053dA = C0053d.a(c(f("com.baidu.deviceid.v2")));
        }
        boolean zB = b("android.permission.READ_EXTERNAL_STORAGE");
        if (c0053dA == null && zB) {
            f9449a |= 2;
        }
        if (c0053dA == null) {
            f9449a |= 8;
            c0053dA = b();
        }
        if (c0053dA == null && zB) {
            f9449a |= 1;
            e("");
        }
        a(c0053dA);
        return c0053dA;
    }

    public final boolean a(C0053d c0053d) {
        if (c0053d == null) {
            return false;
        }
        if (c0053d.b()) {
            c0053d.f9457b = "O";
            return true;
        }
        if (!c0053d.c()) {
            return false;
        }
        c0053d.f9457b = "0";
        return true;
    }
}
