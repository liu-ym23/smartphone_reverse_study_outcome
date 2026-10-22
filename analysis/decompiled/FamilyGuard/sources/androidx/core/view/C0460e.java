package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: androidx.core.view.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0460e {

    /* renamed from: a, reason: collision with root package name */
    private final Context f9803a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0461f f9804b;

    /* renamed from: c, reason: collision with root package name */
    private final b f9805c;

    /* renamed from: d, reason: collision with root package name */
    private final a f9806d;

    /* renamed from: e, reason: collision with root package name */
    private VelocityTracker f9807e;

    /* renamed from: f, reason: collision with root package name */
    private float f9808f;

    /* renamed from: g, reason: collision with root package name */
    private int f9809g;

    /* renamed from: h, reason: collision with root package name */
    private int f9810h;

    /* renamed from: i, reason: collision with root package name */
    private int f9811i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f9812j;

    /* renamed from: androidx.core.view.e$a */
    interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i5);
    }

    /* renamed from: androidx.core.view.e$b */
    interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i5);
    }

    public C0460e(Context context, InterfaceC0461f interfaceC0461f) {
        this(context, interfaceC0461f, new b() { // from class: androidx.core.view.c
            @Override // androidx.core.view.C0460e.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i5) {
                C0460e.c(context2, iArr, motionEvent, i5);
            }
        }, new a() { // from class: androidx.core.view.d
            @Override // androidx.core.view.C0460e.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i5) {
                return C0460e.f(velocityTracker, motionEvent, i5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i5) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = L.g(context, viewConfiguration, motionEvent.getDeviceId(), i5, motionEvent.getSource());
        iArr[1] = L.f(context, viewConfiguration, motionEvent.getDeviceId(), i5, motionEvent.getSource());
    }

    private boolean d(MotionEvent motionEvent, int i5) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f9810h == source && this.f9811i == deviceId && this.f9809g == i5) {
            return false;
        }
        this.f9805c.a(this.f9803a, this.f9812j, motionEvent, i5);
        this.f9810h = source;
        this.f9811i = deviceId;
        this.f9809g = i5;
        return true;
    }

    private float e(MotionEvent motionEvent, int i5) {
        if (this.f9807e == null) {
            this.f9807e = VelocityTracker.obtain();
        }
        return this.f9806d.a(this.f9807e, motionEvent, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i5) {
        E.a(velocityTracker, motionEvent);
        E.b(velocityTracker, 1000);
        return E.d(velocityTracker, i5);
    }

    public void g(MotionEvent motionEvent, int i5) {
        boolean zD = d(motionEvent, i5);
        if (this.f9812j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f9807e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f9807e = null;
                return;
            }
            return;
        }
        float fE = e(motionEvent, i5) * this.f9804b.b();
        float fSignum = Math.signum(fE);
        if (zD || (fSignum != Math.signum(this.f9808f) && fSignum != 0.0f)) {
            this.f9804b.c();
        }
        float fAbs = Math.abs(fE);
        int[] iArr = this.f9812j;
        if (fAbs < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r6, Math.min(fE, iArr[1]));
        this.f9808f = this.f9804b.a(fMax) ? fMax : 0.0f;
    }

    C0460e(Context context, InterfaceC0461f interfaceC0461f, b bVar, a aVar) {
        this.f9809g = -1;
        this.f9810h = -1;
        this.f9811i = -1;
        this.f9812j = new int[]{Integer.MAX_VALUE, 0};
        this.f9803a = context;
        this.f9804b = interfaceC0461f;
        this.f9805c = bVar;
        this.f9806d = aVar;
    }
}
