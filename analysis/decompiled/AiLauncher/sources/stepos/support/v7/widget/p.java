package stepos.support.v7.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes5.dex */
public class p {

    /* renamed from: p, reason: collision with root package name */
    public static final int f41664p = ViewConfiguration.getLongPressTimeout();

    /* renamed from: a, reason: collision with root package name */
    public int f41665a;

    /* renamed from: b, reason: collision with root package name */
    public int f41666b;

    /* renamed from: c, reason: collision with root package name */
    public int f41667c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f41668d;

    /* renamed from: e, reason: collision with root package name */
    public final b f41669e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f41670f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f41671g;

    /* renamed from: h, reason: collision with root package name */
    public MotionEvent f41672h;

    /* renamed from: i, reason: collision with root package name */
    public MotionEvent f41673i;

    /* renamed from: j, reason: collision with root package name */
    public float f41674j;

    /* renamed from: k, reason: collision with root package name */
    public float f41675k;

    /* renamed from: l, reason: collision with root package name */
    public float f41676l;

    /* renamed from: m, reason: collision with root package name */
    public float f41677m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f41678n;

    /* renamed from: o, reason: collision with root package name */
    public VelocityTracker f41679o;

    public interface b {
        boolean onDown(MotionEvent motionEvent);

        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11);

        void onLongPress(MotionEvent motionEvent);

        boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11);

        void onShowPress(MotionEvent motionEvent);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public p(Context context, b bVar) {
        this(context, bVar, null);
    }

    public final void d() {
        this.f41668d.removeMessages(1);
        this.f41668d.removeMessages(2);
        this.f41679o.recycle();
        this.f41679o = null;
        this.f41671g = false;
        this.f41670f = false;
    }

    public final void e() {
        this.f41668d.removeMessages(1);
        this.f41668d.removeMessages(2);
        this.f41671g = false;
        this.f41670f = false;
    }

    public final void f() {
        this.f41670f = true;
        this.f41669e.onLongPress(this.f41672h);
    }

    public final void g(Context context) {
        int touchSlop;
        if (this.f41669e == null) {
            throw new NullPointerException("OnGestureListener must not be null");
        }
        this.f41678n = true;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            this.f41666b = ViewConfiguration.getMinimumFlingVelocity();
            this.f41667c = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.f41666b = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f41667c = viewConfiguration.getScaledMaximumFlingVelocity();
            touchSlop = scaledTouchSlop;
        }
        this.f41665a = touchSlop * touchSlop;
    }

    public boolean h(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f41679o == null) {
            this.f41679o = VelocityTracker.obtain();
        }
        this.f41679o.addMovement(motionEvent);
        int i10 = action & 255;
        boolean zOnFling = false;
        boolean z10 = i10 == 6;
        int actionIndex = z10 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float x10 = 0.0f;
        float y10 = 0.0f;
        for (int i11 = 0; i11 < pointerCount; i11++) {
            if (actionIndex != i11) {
                x10 += motionEvent.getX(i11);
                y10 += motionEvent.getY(i11);
            }
        }
        float f10 = z10 ? pointerCount - 1 : pointerCount;
        float f11 = x10 / f10;
        float f12 = y10 / f10;
        if (i10 == 0) {
            this.f41674j = f11;
            this.f41676l = f11;
            this.f41675k = f12;
            this.f41677m = f12;
            MotionEvent motionEvent2 = this.f41672h;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.f41672h = MotionEvent.obtain(motionEvent);
            this.f41671g = true;
            this.f41670f = false;
            if (this.f41678n) {
                this.f41668d.removeMessages(2);
                this.f41668d.sendEmptyMessageAtTime(2, SystemClock.uptimeMillis() + 150 + f41664p);
            }
            this.f41668d.sendEmptyMessageAtTime(1, this.f41672h.getDownTime() + 150);
            return this.f41669e.onDown(motionEvent);
        }
        if (i10 == 1) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            if (this.f41670f) {
                this.f41670f = false;
            } else if (this.f41671g) {
                zOnFling = this.f41669e.onSingleTapUp(motionEvent);
            } else {
                VelocityTracker velocityTracker = this.f41679o;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker.computeCurrentVelocity(1000, this.f41667c);
                float yVelocity = velocityTracker.getYVelocity(pointerId);
                float xVelocity = velocityTracker.getXVelocity(pointerId);
                if (Math.abs(yVelocity) > this.f41666b || Math.abs(xVelocity) > this.f41666b) {
                    zOnFling = this.f41669e.onFling(this.f41672h, motionEvent, xVelocity, yVelocity);
                }
            }
            MotionEvent motionEvent3 = this.f41673i;
            if (motionEvent3 != null) {
                motionEvent3.recycle();
            }
            this.f41673i = motionEventObtain;
            VelocityTracker velocityTracker2 = this.f41679o;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f41679o = null;
            }
            this.f41668d.removeMessages(1);
            this.f41668d.removeMessages(2);
            return zOnFling;
        }
        if (i10 == 2) {
            float f13 = this.f41674j - f11;
            float f14 = this.f41675k - f12;
            if (this.f41671g) {
                int i12 = (int) (f11 - this.f41676l);
                int i13 = (int) (f12 - this.f41677m);
                if ((i12 * i12) + (i13 * i13) > this.f41665a) {
                    boolean zOnScroll = this.f41669e.onScroll(this.f41672h, motionEvent, f13, f14);
                    this.f41674j = f11;
                    this.f41675k = f12;
                    this.f41671g = false;
                    this.f41668d.removeMessages(1);
                    this.f41668d.removeMessages(2);
                    return zOnScroll;
                }
            } else if (Math.abs(f13) >= 1.0f || Math.abs(f14) >= 1.0f) {
                boolean zOnScroll2 = this.f41669e.onScroll(this.f41672h, motionEvent, f13, f14);
                this.f41674j = f11;
                this.f41675k = f12;
                return zOnScroll2;
            }
        } else {
            if (i10 == 3) {
                d();
                return false;
            }
            if (i10 == 5) {
                this.f41674j = f11;
                this.f41676l = f11;
                this.f41675k = f12;
                this.f41677m = f12;
                e();
                return false;
            }
            if (i10 == 6) {
                this.f41674j = f11;
                this.f41676l = f11;
                this.f41675k = f12;
                this.f41677m = f12;
                this.f41679o.computeCurrentVelocity(1000, this.f41667c);
                int actionIndex2 = motionEvent.getActionIndex();
                int pointerId2 = motionEvent.getPointerId(actionIndex2);
                float xVelocity2 = this.f41679o.getXVelocity(pointerId2);
                float yVelocity2 = this.f41679o.getYVelocity(pointerId2);
                for (int i14 = 0; i14 < pointerCount; i14++) {
                    if (i14 != actionIndex2) {
                        int pointerId3 = motionEvent.getPointerId(i14);
                        if ((this.f41679o.getXVelocity(pointerId3) * xVelocity2) + (this.f41679o.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                            this.f41679o.clear();
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                p.this.f41669e.onShowPress(p.this.f41672h);
            } else {
                if (i10 == 2) {
                    p.this.f();
                    return;
                }
                throw new RuntimeException("Unknown message " + message);
            }
        }

        public a(Handler handler) {
            super(handler.getLooper());
        }
    }

    public p(Context context, b bVar, Handler handler) {
        if (handler != null) {
            this.f41668d = new a(handler);
        } else {
            this.f41668d = new a();
        }
        this.f41669e = bVar;
        g(context);
    }
}
