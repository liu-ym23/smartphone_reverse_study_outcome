package com.bytedance.android.livesdk.chatroom.replay.commerce;

import com.baidu.platform.comapi.map.MapController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ReplayECProductWidget$addPlayerViewControl$1$2$canControlByPlayer$1 extends MutablePropertyReference0Impl {
    public ReplayECProductWidget$addPlayerViewControl$1$2$canControlByPlayer$1(ReplayECProductWidget r100) {
        super(r100, ReplayECProductWidget.class, MapController.ITEM_LAYER_TAG, "getItem()Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/VSPlayerViewControlItem;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100 = ((ReplayECProductWidget) this.receiver).f108279f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(MapController.ITEM_LAYER_TAG);
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r101 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.c) r100;
        ((ReplayECProductWidget) this.receiver).f108279f = r101;
    }
}
