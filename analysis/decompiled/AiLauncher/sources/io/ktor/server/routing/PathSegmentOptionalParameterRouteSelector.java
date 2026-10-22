package io.ktor.server.routing;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0010J2\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0010R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\u0010R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b \u0010\u0010¨\u0006!"}, d2 = {"Lio/ktor/server/routing/PathSegmentOptionalParameterRouteSelector;", "Lio/ktor/server/routing/RouteSelector;", "", "name", "prefix", "suffix", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "toString", "()Ljava/lang/String;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/ktor/server/routing/PathSegmentOptionalParameterRouteSelector;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getPrefix", "getSuffix", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PathSegmentOptionalParameterRouteSelector extends RouteSelector {
    private final String name;
    private final String prefix;
    private final String suffix;

    public /* synthetic */ PathSegmentOptionalParameterRouteSelector(String str, String str2, String str3, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }

    public static /* synthetic */ PathSegmentOptionalParameterRouteSelector copy$default(PathSegmentOptionalParameterRouteSelector pathSegmentOptionalParameterRouteSelector, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = pathSegmentOptionalParameterRouteSelector.name;
        }
        if ((i10 & 2) != 0) {
            str2 = pathSegmentOptionalParameterRouteSelector.prefix;
        }
        if ((i10 & 4) != 0) {
            str3 = pathSegmentOptionalParameterRouteSelector.suffix;
        }
        return pathSegmentOptionalParameterRouteSelector.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPrefix() {
        return this.prefix;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSuffix() {
        return this.suffix;
    }

    public final PathSegmentOptionalParameterRouteSelector copy(String name, String prefix, String suffix) {
        kotlin.jvm.internal.p.i(name, "name");
        return new PathSegmentOptionalParameterRouteSelector(name, prefix, suffix);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PathSegmentOptionalParameterRouteSelector)) {
            return false;
        }
        PathSegmentOptionalParameterRouteSelector pathSegmentOptionalParameterRouteSelector = (PathSegmentOptionalParameterRouteSelector) other;
        return kotlin.jvm.internal.p.d(this.name, pathSegmentOptionalParameterRouteSelector.name) && kotlin.jvm.internal.p.d(this.prefix, pathSegmentOptionalParameterRouteSelector.prefix) && kotlin.jvm.internal.p.d(this.suffix, pathSegmentOptionalParameterRouteSelector.suffix);
    }

    @Override // io.ktor.server.routing.RouteSelector
    public Object evaluate(RoutingResolveContext routingResolveContext, int i10, InterfaceC4014c<? super RouteSelectorEvaluation> interfaceC4014c) {
        return RouteSelectorKt.evaluatePathSegmentParameter(routingResolveContext.getSegments(), i10, this.name, this.prefix, this.suffix, true);
    }

    public final String getName() {
        return this.name;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.prefix;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.suffix;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.prefix;
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append('{');
        sb2.append(this.name);
        sb2.append("?}");
        String str2 = this.suffix;
        sb2.append(str2 != null ? str2 : "");
        return sb2.toString();
    }

    public PathSegmentOptionalParameterRouteSelector(String name, String str, String str2) {
        kotlin.jvm.internal.p.i(name, "name");
        this.name = name;
        this.prefix = str;
        this.suffix = str2;
    }
}
