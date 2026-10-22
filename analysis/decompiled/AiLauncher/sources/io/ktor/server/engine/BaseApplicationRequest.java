package io.ktor.server.engine;

import io.ktor.http.Headers;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.request.ApplicationReceivePipeline;
import io.ktor.server.request.PipelineRequest;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.InternalAPI;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020\u00168$X¤\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001aR\u0014\u0010$\u001a\u00020\u00068$X¤\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\b¨\u0006%"}, d2 = {"Lio/ktor/server/engine/BaseApplicationRequest;", "Lio/ktor/server/request/PipelineRequest;", "Lio/ktor/server/application/PipelineCall;", "call", "<init>", "(Lio/ktor/server/application/PipelineCall;)V", "Lio/ktor/utils/io/ByteReadChannel;", "receiveChannel", "()Lio/ktor/utils/io/ByteReadChannel;", "", "name", "", "values", "LY8/t;", "setHeader", "(Ljava/lang/String;Ljava/util/List;)V", "channel", "setReceiveChannel", "(Lio/ktor/utils/io/ByteReadChannel;)V", "Lio/ktor/server/application/PipelineCall;", "getCall", "()Lio/ktor/server/application/PipelineCall;", "Lio/ktor/http/Headers;", "headers$delegate", "LY8/h;", "getHeaders", "()Lio/ktor/http/Headers;", "headers", "Lio/ktor/server/request/ApplicationReceivePipeline;", "pipeline", "Lio/ktor/server/request/ApplicationReceivePipeline;", "getPipeline", "()Lio/ktor/server/request/ApplicationReceivePipeline;", "getEngineHeaders", "engineHeaders", "getEngineReceiveChannel", "engineReceiveChannel", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseApplicationRequest implements PipelineRequest {
    private final PipelineCall call;

    /* renamed from: headers$delegate, reason: from kotlin metadata */
    private final Y8.h headers;
    private final ApplicationReceivePipeline pipeline;
    private volatile /* synthetic */ Object receiveChannel;

    public BaseApplicationRequest(PipelineCall call) {
        kotlin.jvm.internal.p.i(call, "call");
        this.call = call;
        this.receiveChannel = null;
        this.headers = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.engine.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return BaseApplicationRequest.headers_delegate$lambda$0(this.f33373a);
            }
        });
        ApplicationReceivePipeline applicationReceivePipeline = new ApplicationReceivePipeline(call.getApplication().getDevelopmentMode());
        applicationReceivePipeline.resetFrom(call.getApplication().getReceivePipeline());
        this.pipeline = applicationReceivePipeline;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DelegateHeaders headers_delegate$lambda$0(BaseApplicationRequest baseApplicationRequest) {
        return new DelegateHeaders(baseApplicationRequest.getEngineHeaders());
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public /* bridge */ /* synthetic */ ApplicationCall getCall() {
        return this.call;
    }

    public abstract Headers getEngineHeaders();

    public abstract ByteReadChannel getEngineReceiveChannel();

    @Override // io.ktor.server.request.ApplicationRequest
    public final Headers getHeaders() {
        return (Headers) this.headers.getValue();
    }

    @Override // io.ktor.server.request.PipelineRequest
    public ApplicationReceivePipeline getPipeline() {
        return this.pipeline;
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public final ByteReadChannel receiveChannel() {
        ByteReadChannel byteReadChannel = (ByteReadChannel) this.receiveChannel;
        return byteReadChannel == null ? getEngineReceiveChannel() : byteReadChannel;
    }

    @Override // io.ktor.server.request.PipelineRequest
    @InternalAPI
    public final void setHeader(String name, List<String> values) {
        kotlin.jvm.internal.p.i(name, "name");
        Headers headers = getHeaders();
        kotlin.jvm.internal.p.g(headers, "null cannot be cast to non-null type io.ktor.server.engine.DelegateHeaders");
        ((DelegateHeaders) headers).setHeader(name, values);
    }

    @Override // io.ktor.server.request.PipelineRequest
    @InternalAPI
    public final void setReceiveChannel(ByteReadChannel channel) {
        kotlin.jvm.internal.p.i(channel, "channel");
        this.receiveChannel = channel;
    }

    @Override // io.ktor.server.request.PipelineRequest, io.ktor.server.request.ApplicationRequest
    public final PipelineCall getCall() {
        return this.call;
    }
}
