package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes46.dex */
public final class w0 extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f77160a;

    public w0(e0 r100) {
        this.f77160a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        JsonObject r101 = new JsonObject();
        r101.addProperty(NewBroadcastMonitor.STAGE.LIFECYCLE, "start");
        r101.addProperty("source", "feed");
        if (MultiLinkLoadWidgetUtils.k() == false) goto L5;
        this.f77160a.getClass();
        r101.add("client_settings_info", e0.d());
    L5:
        this.f77160a.i(r101);
        ih0.c r102 = this.f77160a.f76922e;
        if (r102 == null) goto L8;
        r102.sendJsEvent("renderWidgetLifecycle", r101);
    L8:
        ih0.c r103 = this.f77160a.f76922e;
        if (r103 == null) goto L13;
        View r104 = r103.S0();
        if (r104 == null) goto L13;
        UtilityKotlinExtentionsKt.w(r104);
    L13:
        this.f77160a.s();
        MultiLinkLoadWidgetUtils.p(this.f77160a.f76919b, "MultiLinkMainHybridCardManager#obtainRenderHybridComponent#onLoadSuccess", "[tag:MultiLinkRenderWidgetReuseManager]渲染容器发送renderWidgetLifecycle start, 使用缓存, renderWidget: " + this.f77160a.f76922e);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        super.onLoadFail(r100, r101, r102);
        ALogger.e("MultiLinkFeedHybridCardManager", "渲染容器加载失败! url=" + r101 + ", reason=" + r102);
        this.f77160a.f76922e = null;
    }
}
