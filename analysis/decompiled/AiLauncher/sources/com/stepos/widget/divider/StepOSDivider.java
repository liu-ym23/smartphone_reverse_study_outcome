package com.stepos.widget.divider;

import Y8.t;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.ailauncher.container.wallpaper.a;
import com.stepos.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import n9.C4946a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\b\b\u0001\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\rJ\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0016\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/widget/divider/StepOSDivider;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "color", "LY8/t;", "setDividerColor", "(I)V", "start", a.PHASE_END, "setInsets", "(II)V", "px", "setThickness", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Lcom/stepos/widget/divider/StepOSDividerPainter;", "painter", "Lcom/stepos/widget/divider/StepOSDividerPainter;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSDivider extends View {
    private final StepOSDividerPainter painter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSDivider(Context context) {
        this(context, null, 0, 6, null);
        p.i(context, "context");
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        StepOSDividerPainter.drawInView$StepOSWidget_release$default(this.painter, canvas, getPaddingTop(), getWidth(), getLayoutDirection(), 0.0f, 16, null);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), Math.max(View.MeasureSpec.getMode(heightMeasureSpec) == 1073741824 ? View.MeasureSpec.getSize(heightMeasureSpec) : this.painter.getThickness() + getPaddingTop() + getPaddingBottom(), this.painter.getThickness()));
    }

    public final void setDividerColor(int color) {
        this.painter.setColor$StepOSWidget_release(color);
        invalidate();
    }

    public final void setInsets(int start, int end) {
        this.painter.setInsetStart$StepOSWidget_release(start);
        this.painter.setInsetEnd$StepOSWidget_release(end);
        invalidate();
    }

    public final void setThickness(int px) {
        if (px >= 0) {
            this.painter.setThickness$StepOSWidget_release(px);
            requestLayout();
        } else {
            throw new IllegalArgumentException(("divider thickness must be >= 0 but was " + px).toString());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSDivider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSDivider(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R.attr.steposDividerStyle : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSDivider(Context context, AttributeSet attributeSet, int i10) throws Exception {
        super(context, attributeSet, i10);
        p.i(context, "context");
        StepOSDividerPainter stepOSDividerPainter = new StepOSDividerPainter();
        this.painter = stepOSDividerPainter;
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSDivider, i10, 0);
        try {
            stepOSDividerPainter.setThickness$StepOSWidget_release(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSDivider_steposDividerHeight, resources.getDimensionPixelSize(R.dimen.stepos_divider_height)));
            stepOSDividerPainter.setInsetStart$StepOSWidget_release(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSDivider_steposDividerInsetStart, 0));
            stepOSDividerPainter.setInsetEnd$StepOSWidget_release(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSDivider_steposDividerInsetEnd, 0));
            stepOSDividerPainter.setColor$StepOSWidget_release(typedArrayObtainStyledAttributes.getColor(R.styleable.StepOSDivider_steposDividerColor, context.getColor(R.color.stepos_divider)));
            t tVar = t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
        } finally {
        }
    }
}
