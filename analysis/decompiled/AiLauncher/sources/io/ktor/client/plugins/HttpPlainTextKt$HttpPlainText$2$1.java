package io.ktor.client.plugins;

import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import java.nio.charset.Charset;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lio/ktor/http/content/OutgoingContent;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$2$1", f = "HttpPlainText.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class HttpPlainTextKt$HttpPlainText$2$1 extends SuspendLambda implements p9.q<HttpRequestBuilder, Object, InterfaceC4014c<? super OutgoingContent>, Object> {
    final /* synthetic */ String $acceptCharsetHeader;
    final /* synthetic */ Charset $requestCharset;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpPlainTextKt$HttpPlainText$2$1(String str, Charset charset, InterfaceC4014c<? super HttpPlainTextKt$HttpPlainText$2$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$acceptCharsetHeader = str;
        this.$requestCharset = charset;
    }

    @Override // p9.q
    public final Object invoke(HttpRequestBuilder httpRequestBuilder, Object obj, InterfaceC4014c<? super OutgoingContent> interfaceC4014c) {
        HttpPlainTextKt$HttpPlainText$2$1 httpPlainTextKt$HttpPlainText$2$1 = new HttpPlainTextKt$HttpPlainText$2$1(this.$acceptCharsetHeader, this.$requestCharset, interfaceC4014c);
        httpPlainTextKt$HttpPlainText$2$1.L$0 = httpRequestBuilder;
        httpPlainTextKt$HttpPlainText$2$1.L$1 = obj;
        return httpPlainTextKt$HttpPlainText$2$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$0;
        Object obj2 = this.L$1;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        HttpPlainTextKt.HttpPlainText$lambda$6$addCharsetHeaders(this.$acceptCharsetHeader, httpRequestBuilder);
        if (!(obj2 instanceof String)) {
            return null;
        }
        ContentType contentType = HttpMessagePropertiesKt.contentType(httpRequestBuilder);
        if (contentType == null || kotlin.jvm.internal.p.d(contentType.getContentType(), ContentType.Text.INSTANCE.getPlain().getContentType())) {
            return HttpPlainTextKt.HttpPlainText$lambda$6$wrapContent(this.$requestCharset, httpRequestBuilder, (String) obj2, contentType);
        }
        return null;
    }
}
