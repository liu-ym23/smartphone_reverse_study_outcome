package com.bytedanceos.appstore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import com.bytedanceos.appstore.PreloadInstall.OtaInstallPreloadApps;
import com.bytedanceos.appstore.buss.utilities.AppAd;
import com.bytedanceos.appstore.download.manager.AppsInstallManager;
import com.bytedanceos.appstore.download.receiver.ScreenMoniterReceiver;
import com.bytedanceos.appstore.network.ObricAPIHelper;
import com.bytedanceos.appstore.ui.MainActivity;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.core.ui.AppDetailActivity;
import com.bytedanceos.common.download.IJobScheduler;
import com.bytedanceos.common.toolbox.i;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks;
import com.bytedanceos.common.utils.PerformanceMonitor;
import com.obric.appstore.R;
import com.obric.appstore.StoreBaseApplication;
import com.obric.appstore.assistant.intent.DownloadAppIntentV2HandlerImpl;
import com.obric.appstore.util.NetworkManager;
import com.obric.appstore.util.l;
import com.obric.appstore.util.p;
import com.obric.apptools.sdk.common.AppMetrics;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsManager;
import com.smartisanos.appstore.apm.ApmHelper;
import com.smt.obric.appstore.assistant.intent.DownloadAppIntentV2Handler;
import com.smt.obric.appstore.domain.oapplet.InstalledOApplets;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public class AppStoreApplication extends StoreBaseApplication {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f8249w;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f8250r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ConcurrentLinkedQueue f8251s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AppStoreApplicationKtx f8252t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8253u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8254v;

    public class a extends SimpleActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppStoreApplication f8255a;

        public a(AppStoreApplication r10) {
            this.f8255a = r10;
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r10, Bundle r11) {
            AppStoreApplication.A();
            if (AppStoreApplication.z() != 1) goto L6;
            Intent r12 = r10.getIntent();
            AppStoreApplication.C(this.f8255a).b(r12);
        L6:
            if ((r10 instanceof AppDetailActivity) == false) goto L17;
            AppStoreApplication.D(this.f8255a).offer(new WeakReference(r10));
            if (AppStoreApplication.D(this.f8255a).size() > 5) goto L10;
            return;
        L10:
            if (AppStoreApplication.D(this.f8255a).isEmpty() == true) goto L19;
            WeakReference r13 = (WeakReference) AppStoreApplication.D(this.f8255a).poll();
            if (r13 != null) goto L14;
            return;
        L14:
            if (r13.get() == null) goto L21;
            ((Activity) r13.get()).finish();
            return;
        L21:
            return;
        L19:
            return;
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r10) {
            l.f11084a.h(r10);
            AppStoreApplication.B();
            if (AppStoreApplication.z() != 0) goto L5;
            this.f8255a.destroy();
        L5:
            Iterator r11 = AppStoreApplication.D(this.f8255a).iterator();
        L7:
            if (r11.hasNext() == false) goto L14;
            WeakReference r12 = (WeakReference) r11.next();
            if (r12 == null) goto L7;
            Activity r13 = (Activity) r12.get();
            if (r13 == null) goto L7;
            if (r10 != r13) goto L7;
            r11.remove();
            goto L7
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r10) {
            AppStoreApplication.I(this.f8255a, null);
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity r10, Bundle r11) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostDestroyed(Activity r10) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostPaused(Activity r10) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity r10) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostSaveInstanceState(Activity r10, Bundle r11) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity r10) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStopped(Activity r10) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity r10, Bundle r11) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity r10) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity r10) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreResumed(Activity r10) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreSaveInstanceState(Activity r10, Bundle r11) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStarted(Activity r10) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity r10) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r10) {
            AppStoreApplication.H(this.f8255a, r10);
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r10) {
            AppStoreApplication.F(this.f8255a);
            if (AppStoreApplication.E(this.f8255a) != 1) goto L6;
            NetworkManager.b(this.f8255a);
            return;
        }

        @Override // com.bytedanceos.common.ui.listener.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r10) {
            AppStoreApplication.G(this.f8255a);
            if (AppStoreApplication.E(this.f8255a) != 0) goto L6;
            NetworkManager.c();
            return;
        }
    }

    static {
    }

    public AppStoreApplication() {
        this.f8250r = 0;
        this.f8251s = new ConcurrentLinkedQueue();
        this.f8252t = new AppStoreApplicationKtx();
        this.f8253u = true;
        this.f8254v = 0;
    }

    public static /* synthetic */ int A() {
        int r10 = f8249w;
        f8249w = r10 + 1;
        return r10;
    }

    public static /* synthetic */ int B() {
        int r10 = f8249w;
        f8249w = r10 - 1;
        return r10;
    }

    public static /* synthetic */ AppStoreApplicationKtx C(AppStoreApplication r10) {
        return r10.f8252t;
    }

    public static /* synthetic */ ConcurrentLinkedQueue D(AppStoreApplication r10) {
        return r10.f8251s;
    }

    public static /* synthetic */ int E(AppStoreApplication r10) {
        return r10.f8250r;
    }

    public static /* synthetic */ int F(AppStoreApplication r10) {
        int r11 = r10.f8250r;
        r10.f8250r = r11 + 1;
        return r11;
    }

    public static /* synthetic */ int G(AppStoreApplication r10) {
        int r11 = r10.f8250r;
        r10.f8250r = r11 - 1;
        return r11;
    }

    public static /* synthetic */ Activity H(AppStoreApplication r10, Activity r11) {
        r10.f9545a = r11;
        return r11;
    }

    public static /* synthetic */ Activity I(AppStoreApplication r10, Activity r11) {
        r10.f9545a = r11;
        return r11;
    }

    public static /* synthetic */ Unit y(AppStoreApplication r10) {
        return r10.K();
    }

    public static /* synthetic */ int z() {
        return f8249w;
    }

    public void J(Context r10) {
        ec.d.f19371l.b(r10, new ec.a.C0244a().c(r10.getPackageName()).d(100003070).b(false).e("1.0.3").a());
        com.obric.matrix.platform.sdk.ones.init.b.c(r10, new com.obric.matrix.platform.sdk.ones.init.a.C0186a().c(false).b(560514).a());
        ac.a.f80a.a(false);
        long r11 = System.currentTimeMillis();
        MatrixSettingsManager.f11938g.b(r10, new com.obric.matrix.platform.sdk.ones.settings.a.C0188a().c(r10.getPackageName()).d(100003070).b(false).e("1.0.3").a());
        j.n("[AppStoreApplication] MatrixSettingsManager init cost: " + (System.currentTimeMillis() - r11) + "ms");
        ApmHelper.f17867a.d(r10, false);
    }

    public final /* synthetic */ Unit K() {
        M();
        return Unit.f21064a;
    }

    public final void L(String r10, boolean r11) {
        if (this.f8253u == false) goto L8;
        if (r11 == false) goto L6;
        cc.a.f().h(r10);
        return;
    L6:
        cc.a.f().g(r10);
        return;
    }

    public void M() {
        int r10 = this.f8254v + 1;
        this.f8254v = r10;
        if (r10 <= 1) goto L5;
        String r11 = "[AppStoreApplication] onPrivacyAgreed called " + this.f8254v;
        i.b("AppStore", r11);
        j.b("[offline]" + r11);
    L5:
        e9.a.a().b(this);
        ApmHelper.f17867a.i(this);
        com.bytedanceos.appstore.utils.a.v(129, null, null);
    }

    public final void N() {
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.SCREEN_OFF");
        r10.addAction("android.intent.action.SCREEN_ON");
        registerReceiver(new ScreenMoniterReceiver(), r10);
    }

    @Override // com.bytedanceos.common.BaseApplication
    public void a() {
        new OtaInstallPreloadApps().h();
    }

    @Override // com.obric.appstore.StoreBaseApplication, android.content.ContextWrapper
    public void attachBaseContext(Context r10) {
        com.bytedanceos.common.toolbox.b.f9994a.b(this);
        InstalledOApplets.g(this);
        this.f8253u = com.smartisanos.appstore.apm.a.f17873a.c(r10);
        cc.a.f().i(this);
        cc.a.f().l(MainActivity.class.getName());
        super.attachBaseContext(r10);
        f9.a.a(this);
        ac.a.f80a.a(true);
        L("app_attach", false);
    }

    @Override // com.bytedanceos.common.BaseApplication
    public CommonCache b() {
        return com.bytedanceos.appstore.datacache.a.N0();
    }

    @Override // com.bytedanceos.common.BaseApplication
    public com.bytedanceos.common.download.a g() {
        return AppsInstallManager.getInstance();
    }

    @Override // com.bytedanceos.common.tt.helper.IMessageContext
    public String getAppName() {
        return getString(R.string.app_name);
    }

    @Override // com.bytedanceos.common.tt.helper.IMessageContext
    public String getSSAppName() {
        return getString(R.string.app_ss_name_app_store);
    }

    @Override // com.bytedanceos.common.BaseApplication
    public IJobScheduler h() {
        return c8.a.r();
    }

    @Override // com.bytedanceos.common.BaseApplication
    public boolean o() {
        return com.bytedanceos.appstore.utils.d.a();
    }

    @Override // com.bytedanceos.common.BaseApplication, android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.locale == null) goto L9;
        com.bytedanceos.appstore.utils.a.v(131, null, null);
        return;
    }

    @Override // com.bytedanceos.common.BaseApplication, android.app.Application
    public void onCreate() {
        L("app_create", true);
        f9.a.a(this);
        i.e("AppStore", "[AppStoreApplication] onCreate flv=sysapp_update, release, 100003070, (fab1af5f,a80d3b82,2bd8f26b,85579b36,5ad573e1)");
        J(this);
        super.onCreate();
        y7.a.a(this);
        N();
        ObricAPIHelper.f9432a.t();
        AppAd.f8826b.a().c();
        p000if.b.c(this);
        AppMetrics.f11123a.h(this, new p());
        PerformanceMonitor.start(PerformanceMonitor.Event.COLD_LAUNCH);
        this.f8252t.a(new com.bytedanceos.appstore.a(this));
        com.bytedanceos.appstore.buss.utilities.a.f8831a.a(this);
        h9.a.f20383a.b(DownloadAppIntentV2Handler.class, DownloadAppIntentV2HandlerImpl.f10526a);
        com.bytedanceos.appstore.atomic.a.a();
        registerActivityLifecycleCallbacks(new a(this));
        L("app_create", false);
    }

    @Override // com.bytedanceos.common.BaseApplication
    public void x() {
        com.bytedanceos.appstore.datacache.a.N0().x0();
    }
}
