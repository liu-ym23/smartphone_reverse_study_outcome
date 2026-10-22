package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public class PraiseView extends View implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private Context f14060a;

    /* renamed from: b, reason: collision with root package name */
    private int f14061b;

    /* renamed from: c, reason: collision with root package name */
    private int f14062c;

    /* renamed from: d, reason: collision with root package name */
    private int f14063d;

    /* renamed from: e, reason: collision with root package name */
    private int f14064e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f14065f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f14066g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f14067h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f14068i;

    /* renamed from: j, reason: collision with root package name */
    private PopupWindow f14069j;

    /* renamed from: k, reason: collision with root package name */
    private ViewGroup f14070k;

    /* renamed from: l, reason: collision with root package name */
    private ImageView f14071l;

    /* renamed from: m, reason: collision with root package name */
    private Animation f14072m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f14073n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f14074o;

    /* renamed from: p, reason: collision with root package name */
    private c f14075p;

    /* renamed from: q, reason: collision with root package name */
    private float f14076q;

    /* renamed from: r, reason: collision with root package name */
    private Animation.AnimationListener f14077r;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PraiseView.a(PraiseView.this);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class b implements Animation.AnimationListener {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PraiseView.this.f14069j.dismiss();
            }
        }

        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (PraiseView.this.f14070k.getChildCount() >= 1) {
                PraiseView.this.f14070k.removeViewAt(0);
            }
            PraiseView.this.post(new a());
            PraiseView.a(PraiseView.this);
            PraiseView.this.f14074o = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            PraiseView.this.f14074o = true;
        }
    }

    public enum c {
        PRAISED,
        CANCEL
    }

    public interface d {
    }

    public PraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static /* synthetic */ d a(PraiseView praiseView) {
        praiseView.getClass();
        return null;
    }

    private void e() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f14061b, this.f14062c);
        layoutParams.gravity = 81;
        ImageView imageView = new ImageView(this.f14060a);
        this.f14071l = imageView;
        imageView.setImageDrawable(this.f14066g);
        this.f14071l.setLayoutParams(layoutParams);
        this.f14070k.addView(this.f14071l);
    }

    private Interpolator f(float f5, float f6, float f7, float f8) {
        return new PathInterpolator(f5, f6, f7, f8);
    }

    private int g(int i5, int i6, int i7) {
        return i6 != 1073741824 ? i7 : i5;
    }

    private Animation h() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.6f, 1.0f, 1.6f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f(0.3f, 0.0f, 0.1f, 1.0f));
        scaleAnimation.setDuration(700L);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -(this.f14076q / this.f14063d));
        translateAnimation.setInterpolator(f(0.3f, 0.0f, 0.1f, 1.0f));
        translateAnimation.setDuration(700L);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 25.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(100L);
        rotateAnimation.setInterpolator(f(0.3f, 0.0f, 0.7f, 1.0f));
        RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, -25.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation2.setDuration(120L);
        rotateAnimation2.setStartOffset(100L);
        rotateAnimation2.setInterpolator(f(0.3f, 0.0f, 0.7f, 1.0f));
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(f(0.3f, 0.0f, 0.7f, 1.0f));
        alphaAnimation.setDuration(300L);
        alphaAnimation.setStartOffset(700L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(rotateAnimation2);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new a());
        animationSet.setAnimationListener(this.f14077r);
        return animationSet;
    }

    private void i(Context context, AttributeSet attributeSet, int i5) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.f2437I3, i5, H1.l.f2382n);
        this.f14065f = typedArrayObtainStyledAttributes.getDrawable(H1.m.f2443J3);
        this.f14067h = typedArrayObtainStyledAttributes.getDrawable(H1.m.f2449K3);
        this.f14066g = this.f14065f.getConstantState().newDrawable();
        typedArrayObtainStyledAttributes.recycle();
        setBackground(this.f14067h);
        this.f14075p = c.CANCEL;
        this.f14073n = true;
        this.f14074o = false;
        this.f14068i = true;
    }

    private void j() {
        this.f14070k = new FrameLayout(this.f14060a);
        e();
        PopupWindow popupWindow = new PopupWindow(this.f14070k, this.f14064e, this.f14063d);
        this.f14069j = popupWindow;
        popupWindow.setAnimationStyle(0);
        this.f14069j.setTouchable(false);
        this.f14069j.setOutsideTouchable(true);
        this.f14069j.setTouchInterceptor(this);
    }

    private void k(int i5, int i6) {
        this.f14064e = i5 * 2;
        float f5 = this.f14060a.getResources().getDisplayMetrics().density * 66.666664f;
        this.f14076q = f5;
        this.f14063d = (int) (f5 + (i6 * 1.6d));
    }

    private void l() {
        if (this.f14069j == null || this.f14068i) {
            j();
        } else {
            e();
        }
        if (this.f14072m == null || this.f14068i) {
            this.f14072m = h();
        }
        this.f14068i = false;
        this.f14069j.showAsDropDown(this, -(this.f14061b / 2), -this.f14063d);
        this.f14071l.startAnimation(this.f14072m);
    }

    public d getPraiseCallBack() {
        return null;
    }

    public c getState() {
        return this.f14075p;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PraiseView.class.getName());
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int intrinsicWidth = this.f14065f.getIntrinsicWidth();
        int intrinsicHeight = this.f14065f.getIntrinsicHeight();
        this.f14061b = g(size, mode, intrinsicWidth);
        int iG = g(size2, mode2, intrinsicHeight);
        this.f14062c = iG;
        setMeasuredDimension(this.f14061b, iG);
        k(this.f14061b, this.f14062c);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Animation.AnimationListener animationListener;
        if (motionEvent.getAction() != 4 && motionEvent.getAction() != 4) {
            return false;
        }
        Animation animation = this.f14072m;
        if (animation == null || (animationListener = this.f14077r) == null) {
            return true;
        }
        animationListener.onAnimationEnd(animation);
        return true;
    }

    public void setAnimationPerform(boolean z5) {
        this.f14073n = z5;
    }

    public void setPraiseCallBack(d dVar) {
    }

    public void setState(c cVar) {
        c cVar2 = c.PRAISED;
        if (cVar == cVar2) {
            if (this.f14075p == cVar) {
                return;
            }
            this.f14075p = cVar2;
            setBackground(this.f14065f);
            if (this.f14073n) {
                l();
                return;
            }
            return;
        }
        if (this.f14075p == cVar) {
            return;
        }
        this.f14075p = c.CANCEL;
        PopupWindow popupWindow = this.f14069j;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        setBackground(this.f14067h);
    }

    public PraiseView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f14077r = new b();
        this.f14060a = context;
        i(context, attributeSet, i5);
    }
}
