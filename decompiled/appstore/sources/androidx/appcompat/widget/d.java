package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CheckedTextView f981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f986f;

    public d(CheckedTextView r10) {
        this.f982b = null;
        this.f983c = null;
        this.f984d = false;
        this.f985e = false;
        this.f981a = r10;
    }

    public void a() {
        Drawable r10 = androidx.core.widget.b.a(this.f981a);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f984d == false) goto L7;
    L8:
        Drawable r11 = o.a.l(r10).mutate();
        if (this.f984d == false) goto L12;
        o.a.i(r11, this.f982b);
    L12:
        if (this.f985e == false) goto L15;
        o.a.j(r11, this.f983c);
    L15:
        if (r11.isStateful() == false) goto L17;
        r11.setState(this.f981a.getDrawableState());
    L17:
        this.f981a.setCheckMarkDrawable(r11);
        return;
    L7:
        if (this.f985e == true) goto L8;
    }

    public ColorStateList b() {
        return this.f982b;
    }

    public PorterDuff.Mode c() {
        return this.f983c;
    }

    public void d(AttributeSet r10, int r11) {
        Context r12 = this.f981a.getContext();
        int[] r13 = R$styleable.CheckedTextView;
        b0 r14 = b0.v(r12, r10, r13, r11, 0);
        CheckedTextView r15 = this.f981a;
        ViewCompat.n0(r15, r15.getContext(), r13, r10, r14.r(), r11, 0);
        int r16 = R$styleable.CheckedTextView_checkMarkCompat;     // Catch: Throwable -> L9
        if (r14.s(r16) == false) goto L11;
        int r17 = r14.n(r16, 0);     // Catch: Throwable -> L9
        if (r17 == 0) goto L11;
        CheckedTextView r18 = this.f981a;     // Catch: Throwable -> L9 Resources.NotFoundException -> L26
        r18.setCheckMarkDrawable(c.a.b(r18.getContext(), r17));     // Catch: Throwable -> L9 Resources.NotFoundException -> L26
    L16:
        int r19 = R$styleable.CheckedTextView_checkMarkTint;     // Catch: Throwable -> L9
        if (r14.s(r19) == false) goto L19;
        androidx.core.widget.b.b(this.f981a, r14.c(r19));     // Catch: Throwable -> L9
    L19:
        int r110 = R$styleable.CheckedTextView_checkMarkTintMode;     // Catch: Throwable -> L9
        if (r14.s(r110) == false) goto L22;
        androidx.core.widget.b.c(this.f981a, r.e(r14.k(r110, -1), null));     // Catch: Throwable -> L9
    L22:
        r14.w();
        return;
    L11:
        int r111 = R$styleable.CheckedTextView_android_checkMark;     // Catch: Throwable -> L9
        if (r14.s(r111) == false) goto L16;
        int r112 = r14.n(r111, 0);     // Catch: Throwable -> L9
        if (r112 == 0) goto L16;
        CheckedTextView r113 = this.f981a;     // Catch: Throwable -> L9
        r113.setCheckMarkDrawable(c.a.b(r113.getContext(), r112));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r14.w();
        throw th;
    }

    public void e() {
        if (this.f986f == false) goto L6;
        this.f986f = false;
        return;
    L6:
        this.f986f = true;
        a();
    }

    public void f(ColorStateList r10) {
        this.f982b = r10;
        this.f984d = true;
        a();
    }

    public void g(PorterDuff.Mode r10) {
        this.f983c = r10;
        this.f985e = true;
        a();
    }
}
