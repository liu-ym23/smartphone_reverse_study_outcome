package com.stepos.stepclaw.edge.spi;

import a6.f0;
import com.stepos.stepclaw.bridge.spi.EdgeServices;
import com.stepos.stepclaw.edge.intercept.InterceptHttpServer;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/edge/spi/EdgeServicesImpl;", "Lcom/stepos/stepclaw/bridge/spi/EdgeServices;", "<init>", "()V", "La6/f0;", "scope", "Lb5/a0;", "startInterceptServer", "(La6/f0;)V", "Lcom/stepos/stepclaw/edge/intercept/InterceptHttpServer;", "interceptServer", "Lcom/stepos/stepclaw/edge/intercept/InterceptHttpServer;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EdgeServicesImpl implements EdgeServices {
    private final InterceptHttpServer interceptServer = new InterceptHttpServer(0, 1, null);

    @Override // com.stepos.stepclaw.bridge.spi.EdgeServices
    public void startInterceptServer(f0 scope) {
        p.e(scope, "scope");
        this.interceptServer.start(scope);
    }
}
