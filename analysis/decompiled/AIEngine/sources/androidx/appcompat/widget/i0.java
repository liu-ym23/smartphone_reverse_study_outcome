package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class i0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final float f836a;

    /* renamed from: b, reason: collision with root package name */
    public final int f837b;

    /* renamed from: c, reason: collision with root package name */
    public final int f838c;

    /* renamed from: d, reason: collision with root package name */
    public final View f839d;

    /* renamed from: e, reason: collision with root package name */
    public a f840e;
    public b h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f841j;

    /* renamed from: k, reason: collision with root package name */
    public int f842k;

    /* renamed from: l, reason: collision with root package name */
    public final int[] f843l = new int[2];

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewParent parent = i0.this.f839d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            i0 i0Var = i0.this;
            i0Var.a();
            View view = i0Var.f839d;
            if (view.isEnabled() && !view.isLongClickable() && i0Var.c()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                i0Var.f841j = true;
            }
        }
    }

    public i0(View view) {
        this.f839d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f836a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f837b = tapTimeout;
        this.f838c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        b bVar = this.h;
        View view = this.f839d;
        if (bVar != null) {
            view.removeCallbacks(bVar);
        }
        a aVar = this.f840e;
        if (aVar != null) {
            view.removeCallbacks(aVar);
        }
    }

    public abstract l.f b();

    public abstract boolean c();

    public boolean d() {
        l.f fVarB = b();
        if (fVarB == null || !fVarB.isShowing()) {
            return true;
        }
        fVarB.dismiss();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fe  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f841j = false;
        this.f842k = -1;
        a aVar = this.f840e;
        if (aVar != null) {
            this.f839d.removeCallbacks(aVar);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
