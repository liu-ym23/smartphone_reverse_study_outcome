package com.bytedance.android.window.shop.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {
    public static final View a(RecyclerView r100, Class<? extends View> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$tryGetSpecificTypeView");
        Intrinsics.checkNotNullParameter(r101, "type");
        int r102 = r100.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        View r104 = r100.getChildAt(r103);
        if (Intrinsics.areEqual(r104.getClass(), r101) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }
}
