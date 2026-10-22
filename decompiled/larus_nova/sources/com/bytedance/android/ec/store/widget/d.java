package com.bytedance.android.ec.store.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.widget.NoneSymmetryDecoration;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f48997a = 0;

    public d() {
    }

    static {
    }

    public static void a(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$clearDecorations");
        if (r100.getItemDecorationCount() <= 0) goto L8;
        int r101 = r100.getItemDecorationCount();
    L5:
        r101 = r101 - 1;
        if (r101 < 0) goto L10;
        r100.removeItemDecorationAt(r101);
        goto L5
    L10:
        return;
    }

    public static void b(RecyclerView r100, int r101, LayoutTypes r110) {
        Intrinsics.checkNotNullParameter(r100, "$this$scrollToFirstItemPosition");
        Integer r102 = Integer.valueOf(r101);
        if (r102.intValue() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L15;
        r100.scrollToPosition(r102.intValue());
        if (r110 != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L13;
        r100.post(new b(r100));
        goto L15
    L13:
        r100.post(new c(r100));
    L15:
        if (r110 != LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE) goto L18;
        a(r100);
        r100.addItemDecoration(new NoneSymmetryDecoration(r100.getContext(), 4.5f, 4.5f, 9.0f, RecyclerViewBySwitchIcon$scrollToFirstItemPosition$3.INSTANCE));
        r100.setPadding(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(7.5d)), 0, com.bytedance.android.shopping.extensions.b.b(Double.valueOf(7.5d)), 0);
        return;
    L18:
        if (r110 != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L22;
        a(r100);
        r100.addItemDecoration(new NoneSymmetryDecoration(r100.getContext(), 0.0f, 0.0f, 12.0f, RecyclerViewBySwitchIcon$scrollToFirstItemPosition$4.INSTANCE));
        r100.setPadding(com.bytedance.android.shopping.extensions.b.b(12), 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
        return;
    L22:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
