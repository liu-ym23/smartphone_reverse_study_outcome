package com.stepos.common.scrollbarview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Interpolator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import com.stepos.aiengine.R;
import ie.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import l8.f;
import stepos.support.v7.widget.StepOSRecyclerView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSScrollBarView extends View {
    public static final PathInterpolator F = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    public static final Method G;
    public static final Method H;
    public static final Method I;
    public static final Method J;
    public static final Method K;
    public static final Method L;
    public static boolean M;
    public final int A;
    public VelocityTracker B;
    public int C;
    public d D;
    public boolean E;

    /* renamed from: a, reason: collision with root package name */
    public View f6556a;

    /* renamed from: b, reason: collision with root package name */
    public final j8.a f6557b;

    /* renamed from: c, reason: collision with root package name */
    public final Drawable f6558c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f6559d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6560e;
    public final int h;

    /* renamed from: j, reason: collision with root package name */
    public com.stepos.common.scrollbarview.a f6561j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6562k;

    /* renamed from: l, reason: collision with root package name */
    public final int f6563l;

    /* renamed from: m, reason: collision with root package name */
    public final int f6564m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6565n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f6566o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f6567p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6568q;
    public final c r;

    /* renamed from: s, reason: collision with root package name */
    public final b f6569s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6570t;

    /* renamed from: u, reason: collision with root package name */
    public Handler f6571u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f6572v;

    /* renamed from: w, reason: collision with root package name */
    public float f6573w;

    /* renamed from: x, reason: collision with root package name */
    public float f6574x;

    /* renamed from: y, reason: collision with root package name */
    public int f6575y;
    public final int z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f6576a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f6577b;

        /* renamed from: c, reason: collision with root package name */
        public ValueAnimator f6578c;

        /* renamed from: d, reason: collision with root package name */
        public final StepOSScrollBarView f6579d;

        /* renamed from: e, reason: collision with root package name */
        public final int f6580e;
        public final int h;

        /* renamed from: j, reason: collision with root package name */
        public boolean f6581j;

        /* renamed from: k, reason: collision with root package name */
        public final j8.a f6582k;

        public b(StepOSScrollBarView stepOSScrollBarView, int i10, int i11, j8.a aVar) {
            this.f6579d = stepOSScrollBarView;
            this.f6580e = i10;
            this.h = i11;
            this.f6582k = aVar;
        }

        public final void a(int i10, int i11) {
            ValueAnimator valueAnimator = this.f6578c;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f6578c.cancel();
            }
            if (this.f6578c == null) {
                this.f6578c = new ValueAnimator();
            }
            this.f6578c.setIntValues(i10, i11);
            this.f6578c.setDuration(250L);
            this.f6578c.setInterpolator(StepOSScrollBarView.F);
            this.f6578c.start();
            this.f6576a = 1;
            this.f6581j = true;
            this.f6579d.postInvalidate();
        }

        @Override // java.lang.Runnable
        public final void run() {
            j8.a aVar;
            if (AnimationUtils.currentAnimationTimeMillis() < this.f6577b || this.f6576a != 0) {
                return;
            }
            if (this.f6578c == null) {
                this.f6578c = new ValueAnimator();
            }
            this.f6576a = 1;
            this.f6581j = false;
            this.f6578c.setDuration(250L);
            this.f6578c.setInterpolator(StepOSScrollBarView.F);
            this.f6578c.setIntValues(this.f6580e, this.h);
            if (StepOSScrollBarView.M && (aVar = this.f6582k) != null) {
                final int i10 = aVar.getBounds().left;
                this.f6578c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: j8.b
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        int i11 = i10;
                        a aVar2 = this.f9738a.f6582k;
                        aVar2.setBounds(i11, aVar2.getBounds().top, iIntValue + i11, aVar2.getBounds().bottom);
                    }
                });
            }
            this.f6578c.start();
            this.f6579d.postInvalidate();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c implements Runnable {
        public static final float[] h = {255.0f};

        /* renamed from: j, reason: collision with root package name */
        public static final float[] f6583j = {0.0f};

        /* renamed from: b, reason: collision with root package name */
        public float[] f6585b;

        /* renamed from: d, reason: collision with root package name */
        public long f6587d;

        /* renamed from: e, reason: collision with root package name */
        public final StepOSScrollBarView f6588e;

        /* renamed from: a, reason: collision with root package name */
        public final Interpolator f6584a = new Interpolator(1, 2);

        /* renamed from: c, reason: collision with root package name */
        public int f6586c = 0;

        public c(StepOSScrollBarView stepOSScrollBarView) {
            this.f6588e = stepOSScrollBarView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StepOSScrollBarView stepOSScrollBarView;
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f6587d || this.f6586c != 1 || (stepOSScrollBarView = this.f6588e) == null || stepOSScrollBarView.E) {
                return;
            }
            int i10 = (int) jCurrentAnimationTimeMillis;
            float[] fArr = h;
            Interpolator interpolator = this.f6584a;
            interpolator.setKeyFrame(0, i10, fArr);
            interpolator.setKeyFrame(1, i10 + 500, f6583j);
            this.f6586c = 2;
            stepOSScrollBarView.invalidate();
        }
    }

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollExtent", null);
            G = declaredMethod;
            Method declaredMethod2 = View.class.getDeclaredMethod("computeVerticalScrollRange", null);
            I = declaredMethod2;
            Method declaredMethod3 = View.class.getDeclaredMethod("computeVerticalScrollOffset", null);
            H = declaredMethod3;
            Method declaredMethod4 = View.class.getDeclaredMethod("computeHorizontalScrollRange", null);
            L = declaredMethod4;
            Method declaredMethod5 = View.class.getDeclaredMethod("computeHorizontalScrollExtent", null);
            J = declaredMethod5;
            Method declaredMethod6 = View.class.getDeclaredMethod("computeHorizontalScrollOffset", null);
            K = declaredMethod6;
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
            }
            if (declaredMethod2 != null) {
                declaredMethod2.setAccessible(true);
            }
            if (declaredMethod3 != null) {
                declaredMethod3.setAccessible(true);
            }
            if (declaredMethod5 != null) {
                declaredMethod5.setAccessible(true);
            }
            if (declaredMethod4 != null) {
                declaredMethod4.setAccessible(true);
            }
            if (declaredMethod6 != null) {
                declaredMethod6.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            Log.e("StepOSSScrollBarView", "get reflect method has an error!");
        }
        M = false;
    }

    public StepOSScrollBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposScrollBarViewStyle);
        this.f6565n = true;
        this.f6566o = true;
        this.f6572v = true;
        this.C = 0;
        setForceDarkAllowed(false);
        this.f6561j = new com.stepos.common.scrollbarview.a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9090q, R.attr.steposScrollBarViewStyle, 0);
        this.f6563l = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, (int) f.a(2.0f, context));
        this.f6564m = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, (int) f.a(6.0f, context));
        this.f6562k = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, (int) f.a(30.0f, context));
        this.f6565n = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.f6566o = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.f6567p = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.f6568q = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.f6572v = typedArrayObtainStyledAttributes.getInt(5, 1) == 1;
        this.f6559d = typedArrayObtainStyledAttributes.getDrawable(8);
        this.f6558c = typedArrayObtainStyledAttributes.getDrawable(10);
        this.h = typedArrayObtainStyledAttributes.getColor(9, context.getResources().getColor(R.color.stepos_scrollbar_thumb_drawable_color));
        this.f6560e = typedArrayObtainStyledAttributes.getColor(11, context.getResources().getColor(R.color.stepos_scrollbar_track_drawable_color));
        if (this.f6557b == null) {
            this.f6557b = new j8.a(this.f6572v, this.f6561j);
        }
        j8.a aVar = this.f6557b;
        Drawable drawable = this.f6559d;
        if (aVar.f9731n) {
            Drawable drawable2 = aVar.f9723b;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            aVar.b(drawable);
            aVar.f9723b = drawable;
        } else {
            Drawable drawable3 = aVar.f9725d;
            if (drawable3 != null) {
                drawable3.setCallback(null);
            }
            aVar.b(drawable);
            aVar.f9725d = drawable;
        }
        j8.a aVar2 = this.f6557b;
        Drawable drawable4 = this.f6558c;
        if (aVar2.f9731n) {
            Drawable drawable5 = aVar2.f9722a;
            if (drawable5 != null) {
                drawable5.setCallback(null);
            }
            aVar2.b(drawable4);
            aVar2.f9722a = drawable4;
        } else {
            Drawable drawable6 = aVar2.f9724c;
            if (drawable6 != null) {
                drawable6.setCallback(null);
            }
            aVar2.b(drawable4);
            aVar2.f9724c = drawable4;
        }
        this.f6557b.getClass();
        this.f6559d.mutate().setTint(this.h);
        this.f6558c.mutate().setTint(this.f6560e);
        typedArrayObtainStyledAttributes.recycle();
        M = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.r = new c(this);
        this.f6569s = new b(this, this.f6563l, this.f6564m, this.f6557b);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.z = viewConfiguration.getScaledMinimumFlingVelocity();
        this.A = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private int getScrollableViewScrollExtent() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f6572v ? G : J;
        View view = this.f6556a;
        if (view == null || method == null) {
            return 0;
        }
        try {
            Object objInvoke = method.invoke(view, null);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
            return 0;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e("StepOSSScrollBarView", "invoke computeVerticalScrollExtent has an error!");
            return 0;
        }
    }

    private int getScrollableViewScrollOffset() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f6572v ? H : K;
        View view = this.f6556a;
        if (view == null || method == null) {
            return 0;
        }
        try {
            Object objInvoke = method.invoke(view, null);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
            return 0;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e("StepOSSScrollBarView", "invoke computeVerticalScrollOffset has an error!");
            return 0;
        }
    }

    private int getScrollableViewScrollRange() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f6572v ? I : L;
        View view = this.f6556a;
        if (view == null || method == null) {
            return 0;
        }
        try {
            Object objInvoke = method.invoke(view, null);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
            return 0;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e("StepOSSScrollBarView", "invoke computeVerticalScrollRange has an error!");
            return 0;
        }
    }

    public final void a(boolean z) {
        if (this.f6571u == null) {
            this.f6571u = new Handler();
        }
        boolean z3 = this.f6565n;
        c cVar = this.r;
        if (z3) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + 2000;
            cVar.f6587d = jCurrentAnimationTimeMillis;
            cVar.f6586c = 1;
            this.f6571u.removeCallbacks(cVar);
            this.f6571u.postAtTime(cVar, jCurrentAnimationTimeMillis);
        } else {
            cVar.f6586c = 1;
        }
        if (z) {
            invalidate();
        }
    }

    public final void b() {
        b bVar = this.f6569s;
        if (bVar.f6576a != 0 || this.f6570t) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        bVar.f6577b = jCurrentAnimationTimeMillis;
        bVar.f6576a = 0;
        this.f6571u.postAtTime(bVar, jCurrentAnimationTimeMillis);
        this.f6570t = true;
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        if (this.f6567p && insets.top != getPaddingTop()) {
            setPadding(getPaddingLeft(), insets.top, getPaddingRight(), getPaddingBottom());
        }
        if (this.f6568q && insets.bottom != getPaddingBottom()) {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), insets.bottom);
        }
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.f6571u;
        if (handler != null) {
            handler.removeCallbacks(this.r);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        c cVar;
        int i10;
        boolean z;
        super.onDraw(canvas);
        if (getVisibility() == 0 && (i10 = (cVar = this.r).f6586c) != 0) {
            if (i10 == 2) {
                if (cVar.f6585b == null) {
                    cVar.f6585b = new float[1];
                }
                float[] fArr = cVar.f6585b;
                if (cVar.f6584a.timeToValues(fArr) == Interpolator.Result.FREEZE_END) {
                    cVar.f6586c = 0;
                } else {
                    j8.a aVar = this.f6557b;
                    aVar.a();
                    aVar.setAlpha(Math.round(fArr[0]));
                }
                z = true;
            } else {
                j8.a aVar2 = this.f6557b;
                aVar2.a();
                aVar2.setAlpha(255);
                z = false;
            }
            b bVar = this.f6569s;
            if (bVar.f6576a == 1) {
                this.f6570t = false;
                a(false);
                Object animatedValue = bVar.f6578c.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    int iIntValue = ((Integer) animatedValue).intValue();
                    j8.a aVar3 = this.f6557b;
                    Rect bounds = aVar3.getBounds();
                    if (aVar3.f9731n) {
                        int i11 = bounds.right;
                        aVar3.setBounds(i11 - iIntValue, bounds.top, i11, bounds.bottom);
                    } else {
                        int i12 = bounds.left;
                        int i13 = bounds.bottom;
                        aVar3.setBounds(i12, i13 - iIntValue, bounds.right, i13);
                    }
                    if (!bVar.f6578c.isRunning()) {
                        boolean z3 = bVar.f6581j;
                        bVar.f6576a = z3 ? 0 : 2;
                        if (!z3) {
                            View view = this.f6556a;
                            boolean zB = l8.a.b();
                            if (l8.a.c(view.getContext())) {
                                if (zB) {
                                    view.performHapticFeedback(31020);
                                } else {
                                    view.performHapticFeedback(0);
                                }
                            }
                        }
                    }
                    z = true;
                }
            }
            int scrollableViewScrollExtent = getScrollableViewScrollExtent();
            int scrollableViewScrollOffset = getScrollableViewScrollOffset();
            int scrollableViewScrollRange = getScrollableViewScrollRange();
            int iAbs = this.f6572v ? Math.abs((int) this.f6556a.getTranslationY()) : (int) Math.abs(this.f6556a.getTranslationX());
            j8.a aVar4 = this.f6557b;
            if (aVar4.h != scrollableViewScrollRange || aVar4.f9727j != scrollableViewScrollOffset || aVar4.f9728k != scrollableViewScrollExtent || aVar4.f9730m != iAbs) {
                aVar4.h = scrollableViewScrollRange;
                aVar4.f9727j = scrollableViewScrollOffset;
                aVar4.f9728k = scrollableViewScrollExtent;
                aVar4.f9730m = iAbs;
                aVar4.f9733p = true;
            }
            this.f6557b.draw(canvas);
            if (cVar.f6586c == 1) {
                int i14 = this.f6557b.f9729l;
            }
            if (z) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        super.onLayout(z, i10, i11, i12, i13);
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i14 = this.C == 1 ? this.f6564m : this.f6563l;
        j8.a aVar = this.f6557b;
        if (aVar != null) {
            if (!this.f6572v) {
                int i15 = (measuredHeight - paddingBottom) - i14;
                aVar.setBounds(paddingStart, i15, measuredWidth - paddingEnd, i14 + i15);
            } else {
                if (!M) {
                    paddingEnd = (measuredWidth - paddingEnd) - i14;
                }
                aVar.setBounds(paddingEnd, paddingTop, i14 + paddingEnd, measuredHeight - paddingBottom);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int size;
        int size2;
        int measuredHeight;
        super.onMeasure(i10, i11);
        boolean z = this.f6572v;
        if (!z) {
            if (z) {
                size2 = View.MeasureSpec.getSize(i11);
                size = this.f6562k;
            } else {
                size = View.MeasureSpec.getSize(i10);
                size2 = this.f6562k;
            }
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        int size3 = View.MeasureSpec.getSize(i11);
        if (View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE) {
            int i12 = 0;
            if (getParent() != null && (getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) getParent();
                for (int i13 = 0; i13 < viewGroup.getChildCount(); i13++) {
                    View childAt = viewGroup.getChildAt(i13);
                    if (childAt != this && (measuredHeight = childAt.getMeasuredHeight()) > i12) {
                        i12 = measuredHeight;
                    }
                }
            }
            size3 = i12;
        }
        setMeasuredDimension(this.f6562k, size3);
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f9  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r13) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1059
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.scrollbarview.StepOSScrollBarView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAdapter(com.stepos.common.scrollbarview.a aVar) {
        this.f6561j = aVar;
        this.f6557b.f9726e = aVar;
    }

    public void setFadeEnable(boolean z) {
        this.f6565n = z;
        a(true);
    }

    public void setFitSystemBottomPadding(boolean z) {
        this.f6568q = z;
        if (z) {
            requestApplyInsets();
        }
    }

    public void setFitSystemTopPadding(boolean z) {
        this.f6567p = z;
        if (z) {
            requestApplyInsets();
        }
    }

    public void setOperable(boolean z) {
        this.f6566o = z;
    }

    public void setScrollState(int i10) {
        this.C = i10;
    }

    public void setScrollableView(View view) {
        this.f6556a = view;
        if (view instanceof StepOSRecyclerView) {
            this.D = ((StepOSRecyclerView) view).getSpringAnimationHelper();
        }
        a(true);
    }
}
