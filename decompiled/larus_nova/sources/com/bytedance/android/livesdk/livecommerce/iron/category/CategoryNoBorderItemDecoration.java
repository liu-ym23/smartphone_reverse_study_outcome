package com.bytedance.android.livesdk.livecommerce.iron.category;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryNoBorderItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryNoBorderItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f148570a;

    public static final class a {
    }

    static {
    }

    public CategoryNoBorderItemDecoration() {
        this(2);
    }

    public CategoryNoBorderItemDecoration(int r100) {
        this.f148570a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        r100.top = 0;
        r100.bottom = 0;
        int r104 = r102.getChildAdapterPosition(r101);
        if (r104 != 0) goto L5;
        r100.left = UtilityKotlinExtentionsKt.d(Integer.valueOf(this.f148570a));
        r100.right = 0;
        return;
    L5:
        RecyclerView.LayoutManager r105 = r102.getLayoutManager();
        if (r105 == null) goto L8;
        int r106 = r105.getItemCount();
    L10:
        if (r104 != (r106 - 1)) goto L12;
        r100.left = 0;
        r100.right = UtilityKotlinExtentionsKt.d(Integer.valueOf(this.f148570a));
        return;
    L12:
        r100.left = 0;
        r100.right = 0;
        return;
    L8:
        r106 = 0;
        goto L10
    }
}
