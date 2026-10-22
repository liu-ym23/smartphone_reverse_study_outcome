package com.networknt.schema;

import u3.e;

/* loaded from: classes3.dex */
public class SchemaException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final e f3012a;

    public SchemaException(e eVar) {
        this.f3012a = eVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        e eVar = this.f3012a;
        return eVar != null ? eVar.a() : super.getMessage();
    }

    public SchemaException(String str) {
        super(str);
        this.f3012a = null;
    }

    public SchemaException(Throwable th) {
        super(th);
        this.f3012a = null;
    }
}
