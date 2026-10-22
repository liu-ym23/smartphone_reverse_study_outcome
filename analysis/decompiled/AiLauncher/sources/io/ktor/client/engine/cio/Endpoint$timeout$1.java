package io.ktor.client.engine.cio;

import Ua.M;
import Ua.U;
import Wa.s;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.util.date.DateJvmKt;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.engine.cio.Endpoint$timeout$1", f = "Endpoint.kt", l = {51}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class Endpoint$timeout$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    long J$0;
    int label;
    final /* synthetic */ Endpoint this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Endpoint$timeout$1(Endpoint endpoint, InterfaceC4014c<? super Endpoint$timeout$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = endpoint;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new Endpoint$timeout$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((Endpoint$timeout$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long timeMillis;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                C4849c.b(obj);
            } catch (Throwable unused) {
            }
        }
        do {
            timeMillis = (this.this$0.lastActivity + this.this$0.maxEndpointIdleTime) - DateJvmKt.getTimeMillis();
            if (timeMillis <= 0) {
                s.a(this.this$0.deliveryPoint, null, 1, null);
                this.this$0.onDone.invoke();
                return t.f7040a;
            }
            this.J$0 = timeMillis;
            this.label = 1;
        } while (U.a(timeMillis, this) != objG);
        return objG;
    }
}
