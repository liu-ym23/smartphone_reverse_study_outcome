package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.graphics.Point;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public class f extends BDAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f32017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f32018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f32019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TypeEvaluator f32020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Animation.AnimationListener f32021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f32023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Object[] f32024h;

    public class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f32025a;

        public a(f r100) {
            this.f32025a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
            if (f.a(this.f32025a) == null) goto L6;
            f.a(this.f32025a).onAnimationCancel();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            if (f.a(this.f32025a) == null) goto L6;
            f.a(this.f32025a).onAnimationEnd();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r100) {
            if (f.a(this.f32025a) == null) goto L6;
            f.a(this.f32025a).onAnimationRepeat();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r100) {
            if (f.a(this.f32025a) == null) goto L6;
            f.a(this.f32025a).onAnimationStart();
            return;
        }
    }

    public class b implements TypeEvaluator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f32026a;

        public b(f r100) {
            this.f32026a = r100;
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float r100, Object r101, Object r102) {
            LatLng r103 = (LatLng) r101;
            LatLng r104 = (LatLng) r102;
            double r105 = r103.longitude;
            double r106 = r100;
            double r107 = r105 + ((r104.longitude - r105) * r106);
            double r108 = r103.latitude;
            return new LatLng(r108 + (r106 * (r104.latitude - r108)), r107);
        }
    }

    public class c implements TypeEvaluator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f32027a;

        public c(f r100) {
            this.f32027a = r100;
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float r100, Object r101, Object r102) {
            Point r103 = (Point) r101;
            Point r104 = (Point) r102;
            int r105 = r103.x;
            float r106 = r105 + ((r104.x - r105) * r100);
            int r107 = r103.y;
            return new Point((int) r106, (int) (r107 + (r100 * (r104.y - r107))));
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimatorSetMode(int r100) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void cancelAnimation() {
        Animator r100 = this.f32017a;
        if (r100 == null) goto L6;
        r100.cancel();
        this.f32017a = null;
        return;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void startAnimation() {
        Animator r100 = this.f32017a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.start();
    }

    public int a() {
        return this.f32022f;
    }

    public f(Point... r100) {
        this.f32017a = null;
        this.f32018b = 0;
        this.f32019c = null;
        this.f32020d = null;
        this.f32021e = null;
        this.f32022f = 1;
        this.f32023g = 0;
        this.f32024h = r100;
    }

    public ObjectAnimator a(Marker r100) {
        if (r100.isFixed() == true) goto L5;
        Object[] r101 = this.f32024h;
        if ((r101[0] instanceof LatLng) == false) goto L21;
        TypeEvaluator r102 = this.f32020d;
        if (r102 == null) goto L14;
        ObjectAnimator r103 = ObjectAnimator.ofObject(r100, "position", r102, r101);
    L15:
        if (r103 == null) goto L19;
        r103.setRepeatCount(this.f32023g);
        r103.setRepeatMode(a());
        r103.setDuration(this.f32018b);
        Interpolator r104 = this.f32019c;
        if (r104 == null) goto L19;
        r103.setInterpolator(r104);
    L19:
        return r103;
    L14:
        r103 = ObjectAnimator.ofObject(r100, "position", new b(this), this.f32024h);
        goto L15
    L21:
        throw new ClassCastException("BDMapSDKException: if the marker isn't fixed on screen, the parameters of Transformation must be Latlng");
    L5:
        if ((this.f32024h[0] instanceof Point) == false) goto L8;
        r103 = ObjectAnimator.ofObject(r100, "fixedScreenPosition", new c(this), this.f32024h);
        goto L15
    L8:
        throw new ClassCastException("BDMapSDKException: if the marker is fixed on screen, the parameters of Transformation must be android.graphics.Point");
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void addAnimationListener(Animator r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.addListener(new a(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimationListener(Animation.AnimationListener r100) {
        this.f32021e = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setDuration(long r100) {
        if (r100 >= 0) goto L5;
        r100 = 0;
    L5:
        this.f32018b = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setInterpolator(Interpolator r100) {
        this.f32019c = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatCount(int r100) {
        if (r100 <= 0) goto L4;
    L5:
        this.f32023g = r100;
        return;
    L4:
        if (r100 == (-1)) goto L5;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatMode(int r100) {
        this.f32022f = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setTypeEvaluator(TypeEvaluator r100) {
        this.f32020d = r100;
    }

    public f(LatLng... r100) {
        this.f32017a = null;
        this.f32018b = 0;
        this.f32019c = null;
        this.f32020d = null;
        this.f32021e = null;
        this.f32022f = 1;
        this.f32023g = 0;
        this.f32024h = r100;
    }

    public static /* synthetic */ Animation.AnimationListener a(f r100) {
        return r100.f32021e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimation(Marker r100, Animation r101) {
        ObjectAnimator r102 = a(r100);
        this.f32017a = r102;
        addAnimationListener(r102);
    }
}
