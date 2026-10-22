package cn.com.chinatelecom.account;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import cn.com.chinatelecom.account.api.CtAuth;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.net.InetAddress;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f24368d = "d0";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Handler f24369e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f24371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f24372c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c0 f24373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d0 f24374b;

        public a(d0 r100, c0 r101) {
            this.f24374b = r100;
            this.f24373a = r101;
        }

        public void cn_com_chinatelecom_account_d0$a__run$___twin___() {
            if (d0.a(this.f24374b) == false) goto L5;
            return;
        L5:
            if (this.f24373a == null) goto L9;
            d0.b(this.f24374b);
            this.f24373a.onSwitchTimeout();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            cn_com_chinatelecom_account_d0$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void cn_com_chinatelecom_account_d0$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.cn_com_chinatelecom_account_d0$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class b extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c0 f24375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f24376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d0 f24377c;

        public b(d0 r100, c0 r101, long r102) {
            this.f24377c = r100;
            this.f24375a = r101;
            this.f24376b = r102;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r100) {
            if (d0.a(this.f24377c) == false) goto L5;
            return;
        L5:
            if (this.f24375a == null) goto L9;
            d0.b(this.f24377c);
            this.f24375a.onSwitchSuccess(r100, System.currentTimeMillis() - this.f24376b);
            return;
        }
    }

    public class c extends f0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f24378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c0 f24379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d0 f24380c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f24381a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f24382b;

            public a(c r100, long r101) {
                this.f24382b = r100;
                this.f24381a = r101;
            }

            public void cn_com_chinatelecom_account_d0$c$a__run$___twin___() {
                this.f24382b.f24379b.onSwitchError(System.currentTimeMillis() - this.f24381a);
            }

            @Override // java.lang.Runnable
            public void run() {
                cn_com_chinatelecom_account_d0$c$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void cn_com_chinatelecom_account_d0$c$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
                r100.cn_com_chinatelecom_account_d0$c$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f24383a;

            public b(c r100) {
                this.f24383a = r100;
            }

            public void cn_com_chinatelecom_account_d0$c$b__run$___twin___() {
                this.f24383a.f24379b.onSwitchTimeout();
            }

            @Override // java.lang.Runnable
            public void run() {
                cn_com_chinatelecom_account_d0$c$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void cn_com_chinatelecom_account_d0$c$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
                r100.cn_com_chinatelecom_account_d0$c$b__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(d0 r100, String r101, c0 r102) {
            this.f24380c = r100;
            this.f24378a = r101;
            this.f24379b = r102;
        }

        @Override // cn.com.chinatelecom.account.f0
        public void runTask() {
            long r100 = System.currentTimeMillis();
            int r101 = d0.a(this.f24380c, this.f24378a);
            if (r101 != 0) goto L6;
            this.f24379b.onSwitchSuccess(null, System.currentTimeMillis() - r100);
            return;
        L6:
            if (r101 != (-1)) goto L8;
            d0.a().post(new a(this, r100));
            return;
        L8:
            d0.a().post(new b(this));
        }
    }

    static {
        f24369e = new Handler(Looper.getMainLooper());
    }

    public d0(Context r100) {
        this.f24371b = r100;
    }

    public static /* synthetic */ int a(d0 r100, String r101) {
        return r100.c(r101);
    }

    public static /* synthetic */ Handler a() {
        return f24369e;
    }

    public static String a(String r100) {
        int r101 = r100.indexOf("://");
        if (r101 <= 0) goto L5;
        r100 = r100.substring(r101 + 3);
    L5:
        int r102 = r100.indexOf(58);
        if (r102 < 0) goto L8;
        r100 = r100.substring(0, r102);
    L8:
        int r103 = r100.indexOf(47);
        if (r103 < 0) goto L11;
        r100 = r100.substring(0, r103);
    L11:
        int r104 = r100.indexOf(63);
        if (r104 >= 0) goto L14;
        return r100;
    L14:
        return r100.substring(0, r104);
    }

    private void a(c0 r100) {
        f24369e.postDelayed(new a(this, r100), 2500);
    }

    public static /* synthetic */ boolean a(d0 r100) {
        return r100.b();
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static int b(String r100) {
        byte[] r101 = InetAddress.getByName(r100).getAddress();
        int r102 = (((r101[3] & UByte.MAX_VALUE) << 24) | ((r101[2] & UByte.MAX_VALUE) << 16)) | ((r101[1] & UByte.MAX_VALUE) << 8);
        return (r101[0] & UByte.MAX_VALUE) | r102;
    L5:
        th = move-exception;
        CtAuth.warn(f24368d, "When InetAddress.getByName(),throws exception", th);
        return -1;
    }

    public static /* synthetic */ void b(d0 r100) {
        r100.c();
    }

    private synchronized boolean b() {
        monitor-enter(this);
        boolean r100 = this.f24370a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    private int c(String r110) {
        Class r100 = INVOKESTATIC_cn_com_chinatelecom_account_d0_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.net.ConnectivityManager");     // Catch: Throwable -> L19
        ConnectivityManager r101 = (ConnectivityManager) this.f24371b.getSystemService("connectivity");     // Catch: Throwable -> L19
        if (r101.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) goto L14;
        r100.getMethod("startUsingNetworkFeature", new Class[]{Integer.TYPE, String.class}).invoke(r101, new Object[]{0, "enableHIPRI"});     // Catch: Throwable -> L19
        int r102 = 0;
    L6:
        if (r102 >= 5) goto L14;
    L12:
        th = move-exception;
        CtAuth.warn(f24368d, "STMN_V4", th);     // Catch: Throwable -> L19
        goto L14
    L8:
        if (r101.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) goto L14;
        Thread.sleep(500);     // Catch: Throwable -> L12
        r102 = r102 + 1;
        goto L6
    L14:
        int r111 = b(a(r110));     // Catch: Throwable -> L19
        Class<?> r103 = Integer.TYPE;     // Catch: Throwable -> L19
        boolean r112 = ((Boolean) r100.getMethod("requestRouteToHost", new Class[]{r103, r103}).invoke(r101, new Object[]{5, Integer.valueOf(r111)})).booleanValue();     // Catch: Throwable -> L19
        CtAuth.info(f24368d, "STMN_V4 ：" + r112);     // Catch: Throwable -> L19
        if (r112 == false) goto L17;
        return 0;
    L17:
        return -2;
    L19:
        th = move-exception;
        CtAuth.warn(f24368d, "STMN_V4_T", th);
        return -1;
    }

    private synchronized void c() {
        monitor-enter(this);
        this.f24370a = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(c0 r100, String r101) {
        new e0().a(new c(this, r101, r100));
    }

    public void b(c0 r100) {
        long r101 = System.currentTimeMillis();
        a(r100);     // Catch: Throwable -> L5
        ConnectivityManager r102 = (ConnectivityManager) this.f24371b.getSystemService("connectivity");     // Catch: Throwable -> L5
        NetworkRequest.Builder r103 = new NetworkRequest.Builder();     // Catch: Throwable -> L5
        r103.addCapability(12);     // Catch: Throwable -> L5
        r103.addTransportType(0);     // Catch: Throwable -> L5
        NetworkRequest r104 = r103.build();     // Catch: Throwable -> L5
        b r105 = new b(this, r100, r101);     // Catch: Throwable -> L5
        this.f24372c = r105;     // Catch: Throwable -> L5
        r102.requestNetwork(r104, r105);     // Catch: Throwable -> L5
        return;
    L6:
        if (b() == true) goto L12;
        if (r100 == null) goto L13;
        r100.onSwitchError(System.currentTimeMillis() - r101);
        return;
    L13:
        return;
    }

    public void d() {
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (this.f24372c == null) goto L11;
        ((ConnectivityManager) this.f24371b.getSystemService("connectivity")).unregisterNetworkCallback(this.f24372c);     // Catch: Throwable -> L6
        this.f24372c = null;     // Catch: Throwable -> L6
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_cn_com_chinatelecom_account_d0_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
