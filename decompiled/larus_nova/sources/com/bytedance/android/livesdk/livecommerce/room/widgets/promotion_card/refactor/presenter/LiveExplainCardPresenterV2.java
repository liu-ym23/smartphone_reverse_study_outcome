package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveExplainCardPresenterV2 extends p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f152418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.controller.business.n f152419h;

    public LiveExplainCardPresenterV2() {
        this.f152418g = LazyKt.lazy(new LiveExplainCardPresenterV2$ecContext$2(this));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        clearDisposable();
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r100 = this.f152419h;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardController");
    L7:
        r100.f151647f = null;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r101 = this.f152419h;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardController");
    L10:
        r101.f151646e = null;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r102 = this.f152419h;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardController");
    L13:
        r102.f151649h = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ExplainCardViewModel r101 = this.f152468e;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isFromLive() != true) goto L36;
        ECContext r102 = (ECContext) this.f152418g.getValue();
        if (r102 != null) goto L9;
    L11:
        ECContext r103 = (ECContext) this.f152418g.getValue();
        String r104 = null;
        if (r103 == null) goto L16;
        com.bytedance.live.datacontext.i<String> r105 = r103.getRoomId();
        if (r105 == null) goto L16;
        String r106 = r105.getValue();
    L17:
        ExplainCardViewModel r107 = this.f152468e;
        if (r107 == null) goto L27;
        RoomContextController r108 = r107.getRoomContextController();
        if (r108 == null) goto L27;
        RoomContextController r109 = ControllerExtensionsKt.c(r108, r106);
        if (r109 == null) goto L27;
        RealRoomController r110 = r109.A();
        if (r110 == null) goto L27;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r111 = r110.f151426q;
        if (r111 == null) goto L27;
    L33:
        this.f152419h = r111;
        return;
    L27:
        int r112 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.f151643o;
        ExplainCardViewModel r113 = this.f152468e;
        if (r113 == null) goto L32;
        RoomContextController r114 = r113.getRoomContextController();
        if (r114 == null) goto L32;
        r104 = r114.D();
    L32:
        r111 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.a.a(r106, r104);
    L16:
        r106 = null;
        goto L17
    L9:
        if (r102.isCleared() != true) goto L11;
        return;
    }
}
