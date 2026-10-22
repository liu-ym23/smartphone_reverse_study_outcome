package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.TextView;
import g.AbstractC0560a;
import java.util.WeakHashMap;

/* renamed from: androidx.appcompat.widget.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0236y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3205a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f3206b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f3207c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3208d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3209e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3210f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f3211g;

    public /* synthetic */ C0236y(TextView textView, int i4) {
        this.f3205a = i4;
        this.f3211g = textView;
    }

    public final void a() {
        TextView textView = this.f3211g;
        Drawable drawableA = androidx.core.widget.c.a((CompoundButton) textView);
        if (drawableA != null) {
            if (this.f3208d || this.f3209e) {
                Drawable drawableMutate = drawableA.mutate();
                if (this.f3208d) {
                    E.a.h(drawableMutate, this.f3206b);
                }
                if (this.f3209e) {
                    E.a.i(drawableMutate, this.f3207c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(((CompoundButton) textView).getDrawableState());
                }
                ((CompoundButton) textView).setButtonDrawable(drawableMutate);
            }
        }
    }

    public final void b() {
        TextView textView = this.f3211g;
        Drawable checkMarkDrawable = ((CheckedTextView) textView).getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f3208d || this.f3209e) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.f3208d) {
                    E.a.h(drawableMutate, this.f3206b);
                }
                if (this.f3209e) {
                    E.a.i(drawableMutate, this.f3207c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(((CheckedTextView) textView).getDrawableState());
                }
                ((CheckedTextView) textView).setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public final void c(AttributeSet attributeSet, int i4) {
        android.support.v4.media.session.c cVarY;
        int iR;
        int iR2;
        int iR3;
        int iR4;
        int i5 = this.f3205a;
        TextView textView = this.f3211g;
        switch (i5) {
            case 0:
                CheckedTextView checkedTextView = (CheckedTextView) textView;
                Context context = checkedTextView.getContext();
                int[] iArr = AbstractC0560a.f12599l;
                cVarY = android.support.v4.media.session.c.y(i4, 0, context, attributeSet, iArr);
                Context context2 = checkedTextView.getContext();
                TypedArray typedArray = (TypedArray) cVarY.f2365c;
                WeakHashMap weakHashMap = K.S.f939a;
                K.O.d(checkedTextView, context2, iArr, attributeSet, typedArray, i4, 0);
                try {
                    if (cVarY.v(1) && (iR2 = cVarY.r(1, 0)) != 0) {
                        try {
                            ((CheckedTextView) textView).setCheckMarkDrawable(Z2.I.o(((CheckedTextView) textView).getContext(), iR2));
                        } catch (Resources.NotFoundException unused) {
                        }
                    } else if (cVarY.v(0) && (iR = cVarY.r(0, 0)) != 0) {
                        ((CheckedTextView) textView).setCheckMarkDrawable(Z2.I.o(((CheckedTextView) textView).getContext(), iR));
                    }
                    if (cVarY.v(2)) {
                        ((CheckedTextView) textView).setCheckMarkTintList(cVarY.h(2));
                    }
                    if (cVarY.v(3)) {
                        ((CheckedTextView) textView).setCheckMarkTintMode(AbstractC0220p0.b(cVarY.p(3, -1), null));
                    }
                    return;
                } finally {
                }
            default:
                CompoundButton compoundButton = (CompoundButton) textView;
                Context context3 = compoundButton.getContext();
                int[] iArr2 = AbstractC0560a.f12600m;
                cVarY = android.support.v4.media.session.c.y(i4, 0, context3, attributeSet, iArr2);
                Context context4 = compoundButton.getContext();
                TypedArray typedArray2 = (TypedArray) cVarY.f2365c;
                WeakHashMap weakHashMap2 = K.S.f939a;
                K.O.d(compoundButton, context4, iArr2, attributeSet, typedArray2, i4, 0);
                try {
                    if (cVarY.v(1) && (iR4 = cVarY.r(1, 0)) != 0) {
                        try {
                            ((CompoundButton) textView).setButtonDrawable(Z2.I.o(((CompoundButton) textView).getContext(), iR4));
                        } catch (Resources.NotFoundException unused2) {
                        }
                    } else if (cVarY.v(0) && (iR3 = cVarY.r(0, 0)) != 0) {
                        ((CompoundButton) textView).setButtonDrawable(Z2.I.o(((CompoundButton) textView).getContext(), iR3));
                    }
                    if (cVarY.v(2)) {
                        androidx.core.widget.b.c((CompoundButton) textView, cVarY.h(2));
                    }
                    if (cVarY.v(3)) {
                        androidx.core.widget.b.d((CompoundButton) textView, AbstractC0220p0.b(cVarY.p(3, -1), null));
                    }
                    return;
                } finally {
                }
        }
    }
}
