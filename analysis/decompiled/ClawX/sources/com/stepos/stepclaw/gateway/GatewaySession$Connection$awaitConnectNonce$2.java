package com.stepos.stepclaw.gateway;

import a6.f0;
import a6.r;
import a6.s;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.gateway.GatewaySession;
import h5.i;
import kotlin.Metadata;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
@h5.e(c = "com.stepos.stepclaw.gateway.GatewaySession$Connection$awaitConnectNonce$2", f = "GatewaySession.kt", l = {651}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class GatewaySession$Connection$awaitConnectNonce$2 extends i implements p {
    int label;
    final /* synthetic */ GatewaySession.Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySession$Connection$awaitConnectNonce$2(GatewaySession.Connection connection, f5.c cVar) {
        super(2, cVar);
        this.this$0 = connection;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new GatewaySession$Connection$awaitConnectNonce$2(this.this$0, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, f5.c cVar) {
        return ((GatewaySession$Connection$awaitConnectNonce$2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        g5.a aVar = g5.a.f2984a;
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            return obj;
        }
        a.a.c0(obj);
        r rVar = this.this$0.connectNonceDeferred;
        this.label = 1;
        Object objW = ((s) rVar).w(this);
        return objW == aVar ? aVar : objW;
    }
}
