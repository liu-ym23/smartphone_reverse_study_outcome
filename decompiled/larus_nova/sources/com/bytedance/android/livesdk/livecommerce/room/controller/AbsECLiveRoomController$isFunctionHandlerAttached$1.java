package com.bytedance.android.livesdk.livecommerce.room.controller;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AbsECLiveRoomController$isFunctionHandlerAttached$1 extends PropertyReference0Impl {
    public AbsECLiveRoomController$isFunctionHandlerAttached$1(a r100) {
        super(r100, a.class, "functionHandler", "getFunctionHandler()Lcom/bytedance/android/livesdk/livecommerce/room/api/IECMergeLiveRoomFunctionHandler;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        com.bytedance.android.livesdk.livecommerce.room.api.c r100 = ((a) this.receiver).f151449d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("functionHandler");
    L5:
        return r100;
    }
}
