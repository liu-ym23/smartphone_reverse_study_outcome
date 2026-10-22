package com.bytedance.android.shopping.commentfeed.view;

import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.shopping.commentfeed.utils.CommentListViewModel;
import com.bytedance.android.shopping.commentfeed.widget.OverScrolledViewPager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements OverScrolledViewPager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentDetailFragment f172379a;

    @Override // com.bytedance.android.shopping.commentfeed.widget.OverScrolledViewPager.a
    public final void onRefresh() {
    }

    @Override // com.bytedance.android.shopping.commentfeed.widget.OverScrolledViewPager.a
    public final void a() {
        CommentDetailFragment r100 = this.f172379a;
        int r101 = CommentDetailFragment.f172338t;
        CommentListViewModel r102 = r100.S90();
        if (r102 != null) goto L5;
    L6:
        ECStatusView r103 = this.f172379a.f172349p;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("loadStatusView");
    L9:
        r103.setVisibility(0);
        oj.b r104 = r103.f46000a;
        if (r104 == null) goto L14;
        r104.d();
        return;
    L14:
        return;
    L5:
        if (r102.getHasMoreComment() != true) goto L6;
    }

    @Override // com.bytedance.android.shopping.commentfeed.widget.OverScrolledViewPager.a
    public final void onLoadMore() {
        ECStatusView r100 = this.f172379a.f172349p;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStatusView");
    L5:
        r100.setVisibility(8);
    }

    public a(CommentDetailFragment r100) {
        this.f172379a = r100;
    }
}
