package io.ktor.server.routing;

import e9.InterfaceC4014c;
import io.ktor.server.application.ApplicationCallPipeline;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.application.Plugin;
import io.ktor.server.routing.Route;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J7\u0010\b\u001a\u00020\u00052&\u0010\u0007\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002j\u0002`\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0010\u001a\u00028\u0000\"\b\b\u0000\u0010\u000e*\u00020\u00012\u0014\u0010\u0010\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011JS\u0010\u0016\u001a\u00028\u0001\"\b\b\u0000\u0010\u0012*\u00020\u0001\"\b\b\u0001\u0010\u000e*\u00020\u00012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f2\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u0004\u0018\u00010\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lio/ktor/server/routing/Route;", "", "Lkotlin/Function2;", "Lio/ktor/server/routing/RoutingContext;", "Le9/c;", "LY8/t;", "Lio/ktor/server/routing/RoutingHandler;", "body", "handle", "(Lp9/p;)V", "Lio/ktor/server/routing/RouteSelector;", "selector", "createChild", "(Lio/ktor/server/routing/RouteSelector;)Lio/ktor/server/routing/Route;", "F", "Lio/ktor/server/application/Plugin;", "plugin", "(Lio/ktor/server/application/Plugin;)Ljava/lang/Object;", "B", "Lio/ktor/server/application/ApplicationCallPipeline;", "Lkotlin/Function1;", "configure", W4.b.STEP_INSTALL, "(Lio/ktor/server/application/Plugin;Lp9/l;)Ljava/lang/Object;", "Lio/ktor/server/application/ApplicationEnvironment;", "getEnvironment", "()Lio/ktor/server/application/ApplicationEnvironment;", "environment", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "attributes", "getParent", "()Lio/ktor/server/routing/Route;", "parent", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Route {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object install$default(Route route, Plugin plugin, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: install");
            }
            if ((i10 & 2) != 0) {
                interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.routing.i
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj2) {
                        return Route.DefaultImpls.install$lambda$0(obj2);
                    }
                };
            }
            return route.install(plugin, interfaceC5074l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Y8.t install$lambda$0(Object obj) {
            kotlin.jvm.internal.p.i(obj, "<this>");
            return Y8.t.f7040a;
        }
    }

    Route createChild(RouteSelector selector);

    Attributes getAttributes();

    ApplicationEnvironment getEnvironment();

    Route getParent();

    void handle(p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body);

    <B, F> F install(Plugin<? super ApplicationCallPipeline, ? extends B, F> plugin, InterfaceC5074l<? super B, Y8.t> configure);

    <F> F plugin(Plugin<?, ?, F> plugin);
}
