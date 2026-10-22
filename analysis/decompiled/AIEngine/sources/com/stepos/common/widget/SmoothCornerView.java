package com.stepos.common.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.stepos.aiengine.R;
import l8.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SmoothCornerView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public Path f7036a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7037b;

    /* renamed from: c, reason: collision with root package name */
    public float f7038c;

    /* renamed from: d, reason: collision with root package name */
    public float f7039d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7040e;
    public SmoothGenMode h;

    /* renamed from: j, reason: collision with root package name */
    public final ViewOutlineProvider f7041j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f7042k;

    /* renamed from: l, reason: collision with root package name */
    public float f7043l;

    /* renamed from: m, reason: collision with root package name */
    public float f7044m;

    /* renamed from: n, reason: collision with root package name */
    public float f7045n;

    /* renamed from: o, reason: collision with root package name */
    public int f7046o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f7047p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7048q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public final y f7049s;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SmoothGenMode {

        /* renamed from: a, reason: collision with root package name */
        public static final SmoothGenMode f7050a;

        /* renamed from: b, reason: collision with root package name */
        public static final SmoothGenMode f7051b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ SmoothGenMode[] f7052c;

        static {
            SmoothGenMode smoothGenMode = new SmoothGenMode("ClipPath", 0);
            f7050a = smoothGenMode;
            SmoothGenMode smoothGenMode2 = new SmoothGenMode("ClearPixel", 1);
            f7051b = smoothGenMode2;
            f7052c = new SmoothGenMode[]{smoothGenMode, smoothGenMode2};
        }

        public SmoothGenMode() {
            throw null;
        }

        public static SmoothGenMode valueOf(String str) {
            return (SmoothGenMode) Enum.valueOf(SmoothGenMode.class, str);
        }

        public static SmoothGenMode[] values() {
            return (SmoothGenMode[]) f7052c.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.g.f(view, "view");
            kotlin.jvm.internal.g.f(outline, "outline");
            SmoothCornerView smoothCornerView = SmoothCornerView.this;
            smoothCornerView.b(smoothCornerView.getAutoFitRadius(), false);
            outline.setPath(smoothCornerView.f7036a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothCornerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        kotlin.jvm.internal.g.f(context, "context");
        this.f7036a = new Path();
        this.f7040e = true;
        this.h = SmoothGenMode.f7051b;
        this.f7041j = getOutlineProvider();
        this.f7042k = getClipToOutline();
        int[] iArr = g8.a.f9086m;
        this.f7043l = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getFloat(2, 0.2f);
        this.f7044m = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getDimension(1, getResources().getDimension(R.dimen.fd_sys_radius_corner_none));
        this.f7045n = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getDimension(4, 0.0f);
        this.f7046o = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getColor(3, getResources().getColor(R.color.fd_sys_color_outline_variant_default));
        Paint paint = new Paint();
        paint.setStrokeWidth(this.f7045n);
        paint.setColor(this.f7046o);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        this.f7047p = paint;
        this.f7048q = context.obtainStyledAttributes(attributeSet, iArr, 0, 0).getBoolean(0, false);
        this.f7049s = new y(this, context, getHandler());
        setRenderMode(SmoothGenMode.f7050a);
        setExactMode(true);
        this.r = l8.a.a(context);
    }

    private final void setHeightFloat(float f8) {
        if (this.f7039d == f8) {
            return;
        }
        this.f7039d = f8;
        this.f7037b = true;
    }

    private final void setPath(Path path) {
        this.f7036a = path;
        int iOrdinal = getRenderMode().ordinal();
        if (iOrdinal == 0) {
            this.f7036a.setFillType(Path.FillType.WINDING);
        } else {
            if (iOrdinal != 1) {
                return;
            }
            this.f7036a.setFillType(Path.FillType.INVERSE_WINDING);
        }
    }

    private final void setWidthFloat(float f8) {
        if (this.f7038c == f8) {
            return;
        }
        this.f7038c = f8;
        this.f7037b = true;
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

    public final void b(boolean z, boolean z3) {
        float radius;
        if (this.f7037b || z3) {
            if (this.f7048q) {
                radius = Math.min(this.f7038c, this.f7039d) * this.r;
            } else {
                radius = getRadius();
            }
            setPath(l8.h.a(0.0f, 0.0f, this.f7038c, this.f7039d, this.f7043l, radius, z));
            this.f7037b = false;
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        float radius;
        kotlin.jvm.internal.g.f(canvas, "canvas");
        if (!this.f7040e) {
            super.draw(canvas);
            return;
        }
        super.draw(canvas);
        if (getRenderMode() == SmoothGenMode.f7051b) {
            if (this.f7048q) {
                radius = Math.min(this.f7038c, this.f7039d) * this.r;
            } else {
                radius = getRadius();
            }
            b(this.f7048q, false);
            Path path = this.f7036a;
            h.c cVar = l8.h.f10359a;
            canvas.drawPath(path, l8.h.f10360b);
            Paint paint = this.f7047p;
            float f8 = 2;
            Path pathA = l8.h.a((paint.getStrokeWidth() / f8) + 0.0f, (paint.getStrokeWidth() / f8) + 0.0f, this.f7038c - (paint.getStrokeWidth() / f8), this.f7039d - (paint.getStrokeWidth() / f8), this.f7043l, radius - (paint.getStrokeWidth() / f8), this.f7048q);
            pathA.setFillType(Path.FillType.WINDING);
            canvas.drawPath(pathA, paint);
        }
    }

    public final boolean getAutoFitRadius() {
        return this.f7048q;
    }

    public final boolean getExactMode() {
        return getLayerType() == 2;
    }

    public final ContentObserver getMContentObserver() {
        return this.f7049s;
    }

    public final float getMaxSmoothRadius() {
        h.c cVar = l8.h.f10359a;
        return l8.h.b(this.f7038c, this.f7039d, this.f7043l);
    }

    public final float getRadius() {
        return dc.h.Z(this.f7044m, 0.0f, getMaxSmoothRadius());
    }

    public final float getRadiusDp() {
        Context context = getContext();
        kotlin.jvm.internal.g.e(context, "context");
        return getRadius() / context.getResources().getDisplayMetrics().density;
    }

    public final float getRadiusRatio() {
        return this.r;
    }

    public final SmoothGenMode getRenderMode() {
        return this.f7047p.getStrokeWidth() > 0.0f ? SmoothGenMode.f7051b : this.h;
    }

    public final boolean getSmoothCornerEnable() {
        return this.f7040e;
    }

    public final float getSmoothness() {
        return this.f7043l;
    }

    public final int getStrokeColor() {
        return this.f7046o;
    }

    public final Paint getStrokePaint() {
        return this.f7047p;
    }

    public final float getStrokeWidthExt() {
        return this.f7045n;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("current_launcher_icon_corner_size"), false, this.f7049s);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.f7049s);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        setWidthFloat(i10);
        setHeightFloat(i11);
        if (getRenderMode() == SmoothGenMode.f7051b) {
            b(this.f7048q, false);
        }
    }

    public final void setAutoFitRadius(boolean z) {
        if (z != this.f7048q) {
            this.f7048q = z;
            a();
        }
    }

    public final void setExactMode(boolean z) {
        if (z) {
            setLayerType(2, null);
        } else {
            setLayerType(0, null);
        }
    }

    public final void setRadius(float f8) {
        if (f8 == this.f7044m) {
            return;
        }
        this.f7037b = true;
        this.f7044m = f8;
        a();
    }

    public final void setRadiusDp(float f8) {
        Context context = getContext();
        kotlin.jvm.internal.g.e(context, "context");
        setRadius(context.getResources().getDisplayMetrics().density * f8);
    }

    public final void setRadiusRatio(float f8) {
        this.r = f8;
    }

    public final void setRenderMode(SmoothGenMode value) {
        kotlin.jvm.internal.g.f(value, "value");
        this.h = value;
        int iOrdinal = getRenderMode().ordinal();
        if (iOrdinal == 0) {
            setClipToOutline(true);
            setOutlineProvider(new a());
        } else if (iOrdinal == 1) {
            setWillNotDraw(false);
            setClipToOutline(this.f7042k);
            setOutlineProvider(this.f7041j);
        }
        int iOrdinal2 = getRenderMode().ordinal();
        if (iOrdinal2 == 0) {
            this.f7036a.setFillType(Path.FillType.WINDING);
        } else if (iOrdinal2 == 1) {
            this.f7036a.setFillType(Path.FillType.INVERSE_WINDING);
        }
        b(this.f7048q, true);
        invalidate();
        invalidateOutline();
    }

    public final void setSmoothCornerEnable(boolean z) {
        if (this.f7040e != z) {
            this.f7040e = z;
            this.f7037b = true;
            invalidate();
        }
    }

    public final void setSmoothness(float f8) {
        float fZ = dc.h.Z(f8, 0.0f, 1.0f);
        if (fZ == this.f7043l) {
            return;
        }
        this.f7037b = true;
        this.f7043l = fZ;
        a();
    }

    public final void setStrokeColor(int i10) {
        if (i10 != this.f7046o) {
            this.f7046o = i10;
            this.f7047p.setColor(i10);
            a();
        }
    }

    public final void setStrokeWidthExt(float f8) {
        if (f8 == this.f7045n) {
            return;
        }
        this.f7045n = f8;
        this.f7047p.setStrokeWidth(f8);
        a();
    }
}
