package com.networknt.schema.dialect;

import com.networknt.schema.SchemaRegistry;

@FunctionalInterface
/* loaded from: classes2.dex */
public interface DialectRegistry {
    Dialect getDialect(String str, SchemaRegistry schemaRegistry);
}
