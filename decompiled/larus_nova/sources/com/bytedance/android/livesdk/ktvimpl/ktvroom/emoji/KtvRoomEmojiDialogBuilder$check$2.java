package com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvRoomEmojiDialogBuilder$check$2 extends MutablePropertyReference0Impl {
    public KtvRoomEmojiDialogBuilder$check$2(a r100) {
        super(r100, a.class, "dataCenter", "getDataCenter()Lcom/bytedance/ies/sdk/widgets/DataCenter;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        DataCenter r100 = ((a) this.receiver).f144695b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        DataCenter r101 = (DataCenter) r100;
        ((a) this.receiver).f144695b = r101;
    }
}
