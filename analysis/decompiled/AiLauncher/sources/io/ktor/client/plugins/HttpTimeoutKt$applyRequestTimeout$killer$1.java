package io.ktor.client.plugins;

import Ua.C1086v0;
import Ua.M;
import Ua.U;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.logging.LoggerJvmKt;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.HttpTimeoutKt$applyRequestTimeout$killer$1", f = "HttpTimeout.kt", l = {184}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class HttpTimeoutKt$applyRequestTimeout$killer$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ kotlinx.coroutines.g $executionContext;
    final /* synthetic */ HttpRequestBuilder $request;
    final /* synthetic */ Long $requestTimeout;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTimeoutKt$applyRequestTimeout$killer$1(Long l10, HttpRequestBuilder httpRequestBuilder, kotlinx.coroutines.g gVar, InterfaceC4014c<? super HttpTimeoutKt$applyRequestTimeout$killer$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$requestTimeout = l10;
        this.$request = httpRequestBuilder;
        this.$executionContext = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new HttpTimeoutKt$applyRequestTimeout$killer$1(this.$requestTimeout, this.$request, this.$executionContext, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((HttpTimeoutKt$applyRequestTimeout$killer$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            long jLongValue = this.$requestTimeout.longValue();
            this.label = 1;
            if (U.a(jLongValue, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        HttpRequestTimeoutException httpRequestTimeoutException = new HttpRequestTimeoutException(this.$request);
        vc.c cVar = HttpTimeoutKt.LOGGER;
        HttpRequestBuilder httpRequestBuilder = this.$request;
        if (LoggerJvmKt.isTraceEnabled(cVar)) {
            cVar.trace("Request timeout: " + httpRequestBuilder.getUrl());
        }
        kotlinx.coroutines.g gVar = this.$executionContext;
        String message = httpRequestTimeoutException.getMessage();
        kotlin.jvm.internal.p.f(message);
        C1086v0.d(gVar, message, httpRequestTimeoutException);
        return Y8.t.f7040a;
    }
}
