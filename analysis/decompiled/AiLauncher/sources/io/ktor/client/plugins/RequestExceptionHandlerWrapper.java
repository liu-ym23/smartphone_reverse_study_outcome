package io.ktor.client.plugins;

import e9.InterfaceC4014c;
import io.ktor.client.request.HttpRequest;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B5\u0012,\u0010\t\u001a(\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002j\u0002`\b¢\u0006\u0004\b\n\u0010\u000bR=\u0010\t\u001a(\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002j\u0002`\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/RequestExceptionHandlerWrapper;", "Lio/ktor/client/plugins/HandlerWrapper;", "Lkotlin/Function3;", "", "Lio/ktor/client/request/HttpRequest;", "Le9/c;", "LY8/t;", "", "Lio/ktor/client/plugins/CallRequestExceptionHandler;", "handler", "<init>", "(Lp9/q;)V", "Lp9/q;", "getHandler", "()Lp9/q;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RequestExceptionHandlerWrapper implements HandlerWrapper {
    private final p9.q<Throwable, HttpRequest, InterfaceC4014c<? super Y8.t>, Object> handler;

    /* JADX WARN: Multi-variable type inference failed */
    public RequestExceptionHandlerWrapper(p9.q<? super Throwable, ? super HttpRequest, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(handler, "handler");
        this.handler = handler;
    }

    public final p9.q<Throwable, HttpRequest, InterfaceC4014c<? super Y8.t>, Object> getHandler() {
        return this.handler;
    }
}
