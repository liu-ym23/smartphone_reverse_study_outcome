package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class W0 {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1552f1 f16405a;

    /* renamed from: b, reason: collision with root package name */
    public Context f16406b;

    /* renamed from: c, reason: collision with root package name */
    public GestureDetector f16407c;

    /* renamed from: f, reason: collision with root package name */
    public O0 f16410f;

    /* renamed from: d, reason: collision with root package name */
    public int f16408d = 0;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16409e = false;

    /* renamed from: g, reason: collision with root package name */
    public Handler f16411g = new Handler(Looper.getMainLooper());

    public class b implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

        /* renamed from: a, reason: collision with root package name */
        public int f16412a;

        /* renamed from: b, reason: collision with root package name */
        public float f16413b;

        /* renamed from: c, reason: collision with root package name */
        public long f16414c;

        public b() {
            this.f16412a = 0;
            this.f16413b = 0.0f;
            this.f16414c = 0L;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            W0.this.f16407c.setIsLongpressEnabled(false);
            this.f16412a = motionEvent.getPointerCount();
            W0.this.getClass();
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.f16412a < motionEvent.getPointerCount()) {
                this.f16412a = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.f16412a != 1) {
                return false;
            }
            if (action == 0) {
                this.f16413b = motionEvent.getY();
                this.f16414c = SystemClock.uptimeMillis();
                return true;
            }
            if (action == 2) {
                W0.this.f16409e = true;
                if (Math.abs(this.f16413b - motionEvent.getY()) >= 20) {
                    this.f16413b = motionEvent.getY();
                }
                return true;
            }
            W0.this.f16407c.setIsLongpressEnabled(true);
            if (action != 1) {
                W0.this.f16409e = false;
                return true;
            }
            long jUptimeMillis = SystemClock.uptimeMillis() - this.f16414c;
            if (!W0.this.f16409e || jUptimeMillis < 200) {
                W0.this.f16410f.getClass();
                return false;
            }
            W0.this.f16409e = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            W0.this.f16409e = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            W0.this.getClass();
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (W0.this.f16408d == 1) {
                if (W0.this.f16410f != null) {
                    ((F0) W0.this.f16410f).b(motionEvent);
                }
                W0.this.getClass();
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            W0.this.getClass();
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (W0.this.f16408d != 1) {
                return false;
            }
            W0.this.getClass();
            return ((F0) W0.this.f16410f).c(motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    public W0(InterfaceC1552f1 interfaceC1552f1, Context context) {
        this.f16406b = context;
        this.f16405a = interfaceC1552f1;
        b bVar = new b();
        GestureDetector gestureDetector = new GestureDetector(this.f16406b, bVar, this.f16411g);
        this.f16407c = gestureDetector;
        gestureDetector.setOnDoubleTapListener(bVar);
    }

    public void a() {
        this.f16408d = 0;
    }

    public void b(O0 o02) {
        this.f16410f = o02;
    }

    public boolean c(MotionEvent motionEvent) {
        if (this.f16408d < motionEvent.getPointerCount()) {
            this.f16408d = motionEvent.getPointerCount();
        }
        motionEvent.getAction();
        if (motionEvent.getAction() == 6) {
            motionEvent.getPointerCount();
        }
        if (this.f16409e && this.f16408d >= 2) {
            this.f16409e = false;
        }
        try {
            int[] iArr = {0, 0};
            InterfaceC1552f1 interfaceC1552f1 = this.f16405a;
            if (interfaceC1552f1 != null && interfaceC1552f1.x() != null) {
                this.f16405a.x().getLocationOnScreen(iArr);
            }
            return this.f16407c.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
