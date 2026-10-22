package io.ktor.server.plugins;

import Ua.C;
import io.ktor.util.internal.ExceptionUtilsJvmKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/server/plugins/MissingRequestParameterException;", "Lio/ktor/server/plugins/BadRequestException;", "LUa/C;", "", "parameterName", "<init>", "(Ljava/lang/String;)V", "createCopy", "()Lio/ktor/server/plugins/MissingRequestParameterException;", "Ljava/lang/String;", "getParameterName", "()Ljava/lang/String;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MissingRequestParameterException extends BadRequestException implements C<MissingRequestParameterException> {
    private final String parameterName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingRequestParameterException(String parameterName) {
        super("Request parameter " + parameterName + " is missing", null, 2, null);
        p.i(parameterName, "parameterName");
        this.parameterName = parameterName;
    }

    public final String getParameterName() {
        return this.parameterName;
    }

    @Override // Ua.C
    public MissingRequestParameterException createCopy() {
        MissingRequestParameterException missingRequestParameterException = new MissingRequestParameterException(this.parameterName);
        ExceptionUtilsJvmKt.initCauseBridge(missingRequestParameterException, this);
        return missingRequestParameterException;
    }
}
