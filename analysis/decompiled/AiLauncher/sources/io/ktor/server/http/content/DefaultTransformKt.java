package io.ktor.server.http.content;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.ByteArrayContent;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.response.ApplicationResponseFunctionsKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/server/application/ApplicationCall;", "call", "", UxipConstants.f30680s, "Lio/ktor/http/content/OutgoingContent;", "transformDefaultContent", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/Object;)Lio/ktor/http/content/OutgoingContent;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultTransformKt {
    public static final OutgoingContent transformDefaultContent(ApplicationCall call, final Object value) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(value, "value");
        if (value instanceof OutgoingContent) {
            return (OutgoingContent) value;
        }
        if (value instanceof String) {
            return new TextContent((String) value, ApplicationResponseFunctionsKt.defaultTextContentType(call, null), null);
        }
        return value instanceof byte[] ? new ByteArrayContent((byte[]) value, null, null, 6, null) : value instanceof HttpStatusCode ? new HttpStatusCodeContent((HttpStatusCode) value) : value instanceof ByteReadChannel ? new OutgoingContent.ReadChannelContent() { // from class: io.ktor.server.http.content.DefaultTransformKt.transformDefaultContent.1
            @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
            public ByteReadChannel readFrom() {
                return (ByteReadChannel) value;
            }
        } : DefaultTransformJvmKt.platformTransformDefaultContent(call, value);
    }
}
