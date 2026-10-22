package io.ktor.server.routing;

import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationPluginKt;
import io.ktor.server.routing.RoutingRoot;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.InternalAPI;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\"&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\"\u001e\u0010\u0012\u001a\u00060\u0010j\u0002`\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\" \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0015\u0010\u001c\u001a\u00020\u0000*\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lio/ktor/server/application/Application;", "Lkotlin/Function1;", "Lio/ktor/server/routing/Routing;", "LY8/t;", "configuration", "Lio/ktor/server/routing/RoutingRoot;", "routing", "(Lio/ktor/server/application/Application;Lp9/l;)Lio/ktor/server/routing/RoutingRoot;", "Lio/ktor/util/AttributeKey;", "Lio/ktor/http/HttpStatusCode;", "RoutingFailureStatusCode", "Lio/ktor/util/AttributeKey;", "getRoutingFailureStatusCode", "()Lio/ktor/util/AttributeKey;", "getRoutingFailureStatusCode$annotations", "()V", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "getLOGGER", "()Lvc/c;", "Lio/ktor/server/routing/RoutingCall;", "routingCallKey", "getRoutingCallKey", "Lio/ktor/server/routing/Route;", "getApplication", "(Lio/ktor/server/routing/Route;)Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingRootKt {
    private static final vc.c LOGGER;
    private static final AttributeKey<HttpStatusCode> RoutingFailureStatusCode;
    private static final AttributeKey<RoutingCall> routingCallKey;

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(HttpStatusCode.class);
        InterfaceC5755n interfaceC5755nM2 = null;
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(HttpStatusCode.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        RoutingFailureStatusCode = new AttributeKey<>("RoutingFailureStatusCode", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.server.routing.Routing");
        InterfaceC5745d interfaceC5745dB2 = kotlin.jvm.internal.t.b(RoutingCall.class);
        try {
            interfaceC5755nM2 = kotlin.jvm.internal.t.m(RoutingCall.class);
        } catch (Throwable unused2) {
        }
        routingCallKey = new AttributeKey<>("RoutingHandler", new TypeInfo(interfaceC5745dB2, interfaceC5755nM2));
    }

    public static final Application getApplication(Route route) {
        Application application;
        kotlin.jvm.internal.p.i(route, "<this>");
        if (route instanceof RoutingRoot) {
            return ((RoutingRoot) route).getApplication();
        }
        Route parent = route.getParent();
        if (parent == null || (application = getApplication(parent)) == null) {
            throw new UnsupportedOperationException("Cannot retrieve application from unattached routing entry");
        }
        return application;
    }

    public static final vc.c getLOGGER() {
        return LOGGER;
    }

    public static final AttributeKey<RoutingCall> getRoutingCallKey() {
        return routingCallKey;
    }

    public static final AttributeKey<HttpStatusCode> getRoutingFailureStatusCode() {
        return RoutingFailureStatusCode;
    }

    @InternalAPI
    public static /* synthetic */ void getRoutingFailureStatusCode$annotations() {
    }

    @KtorDsl
    public static final RoutingRoot routing(Application application, InterfaceC5074l<? super Routing, Y8.t> configuration) {
        kotlin.jvm.internal.p.i(application, "<this>");
        kotlin.jvm.internal.p.i(configuration, "configuration");
        RoutingRoot.Companion plugin = RoutingRoot.INSTANCE;
        RoutingRoot routingRoot = (RoutingRoot) ApplicationPluginKt.pluginOrNull(application, plugin);
        if (routingRoot == null) {
            return (RoutingRoot) ApplicationPluginKt.install(application, plugin, configuration);
        }
        configuration.invoke(routingRoot);
        return routingRoot;
    }
}
