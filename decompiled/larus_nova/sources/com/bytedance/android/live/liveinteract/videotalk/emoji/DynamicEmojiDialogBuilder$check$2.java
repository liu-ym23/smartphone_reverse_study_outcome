package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class DynamicEmojiDialogBuilder$check$2 extends MutablePropertyReference0Impl {
    public DynamicEmojiDialogBuilder$check$2(t r100) {
        super(r100, t.class, "dataCenter", "getDataCenter()Lcom/bytedance/ies/sdk/widgets/DataCenter;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        DataCenter r100 = ((t) this.receiver).f79418b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        DataCenter r101 = (DataCenter) r100;
        ((t) this.receiver).f79418b = r101;
    }
}
