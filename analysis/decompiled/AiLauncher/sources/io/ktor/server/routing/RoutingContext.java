package io.ktor.server.routing;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "", "Lio/ktor/server/routing/RoutingCall;", "call", "<init>", "(Lio/ktor/server/routing/RoutingCall;)V", "Lio/ktor/server/routing/RoutingCall;", "getCall", "()Lio/ktor/server/routing/RoutingCall;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingContext {
    private final RoutingCall call;

    public RoutingContext(RoutingCall call) {
        kotlin.jvm.internal.p.i(call, "call");
        this.call = call;
    }

    public final RoutingCall getCall() {
        return this.call;
    }
}
