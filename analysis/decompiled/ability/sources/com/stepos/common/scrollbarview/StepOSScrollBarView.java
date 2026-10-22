package com.stepos.common.scrollbarview;

import V4.s;
import Xa.e;
import Z4.a;
import Z4.b;
import Z4.d;
import a5.l;
import a5.m;
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
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.stepos.ability.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes3.dex */
public class StepOSScrollBarView extends View {

    /* renamed from: C, reason: collision with root package name */
    public static final Interpolator f3601C = PathInterpolatorCompat.create(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: D, reason: collision with root package name */
    public static final Method f3602D;
    public static final Method E;

    /* renamed from: F, reason: collision with root package name */
    public static final Method f3603F;

    /* renamed from: G, reason: collision with root package name */
    public static final Method f3604G;

    /* renamed from: L, reason: collision with root package name */
    public static final Method f3605L;

    /* renamed from: M, reason: collision with root package name */
    public static final Method f3606M;

    /* renamed from: N, reason: collision with root package name */
    public static boolean f3607N;

    /* renamed from: A, reason: collision with root package name */
    public e f3608A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f3609B;

    /* renamed from: a, reason: collision with root package name */
    public View f3610a;
    public final b b;
    public final Drawable c;
    public final Drawable d;
    public final int e;
    public final int f;
    public a g;
    public final int h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3611j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final Z4.e o;
    public final d p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3612q;

    /* renamed from: r, reason: collision with root package name */
    public Handler f3613r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f3614s;

    /* renamed from: t, reason: collision with root package name */
    public float f3615t;
    public float u;

    /* renamed from: v, reason: collision with root package name */
    public int f3616v;

    /* renamed from: w, reason: collision with root package name */
    public final int f3617w;

    /* renamed from: x, reason: collision with root package name */
    public final int f3618x;
    public VelocityTracker y;

    /* renamed from: z, reason: collision with root package name */
    public int f3619z;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollExtent", null);
            f3602D = declaredMethod;
            Method declaredMethod2 = View.class.getDeclaredMethod("computeVerticalScrollRange", null);
            f3603F = declaredMethod2;
            Method declaredMethod3 = View.class.getDeclaredMethod("computeVerticalScrollOffset", null);
            E = declaredMethod3;
            Method declaredMethod4 = View.class.getDeclaredMethod("computeHorizontalScrollRange", null);
            f3606M = declaredMethod4;
            Method declaredMethod5 = View.class.getDeclaredMethod("computeHorizontalScrollExtent", null);
            f3604G = declaredMethod5;
            Method declaredMethod6 = View.class.getDeclaredMethod("computeHorizontalScrollOffset", null);
            f3605L = declaredMethod6;
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
        f3607N = false;
    }

