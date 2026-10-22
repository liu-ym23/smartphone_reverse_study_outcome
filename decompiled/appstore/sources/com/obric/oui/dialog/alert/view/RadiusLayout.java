package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import bg.h;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.l;
import com.obric.oui.material.o;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010 \u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0014¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b(\u0010'J\u001f\u0010+\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0014¢\u0006\u0004\b+\u0010#J7\u00101\u001a\u00020\f2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\u0014¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\fH\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b5\u0010'J\u0017\u00106\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b6\u0010'R\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00107R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010:R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00107R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010>R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010AR\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010DR\u0016\u0010H\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\"\u0010M\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010G\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010\u0011R\"\u0010R\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u00107\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010\u000eR\u0016\u0010T\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u00107R\u0016\u0010V\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u00107R\u0014\u0010Y\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006Z"}, d2 = {"Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "suppress", "", "setSuppressChildMeasureAndLayout", "(Z)V", "color", "setBackgroundColor", "(I)V", "", "r", "setRadius", "(F)V", "lt", "rt", "lb", "rb", "c", "(FFFF)V", "strokeColor", "strokeWidth", "strokeDash", "strokeGap", "e", "(IIII)V", "d", "(II)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "draw", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "f", "()V", "a", "b", "Z", "showStroke", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "strokePaint", "hasStroke", "", "[F", "radiusArray", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "outRectF", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "outPath", "g", "I", "backgroundColor", "h", "getMaxHeight", "()I", "setMaxHeight", "maxHeight", "i", "getMeasureHeightUnspecified", "()Z", "setMeasureHeightUnspecified", "measureHeightUnspecified", "j", "suppressChildMeasureAndLayout", "k", "enableMaterial", "l", "F", "materialEdgeWidth", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class RadiusLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f14331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f14333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f14334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f14335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f14341l;

    @JvmOverloads
    public RadiusLayout(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void a(Canvas r10) {
        this.f14334e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f14334e.inset(0.0f, this.f14341l);
        this.f14335f.reset();
        Path r11 = this.f14335f;
        RectF r12 = this.f14334e;
        float[] r13 = this.f14333d;
        if (r13 != null) goto L5;
        q.y("radiusArray");
        r13 = null;
    L5:
        r11.addRoundRect(r12, r13, Path.Direction.CW);
        r10.clipPath(this.f14335f);
    }

    public final void b(Canvas r10) {
        Paint r11 = this.f14331b;
        if (r11 != null) goto L5;
        return;
    L5:
        this.f14334e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f14335f.reset();
        l r12 = l.f13087a;
        Path r13 = this.f14335f;
        RectF r14 = this.f14334e;
        float[] r15 = this.f14333d;
        if (r15 != null) goto L8;
        q.y("radiusArray");
        r15 = null;
    L8:
        r12.b(r13, r14, r15, Path.Direction.CW);
        r10.drawPath(this.f14335f, r11);
    }

    public final void c(float r10, float r11, float r12, float r13) {
        this.f14333d = new float[]{r10, r10, r11, r11, r13, r13, r12, r12};
        f();
        invalidate();
    }

    public final void d(int r10, int r11) {
        Paint r12 = new Paint();
        boolean r13 = true;
        r12.setAntiAlias(true);
        r12.setColor(r10);
        r12.setStyle(Paint.Style.STROKE);
        r12.setStrokeWidth(r11);
        this.f14331b = r12;
        if ((r10 & (-16777216)) == 0) goto L6;
        if (r11 == 0) goto L6;
    L7:
        this.f14332c = r13;
        invalidate();
        return;
    L6:
        r13 = false;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        q.g(r10, "canvas");
        if (this.f14340k == false) goto L5;
        a(r10);
    L5:
        super.dispatchDraw(r10);
        if (this.f14332c == true) goto L8;
        return;
    L8:
        if (this.f14330a == false) goto L12;
        b(r10);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        q.g(r10, "canvas");
        super.draw(r10);
    }

    public final void e(int r10, int r11, int r12, int r13) {
        boolean r14 = false;
        Paint r15 = new Paint();
        r15.setAntiAlias(true);
        r15.setColor(r10);
        r15.setStyle(Paint.Style.STROKE);
        if (r12 == 0) goto L6;
        if (r13 == 0) goto L6;
        r15.setPathEffect(new DashPathEffect(new float[]{r12, r13}, 0.0f));
    L6:
        r15.setStrokeWidth(r11);
        this.f14331b = r15;
        if ((r10 & (-16777216)) == 0) goto L10;
        if (r11 == 0) goto L10;
        r14 = true;
    L10:
        this.f14332c = r14;
        invalidate();
    }

    public final void f() {
        GradientDrawable r10 = new GradientDrawable();
        r10.setShape(0);
        float[] r11 = this.f14333d;
        if (r11 != null) goto L5;
        q.y("radiusArray");
        r11 = null;
    L5:
        r10.setCornerRadii(r11);
        r10.setColor(ColorStateList.valueOf(this.f14336g));
        setBackground(r10);
    }

    public final int getMaxHeight() {
        return this.f14337h;
    }

    public final boolean getMeasureHeightUnspecified() {
        return this.f14338i;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (this.f14339j == false) goto L5;
        return;
    L5:
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.f14339j == false) goto L14;
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = View.MeasureSpec.getMode(r11);
        int r15 = View.MeasureSpec.getSize(r11);
        if (r12 == Integer.MIN_VALUE) goto L8;
        if (r12 == 1073741824) goto L8;
        r13 = h.d(getMeasuredWidth(), getSuggestedMinimumWidth());
    L8:
        if (r14 == Integer.MIN_VALUE) goto L11;
        if (r14 == 1073741824) goto L11;
        r15 = h.d(getMeasuredHeight(), getSuggestedMinimumHeight());
    L11:
        setMeasuredDimension(r13, r15);
        return;
    L14:
        if (this.f14338i == false) goto L19;
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r16 = getMeasuredHeight();
        int r17 = this.f14337h;
        if (1 > r17) goto L21;
        if (r17 >= r16) goto L22;
        setMeasuredDimension(getMeasuredWidth(), this.f14337h);
        return;
    L22:
        return;
    L21:
        return;
    L19:
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        super.setBackgroundColor(r10);
        this.f14336g = r10;
        f();
    }

    public final void setMaxHeight(int r10) {
        this.f14337h = r10;
    }

    public final void setMeasureHeightUnspecified(boolean r10) {
        this.f14338i = r10;
    }

    public final void setRadius(float r10) {
        c(r10, r10, r10, r10);
    }

    public final void setSuppressChildMeasureAndLayout(boolean r10) {
        if (this.f14339j != r10) goto L5;
        return;
    L5:
        this.f14339j = r10;
        if (r10 == true) goto L9;
        requestLayout();
        invalidate();
        return;
    }

    @JvmOverloads
    public RadiusLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ RadiusLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public RadiusLayout(@NotNull Context r11, @Nullable AttributeSet r12, int r13) {
        q.g(r11, "context");
        super(r11, r12, r13);
        this.f14330a = true;
        this.f14334e = new RectF();
        this.f14335f = new Path();
        this.f14340k = o.f(this);
        this.f14341l = 3.0f;
        if ((getBackground() instanceof ColorDrawable) == false) goto L9;
        Drawable r10 = getBackground();
        if (r10 == null) goto L8;
        int r14 = ((ColorDrawable) r10).getColor();
    L10:
        this.f14336g = r14;
        TypedArray r15 = r11.obtainStyledAttributes(r12, R$styleable.ORadiusLayout, r13, 0);
        q.f(r15, "context.obtainStyledAttr…sLayout, defStyleAttr, 0)");
        float r16 = r15.getDimension(R$styleable.ORadiusLayout_oui_cornerRadius, 0.0f);
        float r17 = r15.getDimension(R$styleable.ORadiusLayout_oui_cornerRadiusLeftTop, r16);
        float r18 = r15.getDimension(R$styleable.ORadiusLayout_oui_cornerRadiusRightTop, r16);
        float r19 = r15.getDimension(R$styleable.ORadiusLayout_oui_cornerRadiusLeftBottom, r16);
        float r20 = r15.getDimension(R$styleable.ORadiusLayout_oui_cornerRadiusRightBottom, r16);
        int r21 = r15.getColor(R$styleable.ORadiusLayout_oui_radiusStrokeColor, -16777216);
        int r22 = r15.getDimensionPixelOffset(R$styleable.ORadiusLayout_oui_radiusStrokeWidth, 0);
        int r23 = r15.getDimensionPixelOffset(R$styleable.ORadiusLayout_oui_radiusStrokeDashWidth, 0);
        int r24 = r15.getDimensionPixelOffset(R$styleable.ORadiusLayout_oui_radiusStrokeDashGapWidth, 0);
        if (r16 != 0.0f) goto L13;
        c(r17, r18, r19, r20);
    L14:
        e(r21, r22, r23, r24);
        r15.recycle();
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        setClipToOutline(true);
        return;
    L13:
        setRadius(r16);
        goto L14
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L9:
        r14 = 0;
        goto L10
    }
}
