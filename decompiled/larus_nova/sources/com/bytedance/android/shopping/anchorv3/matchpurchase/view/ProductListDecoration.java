package com.bytedance.android.shopping.anchorv3.matchpurchase.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/view/ProductListDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductListDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f165228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f165229b;

    public static final class a {
    }

    static {
    }

    public ProductListDecoration(float r100, int r101) {
        this.f165228a = r100;
        this.f165229b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 == null) goto L5;
        int r106 = r105.getItemCount();
    L6:
        int r107 = vf4.a.a(r102.getContext(), this.f165228a);
        int r108 = this.f165229b;
        if (r108 != 0) goto L14;
        if (r104 != 0) goto L11;
        r100.top = 0;
        r100.bottom = r107 / 2;
        return;
    L11:
        if (r104 != (r106 - 1)) goto L13;
        r100.top = r107 / 2;
        r100.bottom = 0;
        return;
    L13:
        int r109 = r107 / 2;
        r100.top = r109;
        r100.bottom = r109;
        return;
    L14:
        if (r108 != 1) goto L25;
        if (r104 != 0) goto L18;
        r100.left = 0;
        r100.right = r107 / 2;
        return;
    L18:
        if (r104 != (r106 - 1)) goto L20;
        r100.left = r107 / 2;
        r100.right = 0;
        return;
    L20:
        int r110 = r107 / 2;
        r100.left = r110;
        r100.right = r110;
        return;
    L25:
        return;
    L5:
        r106 = 0;
        goto L6
    }
}
