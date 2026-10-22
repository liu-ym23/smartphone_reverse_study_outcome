package stepos.support.v7.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes4.dex */
public abstract class W {
    public static final int p = ViewConfiguration.getLongPressTimeout();

    /* renamed from: a, reason: collision with root package name */
    public final int f6597a;
    public final int b;
    public final int c;
    public final k0 e;
    public boolean f;
    public boolean g;
    public MotionEvent h;
    public MotionEvent i;

    /* renamed from: j, reason: collision with root package name */
    public float f6598j;
    public float k;
    public float l;
    public float m;
    public VelocityTracker o;
    public final V d = new V(this);
    public final boolean n = true;

    public W(Context context, k0 k0Var) {
        int touchSlop;
        this.e = k0Var;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            this.b = ViewConfiguration.getMinimumFlingVelocity();
            this.c = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.b = viewConfiguration.getScaledMinimumFlingVelocity();
            this.c = viewConfiguration.getScaledMaximumFlingVelocity();
            touchSlop = scaledTouchSlop;
        }
        this.f6597a = touchSlop * touchSlop;
    }
}
