package com.stepos.stepclaw;

import a6.f0;
import b5.a0;
import com.stepos.stepclaw.gateway.GatewayEndpoint;
import com.stepos.stepclaw.openclaw.OpenClawClient;
import h5.e;
import h5.i;
import kotlin.Metadata;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.stepos.stepclaw.GatewayRuntime$gatewaySession$4$1$1", f = "GatewayRuntime.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class GatewayRuntime$gatewaySession$4$1$1 extends i implements p {
    final /* synthetic */ GatewayEndpoint $ep;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayRuntime$gatewaySession$4$1$1(GatewayEndpoint gatewayEndpoint, f5.c cVar) {
        super(2, cVar);
        this.$ep = gatewayEndpoint;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new GatewayRuntime$gatewaySession$4$1$1(this.$ep, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, f5.c cVar) {
        return ((GatewayRuntime$gatewaySession$4$1$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        g5.a aVar = g5.a.f2984a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        a.a.c0(obj);
        GatewayEndpoint gatewayEndpoint = this.$ep;
        if (gatewayEndpoint != null) {
            String str = gatewayEndpoint.getTlsEnabled() ? "https" : "http";
            OpenClawClient.INSTANCE.init(str + "://" + this.$ep.getHost() + ":" + this.$ep.getPort());
        }
        return a0.f883a;
    }
}
