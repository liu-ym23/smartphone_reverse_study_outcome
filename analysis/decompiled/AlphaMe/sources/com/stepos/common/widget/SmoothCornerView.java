package com.stepos.common.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import i2.AbstractC0620a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import m2.AbstractC0770a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(21)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001:\u0001\u001aR$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR*\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010!\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010&\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\rR*\u0010*\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010$\"\u0004\b)\u0010\rR*\u0010.\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010$\"\u0004\b-\u0010\rR*\u00106\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0017\u0010<\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R*\u0010@\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0014\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010\u0018R\"\u0010D\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010$\"\u0004\bC\u0010\rR\u0017\u0010J\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR$\u0010M\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010\u0016\"\u0004\bL\u0010\u0018R\u0011\u0010O\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bN\u0010$R$\u0010R\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bP\u0010$\"\u0004\bQ\u0010\r¨\u0006S"}, d2 = {"Lcom/stepos/common/widget/SmoothCornerView;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Path;", "value", "a", "Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", "path", "", "c", "F", "setWidthFloat", "(F)V", "widthFloat", DateTokenConverter.CONVERTER_KEY, "setHeightFloat", "heightFloat", "", "e", "Z", "getSmoothCornerEnable", "()Z", "setSmoothCornerEnable", "(Z)V", "smoothCornerEnable", "Lcom/stepos/common/widget/H;", "f", "Lcom/stepos/common/widget/H;", "getRenderMode", "()Lcom/stepos/common/widget/H;", "setRenderMode", "(Lcom/stepos/common/widget/H;)V", "renderMode", IntegerTokenConverter.CONVERTER_KEY, "getSmoothness", "()F", "setSmoothness", "smoothness", "j", "getRadius", "setRadius", "radius", "k", "getStrokeWidthExt", "setStrokeWidthExt", "strokeWidthExt", "", "l", "I", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "strokeColor", "Landroid/graphics/Paint;", ANSIConstants.ESC_END, "Landroid/graphics/Paint;", "getStrokePaint", "()Landroid/graphics/Paint;", "strokePaint", "n", "getAutoFitRadius", "setAutoFitRadius", "autoFitRadius", "o", "getRadiusRatio", "setRadiusRatio", "radiusRatio", "Landroid/database/ContentObserver;", "p", "Landroid/database/ContentObserver;", "getMContentObserver", "()Landroid/database/ContentObserver;", "mContentObserver", "getExactMode", "setExactMode", "exactMode", "getMaxSmoothRadius", "maxSmoothRadius", "getRadiusDp", "setRadiusDp", "radiusDp", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public class SmoothCornerView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Path path;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11784b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public float widthFloat;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float heightFloat;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean smoothCornerEnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public H renderMode;

    /* renamed from: g, reason: collision with root package name */
    public final ViewOutlineProvider f11789g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f11790h;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public float smoothness;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public float radius;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public float strokeWidthExt;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public int strokeColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final Paint strokePaint;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public boolean autoFitRadius;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public float radiusRatio;

    /* renamed from: p, reason: collision with root package name */
    public final J f11798p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmoothCornerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        this.smoothCornerEnable = true;
        this.renderMode = H.f11630b;
        this.f11789g = getOutlineProvider();
        this.f11790h = getClipToOutline();
        int[] iArr = AbstractC0620a.f13031m;
        this.smoothness = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getFloat(2, 0.2f);
        this.radius = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getDimension(1, getResources().getDimension(R.dimen.fd_sys_radius_corner_none));
        this.strokeWidthExt = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getDimension(4, Property.DEFAULT_FLOAT_VALUE);
        this.strokeColor = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getColor(3, getResources().getColor(R.color.fd_sys_color_outline_variant_default));
        Paint paint = new Paint();
        paint.setStrokeWidth(this.strokeWidthExt);
        paint.setColor(this.strokeColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        this.strokePaint = paint;
        this.autoFitRadius = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getBoolean(0, false);
        this.f11798p = new J(this, context, getHandler());
        setRenderMode(H.f11629a);
        setExactMode(true);
        this.radiusRatio = AbstractC0770a.a(context);
    }

    private final void setHeightFloat(float f4) {
        if (this.heightFloat == f4) {
            return;
        }
        this.heightFloat = f4;
        this.f11784b = true;
    }

    private final void setPath(Path path) {
        this.path = path;
        a();
    }

    private final void setWidthFloat(float f4) {
        if (this.widthFloat == f4) {
            return;
        }
        this.widthFloat = f4;
        this.f11784b = true;
    }

    public final void a() {
        int i4 = I.$EnumSwitchMapping$0[getRenderMode().ordinal()];
        if (i4 == 1) {
            this.path.setFillType(Path.FillType.WINDING);
        } else {
            if (i4 != 2) {
                return;
            }
            this.path.setFillType(Path.FillType.INVERSE_WINDING);
        }
    }

    public final void b() {
        int i4 = I.$EnumSwitchMapping$0[getRenderMode().ordinal()];
        if (i4 == 1) {
            invalidateOutline();
        } else {
            if (i4 != 2) {
                return;
            }
            invalidate();
        }
    }

    public final void c(boolean z4, boolean z5) {
        float radius;
        if (this.f11784b || z5) {
            if (this.autoFitRadius) {
                radius = Math.min(this.widthFloat, this.heightFloat) * this.radiusRatio;
            } else {
                radius = getRadius();
            }
            setPath(m2.m.a(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, this.widthFloat, this.heightFloat, this.smoothness, radius, z4));
            this.f11784b = false;
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        float radius;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.smoothCornerEnable) {
            super.draw(canvas);
            return;
        }
        super.draw(canvas);
        if (getRenderMode() == H.f11630b) {
            if (this.autoFitRadius) {
                radius = Math.min(this.widthFloat, this.heightFloat) * this.radiusRatio;
            } else {
                radius = getRadius();
            }
            c(this.autoFitRadius, false);
            Path path = this.path;
            m2.l lVar = m2.m.f13583a;
            canvas.drawPath(path, m2.m.f13584b);
            Paint paint = this.strokePaint;
            float f4 = 2;
            Path pathA = m2.m.a((paint.getStrokeWidth() / f4) + Property.DEFAULT_FLOAT_VALUE, (paint.getStrokeWidth() / f4) + Property.DEFAULT_FLOAT_VALUE, this.widthFloat - (paint.getStrokeWidth() / f4), this.heightFloat - (paint.getStrokeWidth() / f4), this.smoothness, radius - (paint.getStrokeWidth() / f4), this.autoFitRadius);
            pathA.setFillType(Path.FillType.WINDING);
            canvas.drawPath(pathA, paint);
        }
    }

    public final boolean getAutoFitRadius() {
        return this.autoFitRadius;
    }

    public final boolean getExactMode() {
        return getLayerType() == 2;
    }

    @NotNull
    public final ContentObserver getMContentObserver() {
        return this.f11798p;
    }

    public final float getMaxSmoothRadius() {
        m2.l lVar = m2.m.f13583a;
        return m2.m.b(this.widthFloat, this.heightFloat, this.smoothness);
    }

    public final float getRadius() {
        return RangesKt___RangesKt.coerceIn(this.radius, Property.DEFAULT_FLOAT_VALUE, getMaxSmoothRadius());
    }

    public final float getRadiusDp() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        float radius = getRadius();
        Intrinsics.checkNotNullParameter(context, "<this>");
        float f4 = context.getResources().getDisplayMetrics().density;
        Intrinsics.checkNotNullParameter(context, "<this>");
        return radius / f4;
    }

    public final float getRadiusRatio() {
        return this.radiusRatio;
    }

    @NotNull
    public final H getRenderMode() {
        return this.strokePaint.getStrokeWidth() > Property.DEFAULT_FLOAT_VALUE ? H.f11630b : this.renderMode;
    }

    public final boolean getSmoothCornerEnable() {
        return this.smoothCornerEnable;
    }

    public final float getSmoothness() {
        return this.smoothness;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    @NotNull
    public final Paint getStrokePaint() {
        return this.strokePaint;
    }

    public final float getStrokeWidthExt() {
        return this.strokeWidthExt;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("current_launcher_icon_corner_size"), false, this.f11798p);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.f11798p);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        setWidthFloat(i4);
        setHeightFloat(i5);
        if (getRenderMode() == H.f11630b) {
            c(this.autoFitRadius, false);
        }
    }

    public final void setAutoFitRadius(boolean z4) {
        if (z4 != this.autoFitRadius) {
            this.autoFitRadius = z4;
            b();
        }
    }

    public final void setExactMode(boolean z4) {
        if (z4) {
            setLayerType(2, null);
        } else {
            setLayerType(0, null);
        }
    }

    public final void setRadius(float f4) {
        if (f4 == this.radius) {
            return;
        }
        this.f11784b = true;
        this.radius = f4;
        b();
    }

    public final void setRadiusDp(float f4) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullParameter(context, "<this>");
        float f5 = context.getResources().getDisplayMetrics().density;
        Intrinsics.checkNotNullParameter(context, "<this>");
        setRadius(f5 * f4);
    }

    public final void setRadiusRatio(float f4) {
        this.radiusRatio = f4;
    }

    public final void setRenderMode(@NotNull H value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.renderMode = value;
        int iOrdinal = getRenderMode().ordinal();
        int i4 = 1;
        if (iOrdinal == 0) {
            setClipToOutline(true);
            setOutlineProvider(new r1.c(i4, this));
        } else if (iOrdinal == 1) {
            setWillNotDraw(false);
            setClipToOutline(this.f11790h);
            setOutlineProvider(this.f11789g);
        }
        a();
        c(this.autoFitRadius, true);
        invalidate();
        invalidateOutline();
    }

    public final void setSmoothCornerEnable(boolean z4) {
        if (this.smoothCornerEnable != z4) {
            this.smoothCornerEnable = z4;
            this.f11784b = true;
            invalidate();
        }
    }

    public final void setSmoothness(float f4) {
        float fCoerceIn = RangesKt___RangesKt.coerceIn(f4, Property.DEFAULT_FLOAT_VALUE, 1.0f);
        if (fCoerceIn == this.smoothness) {
            return;
        }
        this.f11784b = true;
        this.smoothness = fCoerceIn;
        b();
    }

    public final void setStrokeColor(int i4) {
        if (i4 != this.strokeColor) {
            this.strokeColor = i4;
            this.strokePaint.setColor(i4);
            b();
        }
    }

    public final void setStrokeWidthExt(float f4) {
        if (f4 == this.strokeWidthExt) {
            return;
        }
        this.strokeWidthExt = f4;
        this.strokePaint.setStrokeWidth(f4);
        b();
    }
}
