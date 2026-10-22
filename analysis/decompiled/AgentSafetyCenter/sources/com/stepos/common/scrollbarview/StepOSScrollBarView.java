package com.stepos.common.scrollbarview;

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
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import stepos.support.v7.widget.StepOSRecyclerView;
import t9.a;
import t9.b;
import t9.e;
import u9.k;
import ve.d;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StepOSScrollBarView extends View {
    public static final PathInterpolator G = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    public static final Method H;
    public static final Method I;
    public static final Method J;
    public static final Method K;
    public static final Method L;
    public static final Method M;
    public static boolean N;
    public final int A;
    public final int B;
    public VelocityTracker C;
    public int D;
    public d E;
    public boolean F;

    /* renamed from: c, reason: collision with root package name */
    public View f2537c;

    /* renamed from: f, reason: collision with root package name */
    public final b f2538f;

    /* renamed from: g, reason: collision with root package name */
    public final Drawable f2539g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f2540h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2541j;

    /* renamed from: k, reason: collision with root package name */
    public a f2542k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2543l;

    /* renamed from: m, reason: collision with root package name */
    public final int f2544m;

    /* renamed from: n, reason: collision with root package name */
    public final int f2545n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2546o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2547p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2548q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2549r;

    /* renamed from: s, reason: collision with root package name */
    public final e f2550s;

    /* renamed from: t, reason: collision with root package name */
    public final t9.d f2551t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2552u;

    /* renamed from: v, reason: collision with root package name */
    public Handler f2553v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f2554w;

    /* renamed from: x, reason: collision with root package name */
    public float f2555x;

    /* renamed from: y, reason: collision with root package name */
    public float f2556y;

    /* renamed from: z, reason: collision with root package name */
    public int f2557z;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollExtent", null);
            H = declaredMethod;
            Method declaredMethod2 = View.class.getDeclaredMethod("computeVerticalScrollRange", null);
            J = declaredMethod2;
            Method declaredMethod3 = View.class.getDeclaredMethod("computeVerticalScrollOffset", null);
            I = declaredMethod3;
            Method declaredMethod4 = View.class.getDeclaredMethod("computeHorizontalScrollRange", null);
            M = declaredMethod4;
            Method declaredMethod5 = View.class.getDeclaredMethod("computeHorizontalScrollExtent", null);
            K = declaredMethod5;
            Method declaredMethod6 = View.class.getDeclaredMethod("computeHorizontalScrollOffset", null);
            L = declaredMethod6;
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
        N = false;
    }

    public StepOSScrollBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2546o = true;
        this.f2547p = true;
        this.f2554w = true;
        this.D = 0;
        setForceDarkAllowed(false);
        this.f2542k = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q9.a.i, i, 0);
        this.f2544m = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, (int) t1.e.e(2.0f, context));
        this.f2545n = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, (int) t1.e.e(6.0f, context));
        this.f2543l = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, (int) t1.e.e(30.0f, context));
        this.f2546o = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.f2547p = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.f2548q = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.f2549r = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.f2554w = typedArrayObtainStyledAttributes.getInt(5, 1) == 1;
        this.f2540h = typedArrayObtainStyledAttributes.getDrawable(8);
        this.f2539g = typedArrayObtainStyledAttributes.getDrawable(10);
        this.f2541j = typedArrayObtainStyledAttributes.getColor(9, context.getResources().getColor(R.color.stepos_scrollbar_thumb_drawable_color));
        this.i = typedArrayObtainStyledAttributes.getColor(11, context.getResources().getColor(R.color.stepos_scrollbar_track_drawable_color));
        if (this.f2538f == null) {
            boolean z10 = this.f2554w;
            a aVar = this.f2542k;
            b bVar = new b();
            bVar.f13271s = 255;
            bVar.f13267o = z10;
            bVar.i = aVar;
            VarHandle.storeStoreFence();
            this.f2538f = bVar;
        }
        b bVar2 = this.f2538f;
        Drawable drawable = this.f2540h;
        if (bVar2.f13267o) {
            Drawable drawable2 = bVar2.f13259f;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            bVar2.b(drawable);
            bVar2.f13259f = drawable;
        } else {
            Drawable drawable3 = bVar2.f13261h;
            if (drawable3 != null) {
                drawable3.setCallback(null);
            }
            bVar2.b(drawable);
            bVar2.f13261h = drawable;
        }
        b bVar3 = this.f2538f;
        Drawable drawable4 = this.f2539g;
        if (bVar3.f13267o) {
            Drawable drawable5 = bVar3.f13258c;
            if (drawable5 != null) {
                drawable5.setCallback(null);
            }
            bVar3.b(drawable4);
            bVar3.f13258c = drawable4;
        } else {
            Drawable drawable6 = bVar3.f13260g;
            if (drawable6 != null) {
                drawable6.setCallback(null);
            }
            bVar3.b(drawable4);
            bVar3.f13260g = drawable4;
        }
        this.f2538f.getClass();
        this.f2540h.mutate().setTint(this.f2541j);
        this.f2539g.mutate().setTint(this.i);
        typedArrayObtainStyledAttributes.recycle();
        N = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        e eVar = new e();
        eVar.f13286c = new Interpolator(1, 2);
        eVar.f13288g = 0;
        eVar.i = this;
        VarHandle.storeStoreFence();
        this.f2550s = eVar;
        int i3 = this.f2544m;
        int i10 = this.f2545n;
        b bVar4 = this.f2538f;
        t9.d dVar = new t9.d();
        dVar.f13277c = 0;
        dVar.f13280h = this;
        dVar.i = i3;
        dVar.f13281j = i10;
        dVar.f13283l = bVar4;
        VarHandle.storeStoreFence();
        this.f2551t = dVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.A = viewConfiguration.getScaledMinimumFlingVelocity();
        this.B = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private int getScrollableViewScrollExtent() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f2554w ? H : K;
        View view = this.f2537c;
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
        Method method = this.f2554w ? I : L;
        View view = this.f2537c;
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
        Method method = this.f2554w ? J : M;
        View view = this.f2537c;
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

    public final void a(boolean z10) {
        if (this.f2553v == null) {
            this.f2553v = new Handler();
        }
        boolean z11 = this.f2546o;
        e eVar = this.f2550s;
        if (z11) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + 2000;
            eVar.f13289h = jCurrentAnimationTimeMillis;
            eVar.f13288g = 1;
            this.f2553v.removeCallbacks(eVar);
            this.f2553v.postAtTime(eVar, jCurrentAnimationTimeMillis);
        } else {
            eVar.f13288g = 1;
        }
        if (z10) {
            invalidate();
        }
    }

    public final void b() {
        t9.d dVar = this.f2551t;
        if (dVar.f13277c != 0 || this.f2552u) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        dVar.f13278f = jCurrentAnimationTimeMillis;
        dVar.f13277c = 0;
        this.f2553v.postAtTime(dVar, jCurrentAnimationTimeMillis);
        this.f2552u = true;
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        if (this.f2548q && insets.top != getPaddingTop()) {
            setPadding(getPaddingLeft(), insets.top, getPaddingRight(), getPaddingBottom());
        }
        if (this.f2549r && insets.bottom != getPaddingBottom()) {
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
        Handler handler = this.f2553v;
        if (handler != null) {
            handler.removeCallbacks(this.f2550s);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        e eVar;
        int i;
        boolean z10;
        super.onDraw(canvas);
        if (getVisibility() == 0 && (i = (eVar = this.f2550s).f13288g) != 0) {
            if (i == 2) {
                if (eVar.f13287f == null) {
                    eVar.f13287f = new float[1];
                }
                float[] fArr = eVar.f13287f;
                if (eVar.f13286c.timeToValues(fArr) == Interpolator.Result.FREEZE_END) {
                    eVar.f13288g = 0;
                } else {
                    b bVar = this.f2538f;
                    bVar.a();
                    bVar.setAlpha(Math.round(fArr[0]));
                }
                z10 = true;
            } else {
                b bVar2 = this.f2538f;
                bVar2.a();
                bVar2.setAlpha(255);
                z10 = false;
            }
            t9.d dVar = this.f2551t;
            if (dVar.f13277c == 1) {
                this.f2552u = false;
                a(false);
                Object animatedValue = dVar.f13279g.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    int iIntValue = ((Integer) animatedValue).intValue();
                    b bVar3 = this.f2538f;
                    Rect bounds = bVar3.getBounds();
                    if (bVar3.f13267o) {
                        int i3 = bounds.right;
                        bVar3.setBounds(i3 - iIntValue, bounds.top, i3, bounds.bottom);
                    } else {
                        int i10 = bounds.left;
                        int i11 = bounds.bottom;
                        bVar3.setBounds(i10, i11 - iIntValue, bounds.right, i11);
                    }
                    if (!dVar.f13279g.isRunning()) {
                        boolean z11 = dVar.f13282k;
                        dVar.f13277c = z11 ? 0 : 2;
                        if (!z11) {
                            View view = this.f2537c;
                            if (k.a()) {
                                view.performHapticFeedback(31020);
                            } else {
                                view.performHapticFeedback(0);
                            }
                        }
                    }
                    z10 = true;
                }
            }
            int scrollableViewScrollExtent = getScrollableViewScrollExtent();
            int scrollableViewScrollOffset = getScrollableViewScrollOffset();
            int scrollableViewScrollRange = getScrollableViewScrollRange();
            View view2 = this.f2537c;
            int iAbs = this.f2554w ? Math.abs((int) view2.getTranslationY()) : (int) Math.abs(view2.getTranslationX());
            b bVar4 = this.f2538f;
            if (bVar4.f13262j != scrollableViewScrollRange || bVar4.f13263k != scrollableViewScrollOffset || bVar4.f13264l != scrollableViewScrollExtent || bVar4.f13266n != iAbs) {
                bVar4.f13262j = scrollableViewScrollRange;
                bVar4.f13263k = scrollableViewScrollOffset;
                bVar4.f13264l = scrollableViewScrollExtent;
                bVar4.f13266n = iAbs;
                bVar4.f13269q = true;
            }
            this.f2538f.draw(canvas);
            if (eVar.f13288g == 1) {
                this.f2538f.getClass();
            }
            if (z10) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        super.onLayout(z10, i, i3, i10, i11);
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i12 = this.D == 1 ? this.f2545n : this.f2544m;
        b bVar = this.f2538f;
        if (bVar != null) {
            if (!this.f2554w) {
                int i13 = (measuredHeight - paddingBottom) - i12;
                bVar.setBounds(paddingStart, i13, measuredWidth - paddingEnd, i12 + i13);
            } else {
                if (!N) {
                    paddingEnd = (measuredWidth - paddingEnd) - i12;
                }
                bVar.setBounds(paddingEnd, paddingTop, i12 + paddingEnd, measuredHeight - paddingBottom);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        int size;
        int size2;
        int measuredHeight;
        super.onMeasure(i, i3);
        boolean z10 = this.f2554w;
        if (!z10) {
            if (z10) {
                size2 = View.MeasureSpec.getSize(i3);
                size = this.f2543l;
            } else {
                size = View.MeasureSpec.getSize(i);
                size2 = this.f2543l;
            }
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        int size3 = View.MeasureSpec.getSize(i3);
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            int i10 = 0;
            if (getParent() != null && (getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) getParent();
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    if (childAt != this && (measuredHeight = childAt.getMeasuredHeight()) > i10) {
                        i10 = measuredHeight;
                    }
                }
            }
            size3 = i10;
        }
        setMeasuredDimension(this.f2543l, size3);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02cf  */
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
            Method dump skipped, instructions count: 1049
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.scrollbarview.StepOSScrollBarView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAdapter(a aVar) {
        this.f2542k = aVar;
        this.f2538f.i = aVar;
    }

    public void setFadeEnable(boolean z10) {
        this.f2546o = z10;
        a(true);
    }

    public void setFitSystemBottomPadding(boolean z10) {
        this.f2549r = z10;
        if (z10) {
            requestApplyInsets();
        }
    }

    public void setFitSystemTopPadding(boolean z10) {
        this.f2548q = z10;
        if (z10) {
            requestApplyInsets();
        }
    }

    public void setOperable(boolean z10) {
        this.f2547p = z10;
    }

    public void setScrollState(int i) {
        this.D = i;
    }

    public void setScrollableView(View view) {
        this.f2537c = view;
        if (view instanceof StepOSRecyclerView) {
            this.E = ((StepOSRecyclerView) view).getSpringAnimationHelper();
        }
        a(true);
    }

    public StepOSScrollBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.steposScrollBarViewStyle);
    }

    public StepOSScrollBarView(Context context) {
        this(context, null);
    }
}
