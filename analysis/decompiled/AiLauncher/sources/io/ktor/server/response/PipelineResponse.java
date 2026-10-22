package io.ktor.server.response;

import io.ktor.server.application.PipelineCall;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/server/response/PipelineResponse;", "Lio/ktor/server/response/ApplicationResponse;", "Lio/ktor/server/application/PipelineCall;", "getCall", "()Lio/ktor/server/application/PipelineCall;", "call", "Lio/ktor/server/response/ApplicationSendPipeline;", "getPipeline", "()Lio/ktor/server/response/ApplicationSendPipeline;", "pipeline", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PipelineResponse extends ApplicationResponse {
    @Override // io.ktor.server.response.ApplicationResponse
    PipelineCall getCall();

    ApplicationSendPipeline getPipeline();
}
