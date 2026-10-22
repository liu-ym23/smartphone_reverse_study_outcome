package com.bytedance.android.livesdk.interactivity.comment.input.panel;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/livesdk/interactivity/comment/input/panel/ScreenChatPanelProvider$providePanel$3", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScreenChatPanelProvider$providePanel$3 extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r103.getItemCount() - 1;
        if (r102.getChildAdapterPosition(r101) == 0) goto L10;
        if (r102.getChildAdapterPosition(r101) != r104) goto L7;
        r100.left = s1.f(8.0f);
        r100.right = s1.f(16.0f);
        return;
    L7:
        r100.left = s1.f(8.0f);
        return;
    L10:
        throw null;
    }
}
