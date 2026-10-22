package com.bytedance.android.livesdk.chatroom.appointment;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppointmentAnchorWidget f105103a;

    public a(AppointmentAnchorWidget r100) {
        this.f105103a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        if (r101.statusCode != 0) goto L5;
        AppointmentAnchorWidget r102 = this.f105103a;
        Long r103 = Long.valueOf(((SubscribeCountData) r101.data).getCount());
        int r104 = AppointmentAnchorWidget.f105100c;
        r102.wq(r103);
        return;
    L5:
        AppointmentAnchorWidget r105 = this.f105103a;
        int r106 = AppointmentAnchorWidget.f105100c;
        r105.getClass();
        int r107 = x8.a.f562881a;
        x8.a.b("AppointmentAnchorWidget", "query subscribe count fail" + r101.logId, false);
    }
}
