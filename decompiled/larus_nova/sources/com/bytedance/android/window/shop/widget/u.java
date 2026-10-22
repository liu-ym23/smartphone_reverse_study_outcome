package com.bytedance.android.window.shop.widget;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.window.shop.home.adapter.WindowAutoScrollViewAdapter;
import com.bytedance.android.window.shop.home.presenter.ECWindowInfoLinearManager;
import com.bytedance.android.window.shop.home.presenter.ECWindowInfoLinearManager$smoothScrollToPositionWithOffset$scroller$1;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowEveryoneTalkCard f190122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f190123b;

    public u(WindowEveryoneTalkCard r100, List r101) {
        this.f190122a = r100;
        this.f190123b = r101;
    }

    public final void a() {
        RecyclerView r100 = this.f190122a.f189900b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L5:
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        RecyclerView.LayoutManager r102 = null;
        if ((r101 instanceof StaggeredGridLayoutManager) == true) goto L8;
        r101 = null;
    L8:
        StaggeredGridLayoutManager r103 = (StaggeredGridLayoutManager) r101;
        if (r103 == null) goto L11;
        int[] r104 = r103.findLastCompletelyVisibleItemPositions(null);
    L12:
        if (r104 == null) goto L19;
        int r105 = r104.length;
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L19;
        if (r104[r106] == (this.f190123b.size() - 1)) goto L17;
        r106 = r106 + 1;
        goto L14
    L17:
        return;
    L19:
        RecyclerView r107 = this.f190122a.f189900b;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L22:
        RecyclerView.Adapter r108 = r107.getAdapter();
        if ((r108 instanceof WindowAutoScrollViewAdapter) == true) goto L25;
        r108 = null;
    L25:
        WindowAutoScrollViewAdapter r109 = (WindowAutoScrollViewAdapter) r108;
        if (r109 == null) goto L28;
        List<uq3.p> r110 = r109.f188177a;
        ((ArrayList) r110).addAll(r110);
        r109.notifyDataSetChanged();
    L28:
        RecyclerView r111 = this.f190122a.f189900b;
        if (r111 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L31:
        RecyclerView.LayoutManager r112 = r111.getLayoutManager();
        if ((r112 instanceof ECWindowInfoLinearManager) == false) goto L35;
        r102 = r112;
    L35:
        final ECWindowInfoLinearManager r113 = (ECWindowInfoLinearManager) r102;
        if (r113 == null) goto L44;
        RecyclerView r114 = this.f190122a.f189900b;
        if (r114 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L40:
        int r115 = this.f190123b.size();
        final int r116 = com.bytedance.android.shopping.extensions.b.b(6);
        Intrinsics.checkNotNullParameter(r114, "recyclerView");
        final Context r117 = r114.getContext();
        LinearSmoothScroller r118 = new ECWindowInfoLinearManager$smoothScrollToPositionWithOffset$scroller$1(r113, r116, r117);
        r118.setTargetPosition(r115);
        r113.startSmoothScroll(r118);
        return;
    L44:
        return;
    L11:
        r104 = null;
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
