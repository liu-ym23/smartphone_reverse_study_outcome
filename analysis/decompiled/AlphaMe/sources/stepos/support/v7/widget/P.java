package stepos.support.v7.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import f0.HandlerC0555a;

/* loaded from: classes2.dex */
public abstract class P {

    /* renamed from: p, reason: collision with root package name */
    public static final int f14838p = ViewConfiguration.getLongPressTimeout();

    /* renamed from: a, reason: collision with root package name */
    public final int f14839a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14840b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14841c;

    /* renamed from: e, reason: collision with root package name */
    public final O f14843e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14844f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14845g;

    /* renamed from: h, reason: collision with root package name */
    public MotionEvent f14846h;

    /* renamed from: i, reason: collision with root package name */
    public MotionEvent f14847i;

    /* renamed from: j, reason: collision with root package name */
    public float f14848j;

    /* renamed from: k, reason: collision with root package name */
    public float f14849k;

    /* renamed from: l, reason: collision with root package name */
    public float f14850l;

    /* renamed from: m, reason: collision with root package name */
    public float f14851m;

    /* renamed from: o, reason: collision with root package name */
    public VelocityTracker f14853o;

    /* renamed from: d, reason: collision with root package name */
    public final HandlerC0555a f14842d = new HandlerC0555a(this);

    /* renamed from: n, reason: collision with root package name */
    public final boolean f14852n = true;

    public P(Context context, O o4) {
        int touchSlop;
        this.f14843e = o4;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            this.f14840b = ViewConfiguration.getMinimumFlingVelocity();
            this.f14841c = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.f14840b = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f14841c = viewConfiguration.getScaledMaximumFlingVelocity();
            touchSlop = scaledTouchSlop;
        }
        this.f14839a = touchSlop * touchSlop;
    }
}
