package com.stepos.widget.panel;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.content.a;
import com.stepos.widget.panel.StepOSLiteSheetSurface;
import j4.k;
import l3.C0846d;
import l3.C0847e;
import l3.g;
import u3.i;
import u3.j;

/* loaded from: classes.dex */
public final class StepOSLiteSheetSurface extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final i f16329a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f16330b;

    /* renamed from: c, reason: collision with root package name */
    private int f16331c;

    /* renamed from: d, reason: collision with root package name */
    private j f16332d;

    /* renamed from: e, reason: collision with root package name */
    private final Path f16333e;

    /* renamed from: f, reason: collision with root package name */
    private final RectF f16334f;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f16335g;

    /* renamed from: h, reason: collision with root package name */
    private float f16336h;

    /* renamed from: i, reason: collision with root package name */
    private float f16337i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f16338j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f16339k;

    /* renamed from: l, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f16340l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSLiteSheetSurface(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.g(context, "context");
        this.f16329a = new i(this);
        Paint paint = new Paint(1);
        paint.setColor(a.c(context, C0846d.f18315v));
        this.f16330b = paint;
        this.f16332d = b(this.f16331c);
        this.f16333e = new Path();
        this.f16334f = new RectF();
        this.f16335g = new float[8];
        this.f16336h = getResources().getDimension(C0847e.f18349b0);
        this.f16338j = true;
        this.f16339k = true;
        this.f16340l = new ViewTreeObserver.OnPreDrawListener() { // from class: u3.l
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return StepOSLiteSheetSurface.f(this.f22913a);
            }
        };
        setWillNotDraw(false);
        setClickable(true);
    }

    private final j b(int i5) {
        Context contextE = e(i5);
        this.f16330b.setColor(a.c(contextE, C0846d.f18315v));
        Resources resources = contextE.getResources();
        return new j(resources.getInteger(l3.i.f18456e), resources.getInteger(l3.i.f18457f), this.f16330b.getColor(), resources.getFraction(g.f18407c, 1, 1), resources.getFraction(g.f18405a, 1, 1));
    }

    private final void c() {
        int i5;
        this.f16334f.set(0.0f, 0.0f, getWidth(), getHeight());
        int i6 = 0;
        while (true) {
            if (i6 >= 4) {
                break;
            }
            this.f16335g[i6] = this.f16336h;
            i6++;
        }
        for (i5 = 4; i5 < 8; i5++) {
            this.f16335g[i5] = this.f16336h * (1.0f - this.f16337i);
        }
        this.f16333e.reset();
        this.f16333e.addRoundRect(this.f16334f, this.f16335g, Path.Direction.CW);
    }

    private final Context e(int i5) {
        if (i5 == 0) {
            Context context = getContext();
            k.f(context, "getContext(...)");
            return context;
        }
        Configuration configuration = new Configuration(getResources().getConfiguration());
        configuration.uiMode = (i5 == 2 ? 32 : 16) | (configuration.uiMode & (-49));
        Context contextCreateConfigurationContext = getContext().createConfigurationContext(configuration);
        k.f(contextCreateConfigurationContext, "createConfigurationContext(...)");
        return contextCreateConfigurationContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(StepOSLiteSheetSurface stepOSLiteSheetSurface) {
        if (!stepOSLiteSheetSurface.f16339k) {
            return true;
        }
        stepOSLiteSheetSurface.f16339k = false;
        stepOSLiteSheetSurface.c();
        stepOSLiteSheetSurface.g();
        return true;
    }

    private final void g() {
        if (!this.f16338j || !isAttachedToWindow() || getWidth() <= 0 || getHeight() <= 0) {
            this.f16329a.i();
            return;
        }
        i iVar = this.f16329a;
        float f5 = this.f16336h;
        float f6 = this.f16337i;
        iVar.j(f5, (1.0f - f6) * f5, this.f16332d.a(f6), this.f16332d.b(this.f16337i));
    }

    public final void d() {
        this.f16339k = false;
        this.f16329a.i();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        k.g(canvas, "canvas");
        int iSave = canvas.save();
        canvas.clipPath(this.f16333e);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f16339k = true;
        getViewTreeObserver().addOnPreDrawListener(this.f16340l);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        getViewTreeObserver().removeOnPreDrawListener(this.f16340l);
        d();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        k.g(canvas, "canvas");
        super.onDraw(canvas);
        if (this.f16329a.h()) {
            return;
        }
        canvas.drawPath(this.f16333e, this.f16330b);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        this.f16339k = true;
    }
}
