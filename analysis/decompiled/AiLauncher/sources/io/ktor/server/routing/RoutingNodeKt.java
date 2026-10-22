package io.ktor.server.routing;

import La.H;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import io.ktor.server.application.PipelineCall;
import io.ktor.util.pipeline.InvalidPhaseException;
import io.ktor.util.pipeline.Phase;
import io.ktor.util.pipeline.PipelineContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a!\u0010\u0002\u001a\u00020\u0006*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004H\u0002¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\f\u001a\u00020\b*\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\r\u001aQ\u0010\u0017\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000f24\u0010\u0016\u001a0\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0011H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u001a\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u001c\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001c\u0010\u001b\"\u0015\u0010\t\u001a\u00020\b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\n*B\u0010 \"\u001e\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001e2\u001e\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001e¨\u0006!"}, d2 = {"Lio/ktor/server/routing/RoutingNode;", "", "getAllRoutes", "(Lio/ktor/server/routing/RoutingNode;)Ljava/util/List;", "", "endpoints", "LY8/t;", "(Lio/ktor/server/routing/RoutingNode;Ljava/util/List;)V", "", "path", "(Lio/ktor/server/routing/RoutingNode;)Ljava/lang/String;", "Lio/ktor/server/routing/RouteSelector;", "toPathElement", "(Lio/ktor/server/routing/RouteSelector;)Ljava/lang/String;", "Lio/ktor/server/routing/Route;", "Lio/ktor/util/pipeline/PipelinePhase;", "phase", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/server/application/PipelineCall;", "Le9/c;", "", "block", "intercept", "(Lio/ktor/server/routing/Route;Lio/ktor/util/pipeline/PipelinePhase;Lp9/q;)V", SkillStoreKt.SKILL_DOC_TYPE_REFERENCE, "insertPhaseAfter", "(Lio/ktor/server/routing/Route;Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhase;)V", "insertPhaseBefore", "getPath", "Lkotlin/Function2;", "Lio/ktor/server/routing/RoutingContext;", "RoutingHandler", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingNodeKt {
    public static final List<RoutingNode> getAllRoutes(RoutingNode routingNode) {
        kotlin.jvm.internal.p.i(routingNode, "<this>");
        ArrayList arrayList = new ArrayList();
        getAllRoutes(routingNode, arrayList);
        return arrayList;
    }

    public static final String getPath(RoutingNode routingNode) {
        kotlin.jvm.internal.p.i(routingNode, "<this>");
        return path(routingNode);
    }

    public static final void insertPhaseAfter(Route route, Phase reference, Phase phase) throws InvalidPhaseException {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(reference, "reference");
        kotlin.jvm.internal.p.i(phase, "phase");
        ((RoutingNode) route).insertPhaseAfter(reference, phase);
    }

    public static final void insertPhaseBefore(Route route, Phase reference, Phase phase) throws InvalidPhaseException {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(reference, "reference");
        kotlin.jvm.internal.p.i(phase, "phase");
        ((RoutingNode) route).insertPhaseBefore(reference, phase);
    }

    public static final void intercept(Route route, Phase phase, p9.q<? super PipelineContext<Y8.t, PipelineCall>, ? super Y8.t, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(phase, "phase");
        kotlin.jvm.internal.p.i(block, "block");
        ((RoutingNode) route).intercept(phase, block);
    }

    private static final String path(RoutingNode routingNode) {
        RoutingNode parent = routingNode.getParent();
        String strPath = parent != null ? path(parent) : null;
        String pathElement = toPathElement(routingNode.getSelector());
        if (strPath == null) {
            return pathElement;
        }
        if (pathElement.length() == 0) {
            return strPath;
        }
        if (H.j0(strPath, JsonPointer.SEPARATOR, false, 2, null) || H.i1(pathElement, JsonPointer.SEPARATOR, false, 2, null)) {
            return strPath + pathElement;
        }
        return strPath + JsonPointer.SEPARATOR + pathElement;
    }

    private static final String toPathElement(RouteSelector routeSelector) {
        return ((routeSelector instanceof PathSegmentConstantRouteSelector) || (routeSelector instanceof PathSegmentParameterRouteSelector) || (routeSelector instanceof PathSegmentOptionalParameterRouteSelector) || (routeSelector instanceof PathSegmentTailcardRouteSelector) || (routeSelector instanceof PathSegmentWildcardRouteSelector) || (routeSelector instanceof Regex)) ? routeSelector.toString() : routeSelector instanceof TrailingSlashRouteSelector ? "/" : "";
    }

    private static final void getAllRoutes(RoutingNode routingNode, List<RoutingNode> list) {
        if (!routingNode.getHandlers$ktor_server_core().isEmpty()) {
            list.add(routingNode);
        }
        Iterator<T> it = routingNode.getChildren().iterator();
        while (it.hasNext()) {
            getAllRoutes((RoutingNode) it.next(), list);
        }
    }
}
