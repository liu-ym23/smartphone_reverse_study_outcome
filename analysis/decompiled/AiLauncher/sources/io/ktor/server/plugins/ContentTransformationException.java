package io.ktor.server.plugins;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/server/plugins/ContentTransformationException;", "Ljava/io/IOException;", "Lkotlinx/io/IOException;", "", "message", "<init>", "(Ljava/lang/String;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ContentTransformationException extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentTransformationException(String message) {
        super(message);
        p.i(message, "message");
    }
}
