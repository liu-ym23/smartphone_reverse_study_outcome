package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompoundButton f988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f993f;

    public e(CompoundButton r10) {
        this.f989b = null;
        this.f990c = null;
        this.f991d = false;
        this.f992e = false;
        this.f988a = r10;
    }

    public void a() {
        Drawable r10 = androidx.core.widget.c.a(this.f988a);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f991d == false) goto L7;
    L8:
        Drawable r11 = o.a.l(r10).mutate();
        if (this.f991d == false) goto L12;
        o.a.i(r11, this.f989b);
    L12:
        if (this.f992e == false) goto L15;
        o.a.j(r11, this.f990c);
    L15:
        if (r11.isStateful() == false) goto L17;
        r11.setState(this.f988a.getDrawableState());
    L17:
        this.f988a.setButtonDrawable(r11);
        return;
    L7:
        if (this.f992e == true) goto L8;
    }

    public int b(int r10) {
        return r10;
    }

    public ColorStateList c() {
        return this.f989b;
    }

    public PorterDuff.Mode d() {
        return this.f990c;
    }

    public void e(AttributeSet r10, int r11) {
        Context r12 = this.f988a.getContext();
        int[] r13 = R$styleable.CompoundButton;
        b0 r14 = b0.v(r12, r10, r13, r11, 0);
        CompoundButton r15 = this.f988a;
        ViewCompat.n0(r15, r15.getContext(), r13, r10, r14.r(), r11, 0);
        int r16 = R$styleable.CompoundButton_buttonCompat;     // Catch: Throwable -> L9
        if (r14.s(r16) == false) goto L11;
        int r17 = r14.n(r16, 0);     // Catch: Throwable -> L9
        if (r17 == 0) goto L11;
        CompoundButton r18 = this.f988a;     // Catch: Throwable -> L9 Resources.NotFoundException -> L26
        r18.setButtonDrawable(c.a.b(r18.getContext(), r17));     // Catch: Throwable -> L9 Resources.NotFoundException -> L26
    L16:
        int r19 = R$styleable.CompoundButton_buttonTint;     // Catch: Throwable -> L9
        if (r14.s(r19) == false) goto L19;
        androidx.core.widget.c.c(this.f988a, r14.c(r19));     // Catch: Throwable -> L9
    L19:
        int r110 = R$styleable.CompoundButton_buttonTintMode;     // Catch: Throwable -> L9
        if (r14.s(r110) == false) goto L22;
        androidx.core.widget.c.d(this.f988a, r.e(r14.k(r110, -1), null));     // Catch: Throwable -> L9
    L22:
        r14.w();
        return;
    L11:
        int r111 = R$styleable.CompoundButton_android_button;     // Catch: Throwable -> L9
        if (r14.s(r111) == false) goto L16;
        int r112 = r14.n(r111, 0);     // Catch: Throwable -> L9
        if (r112 == 0) goto L16;
        CompoundButton r113 = this.f988a;     // Catch: Throwable -> L9
        r113.setButtonDrawable(c.a.b(r113.getContext(), r112));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r14.w();
        throw th;
    }

    public void f() {
        if (this.f993f == false) goto L6;
        this.f993f = false;
        return;
    L6:
        this.f993f = true;
        a();
    }

    public void g(ColorStateList r10) {
        this.f989b = r10;
        this.f991d = true;
        a();
    }

    public void h(PorterDuff.Mode r10) {
        this.f990c = r10;
        this.f992e = true;
        a();
    }
}
