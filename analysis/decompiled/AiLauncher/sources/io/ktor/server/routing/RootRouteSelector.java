package io.ktor.server.routing;

import Z8.C1174w;
import e9.InterfaceC4014c;
import io.ktor.server.routing.RouteSelectorEvaluation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/server/routing/RootRouteSelector;", "Lio/ktor/server/routing/RouteSelector;", "", "rootPath", "<init>", "(Ljava/lang/String;)V", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "toString", "()Ljava/lang/String;", "", "parts", "Ljava/util/List;", "Lio/ktor/server/routing/RouteSelectorEvaluation$Success;", "successEvaluationResult", "Lio/ktor/server/routing/RouteSelectorEvaluation$Success;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RootRouteSelector extends RouteSelector {
    private final List<String> parts;
    private final RouteSelectorEvaluation.Success successEvaluationResult;

    /* JADX WARN: Multi-variable type inference failed */
    public RootRouteSelector() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // io.ktor.server.routing.RouteSelector
    public Object evaluate(RoutingResolveContext routingResolveContext, int i10, InterfaceC4014c<? super RouteSelectorEvaluation> interfaceC4014c) {
        if (i10 != 0) {
            throw new IllegalStateException("Root selector should be evaluated first.");
        }
        if (this.parts.isEmpty()) {
            return RouteSelectorEvaluation.INSTANCE.getConstant();
        }
        List<String> list = this.parts;
        List<String> segments = routingResolveContext.getSegments();
        if (segments.size() < list.size()) {
            return RouteSelectorEvaluation.INSTANCE.getFailedPath();
        }
        int size = list.size() + i10;
        while (i10 < size) {
            if (!kotlin.jvm.internal.p.d(segments.get(i10), list.get(i10))) {
                return RouteSelectorEvaluation.INSTANCE.getFailedPath();
            }
            i10++;
        }
        return this.successEvaluationResult;
    }

    public String toString() {
        return Z8.F.A0(this.parts, "/", null, null, 0, null, null, 62, null);
    }

    public RootRouteSelector(String rootPath) {
        kotlin.jvm.internal.p.i(rootPath, "rootPath");
        List<RoutingPathSegment> parts = RoutingPath.INSTANCE.parse(rootPath).getParts();
        ArrayList arrayList = new ArrayList(C1174w.x(parts, 10));
        for (RoutingPathSegment routingPathSegment : parts) {
            if (routingPathSegment.getKind() != RoutingPathSegmentKind.Constant) {
                throw new IllegalArgumentException("rootPath should be constant, no wildcards supported.");
            }
            arrayList.add(routingPathSegment.getValue());
        }
        this.parts = arrayList;
        this.successEvaluationResult = new RouteSelectorEvaluation.Success(1.0d, null, arrayList.size(), 2, null);
    }

    public /* synthetic */ RootRouteSelector(String str, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str);
    }
}
