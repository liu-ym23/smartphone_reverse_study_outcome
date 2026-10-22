package com.bytedance.android.gamecp.business.download.custommade;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.gamecp.business.download.custommade.bean.CustomInstallInfo;
import com.bytedance.android.gamecp.business.download.custommade.bean.InstallFailReason;
import com.bytedance.android.gamecp.business.download.p;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.common.utils.e1;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.DownloadComponentManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.AhUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAppInstallHandler;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wu.q;
import wu.u;

/* JADX INFO: loaded from: classes44.dex */
public final class NewSessionInstaller implements g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f52620h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Boolean> f52621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f52622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f52623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f52624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PackageInstaller.Session f52625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<Integer> f52626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f52627g;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/business/download/custommade/NewSessionInstaller$AppLifeCycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", "onForeground", "onBackground", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AppLifeCycleObserver implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f52628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f52629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final NewSessionInstaller f52630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f52631d;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppLifeCycleObserver f52632a;

            public a(AppLifeCycleObserver r100) {
                this.f52632a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AppLifeCycleObserver r100 = this.f52632a;     // Catch: Throwable -> L4
                NewSessionInstaller r101 = r100.f52630c;     // Catch: Throwable -> L4
                Context r102 = r100.getContext();     // Catch: Throwable -> L4
                int r103 = this.f52632a.f52631d;     // Catch: Throwable -> L4
                int r104 = NewSessionInstaller.f52620h;     // Catch: Throwable -> L4
                r101.n(r102, r103);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                yr.c.c("CustomInstaller", "onForeground exception:", th);     // Catch: Throwable -> L9
                Context r105 = this.f52632a.f52629b;     // Catch: Throwable -> L9
                if ((r105 instanceof NewCustomInstallActivity) == false) goto L12;
                com.bytedance.android.gamecp.business.download.custommade.c r106 = com.bytedance.android.gamecp.business.download.custommade.c.f52643a;     // Catch: Throwable -> L9
                com.bytedance.android.gamecp.business.download.custommade.c.b(((NewCustomInstallActivity) r105).f52603q, InstallFailReason.STATUS_FAILURE_SESSION_COMMIT_IN_BG_FAIL);     // Catch: Throwable -> L9
                return;
            L12:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L18;
                throw th;
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public final void onBackground() {
            yr.c.a("CustomInstaller", "onBackground");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public final void onForeground() {
            yr.c.a("CustomInstaller", "onForeground sessionCommit continue");
        L15:
            th = move-exception;
            yr.c.c("CustomInstaller", "onForeground", th);
            return;
        L4:
            if (this.f52630c.f52626f.contains(Integer.valueOf(this.f52631d)) == false) goto L7;
            yr.c.a("CustomInstaller", "onForeground already commit return");     // Catch: Throwable -> L15
            return;
        L7:
            NewSessionInstaller r100 = this.f52630c;     // Catch: Throwable -> L15
            int r101 = NewSessionInstaller.f52620h;     // Catch: Throwable -> L15
            r100.getClass();     // Catch: Throwable -> L15
            if (q.f561371a.getValue().p() == false) goto L10;
            DownloadComponentManager.getInstance().submitIOTask(new k(this));     // Catch: Throwable -> L15
        L11:
            Lifecycle r102 = this.f52628a;     // Catch: Throwable -> L15
            if (r102 == null) goto L19;
            r102.removeObserver(this);     // Catch: Throwable -> L15
            return;
        L19:
            return;
        L10:
            DownloadComponentManager.getInstance().submitIOTask(new a(this));     // Catch: Throwable -> L15
            goto L11
        }

        public final Context getContext() {
            return this.f52629b;
        }

        public AppLifeCycleObserver(Lifecycle r100, Context r101, NewSessionInstaller r102, int r103) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "sessionInstaller");
            this.f52628a = r100;
            this.f52629b = r101;
            this.f52630c = r102;
            this.f52631d = r103;
        }
    }

    public static final class a {
    }

    public static final class b extends PackageInstaller.SessionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f52633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public NewSessionInstaller f52634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f f52635c;

        public b() {
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public final void onBadgingChanged(int r100) {
            yr.c.a("CustomInstaller", "onBadgingChanged：" + r100);
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public final void onCreated(int r100) {
            yr.c.a("CustomInstaller", "onCreated：" + r100 + " curSessionId:" + this.f52633a);
            int r101 = this.f52633a;
            if (r100 == r101) goto L10;
            NewSessionInstaller r102 = this.f52634b;
            if (r102 == null) goto L11;
            Map<Integer, Boolean> r103 = r102.f52621a;
            if (r103 == null) goto L12;
            r103.put(Integer.valueOf(r101), Boolean.TRUE);
            return;
        L12:
            return;
        L11:
            return;
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public final void onActiveChanged(int r100, boolean r101) {
            yr.c.a("CustomInstaller", "onActiveChanged：" + r100 + " active:" + r101);
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public final void onFinished(int r100, boolean r101) {
            yr.c.a("CustomInstaller", "onFinished：" + r100 + " success:" + r101);
            if (r100 != this.f52633a) goto L8;
            f r102 = this.f52635c;
            if (r102 == null) goto L9;
            r102.a(r100, r101);
            return;
        L9:
            return;
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public final void onProgressChanged(int r100, float r101) {
            yr.c.a("CustomInstaller", "onProgressChanged：" + r100 + " progress:" + r101 + " curSessionId" + this.f52633a);
            int r102 = this.f52633a;
            if (r100 == r102) goto L5;
            return;
        L5:
            if (r101 <= 0.8f) goto L13;
            NewSessionInstaller r103 = this.f52634b;
            if (r103 == null) goto L14;
            Map<Integer, Boolean> r104 = r103.f52621a;
            if (r104 == null) goto L15;
            r104.put(Integer.valueOf(r102), Boolean.TRUE);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewSessionInstaller f52636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f52637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f52638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f52639d;

        public c(NewSessionInstaller r100, Context r101, int r102, boolean r103) {
            this.f52636a = r100;
            this.f52637b = r101;
            this.f52638c = r102;
            this.f52639d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f52636a.l(this.f52637b, this.f52638c, this.f52639d);     // Catch: Throwable -> L4
            this.f52636a.k(this.f52637b, this.f52638c);     // Catch: Throwable -> L4
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
    }

    @Override // com.bytedance.android.gamecp.business.download.custommade.g
    public final boolean f() {
        return q.f561371a.getValue().s();
    }

    public NewSessionInstaller() {
        this.f52621a = new LinkedHashMap();
        this.f52626f = new LinkedHashSet();
        this.f52627g = "";
    }

    @Override // com.bytedance.android.gamecp.business.download.custommade.g
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pkgName");
        ConcurrentHashMap<String, Intent> r101 = CustomInstaller.f52577a;
        boolean r102 = false;
        if (CustomInstaller.c() == true) goto L5;
    L15:
        return r102;
    L5:
        if (q.f561371a.getValue().f() == false) goto L15;
        if (UtilsKt.c(this.f52627g) == true) goto L10;
    L14:
        yr.c.a("CustomInstaller", "checkIsSessionInstall pkgName " + r100 + " isSessionInstallingPkg:" + this.f52627g);
        goto L15
    L10:
        if (UtilsKt.c(r100) == false) goto L14;
        if ((!Intrinsics.areEqual(r100, this.f52627g)) == false) goto L14;
        r102 = true;
        goto L14
    }

    @Override // com.bytedance.android.gamecp.business.download.custommade.g
    public final void e(int r100) {
        yr.c.a("CustomInstaller", "onSessionCommitSuc  sessionId: " + r100);
        if (r100 > 0) goto L5;
        return;
    L5:
        this.f52626f.add(Integer.valueOf(r100));
    }

    @Override // com.bytedance.android.gamecp.business.download.custommade.g
    public final boolean g(int r100) {
        Boolean r101 = (Boolean) ((LinkedHashMap) this.f52621a).get(Integer.valueOf(r100));
        Boolean r102 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r101, r102)) == true) goto L5;
    L17:
        Boolean r103 = (Boolean) ((LinkedHashMap) this.f52621a).get(Integer.valueOf(r100));
        if (r103 == null) goto L20;
        boolean r104 = r103.booleanValue();
    L21:
        boolean r105 = !r104;
        yr.c.a("CustomInstaller", "isUserCancel sessionId:" + r100 + " 是否用户取消：" + r105 + tb2.c.DEFAULT_TEXT + String.valueOf(e1.a(this.f52621a)));
        return r105;
    L20:
        r104 = false;
        goto L21
    L5:
        if (f() == false) goto L17;
        Context r106 = y0.getContext();
        if (r106 == null) goto L17;
        PackageManager r107 = r106.getPackageManager();
        if (r107 == null) goto L17;
        PackageInstaller r108 = r107.getPackageInstaller();
        if (r108 == null) goto L17;
        PackageInstaller.SessionInfo r109 = r108.getSessionInfo(r100);
        if (r109 == null) goto L17;
        yr.c.a("CustomInstaller", "isUserCancel getSessionInfo progress: " + r109.getProgress());
        if (r109.getProgress() <= 0.8f) goto L17;
        this.f52621a.put(Integer.valueOf(r100), r102);
        goto L17
    }

    @Override // com.bytedance.android.gamecp.business.download.custommade.g
    public final void h(NewCustomInstallActivity.f r100) {
        this.f52623c = r100;
        ConcurrentHashMap<String, Intent> r101 = CustomInstaller.f52577a;
        if (CustomInstaller.c() == false) goto L9;
        b r102 = this.f52622b;
        if (r102 != null) goto L7;
        r102 = new b();
    L7:
        this.f52622b = r102;
        r102.f52634b = this;
        r102.f52635c = r100;
        yr.c.a("CustomInstaller", "sysSessionCallback  " + r102);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.download.custommade.g
    public final boolean c(Intent r100, p r101) {
        if (r101.f52867q != 1) goto L12;
        Integer r102 = u.f561395a.getValue();
        if (r102 == null) goto L12;
        if (r102.intValue() != 0) goto L12;
        yr.c.b("CustomInstaller", "from order");
        ConcurrentHashMap<String, Intent> r103 = CustomInstaller.f52577a;
        CustomInstaller.d(r101, -1001);
        return false;
    L12:
        if (y0.getContext() == null) goto L41;
        if (r100 == null) goto L41;
        ConcurrentHashMap<String, Intent> r104 = CustomInstaller.f52577a;
        if (((Boolean) CustomInstaller.f52581e.getValue()).booleanValue() == false) goto L18;
        CustomInstaller.d(r101, -1019);
        yr.c.b("CustomInstaller", "预装包通过插件下发，不支持该能力");
        return false;
    L18:
        int r105 = com.bytedance.android.gamecp.business.download.custommade.b.f52641a;
        q r106 = q.f561371a;
        if ((!com.bytedance.android.gamecp.business.download.custommade.b.a(r106.getValue().l())) == true) goto L23;
        CustomInstaller.d(r101, -1006);
        yr.c.b("CustomInstaller", "设备不合法，不支持安装页面定制");
        return false;
    L23:
        if (CustomInstaller.c() == false) goto L35;
        Context r107 = y0.getContext();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (AhUtils.isUnknownSourceEnabled(r107) == false) goto L27;
    L30:
        boolean r108 = true;
    L31:
        if (r108 == true) goto L35;
        CustomInstaller.d(r101, -1016);
        yr.c.b("CustomInstaller", "设备不合法，不适配全机型兼容方案");
        return false;
    L27:
        if (com.bytedance.android.gamecp.business.download.custommade.b.a(r106.getValue().i()) == false) goto L30;
        r108 = false;
    L35:
        if (CustomInstaller.c() == true) goto L37;
    L40:
        return true;
    L37:
        if ((!com.bytedance.android.gamecp.business.download.custommade.b.a(r106.getValue().m())) == true) goto L40;
        CustomInstaller.d(r101, -1017);
        yr.c.b("CustomInstaller", "设备不合法，不支持后台执行安装准备");
        return false;
    L41:
        yr.c.b("CustomInstaller", "intent 为 null return");
        ConcurrentHashMap<String, Intent> r109 = CustomInstaller.f52577a;
        if (r100 != null) goto L44;
        int r110 = -1002;
    L45:
        CustomInstaller.d(r101, r110);
        return false;
    L44:
        r110 = -1004;
        goto L45
    }

    public final void i(Context r100, int r101) {
        yr.c.a("CustomInstaller", "abandonSession sessionId:" + r101);     // Catch: Throwable -> L5
        r100.getPackageManager().getPackageInstaller().abandonSession(r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        yr.c.b("CustomInstaller", "session abandon fail " + Log.getStackTraceString(th));
    }

    public final int j(PackageInstaller r100, PackageInstaller.SessionParams r101) throws IOException {
        ConcurrentHashMap<String, Intent> r102 = CustomInstaller.f52577a;
        if (CustomInstaller.c() == false) goto L9;
        b r103 = this.f52622b;
        if (r103 == null) goto L8;
        r100.registerSessionCallback(r103, new Handler(Looper.getMainLooper()));
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.content.pm.PackageInstaller.SessionCallback");
    L9:
        int r104 = r100.createSession(r101);
        if (CustomInstaller.c() == false) goto L15;
        b r105 = this.f52622b;
        if (r105 == null) goto L14;
        r105.f52633a = r104;
    L14:
        this.f52621a.put(Integer.valueOf(r104), Boolean.FALSE);
    L15:
        yr.c.a("CustomInstaller", "new createSession: " + r104);
        return r104;
    }

    public final void k(Context r100, int r101) {
        List<PackageInstaller.SessionInfo> r102 = r100.getPackageManager().getPackageInstaller().getMySessions();     // Catch: Throwable -> L12
        yr.c.a("CustomInstaller", "doClearSession sessionId:" + r101 + " mySessions:" + r102.size());     // Catch: Throwable -> L12
        if (r102.size() < q.f561371a.getValue().g()) goto L22;
        Iterator<T> r103 = r102.iterator();     // Catch: Throwable -> L12
    L7:
        if (r103.hasNext() == false) goto L23;
        PackageInstaller.SessionInfo r104 = (PackageInstaller.SessionInfo) r103.next();     // Catch: Throwable -> L12
        if (r104.getSessionId() == r101) goto L7;
        i(r100, r104.getSessionId());     // Catch: Throwable -> L12
        goto L7
    L23:
        return;
    L22:
        return;
    L12:
        th = move-exception;
        yr.c.b("CustomInstaller", "clearSession fail " + Log.getStackTraceString(th));
    }

    public final void n(Context r100, int r101) {
        if (com.bytedance.android.gamecp.common.utils.e.a() == true) goto L17;
        yr.c.a("CustomInstaller", "sessionCommit onBackground return");
        if ((r100 instanceof NewCustomInstallActivity) == false) goto L7;
        com.bytedance.android.gamecp.business.download.custommade.c r102 = com.bytedance.android.gamecp.business.download.custommade.c.f52643a;
        Map<String, String> r103 = ((NewCustomInstallActivity) r100).f52603q;
        Intrinsics.checkNotNullParameter(r103, "eventMap");
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("game_install_custom_session_commit_in_bg", r103);
    L7:
        Activity r104 = com.bytedance.android.gamecp.host_api.a.b().getHostAppService().getTopActivity();
        if ((r104 instanceof FragmentActivity) == true) goto L10;
        r104 = null;
    L10:
        FragmentActivity r105 = (FragmentActivity) r104;
        if (r105 != null) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L15;
        r105.getLifecycle().addObserver(new AppLifeCycleObserver(r105.getLifecycle(), r100, this, r101));
        return;
    L15:
        new Handler(Looper.getMainLooper()).post(new m(r105, r100, this, r101));
        return;
    L17:
        Intent r106 = new Intent(r100, NewCustomInstallActivity.class);
        ConcurrentHashMap<String, Intent> r107 = CustomInstaller.f52577a;
        if (Build.VERSION.SDK_INT < 31) goto L20;
        int r108 = 33554432;
    L21:
        PendingIntent r109 = PendingIntent.getActivity(r100, 0, r106, r108);
        PackageInstaller.Session r110 = this.f52625e;
        if (r110 == null) goto L24;
        r110.commit(r109.getIntentSender());
    L24:
        PackageInstaller.Session r111 = this.f52625e;
        if (r111 == null) goto L28;
        r111.close();
    L28:
        if ((r100 instanceof NewCustomInstallActivity) == false) goto L33;
        com.bytedance.android.gamecp.business.download.custommade.c r112 = com.bytedance.android.gamecp.business.download.custommade.c.f52643a;
        Map<String, String> r113 = ((NewCustomInstallActivity) r100).f52603q;
        r113.put("is_foreground", "1");
        Unit r114 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r113, "eventMap");
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("game_install_custom_session_commit_in_bg", r113);
        return;
    L33:
        return;
    L20:
        r108 = 0;
        goto L21
    }

    public final void o(PackageInstaller.Session r110, PolarisFileWrapper r111) {
        PolarisFileInputStreamWrapper r100 = new PolarisFileInputStreamWrapper(r111);     // Catch: Throwable -> L29
        OutputStream r112 = r110.openWrite("base", 0, r111.length());     // Catch: Throwable -> L27
    L25:
        Throwable th10 = th;
    L54:
        throw th10;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        if (r112 != null) goto L52;
    L38:
        if (r100 == null) goto L64;
        r100.close();     // Catch: Exception -> L41
    L41:
        e = move-exception;
        yr.c.c("CustomInstaller", "fileInputStream close fail", e);
    L64:
        yr.c.e("CustomInstaller", "session abandon start");     // Catch: Exception -> L45
        r110.abandon();     // Catch: Exception -> L45
        throw th;
    L45:
        e = move-exception;
        yr.c.b("CustomInstaller", "session abandon fail " + Log.getStackTraceString(e));
        throw th;
    L52:
        r112.close();     // Catch: Exception -> L36
    L36:
        e = move-exception;
        yr.c.b("CustomInstaller", "outputStream close fail " + Log.getStackTraceString(e));
        goto L38
    L6:
        if (Build.VERSION.SDK_INT >= 28) goto L8;
        int r101 = 4096;
    L9:
        byte[] r102 = new byte[r101];     // Catch: Throwable -> L25
    L10:
        int r103 = r100.read(r102);     // Catch: Throwable -> L25
        if (r103 == (-1)) goto L12;
        r112.write(r102, 0, r103);     // Catch: Throwable -> L25
        goto L10
    L12:
        r112.flush();     // Catch: Throwable -> L25
        r110.fsync(r112);     // Catch: Throwable -> L25
        r112.close();     // Catch: Exception -> L15
    L50:
        r100.close();     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        yr.c.c("CustomInstaller", "fileInputStream close fail", e);
        return;
    L15:
        e = move-exception;
        yr.c.b("CustomInstaller", "outputStream close fail " + Log.getStackTraceString(e));
        goto L50
    L8:
        r101 = 1048576;
    L27:
        th = move-exception;
        th10 = th;
        r112 = null;
    L29:
        th = move-exception;
        r100 = null;
        th10 = th;
        r112 = null;
        goto L54
    }

    @Override // com.bytedance.android.gamecp.business.download.custommade.g
    public final void b(Context r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f52627g = "";
        ConcurrentHashMap<String, Intent> r103 = CustomInstaller.f52577a;
        if (CustomInstaller.c() == true) goto L24;
        yr.c.a("CustomInstaller", "unRegisterSessionCallback return");
    L18:
        this.f52623c = null;
        if (q.f561371a.getValue().a() == false) goto L22;
        PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("NewSessionInstaller")).submit(new c(this, r100, r101, r102));
        return;
    L22:
        l(r100, r101, r102);
        k(r100, r101);
        return;
    L24:
        StringBuilder r104 = new StringBuilder("unRegisterSessionCallback: ");     // Catch: Throwable -> L16
        r104.append(r101);     // Catch: Throwable -> L16
        r104.append(" callback.id:");     // Catch: Throwable -> L16
        b r105 = this.f52622b;     // Catch: Throwable -> L16
        if (r105 == null) goto L8;
        Integer r106 = Integer.valueOf(r105.f52633a);     // Catch: Throwable -> L16
    L9:
        r104.append(r106);     // Catch: Throwable -> L16
        r104.append(", sysSessionCallback:");     // Catch: Throwable -> L16
        r104.append(this.f52622b);     // Catch: Throwable -> L16
        yr.c.a("CustomInstaller", r104.toString());     // Catch: Throwable -> L16
        b r107 = this.f52622b;     // Catch: Throwable -> L16
        if (r107 != null) goto L12;
    L14:
        this.f52622b = null;     // Catch: Throwable -> L16
        this.f52621a.remove(Integer.valueOf(r101));     // Catch: Throwable -> L16
        goto L18
    L12:
        if (r107.f52633a != r101) goto L14;
        yr.c.a("CustomInstaller", "unRegisterSessionCallback: " + r101);     // Catch: Throwable -> L16
        r100.getPackageManager().getPackageInstaller().unregisterSessionCallback(r107);     // Catch: Throwable -> L16
        goto L14
    L8:
        r106 = null;
    L16:
        th = move-exception;
        yr.c.b("CustomInstaller", "unRegisterSessionCallback fail " + Log.getStackTraceString(th));
        goto L18
    }

    public final void l(Context r100, int r101, boolean r102) {
        if (r101 <= 0) goto L16;
        if (r102 == false) goto L16;
        q r103 = q.f561371a;
        if (r103.getValue().q() == false) goto L16;
        ConcurrentHashMap<String, Intent> r104 = CustomInstaller.f52577a;
        if (CustomInstaller.c() == false) goto L11;
        new Handler(Looper.getMainLooper()).post(new l(this));
    L11:
        yr.c.a("CustomInstaller", "doClearCurSession sessionId:" + r101 + ' ');
        if (r103.getValue().p() == true) goto L14;
        this.f52626f.remove(Integer.valueOf(r101));
    L14:
        i(r100, r101);
        return;
    L16:
        yr.c.a("CustomInstaller", "doClearCurSession false, sessionId:" + r101 + " isClearCurSession:" + r102);
    }

    @Override // com.bytedance.android.gamecp.business.download.custommade.g
    public final void d(AppCompatActivity r100, CustomInstallInfo r101, PolarisFileWrapper r102, f r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "customInstallInfo");
        Intrinsics.checkNotNullParameter(r102, "downloadFile");
        this.f52627g = r101.getPkgName();     // Catch: Throwable -> L16
        ConcurrentHashMap<String, Intent> r104 = CustomInstaller.f52577a;     // Catch: Throwable -> L16
        if (CustomInstaller.c() == false) goto L7;
        new Handler(Looper.getMainLooper()).post(new n(this, r101));     // Catch: Throwable -> L16
    L7:
        PackageInstaller.SessionParams r105 = new PackageInstaller.SessionParams(1);     // Catch: Throwable -> L16
        PackageInstaller r106 = r100.getPackageManager().getPackageInstaller();     // Catch: Throwable -> L16
        int r107 = j(r106, r105);     // Catch: Throwable -> L16
        f r108 = this.f52623c;     // Catch: Throwable -> L14
        if (r108 == null) goto L11;
        r108.c(r107);     // Catch: Throwable -> L14
    L11:
        PackageInstaller.Session r109 = r106.openSession(r107);     // Catch: Throwable -> L14
        this.f52625e = r109;     // Catch: Throwable -> L14
        o(r109, r102);     // Catch: Throwable -> L14
        yr.c.a("CustomInstaller", "writeSessionResult:true sessionId:" + r107);     // Catch: Throwable -> L14
        n(r100, r107);     // Catch: Throwable -> L14
        m(r100, r107, true, "");
        return;
    L14:
        Throwable th10 = th;
    L18:
        yr.c.c("CustomInstaller", "fileInputStream close fail", th10);
        PackageInstaller.Session r110 = this.f52625e;     // Catch: Throwable -> L23
        if (r110 == null) goto L37;
        r110.abandon();     // Catch: Throwable -> L23
    L37:
        PackageInstaller.Session r111 = this.f52625e;     // Catch: Throwable -> L29
        if (r111 == null) goto L31;
        r111.close();     // Catch: Throwable -> L29
    L31:
        m(r100, r107, false, Log.getStackTraceString(th10));
        return;
    L29:
        th = move-exception;
        yr.c.c("CustomInstaller", "sessionInstall close:" + th.getMessage(), th);
    L23:
        th = move-exception;
        yr.c.c("CustomInstaller", "sessionInstall abandon:" + th.getMessage(), th);
    L16:
        th = move-exception;
        th10 = th;
        r107 = 0;
        goto L18
    }

    public final void m(AppCompatActivity r100, int r101, boolean r102, String r103) {
        yr.c.a("CustomInstaller", "sessionInstallCallback：" + this.f52623c + ", isSuc" + r102);
        f r104 = this.f52623c;
        if (r104 == null) goto L5;
        r104.d(r101, r102, r103);
    L5:
        ConcurrentHashMap<String, Intent> r105 = CustomInstaller.f52577a;
        if (CustomInstaller.c() == true) goto L8;
        return;
    L8:
        if (CustomInstaller.f52580d == null) goto L35;
        if (r102 == true) goto L36;
        yr.c.a("CustomInstaller", "调起系统安装");
        ls.a r106 = CustomInstaller.f52580d;
        if (r106 == null) goto L37;
        CustomInstallInfo r107 = r106.f510487c;
        if (r107 == null) goto L38;
        String r108 = r107.getPkgName();
        if (r108 != null) goto L17;
        r108 = "";
    L17:
        Intrinsics.checkNotNullParameter(r108, "pkgName");
        Intent r109 = CustomInstaller.f52577a.get(r108);
        if (r109 != null) goto L32;
        yr.c.b("CustomInstaller", "doSystemInstall intent 为null return");
        return;
    L32:
        IDownloadAppInstallHandler r110 = AppDownloader.getInstance().getAppInstallHandler();     // Catch: Throwable -> L29
        if (r110 == null) goto L23;
        r110.startActivity(r100, r109);     // Catch: Throwable -> L29
    L25:
        if ((r100 instanceof NewCustomInstallActivity) == false) goto L27;
        com.bytedance.android.gamecp.business.download.custommade.c r111 = com.bytedance.android.gamecp.business.download.custommade.c.f52643a;     // Catch: Throwable -> L29
        Map<String, String> r112 = ((NewCustomInstallActivity) r100).f52603q;     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r112, "eventMap");     // Catch: Throwable -> L29
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("game_install_custom_bg_fail_sys_install_call", r112);     // Catch: Throwable -> L29
    L27:
        CustomInstaller.f52580d = null;     // Catch: Throwable -> L29
        CustomInstaller.a(r100, r101, true, r107.getPkgName());     // Catch: Throwable -> L29
        return;
    L23:
        r100.startActivity(r109);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        yr.c.c("CustomInstaller", "doSystemInstall exception", th);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    }
}
