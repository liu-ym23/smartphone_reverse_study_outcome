package com.bytedance.android.gamecp.business.compress;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.gamecp.business.api.response.k;
import com.bytedance.android.gamecp.business.compress.experiment.AcpOptABTestUtils;
import com.bytedance.android.gamecp.business.download.AppLifecycleObserver;
import com.bytedance.android.gamecp.business.download.GamePromoteDownloaderOld;
import com.bytedance.android.gamecp.business.download.k1;
import com.bytedance.android.gamecp.business.download.p;
import com.bytedance.android.gamecp.business.download.s;
import com.bytedance.android.gamecp.business.download.y0;
import com.bytedance.android.gamecp.business.micro.MicroGameManager;
import com.bytedance.android.gamecp.business.patch.GameApkMd5Manager;
import com.bytedance.android.gamecp.business.patch.PatchUpdateManager;
import com.bytedance.android.gamecp.common.utils.NetworkUtils;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.gamecenter.base.order.h;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.DownloadInsideHelper;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.constants.DownloadTaskKeyConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import wu.q1;
import yt.m;

/* JADX INFO: loaded from: classes44.dex */
public final class AirCompressManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f52225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile g f52226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArraySet<g> f52227c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PriorityBlockingQueue<g> f52228d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Integer> f52229e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Integer> f52230f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, List<com.bytedance.android.gamecp.base.core.service.depend.b>> f52231g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, Map<Integer, com.bytedance.android.gamecp.base.core.service.depend.b>> f52232h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f52233i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f52234j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f52235k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f52236l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map<String, String> f52237m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map<String, Integer> f52238n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f52239o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Map<String, p> f52240p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f52241q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AirCompressManager f52242r = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f52243a;

        public a(g r100) {
            this.f52243a = r100;
        }

        public final void a() {
            AirCompressManager r100 = AirCompressManager.f52242r;
            AirCompressManager.f52226b = this.f52243a;
            yr.c.a("AirCompressManager", "取消还原超时监听");
            g r101 = this.f52243a;
            com.bytedance.android.gamecp.business.download.b r110 = r101.f52288a;
            cw.c r111 = r101.f52289b;
            int r102 = r101.f52290c;
            yr.c.e("AirCompressManager", "还原开始 restoreFrom = " + r102);
            if (r110 == null) goto L5;
            String r103 = r110.f52534c;
        L7:
            if (AirCompressManager.t(r103, r110) == true) goto L13;
            yr.c.e("AirCompressManager", "realAirCompress 不是空压包, 无需再次还原");
            AirCompressReport.f52266d.k(r110, 1005, "restore start uncompressed apk", r102);
            if (r111 == null) goto L11;
            r111.onNext();
        L11:
            r100.b();
            return;
        L13:
            if (AirCompressManager.s(r110, r102) == true) goto L17;
            yr.c.e("AirCompressManager", "插件没有就绪 return");
            AirCompressManager.f52226b = null;
            if (AirCompressManager.f52225a == true) goto L153;
            AirCompressManager.q(2, r111);
            return;
        L153:
            return;
        L17:
            String r104 = "";
            if (r110 == null) goto L23;
            String r105 = r110.f52534c;
            if (r105 == null) goto L23;
            String r106 = r105;
        L24:
            int r107 = com.bytedance.android.gamecp.business.patch.experiment.a.f56229a;
            String r108 = AirCompressManager.k(r110);
            if (r110 == null) goto L27;
            JSONObject r109 = r110.f52537f;
        L28:
            yr.c.a("PatchABTestUtils", "isPatchDownload pkgName = " + r108 + ", downloadExtra = " + r109);
            if (r108.length() != 0) goto L31;
            boolean r112 = true;
        L32:
            if (r112 == true) goto L49;
            if (r109 == null) goto L49;
            boolean r113 = ToolUtils.isInstalledApp(h.a(), r108);
            String r114 = r109.optString("local_apk_md5");
            Lazy r115 = GameApkMd5Manager.f56195a;
            AppLifecycleObserver r116 = k1.f52798a;
            Pair r117 = GameApkMd5Manager.e(k1.e(r109), r108, "PatchUpdateABUtils.isPatchAfterDownload");
            if (r117 == null) goto L38;
            String r118 = (String) r117.getFirst();
        L39:
            boolean r119 = r109.optBoolean("is_patch_update", false);
            yr.c.a("PatchABTestUtils", "isPatchDownload isInstalled = " + r113 + ", cacheApkMd5 = " + r114 + ", currentApkMd5 = " + r118 + ", isPatchUpdate = " + r119);
            if (r113 == false) goto L49;
            if (r119 == false) goto L49;
            if (UtilsKt.c(r114) == false) goto L49;
            if (UtilsKt.c(r118) == false) goto L49;
            if (Intrinsics.areEqual(r114, r118) == false) goto L49;
            boolean r120 = true;
        L50:
            if (r120 == false) goto L150;
            ScheduledExecutorService r121 = PatchUpdateManager.f56206a;
            yr.c.a("PatchUpdateManager", "开始增量更新合成");
            if (r110 == null) goto L57;
            String r122 = r110.f52534c;
            if (r122 == null) goto L57;
            String r123 = r122;
        L58:
            com.bytedance.android.gamecp.host_api.a.b().getHostAirCompressService().B2(r123);
            String r124 = AirCompressManager.k(r110);
            if (r110 == null) goto L61;
            JSONObject r125 = r110.f52537f;
        L62:
            DownloadInsideHelper.getGameNameFromExtra(r125);
            String r126 = AirCompressManager.l(r110);
            yr.c.a("PatchUpdateManager", "getOldFilePath pkgName = ".concat(r124));
            if (r124.length() != 0) goto L65;
            boolean r127 = true;
        L67:
            if (r127 == false) goto L69;
            String r128 = null;
        L77:
            if (r128 == null) goto L81;
            r104 = r128;
        L81:
            if (TextUtils.isEmpty(r123) == true) goto L88;
            PolarisFileWrapper r129 = new PolarisFileWrapper(r123);
            if (r129.isFile() == false) goto L88;
            if (r129.exists() == false) goto L88;
            boolean r130 = true;
        L90:
            if (TextUtils.isEmpty(r104) == true) goto L97;
            PolarisFileWrapper r131 = new PolarisFileWrapper(r104);
            if (r131.isFile() == false) goto L97;
            if (r131.exists() == false) goto L97;
            boolean r132 = true;
        L98:
            yr.c.a("PatchUpdateManager", "handlePatch sourceApk = " + r123 + ", oldFilePath = " + r104 + ", targetApk = " + r126 + ", sourceApkExists = " + r130 + ", oldFileExists = " + r132);
            if (r123.length() != 0) goto L101;
            boolean r133 = true;
        L102:
            if (r133 == true) goto L143;
            if (r130 == false) goto L143;
            if (r126.length() != 0) goto L107;
            boolean r134 = true;
        L108:
            if (r134 == true) goto L143;
            if (r104.length() != 0) goto L112;
            boolean r135 = true;
        L113:
            if (r135 == true) goto L143;
            if (r132 == false) goto L143;
            SystemClock.elapsedRealtime();
            AppLifecycleObserver r136 = k1.f52798a;
            if (r110 == null) goto L119;
            JSONObject r137 = r110.f52537f;
        L120:
            k1.e(r137);
            AirCompressReport r138 = AirCompressReport.f52266d;
            Lazy r139 = PatchUpdateManager.f56208c;
            r138.l(r110, r123, ((Boolean) r139.getValue()).booleanValue(), r102, System.currentTimeMillis());
            com.bytedance.android.gamecp.business.patch.f r140 = new com.bytedance.android.gamecp.business.patch.f(r111);
            if (r102 != 2) goto L123;
            boolean r141 = true;
        L124:
            int r142 = cw.b.f465534n;
            cw.b.a r143 = new cw.b.a();
            Intrinsics.checkNotNullParameter(r123, "sourceFilePath");
            r143.f465548a = r123;
            Intrinsics.checkNotNullParameter(r126, "targetFilePath");
            r143.f465549b = r126;
            Intrinsics.checkNotNullParameter(r104, "oldFilePath");
            r143.f465550c = r104;
            r143.f465552e = ((Number) PatchUpdateManager.f56210e.getValue()).intValue();
            r143.f465554g = ((Boolean) r139.getValue()).booleanValue();
            r143.f465555h = true;
            r143.f465556i = r141;
            r143.f465557j = r141;
            Intrinsics.checkNotNullParameter(r140, "airCompressListener");
            r143.f465551d = r140;
            cw.b r144 = new cw.b(r143);
            StringCompanionObject r145 = StringCompanionObject.INSTANCE;
            AirCompressManager.C(String.format("增量包开始合成", Arrays.copyOf(new Object[0], 0)));
            yr.c.e("PatchUpdateManager", "真正调用空压 sdk 的增量更新方法 model = " + r144 + ", airCompressListener = " + r140);
            ((ExecutorService) PatchUpdateManager.f56211f.getValue()).submit(new com.bytedance.android.gamecp.business.patch.e(r144));
            yr.c.e("PatchUpdateManager", "开始合成超时监听");
            ScheduledExecutorService r146 = PatchUpdateManager.f56206a;
            if (r146 != null) goto L127;
        L132:
            PatchUpdateManager.f56206a = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("PatchUpdateManager"));
        L133:
            ScheduledExecutorService r147 = PatchUpdateManager.f56206a;
            if (r147 == null) goto L140;
            PatchUpdateManager.a r148 = new PatchUpdateManager.a(r110, r126, r111);
            Long r149 = q1.f561373a.getValue().p();
            if (r149 == null) goto L138;
            long r150 = r149.longValue();
        L139:
            ScheduledFuture<?> r151 = r147.schedule(r148, r150, TimeUnit.MILLISECONDS);
        L141:
            PatchUpdateManager.f56207b = r151;
        L149:
            r100.b();
            return;
        L138:
            r150 = 300000;
            goto L139
        L140:
            r151 = null;
            goto L141
        L127:
            if (r146.isShutdown() == true) goto L132;
            ScheduledExecutorService r152 = PatchUpdateManager.f56206a;
            if (r152 == null) goto L133;
            if (r152.isTerminated() != true) goto L133;
        L123:
            r141 = false;
            goto L124
        L119:
            r137 = null;
            goto L120
        L112:
            r135 = false;
            goto L113
        L107:
            r134 = false;
        L143:
            if (r130 == true) goto L145;
            int r153 = 1019;
        L148:
            AirCompressManager.o(r110, r126, r153, "file path error", SystemClock.elapsedRealtime(), r111, r102, null, null, Boolean.TRUE, 384);
            goto L149
        L145:
            if (r132 == true) goto L147;
            r153 = 1020;
            goto L148
        L147:
            r153 = 1021;
            goto L148
        L101:
            r133 = false;
        L97:
            r132 = false;
        L88:
            r130 = false;
            goto L90
        L69:
            PackageManager r154 = h.a().getPackageManager();
            if (r154 == null) goto L72;
            ApplicationInfo r155 = r154.getApplicationInfo(r124, 0);
        L73:
            if (r155 == null) goto L75;
            r128 = r155.sourceDir;
        L76:
            yr.c.a("PatchUpdateManager", "getOldFilePath pkgName = " + r124 + ", oldFilePath = " + r128);
            goto L77
        L75:
            r128 = null;
            goto L76
        L72:
            r155 = null;
            goto L73
        L65:
            r127 = false;
            goto L67
        L61:
            r125 = null;
        L57:
            r123 = "";
            goto L58
        L150:
            Lazy r156 = AirCompressOpt.f52246a;
            AirCompressOpt.b(r110, r111, r106, true, ((Boolean) AirCompressManager.f52234j.getValue()).booleanValue(), r102);
            r100.b();
            return;
        L38:
            r118 = null;
        L49:
            r120 = false;
            goto L50
        L31:
            r112 = false;
            goto L32
        L27:
            r109 = null;
        L23:
            r106 = "";
            goto L24
        L5:
            r103 = null;
            goto L7
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

    public static final class b implements cw.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f52244a;

        @Override // cw.c
        public final void onNext() {
            yr.c.a("AirCompressManager", "空压兜底逻辑 还原完成调起安装");
            AppDownloadUtils.startPackageInstaller(GlobalInfo.getContext(), this.f52244a);
        }

        public b(Intent r100) {
            this.f52244a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f52245a;

        public c(String r100) {
            this.f52245a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r100 = AirCompressManager.f52225a;     // Catch: Throwable -> L4
            AirCompressManager.h().erase("key_air_compress_failed" + this.f52245a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AirCompressManager() {
    }

    public static Keva h() {
        return (Keva) f52233i.getValue();
    }

    public final void b() {
        f52226b = null;
        yr.c.a("AirCompressManager", "取消还原超时监听");
        g r100 = f52228d.poll();
        if (r100 == null) goto L5;
        yr.c.e("AirCompressManager", "队列中任务不为空 执行下一个任务");
        f52227c.remove(r100);
        c(r100);
        return;
    L5:
        yr.c.e("AirCompressManager", "队列中没有任务了");
    }

    static {
        f52242r = new AirCompressManager();
        f52227c = new CopyOnWriteArraySet();
        f52228d = new PriorityBlockingQueue();
        f52229e = new LinkedHashMap();
        f52230f = new LinkedHashMap();
        f52231g = new LinkedHashMap();
        f52232h = new ConcurrentHashMap();
        f52233i = LazyKt.lazy(LazyThreadSafetyMode.NONE, AirCompressManager$keva$2.INSTANCE);
        f52234j = LazyKt.lazy(AirCompressManager$checkSumEnable$2.INSTANCE);
        f52235k = LazyKt.lazy(AirCompressManager$pluginInitRetryCntSettings$2.INSTANCE);
        f52236l = LazyKt.lazy(AirCompressManager$deviceScore$2.INSTANCE);
        f52237m = new LinkedHashMap();
        f52238n = new LinkedHashMap();
        f52239o = new ConcurrentHashMap();
        f52240p = new ConcurrentHashMap();
        f52241q = LazyKt.lazy(AirCompressManager$versionName$2.INSTANCE);
    }

    public static void B(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        h().storeBoolean("key_air_compress_failed_retry" + r100, true);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static void C(String r100) {
        Intrinsics.checkNotNullParameter(r100, "toastText");
        LocalTestManager.a(new Class[]{uv.a.class});
        int r101 = is.a.f495578a;
        yr.c.a("AirCompressManager", "showToast is not debug env");
    }

    public static void D(String r100) {
        yr.c.a("AirCompressManager", "unregisterAirCompressListener: gameId = " + r100 + ", listener:null");
        Map<String, List<com.bytedance.android.gamecp.base.core.service.depend.b>> r101 = f52231g;
        if (r101 == null) goto L7;
        TypeIntrinsics.asMutableMap(r101).remove(r100);
        h().erase("key_air_compress_failed_retry" + r100);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public static String e(String r100) {
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r100));     // Catch: Throwable -> L13
        byte[] r102 = new byte[4];     // Catch: Throwable -> L11
        r101.read(r102);     // Catch: Throwable -> L11
        String r103 = new String(r102, Charsets.UTF_8);     // Catch: Throwable -> L11
        r101.close();     // Catch: Throwable -> L8
    L10:
        return r103;
    L8:
        th = move-exception;
        th.printStackTrace();
    L11:
        th = th;
    L32:
        th.printStackTrace();     // Catch: Throwable -> L17
        yr.c.a("AirCompressManager", "getFileMagic exception = " + yr.c.d(th));     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r101 != null) goto L28;
    L23:
        throw th;
    L28:
        r101.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
    L13:
        th = th;
        r101 = null;
        goto L32
    }

    public static String f(Intent r100) {
        String r101 = "";
        if (r100 != null) goto L12;
    L7:
        yr.c.a("AirCompressManager", "getFilePathFromIntent filePath = " + r101);     // Catch: Throwable -> L9
        return r101;
    L9:
        th = move-exception;
        yr.c.b("AirCompressManager", "getFilePathFromIntent exception = " + th.getMessage());
        return r101;
    L12:
        Uri r102 = r100.getData();     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r101 = yt.c.a(GlobalInfo.getContext(), AppDownloader.getInstance().getFileProviderAuthority()).getFileForUri(r102).getAbsolutePath();     // Catch: Throwable -> L9
        goto L7
    }

    public static double g(String r100) {
        yr.c.a("AirCompressManager", "getFileSize filePath = " + r100);
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r101 == false) goto L12;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L12:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100);
        if (r103.exists() == false) goto L15;
        int r104 = m.f569019a;
        r102 = m.b(r103.length() / 1048576, 2);
    L15:
        yr.c.a("AirCompressManager", "getFileSize filePath = " + r100 + ", size = " + r102);
        return r102;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static String i(String r100) {
        Map<String, String> r101 = f52237m;
        String r102 = (String) ((LinkedHashMap) r101).get(r100);
        if (UtilsKt.c(r102) == false) goto L6;
        yr.c.a("AirCompressManager", "getLocalApkMd5 cache localApkMd5 = " + r102);
        Intrinsics.checkNotNull(r102);
        return r102;
    L6:
        String r103 = h().getString("key_local_apk_md5" + r100, "");
        yr.c.a("AirCompressManager", "getLocalApkMd5 keva localApkMd5 = " + r103);
        if (UtilsKt.c(r103) == true) goto L9;
    L11:
        return r103;
    L9:
        if (UtilsKt.c(r100) == false) goto L11;
        Intrinsics.checkNotNull(r100);
        r101.put(r100, r103);
        goto L11
    }

    public static int j(String r100) {
        Map<String, Integer> r101 = f52238n;
        Integer r102 = (Integer) ((LinkedHashMap) r101).get(r100);
        if (r102 != null) goto L5;
    L8:
        Integer r103 = Integer.valueOf(h().getInt("key_local_version_code" + r100, 0));
        yr.c.a("AirCompressManager", "getLocalApkMd5 keva localVersionCode = " + r103);
        if (r103.intValue() == 0) goto L14;
        if (UtilsKt.c(r100) == false) goto L14;
        Intrinsics.checkNotNull(r100);
        r101.put(r100, r103);
    L14:
        return r103.intValue();
    L5:
        if (r102.intValue() == 0) goto L8;
        yr.c.a("AirCompressManager", "getLocalApkMd5 cache localVersionCode = " + r102);
        return r102.intValue();
    }

    public static String k(com.bytedance.android.gamecp.business.download.b r100) {
        String r101 = null;
        if (r100 == null) goto L7;
        JSONObject r102 = r100.f52537f;
        if (r102 == null) goto L7;
        String r103 = r102.optString("pkg_name");
    L9:
        if ((!TextUtils.isEmpty(r103)) == true) goto L12;
        r103 = null;
    L12:
        if (r103 != null) goto L17;
        if (r100 == null) goto L18;
        JSONObject r104 = r100.f52537f;
        if (r104 == null) goto L18;
        r101 = r104.optString("package_name");
    L18:
        if (r101 != null) goto L21;
        return "";
    L21:
        return r101;
    L17:
        r101 = r103;
    L7:
        r103 = null;
        goto L9
    }

    public static String l(com.bytedance.android.gamecp.business.download.b r110) {
        if (r110 == null) goto L6;
        String r111 = r110.f52534c;
        if (r111 == null) goto L6;
    L7:
        List r100 = StringsKt.split$default(r111, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        if (r100.isEmpty() == false) goto L11;
        yr.c.b("AirCompressManager", "原始路径为空, 目标路径返回空");
        return "";
    L11:
        List r101 = StringsKt.split$default((String) ListProtector.get(r100, r100.size() - 1), new String[]{"."}, false, 0, 6, null);
        if (r101.isEmpty() == false) goto L15;
        yr.c.b("AirCompressManager", "文件名为空, 目标路径返回空");
        return "";
    L15:
        String r112 = StringsKt.substringBeforeLast$default(r111, HTTP.URL_DEFAULT, null, 2, null) + '/' + ((String) ListProtector.get(r101, 0)) + "1.apk";
        yr.c.a("AirCompressManager", "getTargetApkPath targetApk = " + r112);
        return r112;
    L6:
        r111 = "";
        goto L7
    }

    public static boolean u(String r100) {
        StringBuilder r101 = new StringBuilder("getCancelSource gameId = ");
        r101.append(r100);
        r101.append(", cancelSourceMap = ");
        ConcurrentHashMap<String, Boolean> r102 = f52239o;
        r101.append(r102);
        yr.c.a("AirCompressManager", r101.toString());
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return false;
    L12:
        return Intrinsics.areEqual(r102.get(r100), Boolean.TRUE);
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public static boolean v(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return h().getBoolean("key_air_compress_failed".concat(r100), false);
    }

    public static boolean w(com.bytedance.android.gamecp.business.download.b r100) {
        String r101 = null;
        if (r100 != null) goto L6;
        yr.c.a("AirCompressManager", "isShield downloadShortInfo 为空 为屏蔽场景 直接调起安装");
        AirCompressReport.f52266d.k(null, 1003, "isShield downloadShortInfo is null", 0);
        return true;
    L6:
        JSONObject r102 = r100.f52537f;
        if (r102 == null) goto L9;
        r101 = r102.optString("page");
    L9:
        yr.c.a("AirCompressManager", "isShield page : " + r101);
        if (r101 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == false) goto L19;
        yr.c.a("AirCompressManager", "isShield page 为空为屏蔽场景");
        return true;
    L19:
        return false;
    L12:
        if (r101.length() == 0) goto L15;
        r103 = false;
        goto L16
    }

    public static Pair x(Double r110) {
        yr.c.a("AirCompressManager", "isSpaceEnough: pkgSize = " + r110);
        if (r110 == null) goto L12;
        boolean r100 = false;
        if (r110.doubleValue() <= 0) goto L12;
        long r101 = ToolUtils.getReportableSpaceMB(ToolUtils.getExternalAvailableSpaceBytes(0));
        yr.c.a("AirCompressManager", "isSpaceEnough: pkgSize = " + r110 + ", availableSpace = " + r101);
        if (r101 <= (r110.doubleValue() * 3.5d)) goto L11;
        r100 = true;
    L11:
        return new Pair(Boolean.valueOf(r100), Long.valueOf(r101));
    L12:
        yr.c.a("AirCompressManager", "包大小不合法 不支持空压");
        return new Pair(Boolean.FALSE, -1L);
    }

    public static void z(String r100) {
        yr.c.a("AirCompressManager", "removeAllKeva gameId = " + r100);
        PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("AirCompressManager")).submit(new c(r100));
    }

    public final synchronized void c(g r100) {
        monitor-enter(this);
        StringBuilder r101 = new StringBuilder("doRestore taskSet = ");     // Catch: Throwable -> L18
        CopyOnWriteArraySet<g> r102 = f52227c;     // Catch: Throwable -> L18
        r101.append(r102);     // Catch: Throwable -> L18
        r101.append(", taskQueue = ");     // Catch: Throwable -> L18
        PriorityBlockingQueue<g> r103 = f52228d;     // Catch: Throwable -> L18
        r101.append(r103);     // Catch: Throwable -> L18
        yr.c.e("AirCompressManager", r101.toString());     // Catch: Throwable -> L18
        if (r102.contains(r100) == false) goto L7;
    L15:
        yr.c.e("AirCompressManager", "队列中有相同 task 无需添加");     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L7:
        if (Intrinsics.areEqual(f52226b, r100) == true) goto L15;
        if (f52226b == null) goto L12;
        r103.add(r100);     // Catch: Throwable -> L18
        r102.add(r100);     // Catch: Throwable -> L18
        yr.c.e("AirCompressManager", "正在还原 添加到队列 taskQueue = " + r103 + ", taskSet = " + r102);     // Catch: Throwable -> L18
    L13:
        monitor-exit(this);
        return;
    L12:
        PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("AirCompressManager")).submit(new a(r100));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static void A(String r100, boolean r101) {
        yr.c.a("AirCompressManager", "setFromCancel gameId = " + r100 + ", fromCancel = " + r101);
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        f52239o.put(r100, Boolean.valueOf(r101));
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static void a(com.bytedance.android.gamecp.business.download.b r100, p r101) {
        StringBuilder r102 = new StringBuilder("还原失败 开始取消下载任务2 url short = ");
        String r103 = null;
        if (r100 == null) goto L5;
        String r104 = r100.f52538g;
    L6:
        r102.append(r104);
        yr.c.a("AirCompressManager", r102.toString());
        String r105 = r101.f52855k;
        if (r105 != null) goto L9;
        r105 = "";
    L9:
        Map<String, Integer> r106 = f52230f;
        LinkedHashMap r107 = (LinkedHashMap) r106;
        boolean r108 = false;
        if (r107.get(r105) != null) goto L12;
        r106.put(r105, 0);
    L12:
        Object r109 = r107.get(r105);
        Intrinsics.checkNotNull(r109);
        if (((Number) r109).intValue() <= 0) goto L16;
        yr.c.a("AirCompressManager", "cancelDownload 已经触发过一次取消并重试 无需再次触发");
        return;
    L16:
        Object r110 = r107.get(r105);
        Intrinsics.checkNotNull(r110);
        r106.put(r105, Integer.valueOf(((Number) r110).intValue() + 1));
        A(r101.f52855k, true);
        y0 r111 = y0.f52963a;
        if (r100 == null) goto L19;
        r103 = r100.f52538g;
    L19:
        y0.f(r101);
        Lazy r112 = GamePromoteDownloaderOld.f52417a;
        yr.c.a("GamePromoteDownloaderOld", "取消下载添加标识 downloadUrl = " + r103);
        NativeDownloadModel r113 = ModelManager.getInstance().getNativeModelByUrl(r103);
        if (r113 == null) goto L26;
        AdDownloadModel r114 = r113.getModel();
        if (r114 == null) goto L26;
        JSONObject r115 = r114.getExtra();
        if (r115 == null) goto L26;
        r115.putOpt("cancel_from_restore_fail", Boolean.TRUE);
    L26:
        String r116 = r101.f52855k;
        yr.c.a("AirCompressManager", "saveDownloadInfo gameId = " + r116 + ", downloadInfo = " + r101);
        if (r116 != null) goto L29;
    L30:
        r108 = true;
    L31:
        if (r108 == true) goto L33;
        ((ConcurrentHashMap) f52240p).put(r116, r101);
    L33:
        r111.b(GlobalInfo.getContext(), r101);
        PolarisFileWrapper r117 = new PolarisFileWrapper(l(r100));
        if (r117.exists() == false) goto L37;
        r117.delete();
        return;
    L37:
        return;
    L29:
        if (r116.length() != 0) goto L31;
    L5:
        r104 = null;
        goto L6
    }

    public static com.bytedance.android.gamecp.business.download.b d(p r110, String r111) {
        com.bytedance.android.gamecp.business.download.b r112 = new com.bytedance.android.gamecp.business.download.b(-1, -1, null, -1, 0, null, null);     // Catch: Throwable -> L8
        r112.f52534c = r111;     // Catch: Throwable -> L8
        String r113 = r110.f52840c0;     // Catch: Throwable -> L8
        if (r113 != null) goto L6;
        r113 = "";
    L6:
        r112.f52538g = r113;     // Catch: Throwable -> L8
        JSONObject r114 = new JSONObject();     // Catch: Throwable -> L8
        r114.putOpt("unified_game_id", r110.f52855k);     // Catch: Throwable -> L8
        r114.putOpt(EventConstants.ExtraJson.GAME_NAME, r110.f52836a0);     // Catch: Throwable -> L8
        r114.putOpt("gamecp_download_url", r110.f52842d0);     // Catch: Throwable -> L8
        r114.putOpt("gamecp_task_group", r110.f52866p0);     // Catch: Throwable -> L8
        r114.putOpt("package_name", r110.f52860m0);     // Catch: Throwable -> L8
        r114.putOpt("is_patch_update", Boolean.valueOf(UtilsKt.c(r110.f52848g0)));     // Catch: Throwable -> L8
        r114.putOpt("patch_version", Integer.valueOf(r110.f52850h0));     // Catch: Throwable -> L8
        r114.putOpt("local_apk_md5", r110.f52852i0);     // Catch: Throwable -> L8
        r114.putOpt("gamecp_version_code", Integer.valueOf(r110.f52856k0));     // Catch: Throwable -> L8
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L8
        r112.f52537f = r114;     // Catch: Throwable -> L8
        yr.c.a("AirCompressManager", "download2ShortInfo fileName = " + r112.f52534c + ", package_name = " + r110.f52860m0 + ", downloadUrl = " + r112.f52538g + ", patchUrl = " + r110.f52848g0 + ", extra = " + r112.f52537f);     // Catch: Throwable -> L8
        return r112;
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static void p(p r110, String r111) {
        StringBuilder r100 = new StringBuilder("取消下载回调 删除还原产物 重新触发完整包下载 gameId = ");
        String r101 = null;
        if (r110 == null) goto L5;
        String r102 = r110.f52855k;
    L6:
        r100.append(r102);
        yr.c.e("AirCompressManager", r100.toString());
        if (r110 != null) goto L18;
        StringBuilder r112 = new StringBuilder("getDownloadInfo gameId = ");
        r112.append(r111);
        r112.append(", downloadInfoMap = ");
        Map<String, p> r103 = f52240p;
        r112.append(r103);
        yr.c.a("AirCompressManager", r112.toString());
        if (r111 != null) goto L11;
    L14:
        boolean r113 = true;
    L15:
        if (r113 == false) goto L17;
        r110 = null;
        goto L18
    L17:
        r110 = (p) ((ConcurrentHashMap) r103).get(r111);
        goto L18
    L11:
        if (r111.length() == 0) goto L14;
        r113 = false;
    L18:
        if (r110 == null) goto L22;
        s r114 = r110.G0;
        if (r114 == null) goto L22;
        com.bytedance.android.gamecp.business.download.b r115 = r114.f52917a;
    L23:
        if (r115 == null) goto L27;
        JSONObject r104 = r115.f52537f;
        if (r104 == null) goto L27;
        final Boolean r105 = Boolean.valueOf(r104.optBoolean("is_patch_update"));
    L28:
        yr.c.e("AirCompressManager", "还原失败, 准备重新下载完整包");
        ToastUtil.b("下载失败, 请重试", 0);
        String r106 = "";
        if (r110 == null) goto L32;
        final String r107 = r110.f52855k;
        if (r107 == null) goto L32;
    L34:
        if (NetworkUtils.f(GlobalInfo.getContext()) == true) goto L36;
        yr.c.e("AirCompressManager", "还原失败, 非 Wi-Fi 环境 不触发重新下载 需要用户手动点击重试");
        UtilityKotlinExtentionsKt.g(0, false, false, new AirCompressManager$retryDownload$1(r105, r107), 7);
        return;
    L36:
        if (r115 == null) goto L44;
        JSONObject r116 = r115.f52537f;
        if (r116 == null) goto L44;
        String r117 = r116.optString("gamecp_download_url");
        if (r117 == null) goto L44;
        r106 = r117;
    L44:
        if (UtilsKt.c(r106) == true) goto L46;
    L50:
        StringBuilder r118 = new StringBuilder("Wi-Fi 环境重新下载, 重新下载 downloadUrl = ");
        if (r110 == null) goto L53;
        r101 = r110.f52840c0;
    L53:
        r118.append(r101);
        yr.c.e("AirCompressManager", r118.toString());
        y0.f52963a.a(GlobalInfo.getContext(), r110);
        A(r107, false);
        z(r107);
        return;
    L46:
        if (r110 == null) goto L48;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r110.f52840c0 = r106;
    L48:
        if (r110 == null) goto L50;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r110.f52842d0 = r106;
    L32:
        r107 = "";
    L27:
        r105 = null;
    L22:
        r115 = null;
        goto L23
    L5:
        r102 = null;
        goto L6
    }

    public static void q(int r100, cw.c r101) {
        yr.c.e("AirCompressManager", "initAirCompressPlugin 开始初始化空压插件");
        if (f52225a == false) goto L6;
        yr.c.e("AirCompressManager", "插件已初始化成功 无需再次初始化");
        return;
    L6:
        f52225a = true;
        long r102 = System.currentTimeMillis();
        Map<String, Double> r103 = AirCompressReport.f52263a;
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put(ILoadStallMonitor.START_TIME, String.valueOf(r102));
        r104.put("from", String.valueOf(r100));
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("plugin_init_start", r104);
        com.bytedance.android.gamecp.host_api.a.b().getHostAirCompressService().J1(new com.bytedance.android.gamecp.business.compress.c(r101));
    }

    public static boolean s(com.bytedance.android.gamecp.business.download.b r110, int r111) {
        com.bytedance.android.gamecp.host_api.a.b().getHostAirCompressService().isReady();
        wu.b r100 = wu.b.f561281a;
        if (Intrinsics.areEqual(r100.getValue().k(), Boolean.TRUE) == false) goto L16;
        Keva r101 = h();
        StringBuilder r102 = new StringBuilder("key_ac_plugin_init_succeed_cnt|");
        Lazy r103 = f52241q;
        r102.append((String) r103.getValue());
        long r104 = r101.getLong(r102.toString(), 0);
        Long r105 = r100.getValue().j();
        if (r105 == null) goto L7;
        long r106 = r105.longValue();
    L9:
        if (r104 < r106) goto L11;
        boolean r107 = true;
    L12:
        yr.c.a("AirCompressManager", "插件是否就绪 = false, 插件是否初始化成功过 = " + r107);
        Map<String, Double> r108 = AirCompressReport.f52263a;
        AirCompressReport.b(r110, "plugin_is_ready_false|plugin_has_init_" + r107, r111, Long.valueOf(h().getLong("key_ac_plugin_init_succeed_cnt|" + ((String) r103.getValue()), 0)), Long.valueOf(h().getLong("key_ac_plugin_init_failed_cnt|" + ((String) r103.getValue()), 0)), Boolean.valueOf(h().getBoolean("key_ac_plugin_init_last_succeed|" + ((String) r103.getValue()), false)));
        if (r107 == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r107 = false;
        goto L12
    L7:
        r106 = 1;
        goto L9
    L16:
        yr.c.a("AirCompressManager", "插件是否就绪 = false, 插件是否初始化成功 = false");
        Map<String, Double> r109 = AirCompressReport.f52263a;
        AirCompressReport.b(r110, "plugin_is_ready_false|plugin_is_init_false", r111, 0L, 0L, Boolean.FALSE);
        return false;
    }

    public static boolean t(String r100, com.bytedance.android.gamecp.business.download.b r101) {
        String r102 = e(r100);     // Catch: Throwable -> L7
        yr.c.a("AirCompressManager", "isCompressFile fileMagic = " + r102 + ", fileSize = " + g(r100));     // Catch: Throwable -> L7
        boolean r103 = Intrinsics.areEqual(r102, "^..^");     // Catch: Throwable -> L7
        if (r103 == true) goto L20;
        Map<String, Double> r104 = AirCompressReport.f52263a;     // Catch: Throwable -> L7
        AirCompressReport.e(r101, r102);     // Catch: Throwable -> L7
        return r103;
    L20:
        return r103;
    L7:
        th = move-exception;
        Map<String, Double> r105 = AirCompressReport.f52263a;
        AirCompressReport.e(r101, yr.c.d(th));
        if ((th instanceof FileNotFoundException) == true) goto L16;
        if (r101 == null) goto L14;
        JSONObject r106 = r101.f52537f;
        if (r106 == null) goto L14;
        Double r107 = Double.valueOf(r106.optDouble("gamecp_package_size", AudioStats.AUDIO_AMPLITUDE_NONE));
    L21:
        return Intrinsics.areEqual(r107, g(r100));
    L14:
        r107 = null;
        goto L21
    L16:
        return false;
    }

    public static void y(String r100, com.bytedance.android.gamecp.base.core.service.depend.b r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        yr.c.a("AirCompressManager", "setAirCompressListener gameId = " + r100);
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        AirCompressReport.f52266d.k(null, 1022, "gameId is null not register", 0);
        return;
    L12:
        Map<String, List<com.bytedance.android.gamecp.base.core.service.depend.b>> r103 = f52231g;
        List<com.bytedance.android.gamecp.base.core.service.depend.b> r104 = (List) ((LinkedHashMap) r103).get(r100);
        if (r104 != null) goto L15;
        r104 = new ArrayList();
    L15:
        yr.c.a("AirCompressManager", "setAirCompressListener gameId = " + r100 + ", airCompressListenerList size = " + r104.size());
        r104.add(r101);
        r103.put(r100, r104);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final boolean r(Intent r100, p r101) {
        Intrinsics.checkNotNullParameter(r101, "downloadInfo");
        yr.c.a("AirCompressManager", "空压兜底逻辑");
        String r102 = f(r100);     // Catch: Throwable -> L15
        JSONObject r103 = null;
        if (t(r102, null) == false) goto L17;
        yr.c.a("AirCompressManager", "空压兜底逻辑 是空压包");     // Catch: Throwable -> L15
        com.bytedance.android.gamecp.business.download.b r104 = d(r101, r102);     // Catch: Throwable -> L15
        StringBuilder r105 = new StringBuilder("空压兜底逻辑 ");     // Catch: Throwable -> L15
        if (r104 == null) goto L8;
        String r106 = r104.f52538g;     // Catch: Throwable -> L15
    L9:
        r105.append(r106);     // Catch: Throwable -> L15
        r105.append(", origin = ");     // Catch: Throwable -> L15
        r105.append(r101.f52842d0);     // Catch: Throwable -> L15
        r105.append(", extra = ");     // Catch: Throwable -> L15
        if (r104 == null) goto L12;
        r103 = r104.f52537f;     // Catch: Throwable -> L15
    L12:
        r105.append(r103);     // Catch: Throwable -> L15
        yr.c.a("AirCompressManager", r105.toString());     // Catch: Throwable -> L15
        Map<String, Double> r107 = AirCompressReport.f52263a;     // Catch: Throwable -> L15
        AirCompressReport.h(r101, 3);     // Catch: Throwable -> L15
        m(r104, new b(r100), 6);     // Catch: Throwable -> L15
        return true;
    L8:
        r106 = null;
    L17:
        yr.c.a("AirCompressManager", "空压兜底逻辑 非空压包 无需处理");
        return false;
    L15:
        th = move-exception;
        Map<String, Double> r108 = AirCompressReport.f52263a;
        AirCompressReport.h(r101, 4);
        yr.c.b("AirCompressManager", "空压兜底逻辑异常 = " + th.getMessage());
        goto L17
    }

    public final void m(com.bytedance.android.gamecp.business.download.b r100, cw.c r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        yr.c.a("AirCompressManager", "触发空压还原开始");
        Map<String, Double> r103 = AirCompressReport.f52263a;
        Intrinsics.checkNotNullParameter("pre start", "msg");
        JSONObject r104 = new JSONObject();
        r104.putOpt("fail_status", 1001);     // Catch: Throwable -> L5
        r104.putOpt("fail_msg", "pre start");     // Catch: Throwable -> L5
    L7:
        AirCompressReport.f("restore_pre_start", r104, r100);
        System.currentTimeMillis();
        AppLifecycleObserver r105 = k1.f52798a;
        if (r100 == null) goto L10;
        JSONObject r106 = r100.f52537f;
    L11:
        String r107 = k1.e(r106);
        if (r100 == null) goto L14;
        String r108 = r100.f52534c;
    L16:
        if (t(r108, r100) == true) goto L35;
        yr.c.e("AirCompressManager", "非空压包, 直接调起安装");
        if (r107 != null) goto L20;
        boolean r109 = false;
    L21:
        if (r109 == false) goto L24;
        AirCompressReport.f52266d.k(r100, 1006, "retry download uncompressed apk", r102);
    L33:
        r101.onNext();
        return;
    L24:
        if (w(r100) == false) goto L26;
        AirCompressReport.f52266d.k(r100, 1012, "isShield page is null", r102);
        goto L33
    L26:
        if (r100 == null) goto L32;
        String r110 = r100.f52538g;
        if (r110 == null) goto L32;
        if (StringsKt.contains$default(r110, "offset_0.apk", false, 2, null) != true) goto L32;
        AirCompressReport.f52266d.k(r100, 1016, "ac finish", r102);
    L32:
        AirCompressReport.f52266d.k(r100, 1005, "uncompressed apk", r102);
        goto L33
    L20:
        r109 = h().getBoolean("key_air_compress_failed_retry".concat(r107), false);
        goto L21
    L35:
        c(new g(r100, r101, r102));
        return;
    L14:
        r108 = null;
        goto L16
    L10:
        r106 = null;
    L5:
        th = move-exception;
        yr.c.a("AirCompressReport", "sendRestorePreStart exception = " + th.getMessage());
        goto L7
    }

    public static void n(com.bytedance.android.gamecp.business.api.response.b r310, p r311, JSONObject r312, boolean r313, boolean r314, Pair r410, String r411, int r412) {
        if ((r412 & 8) == 0) goto L5;
        boolean r110 = false;
    L7:
        if ((r412 & 16) == 0) goto L9;
        boolean r111 = false;
    L10:
        Intrinsics.checkNotNullParameter(r310, "info");
        Intrinsics.checkNotNullParameter(r312, "extraObj");
        Intrinsics.checkNotNullParameter(r411, "from");
        String r112 = null;
        if (r311 == null) goto L13;
        String r113 = r311.f52855k;
    L14:
        if (r311 == null) goto L16;
        Double r114 = Double.valueOf(r311.f52854j0);
    L17:
        if (r311 == null) goto L19;
        String r115 = r311.f52860m0;
    L20:
        String r116 = r310.compressedDownloadUrl;
        int r100 = is.a.f495578a;
        yr.c.a("AirCompressManager", "是否优先处理空压：false");
        Lazy r101 = MicroGameManager.f56148a;
        boolean r117 = MicroGameManager.d(r311, r310.microPkgDownloadUrl);
        if (r311 == null) goto L27;
        if (r410 == null) goto L25;
        String r102 = (String) r410.getFirst();
        if (r102 == null) goto L25;
    L26:
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r311.f52852i0 = r102;
    L25:
        r102 = "";
    L27:
        if (r410 == null) goto L30;
        String r103 = (String) r410.getFirst();
        if (r103 == null) goto L30;
    L31:
        if (r311 == null) goto L33;
        String r104 = r311.f52855k;
    L35:
        if (UtilsKt.c(r103) == false) goto L40;
        if (UtilsKt.c(r104) == false) goto L40;
        Map<String, String> r118 = f52237m;
        Intrinsics.checkNotNull(r104);
        r118.put(r104, r103);
        h().storeString("key_local_apk_md5" + r104, r103);
    L40:
        if (r410 == null) goto L44;
        Integer r105 = (Integer) r410.getSecond();
        if (r105 == null) goto L44;
        int r106 = r105.intValue();
    L45:
        if (r311 == null) goto L47;
        String r107 = r311.f52855k;
    L49:
        if (UtilsKt.c(r107) == false) goto L52;
        Map<String, Integer> r108 = f52238n;
        Intrinsics.checkNotNull(r107);
        r108.put(r107, Integer.valueOf(r106));
        h().storeInt("key_local_version_code" + r107, r106);
    L52:
        if (com.bytedance.android.gamecp.business.patch.experiment.a.b() == false) goto L70;
        k r109 = r310.incrementPackageInfoV2;
        if (r109 == null) goto L56;
        String r119 = r109.downloadUrl;
    L57:
        if (r119 != null) goto L59;
    L62:
        boolean r120 = true;
    L63:
        if (r120 == true) goto L70;
        com.bytedance.android.gamecp.business.patch.experiment.c.f56231a.getClass();
        if (h06.a.b().c(com.bytedance.android.gamecp.business.patch.experiment.c.class) != 1) goto L67;
        boolean r121 = true;
    L68:
        if (r121 == false) goto L70;
        r310.incrementPackageInfo = r310.incrementPackageInfoV2;
        goto L70
    L67:
        r121 = false;
        goto L68
    L59:
        if (r119.length() == 0) goto L62;
        r120 = false;
        goto L63
    L56:
        r119 = null;
    L70:
        k r122 = r310.incrementPackageInfo;
        Intrinsics.checkNotNullParameter(r411, "from");
        if (Intrinsics.areEqual(q1.f561373a.getValue().o(), Boolean.TRUE) == false) goto L98;
        String r210 = "";
        String r315 = "<set-?>";
        String r316 = "AirCompressManager";
        if (((Boolean) com.bytedance.android.gamecp.business.patch.experiment.a.e(r122, r113, r115, r114, r411, r410).getFirst()).booleanValue() == true) goto L75;
        String r123 = "patch_version";
    L99:
        boolean r211 = false;
    L101:
        if (r211 == false) goto L212;
        if (r311 == null) goto L104;
        String r124 = r311.f52855k;
    L106:
        if (v(r124) == false) goto L129;
        if (r311 == null) goto L112;
        String r125 = r310.downloadUrl;
        if (r125 != null) goto L111;
        r125 = r210;
    L111:
        String r126 = r315;
        Intrinsics.checkNotNullParameter(r125, r126);
        r311.f52840c0 = r125;
    L462:
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L122
        Object r128 = r310.downloadUrl;     // Catch: Throwable -> L122
        if (r128 != null) goto L116;
        r128 = r210;
    L116:
        r312.put("download_url", r128);     // Catch: Throwable -> L122
        String r129 = r210;
        Result.m9449constructorimpl(r312.put("patch_download_url", r129));     // Catch: Throwable -> L120
    L125:
        if (r311 == null) goto L127;
        String r130 = r311.f52855k;
    L128:
        B(r130);
    L175:
        if (r311 == null) goto L177;
        r112 = r311.f52855k;
    L177:
        z(r112);
        if (r311 == null) goto L185;
        k r131 = r310.incrementPackageInfo;
        if (r131 == null) goto L183;
        String r132 = r131.downloadUrl;
        if (r132 == null) goto L183;
    L184:
        Intrinsics.checkNotNullParameter(r132, r126);
        r311.f52848g0 = r132;
    L183:
        r132 = r129;
    L185:
        if (r311 == null) goto L191;
        k r133 = r310.incrementPackageInfo;
        if (r133 == null) goto L189;
        int r134 = r133.sdkVersion;
    L190:
        r311.f52850h0 = r134;
        goto L191
    L189:
        r134 = 0;
    L191:
        if (r311 == null) goto L456;
        String r135 = r310.downloadUrl;
        if (r135 != null) goto L195;
        r135 = r129;
    L195:
        Intrinsics.checkNotNullParameter(r135, r126);
        r311.f52842d0 = r135;
    L456:
        Object r136 = r310.downloadUrl;     // Catch: Throwable -> L210
        if (r136 != null) goto L199;
        r136 = r129;
    L199:
        r312.put("origin_download_url", r136);     // Catch: Throwable -> L210
        if (r311 == null) goto L205;
        String r137 = r310.taskGroup;     // Catch: Throwable -> L210
        if (r137 != null) goto L204;
        r137 = r129;
    L204:
        r311.f52866p0 = r137;     // Catch: Throwable -> L210
    L205:
        Object r138 = r310.taskGroup;     // Catch: Throwable -> L210
        if (r138 != null) goto L208;
        r138 = r129;
    L208:
        Result.m9449constructorimpl(r312.put(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP, r138));     // Catch: Throwable -> L210
        return;
    L210:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L127:
        r130 = null;
    L120:
        th = th;
    L124:
        Result.Companion r140 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L122:
        th = th;
        r129 = r210;
        goto L124
    L112:
        r126 = r315;
        goto L462
    L129:
        r129 = r210;
        r126 = r315;
        k r141 = r310.incrementPackageInfo;
        if (r141 == null) goto L141;
        String r142 = r141.downloadUrl;
        if (r142 == null) goto L141;
        if (r142.length() <= 0) goto L136;
        boolean r143 = true;
    L137:
        if (r143 == true) goto L140;
        r142 = null;
    L140:
        if (r142 == null) goto L141;
    L142:
        if (r142 != null) goto L144;
        r142 = r129;
    L144:
        if (r311 == null) goto L464;
        Intrinsics.checkNotNullParameter(r142, r126);
        r311.f52840c0 = r142;
    L464:
        Result.Companion r144 = Result.Companion;     // Catch: Throwable -> L157
        r312.put("download_url", r142);     // Catch: Throwable -> L157
        k r145 = r310.incrementPackageInfo;     // Catch: Throwable -> L157
        if (r145 == null) goto L149;
        int r146 = r145.sdkVersion;     // Catch: Throwable -> L157
    L150:
        r312.put(r123, r146);     // Catch: Throwable -> L157
        k r147 = r310.incrementPackageInfo;     // Catch: Throwable -> L157
        if (r147 == null) goto L154;
        Object r148 = r147.downloadUrl;     // Catch: Throwable -> L157
        if (r148 == null) goto L154;
    L155:
        Result.m9449constructorimpl(r312.put("patch_download_url", r148));     // Catch: Throwable -> L157
    L466:
        JSONArray r149 = r312.optJSONArray("patch_backup_urls");     // Catch: Throwable -> L173
        String r150 = r316;
        yr.c.a(r150, "patchBackupUrls:" + r149);     // Catch: Throwable -> L173
        if (r149 != null) goto L171;
        JSONArray r151 = new JSONArray();     // Catch: Throwable -> L173
        k r152 = r310.incrementPackageInfo;     // Catch: Throwable -> L173
        if (r152 == null) goto L170;
        List<String> r153 = r152.backupUrls;     // Catch: Throwable -> L173
        if (r153 == null) goto L170;
        Iterator<T> r154 = r153.iterator();     // Catch: Throwable -> L173
    L168:
        if (r154.hasNext() == false) goto L170;
        r151.put((String) r154.next());     // Catch: Throwable -> L173
    L170:
        r312.put("patch_backup_urls", r151);     // Catch: Throwable -> L173
    L171:
        yr.c.a(r150, "extra:" + r312);     // Catch: Throwable -> L173
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L173
    L173:
        th = move-exception;
        Result.Companion r155 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L154:
        r148 = r129;
        goto L155
    L149:
        r146 = 0;
    L157:
        th = move-exception;
        Result.Companion r156 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L466
    L136:
        r143 = false;
    L141:
        r142 = r310.downloadUrl;
        goto L142
    L104:
        r124 = null;
        goto L106
    L212:
        String r157 = r210;
        String r158 = r315;
        if (r117 == false) goto L265;
        String r159 = r310.microPkgDownloadUrl;
        if (r159 != null) goto L217;
    L225:
        String r160 = r310.downloadUrl;
    L226:
        if (r160 != null) goto L228;
        r160 = r157;
    L228:
        if (r311 == null) goto L454;
        Intrinsics.checkNotNullParameter(r160, r158);
        r311.f52840c0 = r160;
    L454:
        Result.Companion r161 = Result.Companion;     // Catch: Throwable -> L232
        Result.m9449constructorimpl(r312.put("download_url", r160));     // Catch: Throwable -> L232
    L234:
        if (r311 == null) goto L239;
        String r162 = r310.downloadUrl;
        if (r162 != null) goto L238;
        r162 = r157;
    L238:
        Intrinsics.checkNotNullParameter(r162, r158);
        r311.f52842d0 = r162;
    L239:
        if (r311 == null) goto L244;
        String r163 = r310.microPkgDownloadUrl;
        if (r163 != null) goto L243;
        r163 = r157;
    L243:
        Intrinsics.checkNotNullParameter(r163, r158);
        r311.f52844e0 = r163;
    L244:
        if (r110 == false) goto L492;
        List<String> r164 = r310.microBackupUrls;     // Catch: Throwable -> L262
        if (r164 != null) goto L248;
    L251:
        boolean r165 = true;
    L252:
        if (r165 == true) goto L260;
        JSONArray r166 = new JSONArray();     // Catch: Throwable -> L262
        List<String> r167 = r310.microBackupUrls;     // Catch: Throwable -> L262
        if (r167 == null) goto L259;
        Iterator<T> r168 = r167.iterator();     // Catch: Throwable -> L262
    L257:
        if (r168.hasNext() == false) goto L259;
        r166.put((String) r168.next());     // Catch: Throwable -> L262
    L259:
        r312.put("micro_pkg_backup_urls", r166);     // Catch: Throwable -> L262
    L260:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L262
        return;
    L248:
        if (r164.isEmpty() == true) goto L251;
        r165 = false;
    L262:
        th = move-exception;
        Result.Companion r169 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L492:
        return;
    L232:
        th = move-exception;
        Result.Companion r170 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L234
    L217:
        if (r159.length() <= 0) goto L219;
        boolean r171 = true;
    L220:
        if (r171 == false) goto L222;
        r112 = r159;
    L222:
        if (r112 == null) goto L225;
        r160 = r112;
        goto L226
    L219:
        r171 = false;
        goto L220
    L265:
        if (TextUtils.isEmpty(r116) == false) goto L339;
        Integer r172 = AcpOptABTestUtils.a().f();
        if (r172 == null) goto L269;
        int r173 = r172.intValue();
    L270:
        if (r173 <= 0) goto L272;
        boolean r174 = true;
    L273:
        if (r174 == false) goto L339;
        Uri r175 = UriProtector.parse(r310.downloadUrl);     // Catch: Exception -> L293
        if (r175 == null) goto L280;
        String r212 = r175.getPath();     // Catch: Exception -> L293
        if (r212 == null) goto L280;
        List r176 = StringsKt.split$default(r212, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);     // Catch: Exception -> L293
    L281:
        if (r176 == null) goto L283;
        String r177 = (String) CollectionsKt.getOrNull(r176, r176.size() - 1);     // Catch: Exception -> L293
    L285:
        if (TextUtils.isEmpty(r177) == true) goto L294;
        Map<String, com.bytedance.android.gamecp.common.setting.config.e> r178 = AcpOptABTestUtils.a().g();     // Catch: Exception -> L293
        if (r178 == null) goto L294;
        com.bytedance.android.gamecp.common.setting.config.e r179 = r178.get(r177);     // Catch: Exception -> L293
        if (r179 == null) goto L294;
        r179.d(r177);     // Catch: Exception -> L293
    L295:
        if (r179 == null) goto L339;
        Integer r180 = AcpOptABTestUtils.a().f();
        if (r180 != null) goto L300;
    L302:
        boolean r181 = false;
    L303:
        if (r181 == false) goto L326;
        String r182 = r310.downloadUrl;
        if (r182 == null) goto L311;
        List r183 = StringsKt.split$default(r182, new String[]{"?"}, false, 0, 6, null);
        if (r183 == null) goto L311;
        String r184 = (String) CollectionsKt.getOrNull(r183, 0);
        if (r184 == null) goto L311;
        String r185 = r179.c();
        Intrinsics.checkNotNull(r185);
        String r213 = r179.a();
        Intrinsics.checkNotNull(r213);
        String r186 = StringsKt.replace$default(r184, r185, r213, false, 4, null);
    L312:
        r310.compressedDownloadUrl = r186;
        ArrayList r187 = new ArrayList();
        List<String> r188 = r310.backupUrls;
        if (r188 == null) goto L325;
        Iterator r189 = r188.iterator();
    L316:
        if (r189.hasNext() == false) goto L325;
        String r190 = r186;
        Iterator r317 = r189;
        String r191 = (String) CollectionsKt.getOrNull(StringsKt.split$default((String) r189.next(), new String[]{"?"}, false, 0, 6, null), 0);
        if (r191 == null) goto L320;
        String r214 = r179.c();
        Intrinsics.checkNotNull(r214);
        String r215 = r179.a();
        Intrinsics.checkNotNull(r215);
        String r192 = StringsKt.replace$default(r191, r214, r215, false, 4, null);
    L322:
        if (TextUtils.isEmpty(r192) == true) goto L324;
        Intrinsics.checkNotNull(r192);
        r187.add(r192);
    L324:
        r189 = r317;
        r186 = r190;
        goto L316
    L320:
        r192 = null;
    L325:
        r310.compressedBackupUrls = r187;
        String r193 = r186;
    L341:
        if (Intrinsics.areEqual(AcpOptABTestUtils.a().a(), Boolean.TRUE) == false) goto L346;
        String r194 = r113;
        boolean r195 = false;
        if (((Boolean) AcpOptABTestUtils.b(r193, r194, r114, r157, 0).getFirst()).booleanValue() == false) goto L347;
        AirCompressReport.j("ac_is_support_finish", r194, -1, "precise enter matched group v2", null, null, null, null, 0, null, 752);
        boolean r196 = true;
    L348:
        if (r196 == true) goto L363;
        if (r111 == true) goto L363;
        if (r311 == null) goto L472;
        String r197 = r310.downloadUrl;
        if (r197 != null) goto L355;
        r197 = r157;
    L355:
        Intrinsics.checkNotNullParameter(r197, r158);
        r311.f52840c0 = r197;
    L472:
        Result.Companion r198 = Result.Companion;     // Catch: Throwable -> L361
        Object r199 = r310.downloadUrl;     // Catch: Throwable -> L361
        if (r199 != null) goto L359;
        r199 = r157;
    L359:
        Result.m9449constructorimpl(r312.put("download_url", r199));     // Catch: Throwable -> L361
        return;
    L361:
        th = move-exception;
        Result.Companion r200 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L363:
        if (r311 == null) goto L365;
        String r201 = r311.f52855k;
    L367:
        if (v(r201) == false) goto L384;
        if (r311 == null) goto L468;
        String r202 = r310.downloadUrl;
        if (r202 != null) goto L372;
        r202 = r157;
    L372:
        Intrinsics.checkNotNullParameter(r202, r158);
        r311.f52840c0 = r202;
    L468:
        Result.Companion r203 = Result.Companion;     // Catch: Throwable -> L378
        Object r204 = r310.downloadUrl;     // Catch: Throwable -> L378
        if (r204 != null) goto L376;
        r204 = r157;
    L376:
        r312.put("download_url", r204);     // Catch: Throwable -> L378
        Result.m9449constructorimpl(r312.put("compressed_download_url", r157));     // Catch: Throwable -> L378
    L380:
        if (r311 == null) goto L382;
        String r205 = r311.f52855k;
    L383:
        B(r205);
    L424:
        if (r311 == null) goto L426;
        r112 = r311.f52855k;
    L426:
        z(r112);
        if (r311 == null) goto L432;
        String r206 = r310.compressedDownloadUrl;
        if (r206 != null) goto L431;
        r206 = r157;
    L431:
        Intrinsics.checkNotNullParameter(r206, r158);
        r311.f52846f0 = r206;
    L432:
        if (r311 == null) goto L476;
        String r207 = r310.downloadUrl;
        if (r207 != null) goto L436;
        r207 = r157;
    L436:
        Intrinsics.checkNotNullParameter(r207, r158);
        r311.f52842d0 = r207;
    L476:
        Object r208 = r310.downloadUrl;     // Catch: Throwable -> L451
        if (r208 != null) goto L440;
        r208 = r157;
    L440:
        r312.put("origin_download_url", r208);     // Catch: Throwable -> L451
        if (r311 == null) goto L446;
        String r209 = r310.taskGroup;     // Catch: Throwable -> L451
        if (r209 != null) goto L445;
        r209 = r157;
    L445:
        r311.f52866p0 = r209;     // Catch: Throwable -> L451
    L446:
        Object r216 = r310.taskGroup;     // Catch: Throwable -> L451
        if (r216 != null) goto L449;
        r216 = r157;
    L449:
        Result.m9449constructorimpl(r312.put(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP, r216));     // Catch: Throwable -> L451
        return;
    L451:
        th = move-exception;
        Result.Companion r217 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L382:
        r205 = null;
    L378:
        th = move-exception;
        Result.Companion r218 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L380
    L384:
        String r219 = r310.compressedDownloadUrl;
        if (r219 != null) goto L387;
    L394:
        r219 = r310.downloadUrl;
    L395:
        if (r219 != null) goto L397;
        r219 = r157;
    L397:
        if (r311 == null) goto L474;
        Intrinsics.checkNotNullParameter(r219, r158);
        r311.f52840c0 = r219;
    L474:
        Result.Companion r1100 = Result.Companion;     // Catch: Throwable -> L404
        r312.put("download_url", r219);     // Catch: Throwable -> L404
        Object r220 = r310.compressedDownloadUrl;     // Catch: Throwable -> L404
        if (r220 != null) goto L402;
        r220 = r157;
    L402:
        Result.m9449constructorimpl(r312.put("compressed_download_url", r220));     // Catch: Throwable -> L404
    L406:
        if (r110 == false) goto L424;
        List<String> r221 = r310.compressedBackupUrls;     // Catch: Throwable -> L422
        if (r221 != null) goto L410;
    L411:
        r195 = true;
    L412:
        if (r195 == true) goto L420;
        JSONArray r222 = new JSONArray();     // Catch: Throwable -> L422
        List<String> r223 = r310.compressedBackupUrls;     // Catch: Throwable -> L422
        if (r223 == null) goto L419;
        Iterator<T> r224 = r223.iterator();     // Catch: Throwable -> L422
    L417:
        if (r224.hasNext() == false) goto L419;
        r222.put((String) r224.next());     // Catch: Throwable -> L422
    L419:
        r312.put("compressed_backup_urls", r222);     // Catch: Throwable -> L422
    L420:
        yr.c.a("DownloadView", "extra:" + r312);     // Catch: Throwable -> L422
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L422
        goto L424
    L410:
        if (r221.isEmpty() == false) goto L412;
    L422:
        th = move-exception;
        Result.Companion r225 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L404:
        th = move-exception;
        Result.Companion r226 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L406
    L387:
        if (r219.length() <= 0) goto L389;
        boolean r1101 = true;
    L390:
        if (r1101 == true) goto L393;
        r219 = null;
    L393:
        if (r219 != null) goto L395;
    L389:
        r1101 = false;
        goto L390
    L365:
        r201 = null;
    L347:
        r196 = false;
        goto L348
    L346:
        r195 = false;
    L311:
        r186 = null;
        goto L312
    L326:
        String r227 = r310.downloadUrl;
        if (r227 == null) goto L329;
        String r228 = r179.c();
        Intrinsics.checkNotNull(r228);
        String r229 = r179.b();
        Intrinsics.checkNotNull(r229);
        String r230 = StringsKt.replace$default(r227, r228, r229, false, 4, null);
    L330:
        r310.downloadUrl = r230;
        ArrayList r231 = new ArrayList();
        List<String> r1102 = r310.backupUrls;
        if (r1102 == null) goto L338;
        Iterator<T> r1103 = r1102.iterator();
    L334:
        if (r1103.hasNext() == false) goto L338;
        String r232 = (String) r1103.next();
        String r233 = r179.c();
        Intrinsics.checkNotNull(r233);
        String r234 = r179.a();
        Intrinsics.checkNotNull(r234);
        String r1104 = StringsKt.replace$default(r232, r233, r234, false, 4, null);
        if (TextUtils.isEmpty(r1104) == true) goto L334;
        r231.add(r1104);
    L338:
        r310.backupUrls = r231;
        goto L339
    L329:
        r230 = null;
        goto L330
    L300:
        if (r180.intValue() != 1) goto L302;
        r181 = true;
        goto L303
    L283:
        r177 = null;
    L280:
        r176 = null;
    L294:
        r179 = null;
        goto L295
    L272:
        r174 = false;
        goto L273
    L269:
        r173 = 0;
    L339:
        r193 = r116;
        goto L341
    L75:
        com.bytedance.android.gamecp.business.patch.experiment.b.f56230a.getClass();
        if (h06.a.b().c(com.bytedance.android.gamecp.business.patch.experiment.b.class) != 1) goto L78;
        boolean r235 = true;
    L79:
        yr.c.a("PatchABTestUtils", "增量更新实验 是否实验组 = " + r235);
        StringBuilder r236 = new StringBuilder("增量更新实验对照组=");
        if (h06.a.b().c(com.bytedance.android.gamecp.business.patch.experiment.b.class) != 0) goto L82;
        boolean r237 = true;
    L83:
        r236.append(r237);
        r236.append(",实验组=");
        r236.append(r235);
        C(r236.toString());
        if (r235 == false) goto L97;
        Map<String, Double> r238 = AirCompressReport.f52263a;
        if (r410 == null) goto L88;
        String r239 = (String) r410.getFirst();
    L89:
        if (r410 == null) goto L91;
        Integer r1105 = (Integer) r410.getSecond();
    L93:
        if (r122 == null) goto L95;
        int r240 = r122.sdkVersion;
    L96:
        r123 = "patch_version";
        r211 = r235;
        Integer r241 = r1105;
        r116 = r116;
        r114 = r114;
        r113 = r113;
        AirCompressReport.i("ac_is_support_finish", r113, -1, "patch precise enter matched group v1", r239, r241, r115, r411, 2, MapsKt.mapOf(TuplesKt.to(r123, Integer.valueOf(r240))));
        goto L101
    L95:
        r240 = 0;
        goto L96
    L91:
        r1105 = null;
        goto L93
    L88:
        r239 = null;
        goto L89
    L97:
        r211 = r235;
        r116 = r116;
        r114 = r114;
        r113 = r113;
        r123 = "patch_version";
        goto L101
    L82:
        r237 = false;
        goto L83
    L78:
        r235 = false;
        goto L79
    L98:
        r210 = r7;
        r315 = r8;
        r123 = "patch_version";
        r316 = "AirCompressManager";
        goto L99
    L47:
        r107 = null;
    L44:
        r106 = 0;
        goto L45
    L33:
        r104 = null;
    L30:
        r103 = "";
        goto L31
    L19:
        r115 = null;
        goto L20
    L16:
        r114 = null;
        goto L17
    L13:
        r113 = null;
        goto L14
    L9:
        r111 = r314;
        goto L10
    L5:
        r110 = r313;
        goto L7
    }

    public static void o(com.bytedance.android.gamecp.business.download.b r210, String r211, int r212, String r213, long r310, cw.c r311, int r312, String r313, String r314, Boolean r315, int r316) {
        AirCompressManager r110 = f52242r;
        if ((r316 & 128) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r316 & 256) == 0) goto L9;
        String r111 = "";
    L11:
        if ((r316 & 512) == 0) goto L13;
        Boolean r112 = Boolean.FALSE;
    L14:
        Intrinsics.checkNotNullParameter(r211, "targetApk");
        AppLifecycleObserver r101 = k1.f52798a;
        String r113 = null;
        if (r210 == null) goto L17;
        JSONObject r102 = r210.f52537f;
    L18:
        String r114 = k1.e(r102);
        f52226b = null;
        StringBuilder r103 = new StringBuilder("handleRestoreFailed gameId = ");
        r103.append(r114);
        r103.append(", 失败次数 = ");
        Map<String, Integer> r104 = f52229e;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        r103.append((Integer) r105.get(r114));
        yr.c.e("AirCompressManager", r103.toString());
        Map<String, Double> r106 = AirCompressReport.f52263a;
        boolean r107 = ((Boolean) f52234j.getValue()).booleanValue();
        long r115 = SystemClock.elapsedRealtime() - r310;
        Boolean r116 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(r211, "targetApk");
        ((ExecutorService) AirCompressReport.f52265c.getValue()).submit(new f(r107, r213, r212, r115, r312, r210, r211, r100, r111, r116, r112));
        int r108 = 0;
        if (r105.get(r114) != null) goto L21;
        Map<String, Integer> r109 = r104;
        r109.put(r114, 0);
    L22:
        Object r117 = r105.get(r114);
        Intrinsics.checkNotNull(r117);
        int r118 = ((Number) r117).intValue();
        Integer r119 = wu.b.f561281a.getValue().u();
        if (r119 == null) goto L26;
        r108 = r119.intValue();
    L26:
        if (r118 >= r108) goto L30;
        Object r120 = r105.get(r114);
        Intrinsics.checkNotNull(r120);
        r109.put(r114, Integer.valueOf(((Number) r120).intValue() + 1));
        com.bytedance.android.gamecp.business.download.b r121 = r210;
        if (r121 == null) goto L31;
        r110.c(new g(r121, r311, 2));
        return;
    L31:
        h().storeBoolean("key_air_compress_failed" + r114, true);
        yr.c.e("AirCompressManager", "handleRestoreFailed gameId = " + r114 + ", 还原失败, 开始清除下载任务");
        if (r121 == null) goto L36;
        JSONObject r122 = r121.f52537f;
        if (r122 == null) goto L36;
        r113 = r122.optString("gamecp_task_group");
    L36:
        String r123 = r113;
        y0 r124 = y0.f52963a;
        int r125 = com.bytedance.android.gamecp.business.f.f53161a;
        GamePromoteDownloaderOld r126 = GamePromoteDownloaderOld.f52422f;
        p r127 = r126.c(r123);
        if (r127 != null) goto L39;
        r127 = r126.c(r123);
    L39:
        if (r127 != null) goto L41;
        y0.d(GlobalInfo.getContext(), "", new com.bytedance.android.gamecp.business.compress.b(r114, r121));
        return;
    L41:
        a(r121, r127);
        return;
    L30:
        r121 = r210;
        goto L31
    L21:
        r109 = r104;
        goto L22
    L17:
        r102 = null;
        goto L18
    L13:
        r112 = r315;
        goto L14
    L9:
        r111 = r314;
        goto L11
    L5:
        r100 = r313;
        goto L7
    }
}
