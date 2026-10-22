package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiCameraLinkedRoomTabsEntrance f159633a;

    public f(MultiCameraLinkedRoomTabsEntrance r100) {
        this.f159633a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        ALogger.i("MultiCameraLinkedRoomTabsEntrance", "on event hideByUgcMultiTabFilter");
        this.f159633a.wq();
    }
}
