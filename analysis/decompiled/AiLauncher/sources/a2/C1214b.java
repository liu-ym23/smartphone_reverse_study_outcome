package a2;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: a2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1214b {

    /* renamed from: a, reason: collision with root package name */
    public int f7868a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f7869b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final ScaleGestureDetector f7870c;

    /* renamed from: d, reason: collision with root package name */
    public VelocityTracker f7871d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7872e;

    /* renamed from: f, reason: collision with root package name */
    public float f7873f;

    /* renamed from: g, reason: collision with root package name */
    public float f7874g;

    /* renamed from: h, reason: collision with root package name */
    public final float f7875h;

    /* renamed from: i, reason: collision with root package name */
    public final float f7876i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC1215c f7877j;

    /* renamed from: a2.b$a */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            C1214b.this.f7877j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public C1214b(Context context, InterfaceC1215c interfaceC1215c) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7876i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7875h = viewConfiguration.getScaledTouchSlop();
        this.f7877j = interfaceC1215c;
        this.f7870c = new ScaleGestureDetector(context, new a());
    }

    public final float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f7869b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    public final float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f7869b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean d() {
        return this.f7872e;
    }

    public boolean e() {
        return this.f7870c.isInProgress();
    }

    public boolean f(MotionEvent motionEvent) {
        try {
            this.f7870c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public final boolean g(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f7868a = motionEvent.getPointerId(0);
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            this.f7871d = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(motionEvent);
            }
            this.f7873f = b(motionEvent);
            this.f7874g = c(motionEvent);
            this.f7872e = false;
        } else if (action == 1) {
            this.f7868a = -1;
            if (this.f7872e && this.f7871d != null) {
                this.f7873f = b(motionEvent);
                this.f7874g = c(motionEvent);
                this.f7871d.addMovement(motionEvent);
                this.f7871d.computeCurrentVelocity(1000);
                float xVelocity = this.f7871d.getXVelocity();
                float yVelocity = this.f7871d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f7876i) {
                    this.f7877j.onFling(this.f7873f, this.f7874g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f7871d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f7871d = null;
            }
        } else if (action == 2) {
            float fB = b(motionEvent);
            float fC = c(motionEvent);
            float f10 = fB - this.f7873f;
            float f11 = fC - this.f7874g;
            if (!this.f7872e) {
                this.f7872e = Math.sqrt((double) ((f10 * f10) + (f11 * f11))) >= ((double) this.f7875h);
            }
            if (this.f7872e) {
                this.f7877j.onDrag(f10, f11);
                this.f7873f = fB;
                this.f7874g = fC;
                VelocityTracker velocityTracker2 = this.f7871d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f7868a = -1;
            VelocityTracker velocityTracker3 = this.f7871d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f7871d = null;
            }
        } else if (action == 6) {
            int iB = C1225m.b(motionEvent.getAction());
            if (motionEvent.getPointerId(iB) == this.f7868a) {
                int i10 = iB == 0 ? 1 : 0;
                this.f7868a = motionEvent.getPointerId(i10);
                this.f7873f = motionEvent.getX(i10);
                this.f7874g = motionEvent.getY(i10);
            }
        }
        int i11 = this.f7868a;
        this.f7869b = motionEvent.findPointerIndex(i11 != -1 ? i11 : 0);
        return true;
    }
}
