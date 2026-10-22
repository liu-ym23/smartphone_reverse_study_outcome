package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import j.InterfaceC4741f;

/* loaded from: classes.dex */
public abstract class E implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final float f8888a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8889b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8890c;

    /* renamed from: d, reason: collision with root package name */
    public final View f8891d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f8892e;

    /* renamed from: f, reason: collision with root package name */
    public Runnable f8893f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8894g;

    /* renamed from: h, reason: collision with root package name */
    public int f8895h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f8896i = new int[2];

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = E.this.f8891d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            E.this.e();
        }
    }

    public E(View view) {
        this.f8891d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f8888a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f8889b = tapTimeout;
        this.f8890c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View view, float f10, float f11, float f12) {
        float f13 = -f12;
        return f10 >= f13 && f11 >= f13 && f10 < ((float) (view.getRight() - view.getLeft())) + f12 && f11 < ((float) (view.getBottom() - view.getTop())) + f12;
    }

    public final void a() {
        Runnable runnable = this.f8893f;
        if (runnable != null) {
            this.f8891d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f8892e;
        if (runnable2 != null) {
            this.f8891d.removeCallbacks(runnable2);
        }
    }

    public abstract InterfaceC4741f b();

    public abstract boolean c();

    public boolean d() {
        InterfaceC4741f interfaceC4741fB = b();
        if (interfaceC4741fB == null || !interfaceC4741fB.isShowing()) {
            return true;
        }
        interfaceC4741fB.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f8891d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f8894g = true;
        }
    }

    public final boolean f(MotionEvent motionEvent) {
        C c10;
        View view = this.f8891d;
        InterfaceC4741f interfaceC4741fB = b();
        if (interfaceC4741fB != null && interfaceC4741fB.isShowing() && (c10 = (C) interfaceC4741fB.n()) != null && c10.isShown()) {
            MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            i(view, motionEventObtainNoHistory);
            j(c10, motionEventObtainNoHistory);
            boolean zE = c10.e(motionEventObtainNoHistory, this.f8895h);
            motionEventObtainNoHistory.recycle();
            int actionMasked = motionEvent.getActionMasked();
            boolean z10 = (actionMasked == 1 || actionMasked == 3) ? false : true;
            if (zE && z10) {
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
    public final boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f8891d
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
            int r1 = r5.f8895h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f8888a
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
            r5.f8895h = r6
            java.lang.Runnable r6 = r5.f8892e
            if (r6 != 0) goto L52
            androidx.appcompat.widget.E$a r6 = new androidx.appcompat.widget.E$a
            r6.<init>()
            r5.f8892e = r6
        L52:
            java.lang.Runnable r6 = r5.f8892e
            int r1 = r5.f8889b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f8893f
            if (r6 != 0) goto L65
            androidx.appcompat.widget.E$b r6 = new androidx.appcompat.widget.E$b
            r6.<init>()
            r5.f8893f = r6
        L65:
            java.lang.Runnable r6 = r5.f8893f
            int r5 = r5.f8890c
            long r3 = (long) r5
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.E.g(android.view.MotionEvent):boolean");
    }

    public final boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f8896i);
        motionEvent.offsetLocation(r1[0], r1[1]);
        return true;
    }

    public final boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f8896i);
        motionEvent.offsetLocation(-r1[0], -r1[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = this.f8894g;
        if (z11) {
            z10 = f(motionEvent) || !d();
        } else {
            z10 = g(motionEvent) && c();
            if (z10) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f8891d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f8894g = z10;
        return z10 || z11;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f8894g = false;
        this.f8895h = -1;
        Runnable runnable = this.f8892e;
        if (runnable != null) {
            this.f8891d.removeCallbacks(runnable);
        }
    }
}
