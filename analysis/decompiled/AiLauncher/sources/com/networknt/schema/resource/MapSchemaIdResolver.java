package com.networknt.schema.resource;

import com.networknt.schema.AbsoluteIri;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public class MapSchemaIdResolver implements SchemaIdResolver {
    private final Function<String, String> mappings;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MapSchemaIdResolver(Map<String, String> map) {
        this(new e(map));
        Objects.requireNonNull(map);
    }

    public static /* synthetic */ String a(Predicate predicate, Function function, String str) {
        if (predicate.test(str)) {
            return (String) function.apply(str);
        }
        return null;
    }

    @Override // com.networknt.schema.resource.SchemaIdResolver
    public AbsoluteIri resolve(AbsoluteIri absoluteIri) {
        String strApply = this.mappings.apply(absoluteIri.toString());
        if (strApply != null) {
            return AbsoluteIri.of(strApply);
        }
        return null;
    }

    public MapSchemaIdResolver(Function<String, String> function) {
        this.mappings = function;
    }

    public MapSchemaIdResolver(final Predicate<String> predicate, final Function<String, String> function) {
        this.mappings = new Function() { // from class: com.networknt.schema.resource.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MapSchemaIdResolver.a(predicate, function, (String) obj);
            }
        };
    }
}
