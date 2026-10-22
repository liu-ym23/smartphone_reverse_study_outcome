package com.bytedance.android.livesdk.gift.platform.core.preview;

import com.bytedance.android.livesdk.gift.model.h1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g {
    public static final b a(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toGiftStruct");
        return new b(r100.getId(), r100.getPrimaryEffectId(), r100.getName(), r100.getDiamondCount(), r100.getImage());
    }
}
