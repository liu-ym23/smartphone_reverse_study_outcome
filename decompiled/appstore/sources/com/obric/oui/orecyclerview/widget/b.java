package com.obric.oui.orecyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes4.dex */
public class b extends RecyclerView.k implements RecyclerView.OnItemTouchListener {
    public static final int[] D = null;
    public static final int[] E = null;
    public int A;
    public final Runnable B;
    public final RecyclerView.m C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f15652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f15653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f15655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f15656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f15657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f15658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f15659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f15661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f15662m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f15663n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f15664o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f15665p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f15666q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f15667r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f15668s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f15669t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f15670u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f15671v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f15672w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f15673x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f15674y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f15675z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f15676a;

        public a(b r10) {
            this.f15676a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15676a.n(500);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.b$b, reason: collision with other inner class name */
    public class C0199b extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f15677a;

        public C0199b(b r10) {
            this.f15677a = r10;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void b(RecyclerView r10, int r11, int r12) {
            this.f15677a.y(r10.computeHorizontalScrollOffset(), r10.computeVerticalScrollOffset());
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f15679b;

        public c(b r10) {
            this.f15679b = r10;
            this.f15678a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.f15678a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            if (this.f15678a == false) goto L7;
            this.f15678a = false;
            return;
        L7:
            if (((Float) this.f15679b.f15675z.getAnimatedValue()).floatValue() != 0.0f) goto L9;
            b r11 = this.f15679b;
            r11.A = 0;
            r11.v(0);
            return;
        L9:
            b r12 = this.f15679b;
            r12.A = 2;
            r12.s();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f15680a;

        public d(b r10) {
            this.f15680a = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            int r11 = (int) (((Float) r10.getAnimatedValue()).floatValue() * 255.0f);
            this.f15680a.f15652c.setAlpha(r11);
            this.f15680a.f15653d.setAlpha(r11);
            this.f15680a.s();
        }
    }

    static {
        D = new int[]{R.attr.state_pressed};
        E = new int[0];
    }

    public b(RecyclerView r10, StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14, int r15, int r16, int r17) {
        this.f15666q = 0;
        this.f15667r = 0;
        this.f15669t = false;
        this.f15670u = false;
        this.f15671v = 0;
        this.f15672w = 0;
        this.f15673x = new int[2];
        this.f15674y = new int[2];
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f15675z = r18;
        this.A = 0;
        this.B = new a(this);
        this.C = new C0199b(this);
        this.f15652c = r11;
        this.f15653d = r12;
        this.f15656g = r13;
        this.f15657h = r14;
        this.f15654e = Math.max(r15, r11.getIntrinsicWidth());
        this.f15655f = Math.max(r15, r12.getIntrinsicWidth());
        this.f15658i = Math.max(r15, r13.getIntrinsicWidth());
        this.f15659j = Math.max(r15, r14.getIntrinsicWidth());
        this.f15650a = r16;
        this.f15651b = r17;
        r11.setAlpha(PrivateKeyType.INVALID);
        r12.setAlpha(PrivateKeyType.INVALID);
        r18.addListener(new c(this));
        r18.addUpdateListener(new d(this));
        g(r10);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public void f(Canvas r10, RecyclerView r11, RecyclerView.q r12) {
        if (this.f15666q == this.f15668s.getWidth()) goto L5;
    L16:
        this.f15666q = this.f15668s.getWidth();
        this.f15667r = this.f15668s.getHeight();
        v(0);
        return;
    L5:
        if (this.f15667r != this.f15668s.getHeight()) goto L16;
        if (this.A != 0) goto L10;
        return;
    L10:
        if (this.f15669t == false) goto L13;
        k(r10);
    L13:
        if (this.f15670u == false) goto L19;
        j(r10);
        return;
    }

    public void g(RecyclerView r10) {
        RecyclerView r11 = this.f15668s;
        if (r11 != r10) goto L5;
        return;
    L5:
        if (r11 == null) goto L7;
        i();
    L7:
        this.f15668s = r10;
        if (r10 == null) goto L11;
        w();
        return;
    }

    public final void h() {
        this.f15668s.removeCallbacks(this.B);
    }

    public final void i() {
        this.f15668s.U0(this);
        this.f15668s.removeOnItemTouchListener(this);
        this.f15668s.removeOnScrollListener(this.C);
        h();
    }

    public final void j(Canvas r10) {
        int r11 = this.f15667r;
        int r12 = this.f15658i;
        int r13 = r11 - r12;
        int r14 = this.f15664o;
        int r15 = this.f15663n;
        int r16 = r14 - (r15 / 2);
        this.f15656g.setBounds(0, 0, r15, r12);
        this.f15657h.setBounds(0, 0, this.f15666q, this.f15659j);
        r10.translate(0.0f, r13);
        this.f15657h.draw(r10);
        r10.translate(r16, 0.0f);
        this.f15656g.draw(r10);
        r10.translate(-r16, -r13);
    }

    public final void k(Canvas r10) {
        int r11 = this.f15666q;
        int r12 = this.f15654e;
        int r13 = r11 - r12;
        int r14 = this.f15661l;
        int r15 = this.f15660k;
        int r16 = r14 - (r15 / 2);
        this.f15652c.setBounds(0, 0, r12, r15);
        this.f15653d.setBounds(0, 0, this.f15655f, this.f15667r);
        if (p() == false) goto L5;
        this.f15653d.draw(r10);
        r10.translate(this.f15654e, r16);
        r10.scale(-1.0f, 1.0f);
        this.f15652c.draw(r10);
        r10.scale(-1.0f, 1.0f);
        r10.translate(-this.f15654e, -r16);
        return;
    L5:
        r10.translate(r13, 0.0f);
        this.f15653d.draw(r10);
        r10.translate(0.0f, r16);
        this.f15652c.draw(r10);
        r10.translate(-r13, -r16);
    }

    public final int[] l() {
        int[] r10 = this.f15674y;
        int r11 = this.f15651b;
        r10[0] = r11;
        r10[1] = this.f15666q - r11;
        return r10;
    }

    public final int[] m() {
        int[] r10 = this.f15673x;
        int r11 = this.f15651b;
        r10[0] = r11;
        r10[1] = this.f15667r - r11;
        return r10;
    }

    public void n(int r10) {
        int r11 = this.A;
        if (r11 == 1) goto L6;
        if (r11 != 2) goto L9;
    L7:
        this.A = 3;
        ValueAnimator r12 = this.f15675z;
        r12.setFloatValues(new float[]{((Float) r12.getAnimatedValue()).floatValue(), 0.0f});
        this.f15675z.setDuration(r10);
        this.f15675z.start();
        return;
    L9:
        return;
    L6:
        this.f15675z.cancel();
        goto L7
    }

    public final void o(float r10) {
        int[] r11 = l();
        float r12 = Math.max(r11[0], Math.min(r11[1], r10));
        if (Math.abs(this.f15664o - r12) >= 2.0f) goto L5;
        return;
    L5:
        int r13 = u(this.f15665p, r12, r11, this.f15668s.computeHorizontalScrollRange(), this.f15668s.computeHorizontalScrollOffset(), this.f15666q);
        if (r13 == 0) goto L8;
        this.f15668s.scrollBy(r13, 0);
    L8:
        this.f15665p = r12;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView r10, MotionEvent r11) {
        int r12 = this.f15671v;
        if (r12 != 1) goto L13;
        boolean r13 = r(r11.getX(), r11.getY());
        boolean r14 = q(r11.getX(), r11.getY());
        if (r11.getAction() != 0) goto L16;
        if (r13 == true) goto L8;
        if (r14 == true) goto L8;
        return false;
    L8:
        if (r14 == false) goto L10;
        this.f15672w = 1;
        this.f15665p = (int) r11.getX();
    L12:
        v(2);
    L15:
        return true;
    L10:
        if (r13 == false) goto L12;
        this.f15672w = 2;
        this.f15662m = (int) r11.getY();
        goto L12
    L16:
        return false;
    L13:
        if (r12 == 2) goto L15;
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean r10) {
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView r10, MotionEvent r11) {
        if (this.f15671v != 0) goto L6;
        return;
    L6:
        if (r11.getAction() != 0) goto L16;
        boolean r12 = r(r11.getX(), r11.getY());
        boolean r13 = q(r11.getX(), r11.getY());
        if (r12 == true) goto L10;
        if (r13 == true) goto L10;
        return;
    L10:
        if (r13 == false) goto L12;
        this.f15672w = 1;
        this.f15665p = (int) r11.getX();
    L14:
        v(2);
        return;
    L12:
        if (r12 == false) goto L14;
        this.f15672w = 2;
        this.f15662m = (int) r11.getY();
        goto L14
    L16:
        if (r11.getAction() != 1) goto L21;
        if (this.f15671v != 2) goto L21;
        this.f15662m = 0.0f;
        this.f15665p = 0.0f;
        v(1);
        this.f15672w = 0;
        return;
    L21:
        if (r11.getAction() == 2) goto L23;
        return;
    L23:
        if (this.f15671v != 2) goto L35;
        x();
        if (this.f15672w != 1) goto L28;
        o(r11.getX());
    L28:
        if (this.f15672w != 2) goto L36;
        z(r11.getY());
        return;
    L36:
        return;
    }

    public final boolean p() {
        if (ViewCompat.A(this.f15668s) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean q(float r10, float r11) {
        if (r11 < (this.f15667r - this.f15658i)) goto L9;
        int r12 = this.f15664o;
        int r13 = this.f15663n;
        if (r10 < (r12 - (r13 / 2))) goto L9;
        if (r10 > (r12 + (r13 / 2))) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean r(float r10, float r11) {
        if (p() == false) goto L8;
        if (r10 <= this.f15654e) goto L9;
    L14:
        return false;
    L9:
        int r12 = this.f15661l;
        int r13 = this.f15660k;
        if (r11 < (r12 - (r13 / 2))) goto L14;
        if (r11 > (r12 + (r13 / 2))) goto L14;
        return true;
    L8:
        if (r10 < (this.f15666q - this.f15654e)) goto L14;
        goto L9
    }

    public void s() {
        this.f15668s.invalidate();
    }

    public final void t(int r10) {
        h();
        this.f15668s.postDelayed(this.B, r10);
    }

    public final int u(float r10, float r11, int[] r12, int r13, int r14, int r15) {
        int r16 = r12[1] - r12[0];
        if (r16 != 0) goto L5;
        return 0;
    L5:
        int r17 = r13 - r15;
        int r18 = (int) (((r11 - r10) / r16) * r17);
        int r19 = r14 + r18;
        if (r19 >= r17) goto L9;
        if (r19 < 0) goto L9;
        return r18;
    L9:
        return 0;
    }

    public void v(int r10) {
        if (r10 == 2) goto L5;
    L7:
        if (r10 != 0) goto L9;
        s();
    L11:
        if (this.f15671v != 2) goto L15;
        if (r10 == 2) goto L15;
        this.f15652c.setState(E);
        t(1200);
    L17:
        this.f15671v = r10;
        return;
    L15:
        if (r10 != 1) goto L17;
        t(1500);
        goto L17
    L9:
        x();
        goto L11
    L5:
        if (this.f15671v == 2) goto L7;
        this.f15652c.setState(D);
        h();
        goto L7
    }

    public final void w() {
        this.f15668s.i(this);
        this.f15668s.addOnItemTouchListener(this);
        this.f15668s.addOnScrollListener(this.C);
    }

    public void x() {
        int r10 = this.A;
        if (r10 != 0) goto L5;
    L8:
        this.A = 1;
        ValueAnimator r11 = this.f15675z;
        r11.setFloatValues(new float[]{((Float) r11.getAnimatedValue()).floatValue(), 1.0f});
        this.f15675z.setDuration(500);
        this.f15675z.setStartDelay(0);
        this.f15675z.start();
        return;
    L5:
        if (r10 != 3) goto L10;
        this.f15675z.cancel();
        goto L8
    }

    public void y(int r10, int r11) {
        int r12 = this.f15668s.computeVerticalScrollRange();
        int r13 = this.f15667r;
        if ((r12 - r13) > 0) goto L5;
    L7:
        boolean r14 = false;
    L8:
        this.f15669t = r14;
        int r15 = this.f15668s.computeHorizontalScrollRange();
        int r16 = this.f15666q;
        if ((r15 - r16) > 0) goto L11;
    L13:
        boolean r17 = false;
    L14:
        this.f15670u = r17;
        boolean r18 = this.f15669t;
        if (r18 == true) goto L22;
        if (r17 == true) goto L22;
        if (this.f15671v == 0) goto L32;
        v(0);
        return;
    L32:
        return;
    L22:
        if (r18 == false) goto L25;
        float r19 = r13;
        this.f15661l = (int) ((r19 * (r11 + (r19 / 2.0f))) / r12);
        this.f15660k = Math.min(r13, (r13 * r13) / r12);
    L25:
        if (this.f15670u == false) goto L27;
        float r110 = r16;
        this.f15664o = (int) ((r110 * (r10 + (r110 / 2.0f))) / r15);
        this.f15663n = Math.min(r16, (r16 * r16) / r15);
    L27:
        int r20 = this.f15671v;
        if (r20 == 0) goto L30;
        if (r20 == 1) goto L30;
        return;
    L30:
        v(1);
        return;
    L11:
        if (r16 < this.f15650a) goto L13;
        r17 = true;
        goto L14
    L5:
        if (r13 < this.f15650a) goto L7;
        r14 = true;
        goto L8
    }

    public final void z(float r10) {
        int[] r11 = m();
        float r12 = Math.max(r11[0], Math.min(r11[1], r10));
        if (Math.abs(this.f15661l - r12) >= 2.0f) goto L5;
        return;
    L5:
        int r13 = u(this.f15662m, r12, r11, this.f15668s.computeVerticalScrollRange(), this.f15668s.computeVerticalScrollOffset(), this.f15667r);
        if (r13 == 0) goto L8;
        this.f15668s.scrollBy(0, r13);
    L8:
        this.f15662m = r12;
    }
}
