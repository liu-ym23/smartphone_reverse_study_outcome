package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class v3 {
    public static final IPublicAreaCommon a(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$publicAreaCommon");
        if ((r100 instanceof u3) == true) goto L5;
        r100 = null;
    L5:
        u3 r101 = (u3) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getOrInitPublicAreaCommon();
    }
}
