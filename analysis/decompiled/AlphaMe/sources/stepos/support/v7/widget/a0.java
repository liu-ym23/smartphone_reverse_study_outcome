package stepos.support.v7.widget;

import android.content.Context;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes2.dex */
public final class a0 extends P {

    /* renamed from: q, reason: collision with root package name */
    public final c0 f15063q;

    /* renamed from: r, reason: collision with root package name */
    public int f15064r;

    /* renamed from: s, reason: collision with root package name */
    public int f15065s;

    /* renamed from: t, reason: collision with root package name */
    public final int f15066t;

    /* renamed from: u, reason: collision with root package name */
    public int f15067u;

    /* renamed from: v, reason: collision with root package name */
    public VelocityTracker f15068v;

    /* renamed from: w, reason: collision with root package name */
    public final /* synthetic */ StepOSRecyclerView f15069w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(StepOSRecyclerView stepOSRecyclerView, Context context, c0 c0Var) {
        super(context, c0Var);
        this.f15069w = stepOSRecyclerView;
        this.f15067u = -1;
        this.f15063q = c0Var;
        this.f15066t = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
