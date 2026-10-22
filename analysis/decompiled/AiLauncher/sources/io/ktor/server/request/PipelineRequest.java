package io.ktor.server.request;

import io.ktor.server.application.PipelineCall;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.InternalAPI;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lio/ktor/server/request/PipelineRequest;", "Lio/ktor/server/request/ApplicationRequest;", "", "name", "", "values", "LY8/t;", "setHeader", "(Ljava/lang/String;Ljava/util/List;)V", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "setReceiveChannel", "(Lio/ktor/utils/io/ByteReadChannel;)V", "Lio/ktor/server/application/PipelineCall;", "getCall", "()Lio/ktor/server/application/PipelineCall;", "call", "Lio/ktor/server/request/ApplicationReceivePipeline;", "getPipeline", "()Lio/ktor/server/request/ApplicationReceivePipeline;", "pipeline", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PipelineRequest extends ApplicationRequest {
    @Override // io.ktor.server.request.ApplicationRequest
    PipelineCall getCall();

    ApplicationReceivePipeline getPipeline();

    @InternalAPI
    void setHeader(String name, List<String> values);

    @InternalAPI
    void setReceiveChannel(ByteReadChannel channel);
}
