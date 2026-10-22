package com.amap.api.mapcore.util;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.ai.api.navi.AppletNaviThirdApp;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes28.dex */
public class o5 {
    private static boolean A = false;
    private static int B = 0;
    private static boolean C = false;
    private static volatile e D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile String f27733a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile String f27734b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile boolean f27735c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static d f27736d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f27737e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f27738f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f27739g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f27740h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f27741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static IBinder f27742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicBoolean f27743k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f27744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final AtomicBoolean f27745m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static String f27746n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static String f27747o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static boolean f27748p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f27749q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static String f27750r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static String f27751s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static String f27752t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static long f27753u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static int f27754v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static String f27755w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static String f27756x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static boolean f27757y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static int f27758z;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27759a;

        @Override // java.lang.Runnable
        public final void run() {
            com_amap_api_mapcore_util_o5$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public final void com_amap_api_mapcore_util_o5$a__run$___twin___() {
            Map<String, String> r100 = o5.f27736d.b();     // Catch: Throwable -> L10
            String r101 = o5.f27736d.a(o5.s(this.f27759a), "", "", "");     // Catch: Throwable -> L10
            if (TextUtils.isEmpty(r101) == false) goto L6;
            return;
        L6:
            z7 r102 = r7.a().a(o5.f27736d.a(r101.getBytes(), r100));     // Catch: Throwable -> L10
            String r103 = o5.f27736d.a(this.f27759a, new String(r102.f28591a));     // Catch: Throwable -> L10
            if (TextUtils.isEmpty(r103) == true) goto L13;
            o5.f27734b = r103;     // Catch: Throwable -> L10
            return;
        L13:
            return;
        }

        public a(Context r100) {
            this.f27759a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_mapcore_util_o5$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_amap_api_mapcore_util_o5$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27760a;

        @Override // java.lang.Runnable
        public final void run() {
            com_amap_api_mapcore_util_o5$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public final void com_amap_api_mapcore_util_o5$b__run$___twin___() {
            o5.e(this.f27760a);
        }

        public b(Context r100) {
            this.f27760a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_mapcore_util_o5$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_amap_api_mapcore_util_o5$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27761a;

        @Override // java.lang.Runnable
        public final void run() {
            com_amap_api_mapcore_util_o5$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public final void com_amap_api_mapcore_util_o5$c__run$___twin___() {
            o5.f(this.f27761a.getApplicationContext());
        }

        public c(Context r100) {
            this.f27761a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_mapcore_util_o5$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.com_amap_api_mapcore_util_o5$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public interface d {
        y7 a(byte[] r100, Map<String, String> r101);

        String a();

        String a(Context r100, String r101);

        String a(String r100, String r101, String r102, String r103);

        Map<String, String> b();
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static BroadcastReceiver f27762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static ConnectivityManager f27763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static NetworkRequest f27764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static ConnectivityManager.NetworkCallback f27765d;

        public class a extends BroadcastReceiver {
            public a(e r100) {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context r100, Intent r101) {
                if (x5.b("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(r101.getAction()) == false) goto L6;
                o5.e();
                return;
            }
        }

        public class b extends ConnectivityManager.NetworkCallback {
            public b(e r100) {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network r100) {
                super.onAvailable(r100);
                o5.e();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network r100) {
                super.onLost(r100);
                o5.e();
            }
        }

        public e() {
        }

        public final void a(Context r100) {
            if (Build.VERSION.SDK_INT >= 24) goto L10;
            if (r100 != null) goto L6;
            return;
        L6:
            if (f27762a != null) goto L20;
            f27762a = new a(this);
            IntentFilter r101 = new IntentFilter();
            r101.addAction(x5.b("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
            INVOKEVIRTUAL_com_amap_api_mapcore_util_o5$e_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, f27762a, r101);
            return;
        L20:
            return;
        L10:
            if (o5.a(r100, x5.b("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L12;
            return;
        L12:
            if (r100 != null) goto L14;
            return;
        L14:
            if (f27763b != null) goto L22;
            ConnectivityManager r102 = (ConnectivityManager) r100.getSystemService("connectivity");
            f27763b = r102;
            if (r102 == null) goto L23;
            f27764c = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
            b r103 = new b(this);
            f27765d = r103;
            f27763b.registerNetworkCallback(f27764c, r103);
            return;
        L23:
            return;
        }

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static Intent INVOKEVIRTUAL_com_amap_api_mapcore_util_o5$e_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L42:
        L36:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
            throw e;
        L40:
            return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
            if (r110 == null) goto L25;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
            ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
            int r103 = r102.result;     // Catch: Exception -> L36
            if (r103 == 1) goto L23;
            if (r103 == 2) goto L21;
            if (r103 == 3) goto L19;
            return r100.registerReceiver(r101, r110);
        L19:
            return r102.intent;
        L21:
            return new Intent();
        L23:
            return r100.registerReceiver(r101, r110);
        L25:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
            return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
        L29:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
            return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
        L35:
            return r100.registerReceiver(r101, r110);
        }
    }

    public static class f implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
        }

        public f() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            o5.a(r101);
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static void e() {
        f27758z = -1;
        A = false;
        B = -1;
        C = false;
        f27756x = "";
        f27757y = false;
        f27747o = "";
        f27748p = false;
    }

    static {
        f27743k = new AtomicBoolean(false);
        f27744l = false;
        f27745m = new AtomicBoolean(false);
        f27746n = "";
        f27747o = "";
        f27748p = false;
        f27749q = "";
        f27750r = "";
        f27751s = "";
        f27752t = "";
        f27756x = "";
        f27757y = false;
        f27758z = -1;
        A = false;
        B = -1;
        C = false;
        D = null;
    }

    public static String a() {
        if (TextUtils.isEmpty(f27755w) == false) goto L5;
        String r100 = System.getProperty("os.arch");
        f27755w = r100;
        return r100;
    L5:
        return f27755w;
    }

    public static long d() {
        long r100 = f27753u;
        if (r100 == 0) goto L9;
        return r100;
    L9:
        StatFs r101 = new StatFs(Environment.getRootDirectory().getAbsolutePath());     // Catch: Throwable -> L8
        StatFs r102 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L8
        f27753u = ((r101.getBlockCountLong() * r101.getBlockSizeLong()) / 1048576) + ((r102.getBlockCountLong() * r102.getBlockSizeLong()) / 1048576);     // Catch: Throwable -> L8
    L7:
        return f27753u;
    }

    public static String b() {
        return f27750r;
    }

    public static String c() {
        return f27746n;
    }

    private static synchronized e A(Context r100) {
        monitor-enter(o5.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (D != null) goto L11;
        if (r100 != null) goto L10;
        monitor-exit(o5.class);
        return null;
    L10:
        e r101 = new e();     // Catch: Throwable -> L14
        D = r101;     // Catch: Throwable -> L14
        r101.a(r100.getApplicationContext());     // Catch: Throwable -> L14
    L11:
        e r102 = D;     // Catch: Throwable -> L14
        monitor-exit(o5.class);
        return r102;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_amap_api_mapcore_util_o5_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static String a(Context r100) {
        if (f27748p == true) goto L5;
        A(r100);     // Catch: Throwable -> L20
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L20
        if (r101 == null) goto L9;
        String r102 = r101.getNetworkOperator();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r102) == false) goto L13;
    L16:
        f27748p = true;     // Catch: Throwable -> L20
        return f27747o;
    L13:
        if (r102.length() < 3) goto L16;
        f27747o = r102.substring(3);     // Catch: Throwable -> L20
        f27748p = true;     // Catch: Throwable -> L20
        goto L19
    L9:
        return f27747o;
    L19:
        return f27747o;
    L5:
        return f27747o;
    }

    public static String b(Context r100) {
        if (b(r100, x5.b("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L8;
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L14
        if (r101 == null) goto L8;
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Throwable -> L14
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        return com_amap_api_mapcore_util_o5_android_net_NetworkInfo_getExtraInfo(r102);
    L8:
        r102 = null;
    L17:
        return null;
    }

    public static String c(Context r100) {
        String r101 = f27749q;     // Catch: Throwable -> L20
        if (r101 != null) goto L6;
    L9:
        DisplayMetrics r102 = new DisplayMetrics();     // Catch: Throwable -> L20
        WindowManager r103 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L20
        if (r103 != null) goto L12;
        return "";
    L12:
        r103.getDefaultDisplay().getMetrics(r102);     // Catch: Throwable -> L20
        int r104 = r102.widthPixels;     // Catch: Throwable -> L20
        int r105 = r102.heightPixels;     // Catch: Throwable -> L20
        if (r105 <= r104) goto L16;
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L20
        r106.append(r104);     // Catch: Throwable -> L20
        r106.append("*");     // Catch: Throwable -> L20
        r106.append(r105);     // Catch: Throwable -> L20
    L17:
        f27749q = r106.toString();     // Catch: Throwable -> L20
        goto L19
    L16:
        r106 = new StringBuilder();     // Catch: Throwable -> L20
        r106.append(r105);     // Catch: Throwable -> L20
        r106.append("*");     // Catch: Throwable -> L20
        r106.append(r104);     // Catch: Throwable -> L20
        goto L17
    L6:
        if ("".equals(r101) == true) goto L9;
        return f27749q;
    L19:
        return f27749q;
    }

    private static String com_amap_api_mapcore_util_o5_android_net_NetworkInfo_getExtraInfo(NetworkInfo r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102026);
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
        f06.d r106 = r105.preInvoke(102026, "android/net/NetworkInfo", "getExtraInfo", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getExtraInfo();
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

    public static String d(Context r100) {
        return v(r100);
    L4:
        return "";
    }

    public static String e(Context r110) {
        String r100 = x5.b("IeGlhb21p");
        String r101 = Build.MANUFACTURER;
        if (r100.equalsIgnoreCase(r101) == true) goto L71;
        String r102 = x5.b("IeGlhb21p");
        String r103 = Build.BRAND;
        if (r102.equalsIgnoreCase(r103) == true) goto L71;
        if (x5.b("IUkVETUk=").equalsIgnoreCase(r101) == true) goto L71;
        if (x5.b("IUkVETUk=").equalsIgnoreCase(r103) == true) goto L71;
        if (x5.b("Idml2bw").equalsIgnoreCase(r101) == false) goto L14;
    L73:
        Cursor r111 = com_amap_api_mapcore_util_o5_android_content_ContentResolver_query(r110.getContentResolver(), Uri.parse(x5.b("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);     // Catch: Throwable -> L59
        if (r111 == null) goto L62;
    L50:
        if (r111.moveToNext() == false) goto L57;
        int r104 = r111.getColumnCount();     // Catch: Throwable -> L59
        int r105 = 0;
    L52:
        if (r105 >= r104) goto L50;
        if (x5.b("IdmFsdWU").equals(r111.getColumnName(r105)) == true) goto L55;
        r105 = r105 + 1;     // Catch: Throwable -> L59
        goto L52
    L55:
        f27738f = r111.getString(r105);     // Catch: Throwable -> L59
        goto L50
    L57:
        r111.close();     // Catch: Throwable -> L59
    L62:
        return f27738f;
    L59:
        th = move-exception;
        f27739g = true;
        p6.a(th, "oa", DimLocationCheckUtil.VIVO);
        goto L62
    L14:
        if (x5.b("Idml2bw").equalsIgnoreCase(r103) == true) goto L73;
        if (x5.b("IaHVhd2Vp").equalsIgnoreCase(r101) == true) goto L46;
        if (x5.b("IaHVhd2Vp").equalsIgnoreCase(r103) == true) goto L46;
        if (x5.b("ISE9OT1I=").equalsIgnoreCase(r101) == true) goto L46;
        if (x5.b("Mc2Ftc3VuZw").equalsIgnoreCase(r101) == true) goto L44;
        if (x5.b("Mc2Ftc3VuZw").equalsIgnoreCase(r103) == true) goto L44;
        if (x5.b("IT1BQTw").equalsIgnoreCase(r101) == true) goto L42;
        if (x5.b("IT1BQTw").equalsIgnoreCase(r103) == true) goto L42;
        if (x5.b("MT25lUGx1cw").equalsIgnoreCase(r101) == true) goto L42;
        if (x5.b("MT25lUGx1cw").equalsIgnoreCase(r103) == true) goto L42;
        if (x5.b("IUkVBTE1F").equalsIgnoreCase(r103) == true) goto L42;
        f27739g = true;
        return f27738f;
    L42:
        return a(r110, 5);
    L44:
        return a(r110, 4);
    L46:
        return a(r110, 2);
    L71:
        Class r106 = INVOKESTATIC_com_amap_api_mapcore_util_o5_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(x5.b("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));     // Catch: Throwable -> L67
        Object r107 = r106.newInstance();     // Catch: Throwable -> L67
        Object r112 = r106.getMethod(x5.b("MZ2V0T0FJRA"), new Class[]{Context.class}).invoke(r107, new Object[]{r110});     // Catch: Throwable -> L67
        if (r112 == null) goto L70;
        String r113 = (String) r112;     // Catch: Throwable -> L67
        f27738f = r113;     // Catch: Throwable -> L67
        return r113;
    L70:
        return f27738f;
    L67:
        th = move-exception;
        p6.a(th, "oa", "xm");
        f27739g = true;
        goto L70
    }

    public static void f(Context r100) {
        String r101 = "";
        if (b(r100, x5.b("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT")) == false) goto L7;
        f27733a = com_amap_api_mapcore_util_o5_android_provider_Settings$System_getString(r100.getContentResolver(), "mqBRboGZkQPcAkyk");     // Catch: Throwable -> L21
    L7:
        if (TextUtils.isEmpty(f27733a) == true) goto L29;
        f27744l = true;     // Catch: Throwable -> L21
        return;
    L29:
        String r102 = m7.b(r100, "Alvin2", "UTDID2", "");     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r102) == false) goto L14;
        r101 = m7.b(r100, "Alvin2", "UTDID", "");     // Catch: Throwable -> L22
        goto L25
    L14:
        r101 = r102;
    L25:
        f27733a = r101;     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r101) == true) goto L31;
        f27744l = true;     // Catch: Throwable -> L23
        return;
    L31:
        f27733a = u(r100);     // Catch: Throwable -> L24
        f27744l = true;     // Catch: Throwable -> L24
        return;
    }

    public static String g(Context r100) {
        if (TextUtils.isEmpty(f27734b) == false) goto L6;
        if (r100 != null) goto L9;
        return "";
    L9:
        String r101 = y(r100);     // Catch: Throwable -> L21
        f27734b = r101;     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r101) == true) goto L14;
        return f27734b;
    L14:
        if (f27736d != null) goto L17;
        return "";
    L17:
        if (f27737e == false) goto L19;
        return "";
    L19:
        f27737e = true;     // Catch: Throwable -> L21
        ThreadMethodProxy.start(new PthreadThreadV2(new a(r100), "ADIUFetchingThread"));     // Catch: Throwable -> L21
        goto L20
    L6:
        return f27734b;
    L20:
        return "";
    }

    public static int h(Context r100) {
        return w(r100);
    L4:
        return -1;
    }

    public static String i(Context r100) {
    L14:
        return "";
    L4:
        if (b(r100, x5.b("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L6;
        return "";
    L6:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L14
        if (r101 != null) goto L9;
        return "";
    L9:
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Throwable -> L14
        if (r102 != null) goto L12;
        return "";
    L12:
        return r102.getTypeName();
    }

    public static int j(Context r100) {
        return w(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static int k(Context r100) {
        return x(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static String l(Context r100) {
        return v(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String m(Context r100) {
        return f27750r + "#" + g(r100) + "#" + o(r100);
    }

    public static int n(Context r100) {
        return x(r100);
    L4:
        return -1;
    }

    public static String o(Context r100) {
        String r101 = "";
        String r102 = f27750r;     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r102) == false) goto L8;
        r102 = g(r100);     // Catch: Throwable -> L21
    L8:
        if (TextUtils.isEmpty(r102) == false) goto L11;
        r102 = s(r100);     // Catch: Throwable -> L21
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L13;
        r102 = p(r100);     // Catch: Throwable -> L21
    L13:
        if (TextUtils.isEmpty(r102) == true) goto L18;
        r101 = r102;
    L18:
        if (TextUtils.isEmpty(r101) == false) goto L28;
        return t(r100);
    L28:
        return r101;
    L22:
        return r102;
    L30:
        return "";
    }

    public static String p(Context r100) {
        if (f27740h == true) goto L7;
        return "";
    L7:
        if (f27739g == false) goto L10;
        return "";
    L10:
        if (TextUtils.isEmpty(f27738f) == true) goto L14;
        return f27738f;
    L14:
        if (f27743k.compareAndSet(false, true) == false) goto L17;
        ThreadMethodProxy.start(new PthreadThreadV2(new b(r100), "OD-Thread"));     // Catch: Throwable -> L18
    L17:
        return f27738f;
    }

    public static int q(Context r100) {
        int r101 = f27754v;
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
        f27754v = r104;
        return r104;
    }

    public static String r(Context r100) {
    L14:
        return "";
    L3:
        if (TextUtils.isEmpty(f27741i) == false) goto L5;
        Signature[] r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 64).signatures;     // Catch: Throwable -> L14
        int r102 = 0;
        byte[] r103 = r101[0].toByteArray();     // Catch: Throwable -> L14
        byte[] r104 = MessageDigest.getInstance(x5.b("IU0hBMQ")).digest(r103);     // Catch: Throwable -> L14
        StringBuffer r105 = new StringBuffer();     // Catch: Throwable -> L14
    L8:
        if (r102 >= r104.length) goto L10;
        r105.append(Integer.toHexString((r104[r102] & UByte.MAX_VALUE) | 256).substring(1, 3));     // Catch: Throwable -> L14
        r102 = r102 + 1;     // Catch: Throwable -> L14
        goto L8
    L10:
        String r106 = r105.toString();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r106) == true) goto L13;
        f27741i = r106;     // Catch: Throwable -> L14
    L13:
        return r106;
    L5:
        return f27741i;
    }

    public static String s(Context r100) {
        if (f27744l == false) goto L10;
        if (f27733a != null) goto L8;
        return "";
    L8:
        return f27733a;
    L10:
        if (f27733a == null) goto L16;
        if ("".equals(f27733a) == true) goto L16;
        return f27733a;
    L16:
        if (f27745m.compareAndSet(false, true) == false) goto L19;
        ThreadMethodProxy.start(new PthreadThreadV2(new c(r100), "UD-Thread"));
    L19:
        if (f27733a != null) goto L22;
        return "";
    L22:
        return f27733a;
    }

    public static String t(Context r100) {
        if (TextUtils.isEmpty(f27752t) == false) goto L5;
        String r101 = m7.b(r100, "open_common", "a1", "");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r101) == false) goto L9;
        f27752t = AppletNaviThirdApp.AMAP + UUID.randomUUID().toString().replace("_", "").toLowerCase();     // Catch: Throwable -> L12
        SharedPreferences.Editor r102 = m7.a(r100, "open_common");     // Catch: Throwable -> L12
        m7.a(r102, "a1", x5.f(f27752t));     // Catch: Throwable -> L12
        m7.a(r102);     // Catch: Throwable -> L12
    L11:
        return f27752t;
    L9:
        f27752t = x5.b(r101);     // Catch: Throwable -> L12
        goto L11
    L13:
        return f27752t;
    L5:
        return f27752t;
    }

    private static String u(Context r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getExternalCacheDir().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");     // Catch: Throwable -> L31
        XmlPullParser r102 = Xml.newPullParser();     // Catch: Throwable -> L31
        int r103 = r102.getEventType();     // Catch: Throwable -> L31
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L31
        r102.setInput(r104, XML.CHARSET_UTF8);     // Catch: Throwable -> L30
        boolean r105 = false;
    L5:
        if (1 != r103) goto L7;
    L44:
        r104.close();     // Catch: Throwable -> L37
        return "";
    L55:
        return "";
    L7:
        if (r103 == 2) goto L19;
        if (r103 != 3) goto L11;
        r105 = false;
    L28:
        r103 = r102.next();     // Catch: Throwable -> L30
        goto L5
    L11:
        if (r103 != 4) goto L28;
        if (r105 == false) goto L28;
        String r106 = r102.getText();     // Catch: Throwable -> L30
        r104.close();     // Catch: Throwable -> L36
    L16:
        return r106;
    L19:
        if (r102.getAttributeCount() <= 0) goto L28;
        int r107 = r102.getAttributeCount();     // Catch: Throwable -> L30
        int r108 = 0;
    L21:
        if (r108 >= r107) goto L28;
        String r109 = r102.getAttributeValue(r108);     // Catch: Throwable -> L30
        if ("UTDID2".equals(r109) == false) goto L25;
    L26:
        r105 = true;
    L27:
        r108 = r108 + 1;     // Catch: Throwable -> L30
        goto L21
    L25:
        if ("UTDID".equals(r109) == false) goto L27;
    L32:
        if (r104 != null) goto L44;
        return "";
    L31:
        r104 = null;
        goto L32
    }

    private static String v(Context r100) {
        if (f27757y == true) goto L5;
        A(r100);
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");
        if (r101 == null) goto L9;
        String r102 = r101.getSimOperatorName();
        f27756x = r102;
        if (TextUtils.isEmpty(r102) == false) goto L13;
        f27756x = r101.getNetworkOperatorName();
    L13:
        f27757y = true;
        return f27756x;
    L9:
        return f27756x;
    L5:
        return f27756x;
    }

    private static int w(Context r100) {
        if (A == true) goto L5;
        A(r100);
        if (r100 == null) goto L22;
        if (b(r100, x5.b("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L22;
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 == null) goto L14;
        NetworkInfo r102 = r101.getActiveNetworkInfo();
        if (r102 != null) goto L19;
        A = true;
        return f27758z;
    L19:
        int r103 = r102.getType();
        f27758z = r103;
        A = true;
        return r103;
    L14:
        return f27758z;
    L22:
        return f27758z;
    L5:
        return f27758z;
    }

    private static int x(Context r100) {
        if (C == true) goto L5;
        A(r100);
        if (b(r100, x5.b("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L9;
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 == null) goto L13;
        NetworkInfo r102 = r101.getActiveNetworkInfo();
        if (r102 == null) goto L20;
        if (r102.isAvailable() == false) goto L20;
        B = r102.getSubtype();
        C = true;
    L20:
        return B;
    L13:
        return B;
    L9:
        return B;
    L5:
        return B;
    }

    private static String y(Context r100) {
        if (f27735c == true) goto L27;
        return "";
    L27:
        String r101 = z(r100);     // Catch: Throwable -> L7
    L23:
    L14:
        r101 = null;
    L16:
        if (TextUtils.isEmpty(r101) == false) goto L25;
        f27735c = false;
        return "";
    L25:
        byte[] r102 = x5.b("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");     // Catch: Throwable -> L21
        byte[] r103 = q5.a(r101);     // Catch: Throwable -> L21
        return new String(q5.b(x5.b("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), r103, r102), "UTF-8");
    L21:
        f27735c = false;
        return "";
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L16;
        r101 = r100.getSharedPreferences(x5.b("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(t5.c(x5.b("RYW1hcF9kZXZpY2VfYWRpdQ")), "");     // Catch: Throwable -> L14
    L7:
        r101 = "";
        goto L23
    }

    private static String z(Context r100) {
        String r101 = t5.c(x5.b("LYW1hcF9kZXZpY2VfYWRpdQ"));
        RandomAccessFile r102 = null;
        File r103 = r100.getExternalCacheDir();     // Catch: Exception -> L9
        if (r103 != null) goto L6;
        r103 = r100.getCacheDir();     // Catch: Exception -> L9
    L6:
        if (r103 == null) goto L10;
        String r104 = r103.getAbsolutePath();     // Catch: Exception -> L9
    L12:
        if (TextUtils.isEmpty(r104) == false) goto L14;
        return "";
    L14:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104 + File.separator + x5.b("KYmFja3Vwcw"), x5.b("MLmFkaXU"));
        if (r105.exists() == true) goto L17;
    L46:
        return "";
    L17:
        if (r105.canRead() == false) goto L46;
        if (r105.length() != 0) goto L54;
        r105.delete();
        return "";
    L54:
        RandomAccessFile r106 = new RandomAccessFile(r105, "r");     // Catch: Throwable -> L44
        byte[] r107 = new byte[1024];     // Catch: Throwable -> L42
        ByteArrayOutputStream r108 = new ByteArrayOutputStream();     // Catch: Throwable -> L42
    L50:
        int r109 = r106.read(r107);     // Catch: Throwable -> L47
        if (r109 == (-1)) goto L29;
        r108.write(r107, 0, r109);     // Catch: Throwable -> L47
        goto L50
    L29:
        String r110 = new String(r108.toByteArray(), "UTF-8");     // Catch: Throwable -> L47
        if (TextUtils.isEmpty(r110) == true) goto L43;
        if (r110.contains(x5.b("SIw")) == false) goto L43;
        String[] r111 = r110.split(x5.b("SIw"));     // Catch: Throwable -> L47
        if (r111 == null) goto L43;
        if (r111.length != 2) goto L43;
        if (TextUtils.equals(r101, r111[0]) == false) goto L43;
        String r112 = r111[1];     // Catch: Throwable -> L47
        a(r108);
        a(r106);
        return r112;
    L43:
        r102 = r106;
    L45:
        a(r108);
        a(r102);
    L42:
        r108 = null;
    L44:
        r108 = null;
    L10:
        r104 = null;
        goto L12
    }

    private static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static /* synthetic */ IBinder a(IBinder r100) {
        f27742j = r100;
        return r100;
    }

    public static void a(boolean r100) {
        f27740h = r100;
    }

    private static String a(Context r110, int r111) {
        Intent r100 = new Intent();     // Catch: Throwable -> L46
        if (r111 == 2) goto L11;
        if (r111 == 4) goto L10;
        if (r111 == 5) goto L9;
        f27739g = true;     // Catch: Throwable -> L46
        return f27738f;
    L9:
        r100.setClassName(x5.b("YY29tLmhleXRhcC5vcGVuaWQ"), x5.b("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));     // Catch: Throwable -> L46
        r100.setAction(x5.b("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));     // Catch: Throwable -> L46
    L12:
        f r101 = new f();     // Catch: Throwable -> L46
        if (r110.bindService(r100, r101, 1) == false) goto L45;
        int r102 = 0;
    L16:
        if (r102 >= 100) goto L43;
        if (TextUtils.isEmpty(f27738f) == false) goto L43;
        r102 = r102 + 1;     // Catch: Throwable -> L46
        if (f27742j == null) goto L42;
        Parcel r103 = Parcel.obtain();     // Catch: Throwable -> L46
        Parcel r104 = Parcel.obtain();     // Catch: Throwable -> L46
        if (r111 == 2) goto L28;
        if (r111 == 4) goto L27;
        if (r111 == 5) goto L26;
        boolean r105 = false;
    L30:
        if (r105 == true) goto L50;
    L32:
        r104.recycle();     // Catch: Throwable -> L46
    L38:
        r103.recycle();     // Catch: Throwable -> L46
        goto L42
    L50:
        INVOKEINTERFACE_com_amap_api_mapcore_util_o5_com_obric_assistant_interaction_impl_BinderLancet_transact(f27742j, 1, r103, r104, 0);     // Catch: Throwable -> L34
        r104.readException();     // Catch: Throwable -> L34
        f27738f = r104.readString();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        p6.a(th, "oac", String.valueOf(r111));     // Catch: Throwable -> L39
        r104.recycle();     // Catch: Throwable -> L46
        goto L38
    L39:
        th = move-exception;
        r104.recycle();     // Catch: Throwable -> L46
        r103.recycle();     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L26:
        r103.writeInterfaceToken(x5.b("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));     // Catch: Throwable -> L34
        r103.writeString(r110.getPackageName());     // Catch: Throwable -> L34
        r103.writeString(r(r110));     // Catch: Throwable -> L34
        r103.writeString(x5.b("IT1VJRA"));     // Catch: Throwable -> L34
    L29:
        r105 = true;
        goto L30
    L27:
        r103.writeInterfaceToken(x5.b("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"));     // Catch: Throwable -> L34
        goto L29
    L28:
        r103.writeInterfaceToken(x5.b("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"));     // Catch: Throwable -> L34
    L42:
        Thread.sleep(15);     // Catch: Throwable -> L46
    L43:
        r110.unbindService(r101);     // Catch: Throwable -> L46
        f27742j = null;     // Catch: Throwable -> L46
    L45:
        return f27738f;
    L10:
        r100.setClassName(x5.b("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), x5.b("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));     // Catch: Throwable -> L46
        goto L12
    L11:
        r100.setAction(x5.b("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));     // Catch: Throwable -> L46
        r100.setPackage(x5.b("UY29tLmh1YXdlaS5od2lk"));     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        p6.a(th, "oa", String.valueOf(r111));
        f27739g = true;
        return f27738f;
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

    private static String com_amap_api_mapcore_util_o5_android_provider_Settings$System_getString(ContentResolver r110, String r111) {
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

    public static /* synthetic */ boolean a(Context r100, String r101) {
        return b(r100, r101);
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_amap_api_mapcore_util_o5_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

    private static Cursor com_amap_api_mapcore_util_o5_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
