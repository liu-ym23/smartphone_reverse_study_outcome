package io.ktor.client.plugins;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/api/Send$Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "io.ktor.client.plugins.HttpRedirectKt$HttpRedirect$2$1", f = "HttpRedirect.kt", l = {112, 117}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class HttpRedirectKt$HttpRedirect$2$1 extends SuspendLambda implements p9.q<Send.Sender, HttpRequestBuilder, InterfaceC4014c<? super HttpClientCall>, Object> {
    final /* synthetic */ boolean $allowHttpsDowngrade;
    final /* synthetic */ boolean $checkHttpMethod;
    final /* synthetic */ ClientPluginBuilder<HttpRedirectConfig> $this_createClientPlugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRedirectKt$HttpRedirect$2$1(boolean z10, boolean z11, ClientPluginBuilder<HttpRedirectConfig> clientPluginBuilder, InterfaceC4014c<? super HttpRedirectKt$HttpRedirect$2$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$checkHttpMethod = z10;
        this.$allowHttpsDowngrade = z11;
        this.$this_createClientPlugin = clientPluginBuilder;
    }

    @Override // p9.q
    public final Object invoke(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpClientCall> interfaceC4014c) {
        HttpRedirectKt$HttpRedirect$2$1 httpRedirectKt$HttpRedirect$2$1 = new HttpRedirectKt$HttpRedirect$2$1(this.$checkHttpMethod, this.$allowHttpsDowngrade, this.$this_createClientPlugin, interfaceC4014c);
        httpRedirectKt$HttpRedirect$2$1.L$0 = sender;
        httpRedirectKt$HttpRedirect$2$1.L$1 = httpRequestBuilder;
        return httpRedirectKt$HttpRedirect$2$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Send.Sender sender = (Send.Sender) this.L$0;
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            this.L$0 = sender;
            this.L$1 = httpRequestBuilder;
            this.label = 1;
            obj = sender.proceed(httpRequestBuilder, this);
            if (obj != objG) {
            }
        }
        if (i10 != 1) {
            if (i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        HttpClientCall httpClientCall = (HttpClientCall) obj;
        if (this.$checkHttpMethod && !HttpRedirectKt.ALLOWED_FOR_REDIRECT.contains(httpClientCall.getRequest().getMethod())) {
            return httpClientCall;
        }
        boolean z10 = this.$allowHttpsDowngrade;
        HttpClient client = this.$this_createClientPlugin.getClient();
        this.L$0 = g9.h.a(sender);
        this.L$1 = g9.h.a(httpRequestBuilder);
        this.L$2 = g9.h.a(httpClientCall);
        this.label = 2;
        Object objHttpRedirect$lambda$1$handleCall = HttpRedirectKt.HttpRedirect$lambda$1$handleCall(sender, httpRequestBuilder, httpClientCall, z10, client, this);
        return objHttpRedirect$lambda$1$handleCall == objG ? objG : objHttpRedirect$lambda$1$handleCall;
    }
}
