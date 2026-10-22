package com.bytedance.android.livesdk.interactivity.roomintro.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomIntroDialogV2 f140739a;

    public p(RoomIntroDialogV2 r100) {
        this.f140739a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((sh6.b) r100).a() == false) goto L6;
        RoomIntroDialogV2.U90(this.f140739a, "livesdk_live_room_detail_poi_set_show");
        return;
    }
}
