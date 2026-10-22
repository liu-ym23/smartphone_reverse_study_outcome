package io.ktor.client.plugins;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.plugins.api.OnRequestContext;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.HttpHeaders;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lio/ktor/client/plugins/api/OnRequestContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "", "<unused var>", "LY8/t;", "<anonymous>", "(Lio/ktor/client/plugins/api/OnRequestContext;Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Object;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.UserAgentKt$UserAgent$3$1", f = "UserAgent.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class UserAgentKt$UserAgent$3$1 extends SuspendLambda implements p9.r<OnRequestContext, HttpRequestBuilder, Object, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $agent;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAgentKt$UserAgent$3$1(String str, InterfaceC4014c<? super UserAgentKt$UserAgent$3$1> interfaceC4014c) {
        super(4, interfaceC4014c);
        this.$agent = str;
    }

    @Override // p9.r
    public final Object invoke(OnRequestContext onRequestContext, HttpRequestBuilder httpRequestBuilder, Object obj, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        UserAgentKt$UserAgent$3$1 userAgentKt$UserAgent$3$1 = new UserAgentKt$UserAgent$3$1(this.$agent, interfaceC4014c);
        userAgentKt$UserAgent$3$1.L$0 = httpRequestBuilder;
        return userAgentKt$UserAgent$3$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        UserAgentKt.LOGGER.trace("Adding User-Agent header: agent for " + httpRequestBuilder.getUrl());
        UtilsKt.header(httpRequestBuilder, HttpHeaders.INSTANCE.getUserAgent(), this.$agent);
        return Y8.t.f7040a;
    }
}
