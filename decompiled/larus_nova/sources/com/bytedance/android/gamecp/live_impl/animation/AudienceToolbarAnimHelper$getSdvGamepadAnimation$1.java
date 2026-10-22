package com.bytedance.android.gamecp.live_impl.animation;

import com.bytedance.android.gamecp.common.ui.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AudienceToolbarAnimHelper$getSdvGamepadAnimation$1 extends MutablePropertyReference0Impl {
    public AudienceToolbarAnimHelper$getSdvGamepadAnimation$1(b r100) {
        super(r100, b.class, "mSdvGamepadAnimation", "getMSdvGamepadAnimation()Lcom/bytedance/android/gamecp/common/ui/HSImageView;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        HSImageView r100 = ((b) this.receiver).f57788b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSdvGamepadAnimation");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        HSImageView r101 = (HSImageView) r100;
        ((b) this.receiver).f57788b = r101;
    }
}
