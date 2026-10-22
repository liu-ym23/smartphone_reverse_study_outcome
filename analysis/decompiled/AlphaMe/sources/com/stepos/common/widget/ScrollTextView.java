package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
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
import androidx.appcompat.app.C0186l;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import e.EnumC0546d;
import h.RunnableC0583a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m2.AbstractC0770a;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class ScrollTextView extends View {

    /* renamed from: A, reason: collision with root package name */
    public ArrayList f11734A;

    /* renamed from: B, reason: collision with root package name */
    public ArrayList f11735B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f11736C;

    /* renamed from: D, reason: collision with root package name */
    public final F f11737D;

    /* renamed from: E, reason: collision with root package name */
    public float f11738E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f11739F;

    /* renamed from: G, reason: collision with root package name */
    public W.m f11740G;

    /* renamed from: H, reason: collision with root package name */
    public final float f11741H;

    /* renamed from: I, reason: collision with root package name */
    public final float f11742I;

    /* renamed from: J, reason: collision with root package name */
    public final v f11743J;

    /* renamed from: K, reason: collision with root package name */
    public final LinkedList f11744K;

    /* renamed from: L, reason: collision with root package name */
    public final LinkedList f11745L;

    /* renamed from: M, reason: collision with root package name */
    public final LinkedList f11746M;

    /* renamed from: N, reason: collision with root package name */
    public final Context f11747N;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f11748a;

    /* renamed from: b, reason: collision with root package name */
    public int f11749b;

    /* renamed from: c, reason: collision with root package name */
    public int f11750c;

    /* renamed from: d, reason: collision with root package name */
    public float f11751d;

    /* renamed from: e, reason: collision with root package name */
    public float f11752e;

    /* renamed from: f, reason: collision with root package name */
    public int f11753f;

    /* renamed from: g, reason: collision with root package name */
    public int f11754g;

    /* renamed from: h, reason: collision with root package name */
    public float f11755h;

    /* renamed from: i, reason: collision with root package name */
    public float f11756i;

    /* renamed from: j, reason: collision with root package name */
    public final D f11757j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f11758k;

    /* renamed from: l, reason: collision with root package name */
    public int f11759l;

    /* renamed from: m, reason: collision with root package name */
    public int f11760m;

    /* renamed from: n, reason: collision with root package name */
    public G f11761n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f11762o;

    /* renamed from: p, reason: collision with root package name */
    public int f11763p;

    /* renamed from: q, reason: collision with root package name */
    public B f11764q;

    /* renamed from: r, reason: collision with root package name */
    public x f11765r;

    /* renamed from: s, reason: collision with root package name */
    public Shader f11766s;

    /* renamed from: t, reason: collision with root package name */
    public final Matrix f11767t;

    /* renamed from: u, reason: collision with root package name */
    public Paint f11768u;

    /* renamed from: v, reason: collision with root package name */
    public float f11769v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f11770w;

    /* renamed from: x, reason: collision with root package name */
    public float f11771x;

    /* renamed from: y, reason: collision with root package name */
    public float f11772y;

    /* renamed from: z, reason: collision with root package name */
    public float f11773z;

    public ScrollTextView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        Paint paint = new Paint(1);
        this.f11748a = paint;
        this.f11749b = 0;
        this.f11750c = 5;
        this.f11751d = Property.DEFAULT_FLOAT_VALUE;
        this.f11752e = Property.DEFAULT_FLOAT_VALUE;
        this.f11762o = false;
        this.f11770w = true;
        this.f11736C = true;
        this.f11738E = Property.DEFAULT_FLOAT_VALUE;
        this.f11739F = true;
        this.f11741H = 30.0f;
        this.f11742I = 0.98f;
        this.f11743J = new v(this, 0);
        LinkedList linkedList = new LinkedList();
        this.f11744K = linkedList;
        this.f11745L = new LinkedList();
        this.f11746M = new LinkedList();
        com.google.android.gms.common.api.internal.p pVar = new com.google.android.gms.common.api.internal.p(17, this);
        this.f11747N = context;
        this.f11734A = new ArrayList();
        this.f11757j = new D(this, getContext(), pVar);
        this.f11756i = context.getResources().getDimension(R.dimen.mc_picker_selected_number_size);
        this.f11755h = context.getResources().getDimension(R.dimen.mc_picker_normal_number_size);
        this.f11751d = context.getResources().getDimension(R.dimen.mc_picker_select_item_height);
        float dimension = context.getResources().getDimension(R.dimen.mc_picker_normal_item_height);
        this.f11752e = dimension;
        l(this.f11756i, this.f11755h, this.f11751d, dimension);
        this.f11753f = context.getResources().getColor(R.color.fd_sys_color_on_surface_default);
        int color = context.getResources().getColor(R.color.fd_sys_color_on_surface_variant_default);
        this.f11754g = color;
        j(this.f11753f, color);
        this.f11764q = new B(this);
        this.f11767t = new Matrix();
        this.f11766s = new LinearGradient(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 1.0f, context.getResources().getColor(R.color.fd_sys_color_surface_container_lowest_default), 16777215, Shader.TileMode.CLAMP);
        Paint paint2 = new Paint();
        this.f11768u = paint2;
        paint2.setShader(this.f11766s);
        this.f11769v = context.getResources().getDimension(R.dimen.mc_picker_fading_height);
        G g4 = new G();
        g4.f11627a = 0;
        g4.f11628b = 0;
        this.f11761n = g4;
        paint.setTextAlign(Paint.Align.CENTER);
        e();
        F f4 = new F();
        f4.f11620a = null;
        f4.f11621b = null;
        this.f11737D = f4;
        linkedList.add(new A(this, 0, 0));
        linkedList.add(new A(this, 1, 0));
        paint.setAntiAlias(true);
    }

    public static void c(ScrollTextView scrollTextView, int i4) {
        if (!scrollTextView.f11762o) {
            if (scrollTextView.f11749b == scrollTextView.getScrollStartItem()) {
                int i5 = scrollTextView.f11759l;
                if (i5 + i4 > 0) {
                    i4 = -i5;
                }
                if (i4 == 0) {
                    return;
                }
            } else if (scrollTextView.f11749b == scrollTextView.getScrollEndItem()) {
                int i6 = scrollTextView.f11759l;
                if (i6 + i4 < 0) {
                    i4 = -i6;
                }
                if (i4 == 0) {
                    return;
                }
            }
        }
        int i7 = scrollTextView.f11764q.f11445c;
        if (i7 == 1) {
            scrollTextView.f11759l = 0;
        } else {
            scrollTextView.f11759l += i4;
        }
        int itemHeight = scrollTextView.getItemHeight();
        int scrollEndItem = scrollTextView.f11759l / itemHeight;
        int scrollEndItem2 = scrollTextView.f11749b - scrollEndItem;
        if (scrollTextView.f11762o && i7 > 0) {
            while (scrollEndItem2 < 0) {
                scrollEndItem2 += i7;
            }
            scrollEndItem2 %= i7;
        } else if (scrollEndItem2 < scrollTextView.getScrollStartItem()) {
            scrollEndItem = scrollTextView.f11749b - scrollTextView.getScrollStartItem();
            scrollEndItem2 = scrollTextView.getScrollStartItem();
        } else if (scrollEndItem2 > scrollTextView.getScrollEndItem()) {
            scrollEndItem = scrollTextView.f11749b - scrollTextView.getScrollEndItem();
            scrollEndItem2 = scrollTextView.getScrollEndItem();
        } else if (scrollEndItem2 != scrollTextView.getScrollEndItem()) {
            scrollTextView.getScrollStartItem();
        }
        int i8 = scrollTextView.f11759l;
        if (scrollEndItem2 != scrollTextView.f11749b) {
            scrollTextView.h(scrollEndItem2, false);
        } else {
            scrollTextView.invalidate();
        }
        int i9 = i8 - (scrollEndItem * itemHeight);
        scrollTextView.f11759l = i9;
        if (i9 <= scrollTextView.getHeight() || scrollTextView.getHeight() == 0) {
            return;
        }
        scrollTextView.f11759l = scrollTextView.getHeight() + (scrollTextView.f11759l % scrollTextView.getHeight());
    }

    private G getItemsRange() {
        if (getItemHeight() == 0) {
            return null;
        }
        int i4 = this.f11749b;
        int iAsin = 1;
        while (true) {
            int i5 = iAsin + 2;
            if (getItemHeight() * i5 >= getHeight()) {
                break;
            }
            i4--;
            iAsin = i5;
        }
        int i6 = this.f11759l;
        if (i6 != 0) {
            if (i6 > 0) {
                i4--;
            }
            int itemHeight = i6 / getItemHeight();
            i4 -= itemHeight;
            iAsin = (int) (Math.asin(itemHeight) + iAsin + 1);
        }
        G g4 = this.f11761n;
        g4.f11627a = i4;
        g4.f11628b = iAsin;
        return g4;
    }

    private int getScrollEndItem() {
        int i4 = this.f11764q.f11445c;
        if (this.f11762o) {
            return 0;
        }
        int i5 = this.f11750c;
        return i4 - 1;
    }

    private int getScrollStartItem() {
        int i4 = this.f11764q.f11445c;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYScrollEnd() {
        if (this.f11762o) {
            return Integer.MAX_VALUE;
        }
        return ((int) ((getScrollEndItem() - getCurrentItem()) * this.f11752e)) + this.f11759l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYScrollStart() {
        if (this.f11762o) {
            return -2147483647;
        }
        return ((int) ((getScrollStartItem() - getCurrentItem()) * this.f11752e)) + this.f11759l;
    }

    private void setViewAdapter(B b4) {
        this.f11764q = b4;
        invalidate();
    }

    public final void d(z zVar) {
        this.f11745L.add(zVar);
    }

    public final void e() {
        float f4 = this.f11756i;
        Paint paint = this.f11748a;
        paint.setTextSize(f4);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        this.f11771x = (fontMetricsInt.bottom + fontMetricsInt.top) / 2.0f;
        paint.setTextSize(this.f11755h);
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        this.f11772y = (fontMetricsInt2.bottom + fontMetricsInt2.top) / 2.0f;
    }

    public final void f(int i4) {
        g(i4, this.f11749b, 0, i4 - 1);
    }

    public final void g(int i4, int i5, int i6, int i7) {
        x xVar;
        D d4 = this.f11757j;
        if (d4 != null) {
            d4.f11514d.forceFinished(true);
        }
        if (i4 < 0) {
            return;
        }
        B b4 = this.f11764q;
        b4.f11443a = i6;
        b4.f11444b = i7;
        b4.f11445c = i4;
        setViewAdapter(b4);
        int i8 = this.f11749b;
        if (i5 != i8) {
            int iMax = Math.max(i5, i6);
            this.f11749b = iMax;
            if (iMax > i7 || iMax >= i4) {
                this.f11749b = Math.min(i7, i4);
            }
        }
        int i9 = this.f11749b;
        if (i8 != i9 && (xVar = this.f11765r) != null) {
            ((C0186l) xVar).c(i9);
        }
        invalidate();
    }

    public int getCurrentItem() {
        return this.f11749b;
    }

    public x getIDataAdapter() {
        return this.f11765r;
    }

    @RestrictTo({EnumC0546d.f12493b})
    public int getItemHeight() {
        return (int) this.f11752e;
    }

    public int getItemsCount() {
        return this.f11764q.f11445c;
    }

    @RestrictTo({EnumC0546d.f12493b})
    public int getSelectedItemHeight() {
        return (int) this.f11751d;
    }

    public B getViewAdapter() {
        return this.f11764q;
    }

    public int getVisibleItems() {
        return this.f11750c;
    }

    public final void h(int i4, boolean z4) {
        int i5;
        Handler handler;
        int iMin;
        B b4 = this.f11764q;
        if (b4 == null || (i5 = b4.f11445c) == 0) {
            return;
        }
        if (i4 < 0 || i4 >= i5) {
            if (!this.f11762o) {
                return;
            }
            while (i4 < 0) {
                i4 += i5;
            }
            i4 %= i5;
        }
        int i6 = this.f11749b;
        if (i4 != i6) {
            if (z4) {
                int i7 = i4 - i6;
                if (this.f11762o && (iMin = (Math.min(i4, i6) + i5) - Math.max(i4, this.f11749b)) < Math.abs(i7)) {
                    i7 = i7 < 0 ? iMin : -iMin;
                }
                this.f11757j.c((getItemHeight() * i7) + this.f11759l, 0);
                return;
            }
            this.f11759l = 0;
            this.f11749b = i4;
            Iterator it = this.f11744K.iterator();
            while (it.hasNext()) {
                A a4 = (A) ((y) it.next());
                int i8 = a4.f11433a;
                ScrollTextView scrollTextView = a4.f11434b;
                switch (i8) {
                    case 0:
                        F f4 = scrollTextView.f11737D;
                        if (f4 != null && (handler = f4.f11620a) != null) {
                            handler.post(new RunnableC0583a(22, f4));
                            break;
                        } else {
                            break;
                        }
                        break;
                    default:
                        scrollTextView.getClass();
                        if (!AbstractC0770a.b()) {
                            scrollTextView.performHapticFeedback(6);
                            break;
                        } else {
                            scrollTextView.performHapticFeedback(21000);
                            break;
                        }
                }
            }
            invalidate();
        }
    }

    public final void i(C0186l c0186l, int i4, int i5, int i6, int i7, boolean z4) {
        setIDataAdapter(c0186l);
        this.f11750c = i6;
        this.f11762o = z4;
        getResources().getDimensionPixelSize(R.dimen.mc_picker_offset_y);
        if (i5 < this.f11750c || i7 + 1 < i5) {
            this.f11762o = false;
        }
        g(i5, i4, 0, i7);
    }

    public final void j(int i4, int i5) {
        this.f11753f = i4;
        this.f11754g = i5;
        this.f11735B = new ArrayList();
        int i6 = this.f11750c - 1;
        for (int i7 = 0; i7 < i6 / 2; i7++) {
            this.f11735B.add(Integer.valueOf(this.f11754g));
        }
        invalidate();
    }

    public final void k(int i4, List list) {
        this.f11753f = i4;
        if (list != null && this.f11735B != list) {
            this.f11754g = ((Integer) list.get(0)).intValue();
            this.f11735B = new ArrayList();
            int i5 = this.f11750c - 1;
            for (int i6 = 0; i6 < i5 / 2; i6++) {
                int size = list.size();
                if (i6 < size) {
                    this.f11735B.add((Integer) list.get(i6));
                } else {
                    this.f11735B.add((Integer) list.get(size - 1));
                }
            }
        }
        invalidate();
    }

    public final void l(float f4, float f5, float f6, float f7) {
        this.f11751d = f6;
        this.f11752e = f7;
        this.f11756i = f4;
        this.f11755h = f5;
        this.f11734A = new ArrayList();
        int i4 = this.f11750c - 1;
        for (int i5 = 0; i5 < i4 / 2; i5++) {
            this.f11734A.add(Float.valueOf(this.f11755h));
        }
        e();
        invalidate();
    }

    public final void m(float f4, List list, float f5, float f6) {
        if (this.f11751d == f5 && this.f11752e == f6 && this.f11756i == f4 && list == null) {
            return;
        }
        this.f11751d = f5;
        this.f11756i = f4;
        this.f11752e = f6;
        if (list != null && this.f11734A != list) {
            this.f11755h = ((Float) list.get(0)).floatValue();
            this.f11734A = new ArrayList();
            int i4 = this.f11750c - 1;
            for (int i5 = 0; i5 < i4 / 2; i5++) {
                int size = list.size();
                if (i5 < size) {
                    this.f11734A.add((Float) list.get(i5));
                } else {
                    this.f11734A.add((Float) list.get(size - 1));
                }
            }
        }
        e();
        invalidate();
    }

    public final void n(float f4, List list) {
        if (f4 == this.f11756i && list == null) {
            return;
        }
        m(f4, list, this.f11751d, this.f11752e);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        F f4 = this.f11737D;
        if (f4 != null) {
            Context context = this.f11747N;
            if (!f4.f11623d) {
                f4.f11625f = context.getApplicationContext();
                f4.f11623d = false;
                f4.f11626g = false;
                new Thread(new E(f4)).start();
            }
        }
        post(new v(this, 1));
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        F f4 = this.f11737D;
        if (f4 != null) {
            synchronized (f4) {
                try {
                    f4.f11626g = true;
                    Handler handler = f4.f11620a;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        if (f4.f11623d) {
                            f4.f11622c.unload(f4.f11624e);
                        }
                        f4.f11622c.release();
                        f4.f11621b.quit();
                        f4.f11623d = false;
                        f4.f11625f = null;
                        f4.f11620a = null;
                    }
                } finally {
                }
            }
        }
        D d4 = this.f11757j;
        if (d4 != null) {
            w wVar = d4.f11518h;
            wVar.removeMessages(0);
            wVar.removeMessages(1);
            wVar.removeMessages(2);
        }
        removeCallbacks(this.f11743J);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f4;
        float f5;
        float fFloatValue;
        float f6;
        float f7;
        int iIntValue;
        String strA;
        super.onDraw(canvas);
        B b4 = this.f11764q;
        float f8 = 1.0f;
        if (b4 != null && b4.f11445c > 0) {
            G itemsRange = getItemsRange();
            this.f11761n = itemsRange;
            int i4 = this.f11763p;
            int i5 = itemsRange.f11627a;
            if (i4 > i5 && i4 <= (itemsRange.f11628b + i5) - 1) {
                while (true) {
                    i4--;
                    if (i4 < this.f11761n.f11627a) {
                        break;
                    } else {
                        this.f11763p = i4;
                    }
                }
            } else {
                this.f11763p = i5;
            }
            int width = getWidth() / 2;
            Paint paint = this.f11748a;
            float fMeasureText = paint.measureText("AA");
            float itemHeight = ((-(((((int) this.f11751d) - getHeight()) / 2) + (getItemHeight() * (this.f11749b - this.f11763p)))) + this.f11759l) - getItemHeight();
            canvas.translate(this.f11760m, itemHeight);
            int itemHeight2 = this.f11759l;
            if (itemHeight2 <= 0) {
                itemHeight2 = getItemHeight() + this.f11759l;
            }
            float itemHeight3 = (itemHeight2 * 1.0f) / getItemHeight();
            int i6 = 0;
            while (i6 < this.f11761n.f11628b) {
                float itemHeight4 = getItemHeight();
                int i7 = (int) (this.f11751d - this.f11752e);
                int i8 = this.f11750c;
                int i9 = i8 / 2;
                if (i6 < i9) {
                    f4 = itemHeight3;
                } else if (i6 == i9) {
                    itemHeight4 += (i7 * itemHeight3) / 2.0f;
                    f4 = itemHeight3;
                } else {
                    if (i6 == i9 + 1) {
                        itemHeight4 += i7 / 2.0f;
                    } else if (i6 == i9 + 2) {
                        float f9 = i7;
                        float f10 = f8 - itemHeight3;
                        itemHeight4 += (f9 * f10) / 2.0f;
                        f4 = f10;
                    }
                    f4 = f8 - itemHeight3;
                }
                int iIntValue2 = this.f11753f;
                if (i6 < i9 || i6 > i9 + 1) {
                    this.f11773z = this.f11772y;
                } else {
                    float f11 = this.f11772y;
                    this.f11773z = AbstractC0831a.c(this.f11771x, f11, f4, f11);
                }
                int i10 = i6 > i9 ? i8 - i6 : i6;
                if (i10 > i9) {
                    i10 = i9;
                }
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 == 0) {
                    iIntValue2 = ((Integer) this.f11735B.get(i10)).intValue();
                    iIntValue = ((Integer) this.f11735B.get(i10)).intValue();
                    float fFloatValue2 = ((Float) this.f11734A.get(i10)).floatValue();
                    fFloatValue = ((Float) this.f11734A.get(i10)).floatValue();
                    f5 = fFloatValue2;
                    f7 = Property.DEFAULT_FLOAT_VALUE;
                    f6 = Property.DEFAULT_FLOAT_VALUE;
                } else if (i10 < i9) {
                    iIntValue2 = ((Integer) this.f11735B.get(i10)).intValue();
                    int i11 = i10 - 1;
                    int iIntValue3 = ((Integer) this.f11735B.get(i11)).intValue();
                    float fFloatValue3 = ((Float) this.f11734A.get(i10)).floatValue();
                    float fFloatValue4 = ((Float) this.f11734A.get(i11)).floatValue();
                    f6 = Property.DEFAULT_FLOAT_VALUE;
                    f7 = f4;
                    iIntValue = iIntValue3;
                    f5 = fFloatValue3;
                    fFloatValue = fFloatValue4;
                } else {
                    int i12 = i10 - 1;
                    int iIntValue4 = ((Integer) this.f11735B.get(i12)).intValue();
                    f5 = this.f11756i;
                    fFloatValue = ((Float) this.f11734A.get(i12)).floatValue();
                    f6 = 2.0f;
                    f7 = f4;
                    iIntValue = iIntValue4;
                }
                int iAlpha = Color.alpha(iIntValue2);
                int iRed = Color.red(iIntValue2);
                int iGreen = Color.green(iIntValue2);
                int iBlue = Color.blue(iIntValue2);
                int iAlpha2 = Color.alpha(iIntValue);
                int iRed2 = Color.red(iIntValue);
                int i13 = iAlpha2 + ((int) ((iAlpha - iAlpha2) * f7));
                float f12 = itemHeight3;
                int i14 = iRed2 + ((int) ((iRed - iRed2) * f7));
                float f13 = fMeasureText;
                paint.setColor(Color.argb(i13, i14, Color.green(iIntValue) + ((int) ((iGreen - r21) * f7)), Color.blue(iIntValue) + ((int) ((iBlue - r6) * f7))));
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setStrokeWidth(((f6 - Property.DEFAULT_FLOAT_VALUE) * f7) + Property.DEFAULT_FLOAT_VALUE);
                paint.setTextSize(((f5 - fFloatValue) * f7) + fFloatValue);
                canvas.translate(Property.DEFAULT_FLOAT_VALUE, itemHeight4);
                itemHeight += itemHeight4;
                int i15 = this.f11763p + i6;
                String strA2 = this.f11764q.a(i15);
                if (i15 < 0) {
                    B b5 = this.f11764q;
                    int i16 = b5.f11445c + i15;
                    if (this.f11762o) {
                        strA = b5.a(i16);
                        strA2 = strA;
                    }
                    strA2 = "";
                } else {
                    B b6 = this.f11764q;
                    int i17 = b6.f11445c;
                    if (i15 >= i17) {
                        int i18 = i15 - i17;
                        if (this.f11762o) {
                            strA = b6.a(i18);
                            strA2 = strA;
                        }
                        strA2 = "";
                    }
                }
                String str = strA2 != null ? strA2 : "";
                float f14 = (this.f11752e / 2.0f) - this.f11773z;
                if (this.f11758k || paint.getTextSize() != this.f11756i) {
                    canvas.drawText(str, width, f14, paint);
                } else {
                    float fMeasureText2 = paint.measureText(str);
                    boolean z4 = this.f11739F;
                    v vVar = this.f11743J;
                    if (!z4 || fMeasureText2 <= getWidth()) {
                        removeCallbacks(vVar);
                        canvas.drawText(str, width, f14, paint);
                    } else {
                        float f15 = this.f11738E - 1.0f;
                        this.f11738E = f15;
                        float f16 = width;
                        float width2 = f16 - ((fMeasureText2 - getWidth()) / 2.0f);
                        if (f15 >= width2 - getWidth()) {
                            canvas.drawText(str, this.f11738E, f14, paint);
                        }
                        float f17 = this.f11738E;
                        if (f17 <= width2 - f13 && f17 >= ((width2 - fMeasureText2) - getWidth()) - f13) {
                            canvas.drawText(str, this.f11738E + fMeasureText2 + f13, f14, paint);
                        }
                        float f18 = this.f11738E;
                        float f19 = f13 * 2.0f;
                        if (f18 <= (width2 - fMeasureText2) - f19) {
                            canvas.drawText(str, ((fMeasureText2 + f13) * 2.0f) + f18, f14, paint);
                        }
                        if (this.f11738E <= (-(((fMeasureText2 * 2.0f) - f16) + f19))) {
                            removeCallbacks(vVar);
                        }
                    }
                }
                i6++;
                itemHeight3 = f12;
                fMeasureText = f13;
                f8 = 1.0f;
            }
            canvas.translate(Property.DEFAULT_FLOAT_VALUE, -itemHeight);
        }
        if (this.f11770w) {
            this.f11767t.setScale(1.0f, this.f11769v);
            this.f11766s.setLocalMatrix(this.f11767t);
            canvas.drawRect(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, getWidth(), this.f11769v, this.f11768u);
            this.f11767t.setScale(1.0f, this.f11769v);
            this.f11767t.postRotate(180.0f);
            this.f11767t.postTranslate(Property.DEFAULT_FLOAT_VALUE, getHeight());
            this.f11766s.setLocalMatrix(this.f11767t);
            canvas.drawRect(Property.DEFAULT_FLOAT_VALUE, getHeight() - this.f11769v, getWidth(), getHeight(), this.f11768u);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ScrollTextView.class.getName());
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (View.MeasureSpec.getMode(i5) == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidthAndState(), (int) (((this.f11750c - 1) * this.f11752e) + this.f11751d));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i4;
        if (isEnabled() && getViewAdapter() != null) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2 && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(this.f11736C);
                }
            } else if (!this.f11758k) {
                int y4 = ((int) motionEvent.getY()) - (getHeight() / 2);
                int itemHeight = (y4 < 0 ? (int) (((this.f11751d / 2.0f) - getItemHeight()) + y4) : (int) (y4 - ((this.f11751d / 2.0f) - getItemHeight()))) / getItemHeight();
                if (itemHeight != 0) {
                    int i5 = this.f11749b + itemHeight;
                    B b4 = this.f11764q;
                    if (b4 != null && (i4 = b4.f11445c) > 0 && (this.f11762o || (i5 >= 0 && i5 < i4))) {
                        h(i5, true);
                        Iterator it = this.f11746M.iterator();
                        if (it.hasNext()) {
                            B0.g.y(it.next());
                            throw null;
                        }
                    }
                }
            }
            D d4 = this.f11757j;
            d4.getClass();
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                d4.f11516f = motionEvent.getY();
                d4.f11514d.forceFinished(true);
                W.m mVar = d4.f11519i.f11740G;
                if (mVar != null && mVar.f1967f) {
                    mVar.c();
                }
                w wVar = d4.f11518h;
                wVar.removeMessages(0);
                wVar.removeMessages(1);
                wVar.removeMessages(2);
                d4.a();
            } else if (action2 == 2) {
                int y5 = (int) (motionEvent.getY() - d4.f11516f);
                if (y5 != 0) {
                    d4.d();
                    d4.f11511a.o(y5);
                    d4.f11516f = motionEvent.getY();
                }
            } else if (action2 == 3) {
                d4.b();
            }
            if (!d4.f11513c.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                d4.b();
            }
        }
        return true;
    }

    public void setCurrentItem(int i4) {
        h(i4, false);
    }

    public void setCyclic(boolean z4) {
        this.f11762o = z4;
        invalidate();
    }

    public void setFadingHeight(float f4) {
        if (this.f11769v != f4) {
            this.f11769v = f4;
            invalidate();
        }
    }

    public void setFadingShader(Shader shader) {
        this.f11766s = shader;
        this.f11768u.setShader(shader);
        invalidate();
    }

    public void setFadingShaderColor(@ColorInt int i4) {
        this.f11766s = new LinearGradient(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 1.0f, i4, 16777215, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.f11768u = paint;
        paint.setShader(this.f11766s);
    }

    public void setHorizontalOffset(int i4) {
        this.f11760m = i4;
    }

    public void setIDataAdapter(x xVar) {
        this.f11765r = xVar;
    }

    public void setInterpolator(Interpolator interpolator) {
        D d4 = this.f11757j;
        d4.f11514d.forceFinished(true);
        d4.f11514d = new Scroller(d4.f11512b, interpolator);
    }

    public void setIsDrawFading(boolean z4) {
        this.f11770w = z4;
    }

    public void setNormalItemHeight(float f4) {
        l(this.f11756i, this.f11755h, this.f11751d, f4);
    }

    public void setNormalTextColor(@ColorInt int i4) {
        if (this.f11754g == i4) {
            return;
        }
        j(this.f11753f, i4);
    }

    public void setNormalTextSize(float f4) {
        l(this.f11756i, f4, this.f11751d, this.f11752e);
    }

    public void setParentRequestDisallowInterceptTouchEvent(boolean z4) {
        this.f11736C = z4;
    }

    @Override // android.view.View
    public void setScrollY(int i4) {
        D d4 = this.f11757j;
        int i5 = d4.f11515e - i4;
        d4.f11515e = i4;
        d4.f11511a.o(i5);
    }

    public void setSelectItemHeight(float f4) {
        l(this.f11756i, this.f11755h, f4, this.f11752e);
    }

    public void setSelectTextColor(@ColorInt int i4) {
        if (this.f11753f == i4) {
            return;
        }
        k(i4, this.f11735B);
    }

    public void setSelectTextSize(float f4) {
        l(f4, this.f11755h, this.f11751d, this.f11752e);
    }

    public void setShowMarquee(boolean z4) {
        this.f11739F = z4;
    }

    public void setTypeface(Typeface typeface) {
        this.f11748a.setTypeface(typeface);
        e();
        invalidate();
    }

    public void setVisibleItems(int i4) {
        this.f11750c = i4;
    }

    public void setNormalTextSize(List<Float> list) {
        if (list != null) {
            m(this.f11756i, list, this.f11751d, this.f11752e);
        }
    }

    public void setNormalTextColor(List<Integer> list) {
        k(this.f11753f, list);
    }
}
