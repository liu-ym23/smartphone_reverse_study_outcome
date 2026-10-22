package com.amap.api.col.jmsl;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Parcel;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.zyql.ai.selector.config.PictureConfig;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class S0 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f16312a = "";

    /* renamed from: b, reason: collision with root package name */
    public static volatile String f16313b = "";

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f16314c = true;

    /* renamed from: d, reason: collision with root package name */
    public static String f16315d = null;

    /* renamed from: e, reason: collision with root package name */
    public static d f16316e = null;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f16317f = false;

    /* renamed from: g, reason: collision with root package name */
    public static String f16318g = "";

    /* renamed from: h, reason: collision with root package name */
    public static boolean f16319h = false;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f16320i = true;

    /* renamed from: j, reason: collision with root package name */
    public static String f16321j;

    /* renamed from: k, reason: collision with root package name */
    public static IBinder f16322k;

    /* renamed from: v, reason: collision with root package name */
    public static long f16333v;

    /* renamed from: w, reason: collision with root package name */
    public static int f16334w;

    /* renamed from: x, reason: collision with root package name */
    public static String f16335x;

    /* renamed from: l, reason: collision with root package name */
    public static final AtomicBoolean f16323l = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    public static boolean f16324m = false;

    /* renamed from: n, reason: collision with root package name */
    public static final AtomicBoolean f16325n = new AtomicBoolean(false);

    /* renamed from: o, reason: collision with root package name */
    public static String f16326o = "";

    /* renamed from: p, reason: collision with root package name */
    public static String f16327p = "";

    /* renamed from: q, reason: collision with root package name */
    public static boolean f16328q = false;

    /* renamed from: r, reason: collision with root package name */
    public static String f16329r = "";

    /* renamed from: s, reason: collision with root package name */
    public static String f16330s = "";

    /* renamed from: t, reason: collision with root package name */
    public static String f16331t = "";

    /* renamed from: u, reason: collision with root package name */
    public static String f16332u = "";

    /* renamed from: y, reason: collision with root package name */
    public static String f16336y = "";

    /* renamed from: z, reason: collision with root package name */
    public static boolean f16337z = false;

    /* renamed from: A, reason: collision with root package name */
    public static int f16307A = -1;

    /* renamed from: B, reason: collision with root package name */
    public static boolean f16308B = false;

    /* renamed from: C, reason: collision with root package name */
    public static int f16309C = -1;

    /* renamed from: D, reason: collision with root package name */
    public static boolean f16310D = false;

    /* renamed from: E, reason: collision with root package name */
    public static volatile e f16311E = null;

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f16338a;

        public a(Context context) {
            this.f16338a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Map<String, String> mapB = S0.f16316e.b();
                String strA = S0.f16316e.a(S0.D(this.f16338a), "", "", "");
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                String strB = S0.f16316e.b(this.f16338a, new String(C1540c1.b().d(S0.f16316e.c(strA.getBytes(), mapB)).f16719a));
                if (TextUtils.isEmpty(strB)) {
                    return;
                }
                S0.f16313b = strB;
            } catch (Throwable unused) {
            }
        }
    }

    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f16339a;

        public b(Context context) {
            this.f16339a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            S0.n(this.f16339a);
        }
    }

    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f16340a;

        public c(Context context) {
            this.f16340a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            S0.p(this.f16340a.getApplicationContext());
        }
    }

    public interface d {
        String a();

        String a(String str, String str2, String str3, String str4);

        String b(Context context, String str);

        Map<String, String> b();

        s7 c(byte[] bArr, Map<String, String> map);
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static ConnectivityManager f16341a;

        /* renamed from: b, reason: collision with root package name */
        public static NetworkRequest f16342b;

        /* renamed from: c, reason: collision with root package name */
        public static ConnectivityManager.NetworkCallback f16343c;

        public class a extends ConnectivityManager.NetworkCallback {
            public a(e eVar) {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                super.onAvailable(network);
                S0.r();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
                S0.r();
            }
        }

        @SuppressLint({"WrongConstant", "MissingPermission"})
        public final void a(Context context) {
            if (S0.j(context, C1604s2.m("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f16341a == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                f16341a = connectivityManager;
                if (connectivityManager != null) {
                    f16342b = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
                    a aVar = new a(this);
                    f16343c = aVar;
                    f16341a.registerNetworkCallback(f16342b, aVar);
                }
            }
        }
    }

    public static class f implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder unused = S0.f16322k = iBinder;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static String A(Context context) {
        if (!f16320i || f16319h) {
            return "";
        }
        if (!TextUtils.isEmpty(f16318g)) {
            return f16318g;
        }
        if (f16323l.compareAndSet(false, true)) {
            new Thread(new b(context), "OD-Thread").start();
        }
        return f16318g;
    }

    public static int B(Context context) {
        int i10 = f16334w;
        if (i10 != 0) {
            return i10;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        int i11 = ((int) (memoryInfo.totalMem / 1024)) / 1024;
        f16334w = i11;
        return i11;
    }

    public static String C(Context context) {
        try {
            if (!TextUtils.isEmpty(f16321j)) {
                return f16321j;
            }
            byte[] bArrDigest = MessageDigest.getInstance(C1604s2.m("IU0hBMQ")).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b10 : bArrDigest) {
                stringBuffer.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
            }
            String string = stringBuffer.toString();
            if (!TextUtils.isEmpty(string)) {
                f16321j = string;
            }
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String D(Context context) {
        if (f16324m) {
            return f16312a == null ? "" : f16312a;
        }
        if (f16312a != null && !"".equals(f16312a)) {
            return f16312a;
        }
        if (f16325n.compareAndSet(false, true)) {
            new Thread(new c(context), "UD-Thread").start();
        }
        return f16312a == null ? "" : f16312a;
    }

    public static String E(Context context) {
        if (!TextUtils.isEmpty(f16332u)) {
            return f16332u;
        }
        try {
            String strM = C1575l0.m(context, "open_common", SdCardDbCreator.FIELD_LASTLOC_ID, "");
            if (TextUtils.isEmpty(strM)) {
                f16332u = Const.STR_PUBLIC_TAG + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor editorB = C1575l0.b(context, "open_common");
                C1575l0.h(editorB, SdCardDbCreator.FIELD_LASTLOC_ID, C1604s2.v(f16332u));
                C1575l0.e(editorB);
            } else {
                f16332u = C1604s2.m(strM);
            }
            return f16332u;
        } catch (Throwable unused) {
            return f16332u;
        }
    }

    public static String F(Context context) {
        FileInputStream fileInputStream;
        XmlPullParser xmlPullParserNewPullParser;
        int eventType;
        try {
            File file = new File(context.getExternalCacheDir().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
            xmlPullParserNewPullParser = Xml.newPullParser();
            fileInputStream = new FileInputStream(file);
        } catch (Throwable unused) {
            fileInputStream = null;
        }
        try {
            xmlPullParserNewPullParser.setInput(fileInputStream, "utf-8");
            boolean z10 = false;
            for (eventType = xmlPullParserNewPullParser.getEventType(); 1 != eventType; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        z10 = false;
                    } else if (eventType == 4 && z10) {
                        String text = xmlPullParserNewPullParser.getText();
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                        return text;
                    }
                } else if (xmlPullParserNewPullParser.getAttributeCount() > 0) {
                    int attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                    for (int i10 = 0; i10 < attributeCount; i10++) {
                        String attributeValue = xmlPullParserNewPullParser.getAttributeValue(i10);
                        if ("UTDID2".equals(attributeValue) || "UTDID".equals(attributeValue)) {
                            z10 = true;
                        }
                    }
                }
            }
        } catch (Throwable unused3) {
            if (fileInputStream == null) {
                return "";
            }
            fileInputStream.close();
            return "";
        }
        try {
            fileInputStream.close();
            return "";
        } catch (Throwable unused4) {
            return "";
        }
    }

    public static String G(Context context) {
        if (f16337z) {
            return f16336y;
        }
        a(context);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return f16336y;
        }
        String simOperatorName = telephonyManager.getSimOperatorName();
        f16336y = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            f16336y = telephonyManager.getNetworkOperatorName();
        }
        f16337z = true;
        return f16336y;
    }

    public static int H(Context context) {
        if (f16308B) {
            return f16307A;
        }
        a(context);
        if (context == null || !j(context, C1604s2.m("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return f16307A;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return f16307A;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            f16308B = true;
            return f16307A;
        }
        int type = activeNetworkInfo.getType();
        f16307A = type;
        f16308B = true;
        return type;
    }

    public static int I(Context context) {
        ConnectivityManager connectivityManager;
        if (f16310D) {
            return f16309C;
        }
        a(context);
        if (j(context, C1604s2.m("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                f16309C = activeNetworkInfo.getSubtype();
                f16310D = true;
            }
            return f16309C;
        }
        return f16309C;
    }

    public static String J(Context context) {
        String string;
        if (!f16314c) {
            return "";
        }
        try {
            string = K(context);
        } catch (Throwable unused) {
            string = "";
        }
        try {
            if (TextUtils.isEmpty(string)) {
                string = context.getSharedPreferences(C1604s2.m("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(L1.c(C1604s2.m("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
            }
        } catch (Throwable unused2) {
            string = null;
        }
        if (TextUtils.isEmpty(string)) {
            f16314c = false;
            return "";
        }
        try {
            byte[] bytes = C1604s2.m("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new String(C1568j1.f(C1604s2.m("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), C1568j1.b(string), bytes), "UTF-8");
        } catch (Throwable unused3) {
            f16314c = false;
            return "";
        }
    }

    public static String K(Context context) {
        ByteArrayOutputStream byteArrayOutputStream;
        String[] strArrSplit;
        File externalCacheDir;
        String strC = L1.c(C1604s2.m("LYW1hcF9kZXZpY2VfYWRpdQ"));
        RandomAccessFile randomAccessFile = null;
        try {
            externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = context.getCacheDir();
            }
        } catch (Exception unused) {
        }
        String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
        if (TextUtils.isEmpty(absolutePath)) {
            return "";
        }
        File file = new File(absolutePath + File.separator + C1604s2.m("KYmFja3Vwcw"), C1604s2.m("MLmFkaXU"));
        if (file.exists() && file.canRead()) {
            if (file.length() == 0) {
                file.delete();
                return "";
            }
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
                try {
                    byte[] bArr = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i10 = randomAccessFile2.read(bArr);
                            if (i10 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i10);
                        } catch (Throwable unused2) {
                        }
                    }
                    String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    if (!TextUtils.isEmpty(str) && str.contains(C1604s2.m("SIw")) && (strArrSplit = str.split(C1604s2.m("SIw"))) != null && strArrSplit.length == 2 && TextUtils.equals(strC, strArrSplit[0])) {
                        String str2 = strArrSplit[1];
                        f(byteArrayOutputStream);
                        f(randomAccessFile2);
                        return str2;
                    }
                } catch (Throwable unused3) {
                    byteArrayOutputStream = null;
                }
                randomAccessFile = randomAccessFile2;
            } catch (Throwable unused4) {
                byteArrayOutputStream = null;
            }
            f(byteArrayOutputStream);
            f(randomAccessFile);
        }
        return "";
    }

    public static synchronized e a(Context context) {
        try {
            if (f16311E == null) {
                if (context == null) {
                    return null;
                }
                e eVar = new e();
                f16311E = eVar;
                eVar.a(context.getApplicationContext());
            }
            return f16311E;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static String c() {
        if (!TextUtils.isEmpty(f16335x)) {
            return f16335x;
        }
        String property = System.getProperty("os.arch");
        f16335x = property;
        return property;
    }

    public static String d(Context context) {
        TelephonyManager telephonyManager;
        if (f16328q) {
            return f16327p;
        }
        try {
            a(context);
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
        }
        if (telephonyManager == null) {
            return f16327p;
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            f16327p = networkOperator.substring(3);
            f16328q = true;
            return f16327p;
        }
        f16328q = true;
        return f16327p;
    }

    /* JADX WARN: Finally extract failed */
    public static String e(Context context, int i10) {
        try {
            Intent intent = new Intent();
            if (i10 == 2) {
                intent.setAction(C1604s2.m("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(C1604s2.m("UY29tLmh1YXdlaS5od2lk"));
            } else if (i10 == 4) {
                intent.setClassName(C1604s2.m("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), C1604s2.m("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else {
                if (i10 != 5) {
                    f16319h = true;
                    return f16318g;
                }
                intent.setClassName(C1604s2.m("YY29tLmhleXRhcC5vcGVuaWQ"), C1604s2.m("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(C1604s2.m("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            f fVar = new f();
            if (context.bindService(intent, fVar, 1)) {
                int i11 = 0;
                while (i11 < 100 && TextUtils.isEmpty(f16318g)) {
                    i11++;
                    if (f16322k != null) {
                        Parcel parcelObtain = Parcel.obtain();
                        Parcel parcelObtain2 = Parcel.obtain();
                        if (i10 == 2) {
                            parcelObtain.writeInterfaceToken(C1604s2.m("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"));
                        } else if (i10 != 4) {
                            if (i10 == 5) {
                                try {
                                    parcelObtain.writeInterfaceToken(C1604s2.m("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));
                                    parcelObtain.writeString(context.getPackageName());
                                    parcelObtain.writeString(C(context));
                                    parcelObtain.writeString(C1604s2.m("IT1VJRA"));
                                } catch (Throwable th) {
                                    try {
                                        C1611u1.b(th, "oac", String.valueOf(i10));
                                        parcelObtain2.recycle();
                                    } catch (Throwable th2) {
                                        parcelObtain2.recycle();
                                        parcelObtain.recycle();
                                        throw th2;
                                    }
                                }
                            }
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            parcelObtain.writeInterfaceToken(C1604s2.m("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"));
                        }
                        f16322k.transact(1, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        f16318g = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                    Thread.sleep(15L);
                }
                context.unbindService(fVar);
                f16322k = null;
            }
            return f16318g;
        } catch (Throwable th3) {
            C1611u1.b(th3, "oa", String.valueOf(i10));
            f16319h = true;
            return f16318g;
        }
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String h() {
        return f16330s;
    }

    public static String i(Context context) {
        String str;
        StringBuilder sb2;
        try {
            str = f16329r;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f16329r;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return "";
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        if (i11 > i10) {
            sb2 = new StringBuilder();
            sb2.append(i10);
            sb2.append("*");
            sb2.append(i11);
        } else {
            sb2 = new StringBuilder();
            sb2.append(i11);
            sb2.append("*");
            sb2.append(i10);
        }
        f16329r = sb2.toString();
        return f16329r;
    }

    public static boolean j(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String k() {
        return f16326o;
    }

    public static String l(Context context) {
        try {
            return G(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long m() {
        long j10 = f16333v;
        if (j10 != 0) {
            return j10;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            f16333v = ((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / PictureConfig.MB) + ((statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / PictureConfig.MB);
        } catch (Throwable unused) {
        }
        return f16333v;
    }

    public static String n(Context context) {
        String strM = C1604s2.m("IeGlhb21p");
        String str = Build.MANUFACTURER;
        if (!strM.equalsIgnoreCase(str)) {
            String strM2 = C1604s2.m("IeGlhb21p");
            String str2 = Build.BRAND;
            if (!strM2.equalsIgnoreCase(str2) && !C1604s2.m("IUkVETUk=").equalsIgnoreCase(str) && !C1604s2.m("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (!C1604s2.m("Idml2bw").equalsIgnoreCase(str) && !C1604s2.m("Idml2bw").equalsIgnoreCase(str2)) {
                    if (C1604s2.m("IaHVhd2Vp").equalsIgnoreCase(str) || C1604s2.m("IaHVhd2Vp").equalsIgnoreCase(str2) || C1604s2.m("ISE9OT1I=").equalsIgnoreCase(str)) {
                        return e(context, 2);
                    }
                    if (C1604s2.m("Mc2Ftc3VuZw").equalsIgnoreCase(str) || C1604s2.m("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                        return e(context, 4);
                    }
                    if (C1604s2.m("IT1BQTw").equalsIgnoreCase(str) || C1604s2.m("IT1BQTw").equalsIgnoreCase(str2) || C1604s2.m("MT25lUGx1cw").equalsIgnoreCase(str) || C1604s2.m("MT25lUGx1cw").equalsIgnoreCase(str2) || C1604s2.m("IUkVBTE1F").equalsIgnoreCase(str2)) {
                        return e(context, 5);
                    }
                    f16319h = true;
                    return f16318g;
                }
                try {
                    Cursor cursorQuery = context.getContentResolver().query(Uri.parse(C1604s2.m("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            int columnCount = cursorQuery.getColumnCount();
                            int i10 = 0;
                            while (true) {
                                if (i10 >= columnCount) {
                                    break;
                                }
                                if (C1604s2.m("IdmFsdWU").equals(cursorQuery.getColumnName(i10))) {
                                    f16318g = cursorQuery.getString(i10);
                                    break;
                                }
                                i10++;
                            }
                        }
                        cursorQuery.close();
                    }
                } catch (Throwable th) {
                    f16319h = true;
                    C1611u1.b(th, "oa", Const.BRAND_VIVO);
                }
                return f16318g;
            }
        }
        try {
            Class<?> cls = Class.forName(C1604s2.m("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object objInvoke = cls.getMethod(C1604s2.m("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (objInvoke != null) {
                String str3 = (String) objInvoke;
                f16318g = str3;
                return str3;
            }
        } catch (Throwable th2) {
            C1611u1.b(th2, "oa", "xm");
            f16319h = true;
        }
        return f16318g;
    }

    public static String o() {
        return f16315d;
    }

    public static void p(Context context) {
        String strM = "";
        try {
            if (j(context, C1604s2.m("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
                f16312a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (!TextUtils.isEmpty(f16312a)) {
                f16324m = true;
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            String strM2 = C1575l0.m(context, "Alvin2", "UTDID2", "");
            strM = TextUtils.isEmpty(strM2) ? C1575l0.m(context, "Alvin2", "UTDID", "") : strM2;
        } catch (Throwable unused2) {
        }
        try {
            f16312a = strM;
            if (!TextUtils.isEmpty(strM)) {
                f16324m = true;
                return;
            }
        } catch (Throwable unused3) {
        }
        try {
            f16312a = F(context);
            f16324m = true;
        } catch (Throwable unused4) {
        }
    }

    public static String q(Context context) {
        if (!TextUtils.isEmpty(f16313b)) {
            return f16313b;
        }
        if (context == null) {
            return "";
        }
        String strJ = J(context);
        f16313b = strJ;
        if (!TextUtils.isEmpty(strJ)) {
            return f16313b;
        }
        if (f16316e == null || f16317f) {
            return "";
        }
        f16317f = true;
        new Thread(new a(context), "ADIUFetchingThread").start();
        return "";
    }

    public static void r() {
        f16307A = -1;
        f16308B = false;
        f16309C = -1;
        f16310D = false;
        f16336y = "";
        f16337z = false;
        f16327p = "";
        f16328q = false;
    }

    public static int s(Context context) {
        try {
            return H(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String t(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            return (!j(context, C1604s2.m("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int u(Context context) {
        try {
            return H(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int v(Context context) {
        try {
            return I(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String w(Context context) {
        try {
            return G(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static NetworkInfo x(Context context) {
        ConnectivityManager connectivityManager;
        if (j(context, C1604s2.m("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static int y(Context context) {
        try {
            return I(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String z(Context context) {
        String str;
        str = "";
        try {
            String strA = f16330s;
            try {
                if (TextUtils.isEmpty(strA)) {
                    strA = q(context);
                }
                if (TextUtils.isEmpty(strA)) {
                    strA = D(context);
                }
                if (TextUtils.isEmpty(strA)) {
                    strA = A(context);
                }
                str = TextUtils.isEmpty(strA) ? "" : strA;
                return TextUtils.isEmpty(str) ? E(context) : str;
            } catch (Throwable unused) {
                return strA;
            }
        } catch (Throwable unused2) {
            return str;
        }
    }
}
