package aqa;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements xpa.a, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f15981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f15982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f15983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f15984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f15985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f15986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f15988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ypa.a f15989i;

    public final boolean a() {
        if (this.f15988h == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f15989i.a(this.f15981a) == false) goto L7;
        return true;
    }

    public final boolean b() {
        if (this.f15987g == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f15989i.b(this.f15981a) == false) goto L7;
        return true;
    }

    public a(View r100) {
        this.f15986f = 0;
        this.f15987g = true;
        this.f15988h = true;
        this.f15989i = new ypa.a();
        this.f15983c = r100;
        this.f15982b = r100;
        this.f15981a = r100;
    }

    public final a e(int r100) {
        View r101 = this.f15983c;
        if (r101 == null) goto L13;
        if (r100 == 0) goto L15;
        if (r100 < 0) goto L7;
    L8:
        if (r100 > 0) goto L10;
        return null;
    L10:
        if (this.f15983c.canScrollVertically(-1) == false) goto L17;
    L11:
        this.f15986f = r100;
        return this;
    L17:
        return null;
    L7:
        if (r101.canScrollVertically(1) == true) goto L11;
    L15:
        return null;
    L13:
        return null;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        int r101 = ((Integer) r100.getAnimatedValue()).intValue();
        float r102 = (r101 - this.f15986f) * this.f15983c.getScaleY();     // Catch: Throwable -> L8
        View r103 = this.f15983c;     // Catch: Throwable -> L8
        if ((r103 instanceof AbsListView) == false) goto L6;
        float r104 = zpa.b.f573281a;     // Catch: Throwable -> L8
        ((AbsListView) r103).scrollListBy((int) r102);     // Catch: Throwable -> L8
    L12:
    L10:
        this.f15986f = r101;
        return;
    L6:
        r103.scrollBy(0, (int) r102);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public static View c(View r100, PointF r101, View r102) {
        if ((r100 instanceof ViewGroup) == false) goto L14;
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount();
        PointF r105 = new PointF();
    L5:
        if (r104 <= 0) goto L14;
        r104 = r104 - 1;
        View r106 = r103.getChildAt(r104);
        if (zpa.b.d(r103, r106, r101.x, r101.y, r105) == false) goto L5;
        if ((r106 instanceof ViewPager) == false) goto L11;
    L12:
        r101.offset(r105.x, r105.y);
        View r107 = c(r106, r101, r102);
        r101.offset(-r105.x, -r105.y);
        return r107;
    L11:
        if (zpa.b.c(r106) == false) goto L12;
        return r106;
    L14:
        return r102;
    }

    public final void d(int r100, int r101, int r102) {
        boolean r103 = true;
        if (r101 == (-1)) goto L11;
        View r104 = this.f15982b.findViewById(r101);
        if (r104 == null) goto L11;
        if (r100 <= 0) goto L9;
        r104.setTranslationY(r100);
        boolean r105 = true;
    L12:
        if (r102 == (-1)) goto L20;
        View r106 = this.f15982b.findViewById(r102);
        if (r106 == null) goto L20;
        if (r100 >= 0) goto L18;
        r106.setTranslationY(r100);
    L21:
        if (r103 == true) goto L23;
        this.f15982b.setTranslationY(r100);
    L24:
        View r107 = this.f15984d;
        if (r107 == null) goto L27;
        r107.setTranslationY(Math.max(0, r100));
    L27:
        View r108 = this.f15985e;
        if (r108 == null) goto L31;
        r108.setTranslationY(Math.min(0, r100));
        return;
    L31:
        return;
    L23:
        this.f15982b.setTranslationY(0.0f);
        goto L24
    L18:
        if (r106.getTranslationY() >= 0.0f) goto L20;
        r106.setTranslationY(0.0f);
    L20:
        r103 = r105;
        goto L21
    L9:
        if (r104.getTranslationY() <= 0.0f) goto L11;
        r104.setTranslationY(0.0f);
    L11:
        r105 = false;
        goto L12
    }
}
