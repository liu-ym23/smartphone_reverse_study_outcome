package com.bytedance.android.live.messagewindow.business.presenter;

import android.view.View;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant$Position;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant$Result;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Integer f82975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f82976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f82977c;

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        i r101 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r101 == null) goto L6;
        CardAlogParamsBuilder r102 = new CardAlogParamsBuilder();
        r102.d("PortraitCommonCardPresenter");
        r102.c("preLoad onLoadSuccess");
        Unit r103 = Unit.INSTANCE;
        r101.d(r102.b());
    L6:
        i r104 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r104 == null) goto L10;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r105 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_result");
        r105.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        r105.b("type", this.f82975a);
        r105.b("result", Integer.valueOf(CommonCardConstant$Result.SUCCESS.getValue()));
        Unit r106 = Unit.INSTANCE;
        r104.b(r105.a());
    L10:
        i r107 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r107 == null) goto L15;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r108 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_time_cost");
        r108.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        r108.b("type", this.f82975a);
        r108.b(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(System.currentTimeMillis() - this.f82976b));
        Unit r109 = Unit.INSTANCE;
        r107.b(r108.a());
        return;
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        super.onInnerFallback(r100, r101);
        i r102 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r102 == null) goto L6;
        CardAlogParamsBuilder r103 = new CardAlogParamsBuilder();
        r103.d("PortraitCommonCardPresenter");
        r103.c("preLoad onInnerFallback");
        r103.a("errorCode", String.valueOf(r100));
        r103.a("errorMessage", r101);
        Unit r104 = Unit.INSTANCE;
        r102.d(r103.b());
    L6:
        i r105 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r105 == null) goto L11;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r106 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_fallback");
        r106.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        r106.b("type", this.f82975a);
        r106.b("error_code", String.valueOf(r100));
        r106.b("error_msg", r101);
        Unit r107 = Unit.INSTANCE;
        r105.b(r106.a());
        return;
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r100, boolean r101) {
        super.onLoadStart(r100, r101);
        i r102 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r102 == null) goto L7;
        CardAlogParamsBuilder r103 = new CardAlogParamsBuilder();
        r103.d("PortraitCommonCardPresenter");
        r103.c("preLoad onHybridCardLoadStart");
        Unit r104 = Unit.INSTANCE;
        r102.d(r103.b());
        return;
    }

    public d(Integer r100, long r101, Function1 r102) {
        this.f82975a = r100;
        this.f82976b = r101;
        this.f82977c = r102;
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        super.onLoadFail(r100, r101, r102);
        i r103 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r103 == null) goto L6;
        CardAlogParamsBuilder r104 = new CardAlogParamsBuilder();
        r104.d("PortraitCommonCardPresenter");
        r104.c("preLoad onLoadFail");
        Unit r105 = Unit.INSTANCE;
        r103.d(r104.b());
    L6:
        Function1 r106 = this.f82977c;
        p71.a.f r107 = new p71.a.f();
        String r108 = String.valueOf(r102);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f527978b = r108;
        Unit r109 = Unit.INSTANCE;
        r106.invoke(r107);
        i r110 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r110 == null) goto L11;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r111 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_result");
        r111.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        r111.b("type", this.f82975a);
        r111.b("result", Integer.valueOf(CommonCardConstant$Result.FAIL.getValue()));
        r111.b("error_msg", r102);
        r110.b(r111.a());
        return;
    }
}
