package stepos.support.v7.widget;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import stepos.support.v7.widget.StepOSRecyclerView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class r {

    /* renamed from: p, reason: collision with root package name */
    public static final int f12827p = ViewConfiguration.getLongPressTimeout();

    /* renamed from: a, reason: collision with root package name */
    public final int f12828a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12829b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12830c;

    /* renamed from: e, reason: collision with root package name */
    public final StepOSRecyclerView.h f12832e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12833f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12834g;
    public MotionEvent h;

    /* renamed from: i, reason: collision with root package name */
    public MotionEvent f12835i;

    /* renamed from: j, reason: collision with root package name */
    public float f12836j;

    /* renamed from: k, reason: collision with root package name */
    public float f12837k;

    /* renamed from: l, reason: collision with root package name */
    public float f12838l;

    /* renamed from: m, reason: collision with root package name */
    public float f12839m;

    /* renamed from: o, reason: collision with root package name */
    public VelocityTracker f12841o;

    /* renamed from: d, reason: collision with root package name */
    public final a f12831d = new a();

    /* renamed from: n, reason: collision with root package name */
    public final boolean f12840n = true;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends Handler {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:69:0x014c  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void handleMessage(android.os.Message r11) {
            /*
                Method dump skipped, instructions count: 528
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.r.a.handleMessage(android.os.Message):void");
        }
    }

    public r(Context context, StepOSRecyclerView.h hVar) {
        int touchSlop;
        this.f12832e = hVar;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            this.f12829b = ViewConfiguration.getMinimumFlingVelocity();
            this.f12830c = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.f12829b = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f12830c = viewConfiguration.getScaledMaximumFlingVelocity();
            touchSlop = scaledTouchSlop;
        }
        this.f12828a = touchSlop * touchSlop;
    }
}
