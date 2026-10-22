package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiCameraLinkedRoomTabsEntrance f159634a;

    public g(MultiCameraLinkedRoomTabsEntrance r100) {
        this.f159634a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f159634a.wq();
    }
}
