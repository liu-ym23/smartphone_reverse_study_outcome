package bj4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.bytedance.creativex.mediaimport.widget.gesture.ScaleGestureLayout;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScaleGestureLayout f19223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Rect f19224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Rect f19225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f19226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ cj4.a f19227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f19228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int[] f19229g;

    public /* synthetic */ l(ScaleGestureLayout r100, Rect r101, Rect r102, d r103, cj4.a r104) {
        this.f19223a = r100;
        this.f19224b = r101;
        this.f19225c = r102;
        this.f19226d = r103;
        this.f19227e = r104;
        this.f19228f = 0.0f;
        this.f19229g = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final ScaleGestureLayout r100 = this.f19223a;
        Rect r101 = this.f19224b;
        Rect r102 = this.f19225c;
        d r103 = this.f19226d;
        cj4.a r104 = this.f19227e;
        float r105 = this.f19228f;
        int[] r106 = this.f19229g;
        Rect r107 = r100.f204203p;
        if (r107 == null) goto L5;
        boolean r108 = r107.isEmpty();
    L6:
        if (r101 == null) goto L8;
        boolean r110 = r101.isEmpty();
    L9:
        if (r102 == null) goto L11;
        boolean r111 = r102.isEmpty();
    L13:
        if (r108 == true) goto L32;
        if (r110 == true) goto L32;
        if (r111 == true) goto L32;
        if (r101 == null) goto L35;
        if (r102 == null) goto L36;
        int[] r109 = new int[2];
        r100.getLocationOnScreen(r109);
        r101.offset(-r109[0], -r109[1]);
        r102.offset(-r109[0], -r109[1]);
        AnimatorSet r112 = ej4.a.b(new Matrix(ej4.a.a(r101, r100.getWidth(), r100.getHeight(), r100.f204203p, r103)), new Matrix(), r100.f204203p, r104, new n(r100));
        ValueAnimator r113 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r113.addUpdateListener(new o(r100));
        r113.setDuration(r104.f23968h);
        r113.setInterpolator(r104.f23964d);
        Rect r114 = new Rect(r101);
        if (r106 != null) goto L24;
    L31:
        Animator r115 = r100.b(r114, r102, r105, false);
        r115.setDuration(r104.f23967g);
        r115.setInterpolator(r104.f23963c);
        AnimatorSet r116 = new AnimatorSet();
        r100.f204209v = r116;
        r116.addListener(new q(r100));
        r116.playTogether(new Animator[]{r112, r115, r113});
        r116.setInterpolator(r100.B);
        r116.setDuration(200);
        r116.start();
        return;
    L24:
        if (r106.length != 4) goto L26;
        boolean r117 = true;
    L27:
        if (r117 == false) goto L30;
        r114.left += r106[0];
        r114.top += r106[1];
        r114.right -= r106[2];
        r114.bottom -= r106[3];
        goto L31
    L30:
        throw new IllegalArgumentException("maskInsetPixel length must equal 4".toString());
    L26:
        r117 = false;
        goto L27
    L36:
        return;
    L35:
        return;
    L32:
        ValueAnimator r118 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r118.addUpdateListener(new m(r100));
        AnimatorSet r119 = new AnimatorSet();
        r100.f204209v = r119;
        r119.addListener(new p(r100));
        r119.playTogether(new Animator[]{r118});
        r119.setInterpolator(r100.B);
        r119.setDuration(200);
        r119.start();
        return;
    L11:
        r111 = true;
        goto L13
    L8:
        r110 = true;
        goto L9
    L5:
        r108 = true;
        goto L6
    }
}
