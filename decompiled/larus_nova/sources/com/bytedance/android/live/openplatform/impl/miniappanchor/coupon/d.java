package com.bytedance.android.live.openplatform.impl.miniappanchor.coupon;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.livesdk.message.model.OpenPlatformCouponInvalidMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends ro0.b<OpenPlatformCouponInvalidMessage> {
    @Override // ro0.b
    public final MessageType a() {
        return MessageType.OPEN_PLATFORM_COUPON_INVALID_MESSAGE;
    }

    public d(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
    }

    @Override // ro0.b
    public final void b(tlc.d r100) {
        OpenPlatformCouponInvalidMessage r101 = (OpenPlatformCouponInvalidMessage) r100;
        Intrinsics.checkNotNullParameter(r101, "message");
        if (r101.invalidType == OpenPlatformCouponInvalidMessage.InvalidType.UnknownInvalidType.getValue()) goto L6;
        f2.c(r101.content, 0);
        return;
    }
}
