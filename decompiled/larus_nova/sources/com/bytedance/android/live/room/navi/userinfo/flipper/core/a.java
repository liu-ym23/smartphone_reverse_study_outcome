package com.bytedance.android.live.room.navi.userinfo.flipper.core;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static final BaseTabFlipper.LayoutParams a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$flipperLp");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof BaseTabFlipper.LayoutParams) == true) goto L6;
        r101 = null;
    L6:
        return (BaseTabFlipper.LayoutParams) r101;
    }
}
