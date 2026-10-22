package com.stepos.common.widget;

import P.e;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Scroller;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class ScrollTextView extends View {

    /* renamed from: A, reason: collision with root package name */
    private float f14085A;

    /* renamed from: B, reason: collision with root package name */
    private List<Float> f14086B;

    /* renamed from: C, reason: collision with root package name */
    private List<Integer> f14087C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f14088D;

    /* renamed from: E, reason: collision with root package name */
    private m f14089E;

    /* renamed from: F, reason: collision with root package name */
    private float f14090F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f14091G;

    /* renamed from: H, reason: collision with root package name */
    private P.i f14092H;

    /* renamed from: I, reason: collision with root package name */
    private float f14093I;

    /* renamed from: J, reason: collision with root package name */
    private float f14094J;

    /* renamed from: K, reason: collision with root package name */
    private final Runnable f14095K;

    /* renamed from: L, reason: collision with root package name */
    private final List<f> f14096L;

    /* renamed from: M, reason: collision with root package name */
    private final List<h> f14097M;

    /* renamed from: Q, reason: collision with root package name */
    private final List<g> f14098Q;

    /* renamed from: R, reason: collision with root package name */
    private Context f14099R;

    /* renamed from: S, reason: collision with root package name */
    private final l f14100S;

    /* renamed from: a, reason: collision with root package name */
    private final Paint f14101a;

    /* renamed from: b, reason: collision with root package name */
    private int f14102b;

    /* renamed from: c, reason: collision with root package name */
    private int f14103c;

    /* renamed from: d, reason: collision with root package name */
    private float f14104d;

    /* renamed from: e, reason: collision with root package name */
    private float f14105e;

    /* renamed from: f, reason: collision with root package name */
    private int f14106f;

    /* renamed from: g, reason: collision with root package name */
    private int f14107g;

    /* renamed from: h, reason: collision with root package name */
    private float f14108h;

    /* renamed from: i, reason: collision with root package name */
    private float f14109i;

    /* renamed from: j, reason: collision with root package name */
    private k f14110j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f14111k;

    /* renamed from: l, reason: collision with root package name */
    private int f14112l;

    /* renamed from: m, reason: collision with root package name */
    private int f14113m;

    /* renamed from: n, reason: collision with root package name */
    private int f14114n;

    /* renamed from: o, reason: collision with root package name */
    private n f14115o;

    /* renamed from: p, reason: collision with root package name */
    boolean f14116p;

    /* renamed from: q, reason: collision with root package name */
    private int f14117q;

    /* renamed from: r, reason: collision with root package name */
    private j f14118r;

    /* renamed from: s, reason: collision with root package name */
    private e f14119s;

    /* renamed from: t, reason: collision with root package name */
    private Shader f14120t;

    /* renamed from: u, reason: collision with root package name */
    private Matrix f14121u;

    /* renamed from: v, reason: collision with root package name */
    private Paint f14122v;

    /* renamed from: w, reason: collision with root package name */
    private float f14123w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f14124x;

    /* renamed from: y, reason: collision with root package name */
    private float f14125y;

    /* renamed from: z, reason: collision with root package name */
    private float f14126z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollTextView.this.B();
            ScrollTextView.this.postInvalidate();
        }
    }

    class b implements l {
        b() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.l
        public void a(int i5) {
            ScrollTextView.this.A(i5);
            int height = ScrollTextView.this.getHeight();
            if (ScrollTextView.this.f14112l > height) {
                ScrollTextView.this.f14112l = height;
                ScrollTextView.this.f14110j.r();
                return;
            }
            int i6 = -height;
            if (ScrollTextView.this.f14112l < i6) {
                ScrollTextView.this.f14112l = i6;
                ScrollTextView.this.f14110j.r();
            }
        }

        @Override // com.stepos.common.widget.ScrollTextView.l
        public void b() {
            if (ScrollTextView.this.f14111k) {
                ScrollTextView.this.P();
                ScrollTextView.this.f14111k = false;
            }
            ScrollTextView.this.f14112l = 0;
            ScrollTextView scrollTextView = ScrollTextView.this;
            scrollTextView.removeCallbacks(scrollTextView.f14095K);
            ScrollTextView.this.f14090F = r0.getWidth() / 2.0f;
            ScrollTextView.this.B();
            ScrollTextView.this.invalidate();
        }

        @Override // com.stepos.common.widget.ScrollTextView.l
        public void c() {
            int i5;
            int itemHeight;
            int i6;
            ScrollTextView scrollTextView = ScrollTextView.this;
            if (!scrollTextView.f14116p && scrollTextView.getCurrentItem() < ScrollTextView.this.f14118r.d()) {
                ScrollTextView scrollTextView2 = ScrollTextView.this;
                scrollTextView2.X(scrollTextView2.f14118r.d() - ScrollTextView.this.getCurrentItem(), 0);
                return;
            }
            ScrollTextView scrollTextView3 = ScrollTextView.this;
            if (!scrollTextView3.f14116p && scrollTextView3.getCurrentItem() > ScrollTextView.this.f14118r.c()) {
                ScrollTextView scrollTextView4 = ScrollTextView.this;
                scrollTextView4.X(scrollTextView4.f14118r.c() - ScrollTextView.this.getCurrentItem(), 0);
                return;
            }
            if (Math.abs(ScrollTextView.this.f14112l) <= ScrollTextView.this.getItemHeight() / 2) {
                if (ScrollTextView.this.f14112l != 0) {
                    ScrollTextView.this.f14110j.n(ScrollTextView.this.f14112l, (Math.abs(ScrollTextView.this.f14112l) * 650) / (ScrollTextView.this.getItemHeight() / 2));
                    return;
                }
                return;
            }
            if (ScrollTextView.this.f14112l > 0) {
                itemHeight = -ScrollTextView.this.getItemHeight();
                i6 = ScrollTextView.this.f14112l;
            } else if (ScrollTextView.this.f14112l >= 0) {
                i5 = 0;
                ScrollTextView.this.f14110j.n(i5, 0);
            } else {
                itemHeight = ScrollTextView.this.getItemHeight();
                i6 = ScrollTextView.this.f14112l;
            }
            i5 = itemHeight + i6;
            ScrollTextView.this.f14110j.n(i5, 0);
        }

        @Override // com.stepos.common.widget.ScrollTextView.l
        public void d() {
            ScrollTextView.this.f14111k = true;
            ScrollTextView scrollTextView = ScrollTextView.this;
            scrollTextView.removeCallbacks(scrollTextView.f14095K);
            ScrollTextView.this.Q();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollTextView.this.f14090F = r0.getWidth() / 2.0f;
            ScrollTextView.this.B();
        }
    }

    private class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<k> f14130a;

        public d(k kVar) {
            this.f14130a = new WeakReference<>(kVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            k kVar = this.f14130a.get();
            if (kVar == null || kVar.f14144h) {
                return;
            }
            kVar.f14140d.computeScrollOffset();
            int currY = kVar.f14140d.getCurrY();
            int i5 = kVar.f14141e - currY;
            kVar.f14141e = currY;
            kVar.f14137a.a(i5);
            if (Math.abs(currY - kVar.f14140d.getFinalY()) < 1) {
                kVar.f14140d.forceFinished(true);
            }
            if (kVar.f14140d.isFinished()) {
                if (message.what == 0) {
                    kVar.l();
                    return;
                } else {
                    kVar.k();
                    return;
                }
            }
            int i6 = message.what;
            if (i6 == 1 || i6 == 0) {
                kVar.f14149m.sendEmptyMessage(message.what);
            }
        }
    }

    public interface e {
        void a(View view, int i5, int i6);

        String b(int i5);
    }

    public interface f {
        void a(ScrollTextView scrollTextView, int i5, int i6);
    }

    public interface g {
        void a(ScrollTextView scrollTextView, int i5);
    }

    public interface h {
        void a(ScrollTextView scrollTextView);

        void b(ScrollTextView scrollTextView);
    }

    private class i implements f {
        private i() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.f
        public void a(ScrollTextView scrollTextView, int i5, int i6) {
            ScrollTextView.this.R();
        }

        /* synthetic */ i(ScrollTextView scrollTextView, a aVar) {
            this();
        }
    }

    private class j {

        /* renamed from: a, reason: collision with root package name */
        private int f14133a;

        /* renamed from: b, reason: collision with root package name */
        private int f14134b;

        /* renamed from: c, reason: collision with root package name */
        private int f14135c;

        public j(ScrollTextView scrollTextView) {
            this(10, 0, 9);
        }

        public String a(int i5) {
            if (i5 < 0 || i5 >= b() || ScrollTextView.this.f14119s == null) {
                return null;
            }
            return ScrollTextView.this.f14119s.b(i5);
        }

        public int b() {
            return this.f14135c;
        }

        public int c() {
            return this.f14134b;
        }

        public int d() {
            return this.f14133a;
        }

        public j e(int i5, int i6, int i7) {
            this.f14133a = i6;
            this.f14134b = i7;
            this.f14135c = i5;
            return this;
        }

        public j(int i5, int i6, int i7) {
            this.f14133a = 0;
            this.f14134b = 0;
            this.f14135c = 0;
            e(i5, i6, i7);
        }
    }

    private class k {

        /* renamed from: a, reason: collision with root package name */
        private final l f14137a;

        /* renamed from: b, reason: collision with root package name */
        private final Context f14138b;

        /* renamed from: c, reason: collision with root package name */
        private final GestureDetector f14139c;

        /* renamed from: d, reason: collision with root package name */
        private Scroller f14140d;

        /* renamed from: e, reason: collision with root package name */
        private int f14141e;

        /* renamed from: f, reason: collision with root package name */
        private float f14142f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f14143g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f14144h;

        /* renamed from: i, reason: collision with root package name */
        private final GestureDetector.SimpleOnGestureListener f14145i;

        /* renamed from: j, reason: collision with root package name */
        private final int f14146j;

        /* renamed from: k, reason: collision with root package name */
        private final int f14147k;

        /* renamed from: l, reason: collision with root package name */
        private final int f14148l;

        /* renamed from: m, reason: collision with root package name */
        private final Handler f14149m;

        class a extends GestureDetector.SimpleOnGestureListener {

            /* renamed from: com.stepos.common.widget.ScrollTextView$k$a$a, reason: collision with other inner class name */
            class C0176a implements e.q {
                C0176a() {
                }

                @Override // P.e.q
                public void a(P.e eVar, boolean z5, float f5, float f6) {
                    k.this.k();
                }
            }

            class b implements e.r {
                b() {
                }

                @Override // P.e.r
                public void a(P.e eVar, float f5, float f6) {
                    k.this.p(2);
                }
            }

            a() {
            }

            private void a(int i5, int i6) {
                ScrollTextView.this.w();
                if (ScrollTextView.this.f14092H == null) {
                    ScrollTextView.this.f14092H = new P.i(new P.g());
                    ScrollTextView.this.f14092H.b(new C0176a());
                    ScrollTextView.this.f14092H.c(new b());
                }
                P.j jVar = new P.j();
                jVar.g(i6);
                jVar.h(ScrollTextView.this.f14093I);
                jVar.f(ScrollTextView.this.f14094J);
                ScrollTextView.this.f14092H.x(jVar);
                ScrollTextView.this.f14092H.n(i5);
                ScrollTextView.this.f14092H.p();
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
                k.this.f14141e = 0;
                int yScrollEnd = ScrollTextView.this.getYScrollEnd();
                int i5 = (int) (-f6);
                k.this.f14140d.fling(0, k.this.f14141e, 0, i5, 0, 0, ScrollTextView.this.getYScrollStart(), yScrollEnd);
                int finalY = k.this.f14140d.getFinalY();
                int itemHeight = finalY % ScrollTextView.this.getItemHeight();
                if (itemHeight != 0) {
                    int itemHeight2 = itemHeight > 0 ? finalY + (ScrollTextView.this.getItemHeight() - itemHeight) : finalY - (ScrollTextView.this.getItemHeight() + itemHeight);
                    finalY = ScrollTextView.this.f14112l > 0 ? (itemHeight2 + ScrollTextView.this.f14112l) - ScrollTextView.this.getItemHeight() : itemHeight2 + ScrollTextView.this.getItemHeight() + ScrollTextView.this.f14112l;
                    if (finalY > ScrollTextView.this.getItemHeight()) {
                        finalY -= ScrollTextView.this.getItemHeight();
                    } else if (finalY < (-ScrollTextView.this.getItemHeight())) {
                        finalY += ScrollTextView.this.getItemHeight();
                    }
                    k.this.f14140d.setFinalY(finalY);
                }
                a(i5, finalY);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
                return true;
            }
        }

        public k(Context context, l lVar) {
            a aVar = new a();
            this.f14145i = aVar;
            this.f14146j = 0;
            this.f14147k = 1;
            this.f14148l = 2;
            this.f14149m = ScrollTextView.this.new d(this);
            GestureDetector gestureDetector = new GestureDetector(context, aVar);
            this.f14139c = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
            this.f14140d = new Scroller(context, new PathInterpolator(0.3f, 1.56f, 0.3f, 1.0f));
            this.f14137a = lVar;
            this.f14138b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j() {
            this.f14149m.removeMessages(0);
            this.f14149m.removeMessages(1);
            this.f14149m.removeMessages(2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l() {
            this.f14137a.c();
            p(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(int i5) {
            j();
            this.f14149m.sendEmptyMessage(i5);
        }

        private void q() {
            if (this.f14143g) {
                return;
            }
            this.f14143g = true;
            this.f14137a.d();
        }

        void k() {
            if (this.f14143g) {
                this.f14137a.b();
                this.f14143g = false;
            }
        }

        public boolean m(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f14144h = false;
                this.f14142f = motionEvent.getY();
                this.f14140d.forceFinished(true);
                ScrollTextView.this.w();
                j();
                k();
            } else if (action == 2) {
                this.f14144h = false;
                int y5 = (int) (motionEvent.getY() - this.f14142f);
                if (y5 != 0) {
                    q();
                    this.f14137a.a(y5);
                    this.f14142f = motionEvent.getY();
                }
            } else if (action == 3) {
                l();
            }
            if (!this.f14139c.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                l();
            }
            return true;
        }

        public void n(int i5, int i6) {
            this.f14140d.forceFinished(true);
            this.f14141e = 0;
            Scroller scroller = this.f14140d;
            if (i6 == 0) {
                i6 = 650;
            }
            scroller.startScroll(0, 0, 0, i5, i6);
            p(0);
            q();
        }

        public void o(Interpolator interpolator) {
            this.f14140d.forceFinished(true);
            this.f14140d = new Scroller(this.f14138b, interpolator);
        }

        public void r() {
            this.f14140d.forceFinished(true);
        }
    }

    private interface l {
        void a(int i5);

        void b();

        void c();

        void d();
    }

    private static class n {

        /* renamed from: a, reason: collision with root package name */
        private int f14165a;

        /* renamed from: b, reason: collision with root package name */
        private int f14166b;

        public n() {
            this(0, 0);
        }

        public int a() {
            return this.f14166b;
        }

        public int b() {
            return this.f14165a;
        }

        public int c() {
            return (b() + a()) - 1;
        }

        public n d(int i5, int i6) {
            this.f14165a = i5;
            this.f14166b = i6;
            return this;
        }

        public n(int i5, int i6) {
            this.f14165a = i5;
            this.f14166b = i6;
        }
    }

    private class o implements f {
        private o() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.f
        public void a(ScrollTextView scrollTextView, int i5, int i6) {
            ScrollTextView.this.L();
        }

        /* synthetic */ o(ScrollTextView scrollTextView, a aVar) {
            this();
        }
    }

    public ScrollTextView(Context context, AttributeSet attributeSet, int i5) throws Resources.NotFoundException {
        super(context, attributeSet, i5);
        this.f14101a = new Paint(1);
        this.f14102b = 0;
        this.f14103c = 5;
        this.f14104d = 0.0f;
        this.f14105e = 0.0f;
        this.f14116p = false;
        this.f14124x = true;
        this.f14088D = true;
        this.f14090F = 0.0f;
        this.f14091G = true;
        this.f14093I = 30.0f;
        this.f14094J = 0.98f;
        this.f14095K = new a();
        this.f14096L = new LinkedList();
        this.f14097M = new LinkedList();
        this.f14098Q = new LinkedList();
        this.f14100S = new b();
        G(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i5) {
        if (!I()) {
            if (this.f14102b == getScrollStartItem()) {
                int i6 = this.f14112l;
                if (i6 + i5 > 0) {
                    i5 = -i6;
                }
                if (i5 == 0) {
                    return;
                }
            } else if (this.f14102b == getScrollEndItem()) {
                int i7 = this.f14112l;
                if (i7 + i5 < 0) {
                    i5 = -i7;
                }
                if (i5 == 0) {
                    return;
                }
            }
        }
        int iB = this.f14118r.b();
        if (iB == 1) {
            this.f14112l = 0;
        } else {
            this.f14112l += i5;
        }
        int itemHeight = getItemHeight();
        int scrollEndItem = this.f14112l / itemHeight;
        int scrollEndItem2 = this.f14102b - scrollEndItem;
        if (this.f14116p && iB > 0) {
            while (scrollEndItem2 < 0) {
                scrollEndItem2 += iB;
            }
            scrollEndItem2 %= iB;
        } else if (scrollEndItem2 < getScrollStartItem()) {
            scrollEndItem = this.f14102b - getScrollStartItem();
            scrollEndItem2 = getScrollStartItem();
        } else if (scrollEndItem2 > getScrollEndItem()) {
            scrollEndItem = this.f14102b - getScrollEndItem();
            scrollEndItem2 = getScrollEndItem();
        } else if (scrollEndItem2 != getScrollEndItem()) {
            getScrollStartItem();
        }
        int i8 = this.f14112l;
        if (scrollEndItem2 != this.f14102b) {
            Y(scrollEndItem2, false);
        } else {
            invalidate();
        }
        int i9 = i8 - (scrollEndItem * itemHeight);
        this.f14112l = i9;
        if (i9 <= getHeight() || getHeight() == 0) {
            return;
        }
        this.f14112l = (this.f14112l % getHeight()) + getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.f14111k) {
            postInvalidate();
        } else {
            postDelayed(this.f14095K, 10L);
        }
    }

    private void C(Canvas canvas) {
        int width = getWidth() / 2;
        float fMeasureText = this.f14101a.measureText("AA");
        float itemHeight = ((-(((this.f14102b - this.f14117q) * getItemHeight()) + ((((int) this.f14104d) - getHeight()) / 2))) + this.f14112l) - getItemHeight();
        canvas.translate(this.f14114n, itemHeight);
        int itemHeight2 = this.f14112l;
        if (itemHeight2 <= 0) {
            itemHeight2 = getItemHeight() + this.f14112l;
        }
        float f5 = 1.0f;
        float itemHeight3 = (itemHeight2 * 1.0f) / getItemHeight();
        int i5 = 0;
        while (i5 < this.f14115o.a()) {
            float fZ = z(i5, itemHeight3);
            canvas.translate(0.0f, fZ);
            itemHeight += fZ;
            String strE = E(i5);
            float f6 = (this.f14105e / 2.0f) - this.f14085A;
            if (this.f14111k || this.f14101a.getTextSize() != this.f14109i) {
                canvas.drawText(strE, width, f6, this.f14101a);
            } else {
                float fMeasureText2 = this.f14101a.measureText(strE);
                if (!J() || fMeasureText2 <= getWidth()) {
                    removeCallbacks(this.f14095K);
                    canvas.drawText(strE, width, f6, this.f14101a);
                } else {
                    float f7 = this.f14090F - f5;
                    this.f14090F = f7;
                    float f8 = width;
                    float width2 = f8 - ((fMeasureText2 - getWidth()) / 2.0f);
                    if (f7 >= width2 - getWidth()) {
                        canvas.drawText(strE, this.f14090F, f6, this.f14101a);
                    }
                    float f9 = this.f14090F;
                    if (f9 <= width2 - fMeasureText && f9 >= ((width2 - fMeasureText2) - getWidth()) - fMeasureText) {
                        canvas.drawText(strE, this.f14090F + fMeasureText2 + fMeasureText, f6, this.f14101a);
                    }
                    float f10 = this.f14090F;
                    float f11 = fMeasureText * 2.0f;
                    if (f10 <= (width2 - fMeasureText2) - f11) {
                        canvas.drawText(strE, f10 + ((fMeasureText2 + fMeasureText) * 2.0f), f6, this.f14101a);
                    }
                    if (this.f14090F <= (-(((fMeasureText2 * 2.0f) - f8) + f11))) {
                        removeCallbacks(this.f14095K);
                    }
                }
            }
            i5++;
            f5 = 1.0f;
        }
        canvas.translate(0.0f, -itemHeight);
    }

    private void D(Canvas canvas) {
        this.f14121u.setScale(1.0f, this.f14123w);
        this.f14120t.setLocalMatrix(this.f14121u);
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.f14123w, this.f14122v);
        this.f14121u.setScale(1.0f, this.f14123w);
        this.f14121u.postRotate(180.0f);
        this.f14121u.postTranslate(0.0f, getHeight());
        this.f14120t.setLocalMatrix(this.f14121u);
        canvas.drawRect(0.0f, getHeight() - this.f14123w, getWidth(), getHeight(), this.f14122v);
    }

    private String E(int i5) {
        String strA;
        int i6 = i5 + this.f14117q;
        String strA2 = this.f14118r.a(i6);
        if (i6 < 0) {
            int iB = this.f14118r.b() + i6;
            if (this.f14116p) {
                strA = this.f14118r.a(iB);
                strA2 = strA;
            }
            strA2 = BuildConfig.FLAVOR;
        } else if (i6 >= this.f14118r.b()) {
            int iB2 = i6 - this.f14118r.b();
            if (this.f14116p) {
                strA = this.f14118r.a(iB2);
                strA2 = strA;
            }
            strA2 = BuildConfig.FLAVOR;
        }
        return strA2 == null ? BuildConfig.FLAVOR : strA2;
    }

    private void F(Context context) throws Resources.NotFoundException {
        this.f14106f = context.getResources().getColor(H1.e.f2081c);
        int color = context.getResources().getColor(H1.e.f2082d);
        this.f14107g = color;
        b0(this.f14106f, color);
    }

    private void G(Context context) throws Resources.NotFoundException {
        this.f14099R = context;
        this.f14086B = new ArrayList();
        H(context);
        F(context);
        this.f14118r = new j(this);
        this.f14121u = new Matrix();
        this.f14120t = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, context.getResources().getColor(H1.e.f2088j), 16777215, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.f14122v = paint;
        paint.setShader(this.f14120t);
        this.f14123w = context.getResources().getDimension(H1.f.f2106B);
        this.f14115o = new n();
        this.f14101a.setTextAlign(Paint.Align.CENTER);
        x();
        a aVar = null;
        this.f14089E = new m(aVar);
        u(new i(this, aVar));
        u(new o(this, aVar));
        this.f14101a.setAntiAlias(true);
    }

    private void H(Context context) throws Resources.NotFoundException {
        this.f14110j = new k(getContext(), this.f14100S);
        this.f14109i = context.getResources().getDimension(H1.f.f2116L);
        this.f14108h = context.getResources().getDimension(H1.f.f2108D);
        this.f14104d = context.getResources().getDimension(H1.f.f2114J);
        float dimension = context.getResources().getDimension(H1.f.f2107C);
        this.f14105e = dimension;
        d0(this.f14109i, this.f14108h, this.f14104d, dimension);
    }

    private boolean K(int i5) {
        j jVar = this.f14118r;
        if (jVar == null || jVar.b() <= 0) {
            return false;
        }
        if (this.f14116p) {
            return true;
        }
        return i5 >= 0 && i5 < this.f14118r.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        N1.a.i(this, 21000, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        m mVar = this.f14089E;
        if (mVar != null) {
            mVar.f();
        }
    }

    private boolean S() {
        n itemsRange = getItemsRange();
        this.f14115o = itemsRange;
        if (this.f14117q <= itemsRange.b() || this.f14117q > this.f14115o.c()) {
            this.f14117q = this.f14115o.b();
            return false;
        }
        int i5 = this.f14117q;
        while (true) {
            i5--;
            if (i5 < this.f14115o.b()) {
                return false;
            }
            this.f14117q = i5;
        }
    }

    private n getItemsRange() {
        if (getItemHeight() == 0) {
            return null;
        }
        int i5 = this.f14102b;
        int iAsin = 1;
        while (true) {
            int i6 = iAsin + 2;
            if (getItemHeight() * i6 >= getHeight()) {
                break;
            }
            i5--;
            iAsin = i6;
        }
        int i7 = this.f14112l;
        if (i7 != 0) {
            if (i7 > 0) {
                i5--;
            }
            int itemHeight = i7 / getItemHeight();
            i5 -= itemHeight;
            iAsin = (int) (iAsin + 1 + Math.asin(itemHeight));
        }
        return this.f14115o.d(i5, iAsin);
    }

    private int getScrollEndItem() {
        int iB = this.f14118r.b();
        if (this.f14116p) {
            return 0;
        }
        return iB <= this.f14103c ? iB - 1 : iB - 1;
    }

    private int getScrollStartItem() {
        this.f14118r.b();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYScrollEnd() {
        if (this.f14116p) {
            return Integer.MAX_VALUE;
        }
        return this.f14112l + ((int) ((getScrollEndItem() - getCurrentItem()) * this.f14105e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYScrollStart() {
        if (this.f14116p) {
            return -2147483647;
        }
        return this.f14112l + ((int) ((getScrollStartItem() - getCurrentItem()) * this.f14105e));
    }

    private void setViewAdapter(j jVar) {
        this.f14118r = jVar;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        P.i iVar = this.f14092H;
        if (iVar == null || !iVar.i()) {
            return;
        }
        this.f14092H.d();
    }

    private void x() {
        this.f14101a.setTextSize(this.f14109i);
        Paint.FontMetricsInt fontMetricsInt = this.f14101a.getFontMetricsInt();
        this.f14125y = (fontMetricsInt.bottom + fontMetricsInt.top) / 2.0f;
        this.f14101a.setTextSize(this.f14108h);
        Paint.FontMetricsInt fontMetricsInt2 = this.f14101a.getFontMetricsInt();
        this.f14126z = (fontMetricsInt2.bottom + fontMetricsInt2.top) / 2.0f;
    }

    private void y(int i5, float f5) {
        float f6;
        float fFloatValue;
        float f7;
        float f8;
        int iIntValue;
        int i6 = this.f14103c;
        int i7 = i6 / 2;
        int iIntValue2 = this.f14106f;
        if (i5 < i7 || i5 > i7 + 1) {
            this.f14085A = this.f14126z;
        } else {
            float f9 = this.f14126z;
            this.f14085A = f9 + ((this.f14125y - f9) * f5);
        }
        if (i5 > i7) {
            i5 = i6 - i5;
        }
        if (i5 > i7) {
            i5 = i7;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        if (i5 == 0) {
            iIntValue2 = this.f14087C.get(i5).intValue();
            iIntValue = this.f14087C.get(i5).intValue();
            float fFloatValue2 = this.f14086B.get(i5).floatValue();
            fFloatValue = this.f14086B.get(i5).floatValue();
            f7 = 0.0f;
            f6 = fFloatValue2;
            f8 = 0.0f;
        } else if (i5 < i7) {
            iIntValue2 = this.f14087C.get(i5).intValue();
            int i8 = i5 - 1;
            int iIntValue3 = this.f14087C.get(i8).intValue();
            float fFloatValue3 = this.f14086B.get(i5).floatValue();
            float fFloatValue4 = this.f14086B.get(i8).floatValue();
            f6 = fFloatValue3;
            fFloatValue = fFloatValue4;
            f8 = f5;
            iIntValue = iIntValue3;
            f7 = 0.0f;
        } else {
            int i9 = i5 - 1;
            int iIntValue4 = this.f14087C.get(i9).intValue();
            f6 = this.f14109i;
            fFloatValue = this.f14086B.get(i9).floatValue();
            f7 = 2.0f;
            f8 = f5;
            iIntValue = iIntValue4;
        }
        int iAlpha = Color.alpha(iIntValue2);
        int iRed = Color.red(iIntValue2);
        int iGreen = Color.green(iIntValue2);
        int iBlue = Color.blue(iIntValue2);
        this.f14101a.setColor(Color.argb(Color.alpha(iIntValue) + ((int) ((iAlpha - r8) * f8)), Color.red(iIntValue) + ((int) ((iRed - r9) * f8)), Color.green(iIntValue) + ((int) ((iGreen - r10) * f8)), Color.blue(iIntValue) + ((int) ((iBlue - r14) * f8))));
        this.f14101a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f14101a.setStrokeWidth(0.0f + ((f7 - 0.0f) * f8));
        this.f14101a.setTextSize(fFloatValue + ((f6 - fFloatValue) * f8));
    }

    private float z(int i5, float f5) {
        float f6;
        float itemHeight = getItemHeight();
        int i6 = (int) (this.f14104d - this.f14105e);
        int i7 = this.f14103c / 2;
        if (i5 >= i7) {
            if (i5 == i7) {
                f6 = i6;
            } else {
                if (i5 == i7 + 1) {
                    itemHeight += i6 / 2.0f;
                } else if (i5 == i7 + 2) {
                    f6 = i6;
                    f5 = 1.0f - f5;
                }
                f5 = 1.0f - f5;
            }
            itemHeight += (f6 * f5) / 2.0f;
        }
        y(i5, f5);
        return itemHeight;
    }

    public boolean I() {
        return this.f14116p;
    }

    public boolean J() {
        return this.f14091G;
    }

    public int M(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        this.f14101a.setTextSize(this.f14109i);
        this.f14101a.getTextWidths(str, new float[length]);
        int iCeil = 0;
        for (int i5 = 0; i5 < length; i5++) {
            iCeil += (int) Math.ceil(r2[i5]);
        }
        return iCeil;
    }

    protected void N(int i5, int i6) {
        Iterator<f> it = this.f14096L.iterator();
        while (it.hasNext()) {
            it.next().a(this, i5, i6);
        }
    }

    protected void O(int i5) {
        Y(i5, true);
        Iterator<g> it = this.f14098Q.iterator();
        while (it.hasNext()) {
            it.next().a(this, i5);
        }
    }

    protected void P() {
        e eVar = this.f14119s;
        if (eVar != null) {
            eVar.a(this, 0, getCurrentItem());
        }
        Iterator<h> it = this.f14097M.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    protected void Q() {
        Iterator<h> it = this.f14097M.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public void T(int i5) {
        W(i5, this.f14102b, 0, i5 - 1);
    }

    public void U(int i5, int i6) {
        int i7 = this.f14102b + i6;
        this.f14102b = i7;
        W(i5, i7, 0, i5 - 1);
    }

    public void V(int i5) {
        W(this.f14118r.b(), i5, this.f14118r.d(), this.f14118r.c());
    }

    public void W(int i5, int i6, int i7, int i8) {
        e eVar;
        h0();
        if (i5 < 0) {
            return;
        }
        setViewAdapter(this.f14118r.e(i5, i7, i8));
        int i9 = this.f14102b;
        if (i6 != i9) {
            int iMax = Math.max(i6, i7);
            this.f14102b = iMax;
            if (iMax > i8 || iMax >= i5) {
                this.f14102b = Math.min(i8, i5);
            }
        }
        int i10 = this.f14102b;
        if (i9 != i10 && (eVar = this.f14119s) != null) {
            eVar.a(this, i9, i10);
        }
        invalidate();
    }

    public void X(int i5, int i6) {
        this.f14110j.n((i5 * getItemHeight()) + this.f14112l, i6);
    }

    public void Y(int i5, boolean z5) {
        int iMin;
        j jVar = this.f14118r;
        if (jVar == null || jVar.b() == 0) {
            return;
        }
        int iB = this.f14118r.b();
        if (i5 < 0 || i5 >= iB) {
            if (!this.f14116p) {
                return;
            }
            while (i5 < 0) {
                i5 += iB;
            }
            i5 %= iB;
        }
        int i6 = this.f14102b;
        if (i5 != i6) {
            if (!z5) {
                this.f14112l = 0;
                this.f14102b = i5;
                N(i6, i5);
                invalidate();
                return;
            }
            int i7 = i5 - i6;
            if (this.f14116p && (iMin = (iB + Math.min(i5, i6)) - Math.max(i5, this.f14102b)) < Math.abs(i7)) {
                i7 = i7 < 0 ? iMin : -iMin;
            }
            X(i7, 0);
        }
    }

    public void Z(e eVar, float f5, int i5, int i6, int i7, int i8, int i9, boolean z5) {
        setIDataAdapter(eVar);
        this.f14103c = i7;
        this.f14116p = z5;
        if (f5 == -1.0f) {
            this.f14113m = getResources().getDimensionPixelSize(H1.f.f2113I);
        } else {
            this.f14113m = (int) (f5 * getContext().getResources().getDisplayMetrics().density);
        }
        if (i6 < this.f14103c || i9 + 1 < i6 || i8 > 0) {
            this.f14116p = false;
        }
        W(i6, i5, i8, i9);
    }

    public void a0(float f5, float f6) {
        d0(this.f14109i, this.f14108h, f5, f6);
    }

    public void b0(int i5, int i6) {
        this.f14106f = i5;
        this.f14107g = i6;
        this.f14087C = new ArrayList();
        int i7 = this.f14103c - 1;
        for (int i8 = 0; i8 < i7 / 2; i8++) {
            this.f14087C.add(Integer.valueOf(this.f14107g));
        }
        invalidate();
    }

    public void c0(int i5, List<Integer> list) {
        this.f14106f = i5;
        if (list != null && this.f14087C != list) {
            this.f14107g = list.get(0).intValue();
            this.f14087C = new ArrayList();
            int i6 = this.f14103c - 1;
            for (int i7 = 0; i7 < i6 / 2; i7++) {
                int size = list.size();
                if (i7 < size) {
                    this.f14087C.add(list.get(i7));
                } else {
                    this.f14087C.add(list.get(size - 1));
                }
            }
        }
        invalidate();
    }

    public void d0(float f5, float f6, float f7, float f8) {
        this.f14104d = f7;
        this.f14105e = f8;
        this.f14109i = f5;
        this.f14108h = f6;
        this.f14086B = new ArrayList();
        int i5 = this.f14103c - 1;
        for (int i6 = 0; i6 < i5 / 2; i6++) {
            this.f14086B.add(Float.valueOf(this.f14108h));
        }
        x();
        invalidate();
    }

    public void e0(float f5, List<Float> list, float f6, float f7) {
        if (this.f14104d == f6 && this.f14105e == f7 && this.f14109i == f5 && list == null) {
            return;
        }
        this.f14104d = f6;
        this.f14109i = f5;
        this.f14105e = f7;
        if (list != null && this.f14086B != list) {
            this.f14108h = list.get(0).floatValue();
            this.f14086B = new ArrayList();
            int i5 = this.f14103c - 1;
            for (int i6 = 0; i6 < i5 / 2; i6++) {
                int size = list.size();
                if (i6 < size) {
                    this.f14086B.add(list.get(i6));
                } else {
                    this.f14086B.add(list.get(size - 1));
                }
            }
        }
        x();
        invalidate();
    }

    public void f0(float f5, float f6) {
        d0(f5, f6, this.f14104d, this.f14105e);
    }

    public void g0(float f5, List<Float> list) {
        if (f5 == this.f14109i && list == null) {
            return;
        }
        e0(f5, list, this.f14104d, this.f14105e);
    }

    public int getCurrentItem() {
        return this.f14102b;
    }

    public e getIDataAdapter() {
        return this.f14119s;
    }

    public int getItemHeight() {
        return (int) this.f14105e;
    }

    public int getItemsCount() {
        return this.f14118r.b();
    }

    public int getSelectedItemHeight() {
        return (int) this.f14104d;
    }

    public j getViewAdapter() {
        return this.f14118r;
    }

    public int getVisibleItems() {
        return this.f14103c;
    }

    public void h0() {
        k kVar = this.f14110j;
        if (kVar != null) {
            kVar.r();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m mVar = this.f14089E;
        if (mVar != null) {
            mVar.e(this.f14099R);
        }
        post(new c());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m mVar = this.f14089E;
        if (mVar != null) {
            mVar.g();
        }
        k kVar = this.f14110j;
        if (kVar != null) {
            kVar.j();
        }
        removeCallbacks(this.f14095K);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        j jVar = this.f14118r;
        if (jVar != null && jVar.b() > 0) {
            S();
            C(canvas);
        }
        if (this.f14124x) {
            D(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ScrollTextView.class.getName());
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (View.MeasureSpec.getMode(i6) == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidthAndState(), (int) (((this.f14103c - 1) * this.f14105e) + this.f14104d));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || getViewAdapter() == null) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2 && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(this.f14088D);
            }
        } else if (!this.f14111k) {
            int y5 = ((int) motionEvent.getY()) - (getHeight() / 2);
            int itemHeight = ((int) (y5 < 0 ? y5 + ((this.f14104d / 2.0f) - getItemHeight()) : y5 - ((this.f14104d / 2.0f) - getItemHeight()))) / getItemHeight();
            if (itemHeight != 0 && K(this.f14102b + itemHeight)) {
                O(this.f14102b + itemHeight);
            }
        }
        return this.f14110j.m(motionEvent);
    }

    public void setCurrentItem(int i5) {
        Y(i5, false);
    }

    public void setCyclic(boolean z5) {
        this.f14116p = z5;
        invalidate();
    }

    public void setFadingHeight(float f5) {
        if (this.f14123w != f5) {
            this.f14123w = f5;
            invalidate();
        }
    }

    public void setFadingShader(Shader shader) {
        this.f14120t = shader;
        this.f14122v.setShader(shader);
        invalidate();
    }

    public void setFadingShaderColor(int i5) {
        this.f14120t = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, i5, 16777215, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.f14122v = paint;
        paint.setShader(this.f14120t);
    }

    public void setHorizontalOffset(int i5) {
        this.f14114n = i5;
    }

    public void setIDataAdapter(e eVar) {
        this.f14119s = eVar;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f14110j.o(interpolator);
    }

    public void setIsDrawFading(boolean z5) {
        this.f14124x = z5;
    }

    public void setNormalItemHeight(float f5) {
        d0(this.f14109i, this.f14108h, this.f14104d, f5);
    }

    public void setNormalTextColor(int i5) {
        if (this.f14107g == i5) {
            return;
        }
        b0(this.f14106f, i5);
    }

    public void setNormalTextSize(float f5) {
        d0(this.f14109i, f5, this.f14104d, this.f14105e);
    }

    public void setParentRequestDisallowInterceptTouchEvent(boolean z5) {
        this.f14088D = z5;
    }

    @Override // android.view.View
    public void setScrollY(int i5) {
        int i6 = this.f14110j.f14141e - i5;
        this.f14110j.f14141e = i5;
        this.f14110j.f14137a.a(i6);
    }

    public void setSelectItemHeight(float f5) {
        d0(this.f14109i, this.f14108h, f5, this.f14105e);
    }

    public void setSelectTextColor(int i5) {
        if (this.f14106f == i5) {
            return;
        }
        c0(i5, this.f14087C);
    }

    public void setSelectTextSize(float f5) {
        d0(f5, this.f14108h, this.f14104d, this.f14105e);
    }

    public void setShowMarquee(boolean z5) {
        this.f14091G = z5;
    }

    public void setTypeface(Typeface typeface) {
        this.f14101a.setTypeface(typeface);
        x();
        invalidate();
    }

    public void setVisibleItems(int i5) {
        this.f14103c = i5;
    }

    public void u(f fVar) {
        this.f14096L.add(fVar);
    }

    public void v(h hVar) {
        this.f14097M.add(hVar);
    }

    public void setNormalTextSize(List<Float> list) {
        if (list != null) {
            e0(this.f14109i, list, this.f14104d, this.f14105e);
        }
    }

    public void setNormalTextColor(List<Integer> list) {
        c0(this.f14106f, list);
    }

    private static class m {

        /* renamed from: a, reason: collision with root package name */
        private Thread f14154a;

        /* renamed from: b, reason: collision with root package name */
        private Handler f14155b;

        /* renamed from: c, reason: collision with root package name */
        private Looper f14156c;

        /* renamed from: d, reason: collision with root package name */
        public SoundPool f14157d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f14158e;

        /* renamed from: f, reason: collision with root package name */
        public int f14159f;

        /* renamed from: g, reason: collision with root package name */
        public Context f14160g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f14161h;

        class a implements Runnable {

            /* renamed from: com.stepos.common.widget.ScrollTextView$m$a$a, reason: collision with other inner class name */
            class C0177a implements SoundPool.OnLoadCompleteListener {
                C0177a() {
                }

                @Override // android.media.SoundPool.OnLoadCompleteListener
                public void onLoadComplete(SoundPool soundPool, int i5, int i6) {
                    m.this.f14158e = true;
                }
            }

            a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v10 */
            /* JADX WARN: Type inference failed for: r5v12 */
            /* JADX WARN: Type inference failed for: r5v13 */
            @Override // java.lang.Runnable
            public void run() throws IllegalArgumentException {
                SoundPool.Builder builder = new SoundPool.Builder();
                builder.setMaxStreams(1);
                AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
                builder2.setLegacyStreamType(1);
                builder.setAudioAttributes(builder2.build());
                m.this.f14157d = builder.build();
                m.this.f14157d.setOnLoadCompleteListener(new C0177a());
                try {
                    try {
                        m mVar = m.this;
                        mVar.f14159f = mVar.f14157d.load(mVar.f14160g, H1.j.f2336a, 1);
                        Looper.prepare();
                        synchronized (m.this) {
                            m mVar2 = m.this;
                            if (mVar2.f14161h) {
                                this = mVar2.f14157d;
                            } else {
                                mVar2.f14156c = Looper.myLooper();
                                m.this.f14155b = new Handler(m.this.f14156c);
                                Looper.loop();
                                this = m.this.f14157d;
                            }
                        }
                    } catch (Exception unused) {
                        m mVar3 = m.this;
                        mVar3.f14158e = false;
                        this = mVar3.f14157d;
                    }
                    this.release();
                } catch (Throwable th) {
                    m.this.f14157d.release();
                    throw th;
                }
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                m mVar = m.this;
                if (mVar.f14158e) {
                    mVar.f14157d.play(mVar.f14159f, 0.5f, 0.5f, 0, 0, 1.0f);
                }
            }
        }

        private m() {
            this.f14154a = null;
            this.f14155b = null;
            this.f14156c = null;
        }

        public void d(Context context) {
            this.f14160g = context.getApplicationContext();
            this.f14158e = false;
            this.f14161h = false;
            Thread thread = new Thread(new a());
            this.f14154a = thread;
            thread.start();
        }

        public void e(Context context) {
            if (this.f14158e) {
                return;
            }
            d(context);
        }

        public void f() {
            Handler handler = this.f14155b;
            if (handler != null) {
                handler.post(new b());
            }
        }

        public void g() {
            synchronized (this) {
                try {
                    this.f14161h = true;
                    Handler handler = this.f14155b;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        if (this.f14158e) {
                            this.f14157d.unload(this.f14159f);
                        }
                        this.f14157d.release();
                        this.f14156c.quit();
                        this.f14154a = null;
                        this.f14158e = false;
                        this.f14160g = null;
                        this.f14155b = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* synthetic */ m(a aVar) {
            this();
        }
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
