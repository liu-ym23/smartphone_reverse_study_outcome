package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.aiengine.R;
import java.util.WeakHashMap;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class x extends s {

    /* renamed from: d, reason: collision with root package name */
    public final w f942d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f943e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f944f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f945g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f946i;

    public x(w wVar) {
        super(wVar);
        this.f944f = null;
        this.f945g = null;
        this.h = false;
        this.f946i = false;
        this.f942d = wVar;
    }

    @Override // androidx.appcompat.widget.s
    public final void a(AttributeSet attributeSet, int i10) {
        super.a(attributeSet, R.attr.seekBarStyle);
        w wVar = this.f942d;
        Context context = wVar.getContext();
        int[] iArr = g.a.f8927g;
        x0 x0VarE = x0.e(context, attributeSet, iArr, R.attr.seekBarStyle);
        TypedArray typedArray = x0VarE.f948b;
        Context context2 = wVar.getContext();
        TypedArray typedArray2 = x0VarE.f948b;
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        e0.h.b(wVar, context2, iArr, attributeSet, typedArray2, R.attr.seekBarStyle, 0);
        Drawable drawableC = x0VarE.c(0);
        if (drawableC != null) {
            wVar.setThumb(drawableC);
        }
        Drawable drawableB = x0VarE.b(1);
        Drawable drawable = this.f943e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f943e = drawableB;
        if (drawableB != null) {
            drawableB.setCallback(wVar);
            drawableB.setLayoutDirection(wVar.getLayoutDirection());
            if (drawableB.isStateful()) {
                drawableB.setState(wVar.getDrawableState());
            }
            c();
        }
        wVar.invalidate();
        if (typedArray.hasValue(3)) {
            this.f945g = f0.c(typedArray.getInt(3, -1), this.f945g);
            this.f946i = true;
        }
        if (typedArray.hasValue(2)) {
            this.f944f = x0VarE.a(2);
            this.h = true;
        }
        x0VarE.f();
        c();
    }

    public final void c() {
        Drawable drawable = this.f943e;
        if (drawable != null) {
            if (this.h || this.f946i) {
                Drawable drawableMutate = drawable.mutate();
                this.f943e = drawableMutate;
                if (this.h) {
                    drawableMutate.setTintList(this.f944f);
                }
                if (this.f946i) {
                    this.f943e.setTintMode(this.f945g);
                }
                if (this.f943e.isStateful()) {
                    this.f943e.setState(this.f942d.getDrawableState());
                }
            }
        }
    }

    public final void d(Canvas canvas) {
        if (this.f943e != null) {
            int max = this.f942d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f943e.getIntrinsicWidth();
                int intrinsicHeight = this.f943e.getIntrinsicHeight();
                int i10 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i11 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f943e.setBounds(-i10, -i11, i10, i11);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f943e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
