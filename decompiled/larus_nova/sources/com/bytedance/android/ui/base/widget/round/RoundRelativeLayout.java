package com.bytedance.android.ui.base.widget.round;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\fH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ui/base/widget/round/RoundRelativeLayout;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", SVGRenderEngine.CLIP_PATH, "Landroid/graphics/Path;", "needClip", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "getPath", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoundRelativeLayout extends RelativeLayout {
    private Path clipPath;
    private boolean needClip;

    private final Path getPath() {
        Path r100 = this.clipPath;
        if (r100 != null) goto L5;
        this.clipPath = new Path();
    L6:
        Path r101 = this.clipPath;
        Intrinsics.checkNotNull(r101);
        r101.reset();
        Drawable r102 = getBackground();
        if (r102 == null) goto L11;
        BackgroundDrawable r103 = (BackgroundDrawable) r102;
        Path r104 = this.clipPath;
        Intrinsics.checkNotNull(r104);
        r104.addRoundRect(new RectF(getBackground().getBounds()), new float[]{r103.getCornerRadiusTL(), r103.getCornerRadiusTL(), r103.getCornerRadiusTR(), r103.getCornerRadiusTR(), r103.getCornerRadiusBR(), r103.getCornerRadiusBR(), r103.getCornerRadiusBL(), r103.getCornerRadiusBL()}, Path.Direction.CW);
        Path r105 = this.clipPath;
        Intrinsics.checkNotNull(r105);
        return r105;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ui.base.widget.round.BackgroundDrawable");
    L5:
        Intrinsics.checkNotNull(r100);
        r100.reset();
        goto L6
    }

    public RoundRelativeLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.needClip == false) goto L5;
        int r101 = r100.save();
        r100.clipPath(getPath());
    L6:
        super.dispatchDraw(r100);
        if (this.needClip == false) goto L10;
        r100.restoreToCount(r101);
        return;
    L10:
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public RoundRelativeLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public RoundRelativeLayout(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        setBackground(new BackgroundDrawable(r100, r101, false, 4, null));
        if (r101 == null) goto L6;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.bg_color, R.attr.bg_colorOrientation, R.attr.bg_cornerRadius, R.attr.bg_cornerRadius_BL, R.attr.bg_cornerRadius_BR, R.attr.bg_cornerRadius_TL, R.attr.bg_cornerRadius_TR, R.attr.bg_endColor, R.attr.bg_startColor, R.attr.bg_strokeColor, R.attr.bg_strokeWidth, R.attr.rv_needClip});
        this.needClip = r102.getBoolean(11, this.needClip);
        r102.recycle();
        return;
    }
}
