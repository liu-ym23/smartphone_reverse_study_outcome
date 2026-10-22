package com.networknt.schema;

import java.util.function.Supplier;

/* loaded from: classes2.dex */
public class SchemaRef {
    private final Supplier<Schema> schemaSupplier;

    public SchemaRef(Supplier<Schema> supplier) {
        this.schemaSupplier = supplier;
    }

    public Schema getSchema() {
        return this.schemaSupplier.get();
    }
}
