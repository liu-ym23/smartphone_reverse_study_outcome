package com.networknt.schema.dialect;

import com.networknt.schema.Error;
import com.networknt.schema.InvalidSchemaException;
import com.networknt.schema.SchemaRegistry;
import java.util.Collection;
import java.util.HashMap;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class BasicDialectRegistry extends AbstractDialectRegistry {
    protected final Function<String, Dialect> dialects;

    public BasicDialectRegistry() {
        this.dialects = null;
    }

    public static /* synthetic */ Dialect a(Dialect dialect, String str) {
        if (dialect.getId().equals(str)) {
            return dialect;
        }
        return null;
    }

    @Override // com.networknt.schema.dialect.DialectRegistry
    public Dialect getDialect(String str, SchemaRegistry schemaRegistry) {
        Dialect dialectApply = this.dialects.apply(str);
        if (dialectApply != null) {
            return dialectApply;
        }
        throw new InvalidSchemaException(Error.builder().message("Unknown dialect ''{0}''. Only dialects that are explicitly configured can be used.").arguments(str).build());
    }

    public BasicDialectRegistry(Function<String, Dialect> function) {
        this.dialects = function;
    }

    public BasicDialectRegistry(final Dialect dialect) {
        this.dialects = new Function() { // from class: com.networknt.schema.dialect.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return BasicDialectRegistry.a(dialect, (String) obj);
            }
        };
    }

    public BasicDialectRegistry(Collection<Dialect> collection) {
        final HashMap map = new HashMap();
        for (Dialect dialect : collection) {
            map.put(dialect.getId(), dialect);
        }
        this.dialects = new Function() { // from class: com.networknt.schema.dialect.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (Dialect) map.get((String) obj);
            }
        };
    }
}
