package com.amap.api.col.s;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.ai.api.navi.AppletNaviThirdApp;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes28.dex */
public final class bm {
    private static String A = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f26275a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static String f26276b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile boolean f26277c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f26278d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static String f26279e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static boolean f26280f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static a f26281g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static int f26282h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static String f26283i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static String f26284j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f26285k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f26286l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile boolean f26287m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static String f26288n = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f26289o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f26290p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f26291q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static String f26292r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static String f26293s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static String f26294t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static String f26295u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static boolean f26296v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static String f26297w = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static long f26298x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static int f26299y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static String f26300z;

    public interface a {
        cy a(byte[] r100, Map<String, String> r101);

        String a();

        String a(Context r100, String r101);

        String a(String r100, String r101, String r102, String r103);

        Map<String, String> b();
    }

    public static class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            Parcel r102 = Parcel.obtain();
            Parcel r103 = Parcel.obtain();
            r102.writeInterfaceToken(com.alipay.sdk.m.c.b.f25240a);     // Catch: Throwable -> L6
            INVOKEINTERFACE_com_amap_api_col_s_bm$b_com_obric_assistant_interaction_impl_BinderLancet_transact(r101, 1, r102, r103, 0);     // Catch: Throwable -> L6
            r103.readException();     // Catch: Throwable -> L6
            bm.a(r103.readString());     // Catch: Throwable -> L6
        L4:
            r103.recycle();
            r102.recycle();
            return;
        L6:
            th = move-exception;
            bm.g();     // Catch: Throwable -> L9
            cd.a(th, "oa", "hwtr");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            r103.recycle();
            r102.recycle();
            throw th;
        }

        @Skip({"com.obric.assistant.interaction.impl.performance"})
        public static boolean INVOKEINTERFACE_com_amap_api_col_s_bm$b_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
            if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
            long r100 = SystemClock.uptimeMillis();
            boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
            long r102 = SystemClock.uptimeMillis() - r100;
            if (r102 < 100) goto L11;
            BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
        L11:
            return r101;
        L12:
            th = move-exception;
            long r103 = SystemClock.uptimeMillis() - r100;
            if (r103 < 100) goto L22;
            if (r110 != null) goto L17;
            String r104 = "";
        L18:
            BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
            throw th;
        L17:
            r104 = r110.getClass().getName();
            goto L18
        L22:
            throw th;
        L5:
            return r110.transact(r111, r112, r113, r114);
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ boolean g() {
        f26289o = true;
        return true;
    }

    public static String b() {
        if (TextUtils.isEmpty(f26279e) == false) goto L6;
        a r100 = f26281g;     // Catch: Throwable -> L12
        if (r100 != null) goto L11;
        return "";
    L11:
        return r100.a();
    L6:
        return f26279e;
    L14:
        return "";
    }

    private static String com_amap_api_col_s_bm_android_os_Build_SERIAL() {
        ArrayList r100 = new ArrayList();
        Object[] r110 = new Object[0];
        f06.b r111 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102002);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r103[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r103;
        f06.d r107 = r106.preInvoke(102002, "android/os/Build", "SERIAL", Build.class, r110, "java.lang.String", r111);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return Build.SERIAL;
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r103 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String[] d() {
        return new String[]{"", ""};
    }

    public static long e() {
        long r100 = f26298x;
        if (r100 == 0) goto L9;
        return r100;
    L9:
        StatFs r101 = new StatFs(Environment.getRootDirectory().getAbsolutePath());     // Catch: Throwable -> L8
        StatFs r102 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L8
        f26298x = ((r101.getBlockCountLong() * r101.getBlockSizeLong()) / 1048576) + ((r102.getBlockCountLong() * r102.getBlockSizeLong()) / 1048576);     // Catch: Throwable -> L8
    L7:
        return f26298x;
    }

    public static String f() {
        if (TextUtils.isEmpty(f26300z) == false) goto L5;
        String r100 = System.getProperty("os.arch");
        f26300z = r100;
        return r100;
    L5:
        return f26300z;
    }

    private static String h() {
        Iterator r100 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Exception -> L23
    L5:
        if (r100.hasNext() == false) goto L33;
        NetworkInterface r101 = (NetworkInterface) r100.next();     // Catch: Exception -> L23
        if (r101.getName().equalsIgnoreCase("wlan0") == false) goto L5;
        byte[] r102 = com_amap_api_col_s_bm_java_net_NetworkInterface_getHardwareAddress(r101);     // Catch: Exception -> L23
        if (r102 != null) goto L11;
        return "";
    L11:
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L23
        int r104 = r102.length;     // Catch: Exception -> L23
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L19;
        String r106 = Integer.toHexString(r102[r105] & UByte.MAX_VALUE).toUpperCase();     // Catch: Exception -> L23
        if (r106.length() != 1) goto L17;
        r103.append("0");     // Catch: Exception -> L23
    L17:
        r103.append(r106);     // Catch: Exception -> L23
        r103.append(":");     // Catch: Exception -> L23
        r105 = r105 + 1;     // Catch: Exception -> L23
        goto L13
    L19:
        if (r103.length() <= 0) goto L21;
        r103.deleteCharAt(r103.length() - 1);     // Catch: Exception -> L23
    L21:
        return r103.toString();
    L33:
        return "";
    L32:
        return "";
    }

    public static String a() {
        return f26285k;
    }

    public static a c() {
        return f26281g;
    }

    private static String A(Context r100) {
        String r101 = bs.c("IeGlhb21p");
        String r102 = Build.MANUFACTURER;
        int r103 = 0;
        if (r101.equalsIgnoreCase(r102) == false) goto L10;
        Class r104 = INVOKESTATIC_com_amap_api_col_s_bm_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(bs.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));     // Catch: Throwable -> L8
        Object r105 = r104.newInstance();     // Catch: Throwable -> L8
        Object r106 = r104.getMethod(bs.c("MZ2V0T0FJRA"), new Class[]{Context.class}).invoke(r105, new Object[]{r100});     // Catch: Throwable -> L8
        if (r106 == null) goto L26;
        String r107 = (String) r106;     // Catch: Throwable -> L8
        f26288n = r107;     // Catch: Throwable -> L8
        return r107;
    L26:
        return f26288n;
    L8:
        f26289o = true;
        goto L26
    L10:
        if (bs.c("IaHVhd2Vp").equalsIgnoreCase(r102) == true) goto L27;
        "OPPO".equalsIgnoreCase(r102);
    L24:
        f26289o = true;
        goto L26
    L27:
        Intent r108 = new Intent();     // Catch: Throwable -> L21
        r108.setAction(bs.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));     // Catch: Throwable -> L21
        r108.setPackage(bs.c("UY29tLmh1YXdlaS5od2lk"));     // Catch: Throwable -> L21
        b r109 = new b();     // Catch: Throwable -> L21
        if (r100.bindService(r108, r109, 1) == true) goto L14;
    L19:
        return f26288n;
    L14:
        if (r103 >= 100) goto L18;
        if (TextUtils.isEmpty(f26288n) == false) goto L18;
        r103 = r103 + 1;     // Catch: Throwable -> L21
        Thread.sleep(15);     // Catch: Throwable -> L21
    L18:
        r100.unbindService(r109);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        cd.a(th, "oa", "hw");
        goto L24
    }

    private static String B(Context r100) {
        if (TextUtils.isEmpty(f26297w) == false) goto L5;
        String r101 = ci.b(r100, "open_common", "a1", "");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r101) == false) goto L9;
        f26297w = AppletNaviThirdApp.AMAP + UUID.randomUUID().toString().replace("_", "").toLowerCase();     // Catch: Throwable -> L12
        SharedPreferences.Editor r102 = ci.b(r100, "open_common");     // Catch: Throwable -> L12
        ci.a(r102, "a1", bs.b(f26297w));     // Catch: Throwable -> L12
        ci.a(r102);     // Catch: Throwable -> L12
    L11:
        return f26297w;
    L9:
        f26297w = bs.c(r101);     // Catch: Throwable -> L12
        goto L11
    L13:
        return f26297w;
    L5:
        return f26297w;
    }

    private static String C(Context r100) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return "";
    L5:
        String r101 = A;
        if (r101 == null) goto L12;
        if ("".equals(r101) == true) goto L12;
        return A;
    L12:
        if (b(r100, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) == false) goto L14;
        TelephonyManager r102 = H(r100);
        if (r102 != null) goto L18;
        return "";
    L18:
        Method r103 = bs.a(r102.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
        if (r103 == null) goto L22;
        A = (String) r103.invoke(r102, new Object[0]);
    L22:
        if (A != null) goto L25;
        A = "";
    L25:
        return A;
    L14:
        return A;
    }

    private static String D(Context r100) {
        if (b(r100, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) == true) goto L6;
        return null;
    L6:
        TelephonyManager r101 = H(r100);
        if (r101 != null) goto L10;
        return "";
    L10:
        String r102 = r101.getSimOperatorName();
        if (TextUtils.isEmpty(r102) == true) goto L13;
        return r102;
    L13:
        return r101.getNetworkOperatorName();
    }

    private static int E(Context r100) {
        if (r100 != null) goto L5;
    L15:
        return -1;
    L5:
        if (b(r100, bs.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L15;
        ConnectivityManager r101 = F(r100);
        if (r101 != null) goto L10;
        return -1;
    L10:
        NetworkInfo r102 = r101.getActiveNetworkInfo();
        if (r102 != null) goto L14;
        return -1;
    L14:
        return r102.getType();
    }

    private static ConnectivityManager F(Context r100) {
        return (ConnectivityManager) r100.getSystemService("connectivity");
    }

    private static int G(Context r100) {
        if (b(r100, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) == true) goto L5;
        return -1;
    L5:
        TelephonyManager r101 = H(r100);
        if (r101 != null) goto L9;
        return -1;
    L9:
        return r101.getNetworkType();
    }

    private static TelephonyManager H(Context r100) {
        return (TelephonyManager) r100.getSystemService("phone");
    }

    private static String I(Context r100) {
        if (f26277c == true) goto L18;
        return "";
    L18:
        String r101 = J(r100);     // Catch: Throwable -> L7
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L16;
        f26277c = false;
        return "";
    L16:
        byte[] r102 = bs.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");     // Catch: Throwable -> L14
        byte[] r103 = bn.b(r101);     // Catch: Throwable -> L14
        return new String(bn.a(bs.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), r103, r102), "UTF-8");
    L14:
        f26277c = false;
        return "";
    L7:
        r101 = null;
        goto L9
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_amap_api_col_s_bm_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static String J(Context r100) {
        String r101 = K(r100);     // Catch: Throwable -> L5
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        return r101;
    L9:
        if (r100 != null) goto L12;
        return "";
    L12:
        return r100.getSharedPreferences(bs.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(bq.a(bs.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    L5:
        r101 = "";
        goto L7
    }

    private static String K(Context r100) {
        String r101 = bq.a(bs.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String r102 = L(r100);
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return "";
    L5:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102 + File.separator + bs.c("KYmFja3Vwcw"), bs.c("MLmFkaXU"));
        if (r103.exists() == true) goto L8;
    L39:
        return "";
    L8:
        if (r103.canRead() == false) goto L39;
        if (r103.length() != 0) goto L14;
        r103.delete();
        return "";
    L14:
        ByteArrayOutputStream r104 = null;
        RandomAccessFile r105 = new RandomAccessFile(r103, "r");     // Catch: Throwable -> L36
        byte[] r106 = new byte[1024];     // Catch: Throwable -> L40
        ByteArrayOutputStream r107 = new ByteArrayOutputStream();     // Catch: Throwable -> L40
    L41:
        int r108 = r105.read(r106);     // Catch: Throwable -> L35
        if (r108 == (-1)) goto L21;
        r107.write(r106, 0, r108);     // Catch: Throwable -> L35
        goto L41
    L21:
        String r109 = new String(r107.toByteArray(), "UTF-8");     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r109) == false) goto L24;
    L34:
        a(r107);
    L38:
        a(r105);
        goto L39
    L24:
        if (r109.contains(bs.c("SIw")) == false) goto L34;
        String[] r110 = r109.split(bs.c("SIw"));     // Catch: Throwable -> L35
        if (r110 == null) goto L34;
        if (r110.length != 2) goto L34;
        if (TextUtils.equals(r101, r110[0]) == false) goto L34;
        String r111 = r110[1];     // Catch: Throwable -> L35
        a(r107);
        a(r105);
        return r111;
    L35:
        r104 = r107;
    L37:
        a(r104);
    L36:
        r105 = null;
        goto L37
    }

    private static String L(Context r100) {
        StorageManager r101 = (StorageManager) r100.getSystemService("storage");     // Catch: Throwable -> L10
        Class r102 = INVOKESTATIC_com_amap_api_col_s_bm_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(bs.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));     // Catch: Throwable -> L10
        Method r103 = r101.getClass().getMethod(bs.c("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);     // Catch: Throwable -> L10
        Method r104 = r102.getMethod(bs.c("FZ2V0UGF0aA"), new Class[0]);     // Catch: Throwable -> L10
        Method r105 = r102.getMethod(bs.c("DaXNSZW1vdmFibGU"), new Class[0]);     // Catch: Throwable -> L10
        Object r106 = r103.invoke(r101, new Object[0]);     // Catch: Throwable -> L10
        int r107 = Array.getLength(r106);     // Catch: Throwable -> L10
        int r108 = 0;
    L3:
        if (r108 >= r107) goto L15;
        Object r109 = Array.get(r106, r108);     // Catch: Throwable -> L10
        String r110 = (String) r104.invoke(r109, new Object[0]);     // Catch: Throwable -> L10
        if (((Boolean) r105.invoke(r109, new Object[0])).booleanValue() == false) goto L6;
        r108 = r108 + 1;
        goto L3
    L6:
        return r110;
    L15:
        return null;
    L8:
        return null;
    }

    public static String a(final Context r100) {
        if (TextUtils.isEmpty(f26276b) == false) goto L6;
        if (r100 != null) goto L9;
        return "";
    L9:
        String r101 = I(r100);     // Catch: Throwable -> L21
        f26276b = r101;     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r101) == true) goto L14;
        return f26276b;
    L14:
        if (f26281g != null) goto L17;
        return "";
    L17:
        if (f26287m == false) goto L19;
        return "";
    L19:
        f26287m = true;     // Catch: Throwable -> L21
        cg.c().submit(new AnonymousClass1(r100));     // Catch: Throwable -> L21
        goto L20
    L6:
        return f26276b;
    L20:
        return "";
    }

    public static String b(Context r100) {
        return D(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String c(Context r100) {
        if (Build.VERSION.SDK_INT < 29) goto L16;
        return "";
    L16:
        String r101 = v(r100);     // Catch: Throwable -> L13
        if (r101 != null) goto L8;
    L12:
        return "";
    L8:
        if (r101.length() < 5) goto L12;
        return r101.substring(3, 5);
    L13:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    private static String com_amap_api_col_s_bm_android_net_wifi_WifiInfo_getBSSID(WifiInfo r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101100);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101100, "android/net/wifi/WifiInfo", "getBSSID", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getBSSID();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    private static String com_amap_api_col_s_bm_android_net_wifi_WifiInfo_getMacAddress(WifiInfo r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(101700, "android/net/wifi/WifiInfo", "getMacAddress", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101700, "android/net/wifi/WifiInfo", "getMacAddress", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getMacAddress();
        r100.a(101700, "android/net/wifi/WifiInfo", "getMacAddress", r110, r101, r113, r111, true);
        return r113;
    }

    private static WifiInfo com_amap_api_col_s_bm_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102301);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r110, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (WifiInfo) r106.f474983b;
    L21:
        return r110.getConnectionInfo();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    private static List com_amap_api_col_s_bm_android_net_wifi_WifiManager_getScanResults(WifiManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, "java.util.List", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, null, r111, false);
        return (List) r112.f474983b;
    L6:
        List<ScanResult> r113 = r110.getScanResults();
        r100.a(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, r113, r111, true);
        return r113;
    }

    private static byte[] com_amap_api_col_s_bm_java_net_NetworkInterface_getHardwareAddress(NetworkInterface r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(101701, "java/net/NetworkInterface", "getHardwareAddress", r110, r101, "byte[]", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r110, r101, null, r111, false);
        return (byte[]) r112.f474983b;
    L6:
        byte[] r113 = r110.getHardwareAddress();
        r100.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r110, r101, r113, r111, true);
        return r113;
    }

    public static int d(Context r100) {
        return G(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static int e(Context r100) {
        return E(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static String f(Context r100) {
        return C(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String g(final Context r100) {
        if (f26289o == false) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(f26288n) == true) goto L11;
        return f26288n;
    L11:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L14;
        cg.c().submit(new AnonymousClass2(r100));     // Catch: Throwable -> L17
        goto L16
    L14:
        return A(r100);
    L16:
        return f26288n;
    }

    public static String h(Context r100) {
        String r101 = f26275a;     // Catch: Throwable -> L25
        if (r101 == null) goto L10;
        if ("".equals(r101) == true) goto L10;
        return f26275a;
    L10:
        if (b(r100, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT")) == false) goto L12;
        f26275a = com_amap_api_col_s_bm_android_provider_Settings$System_getString(r100.getContentResolver(), "mqBRboGZkQPcAkyk");     // Catch: Throwable -> L25
    L12:
        String r102 = f26275a;     // Catch: Throwable -> L25
        if (r102 == null) goto L27;
        if ("".equals(r102) == true) goto L27;
        return f26275a;
    L27:
        f26275a = z(r100);     // Catch: Throwable -> L20
    L21:
        String r103 = f26275a;
        if (r103 != null) goto L24;
        return "";
    L24:
        return r103;
    }

    public static String i(Context r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 29) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(f26291q) == true) goto L10;
        return f26291q;
    L10:
        if (b(r100, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) == true) goto L22;
        return "";
    L22:
        if (r101 >= 26) goto L15;
        f26291q = com_amap_api_col_s_bm_android_os_Build_SERIAL();     // Catch: Throwable -> L16
        goto L18
    L15:
        return (String) bs.a(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
    L18:
        String r102 = f26291q;
        if (r102 != null) goto L21;
        return "";
    L21:
        return r102;
    }

    public static String j(Context r100) {
        if (TextUtils.isEmpty(f26290p) == false) goto L5;
        String r101 = com_amap_api_col_s_bm_android_provider_Settings$Secure_getString(r100.getContentResolver(), bs.c(new String(cc.a(13))));     // Catch: Throwable -> L10
        f26290p = r101;     // Catch: Throwable -> L10
        if (r101 != null) goto L14;
        return "";
    L14:
        return r101;
    L11:
        return f26290p;
    L5:
        return f26290p;
    }

    public static String k(Context r100) {
        if (r100 == null) goto L18;
        if (b(r100, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) == false) goto L19;
        WifiManager r101 = (WifiManager) r100.getSystemService("wifi");     // Catch: Throwable -> L15
        if (r101 != null) goto L11;
        return "";
    L11:
        if (r101.isWifiEnabled() == false) goto L20;
        return com_amap_api_col_s_bm_android_net_wifi_WifiInfo_getBSSID(com_amap_api_col_s_bm_android_net_wifi_WifiManager_getConnectionInfo(r101));
    L20:
        return "";
    L19:
        return "";
    L21:
        return "";
    L18:
        return "";
    }

    public static String l(Context r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L31;
        if (b(r100, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) == false) goto L31;
        WifiManager r102 = (WifiManager) r100.getSystemService("wifi");     // Catch: Throwable -> L34
        if (r102 != null) goto L12;
        return "";
    L12:
        if (r102.isWifiEnabled() == false) goto L33;
        List r103 = com_amap_api_col_s_bm_android_net_wifi_WifiManager_getScanResults(r102);     // Catch: Throwable -> L34
        if (r103 == null) goto L29;
        if (r103.size() == 0) goto L29;
        List<ScanResult> r104 = a(r103);     // Catch: Throwable -> L34
        boolean r105 = true;
        int r106 = 0;
    L20:
        if (r106 >= r104.size()) goto L33;
        if (r106 >= 7) goto L33;
        ScanResult r107 = (ScanResult) ListProtector.get(r104, r106);     // Catch: Throwable -> L34
        if (r105 == false) goto L26;
        r105 = false;
    L27:
        r101.append(r107.BSSID);     // Catch: Throwable -> L34
        r106 = r106 + 1;     // Catch: Throwable -> L34
        goto L20
    L26:
        r101.append(com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L34
    L29:
        return r101.toString();
    L33:
        return r101.toString();
    L31:
        return r101.toString();
    }

    public static String m(Context r100) {
        String r101 = f26292r;     // Catch: Throwable -> L23
        if (r101 == null) goto L10;
        if ("".equals(r101) == true) goto L10;
        return f26292r;
    L10:
        if (b(r100, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) == false) goto L12;
        WifiManager r102 = (WifiManager) r100.getSystemService("wifi");     // Catch: Throwable -> L23
        if (r102 != null) goto L16;
        return "";
    L16:
        f26292r = com_amap_api_col_s_bm_android_net_wifi_WifiInfo_getMacAddress(com_amap_api_col_s_bm_android_net_wifi_WifiManager_getConnectionInfo(r102));     // Catch: Throwable -> L23
        if (bs.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(f26292r) == false) goto L19;
    L20:
        f26292r = h();     // Catch: Throwable -> L23
        goto L22
    L19:
        if (bs.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(f26292r) == false) goto L22;
    L12:
        return f26292r;
    L22:
        return f26292r;
    }

    public static String n(Context r100) {
        TelephonyManager r101 = H(r100);     // Catch: Throwable -> L13
        if (r101 != null) goto L6;
        return "";
    L6:
        String r102 = r101.getNetworkOperator();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r102) == false) goto L9;
        return "";
    L9:
        if (r102.length() < 3) goto L17;
        return r102.substring(3);
    L17:
        return "";
    L18:
        return "";
    }

    public static int o(Context r100) {
        return G(r100);
    L4:
        return -1;
    }

    public static int p(Context r100) {
        return E(r100);
    L4:
        return -1;
    }

    public static String q(Context r100) {
        String r101 = f26293s;     // Catch: Throwable -> L21
        if (r101 != null) goto L6;
    L9:
        DisplayMetrics r102 = new DisplayMetrics();     // Catch: Throwable -> L21
        WindowManager r103 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L21
        if (r103 != null) goto L12;
        return "";
    L12:
        r103.getDefaultDisplay().getMetrics(r102);     // Catch: Throwable -> L21
        int r104 = r102.widthPixels;     // Catch: Throwable -> L21
        int r105 = r102.heightPixels;     // Catch: Throwable -> L21
        if (r105 <= r104) goto L17;
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L21
        r106.append(r104);     // Catch: Throwable -> L21
        r106.append("*");     // Catch: Throwable -> L21
        r106.append(r105);     // Catch: Throwable -> L21
    L18:
        f26293s = r106.toString();     // Catch: Throwable -> L21
        goto L20
    L17:
        r106 = new StringBuilder();     // Catch: Throwable -> L21
        r106.append(r105);     // Catch: Throwable -> L21
        r106.append("*");     // Catch: Throwable -> L21
        r106.append(r104);     // Catch: Throwable -> L21
        goto L18
    L6:
        if ("".equals(r101) == true) goto L9;
        return f26293s;
    L20:
        return f26293s;
    }

    public static String r(Context r100) {
    L14:
        return "";
    L4:
        if (b(r100, bs.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L6;
        return "";
    L6:
        ConnectivityManager r101 = F(r100);     // Catch: Throwable -> L14
        if (r101 != null) goto L9;
        return "";
    L9:
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Throwable -> L14
        if (r102 != null) goto L12;
        return "";
    L12:
        return r102.getTypeName();
    }

    public static String s(Context r100) {
        String r101 = t(r100);     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r101) == false) goto L7;
        r101 = a(r100);     // Catch: Throwable -> L21
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r101 = h(r100);     // Catch: Throwable -> L21
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        r101 = g(r100);     // Catch: Throwable -> L21
    L13:
        if (TextUtils.isEmpty(r101) == false) goto L16;
        r101 = j(r100);     // Catch: Throwable -> L21
    L16:
        if (TextUtils.isEmpty(r101) == false) goto L26;
        return B(r100);
    L26:
        return r101;
    L28:
        return r101;
    L19:
        return "";
    }

    public static String t(Context r100) {
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L29
        if (r101 < 29) goto L6;
        return "";
    L6:
        String r102 = f26294t;     // Catch: Throwable -> L29
        if (r102 == null) goto L13;
        if ("".equals(r102) == true) goto L13;
        return f26294t;
    L13:
        if (b(r100, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) == false) goto L15;
        TelephonyManager r103 = H(r100);     // Catch: Throwable -> L29
        if (r103 != null) goto L19;
        return "";
    L19:
        Method r104 = bs.a(r103.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);     // Catch: Throwable -> L29
        if (r101 < 26) goto L22;
        r104 = bs.a(r103.getClass(), "QZ2V0SW1laQ==", new Class[0]);     // Catch: Throwable -> L29
    L22:
        if (r104 == null) goto L25;
        f26294t = (String) r104.invoke(r103, new Object[0]);     // Catch: Throwable -> L29
    L25:
        if (f26294t != null) goto L28;
        f26294t = "";     // Catch: Throwable -> L29
        goto L28
    L15:
        return f26294t;
    L28:
        return f26294t;
    }

    public static String u(Context r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 29) goto L29;
        return "";
    L29:
        String r102 = f26295u;     // Catch: Throwable -> L28
        if (r102 == null) goto L12;
        if ("".equals(r102) == true) goto L12;
        return f26295u;
    L12:
        if (b(r100, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) == false) goto L14;
        TelephonyManager r103 = H(r100);     // Catch: Throwable -> L28
        if (r103 != null) goto L19;
        return "";
    L19:
        if (r101 < 26) goto L27;
        Method r104 = bs.a(r103.getClass(), "QZ2V0TWVpZA==", new Class[0]);     // Catch: Throwable -> L28
        if (r104 == null) goto L24;
        f26295u = (String) r104.invoke(r103, new Object[0]);     // Catch: Throwable -> L28
    L24:
        if (f26295u != null) goto L27;
        f26295u = "";     // Catch: Throwable -> L28
        goto L27
    L14:
        return f26295u;
    L27:
        return f26295u;
    }

    public static String v(Context r100) {
        return C(r100);
    L4:
        return "";
    }

    public static int w(Context r100) {
        int r101 = f26299y;
        if (r101 == 0) goto L5;
        return r101;
    L5:
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");
        if (r102 != null) goto L9;
        return 0;
    L9:
        ActivityManager.MemoryInfo r103 = new ActivityManager.MemoryInfo();
        r102.getMemoryInfo(r103);
        int r104 = ((int) (r103.totalMem / 1024)) / 1024;
        f26299y = r104;
        return r104;
    }

    public static String x(Context r100) {
        return D(r100);
    L4:
        return "";
    }

    public static /* synthetic */ String y(Context r100) {
        return A(r100);
    }

    private static String z(Context r100) {
        PolarisFileInputStreamWrapper r101 = null;
        if (bs.a(r100, "android.permission.READ_EXTERNAL_STORAGE") == true) goto L6;
    L37:
        if (r101 != null) goto L49;
        return "";
    L49:
        r101.close();     // Catch: Throwable -> L45
        return "";
    L66:
        return "";
    L6:
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L37;
        PolarisFileWrapper r102 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");     // Catch: Throwable -> L46
        XmlPullParser r103 = Xml.newPullParser();     // Catch: Throwable -> L46
        int r104 = r103.getEventType();     // Catch: Throwable -> L46
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L46
        r103.setInput(r105, XML.CHARSET_UTF8);     // Catch: Throwable -> L36
        boolean r106 = false;
    L10:
        if (1 == r104) goto L35;
        if (r104 == 2) goto L24;
        if (r104 != 3) goto L16;
        r106 = false;
    L33:
        r104 = r103.next();     // Catch: Throwable -> L36
        goto L10
    L16:
        if (r104 != 4) goto L33;
        if (r106 == false) goto L33;
        String r107 = r103.getText();     // Catch: Throwable -> L36
        r105.close();     // Catch: Throwable -> L44
    L21:
        return r107;
    L24:
        if (r103.getAttributeCount() <= 0) goto L33;
        int r108 = r103.getAttributeCount();     // Catch: Throwable -> L36
        int r109 = 0;
    L26:
        if (r109 >= r108) goto L33;
        String r110 = r103.getAttributeValue(r109);     // Catch: Throwable -> L36
        if ("UTDID2".equals(r110) == false) goto L30;
    L31:
        r106 = true;
    L32:
        r109 = r109 + 1;     // Catch: Throwable -> L36
        goto L26
    L30:
        if ("UTDID".equals(r110) == false) goto L32;
    L35:
        r101 = r105;
    L36:
        r101 = r105;
    L40:
        if (r101 != null) goto L49;
        return "";
    }

    private static List<ScanResult> a(List<ScanResult> r100) {
        int r101 = r100.size();
        int r102 = 0;
    L4:
        if (r102 >= (r101 - 1)) goto L13;
        int r103 = 1;
    L7:
        if (r103 >= (r101 - r102)) goto L12;
        int r104 = r103 - 1;
        if (((ScanResult) ListProtector.get(r100, r104)).level <= ((ScanResult) ListProtector.get(r100, r103)).level) goto L11;
        ScanResult r105 = (ScanResult) ListProtector.get(r100, r104);
        ListProtector.set(r100, r104, ListProtector.get(r100, r103));
        ListProtector.set(r100, r103, r105);
    L11:
        r103 = r103 + 1;
        goto L7
    L12:
        r102 = r102 + 1;
        goto L4
    L13:
        return r100;
    }

    public static void a(a r100) {
        if (f26281g != null) goto L6;
        f26281g = r100;
        return;
    }

    private static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static /* synthetic */ String a(String r100) {
        f26288n = r100;
        return r100;
    }

    public static String a(Context r100, String r101) {
        if (Build.VERSION.SDK_INT < 29) goto L39;
        return "";
    L39:
    L33:
        return "";
    L6:
        if (TextUtils.isEmpty(f26283i) == false) goto L8;
        TelephonyManager r102 = H(r100);     // Catch: Throwable -> L33
        if (f26282h != (-1)) goto L17;
        Method r103 = bs.a(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);     // Catch: Throwable -> L33
        if (r103 != null) goto L37;
        f26282h = 0;     // Catch: Throwable -> L33
        goto L17
    L37:
        f26282h = ((Integer) r103.invoke(r102, new Object[0])).intValue();     // Catch: Throwable -> L15
    L15:
        f26282h = 0;     // Catch: Throwable -> L33
    L17:
        Method r104 = bs.a(TelephonyManager.class, "MZ2V0SW1laQ=", new Class[]{Integer.TYPE});     // Catch: Throwable -> L33
        if (r104 != null) goto L21;
        f26282h = 0;     // Catch: Throwable -> L33
        return "";
    L21:
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L33
        int r106 = 0;
    L35:
        if (r106 >= f26282h) goto L27;
        r105.append((String) r104.invoke(r102, new Object[]{Integer.valueOf(r106)}));     // Catch: Throwable -> L34
        r105.append(r101);     // Catch: Throwable -> L34
        r106 = r106 + 1;
    L27:
        String r107 = r105.toString();     // Catch: Throwable -> L33
        if (r107.length() != 0) goto L31;
        f26282h = 0;     // Catch: Throwable -> L33
        return "";
    L31:
        String r108 = r107.substring(0, r107.length() - 1);     // Catch: Throwable -> L33
        f26283i = r108;     // Catch: Throwable -> L33
        return r108;
    L8:
        return f26283i;
    }

    private static boolean b(Context r100, String r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.checkCallingOrSelfPermission(r101) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    private static String com_amap_api_col_s_bm_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }

    private static String com_amap_api_col_s_bm_android_provider_Settings$System_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.System.getString(r110, r111);
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, r114, r112, true);
        return r114;
    }
}
