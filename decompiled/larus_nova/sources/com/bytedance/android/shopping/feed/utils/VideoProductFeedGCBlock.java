package com.bytedance.android.shopping.feed.utils;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/utils/VideoProductFeedGCBlock;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProductFeedGCBlock extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f175432a;

    public VideoProductFeedGCBlock() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "rv");
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L9;
        int r102 = ph.a.f529226a;
        this.f175432a = false;
        return;
    L9:
        if (this.f175432a == true) goto L13;
        int r103 = ph.a.f529226a;
        this.f175432a = true;
        return;
    }
}
