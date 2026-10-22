package io.ktor.server.http.content;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.URIFileContent;
import io.ktor.server.application.ApplicationCall;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import java.io.File;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/server/application/ApplicationCall;", "call", "", UxipConstants.f30680s, "Lio/ktor/http/content/OutgoingContent;", "platformTransformDefaultContent", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/Object;)Lio/ktor/http/content/OutgoingContent;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultTransformJvmKt {
    public static final OutgoingContent platformTransformDefaultContent(ApplicationCall call, final Object value) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(value, "value");
        if (!(value instanceof URIFileContent)) {
            if (value instanceof InputStream) {
                return new OutgoingContent.ReadChannelContent() { // from class: io.ktor.server.http.content.DefaultTransformJvmKt.platformTransformDefaultContent.1
                    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                    public ByteReadChannel readFrom() {
                        return ReadingKt.toByteReadChannelWithArrayPool$default((InputStream) value, null, null, 3, null);
                    }
                };
            }
            return null;
        }
        URIFileContent uRIFileContent = (URIFileContent) value;
        if (kotlin.jvm.internal.p.d(uRIFileContent.getUri().getScheme(), Const.STR_FILE)) {
            return new LocalFileContent(new File(uRIFileContent.getUri()), null, 2, null);
        }
        return null;
    }
}
