package com.bytedance.android.shopping.feedbackpanel;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.feedbackpanel.enums.WhereType;
import de3.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/feedbackpanel/FeedbackPanelDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedbackPanelDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f176080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f176081b;

    public FeedbackPanelDecoration(List<c> r100) {
        Intrinsics.checkNotNullParameter(r100, "itemDataList");
        this.f176081b = r100;
        this.f176080a = com.bytedance.android.shopping.extensions.b.b(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        if (r104 > 0) goto L5;
        return;
    L5:
        if (r104 >= this.f176081b.size()) goto L19;
        c r105 = (c) CollectionsKt.getOrNull(this.f176081b, r104);
        WhereType r106 = null;
        if (r105 == null) goto L9;
        WhereType r107 = r105.f468061d;
    L11:
        if (r107 == WhereType.GROUP_BOTTOM) goto L16;
        if (r105 == null) goto L15;
        r106 = r105.f468061d;
    L15:
        if (r106 == WhereType.GROUP_ONLY_ONE) goto L16;
        return;
    L16:
        r100.bottom = this.f176080a;
        return;
    L9:
        r107 = null;
        goto L11
    }
}
