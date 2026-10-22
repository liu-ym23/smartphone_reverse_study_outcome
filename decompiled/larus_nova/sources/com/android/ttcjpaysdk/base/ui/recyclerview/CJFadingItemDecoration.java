package com.android.ttcjpaysdk.base.ui.recyclerview;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/recyclerview/CJFadingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "fadingEdgeLength", "", "paint", "Landroid/graphics/Paint;", "onDrawOver", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJFadingItemDecoration extends RecyclerView.ItemDecoration {
    private int fadingEdgeLength;
    private final Paint paint;

    public CJFadingItemDecoration() {
        this.fadingEdgeLength = CJPayBasicExtensionKt.dp(20);
        Paint r100 = new Paint();
        r100.setAntiAlias(true);
        this.paint = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        super.onDrawOver(r110, r111, r112);
        int r100 = r111.getHeight();
        int r101 = r111.getChildCount();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L6;
        r103 = r103 + r111.getChildAt(r102).getHeight();
        r102 = r102 + 1;
        goto L3
    L6:
        if ((r103 + (r111.getPaddingTop() + r111.getPaddingBottom())) > r100) goto L8;
        return;
    L8:
        float r113 = r100 - this.fadingEdgeLength;
        float r104 = r100;
        this.paint.setShader(new LinearGradient(0.0f, r113, 0.0f, r104, new int[]{16777215, -1}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
        r110.drawRoundRect(0.0f, r113, r111.getWidth(), r104, CJPayBasicExtensionKt.dp(8), CJPayBasicExtensionKt.dp(8), this.paint);
    }
}
