package io.ktor.client.plugins;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/api/Send$Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$2", f = "HttpCallValidator.kt", l = {128, 129}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class HttpCallValidatorKt$HttpCallValidator$2$2 extends SuspendLambda implements p9.q<Send.Sender, HttpRequestBuilder, InterfaceC4014c<? super HttpClientCall>, Object> {
    final /* synthetic */ List<p9.p<HttpResponse, InterfaceC4014c<? super Y8.t>, Object>> $responseValidators;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HttpCallValidatorKt$HttpCallValidator$2$2(List<? extends p9.p<? super HttpResponse, ? super InterfaceC4014c<? super Y8.t>, ? extends Object>> list, InterfaceC4014c<? super HttpCallValidatorKt$HttpCallValidator$2$2> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$responseValidators = list;
    }

    @Override // p9.q
    public final Object invoke(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpClientCall> interfaceC4014c) {
        HttpCallValidatorKt$HttpCallValidator$2$2 httpCallValidatorKt$HttpCallValidator$2$2 = new HttpCallValidatorKt$HttpCallValidator$2$2(this.$responseValidators, interfaceC4014c);
        httpCallValidatorKt$HttpCallValidator$2$2.L$0 = sender;
        httpCallValidatorKt$HttpCallValidator$2$2.L$1 = httpRequestBuilder;
        return httpCallValidatorKt$HttpCallValidator$2$2.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Send.Sender sender = (Send.Sender) this.L$0;
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            this.L$0 = g9.h.a(sender);
            this.L$1 = g9.h.a(httpRequestBuilder);
            this.label = 1;
            obj = sender.proceed(httpRequestBuilder, this);
            if (obj != objG) {
            }
        }
        if (i10 != 1) {
            if (i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            HttpClientCall httpClientCall = (HttpClientCall) this.L$2;
            C4849c.b(obj);
            return httpClientCall;
        }
        C4849c.b(obj);
        HttpClientCall httpClientCall2 = (HttpClientCall) obj;
        List<p9.p<HttpResponse, InterfaceC4014c<? super Y8.t>, Object>> list = this.$responseValidators;
        HttpResponse response = httpClientCall2.getResponse();
        this.L$0 = g9.h.a(sender);
        this.L$1 = g9.h.a(httpRequestBuilder);
        this.L$2 = httpClientCall2;
        this.label = 2;
        return HttpCallValidatorKt.HttpCallValidator$lambda$2$validateResponse(list, response, this) == objG ? objG : httpClientCall2;
    }
}
