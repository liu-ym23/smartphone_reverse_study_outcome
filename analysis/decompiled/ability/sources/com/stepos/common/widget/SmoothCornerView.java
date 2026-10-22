package com.stepos.common.widget;

import a5.AbstractC0301a;
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
import com.stepos.ability.R;
import com.stepos.aiengine.args.SingleFileBundle;
import g1.AbstractC1451a;
import kotlin.Metadata;

@RequiresApi(21)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u0001:\u0001SR$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR*\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010!\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010&\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\rR*\u0010*\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010$\"\u0004\b)\u0010\rR*\u0010.\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010$\"\u0004\b-\u0010\rR*\u00106\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0017\u0010<\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R*\u0010@\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0014\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010\u0018R\"\u0010D\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010$\"\u0004\bC\u0010\rR\u0017\u0010J\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR$\u0010M\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010\u0016\"\u0004\bL\u0010\u0018R\u0011\u0010O\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bN\u0010$R$\u0010R\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bP\u0010$\"\u0004\bQ\u0010\r¨\u0006T"}, d2 = {"Lcom/stepos/common/widget/SmoothCornerView;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Path;", "value", "a", "Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", SingleFileBundle.KEY_PATH, "", "c", "F", "setWidthFloat", "(F)V", "widthFloat", "d", "setHeightFloat", "heightFloat", "", "e", "Z", "getSmoothCornerEnable", "()Z", "setSmoothCornerEnable", "(Z)V", "smoothCornerEnable", "Lcom/stepos/common/widget/SmoothCornerView$SmoothGenMode;", "f", "Lcom/stepos/common/widget/SmoothCornerView$SmoothGenMode;", "getRenderMode", "()Lcom/stepos/common/widget/SmoothCornerView$SmoothGenMode;", "setRenderMode", "(Lcom/stepos/common/widget/SmoothCornerView$SmoothGenMode;)V", "renderMode", "i", "getSmoothness", "()F", "setSmoothness", "smoothness", "j", "getRadius", "setRadius", "radius", "k", "getStrokeWidthExt", "setStrokeWidthExt", "strokeWidthExt", "", "l", "I", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "strokeColor", "Landroid/graphics/Paint;", "m", "Landroid/graphics/Paint;", "getStrokePaint", "()Landroid/graphics/Paint;", "strokePaint", "n", "getAutoFitRadius", "setAutoFitRadius", "autoFitRadius", "o", "getRadiusRatio", "setRadiusRatio", "radiusRatio", "Landroid/database/ContentObserver;", "p", "Landroid/database/ContentObserver;", "getMContentObserver", "()Landroid/database/ContentObserver;", "mContentObserver", "getExactMode", "setExactMode", "exactMode", "getMaxSmoothRadius", "maxSmoothRadius", "getRadiusDp", "setRadiusDp", "radiusDp", "SmoothGenMode", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public class SmoothCornerView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Path path;
    public boolean b;

    /* renamed from: c, reason: from kotlin metadata */
    public float widthFloat;

    /* renamed from: d, reason: from kotlin metadata */
    public float heightFloat;

    /* renamed from: e, reason: from kotlin metadata */
    public boolean smoothCornerEnable;

    /* renamed from: f, reason: from kotlin metadata */
    public SmoothGenMode renderMode;
    public final ViewOutlineProvider g;
    public final boolean h;

    /* renamed from: i, reason: from kotlin metadata */
    public float smoothness;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public float radius;

    /* renamed from: k, reason: from kotlin metadata */
    public float strokeWidthExt;

    /* renamed from: l, reason: from kotlin metadata */
    public int strokeColor;

    /* renamed from: m, reason: from kotlin metadata */
    public final Paint strokePaint;

    /* renamed from: n, reason: from kotlin metadata */
    public boolean autoFitRadius;

    /* renamed from: o, reason: from kotlin metadata */
    public float radiusRatio;
    public final N p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/common/widget/SmoothCornerView$SmoothGenMode;", "", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SmoothGenMode {

        /* renamed from: a, reason: collision with root package name */
        public static final SmoothGenMode f3768a;
        public static final SmoothGenMode b;
        public static final /* synthetic */ SmoothGenMode[] c;

        static {
            SmoothGenMode smoothGenMode = new SmoothGenMode("ClipPath", 0);
            f3768a = smoothGenMode;
            SmoothGenMode smoothGenMode2 = new SmoothGenMode("ClearPixel", 1);
            b = smoothGenMode2;
            c = new SmoothGenMode[]{smoothGenMode, smoothGenMode2};
        }

        public static SmoothGenMode valueOf(String str) {
            return (SmoothGenMode) Enum.valueOf(SmoothGenMode.class, str);
        }

        public static SmoothGenMode[] values() {
            return (SmoothGenMode[]) c.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothCornerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        kotlin.jvm.internal.k.f(context, "context");
        this.path = new Path();
        this.smoothCornerEnable = true;
        this.renderMode = SmoothGenMode.b;
        this.g = getOutlineProvider();
        this.h = getClipToOutline();
        int[] iArr = V4.s.m;
        this.smoothness = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getFloat(2, 0.2f);
        this.radius = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getDimension(1, getResources().getDimension(R.dimen.fd_sys_radius_corner_none));
        this.strokeWidthExt = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getDimension(4, 0.0f);
        this.strokeColor = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getColor(3, getResources().getColor(R.color.fd_sys_color_outline_variant_default));
        Paint paint = new Paint();
        paint.setStrokeWidth(this.strokeWidthExt);
        paint.setColor(this.strokeColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        this.strokePaint = paint;
        this.autoFitRadius = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getBoolean(0, false);
        this.p = new N(this, context, getHandler());
        setRenderMode(SmoothGenMode.f3768a);
        setExactMode(true);
        this.radiusRatio = AbstractC0301a.a(context);
    }

    private final void setHeightFloat(float f) {
        if (this.heightFloat == f) {
            return;
        }
        this.heightFloat = f;
        this.b = true;
    }

    private final void setPath(Path path) {
        this.path = path;
        int iOrdinal = getRenderMode().ordinal();
        if (iOrdinal == 0) {
            this.path.setFillType(Path.FillType.WINDING);
        } else {
            if (iOrdinal != 1) {
                return;
            }
            this.path.setFillType(Path.FillType.INVERSE_WINDING);
        }
    }

    private final void setWidthFloat(float f) {
        if (this.widthFloat == f) {
            return;
        }
        this.widthFloat = f;
        this.b = true;
    }

    public final void a() {
        int iOrdinal = getRenderMode().ordinal();
        if (iOrdinal == 0) {
            invalidateOutline();
        } else {
            if (iOrdinal != 1) {
                return;
            }
            invalidate();
        }
    }

    public final void b(boolean z10, boolean z11) {
        float radius;
        if (this.b || z11) {
            if (this.autoFitRadius) {
                radius = Math.min(this.widthFloat, this.heightFloat) * this.radiusRatio;
            } else {
                radius = getRadius();
            }
            setPath(a5.j.a(0.0f, 0.0f, this.widthFloat, this.heightFloat, this.smoothness, radius, z10));
            this.b = false;
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        float radius;
        kotlin.jvm.internal.k.f(canvas, "canvas");
        if (!this.smoothCornerEnable) {
            super.draw(canvas);
            return;
        }
        super.draw(canvas);
        if (getRenderMode() == SmoothGenMode.b) {
            if (this.autoFitRadius) {
                radius = Math.min(this.widthFloat, this.heightFloat) * this.radiusRatio;
            } else {
                radius = getRadius();
            }
            b(this.autoFitRadius, false);
            Path path = this.path;
            a5.i iVar = a5.j.f1645a;
            canvas.drawPath(path, a5.j.b);
            Paint paint = this.strokePaint;
            float f = 2;
            Path pathA = a5.j.a((paint.getStrokeWidth() / f) + 0.0f, (paint.getStrokeWidth() / f) + 0.0f, this.widthFloat - (paint.getStrokeWidth() / f), this.heightFloat - (paint.getStrokeWidth() / f), this.smoothness, radius - (paint.getStrokeWidth() / f), this.autoFitRadius);
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

    public final ContentObserver getMContentObserver() {
        return this.p;
    }

    public final float getMaxSmoothRadius() {
        a5.i iVar = a5.j.f1645a;
        return a5.j.b(this.widthFloat, this.heightFloat, this.smoothness);
    }

    public final float getRadius() {
        return AbstractC1451a.t(this.radius, 0.0f, getMaxSmoothRadius());
    }

    public final float getRadiusDp() {
        Context context = getContext();
        kotlin.jvm.internal.k.e(context, "context");
        return getRadius() / context.getResources().getDisplayMetrics().density;
    }

    public final float getRadiusRatio() {
        return this.radiusRatio;
    }

    public final SmoothGenMode getRenderMode() {
        return this.strokePaint.getStrokeWidth() > 0.0f ? SmoothGenMode.b : this.renderMode;
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

    public final Paint getStrokePaint() {
        return this.strokePaint;
    }

    public final float getStrokeWidthExt() {
        return this.strokeWidthExt;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("current_launcher_icon_corner_size"), false, this.p);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.p);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        setWidthFloat(i);
        setHeightFloat(i6);
        if (getRenderMode() == SmoothGenMode.b) {
            b(this.autoFitRadius, false);
        }
    }

    public final void setAutoFitRadius(boolean z10) {
        if (z10 != this.autoFitRadius) {
            this.autoFitRadius = z10;
            a();
        }
    }

    public final void setExactMode(boolean z10) {
        if (z10) {
            setLayerType(2, null);
        } else {
            setLayerType(0, null);
        }
    }

    public final void setRadius(float f) {
        if (f == this.radius) {
            return;
        }
        this.b = true;
        this.radius = f;
        a();
    }

    public final void setRadiusDp(float f) {
        Context context = getContext();
        kotlin.jvm.internal.k.e(context, "context");
        setRadius(context.getResources().getDisplayMetrics().density * f);
    }

    public final void setRadiusRatio(float f) {
        this.radiusRatio = f;
    }

    public final void setRenderMode(SmoothGenMode value) {
        kotlin.jvm.internal.k.f(value, "value");
        this.renderMode = value;
        int iOrdinal = getRenderMode().ordinal();
        if (iOrdinal == 0) {
            setClipToOutline(true);
            setOutlineProvider(new A6.k(this, 2));
        } else if (iOrdinal == 1) {
            setWillNotDraw(false);
            setClipToOutline(this.h);
            setOutlineProvider(this.g);
        }
        int iOrdinal2 = getRenderMode().ordinal();
        if (iOrdinal2 == 0) {
            this.path.setFillType(Path.FillType.WINDING);
        } else if (iOrdinal2 == 1) {
            this.path.setFillType(Path.FillType.INVERSE_WINDING);
        }
        b(this.autoFitRadius, true);
        invalidate();
        invalidateOutline();
    }

    public final void setSmoothCornerEnable(boolean z10) {
        if (this.smoothCornerEnable != z10) {
            this.smoothCornerEnable = z10;
            this.b = true;
            invalidate();
        }
    }

    public final void setSmoothness(float f) {
        float fT = AbstractC1451a.t(f, 0.0f, 1.0f);
        if (fT == this.smoothness) {
            return;
        }
        this.b = true;
        this.smoothness = fT;
        a();
    }

    public final void setStrokeColor(int i) {
        if (i != this.strokeColor) {
            this.strokeColor = i;
            this.strokePaint.setColor(i);
            a();
        }
    }

    public final void setStrokeWidthExt(float f) {
        if (f == this.strokeWidthExt) {
            return;
        }
        this.strokeWidthExt = f;
        this.strokePaint.setStrokeWidth(f);
        a();
    }
}
