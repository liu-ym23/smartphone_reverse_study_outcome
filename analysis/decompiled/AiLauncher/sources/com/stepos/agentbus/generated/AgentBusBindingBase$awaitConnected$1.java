package com.stepos.agentbus.generated;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {219}, m = "awaitConnected", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusBindingBase$awaitConnected$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public long f22196a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f22197b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AgentBusBindingBase f22198c;

    /* renamed from: d, reason: collision with root package name */
    public int f22199d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$awaitConnected$1(AgentBusBindingBase agentBusBindingBase, InterfaceC4014c<? super AgentBusBindingBase$awaitConnected$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f22198c = agentBusBindingBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22197b = obj;
        this.f22199d |= Integer.MIN_VALUE;
        return this.f22198c.C(0L, this);
    }
}
