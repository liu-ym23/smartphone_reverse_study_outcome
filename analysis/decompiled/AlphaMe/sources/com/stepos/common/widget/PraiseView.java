package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import i2.AbstractC0620a;

/* loaded from: classes.dex */
public class PraiseView extends View implements View.OnTouchListener {

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f11713r = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Context f11714a;

    /* renamed from: b, reason: collision with root package name */
    public int f11715b;

    /* renamed from: c, reason: collision with root package name */
    public int f11716c;

    /* renamed from: d, reason: collision with root package name */
    public int f11717d;

    /* renamed from: e, reason: collision with root package name */
    public int f11718e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f11719f;

    /* renamed from: g, reason: collision with root package name */
    public final Drawable f11720g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f11721h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f11722i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow f11723j;

    /* renamed from: k, reason: collision with root package name */
    public FrameLayout f11724k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f11725l;

    /* renamed from: m, reason: collision with root package name */
    public AnimationSet f11726m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11727n;

    /* renamed from: o, reason: collision with root package name */
    public t f11728o;

    /* renamed from: p, reason: collision with root package name */
    public float f11729p;

    /* renamed from: q, reason: collision with root package name */
    public final s f11730q;

    public PraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f11730q = new s(this, 1);
        this.f11714a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13028j, 0, R.style.Widget_StepOSCommon_PraiseView_Default);
        this.f11719f = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f11721h = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f11720g = this.f11719f.getConstantState().newDrawable();
        typedArrayObtainStyledAttributes.recycle();
        setBackground(this.f11721h);
        this.f11728o = t.f11968b;
        this.f11727n = true;
        this.f11722i = true;
    }

    public final void a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f11715b, this.f11716c);
        layoutParams.gravity = 81;
        ImageView imageView = new ImageView(this.f11714a);
        this.f11725l = imageView;
        imageView.setImageDrawable(this.f11720g);
        this.f11725l.setLayoutParams(layoutParams);
        this.f11724k.addView(this.f11725l);
    }

    public u getPraiseCallBack() {
        return null;
    }

    public t getState() {
        return this.f11728o;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PraiseView.class.getName());
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        int intrinsicWidth = this.f11719f.getIntrinsicWidth();
        int intrinsicHeight = this.f11719f.getIntrinsicHeight();
        if (mode != 1073741824) {
            size = intrinsicWidth;
        }
        this.f11715b = size;
        if (mode2 != 1073741824) {
            size2 = intrinsicHeight;
        }
        this.f11716c = size2;
        setMeasuredDimension(size, size2);
        int i6 = this.f11715b;
        int i7 = this.f11716c;
        this.f11718e = i6 * 2;
        float f4 = this.f11714a.getResources().getDisplayMetrics().density * 66.666664f;
        this.f11729p = f4;
        this.f11717d = (int) ((i7 * 1.6d) + f4);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        s sVar;
        if (motionEvent.getAction() != 4 && motionEvent.getAction() != 4) {
            return false;
        }
        AnimationSet animationSet = this.f11726m;
        if (animationSet == null || (sVar = this.f11730q) == null) {
            return true;
        }
        sVar.onAnimationEnd(animationSet);
        return true;
    }

    public void setAnimationPerform(boolean z4) {
        this.f11727n = z4;
    }

    public void setPraiseCallBack(u uVar) {
    }

    public void setState(t tVar) {
        boolean z4;
        t tVar2 = t.f11967a;
        if (tVar != tVar2) {
            if (this.f11728o == tVar) {
                return;
            }
            this.f11728o = t.f11968b;
            PopupWindow popupWindow = this.f11723j;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            setBackground(this.f11721h);
            return;
        }
        if (this.f11728o == tVar) {
            return;
        }
        this.f11728o = tVar2;
        setBackground(this.f11719f);
        if (this.f11727n) {
            if (this.f11723j == null || this.f11722i) {
                this.f11724k = new FrameLayout(this.f11714a);
                a();
                PopupWindow popupWindow2 = new PopupWindow(this.f11724k, this.f11718e, this.f11717d);
                this.f11723j = popupWindow2;
                popupWindow2.setAnimationStyle(0);
                this.f11723j.setTouchable(false);
                this.f11723j.setOutsideTouchable(true);
                this.f11723j.setTouchInterceptor(this);
            } else {
                a();
            }
            if (this.f11726m == null || this.f11722i) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.6f, 1.0f, 1.6f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new PathInterpolator(0.3f, Property.DEFAULT_FLOAT_VALUE, 0.1f, 1.0f));
                scaleAnimation.setDuration(700L);
                TranslateAnimation translateAnimation = new TranslateAnimation(2, Property.DEFAULT_FLOAT_VALUE, 2, Property.DEFAULT_FLOAT_VALUE, 2, Property.DEFAULT_FLOAT_VALUE, 2, -(this.f11729p / this.f11717d));
                translateAnimation.setInterpolator(new PathInterpolator(0.3f, Property.DEFAULT_FLOAT_VALUE, 0.1f, 1.0f));
                translateAnimation.setDuration(700L);
                RotateAnimation rotateAnimation = new RotateAnimation(Property.DEFAULT_FLOAT_VALUE, 25.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setDuration(100L);
                rotateAnimation.setInterpolator(new PathInterpolator(0.3f, Property.DEFAULT_FLOAT_VALUE, 0.7f, 1.0f));
                RotateAnimation rotateAnimation2 = new RotateAnimation(Property.DEFAULT_FLOAT_VALUE, -25.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation2.setDuration(120L);
                rotateAnimation2.setStartOffset(100L);
                rotateAnimation2.setInterpolator(new PathInterpolator(0.3f, Property.DEFAULT_FLOAT_VALUE, 0.7f, 1.0f));
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, Property.DEFAULT_FLOAT_VALUE);
                alphaAnimation.setInterpolator(new PathInterpolator(0.3f, Property.DEFAULT_FLOAT_VALUE, 0.7f, 1.0f));
                alphaAnimation.setDuration(300L);
                alphaAnimation.setStartOffset(700L);
                z4 = false;
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(rotateAnimation2);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);
                alphaAnimation.setAnimationListener(new s(this, 0));
                animationSet.setAnimationListener(this.f11730q);
                this.f11726m = animationSet;
            } else {
                z4 = false;
            }
            this.f11722i = z4;
            this.f11723j.showAsDropDown(this, -(this.f11715b / 2), -this.f11717d);
            this.f11725l.startAnimation(this.f11726m);
        }
    }
}
