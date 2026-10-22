package cl9;

import android.app.Application;
import android.os.Looper;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.mira.IALogSupport;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.MiraParamPre;
import com.bytedance.mira.event.PluginEventManager;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.core.func.soloader.SoLoader;
import com.bytedance.morpheus.mira.MiraMorpheusHelper;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.api.plugin.service.IPluginService;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f24138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f24139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f24140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CountDownLatch f24141d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CopyOnWriteArraySet<Function0<Unit>> f24142e = null;

    public static final class a implements SoLoader.ILog {
        public a() {
        }

        @Override // com.bytedance.mira.plugin.core.func.soloader.SoLoader.ILog
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "info");
            FLogger.f375446a.i(r100, r101);
        }

        @Override // com.bytedance.mira.plugin.core.func.soloader.SoLoader.ILog
        public final void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "info");
            FLogger.f375446a.e(r100, r101);
        }
    }

    public static final class b implements IALogSupport {
        public b() {
        }

        @Override // com.bytedance.mira.IALogSupport
        public final void i(String r100, String r101) {
            if (r100 == null) goto L5;
            FLogger.f375446a.i(r100, r101);
            return;
        }

        @Override // com.bytedance.mira.IALogSupport
        public final void v(String r100, String r101) {
            if (r100 == null) goto L5;
            FLogger.f375446a.v(r100, r101);
            return;
        }

        @Override // com.bytedance.mira.IALogSupport
        public final void w(String r100, String r101) {
            if (r100 == null) goto L5;
            FLogger.f375446a.w(r100, r101);
            return;
        }

        @Override // com.bytedance.mira.IALogSupport
        public final void e(String r100, String r101, Throwable r102) {
            if (r100 == null) goto L5;
            FLogger.f375446a.e(r100, r101, r102);
            return;
        }

        @Override // com.bytedance.mira.IALogSupport
        public final void w(String r100, String r101, Throwable r102) {
            if (r100 == null) goto L5;
            FLogger.f375446a.w(r100, r101, r102);
            return;
        }
    }

    public g() {
    }

    static {
        f24138a = new g();
        f24141d = new CountDownLatch(1);
        f24142e = new CopyOnWriteArraySet();
    }

    public static MiraParam a() {
        e10 r100 = e10.f368561a;
        lu9.a r101 = e10.u();
        boolean r102 = r101.k();
        if (r102 == false) goto L5;
        boolean r103 = r101.g();
    L6:
        if (r102 == false) goto L8;
        boolean r104 = r101.x();
    L9:
        FLogger.f375446a.i(MiraLogger.TAG_INIT, "plugin cleanup config: useExtended=" + r102 + ", deleteUndeclared=" + r103 + ", keepExpiredUntilInstallNew=" + r104);
        HashMap r105 = new HashMap();
        ArrayList r106 = new ArrayList();
        r106.add("com.samsung.android.permission.GET_APP_LIST");
        r106.add("com.android.permission.GET_INSTALLED_APPS");
        IPluginService r107 = (IPluginService) ServiceManager.get().getService(IPluginService.class);
        if (r107 == null) goto L17;
        Set<String> r108 = r107.b();
        if (r108 == null) goto L17;
        Iterator<T> r109 = r108.iterator();
    L15:
        if (r109.hasNext() == false) goto L17;
        r105.put((String) r109.next(), r106);
    L17:
        HashSet r110 = new HashSet();
        MiraParam.Builder r111 = new MiraParam.Builder().withClassLoaderHook(true).openMiraOpt(true);
        AppHost.Companion r112 = AppHost.f326268a;
        MiraParam.Builder r113 = r111.withDebug(r112.isDebug());
        if (r112.isDebug() == false) goto L20;
        int r114 = 4;
    L21:
        MiraParam r115 = r113.withLogLevel(r114).withHookActivityViewRootImplCallback(null).withEnableDeleteUndeclaredPlugin(r103).withEnableOptIntent(true).withEnableOptMakeApplication(true).withoutHookHostActivityRes(r110).withKeepExpiredPluginUntilInstallNew(r104).withEnableDrawableAccessReport(false).withEnableArrayIndexExceptionFix(false).withEnableSkipCheckPermission(r105).withEnableOptRecovery(true).withEnableOptResourcesArch(true).withEnableInstallProcessOpt(true).withEnableDiffStorageOpt(true).build();
        Intrinsics.checkNotNull(r115);
        return r115;
    L20:
        r114 = 3;
        goto L21
    L8:
        r104 = true;
        goto L9
    L5:
        r103 = true;
        goto L6
    }

    public static SoLoader.Config b() {
        SoLoader.ConfigBuilder r100 = new SoLoader.ConfigBuilder();
        AppHost.Companion r101 = AppHost.f326268a;
        return r100.setDebug(r101.isDebug()).setHostPackageName(r101.getApplication().getPackageName()).setClassloaderGet(new d()).setAction(new e()).setPkgToSoListMap(bl9.c.f19515c).setSoLinkedMap(bl9.c.f19516d).setSoToNeedLoadPkgMap(bl9.c.f19514b).setLogImpl(new a()).build();
    }

    public static boolean e() {
        if (f24139b == true) goto L5;
    L7:
        return false;
    L5:
        if (f24140c == false) goto L7;
        return true;
    }

    public static void f() {
        if (f24140c == false) goto L7;
        FLogger.f375446a.i("mira/start", "morpheus already started");
        return;
    L7:
        monitor-enter(g.class);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (f24140c == false) goto L13;
        FLogger.f375446a.i("mira/start", "morpheus already started2");     // Catch: Throwable -> L17
        monitor-exit(g.class);
        return;
    L13:
        boolean r100 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());     // Catch: Throwable -> L17
        FLogger r101 = FLogger.f375446a;     // Catch: Throwable -> L17
        r101.i("mira/start", "start to start mira: isMainThread=" + r100);     // Catch: Throwable -> L17
        h27.b.a(new cl9.a());     // Catch: Throwable -> L17
        k27.d.b().f501592b = MiraMorpheusHelper.DownloadType.CONCURRENCE;     // Catch: Throwable -> L17
        r101.i(MiraLogger.TAG_INIT, "use parallel download");     // Catch: Throwable -> L17
        f24140c = true;     // Catch: Throwable -> L17
        r101.i("mira/start", "finish to start mira: isMainThread=" + r100);     // Catch: Throwable -> L17
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(g.class);
        f24141d.countDown();
        IApplog.f287053a.f(new c());
    }

    public static void c(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        if (f24139b == true) goto L18;
        FLogger r101 = FLogger.f375446a;
        r101.i(MiraLogger.TAG_INIT, "start to init mira");
        monitor-enter(g.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f24139b == true) goto L12;
        Mira.initPre(AppHost.f326268a.getApplication(), new MiraParamPre.Builder().withEnableOptInitProcess(true).withHostSupport(new cl9.b()).withALogSupport(new b()).build());     // Catch: Throwable -> L15
        boolean r102 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());     // Catch: Throwable -> L15
        r101.i(MiraLogger.TAG_INIT, "start to init mira: isMainThread=" + r102);     // Catch: Throwable -> L15
        bl9.b r103 = new bl9.b();     // Catch: Throwable -> L15
        MiraManager.getInstance().registerPluginEventBeforeLoadListener(r103);     // Catch: Throwable -> L15
        PluginEventManager.getInstance().addPluginEventListener(r103);     // Catch: Throwable -> L15
        MiraManager.getInstance().registerPluginEventListener(r103);     // Catch: Throwable -> L15
        r101.i(MiraLogger.TAG_INIT, "start to init SoLoader");     // Catch: Throwable -> L15
        r101.i(MiraLogger.TAG_INIT, "start to init native Hook");     // Catch: Throwable -> L15
        ByteHook.init();     // Catch: Throwable -> L15
        r101.i(MiraLogger.TAG_INIT, "init native Hook finished");     // Catch: Throwable -> L15
        f24138a.getClass();     // Catch: Throwable -> L15
        d(b(), 500);     // Catch: Throwable -> L15
        Mira.init(r100, a());     // Catch: Throwable -> L15
        f24139b = true;     // Catch: Throwable -> L15
        r101.i(MiraLogger.TAG_INIT, "finish to init mira: isMainThread=" + r102);     // Catch: Throwable -> L15
        Iterator<Function0<Unit>> r104 = f24142e.iterator();     // Catch: Throwable -> L15
    L10:
        if (r104.hasNext() == false) goto L12;
        r104.next().invoke();     // Catch: Throwable -> L15
    L12:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(g.class);
        return;
    }

    public static void d(final SoLoader.Config r100, final long r101) {
        if (SoLoader.init(r100) == true) goto L5;
        t0.b(new f(r100, r101), r101);
        FLogger.f375446a.e(MiraLogger.TAG_INIT, "init SoLoader Failed");
        return;
    L5:
        FLogger.f375446a.i(MiraLogger.TAG_INIT, "init SoLoader Succeed");
    }
}
