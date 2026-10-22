package com.bytedance.android.shopping.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/widget/CustomDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f187219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f187220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f187221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f187222d;

    public final Context getContext() {
        return this.f187221c;
    }

    public CustomDividerItemDecoration(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f187221c = r100;
        this.f187222d = 1;
        this.f187220b = new Rect();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r110) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r110, "state");
        if (this.f187219a == null) goto L63;
        if (r101.getLayoutManager() != null) goto L7;
        return;
    L7:
        if (this.f187222d != 0) goto L36;
        r100.save();
        if (r101.getClipToPadding() == false) goto L11;
        int r111 = r101.getPaddingTop();
        int r102 = r101.getHeight() - r101.getPaddingBottom();
        r100.clipRect(r101.getPaddingLeft(), r111, r101.getWidth() - r101.getPaddingRight(), r102);
    L12:
        Iterator<T> r103 = com.bytedance.commerce.base.view.b.a(r101).iterator();
        int r104 = 0;
    L14:
        if (r103.hasNext() == false) goto L34;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        View r107 = (View) r105;
        if (r104 >= (r101.getChildCount() - 1)) goto L33;
        RecyclerView.LayoutManager r108 = r101.getLayoutManager();
        if (r108 == null) goto L23;
        r108.getDecoratedBoundsWithMargins(r107, this.f187220b);
    L23:
        int r109 = this.f187220b.right + MathKt.roundToInt(r107.getTranslationX());
        Drawable r112 = this.f187219a;
        if (r112 == null) goto L26;
        int r113 = r112.getIntrinsicWidth();
    L27:
        int r114 = r109 - r113;
        Drawable r115 = this.f187219a;
        if (r115 == null) goto L30;
        r115.setBounds(r114, r111, r109, r102);
    L30:
        Drawable r116 = this.f187219a;
        if (r116 == null) goto L33;
        r116.draw(r100);
        goto L33
    L26:
        r113 = 0;
    L33:
        r104 = r106;
        goto L14
    L34:
        r100.restore();
        goto L36
    L11:
        r102 = r101.getHeight();
        r111 = 0;
    L36:
        if (this.f187222d != 1) goto L73;
        r100.save();
        if (r101.getClipToPadding() == false) goto L40;
        int r117 = r101.getPaddingLeft();
        int r118 = r101.getWidth() - r101.getPaddingRight();
        r100.clipRect(r117, r101.getPaddingTop(), r118, r101.getHeight() - r101.getPaddingBottom());
    L41:
        Iterator<T> r119 = com.bytedance.commerce.base.view.b.a(r101).iterator();
        int r120 = 0;
    L43:
        if (r119.hasNext() == false) goto L60;
        Object r121 = r119.next();
        int r122 = r120 + 1;
        if (r120 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();
    L47:
        View r123 = (View) r121;
        if (r120 >= (r101.getChildCount() - 1)) goto L59;
        r101.getDecoratedBoundsWithMargins(r123, this.f187220b);
        int r124 = this.f187220b.bottom + MathKt.roundToInt(r123.getTranslationY());
        Drawable r125 = this.f187219a;
        if (r125 == null) goto L52;
        int r126 = r125.getIntrinsicHeight();
    L53:
        int r127 = r124 - r126;
        Drawable r128 = this.f187219a;
        if (r128 == null) goto L56;
        r128.setBounds(r117, r127, r118, r124);
    L56:
        Drawable r129 = this.f187219a;
        if (r129 == null) goto L59;
        r129.draw(r100);
        goto L59
    L52:
        r126 = 0;
    L59:
        r120 = r122;
        goto L43
    L60:
        r100.restore();
        return;
    L40:
        r118 = r101.getWidth();
        r117 = 0;
        goto L41
    L73:
        return;
    L63:
        throw new IllegalArgumentException("Drawable must not be null");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        Drawable r104 = this.f187219a;
        if (r104 != null) goto L7;
        r100.set(0, 0, 0, 0);
        return;
    L7:
        if (this.f187222d != 0) goto L13;
        if (r104 == null) goto L10;
        int r105 = r104.getIntrinsicWidth();
    L11:
        r100.set(0, 0, r105, 0);
        goto L13
    L10:
        r105 = 0;
    L13:
        if (this.f187222d != 1) goto L20;
        Drawable r106 = this.f187219a;
        if (r106 == null) goto L17;
        int r107 = r106.getIntrinsicHeight();
    L18:
        r100.set(0, 0, 0, r107);
        return;
    L17:
        r107 = 0;
        goto L18
    }
}
