package com.bytedance.android.live.livepullstream.service;

import android.content.Context;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livesdk.config.p30;
import com.bytedance.android.livesdk.config.rj;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.service.ILiveCellularService;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.network.LSNetworkManager;
import com.ss.videoarch.strategy.network.LSSDKConfig;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements gl0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f82520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JSONObject f82521b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f82522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f82523d = null;

    public h() {
    }

    static {
        f82523d = new h();
        f82521b = new JSONObject();
    }

    public static void b() {
        if (f82520a == true) goto L27;
        LiveInitAssistant.INSTANCE.markTimeStart("stream_strategy_init_duration");
        Context r100 = ((IHostContext) k.n(IHostContext.class)).context().getApplicationContext();
        if (r100 == null) goto L26;
        LSNetworkManager.inst().init(new LSSDKConfig.Builder().setApiHost(Constants.PATHS.HOST_PSEUDO_CODE).setHttpExecutor(new b()).build());
        LiveStrategyManager r101 = LiveStrategyManager.inst();
        JSONObject r102 = new JSONObject();
        r102.put("device_id", ((IHostContext) k.n(IHostContext.class)).getServerDeviceId().toString());     // Catch: Exception -> L23
        if (tb1.c.f545229a == false) goto L18;
        IHostService r103 = TTLiveSDK.hostService();     // Catch: Exception -> L23
        if (r103 == null) goto L18;
        IHostUser r104 = r103.user();     // Catch: Exception -> L23
        if (r104 == null) goto L18;
        String r105 = r104.getCurUserId();     // Catch: Exception -> L23
        if (r105 == null) goto L18;
        if (r102.put("user_id", r105) != null) goto L18;
        r102.put("user_id", String.valueOf(0));     // Catch: Exception -> L23
    L18:
        r102.put("channel", ((IHostContext) k.n(IHostContext.class)).getChannel());     // Catch: Exception -> L23
        r102.put("host_aid", ((IHostContext) k.n(IHostContext.class)).appId());     // Catch: Exception -> L23
        String r106 = ((IHostApp) k.n(IHostApp.class)).getSessionId();     // Catch: Exception -> L23
        if (r106 != null) goto L21;
        r106 = "";
    L21:
        r102.put("app_session_id", r106);     // Catch: Exception -> L23
        r102.put("app_version", ((IHostContext) k.n(IHostContext.class)).getVersionName());     // Catch: Exception -> L23
        r102.put("update_version_code", String.valueOf(((IHostContext) k.n(IHostContext.class)).getUpdateVersionCode()));     // Catch: Exception -> L23
    L25:
        r101.init(r100, r102);
        LiveStrategyManager.inst().setAppInfoBundle(new a());
        f82520a = true;
    L23:
        e = move-exception;
        ALogger.e("StreamStrategyOptimizer", "build stream strategy info failed", e);
    L26:
        LiveInitAssistant.INSTANCE.markTimeEnd("stream_strategy_init_duration");
    L27:
        LiveStrategyManager.inst().start();
        com.ss.videoarch.live.b.f.f458578a.getClass();
        LiveStrategyManager.inst().setIFunctionCalledByStrategyEngine(new com.ss.videoarch.live.b.g());
        rj r107 = rj.f121136a;
        boolean r108 = r107.getValue().c();
        boolean r109 = r107.getValue().e();
        boolean r110 = r107.getValue().d();
        ILiveCellularService r111 = (ILiveCellularService) k.f(ILiveCellularService.class);
        if (r111 == null) goto L30;
        boolean r112 = r111.hasCellularPermission();
    L31:
        ILiveCellularService r113 = (ILiveCellularService) k.f(ILiveCellularService.class);
        if (r113 == null) goto L34;
        boolean r114 = r113.isPermissionLimite();
    L36:
        if (r112 == false) goto L39;
        if (r110 == false) goto L42;
        int r115 = 2;
    L44:
        f82522c = r108;
        if (r108 == false) goto L54;
        JSONObject r116 = f82521b;
        r116.put("multipath_network_status", 0);
        if (f82522c == true) goto L49;
        r116.put("multipath_user_access_status", 3);
    L50:
        r116.put("multipath_user_toast", 1);
        TTExecutors.getNormalExecutor().submit(d.f82516a);
        ALogger.e("LiveCellularService", "init, mJson:" + r116.toString());
        return;
    L49:
        r116.put("multipath_user_access_status", r115);
        goto L50
    L54:
        return;
    L42:
        r115 = 1;
        goto L44
    L39:
        if (r114 == true) goto L43;
        if (r109 == true) goto L42;
    L43:
        r115 = 3;
        goto L44
    L34:
        r114 = false;
        goto L36
    L30:
        r112 = false;
        goto L31
    }

    public final void a() {
        if (p30.f120953a.getValue().booleanValue() == false) goto L10;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L7;
        b();
        return;
    L7:
        TTExecutors.getNormalExecutor().submit(g.f82519a);
        return;
    L10:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L12;
        b();
        return;
    L12:
        UtilityKotlinExtentionsKt.s(0, false, false, StreamStrategyOptimizer$startOnUiThread$1.INSTANCE, 7);
    }
}
