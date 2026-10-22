package com.bytedance.android.ec.window.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/window/base/widget/WindowRoundedLinearLayout;", "Landroid/widget/LinearLayout;", "", "radius", "", "setRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class WindowRoundedLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f49923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f49924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f49925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f49926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f49927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f49928f;

    public WindowRoundedLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public WindowRoundedLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = getWidth();
        int r102 = getHeight();
        Path r103 = null;
        if (r101 <= 0) goto L24;
        if (r102 <= 0) goto L24;
        if (this.f49923a > 0.0f) goto L16;
        if (this.f49924b > 0.0f) goto L16;
        if (this.f49925c > 0.0f) goto L16;
        if (this.f49926d <= 0.0f) goto L24;
    L16:
        if (this.f49928f == true) goto L20;
        r103 = this.f49927e;
        if (r103 != null) goto L24;
    L20:
        r103 = this.f49927e;
        if (r103 != null) goto L23;
        r103 = new Path();
        this.f49927e = r103;
    L23:
        r103.reset();
        RectF r104 = new RectF(0.0f, 0.0f, r101, r102);
        float r105 = this.f49923a;
        float r106 = this.f49924b;
        float r107 = this.f49925c;
        float r108 = this.f49926d;
        r103.addRoundRect(r104, new float[]{r105, r105, r106, r106, r107, r107, r108, r108}, Path.Direction.CW);
        this.f49928f = false;
    L24:
        if (r103 != null) goto L27;
        super.draw(r100);
        return;
    L27:
        int r109 = r100.save();
        r100.clipPath(r103);
        super.draw(r100);
        r100.restoreToCount(r109);
    }

    public final void setRadius(float r100) {
        a(r100, r100, r100, r100);
    }

    public WindowRoundedLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f49928f = true;
        if (r101 == null) goto L6;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.window_rounded_radius, R.attr.window_rounded_radius_bottom_left, R.attr.window_rounded_radius_bottom_right, R.attr.window_rounded_radius_top_left, R.attr.window_rounded_radius_top_right});
        float r104 = r103.getDimension(0, 0.0f);
        this.f49923a = r103.getDimension(3, r104);
        this.f49924b = r103.getDimension(4, r104);
        this.f49925c = r103.getDimension(2, r104);
        this.f49926d = r103.getDimension(1, r104);
        r103.recycle();
        return;
    }

    public /* synthetic */ WindowRoundedLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(float r100, float r101, float r102, float r103) {
        if (this.f49923a == r100) goto L5;
    L11:
        this.f49923a = r100;
        this.f49924b = r101;
        this.f49925c = r102;
        this.f49926d = r103;
        this.f49928f = true;
        invalidate();
        return;
    L5:
        if (this.f49924b != r101) goto L11;
        if (this.f49925c != r102) goto L11;
        if (this.f49926d != r103) goto L11;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f49928f = true;
    }
}
