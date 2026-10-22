package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PraiseView extends View implements View.OnTouchListener {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f6958u = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6959a;

    /* renamed from: b, reason: collision with root package name */
    public int f6960b;

    /* renamed from: c, reason: collision with root package name */
    public int f6961c;

    /* renamed from: d, reason: collision with root package name */
    public int f6962d;

    /* renamed from: e, reason: collision with root package name */
    public int f6963e;
    public final Drawable h;

    /* renamed from: j, reason: collision with root package name */
    public final Drawable f6964j;

    /* renamed from: k, reason: collision with root package name */
    public final Drawable f6965k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6966l;

    /* renamed from: m, reason: collision with root package name */
    public PopupWindow f6967m;

    /* renamed from: n, reason: collision with root package name */
    public FrameLayout f6968n;

    /* renamed from: o, reason: collision with root package name */
    public ImageView f6969o;

    /* renamed from: p, reason: collision with root package name */
    public AnimationSet f6970p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6971q;
    public Stage r;

    /* renamed from: s, reason: collision with root package name */
    public float f6972s;

    /* renamed from: t, reason: collision with root package name */
    public final a f6973t;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Stage {

        /* renamed from: a, reason: collision with root package name */
        public static final Stage f6974a;

        /* renamed from: b, reason: collision with root package name */
        public static final Stage f6975b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Stage[] f6976c;

        static {
            Stage stage = new Stage("PRAISED", 0);
            f6974a = stage;
            Stage stage2 = new Stage("CANCEL", 1);
            f6975b = stage2;
            f6976c = new Stage[]{stage, stage2};
        }

        public Stage() {
            throw null;
        }

        public static Stage valueOf(String str) {
            return (Stage) Enum.valueOf(Stage.class, str);
        }

        public static Stage[] values() {
            return (Stage[]) f6976c.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
    }

    public PraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6973t = new a();
        this.f6959a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9083j, 0, R.style.Widget_StepOSCommon_PraiseView_Default);
        this.h = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f6965k = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f6964j = this.h.getConstantState().newDrawable();
        typedArrayObtainStyledAttributes.recycle();
        setBackground(this.f6965k);
        this.r = Stage.f6975b;
        this.f6971q = true;
        this.f6966l = true;
    }

    public final void a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f6960b, this.f6961c);
        layoutParams.gravity = 81;
        ImageView imageView = new ImageView(this.f6959a);
        this.f6969o = imageView;
        imageView.setImageDrawable(this.f6964j);
        this.f6969o.setLayoutParams(layoutParams);
        this.f6968n.addView(this.f6969o);
    }

    public b getPraiseCallBack() {
        return null;
    }

    public Stage getState() {
        return this.r;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PraiseView.class.getName());
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int intrinsicWidth = this.h.getIntrinsicWidth();
        int intrinsicHeight = this.h.getIntrinsicHeight();
        if (mode != 1073741824) {
            size = intrinsicWidth;
        }
        this.f6960b = size;
        if (mode2 != 1073741824) {
            size2 = intrinsicHeight;
        }
        this.f6961c = size2;
        setMeasuredDimension(size, size2);
        int i12 = this.f6960b;
        int i13 = this.f6961c;
        this.f6963e = i12 * 2;
        float f8 = this.f6959a.getResources().getDisplayMetrics().density * 66.666664f;
        this.f6972s = f8;
        this.f6962d = (int) ((i13 * 1.6d) + f8);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        a aVar;
        if (motionEvent.getAction() != 4 && motionEvent.getAction() != 4) {
            return false;
        }
        AnimationSet animationSet = this.f6970p;
        if (animationSet == null || (aVar = this.f6973t) == null) {
            return true;
        }
        aVar.onAnimationEnd(animationSet);
        return true;
    }

    public void setAnimationPerform(boolean z) {
        this.f6971q = z;
    }

    public void setState(Stage stage) {
        Stage stage2 = Stage.f6974a;
        if (stage != stage2) {
            if (this.r == stage) {
                return;
            }
            this.r = Stage.f6975b;
            PopupWindow popupWindow = this.f6967m;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            setBackground(this.f6965k);
            return;
        }
        if (this.r == stage) {
            return;
        }
        this.r = stage2;
        setBackground(this.h);
        if (this.f6971q) {
            if (this.f6967m == null || this.f6966l) {
                this.f6968n = new FrameLayout(this.f6959a);
                a();
                PopupWindow popupWindow2 = new PopupWindow(this.f6968n, this.f6963e, this.f6962d);
                this.f6967m = popupWindow2;
                popupWindow2.setAnimationStyle(0);
                this.f6967m.setTouchable(false);
                this.f6967m.setOutsideTouchable(true);
                this.f6967m.setTouchInterceptor(this);
            } else {
                a();
            }
            if (this.f6970p == null || this.f6966l) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.6f, 1.0f, 1.6f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
                scaleAnimation.setDuration(700L);
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -(this.f6972s / this.f6962d));
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
                alphaAnimation.setAnimationListener(new r(this));
                animationSet.setAnimationListener(this.f6973t);
                this.f6970p = animationSet;
            }
            this.f6966l = false;
            this.f6967m.showAsDropDown(this, -(this.f6960b / 2), -this.f6962d);
            this.f6969o.startAnimation(this.f6970p);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Animation.AnimationListener {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: com.stepos.common.widget.PraiseView$a$a, reason: collision with other inner class name */
        public class RunnableC0048a implements Runnable {
            public RunnableC0048a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                PraiseView.this.f6967m.dismiss();
            }
        }

        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            PraiseView praiseView = PraiseView.this;
            if (praiseView.f6968n.getChildCount() >= 1) {
                praiseView.f6968n.removeViewAt(0);
            }
            praiseView.post(new RunnableC0048a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            int i10 = PraiseView.f6958u;
            PraiseView.this.getClass();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public void setPraiseCallBack(b bVar) {
    }
}
