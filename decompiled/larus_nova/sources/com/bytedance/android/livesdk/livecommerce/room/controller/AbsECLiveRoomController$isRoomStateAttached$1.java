package com.bytedance.android.livesdk.livecommerce.room.controller;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AbsECLiveRoomController$isRoomStateAttached$1 extends PropertyReference0Impl {
    public AbsECLiveRoomController$isRoomStateAttached$1(a r100) {
        super(r100, a.class, "currentRoomState", "getCurrentRoomState()Lcom/bytedance/android/ec/adapter/api/state/ECRoomState;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((a) this.receiver).b();
    }
}
