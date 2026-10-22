package com.stepos.agentbus.generated;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {304, 305}, m = "request", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusBindingBase$request$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f22269a;

    /* renamed from: b, reason: collision with root package name */
    public Object f22270b;

    /* renamed from: c, reason: collision with root package name */
    public Object f22271c;

    /* renamed from: d, reason: collision with root package name */
    public long f22272d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f22273e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AgentBusBindingBase f22274f;

    /* renamed from: g, reason: collision with root package name */
    public int f22275g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$request$1(AgentBusBindingBase agentBusBindingBase, InterfaceC4014c<? super AgentBusBindingBase$request$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f22274f = agentBusBindingBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22273e = obj;
        this.f22275g |= Integer.MIN_VALUE;
        return this.f22274f.a0(null, null, 0L, this);
    }
}
