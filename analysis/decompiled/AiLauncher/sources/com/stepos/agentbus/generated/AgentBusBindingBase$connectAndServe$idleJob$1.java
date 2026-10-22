package com.stepos.agentbus.generated;

import Ua.M;
import Ua.U;
import Y8.t;
import android.net.LocalSocket;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentbus.generated.AgentBusBindingBase$connectAndServe$idleJob$1", f = "AgentBusBindingBase.kt", l = {420}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusBindingBase$connectAndServe$idleJob$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public long f22246a;

    /* renamed from: b, reason: collision with root package name */
    public int f22247b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f22248c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AgentBusBindingBase f22249d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref$BooleanRef f22250e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ LocalSocket f22251f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$connectAndServe$idleJob$1(AgentBusBindingBase agentBusBindingBase, Ref$BooleanRef ref$BooleanRef, LocalSocket localSocket, InterfaceC4014c<? super AgentBusBindingBase$connectAndServe$idleJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f22249d = agentBusBindingBase;
        this.f22250e = ref$BooleanRef;
        this.f22251f = localSocket;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusBindingBase$connectAndServe$idleJob$1 agentBusBindingBase$connectAndServe$idleJob$1 = new AgentBusBindingBase$connectAndServe$idleJob$1(this.f22249d, this.f22250e, this.f22251f, interfaceC4014c);
        agentBusBindingBase$connectAndServe$idleJob$1.f22248c = obj;
        return agentBusBindingBase$connectAndServe$idleJob$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AgentBusBindingBase$connectAndServe$idleJob$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        M m10 = (M) this.f22248c;
        Object objG = C4063a.g();
        int i10 = this.f22247b;
        if (i10 != 0 && i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        while (kotlinx.coroutines.d.h(m10)) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f22249d.lastActivityMs;
            if (jCurrentTimeMillis >= this.f22249d.idleTimeoutMs) {
                this.f22250e.f34815a = true;
                LocalSocket localSocket = this.f22251f;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    localSocket.close();
                    Result.b(t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
                return t.f7040a;
            }
            long jMin = Math.min(C5685n.g(this.f22249d.idleTimeoutMs - jCurrentTimeMillis, 1L), 10000L);
            this.f22248c = m10;
            this.f22246a = jCurrentTimeMillis;
            this.f22247b = 1;
            if (U.a(jMin, this) == objG) {
                return objG;
            }
        }
        return t.f7040a;
    }
}
