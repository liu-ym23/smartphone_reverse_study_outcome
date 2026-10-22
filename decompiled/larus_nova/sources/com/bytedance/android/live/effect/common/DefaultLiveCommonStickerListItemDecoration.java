package com.bytedance.android.live.effect.common;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/common/DefaultLiveCommonStickerListItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DefaultLiveCommonStickerListItemDecoration extends RecyclerView.ItemDecoration {
    public DefaultLiveCommonStickerListItemDecoration() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        if (r102.getChildAdapterPosition(r101) != 0) goto L5;
        r100.set(s1.f(14.0f), 0, s1.f(2.0f), 0);
        return;
    L5:
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 != null) goto L8;
    L10:
        r100.set(s1.f(2.0f), 0, s1.f(2.0f), 0);
        return;
    L8:
        if (r104 != (r105.getItemCount() - 1)) goto L10;
        r100.set(s1.f(2.0f), 0, s1.f(14.0f), 0);
    }
}
