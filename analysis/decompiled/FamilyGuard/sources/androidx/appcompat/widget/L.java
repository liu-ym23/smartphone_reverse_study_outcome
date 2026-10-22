package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import l.InterfaceC0820e;

/* loaded from: classes.dex */
public abstract class L implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final float f8163a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8164b;

    /* renamed from: c, reason: collision with root package name */
    private final int f8165c;

    /* renamed from: d, reason: collision with root package name */
    final View f8166d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f8167e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f8168f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8169g;

    /* renamed from: h, reason: collision with root package name */
    private int f8170h;

    /* renamed from: i, reason: collision with root package name */
    private final int[] f8171i = new int[2];

    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = L.this.f8166d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            L.this.e();
        }
    }

    public L(View view) {
        this.f8166d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f8163a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f8164b = tapTimeout;
        this.f8165c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f8168f;
        if (runnable != null) {
            this.f8166d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f8167e;
        if (runnable2 != null) {
            this.f8166d.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        J j5;
        View view = this.f8166d;
        InterfaceC0820e interfaceC0820eB = b();
        if (interfaceC0820eB != null && interfaceC0820eB.h() && (j5 = (J) interfaceC0820eB.m()) != null && j5.isShown()) {
            MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            i(view, motionEventObtainNoHistory);
            j(j5, motionEventObtainNoHistory);
            boolean zE = j5.e(motionEventObtainNoHistory, this.f8170h);
            motionEventObtainNoHistory.recycle();
            int actionMasked = motionEvent.getActionMasked();
            boolean z5 = (actionMasked == 1 || actionMasked == 3) ? false : true;
            if (zE && z5) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f8166d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f8170h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f8163a
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r5 = r0.getParent()
            r5.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f8170h = r6
            java.lang.Runnable r6 = r5.f8167e
            if (r6 != 0) goto L52
            androidx.appcompat.widget.L$a r6 = new androidx.appcompat.widget.L$a
            r6.<init>()
            r5.f8167e = r6
        L52:
            java.lang.Runnable r6 = r5.f8167e
            int r1 = r5.f8164b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f8168f
            if (r6 != 0) goto L65
            androidx.appcompat.widget.L$b r6 = new androidx.appcompat.widget.L$b
            r6.<init>()
            r5.f8168f = r6
        L65:
            java.lang.Runnable r6 = r5.f8168f
            int r5 = r5.f8165c
            long r3 = (long) r5
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.L.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f5, float f6, float f7) {
        float f8 = -f7;
        return f5 >= f8 && f6 >= f8 && f5 < ((float) (view.getRight() - view.getLeft())) + f7 && f6 < ((float) (view.getBottom() - view.getTop())) + f7;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f8171i);
        motionEvent.offsetLocation(r1[0], r1[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f8171i);
        motionEvent.offsetLocation(-r1[0], -r1[1]);
        return true;
    }

    public abstract InterfaceC0820e b();

    protected abstract boolean c();

    protected boolean d() {
        InterfaceC0820e interfaceC0820eB = b();
        if (interfaceC0820eB == null || !interfaceC0820eB.h()) {
            return true;
        }
        interfaceC0820eB.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f8166d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f8169g = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z5;
        boolean z6 = this.f8169g;
        if (z6) {
            z5 = f(motionEvent) || !d();
        } else {
            z5 = g(motionEvent) && c();
            if (z5) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f8166d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f8169g = z5;
        return z5 || z6;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f8169g = false;
        this.f8170h = -1;
        Runnable runnable = this.f8167e;
        if (runnable != null) {
            this.f8166d.removeCallbacks(runnable);
        }
    }
}
