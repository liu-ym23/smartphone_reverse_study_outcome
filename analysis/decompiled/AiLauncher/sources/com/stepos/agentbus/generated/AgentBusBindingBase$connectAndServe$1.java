package com.stepos.agentbus.generated;

import com.stepos.launcher.assistant.slidepanel.MinusOneTransitionSpec;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {MinusOneTransitionSpec.OVERLAY_CLOSE_DURATION_MS, 493, 498}, m = "connectAndServe", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusBindingBase$connectAndServe$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f22225a;

    /* renamed from: b, reason: collision with root package name */
    public Object f22226b;

    /* renamed from: c, reason: collision with root package name */
    public Object f22227c;

    /* renamed from: d, reason: collision with root package name */
    public Object f22228d;

    /* renamed from: e, reason: collision with root package name */
    public Object f22229e;

    /* renamed from: f, reason: collision with root package name */
    public Object f22230f;

    /* renamed from: g, reason: collision with root package name */
    public Object f22231g;

    /* renamed from: h, reason: collision with root package name */
    public Object f22232h;

    /* renamed from: i, reason: collision with root package name */
    public Object f22233i;

    /* renamed from: j, reason: collision with root package name */
    public Object f22234j;

    /* renamed from: k, reason: collision with root package name */
    public Object f22235k;

    /* renamed from: l, reason: collision with root package name */
    public Object f22236l;

    /* renamed from: m, reason: collision with root package name */
    public Object f22237m;

    /* renamed from: n, reason: collision with root package name */
    public Object f22238n;

    /* renamed from: o, reason: collision with root package name */
    public int f22239o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f22240p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ AgentBusBindingBase f22241q;

    /* renamed from: r, reason: collision with root package name */
    public int f22242r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$connectAndServe$1(AgentBusBindingBase agentBusBindingBase, InterfaceC4014c<? super AgentBusBindingBase$connectAndServe$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f22241q = agentBusBindingBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22240p = obj;
        this.f22242r |= Integer.MIN_VALUE;
        return this.f22241q.F(this);
    }
}
