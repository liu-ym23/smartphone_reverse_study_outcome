package com.bytedance.android.live.search.impl.search.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/adapter/LiveSearchResultDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchResultDecoration extends RecyclerView.ItemDecoration {

    public static final class a {
    }

    static {
    }

    public LiveSearchResultDecoration() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        if (r101.getVisibility() != 0) goto L5;
        int r104 = s1.f(3.0f);
    L6:
        ViewGroup.LayoutParams r105 = r101.getLayoutParams();
        if (r105 == null) goto L17;
        RecyclerView.LayoutParams r106 = (RecyclerView.LayoutParams) r105;
        if ((r106 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L11;
        boolean r107 = ((StaggeredGridLayoutManager.LayoutParams) r106).isFullSpan();
    L12:
        if (r107 == false) goto L14;
        r104 = s1.f(3.0f);
    L14:
        int r108 = s1.f(1.5f);
        r100.set(r108, r104, r108, 0);
        return;
    L11:
        r107 = false;
        goto L12
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L5:
        r104 = 0;
        goto L6
    }
}
