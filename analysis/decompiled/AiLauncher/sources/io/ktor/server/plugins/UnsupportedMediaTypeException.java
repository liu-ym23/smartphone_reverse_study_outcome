package io.ktor.server.plugins;

import Ua.C;
import io.ktor.http.ContentType;
import io.ktor.util.internal.ExceptionUtilsJvmKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/server/plugins/UnsupportedMediaTypeException;", "Lio/ktor/server/plugins/ContentTransformationException;", "LUa/C;", "Lio/ktor/http/ContentType;", "contentType", "<init>", "(Lio/ktor/http/ContentType;)V", "createCopy", "()Lio/ktor/server/plugins/UnsupportedMediaTypeException;", "Lio/ktor/http/ContentType;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UnsupportedMediaTypeException extends ContentTransformationException implements C<UnsupportedMediaTypeException> {
    private final ContentType contentType;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public UnsupportedMediaTypeException(io.ktor.http.ContentType r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Content type "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = " is not supported"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L1c
        L1a:
            java.lang.String r0 = "Content-Type header is required"
        L1c:
            r2.<init>(r0)
            r2.contentType = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.plugins.UnsupportedMediaTypeException.<init>(io.ktor.http.ContentType):void");
    }

    @Override // Ua.C
    public UnsupportedMediaTypeException createCopy() {
        UnsupportedMediaTypeException unsupportedMediaTypeException = new UnsupportedMediaTypeException(this.contentType);
        ExceptionUtilsJvmKt.initCauseBridge(unsupportedMediaTypeException, this);
        return unsupportedMediaTypeException;
    }
}
