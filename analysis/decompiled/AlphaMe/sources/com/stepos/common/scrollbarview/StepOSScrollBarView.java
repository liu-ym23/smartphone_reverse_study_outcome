package com.stepos.common.scrollbarview;

import M.a;
import N3.d;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import i2.AbstractC0620a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import l2.C0762a;
import l2.C0763b;
import l2.e;
import m2.AbstractC0770a;
import m2.o;
import m2.p;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes.dex */
public class StepOSScrollBarView extends View {

    /* renamed from: C, reason: collision with root package name */
    public static final Interpolator f11395C = a.b(0.4f, Property.DEFAULT_FLOAT_VALUE, 0.2f, 1.0f);

    /* renamed from: D, reason: collision with root package name */
    public static final Method f11396D;

    /* renamed from: E, reason: collision with root package name */
    public static final Method f11397E;

    /* renamed from: F, reason: collision with root package name */
    public static final Method f11398F;

    /* renamed from: G, reason: collision with root package name */
    public static final Method f11399G;

    /* renamed from: H, reason: collision with root package name */
    public static final Method f11400H;

    /* renamed from: I, reason: collision with root package name */
    public static final Method f11401I;

    /* renamed from: J, reason: collision with root package name */
    public static boolean f11402J;

    /* renamed from: A, reason: collision with root package name */
    public d f11403A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f11404B;

    /* renamed from: a, reason: collision with root package name */
    public View f11405a;

    /* renamed from: b, reason: collision with root package name */
    public final C0763b f11406b;

    /* renamed from: c, reason: collision with root package name */
    public final Drawable f11407c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f11408d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11409e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11410f;

    /* renamed from: g, reason: collision with root package name */
    public C0762a f11411g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11412h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11413i;

    /* renamed from: j, reason: collision with root package name */
    public final int f11414j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f11415k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11416l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f11417m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11418n;

    /* renamed from: o, reason: collision with root package name */
    public final e f11419o;

    /* renamed from: p, reason: collision with root package name */
    public final l2.d f11420p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11421q;

    /* renamed from: r, reason: collision with root package name */
    public Handler f11422r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f11423s;

    /* renamed from: t, reason: collision with root package name */
    public float f11424t;

    /* renamed from: u, reason: collision with root package name */
    public float f11425u;

    /* renamed from: v, reason: collision with root package name */
    public int f11426v;

    /* renamed from: w, reason: collision with root package name */
    public final int f11427w;

    /* renamed from: x, reason: collision with root package name */
    public final int f11428x;

    /* renamed from: y, reason: collision with root package name */
    public VelocityTracker f11429y;

