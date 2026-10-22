package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiCameraLinkeRoomEntranceWidget f159628a;

    public b(MultiCameraLinkeRoomEntranceWidget r100) {
        this.f159628a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MultiCameraLinkeRoomEntranceWidget.xq(this.f159628a);
    }
}
