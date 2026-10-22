package com.stepos.agentbus.generated;

import Ua.M;
import Xa.k;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentbus.generated.AgentBusBindingBase$writeFrame$out$1$2", f = "AgentBusBindingBase.kt", l = {592}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusBindingBase$writeFrame$out$1$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f22311a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AgentBusBindingBase f22312b;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "com.stepos.agentbus.generated.AgentBusBindingBase$writeFrame$out$1$2$1", f = "AgentBusBindingBase.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$writeFrame$out$1$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<Boolean, InterfaceC4014c<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f22313a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ boolean f22314b;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
            anonymousClass1.f22314b = ((Boolean) obj).booleanValue();
            return anonymousClass1;
        }

        public final Object f(boolean z10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return ((AnonymousClass1) create(Boolean.valueOf(z10), interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return f(bool.booleanValue(), interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z10 = this.f22314b;
            C4063a.g();
            if (this.f22313a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return C4109a.a(z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$writeFrame$out$1$2(AgentBusBindingBase agentBusBindingBase, InterfaceC4014c<? super AgentBusBindingBase$writeFrame$out$1$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f22312b = agentBusBindingBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusBindingBase$writeFrame$out$1$2(this.f22312b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((AgentBusBindingBase$writeFrame$out$1$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f22311a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        k kVar = this.f22312b.connectedFlow;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
        this.f22311a = 1;
        Object objZ = Xa.d.z(kVar, anonymousClass1, this);
        return objZ == objG ? objG : objZ;
    }
}
