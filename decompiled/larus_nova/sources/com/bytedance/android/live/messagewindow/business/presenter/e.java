package com.bytedance.android.live.messagewindow.business.presenter;

import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes46.dex */
public final class e extends AbsCommonCardPresenter<i3> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f82978e;

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter
    public final String d0() {
        return this.f82978e;
    }

    public e(DataCenter r100) {
        super(r100);
        this.f82978e = "TopRightCommonCardPresenter";
    }
}
