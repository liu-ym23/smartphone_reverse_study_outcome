package com.bytedance.android.livesdk.feed.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: classes8.dex */
public class FeedItemDecoration2 extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f124527a = 2.0f;

    public FeedItemDecoration2() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        if (r101.getVisibility() != 0) goto L5;
        int r104 = s1.f(f124527a);
    L6:
        RecyclerView.LayoutParams r105 = (RecyclerView.LayoutParams) r101.getLayoutParams();
        if ((r105 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L9;
        boolean r106 = ((StaggeredGridLayoutManager.LayoutParams) r105).isFullSpan();
    L10:
        if (r106 == false) goto L12;
        r104 = s1.f(2.0f);
    L12:
        int r107 = s1.f(1.0f);
        r100.set(r107, r104, r107, 0);
        return;
    L9:
        r106 = false;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }
}
