package com.bytedance.android.livesdk.livecommerce.messagev2;

import com.bytedance.android.livesdk.livecommerce.room.api.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class MessageV2Controller$onDestroy$1 extends MutablePropertyReference0Impl {
    public MessageV2Controller$onDestroy$1(a r100) {
        super(r100, a.class, "messageHandler", "getMessageHandler()Lcom/bytedance/android/livesdk/livecommerce/room/api/IECMergeLiveRoomMessageHandler;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        d r100 = ((a) this.receiver).f149393c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageHandler");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        d r101 = (d) r100;
        ((a) this.receiver).f149393c = r101;
    }
}
