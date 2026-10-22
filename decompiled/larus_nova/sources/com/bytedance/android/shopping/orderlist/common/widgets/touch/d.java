package com.bytedance.android.shopping.orderlist.common.widgets.touch;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {
    public static final String a(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getActionName");
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        return "DOWN";
    L5:
        if (r101 != 1) goto L7;
        return "UP";
    L7:
        if (r101 != 2) goto L9;
        return "MOVE";
    L9:
        if (r101 != 3) goto L16;
        return "CANCEL";
    L16:
        return String.valueOf(r100.getAction());
    }
}
