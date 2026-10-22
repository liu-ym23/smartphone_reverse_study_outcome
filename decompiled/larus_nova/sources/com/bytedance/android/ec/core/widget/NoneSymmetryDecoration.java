package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.common.utility.UIUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/core/widget/NoneSymmetryDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NoneSymmetryDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f46009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f46010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f46011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f46012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f46013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f46014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f46015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f46016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f46017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<View, Boolean> f46018j;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        this.f46009a = (int) UIUtils.dip2Px(this.f46013e, this.f46016h);
        this.f46010b = (int) UIUtils.dip2Px(this.f46013e, this.f46017i);
        this.f46011c = (int) UIUtils.dip2Px(this.f46013e, this.f46014f);
        this.f46012d = (int) UIUtils.dip2Px(this.f46013e, this.f46015g);
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        if (r104 == null) goto L14;
        StaggeredGridLayoutManager.LayoutParams r105 = (StaggeredGridLayoutManager.LayoutParams) r104;
        if (this.f46018j.invoke(r101).booleanValue() == false) goto L8;
        return;
    L8:
        if ((r105.getSpanIndex() % 2) != 0) goto L10;
        r100.left = this.f46011c;
        r100.right = this.f46012d;
    L11:
        r100.top = this.f46009a;
        r100.bottom = this.f46010b;
        return;
    L10:
        r100.left = this.f46012d;
        r100.right = this.f46011c;
        goto L11
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    public NoneSymmetryDecoration(Context r100, float r101, float r102, float r103, Function1 r104) {
        Intrinsics.checkNotNullParameter(r104, "exceptView");
        this.f46013e = r100;
        this.f46014f = r101;
        this.f46015g = r102;
        this.f46016h = 0.0f;
        this.f46017i = r103;
        this.f46018j = r104;
    }
}
