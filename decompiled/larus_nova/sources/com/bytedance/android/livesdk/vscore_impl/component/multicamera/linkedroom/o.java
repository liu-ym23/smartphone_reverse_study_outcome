package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UgcLinkedRoomEntranceWidget f159642a;

    public o(UgcLinkedRoomEntranceWidget r100) {
        this.f159642a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        UgcLinkedRoomEntranceWidget.xq(this.f159642a);
    }
}
