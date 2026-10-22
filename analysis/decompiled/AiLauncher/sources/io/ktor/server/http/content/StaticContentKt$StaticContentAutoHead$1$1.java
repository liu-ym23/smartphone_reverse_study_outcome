package io.ktor.server.http.content;

import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.hooks.ResponseBodyReadyForSend;
import io.ktor.util.AttributeKey;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lio/ktor/server/application/hooks/ResponseBodyReadyForSend$Context;", "Lio/ktor/server/application/ApplicationCall;", "call", "Lio/ktor/http/content/OutgoingContent;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "LY8/t;", "<anonymous>", "(Lio/ktor/server/application/hooks/ResponseBodyReadyForSend$Context;Lio/ktor/server/application/ApplicationCall;Lio/ktor/http/content/OutgoingContent;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt$StaticContentAutoHead$1$1", f = "StaticContent.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class StaticContentKt$StaticContentAutoHead$1$1 extends SuspendLambda implements p9.r<ResponseBodyReadyForSend.Context, ApplicationCall, OutgoingContent, InterfaceC4014c<? super Y8.t>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    public StaticContentKt$StaticContentAutoHead$1$1(InterfaceC4014c<? super StaticContentKt$StaticContentAutoHead$1$1> interfaceC4014c) {
        super(4, interfaceC4014c);
    }

    @Override // p9.r
    public final Object invoke(ResponseBodyReadyForSend.Context context, ApplicationCall applicationCall, OutgoingContent outgoingContent, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        StaticContentKt$StaticContentAutoHead$1$1 staticContentKt$StaticContentAutoHead$1$1 = new StaticContentKt$StaticContentAutoHead$1$1(interfaceC4014c);
        staticContentKt$StaticContentAutoHead$1$1.L$0 = context;
        staticContentKt$StaticContentAutoHead$1$1.L$1 = applicationCall;
        staticContentKt$StaticContentAutoHead$1$1.L$2 = outgoingContent;
        return staticContentKt$StaticContentAutoHead$1$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        ResponseBodyReadyForSend.Context context = (ResponseBodyReadyForSend.Context) this.L$0;
        ApplicationCall applicationCall = (ApplicationCall) this.L$1;
        final OutgoingContent outgoingContent = (OutgoingContent) this.L$2;
        if (!kotlin.jvm.internal.p.d(applicationCall.getRequest().getLocal().getMethod(), HttpMethod.INSTANCE.getHead())) {
            throw new IllegalStateException("Check failed.");
        }
        if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            ((OutgoingContent.ReadChannelContent) outgoingContent).readFrom().cancel(null);
        }
        context.transformBodyTo(new OutgoingContent.NoContent(outgoingContent) { // from class: io.ktor.server.http.content.StaticContentKt$StaticContentAutoHead$1$HeadResponse
            private final OutgoingContent original;

            {
                kotlin.jvm.internal.p.i(outgoingContent, "original");
                this.original = outgoingContent;
            }

            @Override // io.ktor.http.content.OutgoingContent
            public Long getContentLength() {
                return this.original.getContentLength();
            }

            @Override // io.ktor.http.content.OutgoingContent
            public ContentType getContentType() {
                return this.original.getContentType();
            }

            @Override // io.ktor.http.content.OutgoingContent
            public Headers getHeaders() {
                return this.original.getHeaders();
            }

            public final OutgoingContent getOriginal() {
                return this.original;
            }

            @Override // io.ktor.http.content.OutgoingContent
            public <T> T getProperty(AttributeKey<T> key) {
                kotlin.jvm.internal.p.i(key, "key");
                return (T) this.original.getProperty(key);
            }

            @Override // io.ktor.http.content.OutgoingContent
            public HttpStatusCode getStatus() {
                return this.original.getStatus();
            }

            @Override // io.ktor.http.content.OutgoingContent
            public <T> void setProperty(AttributeKey<T> key, T value) {
                kotlin.jvm.internal.p.i(key, "key");
                this.original.setProperty(key, value);
            }
        });
        return Y8.t.f7040a;
    }
}
