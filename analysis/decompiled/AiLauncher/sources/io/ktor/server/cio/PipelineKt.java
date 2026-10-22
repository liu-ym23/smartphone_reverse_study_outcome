package io.ktor.server.cio;

import Ua.CoroutineName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\"\u001a\u0010\u0001\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u001a\u0010\u0007\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\u0004*N\u0010\u000f\"$\b\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t2$\b\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t¨\u0006\u0010"}, d2 = {"LUa/L;", "HttpPipelineCoroutine", "LUa/L;", "getHttpPipelineCoroutine", "()LUa/L;", "HttpPipelineWriterCoroutine", "getHttpPipelineWriterCoroutine", "RequestHandlerCoroutine", "getRequestHandlerCoroutine", "Lkotlin/Function3;", "Lio/ktor/server/cio/backend/ServerRequestScope;", "Lio/ktor/http/cio/Request;", "Le9/c;", "LY8/t;", "", "HttpRequestHandler", "ktor-server-cio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PipelineKt {
    private static final CoroutineName HttpPipelineCoroutine = new CoroutineName("http-pipeline");
    private static final CoroutineName HttpPipelineWriterCoroutine = new CoroutineName("http-pipeline-writer");
    private static final CoroutineName RequestHandlerCoroutine = new CoroutineName("request-handler");

    public static final CoroutineName getHttpPipelineCoroutine() {
        return HttpPipelineCoroutine;
    }

    public static final CoroutineName getHttpPipelineWriterCoroutine() {
        return HttpPipelineWriterCoroutine;
    }

    public static final CoroutineName getRequestHandlerCoroutine() {
        return RequestHandlerCoroutine;
    }
}
