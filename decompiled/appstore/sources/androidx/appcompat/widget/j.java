package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f1035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f1036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f1037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z f1038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1039e;

    public j(ImageView r10) {
        this.f1039e = 0;
        this.f1035a = r10;
    }

    public final boolean a(Drawable r10) {
        if (this.f1038d != null) goto L5;
        this.f1038d = new z();
    L5:
        z r11 = this.f1038d;
        r11.a();
        ColorStateList r12 = androidx.core.widget.g.a(this.f1035a);
        if (r12 == null) goto L8;
        r11.f1164d = true;
        r11.f1161a = r12;
    L8:
        PorterDuff.Mode r13 = androidx.core.widget.g.b(this.f1035a);
        if (r13 == null) goto L12;
        r11.f1163c = true;
        r11.f1162b = r13;
    L12:
        if (r11.f1164d == false) goto L14;
    L18:
        f.i(r10, r11, this.f1035a.getDrawableState());
        return true;
    L14:
        if (r11.f1163c == true) goto L18;
        return false;
    }

    public void b() {
        if (this.f1035a.getDrawable() == null) goto L6;
        this.f1035a.getDrawable().setLevel(this.f1039e);
        return;
    }

    public void c() {
        Drawable r10 = this.f1035a.getDrawable();
        if (r10 == null) goto L5;
        r.b(r10);
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        if (l() == true) goto L9;
    L11:
        z r11 = this.f1037c;
        if (r11 == null) goto L14;
        f.i(r10, r11, this.f1035a.getDrawableState());
        return;
    L14:
        z r12 = this.f1036b;
        if (r12 == null) goto L20;
        f.i(r10, r12, this.f1035a.getDrawableState());
        return;
    L20:
        return;
    L9:
        if (a(r10) == false) goto L11;
    }

    public ColorStateList d() {
        z r10 = this.f1037c;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f1161a;
    }

    public PorterDuff.Mode e() {
        z r10 = this.f1037c;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f1162b;
    }

    public boolean f() {
        if ((this.f1035a.getBackground() instanceof RippleDrawable) == false) goto L6;
        return false;
    L6:
        return true;
    }

    public void g(AttributeSet r10, int r11) {
        Context r12 = this.f1035a.getContext();
        int[] r13 = R$styleable.AppCompatImageView;
        b0 r14 = b0.v(r12, r10, r13, r11, 0);
        ImageView r15 = this.f1035a;
        ViewCompat.n0(r15, r15.getContext(), r13, r10, r14.r(), r11, 0);
        Drawable r16 = this.f1035a.getDrawable();     // Catch: Throwable -> L10
        if (r16 != null) goto L12;
        int r17 = r14.n(R$styleable.AppCompatImageView_srcCompat, -1);     // Catch: Throwable -> L10
        if (r17 == (-1)) goto L12;
        r16 = c.a.b(this.f1035a.getContext(), r17);     // Catch: Throwable -> L10
        if (r16 == null) goto L12;
        this.f1035a.setImageDrawable(r16);     // Catch: Throwable -> L10
    L12:
        if (r16 == null) goto L14;
        r.b(r16);     // Catch: Throwable -> L10
    L14:
        int r18 = R$styleable.AppCompatImageView_tint;     // Catch: Throwable -> L10
        if (r14.s(r18) == false) goto L17;
        androidx.core.widget.g.c(this.f1035a, r14.c(r18));     // Catch: Throwable -> L10
    L17:
        int r19 = R$styleable.AppCompatImageView_tintMode;     // Catch: Throwable -> L10
        if (r14.s(r19) == false) goto L20;
        androidx.core.widget.g.d(this.f1035a, r.e(r14.k(r19, -1), null));     // Catch: Throwable -> L10
    L20:
        r14.w();
        return;
    L10:
        th = move-exception;
        r14.w();
        throw th;
    }

    public void h(Drawable r10) {
        this.f1039e = r10.getLevel();
    }

    public void i(int r10) {
        if (r10 == 0) goto L7;
        Drawable r11 = c.a.b(this.f1035a.getContext(), r10);
        if (r11 == null) goto L6;
        r.b(r11);
    L6:
        this.f1035a.setImageDrawable(r11);
    L8:
        c();
        return;
    L7:
        this.f1035a.setImageDrawable(null);
        goto L8
    }

    public void j(ColorStateList r10) {
        if (this.f1037c != null) goto L5;
        this.f1037c = new z();
    L5:
        z r11 = this.f1037c;
        r11.f1161a = r10;
        r11.f1164d = true;
        c();
    }

    public void k(PorterDuff.Mode r10) {
        if (this.f1037c != null) goto L5;
        this.f1037c = new z();
    L5:
        z r11 = this.f1037c;
        r11.f1162b = r10;
        r11.f1163c = true;
        c();
    }

    public final boolean l() {
        if (this.f1036b == null) goto L5;
        return true;
    L5:
        return false;
    }
}
