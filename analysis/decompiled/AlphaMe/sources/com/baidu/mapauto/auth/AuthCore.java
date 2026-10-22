package com.baidu.mapauto.auth;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.constant.ErrorCode;
import com.baidu.mapauto.auth.net.c;
import com.baidu.mapauto.auth.util.LogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public class AuthCore {
    public static final String TAG = "AuthCore";
    public static final int TYPE_LICENSE_ALL = 3;
    public static final int TYPE_LICENSE_FILE = 1;
    public static final int TYPE_LICENSE_FUNCTION = 2;

    /* renamed from: a, reason: collision with root package name */
    public final com.baidu.mapauto.auth.data.license.impl.a f7635a;

    /* renamed from: b, reason: collision with root package name */
    public volatile com.baidu.mapauto.auth.data.license.impl.b f7636b;

    /* renamed from: c, reason: collision with root package name */
    public final ThreadPoolExecutor f7637c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadPoolExecutor f7638d;

    /* renamed from: e, reason: collision with root package name */
    public volatile com.baidu.mapauto.auth.process.a f7639e;

    /* renamed from: f, reason: collision with root package name */
    public volatile com.baidu.mapauto.auth.process.b f7640f;

    /* renamed from: g, reason: collision with root package name */
    public String f7641g;

    /* renamed from: h, reason: collision with root package name */
    public String f7642h;

    /* renamed from: i, reason: collision with root package name */
    public String f7643i;

    public static class AuthParam extends HashMap<String, Object> {
        public static final String KEY_EXTRA_APP_VERSION = "extra_app_version";
        public static final String KEY_EXTRA_CUID = "extra_cuid";
        public static final String KEY_EXTRA_MODEL = "extra_model";
        public static final String KEY_EXTRA_OS_VERSION = "extra_os_version";

        public AuthParam() {
        }

        public AuthParam(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) {
            put("ak", str);
            put("channel", str2);
            put("device_id", str3);
            put("service_name", str4);
            put("function_name", str5);
            if (map != null) {
                putAll(map);
            }
            put("sdk_version_name", "1.0.0");
            put("sdk_version_code", 1);
        }

        public final AuthParam a() {
            AuthParam authParam = new AuthParam();
            for (String str : keySet()) {
                authParam.put(str, get(str));
            }
            return authParam;
        }

        public final String b() {
            Object obj = get("ak");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        public final String c() {
            Object obj = get("channel");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        public final String d() {
            Object obj = get("device_id");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        public final String e() {
            Object obj = get("service_name");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        public final boolean a(int i4) {
            boolean z4 = (TextUtils.isEmpty(b()) || TextUtils.isEmpty(e())) ? false : true;
            if ((i4 & 2) == 2) {
                z4 = z4 && !TextUtils.isEmpty(c());
            }
            return (i4 & 1) == 1 ? z4 && !TextUtils.isEmpty(d()) : z4;
        }
    }

    public class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            return !TextUtils.isEmpty(str) && "https://api.map.baidu.com".contains(str);
        }
    }

    public static final class b implements ILicenseAuthListener {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ILicenseAuthListener> f7644a;

        /* renamed from: b, reason: collision with root package name */
        public final Handler f7645b = new Handler(Looper.getMainLooper());

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Map f7646a;

            public a(Map map) {
                this.f7646a = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ILicenseAuthListener iLicenseAuthListener = b.this.f7644a.get();
                LogUtil.getInstance().i(AuthCore.TAG, "授权成功(回调 " + iLicenseAuthListener + "): " + this.f7646a);
                if (iLicenseAuthListener != null) {
                    iLicenseAuthListener.onSuccess(this.f7646a);
                }
            }
        }

        /* renamed from: com.baidu.mapauto.auth.AuthCore$b$b, reason: collision with other inner class name */
        public class RunnableC0020b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f7648a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f7649b;

            public RunnableC0020b(int i4, String str) {
                this.f7648a = i4;
                this.f7649b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ILicenseAuthListener iLicenseAuthListener = b.this.f7644a.get();
                LogUtil.getInstance().e(AuthCore.TAG, "授权失败(回调 " + iLicenseAuthListener + "): code = " + this.f7648a + ", msg = " + this.f7649b);
                if (iLicenseAuthListener != null) {
                    iLicenseAuthListener.onError(this.f7648a, this.f7649b);
                }
            }
        }

        public b(ILicenseAuthListener iLicenseAuthListener) {
            this.f7644a = new WeakReference<>(iLicenseAuthListener);
        }

        @Override // com.baidu.mapauto.auth.ILicenseAuthListener
        public final void onError(int i4, String str) {
            RunnableC0020b runnableC0020b = new RunnableC0020b(i4, str);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                runnableC0020b.run();
            } else {
                this.f7645b.post(runnableC0020b);
            }
        }

        @Override // com.baidu.mapauto.auth.ILicenseAuthListener
        public final void onSuccess(Map<String, Integer> map) {
            a aVar = new a(map);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                aVar.run();
            } else {
                this.f7645b.post(aVar);
            }
        }
    }

    public AuthCore() {
        HashMap map = new HashMap(2);
        map.put("sdk_version_name", "1.0.0");
        map.put("sdk_version_code", 1);
        this.f7635a = new com.baidu.mapauto.auth.data.license.impl.a(new com.baidu.mapauto.auth.net.a(new c.a().d().c().b().a(map).a(new a()).a()));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f7637c = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 60L, timeUnit, new LinkedBlockingQueue());
        this.f7638d = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 60L, timeUnit, new LinkedBlockingQueue());
    }

    public final HashMap a(Context context, String str, String str2, String str3, String str4, String str5, int i4) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        LogUtil logUtil = LogUtil.getInstance();
        String str6 = TAG;
        logUtil.i(str6, "本地: 开始授权");
        if (context == null) {
            LogUtil.getInstance().i(str6, "本地: context 为空");
            throw new BaseLicenseAuthDataStandardProcess.ProcessException(ErrorCode.CODE_PARAMETER_ERROR, "context 不可以为空");
        }
        String str7 = TextUtils.isEmpty(str) ? this.f7641g : str;
        String str8 = TextUtils.isEmpty(str2) ? this.f7642h : str2;
        AuthParam authParam = new AuthParam(str7, TextUtils.isEmpty(str3) ? this.f7643i : str3, str8, str4, str5, new HashMap(0));
        if (!authParam.a(i4)) {
            LogUtil.getInstance().i(str6, "本地: 核心参数检测失败");
            throw new BaseLicenseAuthDataStandardProcess.ProcessException(ErrorCode.CODE_PARAMETER_ERROR, "参数错误, 请确保 ak, channel, serviceName 、 file 类型下时的 deviceId 不为空");
        }
        if (this.f7636b == null) {
            synchronized (AuthCore.class) {
                try {
                    if (this.f7636b == null) {
                        this.f7636b = new com.baidu.mapauto.auth.data.license.impl.b(new com.baidu.mapauto.auth.store.a(context));
                    }
                } finally {
                }
            }
        }
        if (this.f7636b instanceof com.baidu.mapauto.auth.data.license.impl.b) {
            com.baidu.mapauto.auth.data.license.impl.b bVar = this.f7636b;
            bVar.getClass();
            bVar.f7670b = str7 + str8;
        }
        ArrayList arrayList = new ArrayList(2);
        if ((i4 & 1) == 1) {
            arrayList.add(new com.baidu.mapauto.auth.process.a(2, this.f7635a, this.f7636b));
            LogUtil.getInstance().i(str6, "本地: 添加 license file 授权流程");
        }
        if ((i4 & 2) == 2) {
            arrayList.add(new com.baidu.mapauto.auth.process.b(2, this.f7635a, this.f7636b));
            LogUtil.getInstance().i(str6, "本地: 添加 license function 授权流程");
        }
        if (arrayList.isEmpty()) {
            LogUtil.getInstance().i(str6, "本地: 没有发现任何授权流程");
            return new HashMap(0);
        }
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                map.putAll(((BaseLicenseAuthDataStandardProcess) it.next()).a(authParam));
            } catch (BaseLicenseAuthDataStandardProcess.ProcessException e4) {
                LogUtil logUtil2 = LogUtil.getInstance();
                String str9 = TAG;
                StringBuilder sbA = com.baidu.mapauto.auth.a.a("本地: 授权异常结束（");
                sbA.append(e4.getMessage());
                sbA.append(")");
                logUtil2.i(str9, sbA.toString());
                throw e4;
            }
        }
        LogUtil.getInstance().i(TAG, "本地: 授权成功结束");
        return map;
    }
}
