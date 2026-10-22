package com.bytedance.android.ec.window.base.utils.playable.impl.video;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g {
    public static final boolean a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isDetachedFromRecyclerView");
        ViewParent r101 = r100.getParent();
    L4:
        if (r101 == null) goto L13;
        if ((r101 instanceof RecyclerView) == true) goto L7;
        ViewParent r102 = r101.getParent();
        if (Intrinsics.areEqual(r101, r102) == true) goto L11;
        r101 = r102;
        goto L4
    L11:
        return true;
    L7:
        return false;
    L13:
        return true;
    }
}
