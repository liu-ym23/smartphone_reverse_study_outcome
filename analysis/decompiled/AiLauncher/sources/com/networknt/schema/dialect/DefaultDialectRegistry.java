package com.networknt.schema.dialect;

import com.networknt.schema.SchemaRegistry;
import com.networknt.schema.Specification;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class DefaultDialectRegistry extends BasicDialectRegistry {
    private final ConcurrentMap<String, Dialect> loadedDialects;

    public static class Holder {
        private static final DefaultDialectRegistry INSTANCE = new DefaultDialectRegistry();

        private Holder() {
        }
    }

    public DefaultDialectRegistry() {
        this.loadedDialects = new ConcurrentHashMap();
    }

    public static DefaultDialectRegistry getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.networknt.schema.dialect.BasicDialectRegistry, com.networknt.schema.dialect.DialectRegistry
    public Dialect getDialect(String str, final SchemaRegistry schemaRegistry) {
        Dialect dialectApply;
        Function<String, Dialect> function = this.dialects;
        if (function != null && (dialectApply = function.apply(str)) != null) {
            return dialectApply;
        }
        Dialect dialect = Specification.getDialect(str);
        return dialect != null ? dialect : this.loadedDialects.computeIfAbsent(str, new Function() { // from class: com.networknt.schema.dialect.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f21967a.loadDialect((String) obj, schemaRegistry);
            }
        });
    }

    public DefaultDialectRegistry(Function<String, Dialect> function) {
        super(function);
        this.loadedDialects = new ConcurrentHashMap();
    }

    public DefaultDialectRegistry(Dialect dialect) {
        super(dialect);
        this.loadedDialects = new ConcurrentHashMap();
    }

    public DefaultDialectRegistry(Collection<Dialect> collection) {
        super(collection);
        this.loadedDialects = new ConcurrentHashMap();
    }
}
