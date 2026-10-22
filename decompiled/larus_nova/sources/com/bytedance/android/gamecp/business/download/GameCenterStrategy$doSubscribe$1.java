package com.bytedance.android.gamecp.business.download;

import android.content.Context;
import com.bytedance.android.gamecp.business.compress.AirCompressManager;
import com.bytedance.android.gamecp.business.compress.AirCompressOpt;
import com.bytedance.android.gamecp.business.compress.AirCompressReport;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class GameCenterStrategy$doSubscribe$1 implements dw.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameCenterStrategy f52408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f52409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.m f52410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f52411d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameCenterStrategy$doSubscribe$1 f52412a;

        public a(GameCenterStrategy$doSubscribe$1 r100) {
            this.f52412a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lazy r100 = AirCompressOpt.f52246a;     // Catch: Throwable -> L4
            AirCompressOpt.d(this.f52412a.f52409b.G0.f52917a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameCenterStrategy$doSubscribe$1 f52413a;

        public b(GameCenterStrategy$doSubscribe$1 r100) {
            this.f52413a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lazy r100 = AirCompressOpt.f52246a;     // Catch: Throwable -> L4
            AirCompressOpt.a(this.f52413a.f52409b.G0.f52917a, 5);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // dw.c
    public final void a(final dw.a r210) {
        yr.c.e("GameCenterStrategy", "status:" + r210.f470285a + ", totalBytes:" + r210.f470286b + ", currentBytes:" + r210.f470287c + ", realCurrentBytes:" + r210.f470288d + ", downloadTime:" + r210.f470289e + ", fileName:" + r210.f470290f + ", failStatus:" + r210.f470291g + ", onlyWifi:" + r210.f470292h + ", token:" + this.f52409b.f52873t + ", page:" + this.f52409b.f52845f);
        int r100 = s.f52916o;
        p r101 = this.f52409b;
        Intrinsics.checkNotNullParameter(r101, "downloadInfo");
        s r102 = r101.G0;
        long r103 = r210.f470295k;
        int r110 = r210.f470285a;
        long r111 = r210.f470286b;
        String r112 = r210.f470290f;
        long r104 = r210.f470289e;
        r102.f52917a = new com.bytedance.android.gamecp.business.download.b(r103, r111, r112, r210.f470288d, r210.f470297m, r210.f470299o, r210.f470296l);
        s r105 = r101.G0;
        r105.f52918b = r111;
        if (r104 <= 0) goto L6;
        r105.f52929m = r104;
    L6:
        if (r110 == 14) goto L8;
        final GameCenterStrategy$doSubscribe$1 r106 = this;
        GameCenterStrategy r107 = r106.f52408a;
        com.bytedance.android.gamecp.base.core.service.depend.m r108 = r106.f52410c;
        r107.getClass();
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$onPassThrough$1(r108, r110), 3);
    L9:
        int r109 = r210.f470285a;
        boolean r113 = false;
        String r114 = null;
        switch(r109) {
            case 0: goto L73;
            case 1: goto L70;
            case 2: goto L69;
            case 3: goto L42;
            case 4: goto L23;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L11;
            case 9: goto L11;
            case 10: goto L11;
            case 11: goto L11;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L12;
            default: goto L11;
        };
    L11:
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$doSubscribe$1$downloadStateChange$13(r106, r210), 7);
        return;
    L12:
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$doSubscribe$1$downloadStateChange$12(r106), 7);
        return;
    L13:
        r106.f52410c.onInstallFailed(r210.f470291g);
        return;
    L14:
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$doSubscribe$1$downloadStateChange$11(r106, r210), 7);
        return;
    L15:
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$doSubscribe$1$downloadStateChange$9(r106, r210), 7);
        return;
    L16:
        GameCenterStrategy r115 = r106.f52408a;
        p r116 = r106.f52409b;
        com.bytedance.android.gamecp.base.core.service.depend.m r117 = r106.f52410c;
        com.bytedance.android.gamecp.base.core.service.depend.v r118 = new com.bytedance.android.gamecp.base.core.service.depend.v(0);
        r115.getClass();
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$onInstalled$1(r116, r109, r117, r118), 3);
        return;
    L17:
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$doSubscribe$1$downloadStateChange$7(r106, r210), 7);
        int r119 = com.bytedance.android.gamecp.business.patch.experiment.a.f56229a;
        if (com.bytedance.android.gamecp.business.patch.experiment.a.d(r210.f470299o) == true) goto L20;
        ((ExecutorService) r106.f52408a.f52404b.getValue()).submit(new b(r106));
    L20:
        yr.c.e("GameCenterStrategy", "下载失败 错误码 " + r210.f470291g);
        if (r210.f470291g != 1004) goto L81;
        y0.f52963a.b(r106.f52411d, r106.f52409b);
        return;
    L81:
        return;
    L23:
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$doSubscribe$1$downloadStateChange$10(r106, r210), 7);
        y0 r120 = y0.f52963a;
        p r121 = r106.f52409b;
        if (r121 == null) goto L32;
        s r122 = r121.G0;
        if (r122 == null) goto L32;
        com.bytedance.android.gamecp.business.download.b r123 = r122.f52917a;
        if (r123 == null) goto L32;
        JSONObject r124 = r123.f52537f;
        if (r124 == null) goto L32;
        r113 = r124.optBoolean("cancel_from_restore_fail");
    L32:
        yr.c.e("GamePromoteDownloader", "处理取消下载回调 isRestoreFailed = " + r113 + ", " + yr.c.d(null));
        if (r113 == true) goto L38;
        boolean r125 = AirCompressManager.f52225a;
        if (r121 == null) goto L37;
        r114 = r121.f52855k;
    L37:
        r113 = AirCompressManager.u(r114);
    L38:
        yr.c.e("GamePromoteDownloader", "处理取消下载回调 isRestoreFailed = " + r113);
        if (r113 == false) goto L41;
        yr.c.e("GamePromoteDownloader", "处理取消下载回调 来自还原失败取消 重新触发完整包下载");
        boolean r126 = AirCompressManager.f52225a;
        AirCompressManager.p(r121, "");
        return;
    L41:
        yr.c.e("GamePromoteDownloader", "处理取消下载回调 来自非空压还原失败 不做处理");
        return;
    L42:
        AirCompressReport r127 = AirCompressReport.f52266d;
        com.bytedance.android.gamecp.business.download.b r128 = r106.f52409b.G0.f52917a;
        if (Intrinsics.areEqual((Boolean) AirCompressReport.f52264b.getValue(), Boolean.TRUE) == false) goto L45;
        ((ExecutorService) AirCompressReport.f52265c.getValue()).submit(new com.bytedance.android.gamecp.business.compress.e(r128));
    L45:
        int r129 = com.bytedance.android.gamecp.business.patch.experiment.a.f56229a;
        boolean r130 = com.bytedance.android.gamecp.business.patch.experiment.a.d(r210.f470299o);
        yr.c.a("GameCenterStrategy", "下载完成，是否是增量更新任务:" + r130);
        if (r130 == false) goto L67;
        boolean r131 = AirCompressManager.f52225a;
        if (AirCompressManager.t(r210.f470290f, null) == false) goto L67;
        yr.c.a("GameCenterStrategy", "下载完成，注册增量合成回调，gameId:" + r106.f52409b.f52855k + ", fileName:" + r210.f470290f);
        p r132 = r106.f52409b;
        String r133 = r132.f52855k;
        Integer r134 = r132.f52873t;
        if (r134 == null) goto L53;
        int r135 = r134.intValue();
    L54:
        GameCenterStrategy$doSubscribe$1$downloadStateChange$6 r136 = new GameCenterStrategy$doSubscribe$1$downloadStateChange$6(r106, r210);
        Intrinsics.checkNotNullParameter(r136, "listener");
        yr.c.a("AirCompressManager", "setAirCompressListener gameId = " + r133);
        if (r133 != null) goto L57;
    L60:
        boolean r137 = true;
    L61:
        if (r137 == false) goto L63;
        r127.k(null, 1022, "gameId is null not register", 0);
        return;
    L63:
        ConcurrentHashMap r138 = (ConcurrentHashMap) AirCompressManager.f52232h;
        Map r139 = (Map) r138.get(r133);
        if (r139 != null) goto L66;
        r139 = new ConcurrentHashMap();
    L66:
        yr.c.a("AirCompressManager", "setAirCompressListener gameId = " + r133 + ", airCompressListenerList size = " + r139.size());
        r139.put(Integer.valueOf(r135), r136);
        r138.put(r133, r139);
        return;
    L57:
        if (r133.length() == 0) goto L60;
        r137 = false;
        goto L61
    L53:
        r135 = hashCode();
    L67:
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$doSubscribe$1$downloadStateChange$5(r106, r210), 7);
        return;
    L69:
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$doSubscribe$1$downloadStateChange$4(r106, r210), 7);
        return;
    L70:
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$doSubscribe$1$downloadStateChange$2(r106, r210), 7);
        int r140 = com.bytedance.android.gamecp.business.patch.experiment.a.f56229a;
        if (com.bytedance.android.gamecp.business.patch.experiment.a.d(r210.f470299o) == true) goto L88;
        yr.c.a("GameCenterStrategy", "下载中 调用还原");
        ((ExecutorService) r106.f52408a.f52404b.getValue()).submit(new a(r106));
        return;
    L88:
        return;
    L73:
        UtilityKotlinExtentionsKt.g(0, false, false, new GameCenterStrategy$doSubscribe$1$downloadStateChange$1(r106, r210), 7);
        return;
    L8:
        r106 = this;
        goto L9
    }

    public GameCenterStrategy$doSubscribe$1(GameCenterStrategy r100, p r101, x0 r102, Context r103) {
        this.f52408a = r100;
        this.f52409b = r101;
        this.f52410c = r102;
        this.f52411d = r103;
    }
}
