package com.bytedance.android.livesdk.chatroom.roommanage.admin;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomAdminManageListPresenter f111270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ td1.d f111271b;

    public d(LiveRoomAdminManageListPresenter r100, td1.d r101) {
        this.f111270a = r100;
        this.f111271b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        LiveRoomAdminManageListPresenter r102 = this.f111270a;
        r102.f111192g.f545502a++;
        this.f111271b.f545503a = true;
        LiveRoomAdminManageListPresenter.a(r102);
        this.f111270a.f111190e = false;
    }
}
