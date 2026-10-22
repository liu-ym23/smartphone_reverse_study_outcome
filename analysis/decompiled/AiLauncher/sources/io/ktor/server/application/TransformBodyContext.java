package io.ktor.server.application;

import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;

@KtorDsl
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/server/application/TransformBodyContext;", "", "Lio/ktor/util/reflect/TypeInfo;", "requestedType", "<init>", "(Lio/ktor/util/reflect/TypeInfo;)V", "Lio/ktor/util/reflect/TypeInfo;", "getRequestedType", "()Lio/ktor/util/reflect/TypeInfo;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TransformBodyContext {
    private final TypeInfo requestedType;

    public TransformBodyContext(TypeInfo typeInfo) {
        this.requestedType = typeInfo;
    }

    public final TypeInfo getRequestedType() {
        return this.requestedType;
    }
}
