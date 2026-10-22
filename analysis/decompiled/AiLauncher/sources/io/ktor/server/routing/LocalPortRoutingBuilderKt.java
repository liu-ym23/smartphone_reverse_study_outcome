package io.ktor.server.routing;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/server/routing/Route;", "", "port", "Lkotlin/Function1;", "LY8/t;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "localPort", "(Lio/ktor/server/routing/Route;ILp9/l;)Lio/ktor/server/routing/Route;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocalPortRoutingBuilderKt {
    public static final Route localPort(Route route, int i10, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(build, "build");
        if (1 <= i10 && i10 < 65536) {
            Route routeCreateChild = route.createChild(new LocalPortRouteSelector(i10));
            build.invoke(routeCreateChild);
            return routeCreateChild;
        }
        throw new IllegalArgumentException(("Port " + i10 + " must be a positive number between 1 and 65,535").toString());
    }
}
