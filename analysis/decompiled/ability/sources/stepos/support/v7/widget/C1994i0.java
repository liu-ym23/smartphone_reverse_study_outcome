package stepos.support.v7.widget;

import android.content.Context;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: stepos.support.v7.widget.i0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1994i0 extends W {

    /* renamed from: q, reason: collision with root package name */
    public final k0 f6614q;

    /* renamed from: r, reason: collision with root package name */
    public int f6615r;

    /* renamed from: s, reason: collision with root package name */
    public int f6616s;

    /* renamed from: t, reason: collision with root package name */
    public final int f6617t;
    public int u;

    /* renamed from: v, reason: collision with root package name */
    public VelocityTracker f6618v;

    /* renamed from: w, reason: collision with root package name */
    public final /* synthetic */ StepOSRecyclerView f6619w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1994i0(StepOSRecyclerView stepOSRecyclerView, Context context, k0 k0Var) {
        super(context, k0Var);
        this.f6619w = stepOSRecyclerView;
        this.u = -1;
        this.f6614q = k0Var;
        this.f6617t = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
