package io.ktor.server.routing;

import Z8.C1172u;
import Z8.C1173v;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.Regex;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a7\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0002\u0010\b\u001a7\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0002\u0010\u000b\u001aC\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0002\u0010\u000f\u001aQ\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0002\u0010\u0011\u001a1\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\n\u0010\u000e\u001a\u00020\u0012\"\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0004\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/server/routing/Route;", "", "host", "", "port", "Lkotlin/Function1;", "LY8/t;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "(Lio/ktor/server/routing/Route;Ljava/lang/String;ILp9/l;)Lio/ktor/server/routing/Route;", "Lkotlin/text/Regex;", "hostPattern", "(Lio/ktor/server/routing/Route;Lkotlin/text/Regex;ILp9/l;)Lio/ktor/server/routing/Route;", "", "hosts", "ports", "(Lio/ktor/server/routing/Route;Ljava/util/List;Ljava/util/List;Lp9/l;)Lio/ktor/server/routing/Route;", "hostPatterns", "(Lio/ktor/server/routing/Route;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lp9/l;)Lio/ktor/server/routing/Route;", "", "(Lio/ktor/server/routing/Route;[ILp9/l;)Lio/ktor/server/routing/Route;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HostsRoutingBuilderKt {
    public static final Route host(Route route, String host, int i10, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(build, "build");
        return host(route, C1172u.e(host), C1173v.m(), i10 > 0 ? C1172u.e(Integer.valueOf(i10)) : C1173v.m(), build);
    }

    public static /* synthetic */ Route host$default(Route route, String str, int i10, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return host(route, str, i10, (InterfaceC5074l<? super Route, Y8.t>) interfaceC5074l);
    }

    public static final Route port(Route route, int[] ports, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(ports, "ports");
        kotlin.jvm.internal.p.i(build, "build");
        if (ports.length == 0) {
            throw new IllegalArgumentException("At least one port need to be specified");
        }
        Route routeCreateChild = route.createChild(new HostRouteSelector(C1173v.m(), C1173v.m(), Z8.r.R0(ports)));
        build.invoke(routeCreateChild);
        return routeCreateChild;
    }

    public static final Route host(Route route, Regex hostPattern, int i10, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(hostPattern, "hostPattern");
        kotlin.jvm.internal.p.i(build, "build");
        return host(route, C1173v.m(), C1172u.e(hostPattern), i10 > 0 ? C1172u.e(Integer.valueOf(i10)) : C1173v.m(), build);
    }

    public static /* synthetic */ Route host$default(Route route, Regex regex, int i10, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return host(route, regex, i10, (InterfaceC5074l<? super Route, Y8.t>) interfaceC5074l);
    }

    public static final Route host(Route route, List<String> hosts, List<Integer> ports, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(hosts, "hosts");
        kotlin.jvm.internal.p.i(ports, "ports");
        kotlin.jvm.internal.p.i(build, "build");
        return host(route, hosts, C1173v.m(), ports, build);
    }

    public static /* synthetic */ Route host$default(Route route, List list, List list2, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list2 = C1173v.m();
        }
        return host(route, (List<String>) list, (List<Integer>) list2, (InterfaceC5074l<? super Route, Y8.t>) interfaceC5074l);
    }

    public static final Route host(Route route, List<String> hosts, List<Regex> hostPatterns, List<Integer> ports, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(hosts, "hosts");
        kotlin.jvm.internal.p.i(hostPatterns, "hostPatterns");
        kotlin.jvm.internal.p.i(ports, "ports");
        kotlin.jvm.internal.p.i(build, "build");
        Route routeCreateChild = route.createChild(new HostRouteSelector(hosts, hostPatterns, ports));
        build.invoke(routeCreateChild);
        return routeCreateChild;
    }

    public static /* synthetic */ Route host$default(Route route, List list, List list2, List list3, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            list3 = C1173v.m();
        }
        return host(route, list, list2, list3, interfaceC5074l);
    }
}
