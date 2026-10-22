package cn.com.chinatelecom.account.api;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.com.chinatelecom.account.b;
import cn.com.chinatelecom.account.e;
import cn.com.chinatelecom.account.g;
import cn.com.chinatelecom.account.h0;
import cn.com.chinatelecom.account.j;
import cn.com.chinatelecom.account.q;
import cn.com.chinatelecom.account.r;
import cn.com.chinatelecom.account.y;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CtAuth {
    private static final String TAG = "CtAuth";
    private static volatile CtAuth instance = null;
    public static boolean isInit = false;
    public static String mAppId = "";
    public static String mAppSecret = "";
    public static Context mContext;
    public static Handler mHandler;
    public static TraceLogger mTraceLogger;

    /* JADX INFO: loaded from: classes28.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultListener f24331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f24333c;

        public a(ResultListener r100, String r101, JSONObject r102) {
            this.f24331a = r100;
            this.f24332b = r101;
            this.f24333c = r102;
        }

        public void cn_com_chinatelecom_account_api_CtAuth$a__run$___twin___() {
            if (this.f24331a == null) goto L15;
            String r100 = this.f24332b;     // Catch: Throwable -> L9
            if (r100 == null) goto L7;
            this.f24333c.put("reqId", r100);     // Catch: Throwable -> L9
        L7:
            this.f24331a.onResult(this.f24333c.toString());     // Catch: Throwable -> L9
        L11:
            q.c(this.f24332b);
            return;
        L9:
            th = move-exception;
            th.printStackTrace();
            goto L11
        }

        @Override // java.lang.Runnable
        public void run() {
            cn_com_chinatelecom_account_api_CtAuth$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void cn_com_chinatelecom_account_api_CtAuth$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.cn_com_chinatelecom_account_api_CtAuth$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public CtAuth() {
    }

    public static CtAuth getInstance() {
        if (instance != null) goto L15;
        monitor-enter(CtAuth.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CtAuth();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CtAuth.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public static void info(String r100, String r101) {
        if (mTraceLogger == null) goto L6;
        mTraceLogger.info("CT_" + r100, r101);
        return;
    }

    public static void postResultOnMainThread(String r100, JSONObject r101, ResultListener r102) {
        a r103 = new a(r102, r100, r101);
        mHandler.post(r103);
    }

    public static void warn(String r100, String r101, Throwable r102) {
        if (mTraceLogger == null) goto L6;
        mTraceLogger.warn("CT_" + r100, r101, r102);
        return;
    }

    public Context getContext() {
        return mContext;
    }

    public String getOperatorType() {
        Context r100 = mContext;
        if (r100 == null) goto L7;
        return r.a(r100, false);
    L7:
        throw new IllegalArgumentException("Please call the init method");
    }

    public void init(Context r100, String r101, String r102, TraceLogger r103) {
        if (r100 == null) goto L16;
        if (r101 == null) goto L14;
        if (r102 == null) goto L12;
        if ((r100 instanceof Application) == true) goto L9;
        r100 = r100.getApplicationContext();
    L9:
        mContext = r100;
        j.a(mContext);
        mAppId = r101;
        mAppSecret = r102;
        mTraceLogger = r103;
        return;
    L12:
        throw new IllegalArgumentException("appSecret must not be null!");
    L14:
        throw new IllegalArgumentException("appId must not be null!");
    L16:
        throw new IllegalArgumentException("context must not be null!");
    }

    public boolean isMobileDataEnabled() {
        Context r100 = mContext;
        if (r100 == null) goto L7;
        return r.k(r100);
    L7:
        throw new IllegalArgumentException("Please call the init method");
    }

    public void requestPreCode(CtSetting r100, ResultListener r101) {
        requestPreLogin(r100, r101);
    }

    public void requestPreLogin(CtSetting r100, int r101, ResultListener r102) {
        info(TAG, "called requestPreLogin()");
        if (r102 != null) goto L6;
        return;
    L6:
        if (mContext != null) goto L8;
    L25:
        JSONObject r103 = y.a();
    L15:
        postResultOnMainThread(null, r103, r102);
        return;
    L8:
        if (TextUtils.isEmpty(mAppId) == true) goto L25;
        if (TextUtils.isEmpty(mAppSecret) == true) goto L25;
        if (r.m(mContext) == true) goto L18;
        r103 = y.c();
        goto L15
    L18:
        if (r.l(mContext) == false) goto L21;
        new b(mContext, mAppId, mAppSecret).a(h0.a(e.f24388e), r100, r101, r102);
        return;
    L21:
        if (r.k(mContext) == false) goto L23;
        new b(mContext, mAppId, mAppSecret).b(h0.a(e.f24388e), r100, r101, r102);
        return;
    L23:
        postResultOnMainThread(null, y.b(), r102);
    }

    public void requestPreLogin(CtSetting r100, ResultListener r101) {
        requestPreLogin(r100, g.f24397a, r101);
    }

    public void setDomainName(String r100, String r101, String r102) {
        r.f24445d = r100;
        r.f24446e = r101;
        r.f24447f = r102;
    }
}
