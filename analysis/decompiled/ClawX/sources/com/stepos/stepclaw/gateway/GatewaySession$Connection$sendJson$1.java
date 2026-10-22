package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.gateway.GatewaySession;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@h5.e(c = "com.stepos.stepclaw.gateway.GatewaySession$Connection", f = "GatewaySession.kt", l = {1033}, m = "sendJson", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewaySession$Connection$sendJson$1 extends h5.c {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GatewaySession.Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySession$Connection$sendJson$1(GatewaySession.Connection connection, f5.c cVar) {
        super(cVar);
        this.this$0 = connection;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendJson(null, this);
    }
}
