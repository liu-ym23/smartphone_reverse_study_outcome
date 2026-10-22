package v0;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends z {

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f5837x = {R.attr.state_pressed};
    public static final int[] y = new int[0];

    /* renamed from: a, reason: collision with root package name */
    public final int f5838a;

    /* renamed from: b, reason: collision with root package name */
    public final StateListDrawable f5839b;

    /* renamed from: c, reason: collision with root package name */
    public final Drawable f5840c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5841e;

    /* renamed from: f, reason: collision with root package name */
    public final StateListDrawable f5842f;

    /* renamed from: g, reason: collision with root package name */
    public final Drawable f5843g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5844h;

    /* renamed from: i, reason: collision with root package name */
    public final int f5845i;

    /* renamed from: j, reason: collision with root package name */
    public float f5846j;

    /* renamed from: k, reason: collision with root package name */
    public float f5847k;

    /* renamed from: n, reason: collision with root package name */
    public final RecyclerView f5850n;

    /* renamed from: u, reason: collision with root package name */
    public final ValueAnimator f5857u;

    /* renamed from: v, reason: collision with root package name */
    public int f5858v;

    /* renamed from: w, reason: collision with root package name */
    public final androidx.fragment.app.b f5859w;

    /* renamed from: l, reason: collision with root package name */
    public int f5848l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f5849m = 0;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f5851o = false;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f5852p = false;

    /* renamed from: q, reason: collision with root package name */
    public int f5853q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f5854r = 0;

    /* renamed from: s, reason: collision with root package name */
    public final int[] f5855s = new int[2];

    /* renamed from: t, reason: collision with root package name */
    public final int[] f5856t = new int[2];

    public j(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i8, int i9, int i10) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f5857u = valueAnimatorOfFloat;
        this.f5858v = 0;
        androidx.fragment.app.b bVar = new androidx.fragment.app.b(9, this);
        this.f5859w = bVar;
        h hVar = new h();
        this.f5839b = stateListDrawable;
        this.f5840c = drawable;
        this.f5842f = stateListDrawable2;
        this.f5843g = drawable2;
        this.d = Math.max(i8, stateListDrawable.getIntrinsicWidth());
        this.f5841e = Math.max(i8, drawable.getIntrinsicWidth());
        this.f5844h = Math.max(i8, stateListDrawable2.getIntrinsicWidth());
        this.f5845i = Math.max(i8, drawable2.getIntrinsicWidth());
        this.f5838a = i10;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new i(this));
        valueAnimatorOfFloat.addUpdateListener(new i1.a(1 == true ? 1 : 0, this));
        RecyclerView recyclerView2 = this.f5850n;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.f778m;
            b0 b0Var = recyclerView2.f776k;
            if (b0Var != null) {
                b0Var.b("Cannot remove item decoration during a scroll  or layout");
            }
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.v();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.f5850n;
            recyclerView3.f779n.remove(this);
            if (recyclerView3.f780o == this) {
                recyclerView3.f780o = null;
            }
            ArrayList arrayList2 = this.f5850n.f763c0;
            if (arrayList2 != null) {
                arrayList2.remove(hVar);
            }
            this.f5850n.removeCallbacks(bVar);
        }
        this.f5850n = recyclerView;
        ArrayList arrayList3 = recyclerView.f778m;
        b0 b0Var2 = recyclerView.f776k;
        if (b0Var2 != null) {
            b0Var2.b("Cannot add item decoration during a scroll  or layout");
        }
        if (arrayList3.isEmpty()) {
            recyclerView.setWillNotDraw(false);
        }
        arrayList3.add(this);
        recyclerView.v();
        recyclerView.requestLayout();
        this.f5850n.f779n.add(this);
        RecyclerView recyclerView4 = this.f5850n;
        if (recyclerView4.f763c0 == null) {
            recyclerView4.f763c0 = new ArrayList();
        }
        recyclerView4.f763c0.add(hVar);
    }

    public static int e(float f3, float f7, int[] iArr, int i8, int i9, int i10) {
        int i11 = iArr[1] - iArr[0];
        if (i11 != 0) {
            int i12 = i8 - i10;
            int i13 = (int) (((f7 - f3) / i11) * i12);
            int i14 = i9 + i13;
            if (i14 < i12 && i14 >= 0) {
                return i13;
            }
        }
        return 0;
    }

    @Override // v0.z
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        int i8 = this.f5848l;
        RecyclerView recyclerView2 = this.f5850n;
        if (i8 != recyclerView2.getWidth() || this.f5849m != recyclerView2.getHeight()) {
            this.f5848l = recyclerView2.getWidth();
            this.f5849m = recyclerView2.getHeight();
            f(0);
            return;
        }
        if (this.f5858v != 0) {
            if (this.f5851o) {
                int i9 = this.f5848l;
                int i10 = this.d;
                int i11 = i9 - i10;
                int i12 = 0 - (0 / 2);
                StateListDrawable stateListDrawable = this.f5839b;
                stateListDrawable.setBounds(0, 0, i10, 0);
                int i13 = this.f5841e;
                int i14 = this.f5849m;
                Drawable drawable = this.f5840c;
                drawable.setBounds(0, 0, i13, i14);
                int[] iArr = e0.a0.f2285a;
                if (recyclerView2.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i10, i12);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i10, -i12);
                } else {
                    canvas.translate(i11, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i12);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i11, -i12);
                }
            }
            if (this.f5852p) {
                int i15 = this.f5849m;
                int i16 = this.f5844h;
                int i17 = i15 - i16;
                StateListDrawable stateListDrawable2 = this.f5842f;
                stateListDrawable2.setBounds(0, 0, 0, i16);
                int i18 = this.f5848l;
                int i19 = this.f5845i;
                Drawable drawable2 = this.f5843g;
                drawable2.setBounds(0, 0, i18, i19);
                canvas.translate(0.0f, i17);
                drawable2.draw(canvas);
                canvas.translate(0 - (0 / 2), 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-r3, -i17);
            }
        }
    }

    public final boolean c(float f3, float f7) {
        return f7 >= ((float) (this.f5849m - this.f5844h)) && f3 >= ((float) (0 - (0 / 2))) && f3 <= ((float) ((0 / 2) + 0));
    }

    public final boolean d(float f3, float f7) {
        int[] iArr = e0.a0.f2285a;
        int layoutDirection = this.f5850n.getLayoutDirection();
        int i8 = this.d;
        if (layoutDirection != 1 ? f3 >= this.f5848l - i8 : f3 <= i8) {
            int i9 = 0 / 2;
            if (f7 >= 0 - i9 && f7 <= i9 + 0) {
                return true;
            }
        }
        return false;
    }

    public final void f(int i8) {
        androidx.fragment.app.b bVar = this.f5859w;
        StateListDrawable stateListDrawable = this.f5839b;
        if (i8 == 2 && this.f5853q != 2) {
            stateListDrawable.setState(f5837x);
            this.f5850n.removeCallbacks(bVar);
        }
        if (i8 == 0) {
            this.f5850n.invalidate();
        } else {
            g();
        }
        if (this.f5853q == 2 && i8 != 2) {
            stateListDrawable.setState(y);
            this.f5850n.removeCallbacks(bVar);
            this.f5850n.postDelayed(bVar, 1200);
        } else if (i8 == 1) {
            this.f5850n.removeCallbacks(bVar);
            this.f5850n.postDelayed(bVar, 1500);
        }
        this.f5853q = i8;
    }

    public final void g() {
        int i8 = this.f5858v;
        ValueAnimator valueAnimator = this.f5857u;
        if (i8 != 0) {
            if (i8 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.f5858v = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
