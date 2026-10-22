package com.stepos.agentbus.generated;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {282}, m = "awaitResponse", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusBindingBase$awaitResponse$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f22204a;

    /* renamed from: b, reason: collision with root package name */
    public Object f22205b;

    /* renamed from: c, reason: collision with root package name */
    public long f22206c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f22207d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AgentBusBindingBase f22208e;

    /* renamed from: f, reason: collision with root package name */
    public int f22209f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$awaitResponse$1(AgentBusBindingBase agentBusBindingBase, InterfaceC4014c<? super AgentBusBindingBase$awaitResponse$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f22208e = agentBusBindingBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22207d = obj;
        this.f22209f |= Integer.MIN_VALUE;
        return this.f22208e.D(null, 0L, this);
    }
}
