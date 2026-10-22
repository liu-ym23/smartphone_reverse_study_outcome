package io.ktor.client.plugins;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "request", "LY8/t;", "<anonymous>", "(Lio/ktor/client/request/HttpRequestBuilder;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$1", f = "HttpCallValidator.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class HttpCallValidatorKt$HttpCallValidator$2$1 extends SuspendLambda implements p9.p<HttpRequestBuilder, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ boolean $expectSuccess;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidatorKt$HttpCallValidator$2$1(boolean z10, InterfaceC4014c<? super HttpCallValidatorKt$HttpCallValidator$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$expectSuccess = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(boolean z10) {
        return z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        HttpCallValidatorKt$HttpCallValidator$2$1 httpCallValidatorKt$HttpCallValidator$2$1 = new HttpCallValidatorKt$HttpCallValidator$2$1(this.$expectSuccess, interfaceC4014c);
        httpCallValidatorKt$HttpCallValidator$2$1.L$0 = obj;
        return httpCallValidatorKt$HttpCallValidator$2$1;
    }

    @Override // p9.p
    public final Object invoke(HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((HttpCallValidatorKt$HttpCallValidator$2$1) create(httpRequestBuilder, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Attributes attributes = httpRequestBuilder.getAttributes();
        AttributeKey<Boolean> expectSuccessAttributeKey = HttpCallValidatorKt.getExpectSuccessAttributeKey();
        final boolean z10 = this.$expectSuccess;
        attributes.computeIfAbsent(expectSuccessAttributeKey, new InterfaceC5063a() { // from class: io.ktor.client.plugins.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(HttpCallValidatorKt$HttpCallValidator$2$1.invokeSuspend$lambda$0(z10));
            }
        });
        return Y8.t.f7040a;
    }
}
