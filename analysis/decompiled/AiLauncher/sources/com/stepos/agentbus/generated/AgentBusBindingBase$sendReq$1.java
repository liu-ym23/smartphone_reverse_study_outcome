package com.stepos.agentbus.generated;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {234}, m = "sendReq", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusBindingBase$sendReq$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f22293a;

    /* renamed from: b, reason: collision with root package name */
    public Object f22294b;

    /* renamed from: c, reason: collision with root package name */
    public Object f22295c;

    /* renamed from: d, reason: collision with root package name */
    public Object f22296d;

    /* renamed from: e, reason: collision with root package name */
    public Object f22297e;

    /* renamed from: f, reason: collision with root package name */
    public Object f22298f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f22299g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AgentBusBindingBase f22300h;

    /* renamed from: i, reason: collision with root package name */
    public int f22301i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$sendReq$1(AgentBusBindingBase agentBusBindingBase, InterfaceC4014c<? super AgentBusBindingBase$sendReq$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f22300h = agentBusBindingBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22299g = obj;
        this.f22301i |= Integer.MIN_VALUE;
        return this.f22300h.f0(null, null, this);
    }
}
