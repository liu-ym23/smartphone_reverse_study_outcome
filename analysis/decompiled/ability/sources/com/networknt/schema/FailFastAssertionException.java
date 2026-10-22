package com.networknt.schema;

import java.util.Objects;
import u3.e;

/* loaded from: classes3.dex */
public class FailFastAssertionException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final e f3010a;

    public FailFastAssertionException(e eVar) {
        Objects.requireNonNull(eVar);
        this.f3010a = eVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        e eVar = this.f3010a;
        return eVar != null ? eVar.a() : super.getMessage();
    }
}
