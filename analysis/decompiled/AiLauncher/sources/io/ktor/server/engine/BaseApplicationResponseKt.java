package io.ktor.server.engine;

import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"io/ktor/server/engine/BaseApplicationResponseKt$ERROR_CONTENT$1", "ERROR_CONTENT", "Lio/ktor/server/engine/BaseApplicationResponseKt$ERROR_CONTENT$1;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BaseApplicationResponseKt {
    private static final BaseApplicationResponseKt$ERROR_CONTENT$1 ERROR_CONTENT = new OutgoingContent.NoContent() { // from class: io.ktor.server.engine.BaseApplicationResponseKt$ERROR_CONTENT$1
        private final HttpStatusCode status = HttpStatusCode.Companion.getInternalServerError();

        @Override // io.ktor.http.content.OutgoingContent
        public HttpStatusCode getStatus() {
            return this.status;
        }
    };
}
