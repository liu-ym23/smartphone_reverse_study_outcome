package com.baidu.mapauto.auth;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.net.c;
import com.baidu.mapauto.auth.util.LogUtil;
import com.bytedance.crash.general.AppInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class AuthCore {
    public static final String TAG = "AuthCore";
    public static final int TYPE_LICENSE_ALL = 3;
    public static final int TYPE_LICENSE_FILE = 1;
    public static final int TYPE_LICENSE_FUNCTION = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.baidu.mapauto.auth.data.license.impl.a f31754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile com.baidu.mapauto.auth.data.license.impl.b f31755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadPoolExecutor f31756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadPoolExecutor f31757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile com.baidu.mapauto.auth.process.a f31758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile com.baidu.mapauto.auth.process.b f31759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f31760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f31761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f31762i;

    public static class AuthParam extends HashMap<String, Object> {
        public static final String KEY_EXTRA_APP_VERSION = "extra_app_version";
        public static final String KEY_EXTRA_CUID = "extra_cuid";
        public static final String KEY_EXTRA_MODE = "extra_mode";
        public static final String KEY_EXTRA_MODEL = "extra_model";
        public static final String KEY_EXTRA_OS_VERSION = "extra_os_version";

        public AuthParam() {
        }

        public AuthParam(String r100, String r101, String r102, String r103, String r104, int r105, Map<String, Object> r106) {
            put("ak", r100);
            put("channel", r101);
            put("device_id", r102);
            put("service_name", r103);
            put("function_name", r104);
            put("need_active", Integer.valueOf(r105));
            if (r106 == null) goto L5;
            putAll(r106);
        L5:
            put(AppInfo.KEY_NPTH_VERSION_NAME, "1.0.0");
            put("sdk_version_code", 1);
        }

        public final AuthParam a() {
            AuthParam r100 = new AuthParam();
            Iterator<String> r101 = keySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            String r102 = r101.next();
            r100.put(r102, get(r102));
            goto L4
        L6:
            return r100;
        }

        public final boolean a(int r100) {
            if (TextUtils.isEmpty(b()) == false) goto L5;
        L7:
            boolean r101 = false;
        L9:
            if ((r100 & 2) != 2) goto L16;
            if (r101 == true) goto L12;
        L14:
            r101 = false;
            goto L16
        L12:
            if (TextUtils.isEmpty(c()) == true) goto L14;
            r101 = true;
        L16:
            if ((r100 & 1) != 1) goto L22;
            if (r101 == true) goto L19;
            return false;
        L19:
            if (TextUtils.isEmpty(d()) == true) goto L24;
            return true;
        L24:
            return false;
        L22:
            return r101;
        L5:
            if (TextUtils.isEmpty(e()) == true) goto L7;
            r101 = true;
            goto L9
        }

        public final String b() {
            Object r100 = get("ak");
            if ((r100 instanceof String) == true) goto L7;
            return null;
        L7:
            return (String) r100;
        }

        public final String c() {
            Object r100 = get("channel");
            if ((r100 instanceof String) == true) goto L7;
            return null;
        L7:
            return (String) r100;
        }

        public final String d() {
            Object r100 = get("device_id");
            if ((r100 instanceof String) == true) goto L7;
            return null;
        L7:
            return (String) r100;
        }

        public final String e() {
            Object r100 = get("service_name");
            if ((r100 instanceof String) == true) goto L7;
            return null;
        L7:
            return (String) r100;
        }
    }

    public class a implements HostnameVerifier {
        public a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String r100, SSLSession r101) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
        L7:
            return false;
        L5:
            if ("https://api.map.baidu.com".contains(r100) == false) goto L7;
            return true;
        }
    }

    public static final class b implements ILicenseAuthListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ILicenseAuthListener f31763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f31764b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Map f31765a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f31766b;

            public a(b r100, Map r101) {
                this.f31766b = r100;
                this.f31765a = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com_baidu_mapauto_auth_AuthCore$b$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public final void com_baidu_mapauto_auth_AuthCore$b$a__run$___twin___() {
                LogUtil r100 = LogUtil.getInstance();
                String r101 = AuthCore.TAG;
                StringBuilder r102 = com.baidu.mapauto.auth.b.a("授权成功(回调 ");
                r102.append(this.f31766b.f31763a);
                r102.append("): ");
                r102.append(this.f31765a);
                r100.i(r101, r102.toString());
                ILicenseAuthListener r103 = this.f31766b.f31763a;
                if (r103 == null) goto L6;
                r103.onSuccess(this.f31765a);
                return;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_baidu_mapauto_auth_AuthCore$b$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
                r100.com_baidu_mapauto_auth_AuthCore$b$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.baidu.mapauto.auth.AuthCore$b$b, reason: collision with other inner class name */
        public class RunnableC0633b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f31767a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f31768b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Exception f31769c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ b f31770d;

            public RunnableC0633b(b r100, int r101, String r102, Exception r103) {
                this.f31770d = r100;
                this.f31767a = r101;
                this.f31768b = r102;
                this.f31769c = r103;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com_baidu_mapauto_auth_AuthCore$b$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public final void com_baidu_mapauto_auth_AuthCore$b$b__run$___twin___() {
                LogUtil r100 = LogUtil.getInstance();
                String r101 = AuthCore.TAG;
                StringBuilder r102 = com.baidu.mapauto.auth.b.a("授权失败(回调 ");
                r102.append(this.f31770d.f31763a);
                r102.append("): code = ");
                r102.append(this.f31767a);
                r102.append(", msg = ");
                r102.append(this.f31768b);
                r100.e(r101, r102.toString());
                ILicenseAuthListener r103 = this.f31770d.f31763a;
                if (r103 == null) goto L6;
                r103.onError(this.f31767a, this.f31768b, this.f31769c);
                return;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_baidu_mapauto_auth_AuthCore$b$b_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0633b r100) {
                r100.com_baidu_mapauto_auth_AuthCore$b$b__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(ILicenseAuthListener r100) {
            this.f31763a = r100;
            this.f31764b = new Handler(Looper.getMainLooper());
        }

        @Override // com.baidu.mapauto.auth.ILicenseAuthListener
        public final void onSuccess(Map<String, Integer> r100) {
            a r101 = new a(this, r100);
            if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
            r101.run();
            return;
        L5:
            this.f31764b.post(r101);
        }

        @Override // com.baidu.mapauto.auth.ILicenseAuthListener
        public final void onError(int r100, String r101, Exception r102) {
            RunnableC0633b r103 = new RunnableC0633b(this, r100, r101, r102);
            if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
            r103.run();
            return;
        L5:
            this.f31764b.post(r103);
        }
    }

    public AuthCore() {
        this.f31762i = "";
        HashMap r100 = new HashMap(2);
        r100.put(AppInfo.KEY_NPTH_VERSION_NAME, "1.0.0");
        r100.put("sdk_version_code", 1);
        this.f31754a = new com.baidu.mapauto.auth.data.license.impl.a(new com.baidu.mapauto.auth.net.a(new c.a().d().c().b().a(r100).a(new a()).a()));
        TimeUnit r110 = TimeUnit.SECONDS;
        this.f31756c = new PThreadPoolExecutor(2, Integer.MAX_VALUE, 60, r110, new LinkedBlockingQueue(), new DefaultThreadFactory("auth/AuthCore"));
        this.f31757d = new PThreadPoolExecutor(3, Integer.MAX_VALUE, 60, r110, new LinkedBlockingQueue(), new DefaultThreadFactory("auth/AuthCore"));
    }

    public final void a(Context r100, AuthParam r101, int r102, ILicenseAuthListener r103) {
        LogUtil.getInstance().i(TAG, "开始授权");
        b r104 = new b(r103);
        if (r100 != null) goto L7;
        r104.onError(-1002, "context 不可以为空", null);
        return;
    L7:
        if (r101.a(r102) == true) goto L10;
        r104.onError(-1002, "参数错误, 请确保 ak, channel, serviceName 、 file 类型下时的 deviceId 不为空", null);
        return;
    L10:
        this.f31760g = r101.b();
        this.f31761h = r101.d();
        this.f31762i = r101.c();
        if (this.f31755b != null) goto L23;
        monitor-enter(AuthCore.class);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (this.f31755b != null) goto L17;
        this.f31755b = new com.baidu.mapauto.auth.data.license.impl.b(new com.baidu.mapauto.auth.store.a(r100));     // Catch: Throwable -> L19
    L17:
        monitor-exit(AuthCore.class);     // Catch: Throwable -> L19
    L23:
        if (this.f31758e != null) goto L35;
        monitor-enter(AuthCore.class);
    L31:
        th = move-exception;
        throw th;
    L27:
        if (this.f31758e != null) goto L29;
        this.f31758e = new com.baidu.mapauto.auth.process.a(3, this.f31754a, this.f31755b);     // Catch: Throwable -> L31
    L29:
        monitor-exit(AuthCore.class);     // Catch: Throwable -> L31
    L35:
        if (this.f31759f != null) goto L47;
        monitor-enter(AuthCore.class);
    L43:
        th = move-exception;
        throw th;
    L39:
        if (this.f31759f != null) goto L41;
        this.f31759f = new com.baidu.mapauto.auth.process.b(3, this.f31754a, this.f31755b);     // Catch: Throwable -> L43
    L41:
        monitor-exit(AuthCore.class);     // Catch: Throwable -> L43
    L47:
        if ((this.f31755b instanceof com.baidu.mapauto.auth.data.license.impl.b) == false) goto L52;
        com.baidu.mapauto.auth.data.license.impl.b r105 = this.f31755b;
        String r106 = r101.b();
        r101.c();
        r101.e();
        Object r107 = r101.get("function_name");
        if ((r107 instanceof String) == false) goto L51;
        String r108 = (String) r107;
    L51:
        String r109 = r101.d();
        r105.getClass();
        r105.f31790b = r106 + r109;
    L52:
        this.f31756c.submit(new com.baidu.mapauto.auth.a(this, r102, r104, r101));
    }

    public final HashMap a(Context r110, String r111, String r210, String r211, String r212, String r213, int r214) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        LogUtil r100 = LogUtil.getInstance();
        String r101 = TAG;
        r100.i(r101, "本地: 开始授权");
        if (r110 != null) goto L5;
        LogUtil.getInstance().i(r101, "本地: context 为空");
        throw new BaseLicenseAuthDataStandardProcess.ProcessException(-1002, "context 不可以为空");
    L5:
        if (TextUtils.isEmpty(r111) == false) goto L7;
        String r102 = this.f31760g;
    L9:
        if (TextUtils.isEmpty(r210) == false) goto L11;
        String r112 = this.f31761h;
    L13:
        if (TextUtils.isEmpty(r211) == false) goto L15;
        String r103 = this.f31762i;
    L16:
        AuthParam r113 = new AuthParam(r102, r103, r112, r212, r213, 0, new HashMap(0));
        if (r113.a(r214) == true) goto L19;
        LogUtil.getInstance().i(r101, "本地: 核心参数检测失败");
        throw new BaseLicenseAuthDataStandardProcess.ProcessException(-1002, "参数错误, 请确保 ak, channel, serviceName 、 file 类型下时的 deviceId 不为空");
    L19:
        if (this.f31755b != null) goto L31;
        monitor-enter(AuthCore.class);
    L27:
        th = move-exception;
        throw th;
    L23:
        if (this.f31755b != null) goto L25;
        this.f31755b = new com.baidu.mapauto.auth.data.license.impl.b(new com.baidu.mapauto.auth.store.a(r110));     // Catch: Throwable -> L27
    L25:
        monitor-exit(AuthCore.class);     // Catch: Throwable -> L27
    L31:
        if ((this.f31755b instanceof com.baidu.mapauto.auth.data.license.impl.b) == false) goto L33;
        com.baidu.mapauto.auth.data.license.impl.b r104 = this.f31755b;
        r104.getClass();
        r104.f31790b = r102 + r112;
    L33:
        ArrayList r105 = new ArrayList(2);
        if ((r214 & 1) != 1) goto L37;
        r105.add(new com.baidu.mapauto.auth.process.a(2, this.f31754a, this.f31755b));
        LogUtil.getInstance().i(r101, "本地: 添加 license file 授权流程");
    L37:
        if ((r214 & 2) != 2) goto L40;
        r105.add(new com.baidu.mapauto.auth.process.b(2, this.f31754a, this.f31755b));
        LogUtil.getInstance().i(r101, "本地: 添加 license function 授权流程");
    L40:
        if (r105.isEmpty() == false) goto L43;
        LogUtil.getInstance().i(r101, "本地: 没有发现任何授权流程");
        return new HashMap(0);
    L43:
        HashMap r106 = new HashMap();
        Iterator r107 = r105.iterator();
    L45:
        if (r107.hasNext() == false) goto L52;
        r106.putAll(((BaseLicenseAuthDataStandardProcess) r107.next()).a(r113));     // Catch: BaseLicenseAuthDataStandardProcess.ProcessException -> L49
    L49:
        e = move-exception;
        LogUtil r108 = LogUtil.getInstance();
        String r109 = TAG;
        StringBuilder r114 = com.baidu.mapauto.auth.b.a("本地: 授权异常结束（");
        r114.append(e.getMessage());
        r114.append(")");
        r108.i(r109, r114.toString());
        throw e;
    L52:
        LogUtil.getInstance().i(TAG, "本地: 授权成功结束");
        return r106;
    L15:
        r103 = r211;
        goto L16
    L11:
        r112 = r210;
        goto L13
    L7:
        r102 = r111;
        goto L9
    }
}
