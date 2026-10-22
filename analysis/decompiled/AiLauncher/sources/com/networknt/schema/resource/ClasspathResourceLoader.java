package com.networknt.schema.resource;

import com.networknt.schema.AbsoluteIri;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public class ClasspathResourceLoader implements ResourceLoader {
    private final Supplier<ClassLoader> classLoaderSource;

    public static class Holder {
        private static final ClasspathResourceLoader INSTANCE = new ClasspathResourceLoader();

        private Holder() {
        }
    }

    public ClasspathResourceLoader() {
        this(new Supplier() { // from class: com.networknt.schema.resource.b
            @Override // java.util.function.Supplier
            public final Object get() {
                return ClasspathResourceLoader.getClassLoader();
            }
        });
    }

    public static /* synthetic */ InputStream a(ClassLoader classLoader, String str, String str2) throws FileNotFoundException {
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream == null) {
            resourceAsStream = classLoader.getResourceAsStream(str.substring(1));
        }
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        throw new FileNotFoundException(str2);
    }

    public static ClassLoader getClassLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? ResourceLoader.class.getClassLoader() : contextClassLoader;
    }

    public static ClasspathResourceLoader getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.networknt.schema.resource.ResourceLoader
    public InputStreamSource getResource(AbsoluteIri absoluteIri) {
        final String string = absoluteIri != null ? absoluteIri.toString() : "";
        final String strSubstring = string.startsWith("classpath:") ? string.substring(10) : string.startsWith("resource:") ? string.substring(9) : null;
        if (strSubstring == null) {
            return null;
        }
        final ClassLoader classLoader = this.classLoaderSource.get();
        if (strSubstring.startsWith("//")) {
            strSubstring = strSubstring.substring(2);
        }
        return new InputStreamSource() { // from class: com.networknt.schema.resource.a
            @Override // com.networknt.schema.resource.InputStreamSource
            public final InputStream getInputStream() {
                return ClasspathResourceLoader.a(classLoader, strSubstring, string);
            }
        };
    }

    public ClasspathResourceLoader(Supplier<ClassLoader> supplier) {
        this.classLoaderSource = supplier;
    }
}
