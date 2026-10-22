package com.bytedance.android.ec.window.base.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.widget.NoneSymmetryDecoration;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f49939a = 0;

    public f() {
    }

    static {
    }

    public static void a(RecyclerView r100, int r101, WindowLayoutTypes r110) {
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
        if (r110 != WindowLayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L13;
        r100.post(new d(r100));
        goto L15
    L13:
        r100.post(new e(r100));
    L15:
        if (r110 != WindowLayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE) goto L24;
        Intrinsics.checkNotNullParameter(r100, "$this$clearDecorations");
        if (r100.getItemDecorationCount() <= 0) goto L22;
        int r104 = r100.getItemDecorationCount();
    L19:
        r104 = r104 - 1;
        if (r104 < 0) goto L22;
        r100.removeItemDecorationAt(r104);
    L22:
        r100.addItemDecoration(new NoneSymmetryDecoration(r100.getContext(), 4.5f, 4.5f, 9.0f, WindowRecyclerViewBySwitchIcon$scrollToFirstItemPosition$3.INSTANCE));
        r100.setPadding(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(7.5d)), 0, com.bytedance.android.shopping.extensions.b.b(Double.valueOf(7.5d)), 0);
        return;
    L24:
        if (r110 != WindowLayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L36;
        Intrinsics.checkNotNullParameter(r100, "$this$clearDecorations");
        if (r100.getItemDecorationCount() <= 0) goto L31;
        int r105 = r100.getItemDecorationCount();
    L28:
        r105 = r105 - 1;
        if (r105 < 0) goto L31;
        r100.removeItemDecorationAt(r105);
    L31:
        r100.addItemDecoration(new NoneSymmetryDecoration(r100.getContext(), 0.0f, 0.0f, 12.0f, WindowRecyclerViewBySwitchIcon$scrollToFirstItemPosition$4.INSTANCE));
        r100.setPadding(com.bytedance.android.shopping.extensions.b.b(12), 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
        return;
    L36:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
