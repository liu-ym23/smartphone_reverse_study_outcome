package com.stepos.common.scrollbarview;

import O6.s;
import O6.y;
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
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.common.R$attr;
import com.stepos.common.R$color;
import com.stepos.common.R$styleable;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes3.dex */
public class StepOSScrollBarView extends View {
    private static final boolean DEBUG = false;
    private static final int FADE_DELAY_DURATION = 2000;
    private static final int FADE_DURATION_DEFAULT = 500;
    private static final float FULL_OPAQUE = 255.0f;
    private static final float FULL_TRANSPARENT = 0.0f;
    private static final int HOTSPOT_THICKNESS = 30;
    private static final int RESTORE_DURATION = 250;
    private static final int SCALE_DELAY_DURATION = 0;
    private static final int SCALE_DURATION = 250;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "StepOSSScrollBarView";
    private static final int THUMB_THICKNESS_DEFAULT = 2;
    private static final int THUMB_THICKNESS_SCALED = 6;
    private static final int VELOCITY_INCREASE_FACTOR = 2;
    private static final int VELOCITY_UNITS = 1000;
    private static final float epsilon = 1.0E-4f;
    private static boolean isRTL;
    private static Method sComputeHorizontalScrollExtentMethod;
    private static Method sComputeHorizontalScrollOffsetMethod;
    private static Method sComputeHorizontalScrollRangeMethod;
    private static Method sComputeVerticalScrollExtentMethod;
    private static Method sComputeVerticalScrollOffsetMethod;
    private static Method sComputeVerticalScrollRangeMethod;
    private static final Interpolator sScaleInterpolator = D0.a.a(0.4f, 0.0f, 0.2f, 1.0f);
    private List<b> listeners;
    private com.stepos.common.scrollbarview.a mAdapter;
    private boolean mFadeEnable;
    boolean mFingerOn;
    private boolean mFitSystemBottomPadding;
    private boolean mFitSystemTopPadding;
    private Handler mHandler;
    private int mHotSpotSize;
    private float mLastMotionX;
    private float mLastMotionY;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private boolean mOperable;
    private int mPointerIndex;
    private final c mScaleAction;
    private boolean mScaledDelay;
    private com.stepos.common.scrollbarview.b mScrollBarDrawable;
    private int mScrollBarDrawableScaledThickness;
    private int mScrollBarDrawableThickness;
    private final d mScrollCache;
    private int mScrollState;
    private View mScrollableView;
    private Lc.c mSpringAnimation;
    private Drawable mThumbDrawable;
    private int mThumbDrawableTint;
    private Drawable mTrackDrawable;
    private int mTrackDrawableTint;
    private VelocityTracker mVelocityTracker;
    private boolean mVertical;

    public static abstract class a {
    }

    public interface b {
        void a(StepOSScrollBarView stepOSScrollBarView, int i10);

        void b(StepOSScrollBarView stepOSScrollBarView, int i10, int i11);
    }

    public static class c implements Runnable {
        public static final int NORMAL = 0;
        public static final int SCALED = 2;
        public static final int SCALING = 1;
        private final View host;
        public boolean mRestore;
        private final int normalThickness;
        public ValueAnimator scaleAnimator;
        public long scaleStartTime;
        private final int scaleThickness;
        public int state = 0;
        private final com.stepos.common.scrollbarview.b stepOSScrollBarDrawable;

        public c(View view, int i10, int i11, com.stepos.common.scrollbarview.b bVar) {
            this.host = view;
            this.normalThickness = i10;
            this.scaleThickness = i11;
            this.stepOSScrollBarDrawable = bVar;
        }

        public static /* synthetic */ void a(c cVar, int i10, ValueAnimator valueAnimator) {
            cVar.getClass();
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue() + i10;
            com.stepos.common.scrollbarview.b bVar = cVar.stepOSScrollBarDrawable;
            bVar.setBounds(i10, bVar.getBounds().top, iIntValue, cVar.stepOSScrollBarDrawable.getBounds().bottom);
        }

        public final void b() {
            if (this.scaleAnimator == null) {
                this.scaleAnimator = new ValueAnimator();
            }
        }

        public void c() {
            ValueAnimator valueAnimator = this.scaleAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.scaleAnimator.cancel();
        }

        public void d(int i10, int i11) {
            c();
            b();
            this.scaleAnimator.setIntValues(i10, i11);
            this.scaleAnimator.setDuration(250L);
            this.scaleAnimator.setInterpolator(StepOSScrollBarView.sScaleInterpolator);
            this.scaleAnimator.start();
            this.state = 1;
            this.mRestore = true;
            this.host.postInvalidate();
        }

