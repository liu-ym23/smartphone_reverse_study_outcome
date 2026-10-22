package com.stepos.agentbus.generated;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {242}, m = "sendEvent", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusBindingBase$sendEvent$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f22285a;

    /* renamed from: b, reason: collision with root package name */
    public Object f22286b;

    /* renamed from: c, reason: collision with root package name */
    public Object f22287c;

    /* renamed from: d, reason: collision with root package name */
    public Object f22288d;

    /* renamed from: e, reason: collision with root package name */
    public Object f22289e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f22290f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AgentBusBindingBase f22291g;

    /* renamed from: h, reason: collision with root package name */
    public int f22292h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$sendEvent$1(AgentBusBindingBase agentBusBindingBase, InterfaceC4014c<? super AgentBusBindingBase$sendEvent$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f22291g = agentBusBindingBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22290f = obj;
        this.f22292h |= Integer.MIN_VALUE;
        return this.f22291g.e0(null, null, this);
    }
}
