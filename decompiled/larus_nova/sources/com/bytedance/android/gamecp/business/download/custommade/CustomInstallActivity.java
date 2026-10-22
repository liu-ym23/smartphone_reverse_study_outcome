package com.bytedance.android.gamecp.business.download.custommade;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.business.download.custommade.bean.CustomInstallInfo;
import com.bytedance.android.gamecp.business.download.custommade.bean.InstallFailReason;
import com.bytedance.android.gamecp.business.download.custommade.fragment.CustomInstallFailFragment;
import com.bytedance.android.gamecp.business.download.custommade.fragment.CustomInstallPrepareFragment;
import com.bytedance.android.gamecp.business.download.custommade.fragment.CustomInstallSuccessFragment;
import com.bytedance.android.gamecp.business.download.custommade.fragment.CustomInstallingFragment;
import com.bytedance.android.gamecp.business.download.p;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.common.utils.j0;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.extend.DownloadCompletedListener;
import com.ss.android.downloadlib.DownloadComponentManager;
import com.ss.android.downloadlib.TTDownloader;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.AhUtils;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import wu.q;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/gamecp/business/download/custommade/CustomInstallActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomInstallActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f52546o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f52547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f52548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CustomInstallInfo f52549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InstallerStep f52550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Fragment f52551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f52552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f52553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f52554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f52555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f52556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, String> f52557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f52558l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f52559m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f f52560n;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final void startActivity(Context r100, String r101, String r102, CustomInstallInfo r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "pkgName");
            Intrinsics.checkNotNullParameter(r102, "downloadFilePath");
            yr.c.a("CustomInstaller", "startActivity:pkgName:" + r101 + ", downloadFilePath:" + r102);
            Intent r104 = new Intent(r100, CustomInstallActivity.class);
            r104.putExtra("extra_pkg_name", r101);
            r104.putExtra("extra_file_path", r102);
            if (r103 == null) goto L5;
            r104.putExtra("gamecp_custom_install_info", r103);
        L5:
            r104.addFlags(268435456);
            r100.startActivity(r104);
        }
    }

    public static final class b implements DownloadCompletedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomInstallActivity f52561a;

        public b(CustomInstallActivity r100) {
            this.f52561a = r100;
        }

        @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
        public final void onCanceled(DownloadInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "downloadInfo");
            Intrinsics.checkNotNullParameter(r100, "downloadInfo");
        }

        @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
        public final void onDownloadFinished(DownloadInfo r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "downloadInfo");
            Intrinsics.checkNotNullParameter(r100, "downloadInfo");
        }

        @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
        public final void onInstalled(DownloadInfo r100, String r101) {
            if (Intrinsics.areEqual(r101, this.f52561a.f52547a) == false) goto L6;
            yr.c.a("CustomInstaller", "pkgName installed " + this.f52561a.f52547a);
            this.f52561a.z1(false);
            return;
        }

        @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
        public final void onDownloadFailed(DownloadInfo r100, BaseException r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "downloadInfo");
            Intrinsics.checkNotNullParameter(r100, "downloadInfo");
        }

        @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
        public final void onDownloadStart(DownloadModel r100, DownloadController r101, DownloadEventConfig r102) {
            Intrinsics.checkNotNullParameter(r100, "downloadModel");
            Intrinsics.checkNotNullParameter(r100, "downloadModel");
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomInstallActivity f52562a;

        public static final class a implements com.bytedance.android.gamecp.business.download.custommade.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f52563a;

            @Override // com.bytedance.android.gamecp.business.download.custommade.f
            public final void a(int r100, boolean r101) {
            }

            @Override // com.bytedance.android.gamecp.business.download.custommade.f
            public final void b(int r100) {
            }

            @Override // com.bytedance.android.gamecp.business.download.custommade.f
            public final void c(int r100) {
            }

            public a(c r100) {
                this.f52563a = r100;
            }

            @Override // com.bytedance.android.gamecp.business.download.custommade.f
            public final void d(int r100, boolean r101, String r102) {
                Intrinsics.checkNotNullParameter(r102, "failMsg");
                CustomInstallActivity r103 = this.f52563a.f52562a;
                r103.f52555i = r100;
                if (r101 == true) goto L9;
                ConcurrentHashMap<String, Intent> r104 = CustomInstaller.f52577a;
                String r105 = r103.f52547a;
                if (r105 == null) goto L7;
                CustomInstaller.f52578b.put(r105, "CustomInstaller");
            L7:
                yr.c.a("CustomInstaller", "安装准备fail，跳转到安装失败页面");
                this.f52563a.f52562a.y1(InstallFailReason.STATUS_FAILURE_SESSION_ERROR, r102);
                return;
            }
        }

        public c(CustomInstallActivity r100) {
            this.f52562a = r100;
        }

        public final void a() {
            yr.c.a("CustomInstaller", "安装准备..");
            CustomInstallActivity r100 = this.f52562a;
            r100.f52550d = InstallerStep.PREPARING;
            r100.A1("page_ready", Integer.MAX_VALUE, "");
            bw.l r101 = com.bytedance.android.gamecp.host_api.a.b().getHostRouteOutCertDataService();
            CustomInstallInfo r102 = this.f52562a.f52549c;
            if (r102 == null) goto L5;
            r102.getRouteOutCertData();
        L5:
            r101.w("install_apk");
            r101.W0();
            ConcurrentHashMap<String, Intent> r103 = CustomInstaller.f52577a;
            CustomInstallActivity r104 = this.f52562a;
            CustomInstallInfo r105 = r104.f52549c;
            Intrinsics.checkNotNull(r105);
            String r106 = this.f52562a.f52548b;
            Intrinsics.checkNotNull(r106);
            PolarisFileWrapper r107 = new PolarisFileWrapper(r106);
            a r108 = new a(this);
            Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r105, "customInstallInfo");
            Intrinsics.checkNotNullParameter(r107, "downloadFile");
            CustomInstaller.b().d(r104, r105, r107, r108);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomInstallActivity f52564a;

        public d(CustomInstallActivity r100) {
            this.f52564a = r100;
        }

        public final void a() {
            CustomInstallActivity r100 = this.f52564a;
            a r101 = CustomInstallActivity.f52546o;
            r100.getClass();
            com.bytedance.android.gamecp.business.download.installstatus.b.a r102 = com.bytedance.android.gamecp.business.download.installstatus.b.f52765l;
            int r103 = r100.getTaskId();
            r102.getClass();
            com.bytedance.android.gamecp.business.download.installstatus.a r104 = com.bytedance.android.gamecp.business.download.installstatus.b.a.a(r100, r103);
            yr.c.a("CustomInstaller", "topPackage:" + r104.f52763a);
            r100.f52554h = Intrinsics.areEqual(r104.f52763a, r100.getPackageName());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomInstallActivity f52565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f52566b;

        public e(CustomInstallActivity r100, boolean r101) {
            this.f52565a = r100;
            this.f52566b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.f52566b == false) goto L11;
            CustomInstallActivity r100 = this.f52565a;     // Catch: Throwable -> L8
            if (r100.f52550d != InstallerStep.PREPARING) goto L15;
            System.currentTimeMillis();     // Catch: Throwable -> L8
            r100.f52550d = InstallerStep.INSTALLING;     // Catch: Throwable -> L8
            yr.c.a("CustomInstaller", "跳转到安装中页面..");     // Catch: Throwable -> L8
            r100.A1("page_installing", Integer.MAX_VALUE, "");     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomInstallActivity f52567a;

        public final void a() {
            CustomInstallActivity r100 = this.f52567a;
            if (r100.f52550d != InstallerStep.INSTALLING) goto L16;
            int r101 = com.bytedance.android.gamecp.common.utils.o.f57249a;
            String r102 = r100.f52547a;
            CustomInstallInfo r103 = r100.f52549c;
            if (r103 == null) goto L9;
            Integer r104 = r103.getVersionCode();
            if (r104 == null) goto L9;
            int r105 = r104.intValue();
        L11:
            if (com.bytedance.android.gamecp.common.utils.o.b(r100, r102, r105) == false) goto L14;
            yr.c.a("CustomInstaller", "check installed pkgName:" + this.f52567a.f52547a);
            this.f52567a.z1(false);
            return;
        L14:
            this.f52567a.f52559m.postDelayed(this, q.f561371a.getValue().d());
            return;
        L9:
            r105 = 0;
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(CustomInstallActivity r100) {
            this.f52567a = r100;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomInstallActivity f52568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f52569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f52570c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f52571d;

        public g(CustomInstallActivity r100, String r101, int r102, String r103) {
            this.f52568a = r100;
            this.f52569b = r101;
            this.f52570c = r102;
            this.f52571d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CustomInstallActivity r100 = this.f52568a;     // Catch: Throwable -> L4
            String r101 = this.f52569b;     // Catch: Throwable -> L4
            int r102 = this.f52570c;     // Catch: Throwable -> L4
            String r103 = this.f52571d;     // Catch: Throwable -> L4
            a r104 = CustomInstallActivity.f52546o;     // Catch: Throwable -> L4
            r100.A1(r101, r102, r103);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.download.custommade.CustomInstallActivity$onCreate$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ CustomInstallActivity this$0;

        public AnonymousClass2(CustomInstallActivity r100) {
            this.this$0 = r100;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            if (Intrinsics.areEqual(r100, this.this$0.f52547a) == false) goto L6;
            yr.c.a("CustomInstaller", "pkgName installed " + this.this$0.f52547a);
            this.this$0.z1(false);
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
        f52546o = new a();
    }

    @JvmStatic
    public static final void startActivity(Context r100, String r101, String r102, CustomInstallInfo r103) {
        f52546o.startActivity(r100, r101, r102, r103);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(CustomInstallActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        Fragment r100 = this.f52551e;
        if (r100 != null) goto L5;
    L14:
        super.onBackPressed();
        return;
    L5:
        if ((r100 instanceof CustomInstallPrepareFragment) == false) goto L14;
        if (((CustomInstallPrepareFragment) r100).handleBackPressed() == false) goto L9;
        return;
    L9:
        ConcurrentHashMap<String, Intent> r101 = CustomInstaller.f52577a;
        CustomInstallInfo r102 = this.f52549c;
        if (r102 == null) goto L12;
        String r103 = r102.getPkgName();
    L13:
        InstallFailReason r104 = InstallFailReason.STATUS_FAILURE_PREPARE_RETURN;
        CustomInstaller.e(r103, r104);
        com.bytedance.android.gamecp.business.download.custommade.c r105 = com.bytedance.android.gamecp.business.download.custommade.c.f52643a;
        com.bytedance.android.gamecp.business.download.custommade.c.b(this.f52556j, r104);
        goto L14
    L12:
        r103 = null;
        goto L13
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CustomInstallActivity.class.getName()));
    L5:
        super.onDestroy();
        ConcurrentHashMap<String, Intent> r100 = CustomInstaller.f52577a;
        String r101 = this.f52547a;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        Intrinsics.checkNotNullParameter(r101, "pkgName");
        CustomInstaller.f52577a.remove(r101);
        yr.c.a("CustomInstaller", LiveCommonConstants.REASON_ON_DEDTROY);
        this.f52552f = false;
        TTDownloader.inst(getApplicationContext()).removeDownloadCompletedListener(this.f52558l);
        this.f52559m.removeCallbacks(this.f52560n);
        int r102 = this.f52555i;
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        CustomInstaller.b().b(this, r102, false);
    }

    public CustomInstallActivity() {
        this.f52550d = InstallerStep.INIT;
        this.f52554h = true;
        this.f52556j = new LinkedHashMap();
        this.f52557k = new LinkedHashMap();
        this.f52558l = new b(this);
        this.f52559m = new Handler(Looper.getMainLooper());
        this.f52560n = new f(this);
    }

    @Override // android.app.Activity
    public final void onRestart() {
        super.onRestart();
        yr.c.a("CustomInstaller", "onRestart");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        yr.c.a("CustomInstaller", "onResume isUserConfirmInstall}");
        this.f52559m.postDelayed(new e(this, this.f52552f), 1000);
        yr.c.a("CustomInstaller", "onResume(), installerStep " + this.f52550d + ", switchSuc" + this.f52554h);
        if (this.f52550d != InstallerStep.PREPARING) goto L8;
        int r100 = com.bytedance.android.gamecp.common.utils.o.f57249a;
        if (com.bytedance.android.gamecp.common.utils.o.b(this, this.f52547a, this.f52553g) == false) goto L8;
        yr.c.a("CustomInstaller", "已经展示过安装完成页面，直接销毁自定义的页面");
        z1(false);
        finish();
    L8:
        if (this.f52550d != InstallerStep.SUCCESS) goto L15;
        if (this.f52554h == true) goto L15;
        int r101 = com.bytedance.android.gamecp.common.utils.o.f57249a;
        if (com.bytedance.android.gamecp.common.utils.o.b(this, this.f52547a, this.f52553g) == false) goto L15;
        yr.c.a("CustomInstaller", "已经展示过安装完成页面，直接销毁自定义的页面");
        finish();
    L15:
        if (this.f52550d == InstallerStep.INSTALLING) goto L17;
        return;
    L17:
        if (this.f52553g <= 0) goto L21;
        yr.c.a("CustomInstaller", "安装中，检测是否安装完成");
        this.f52559m.removeCallbacks(this.f52560n);
        this.f52559m.postDelayed(this.f52560n, q.f561371a.getValue().e());
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        yr.c.a("CustomInstaller", WidgetCostModule.TYPE_ON_START);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        StringBuilder r100 = new StringBuilder("onStop installerStep state:");
        r100.append(this.f52550d.getState());
        r100.append(", versionCode:");
        CustomInstallInfo r101 = this.f52549c;
        if (r101 == null) goto L5;
        Integer r102 = r101.getVersionCode();
    L6:
        r100.append(r102);
        yr.c.a("CustomInstaller", r100.toString());
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L18;
        View r103 = getWindow().getDecorView();     // Catch: Throwable -> L15
        if (com.larus.home.impl.utils.c.f346345e == false) goto L13;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L15
        Thread r104 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L15
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L13;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");     // Catch: Throwable -> L15
    L13:
        r103.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L15
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r110);
        setContentView(com.larus.nova.R.layout.gamecp_install_custom_install);
        j0.e(getWindow());
        j0.b(getWindow());
        Intent r111 = getIntent();
        String r100 = "";
        if (r111 == null) goto L14;
        String r112 = r111.getStringExtra("extra_pkg_name");
        if (r112 == null) goto L14;
    L15:
        this.f52547a = r112;
        Intent r113 = getIntent();
        if (r113 == null) goto L21;
        String r114 = r113.getStringExtra("extra_file_path");
        if (r114 == null) goto L21;
        r100 = r114;
    L21:
        this.f52548b = r100;
        Intent r115 = getIntent();
        Integer r101 = null;
        if (r115 == null) goto L24;
        Serializable r116 = r115.getSerializableExtra("gamecp_custom_install_info");
    L25:
        CustomInstallInfo r117 = (CustomInstallInfo) r116;
        this.f52549c = r117;
        boolean r102 = false;
        if (r117 != null) goto L103;
    L34:
        CustomInstallInfo r118 = this.f52549c;
        if (r118 == null) goto L39;
        Integer r119 = r118.getVersionCode();
        if (r119 == null) goto L39;
        int r120 = r119.intValue();
    L40:
        this.f52553g = r120;
        String r121 = this.f52547a;
        if (r121 != null) goto L43;
    L46:
        boolean r122 = true;
    L48:
        if (r122 == true) goto L101;
        String r123 = this.f52548b;
        if (r123 != null) goto L52;
    L53:
        r102 = true;
    L54:
        if (r102 == true) goto L101;
        if (this.f52549c == null) goto L101;
        Map<String, p> r103 = com.bytedance.android.gamecp.business.download.installstatus.h.f52782a;
        JSONObject r104 = com.bytedance.android.gamecp.business.download.installstatus.h.a(this.f52548b);
        if (r104 != null) goto L105;
    L93:
        DownloadComponentManager.getInstance().submitIOTask(new c(this));
        TTDownloader.inst(getApplicationContext()).addDownloadCompletedListener(this.f52558l);
        int r124 = com.bytedance.android.gamecp.business.f.f53161a;
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r125 = RomUtils.getName();
        String r105 = RomUtils.getVersion();
        StringBuilder r106 = new StringBuilder("rom name:");
        r106.append(r125);
        r106.append(" rom version:");
        r106.append(r105);
        r106.append(" deviceBrand:");
        r106.append(Build.BRAND);
        r106.append(",deviceModel:");
        r106.append(Build.MODEL);
        r106.append(" VERSION:");
        r106.append(Build.VERSION.RELEASE);
        r106.append("versionName:");
        CustomInstallInfo r126 = this.f52549c;
        if (r126 == null) goto L96;
        String r127 = r126.getVersionName();
    L97:
        r106.append(r127);
        r106.append(",versionCode");
        CustomInstallInfo r128 = this.f52549c;
        if (r128 == null) goto L100;
        r101 = r128.getVersionCode();
    L100:
        r106.append(r101);
        yr.c.a("CustomInstaller", r106.toString());
        return;
    L96:
        r127 = null;
        goto L97
    L105:
        JSONObject r107 = r104.optJSONObject(EventConstants.ExtraJson.DY_GAME_INFO);     // Catch: Exception -> L92
        if (r107 == null) goto L80;
        Iterator<String> r108 = r107.keys();     // Catch: Exception -> L92
        if (r108 == null) goto L80;
    L66:
        if (r108.hasNext() == false) goto L80;
        String r109 = r108.next();     // Catch: Exception -> L92
        if ((!Intrinsics.areEqual(r109, SlcElement.KEY_ATTR)) == false) goto L66;
        if ((!Intrinsics.areEqual(r109, EventConstants.ExtraJson.FRESH_EXTRA)) == false) goto L66;
        if ((!Intrinsics.areEqual(r109, "action_type")) == false) goto L66;
        if ((!Intrinsics.areEqual(r109, "module_name")) == false) goto L66;
        Object r129 = r107.opt(r109);     // Catch: Exception -> L92
        if (r129 == null) goto L78;
        String r130 = r129.toString();     // Catch: Exception -> L92
    L79:
        this.f52556j.put(r109, r130);     // Catch: Exception -> L92
        this.f52557k.put(r109, r130);     // Catch: Exception -> L92
        goto L66
    L78:
        r130 = null;
    L80:
        CustomInstallInfo r131 = this.f52549c;     // Catch: Exception -> L92
        if (r131 == null) goto L83;
        Integer r132 = r131.isFromOrder();     // Catch: Exception -> L92
    L84:
        if (r132 == null) goto L93;
        if (r132.intValue() != 1) goto L93;
        String r133 = r104.optString("unified_game_id");     // Catch: Exception -> L92
        if (UtilsKt.c(r133) == false) goto L93;
        this.f52556j.put("game_id", r133);     // Catch: Exception -> L92
        this.f52557k.put("game_id", r133);     // Catch: Exception -> L92
        goto L93
    L83:
        r132 = null;
        goto L84
    L52:
        if (r123.length() != 0) goto L54;
    L101:
        yr.c.a("CustomInstaller", "pkgName filePath is null return " + this.f52547a + ", " + this.f52548b);
        finish();
        return;
    L43:
        if (r121.length() == 0) goto L46;
        r122 = false;
    L39:
        r120 = 0;
        goto L40
    L103:
        PackageManager r134 = getApplicationContext().getPackageManager();     // Catch: Exception -> L32
        CharSequence r135 = r134.getApplicationLabel(r134.getApplicationInfo(getPackageName(), 0));     // Catch: Exception -> L32
        if ((r135 instanceof String) == true) goto L30;
        r135 = null;
    L30:
        String r136 = (String) r135;     // Catch: Exception -> L32
    L33:
        r117.setAppName(r136);
    L32:
        r136 = null;
        goto L33
    L24:
        r116 = null;
    L14:
        r112 = "";
        goto L15
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        super.onNewIntent(r100);
        StringBuilder r101 = new StringBuilder("onNewIntent，extra:");
        Object r102 = null;
        String r103 = null;
        if (r100 == null) goto L5;
        Bundle r104 = r100.getExtras();
    L6:
        r101.append(r104);
        yr.c.a("CustomInstaller", r101.toString());
        if (r100 == null) goto L51;
        Bundle r105 = r100.getExtras();
        if (r105 != null) goto L12;
        return;
    L12:
        if (r105.containsKey("android.content.pm.extra.STATUS") == true) goto L15;
        yr.c.b("CustomInstaller", "没有status信息，return");
        return;
    L15:
        int r106 = r105.getInt("android.content.pm.extra.STATUS", 0);
        yr.c.a("CustomInstaller", "onNewIntent status:" + r106 + ", msg:" + r105.getString("android.content.pm.extra.STATUS_MESSAGE", "") + ", extra:" + r105 + ' ');
        switch(r106) {
            case -1: goto L33;
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            default: goto L47;
        };
    L18:
        y1(InstallFailReason.STATUS_FAILURE_INCOMPATIBLE, "");
        return;
    L19:
        y1(InstallFailReason.STATUS_FAILURE_STORAGE, "");
        return;
    L20:
        y1(InstallFailReason.STATUS_FAILURE_CONFLICT, "");
        return;
    L21:
        y1(InstallFailReason.STATUS_FAILURE_INVALID, "");
        return;
    L22:
        this.f52550d = InstallerStep.CANCEL;
        yr.c.a("CustomInstaller", "处理安装取消");
        if (AhUtils.isUnknownSourceEnabled(this) == false) goto L25;
        InstallFailReason r107 = InstallFailReason.STATUS_FAILURE_ABORTED_HAS_PERMISSION;
    L26:
        ConcurrentHashMap<String, Intent> r108 = CustomInstaller.f52577a;
        CustomInstallInfo r109 = this.f52549c;
        if (r109 == null) goto L29;
        r103 = r109.getPkgName();
    L29:
        CustomInstaller.e(r103, r107);
        com.bytedance.android.gamecp.business.download.custommade.c r110 = com.bytedance.android.gamecp.business.download.custommade.c.f52643a;
        com.bytedance.android.gamecp.business.download.custommade.c.b(this.f52556j, r107);
        finish();
        return;
    L25:
        r107 = InstallFailReason.STATUS_FAILURE_ABORTED_NO_PERMISSION;
        goto L26
    L30:
        y1(InstallFailReason.STATUS_FAILURE_BLOCKED, "");
        return;
    L31:
        y1(InstallFailReason.STATUS_FAILURE, "");
        return;
    L32:
        this.f52559m.postDelayed(new d(this), 500);
        z1(true);
        return;
    L33:
        Object r111 = r105.get("android.intent.extra.INTENT");
        if ((r111 instanceof Intent) == false) goto L37;
        r102 = r111;
    L37:
        Intent r112 = (Intent) r102;
        if (r112 != null) goto L49;
        y1(InstallFailReason.STATUS_FAILURE_CONFIRM_ERROR, "confirm error");
        return;
    L49:
        startActivity(r112);     // Catch: Throwable -> L42
        this.f52559m.postDelayed(new com.bytedance.android.gamecp.business.download.custommade.a(this), q.f561371a.getValue().o());     // Catch: Throwable -> L42
        return;
    L42:
        th = move-exception;
        yr.c.b("CustomInstaller", "exception:" + Log.getStackTraceString(th));
        InstallFailReason r113 = InstallFailReason.STATUS_FAILURE_START_ACTIVITY;
        String r114 = th.getMessage();
        if (r114 != null) goto L46;
        r114 = "user action fail";
    L46:
        y1(r113, r114);
        return;
    L47:
        y1(InstallFailReason.OTHER, "");
        return;
    L51:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void z1(boolean r100) {
        InstallerStep r101 = this.f52550d;
        InstallerStep r102 = InstallerStep.SUCCESS;
        if (r101 != r102) goto L6;
        yr.c.a("CustomInstaller", "已在安装中，return");
        return;
    L6:
        if (r100 == false) goto L8;
    L11:
        this.f52550d = r102;
        A1("page_installed", Integer.MAX_VALUE, "");
        return;
    L8:
        if (com.bytedance.android.gamecp.common.utils.e.a() == true) goto L11;
        yr.c.a("CustomInstaller", "在后台，不切换为成功页面");
    }

    public final void y1(InstallFailReason r100, String r101) {
        this.f52550d = InstallerStep.FAIL;
        yr.c.a("CustomInstaller", "failCode:" + r100.failureCode + " failMsg:" + r101);
        ConcurrentHashMap<String, Intent> r102 = CustomInstaller.f52577a;
        CustomInstallInfo r103 = this.f52549c;
        if (r103 == null) goto L5;
        String r104 = r103.getPkgName();
    L6:
        CustomInstaller.e(r104, r100);
        A1("page_fail", r100.failureCode, r101);
        com.bytedance.android.gamecp.business.download.custommade.c r105 = com.bytedance.android.gamecp.business.download.custommade.c.f52643a;
        com.bytedance.android.gamecp.business.download.custommade.c.b(this.f52556j, r100);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void A1(String r100, int r101, String r102) {
        if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L7;
        new Handler(Looper.getMainLooper()).post(new g(this, r100, r101, r102));
        return;
    L7:
        if (getSupportFragmentManager().findFragmentByTag(r100) == null) goto L10;
        return;
    L10:
        switch(r100.hashCode()) {
            case -1336021558: goto L22;
            case 883453646: goto L19;
            case 1533008919: goto L16;
            case 1628452851: goto L13;
            default: goto L24;
        };
    L24:
        Fragment r103 = new Fragment();
    L25:
        this.f52551e = r103;
        Bundle r104 = new Bundle();
        CustomInstallInfo r105 = this.f52549c;
        if (r105 == null) goto L28;
        r104.putSerializable("gamecp_custom_install_info", r105);
    L28:
        String r106 = this.f52548b;
        if (r106 == null) goto L31;
        r104.putString("gamecp_custom_install_filepath", r106);
    L31:
        r103.setArguments(r104);
        FragmentTransaction r107 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r107, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r100, com.larus.nova.R.id.content_root) == true) goto L35;
        r107 = r107.replace(com.larus.nova.R.id.content_root, r103, r100);
    L35:
        r107.commitNowAllowingStateLoss();
        return;
    L13:
        if (r100.equals("page_ready") == false) goto L24;
        r103 = new CustomInstallPrepareFragment();
        goto L25
    L16:
        if (r100.equals("page_installing") == false) goto L24;
        r103 = new CustomInstallingFragment();
        goto L25
    L19:
        if (r100.equals("page_fail") == false) goto L24;
        CustomInstallFailFragment r108 = new CustomInstallFailFragment();
        Intrinsics.checkNotNullParameter(r102, "failMsg");
        r108.f52667m = r101;
        r108.f52668n = r102;
        r103 = r108;
        goto L25
    L22:
        if (r100.equals("page_installed") == false) goto L24;
        r103 = new CustomInstallSuccessFragment();
        goto L25
    }
}
