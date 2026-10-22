package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a0 extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiLinkFeedHybridCardManager f76868a;

    public a0(MultiLinkFeedHybridCardManager r100) {
        this.f76868a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        JsonObject r101 = new JsonObject();
        r101.addProperty(NewBroadcastMonitor.STAGE.LIFECYCLE, "start");
        r101.addProperty("source", "feed");
        if (MultiLinkLoadWidgetUtils.k() == false) goto L5;
        this.f76868a.getClass();
        r101.add("client_settings_info", MultiLinkFeedHybridCardManager.a());
    L5:
        this.f76868a.f(r101);
        ih0.c r102 = this.f76868a.f76850b;
        if (r102 == null) goto L8;
        r102.sendJsEvent("renderWidgetLifecycle", r101);
    L8:
        ih0.c r103 = this.f76868a.f76850b;
        if (r103 == null) goto L13;
        View r104 = r103.S0();
        if (r104 == null) goto L13;
        UtilityKotlinExtentionsKt.w(r104);
    L13:
        this.f76868a.k();
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        super.onLoadFail(r100, r101, r102);
        ALogger.e("MultiLinkFeedHybridCardManager", "渲染容器加载失败! url=" + r101 + ", reason=" + r102);
        this.f76868a.f76850b = null;
    }
}
