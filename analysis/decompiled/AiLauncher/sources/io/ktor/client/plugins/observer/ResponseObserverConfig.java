package io.ktor.client.plugins.observer;

import Y8.t;
import e9.InterfaceC4014c;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import p9.p;

@KtorDsl
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u00020\u00072&\u0010\t\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\b¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u000f\u0010\u0010RB\u0010\u0011\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u000bR0\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0010¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/observer/ResponseObserverConfig;", "", "<init>", "()V", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Le9/c;", "LY8/t;", "Lio/ktor/client/plugins/observer/ResponseHandler;", "block", "onResponse", "(Lp9/p;)V", "Lkotlin/Function1;", "Lio/ktor/client/call/HttpClientCall;", "", "filter", "(Lp9/l;)V", "responseHandler", "Lp9/p;", "getResponseHandler$ktor_client_core", "()Lp9/p;", "setResponseHandler$ktor_client_core", "Lp9/l;", "getFilter$ktor_client_core", "()Lp9/l;", "setFilter$ktor_client_core", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResponseObserverConfig {
    private InterfaceC5074l<? super HttpClientCall, Boolean> filter;
    private p<? super HttpResponse, ? super InterfaceC4014c<? super t>, ? extends Object> responseHandler = new ResponseObserverConfig$responseHandler$1(null);

    public final void filter(InterfaceC5074l<? super HttpClientCall, Boolean> block) {
        kotlin.jvm.internal.p.i(block, "block");
        this.filter = block;
    }

    public final InterfaceC5074l<HttpClientCall, Boolean> getFilter$ktor_client_core() {
        return this.filter;
    }

    public final p<HttpResponse, InterfaceC4014c<? super t>, Object> getResponseHandler$ktor_client_core() {
        return this.responseHandler;
    }

    public final void onResponse(p<? super HttpResponse, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        this.responseHandler = block;
    }

    public final void setFilter$ktor_client_core(InterfaceC5074l<? super HttpClientCall, Boolean> interfaceC5074l) {
        this.filter = interfaceC5074l;
    }

    public final void setResponseHandler$ktor_client_core(p<? super HttpResponse, ? super InterfaceC4014c<? super t>, ? extends Object> pVar) {
        kotlin.jvm.internal.p.i(pVar, "<set-?>");
        this.responseHandler = pVar;
    }
}
