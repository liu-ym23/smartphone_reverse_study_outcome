package io.ktor.server.plugins;

import Ua.C;
import io.ktor.util.internal.ExceptionUtilsJvmKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/server/plugins/CannotTransformContentToTypeException;", "Lio/ktor/server/plugins/ContentTransformationException;", "LUa/C;", "Lw9/n;", "type", "<init>", "(Lw9/n;)V", "createCopy", "()Lio/ktor/server/plugins/CannotTransformContentToTypeException;", "Lw9/n;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CannotTransformContentToTypeException extends ContentTransformationException implements C<CannotTransformContentToTypeException> {
    private final InterfaceC5755n type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CannotTransformContentToTypeException(InterfaceC5755n type) {
        super("Cannot transform this request's content to " + type);
        p.i(type, "type");
        this.type = type;
    }

    @Override // Ua.C
    public CannotTransformContentToTypeException createCopy() {
        CannotTransformContentToTypeException cannotTransformContentToTypeException = new CannotTransformContentToTypeException(this.type);
        ExceptionUtilsJvmKt.initCauseBridge(cannotTransformContentToTypeException, this);
        return cannotTransformContentToTypeException;
    }
}
