package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.stepos.agentsafetycenter.R;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 extends a0 {

    /* renamed from: e, reason: collision with root package name */
    public d0 f7896e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f7897f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f7898g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f7899h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7900j;

    @Override // m.a0
    public final void c(AttributeSet attributeSet, int i) {
        super.c(attributeSet, R.attr.seekBarStyle);
        d0 d0Var = this.f7896e;
        Context context = d0Var.getContext();
        int[] iArr = g.a.f4104g;
        p5.m mVarJ = p5.m.J(context, attributeSet, iArr, R.attr.seekBarStyle);
        TypedArray typedArray = (TypedArray) mVarJ.f9742g;
        Context context2 = d0Var.getContext();
        TypedArray typedArray2 = (TypedArray) mVarJ.f9742g;
        WeakHashMap weakHashMap = n3.k0.f8724a;
        n3.i0.b(d0Var, context2, iArr, attributeSet, typedArray2, R.attr.seekBarStyle, 0);
        Drawable drawableB = mVarJ.B(0);
        if (drawableB != null) {
            d0Var.setThumb(drawableB);
        }
        Drawable drawableA = mVarJ.A(1);
        Drawable drawable = this.f7897f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f7897f = drawableA;
        if (drawableA != null) {
            drawableA.setCallback(d0Var);
            drawableA.setLayoutDirection(d0Var.getLayoutDirection());
            if (drawableA.isStateful()) {
                drawableA.setState(d0Var.getDrawableState());
            }
            g();
        }
        d0Var.invalidate();
        if (typedArray.hasValue(3)) {
            this.f7899h = e1.b(typedArray.getInt(3, -1), this.f7899h);
            this.f7900j = true;
        }
        if (typedArray.hasValue(2)) {
            this.f7898g = mVarJ.z(2);
            this.i = true;
        }
        mVarJ.M();
        g();
    }

    public final void g() {
        Drawable drawable = this.f7897f;
        if (drawable != null) {
            if (this.i || this.f7900j) {
                Drawable drawableMutate = drawable.mutate();
                this.f7897f = drawableMutate;
                if (this.i) {
                    drawableMutate.setTintList(this.f7898g);
                }
                if (this.f7900j) {
                    this.f7897f.setTintMode(this.f7899h);
                }
                if (this.f7897f.isStateful()) {
                    this.f7897f.setState(this.f7896e.getDrawableState());
                }
            }
        }
    }

    public final void h(Canvas canvas) {
        d0 d0Var = this.f7896e;
        if (this.f7897f != null) {
            int max = d0Var.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f7897f.getIntrinsicWidth();
                int intrinsicHeight = this.f7897f.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i3 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f7897f.setBounds(-i, -i3, i, i3);
                float width = ((d0Var.getWidth() - d0Var.getPaddingLeft()) - d0Var.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(d0Var.getPaddingLeft(), d0Var.getHeight() / 2);
                for (int i10 = 0; i10 <= max; i10++) {
                    this.f7897f.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
