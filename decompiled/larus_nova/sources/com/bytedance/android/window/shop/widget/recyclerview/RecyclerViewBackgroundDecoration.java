package com.bytedance.android.window.shop.widget.recyclerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import gr3.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/widget/recyclerview/RecyclerViewBackgroundDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewBackgroundDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f190108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f190109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f190110c;

    public static final class a {
    }

    static {
    }

    public RecyclerViewBackgroundDecoration() {
        this.f190109b = new Rect();
        Paint r100 = new Paint();
        r100.setAntiAlias(true);
        r100.setStyle(Paint.Style.FILL_AND_STROKE);
        Unit r101 = Unit.INSTANCE;
        this.f190110c = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r110) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r110, "state");
        super.onDraw(r100, r101, r110);
        if (this.f190108a != 0) goto L5;
        this.f190108a = r101.getPaddingLeft();
        r101.getPaddingRight();
    L5:
        int r111 = r101.getChildCount();
        int r102 = 0;
    L6:
        if (r102 >= r111) goto L22;
        View r103 = r101.getChildAt(r102);
        Object r104 = r103.getTag(R.id.ec_shop_recycler_view_background_drawer);
        Object r105 = null;
        if ((r104 instanceof gr3.a) == true) goto L10;
        r104 = null;
    L10:
        gr3.a r106 = (gr3.a) r104;
        if (r106 == null) goto L21;
        Object r107 = r103.getTag(R.id.ec_shop_recycler_view_background_drawer_cutter);
        if ((r107 instanceof b) == false) goto L17;
        r105 = r107;
    L17:
        b r108 = (b) r105;
        if (r108 == null) goto L21;
        r101.getDecoratedBoundsWithMargins(r103, this.f190109b);
        this.f190109b.left += com.bytedance.android.shopping.extensions.b.b(Float.valueOf(12.0f));
        this.f190109b.right -= com.bytedance.android.shopping.extensions.b.b(Float.valueOf(12.0f));
        r106.a(r100, this.f190109b, this.f190110c, r108);
    L21:
        r102 = r102 + 1;
        goto L6
    }
}
