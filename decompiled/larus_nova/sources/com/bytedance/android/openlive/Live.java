package com.bytedance.android.openlive;

import android.content.Context;
import com.bytedance.android.dy.saas.utuid.e;
import com.bytedance.android.live.saas.middleware.BDLiveSdkConfig;
import com.bytedance.android.live.saas.middleware.alog.ALogConfig;
import com.bytedance.android.live.saas.middleware.applog.AppLogConfig;
import com.bytedance.android.live.saas.middleware.fresco.FrescoConfig;
import com.bytedance.android.live.saas.middleware.login.LoginConfig;
import com.bytedance.android.live.saas.middleware.monitor.MonitorConfig;
import com.bytedance.android.live.saas.middleware.network.NetworkConfig;
import com.bytedance.android.live.saas.middleware.npth.NpthConfig;
import com.bytedance.android.live.saas.middleware.sec.SecConfig;
import com.bytedance.android.live.saas.middleware.utils.PluginInfoUtils;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.openlive.wrapper.LiveHostParamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import java.io.File;
import java.util.HashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ry.h;
import ry.j;
import ry.o;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J2\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012J$\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/openlive/Live;", "", "Ljava/io/File;", "rootFile", "", "checkMetaSecLicenseFile", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "getMaterialDownloadPath", "", "initSuperThreadPool", "Lcom/bytedance/android/openlive/LiveContext;", "liveContext", "Lry/j;", "initCallback", "Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig$Builder;", "sdkConfigBuilder", "Lcom/bytedance/android/openlive/IHostServiceTransformer;", "hostServiceTransformer", "init", "Lry/h;", "param", "initLivePlugin", "Lcom/bytedance/android/openlive/InternalLive;", "internalLive", "Lcom/bytedance/android/openlive/InternalLive;", "<init>", "()V", "live-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class Live {
    public static final Live INSTANCE = null;
    private static final InternalLive internalLive = null;

    private Live() {
    }

    static {
        INSTANCE = new Live();
        internalLive = new InternalLive();
    }

    private final void initSuperThreadPool() {
        SuperThreadPool r100 = SuperThreadPool.INSTANCE;
        r100.setEnablePriority(true);
        r100.setEnableBlockFetchTask(false);
        r100.setEnableType(10);
    }

    private final boolean checkMetaSecLicenseFile(File r110) {
        if (r110.exists() == true) goto L5;
        return false;
    L5:
        File[] r111 = r110.listFiles();
        if (r111 != null) goto L8;
        return false;
    L8:
        if (r111.length != 0) goto L10;
        boolean r100 = true;
    L11:
        if (r100 == true) goto L37;
        int r101 = r111.length;
        int r102 = 0;
    L14:
        File r103 = null;
        if (r102 >= r101) goto L22;
        File r104 = r111[r102];
        if (r104.isFile() == false) goto L21;
        if (StringsKt.endsWith$default(r104.getAbsolutePath(), ".msext", false, 2, null) == false) goto L21;
        r103 = r104;
    L21:
        r102 = r102 + 1;
    L22:
        if (r103 != null) goto L24;
        return false;
    L24:
        if (r103.exists() == true) goto L26;
        return false;
    L26:
        if (r103.length() <= 0) goto L36;
        return true;
    L36:
        return false;
    L37:
        return false;
    L10:
        r100 = false;
        goto L11
    }

    private final String getMaterialDownloadPath(Context r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getFilesDir().toString());
        String r102 = File.separator;
        r101.append(r102);
        r101.append(".msdata_lc");
        r101.append(r102);
        return r101.toString();
    }

    public final void initLivePlugin(h r110, j r111, IHostServiceTransformer r112) {
        Intrinsics.checkNotNullParameter(r110, "param");
        initSuperThreadPool();
        LiveHostParamWrapper r100 = new LiveHostParamWrapper(r110);
        String r101 = String.valueOf(r100.getAid());
        String r102 = r100.getGeneralAppId();
        String r103 = r100.getPartner();
        String r104 = r100.getPartnerSecret();
        r100.getPartnerExtra();
        r100.getPartnerExtra();
        BDLiveSdkConfig.Builder r105 = new BDLiveSdkConfig.Builder().utUidConfig(new e(true, r101, r102, r103, r104, "", "")).npthConfig(new NpthConfig(true, true, r100.getGeneralAppId(), null, 8, null)).accountConfig(new LoginConfig(r100.getUserId()));
        ALogConfig r106 = r110.getALogConfig();
        if (r106 != null) goto L5;
        r106 = new ALogConfig(null, true, r100.getDebug());
    L5:
        BDLiveSdkConfig.Builder r107 = r105.aLogConfig(r106);
        AppLogConfig r113 = r110.getAppLogConfig();
        if (r113 != null) goto L8;
        r113 = new AppLogConfig(null, true, true, r100.getGeneralAppId(), r100.getHostPermission());
    L8:
        init(r100, r111, r107.appLogConfig(r113).networkConfig(new NetworkConfig(null, r100.getNeedInitNetwork(), r100.getNeedInitNetwork(), true, null, 16, null)).frescoConfig(new FrescoConfig(true, true, r100.getNativeLibraryDir())).secConfig(new SecConfig(null, true, true, r100.getMsSDKAppId(), r100.getHostPermission())).monitorConfig(new MonitorConfig(null, true, true, r100.getGeneralAppId(), false, 16, null)).setHostPermission(r100.getHostPermission()), r112);
        o r114 = r100.provideMethodChannel();
        if (r114 == null) goto L11;
        k.l(o.class, r114);
    L11:
        HashMap r115 = new HashMap();
        PluginInfoUtils r116 = PluginInfoUtils.INSTANCE;
        r115.put("plugin_version_code", Long.valueOf(r116.getPluginVersionCode()));
        r115.put("plugin_version_name", r116.getPluginVersionName());
        u.l().d("livesdk_sdk_initialized", new Object[]{r115});
    }

    public final void init(LiveContext r100, j r101, BDLiveSdkConfig.Builder r102, IHostServiceTransformer r103) {
        Intrinsics.checkNotNullParameter(r100, "liveContext");
        if (checkMetaSecLicenseFile(new PolarisFileWrapper(getMaterialDownloadPath(r100.getContext()))) == false) goto L6;
        internalLive.init(r100, r101, r102, r103);
        return;
    }

    public static /* synthetic */ void initLivePlugin$default(Live r100, h r101, j r102, IHostServiceTransformer r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.initLivePlugin(r101, r102, r103);
    }

    public static /* synthetic */ void init$default(Live r100, LiveContext r101, j r102, BDLiveSdkConfig.Builder r103, IHostServiceTransformer r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = null;
    L11:
        r100.init(r101, r102, r103, r104);
    }
}
