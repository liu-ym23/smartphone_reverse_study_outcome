package io.ktor.server.application;

import io.ktor.http.ContentType;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\" \u0010\u0004\u001a\u00020\u0001*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00010\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u001f\u0010\b\u001a\u00020\u0005*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/server/application/PipelineCall;", "getCall", "(Lio/ktor/util/pipeline/PipelineContext;)Lio/ktor/server/application/PipelineCall;", "call", "Lio/ktor/server/application/Application;", "getApplication", "(Lio/ktor/util/pipeline/PipelineContext;)Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationCallPipelineKt {
    public static final Application getApplication(PipelineContext<?, PipelineCall> pipelineContext) {
        p.i(pipelineContext, "<this>");
        return pipelineContext.getContext().getApplication();
    }

    public static final PipelineCall getCall(PipelineContext<?, PipelineCall> pipelineContext) {
        p.i(pipelineContext, "<this>");
        return pipelineContext.getContext();
    }
}
