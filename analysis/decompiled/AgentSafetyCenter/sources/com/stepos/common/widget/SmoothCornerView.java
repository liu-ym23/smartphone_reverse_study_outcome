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
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class SmoothCornerView extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public Path f2624c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2625f;

    /* renamed from: g, reason: collision with root package name */
    public float f2626g;

    /* renamed from: h, reason: collision with root package name */
    public float f2627h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public j f2628j;

    /* renamed from: k, reason: collision with root package name */
    public final ViewOutlineProvider f2629k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f2630l;

    /* renamed from: m, reason: collision with root package name */
    public float f2631m;

    /* renamed from: n, reason: collision with root package name */
    public float f2632n;

    /* renamed from: o, reason: collision with root package name */
    public float f2633o;

    /* renamed from: p, reason: collision with root package name */
    public int f2634p;

    /* renamed from: q, reason: collision with root package name */
    public final Paint f2635q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2636r;

    /* renamed from: s, reason: collision with root package name */
    public float f2637s;

    /* renamed from: t, reason: collision with root package name */
    public final k f2638t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothCornerView(Context context, AttributeSet attributeSet, int i, int i3) {
        super(context, attributeSet, i, i3);
        context.getClass();
        this.f2624c = new Path();
        this.i = true;
        this.f2628j = j.f2720f;
        this.f2629k = getOutlineProvider();
        this.f2630l = getClipToOutline();
        int[] iArr = q9.a.f10204g;
        this.f2631m = context.obtainStyledAttributes(attributeSet, iArr, i, i3).getFloat(2, 0.2f);
        this.f2632n = context.obtainStyledAttributes(attributeSet, iArr, i, i3).getDimension(1, getResources().getDimension(R.dimen.fd_sys_radius_corner_none));
        this.f2633o = context.obtainStyledAttributes(attributeSet, iArr, i, i3).getDimension(4, 0.0f);
        this.f2634p = context.obtainStyledAttributes(attributeSet, iArr, i, i3).getColor(3, getResources().getColor(R.color.fd_sys_color_outline_variant_default));
        Paint paint = new Paint();
        paint.setStrokeWidth(this.f2633o);
        paint.setColor(this.f2634p);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        this.f2635q = paint;
        this.f2636r = context.obtainStyledAttributes(attributeSet, iArr, i, i3).getBoolean(0, false);
        this.f2638t = new k(this, context, getHandler());
        setRenderMode(j.f2719c);
        setExactMode(true);
        this.f2637s = u9.a.a(context);
    }

    private final void setHeightFloat(float f5) {
        if (this.f2627h == f5) {
            return;
        }
        this.f2627h = f5;
        this.f2625f = true;
    }

    private final void setPath(Path path) {
        this.f2624c = path;
        int iOrdinal = getRenderMode().ordinal();
        if (iOrdinal == 0) {
            this.f2624c.setFillType(Path.FillType.WINDING);
        } else {
            if (iOrdinal != 1) {
                return;
            }
            this.f2624c.setFillType(Path.FillType.INVERSE_WINDING);
        }
    }

    private final void setWidthFloat(float f5) {
        if (this.f2626g == f5) {
            return;
        }
        this.f2626g = f5;
        this.f2625f = true;
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
        if (this.f2625f || z11) {
            if (this.f2636r) {
                radius = Math.min(this.f2626g, this.f2627h) * this.f2637s;
            } else {
                radius = getRadius();
            }
            setPath(u9.j.a(0.0f, 0.0f, this.f2626g, this.f2627h, this.f2631m, radius, z10));
            this.f2625f = false;
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        float radius;
        canvas.getClass();
        if (!this.i) {
            super.draw(canvas);
            return;
        }
        super.draw(canvas);
        if (getRenderMode() == j.f2720f) {
            if (this.f2636r) {
                radius = Math.min(this.f2626g, this.f2627h) * this.f2637s;
            } else {
                radius = getRadius();
            }
            b(this.f2636r, false);
            Path path = this.f2624c;
            u9.i iVar = u9.j.f14273a;
            canvas.drawPath(path, u9.j.f14274b);
            Paint paint = this.f2635q;
            float f5 = 2;
            Path pathA = u9.j.a((paint.getStrokeWidth() / f5) + 0.0f, (paint.getStrokeWidth() / f5) + 0.0f, this.f2626g - (paint.getStrokeWidth() / f5), this.f2627h - (paint.getStrokeWidth() / f5), this.f2631m, radius - (paint.getStrokeWidth() / f5), this.f2636r);
            pathA.setFillType(Path.FillType.WINDING);
            canvas.drawPath(pathA, paint);
        }
    }

    public final boolean getAutoFitRadius() {
        return this.f2636r;
    }

    public final boolean getExactMode() {
        return getLayerType() == 2;
    }

    public final ContentObserver getMContentObserver() {
        return this.f2638t;
    }

    public final float getMaxSmoothRadius() {
        u9.i iVar = u9.j.f14273a;
        return u9.j.b(this.f2626g, this.f2627h, this.f2631m);
    }

    public final float getRadius() {
        return p5.f.p(this.f2632n, 0.0f, getMaxSmoothRadius());
    }

    public final float getRadiusDp() {
        Context context = getContext();
        context.getClass();
        return getRadius() / context.getResources().getDisplayMetrics().density;
    }

    public final float getRadiusRatio() {
        return this.f2637s;
    }

    public final j getRenderMode() {
        return this.f2635q.getStrokeWidth() > 0.0f ? j.f2720f : this.f2628j;
    }

    public final boolean getSmoothCornerEnable() {
        return this.i;
    }

    public final float getSmoothness() {
        return this.f2631m;
    }

    public final int getStrokeColor() {
        return this.f2634p;
    }

    public final Paint getStrokePaint() {
        return this.f2635q;
    }

    public final float getStrokeWidthExt() {
        return this.f2633o;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("current_launcher_icon_corner_size"), false, this.f2638t);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.f2638t);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i3, int i10, int i11) {
        super.onSizeChanged(i, i3, i10, i11);
        setWidthFloat(i);
        setHeightFloat(i3);
        if (getRenderMode() == j.f2720f) {
            b(this.f2636r, false);
        }
    }

    public final void setAutoFitRadius(boolean z10) {
        if (z10 != this.f2636r) {
            this.f2636r = z10;
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

    public final void setRadius(float f5) {
        if (f5 == this.f2632n) {
            return;
        }
        this.f2625f = true;
        this.f2632n = f5;
        a();
    }

    public final void setRadiusDp(float f5) {
        Context context = getContext();
        context.getClass();
        setRadius(context.getResources().getDisplayMetrics().density * f5);
    }

    public final void setRadiusRatio(float f5) {
        this.f2637s = f5;
    }

    public final void setRenderMode(j jVar) {
        jVar.getClass();
        this.f2628j = jVar;
        int iOrdinal = getRenderMode().ordinal();
        if (iOrdinal == 0) {
            setClipToOutline(true);
            setOutlineProvider(new l(this, 0));
        } else if (iOrdinal == 1) {
            setWillNotDraw(false);
            setClipToOutline(this.f2630l);
            setOutlineProvider(this.f2629k);
        }
        int iOrdinal2 = getRenderMode().ordinal();
        if (iOrdinal2 == 0) {
            this.f2624c.setFillType(Path.FillType.WINDING);
        } else if (iOrdinal2 == 1) {
            this.f2624c.setFillType(Path.FillType.INVERSE_WINDING);
        }
        b(this.f2636r, true);
        invalidate();
        invalidateOutline();
    }

    public final void setSmoothCornerEnable(boolean z10) {
        if (this.i != z10) {
            this.i = z10;
            this.f2625f = true;
            invalidate();
        }
    }

    public final void setSmoothness(float f5) {
        float fP = p5.f.p(f5, 0.0f, 1.0f);
        if (fP == this.f2631m) {
            return;
        }
        this.f2625f = true;
        this.f2631m = fP;
        a();
    }

    public final void setStrokeColor(int i) {
        if (i != this.f2634p) {
            this.f2634p = i;
            this.f2635q.setColor(i);
            a();
        }
    }

    public final void setStrokeWidthExt(float f5) {
        if (f5 == this.f2633o) {
            return;
        }
        this.f2633o = f5;
        this.f2635q.setStrokeWidth(f5);
        a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        context.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        context.getClass();
    }

    public /* synthetic */ SmoothCornerView(Context context, AttributeSet attributeSet, int i, int i3, int i10, yb.f fVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet, (i10 & 4) != 0 ? 0 : i, (i10 & 8) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerView(Context context) {
        this(context, null, 0, 0, 14, null);
        context.getClass();
    }
}
