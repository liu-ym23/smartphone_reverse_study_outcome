package com.stepos.agentbus.generated;

import Ua.InterfaceC1083u;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import org.json.JSONObject;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lorg/json/JSONObject;", "<anonymous>", "(LUa/M;)Lorg/json/JSONObject;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$2", f = "AgentBusBindingBase.kt", l = {282}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusBindingBase$awaitResponse$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super JSONObject>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f22210a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1083u<JSONObject> f22211b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$awaitResponse$2(InterfaceC1083u<JSONObject> interfaceC1083u, InterfaceC4014c<? super AgentBusBindingBase$awaitResponse$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f22211b = interfaceC1083u;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusBindingBase$awaitResponse$2(this.f22211b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super JSONObject> interfaceC4014c) {
        return ((AgentBusBindingBase$awaitResponse$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f22210a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        InterfaceC1083u<JSONObject> interfaceC1083u = this.f22211b;
        this.f22210a = 1;
        Object objA1 = interfaceC1083u.a1(this);
        return objA1 == objG ? objG : objA1;
    }
}
