package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video;

import android.content.Context;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base.PlayState;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base.VideoComponentScene;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.n;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import k73.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends b73.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VideoCtrlContainerComponent f166804c;

    public static final class a {
    }

    static {
    }

    public final void j0() {
        final VideoCtrlContainerComponent r100 = this.f166804c;
        if (r100 == null) goto L9;
        dm.a.a("VideoCtrlContainerComponent").i("onPlayCompleted");
        k73.a r101 = new k73.a(PlayState.STOP, k73.c.a(r100.f166799e));
        Map<String, k73.a> r102 = com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.utils.a.f166808a;
        String r103 = r100.f166799e.f501991b;
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.utils.a.a(r103, r101, new VideoCtrlContainerComponent$onPlayCompleted$1(r100), VideoCtrlContainerComponent$onPlayCompleted$2.INSTANCE);
        return;
    }

    @Override // b73.a, b73.d
    public final void onDestroy() {
        clearDisposable();
        VideoCtrlContainerComponent r100 = this.f166804c;
        if (r100 == null) goto L23;
        Iterator<Map.Entry<String, e>> r101 = r100.f166795a.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L12;
        e r102 = r101.next().getValue();
        if (r102 == null) goto L6;
        l r103 = r102.f501999b;
        if (r103 == null) goto L6;
        r103.release();
        goto L6
    L12:
        r100.f166795a.clear();
        ((LinkedHashMap) com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.utils.a.f166808a).clear();
        r100.b().removeAllViews();
        ViewGroup r104 = r100.f166798d;
        if (r104 == null) goto L24;
        r104.removeView(r100.b());
        return;
    L24:
        return;
    }

    public final void i0(k73.b r100) {
        VideoCtrlContainerComponent r101 = this.f166804c;
        if (r101 == null) goto L31;
        r101.b().removeAllViews();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L23
        n r103 = r100.f501993d;     // Catch: Throwable -> L23
        if (r103 == null) goto L20;
        String r104 = r100.f501994e;     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r104, VideoComponentScene.HEAD_VIDEO.getScene()) == false) goto L14;
        if (r103.b() == null) goto L12;
        r101.a(r100);     // Catch: Throwable -> L23
    L21:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L32;
        dm.a.a("VideoCtrlContainerComponent").b("bind failed", r106);
        return;
    L32:
        return;
    L12:
        dm.a.a("VideoCtrlContainerComponent").b("HeaderVideoInteractor is null", null);     // Catch: Throwable -> L23
        goto L21
    L14:
        if (Intrinsics.areEqual(r104, VideoComponentScene.HEAD_VIDEO_GALLERY.getScene()) == true) goto L16;
        dm.a.a("VideoCtrlContainerComponent").b("VideoComponentScene not support", null);     // Catch: Throwable -> L23
        goto L21
    L16:
        if (r103.a() == null) goto L18;
        r101.a(r100);     // Catch: Throwable -> L23
        goto L21
    L18:
        dm.a.a("VideoCtrlContainerComponent").b("GalleryVideoInteractor is null", null);     // Catch: Throwable -> L23
        goto L21
    L20:
        dm.a.a("VideoCtrlContainerComponent").b("VideoInteractor is null", null);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    public final void k0(boolean r100) {
        dm.a.a("VideoCtrlContainerComponentProxy").b("updateLoading, isLoading=" + r100, null);
        VideoCtrlContainerComponent r101 = this.f166804c;
        if (r101 == null) goto L6;
        Map<String, k73.a> r102 = com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.utils.a.f166808a;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.utils.a.b(r101.f166799e, null, r100, 6);
        return;
    }

    public final void m0(float r110, float r111) {
        VideoCtrlContainerComponent r100 = this.f166804c;
        if (r100 == null) goto L31;
        Map<String, k73.a> r101 = com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.utils.a.f166808a;
        k73.b r102 = r100.f166799e;
        int r112 = (int) (r110 * r111);
        int r113 = (int) r111;
        String r103 = "";
        Intrinsics.checkNotNullParameter(r102, "videoComponentInfo");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        String r105 = r102.f501991b;     // Catch: Throwable -> L17
        if (r105 != null) goto L27;
        r105 = "";
    L27:
        String r106 = r102.f501990a;     // Catch: Throwable -> L10
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L10
        KtSafeMethodExtensionKt.safePut(r107, LocationMonitorConst.IDENTIFIER, r106);     // Catch: Throwable -> L10
        KtSafeMethodExtensionKt.safePut(r107, "video_id", r105);     // Catch: Throwable -> L10
        KtSafeMethodExtensionKt.safePut(r107, "pdp_event_transparent_id", r106);     // Catch: Throwable -> L10
        KtSafeMethodExtensionKt.safePut(r107, HistoryTableOperate.HISTORY_PLAY_TIME, Integer.valueOf(r112));     // Catch: Throwable -> L10
        KtSafeMethodExtensionKt.safePut(r107, "total_duration", Integer.valueOf(r113));     // Catch: Throwable -> L10
        KtSafeMethodExtensionKt.safePut(r107, "status", k73.c.b(r102).getValue());     // Catch: Throwable -> L10
        KtSafeMethodExtensionKt.safePut(r107, "mute_status", k73.c.a(r102).getValue());     // Catch: Throwable -> L10
        dm.a.a("LynxEventUtils").i("publishLynxPlayerEvent eventName = ecom.pdp.player.play_time_change, params = " + r107);     // Catch: Throwable -> L10
        ECLiveHybridUtil.f("ecom.pdp.player.play_time_change", r107);     // Catch: Throwable -> L10
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L17
        if (r115 == null) goto L15;
        ECExceptionMonitor.e(r115);     // Catch: Throwable -> L17
    L15:
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L32;
        ECExceptionMonitor.e(r117);
        dm.a.b r118 = dm.a.a("LynxEventUtils");
        String r119 = r102.f501991b;
        if (r119 == null) goto L25;
        r103 = r119;
    L25:
        r118.b("publishLynxPlayTimeChangeEvent error videoId = ".concat(r103), null);
        return;
    L32:
        return;
    L10:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L17
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public b(Context r100, ViewGroup r101, k73.b r102, c r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "videoComponentInfo");
        Intrinsics.checkNotNullParameter(r103, "lynxCallback");
        dm.a.a("VideoCtrlContainerComponentProxy").b("videoComponentInfo=" + r102, null);
        this.f166804c = new VideoCtrlContainerComponent(r100, r101, r102, r103);
    }
}
