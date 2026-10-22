package com.bytedance.android.livesdk.livecommerce.room.controller;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AbsECLiveRoomController$isViewHandlerAttached$1 extends PropertyReference0Impl {
    public AbsECLiveRoomController$isViewHandlerAttached$1(a r100) {
        super(r100, a.class, "handler", "getHandler()Lcom/bytedance/android/livesdk/livecommerce/room/api/IECMergeLiveRoomViewHandler;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        com.bytedance.android.livesdk.livecommerce.room.api.e r100 = ((a) this.receiver).f151446a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L5:
        return r100;
    }
}
