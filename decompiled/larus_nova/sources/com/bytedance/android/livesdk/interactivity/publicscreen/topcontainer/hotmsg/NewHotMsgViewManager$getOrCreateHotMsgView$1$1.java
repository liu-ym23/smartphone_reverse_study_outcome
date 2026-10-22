package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class NewHotMsgViewManager$getOrCreateHotMsgView$1$1 extends MutablePropertyReference0Impl {
    public NewHotMsgViewManager$getOrCreateHotMsgView$1$1(d r100) {
        super(r100, d.class, KtvSubElement.CONTAINER, "getContainer()Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/topcontainer/IPSTopContainer;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        f52.b r100 = ((d) this.receiver).f139873a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        f52.b r101 = (f52.b) r100;
        ((d) this.receiver).f139873a = r101;
    }
}
