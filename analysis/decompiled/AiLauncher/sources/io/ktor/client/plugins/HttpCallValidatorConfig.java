package io.ktor.client.plugins;

import e9.InterfaceC4014c;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@KtorDsl
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u000b\u001a\u00020\b2,\u0010\n\u001a(\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\t¢\u0006\u0004\b\u000b\u0010\fJ;\u0010\r\u001a\u00020\b2,\u0010\n\u001a(\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\t¢\u0006\u0004\b\r\u0010\fJ5\u0010\u0011\u001a\u00020\b2&\u0010\n\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000ej\u0002`\u0010¢\u0006\u0004\b\u0011\u0010\u0012R@\u0010\u0014\u001a(\u0012$\u0012\"\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000ej\u0002`\u00100\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\"\u0010\u001c\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lio/ktor/client/plugins/HttpCallValidatorConfig;", "", "<init>", "()V", "Lkotlin/Function3;", "", "Lio/ktor/client/request/HttpRequest;", "Le9/c;", "LY8/t;", "Lio/ktor/client/plugins/CallRequestExceptionHandler;", "block", "handleResponseException", "(Lp9/q;)V", "handleResponseExceptionWithRequest", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/plugins/ResponseValidator;", "validateResponse", "(Lp9/p;)V", "", "responseValidators", "Ljava/util/List;", "getResponseValidators$ktor_client_core", "()Ljava/util/List;", "Lio/ktor/client/plugins/HandlerWrapper;", "responseExceptionHandlers", "getResponseExceptionHandlers$ktor_client_core", "", "expectSuccess", "Z", "getExpectSuccess$ktor_client_core", "()Z", "setExpectSuccess$ktor_client_core", "(Z)V", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpCallValidatorConfig {
    private final List<p9.p<HttpResponse, InterfaceC4014c<? super Y8.t>, Object>> responseValidators = new ArrayList();
    private final List<HandlerWrapper> responseExceptionHandlers = new ArrayList();
    private boolean expectSuccess = true;

    /* renamed from: getExpectSuccess$ktor_client_core, reason: from getter */
    public final boolean getExpectSuccess() {
        return this.expectSuccess;
    }

    public final List<HandlerWrapper> getResponseExceptionHandlers$ktor_client_core() {
        return this.responseExceptionHandlers;
    }

    public final List<p9.p<HttpResponse, InterfaceC4014c<? super Y8.t>, Object>> getResponseValidators$ktor_client_core() {
        return this.responseValidators;
    }

    public final void handleResponseException(p9.q<? super Throwable, ? super HttpRequest, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        this.responseExceptionHandlers.add(new RequestExceptionHandlerWrapper(block));
    }

    public final void handleResponseExceptionWithRequest(p9.q<? super Throwable, ? super HttpRequest, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        this.responseExceptionHandlers.add(new RequestExceptionHandlerWrapper(block));
    }

    public final void setExpectSuccess$ktor_client_core(boolean z10) {
        this.expectSuccess = z10;
    }

    public final void validateResponse(p9.p<? super HttpResponse, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        this.responseValidators.add(block);
    }
}
