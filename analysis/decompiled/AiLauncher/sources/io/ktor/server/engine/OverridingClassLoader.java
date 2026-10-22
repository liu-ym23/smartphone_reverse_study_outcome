package io.ktor.server.engine;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0016B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lio/ktor/server/engine/OverridingClassLoader;", "Ljava/lang/ClassLoader;", "Ljava/io/Closeable;", "", "Ljava/net/URL;", "classpath", "parentClassLoader", "<init>", "(Ljava/util/List;Ljava/lang/ClassLoader;)V", "", "name", "", "resolve", "Ljava/lang/Class;", "loadClass", "(Ljava/lang/String;Z)Ljava/lang/Class;", "LY8/t;", "close", "()V", "Lio/ktor/server/engine/OverridingClassLoader$ChildURLClassLoader;", "childClassLoader", "Lio/ktor/server/engine/OverridingClassLoader$ChildURLClassLoader;", "ChildURLClassLoader", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OverridingClassLoader extends ClassLoader implements Closeable {
    private final ChildURLClassLoader childClassLoader;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/server/engine/OverridingClassLoader$ChildURLClassLoader;", "Ljava/net/URLClassLoader;", "", "Ljava/net/URL;", "urls", "Ljava/lang/ClassLoader;", "realParent", "<init>", "([Ljava/net/URL;Ljava/lang/ClassLoader;)V", "", "name", "Ljava/lang/Class;", "findClass", "(Ljava/lang/String;)Ljava/lang/Class;", "Ljava/util/Enumeration;", "getResources", "(Ljava/lang/String;)Ljava/util/Enumeration;", "getResource", "(Ljava/lang/String;)Ljava/net/URL;", "Ljava/io/InputStream;", "getResourceAsStream", "(Ljava/lang/String;)Ljava/io/InputStream;", "findResource", "findResources", "Ljava/lang/ClassLoader;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChildURLClassLoader extends URLClassLoader {
        private final ClassLoader realParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChildURLClassLoader(URL[] urls, ClassLoader realParent) {
            super(urls, null);
            kotlin.jvm.internal.p.i(urls, "urls");
            kotlin.jvm.internal.p.i(realParent, "realParent");
            this.realParent = realParent;
        }

        @Override // java.net.URLClassLoader, java.lang.ClassLoader
        public Class<?> findClass(String name) throws ClassNotFoundException {
            kotlin.jvm.internal.p.i(name, "name");
            Class<?> clsFindLoadedClass = super.findLoadedClass(name);
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                Class<?> clsFindClass = super.findClass(name);
                kotlin.jvm.internal.p.f(clsFindClass);
                return clsFindClass;
            } catch (ClassNotFoundException unused) {
                Class<?> clsLoadClass = this.realParent.loadClass(name);
                kotlin.jvm.internal.p.f(clsLoadClass);
                return clsLoadClass;
            }
        }

        @Override // java.net.URLClassLoader, java.lang.ClassLoader
        public URL findResource(String name) {
            return null;
        }

        @Override // java.net.URLClassLoader, java.lang.ClassLoader
        public Enumeration<URL> findResources(String name) {
            Enumeration<URL> enumerationEmptyEnumeration = Collections.emptyEnumeration();
            kotlin.jvm.internal.p.h(enumerationEmptyEnumeration, "emptyEnumeration(...)");
            return enumerationEmptyEnumeration;
        }

        @Override // java.lang.ClassLoader
        public URL getResource(String name) {
            return this.realParent.getResource(name);
        }

        @Override // java.net.URLClassLoader, java.lang.ClassLoader
        public InputStream getResourceAsStream(String name) {
            return this.realParent.getResourceAsStream(name);
        }

        @Override // java.lang.ClassLoader
        public Enumeration<URL> getResources(String name) throws IOException {
            Enumeration<URL> resources = this.realParent.getResources(name);
            kotlin.jvm.internal.p.h(resources, "getResources(...)");
            return resources;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverridingClassLoader(List<URL> classpath, ClassLoader classLoader) {
        super(classLoader);
        kotlin.jvm.internal.p.i(classpath, "classpath");
        URL[] urlArr = (URL[]) classpath.toArray(new URL[0]);
        ClassLoader parent = getParent();
        kotlin.jvm.internal.p.h(parent, "getParent(...)");
        this.childClassLoader = new ChildURLClassLoader(urlArr, parent);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.childClassLoader.close();
    }

    @Override // java.lang.ClassLoader
    public synchronized Class<?> loadClass(String name, boolean resolve) {
        Class<?> clsLoadClass;
        kotlin.jvm.internal.p.i(name, "name");
        try {
            clsLoadClass = this.childClassLoader.findClass(name);
        } catch (ClassNotFoundException unused) {
            clsLoadClass = super.loadClass(name, resolve);
            kotlin.jvm.internal.p.f(clsLoadClass);
        }
        return clsLoadClass;
    }
}
