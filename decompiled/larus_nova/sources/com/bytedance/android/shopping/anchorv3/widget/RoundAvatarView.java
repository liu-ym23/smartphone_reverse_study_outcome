package com.bytedance.android.shopping.anchorv3.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/widget/RoundAvatarView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoundAvatarView extends SimpleDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f165595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f165596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f165597c;

    public RoundAvatarView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RoundAvatarView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = getWidth() / 2.0f;
        float r102 = getHeight() / 2.0f;
        float r103 = (getWidth() / 2.0f) - this.f165597c;
        Paint r104 = this.f165595a;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("paint");
    L5:
        r100.drawCircle(r101, r102, r103, r104);
    }

    public RoundAvatarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = r100.getResources().getColor(R.color.commerce_color_FFFFFF);
        int r104 = com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d));
        TypedArray r105 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.rav_stroke_width, R.attr.stroke_color});
        this.f165597c = r105.getColor(0, r104);
        this.f165596b = r105.getColor(1, r103);
        Paint r106 = new Paint();
        this.f165595a = r106;
        r106.setColor(this.f165596b);
        Paint r107 = this.f165595a;
        if (r107 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("paint");
    L5:
        r107.setStyle(Paint.Style.STROKE);
        Paint r108 = this.f165595a;
        if (r108 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("paint");
    L8:
        r108.setAntiAlias(true);
        Paint r109 = this.f165595a;
        if (r109 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("paint");
    L11:
        r109.setStrokeWidth(this.f165597c);
        r105.recycle();
    }

    public /* synthetic */ RoundAvatarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
