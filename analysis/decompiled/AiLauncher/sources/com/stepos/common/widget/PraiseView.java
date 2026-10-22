package com.stepos.common.widget;

import android.annotation.TargetApi;
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
import com.stepos.common.R$style;
import com.stepos.common.R$styleable;

/* loaded from: classes3.dex */
public class PraiseView extends View implements View.OnTouchListener {
    private boolean isAnimationRunning;
    private boolean isPerformAnimation;
    private Drawable mAnimImage;
    private ImageView mAnimImageView;
    private Animation.AnimationListener mAnimListener;
    private PopupWindow mAnimPopWindow;
    private boolean mBackImageChanged;
    private Context mContext;
    private Stage mCurrentStage;
    private int mHeight;
    private Animation mPopAnimation;
    private ViewGroup mPopWindowView;
    private int mPopwindowHiehgt;
    private int mPopwindowWidth;
    private c mPraiseCallBack;
    private Drawable mPraiseImage;
    private float mTranslateHeight;
    private Drawable mUnPraiseImage;
    private int mWidth;

    public enum Stage {
        PRAISED,
        CANCEL
    }

    public class a implements Animation.AnimationListener {
        public a() {
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

    public class b implements Animation.AnimationListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PraiseView.this.mAnimPopWindow.dismiss();
            }
        }

        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (PraiseView.this.mPopWindowView.getChildCount() >= 1) {
                PraiseView.this.mPopWindowView.removeViewAt(0);
            }
            PraiseView.this.post(new a());
            PraiseView.a(PraiseView.this);
            PraiseView.this.isAnimationRunning = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            PraiseView.this.isAnimationRunning = true;
        }
    }

    public interface c {
    }

    public PraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ c a(PraiseView praiseView) {
        praiseView.getClass();
        return null;
    }

    public final void e() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mWidth, this.mHeight);
        layoutParams.gravity = 81;
        ImageView imageView = new ImageView(this.mContext);
        this.mAnimImageView = imageView;
        imageView.setImageDrawable(this.mAnimImage);
        this.mAnimImageView.setLayoutParams(layoutParams);
        this.mPopWindowView.addView(this.mAnimImageView);
    }

    @TargetApi(21)
    public final Interpolator f(float f10, float f11, float f12, float f13) {
        return new PathInterpolator(f10, f11, f12, f13);
    }

    public final int g(int i10, int i11, int i12) {
        return i11 != 1073741824 ? i12 : i10;
    }

    public c getPraiseCallBack() {
        return null;
    }

    public Stage getState() {
        return this.mCurrentStage;
    }

    public final Animation h() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.6f, 1.0f, 1.6f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f(0.3f, 0.0f, 0.1f, 1.0f));
        scaleAnimation.setDuration(700L);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -(this.mTranslateHeight / this.mPopwindowHiehgt));
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
        animationSet.setAnimationListener(this.mAnimListener);
        return animationSet;
    }

    public final void i(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PraiseView, i10, R$style.Widget_StepOSCommon_PraiseView_Default);
        this.mPraiseImage = typedArrayObtainStyledAttributes.getDrawable(R$styleable.PraiseView_praiseBackDrawable);
        this.mUnPraiseImage = typedArrayObtainStyledAttributes.getDrawable(R$styleable.PraiseView_unPraiseBackDrawable);
        this.mAnimImage = this.mPraiseImage.getConstantState().newDrawable();
        typedArrayObtainStyledAttributes.recycle();
        setBackground(this.mUnPraiseImage);
        this.mCurrentStage = Stage.CANCEL;
        this.isPerformAnimation = true;
        this.isAnimationRunning = false;
        this.mBackImageChanged = true;
    }

    public final void j() {
        this.mPopWindowView = new FrameLayout(this.mContext);
        e();
        PopupWindow popupWindow = new PopupWindow(this.mPopWindowView, this.mPopwindowWidth, this.mPopwindowHiehgt);
        this.mAnimPopWindow = popupWindow;
        popupWindow.setAnimationStyle(0);
        this.mAnimPopWindow.setTouchable(false);
        this.mAnimPopWindow.setOutsideTouchable(true);
        this.mAnimPopWindow.setTouchInterceptor(this);
    }

    public final void k(int i10, int i11) {
        this.mPopwindowWidth = i10 * 2;
        float f10 = this.mContext.getResources().getDisplayMetrics().density * 66.666664f;
        this.mTranslateHeight = f10;
        this.mPopwindowHiehgt = (int) (f10 + (i11 * 1.6d));
    }

    public final void l() {
        if (this.mAnimPopWindow == null || this.mBackImageChanged) {
            j();
        } else {
            e();
        }
        if (this.mPopAnimation == null || this.mBackImageChanged) {
            this.mPopAnimation = h();
        }
        this.mBackImageChanged = false;
        this.mAnimPopWindow.showAsDropDown(this, -(this.mWidth / 2), -this.mPopwindowHiehgt);
        this.mAnimImageView.startAnimation(this.mPopAnimation);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PraiseView.class.getName());
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int intrinsicWidth = this.mPraiseImage.getIntrinsicWidth();
        int intrinsicHeight = this.mPraiseImage.getIntrinsicHeight();
        this.mWidth = g(size, mode, intrinsicWidth);
        int iG = g(size2, mode2, intrinsicHeight);
        this.mHeight = iG;
        setMeasuredDimension(this.mWidth, iG);
        k(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Animation.AnimationListener animationListener;
        if (motionEvent.getAction() != 4 && motionEvent.getAction() != 4) {
            return false;
        }
        Animation animation = this.mPopAnimation;
        if (animation == null || (animationListener = this.mAnimListener) == null) {
            return true;
        }
        animationListener.onAnimationEnd(animation);
        return true;
    }

    public void setAnimationPerform(boolean z10) {
        this.isPerformAnimation = z10;
    }

    public void setPraiseCallBack(c cVar) {
    }

    public void setState(Stage stage) {
        Stage stage2 = Stage.PRAISED;
        if (stage == stage2) {
            if (this.mCurrentStage == stage) {
                return;
            }
            this.mCurrentStage = stage2;
            setBackground(this.mPraiseImage);
            if (this.isPerformAnimation) {
                l();
                return;
            }
            return;
        }
        if (this.mCurrentStage == stage) {
            return;
        }
        this.mCurrentStage = Stage.CANCEL;
        PopupWindow popupWindow = this.mAnimPopWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        setBackground(this.mUnPraiseImage);
    }

    public PraiseView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mAnimListener = new b();
        this.mContext = context;
        i(context, attributeSet, i10);
    }
}
