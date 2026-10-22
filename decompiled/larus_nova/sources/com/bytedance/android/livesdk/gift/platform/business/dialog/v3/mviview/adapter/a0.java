package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a0 extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f127816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f127817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f127818c;

    public a0(int r100, int r101, int r102) {
        this.f127816a = r100;
        this.f127817b = r101;
        this.f127818c = r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 == null) goto L5;
        int r106 = r105.getItemCount();
    L6:
        if (r104 != 0) goto L9;
        r100.top = this.f127816a;
    L9:
        if (r104 != (r106 - 1)) goto L11;
        r100.bottom = this.f127818c;
        return;
    L11:
        r100.bottom = this.f127817b;
        return;
    L5:
        r106 = 0;
        goto L6
    }
}
