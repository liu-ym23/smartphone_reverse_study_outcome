package io.ktor.server.sse;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.utils.CacheControl;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.server.response.ApplicationResponsePropertiesKt;
import io.ktor.server.routing.Route;
import io.ktor.server.routing.RoutingBuilderKt;
import io.ktor.server.routing.RoutingCall;
import io.ktor.server.routing.RoutingContext;
import io.ktor.server.routing.RoutingResponse;
import io.ktor.util.reflect.TypeInfo;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a=\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\t\u001a\u00020\u0006*\u00020\u00002\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0004\b\t\u0010\u000b\u001aW\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00032\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0004\b\t\u0010\u000f\u001aO\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00032\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0004\b\t\u0010\u0010\u001a7\u0010\u0011\u001a\u00020\u0006*\u00020\u00002\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u000b\u001aQ\u0010\u0012\u001a\u00020\u0006*\u00020\u00002\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00032\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0010\u001aS\u0010\u0013\u001a\u00020\u0006*\u00020\u00002\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lio/ktor/server/routing/Route;", "", "path", "Lkotlin/Function2;", "Lio/ktor/server/sse/ServerSSESession;", "Le9/c;", "LY8/t;", "", "handler", "sse", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Lp9/p;)V", "(Lio/ktor/server/routing/Route;Lp9/p;)V", "Lio/ktor/util/reflect/TypeInfo;", "serialize", "Lio/ktor/server/sse/ServerSSESessionWithSerialization;", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Lp9/p;Lp9/p;)V", "(Lio/ktor/server/routing/Route;Lp9/p;Lp9/p;)V", "processSSEWithoutSerialization", "processSSEWithSerialization", "processSSE", "ktor-server-sse"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingKt {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.sse.RoutingKt$processSSE$1", f = "Routing.kt", l = {187}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.sse.RoutingKt$processSSE$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<RoutingContext, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ p<ServerSSESession, InterfaceC4014c<? super t>, Object> $handler;
        final /* synthetic */ p<TypeInfo, Object, String> $serialize;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p<? super ServerSSESession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, p<? super TypeInfo, Object, String> pVar2, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$handler = pVar;
            this.$serialize = pVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, this.$serialize, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(routingContext, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC5755n interfaceC5755nM;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                RoutingContext routingContext = (RoutingContext) this.L$0;
                RoutingResponse response = routingContext.getCall().getResponse();
                HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
                ApplicationResponsePropertiesKt.header(response, httpHeaders.getContentType(), ContentType.Text.INSTANCE.getEventStream().toString());
                ApplicationResponsePropertiesKt.header(routingContext.getCall().getResponse(), httpHeaders.getCacheControl(), CacheControl.NO_STORE);
                ApplicationResponsePropertiesKt.header(routingContext.getCall().getResponse(), httpHeaders.getConnection(), "keep-alive");
                ApplicationResponsePropertiesKt.header(routingContext.getCall().getResponse(), "X-Accel-Buffering", "no");
                RoutingCall call = routingContext.getCall();
                SSEServerContent sSEServerContent = new SSEServerContent(routingContext.getCall(), this.$handler, this.$serialize);
                InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(SSEServerContent.class);
                try {
                    interfaceC5755nM = kotlin.jvm.internal.t.m(SSEServerContent.class);
                } catch (Throwable unused) {
                    interfaceC5755nM = null;
                }
                TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, interfaceC5755nM);
                this.label = 1;
                if (call.respond(sSEServerContent, typeInfo, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    private static final void processSSE(Route route, p<? super TypeInfo, Object, String> pVar, p<? super ServerSSESession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar2) {
        route.plugin(SSEKt.getSSE());
        route.handle(new AnonymousClass1(pVar2, pVar, null));
    }

    private static final void processSSEWithSerialization(Route route, p<? super TypeInfo, Object, String> pVar, p<? super ServerSSESessionWithSerialization, ? super InterfaceC4014c<? super t>, ? extends Object> pVar2) {
        processSSE(route, pVar, new RoutingKt$processSSEWithSerialization$sessionHandler$1(pVar2, null));
    }

    private static final void processSSEWithoutSerialization(Route route, p<? super ServerSSESession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar) {
        processSSE(route, null, pVar);
    }

    public static final void sse(Route route, String path, final p<? super ServerSSESession, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(handler, "handler");
        RoutingBuilderKt.route(route, path, HttpMethod.INSTANCE.getGet(), new InterfaceC5074l() { // from class: io.ktor.server.sse.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingKt.sse$lambda$0(handler, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t sse$lambda$0(p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        sse(route, pVar);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t sse$lambda$1(p pVar, p pVar2, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        sse(route, (p<? super TypeInfo, Object, String>) pVar, (p<? super ServerSSESessionWithSerialization, ? super InterfaceC4014c<? super t>, ? extends Object>) pVar2);
        return t.f7040a;
    }

    public static final void sse(Route route, p<? super ServerSSESession, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(handler, "handler");
        processSSEWithoutSerialization(route, handler);
    }

    public static final void sse(Route route, String path, final p<? super TypeInfo, Object, String> serialize, final p<? super ServerSSESessionWithSerialization, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(serialize, "serialize");
        kotlin.jvm.internal.p.i(handler, "handler");
        RoutingBuilderKt.route(route, path, HttpMethod.INSTANCE.getGet(), new InterfaceC5074l() { // from class: io.ktor.server.sse.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingKt.sse$lambda$1(serialize, handler, (Route) obj);
            }
        });
    }

    public static final void sse(Route route, p<? super TypeInfo, Object, String> serialize, p<? super ServerSSESessionWithSerialization, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(serialize, "serialize");
        kotlin.jvm.internal.p.i(handler, "handler");
        processSSEWithSerialization(route, serialize, handler);
    }
}
