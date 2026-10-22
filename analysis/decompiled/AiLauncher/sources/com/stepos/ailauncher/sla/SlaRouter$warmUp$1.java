package com.stepos.ailauncher.sla;

import android.content.Context;
import com.stepos.aiengine.algorithm.sla.ISla;
import com.stepos.aiengine.client.AlgorithmClient;
import com.stepos.aiengine.clients.AlgorithmClients;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.sla.SlaRouter$warmUp$1", f = "SlaRouter.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SlaRouter$warmUp$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $appContext;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaRouter$warmUp$1(Context context, InterfaceC4014c<? super SlaRouter$warmUp$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$appContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SlaRouter$warmUp$1 slaRouter$warmUp$1 = new SlaRouter$warmUp$1(this.$appContext, interfaceC4014c);
        slaRouter$warmUp$1.L$0 = obj;
        return slaRouter$warmUp$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SlaRouter$warmUp$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Context context = this.$appContext;
        try {
            Result.Companion companion = Result.INSTANCE;
            AlgorithmClients algorithmClients = AlgorithmClients.INSTANCE;
            AlgorithmClient<ISla> sla = algorithmClients.getSla();
            kotlin.jvm.internal.p.f(context);
            if (sla.isSupported(context)) {
                AlgorithmClient.loadAlgorithm$default(algorithmClients.getSla(), context, null, 2, null);
                C4148a.k(SlaGate.TAG, "warmUp loadAlgorithm done", false, 4, null);
            }
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(SlaGate.TAG, "warmUp failed: " + thE.getMessage(), false, 4, null);
        }
        SlaRouter slaRouter = SlaRouter.INSTANCE;
        Context context2 = this.$appContext;
        kotlin.jvm.internal.p.f(context2);
        slaRouter.J(context2);
        SlaRouter.warming.set(false);
        return Y8.t.f7040a;
    }
}
