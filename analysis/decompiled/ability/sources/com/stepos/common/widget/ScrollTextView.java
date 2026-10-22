package com.stepos.common.widget;

import a5.AbstractC0301a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.mdisdk.capability.framework.FrameworkRegister;
import com.stepos.ability.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import w0.C2086g;

/* loaded from: classes3.dex */
public class ScrollTextView extends View {

    /* renamed from: S, reason: collision with root package name */
    public static final /* synthetic */ int f3740S = 0;

    /* renamed from: A, reason: collision with root package name */
    public ArrayList f3741A;

    /* renamed from: B, reason: collision with root package name */
    public ArrayList f3742B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f3743C;

    /* renamed from: D, reason: collision with root package name */
    public final L f3744D;
    public float E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f3745F;

    /* renamed from: G, reason: collision with root package name */
    public SpringAnimation f3746G;

    /* renamed from: L, reason: collision with root package name */
    public final float f3747L;

    /* renamed from: M, reason: collision with root package name */
    public final float f3748M;

    /* renamed from: N, reason: collision with root package name */
    public final B f3749N;

    /* renamed from: O, reason: collision with root package name */
    public final LinkedList f3750O;

    /* renamed from: P, reason: collision with root package name */
    public final LinkedList f3751P;

    /* renamed from: Q, reason: collision with root package name */
    public final LinkedList f3752Q;

    /* renamed from: R, reason: collision with root package name */
    public final Context f3753R;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f3754a;
    public int b;
    public int c;
    public float d;
    public float e;
    public int f;
    public int g;
    public float h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public final J f3755j;
    public boolean k;
    public int l;
    public int m;
    public M n;
    public boolean o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public F f3756q;

    /* renamed from: r, reason: collision with root package name */
    public C f3757r;

    /* renamed from: s, reason: collision with root package name */
    public Shader f3758s;

    /* renamed from: t, reason: collision with root package name */
    public final Matrix f3759t;
    public Paint u;

    /* renamed from: v, reason: collision with root package name */
    public float f3760v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f3761w;

    /* renamed from: x, reason: collision with root package name */
    public float f3762x;
    public float y;

    /* renamed from: z, reason: collision with root package name */
    public float f3763z;

