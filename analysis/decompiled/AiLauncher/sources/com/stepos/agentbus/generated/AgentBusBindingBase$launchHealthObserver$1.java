package com.stepos.agentbus.generated;

import Ua.M;
import Xa.k;
import Y8.t;
import a4.BffLinkStatus;
import com.stepos.agentbus.generated.c;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentbus.generated.AgentBusBindingBase$launchHealthObserver$1", f = "AgentBusBindingBase.kt", l = {180}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusBindingBase$launchHealthObserver$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f22266a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AgentBusBindingBase f22267b;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AgentBusBindingBase f22268a;

        public a(AgentBusBindingBase agentBusBindingBase) {
            this.f22268a = agentBusBindingBase;
        }

        public final Object b(boolean z10, InterfaceC4014c<? super t> interfaceC4014c) {
            if (!z10) {
                k kVar = this.f22268a.mutableServiceHealth;
                long jCurrentTimeMillis = System.currentTimeMillis();
                RetryHint retryHint = RetryHint.Auto;
                kVar.setValue(new c.Unavailable("agentbus disconnected", jCurrentTimeMillis, retryHint));
                this.f22268a.mutableUpstreamHealth.setValue(new c.Unavailable("agentbus disconnected", System.currentTimeMillis(), retryHint));
                this.f22268a.mutableBffHealth.setValue(new c.Unavailable("agentbus disconnected", System.currentTimeMillis(), retryHint));
                this.f22268a.mutableBffLinkState.setValue(new BffLinkStatus(false, false, 3, null));
            } else if (!(this.f22268a.mutableServiceHealth.getValue() instanceof c.Available)) {
                this.f22268a.mutableServiceHealth.setValue(new c.Available(null, 1, null));
            }
            return t.f7040a;
        }

        @Override // Xa.c
        public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
            return b(((Boolean) obj).booleanValue(), interfaceC4014c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$launchHealthObserver$1(AgentBusBindingBase agentBusBindingBase, InterfaceC4014c<? super AgentBusBindingBase$launchHealthObserver$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f22267b = agentBusBindingBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusBindingBase$launchHealthObserver$1(this.f22267b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AgentBusBindingBase$launchHealthObserver$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f22266a;
        if (i10 == 0) {
            C4849c.b(obj);
            k kVar = this.f22267b.connectedFlow;
            a aVar = new a(this.f22267b);
            this.f22266a = 1;
            if (kVar.collect(aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
