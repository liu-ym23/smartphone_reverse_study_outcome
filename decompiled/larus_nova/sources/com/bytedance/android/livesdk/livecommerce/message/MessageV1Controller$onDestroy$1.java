package com.bytedance.android.livesdk.livecommerce.message;

import com.bytedance.android.livesdk.livecommerce.room.api.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class MessageV1Controller$onDestroy$1 extends MutablePropertyReference0Impl {
    public MessageV1Controller$onDestroy$1(b r100) {
        super(r100, b.class, "messageHandler", "getMessageHandler()Lcom/bytedance/android/livesdk/livecommerce/room/api/IECMergeLiveRoomMessageHandler;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        d r100 = ((b) this.receiver).f149388c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageHandler");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        d r101 = (d) r100;
        ((b) this.receiver).f149388c = r101;
    }
}
