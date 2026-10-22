package b96;

import android.text.TextUtils;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.geckox.pcdn.GeckoXOdlDownloader;
import com.bytedance.geckox.utils.BsPatch;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaPackage;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import com.bytedance.iesgurd.settings.SettingsExtra;
import com.bytedance.iesgurd.update.ErrorCode;
import com.bytedance.iesgurd.update.UpdateException;
import com.bytedance.iesgurd.utils.GeckoExecutors;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.iesgurd.meta.c f18303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f18304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GeckoUpdateListener f18306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PrepareMeta f18307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.iesgurd.j f18308g;

    public final void b() {
        String r100 = "";
        long r101 = System.currentTimeMillis();
        List<String> r102 = this.f18307f.getPackage().getUrlList();
        String r103 = (String) ListProtector.get(r102, this.f18305d);
        com.bytedance.iesgurd.meta.c r104 = this.f18303b;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L5:
        com.bytedance.iesgurd.meta.c.a r105 = r104.a(this.f18307f.getUpdateWithPatch());
        r105.f250784d = r103;
        boolean r106 = true;
        boolean r107 = false;
        c(r103);     // Catch: Throwable -> L100
        com.bytedance.iesgurd.meta.c r108 = this.f18303b;
        if (r108 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L10:
        r108.f250774e = System.currentTimeMillis() - r101;
        com.bytedance.iesgurd.meta.c r109 = this.f18303b;
        if (r109 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L13:
        r109.f250773d = System.currentTimeMillis() - this.f18304c;
        GeckoExecutors.a().execute(new d(this));
        PrepareMeta r110 = this.f18307f;
        a r111 = new a(r110);
        long r112 = System.currentTimeMillis();
        GeckoLogger.d("[" + r110 + "]start active");
        boolean r113 = r110.getUpdateWithPatch();
        if (r110.getUseZstd() == false) goto L49;
        GeckoLogger.d("[" + r110 + "]start decompress zstd");
        long r114 = System.currentTimeMillis();
        r111.f18285a.position(0);
        PolarisFileWrapper r115 = new PolarisFileWrapper(r110.getUpdatingDir(), "res.zst.tmp");
        ez5.c.delete(r115);
        int r116 = oy5.a.f527127a;
        ny5.a r117 = oy5.a.a(r115, r115.length());
        int r118 = ez5.j.f474889a;     // Catch: Throwable -> L41 Exception -> L43
        ez5.j.b(r111.f18285a, r117);     // Catch: Throwable -> L41 Exception -> L43
        r111.f18285a.b();
        r117.position(0);
        MD5Utils.INSTANCE.check$geckox_noasanRelease(new py5.a(r117), r110.getPackage().getDecompressMd5());     // Catch: Throwable -> L38
        r111.f18285a = r117;
        r110.setUpdateBuffer(r117);
        r111.f18286b.f250777h = System.currentTimeMillis() - r114;
        if (r113 == false) goto L37;
        GeckoLogger.d("[" + r110 + "]start merge dir");
        long r119 = System.currentTimeMillis();
        File r120 = r111.f18285a.a();
        r111.f18285a.c();
        r111.f18285a.release();
        Map<String, vy5.a> r121 = vy5.b.f557621a;
        if (vy5.b.b(r111.f18287c.getAbsolutePath()) == false) goto L36;
        new b().g(r111.f18289e, r111.f18288d, r120);     // Catch: Throwable -> L25 BytePatchException -> L27
        vy5.b.d(r111.f18287c.getAbsolutePath());
        r120.delete();
        r111.f18286b.f250778i = System.currentTimeMillis() - r119;
    L120:
        new g(r110).b();     // Catch: Throwable -> L97
        r111.f18286b.f250775f = System.currentTimeMillis() - r112;
        return;
    L97:
        th = move-exception;
        throw new UpdateException(ErrorCode.RENAME, th.getMessage());
    L27:
        e = move-exception;
        GeckoLogger.w("[" + r111.f18290f + "]merge dir failed: " + e.getMessage());     // Catch: Throwable -> L25
        int r122 = e.getCode();     // Catch: Throwable -> L25
        String r123 = e.getMessage();     // Catch: Throwable -> L25
        if (r123 == null) goto L32;
        r100 = r123;
    L32:
        throw new UpdateException(r122, r100);     // Catch: Throwable -> L25
    L36:
        throw new UpdateException(ErrorCode.BYTE_PATCH_LOCK, "read lock failed");
    L25:
        th = move-exception;
        Map<String, vy5.a> r124 = vy5.b.f557621a;
        vy5.b.d(r111.f18287c.getAbsolutePath());
        r120.delete();
        throw th;
    L37:
        r111.b();
    L38:
        th = move-exception;
        r117.b();
        throw new UpdateException(ErrorCode.DECOMPRESS_ZSTD_CHECK, th.getMessage());
    L43:
        e = move-exception;
        r117.b();     // Catch: Throwable -> L41
        throw new UpdateException(ErrorCode.DECOMPRESS_ZSTD, e.getMessage());     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        r111.f18285a.b();
        throw th;
    L49:
        if (r110.isSingleFile() == false) goto L93;
        if (r113 == false) goto L85;
        GeckoLogger.d("[" + r110 + "]start merge patch");
        long r125 = System.currentTimeMillis();
        File r126 = r111.f18285a.a();
        r111.f18285a.c();
        r111.f18285a.release();
        File[] r127 = r111.f18289e.listFiles();
        if (r127 != null) goto L54;
    L60:
        if (r106 == true) goto L83;
        File r128 = r127[0];
        PolarisFileWrapper r129 = r111.a();
        String r130 = r111.f18287c.getAbsolutePath();
        if (vy5.b.b(r130) == false) goto L81;
        BsPatch.f245100a.a(r128, r126, r129.getParentFile(), r129.getName());     // Catch: Throwable -> L73 Exception -> L75
        vy5.b.d(r130);
        ez5.c.delete(r126);
        int r131 = oy5.a.f527127a;
        ny5.a r132 = oy5.a.a(r129, r129.length());
        r132.position(0);
        MD5Utils r133 = MD5Utils.INSTANCE;     // Catch: Throwable -> L70
        py5.a r134 = new py5.a(r132);     // Catch: Throwable -> L70
        PrepareMetaPackage r135 = r110.getFullPackage();     // Catch: Throwable -> L70
        if (r135 != null) goto L68;
        Intrinsics.throwNpe();     // Catch: Throwable -> L70
    L68:
        r133.check$geckox_noasanRelease(r134, r135.getMd5());     // Catch: Throwable -> L70
        r111.f18285a = r132;
        r110.setUpdateBuffer(r132);
        r111.f18286b.f250779j = System.currentTimeMillis() - r125;
    L70:
        th = move-exception;
        throw new UpdateException(ErrorCode.MERGE_PATCH_CHECK, th.getMessage());
    L75:
        e = move-exception;
        throw new UpdateException(ErrorCode.MERGE_PATCH, e.getMessage());     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        vy5.b.d(r130);
        ez5.c.delete(r126);
        throw th;
    L81:
        throw new UpdateException(ErrorCode.MERGE_PATCH_LOCK, "read lock failed");
    L83:
        throw new UpdateException(ErrorCode.MERGE_PATCH_NO_LOCAL, "get old file is null");
    L54:
        if (r127.length != 0) goto L56;
        boolean r136 = true;
    L57:
        if (r136 == true) goto L60;
        r106 = false;
        goto L60
    L56:
        r136 = false;
        goto L57
    L85:
        if (r111.f18288d.mkdirs() == false) goto L92;
        if (r110.getDownloadFile().renameTo(r111.a()) == true) goto L120;
        throw new UpdateException(ErrorCode.RENAME_SINGLE, "single file channel rename failed");
    L92:
        throw new UpdateException(ErrorCode.RENAME_SINGLE, "single file channel make dir failed");
    L93:
        r111.b();
    L100:
        th = move-exception;
        if (this.f18308g.f250721n == false) goto L104;
    L105:
        r107 = true;
    L106:
        if (r107 == false) goto L112;
        if (this.f18305d >= (r102.size() - 1)) goto L112;
        this.f18305d++;
        r105.f250785e++;
        b();
        return;
    L112:
        if ((th instanceof UpdateException) == false) goto L114;
        int r137 = th.getCode();
    L115:
        String r138 = th.getMessage();
        if (r138 == null) goto L118;
        r100 = r138;
    L118:
        UpdateException r139 = new UpdateException(r137, r100);
        GeckoExecutors.a().execute(new c(this, r139));
        throw r139;
    L114:
        r137 = ErrorCode.DOWNLOAD_OTHER.getCode();
        goto L115
    L104:
        if (this.f18307f.getUsePcdn() == false) goto L106;
        goto L105
    }

    public final void d() {
        GeckoLogger.d("[" + this.f18307f + "]start download");
        this.f18304c = System.currentTimeMillis();
        com.bytedance.iesgurd.meta.c r100 = this.f18307f.getStatisticModel();
        if (r100 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        this.f18303b = r100;
        this.f18306e = this.f18308g.f250710c;
        this.f18307f.setDownloadFile(new PolarisFileWrapper(this.f18307f.getUpdatingDir(), this.f18302a));
        b();
    }

    public final void c(String r110) {
        GeckoLogger.d("[" + this.f18307f + "]download url: " + r110);
        PrepareMetaPackage r100 = this.f18307f.getPackage();
        long r101 = r100.getLength();
        if (this.f18307f.getUsePcdn() == true) goto L5;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L83;
        GeckoXOdlDownloader.a r103 = GeckoXOdlDownloader.f245095i;
        monitor-enter(r103);
        com.bytedance.geckox.b r104 = com.bytedance.geckox.b.a.f245076a;     // Catch: Throwable -> L80
        GeckoGlobalConfig r105 = com.bytedance.geckox.b.a();     // Catch: Throwable -> L80
        if (r105 != null) goto L17;
        String r106 = "config not exist";
    L70:
        monitor-exit(r103);
        String r107 = r106;
    L72:
        if (r107 != null) goto L74;
    L77:
        boolean r111 = true;
    L78:
        if (r111 == true) goto L84;
        this.f18307f.odlFallbackReason = r107;
        r102 = false;
    L84:
        if (r102 == false) goto L139;
        int r108 = oy5.a.f527127a;     // Catch: Throwable -> L120
        ny5.a r109 = oy5.a.a(this.f18307f.getDownloadFile(), r101);     // Catch: Throwable -> L120
        py5.b r112 = new py5.b(r109, this.f18308g, this.f18307f, r101);     // Catch: Throwable -> L117
        PrepareMeta r113 = this.f18307f;     // Catch: Throwable -> L115
        r113.odlUseUrl = r110;     // Catch: Throwable -> L115
        new GeckoXOdlDownloader(r110, this.f18302a, r113, r112).a();     // Catch: Throwable -> L112
        throw null;     // Catch: Throwable -> L112
    L112:
        th = move-exception;
        r113.odlFallbackReason = th.toString();     // Catch: Throwable -> L115
        throw th;     // Catch: Throwable -> L115
    L115:
        th = th;
    L119:
        py5.b r114 = r112;
        ny5.a r115 = r109;
    L122:
        if (r115 == null) goto L125;
        r115.b();     // Catch: Throwable -> L126
    L126:
        th = move-exception;
        if (r114 == null) goto L131;
        wy5.c r116 = r114.f531036b;
        if (r116 == null) goto L131;
        r116.a();
    L131:
        throw th;
    L125:
        throw new UpdateException(ErrorCode.DOWNLOAD, th.getMessage());     // Catch: Throwable -> L126
    L117:
        th = th;
        r112 = null;
    L120:
        th = th;
        r114 = null;
        r115 = null;
        goto L122
    L139:
        int r117 = oy5.a.f527127a;     // Catch: Throwable -> L105
        ny5.a r118 = oy5.a.a(this.f18307f.getDownloadFile(), r101);     // Catch: Throwable -> L105
        py5.b r119 = new py5.b(r118, this.f18308g, this.f18307f, r101);     // Catch: Throwable -> L103
        a(r110, this.f18307f, r119);     // Catch: Throwable -> L101
        wy5.c r120 = r119.f531036b;
        if (r120 == null) goto L91;
        r120.a();
    L91:
        r118.finish();
        r118.position(0);     // Catch: Throwable -> L95
        MD5Utils.INSTANCE.check$geckox_noasanRelease(new py5.a(r118), r100.getMd5());     // Catch: Throwable -> L95
        this.f18307f.setUpdateBuffer(r118);
        return;
    L95:
        th = move-exception;
        r118.b();
        if (r102 == false) goto L100;
        this.f18307f.odlFallbackReason = th.getMessage();
    L100:
        throw new UpdateException(ErrorCode.DOWNLOAD_CHECK, th.getMessage());
    L101:
        th = th;
        r115 = r118;
        r114 = r119;
    L103:
        th = th;
        r115 = r118;
        r114 = null;
    L105:
        th = th;
        r114 = null;
        r115 = null;
        goto L122
    L74:
        if (r107.length() == 0) goto L77;
        r111 = false;
        goto L78
    L17:
        if (GeckoXOdlDownloader.f245092f == null) goto L21;
        GeckoLogger.d("[pcdn]Odl already initialized");     // Catch: Throwable -> L80
        monitor-exit(r103);
        r102 = r102;
        r107 = null;
        goto L72
    L21:
        SettingsExtra r121 = GlobalSettingsManager.f250843k;     // Catch: Throwable -> L80
        if (r121 == null) goto L24;
        SettingsExtra.a r122 = r121.getPcdnInfo();     // Catch: Throwable -> L80
    L25:
        if (r122 != null) goto L28;
        r106 = "p2p struct not exists";
        goto L70
    L28:
        if (r122.a() != null) goto L145;
        r106 = "sid not exists";
        goto L70
    L145:
        Class r123 = GeckoXOdlDownloader.a.a();     // Catch: Throwable -> L66
    L147:
    L60:
        th = th;
        r102 = r102;
    L63:
        th.printStackTrace();     // Catch: Throwable -> L80
        GeckoXOdlDownloader.f245092f = null;     // Catch: Throwable -> L80
        GeckoLogger.d("[pcdn]Odl initialize failed, cause=" + th);     // Catch: Throwable -> L80
        r107 = th.getMessage();     // Catch: Throwable -> L80
        monitor-exit(r103);
        goto L72
    L33:
        if (TextUtils.isEmpty(r105.getDeviceId()) == false) goto L36;
        r106 = "device_id is empty";
        goto L70
    L36:
        GeckoLogger.d("[pcdn]Starting to build odl config...");     // Catch: Throwable -> L60
        JSONObject r124 = new JSONObject();     // Catch: Throwable -> L60
        GeckoXOdlDownloader.f245093g = new PolarisFileWrapper(r105.getContext().getFilesDir(), "geckox_odl_root");     // Catch: Throwable -> L60
        File r125 = GeckoXOdlDownloader.f245093g;     // Catch: Throwable -> L60
        if (r125 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("odlBaseAbsPath");     // Catch: Throwable -> L60
    L39:
        r124.put("pcdn_basepath", new PolarisFileWrapper(r125, "base").getAbsolutePath());     // Catch: Throwable -> L60
        File r126 = GeckoXOdlDownloader.f245093g;     // Catch: Throwable -> L60
        if (r126 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("odlBaseAbsPath");     // Catch: Throwable -> L60
    L42:
        r124.put("pcdn_cachepath", new PolarisFileWrapper(r126, "meta_cache").getAbsolutePath());     // Catch: Throwable -> L60
        File r127 = GeckoXOdlDownloader.f245093g;     // Catch: Throwable -> L60
        if (r127 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("odlBaseAbsPath");     // Catch: Throwable -> L60
    L45:
        r124.put("odl_cachepath", new PolarisFileWrapper(r127, "odl_cache").getAbsolutePath());     // Catch: Throwable -> L60
        r124.put("pcdn_cachesize", 20);     // Catch: Throwable -> L60
        r124.put("pcdn_memorysize", 1);     // Catch: Throwable -> L60
        r124.put("pcdn_businessid", r122.a());     // Catch: Throwable -> L60
        r124.put("pcdn_groupid", r122.b());     // Catch: Throwable -> L60
        r124.put("pcdn_testid", r122.c());     // Catch: Throwable -> L60
        r124.put("deviceid", r105.getDeviceId());     // Catch: Throwable -> L60
        r102 = r102;
        r124.put("appid", r105.getAppId());     // Catch: Throwable -> L58
        GeckoLogger.d("[pcdn]Starting to init odl downloader...");     // Catch: Throwable -> L58
        if (r123 != null) goto L141;
        Intrinsics.throwNpe();     // Catch: Throwable -> L58
    L141:
        GeckoXOdlDownloader.f245092f = (rr0.b) r123.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L56
        rr0.b r128 = GeckoXOdlDownloader.f245092f;     // Catch: Throwable -> L56
        if (r128 != null) goto L54;
        Intrinsics.throwNpe();     // Catch: Throwable -> L56
    L54:
        r124.toString();     // Catch: Throwable -> L56
        rr0.c r129 = (rr0.c) GeckoXOdlDownloader.f245094h.getValue();     // Catch: Throwable -> L56
        r128.init();     // Catch: Throwable -> L56
        throw new IllegalStateException("initDownloader failed, ret=-1");     // Catch: Throwable -> L56
    L56:
        th = th;
    L58:
        th = th;
    L66:
        th = move-exception;
        GeckoLogger.d("[pcdn]Odl plugin not installed yet..., cause by " + th);     // Catch: Throwable -> L80
        r106 = th.toString();     // Catch: Throwable -> L80
        goto L70
    L24:
        r122 = null;
    L80:
        th = move-exception;
        throw th;
    L83:
        r102 = r102;
        goto L84
    L5:
        if (this.f18307f.odlUseUrl.length() != 0) goto L7;
        boolean r130 = true;
    L8:
        if (r130 == false) goto L10;
        r102 = true;
        goto L11
    L7:
        r130 = false;
        goto L8
    }

    public e(PrepareMeta r100, com.bytedance.iesgurd.j r101) {
        this.f18307f = r100;
        this.f18308g = r101;
        if (r100.getUpdateWithPatch() == false) goto L5;
        String r102 = "DOWNLOAD_PATCH";
    L6:
        this.f18302a = r102;
        return;
    L5:
        r102 = "DOWNLOAD_FULL";
        goto L6
    }

    public static void a(String r100, PrepareMeta r101, py5.b r102) {
        com.bytedance.geckox.b r103 = com.bytedance.geckox.b.a.f245076a;     // Catch: Throwable -> L12
        GeckoGlobalConfig r104 = com.bytedance.geckox.b.a();     // Catch: Throwable -> L12
        int r105 = wy5.b.f561875a;     // Catch: Throwable -> L12
        INetWork r106 = r104.getNetWork();     // Catch: Throwable -> L12
        Map r107 = MapsKt.emptyMap();     // Catch: Throwable -> L12
        if ((r106 instanceof wy5.d) == false) goto L7;
        if (r107 == null) goto L7;
        r101.getPackage().getLength();     // Catch: Throwable -> L12
        ((wy5.d) r106).downloadFile();     // Catch: Throwable -> L12
    L9:
        if (r102.f531036b == null) goto L18;
        r101.originCDNDuration = 0;
        r101.originCDNReceivedBytes = 0;
        return;
    L18:
        return;
    L7:
        r106.downloadFile(r100, r101.getPackage().getLength(), r102);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (r102.f531036b == null) goto L16;
        r101.originCDNDuration = 0;
        r101.originCDNReceivedBytes = 0;
    L16:
        throw th;
    }
}
