package androidx.recyclerview.widget;

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

/* JADX INFO: loaded from: classes.dex */
public class e extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    public static final int[] D = null;
    public static final int[] E = null;
    public int A;
    public final Runnable B;
    public final RecyclerView.OnScrollListener C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f4383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f4384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f4387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f4388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f4389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f4390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f4393m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4394n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4395o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f4396p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4397q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4398r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f4399s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f4400t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f4401u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4402v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4403w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f4404x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f4405y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f4406z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f4407a;

        public a(e r10) {
            this.f4407a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4407a.h(500);
        }
    }

    public class b extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f4408a;

        public b(e r10) {
            this.f4408a = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView r10, int r11, int r12) {
            this.f4408a.s(r10.computeHorizontalScrollOffset(), r10.computeVerticalScrollOffset());
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f4410b;

        public c(e r10) {
            this.f4410b = r10;
            this.f4409a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.f4409a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            if (this.f4409a == false) goto L7;
            this.f4409a = false;
            return;
        L7:
            if (((Float) this.f4410b.f4406z.getAnimatedValue()).floatValue() != 0.0f) goto L9;
            e r11 = this.f4410b;
            r11.A = 0;
            r11.p(0);
            return;
        L9:
            e r12 = this.f4410b;
            r12.A = 2;
            r12.m();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f4411a;

        public d(e r10) {
            this.f4411a = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            int r11 = (int) (((Float) r10.getAnimatedValue()).floatValue() * 255.0f);
            this.f4411a.f4383c.setAlpha(r11);
            this.f4411a.f4384d.setAlpha(r11);
            this.f4411a.m();
        }
    }

    static {
        D = new int[]{R.attr.state_pressed};
        E = new int[0];
    }

    public e(RecyclerView r10, StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14, int r15, int r16, int r17) {
        this.f4397q = 0;
        this.f4398r = 0;
        this.f4400t = false;
        this.f4401u = false;
        this.f4402v = 0;
        this.f4403w = 0;
        this.f4404x = new int[2];
        this.f4405y = new int[2];
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f4406z = r18;
        this.A = 0;
        this.B = new a(this);
        this.C = new b(this);
        this.f4383c = r11;
        this.f4384d = r12;
        this.f4387g = r13;
        this.f4388h = r14;
        this.f4385e = Math.max(r15, r11.getIntrinsicWidth());
        this.f4386f = Math.max(r15, r12.getIntrinsicWidth());
        this.f4389i = Math.max(r15, r13.getIntrinsicWidth());
        this.f4390j = Math.max(r15, r14.getIntrinsicWidth());
        this.f4381a = r16;
        this.f4382b = r17;
        r11.setAlpha(PrivateKeyType.INVALID);
        r12.setAlpha(PrivateKeyType.INVALID);
        r18.addListener(new c(this));
        r18.addUpdateListener(new d(this));
        a(r10);
    }

    public void a(RecyclerView r10) {
        RecyclerView r11 = this.f4399s;
        if (r11 != r10) goto L5;
        return;
    L5:
        if (r11 == null) goto L7;
        c();
    L7:
        this.f4399s = r10;
        if (r10 == null) goto L11;
        q();
        return;
    }

    public final void b() {
        this.f4399s.removeCallbacks(this.B);
    }

    public final void c() {
        this.f4399s.removeItemDecoration(this);
        this.f4399s.removeOnItemTouchListener(this);
        this.f4399s.removeOnScrollListener(this.C);
        b();
    }

    public final void d(Canvas r10) {
        int r11 = this.f4398r;
        int r12 = this.f4389i;
        int r13 = r11 - r12;
        int r14 = this.f4395o;
        int r15 = this.f4394n;
        int r16 = r14 - (r15 / 2);
        this.f4387g.setBounds(0, 0, r15, r12);
        this.f4388h.setBounds(0, 0, this.f4397q, this.f4390j);
        r10.translate(0.0f, r13);
        this.f4388h.draw(r10);
        r10.translate(r16, 0.0f);
        this.f4387g.draw(r10);
        r10.translate(-r16, -r13);
    }

    public final void e(Canvas r10) {
        int r11 = this.f4397q;
        int r12 = this.f4385e;
        int r13 = r11 - r12;
        int r14 = this.f4392l;
        int r15 = this.f4391k;
        int r16 = r14 - (r15 / 2);
        this.f4383c.setBounds(0, 0, r12, r15);
        this.f4384d.setBounds(0, 0, this.f4386f, this.f4398r);
        if (j() == false) goto L5;
        this.f4384d.draw(r10);
        r10.translate(this.f4385e, r16);
        r10.scale(-1.0f, 1.0f);
        this.f4383c.draw(r10);
        r10.scale(-1.0f, 1.0f);
        r10.translate(-this.f4385e, -r16);
        return;
    L5:
        r10.translate(r13, 0.0f);
        this.f4384d.draw(r10);
        r10.translate(0.0f, r16);
        this.f4383c.draw(r10);
        r10.translate(-r13, -r16);
    }

    public final int[] f() {
        int[] r10 = this.f4405y;
        int r11 = this.f4382b;
        r10[0] = r11;
        r10[1] = this.f4397q - r11;
        return r10;
    }

    public final int[] g() {
        int[] r10 = this.f4404x;
        int r11 = this.f4382b;
        r10[0] = r11;
        r10[1] = this.f4398r - r11;
        return r10;
    }

    public void h(int r10) {
        int r11 = this.A;
        if (r11 == 1) goto L6;
        if (r11 != 2) goto L9;
    L7:
        this.A = 3;
        ValueAnimator r12 = this.f4406z;
        r12.setFloatValues(new float[]{((Float) r12.getAnimatedValue()).floatValue(), 0.0f});
        this.f4406z.setDuration(r10);
        this.f4406z.start();
        return;
    L9:
        return;
    L6:
        this.f4406z.cancel();
        goto L7
    }

    public final void i(float r10) {
        int[] r11 = f();
        float r12 = Math.max(r11[0], Math.min(r11[1], r10));
        if (Math.abs(this.f4395o - r12) >= 2.0f) goto L5;
        return;
    L5:
        int r13 = o(this.f4396p, r12, r11, this.f4399s.computeHorizontalScrollRange(), this.f4399s.computeHorizontalScrollOffset(), this.f4397q);
        if (r13 == 0) goto L8;
        this.f4399s.scrollBy(r13, 0);
    L8:
        this.f4396p = r12;
    }

    public final boolean j() {
        if (ViewCompat.A(this.f4399s) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean k(float r10, float r11) {
        if (r11 < (this.f4398r - this.f4389i)) goto L9;
        int r12 = this.f4395o;
        int r13 = this.f4394n;
        if (r10 < (r12 - (r13 / 2))) goto L9;
        if (r10 > (r12 + (r13 / 2))) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean l(float r10, float r11) {
        if (j() == false) goto L8;
        if (r10 <= this.f4385e) goto L9;
    L14:
        return false;
    L9:
        int r12 = this.f4392l;
        int r13 = this.f4391k;
        if (r11 < (r12 - (r13 / 2))) goto L14;
        if (r11 > (r12 + (r13 / 2))) goto L14;
        return true;
    L8:
        if (r10 < (this.f4397q - this.f4385e)) goto L14;
        goto L9
    }

    public void m() {
        this.f4399s.invalidate();
    }

    public final void n(int r10) {
        b();
        this.f4399s.postDelayed(this.B, r10);
    }

    public final int o(float r10, float r11, int[] r12, int r13, int r14, int r15) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        if (this.f4397q == this.f4399s.getWidth()) goto L5;
    L16:
        this.f4397q = this.f4399s.getWidth();
        this.f4398r = this.f4399s.getHeight();
        p(0);
        return;
    L5:
        if (this.f4398r != this.f4399s.getHeight()) goto L16;
        if (this.A != 0) goto L10;
        return;
    L10:
        if (this.f4400t == false) goto L13;
        e(r10);
    L13:
        if (this.f4401u == false) goto L19;
        d(r10);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView r10, MotionEvent r11) {
        int r12 = this.f4402v;
        if (r12 != 1) goto L13;
        boolean r13 = l(r11.getX(), r11.getY());
        boolean r14 = k(r11.getX(), r11.getY());
        if (r11.getAction() != 0) goto L16;
        if (r13 == true) goto L8;
        if (r14 == true) goto L8;
        return false;
    L8:
        if (r14 == false) goto L10;
        this.f4403w = 1;
        this.f4396p = (int) r11.getX();
    L12:
        p(2);
    L15:
        return true;
    L10:
        if (r13 == false) goto L12;
        this.f4403w = 2;
        this.f4393m = (int) r11.getY();
        goto L12
    L16:
        return false;
    L13:
        if (r12 == 2) goto L15;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean r10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView r10, MotionEvent r11) {
        if (this.f4402v != 0) goto L6;
        return;
    L6:
        if (r11.getAction() != 0) goto L16;
        boolean r12 = l(r11.getX(), r11.getY());
        boolean r13 = k(r11.getX(), r11.getY());
        if (r12 == true) goto L10;
        if (r13 == true) goto L10;
        return;
    L10:
        if (r13 == false) goto L12;
        this.f4403w = 1;
        this.f4396p = (int) r11.getX();
    L14:
        p(2);
        return;
    L12:
        if (r12 == false) goto L14;
        this.f4403w = 2;
        this.f4393m = (int) r11.getY();
        goto L14
    L16:
        if (r11.getAction() != 1) goto L21;
        if (this.f4402v != 2) goto L21;
        this.f4393m = 0.0f;
        this.f4396p = 0.0f;
        p(1);
        this.f4403w = 0;
        return;
    L21:
        if (r11.getAction() == 2) goto L23;
        return;
    L23:
        if (this.f4402v != 2) goto L35;
        r();
        if (this.f4403w != 1) goto L28;
        i(r11.getX());
    L28:
        if (this.f4403w != 2) goto L36;
        t(r11.getY());
        return;
    L36:
        return;
    }

    public void p(int r10) {
        if (r10 == 2) goto L5;
    L7:
        if (r10 != 0) goto L9;
        m();
    L11:
        if (this.f4402v != 2) goto L15;
        if (r10 == 2) goto L15;
        this.f4383c.setState(E);
        n(1200);
    L17:
        this.f4402v = r10;
        return;
    L15:
        if (r10 != 1) goto L17;
        n(1500);
        goto L17
    L9:
        r();
        goto L11
    L5:
        if (this.f4402v == 2) goto L7;
        this.f4383c.setState(D);
        b();
        goto L7
    }

    public final void q() {
        this.f4399s.addItemDecoration(this);
        this.f4399s.addOnItemTouchListener(this);
        this.f4399s.addOnScrollListener(this.C);
    }

    public void r() {
        int r10 = this.A;
        if (r10 != 0) goto L5;
    L8:
        this.A = 1;
        ValueAnimator r11 = this.f4406z;
        r11.setFloatValues(new float[]{((Float) r11.getAnimatedValue()).floatValue(), 1.0f});
        this.f4406z.setDuration(500);
        this.f4406z.setStartDelay(0);
        this.f4406z.start();
        return;
    L5:
        if (r10 != 3) goto L10;
        this.f4406z.cancel();
        goto L8
    }

    public void s(int r10, int r11) {
        int r12 = this.f4399s.computeVerticalScrollRange();
        int r13 = this.f4398r;
        if ((r12 - r13) > 0) goto L5;
    L7:
        boolean r14 = false;
    L8:
        this.f4400t = r14;
        int r15 = this.f4399s.computeHorizontalScrollRange();
        int r16 = this.f4397q;
        if ((r15 - r16) > 0) goto L11;
    L13:
        boolean r17 = false;
    L14:
        this.f4401u = r17;
        boolean r18 = this.f4400t;
        if (r18 == true) goto L22;
        if (r17 == true) goto L22;
        if (this.f4402v == 0) goto L32;
        p(0);
        return;
    L32:
        return;
    L22:
        if (r18 == false) goto L25;
        float r19 = r13;
        this.f4392l = (int) ((r19 * (r11 + (r19 / 2.0f))) / r12);
        this.f4391k = Math.min(r13, (r13 * r13) / r12);
    L25:
        if (this.f4401u == false) goto L27;
        float r110 = r16;
        this.f4395o = (int) ((r110 * (r10 + (r110 / 2.0f))) / r15);
        this.f4394n = Math.min(r16, (r16 * r16) / r15);
    L27:
        int r20 = this.f4402v;
        if (r20 == 0) goto L30;
        if (r20 == 1) goto L30;
        return;
    L30:
        p(1);
        return;
    L11:
        if (r16 < this.f4381a) goto L13;
        r17 = true;
        goto L14
    L5:
        if (r13 < this.f4381a) goto L7;
        r14 = true;
        goto L8
    }

    public final void t(float r10) {
        int[] r11 = g();
        float r12 = Math.max(r11[0], Math.min(r11[1], r10));
        if (Math.abs(this.f4392l - r12) >= 2.0f) goto L5;
        return;
    L5:
        int r13 = o(this.f4393m, r12, r11, this.f4399s.computeVerticalScrollRange(), this.f4399s.computeVerticalScrollOffset(), this.f4398r);
        if (r13 == 0) goto L8;
        this.f4399s.scrollBy(0, r13);
    L8:
        this.f4393m = r12;
    }
}
