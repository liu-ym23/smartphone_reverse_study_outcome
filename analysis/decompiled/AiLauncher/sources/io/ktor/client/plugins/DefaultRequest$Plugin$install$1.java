package io.ktor.client.plugins;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.StringValuesKt;
import io.ktor.util.pipeline.PipelineContext;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.DefaultRequest$Plugin$install$1", f = "DefaultRequest.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class DefaultRequest$Plugin$install$1 extends SuspendLambda implements p9.q<PipelineContext<Object, HttpRequestBuilder>, Object, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ DefaultRequest $plugin;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultRequest$Plugin$install$1(DefaultRequest defaultRequest, InterfaceC4014c<? super DefaultRequest$Plugin$install$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$plugin = defaultRequest;
    }

    @Override // p9.q
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        DefaultRequest$Plugin$install$1 defaultRequest$Plugin$install$1 = new DefaultRequest$Plugin$install$1(this.$plugin, interfaceC4014c);
        defaultRequest$Plugin$install$1.L$0 = pipelineContext;
        return defaultRequest$Plugin$install$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PipelineContext pipelineContext = (PipelineContext) this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        String string = ((HttpRequestBuilder) pipelineContext.getContext()).getUrl().toString();
        DefaultRequest.DefaultRequestBuilder defaultRequestBuilder = new DefaultRequest.DefaultRequestBuilder();
        DefaultRequest defaultRequest = this.$plugin;
        StringValuesKt.appendAll(defaultRequestBuilder.getHeaders(), ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders());
        Headers headersBuild = defaultRequestBuilder.getHeaders().build();
        defaultRequest.block.invoke(defaultRequestBuilder);
        Iterator<T> it = headersBuild.entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            List<String> all = defaultRequestBuilder.getHeaders().getAll(str);
            if (all == null) {
                defaultRequestBuilder.getHeaders().appendAll(str, list);
            } else if (!kotlin.jvm.internal.p.d(all, list) && !kotlin.jvm.internal.p.d(str, HttpHeaders.INSTANCE.getCookie())) {
                defaultRequestBuilder.getHeaders().remove(str);
                defaultRequestBuilder.getHeaders().appendAll(str, list);
                defaultRequestBuilder.getHeaders().appendMissing(str, all);
            }
        }
        DefaultRequest.INSTANCE.mergeUrls(defaultRequestBuilder.getUrl().build(), ((HttpRequestBuilder) pipelineContext.getContext()).getUrl());
        for (AttributeKey<?> attributeKey : defaultRequestBuilder.getAttributes().getAllKeys()) {
            if (!((HttpRequestBuilder) pipelineContext.getContext()).getAttributes().contains(attributeKey)) {
                Attributes attributes = ((HttpRequestBuilder) pipelineContext.getContext()).getAttributes();
                kotlin.jvm.internal.p.g(attributeKey, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
                attributes.put(attributeKey, defaultRequestBuilder.getAttributes().get(attributeKey));
            }
        }
        ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().clear();
        ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().appendAll(defaultRequestBuilder.getHeaders().build());
        DefaultRequestKt.LOGGER.trace("Applied DefaultRequest to " + string + ". New url: " + ((HttpRequestBuilder) pipelineContext.getContext()).getUrl());
        return Y8.t.f7040a;
    }
}