    public ScrollTextView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        Paint paint = new Paint(1);
        this.f3754a = paint;
        this.b = 0;
        this.c = 5;
        this.d = 0.0f;
        this.e = 0.0f;
        this.o = false;
        this.f3761w = true;
        this.f3743C = true;
        this.E = 0.0f;
        this.f3745F = true;
        this.f3747L = 30.0f;
        this.f3748M = 0.98f;
        this.f3749N = new B(this, 0);
        LinkedList linkedList = new LinkedList();
        this.f3750O = linkedList;
        this.f3751P = new LinkedList();
        this.f3752Q = new LinkedList();
        C2086g c2086g = new C2086g(this);
        this.f3753R = context;
        this.f3741A = new ArrayList();
        this.f3755j = new J(this, getContext(), c2086g);
        this.i = context.getResources().getDimension(R.dimen.mc_picker_selected_number_size);
        this.h = context.getResources().getDimension(R.dimen.mc_picker_normal_number_size);
        this.d = context.getResources().getDimension(R.dimen.mc_picker_select_item_height);
        float dimension = context.getResources().getDimension(R.dimen.mc_picker_normal_item_height);
        this.e = dimension;
        l(this.i, this.h, this.d, dimension);
        this.f = context.getResources().getColor(R.color.fd_sys_color_on_surface_default);
        int color = context.getResources().getColor(R.color.fd_sys_color_on_surface_variant_default);
        this.g = color;
        j(this.f, color);
        this.f3756q = new F(this);
        this.f3759t = new Matrix();
        this.f3758s = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, context.getResources().getColor(R.color.fd_sys_color_surface_container_lowest_default), ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP);
        Paint paint2 = new Paint();
        this.u = paint2;
        paint2.setShader(this.f3758s);
        this.f3760v = context.getResources().getDimension(R.dimen.mc_picker_fading_height);
        M m = new M();
        m.f3724a = 0;
        m.b = 0;
        this.n = m;
        paint.setTextAlign(Paint.Align.CENTER);
        e();
        L l = new L();
        l.f3720a = null;
        l.b = null;
        this.f3744D = l;
        linkedList.add(new E(this, 0));
        linkedList.add(new E(this, 1));
        paint.setAntiAlias(true);
    }

    public static void c(ScrollTextView scrollTextView, int i) {
        if (!scrollTextView.o) {
            if (scrollTextView.b == scrollTextView.getScrollStartItem()) {
                int i6 = scrollTextView.l;
                if (i6 + i > 0) {
                    i = -i6;
                }
                if (i == 0) {
                    return;
                }
            } else if (scrollTextView.b == scrollTextView.getScrollEndItem()) {
                int i10 = scrollTextView.l;
                if (i10 + i < 0) {
                    i = -i10;
                }
                if (i == 0) {
                    return;
                }
            }
        }
        int i11 = scrollTextView.f3756q.b;
        if (i11 == 1) {
            scrollTextView.l = 0;
        } else {
            scrollTextView.l += i;
        }
        int itemHeight = scrollTextView.getItemHeight();
        int scrollEndItem = scrollTextView.l / itemHeight;
        int scrollEndItem2 = scrollTextView.b - scrollEndItem;
        if (scrollTextView.o && i11 > 0) {
            while (scrollEndItem2 < 0) {
                scrollEndItem2 += i11;
            }
            scrollEndItem2 %= i11;
        } else if (scrollEndItem2 < scrollTextView.getScrollStartItem()) {
            scrollEndItem = scrollTextView.b - scrollTextView.getScrollStartItem();
            scrollEndItem2 = scrollTextView.getScrollStartItem();
        } else if (scrollEndItem2 > scrollTextView.getScrollEndItem()) {
            scrollEndItem = scrollTextView.b - scrollTextView.getScrollEndItem();
            scrollEndItem2 = scrollTextView.getScrollEndItem();
        } else if (scrollEndItem2 != scrollTextView.getScrollEndItem()) {
            scrollTextView.getScrollStartItem();
        }
        int i12 = scrollTextView.l;
        if (scrollEndItem2 != scrollTextView.b) {
            scrollTextView.h(scrollEndItem2, false);
        } else {
            scrollTextView.invalidate();
        }
        int i13 = i12 - (scrollEndItem * itemHeight);
        scrollTextView.l = i13;
        if (i13 <= scrollTextView.getHeight() || scrollTextView.getHeight() == 0) {
            return;
        }
        scrollTextView.l = scrollTextView.getHeight() + (scrollTextView.l % scrollTextView.getHeight());
    }

    private M getItemsRange() {
        if (getItemHeight() == 0) {
            return null;
        }
        int i = this.b;
        int iAsin = 1;
        while (true) {
            int i6 = iAsin + 2;
            if (getItemHeight() * i6 >= getHeight()) {
                break;
            }
            i--;
            iAsin = i6;
        }
        int i10 = this.l;
        if (i10 != 0) {
            if (i10 > 0) {
                i--;
            }
            int itemHeight = i10 / getItemHeight();
            i -= itemHeight;
            iAsin = (int) (Math.asin(itemHeight) + iAsin + 1);
        }
        M m = this.n;
        m.f3724a = i;
        m.b = iAsin;
        return m;
    }

    private int getScrollEndItem() {
        int i = this.f3756q.b;
        if (this.o) {
            return 0;
        }
        return i <= this.c ? i - 1 : i - 1;
    }

    private int getScrollStartItem() {
        int i = this.f3756q.b;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYScrollEnd() {
        if (this.o) {
            return Integer.MAX_VALUE;
        }
        return this.l + ((int) ((getScrollEndItem() - getCurrentItem()) * this.e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYScrollStart() {
        return this.o ? FrameworkRegister.TYPE_ACTIVITY_MOVE_TO_FOREGROUND : this.l + ((int) ((getScrollStartItem() - getCurrentItem()) * this.e));
    }

    private void setViewAdapter(F f) {
        this.f3756q = f;
        invalidate();
    }

    public final void d(D d) {
        this.f3751P.add(d);
    }

    public final void e() {
        float f = this.i;
        Paint paint = this.f3754a;
        paint.setTextSize(f);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        this.f3762x = (fontMetricsInt.bottom + fontMetricsInt.top) / 2.0f;
        paint.setTextSize(this.h);
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        this.y = (fontMetricsInt2.bottom + fontMetricsInt2.top) / 2.0f;
    }

    public final void f(int i) {
        g(i, this.b, i - 1);
    }

    public final void g(int i, int i6, int i10) {
        C c;
        J j5 = this.f3755j;
        if (j5 != null) {
            j5.d.forceFinished(true);
        }
        if (i < 0) {
            return;
        }
        F f = this.f3756q;
        f.f3709a = i10;
        f.b = i;
        setViewAdapter(f);
        int i11 = this.b;
        if (i6 != i11) {
            int iMax = Math.max(i6, 0);
            this.b = iMax;
            if (iMax > i10 || iMax >= i) {
                this.b = Math.min(i10, i);
            }
        }
        int i12 = this.b;
        if (i11 != i12 && (c = this.f3757r) != null) {
            c.b(i12);
        }
        invalidate();
    }

    public int getCurrentItem() {
        return this.b;
    }

    public C getIDataAdapter() {
        return this.f3757r;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getItemHeight() {
        return (int) this.e;
    }

    public int getItemsCount() {
        return this.f3756q.b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getSelectedItemHeight() {
        return (int) this.d;
    }

    public F getViewAdapter() {
        return this.f3756q;
    }

    public int getVisibleItems() {
        return this.c;
    }

    public final void h(int i, boolean z10) {
        int i6;
        Handler handler;
        int iMin;
        F f = this.f3756q;
        if (f == null || (i6 = f.b) == 0) {
            return;
        }
        if (i < 0 || i >= i6) {
            if (!this.o) {
                return;
            }
            while (i < 0) {
                i += i6;
            }
            i %= i6;
        }
        int i10 = this.b;
        if (i != i10) {
            if (z10) {
                int i11 = i - i10;
                if (this.o && (iMin = (Math.min(i, i10) + i6) - Math.max(i, this.b)) < Math.abs(i11)) {
                    i11 = i11 < 0 ? iMin : -iMin;
                }
                this.f3755j.c((getItemHeight() * i11) + this.l, 0);
                return;
            }
            this.l = 0;
            this.b = i;
            for (E e : this.f3750O) {
                switch (e.f3706a) {
                    case 0:
                        L l = e.b.f3744D;
                        if (l != null && (handler = l.f3720a) != null) {
                            handler.post(new K(l, 1));
                            break;
                        } else {
                            break;
                        }
                        break;
                    default:
                        ScrollTextView scrollTextView = e.b;
                        if (AbstractC0301a.b()) {
                            scrollTextView.performHapticFeedback(21000);
                            break;
                        } else {
                            scrollTextView.performHapticFeedback(6);
                            break;
                        }
                }
            }
            invalidate();
        }
    }

    public final void i(C c, int i, int i6, int i10, int i11, boolean z10) {
        setIDataAdapter(c);
        this.c = i10;
        this.o = z10;
        getResources().getDimensionPixelSize(R.dimen.mc_picker_offset_y);
        if (i6 < this.c || i11 + 1 < i6) {
            this.o = false;
        }
        g(i6, i, i11);
    }

    public final void j(int i, int i6) {
        this.f = i;
        this.g = i6;
        this.f3742B = new ArrayList();
        int i10 = this.c - 1;
        for (int i11 = 0; i11 < i10 / 2; i11++) {
            this.f3742B.add(Integer.valueOf(this.g));
        }
        invalidate();
    }

    public final void k(int i, List list) {
        this.f = i;
        if (list != null && this.f3742B != list) {
            this.g = ((Integer) list.get(0)).intValue();
            this.f3742B = new ArrayList();
            int i6 = this.c - 1;
            for (int i10 = 0; i10 < i6 / 2; i10++) {
                int size = list.size();
                if (i10 < size) {
                    this.f3742B.add((Integer) list.get(i10));
                } else {
                    this.f3742B.add((Integer) list.get(size - 1));
                }
            }
        }
        invalidate();
    }

    public final void l(float f, float f7, float f9, float f10) {
        this.d = f9;
        this.e = f10;
        this.i = f;
        this.h = f7;
        this.f3741A = new ArrayList();
        int i = this.c - 1;
        for (int i6 = 0; i6 < i / 2; i6++) {
            this.f3741A.add(Float.valueOf(this.h));
        }
        e();
        invalidate();
    }

    public final void m(float f, List list, float f7, float f9) {
        if (this.d == f7 && this.e == f9 && this.i == f && list == null) {
            return;
        }
        this.d = f7;
        this.i = f;
        this.e = f9;
        if (list != null && this.f3741A != list) {
            this.h = ((Float) list.get(0)).floatValue();
            this.f3741A = new ArrayList();
            int i = this.c - 1;
            for (int i6 = 0; i6 < i / 2; i6++) {
                int size = list.size();
                if (i6 < size) {
                    this.f3741A.add((Float) list.get(i6));
                } else {
                    this.f3741A.add((Float) list.get(size - 1));
                }
            }
        }
        e();
        invalidate();
    }

    public final void n(float f, ArrayList arrayList) {
        if (f == this.i && arrayList == null) {
            return;
        }
        m(f, arrayList, this.d, this.e);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        L l = this.f3744D;
        if (l != null && !l.d) {
            l.f = this.f3753R.getApplicationContext();
            l.d = false;
            l.g = false;
            new Thread(new K(l, 0)).start();
        }
        post(new B(this, 1));
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        L l = this.f3744D;
        if (l != null) {
            synchronized (l) {
                try {
                    l.g = true;
                    Handler handler = l.f3720a;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        if (l.d) {
                            l.c.unload(l.e);
                        }
                        l.c.release();
                        l.b.quit();
                        l.d = false;
                        l.f = null;
                        l.f3720a = null;
                    }
                } finally {
                }
            }
        }
        J j5 = this.f3755j;
        if (j5 != null) {
            A6.c cVar = j5.h;
            cVar.removeMessages(0);
            cVar.removeMessages(1);
            cVar.removeMessages(2);
        }
        removeCallbacks(this.f3749N);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x028e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r26) {
        /*
            Method dump skipped, instructions count: 774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.ScrollTextView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ScrollTextView.class.getName());
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        if (View.MeasureSpec.getMode(i6) == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidthAndState(), (int) (((this.c - 1) * this.e) + this.d));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (isEnabled() && getViewAdapter() != null) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2 && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(this.f3743C);
                }
            } else if (!this.k) {
                int y = ((int) motionEvent.getY()) - (getHeight() / 2);
                int itemHeight = (y < 0 ? (int) (((this.d / 2.0f) - getItemHeight()) + y) : (int) (y - ((this.d / 2.0f) - getItemHeight()))) / getItemHeight();
                if (itemHeight != 0) {
                    int i6 = this.b + itemHeight;
                    F f = this.f3756q;
                    if (f != null && (i = f.b) > 0 && (this.o || (i6 >= 0 && i6 < i))) {
                        h(i6, true);
                        Iterator it = this.f3752Q.iterator();
                        if (it.hasNext()) {
                            throw B7.a.f(it);
                        }
                    }
                }
            }
            J j5 = this.f3755j;
            j5.getClass();
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                j5.f = motionEvent.getY();
                j5.d.forceFinished(true);
                ScrollTextView scrollTextView = j5.i;
                SpringAnimation springAnimation = scrollTextView.f3746G;
                if (springAnimation != null && springAnimation.isRunning()) {
                    scrollTextView.f3746G.cancel();
                }
                A6.c cVar = j5.h;
                cVar.removeMessages(0);
                cVar.removeMessages(1);
                cVar.removeMessages(2);
                j5.a();
            } else if (action2 == 2) {
                int y9 = (int) (motionEvent.getY() - j5.f);
                if (y9 != 0) {
                    j5.d();
                    j5.f3718a.d(y9);
                    j5.f = motionEvent.getY();
                }
            } else if (action2 == 3) {
                j5.b();
            }
            if (!j5.c.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                j5.b();
            }
        }
        return true;
    }

    public void setCurrentItem(int i) {
        h(i, false);
    }

    public void setCyclic(boolean z10) {
        this.o = z10;
        invalidate();
    }

    public void setFadingHeight(float f) {
        if (this.f3760v != f) {
            this.f3760v = f;
            invalidate();
        }
    }

    public void setFadingShader(Shader shader) {
        this.f3758s = shader;
        this.u.setShader(shader);
        invalidate();
    }

    public void setFadingShaderColor(@ColorInt int i) {
        this.f3758s = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, i, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.u = paint;
        paint.setShader(this.f3758s);
    }

    public void setHorizontalOffset(int i) {
        this.m = i;
    }

    public void setIDataAdapter(C c) {
        this.f3757r = c;
    }

    public void setInterpolator(Interpolator interpolator) {
        J j5 = this.f3755j;
        j5.d.forceFinished(true);
        j5.d = new Scroller(j5.b, interpolator);
    }

    public void setIsDrawFading(boolean z10) {
        this.f3761w = z10;
    }

    public void setNormalItemHeight(float f) {
        l(this.i, this.h, this.d, f);
    }

    public void setNormalTextColor(@ColorInt int i) {
        if (this.g == i) {
            return;
        }
        j(this.f, i);
    }

    public void setNormalTextSize(float f) {
        l(this.i, f, this.d, this.e);
    }

    public void setParentRequestDisallowInterceptTouchEvent(boolean z10) {
        this.f3743C = z10;
    }

    @Override // android.view.View
    public void setScrollY(int i) {
        J j5 = this.f3755j;
        int i6 = j5.e - i;
        j5.e = i;
        j5.f3718a.d(i6);
    }

    public void setSelectItemHeight(float f) {
        l(this.i, this.h, f, this.e);
    }

    public void setSelectTextColor(@ColorInt int i) {
        if (this.f == i) {
            return;
        }
        k(i, this.f3742B);
    }

    public void setSelectTextSize(float f) {
        l(f, this.h, this.d, this.e);
    }

    public void setShowMarquee(boolean z10) {
        this.f3745F = z10;
    }

    public void setTypeface(Typeface typeface) {
        this.f3754a.setTypeface(typeface);
        e();
        invalidate();
    }

    public void setVisibleItems(int i) {
        this.c = i;
    }

    public void setNormalTextSize(List<Float> list) {
        if (list != null) {
            m(this.i, list, this.d, this.e);
        }
    }

    public void setNormalTextColor(List<Integer> list) {
        k(this.f, list);
    }
}
