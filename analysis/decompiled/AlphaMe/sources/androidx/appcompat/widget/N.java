package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import g.AbstractC0560a;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class N extends J {

    /* renamed from: d, reason: collision with root package name */
    public final SeekBar f2880d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f2881e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f2882f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f2883g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2884h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2885i;

    public N(SeekBar seekBar) {
        super(seekBar);
        this.f2882f = null;
        this.f2883g = null;
        this.f2884h = false;
        this.f2885i = false;
        this.f2880d = seekBar;
    }

    @Override // androidx.appcompat.widget.J
    public final void a(AttributeSet attributeSet, int i4) {
        super.a(attributeSet, R.attr.seekBarStyle);
        SeekBar seekBar = this.f2880d;
        Context context = seekBar.getContext();
        int[] iArr = AbstractC0560a.f12594g;
        android.support.v4.media.session.c cVarY = android.support.v4.media.session.c.y(R.attr.seekBarStyle, 0, context, attributeSet, iArr);
        Context context2 = seekBar.getContext();
        TypedArray typedArray = (TypedArray) cVarY.f2365c;
        WeakHashMap weakHashMap = K.S.f939a;
        K.O.d(seekBar, context2, iArr, attributeSet, typedArray, R.attr.seekBarStyle, 0);
        Drawable drawableM = cVarY.m(0);
        if (drawableM != null) {
            seekBar.setThumb(drawableM);
        }
        Drawable drawableL = cVarY.l(1);
        Drawable drawable = this.f2881e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f2881e = drawableL;
        if (drawableL != null) {
            drawableL.setCallback(seekBar);
            E.b.b(drawableL, seekBar.getLayoutDirection());
            if (drawableL.isStateful()) {
                drawableL.setState(seekBar.getDrawableState());
            }
            c();
        }
        seekBar.invalidate();
        if (cVarY.v(3)) {
            this.f2883g = AbstractC0220p0.b(cVarY.p(3, -1), this.f2883g);
            this.f2885i = true;
        }
        if (cVarY.v(2)) {
            this.f2882f = cVarY.h(2);
            this.f2884h = true;
        }
        cVarY.A();
        c();
    }

    public final void c() {
        Drawable drawable = this.f2881e;
        if (drawable != null) {
            if (this.f2884h || this.f2885i) {
                Drawable drawableMutate = drawable.mutate();
                this.f2881e = drawableMutate;
                if (this.f2884h) {
                    E.a.h(drawableMutate, this.f2882f);
                }
                if (this.f2885i) {
                    E.a.i(this.f2881e, this.f2883g);
                }
                if (this.f2881e.isStateful()) {
                    this.f2881e.setState(this.f2880d.getDrawableState());
                }
            }
        }
    }

    public final void d(Canvas canvas) {
        if (this.f2881e != null) {
            int max = this.f2880d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f2881e.getIntrinsicWidth();
                int intrinsicHeight = this.f2881e.getIntrinsicHeight();
                int i4 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i5 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f2881e.setBounds(-i4, -i5, i4, i5);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i6 = 0; i6 <= max; i6++) {
                    this.f2881e.draw(canvas);
                    canvas.translate(width, Property.DEFAULT_FLOAT_VALUE);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
