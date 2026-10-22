package io.ktor.server.http.content;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0014\u0010\f\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lio/ktor/server/http/content/HttpStatusCodeContent;", "Lio/ktor/http/content/OutgoingContent$NoContent;", "Lio/ktor/http/HttpStatusCode;", UxipConstants.f30680s, "<init>", "(Lio/ktor/http/HttpStatusCode;)V", "", "toString", "()Ljava/lang/String;", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpStatusCodeContent extends OutgoingContent.NoContent {
    private final HttpStatusCode value;

    public HttpStatusCodeContent(HttpStatusCode value) {
        kotlin.jvm.internal.p.i(value, "value");
        this.value = value;
    }

    @Override // io.ktor.http.content.OutgoingContent
    /* renamed from: getStatus, reason: from getter */
    public HttpStatusCode getValue() {
        return this.value;
    }

    public String toString() {
        return "HttpStatusCodeContent(" + this.value + ')';
    }
}
