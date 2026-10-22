package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

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
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ECRoundedConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "radius", "", "setRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECRoundedConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f170285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f170286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f170287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f170288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f170289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function2<? super Integer, ? super Integer, Unit> f170290f;

    public ECRoundedConstraintLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECRoundedConstraintLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void R5() {
        if (this.f170285a != 0.0f) goto L13;
        if (this.f170286b != 0.0f) goto L13;
        if (this.f170287c != 0.0f) goto L13;
        if (this.f170288d != 0.0f) goto L13;
        this.f170289e = null;
        return;
    L13:
        if (this.f170289e != null) goto L15;
        this.f170289e = new Path();
    L15:
        Path r100 = this.f170289e;
        if (r100 == null) goto L18;
        r100.reset();
    L18:
        RectF r101 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float r102 = this.f170285a;
        float r103 = this.f170286b;
        float r104 = this.f170287c;
        float r105 = this.f170288d;
        float[] r106 = {r102, r102, r103, r103, r104, r104, r105, r105};
        Path r107 = this.f170289e;
        if (r107 == null) goto L22;
        r107.addRoundRect(r101, r106, Path.Direction.CW);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f170289e != null) goto L6;
        super.dispatchDraw(r100);
        return;
    L6:
        r100.save();
        Path r101 = this.f170289e;
        if (r101 == null) goto L9;
        r100.clipPath(r101);
    L9:
        super.dispatchDraw(r100);
        r100.restore();
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f170289e != null) goto L6;
        super.draw(r100);
        return;
    L6:
        r100.save();
        Path r101 = this.f170289e;
        if (r101 == null) goto L9;
        r100.clipPath(r101);
    L9:
        super.draw(r100);
        r100.restore();
    }

    public final void setRadius(float r100) {
        this.f170285a = r100;
        this.f170286b = r100;
        this.f170287c = r100;
        this.f170288d = r100;
        R5();
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        Function2<? super Integer, ? super Integer, Unit> r102 = this.f170290f;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()));
        return;
    }

    public ECRoundedConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.left_rounded_radius, R.attr.rounded_radius}, r102, 0);
        if (r103.hasValue(1) == false) goto L5;
        float r104 = r103.getDimensionPixelOffset(1, 0);
        this.f170285a = r104;
        this.f170286b = r104;
        this.f170287c = r104;
        this.f170288d = r104;
    L5:
        r103.recycle();
    }

    public /* synthetic */ ECRoundedConstraintLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        R5();
    }
}
