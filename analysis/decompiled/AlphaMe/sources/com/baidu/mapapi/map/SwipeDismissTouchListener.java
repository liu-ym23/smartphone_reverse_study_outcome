package com.baidu.mapapi.map;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private int f6879a;

    /* renamed from: b, reason: collision with root package name */
    private int f6880b;

    /* renamed from: c, reason: collision with root package name */
    private int f6881c;

    /* renamed from: d, reason: collision with root package name */
    private long f6882d;

    /* renamed from: e, reason: collision with root package name */
    private View f6883e;

    /* renamed from: f, reason: collision with root package name */
    private DismissCallbacks f6884f;

    /* renamed from: g, reason: collision with root package name */
    private int f6885g = 1;

    /* renamed from: h, reason: collision with root package name */
    private float f6886h;

    /* renamed from: i, reason: collision with root package name */
    private float f6887i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6888j;

    /* renamed from: k, reason: collision with root package name */
    private int f6889k;

    /* renamed from: l, reason: collision with root package name */
    private Object f6890l;

    /* renamed from: m, reason: collision with root package name */
    private VelocityTracker f6891m;

    /* renamed from: n, reason: collision with root package name */
    private float f6892n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6893o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f6894p;

    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);

        void onNotify();
    }

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeDismissTouchListener.this.a();
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f6896a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6897b;

        public b(ViewGroup.LayoutParams layoutParams, int i4) {
            this.f6896a = layoutParams;
            this.f6897b = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeDismissTouchListener.this.f6884f.onDismiss(SwipeDismissTouchListener.this.f6883e, SwipeDismissTouchListener.this.f6890l);
            SwipeDismissTouchListener.this.f6883e.setTranslationX(Property.DEFAULT_FLOAT_VALUE);
            this.f6896a.height = this.f6897b;
            SwipeDismissTouchListener.this.f6883e.setLayoutParams(this.f6896a);
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f6899a;

        public c(ViewGroup.LayoutParams layoutParams) {
            this.f6899a = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f6899a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            SwipeDismissTouchListener.this.f6883e.setLayoutParams(this.f6899a);
        }
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f6879a = viewConfiguration.getScaledTouchSlop();
        this.f6880b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6881c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f6882d = view.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.f6883e = view;
        view.getContext();
        this.f6890l = obj;
        this.f6884f = dismissCallbacks;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0188  */
    @Override // android.view.View.OnTouchListener
    @android.annotation.TargetApi(12)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.SwipeDismissTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void a() {
        ViewGroup.LayoutParams layoutParams = this.f6883e.getLayoutParams();
        int height = this.f6883e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f6882d);
        duration.addListener(new b(layoutParams, height));
        duration.addUpdateListener(new c(layoutParams));
        duration.start();
    }
}
