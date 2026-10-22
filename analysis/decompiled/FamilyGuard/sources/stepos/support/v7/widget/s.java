package stepos.support.v7.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public class s {

    /* renamed from: p, reason: collision with root package name */
    private static final int f22101p = ViewConfiguration.getLongPressTimeout();

    /* renamed from: a, reason: collision with root package name */
    private int f22102a;

    /* renamed from: b, reason: collision with root package name */
    private int f22103b;

    /* renamed from: c, reason: collision with root package name */
    private int f22104c;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f22105d;

    /* renamed from: e, reason: collision with root package name */
    private final b f22106e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f22107f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f22108g;

    /* renamed from: h, reason: collision with root package name */
    private MotionEvent f22109h;

    /* renamed from: i, reason: collision with root package name */
    private MotionEvent f22110i;

    /* renamed from: j, reason: collision with root package name */
    private float f22111j;

    /* renamed from: k, reason: collision with root package name */
    private float f22112k;

    /* renamed from: l, reason: collision with root package name */
    private float f22113l;

    /* renamed from: m, reason: collision with root package name */
    private float f22114m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f22115n;

    /* renamed from: o, reason: collision with root package name */
    private VelocityTracker f22116o;

    public interface b {
        boolean onDown(MotionEvent motionEvent);

        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6);

        void onLongPress(MotionEvent motionEvent);

        boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6);

        void onShowPress(MotionEvent motionEvent);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public s(Context context, b bVar) {
        this(context, bVar, null);
    }

    private void d() {
        this.f22105d.removeMessages(1);
        this.f22105d.removeMessages(2);
        this.f22116o.recycle();
        this.f22116o = null;
        this.f22108g = false;
        this.f22107f = false;
    }

    private void e() {
        this.f22105d.removeMessages(1);
        this.f22105d.removeMessages(2);
        this.f22108g = false;
        this.f22107f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f22107f = true;
        this.f22106e.onLongPress(this.f22109h);
    }

    private void g(Context context) {
        int touchSlop;
        if (this.f22106e == null) {
            throw new NullPointerException("OnGestureListener must not be null");
        }
        this.f22115n = true;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            this.f22103b = ViewConfiguration.getMinimumFlingVelocity();
            this.f22104c = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.f22103b = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f22104c = viewConfiguration.getScaledMaximumFlingVelocity();
            touchSlop = scaledTouchSlop;
        }
        this.f22102a = touchSlop * touchSlop;
    }

    public boolean h(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f22116o == null) {
            this.f22116o = VelocityTracker.obtain();
        }
        this.f22116o.addMovement(motionEvent);
        int i5 = action & 255;
        boolean zOnFling = false;
        boolean z5 = i5 == 6;
        int actionIndex = z5 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float x5 = 0.0f;
        float y5 = 0.0f;
        for (int i6 = 0; i6 < pointerCount; i6++) {
            if (actionIndex != i6) {
                x5 += motionEvent.getX(i6);
                y5 += motionEvent.getY(i6);
            }
        }
        float f5 = z5 ? pointerCount - 1 : pointerCount;
        float f6 = x5 / f5;
        float f7 = y5 / f5;
        if (i5 == 0) {
            this.f22111j = f6;
            this.f22113l = f6;
            this.f22112k = f7;
            this.f22114m = f7;
            MotionEvent motionEvent2 = this.f22109h;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.f22109h = MotionEvent.obtain(motionEvent);
            this.f22108g = true;
            this.f22107f = false;
            if (this.f22115n) {
                this.f22105d.removeMessages(2);
                this.f22105d.sendEmptyMessageAtTime(2, SystemClock.uptimeMillis() + 150 + f22101p);
            }
            this.f22105d.sendEmptyMessageAtTime(1, this.f22109h.getDownTime() + 150);
            return this.f22106e.onDown(motionEvent);
        }
        if (i5 == 1) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            if (this.f22107f) {
                this.f22107f = false;
            } else if (this.f22108g) {
                zOnFling = this.f22106e.onSingleTapUp(motionEvent);
            } else {
                VelocityTracker velocityTracker = this.f22116o;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker.computeCurrentVelocity(1000, this.f22104c);
                float yVelocity = velocityTracker.getYVelocity(pointerId);
                float xVelocity = velocityTracker.getXVelocity(pointerId);
                if (Math.abs(yVelocity) > this.f22103b || Math.abs(xVelocity) > this.f22103b) {
                    zOnFling = this.f22106e.onFling(this.f22109h, motionEvent, xVelocity, yVelocity);
                }
            }
            MotionEvent motionEvent3 = this.f22110i;
            if (motionEvent3 != null) {
                motionEvent3.recycle();
            }
            this.f22110i = motionEventObtain;
            VelocityTracker velocityTracker2 = this.f22116o;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f22116o = null;
            }
            this.f22105d.removeMessages(1);
            this.f22105d.removeMessages(2);
            return zOnFling;
        }
        if (i5 == 2) {
            float f8 = this.f22111j - f6;
            float f9 = this.f22112k - f7;
            if (this.f22108g) {
                int i7 = (int) (f6 - this.f22113l);
                int i8 = (int) (f7 - this.f22114m);
                if ((i7 * i7) + (i8 * i8) > this.f22102a) {
                    boolean zOnScroll = this.f22106e.onScroll(this.f22109h, motionEvent, f8, f9);
                    this.f22111j = f6;
                    this.f22112k = f7;
                    this.f22108g = false;
                    this.f22105d.removeMessages(1);
                    this.f22105d.removeMessages(2);
                    return zOnScroll;
                }
            } else if (Math.abs(f8) >= 1.0f || Math.abs(f9) >= 1.0f) {
                boolean zOnScroll2 = this.f22106e.onScroll(this.f22109h, motionEvent, f8, f9);
                this.f22111j = f6;
                this.f22112k = f7;
                return zOnScroll2;
            }
        } else {
            if (i5 == 3) {
                d();
                return false;
            }
            if (i5 == 5) {
                this.f22111j = f6;
                this.f22113l = f6;
                this.f22112k = f7;
                this.f22114m = f7;
                e();
                return false;
            }
            if (i5 == 6) {
                this.f22111j = f6;
                this.f22113l = f6;
                this.f22112k = f7;
                this.f22114m = f7;
                this.f22116o.computeCurrentVelocity(1000, this.f22104c);
                int actionIndex2 = motionEvent.getActionIndex();
                int pointerId2 = motionEvent.getPointerId(actionIndex2);
                float xVelocity2 = this.f22116o.getXVelocity(pointerId2);
                float yVelocity2 = this.f22116o.getYVelocity(pointerId2);
                for (int i9 = 0; i9 < pointerCount; i9++) {
                    if (i9 != actionIndex2) {
                        int pointerId3 = motionEvent.getPointerId(i9);
                        if ((this.f22116o.getXVelocity(pointerId3) * xVelocity2) + (this.f22116o.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                            this.f22116o.clear();
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    private class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == 1) {
                s.this.f22106e.onShowPress(s.this.f22109h);
            } else {
                if (i5 == 2) {
                    s.this.f();
                    return;
                }
                throw new RuntimeException("Unknown message " + message);
            }
        }

        a(Handler handler) {
            super(handler.getLooper());
        }
    }

    public s(Context context, b bVar, Handler handler) {
        if (handler != null) {
            this.f22105d = new a(handler);
        } else {
            this.f22105d = new a();
        }
        this.f22106e = bVar;
        g(context);
    }
}
