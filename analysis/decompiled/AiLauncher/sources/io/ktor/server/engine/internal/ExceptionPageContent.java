package io.ktor.server.engine.internal;

import La.H;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.plugins.OriginConnectionPointKt;
import io.ktor.server.request.ApplicationRequest;
import io.ktor.server.request.ApplicationRequestPropertiesKt;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/server/engine/internal/ExceptionPageContent;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/server/application/ApplicationCall;", "call", "", "cause", "<init>", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/Throwable;)V", "Lio/ktor/utils/io/ByteReadChannel;", "readFrom", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "", "responsePage", "Ljava/lang/String;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExceptionPageContent extends OutgoingContent.ReadChannelContent {
    private final String responsePage;

    public ExceptionPageContent(ApplicationCall call, Throwable cause) {
        p.i(call, "call");
        p.i(cause, "cause");
        StringBuilder sb2 = new StringBuilder();
        ApplicationRequest request = call.getRequest();
        sb2.append("<html><body><h1>Internal Server Error</h1><h2>Request Information:</h2><pre>");
        sb2.append("Method: " + ApplicationRequestPropertiesKt.getHttpMethod(request) + '\n');
        sb2.append("Path: " + ApplicationRequestPropertiesKt.path(request) + '\n');
        sb2.append("Parameters: " + request.getRawQueryParameters() + '\n');
        sb2.append("From origin: " + OriginConnectionPointKt.getOrigin(request) + '\n');
        sb2.append("</pre><h2>Stack Trace:</h2><pre>");
        Iterator<T> it = H.F0(Y8.d.b(cause)).iterator();
        while (it.hasNext()) {
            sb2.append("<span style=\"color:blue;\">" + ((String) it.next()) + "</span><br>");
        }
        for (Throwable cause2 = cause.getCause(); cause2 != null; cause2 = cause2.getCause()) {
            sb2.append("<br>Caused by:<br>");
            Iterator<T> it2 = H.F0(Y8.d.b(cause2)).iterator();
            while (it2.hasNext()) {
                sb2.append("<span style=\"color:green;\">" + ((String) it2.next()) + "</span><br>");
            }
        }
        sb2.append("</pre></body></html>");
        this.responsePage = sb2.toString();
    }

    @Override // io.ktor.http.content.OutgoingContent
    /* renamed from: getStatus */
    public HttpStatusCode getValue() {
        return HttpStatusCode.INSTANCE.getInternalServerError();
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel readFrom() {
        return ByteChannelCtorKt.ByteReadChannel$default(this.responsePage, null, 2, null);
    }
}
