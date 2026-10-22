package com.bytedance.android.livesdk.livecommerce.room.widgets.info_card.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ti.k;
import ti.l;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends QPresenter implements k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f152194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LiveRoomParams f152195f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.info_card.presenter.a$a, reason: collision with other inner class name */
    public static final class C2343a {
    }

    static {
    }

    @Override // ti.k
    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        ((ViewGroup) w().f()).removeAllViews();
        l r100 = this.f152194e;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f152194e = null;
    }

    public a(LiveRoomParams r100) {
        this.f152195f = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r110) {
        dm.a.a("ECLiveInfoCardPresenter").a("load");
        String r100 = ECLiveABUtils.INSTANCE.getEC_LIVE_INFO_CARD_SCHEMA();
        LiveRoomParams r101 = this.f152195f;
        if (r101 == null) goto L5;
        Map<String, Object> r102 = r101.generaInitialData();
    L7:
        if (r100.length() != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        dm.a.a("ECLiveInfoCardPresenter").b("lynx schema is empty", null);
        return;
    L13:
        if (this.f152194e == null) goto L15;
        dm.a.a("ECLiveInfoCardPresenter").a("lynxView has init");
        return;
    L15:
        l r111 = ECLiveHybridUtil.b(u().c(), r100, r102, (ViewGroup) w().f(), this, null, null, false, null, null, false, 4064);
        UtilityKotlinExtentionsKt.h(r111, ECLiveInfoCardPresenter$initLynxView$1.INSTANCE);
        this.f152194e = r111;
        return;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    @Override // ti.k
    public final void onFirstScreen(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onLoadSuccess(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        dm.a.a("ECLiveInfoCardPresenter").a("load Lynx onLoadSuccess");
        if (w().d() == true) goto L6;
        w().g(0);
        return;
    }

    @Override // ti.k
    public final void onRuntimeReady(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void g(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // ti.k
    public final void onLoadFailed(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        dm.a.a("ECLiveInfoCardPresenter").b("load Lynx onLoadFailed " + r101, null);
        w().c();
    }

    @Override // ti.k
    public final void onPageStart(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void s(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }
}
