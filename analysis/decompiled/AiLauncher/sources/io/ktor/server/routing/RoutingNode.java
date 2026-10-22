package io.ktor.server.routing;

import La.H;
import Z8.C1173v;
import com.fasterxml.jackson.core.JsonPointer;
import e9.InterfaceC4014c;
import io.ktor.server.application.ApplicationCallPipeline;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.application.ApplicationPluginKt;
import io.ktor.server.application.Plugin;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@KtorDsl
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0013\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f0\u0011H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u001a\u001a\u00020\f2&\u0010\u0012\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015j\u0002`\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001e\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020\u00182\u0014\u0010\u001e\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJQ\u0010\"\u001a\u00028\u0001\"\b\b\u0000\u0010 *\u00020\u0018\"\b\b\u0001\u0010\u001c*\u00020\u00182\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0011H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\fH\u0016¢\u0006\u0004\b$\u0010\u000eJ\u000f\u0010'\u001a\u00020\u0001H\u0000¢\u0006\u0004\b%\u0010&J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010.\u001a\u0004\b/\u00100R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u0000018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R@\u00106\u001a(\u0012$\u0012\"\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015j\u0002`\u0019018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b6\u00103\u001a\u0004\b7\u00108R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0000098F¢\u0006\u0006\u001a\u0004\b:\u00108¨\u0006<"}, d2 = {"Lio/ktor/server/routing/RoutingNode;", "Lio/ktor/server/application/ApplicationCallPipeline;", "Lio/ktor/server/routing/Route;", "parent", "Lio/ktor/server/routing/RouteSelector;", "selector", "", "developmentMode", "Lio/ktor/server/application/ApplicationEnvironment;", "environment", "<init>", "(Lio/ktor/server/routing/RoutingNode;Lio/ktor/server/routing/RouteSelector;ZLio/ktor/server/application/ApplicationEnvironment;)V", "LY8/t;", "invalidateCachesRecursively", "()V", "createChild", "(Lio/ktor/server/routing/RouteSelector;)Lio/ktor/server/routing/RoutingNode;", "Lkotlin/Function1;", "body", "invoke", "(Lp9/l;)V", "Lkotlin/Function2;", "Lio/ktor/server/routing/RoutingContext;", "Le9/c;", "", "Lio/ktor/server/routing/RoutingHandler;", "handle", "(Lp9/p;)V", "F", "Lio/ktor/server/application/Plugin;", "plugin", "(Lio/ktor/server/application/Plugin;)Ljava/lang/Object;", "B", "configure", W4.b.STEP_INSTALL, "(Lio/ktor/server/application/Plugin;Lp9/l;)Ljava/lang/Object;", "afterIntercepted", "buildPipeline$ktor_server_core", "()Lio/ktor/server/application/ApplicationCallPipeline;", "buildPipeline", "", "toString", "()Ljava/lang/String;", "Lio/ktor/server/routing/RoutingNode;", "getParent", "()Lio/ktor/server/routing/RoutingNode;", "Lio/ktor/server/routing/RouteSelector;", "getSelector", "()Lio/ktor/server/routing/RouteSelector;", "", "childList", "Ljava/util/List;", "cachedPipeline", "Lio/ktor/server/application/ApplicationCallPipeline;", "handlers", "getHandlers$ktor_server_core", "()Ljava/util/List;", "", "getChildren", "children", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public class RoutingNode extends ApplicationCallPipeline implements Route {
    private ApplicationCallPipeline cachedPipeline;
    private final List<RoutingNode> childList;
    private final List<p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object>> handlers;
    private final RoutingNode parent;
    private final RouteSelector selector;

    public /* synthetic */ RoutingNode(RoutingNode routingNode, RouteSelector routeSelector, boolean z10, ApplicationEnvironment applicationEnvironment, int i10, kotlin.jvm.internal.i iVar) {
        this(routingNode, routeSelector, (i10 & 4) != 0 ? false : z10, applicationEnvironment);
    }

    private final void invalidateCachesRecursively() {
        this.cachedPipeline = null;
        Iterator<T> it = this.childList.iterator();
        while (it.hasNext()) {
            ((RoutingNode) it.next()).invalidateCachesRecursively();
        }
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public void afterIntercepted() {
        invalidateCachesRecursively();
    }

    public final ApplicationCallPipeline buildPipeline$ktor_server_core() {
        ApplicationCallPipeline applicationCallPipeline = this.cachedPipeline;
        if (applicationCallPipeline == null) {
            applicationCallPipeline = new ApplicationCallPipeline(getDevelopmentMode(), RoutingRootKt.getApplication(this).getEnvironment());
            ArrayList arrayList = new ArrayList();
            for (RoutingNode parent = this; parent != null; parent = parent.getParent()) {
                arrayList.add(parent);
            }
            for (int iO = C1173v.o(arrayList); -1 < iO; iO--) {
                ApplicationCallPipeline applicationCallPipeline2 = (ApplicationCallPipeline) arrayList.get(iO);
                applicationCallPipeline.merge(applicationCallPipeline2);
                applicationCallPipeline.getReceivePipeline().merge(applicationCallPipeline2.getReceivePipeline());
                applicationCallPipeline.getSendPipeline().merge(applicationCallPipeline2.getSendPipeline());
            }
            List<p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object>> list = this.handlers;
            int iO2 = C1173v.o(list);
            if (iO2 >= 0) {
                int i10 = 0;
                while (true) {
                    applicationCallPipeline.intercept(ApplicationCallPipeline.INSTANCE.getCall(), new RoutingNode$buildPipeline$1$1(list, i10, null));
                    if (i10 == iO2) {
                        break;
                    }
                    i10++;
                }
            }
            this.cachedPipeline = applicationCallPipeline;
        }
        return applicationCallPipeline;
    }

    public final List<RoutingNode> getChildren() {
        return this.childList;
    }

    public final List<p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object>> getHandlers$ktor_server_core() {
        return this.handlers;
    }

    public final RouteSelector getSelector() {
        return this.selector;
    }

    @Override // io.ktor.server.routing.Route
    public void handle(p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(body, "body");
        this.handlers.add(body);
        this.cachedPipeline = null;
    }

    @Override // io.ktor.server.routing.Route
    public <B, F> F install(Plugin<? super ApplicationCallPipeline, ? extends B, F> plugin, InterfaceC5074l<? super B, Y8.t> configure) {
        kotlin.jvm.internal.p.i(plugin, "plugin");
        kotlin.jvm.internal.p.i(configure, "configure");
        kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type io.ktor.server.application.ApplicationCallPipeline");
        return (F) ApplicationPluginKt.install(this, (Plugin<? super RoutingNode, ? extends B, F>) plugin, (InterfaceC5074l) configure);
    }

    public final void invoke(InterfaceC5074l<? super RoutingNode, Y8.t> body) {
        kotlin.jvm.internal.p.i(body, "body");
        body.invoke(this);
    }

    @Override // io.ktor.server.routing.Route
    public <F> F plugin(Plugin<?, ?, F> plugin) {
        kotlin.jvm.internal.p.i(plugin, "plugin");
        kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type io.ktor.server.application.ApplicationCallPipeline");
        return (F) ApplicationPluginKt.plugin(this, plugin);
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public String toString() {
        RoutingNode parent = getParent();
        String string = parent != null ? parent.toString() : null;
        if (string == null) {
            if (this.selector instanceof TrailingSlashRouteSelector) {
                return "/";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(JsonPointer.SEPARATOR);
            sb2.append(this.selector);
            return sb2.toString();
        }
        if (this.selector instanceof TrailingSlashRouteSelector) {
            if (H.j0(string, JsonPointer.SEPARATOR, false, 2, null)) {
                return string;
            }
            return string + JsonPointer.SEPARATOR;
        }
        if (H.j0(string, JsonPointer.SEPARATOR, false, 2, null)) {
            return string + this.selector;
        }
        return string + JsonPointer.SEPARATOR + this.selector;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoutingNode(RoutingNode routingNode, RouteSelector selector, boolean z10, ApplicationEnvironment environment) {
        super(z10, environment);
        kotlin.jvm.internal.p.i(selector, "selector");
        kotlin.jvm.internal.p.i(environment, "environment");
        this.parent = routingNode;
        this.selector = selector;
        this.childList = new ArrayList();
        this.handlers = new ArrayList();
    }

    @Override // io.ktor.server.routing.Route
    public RoutingNode createChild(RouteSelector selector) {
        Object next;
        kotlin.jvm.internal.p.i(selector, "selector");
        Iterator<T> it = this.childList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.p.d(((RoutingNode) next).selector, selector)) {
                break;
            }
        }
        RoutingNode routingNode = (RoutingNode) next;
        if (routingNode != null) {
            return routingNode;
        }
        RoutingNode routingNode2 = new RoutingNode(this, selector, getDevelopmentMode(), getEnvironment());
        this.childList.add(routingNode2);
        return routingNode2;
    }

    @Override // io.ktor.server.routing.Route
    public RoutingNode getParent() {
        return this.parent;
    }
}
