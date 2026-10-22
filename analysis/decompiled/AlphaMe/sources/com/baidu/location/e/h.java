package com.baidu.location.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import androidx.room.AbstractC0351g;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.c.k;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.utils.Consts;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.UByte;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h {

    /* renamed from: A, reason: collision with root package name */
    public static float f5890A = 2.3f;

    /* renamed from: B, reason: collision with root package name */
    public static float f5891B = 3.8f;

    /* renamed from: C, reason: collision with root package name */
    public static int f5892C = 3;

    /* renamed from: D, reason: collision with root package name */
    public static int f5893D = 10;

    /* renamed from: E, reason: collision with root package name */
    public static int f5894E = 2;

    /* renamed from: F, reason: collision with root package name */
    public static int f5895F = 7;

    /* renamed from: G, reason: collision with root package name */
    public static int f5896G = 20;

    /* renamed from: H, reason: collision with root package name */
    public static int f5897H = 70;

    /* renamed from: I, reason: collision with root package name */
    public static int f5898I = 120;

    /* renamed from: J, reason: collision with root package name */
    public static float f5899J = 2.0f;

    /* renamed from: K, reason: collision with root package name */
    public static float f5900K = 10.0f;

    /* renamed from: L, reason: collision with root package name */
    public static float f5901L = 50.0f;

    /* renamed from: M, reason: collision with root package name */
    public static float f5902M = 200.0f;

    /* renamed from: N, reason: collision with root package name */
    public static int f5903N = 16;

    /* renamed from: O, reason: collision with root package name */
    public static int f5904O = 32;

    /* renamed from: P, reason: collision with root package name */
    public static float f5905P = 0.9f;

    /* renamed from: Q, reason: collision with root package name */
    public static int f5906Q = 10000;

    /* renamed from: R, reason: collision with root package name */
    public static float f5907R = 0.5f;

    /* renamed from: S, reason: collision with root package name */
    public static float f5908S = 0.0f;
    public static float T = 0.1f;

    /* renamed from: U, reason: collision with root package name */
    public static int f5909U = 30;

    /* renamed from: V, reason: collision with root package name */
    public static int f5910V = 100;

    /* renamed from: W, reason: collision with root package name */
    public static int f5911W = 0;

    /* renamed from: X, reason: collision with root package name */
    public static int f5912X = 0;

    /* renamed from: Y, reason: collision with root package name */
    public static int f5913Y = 0;

    /* renamed from: Z, reason: collision with root package name */
    public static int f5914Z = 420000;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f5915a = false;
    public static float aA = 0.75f;
    public static double aB = -0.10000000149011612d;
    public static int aC = 0;
    public static int aD = 0;
    public static int aE = 1;
    public static int aF = 1;
    public static int aG = 0;
    public static float aH = 0.8f;
    public static float aI = 0.2f;
    public static int aJ = 0;
    public static int[] aK = null;
    public static boolean aL = false;
    public static int aM = 8;
    public static int aN = 4000;
    public static int aO = 1;
    public static boolean aP = false;
    public static int aQ = -1;
    public static int aR = 10;
    public static int aS = 3;
    public static int aT = 40;
    public static double[] aU = null;
    public static int aV = 1;
    public static int aW = 1;
    public static int aX = 1;
    public static boolean aa = true;
    public static boolean ab = true;
    public static int ac = 20;
    public static int ad = 300;
    public static int ae = 1000;
    public static int af = Integer.MAX_VALUE;
    public static long ag = 900000;
    public static long ah = 420000;
    public static long ai = 180000;
    public static long aj = 0;
    public static long ak = 15;
    public static long al = 300000;
    public static int am = 1000;
    public static int an = 0;
    public static int ao = 30000;
    public static int ap = 30000;
    public static float aq = 10.0f;
    public static float ar = 6.0f;
    public static float as = 10.0f;
    public static int at = 60;
    public static int au = 70;
    public static int av = 6;
    public static String aw = null;
    public static boolean ax = false;
    public static int ay = 16;
    public static int az = 15;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f5916b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f5917c = false;

    /* renamed from: d, reason: collision with root package name */
    public static int f5918d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static String f5919e = "no";

    /* renamed from: f, reason: collision with root package name */
    public static int f5920f = 4;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f5921g = false;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f5922h = false;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f5923i = false;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f5924j = false;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f5925k = false;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f5926l = false;

    /* renamed from: m, reason: collision with root package name */
    public static String f5927m = "gcj02";

    /* renamed from: n, reason: collision with root package name */
    public static String f5928n = "";

    /* renamed from: o, reason: collision with root package name */
    public static boolean f5929o = true;

    /* renamed from: p, reason: collision with root package name */
    public static int f5930p = 3;

    /* renamed from: q, reason: collision with root package name */
    public static double f5931q = 0.0d;

    /* renamed from: r, reason: collision with root package name */
    public static double f5932r = 0.0d;

    /* renamed from: s, reason: collision with root package name */
    public static double f5933s = 0.0d;

    /* renamed from: t, reason: collision with root package name */
    public static double f5934t = 0.0d;

    /* renamed from: u, reason: collision with root package name */
    public static int f5935u = 0;

    /* renamed from: v, reason: collision with root package name */
    public static byte[] f5936v = null;

    /* renamed from: w, reason: collision with root package name */
    public static boolean f5937w = false;

    /* renamed from: x, reason: collision with root package name */
    public static int f5938x = 0;

    /* renamed from: y, reason: collision with root package name */
    public static float f5939y = 1.1f;

    /* renamed from: z, reason: collision with root package name */
    public static float f5940z = 2.2f;
    private static String bd = Build.MANUFACTURER;
    public static boolean aY = false;
    public static String aZ = null;
    public static int ba = -1;
    public static String bb = null;
    public static String bc = null;

    public static double a(double d4, double d5, double d6, double d7) {
        Location.distanceBetween(d4, d5, d6, d7, new float[1]);
        return r0[0];
    }

    public static int b(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode", -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static long c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime() / 1000;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String d() {
        return d.f5849k;
    }

    public static String e() {
        String absolutePath;
        if (com.baidu.location.f.getServiceContext() != null) {
            try {
                absolutePath = com.baidu.location.f.getServiceContext().getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath();
            } catch (Exception unused) {
            }
        } else {
            absolutePath = null;
        }
        if (absolutePath != null) {
            try {
                File file = new File(absolutePath.concat("/baidu/tempdata"));
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return absolutePath;
    }

    public static String f() {
        String strE = e();
        if (strE == null) {
            return null;
        }
        return strE.concat("/baidu/tempdata");
    }

    public static int g(Context context) {
        int iA = a(context, PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) | a(context, PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION);
        if (b(context) != 0 && iA == 1) {
            return 1;
        }
        if (b(context) == 0 || iA == 1) {
            return (b(context) >= 1 || iA != 1) ? 0 : -1;
        }
        return -2;
    }

    public static String h() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            return com.baidu.location.f.getServiceContext().getFilesDir().getPath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String i() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(com.baidu.location.f.getServiceContext().getFilesDir());
            String str = File.separator;
            sb.append(str);
            sb.append("/baidu/tempdata");
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return com.baidu.location.f.getServiceContext().getFilesDir().getPath() + str + "/baidu/tempdata";
        } catch (Exception unused) {
            return null;
        }
    }

    public static String j() {
        return b("ro.mediatek.platform");
    }

    public static SSLSocketFactory k() throws Exception {
        TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.baidu.location.e.h.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                for (X509Certificate x509Certificate : x509CertificateArr) {
                    x509Certificate.checkValidity();
                }
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagerArr, new SecureRandom());
        return sSLContext.getSocketFactory();
    }

    public static int a(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Exception unused) {
            return 2;
        }
    }

    public static String b(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            if (TextUtils.isEmpty(line)) {
                return null;
            }
            return line;
        } catch (Exception unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public static String c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet6Address) && inetAddressNextElement.getHostAddress() != null && !inetAddressNextElement.getHostAddress().startsWith("fe80:")) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d(Context context) {
        int iA = a(context, PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION);
        int iA2 = a(context, PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION);
        int iA3 = a(context, PolicySdkPermissionManifestUtils.READ_PHONE_STATE);
        int iA4 = a(context, PolicySdkPermissionManifestUtils.ACCESS_BACKGROUND_LOCATION);
        StringBuilder sbU = B0.g.u("&per=", iA, Consts.SPLITTER_DETAIL, iA2, Consts.SPLITTER_DETAIL);
        sbU.append(iA3);
        sbU.append(Consts.SPLITTER_DETAIL);
        sbU.append(iA4);
        return sbU.toString();
    }

    public static String e(Context context) {
        int type = -1;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    type = activeNetworkInfo.getType();
                }
            } catch (Throwable unused) {
            }
        }
        return AbstractC0351g.m("&netc=", type);
    }

    public static String f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String g() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean h(Context context) {
        if (context == null) {
            return false;
        }
        return a(context, PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) == 0 && a(context, PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION) == 1;
    }

    public static boolean i(Context context) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12)) {
                return false;
            }
            return networkCapabilities.hasCapability(16);
        } catch (Exception unused) {
            return false;
        }
    }

    public static int a(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static boolean b() {
        return false;
    }

    public static boolean c(Context context) {
        if (context != null) {
            try {
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            boolean z4 = a(context, PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION) == 1;
            if (z4) {
                try {
                    if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 1) == 0) {
                        return false;
                    }
                } catch (Exception unused) {
                }
            }
            return z4;
        }
        return true;
    }

    public static int a(Object obj, String str) throws Exception {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, null);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, null)).intValue();
    }

    public static boolean b(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static int a(String str, String str2, String str3) {
        int iIndexOf;
        int length;
        int iIndexOf2;
        String strSubstring;
        if (str != null && !str.equals("") && (iIndexOf = str.indexOf(str2)) != -1 && (iIndexOf2 = str.indexOf(str3, (length = str2.length() + iIndexOf))) != -1 && (strSubstring = str.substring(length, iIndexOf2)) != null && !strSubstring.equals("")) {
            try {
                return Integer.parseInt(strSubstring);
            } catch (NumberFormatException unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] b(byte[] r4) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r4 == 0) goto L51
            int r1 = r4.length
            if (r1 != 0) goto L7
            goto L51
        L7:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r4)
            r4 = 0
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L36
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L36
            r4 = 2048(0x800, float:2.87E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
        L1b:
            int r2 = r3.read(r4)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            if (r2 < 0) goto L29
            r1.write(r4, r0, r2)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            goto L1b
        L25:
            r4 = move-exception
            goto L46
        L27:
            r4 = move-exception
            goto L39
        L29:
            r3.close()     // Catch: java.io.IOException -> L2d
            goto L41
        L2d:
            r4 = move-exception
            r4.printStackTrace()
            goto L41
        L32:
            r0 = move-exception
            r3 = r4
            r4 = r0
            goto L46
        L36:
            r0 = move-exception
            r3 = r4
            r4 = r0
        L39:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L41
            r3.close()     // Catch: java.io.IOException -> L2d
        L41:
            byte[] r4 = r1.toByteArray()
            return r4
        L46:
            if (r3 == 0) goto L50
            r3.close()     // Catch: java.io.IOException -> L4c
            goto L50
        L4c:
            r0 = move-exception
            r0.printStackTrace()
        L50:
            throw r4
        L51:
            byte[] r4 = new byte[r0]
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.h.b(byte[]):byte[]");
    }

    public static String a() {
        Calendar calendar = Calendar.getInstance();
        int i4 = calendar.get(5);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i4), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    public static String a(com.baidu.location.c.a aVar, k kVar, Location location, String str, int i4) {
        return a(aVar, kVar, location, str, i4, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ca A[Catch: Exception -> 0x00cd, TRY_LEAVE, TryCatch #0 {Exception -> 0x00cd, blocks: (B:40:0x008b, B:44:0x00a9, B:47:0x00af, B:48:0x00b2, B:53:0x00be, B:55:0x00c2, B:57:0x00c6, B:58:0x00ca), top: B:62:0x008b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(com.baidu.location.c.a r4, com.baidu.location.c.k r5, android.location.Location r6, java.lang.String r7, int r8, boolean r9) {
        /*
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r0 = 2048(0x800, float:2.87E-42)
            r9.<init>(r0)
            if (r4 == 0) goto L16
            com.baidu.location.c.f r0 = com.baidu.location.c.f.a()
            java.lang.String r0 = r0.b(r4)
            if (r0 == 0) goto L16
            r9.append(r0)
        L16:
            r0 = 1
            if (r5 == 0) goto L30
            com.baidu.location.c.f r1 = com.baidu.location.c.f.a()
            if (r8 != 0) goto L28
            int r2 = com.baidu.location.e.h.f5903N
        L21:
            int r3 = com.baidu.location.e.h.ay
            java.lang.String r1 = r1.a(r2, r0, r5, r3)
            goto L2b
        L28:
            int r2 = com.baidu.location.e.h.az
            goto L21
        L2b:
            if (r1 == 0) goto L30
            r9.append(r1)
        L30:
            if (r6 == 0) goto L46
            int r1 = com.baidu.location.e.h.f5918d
            if (r1 == 0) goto L3d
            if (r8 == 0) goto L3d
            java.lang.String r1 = com.baidu.location.c.d.c(r6)
            goto L41
        L3d:
            java.lang.String r1 = com.baidu.location.c.d.b(r6)
        L41:
            if (r1 == 0) goto L46
            r9.append(r1)
        L46:
            if (r8 != 0) goto L4a
            r8 = r0
            goto L4b
        L4a:
            r8 = 0
        L4b:
            com.baidu.location.e.b r1 = com.baidu.location.e.b.a()
            java.lang.String r8 = r1.a(r8)
            if (r8 == 0) goto L58
            r9.append(r8)
        L58:
            if (r7 == 0) goto L5d
            r9.append(r7)
        L5d:
            com.baidu.location.c.d r7 = com.baidu.location.c.d.a()
            java.lang.String r7 = r7.m()
            r9.append(r7)
            com.baidu.location.c.f r7 = com.baidu.location.c.f.a()
            java.lang.String r4 = r7.a(r4)
            if (r4 == 0) goto L82
            int r7 = r4.length()
            int r8 = r9.length()
            int r8 = r8 + r7
            r7 = 2000(0x7d0, float:2.803E-42)
            if (r8 >= r7) goto L82
            r9.append(r4)
        L82:
            java.lang.String r4 = r9.toString()
            r7 = 3
            if (r6 == 0) goto Lca
            if (r5 == 0) goto Lca
            float r6 = r6.getSpeed()     // Catch: java.lang.Exception -> Lcd
            int r8 = com.baidu.location.e.h.f5918d     // Catch: java.lang.Exception -> Lcd
            com.baidu.location.c.f r9 = com.baidu.location.c.f.a()     // Catch: java.lang.Exception -> Lcd
            int r9 = r9.a(r5)     // Catch: java.lang.Exception -> Lcd
            int r1 = r5.a()     // Catch: java.lang.Exception -> Lcd
            boolean r5 = r5.f5758d     // Catch: java.lang.Exception -> Lcd
            float r2 = com.baidu.location.e.h.ar     // Catch: java.lang.Exception -> Lcd
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 >= 0) goto Lb2
            if (r8 == r0) goto La9
            if (r8 != 0) goto Lb2
        La9:
            int r2 = com.baidu.location.e.h.at     // Catch: java.lang.Exception -> Lcd
            if (r9 < r2) goto Laf
            if (r5 != r0) goto Lb2
        Laf:
            com.baidu.location.e.h.f5930p = r0     // Catch: java.lang.Exception -> Lcd
            goto Lcf
        Lb2:
            float r5 = com.baidu.location.e.h.as     // Catch: java.lang.Exception -> Lcd
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 >= 0) goto Lca
            if (r8 == r0) goto Lbe
            if (r8 == 0) goto Lbe
            if (r8 != r7) goto Lca
        Lbe:
            int r5 = com.baidu.location.e.h.au     // Catch: java.lang.Exception -> Lcd
            if (r9 < r5) goto Lc6
            int r5 = com.baidu.location.e.h.av     // Catch: java.lang.Exception -> Lcd
            if (r1 <= r5) goto Lca
        Lc6:
            r5 = 2
            com.baidu.location.e.h.f5930p = r5     // Catch: java.lang.Exception -> Lcd
            goto Lcf
        Lca:
            com.baidu.location.e.h.f5930p = r7     // Catch: java.lang.Exception -> Lcd
            goto Lcf
        Lcd:
            com.baidu.location.e.h.f5930p = r7
        Lcf:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.h.a(com.baidu.location.c.a, com.baidu.location.c.k, android.location.Location, java.lang.String, int, boolean):java.lang.String");
    }

    public static String a(String str) {
        return Jni.en1(f5928n + ";" + str);
    }

    public static String a(byte[] bArr, String str, boolean z4) {
        StringBuilder sb = new StringBuilder();
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & UByte.MAX_VALUE);
            if (z4) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("enc3")) {
                return new String(b(Base64.decode(jSONObject.optString("enc3").getBytes(), 0)), Constants.UTF_8_CODE);
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static String a(byte[] bArr, boolean z4) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z4);
        } catch (NoSuchAlgorithmException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static boolean a(double d4, double d5) {
        return Math.abs(d4 - d5) <= 1.192092896E-7d;
    }

    public static boolean a(float f4, float f5) {
        return Math.abs(f4 - f5) <= 1.1920929E-7f;
    }

    public static boolean a(Location location) {
        String str;
        if (location == null || (str = bd) == null || !"huawei".equalsIgnoreCase(str)) {
            return false;
        }
        try {
            Bundle extras = location.getExtras();
            if (extras != null) {
                return (extras.getInt("SourceType") & 128) == 128;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return (locType > 100 && locType < 200) || locType == 62;
    }

    public static boolean a(int[] iArr) {
        if (iArr != null && iArr.length >= 18) {
            for (int i4 : iArr) {
                if (i4 == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
