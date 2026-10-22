package io.ktor.server.cio.backend;

import Ua.C1056g;
import Ua.C1060i;
import Ua.C1087w;
import Ua.CoroutineName;
import Ua.InterfaceC1083u;
import Ua.InterfaceC1089x;
import Ua.L0;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import io.ktor.http.cio.Request;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.selector.SelectorManagerKt;
import io.ktor.server.cio.HttpServer;
import io.ktor.server.cio.HttpServerSettings;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.time.DurationUnit;
import kotlin.time.a;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobKt__JobKt;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012,\u0010\n\u001a(\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003j\u0002`\t¢\u0006\u0004\b\f\u0010\r\"\u0018\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"LUa/M;", "Lio/ktor/server/cio/HttpServerSettings;", "settings", "Lkotlin/Function3;", "Lio/ktor/server/cio/backend/ServerRequestScope;", "Lio/ktor/http/cio/Request;", "Le9/c;", "LY8/t;", "", "Lio/ktor/server/cio/HttpRequestHandler;", "handler", "Lio/ktor/server/cio/HttpServer;", "httpServer", "(LUa/M;Lio/ktor/server/cio/HttpServerSettings;Lp9/q;)Lio/ktor/server/cio/HttpServer;", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "ktor-server-cio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpServerKt {
    private static final vc.c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.server.cio.HttpServer");

    public static final HttpServer httpServer(M m10, HttpServerSettings settings, q<? super ServerRequestScope, ? super Request, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        p.i(m10, "<this>");
        p.i(settings, "settings");
        p.i(handler, "handler");
        final InterfaceC1083u interfaceC1083uC = C1087w.c(null, 1, null);
        final InterfaceC1089x interfaceC1089xB = JobKt__JobKt.b(null, 1, null);
        kotlinx.coroutines.g gVarC = C1056g.c(m10, new CoroutineName("server-root-" + settings), CoroutineStart.UNDISPATCHED, new HttpServerKt$httpServer$serverJob$1(interfaceC1089xB, null));
        final SelectorManager SelectorManager = SelectorManagerKt.SelectorManager(m10.getCoroutineContext());
        a.Companion companion = kotlin.time.a.INSTANCE;
        long jT = kotlin.time.b.t(settings.getConnectionIdleTimeoutSeconds(), DurationUnit.SECONDS);
        kotlinx.coroutines.g gVarD = C1060i.d(m10, gVarC.plus(new CoroutineName("accept-" + settings)), null, new HttpServerKt$httpServer$acceptJob$1(SelectorManager, settings, interfaceC1083uC, L0.a(gVarC), jT, handler, null), 2, null);
        gVarD.J(new InterfaceC5074l() { // from class: io.ktor.server.cio.backend.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpServerKt.httpServer$lambda$1(interfaceC1089xB, interfaceC1083uC, (Throwable) obj);
            }
        });
        gVarC.J(new InterfaceC5074l() { // from class: io.ktor.server.cio.backend.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpServerKt.httpServer$lambda$2(SelectorManager, (Throwable) obj);
            }
        });
        return new HttpServer(gVarC, gVarD, interfaceC1083uC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t httpServer$lambda$1(InterfaceC1089x interfaceC1089x, InterfaceC1083u interfaceC1083u, Throwable th) {
        if (th != null) {
            interfaceC1083u.e(th);
        }
        interfaceC1089x.complete();
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t httpServer$lambda$2(SelectorManager selectorManager, Throwable th) throws IOException {
        selectorManager.close();
        return t.f7040a;
    }
}
