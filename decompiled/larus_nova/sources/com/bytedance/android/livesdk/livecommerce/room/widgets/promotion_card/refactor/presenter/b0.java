package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

/* JADX INFO: loaded from: classes10.dex */
public final class b0 extends com.bytedance.android.ec.core.utils.y.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StatusPresenter f152440a;

    public b0(StatusPresenter r100) {
        this.f152440a = r100;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        this.f152440a.f152420g = null;
    }
}
