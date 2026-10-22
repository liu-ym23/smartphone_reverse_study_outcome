package com.bytedance.android.livesdk.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/widget/EndlessScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EndlessScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutManager f160858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x1 f160859b;

    public EndlessScrollListener(LinearLayoutManager r100, x1 r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        Intrinsics.checkNotNullParameter(r101, "loadMoreSubject");
        this.f160858a = r100;
        this.f160859b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (r102 >= 0) goto L5;
        return;
    L5:
        if (this.f160859b.isLoading() == true) goto L16;
        int r103 = this.f160858a.getItemCount();
        boolean r104 = true;
        if (this.f160858a.findLastCompletelyVisibleItemPosition() >= ((r103 - 1) - this.f160859b.a())) goto L11;
        r104 = false;
    L11:
        if (r104 == false) goto L15;
        this.f160859b.onLoadMore();
        return;
    L15:
        return;
    }
}