        @Override // java.lang.Runnable
        public void run() {
            com.stepos.common.scrollbarview.b bVar;
            if (AnimationUtils.currentAnimationTimeMillis() < this.scaleStartTime || this.state != 0) {
                return;
            }
            b();
            this.state = 1;
            this.mRestore = false;
            this.scaleAnimator.setDuration(250L);
            this.scaleAnimator.setInterpolator(StepOSScrollBarView.sScaleInterpolator);
            this.scaleAnimator.setIntValues(this.normalThickness, this.scaleThickness);
            if (StepOSScrollBarView.isRTL && (bVar = this.stepOSScrollBarDrawable) != null) {
                final int i10 = bVar.getBounds().left;
                this.scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.scrollbarview.c
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        StepOSScrollBarView.c.a(this.f29513a, i10, valueAnimator);
                    }
                });
            }
            this.scaleAnimator.start();
            this.host.postInvalidate();
        }
    }

    public static class d implements Runnable {
        public static final int FADING = 2;
        public static final int OFF = 0;
        public static final int ON = 1;
        private static final float[] OPAQUE = {StepOSScrollBarView.FULL_OPAQUE};
        private static final float[] TRANSPARENT = {0.0f};
        public long fadeStartTime;
        public View host;
        public float[] interpolatorValues;
        public final android.graphics.Interpolator scrollBarInterpolator = new android.graphics.Interpolator(1, 2);
        public int state = 0;

        public d(View view) {
            this.host = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.fadeStartTime || this.state != 1) {
                return;
            }
            View view = this.host;
            if (!(view instanceof StepOSScrollBarView) || ((StepOSScrollBarView) view).mFingerOn) {
                return;
            }
            int i10 = (int) jCurrentAnimationTimeMillis;
            android.graphics.Interpolator interpolator = this.scrollBarInterpolator;
            interpolator.setKeyFrame(0, i10, OPAQUE);
            interpolator.setKeyFrame(1, i10 + 500, TRANSPARENT);
            this.state = 2;
            this.host.invalidate();
        }
    }

    static {
        try {
            sComputeVerticalScrollExtentMethod = View.class.getDeclaredMethod("computeVerticalScrollExtent", null);
            sComputeVerticalScrollRangeMethod = View.class.getDeclaredMethod("computeVerticalScrollRange", null);
            sComputeVerticalScrollOffsetMethod = View.class.getDeclaredMethod("computeVerticalScrollOffset", null);
            sComputeHorizontalScrollRangeMethod = View.class.getDeclaredMethod("computeHorizontalScrollRange", null);
            sComputeHorizontalScrollExtentMethod = View.class.getDeclaredMethod("computeHorizontalScrollExtent", null);
            sComputeHorizontalScrollOffsetMethod = View.class.getDeclaredMethod("computeHorizontalScrollOffset", null);
            Method method = sComputeVerticalScrollExtentMethod;
            if (method != null) {
                method.setAccessible(true);
            }
            Method method2 = sComputeVerticalScrollRangeMethod;
            if (method2 != null) {
                method2.setAccessible(true);
            }
            Method method3 = sComputeVerticalScrollOffsetMethod;
            if (method3 != null) {
                method3.setAccessible(true);
            }
            Method method4 = sComputeHorizontalScrollExtentMethod;
            if (method4 != null) {
                method4.setAccessible(true);
            }
            Method method5 = sComputeHorizontalScrollRangeMethod;
            if (method5 != null) {
                method5.setAccessible(true);
            }
            Method method6 = sComputeHorizontalScrollOffsetMethod;
            if (method6 != null) {
                method6.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            Log.e(TAG, "get reflect method has an error!");
        }
        isRTL = false;
    }

    public StepOSScrollBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.steposScrollBarViewStyle);
    }

    private int getScrollableViewScrollExtent() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.mVertical ? sComputeVerticalScrollExtentMethod : sComputeHorizontalScrollExtentMethod;
        View view = this.mScrollableView;
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
            Log.e(TAG, "invoke computeVerticalScrollExtent has an error!");
            return 0;
        }
    }

    private int getScrollableViewScrollOffset() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.mVertical ? sComputeVerticalScrollOffsetMethod : sComputeHorizontalScrollOffsetMethod;
        View view = this.mScrollableView;
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
            Log.e(TAG, "invoke computeVerticalScrollOffset has an error!");
            return 0;
        }
    }

    private int getScrollableViewScrollRange() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.mVertical ? sComputeVerticalScrollRangeMethod : sComputeHorizontalScrollRangeMethod;
        View view = this.mScrollableView;
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
            Log.e(TAG, "invoke computeVerticalScrollRange has an error!");
            return 0;
        }
    }

    public void c() {
        d(true);
    }

    public void d(boolean z10) {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        if (this.mFadeEnable) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + 2000;
            d dVar = this.mScrollCache;
            dVar.fadeStartTime = jCurrentAnimationTimeMillis;
            dVar.state = 1;
            this.mHandler.removeCallbacks(dVar);
            this.mHandler.postAtTime(this.mScrollCache, jCurrentAnimationTimeMillis);
        } else {
            this.mScrollCache.state = 1;
        }
        if (z10) {
            invalidate();
        }
    }

    public final void e(float f10, float f11) {
        Lc.c cVar = this.mSpringAnimation;
        if (cVar != null) {
            cVar.A(f10, f11);
        }
    }

    public void f() {
        int iD = this.mScrollBarDrawable.d();
        boolean z10 = this.mVertical;
        int i10 = z10 ? 0 : iD;
        if (!z10) {
            iD = 0;
        }
        List<b> list = this.listeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.listeners.get(size).b(this, i10, iD);
            }
        }
    }

    public final void g(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.StepOSScrollBarView, i10, 0);
        this.mScrollBarDrawableThickness = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.StepOSScrollBarView_scrollBarThickness, (int) s.a(2.0f, context));
        this.mScrollBarDrawableScaledThickness = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.StepOSScrollBarView_scrollBarScaledThickness, (int) s.a(6.0f, context));
        this.mHotSpotSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.StepOSScrollBarView_scrollBarHotspot, (int) s.a(30.0f, context));
        this.mFadeEnable = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSScrollBarView_scrollBarFadeEnable, true);
        this.mOperable = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSScrollBarView_scrollBarOperable, true);
        this.mFitSystemTopPadding = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSScrollBarView_fitSystemTopPadding, false);
        this.mFitSystemBottomPadding = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSScrollBarView_fitSystemBottomPadding, false);
        this.mVertical = typedArrayObtainStyledAttributes.getInt(R$styleable.StepOSScrollBarView_scrollBarOrientation, 1) == 1;
        this.mThumbDrawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.StepOSScrollBarView_scrollBarThumbDrawable);
        this.mTrackDrawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.StepOSScrollBarView_scrollBarTrackDrawable);
        this.mThumbDrawableTint = typedArrayObtainStyledAttributes.getColor(R$styleable.StepOSScrollBarView_scrollBarThumbTint, context.getResources().getColor(R$color.stepos_scrollbar_thumb_drawable_color));
        this.mTrackDrawableTint = typedArrayObtainStyledAttributes.getColor(R$styleable.StepOSScrollBarView_scrollBarTrackTint, context.getResources().getColor(R$color.stepos_scrollbar_track_drawable_color));
        h();
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void h() {
        if (this.mScrollBarDrawable == null) {
            this.mScrollBarDrawable = new com.stepos.common.scrollbarview.b(this.mVertical, this.mAdapter);
        }
        this.mScrollBarDrawable.k(this.mThumbDrawable);
        this.mScrollBarDrawable.l(this.mTrackDrawable);
        this.mScrollBarDrawable.g(false);
        this.mThumbDrawable.mutate().setTint(this.mThumbDrawableTint);
        this.mTrackDrawable.mutate().setTint(this.mTrackDrawableTint);
    }

    public final boolean i(float f10, float f11) {
        Drawable drawableC = this.mScrollBarDrawable.c();
        if (drawableC == null) {
            return false;
        }
        Rect rect = new Rect(drawableC.getBounds());
        if (this.mVertical) {
            rect.left = 0;
            rect.right = getMeasuredWidth();
        } else {
            rect.top = 0;
            rect.bottom = getMeasuredHeight();
        }
        return rect.contains((int) f10, (int) f11);
    }

    public final void j(MotionEvent motionEvent, int i10) {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        d(false);
        m();
        boolean zS = this.mVertical ? s(motionEvent, i10) : r(motionEvent, i10);
        if (zS && this.mScrollState != 1) {
            setScrollState(1);
        }
        View view = this.mScrollableView;
        boolean zG0 = view instanceof StepOSRecyclerView ? ((StepOSRecyclerView) view).G0() : true;
        View view2 = this.mScrollableView;
        if (view2 instanceof N6.a) {
            zG0 = ((N6.a) view2).a();
        }
        View view3 = this.mScrollableView;
        if (view3 instanceof StepOSNestedScrollView) {
            zG0 = ((StepOSNestedScrollView) view3).X();
        }
        if (!zS && this.mSpringAnimation != null && zG0) {
            if (this.mVertical) {
                p(motionEvent, i10);
            } else {
                o(motionEvent, i10);
            }
        }
        this.mLastMotionX = motionEvent.getX(i10);
        this.mLastMotionY = motionEvent.getY(i10);
    }

    public final void k() {
        this.mScaledDelay = false;
        this.mLastMotionY = 0.0f;
        this.mLastMotionX = 0.0f;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mScaleAction);
        }
        this.mScaleAction.c();
        if (this.mVertical) {
            this.mScaleAction.d(this.mScrollBarDrawable.getBounds().width(), this.mScrollBarDrawableThickness);
        } else {
            this.mScaleAction.d(this.mScrollBarDrawable.getBounds().height(), this.mScrollBarDrawableThickness);
        }
        if (this.mScrollableView.getTranslationY() != 0.0f || this.mScrollableView.getTranslationX() != 0.0f) {
            q();
            return;
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        n((int) (this.mVertical ? velocityTracker.getYVelocity(this.mPointerIndex) : velocityTracker.getXVelocity(this.mPointerIndex)));
    }

    public final void l(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        d dVar;
        int i10;
        boolean z10;
        if (getVisibility() == 0 && (i10 = (dVar = this.mScrollCache).state) != 0) {
            if (i10 == 2) {
                if (dVar.interpolatorValues == null) {
                    dVar.interpolatorValues = new float[1];
                }
                float[] fArr = dVar.interpolatorValues;
                if (dVar.scrollBarInterpolator.timeToValues(fArr) == Interpolator.Result.FREEZE_END) {
                    this.mScrollCache.state = 0;
                } else {
                    this.mScrollBarDrawable.mutate().setAlpha(Math.round(fArr[0]));
                }
                z10 = true;
            } else {
                this.mScrollBarDrawable.mutate().setAlpha(255);
                z10 = false;
            }
            if (this.mScaleAction.state == 1) {
                this.mScaledDelay = false;
                d(false);
                Object animatedValue = this.mScaleAction.scaleAnimator.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    this.mScrollBarDrawable.j(((Integer) animatedValue).intValue());
                    if (!this.mScaleAction.scaleAnimator.isRunning()) {
                        c cVar = this.mScaleAction;
                        boolean z11 = cVar.mRestore;
                        cVar.state = z11 ? 0 : 2;
                        if (!z11) {
                            y.c(this.mScrollableView, y.a());
                        }
                    }
                    z10 = true;
                }
            }
            int scrollableViewScrollExtent = getScrollableViewScrollExtent();
            this.mScrollBarDrawable.h(getScrollableViewScrollRange(), getScrollableViewScrollOffset(), scrollableViewScrollExtent, this.mVertical ? Math.abs((int) this.mScrollableView.getTranslationY()) : (int) Math.abs(this.mScrollableView.getTranslationX()));
            this.mScrollBarDrawable.draw(canvas);
            if (this.mScrollCache.state == 1) {
                f();
            }
            if (z10) {
                invalidate();
            }
        }
    }

    public final void m() {
        if (this.mScaleAction.state != 0 || this.mScaledDelay) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        c cVar = this.mScaleAction;
        cVar.scaleStartTime = jCurrentAnimationTimeMillis;
        cVar.state = 0;
        this.mHandler.postAtTime(cVar, jCurrentAnimationTimeMillis);
        this.mScaledDelay = true;
    }

    public final void n(int i10) {
        boolean z10 = this.mVertical;
        int i11 = z10 ? 0 : i10 * 2;
        int i12 = z10 ? i10 * 2 : 0;
        int iMin = Math.min(this.mMaxFlingVelocity, i11);
        int iMin2 = Math.min(this.mMaxFlingVelocity, i12);
        if (this.mVertical) {
            if (Math.abs(iMin2) <= this.mMinFlingVelocity) {
                return;
            }
        } else if (Math.abs(iMin) <= this.mMinFlingVelocity) {
            return;
        }
        View view = this.mScrollableView;
        if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(iMin, iMin2);
        }
        View view2 = this.mScrollableView;
        if (view2 instanceof ScrollView) {
            ((ScrollView) view2).fling(iMin2);
        }
        View view3 = this.mScrollableView;
        if (view3 instanceof NestedScrollView) {
            ((NestedScrollView) view3).p(iMin2);
        }
        View view4 = this.mScrollableView;
        if (view4 instanceof AbsListView) {
            ((AbsListView) view4).fling(iMin2);
        }
        if (this.mScrollState != 2) {
            setScrollState(2);
        }
    }

    public final void o(MotionEvent motionEvent, int i10) {
        float x10 = motionEvent.getX(i10) - this.mLastMotionX;
        boolean zCanScrollHorizontally = this.mScrollableView.canScrollHorizontally(-1);
        boolean zCanScrollHorizontally2 = this.mScrollableView.canScrollHorizontally(1);
        float translationX = this.mScrollableView.getTranslationX();
        if ((!zCanScrollHorizontally2 && x10 > 0.0f) || (!zCanScrollHorizontally && x10 < 0.0f)) {
            this.mScrollableView.setTranslationX(translationX - x10);
        }
        if (!zCanScrollHorizontally2 && x10 <= 0.0f) {
            this.mScrollableView.setTranslationX(Math.min(0.0f, translationX - x10));
        } else if (!zCanScrollHorizontally && x10 >= 0.0f) {
            this.mScrollableView.setTranslationX(Math.max(0.0f, translationX - x10));
        }
        d(true);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        if (this.mFitSystemTopPadding && insets.top != getPaddingTop()) {
            setPadding(getPaddingLeft(), insets.top, getPaddingRight(), getPaddingBottom());
        }
        if (this.mFitSystemBottomPadding && insets.bottom != getPaddingBottom()) {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), insets.bottom);
        }
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mScrollCache);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onDraw(canvas);
        l(canvas);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i14 = this.mScrollState == 1 ? this.mScrollBarDrawableScaledThickness : this.mScrollBarDrawableThickness;
        com.stepos.common.scrollbarview.b bVar = this.mScrollBarDrawable;
        if (bVar != null) {
            if (!this.mVertical) {
                int i15 = (measuredHeight - paddingBottom) - i14;
                bVar.setBounds(paddingStart, i15, measuredWidth - paddingEnd, i14 + i15);
            } else {
                if (!isRTL) {
                    paddingEnd = (measuredWidth - paddingEnd) - i14;
                }
                bVar.setBounds(paddingEnd, paddingTop, i14 + paddingEnd, measuredHeight - paddingBottom);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int size;
        int size2;
        int measuredHeight;
        super.onMeasure(i10, i11);
        boolean z10 = this.mVertical;
        if (!z10) {
            if (z10) {
                size2 = View.MeasureSpec.getSize(i11);
                size = this.mHotSpotSize;
            } else {
                size = View.MeasureSpec.getSize(i10);
                size2 = this.mHotSpotSize;
            }
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        int i12 = this.mHotSpotSize;
        int size3 = View.MeasureSpec.getSize(i11);
        if (View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE) {
            size3 = 0;
            if (getParent() != null && (getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) getParent();
                int i13 = 0;
                while (size3 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(size3);
                    if (childAt != this && (measuredHeight = childAt.getMeasuredHeight()) > i13) {
                        i13 = measuredHeight;
                    }
                    size3++;
                }
                size3 = i13;
            }
        }
        setMeasuredDimension(i12, size3);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ba  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.scrollbarview.StepOSScrollBarView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(MotionEvent motionEvent, int i10) {
        float y10 = motionEvent.getY(i10) - this.mLastMotionY;
        boolean zCanScrollVertically = this.mScrollableView.canScrollVertically(-1);
        boolean zCanScrollVertically2 = this.mScrollableView.canScrollVertically(1);
        float translationY = this.mScrollableView.getTranslationY();
        if ((!zCanScrollVertically2 && y10 > 0.0f) || (!zCanScrollVertically && y10 < 0.0f)) {
            float f10 = translationY - y10;
            this.mScrollableView.setTranslationY(f10);
            e(0.0f, f10);
        }
        if (!zCanScrollVertically2 && y10 <= 0.0f) {
            float fMin = Math.min(0.0f, translationY - y10);
            this.mScrollableView.setTranslationY(fMin);
            e(0.0f, fMin);
        } else if (!zCanScrollVertically && y10 >= 0.0f) {
            float fMax = Math.max(0.0f, translationY - y10);
            this.mScrollableView.setTranslationY(fMax);
            e(0.0f, fMax);
        }
        d(true);
    }

    public final void q() {
        Lc.c cVar = this.mSpringAnimation;
        if (cVar != null) {
            cVar.r();
        }
    }

    public final boolean r(MotionEvent motionEvent, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        float x10 = motionEvent.getX(i10) - this.mLastMotionX;
        if (Math.abs(this.mScrollableView.getTranslationX() - 0.0f) >= epsilon) {
            return false;
        }
        boolean zCanScrollHorizontally = this.mScrollableView.canScrollHorizontally(-1);
        boolean zCanScrollHorizontally2 = this.mScrollableView.canScrollHorizontally(1);
        if ((!zCanScrollHorizontally && x10 < 0.0f) || (!zCanScrollHorizontally2 && x10 > 0.0f)) {
            return false;
        }
        this.mScrollableView.scrollBy(this.mAdapter.b((int) (this.mScrollBarDrawable.d() + x10), this.mScrollBarDrawable.getBounds().width(), this.mScrollBarDrawable.c().getBounds().width(), getScrollableViewScrollExtent(), getScrollableViewScrollRange()) - getScrollableViewScrollOffset(), 0);
        return true;
    }

    public final boolean s(MotionEvent motionEvent, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        float y10 = motionEvent.getY(i10) - this.mLastMotionY;
        if (Math.abs(this.mScrollableView.getTranslationY() - 0.0f) >= epsilon) {
            return false;
        }
        boolean zCanScrollVertically = this.mScrollableView.canScrollVertically(-1);
        boolean zCanScrollVertically2 = this.mScrollableView.canScrollVertically(1);
        if ((!zCanScrollVertically && y10 < 0.0f) || (!zCanScrollVertically2 && y10 > 0.0f)) {
            return false;
        }
        int iB = this.mAdapter.b((int) (this.mScrollBarDrawable.d() + y10), this.mScrollBarDrawable.getBounds().height(), this.mScrollBarDrawable.c().getBounds().height(), getScrollableViewScrollExtent(), getScrollableViewScrollRange()) - getScrollableViewScrollOffset();
        View view = this.mScrollableView;
        if (view instanceof AbsListView) {
            ((ListView) view).scrollListBy(iB);
        } else {
            view.scrollBy(0, iB);
        }
        return true;
    }

    public void setAdapter(com.stepos.common.scrollbarview.a aVar) {
        this.mAdapter = aVar;
        this.mScrollBarDrawable.i(aVar);
    }

    public void setFadeEnable(boolean z10) {
        this.mFadeEnable = z10;
        c();
    }

    public void setFitSystemBottomPadding(boolean z10) {
        this.mFitSystemBottomPadding = z10;
        if (z10) {
            requestApplyInsets();
        }
    }

    public void setFitSystemTopPadding(boolean z10) {
        this.mFitSystemTopPadding = z10;
        if (z10) {
            requestApplyInsets();
        }
    }

    public void setOperable(boolean z10) {
        this.mOperable = z10;
    }

    public void setScrollState(int i10) {
        this.mScrollState = i10;
        List<b> list = this.listeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.listeners.get(size).a(this, i10);
            }
        }
    }

    public void setScrollableView(View view) {
        this.mScrollableView = view;
        if (view instanceof StepOSRecyclerView) {
            this.mSpringAnimation = ((StepOSRecyclerView) view).getSpringAnimationHelper();
        }
        c();
    }

    public final void t(MotionEvent motionEvent, int i10) {
        if (motionEvent.getPointerId(i10) == this.mPointerIndex) {
            int i11 = i10 == 0 ? 1 : 0;
            this.mPointerIndex = motionEvent.getPointerId(i11);
            this.mLastMotionX = motionEvent.getX(i11);
            this.mLastMotionY = motionEvent.getY(i11);
        }
    }

    public StepOSScrollBarView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mFadeEnable = true;
        this.mOperable = true;
        this.mVertical = true;
        this.mScrollState = 0;
        O6.c.e(this, 2);
        this.mAdapter = new com.stepos.common.scrollbarview.a();
        g(context, attributeSet, i10);
        isRTL = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.mScrollCache = new d(this);
        this.mScaleAction = new c(this, this.mScrollBarDrawableThickness, this.mScrollBarDrawableScaledThickness, this.mScrollBarDrawable);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }
}
