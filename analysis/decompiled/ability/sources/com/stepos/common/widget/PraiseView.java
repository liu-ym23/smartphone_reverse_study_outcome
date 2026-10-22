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
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public class PraiseView extends View implements View.OnTouchListener {

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f3734r = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Context f3735a;
    public int b;
    public int c;
    public int d;
    public int e;
    public final Drawable f;
    public final Drawable g;
    public final Drawable h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow f3736j;
    public FrameLayout k;
    public ImageView l;
    public AnimationSet m;
    public boolean n;
    public Stage o;
    public float p;

    /* renamed from: q, reason: collision with root package name */
    public final y f3737q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Stage {

        /* renamed from: a, reason: collision with root package name */
        public static final Stage f3738a;
        public static final Stage b;
        public static final /* synthetic */ Stage[] c;

        static {
            Stage stage = new Stage("PRAISED", 0);
            f3738a = stage;
            Stage stage2 = new Stage("CANCEL", 1);
            b = stage2;
            c = new Stage[]{stage, stage2};
        }

        public static Stage valueOf(String str) {
            return (Stage) Enum.valueOf(Stage.class, str);
        }

        public static Stage[] values() {
            return (Stage[]) c.clone();
        }
    }

    public PraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3737q = new y(this, 1);
        this.f3735a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.f1372j, 0, R.style.Widget_StepOSCommon_PraiseView_Default);
        this.f = typedArrayObtainStyledAttributes.getDrawable(0);
        this.h = typedArrayObtainStyledAttributes.getDrawable(1);
        this.g = this.f.getConstantState().newDrawable();
        typedArrayObtainStyledAttributes.recycle();
        setBackground(this.h);
        this.o = Stage.b;
        this.n = true;
        this.i = true;
    }

    public final void a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.b, this.c);
        layoutParams.gravity = 81;
        ImageView imageView = new ImageView(this.f3735a);
        this.l = imageView;
        imageView.setImageDrawable(this.g);
        this.l.setLayoutParams(layoutParams);
        this.k.addView(this.l);
    }

    public z getPraiseCallBack() {
        return null;
    }

    public Stage getState() {
        return this.o;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PraiseView.class.getName());
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i6);
        int intrinsicWidth = this.f.getIntrinsicWidth();
        int intrinsicHeight = this.f.getIntrinsicHeight();
        if (mode != 1073741824) {
            size = intrinsicWidth;
        }
        this.b = size;
        if (mode2 != 1073741824) {
            size2 = intrinsicHeight;
        }
        this.c = size2;
        setMeasuredDimension(size, size2);
        int i10 = this.b;
        int i11 = this.c;
        this.e = i10 * 2;
        float f = this.f3735a.getResources().getDisplayMetrics().density * 66.666664f;
        this.p = f;
        this.d = (int) ((i11 * 1.6d) + f);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        y yVar;
        if (motionEvent.getAction() != 4 && motionEvent.getAction() != 4) {
            return false;
        }
        AnimationSet animationSet = this.m;
        if (animationSet == null || (yVar = this.f3737q) == null) {
            return true;
        }
        yVar.onAnimationEnd(animationSet);
        return true;
    }

    public void setAnimationPerform(boolean z10) {
        this.n = z10;
    }

    public void setPraiseCallBack(z zVar) {
    }

    public void setState(Stage stage) {
        Stage stage2 = Stage.f3738a;
        if (stage != stage2) {
            if (this.o == stage) {
                return;
            }
            this.o = Stage.b;
            PopupWindow popupWindow = this.f3736j;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            setBackground(this.h);
            return;
        }
        if (this.o == stage) {
            return;
        }
        this.o = stage2;
        setBackground(this.f);
        if (this.n) {
            if (this.f3736j == null || this.i) {
                this.k = new FrameLayout(this.f3735a);
                a();
                PopupWindow popupWindow2 = new PopupWindow(this.k, this.e, this.d);
                this.f3736j = popupWindow2;
                popupWindow2.setAnimationStyle(0);
                this.f3736j.setTouchable(false);
                this.f3736j.setOutsideTouchable(true);
                this.f3736j.setTouchInterceptor(this);
            } else {
                a();
            }
            if (this.m == null || this.i) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.6f, 1.0f, 1.6f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
                scaleAnimation.setDuration(700L);
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -(this.p / this.d));
                translateAnimation.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
                translateAnimation.setDuration(700L);
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 25.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setDuration(100L);
                rotateAnimation.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.7f, 1.0f));
                RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, -25.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation2.setDuration(120L);
                rotateAnimation2.setStartOffset(100L);
                rotateAnimation2.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.7f, 1.0f));
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.7f, 1.0f));
                alphaAnimation.setDuration(300L);
                alphaAnimation.setStartOffset(700L);
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(rotateAnimation2);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);
                alphaAnimation.setAnimationListener(new y(this, 0));
                animationSet.setAnimationListener(this.f3737q);
                this.m = animationSet;
            }
            this.i = false;
            this.f3736j.showAsDropDown(this, -(this.b / 2), -this.d);
            this.l.startAnimation(this.m);
        }
    }
}
