package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.stepos.alphame.suggest.AppSuggestStorable;

/* loaded from: classes.dex */
public class f extends BDAnimation {

    /* renamed from: a, reason: collision with root package name */
    private Animator f7893a = null;

    /* renamed from: b, reason: collision with root package name */
    private long f7894b = 0;

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f7895c = null;

    /* renamed from: d, reason: collision with root package name */
    private TypeEvaluator f7896d = null;

    /* renamed from: e, reason: collision with root package name */
    private Animation.AnimationListener f7897e = null;

    /* renamed from: f, reason: collision with root package name */
    private int f7898f = 1;

    /* renamed from: g, reason: collision with root package name */
    private int f7899g = 0;

    /* renamed from: h, reason: collision with root package name */
    private Object[] f7900h;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (f.this.f7897e != null) {
                f.this.f7897e.onAnimationCancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (f.this.f7897e != null) {
                f.this.f7897e.onAnimationEnd();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (f.this.f7897e != null) {
                f.this.f7897e.onAnimationRepeat();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (f.this.f7897e != null) {
                f.this.f7897e.onAnimationStart();
            }
        }
    }

    @TargetApi(11)
    public class b implements TypeEvaluator {
        public b() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f4, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d4 = latLng.longitude;
            double d5 = f4;
            double d6 = ((latLng2.longitude - d4) * d5) + d4;
            double d7 = latLng.latitude;
            return new LatLng(((latLng2.latitude - d7) * d5) + d7, d6);
        }
    }

    @TargetApi(11)
    public class c implements TypeEvaluator {
        public c() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f4, Object obj, Object obj2) {
            Point point = (Point) obj;
            Point point2 = (Point) obj2;
            return new Point((int) (((point2.x - r2) * f4) + point.x), (int) ((f4 * (point2.y - r4)) + point.y));
        }
    }

    public f(LatLng... latLngArr) {
        this.f7900h = latLngArr;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void addAnimationListener(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new a());
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void cancelAnimation() {
        Animator animator = this.f7893a;
        if (animator != null) {
            animator.cancel();
            this.f7893a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void setAnimation(Marker marker, Animation animation) {
        ObjectAnimator objectAnimatorA = a(marker);
        this.f7893a = objectAnimatorA;
        addAnimationListener(objectAnimatorA);
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f7897e = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimatorSetMode(int i4) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setDuration(long j4) {
        if (j4 < 0) {
            j4 = 0;
        }
        this.f7894b = j4;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setInterpolator(Interpolator interpolator) {
        this.f7895c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatCount(int i4) {
        if (i4 > 0 || i4 == -1) {
            this.f7899g = i4;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatMode(int i4) {
        this.f7898f = i4;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setTypeEvaluator(TypeEvaluator typeEvaluator) {
        this.f7896d = typeEvaluator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void startAnimation() {
        Animator animator = this.f7893a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    public int a() {
        return this.f7898f;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator objectAnimatorOfObject;
        if (marker.isFixed()) {
            if (this.f7900h[0] instanceof Point) {
                objectAnimatorOfObject = ObjectAnimator.ofObject(marker, "fixedScreenPosition", new c(), this.f7900h);
            } else {
                throw new ClassCastException("BDMapSDKException: if the marker is fixed on screen, the parameters of Transformation must be android.graphics.Point");
            }
        } else {
            Object[] objArr = this.f7900h;
            if (objArr[0] instanceof LatLng) {
                TypeEvaluator typeEvaluator = this.f7896d;
                if (typeEvaluator != null) {
                    objectAnimatorOfObject = ObjectAnimator.ofObject(marker, AppSuggestStorable.COLUMN_POSITION, typeEvaluator, objArr);
                } else {
                    objectAnimatorOfObject = ObjectAnimator.ofObject(marker, AppSuggestStorable.COLUMN_POSITION, new b(), this.f7900h);
                }
            } else {
                throw new ClassCastException("BDMapSDKException: if the marker isn't fixed on screen, the parameters of Transformation must be Latlng");
            }
        }
        if (objectAnimatorOfObject != null) {
            objectAnimatorOfObject.setRepeatCount(this.f7899g);
            objectAnimatorOfObject.setRepeatMode(a());
            objectAnimatorOfObject.setDuration(this.f7894b);
            Interpolator interpolator = this.f7895c;
            if (interpolator != null) {
                objectAnimatorOfObject.setInterpolator(interpolator);
            }
        }
        return objectAnimatorOfObject;
    }

    public f(Point... pointArr) {
        this.f7900h = pointArr;
    }
}
