package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class s {
    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setHeight");
        r100.getLayoutParams().height = r101;
        r100.requestLayout();
    }
}
