package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserInfoPopupPresenter f100129a;

    public b(UserInfoPopupPresenter r100) {
        this.f100129a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        DataCenter r102 = this.f100129a.a();
        if (r102 == null) goto L6;
        r102.put("fans_rank_list_lottie", Boolean.FALSE);
        return;
    }
}
