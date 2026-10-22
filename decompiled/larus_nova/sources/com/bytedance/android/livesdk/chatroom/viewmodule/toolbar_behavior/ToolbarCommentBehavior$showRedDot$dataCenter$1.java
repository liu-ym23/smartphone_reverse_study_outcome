package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ToolbarCommentBehavior$showRedDot$dataCenter$1 extends MutablePropertyReference0Impl {
    public ToolbarCommentBehavior$showRedDot$dataCenter$1(s2 r100) {
        super(r100, s2.class, "mDataCenter", "getMDataCenter()Lcom/bytedance/ies/sdk/widgets/DataCenter;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        DataCenter r100 = ((s2) this.receiver).f117363a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        s2 r101 = (s2) this.receiver;
        DataCenter r102 = (DataCenter) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f117363a = r102;
    }
}
