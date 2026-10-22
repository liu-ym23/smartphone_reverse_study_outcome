package io.ktor.client.plugins;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/api/Send$Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "io.ktor.client.plugins.HttpRequestRetryKt$HttpRequestRetry$2$1", f = "HttpRequestRetry.kt", l = {352, 355, 371}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class HttpRequestRetryKt$HttpRequestRetry$2$1 extends SuspendLambda implements p9.q<Send.Sender, HttpRequestBuilder, InterfaceC4014c<? super HttpClientCall>, Object> {
    final /* synthetic */ p9.p<Long, InterfaceC4014c<? super Y8.t>, Object> $delay;
    final /* synthetic */ p9.p<HttpRetryDelayContext, Integer, Long> $delayMillis;
    final /* synthetic */ int $maxRetries;
    final /* synthetic */ p9.p<HttpRetryModifyRequestContext, HttpRequestBuilder, Y8.t> $modifyRequest;
    final /* synthetic */ p9.q<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean> $shouldRetry;
    final /* synthetic */ p9.q<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> $shouldRetryOnException;
    final /* synthetic */ ClientPluginBuilder<HttpRequestRetryConfig> $this_createClientPlugin;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequestRetryKt$HttpRequestRetry$2$1(p9.q<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> qVar, p9.q<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> qVar2, int i10, p9.p<? super HttpRetryDelayContext, ? super Integer, Long> pVar, p9.p<? super HttpRetryModifyRequestContext, ? super HttpRequestBuilder, Y8.t> pVar2, ClientPluginBuilder<HttpRequestRetryConfig> clientPluginBuilder, p9.p<? super Long, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar3, InterfaceC4014c<? super HttpRequestRetryKt$HttpRequestRetry$2$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$shouldRetry = qVar;
        this.$shouldRetryOnException = qVar2;
        this.$maxRetries = i10;
        this.$delayMillis = pVar;
        this.$modifyRequest = pVar2;
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$delay = pVar3;
    }

    @Override // p9.q
    public final Object invoke(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpClientCall> interfaceC4014c) {
        HttpRequestRetryKt$HttpRequestRetry$2$1 httpRequestRetryKt$HttpRequestRetry$2$1 = new HttpRequestRetryKt$HttpRequestRetry$2$1(this.$shouldRetry, this.$shouldRetryOnException, this.$maxRetries, this.$delayMillis, this.$modifyRequest, this.$this_createClientPlugin, this.$delay, interfaceC4014c);
        httpRequestRetryKt$HttpRequestRetry$2$1.L$0 = sender;
        httpRequestRetryKt$HttpRequestRetry$2$1.L$1 = httpRequestBuilder;
        return httpRequestRetryKt$HttpRequestRetry$2$1.invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:7|8|80|38|(2:94|40)(1:44)|45|46|96|47|(6:50|88|51|84|52|(6:86|54|55|92|56|(0)(1:59))(5:64|65|66|76|(10:79|8|80|38|(0)(0)|45|46|96|47|(0))))|78) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:50|(1:88)|51|84|52|(6:86|54|55|92|56|(0)(1:59))(5:64|65|66|76|(10:79|8|80|38|(0)(0)|45|46|96|47|(0)))) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01e1, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01e2, code lost:
    
        r2 = r3;
        r3 = r5;
        r5 = r7;
        r12 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01ee, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0191 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x026d -> B:8:0x0051). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 671
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestRetryKt$HttpRequestRetry$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
