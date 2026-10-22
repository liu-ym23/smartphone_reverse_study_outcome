package io.ktor.server.routing;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J@\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b!\u0010\u0014R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b\"\u0010\u0014R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b#\u0010\u0014¨\u0006%"}, d2 = {"Lio/ktor/server/routing/HostRouteSelector;", "Lio/ktor/server/routing/RouteSelector;", "", "", "hostList", "Lkotlin/text/Regex;", "hostPatterns", "", "portsList", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "toString", "()Ljava/lang/String;", "component1", "()Ljava/util/List;", "component2", "component3", ChatTracker.CLICK_COPY, "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lio/ktor/server/routing/HostRouteSelector;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getHostList", "getHostPatterns", "getPortsList", "Companion", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HostRouteSelector extends RouteSelector {
    public static final String HostNameParameter = "$RequestHost";
    public static final String PortParameter = "$RequestPort";
    private final List<String> hostList;
    private final List<Regex> hostPatterns;
    private final List<Integer> portsList;

    public HostRouteSelector(List<String> hostList, List<Regex> hostPatterns, List<Integer> portsList) {
        kotlin.jvm.internal.p.i(hostList, "hostList");
        kotlin.jvm.internal.p.i(hostPatterns, "hostPatterns");
        kotlin.jvm.internal.p.i(portsList, "portsList");
        this.hostList = hostList;
        this.hostPatterns = hostPatterns;
        this.portsList = portsList;
        if (hostList.isEmpty() && hostPatterns.isEmpty() && portsList.isEmpty()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostRouteSelector copy$default(HostRouteSelector hostRouteSelector, List list, List list2, List list3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = hostRouteSelector.hostList;
        }
        if ((i10 & 2) != 0) {
            list2 = hostRouteSelector.hostPatterns;
        }
        if ((i10 & 4) != 0) {
            list3 = hostRouteSelector.portsList;
        }
        return hostRouteSelector.copy(list, list2, list3);
    }

    public final List<String> component1() {
        return this.hostList;
    }

    public final List<Regex> component2() {
        return this.hostPatterns;
    }

    public final List<Integer> component3() {
        return this.portsList;
    }

    public final HostRouteSelector copy(List<String> hostList, List<Regex> hostPatterns, List<Integer> portsList) {
        kotlin.jvm.internal.p.i(hostList, "hostList");
        kotlin.jvm.internal.p.i(hostPatterns, "hostPatterns");
        kotlin.jvm.internal.p.i(portsList, "portsList");
        return new HostRouteSelector(hostList, hostPatterns, portsList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostRouteSelector)) {
            return false;
        }
        HostRouteSelector hostRouteSelector = (HostRouteSelector) other;
        return kotlin.jvm.internal.p.d(this.hostList, hostRouteSelector.hostList) && kotlin.jvm.internal.p.d(this.hostPatterns, hostRouteSelector.hostPatterns) && kotlin.jvm.internal.p.d(this.portsList, hostRouteSelector.portsList);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    @Override // io.ktor.server.routing.RouteSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object evaluate(io.ktor.server.routing.RoutingResolveContext r8, int r9, e9.InterfaceC4014c<? super io.ktor.server.routing.RouteSelectorEvaluation> r10) {
        /*
            r7 = this;
            io.ktor.server.application.PipelineCall r9 = r8.getCall()
            io.ktor.server.request.PipelineRequest r9 = r9.getRequest()
            io.ktor.http.RequestConnectionPoint r9 = io.ktor.server.plugins.OriginConnectionPointKt.getOrigin(r9)
            java.lang.String r9 = r9.getServerHost()
            io.ktor.server.application.PipelineCall r8 = r8.getCall()
            io.ktor.server.request.PipelineRequest r8 = r8.getRequest()
            io.ktor.http.RequestConnectionPoint r8 = io.ktor.server.plugins.OriginConnectionPointKt.getOrigin(r8)
            int r8 = r8.getServerPort()
            java.util.List<java.lang.String> r10 = r7.hostList
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            r0 = 1
            r1 = 0
            if (r10 == 0) goto L36
            java.util.List<kotlin.text.Regex> r10 = r7.hostPatterns
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L73
        L36:
            java.util.List<java.lang.String> r10 = r7.hostList
            boolean r10 = r10.contains(r9)
            if (r10 != 0) goto L4f
            java.util.List<kotlin.text.Regex> r2 = r7.hostPatterns
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r3 = r2 instanceof java.util.Collection
            if (r3 == 0) goto L51
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L51
        L4f:
            r2 = r1
            goto L68
        L51:
            java.util.Iterator r2 = r2.iterator()
        L55:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L4f
            java.lang.Object r3 = r2.next()
            kotlin.text.Regex r3 = (kotlin.text.Regex) r3
            boolean r3 = r3.k(r9)
            if (r3 == 0) goto L55
            r2 = r0
        L68:
            if (r10 != 0) goto L73
            if (r2 != 0) goto L73
            io.ktor.server.routing.RouteSelectorEvaluation$Companion r7 = io.ktor.server.routing.RouteSelectorEvaluation.INSTANCE
            io.ktor.server.routing.RouteSelectorEvaluation$Failure r7 = r7.getFailed()
            return r7
        L73:
            java.util.List<java.lang.Integer> r10 = r7.portsList
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L90
            java.util.List<java.lang.Integer> r7 = r7.portsList
            java.lang.Integer r10 = g9.C4109a.f(r8)
            boolean r7 = r7.contains(r10)
            if (r7 != 0) goto L90
            io.ktor.server.routing.RouteSelectorEvaluation$Companion r7 = io.ktor.server.routing.RouteSelectorEvaluation.INSTANCE
            io.ktor.server.routing.RouteSelectorEvaluation$Failure r7 = r7.getFailed()
            return r7
        L90:
            io.ktor.http.Parameters$Companion r7 = io.ktor.http.Parameters.INSTANCE
            r7 = 0
            io.ktor.http.ParametersBuilder r7 = io.ktor.http.ParametersKt.ParametersBuilder$default(r1, r0, r7)
            java.lang.String r10 = "$RequestHost"
            r7.append(r10, r9)
            java.lang.String r9 = "$RequestPort"
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r7.append(r9, r8)
            io.ktor.http.Parameters r3 = r7.build()
            io.ktor.server.routing.RouteSelectorEvaluation$Success r0 = new io.ktor.server.routing.RouteSelectorEvaluation$Success
            r5 = 4
            r6 = 0
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r4 = 0
            r0.<init>(r1, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.HostRouteSelector.evaluate(io.ktor.server.routing.RoutingResolveContext, int, e9.c):java.lang.Object");
    }

    public final List<String> getHostList() {
        return this.hostList;
    }

    public final List<Regex> getHostPatterns() {
        return this.hostPatterns;
    }

    public final List<Integer> getPortsList() {
        return this.portsList;
    }

    public int hashCode() {
        return (((this.hostList.hashCode() * 31) + this.hostPatterns.hashCode()) * 31) + this.portsList.hashCode();
    }

    public String toString() {
        return '(' + this.hostList + ", " + this.hostPatterns + ", " + this.portsList + ')';
    }
}
