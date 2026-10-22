package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: androidx.core.view.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1318f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13190a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1319g f13191b;

    /* renamed from: c, reason: collision with root package name */
    public final b f13192c;

    /* renamed from: d, reason: collision with root package name */
    public final a f13193d;

    /* renamed from: e, reason: collision with root package name */
    public VelocityTracker f13194e;

    /* renamed from: f, reason: collision with root package name */
    public float f13195f;

    /* renamed from: g, reason: collision with root package name */
    public int f13196g;

    /* renamed from: h, reason: collision with root package name */
    public int f13197h;

    /* renamed from: i, reason: collision with root package name */
    public int f13198i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f13199j;

    /* renamed from: androidx.core.view.f$a */
    public interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10);
    }

    /* renamed from: androidx.core.view.f$b */
    public interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i10);
    }

    public C1318f(Context context, InterfaceC1319g interfaceC1319g) {
        this(context, interfaceC1319g, new b() { // from class: androidx.core.view.d
            @Override // androidx.core.view.C1318f.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i10) {
                C1318f.c(context2, iArr, motionEvent, i10);
            }
        }, new a() { // from class: androidx.core.view.e
            @Override // androidx.core.view.C1318f.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10) {
                return C1318f.f(velocityTracker, motionEvent, i10);
            }
        });
    }

    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = O.c(context, viewConfiguration, motionEvent.getDeviceId(), i10, motionEvent.getSource());
        iArr[1] = O.b(context, viewConfiguration, motionEvent.getDeviceId(), i10, motionEvent.getSource());
    }

    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10) {
        K.a(velocityTracker, motionEvent);
        K.b(velocityTracker, 1000);
        return K.d(velocityTracker, i10);
    }

    public final boolean d(MotionEvent motionEvent, int i10) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f13197h == source && this.f13198i == deviceId && this.f13196g == i10) {
            return false;
        }
        this.f13192c.a(this.f13190a, this.f13199j, motionEvent, i10);
        this.f13197h = source;
        this.f13198i = deviceId;
        this.f13196g = i10;
        return true;
    }

    public final float e(MotionEvent motionEvent, int i10) {
        if (this.f13194e == null) {
            this.f13194e = VelocityTracker.obtain();
        }
        return this.f13193d.a(this.f13194e, motionEvent, i10);
    }

    public void g(MotionEvent motionEvent, int i10) {
        boolean zD = d(motionEvent, i10);
        if (this.f13199j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f13194e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f13194e = null;
                return;
            }
            return;
        }
        float fE = e(motionEvent, i10) * this.f13191b.getScaledScrollFactor();
        float fSignum = Math.signum(fE);
        if (zD || (fSignum != Math.signum(this.f13195f) && fSignum != 0.0f)) {
            this.f13191b.stopDifferentialMotionFling();
        }
        float fAbs = Math.abs(fE);
        int[] iArr = this.f13199j;
        if (fAbs < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r6, Math.min(fE, iArr[1]));
        this.f13195f = this.f13191b.startDifferentialMotionFling(fMax) ? fMax : 0.0f;
    }

    public C1318f(Context context, InterfaceC1319g interfaceC1319g, b bVar, a aVar) {
        this.f13196g = -1;
        this.f13197h = -1;
        this.f13198i = -1;
        this.f13199j = new int[]{Integer.MAX_VALUE, 0};
        this.f13190a = context;
        this.f13191b = interfaceC1319g;
        this.f13192c = bVar;
        this.f13193d = aVar;
    }
}
