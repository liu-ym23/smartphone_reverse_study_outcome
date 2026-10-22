package io.ktor.server.routing;

import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Parameters;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/server/routing/RoutingResolveResult;", "", "Lio/ktor/server/routing/RoutingNode;", M5.a.CARD_TYPE_ROUTE, "<init>", "(Lio/ktor/server/routing/RoutingNode;)V", "Lio/ktor/server/routing/RoutingNode;", "getRoute", "()Lio/ktor/server/routing/RoutingNode;", "Lio/ktor/http/Parameters;", "getParameters", "()Lio/ktor/http/Parameters;", "parameters", "Success", "Failure", "Lio/ktor/server/routing/RoutingResolveResult$Failure;", "Lio/ktor/server/routing/RoutingResolveResult$Success;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class RoutingResolveResult {
    private final RoutingNode route;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0001\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/ktor/server/routing/RoutingResolveResult$Failure;", "Lio/ktor/server/routing/RoutingResolveResult;", "Lio/ktor/server/routing/RoutingNode;", M5.a.CARD_TYPE_ROUTE, "", "reason", "Lio/ktor/http/HttpStatusCode;", "errorStatusCode", "<init>", "(Lio/ktor/server/routing/RoutingNode;Ljava/lang/String;Lio/ktor/http/HttpStatusCode;)V", "(Lio/ktor/server/routing/RoutingNode;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getReason", "Lio/ktor/http/HttpStatusCode;", "getErrorStatusCode", "()Lio/ktor/http/HttpStatusCode;", "", "getParameters", "()Ljava/lang/Void;", "parameters", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Failure extends RoutingResolveResult {
        private final HttpStatusCode errorStatusCode;
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(RoutingNode route, String reason, HttpStatusCode errorStatusCode) {
            super(route, null);
            kotlin.jvm.internal.p.i(route, "route");
            kotlin.jvm.internal.p.i(reason, "reason");
            kotlin.jvm.internal.p.i(errorStatusCode, "errorStatusCode");
            this.reason = reason;
            this.errorStatusCode = errorStatusCode;
        }

        public final HttpStatusCode getErrorStatusCode() {
            return this.errorStatusCode;
        }

        @Override // io.ktor.server.routing.RoutingResolveResult
        public /* bridge */ /* synthetic */ Parameters getParameters() {
            return (Parameters) m177getParameters();
        }

        public final String getReason() {
            return this.reason;
        }

        public String toString() {
            return "FAILURE \"" + this.reason + "\" @ " + getRoute();
        }

        /* renamed from: getParameters, reason: collision with other method in class */
        public Void m177getParameters() {
            throw new UnsupportedOperationException("Parameters are available only when routing resolve succeeds");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Failure(RoutingNode route, String reason) {
            this(route, reason, HttpStatusCode.INSTANCE.getNotFound());
            kotlin.jvm.internal.p.i(route, "route");
            kotlin.jvm.internal.p.i(reason, "reason");
        }
    }

    public /* synthetic */ RoutingResolveResult(RoutingNode routingNode, kotlin.jvm.internal.i iVar) {
        this(routingNode);
    }

    public abstract Parameters getParameters();

    public final RoutingNode getRoute() {
        return this.route;
    }

    private RoutingResolveResult(RoutingNode routingNode) {
        this.route = routingNode;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/server/routing/RoutingResolveResult$Success;", "Lio/ktor/server/routing/RoutingResolveResult;", "Lio/ktor/server/routing/RoutingNode;", M5.a.CARD_TYPE_ROUTE, "Lio/ktor/http/Parameters;", "parameters", "", "quality", "<init>", "(Lio/ktor/server/routing/RoutingNode;Lio/ktor/http/Parameters;D)V", "(Lio/ktor/server/routing/RoutingNode;Lio/ktor/http/Parameters;)V", "", "toString", "()Ljava/lang/String;", "Lio/ktor/http/Parameters;", "getParameters", "()Lio/ktor/http/Parameters;", "D", "getQuality$ktor_server_core", "()D", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Success extends RoutingResolveResult {
        private final Parameters parameters;
        private final double quality;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(RoutingNode route, Parameters parameters, double d10) {
            super(route, null);
            kotlin.jvm.internal.p.i(route, "route");
            kotlin.jvm.internal.p.i(parameters, "parameters");
            this.parameters = parameters;
            this.quality = d10;
        }

        @Override // io.ktor.server.routing.RoutingResolveResult
        public Parameters getParameters() {
            return this.parameters;
        }

        /* renamed from: getQuality$ktor_server_core, reason: from getter */
        public final double getQuality() {
            return this.quality;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(AMapLocationStaticsEntity.SUCCESS_STATUS);
            if (getParameters().isEmpty()) {
                str = "";
            } else {
                str = "; " + getParameters();
            }
            sb2.append(str);
            sb2.append(" @ ");
            sb2.append(getRoute());
            return sb2.toString();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Success(RoutingNode route, Parameters parameters) {
            this(route, parameters, 0.0d);
            kotlin.jvm.internal.p.i(route, "route");
            kotlin.jvm.internal.p.i(parameters, "parameters");
        }
    }
}
