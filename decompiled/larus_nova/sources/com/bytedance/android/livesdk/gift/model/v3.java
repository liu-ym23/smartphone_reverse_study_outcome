package com.bytedance.android.livesdk.gift.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class v3 {
    public static final boolean a(u3 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isValid");
        if (r100.getPostEffectSource() == 0) goto L9;
        py.k r101 = r100.getPostEffectImg();
        if (r101 == null) goto L9;
        if ((!r101.getUrls().isEmpty()) != true) goto L9;
        return true;
    L9:
        return false;
    }
}
