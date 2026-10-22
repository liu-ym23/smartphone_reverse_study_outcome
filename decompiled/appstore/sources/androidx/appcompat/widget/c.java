package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z f977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z f978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z f979f;

    public c(View r10) {
        this.f976c = -1;
        this.f974a = r10;
        this.f975b = f.b();
    }

    public final boolean a(Drawable r10) {
        if (this.f979f != null) goto L5;
        this.f979f = new z();
    L5:
        z r11 = this.f979f;
        r11.a();
        ColorStateList r12 = ViewCompat.r(this.f974a);
        if (r12 == null) goto L8;
        r11.f1164d = true;
        r11.f1161a = r12;
    L8:
        PorterDuff.Mode r13 = ViewCompat.s(this.f974a);
        if (r13 == null) goto L12;
        r11.f1163c = true;
        r11.f1162b = r13;
    L12:
        if (r11.f1164d == false) goto L14;
    L18:
        f.i(r10, r11, this.f974a.getDrawableState());
        return true;
    L14:
        if (r11.f1163c == true) goto L18;
        return false;
    }

    public void b() {
        Drawable r10 = this.f974a.getBackground();
        if (r10 != null) goto L5;
        return;
    L5:
        if (k() == true) goto L7;
    L9:
        z r11 = this.f978e;
        if (r11 == null) goto L12;
        f.i(r10, r11, this.f974a.getDrawableState());
        return;
    L12:
        z r12 = this.f977d;
        if (r12 == null) goto L18;
        f.i(r10, r12, this.f974a.getDrawableState());
        return;
    L18:
        return;
    L7:
        if (a(r10) == false) goto L9;
    }

    public ColorStateList c() {
        z r10 = this.f978e;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f1161a;
    }

    public PorterDuff.Mode d() {
        z r10 = this.f978e;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f1162b;
    }

    public void e(AttributeSet r10, int r11) {
        Context r12 = this.f974a.getContext();
        int[] r13 = R$styleable.ViewBackgroundHelper;
        b0 r14 = b0.v(r12, r10, r13, r11, 0);
        View r15 = this.f974a;
        ViewCompat.n0(r15, r15.getContext(), r13, r10, r14.r(), r11, 0);
        int r16 = R$styleable.ViewBackgroundHelper_android_background;     // Catch: Throwable -> L8
        if (r14.s(r16) == false) goto L10;
        this.f976c = r14.n(r16, -1);     // Catch: Throwable -> L8
        ColorStateList r17 = this.f975b.f(this.f974a.getContext(), this.f976c);     // Catch: Throwable -> L8
        if (r17 == null) goto L10;
        h(r17);     // Catch: Throwable -> L8
    L10:
        int r18 = R$styleable.ViewBackgroundHelper_backgroundTint;     // Catch: Throwable -> L8
        if (r14.s(r18) == false) goto L13;
        ViewCompat.u0(this.f974a, r14.c(r18));     // Catch: Throwable -> L8
    L13:
        int r19 = R$styleable.ViewBackgroundHelper_backgroundTintMode;     // Catch: Throwable -> L8
        if (r14.s(r19) == false) goto L16;
        ViewCompat.v0(this.f974a, r.e(r14.k(r19, -1), null));     // Catch: Throwable -> L8
    L16:
        r14.w();
        return;
    L8:
        th = move-exception;
        r14.w();
        throw th;
    }

    public void f(Drawable r10) {
        this.f976c = -1;
        h(null);
        b();
    }

    public void g(int r10) {
        this.f976c = r10;
        f r11 = this.f975b;
        if (r11 == null) goto L5;
        ColorStateList r12 = r11.f(this.f974a.getContext(), r10);
    L6:
        h(r12);
        b();
        return;
    L5:
        r12 = null;
        goto L6
    }

    public void h(ColorStateList r10) {
        if (r10 != null) goto L4;
        this.f977d = null;
    L8:
        b();
        return;
    L4:
        if (this.f977d != null) goto L6;
        this.f977d = new z();
    L6:
        z r11 = this.f977d;
        r11.f1161a = r10;
        r11.f1164d = true;
        goto L8
    }

    public void i(ColorStateList r10) {
        if (this.f978e != null) goto L5;
        this.f978e = new z();
    L5:
        z r11 = this.f978e;
        r11.f1161a = r10;
        r11.f1164d = true;
        b();
    }

    public void j(PorterDuff.Mode r10) {
        if (this.f978e != null) goto L5;
        this.f978e = new z();
    L5:
        z r11 = this.f978e;
        r11.f1162b = r10;
        r11.f1163c = true;
        b();
    }

    public final boolean k() {
        if (this.f977d == null) goto L5;
        return true;
    L5:
        return false;
    }
}
