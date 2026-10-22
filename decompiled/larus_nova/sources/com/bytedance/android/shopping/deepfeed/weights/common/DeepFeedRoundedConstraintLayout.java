package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/DeepFeedRoundedConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedRoundedConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f174201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f174202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f174203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f174204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f174205e;

    public DeepFeedRoundedConstraintLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedRoundedConstraintLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f174205e != null) goto L6;
        super.dispatchDraw(r100);
        return;
    L6:
        r100.save();
        Path r101 = this.f174205e;
        if (r101 == null) goto L9;
        r100.clipPath(r101);
    L9:
        super.dispatchDraw(r100);
        r100.restore();
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f174205e != null) goto L6;
        super.draw(r100);
        return;
    L6:
        r100.save();
        Path r101 = this.f174205e;
        if (r101 == null) goto L9;
        r100.clipPath(r101);
    L9:
        super.draw(r100);
        r100.restore();
    }

    public DeepFeedRoundedConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.left_rounded_radius, R.attr.rounded_radius}, r102, 0);
        if (r103.hasValue(1) == false) goto L5;
        float r104 = r103.getDimensionPixelOffset(1, 0);
        this.f174201a = r104;
        this.f174202b = r104;
        this.f174203c = r104;
        this.f174204d = r104;
    L5:
        r103.recycle();
    }

    public /* synthetic */ DeepFeedRoundedConstraintLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f174201a != 0.0f) goto L12;
        if (this.f174202b != 0.0f) goto L12;
        if (this.f174203c != 0.0f) goto L12;
        if (this.f174204d != 0.0f) goto L12;
        this.f174205e = null;
        return;
    L12:
        if (this.f174205e != null) goto L14;
        this.f174205e = new Path();
    L14:
        Path r104 = this.f174205e;
        if (r104 == null) goto L17;
        r104.reset();
    L17:
        RectF r105 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float r106 = this.f174201a;
        float r107 = this.f174202b;
        float r108 = this.f174203c;
        float r109 = this.f174204d;
        float[] r110 = {r106, r106, r107, r107, r108, r108, r109, r109};
        Path r111 = this.f174205e;
        if (r111 == null) goto L22;
        r111.addRoundRect(r105, r110, Path.Direction.CW);
        return;
    }
}
