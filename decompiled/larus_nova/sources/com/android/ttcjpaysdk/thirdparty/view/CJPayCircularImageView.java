package com.android.ttcjpaysdk.thirdparty.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/view/CJPayCircularImageView;", "Landroid/widget/ImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderPaint", "Landroid/graphics/Paint;", SVGRenderEngine.CLIP_PATH, "Landroid/graphics/Path;", "strokeColor", "strokeWidth", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setupAttributes", "setupPaint", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCircularImageView extends ImageView {
    private final Paint borderPaint;
    private final Path clipPath;
    private int strokeColor;
    private float strokeWidth;

    public CJPayCircularImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJPayCircularImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final void setupPaint() {
        Paint r100 = this.borderPaint;
        r100.setStyle(Paint.Style.STROKE);
        r100.setColor(this.strokeColor);
        r100.setStrokeWidth(this.strokeWidth);
    }

    private final void setupAttributes(AttributeSet r100) {
        if (r100 == null) goto L5;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.border_color, R.attr.border_width}, 0, 0);
        this.strokeWidth = r101.getDimension(1, 0.0f);
        this.strokeColor = r101.getColor(0, 0);
        r101.recycle();
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = getWidth() / 2.0f;
        float r102 = getHeight() / 2.0f;
        float r103 = (Math.min(getWidth(), getHeight()) - this.strokeWidth) / 2.0f;
        this.clipPath.reset();
        this.clipPath.addCircle(r101, r102, r103, Path.Direction.CW);
        r100.clipPath(this.clipPath);
        super.onDraw(r100);
        if (this.strokeWidth > 0.0f) goto L5;
        return;
    L5:
        if (this.strokeColor == 0) goto L9;
        r100.drawCircle(r101, r102, r103, this.borderPaint);
        return;
    }

    public CJPayCircularImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.borderPaint = new Paint(1);
        this.clipPath = new Path();
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setupAttributes(r101);
        setupPaint();
    }

    public /* synthetic */ CJPayCircularImageView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
