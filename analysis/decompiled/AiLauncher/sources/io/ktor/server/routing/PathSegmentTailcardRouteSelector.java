package io.ktor.server.routing;

import La.K;
import Z8.C1173v;
import Z8.C1174w;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersKt;
import io.ktor.server.routing.RouteSelectorEvaluation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0096@¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ$\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000f¨\u0006\u001e"}, d2 = {"Lio/ktor/server/routing/PathSegmentTailcardRouteSelector;", "Lio/ktor/server/routing/RouteSelector;", "", "name", "prefix", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "toString", "()Ljava/lang/String;", "component1", "component2", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;)Lio/ktor/server/routing/PathSegmentTailcardRouteSelector;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getPrefix", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PathSegmentTailcardRouteSelector extends RouteSelector {
    private final String name;
    private final String prefix;

    /* JADX WARN: Multi-variable type inference failed */
    public PathSegmentTailcardRouteSelector() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PathSegmentTailcardRouteSelector copy$default(PathSegmentTailcardRouteSelector pathSegmentTailcardRouteSelector, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = pathSegmentTailcardRouteSelector.name;
        }
        if ((i10 & 2) != 0) {
            str2 = pathSegmentTailcardRouteSelector.prefix;
        }
        return pathSegmentTailcardRouteSelector.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPrefix() {
        return this.prefix;
    }

    public final PathSegmentTailcardRouteSelector copy(String name, String prefix) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        return new PathSegmentTailcardRouteSelector(name, prefix);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PathSegmentTailcardRouteSelector)) {
            return false;
        }
        PathSegmentTailcardRouteSelector pathSegmentTailcardRouteSelector = (PathSegmentTailcardRouteSelector) other;
        return kotlin.jvm.internal.p.d(this.name, pathSegmentTailcardRouteSelector.name) && kotlin.jvm.internal.p.d(this.prefix, pathSegmentTailcardRouteSelector.prefix);
    }

    @Override // io.ktor.server.routing.RouteSelector
    public Object evaluate(RoutingResolveContext routingResolveContext, int i10, InterfaceC4014c<? super RouteSelectorEvaluation> interfaceC4014c) {
        Parameters parametersParametersOf;
        String str;
        List<String> segments = routingResolveContext.getSegments();
        int i11 = 0;
        if (this.prefix.length() > 0 && ((str = (String) Z8.F.t0(segments, i10)) == null || !La.D.X(str, this.prefix, false, 2, null))) {
            return RouteSelectorEvaluation.INSTANCE.getFailedPath();
        }
        if (this.name.length() == 0) {
            parametersParametersOf = ParametersKt.parametersOf();
        } else {
            String str2 = this.name;
            List listH0 = Z8.F.h0(segments, i10);
            ArrayList arrayList = new ArrayList(C1174w.x(listH0, 10));
            for (Object obj : listH0) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    C1173v.w();
                }
                String strL1 = (String) obj;
                if (i11 == 0) {
                    strL1 = K.L1(strL1, this.prefix.length());
                }
                arrayList.add(strL1);
                i11 = i12;
            }
            parametersParametersOf = ParametersKt.parametersOf(str2, arrayList);
        }
        return new RouteSelectorEvaluation.Success(i10 < segments.size() ? 0.1d : 0.2d, parametersParametersOf, segments.size() - i10);
    }

    public final String getName() {
        return this.name;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.prefix.hashCode();
    }

    public String toString() {
        return "{...}";
    }

    public /* synthetic */ PathSegmentTailcardRouteSelector(String str, String str2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2);
    }

    public PathSegmentTailcardRouteSelector(String name, String prefix) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(prefix, "prefix");
        this.name = name;
        this.prefix = prefix;
        for (int i10 = 0; i10 < prefix.length(); i10++) {
            if (prefix.charAt(i10) == '/') {
                throw new IllegalArgumentException("Multisegment prefix is not supported");
            }
        }
    }
}
