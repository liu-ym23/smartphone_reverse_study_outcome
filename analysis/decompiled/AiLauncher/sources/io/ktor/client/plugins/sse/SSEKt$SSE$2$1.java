package io.ktor.client.plugins.sse;

import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.SSEClientResponseAdapter;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.LoggerJvmKt;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lio/ktor/http/content/OutgoingContent;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "io.ktor.client.plugins.sse.SSEKt$SSE$2$1", f = "SSE.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class SSEKt$SSE$2$1 extends SuspendLambda implements p9.q<HttpRequestBuilder, OutgoingContent, InterfaceC4014c<? super OutgoingContent>, Object> {
    final /* synthetic */ SSEBufferPolicy $bufferPolicy;
    final /* synthetic */ int $maxReconnectionAttempts;
    final /* synthetic */ long $reconnectionTime;
    final /* synthetic */ boolean $showCommentEvents;
    final /* synthetic */ boolean $showRetryEvents;
    final /* synthetic */ ClientPluginBuilder<SSEConfig> $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSEKt$SSE$2$1(ClientPluginBuilder<SSEConfig> clientPluginBuilder, long j10, boolean z10, boolean z11, int i10, SSEBufferPolicy sSEBufferPolicy, InterfaceC4014c<? super SSEKt$SSE$2$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$reconnectionTime = j10;
        this.$showCommentEvents = z10;
        this.$showRetryEvents = z11;
        this.$maxReconnectionAttempts = i10;
        this.$bufferPolicy = sSEBufferPolicy;
    }

    @Override // p9.q
    public final Object invoke(HttpRequestBuilder httpRequestBuilder, OutgoingContent outgoingContent, InterfaceC4014c<? super OutgoingContent> interfaceC4014c) {
        SSEKt$SSE$2$1 sSEKt$SSE$2$1 = new SSEKt$SSE$2$1(this.$this_createClientPlugin, this.$reconnectionTime, this.$showCommentEvents, this.$showRetryEvents, this.$maxReconnectionAttempts, this.$bufferPolicy, interfaceC4014c);
        sSEKt$SSE$2$1.L$0 = httpRequestBuilder;
        sSEKt$SSE$2$1.L$1 = outgoingContent;
        return sSEKt$SSE$2$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$0;
        OutgoingContent outgoingContent = (OutgoingContent) this.L$1;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (!kotlin.jvm.internal.p.d(SSEKt.getAttributeValue(httpRequestBuilder, BuildersKt.getSseRequestAttr()), C4109a.a(true))) {
            return outgoingContent;
        }
        vc.c logger = SSEKt.getLOGGER();
        if (LoggerJvmKt.isTraceEnabled(logger)) {
            logger.trace("Sending SSE request to " + httpRequestBuilder.getUrl());
        }
        httpRequestBuilder.setCapability(SSECapability.INSTANCE, Y8.t.f7040a);
        kotlin.time.a aVar = (kotlin.time.a) SSEKt.getAttributeValue(httpRequestBuilder, BuildersKt.getReconnectionTimeAttr());
        Boolean bool = (Boolean) SSEKt.getAttributeValue(httpRequestBuilder, BuildersKt.getShowCommentEventsAttr());
        Boolean bool2 = (Boolean) SSEKt.getAttributeValue(httpRequestBuilder, BuildersKt.getShowRetryEventsAttr());
        SSEBufferPolicy sSEBufferPolicy = (SSEBufferPolicy) SSEKt.getAttributeValue(httpRequestBuilder, BuildersKt.getSseBufferPolicyAttr());
        httpRequestBuilder.getAttributes().put(HttpRequestKt.getResponseAdapterAttributeKey(), new SSEClientResponseAdapter());
        httpRequestBuilder.getAttributes().put(SSEKt.getSSEClientForReconnectionAttr(), this.$this_createClientPlugin.getClient());
        ContentType contentType = outgoingContent.getContentType();
        if (contentType != null) {
            HttpMessagePropertiesKt.contentType(httpRequestBuilder, contentType);
        }
        long rawValue = aVar != null ? aVar.getRawValue() : this.$reconnectionTime;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : this.$showCommentEvents;
        boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : this.$showRetryEvents;
        int i10 = this.$maxReconnectionAttempts;
        if (sSEBufferPolicy == null) {
            sSEBufferPolicy = this.$bufferPolicy;
        }
        return new SSEClientContent(rawValue, zBooleanValue, zBooleanValue2, i10, sSEBufferPolicy, getContext(), httpRequestBuilder, outgoingContent, null);
    }
}
