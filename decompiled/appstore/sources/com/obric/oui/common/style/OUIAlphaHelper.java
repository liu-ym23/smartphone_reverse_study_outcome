package com.obric.oui.common.style;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import com.obric.oui.utils.log.L;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.ref.WeakReference;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public class OUIAlphaHelper implements IOUIAlpha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f12965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f12971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f12975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AttributeSet f12976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12977m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12978n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f12979o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f12980p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ObjectAnimator f12981q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ObjectAnimator f12982r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f12983s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f12984t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12985u;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OUIAlphaHelper f12986a;

        public a(OUIAlphaHelper r10) {
            this.f12986a = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            OUIAlphaHelper.e(this.f12986a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            OUIAlphaHelper.e(this.f12986a);
        }
    }

    public OUIAlphaHelper(Context r10, AttributeSet r11, int r12, int r13) {
        this.f12966b = true;
        this.f12967c = false;
        this.f12968d = true;
        this.f12969e = false;
        this.f12970f = false;
        this.f12971g = 1.0f;
        this.f12972h = 0;
        this.f12973i = -1;
        this.f12974j = 0.3f;
        this.f12983s = 1;
        this.f12984t = Token$Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration();
        this.f12985u = 0;
        this.f12975k = r10;
        this.f12976l = r11;
        this.f12977m = r12;
        this.f12978n = r13;
    }

    public static /* synthetic */ void a(OUIAlphaHelper r10, ValueAnimator r11) {
        r10.k(r11);
    }

    public static /* synthetic */ Unit b(View r10) {
        return m(r10);
    }

    public static /* synthetic */ Unit c(boolean r10, View r11) {
        return n(r10, r11);
    }

    public static /* synthetic */ void d(OUIAlphaHelper r10, ValueAnimator r11) {
        r10.l(r11);
    }

    public static /* synthetic */ void e(OUIAlphaHelper r10) {
        r10.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Unit m(View r10) {
        if ((r10 instanceof IOUIAlpha) == false) goto L7;
        ((IOUIAlpha) r10).resetAlphaAnim();
        return null;
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Unit n(boolean r10, View r11) {
        if ((r11 instanceof IOUIAlpha) == false) goto L7;
        ((IOUIAlpha) r11).setKeepPressAlpha(r10);
        return null;
    L7:
        return null;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void disablePressReleaseAnim(boolean r10) {
        this.f12970f = r10;
    }

    public final int f(View r10) {
        int r11 = this.f12973i;
        if (r11 == (-1)) goto L5;
        return r11;
    L5:
        return ContextCompat.b(r10.getContext(), R$color.oui_fill_element_2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        View r10 = (View) this.f12965a.get();
        if (r10 != 0) goto L6;
        return;
    L6:
        if (this.f12966b == false) goto L15;
        if (r10.isPressed() == false) goto L10;
    L13:
        r10.setForeground(this.f12979o);
        return;
    L10:
        if ((r10 instanceof IOUILayout) == false) goto L15;
        if (((IOUILayout) r10).isFakePressed() == true) goto L13;
    L15:
        if (this.f12966b == false) goto L22;
        if ((r10 instanceof IOUILayout) == false) goto L22;
        if (((IOUILayout) r10).decideIsNeedUpdatePressedForegroundBySelf() == false) goto L22;
        r10.setForeground(this.f12979o);
        return;
    L22:
        if (this.f12969e == true) goto L24;
    L26:
        r10.setForeground(null);
        return;
    L24:
        if (r10.isSelected() == false) goto L26;
        r10.setForeground(this.f12980p);
    }

    public final void h(View r10) {
        int r11 = f(r10);
        int[] r12 = {ContextCompat.b(r10.getContext(), R$color.oui_accent_bg), ContextCompat.b(r10.getContext(), R$color.oui_functional_red_6)};
        this.f12972h = r11;
        TypedArray r13 = this.f12975k.obtainStyledAttributes(this.f12976l, R$styleable.OUIAlpha, this.f12977m, this.f12978n);
        int r14 = 0;
        if (this.f12976l == null) goto L5;
    L8:
        int r15 = r13.getIndexCount();
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L18;
        int r17 = r13.getIndex(r16);
        if (r17 != R$styleable.OUIAlpha_OUI_alpha_pressed) goto L14;
        this.f12972h = r13.getColor(r17, r11);
    L16:
        r16 = r16 + 1;
        goto L9
    L14:
        if (r17 != R$styleable.OUIAlpha_OUI_alpha_disabled) goto L16;
        this.f12974j = r13.getFloat(r17, -1.0f);
    L18:
        if (this.f12972h != r11) goto L27;
        Drawable r18 = r10.getBackground();
        if ((r18 instanceof ColorDrawable) == false) goto L27;
    L22:
        if (r14 >= 2) goto L27;
        if (((ColorDrawable) r18).getColor() != r12[r14]) goto L26;
        this.f12972h = ContextCompat.b(r10.getContext(), R$color.oui_pressed_on_color);
    L26:
        r14 = r14 + 1;
    L27:
        i(r10);
        return;
    L5:
        if (this.f12977m != 0) goto L8;
        if (this.f12978n == 0) goto L18;
        goto L8
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void handleTouchEvent(MotionEvent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = r10.getAction();
        if (r11 == 1) goto L10;
        if (r11 == 3) goto L10;
        return;
    L10:
        if (this.f12970f == false) goto L13;
        s();
        return;
    }

    public final void i(View r10) {
        if (this.f12985u <= 0) goto L5;
        GradientDrawable r11 = new GradientDrawable();
        this.f12979o = r11;
        r11.setCornerRadius(this.f12985u);
        ((GradientDrawable) this.f12979o).setColor(this.f12972h);
        GradientDrawable r12 = new GradientDrawable();
        this.f12980p = r12;
        r12.setCornerRadius(this.f12985u);
        ((GradientDrawable) this.f12980p).setColor(this.f12972h);
    L6:
        boolean r13 = true;
        if (this.f12972h <= 0) goto L9;
        boolean r14 = true;
    L10:
        this.f12966b = r14;
        if (this.f12974j > 0.0f) goto L14;
        r13 = false;
    L14:
        this.f12968d = r13;
        o(r10, r10.isEnabled());
        ObjectAnimator r15 = ObjectAnimator.ofInt(this.f12979o, "alpha", new int[]{PrivateKeyType.INVALID, PrivateKeyType.INVALID});
        this.f12981q = r15;
        r15.setDuration(this.f12983s);
        this.f12981q.setInterpolator(null);
        this.f12981q.addUpdateListener(new d(this));
        ObjectAnimator r16 = ObjectAnimator.ofInt(this.f12979o, "alpha", new int[]{PrivateKeyType.INVALID, 0});
        this.f12982r = r16;
        r16.setDuration(this.f12984t);
        this.f12982r.setInterpolator(null);
        this.f12982r.addListener(new a(this));
        this.f12982r.addUpdateListener(new e(this));
        return;
    L9:
        r14 = false;
        goto L10
    L5:
        this.f12979o = new ColorDrawable(this.f12972h);
        this.f12980p = new ColorDrawable(this.f12972h);
        goto L6
    }

    public void j(View r10) {
        this.f12965a = new WeakReference(r10);
        h(r10);
    }

    public final /* synthetic */ void k(ValueAnimator r10) {
        p(r10, "press anim");
    }

    public final /* synthetic */ void l(ValueAnimator r10) {
        p(r10, "release anim");
    }

    public void o(View r10, boolean r11) {
        View r12 = (View) this.f12965a.get();
        if (r12 != null) goto L6;
        return;
    L6:
        if (this.f12968d == false) goto L10;
        if (r11 == false) goto L9;
        float r13 = this.f12971g;
    L11:
        if (r10 != r12) goto L13;
    L15:
        r12.setAlpha(r13);
        return;
    L13:
        if (r12.isEnabled() == r11) goto L15;
        r12.setEnabled(r11);
        goto L15
    L9:
        r13 = this.f12974j;
        goto L11
    L10:
        r13 = this.f12971g;
        goto L11
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onPressedChanged(View r10, boolean r11) {
        if (((View) this.f12965a.get()) != null) goto L5;
        return;
    L5:
        this.f12981q.cancel();
        this.f12982r.cancel();
        if (this.f12966b == true) goto L8;
        return;
    L8:
        if (this.f12967c == true) goto L17;
        if (r11 == false) goto L12;
        g();
        this.f12981q.start();
        return;
    L12:
        if (this.f12970f == false) goto L14;
        s();
        return;
    L14:
        this.f12982r.start();
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onSelectedChanged(View r10, boolean r11) {
        if (this.f12969e == false) goto L6;
        g();
        return;
    }

    public final void p(ValueAnimator r10, String r11) {
        KeyEvent.Callback r12 = (View) this.f12965a.get();
        if ((r12 instanceof IOUILayout) == true) goto L5;
        return;
    L5:
        IOUILayout r13 = (IOUILayout) r12;
        Object r14 = r10.getAnimatedValue("alpha");
        if (r13.shouldUpdateDividerColorOnPress() == false) goto L16;
        if ((r14 instanceof Integer) == false) goto L16;
        int r15 = ((Integer) r14).intValue();
        if (r15 >= 0) goto L12;
    L14:
        L.b("OUIAlphaHelper", "pressColorAnimSideEffect, invalid alpha: " + r15 + ", scene: " + r11);
        goto L16
    L12:
        if (r15 > 255) goto L14;
        r13.updateDividerColorStrength((PrivateKeyType.INVALID - r15) / 255.0f);
    L16:
        if ((r14 instanceof Integer) == false) goto L19;
        r13.onPressAlphaChange(((Integer) r14).intValue());
        return;
    }

    public void q(boolean r10, boolean r11) {
        this.f12966b = r10;
        View r12 = (View) this.f12965a.get();
        if (r12 == null) goto L7;
        if (r11 == false) goto L8;
        onPressedChanged(r12, r12.isPressed());
        return;
    L8:
        return;
    }

    public void r(int r10) {
        if (this.f12985u == r10) goto L10;
        this.f12985u = r10;
        View r11 = (View) this.f12965a.get();
        if (r11 != null) goto L8;
        L.b("OUIAlphaHelper", "setRadius: owner is null");
        return;
    L8:
        i(r11);
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void refreshColors(String r10) {
        View r11 = (View) this.f12965a.get();
        if (r11 != null) goto L6;
        L.b("OUIAlphaHelper", "refreshColors: owner is null");
        return;
    L6:
        h(r11);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void resetAlphaAnim() {
        this.f12967c = false;
        if (this.f12966b == false) goto L5;
        s();
    L5:
        td.h.h((View) this.f12965a.get(), new f());
    }

    public final void s() {
        this.f12981q.cancel();
        this.f12982r.cancel();
        this.f12979o.setAlpha(0);
        View r10 = (View) this.f12965a.get();
        if (r10 == null) goto L6;
        r10.setForeground(null);
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r10) {
        this.f12968d = r10;
        View r11 = (View) this.f12965a.get();
        if (r11 == null) goto L6;
        o(r11, r11.isEnabled());
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r10) {
        q(r10, false);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenSelected(boolean r10) {
        this.f12969e = r10;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(final boolean r10) {
        L.i("OUIAlphaHelper", "setKeepPressAlpha, " + r10 + ", target: " + this.f12965a.get());
        if (this.f12967c == r10) goto L7;
        this.f12967c = r10;
        if (r10 == true) goto L7;
        onPressedChanged((View) this.f12965a.get(), false);
    L7:
        td.h.h((View) this.f12965a.get(), new c(r10));
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setOverridePressColor(int r10) {
        if (this.f12973i == r10) goto L6;
        this.f12973i = r10;
        return;
    }
}
