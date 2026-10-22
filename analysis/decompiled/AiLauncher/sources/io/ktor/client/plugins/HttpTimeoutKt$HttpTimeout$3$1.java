package io.ktor.client.plugins;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/api/Send$Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "io.ktor.client.plugins.HttpTimeoutKt$HttpTimeout$3$1", f = "HttpTimeout.kt", l = {168}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class HttpTimeoutKt$HttpTimeout$3$1 extends SuspendLambda implements p9.q<Send.Sender, HttpRequestBuilder, InterfaceC4014c<? super HttpClientCall>, Object> {
    final /* synthetic */ Long $connectTimeoutMillis;
    final /* synthetic */ Long $requestTimeoutMillis;
    final /* synthetic */ Long $socketTimeoutMillis;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTimeoutKt$HttpTimeout$3$1(Long l10, Long l11, Long l12, InterfaceC4014c<? super HttpTimeoutKt$HttpTimeout$3$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$requestTimeoutMillis = l10;
        this.$connectTimeoutMillis = l11;
        this.$socketTimeoutMillis = l12;
    }

    @Override // p9.q
    public final Object invoke(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpClientCall> interfaceC4014c) {
        HttpTimeoutKt$HttpTimeout$3$1 httpTimeoutKt$HttpTimeout$3$1 = new HttpTimeoutKt$HttpTimeout$3$1(this.$requestTimeoutMillis, this.$connectTimeoutMillis, this.$socketTimeoutMillis, interfaceC4014c);
        httpTimeoutKt$HttpTimeout$3$1.L$0 = sender;
        httpTimeoutKt$HttpTimeout$3$1.L$1 = httpRequestBuilder;
        return httpTimeoutKt$HttpTimeout$3$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Send.Sender sender = (Send.Sender) this.L$0;
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        boolean supportsRequestTimeout = HttpTimeoutKt.getSupportsRequestTimeout(httpRequestBuilder);
        HttpTimeoutCapability httpTimeoutCapability = HttpTimeoutCapability.INSTANCE;
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) httpRequestBuilder.getCapabilityOrNull(httpTimeoutCapability);
        if (httpTimeoutConfig == null && HttpTimeoutKt.HttpTimeout$lambda$1$hasNotNullTimeouts(this.$requestTimeoutMillis, this.$connectTimeoutMillis, this.$socketTimeoutMillis, supportsRequestTimeout)) {
            HttpTimeoutConfig httpTimeoutConfig2 = new HttpTimeoutConfig(null, null, null, 7, null);
            httpRequestBuilder.setCapability(httpTimeoutCapability, httpTimeoutConfig2);
            httpTimeoutConfig = httpTimeoutConfig2;
        }
        if (httpTimeoutConfig != null) {
            Long l10 = this.$connectTimeoutMillis;
            Long l11 = this.$socketTimeoutMillis;
            Long l12 = this.$requestTimeoutMillis;
            Long l13 = httpTimeoutConfig.get_connectTimeoutMillis();
            if (l13 != null) {
                l10 = l13;
            }
            httpTimeoutConfig.setConnectTimeoutMillis(l10);
            Long l14 = httpTimeoutConfig.get_socketTimeoutMillis();
            if (l14 != null) {
                l11 = l14;
            }
            httpTimeoutConfig.setSocketTimeoutMillis(l11);
            if (supportsRequestTimeout) {
                Long l15 = httpTimeoutConfig.get_requestTimeoutMillis();
                if (l15 != null) {
                    l12 = l15;
                }
                httpTimeoutConfig.setRequestTimeoutMillis(l12);
                HttpTimeoutKt.applyRequestTimeout(sender, httpRequestBuilder, httpTimeoutConfig.get_requestTimeoutMillis());
            }
        }
        this.L$0 = g9.h.a(sender);
        this.L$1 = g9.h.a(httpRequestBuilder);
        this.L$2 = g9.h.a(httpTimeoutConfig);
        this.Z$0 = supportsRequestTimeout;
        this.label = 1;
        Object objProceed = sender.proceed(httpRequestBuilder, this);
        return objProceed == objG ? objG : objProceed;
    }
}
