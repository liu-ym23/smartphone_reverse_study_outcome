package com.bytedance.android.live.effect.beauty.sticker;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/sticker/LiveBeautyStickerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautyStickerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f67739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f67740b;

    public LiveBeautyStickerItemDecoration() {
        this.f67739a = 10;
        this.f67740b = 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        if (r104 != 0) goto L5;
        r100.set(s1.f(this.f67739a), 0, 0, 0);
        return;
    L5:
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 == null) goto L8;
        int r106 = r105.getItemCount();
    L10:
        if (r104 != (r106 - 1)) goto L12;
        r100.set(0, 0, s1.f(this.f67739a), 0);
        return;
    L12:
        r100.set(s1.f(this.f67740b), 0, s1.f(this.f67740b), 0);
        return;
    L8:
        r106 = 0;
        goto L10
    }
}