    @RequiresApi(api = 23)
    public StepOSScrollBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposScrollBarViewStyle);
        this.k = true;
        this.l = true;
        this.f3614s = true;
        this.f3619z = 0;
        setForceDarkAllowed(false);
        this.g = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f1373q, R.attr.steposScrollBarViewStyle, 0);
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, (int) l.c(2.0f, context));
        this.f3611j = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, (int) l.c(6.0f, context));
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, (int) l.c(30.0f, context));
        this.k = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.l = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.m = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.n = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.f3614s = typedArrayObtainStyledAttributes.getInt(5, 1) == 1;
        this.d = typedArrayObtainStyledAttributes.getDrawable(8);
        this.c = typedArrayObtainStyledAttributes.getDrawable(10);
        this.f = typedArrayObtainStyledAttributes.getColor(9, context.getResources().getColor(R.color.stepos_scrollbar_thumb_drawable_color));
        this.e = typedArrayObtainStyledAttributes.getColor(11, context.getResources().getColor(R.color.stepos_scrollbar_track_drawable_color));
        if (this.b == null) {
            this.b = new b(this.f3614s, this.g);
        }
        b bVar = this.b;
        Drawable drawable = this.d;
        if (bVar.k) {
            Drawable drawable2 = bVar.b;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            bVar.b(drawable);
            bVar.b = drawable;
        } else {
            Drawable drawable3 = bVar.d;
            if (drawable3 != null) {
                drawable3.setCallback(null);
            }
            bVar.b(drawable);
            bVar.d = drawable;
        }
        b bVar2 = this.b;
        Drawable drawable4 = this.c;
        if (bVar2.k) {
            Drawable drawable5 = bVar2.f1585a;
            if (drawable5 != null) {
                drawable5.setCallback(null);
            }
            bVar2.b(drawable4);
            bVar2.f1585a = drawable4;
        } else {
            Drawable drawable6 = bVar2.c;
            if (drawable6 != null) {
                drawable6.setCallback(null);
            }
            bVar2.b(drawable4);
            bVar2.c = drawable4;
        }
        this.b.getClass();
        this.d.mutate().setTint(this.f);
        this.c.mutate().setTint(this.e);
        typedArrayObtainStyledAttributes.recycle();
        f3607N = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.o = new Z4.e(this);
        this.p = new d(this, this.i, this.f3611j, this.b);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3617w = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3618x = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @RequiresApi(api = 19)
    private int getScrollableViewScrollExtent() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f3614s ? f3602D : f3604G;
        View view = this.f3610a;
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

    @RequiresApi(api = 19)
    private int getScrollableViewScrollOffset() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f3614s ? E : f3605L;
        View view = this.f3610a;
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

    @RequiresApi(api = 19)
    private int getScrollableViewScrollRange() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f3614s ? f3603F : f3606M;
        View view = this.f3610a;
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
        if (this.f3613r == null) {
            this.f3613r = new Handler();
        }
        boolean z11 = this.k;
        Z4.e eVar = this.o;
        if (z11) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + 2000;
            eVar.d = jCurrentAnimationTimeMillis;
            eVar.c = 1;
            this.f3613r.removeCallbacks(eVar);
            this.f3613r.postAtTime(eVar, jCurrentAnimationTimeMillis);
        } else {
            eVar.c = 1;
        }
        if (z10) {
            invalidate();
        }
    }

    public final void b() {
        d dVar = this.p;
        if (dVar.f1590a != 0 || this.f3612q) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        dVar.b = jCurrentAnimationTimeMillis;
        dVar.f1590a = 0;
        this.f3613r.postAtTime(dVar, jCurrentAnimationTimeMillis);
        this.f3612q = true;
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        if (this.m && insets.top != getPaddingTop()) {
            setPadding(getPaddingLeft(), insets.top, getPaddingRight(), getPaddingBottom());
        }
        if (this.n && insets.bottom != getPaddingBottom()) {
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
        Handler handler = this.f3613r;
        if (handler != null) {
            handler.removeCallbacks(this.o);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Z4.e eVar;
        int i;
        boolean z10;
        super.onDraw(canvas);
        if (getVisibility() == 0 && (i = (eVar = this.o).c) != 0) {
            if (i == 2) {
                if (eVar.b == null) {
                    eVar.b = new float[1];
                }
                float[] fArr = eVar.b;
                if (eVar.f1591a.timeToValues(fArr) == Interpolator.Result.FREEZE_END) {
                    eVar.c = 0;
                } else {
                    b bVar = this.b;
                    bVar.a();
                    bVar.setAlpha(Math.round(fArr[0]));
                }
                z10 = true;
            } else {
                b bVar2 = this.b;
                bVar2.a();
                bVar2.setAlpha(255);
                z10 = false;
            }
            d dVar = this.p;
            if (dVar.f1590a == 1) {
                this.f3612q = false;
                a(false);
                Object animatedValue = dVar.c.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    int iIntValue = ((Integer) animatedValue).intValue();
                    b bVar3 = this.b;
                    Rect bounds = bVar3.getBounds();
                    if (bVar3.k) {
                        int i6 = bounds.right;
                        bVar3.setBounds(i6 - iIntValue, bounds.top, i6, bounds.bottom);
                    } else {
                        int i10 = bounds.left;
                        int i11 = bounds.bottom;
                        bVar3.setBounds(i10, i11 - iIntValue, bounds.right, i11);
                    }
                    if (!dVar.c.isRunning()) {
                        boolean z11 = dVar.g;
                        dVar.f1590a = z11 ? 0 : 2;
                        if (!z11) {
                            View view = this.f3610a;
                            if (m.a()) {
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
            int iAbs = this.f3614s ? Math.abs((int) this.f3610a.getTranslationY()) : (int) Math.abs(this.f3610a.getTranslationX());
            b bVar4 = this.b;
            if (bVar4.f != scrollableViewScrollRange || bVar4.g != scrollableViewScrollOffset || bVar4.h != scrollableViewScrollExtent || bVar4.f1586j != iAbs) {
                bVar4.f = scrollableViewScrollRange;
                bVar4.g = scrollableViewScrollOffset;
                bVar4.h = scrollableViewScrollExtent;
                bVar4.f1586j = iAbs;
                bVar4.m = true;
            }
            this.b.draw(canvas);
            if (eVar.c == 1) {
                int i12 = this.b.i;
            }
            if (z10) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        super.onLayout(z10, i, i6, i10, i11);
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i12 = this.f3619z == 1 ? this.f3611j : this.i;
        b bVar = this.b;
        if (bVar != null) {
            if (!this.f3614s) {
                int i13 = (measuredHeight - paddingBottom) - i12;
                bVar.setBounds(paddingStart, i13, measuredWidth - paddingEnd, i12 + i13);
            } else {
                if (!f3607N) {
                    paddingEnd = (measuredWidth - paddingEnd) - i12;
                }
                bVar.setBounds(paddingEnd, paddingTop, i12 + paddingEnd, measuredHeight - paddingBottom);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int size;
        int size2;
        int measuredHeight;
        super.onMeasure(i, i6);
        boolean z10 = this.f3614s;
        if (!z10) {
            if (z10) {
                size2 = View.MeasureSpec.getSize(i6);
                size = this.h;
            } else {
                size = View.MeasureSpec.getSize(i);
                size2 = this.h;
            }
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
            return;
        }
        int size3 = View.MeasureSpec.getSize(i6);
        if (View.MeasureSpec.getMode(i6) == Integer.MIN_VALUE) {
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
        setMeasuredDimension(this.h, size3);
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
            Method dump skipped, instructions count: 1057
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.scrollbarview.StepOSScrollBarView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAdapter(@NonNull a aVar) {
        this.g = aVar;
        this.b.e = aVar;
    }

    public void setFadeEnable(boolean z10) {
        this.k = z10;
        a(true);
    }

    @RequiresApi(api = 20)
    public void setFitSystemBottomPadding(boolean z10) {
        this.n = z10;
        if (z10) {
            requestApplyInsets();
        }
    }

    @RequiresApi(api = 20)
    public void setFitSystemTopPadding(boolean z10) {
        this.m = z10;
        if (z10) {
            requestApplyInsets();
        }
    }

    public void setOperable(boolean z10) {
        this.l = z10;
    }

    public void setScrollState(int i) {
        this.f3619z = i;
    }

    public void setScrollableView(@NonNull View view) {
        this.f3610a = view;
        if (view instanceof StepOSRecyclerView) {
            this.f3608A = ((StepOSRecyclerView) view).getSpringAnimationHelper();
        }
        a(true);
    }
}
