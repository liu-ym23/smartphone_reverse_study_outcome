package com.networknt.schema.resource;

import com.networknt.schema.AbsoluteIri;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class MapResourceLoader implements ResourceLoader {
    private final Function<String, String> mappings;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MapResourceLoader(Map<String, String> map) {
        this(new e(map));
        Objects.requireNonNull(map);
    }

    public static /* synthetic */ String a(Function function, Function function2, String str) {
        Object objApply = function.apply(str);
        if (objApply != null) {
            return (String) function2.apply(objApply);
        }
        return null;
    }

    public static /* synthetic */ InputStream b(String str) {
        return new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
    }

    @Override // com.networknt.schema.resource.ResourceLoader
    public InputStreamSource getResource(AbsoluteIri absoluteIri) {
        try {
            final String strApply = this.mappings.apply(absoluteIri.toString());
            if (strApply != null) {
                return new InputStreamSource() { // from class: com.networknt.schema.resource.f
                    @Override // com.networknt.schema.resource.InputStreamSource
                    public final InputStream getInputStream() {
                        return MapResourceLoader.b(strApply);
                    }
                };
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public MapResourceLoader(Function<String, String> function) {
        this.mappings = function;
    }

    public <T> MapResourceLoader(final Function<String, T> function, final Function<T, String> function2) {
        this.mappings = new Function() { // from class: com.networknt.schema.resource.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MapResourceLoader.a(function, function2, (String) obj);
            }
        };
    }
}
