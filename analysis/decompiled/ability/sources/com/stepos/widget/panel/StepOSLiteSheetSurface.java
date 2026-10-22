package com.stepos.widget.panel;

import G6.f;
import G6.g;
import G6.h;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.R;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetSurface;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public final class StepOSLiteSheetSurface extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final f f4151a;
    public final Paint b;
    public final g c;
    public final Path d;
    public final RectF e;
    public final float[] f;
    public final float g;
    public final boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final h f4152j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v10, types: [G6.h] */
    public StepOSLiteSheetSurface(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        k.f(context, "context");
        this.f4151a = new f(this);
        Paint paint = new Paint(1);
        paint.setColor(ContextCompat.getColor(context, R.color.stepos_lite_sheet_background));
        this.b = paint;
        Context context2 = getContext();
        k.e(context2, "getContext(...)");
        paint.setColor(ContextCompat.getColor(context2, R.color.stepos_lite_sheet_background));
        Resources resources = context2.getResources();
        this.c = new g(resources.getFraction(R.fraction.stepos_lite_sheet_glass_tint_alpha, 1, 1), resources.getInteger(R.integer.stepos_lite_sheet_blur_radius), resources.getFraction(R.fraction.stepos_lite_sheet_expanded_glass_tint_alpha, 1, 1), resources.getInteger(R.integer.stepos_lite_sheet_expanded_blur_radius), paint.getColor());
        this.d = new Path();
        this.e = new RectF();
        this.f = new float[8];
        this.g = getResources().getDimension(R.dimen.stepos_lite_sheet_corner_radius);
        this.h = true;
        this.i = true;
        this.f4152j = new ViewTreeObserver.OnPreDrawListener() { // from class: G6.h
            /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00c4 A[Catch: Exception -> 0x00af, TryCatch #0 {Exception -> 0x00af, blocks: (B:26:0x0092, B:28:0x009a, B:31:0x00a2, B:33:0x00ac, B:36:0x00b1, B:37:0x00b8, B:38:0x00b9, B:39:0x00bd, B:42:0x00c4, B:47:0x00d1, B:48:0x00da, B:53:0x00e7, B:54:0x00f0, B:51:0x00e1, B:45:0x00cb), top: B:59:0x0092 }] */
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final boolean onPreDraw() {
                /*
                    Method dump skipped, instructions count: 265
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: G6.h.onPreDraw():boolean");
            }
        };
        setWillNotDraw(false);
        setClickable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        k.f(canvas, "canvas");
        int iSave = canvas.save();
        canvas.clipPath(this.d);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i = true;
        getViewTreeObserver().addOnPreDrawListener(this.f4152j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        getViewTreeObserver().removeOnPreDrawListener(this.f4152j);
        this.i = false;
        f fVar = this.f4151a;
        fVar.a();
        fVar.f682a = false;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        k.f(canvas, "canvas");
        super.onDraw(canvas);
        f fVar = this.f4151a;
        if (((Drawable) fVar.d) == null || !((D6.f) fVar.c).d) {
            canvas.drawPath(this.d, this.b);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        this.i = true;
    }
}