    /* renamed from: z, reason: collision with root package name */
    public int f11430z;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollExtent", new Class[0]);
            f11396D = declaredMethod;
            Method declaredMethod2 = View.class.getDeclaredMethod("computeVerticalScrollRange", new Class[0]);
            f11398F = declaredMethod2;
            Method declaredMethod3 = View.class.getDeclaredMethod("computeVerticalScrollOffset", new Class[0]);
            f11397E = declaredMethod3;
            Method declaredMethod4 = View.class.getDeclaredMethod("computeHorizontalScrollRange", new Class[0]);
            f11401I = declaredMethod4;
            Method declaredMethod5 = View.class.getDeclaredMethod("computeHorizontalScrollExtent", new Class[0]);
            f11399G = declaredMethod5;
            Method declaredMethod6 = View.class.getDeclaredMethod("computeHorizontalScrollOffset", new Class[0]);
            f11400H = declaredMethod6;
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
        f11402J = false;
    }

    @RequiresApi(api = 23)
    public StepOSScrollBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposScrollBarViewStyle);
        this.f11415k = true;
        this.f11416l = true;
        this.f11423s = true;
        this.f11430z = 0;
        AbstractC0770a.c(this);
        this.f11411g = new C0762a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13035q, R.attr.steposScrollBarViewStyle, 0);
        this.f11413i = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, (int) o.c(context, 2.0f));
        this.f11414j = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, (int) o.c(context, 6.0f));
        this.f11412h = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, (int) o.c(context, 30.0f));
        this.f11415k = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.f11416l = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.f11417m = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.f11418n = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.f11423s = typedArrayObtainStyledAttributes.getInt(5, 1) == 1;
        this.f11408d = typedArrayObtainStyledAttributes.getDrawable(8);
        this.f11407c = typedArrayObtainStyledAttributes.getDrawable(10);
        this.f11410f = typedArrayObtainStyledAttributes.getColor(9, context.getResources().getColor(R.color.stepos_scrollbar_thumb_drawable_color));
        this.f11409e = typedArrayObtainStyledAttributes.getColor(11, context.getResources().getColor(R.color.stepos_scrollbar_track_drawable_color));
        if (this.f11406b == null) {
            this.f11406b = new C0763b(this.f11423s, this.f11411g);
        }
        C0763b c0763b = this.f11406b;
        Drawable drawable = this.f11408d;
        if (c0763b.f13478k) {
            Drawable drawable2 = c0763b.f13469b;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            c0763b.b(drawable);
            c0763b.f13469b = drawable;
        } else {
            Drawable drawable3 = c0763b.f13471d;
            if (drawable3 != null) {
                drawable3.setCallback(null);
            }
            c0763b.b(drawable);
            c0763b.f13471d = drawable;
        }
        C0763b c0763b2 = this.f11406b;
        Drawable drawable4 = this.f11407c;
        if (c0763b2.f13478k) {
            Drawable drawable5 = c0763b2.f13468a;
            if (drawable5 != null) {
                drawable5.setCallback(null);
            }
            c0763b2.b(drawable4);
            c0763b2.f13468a = drawable4;
        } else {
            Drawable drawable6 = c0763b2.f13470c;
            if (drawable6 != null) {
                drawable6.setCallback(null);
            }
            c0763b2.b(drawable4);
            c0763b2.f13470c = drawable4;
        }
        this.f11406b.f13481n = false;
        this.f11408d.mutate().setTint(this.f11410f);
        this.f11407c.mutate().setTint(this.f11409e);
        typedArrayObtainStyledAttributes.recycle();
        f11402J = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.f11419o = new e(this);
        this.f11420p = new l2.d(this, this.f11413i, this.f11414j, this.f11406b);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f11427w = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f11428x = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @RequiresApi(api = 19)
    private int getScrollableViewScrollExtent() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f11423s ? f11396D : f11399G;
        View view = this.f11405a;
        if (view != null && method != null) {
            try {
                Object objInvoke = method.invoke(view, new Object[0]);
                if (objInvoke instanceof Integer) {
                    return ((Integer) objInvoke).intValue();
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
                Log.e("StepOSSScrollBarView", "invoke computeVerticalScrollExtent has an error!");
            }
        }
        return 0;
    }

    @RequiresApi(api = 19)
    private int getScrollableViewScrollOffset() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f11423s ? f11397E : f11400H;
        View view = this.f11405a;
        if (view != null && method != null) {
            try {
                Object objInvoke = method.invoke(view, new Object[0]);
                if (objInvoke instanceof Integer) {
                    return ((Integer) objInvoke).intValue();
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
                Log.e("StepOSSScrollBarView", "invoke computeVerticalScrollOffset has an error!");
            }
        }
        return 0;
    }

    @RequiresApi(api = 19)
    private int getScrollableViewScrollRange() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f11423s ? f11398F : f11401I;
        View view = this.f11405a;
        if (view != null && method != null) {
            try {
                Object objInvoke = method.invoke(view, new Object[0]);
                if (objInvoke instanceof Integer) {
                    return ((Integer) objInvoke).intValue();
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
                Log.e("StepOSSScrollBarView", "invoke computeVerticalScrollRange has an error!");
            }
        }
        return 0;
    }

    public final void a(boolean z4) {
        if (this.f11422r == null) {
            this.f11422r = new Handler();
        }
        boolean z5 = this.f11415k;
        e eVar = this.f11419o;
        if (z5) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + 2000;
            eVar.f13502d = jCurrentAnimationTimeMillis;
            eVar.f13501c = 1;
            this.f11422r.removeCallbacks(eVar);
            this.f11422r.postAtTime(eVar, jCurrentAnimationTimeMillis);
        } else {
            eVar.f13501c = 1;
        }
        if (z4) {
            invalidate();
        }
    }

    public final void b() {
        l2.d dVar = this.f11420p;
        if (dVar.f13489a != 0 || this.f11421q) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        dVar.f13490b = jCurrentAnimationTimeMillis;
        dVar.f13489a = 0;
        this.f11422r.postAtTime(dVar, jCurrentAnimationTimeMillis);
        this.f11421q = true;
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        if (this.f11417m && insets.top != getPaddingTop()) {
            setPadding(getPaddingLeft(), insets.top, getPaddingRight(), getPaddingBottom());
        }
        if (this.f11418n && insets.bottom != getPaddingBottom()) {
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
        Handler handler = this.f11422r;
        if (handler != null) {
            handler.removeCallbacks(this.f11419o);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        e eVar;
        int i4;
        boolean z4;
        super.onDraw(canvas);
        if (getVisibility() == 0 && (i4 = (eVar = this.f11419o).f13501c) != 0) {
            if (i4 == 2) {
                if (eVar.f13500b == null) {
                    eVar.f13500b = new float[1];
                }
                float[] fArr = eVar.f13500b;
                if (eVar.f13499a.timeToValues(fArr) == Interpolator.Result.FREEZE_END) {
                    eVar.f13501c = 0;
                } else {
                    C0763b c0763b = this.f11406b;
                    c0763b.a();
                    c0763b.setAlpha(Math.round(fArr[0]));
                }
                z4 = true;
            } else {
                C0763b c0763b2 = this.f11406b;
                c0763b2.a();
                c0763b2.setAlpha(255);
                z4 = false;
            }
            l2.d dVar = this.f11420p;
            if (dVar.f13489a == 1) {
                this.f11421q = false;
                a(false);
                Object animatedValue = dVar.f13491c.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    int iIntValue = ((Integer) animatedValue).intValue();
                    C0763b c0763b3 = this.f11406b;
                    Rect bounds = c0763b3.getBounds();
                    if (c0763b3.f13478k) {
                        int i5 = bounds.right;
                        c0763b3.setBounds(i5 - iIntValue, bounds.top, i5, bounds.bottom);
                    } else {
                        int i6 = bounds.left;
                        int i7 = bounds.bottom;
                        c0763b3.setBounds(i6, i7 - iIntValue, bounds.right, i7);
                    }
                    if (!dVar.f13491c.isRunning()) {
                        boolean z5 = dVar.f13495g;
                        dVar.f13489a = z5 ? 0 : 2;
                        if (!z5) {
                            View view = this.f11405a;
                            if (p.a()) {
                                view.performHapticFeedback(31020);
                            } else {
                                view.performHapticFeedback(0);
                            }
                        }
                    }
                    z4 = true;
                }
            }
            int scrollableViewScrollExtent = getScrollableViewScrollExtent();
            int scrollableViewScrollOffset = getScrollableViewScrollOffset();
            int scrollableViewScrollRange = getScrollableViewScrollRange();
            C0763b c0763b4 = this.f11406b;
            int iAbs = this.f11423s ? Math.abs((int) this.f11405a.getTranslationY()) : (int) Math.abs(this.f11405a.getTranslationX());
            if (c0763b4.f13473f != scrollableViewScrollRange || c0763b4.f13474g != scrollableViewScrollOffset || c0763b4.f13475h != scrollableViewScrollExtent || c0763b4.f13477j != iAbs) {
                c0763b4.f13473f = scrollableViewScrollRange;
                c0763b4.f13474g = scrollableViewScrollOffset;
                c0763b4.f13475h = scrollableViewScrollExtent;
                c0763b4.f13477j = iAbs;
                c0763b4.f13480m = true;
            }
            this.f11406b.draw(canvas);
            if (eVar.f13501c == 1) {
                int i8 = this.f11406b.f13476i;
            }
            if (z4) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i8 = this.f11430z == 1 ? this.f11414j : this.f11413i;
        C0763b c0763b = this.f11406b;
        if (c0763b != null) {
            if (!this.f11423s) {
                int i9 = (measuredHeight - paddingBottom) - i8;
                c0763b.setBounds(paddingStart, i9, measuredWidth - paddingEnd, i8 + i9);
            } else {
                if (!f11402J) {
                    paddingEnd = (measuredWidth - paddingEnd) - i8;
                }
                c0763b.setBounds(paddingEnd, paddingTop, i8 + paddingEnd, measuredHeight - paddingBottom);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int size;
        int size2;
        int measuredHeight;
        super.onMeasure(i4, i5);
        boolean z4 = this.f11423s;
        if (!z4) {
            if (z4) {
                size2 = View.MeasureSpec.getSize(i5);
                size = this.f11412h;
            } else {
                size = View.MeasureSpec.getSize(i4);
                size2 = this.f11412h;
            }
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        int i6 = this.f11412h;
        int size3 = View.MeasureSpec.getSize(i5);
        if (View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE) {
            size3 = 0;
            if (getParent() != null && (getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) getParent();
                int i7 = 0;
                while (size3 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(size3);
                    if (childAt != this && (measuredHeight = childAt.getMeasuredHeight()) > i7) {
                        i7 = measuredHeight;
                    }
                    size3++;
                }
                size3 = i7;
            }
        }
        setMeasuredDimension(i6, size3);
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
            Method dump skipped, instructions count: 1053
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.scrollbarview.StepOSScrollBarView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAdapter(@NonNull C0762a c0762a) {
        this.f11411g = c0762a;
        this.f11406b.f13472e = c0762a;
    }

    public void setFadeEnable(boolean z4) {
        this.f11415k = z4;
        a(true);
    }

    @RequiresApi(api = 20)
    public void setFitSystemBottomPadding(boolean z4) {
        this.f11418n = z4;
        if (z4) {
            requestApplyInsets();
        }
    }

    @RequiresApi(api = 20)
    public void setFitSystemTopPadding(boolean z4) {
        this.f11417m = z4;
        if (z4) {
            requestApplyInsets();
        }
    }

    public void setOperable(boolean z4) {
        this.f11416l = z4;
    }

    public void setScrollState(int i4) {
        this.f11430z = i4;
    }

    public void setScrollableView(@NonNull View view) {
        this.f11405a = view;
        if (view instanceof StepOSRecyclerView) {
            this.f11403A = ((StepOSRecyclerView) view).getSpringAnimationHelper();
        }
        a(true);
    }
}
