package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepicker/ImagePickerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImagePickerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f139941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f139942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f139943c;

    public ImagePickerItemDecoration(int r100, int r101) {
        this.f139941a = r100;
        this.f139942b = r101;
        this.f139943c = 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = this.f139943c;
        int r106 = r104 / r105;
        int r107 = r104 % r105;
        int r108 = this.f139941a;
        r100.left = (r107 * r108) / r105;
        r100.right = r108 - (((r107 + 1) * r108) / r105);
        if (r106 < 1) goto L6;
        r100.top = this.f139942b;
        return;
    }
}
