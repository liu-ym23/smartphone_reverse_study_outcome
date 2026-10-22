package com.stepos.common.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class SmoothCornerView extends FrameLayout {

    /* renamed from: q, reason: collision with root package name */
    public static final a f14177q = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private Path f14178a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f14179b;

    /* renamed from: c, reason: collision with root package name */
    private float f14180c;

    /* renamed from: d, reason: collision with root package name */
    private float f14181d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f14182e;

    /* renamed from: f, reason: collision with root package name */
    private b f14183f;

    /* renamed from: g, reason: collision with root package name */
    private final ViewOutlineProvider f14184g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f14185h;

    /* renamed from: i, reason: collision with root package name */
    private float f14186i;

    /* renamed from: j, reason: collision with root package name */
    private float f14187j;

    /* renamed from: k, reason: collision with root package name */
    private float f14188k;

    /* renamed from: l, reason: collision with root package name */
    private int f14189l;

    /* renamed from: m, reason: collision with root package name */
    private final Paint f14190m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f14191n;

    /* renamed from: o, reason: collision with root package name */
    private float f14192o;

    /* renamed from: p, reason: collision with root package name */
    private final ContentObserver f14193p;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        public static /* synthetic */ float b(a aVar, Context context, float f5, float f6, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                f6 = aVar.c(context);
            }
            return aVar.a(context, f5, f6);
        }

        public static /* synthetic */ float e(a aVar, Context context, float f5, float f6, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                f6 = aVar.c(context);
            }
            return aVar.d(context, f5, f6);
        }

        public final float a(Context context, float f5, float f6) {
            j4.k.g(context, "<this>");
            return f5 * f6;
        }

        public final float c(Context context) {
            j4.k.g(context, "<this>");
            return context.getResources().getDisplayMetrics().density;
        }

        public final float d(Context context, float f5, float f6) {
            j4.k.g(context, "<this>");
            return f5 / f6;
        }

        private a() {
        }
    }

    public enum b {
        ClipPath,
        ClearPixel
    }

    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14197a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.ClipPath.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.ClearPixel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f14197a = iArr;
        }
    }

    public static final class d extends ContentObserver {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f14199b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, Handler handler) {
            super(handler);
            this.f14199b = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            SmoothCornerView.this.setRadiusRatio(N1.a.a(this.f14199b));
            SmoothCornerView.this.f14179b = true;
            SmoothCornerView.this.invalidate();
        }
    }

    public static final class e extends ViewOutlineProvider {
        e() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            j4.k.g(view, "view");
            j4.k.g(outline, "outline");
            SmoothCornerView smoothCornerView = SmoothCornerView.this;
            SmoothCornerView.g(smoothCornerView, smoothCornerView.getAutoFitRadius(), false, 2, null);
            outline.setPath(SmoothCornerView.this.f14178a);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        j4.k.g(context, "context");
    }

    private final void c() {
        int i5 = c.f14197a[getRenderMode().ordinal()];
        if (i5 == 1) {
            this.f14178a.setFillType(Path.FillType.WINDING);
        } else {
            if (i5 != 2) {
                return;
            }
            this.f14178a.setFillType(Path.FillType.INVERSE_WINDING);
        }
    }

    private final void d() {
        int i5 = c.f14197a[getRenderMode().ordinal()];
        if (i5 == 1) {
            invalidateOutline();
        } else {
            if (i5 != 2) {
                return;
            }
            invalidate();
        }
    }

    private final void e() {
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("current_launcher_icon_corner_size"), false, this.f14193p);
    }

    private final void f(boolean z5, boolean z6) {
        if (this.f14179b || z6) {
            setPath(N1.k.a(0.0f, 0.0f, this.f14180c, this.f14181d, this.f14186i, this.f14191n ? this.f14192o * Math.min(this.f14180c, this.f14181d) : getRadius(), z5));
            this.f14179b = false;
        }
    }

    static /* synthetic */ void g(SmoothCornerView smoothCornerView, boolean z5, boolean z6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trySmoothPath");
        }
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        smoothCornerView.f(z5, z6);
    }

    private final void setHeightFloat(float f5) {
        if (this.f14181d == f5) {
            return;
        }
        this.f14181d = f5;
        this.f14179b = true;
    }

    private final void setPath(Path path) {
        this.f14178a = path;
        c();
    }

    private final void setWidthFloat(float f5) {
        if (this.f14180c == f5) {
            return;
        }
        this.f14180c = f5;
        this.f14179b = true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        j4.k.g(canvas, "canvas");
        if (!this.f14182e) {
            super.draw(canvas);
            return;
        }
        super.draw(canvas);
        if (getRenderMode() == b.ClearPixel) {
            float fMin = this.f14191n ? this.f14192o * Math.min(this.f14180c, this.f14181d) : getRadius();
            f(this.f14191n, false);
            canvas.drawPath(this.f14178a, N1.k.f4211a.c());
            float f5 = 2;
            Path pathA = N1.k.a((this.f14190m.getStrokeWidth() / f5) + 0.0f, (this.f14190m.getStrokeWidth() / f5) + 0.0f, this.f14180c - (this.f14190m.getStrokeWidth() / f5), this.f14181d - (this.f14190m.getStrokeWidth() / f5), this.f14186i, fMin - (this.f14190m.getStrokeWidth() / f5), this.f14191n);
            pathA.setFillType(Path.FillType.WINDING);
            canvas.drawPath(pathA, this.f14190m);
        }
    }

    public final boolean getAutoFitRadius() {
        return this.f14191n;
    }

    public final boolean getExactMode() {
        return getLayerType() == 2;
    }

    public final ContentObserver getMContentObserver() {
        return this.f14193p;
    }

    public final float getMaxSmoothRadius() {
        return N1.k.f4211a.e(this.f14180c, this.f14181d, this.f14186i);
    }

    public final float getRadius() {
        return kotlin.ranges.l.g(this.f14187j, 0.0f, getMaxSmoothRadius());
    }

    public final float getRadiusDp() {
        a aVar = f14177q;
        Context context = getContext();
        j4.k.f(context, "context");
        return a.e(aVar, context, getRadius(), 0.0f, 2, null);
    }

    public final float getRadiusRatio() {
        return this.f14192o;
    }

    public final b getRenderMode() {
        return this.f14190m.getStrokeWidth() > 0.0f ? b.ClearPixel : this.f14183f;
    }

    public final boolean getSmoothCornerEnable() {
        return this.f14182e;
    }

    public final float getSmoothness() {
        return this.f14186i;
    }

    public final int getStrokeColor() {
        return this.f14189l;
    }

    public final Paint getStrokePaint() {
        return this.f14190m;
    }

    public final float getStrokeWidthExt() {
        return this.f14188k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.f14193p);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        setWidthFloat(i5);
        setHeightFloat(i6);
        if (getRenderMode() == b.ClearPixel) {
            g(this, this.f14191n, false, 2, null);
        }
    }

    public final void setAutoFitRadius(boolean z5) {
        if (z5 != this.f14191n) {
            this.f14191n = z5;
            d();
        }
    }

    public final void setExactMode(boolean z5) {
        if (z5) {
            setLayerType(2, null);
        } else {
            setLayerType(0, null);
        }
    }

    public final void setRadius(float f5) {
        if (f5 == this.f14187j) {
            return;
        }
        this.f14179b = true;
        this.f14187j = f5;
        d();
    }

    public final void setRadiusDp(float f5) {
        a aVar = f14177q;
        Context context = getContext();
        j4.k.f(context, "context");
        setRadius(a.b(aVar, context, f5, 0.0f, 2, null));
    }

    public final void setRadiusRatio(float f5) {
        this.f14192o = f5;
    }

    public final void setRenderMode(b bVar) {
        j4.k.g(bVar, "value");
        this.f14183f = bVar;
        int i5 = c.f14197a[getRenderMode().ordinal()];
        if (i5 == 1) {
            setClipToOutline(true);
            setOutlineProvider(new e());
        } else if (i5 == 2) {
            setWillNotDraw(false);
            setClipToOutline(this.f14185h);
            setOutlineProvider(this.f14184g);
        }
        c();
        f(this.f14191n, true);
        invalidate();
        invalidateOutline();
    }

    public final void setSmoothCornerEnable(boolean z5) {
        if (this.f14182e != z5) {
            this.f14182e = z5;
            this.f14179b = true;
            invalidate();
        }
    }

    public final void setSmoothness(float f5) {
        float fG = kotlin.ranges.l.g(f5, 0.0f, 1.0f);
        if (fG == this.f14186i) {
            return;
        }
        this.f14179b = true;
        this.f14186i = fG;
        d();
    }

    public final void setStrokeColor(int i5) {
        if (i5 != this.f14189l) {
            this.f14189l = i5;
            this.f14190m.setColor(i5);
            d();
        }
    }

    public final void setStrokeWidthExt(float f5) {
        if (f5 == this.f14188k) {
            return;
        }
        this.f14188k = f5;
        this.f14190m.setStrokeWidth(f5);
        d();
    }

    public /* synthetic */ SmoothCornerView(Context context, AttributeSet attributeSet, int i5, int i6, int i7, j4.g gVar) {
        this(context, (i7 & 2) != 0 ? null : attributeSet, (i7 & 4) != 0 ? 0 : i5, (i7 & 8) != 0 ? 0 : i6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothCornerView(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        j4.k.g(context, "context");
        this.f14178a = new Path();
        this.f14182e = true;
        this.f14183f = b.ClearPixel;
        this.f14184g = getOutlineProvider();
        this.f14185h = getClipToOutline();
        int[] iArr = H1.m.f2695y4;
        this.f14186i = context.obtainStyledAttributes(attributeSet, iArr, i5, i6).getFloat(H1.m.f2396B4, 0.2f);
        this.f14187j = context.obtainStyledAttributes(attributeSet, iArr, i5, i6).getDimension(H1.m.f2390A4, getResources().getDimension(H1.f.f2135c));
        this.f14188k = context.obtainStyledAttributes(attributeSet, iArr, i5, i6).getDimension(H1.m.f2408D4, 0.0f);
        this.f14189l = context.obtainStyledAttributes(attributeSet, iArr, i5, i6).getColor(H1.m.f2402C4, getResources().getColor(H1.e.f2083e));
        Paint paint = new Paint();
        paint.setStrokeWidth(this.f14188k);
        paint.setColor(this.f14189l);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        this.f14190m = paint;
        this.f14191n = context.obtainStyledAttributes(attributeSet, iArr, i5, i6).getBoolean(H1.m.f2701z4, false);
        this.f14193p = new d(context, getHandler());
        setRenderMode(b.ClipPath);
        setExactMode(true);
        this.f14192o = N1.a.a(context);
    }
}
