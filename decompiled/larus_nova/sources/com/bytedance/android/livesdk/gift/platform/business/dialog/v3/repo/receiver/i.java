package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i {
    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setWidth");
        r100.getLayoutParams().width = r101;
        r100.requestLayout();
    }
}
