package com.bytedance.android.live.search.impl.search.callback;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qa1.f;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/callback/OnRecyclerViewFlingListener;", "Landroidx/recyclerview/widget/RecyclerView$OnFlingListener;", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnRecyclerViewFlingListener extends RecyclerView.OnFlingListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f100726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f100727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f100728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f100729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f100730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerView f100731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f100732g;

    public OnRecyclerViewFlingListener(RecyclerView r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "onHasMoreListener");
        this.f100731f = r100;
        this.f100732g = r101;
        this.f100726a = true;
        this.f100729d = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public final boolean onFling(int r100, int r101) {
        if (this.f100726a == true) goto L5;
        return false;
    L5:
        RecyclerView.LayoutManager r102 = this.f100731f.getLayoutManager();
        if ((r102 instanceof GridLayoutManager) == false) goto L11;
        GridLayoutManager r103 = (GridLayoutManager) r102;
        int r104 = r103.findFirstVisibleItemPosition();
        int r105 = r103.findLastVisibleItemPosition();
        if (this.f100729d != (-1)) goto L25;
        this.f100729d = r103.getSpanCount();
    L25:
        int r106 = r102.getChildCount();
        int r107 = r102.getItemCount();
        if (r106 <= 0) goto L51;
        View r108 = r102.findViewByPosition(r104);
        if (r108 == null) goto L30;
        int r109 = r108.getHeight();
    L31:
        if (r109 != 0) goto L33;
        return false;
    L33:
        int r110 = this.f100729d;
        if (r110 != (-1)) goto L46;
        int r111 = this.f100730e;
        if (r111 <= 0) goto L38;
        if (r111 > r107) goto L38;
    L40:
        if (((r101 / r109) + r105) < (r107 - this.f100730e)) goto L51;
        if (this.f100732g.hasMore() == false) goto L44;
        this.f100732g.preload();
        goto L51
    L44:
        this.f100732g.x1();
    L38:
        this.f100730e = 2;
        goto L40
    L46:
        if ((((r101 / r109) + (r105 / r110)) + 3) < (r107 / r110)) goto L51;
        if (this.f100732g.hasMore() == false) goto L50;
        this.f100732g.preload();
        goto L51
    L50:
        this.f100732g.x1();
        goto L51
    L30:
        r109 = 0;
    L51:
        return false;
    L11:
        if ((r102 instanceof LinearLayoutManager) == false) goto L14;
        LinearLayoutManager r112 = (LinearLayoutManager) r102;
        r104 = r112.findFirstVisibleItemPosition();
        r105 = r112.findLastVisibleItemPosition();
        goto L25
    L14:
        if ((r102 instanceof StaggeredGridLayoutManager) == false) goto L53;
        StaggeredGridLayoutManager r113 = (StaggeredGridLayoutManager) r102;
        if (this.f100729d != (-1)) goto L19;
        this.f100729d = r113.getSpanCount();
    L19:
        if (this.f100727b != null) goto L22;
        this.f100727b = new int[r113.getSpanCount()];
    L22:
        if (this.f100728c != null) goto L24;
        this.f100728c = new int[r113.getSpanCount()];
    L24:
        r113.findFirstVisibleItemPositions(this.f100727b);
        r113.findLastVisibleItemPositions(this.f100728c);
        int[] r114 = this.f100727b;
        Intrinsics.checkNotNull(r114);
        r104 = r114[0];
        int[] r115 = this.f100728c;
        Intrinsics.checkNotNull(r115);
        int[] r116 = this.f100728c;
        Intrinsics.checkNotNull(r116);
        r105 = r115[r116.length - 1];
        goto L25
    L53:
        throw new RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
    }
}
