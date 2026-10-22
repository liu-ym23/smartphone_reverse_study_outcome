package com.alipay.sdk.m.p0;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class c {
    public static String A = null;
    public static volatile c B = null;
    public static volatile b C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25692a = "VMS_IDLG_SDK_Client";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25693b = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25694c = "persist.sys.identifierid.supported";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f25695d = "appid";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f25696e = "type";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f25697f = "OAID";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f25698g = "VAID";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f25699h = "AAID";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25700i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f25701j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f25702k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f25703l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f25704m = 11;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f25705n = 2000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Context f25706o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f25707p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static d f25708q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static d f25709r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static d f25710s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static Object f25711t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static HandlerThread f25712u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static Handler f25713v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f25714w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f25715x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f25716y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static String f25717z;

    public static class a extends Handler {
        public a(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            if (r100.what != 11) goto L12;
            int r101 = r100.getData().getInt("type");
            String r102 = r100.getData().getString("appid");
            c.c(c.d().a(r101, r102));
            Object r103 = c.e();
            monitor-enter(r103);
            c.e().notify();     // Catch: Throwable -> L9
            monitor-exit(r103);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f25711t = new Object();
    }

    public static void f() {
        f25707p = "1".equals(a(f25694c, "0"));
    }

    public static void g() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("SqlWorkThread");
        f25712u = r100;
        ThreadMethodProxy.start(r100);
        f25713v = new a(f25712u.getLooper());
    }

    public String a() {
        if (c() == true) goto L5;
        return null;
    L5:
        String r100 = f25715x;
        if (r100 == null) goto L8;
        return r100;
    L8:
        a(0, null);
        if (f25708q != null) goto L12;
        a(f25706o, 0, null);
    L12:
        return f25715x;
    }

    public String b() {
        if (c() == true) goto L5;
        return null;
    L5:
        a(4, null);
        return A;
    }

    public c() {
    }

    public static /* synthetic */ b d() {
        return C;
    }

    public static /* synthetic */ Object e() {
        return f25711t;
    }

    public boolean c() {
        return f25707p;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alipay_sdk_m_p0_c_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static c a(Context r100) {
        if (B != null) goto L13;
        monitor-enter(c.class);
        f25706o = r100.getApplicationContext();     // Catch: Throwable -> L9
        B = new c();     // Catch: Throwable -> L9
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        if (C != null) goto L23;
        monitor-enter(c.class);
        f25706o = r100.getApplicationContext();     // Catch: Throwable -> L19
        g();     // Catch: Throwable -> L19
        C = new b(f25706o);     // Catch: Throwable -> L19
        f();     // Catch: Throwable -> L19
        monitor-exit(c.class);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L23:
        return B;
    }

    public static /* synthetic */ String c(String r100) {
        f25714w = r100;
        return r100;
    }

    public String b(String r100) {
        if (c() == true) goto L6;
        return null;
    L6:
        String r101 = f25716y;
        if (r101 == null) goto L9;
        return r101;
    L9:
        a(1, r100);
        if (f25709r != null) goto L15;
        if (f25716y == null) goto L15;
        a(f25706o, 1, r100);
    L15:
        return f25716y;
    }

    public String a(String r100) {
        if (c() == true) goto L6;
        return null;
    L6:
        String r101 = f25717z;
        if (r101 == null) goto L9;
        return r101;
    L9:
        a(2, r100);
        if (f25710s != null) goto L15;
        if (f25717z == null) goto L15;
        a(f25706o, 2, r100);
    L15:
        return f25717z;
    }

    private void b(int r100, String r101) {
        Message r102 = f25713v.obtainMessage();
        r102.what = 11;
        Bundle r103 = new Bundle();
        r103.putInt("type", r100);
        if (r100 != 1) goto L5;
    L6:
        r103.putString("appid", r101);
    L7:
        r102.setData(r103);
        f25713v.sendMessage(r102);
        return;
    L5:
        if (r100 != 2) goto L7;
        goto L6
    }

    public void a(int r100, String r101) {
        Object r102 = f25711t;
        monitor-enter(r102);
        b(r100, r101);     // Catch: Throwable -> L31
        long r103 = SystemClock.uptimeMillis();     // Catch: Throwable -> L31
        f25711t.wait(2000);     // Catch: InterruptedException -> L8 Throwable -> L31
    L11:
        if ((SystemClock.uptimeMillis() - r103) < 2000) goto L13;
    L29:
        monitor-exit(r102);     // Catch: Throwable -> L31
        return;
    L13:
        if (r100 != 0) goto L15;
        f25715x = f25714w;     // Catch: Throwable -> L31
        f25714w = null;     // Catch: Throwable -> L31
        goto L29
    L15:
        if (r100 != 1) goto L17;
        String r104 = f25714w;     // Catch: Throwable -> L31
        if (r104 == null) goto L29;
        f25716y = r104;     // Catch: Throwable -> L31
        f25714w = null;     // Catch: Throwable -> L31
        goto L29
    L17:
        if (r100 != 2) goto L19;
        String r105 = f25714w;     // Catch: Throwable -> L31
        if (r105 == null) goto L24;
        f25717z = r105;     // Catch: Throwable -> L31
        f25714w = null;     // Catch: Throwable -> L31
    L24:
        A = f25714w;     // Catch: Throwable -> L31
        f25714w = null;     // Catch: Throwable -> L31
        goto L29
    L19:
        if (r100 == 4) goto L24;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public static String a(String r100, String r101) {
        Class r102 = INVOKESTATIC_com_alipay_sdk_m_p0_c_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L6 Throwable -> L9
        return (String) r102.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r102, new Object[]{r100, "unknown"});
    L6:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
    L8:
        return r101;
    }

    public static void a(Context r100, int r101, String r102) {
        if (r101 == 0) goto L10;
        if (r101 != 1) goto L6;
        f25709r = new d(B, 1, r102);
        r100.getContentResolver().registerContentObserver(UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + r102), false, f25709r);
        return;
    L6:
        if (r101 != 2) goto L14;
        f25710s = new d(B, 2, r102);
        r100.getContentResolver().registerContentObserver(UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + r102), false, f25710s);
        return;
    L14:
        return;
    L10:
        f25708q = new d(B, 0, null);
        r100.getContentResolver().registerContentObserver(UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f25708q);
    }
}
