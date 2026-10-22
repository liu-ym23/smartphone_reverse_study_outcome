package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class m extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SeekBar f1043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f1044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorStateList f1045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f1046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1048i;

    public m(SeekBar r10) {
        super(r10);
        this.f1045f = null;
        this.f1046g = null;
        this.f1047h = false;
        this.f1048i = false;
        this.f1043d = r10;
    }

    @Override // androidx.appcompat.widget.k
    public void c(AttributeSet r10, int r11) {
        super.c(r10, r11);
        Context r12 = this.f1043d.getContext();
        int[] r13 = R$styleable.AppCompatSeekBar;
        b0 r14 = b0.v(r12, r10, r13, r11, 0);
        SeekBar r15 = this.f1043d;
        ViewCompat.n0(r15, r15.getContext(), r13, r10, r14.r(), r11, 0);
        Drawable r16 = r14.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (r16 == null) goto L5;
        this.f1043d.setThumb(r16);
    L5:
        j(r14.g(R$styleable.AppCompatSeekBar_tickMark));
        int r17 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (r14.s(r17) == false) goto L8;
        this.f1046g = r.e(r14.k(r17, -1), this.f1046g);
        this.f1048i = true;
    L8:
        int r18 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (r14.s(r18) == false) goto L11;
        this.f1045f = r14.c(r18);
        this.f1047h = true;
    L11:
        r14.w();
        f();
    }

    public final void f() {
        Drawable r10 = this.f1044e;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f1047h == false) goto L7;
    L8:
        Drawable r11 = o.a.l(r10.mutate());
        this.f1044e = r11;
        if (this.f1047h == false) goto L12;
        o.a.i(r11, this.f1045f);
    L12:
        if (this.f1048i == false) goto L15;
        o.a.j(this.f1044e, this.f1046g);
    L15:
        if (this.f1044e.isStateful() == false) goto L20;
        this.f1044e.setState(this.f1043d.getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f1048i == true) goto L8;
    }

    public void g(Canvas r10) {
        if (this.f1044e == null) goto L18;
        int r11 = this.f1043d.getMax();
        int r12 = 1;
        if (r11 <= 1) goto L19;
        int r13 = this.f1044e.getIntrinsicWidth();
        int r14 = this.f1044e.getIntrinsicHeight();
        if (r13 < 0) goto L9;
        int r15 = r13 / 2;
    L10:
        if (r14 < 0) goto L12;
        r12 = r14 / 2;
    L12:
        this.f1044e.setBounds(-r15, -r12, r15, r12);
        float r16 = ((this.f1043d.getWidth() - this.f1043d.getPaddingLeft()) - this.f1043d.getPaddingRight()) / r11;
        int r17 = r10.save();
        r10.translate(this.f1043d.getPaddingLeft(), this.f1043d.getHeight() / 2);
        int r18 = 0;
    L13:
        if (r18 > r11) goto L15;
        this.f1044e.draw(r10);
        r10.translate(r16, 0.0f);
        r18 = r18 + 1;
        goto L13
    L15:
        r10.restoreToCount(r17);
        return;
    L9:
        r15 = 1;
        goto L10
    L19:
        return;
    }

    public void h() {
        Drawable r10 = this.f1044e;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isStateful() == true) goto L7;
        return;
    L7:
        if (r10.setState(this.f1043d.getDrawableState()) == false) goto L12;
        this.f1043d.invalidateDrawable(r10);
        return;
    }

    public void i() {
        Drawable r10 = this.f1044e;
        if (r10 == null) goto L6;
        r10.jumpToCurrentState();
        return;
    }

    public void j(Drawable r10) {
        Drawable r11 = this.f1044e;
        if (r11 == null) goto L5;
        r11.setCallback(null);
    L5:
        this.f1044e = r10;
        if (r10 == null) goto L11;
        r10.setCallback(this.f1043d);
        o.a.g(r10, ViewCompat.A(this.f1043d));
        if (r10.isStateful() == false) goto L10;
        r10.setState(this.f1043d.getDrawableState());
    L10:
        f();
    L11:
        this.f1043d.invalidate();
    }
}
