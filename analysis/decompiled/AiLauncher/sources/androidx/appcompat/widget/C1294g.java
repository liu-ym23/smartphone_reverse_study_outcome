package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;
import f.C4027a;
import u0.C5566a;

/* renamed from: androidx.appcompat.widget.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1294g {

    /* renamed from: a, reason: collision with root package name */
    public final CompoundButton f9196a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f9197b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f9198c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9199d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9200e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9201f;

    public C1294g(CompoundButton compoundButton) {
        this.f9196a = compoundButton;
    }

    public void a() {
        Drawable drawableA = androidx.core.widget.c.a(this.f9196a);
        if (drawableA != null) {
            if (this.f9199d || this.f9200e) {
                Drawable drawableMutate = C5566a.r(drawableA).mutate();
                if (this.f9199d) {
                    C5566a.o(drawableMutate, this.f9197b);
                }
                if (this.f9200e) {
                    C5566a.p(drawableMutate, this.f9198c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f9196a.getDrawableState());
                }
                this.f9196a.setButtonDrawable(drawableMutate);
            }
        }
    }

    public ColorStateList b() {
        return this.f9197b;
    }

    public PorterDuff.Mode c() {
        return this.f9198c;
    }

    public void d(AttributeSet attributeSet, int i10) {
        int iN;
        int iN2;
        Context context = this.f9196a.getContext();
        int[] iArr = R$styleable.CompoundButton;
        U uV = U.v(context, attributeSet, iArr, i10, 0);
        CompoundButton compoundButton = this.f9196a;
        androidx.core.view.N.g0(compoundButton, compoundButton.getContext(), iArr, attributeSet, uV.r(), i10, 0);
        try {
            int i11 = R$styleable.CompoundButton_buttonCompat;
            if (!uV.s(i11) || (iN2 = uV.n(i11, 0)) == 0) {
                int i12 = R$styleable.CompoundButton_android_button;
                if (uV.s(i12) && (iN = uV.n(i12, 0)) != 0) {
                    CompoundButton compoundButton2 = this.f9196a;
                    compoundButton2.setButtonDrawable(C4027a.b(compoundButton2.getContext(), iN));
                }
            } else {
                try {
                    CompoundButton compoundButton3 = this.f9196a;
                    compoundButton3.setButtonDrawable(C4027a.b(compoundButton3.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                }
            }
            int i13 = R$styleable.CompoundButton_buttonTint;
            if (uV.s(i13)) {
                androidx.core.widget.c.d(this.f9196a, uV.c(i13));
            }
            int i14 = R$styleable.CompoundButton_buttonTintMode;
            if (uV.s(i14)) {
                androidx.core.widget.c.e(this.f9196a, B.d(uV.k(i14, -1), null));
            }
            uV.x();
        } catch (Throwable th) {
            uV.x();
            throw th;
        }
    }

    public void e() {
        if (this.f9201f) {
            this.f9201f = false;
        } else {
            this.f9201f = true;
            a();
        }
    }

    public void f(ColorStateList colorStateList) {
        this.f9197b = colorStateList;
        this.f9199d = true;
        a();
    }

    public void g(PorterDuff.Mode mode) {
        this.f9198c = mode;
        this.f9200e = true;
        a();
    }
}
