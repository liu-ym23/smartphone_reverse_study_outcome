package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
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
import com.stepos.aiengine.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ScrollTextView extends View {
    public static final /* synthetic */ int R = 0;
    public float A;
    public float B;
    public float C;
    public ArrayList D;
    public ArrayList E;
    public boolean F;
    public final l G;
    public float H;
    public boolean I;
    public h1.f J;
    public final float K;
    public final float L;
    public final a M;
    public final LinkedList N;
    public final LinkedList O;
    public final LinkedList P;
    public final Context Q;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f6980a;

    /* renamed from: b, reason: collision with root package name */
    public int f6981b;

    /* renamed from: c, reason: collision with root package name */
    public int f6982c;

    /* renamed from: d, reason: collision with root package name */
    public float f6983d;

    /* renamed from: e, reason: collision with root package name */
    public float f6984e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public int f6985j;

    /* renamed from: k, reason: collision with root package name */
    public float f6986k;

    /* renamed from: l, reason: collision with root package name */
    public float f6987l;

    /* renamed from: m, reason: collision with root package name */
    public final k f6988m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6989n;

    /* renamed from: o, reason: collision with root package name */
    public int f6990o;

    /* renamed from: p, reason: collision with root package name */
    public int f6991p;

    /* renamed from: q, reason: collision with root package name */
    public m f6992q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public int f6993s;

    /* renamed from: t, reason: collision with root package name */
    public j f6994t;

    /* renamed from: u, reason: collision with root package name */
    public e f6995u;

    /* renamed from: v, reason: collision with root package name */
    public Shader f6996v;

    /* renamed from: w, reason: collision with root package name */
    public final Matrix f6997w;

    /* renamed from: x, reason: collision with root package name */
    public Paint f6998x;

    /* renamed from: y, reason: collision with root package name */
    public float f6999y;
    public boolean z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ScrollTextView scrollTextView = ScrollTextView.this;
            if (scrollTextView.f6989n) {
                scrollTextView.postInvalidate();
            } else {
                scrollTextView.postDelayed(scrollTextView.M, 10L);
            }
            scrollTextView.postInvalidate();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b {
        public b() {
        }

        public final void a(int i10) {
            ScrollTextView scrollTextView = ScrollTextView.this;
            ScrollTextView.c(scrollTextView, i10);
            int height = scrollTextView.getHeight();
            int i11 = scrollTextView.f6990o;
            if (i11 > height) {
                scrollTextView.f6990o = height;
                scrollTextView.f6988m.f7011d.forceFinished(true);
                return;
            }
            int i12 = -height;
            if (i11 < i12) {
                scrollTextView.f6990o = i12;
                scrollTextView.f6988m.f7011d.forceFinished(true);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ScrollTextView scrollTextView = ScrollTextView.this;
            scrollTextView.H = scrollTextView.getWidth() / 2.0f;
            if (scrollTextView.f6989n) {
                scrollTextView.postInvalidate();
            } else {
                scrollTextView.postDelayed(scrollTextView.M, 10L);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<k> f7003a;

        public d(k kVar) {
            this.f7003a = new WeakReference<>(kVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            k kVar = this.f7003a.get();
            if (kVar != null) {
                kVar.f7011d.computeScrollOffset();
                int currY = kVar.f7011d.getCurrY();
                int i10 = kVar.f7012e - currY;
                kVar.f7012e = currY;
                kVar.f7008a.a(i10);
                if (Math.abs(currY - kVar.f7011d.getFinalY()) < 1) {
                    kVar.f7011d.forceFinished(true);
                }
                if (kVar.f7011d.isFinished()) {
                    if (message.what == 0) {
                        kVar.b();
                        return;
                    } else {
                        kVar.a();
                        return;
                    }
                }
                int i11 = message.what;
                if (i11 == 1 || i11 == 0) {
                    kVar.h.sendEmptyMessage(i11);
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface e {
        String a(int i10);

        void b(int i10);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface f {
        void onChanged();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface g {
        void a();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface h {
        void a(ScrollTextView scrollTextView);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class i implements f {
        public i() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.f
        public final void onChanged() {
            Handler handler;
            l lVar = ScrollTextView.this.G;
            if (lVar != null) {
                synchronized (lVar) {
                    handler = lVar.f7018b;
                }
                if (handler != null) {
                    handler.post(new w(lVar));
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class j {

        /* renamed from: a, reason: collision with root package name */
        public int f7005a = 9;

        /* renamed from: b, reason: collision with root package name */
        public int f7006b = 10;

        public j() {
        }

        public final String a(int i10) {
            e eVar;
            if (i10 < 0 || i10 >= this.f7006b || (eVar = ScrollTextView.this.f6995u) == null) {
                return null;
            }
            return eVar.a(i10);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class k {

        /* renamed from: a, reason: collision with root package name */
        public final b f7008a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f7009b;

        /* renamed from: c, reason: collision with root package name */
        public final GestureDetector f7010c;

        /* renamed from: d, reason: collision with root package name */
        public Scroller f7011d;

        /* renamed from: e, reason: collision with root package name */
        public int f7012e;

        /* renamed from: f, reason: collision with root package name */
        public float f7013f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f7014g;
        public final d h;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a extends GestureDetector.SimpleOnGestureListener {
            public a() {
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
                k kVar = k.this;
                kVar.f7012e = 0;
                ScrollTextView scrollTextView = ScrollTextView.this;
                int i10 = (int) (-f9);
                kVar.f7011d.fling(0, kVar.f7012e, 0, i10, 0, 0, scrollTextView.getYScrollStart(), scrollTextView.getYScrollEnd());
                int finalY = kVar.f7011d.getFinalY();
                int itemHeight = finalY % scrollTextView.getItemHeight();
                if (itemHeight != 0) {
                    int itemHeight2 = itemHeight > 0 ? (scrollTextView.getItemHeight() - itemHeight) + finalY : finalY - (scrollTextView.getItemHeight() + itemHeight);
                    int i11 = scrollTextView.f6990o;
                    int itemHeight3 = i11 > 0 ? (itemHeight2 + i11) - scrollTextView.getItemHeight() : scrollTextView.getItemHeight() + itemHeight2 + scrollTextView.f6990o;
                    if (itemHeight3 > scrollTextView.getItemHeight()) {
                        itemHeight3 -= scrollTextView.getItemHeight();
                    } else {
                        if (itemHeight3 < (-scrollTextView.getItemHeight())) {
                            finalY = scrollTextView.getItemHeight() + itemHeight3;
                        }
                        kVar.f7011d.setFinalY(finalY);
                    }
                    finalY = itemHeight3;
                    kVar.f7011d.setFinalY(finalY);
                }
                h1.f fVar = scrollTextView.J;
                if (fVar != null && fVar.f9232f) {
                    fVar.f();
                }
                if (scrollTextView.J == null) {
                    h1.f fVar2 = new h1.f(new h1.e());
                    scrollTextView.J = fVar2;
                    fVar2.a(new t(this));
                    scrollTextView.J.b(new u(this));
                }
                h1.g gVar = new h1.g();
                gVar.f9251i = finalY;
                gVar.b(scrollTextView.K);
                gVar.a(scrollTextView.L);
                h1.f fVar3 = scrollTextView.J;
                fVar3.f9241t = gVar;
                fVar3.f9227a = i10;
                fVar3.h();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
                return true;
            }
        }

        public k(Context context, b bVar) {
            a aVar = new a();
            this.h = new d(this);
            GestureDetector gestureDetector = new GestureDetector(context, aVar);
            this.f7010c = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
            this.f7011d = new Scroller(context, new PathInterpolator(0.3f, 1.56f, 0.3f, 1.0f));
            this.f7008a = bVar;
            this.f7009b = context;
        }

        public final void a() {
            if (this.f7014g) {
                ScrollTextView scrollTextView = ScrollTextView.this;
                a aVar = scrollTextView.M;
                if (scrollTextView.f6989n) {
                    e eVar = scrollTextView.f6995u;
                    if (eVar != null) {
                        eVar.b(scrollTextView.getCurrentItem());
                    }
                    Iterator it = scrollTextView.O.iterator();
                    while (it.hasNext()) {
                        ((h) it.next()).a(scrollTextView);
                    }
                    scrollTextView.f6989n = false;
                }
                scrollTextView.f6990o = 0;
                scrollTextView.removeCallbacks(aVar);
                scrollTextView.H = scrollTextView.getWidth() / 2.0f;
                if (scrollTextView.f6989n) {
                    scrollTextView.postInvalidate();
                } else {
                    scrollTextView.postDelayed(aVar, 10L);
                }
                scrollTextView.invalidate();
                this.f7014g = false;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b() {
            /*
                r6 = this;
                com.stepos.common.widget.ScrollTextView$b r0 = r6.f7008a
                com.stepos.common.widget.ScrollTextView r0 = com.stepos.common.widget.ScrollTextView.this
                boolean r1 = r0.r
                r2 = 2
                r3 = 0
                if (r1 != 0) goto L29
                int r1 = r0.getCurrentItem()
                com.stepos.common.widget.ScrollTextView$j r4 = r0.f6994t
                r4.getClass()
                if (r1 >= 0) goto L29
                int r1 = r0.getCurrentItem()
                int r1 = 0 - r1
                int r4 = r0.getItemHeight()
                int r4 = r4 * r1
                int r1 = r0.f6990o
                int r4 = r4 + r1
                com.stepos.common.widget.ScrollTextView$k r0 = r0.f6988m
                r0.c(r4, r3)
                goto L89
            L29:
                boolean r1 = r0.r
                if (r1 != 0) goto L4a
                int r1 = r0.getCurrentItem()
                com.stepos.common.widget.ScrollTextView$j r4 = r0.f6994t
                int r4 = r4.f7005a
                if (r1 <= r4) goto L4a
                int r1 = r0.getCurrentItem()
                int r4 = r4 - r1
                int r1 = r0.getItemHeight()
                int r1 = r1 * r4
                int r4 = r0.f6990o
                int r1 = r1 + r4
                com.stepos.common.widget.ScrollTextView$k r0 = r0.f6988m
                r0.c(r1, r3)
                goto L89
            L4a:
                int r1 = r0.f6990o
                int r1 = java.lang.Math.abs(r1)
                int r4 = r0.getItemHeight()
                int r4 = r4 / r2
                if (r1 <= r4) goto L74
                int r1 = r0.f6990o
                if (r1 <= 0) goto L64
                int r1 = r0.getItemHeight()
                int r1 = -r1
                int r4 = r0.f6990o
            L62:
                int r1 = r1 + r4
                goto L6e
            L64:
                if (r1 >= 0) goto L6d
                int r1 = r0.getItemHeight()
                int r4 = r0.f6990o
                goto L62
            L6d:
                r1 = r3
            L6e:
                com.stepos.common.widget.ScrollTextView$k r0 = r0.f6988m
                r0.c(r1, r3)
                goto L89
            L74:
                int r1 = r0.f6990o
                if (r1 == 0) goto L89
                com.stepos.common.widget.ScrollTextView$k r4 = r0.f6988m
                int r5 = java.lang.Math.abs(r1)
                int r5 = r5 * 650
                int r0 = r0.getItemHeight()
                int r0 = r0 / r2
                int r5 = r5 / r0
                r4.c(r1, r5)
            L89:
                com.stepos.common.widget.ScrollTextView$d r6 = r6.h
                r6.removeMessages(r3)
                r0 = 1
                r6.removeMessages(r0)
                r6.removeMessages(r2)
                r6.sendEmptyMessage(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.ScrollTextView.k.b():void");
        }

        public final void c(int i10, int i11) {
            this.f7011d.forceFinished(true);
            this.f7012e = 0;
            Scroller scroller = this.f7011d;
            if (i11 == 0) {
                i11 = 650;
            }
            scroller.startScroll(0, 0, 0, i10, i11);
            d dVar = this.h;
            dVar.removeMessages(0);
            dVar.removeMessages(1);
            dVar.removeMessages(2);
            dVar.sendEmptyMessage(0);
            d();
        }

        public final void d() {
            if (this.f7014g) {
                return;
            }
            this.f7014g = true;
            ScrollTextView scrollTextView = ScrollTextView.this;
            scrollTextView.f6989n = true;
            scrollTextView.removeCallbacks(scrollTextView.M);
            Iterator it = scrollTextView.O.iterator();
            while (it.hasNext()) {
                ((h) it.next()).getClass();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public Thread f7017a;

        /* renamed from: b, reason: collision with root package name */
        public Handler f7018b;

        /* renamed from: c, reason: collision with root package name */
        public Looper f7019c;

        /* renamed from: d, reason: collision with root package name */
        public SoundPool f7020d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f7021e;

        /* renamed from: f, reason: collision with root package name */
        public int f7022f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f7023g;
        public int h;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class m {

        /* renamed from: a, reason: collision with root package name */
        public int f7024a;

        /* renamed from: b, reason: collision with root package name */
        public int f7025b;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class n implements f {
        public n() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.f
        public final void onChanged() {
            int i10 = ScrollTextView.R;
            l8.a.e(ScrollTextView.this, 21000, 6);
        }
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        Paint paint = new Paint(1);
        this.f6980a = paint;
        this.f6981b = 0;
        this.f6982c = 5;
        this.f6983d = 0.0f;
        this.f6984e = 0.0f;
        this.r = false;
        this.z = true;
        this.F = true;
        this.H = 0.0f;
        this.I = true;
        this.K = 30.0f;
        this.L = 0.98f;
        this.M = new a();
        LinkedList linkedList = new LinkedList();
        this.N = linkedList;
        this.O = new LinkedList();
        this.P = new LinkedList();
        b bVar = new b();
        this.Q = context;
        this.D = new ArrayList();
        this.f6988m = new k(getContext(), bVar);
        this.f6987l = context.getResources().getDimension(R.dimen.mc_picker_selected_number_size);
        this.f6986k = context.getResources().getDimension(R.dimen.mc_picker_normal_number_size);
        this.f6983d = context.getResources().getDimension(R.dimen.mc_picker_select_item_height);
        float dimension = context.getResources().getDimension(R.dimen.mc_picker_normal_item_height);
        this.f6984e = dimension;
        l(this.f6987l, this.f6986k, this.f6983d, dimension);
        this.h = context.getResources().getColor(R.color.fd_sys_color_on_surface_default);
        int color = context.getResources().getColor(R.color.fd_sys_color_on_surface_variant_default);
        this.f6985j = color;
        j(this.h, color);
        this.f6994t = new j();
        this.f6997w = new Matrix();
        this.f6996v = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, context.getResources().getColor(R.color.fd_sys_color_surface_container_lowest_default), 16777215, Shader.TileMode.CLAMP);
        Paint paint2 = new Paint();
        this.f6998x = paint2;
        paint2.setShader(this.f6996v);
        this.f6999y = context.getResources().getDimension(R.dimen.mc_picker_fading_height);
        m mVar = new m();
        mVar.f7024a = 0;
        mVar.f7025b = 0;
        this.f6992q = mVar;
        paint.setTextAlign(Paint.Align.CENTER);
        e();
        l lVar = new l();
        lVar.f7017a = null;
        lVar.f7018b = null;
        lVar.f7019c = null;
        this.G = lVar;
        linkedList.add(new i());
        linkedList.add(new n());
        paint.setAntiAlias(true);
    }

    public static void c(ScrollTextView scrollTextView, int i10) {
        if (!scrollTextView.r) {
            if (scrollTextView.f6981b == scrollTextView.getScrollStartItem()) {
                int i11 = scrollTextView.f6990o;
                if (i11 + i10 > 0) {
                    i10 = -i11;
                }
                if (i10 == 0) {
                    return;
                }
            } else if (scrollTextView.f6981b == scrollTextView.getScrollEndItem()) {
                int i12 = scrollTextView.f6990o;
                if (i12 + i10 < 0) {
                    i10 = -i12;
                }
                if (i10 == 0) {
                    return;
                }
            }
        }
        int i13 = scrollTextView.f6994t.f7006b;
        if (i13 == 1) {
            scrollTextView.f6990o = 0;
        } else {
            scrollTextView.f6990o += i10;
        }
        int itemHeight = scrollTextView.getItemHeight();
        int scrollEndItem = scrollTextView.f6990o / itemHeight;
        int scrollEndItem2 = scrollTextView.f6981b - scrollEndItem;
        if (scrollTextView.r && i13 > 0) {
            while (scrollEndItem2 < 0) {
                scrollEndItem2 += i13;
            }
            scrollEndItem2 %= i13;
        } else if (scrollEndItem2 < scrollTextView.getScrollStartItem()) {
            scrollEndItem = scrollTextView.f6981b - scrollTextView.getScrollStartItem();
            scrollEndItem2 = scrollTextView.getScrollStartItem();
        } else if (scrollEndItem2 > scrollTextView.getScrollEndItem()) {
            scrollEndItem = scrollTextView.f6981b - scrollTextView.getScrollEndItem();
            scrollEndItem2 = scrollTextView.getScrollEndItem();
        } else if (scrollEndItem2 != scrollTextView.getScrollEndItem()) {
            scrollTextView.getScrollStartItem();
        }
        int i14 = scrollTextView.f6990o;
        if (scrollEndItem2 != scrollTextView.f6981b) {
            scrollTextView.h(scrollEndItem2, false);
        } else {
            scrollTextView.invalidate();
        }
        int i15 = i14 - (scrollEndItem * itemHeight);
        scrollTextView.f6990o = i15;
        if (i15 <= scrollTextView.getHeight() || scrollTextView.getHeight() == 0) {
            return;
        }
        scrollTextView.f6990o = scrollTextView.getHeight() + (scrollTextView.f6990o % scrollTextView.getHeight());
    }

    private m getItemsRange() {
        if (getItemHeight() == 0) {
            return null;
        }
        int i10 = this.f6981b;
        int iAsin = 1;
        while (true) {
            int i11 = iAsin + 2;
            if (getItemHeight() * i11 >= getHeight()) {
                break;
            }
            i10--;
            iAsin = i11;
        }
        int i12 = this.f6990o;
        if (i12 != 0) {
            if (i12 > 0) {
                i10--;
            }
            int itemHeight = i12 / getItemHeight();
            i10 -= itemHeight;
            iAsin = (int) (Math.asin(itemHeight) + iAsin + 1);
        }
        m mVar = this.f6992q;
        mVar.f7024a = i10;
        mVar.f7025b = iAsin;
        return mVar;
    }

    private int getScrollEndItem() {
        int i10 = this.f6994t.f7006b;
        if (this.r) {
            return 0;
        }
        return i10 <= this.f6982c ? i10 - 1 : i10 - 1;
    }

    private int getScrollStartItem() {
        int i10 = this.f6994t.f7006b;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYScrollEnd() {
        if (this.r) {
            return Integer.MAX_VALUE;
        }
        return this.f6990o + ((int) ((getScrollEndItem() - getCurrentItem()) * this.f6984e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYScrollStart() {
        if (this.r) {
            return -2147483647;
        }
        return this.f6990o + ((int) ((getScrollStartItem() - getCurrentItem()) * this.f6984e));
    }

    private void setViewAdapter(j jVar) {
        this.f6994t = jVar;
        invalidate();
    }

    public final void d(h hVar) {
        this.O.add(hVar);
    }

    public final void e() {
        float f8 = this.f6987l;
        Paint paint = this.f6980a;
        paint.setTextSize(f8);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        this.A = (fontMetricsInt.bottom + fontMetricsInt.top) / 2.0f;
        paint.setTextSize(this.f6986k);
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        this.B = (fontMetricsInt2.bottom + fontMetricsInt2.top) / 2.0f;
    }

    public final void f(int i10) {
        g(i10, this.f6981b, i10 - 1);
    }

    public final void g(int i10, int i11, int i12) {
        e eVar;
        k kVar = this.f6988m;
        if (kVar != null) {
            kVar.f7011d.forceFinished(true);
        }
        if (i10 < 0) {
            return;
        }
        j jVar = this.f6994t;
        jVar.f7005a = i12;
        jVar.f7006b = i10;
        setViewAdapter(jVar);
        int i13 = this.f6981b;
        if (i11 != i13) {
            int iMax = Math.max(i11, 0);
            this.f6981b = iMax;
            if (iMax > i12 || iMax >= i10) {
                this.f6981b = Math.min(i12, i10);
            }
        }
        int i14 = this.f6981b;
        if (i13 != i14 && (eVar = this.f6995u) != null) {
            eVar.b(i14);
        }
        invalidate();
    }

    public int getCurrentItem() {
        return this.f6981b;
    }

    public e getIDataAdapter() {
        return this.f6995u;
    }

    public int getItemHeight() {
        return (int) this.f6984e;
    }

    public int getItemsCount() {
        return this.f6994t.f7006b;
    }

    public int getSelectedItemHeight() {
        return (int) this.f6983d;
    }

    public j getViewAdapter() {
        return this.f6994t;
    }

    public int getVisibleItems() {
        return this.f6982c;
    }

    public final void h(int i10, boolean z) {
        int i11;
        int iMin;
        j jVar = this.f6994t;
        if (jVar == null || (i11 = jVar.f7006b) == 0) {
            return;
        }
        if (i10 < 0 || i10 >= i11) {
            if (!this.r) {
                return;
            }
            while (i10 < 0) {
                i10 += i11;
            }
            i10 %= i11;
        }
        int i12 = this.f6981b;
        if (i10 != i12) {
            if (z) {
                int i13 = i10 - i12;
                if (this.r && (iMin = (Math.min(i10, i12) + i11) - Math.max(i10, this.f6981b)) < Math.abs(i13)) {
                    i13 = i13 < 0 ? iMin : -iMin;
                }
                this.f6988m.c((getItemHeight() * i13) + this.f6990o, 0);
                return;
            }
            this.f6990o = 0;
            this.f6981b = i10;
            Iterator it = this.N.iterator();
            while (it.hasNext()) {
                ((f) it.next()).onChanged();
            }
            invalidate();
        }
    }

    public final void i(e eVar, int i10, int i11, int i12, int i13, boolean z) throws Resources.NotFoundException {
        setIDataAdapter(eVar);
        this.f6982c = i12;
        this.r = z;
        getResources().getDimensionPixelSize(R.dimen.mc_picker_offset_y);
        if (i11 < this.f6982c || i13 + 1 < i11) {
            this.r = false;
        }
        g(i11, i10, i13);
    }

    public final void j(int i10, int i11) {
        this.h = i10;
        this.f6985j = i11;
        this.E = new ArrayList();
        int i12 = this.f6982c - 1;
        for (int i13 = 0; i13 < i12 / 2; i13++) {
            this.E.add(Integer.valueOf(this.f6985j));
        }
        invalidate();
    }

    public final void k(int i10, List<Integer> list) {
        this.h = i10;
        if (list != null && this.E != list) {
            this.f6985j = list.get(0).intValue();
            this.E = new ArrayList();
            int i11 = this.f6982c - 1;
            for (int i12 = 0; i12 < i11 / 2; i12++) {
                int size = list.size();
                if (i12 < size) {
                    this.E.add(list.get(i12));
                } else {
                    this.E.add(list.get(size - 1));
                }
            }
        }
        invalidate();
    }

    public final void l(float f8, float f9, float f10, float f11) {
        this.f6983d = f10;
        this.f6984e = f11;
        this.f6987l = f8;
        this.f6986k = f9;
        this.D = new ArrayList();
        int i10 = this.f6982c - 1;
        for (int i11 = 0; i11 < i10 / 2; i11++) {
            this.D.add(Float.valueOf(this.f6986k));
        }
        e();
        invalidate();
    }

    public final void m(float f8, List<Float> list, float f9, float f10) {
        if (this.f6983d == f9 && this.f6984e == f10 && this.f6987l == f8 && list == null) {
            return;
        }
        this.f6983d = f9;
        this.f6987l = f8;
        this.f6984e = f10;
        if (list != null && this.D != list) {
            this.f6986k = list.get(0).floatValue();
            this.D = new ArrayList();
            int i10 = this.f6982c - 1;
            for (int i11 = 0; i11 < i10 / 2; i11++) {
                int size = list.size();
                if (i11 < size) {
                    this.D.add(list.get(i11));
                } else {
                    this.D.add(list.get(size - 1));
                }
            }
        }
        e();
        invalidate();
    }

    public final void n(float f8, ArrayList arrayList) {
        if (f8 == this.f6987l && arrayList == null) {
            return;
        }
        m(f8, arrayList, this.f6983d, this.f6984e);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        l lVar = this.G;
        if (lVar != null) {
            Context context = this.Q;
            synchronized (lVar) {
                try {
                    if (lVar.f7023g || (!lVar.f7021e && lVar.f7017a == null && lVar.f7020d == null)) {
                        if (context != null) {
                            Context applicationContext = context.getApplicationContext();
                            synchronized (lVar) {
                                try {
                                    if (lVar.f7023g || (lVar.f7017a == null && lVar.f7020d == null)) {
                                        lVar.f7021e = false;
                                        lVar.f7023g = false;
                                        int i10 = lVar.h + 1;
                                        lVar.h = i10;
                                        Thread thread = new Thread(new v(lVar, i10, applicationContext));
                                        thread.setName("ScrollTextView-SoundPool");
                                        lVar.f7017a = thread;
                                        thread.start();
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                } finally {
                }
            }
        }
        post(new c());
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.G;
        if (lVar != null) {
            synchronized (lVar) {
                try {
                    if (!lVar.f7023g) {
                        lVar.f7023g = true;
                        lVar.h++;
                        Handler handler = lVar.f7018b;
                        Looper looper = lVar.f7019c;
                        SoundPool soundPool = lVar.f7020d;
                        int i10 = lVar.f7022f;
                        boolean z = lVar.f7021e;
                        lVar.f7017a = null;
                        lVar.f7019c = null;
                        lVar.f7018b = null;
                        lVar.f7020d = null;
                        lVar.f7022f = 0;
                        lVar.f7021e = false;
                        if (handler != null) {
                            handler.removeCallbacksAndMessages(null);
                            handler.post(new x(z, soundPool, i10, looper));
                        }
                    }
                } finally {
                }
            }
        }
        k kVar = this.f6988m;
        if (kVar != null) {
            d dVar = kVar.h;
            dVar.removeMessages(0);
            dVar.removeMessages(1);
            dVar.removeMessages(2);
        }
        removeCallbacks(this.M);
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
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidthAndState(), (int) (((this.f6982c - 1) * this.f6984e) + this.f6983d));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i10;
        if (isEnabled() && getViewAdapter() != null) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2 && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(this.F);
                }
            } else if (!this.f6989n) {
                int y3 = ((int) motionEvent.getY()) - (getHeight() / 2);
                int itemHeight = (y3 < 0 ? (int) (((this.f6983d / 2.0f) - getItemHeight()) + y3) : (int) (y3 - ((this.f6983d / 2.0f) - getItemHeight()))) / getItemHeight();
                if (itemHeight != 0) {
                    int i11 = this.f6981b + itemHeight;
                    j jVar = this.f6994t;
                    if (jVar != null && (i10 = jVar.f7006b) > 0 && (this.r || (i11 >= 0 && i11 < i10))) {
                        h(i11, true);
                        Iterator it = this.P.iterator();
                        while (it.hasNext()) {
                            ((g) it.next()).a();
                        }
                    }
                }
            }
            k kVar = this.f6988m;
            kVar.getClass();
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                kVar.f7013f = motionEvent.getY();
                kVar.f7011d.forceFinished(true);
                h1.f fVar = ScrollTextView.this.J;
                if (fVar != null && fVar.f9232f) {
                    fVar.f();
                }
                d dVar = kVar.h;
                dVar.removeMessages(0);
                dVar.removeMessages(1);
                dVar.removeMessages(2);
                kVar.a();
            } else if (action2 == 2) {
                int y5 = (int) (motionEvent.getY() - kVar.f7013f);
                if (y5 != 0) {
                    kVar.d();
                    kVar.f7008a.a(y5);
                    kVar.f7013f = motionEvent.getY();
                }
            } else if (action2 == 3) {
                kVar.b();
            }
            if (!kVar.f7010c.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                kVar.b();
            }
        }
        return true;
    }

    public void setCurrentItem(int i10) {
        h(i10, false);
    }

    public void setCyclic(boolean z) {
        this.r = z;
        invalidate();
    }

    public void setFadingHeight(float f8) {
        if (this.f6999y != f8) {
            this.f6999y = f8;
            invalidate();
        }
    }

    public void setFadingShader(Shader shader) {
        this.f6996v = shader;
        this.f6998x.setShader(shader);
        invalidate();
    }

    public void setFadingShaderColor(int i10) {
        this.f6996v = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, i10, 16777215, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.f6998x = paint;
        paint.setShader(this.f6996v);
    }

    public void setHorizontalOffset(int i10) {
        this.f6991p = i10;
    }

    public void setIDataAdapter(e eVar) {
        this.f6995u = eVar;
    }

    public void setInterpolator(Interpolator interpolator) {
        k kVar = this.f6988m;
        kVar.f7011d.forceFinished(true);
        kVar.f7011d = new Scroller(kVar.f7009b, interpolator);
    }

    public void setIsDrawFading(boolean z) {
        this.z = z;
    }

    public void setNormalItemHeight(float f8) {
        l(this.f6987l, this.f6986k, this.f6983d, f8);
    }

    public void setNormalTextColor(int i10) {
        if (this.f6985j == i10) {
            return;
        }
        j(this.h, i10);
    }

    public void setNormalTextSize(float f8) {
        l(this.f6987l, f8, this.f6983d, this.f6984e);
    }

    public void setParentRequestDisallowInterceptTouchEvent(boolean z) {
        this.F = z;
    }

    @Override // android.view.View
    public void setScrollY(int i10) {
        k kVar = this.f6988m;
        int i11 = kVar.f7012e - i10;
        kVar.f7012e = i10;
        kVar.f7008a.a(i11);
    }

    public void setSelectItemHeight(float f8) {
        l(this.f6987l, this.f6986k, f8, this.f6984e);
    }

    public void setSelectTextColor(int i10) {
        if (this.h == i10) {
            return;
        }
        k(i10, this.E);
    }

    public void setSelectTextSize(float f8) {
        l(f8, this.f6986k, this.f6983d, this.f6984e);
    }

    public void setShowMarquee(boolean z) {
        this.I = z;
    }

    public void setTypeface(Typeface typeface) {
        this.f6980a.setTypeface(typeface);
        e();
        invalidate();
    }

    public void setVisibleItems(int i10) {
        this.f6982c = i10;
    }

    public void setNormalTextSize(List<Float> list) {
        if (list != null) {
            m(this.f6987l, list, this.f6983d, this.f6984e);
        }
    }

    public void setNormalTextColor(List<Integer> list) {
        k(this.h, list);
    }
}
