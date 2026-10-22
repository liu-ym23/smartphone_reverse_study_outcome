package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.appcompat.R$styleable;
import f.C4027a;
import u0.C5566a;

/* renamed from: androidx.appcompat.widget.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1293f {

    /* renamed from: a, reason: collision with root package name */
    public final CheckedTextView f9190a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f9191b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f9192c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9193d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9194e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9195f;

    public C1293f(CheckedTextView checkedTextView) {
        this.f9190a = checkedTextView;
    }

    public void a() {
        Drawable drawableA = androidx.core.widget.b.a(this.f9190a);
        if (drawableA != null) {
            if (this.f9193d || this.f9194e) {
                Drawable drawableMutate = C5566a.r(drawableA).mutate();
                if (this.f9193d) {
                    C5566a.o(drawableMutate, this.f9191b);
                }
                if (this.f9194e) {
                    C5566a.p(drawableMutate, this.f9192c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f9190a.getDrawableState());
                }
                this.f9190a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public ColorStateList b() {
        return this.f9191b;
    }

    public PorterDuff.Mode c() {
        return this.f9192c;
    }

    public void d(AttributeSet attributeSet, int i10) {
        int iN;
        int iN2;
        Context context = this.f9190a.getContext();
        int[] iArr = R$styleable.CheckedTextView;
        U uV = U.v(context, attributeSet, iArr, i10, 0);
        CheckedTextView checkedTextView = this.f9190a;
        androidx.core.view.N.g0(checkedTextView, checkedTextView.getContext(), iArr, attributeSet, uV.r(), i10, 0);
        try {
            int i11 = R$styleable.CheckedTextView_checkMarkCompat;
            if (!uV.s(i11) || (iN2 = uV.n(i11, 0)) == 0) {
                int i12 = R$styleable.CheckedTextView_android_checkMark;
                if (uV.s(i12) && (iN = uV.n(i12, 0)) != 0) {
                    CheckedTextView checkedTextView2 = this.f9190a;
                    checkedTextView2.setCheckMarkDrawable(C4027a.b(checkedTextView2.getContext(), iN));
                }
            } else {
                try {
                    CheckedTextView checkedTextView3 = this.f9190a;
                    checkedTextView3.setCheckMarkDrawable(C4027a.b(checkedTextView3.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                }
            }
            int i13 = R$styleable.CheckedTextView_checkMarkTint;
            if (uV.s(i13)) {
                androidx.core.widget.b.b(this.f9190a, uV.c(i13));
            }
            int i14 = R$styleable.CheckedTextView_checkMarkTintMode;
            if (uV.s(i14)) {
                androidx.core.widget.b.c(this.f9190a, B.d(uV.k(i14, -1), null));
            }
            uV.x();
        } catch (Throwable th) {
            uV.x();
            throw th;
        }
    }

    public void e() {
        if (this.f9195f) {
            this.f9195f = false;
        } else {
            this.f9195f = true;
            a();
        }
    }

    public void f(ColorStateList colorStateList) {
        this.f9191b = colorStateList;
        this.f9193d = true;
        a();
    }

    public void g(PorterDuff.Mode mode) {
        this.f9192c = mode;
        this.f9194e = true;
        a();
    }
}
