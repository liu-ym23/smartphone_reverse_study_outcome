package com.google.common.reflect;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class ClassPath {
    private static final String CLASS_FILE_NAME_EXTENSION = ".class";
    private static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR = null;
    private static final Predicate<ClassInfo> IS_TOP_LEVEL = null;
    private static final Logger logger = null;
    private final ImmutableSet<ResourceInfo> resources;

    @Beta
    public static final class ClassInfo extends ResourceInfo {
        private final String className;

        public ClassInfo(String r10, ClassLoader r11) {
            super(r10, r11);
            this.className = ClassPath.getClassName(r10);
        }

        public static /* synthetic */ String access$000(ClassInfo r10) {
            return r10.className;
        }

        public String getName() {
            return this.className;
        }

        public String getPackageName() {
            return Reflection.getPackageName(this.className);
        }

        public String getSimpleName() {
            int r10 = this.className.lastIndexOf(36);
            if (r10 == (-1)) goto L6;
            String r11 = this.className.substring(r10 + 1);
            return CharMatcher.digit().trimLeadingFrom(r11);
        L6:
            String r12 = getPackageName();
            if (r12.isEmpty() == false) goto L11;
            return this.className;
        L11:
            return this.className.substring(r12.length() + 1);
        }

        public Class<?> load() {
            return this.loader.loadClass(this.className);
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.reflect.ClassPath.ResourceInfo
        public String toString() {
            return this.className;
        }
    }

    @VisibleForTesting
    public static final class DefaultScanner extends Scanner {
        private final SetMultimap<ClassLoader, String> resources;

        public DefaultScanner() {
            this.resources = MultimapBuilder.hashKeys().linkedHashSetValues().build();
        }

        public ImmutableSet<ResourceInfo> getResources() {
            ImmutableSet.Builder r10 = ImmutableSet.builder();
            Iterator<Map.Entry<ClassLoader, String>> r11 = this.resources.entries().iterator();
        L4:
            if (r11.hasNext() == false) goto L7;
            Map.Entry<ClassLoader, String> r12 = r11.next();
            r10.add(ResourceInfo.of(r12.getValue(), r12.getKey()));
            goto L4
        L7:
            return r10.build();
        }

        @Override // com.google.common.reflect.ClassPath.Scanner
        public void scanDirectory(ClassLoader r10, File r11) throws IOException {
            HashSet r12 = new HashSet();
            r12.add(r11.getCanonicalFile());
            scanDirectory(r11, r10, "", r12);
        }

        @Override // com.google.common.reflect.ClassPath.Scanner
        public void scanJarFile(ClassLoader r10, JarFile r11) {
            Enumeration<JarEntry> r12 = r11.entries();
        L4:
            if (r12.hasMoreElements() == false) goto L11;
            JarEntry r13 = r12.nextElement();
            if (r13.isDirectory() == true) goto L4;
            if (r13.getName().equals("META-INF/MANIFEST.MF") == true) goto L4;
            this.resources.get(r10).add(r13.getName());
            goto L4
        }

        private void scanDirectory(File r10, ClassLoader r11, String r12, Set<File> r13) throws IOException {
            File[] r14 = r10.listFiles();
            if (r14 != null) goto L6;
            ClassPath.access$100().warning("Cannot read directory " + r10);
            return;
        L6:
            int r15 = r14.length;
            int r16 = 0;
        L7:
            if (r16 >= r15) goto L17;
            File r17 = r14[r16];
            String r18 = r17.getName();
            if (r17.isDirectory() == false) goto L13;
            File r19 = r17.getCanonicalFile();
            if (r13.add(r19) == false) goto L16;
            scanDirectory(r19, r11, r12 + r18 + LibrarianImpl.Constants.SEPARATOR, r13);
            r13.remove(r19);
        L16:
            r16 = r16 + 1;
            goto L7
        L13:
            String r20 = r12 + r18;
            if (r20.equals("META-INF/MANIFEST.MF") == true) goto L16;
            this.resources.get(r11).add(r20);
            goto L16
        }
    }

    @Beta
    public static class ResourceInfo {
        final ClassLoader loader;
        private final String resourceName;

        public ResourceInfo(String r10, ClassLoader r11) {
            this.resourceName = (String) Preconditions.checkNotNull(r10);
            this.loader = (ClassLoader) Preconditions.checkNotNull(r11);
        }

        public static ResourceInfo of(String r10, ClassLoader r11) {
            if (r10.endsWith(ClassPath.CLASS_FILE_NAME_EXTENSION) == false) goto L7;
            return new ClassInfo(r10, r11);
        L7:
            return new ResourceInfo(r10, r11);
        }

        public final ByteSource asByteSource() {
            return Resources.asByteSource(url());
        }

        public final CharSource asCharSource(Charset r10) {
            return Resources.asCharSource(url(), r10);
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ResourceInfo) == false) goto L10;
            ResourceInfo r11 = (ResourceInfo) r10;
            if (this.resourceName.equals(r11.resourceName) == true) goto L7;
            return false;
        L7:
            if (this.loader != r11.loader) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public final String getResourceName() {
            return this.resourceName;
        }

        public int hashCode() {
            return this.resourceName.hashCode();
        }

        public String toString() {
            return this.resourceName;
        }

        public final URL url() {
            URL r10 = this.loader.getResource(this.resourceName);
            if (r10 == null) goto L6;
            return r10;
        L6:
            throw new NoSuchElementException(this.resourceName);
        }
    }

    public static abstract class Scanner {
        private final Set<File> scannedUris;

        public Scanner() {
            this.scannedUris = Sets.newHashSet();
        }

        private static ImmutableList<URL> getClassLoaderUrls(ClassLoader r10) {
            if ((r10 instanceof URLClassLoader) == false) goto L7;
            return ImmutableList.copyOf(((URLClassLoader) r10).getURLs());
        L7:
            if (r10.equals(ClassLoader.getSystemClassLoader()) == false) goto L11;
            return parseJavaClassPath();
        L11:
            return ImmutableList.of();
        }

        @VisibleForTesting
        public static ImmutableMap<File, ClassLoader> getClassPathEntries(ClassLoader r10) {
            LinkedHashMap r11 = Maps.newLinkedHashMap();
            ClassLoader r12 = r10.getParent();
            if (r12 == null) goto L5;
            r11.putAll(getClassPathEntries(r12));
        L5:
            UnmodifiableIterator<URL> r13 = getClassLoaderUrls(r10).iterator();
        L7:
            if (r13.hasNext() == false) goto L14;
            URL r14 = r13.next();
            if (r14.getProtocol().equals("file") == false) goto L7;
            File r15 = ClassPath.toFile(r14);
            if (r11.containsKey(r15) == true) goto L7;
            r11.put(r15, r10);
            goto L7
        L14:
            return ImmutableMap.copyOf(r11);
        }

        @VisibleForTesting
        public static URL getClassPathEntry(File r10, String r11) throws MalformedURLException {
            return new URL(r10.toURI().toURL(), r11);
        }

        @VisibleForTesting
        public static ImmutableSet<File> getClassPathFromManifest(File r10, @NullableDecl Manifest r11) {
            if (r11 == null) goto L4;
            ImmutableSet.Builder r12 = ImmutableSet.builder();
            String r13 = r11.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
            if (r13 == null) goto L17;
            Iterator<String> r14 = ClassPath.access$200().split(r13).iterator();
        L9:
            if (r14.hasNext() == false) goto L17;
            String r15 = r14.next();
            URL r16 = getClassPathEntry(r10, r15);     // Catch: MalformedURLException -> L15
            if (r16.getProtocol().equals("file") == false) goto L9;
            r12.add(ClassPath.toFile(r16));
        L15:
            ClassPath.access$100().warning("Invalid Class-Path entry: " + r15);
        L17:
            return r12.build();
        L4:
            return ImmutableSet.of();
        }

        @VisibleForTesting
        public static ImmutableList<URL> parseJavaClassPath() {
            ImmutableList.Builder r10 = ImmutableList.builder();
            Iterator<String> r11 = Splitter.on(StandardSystemProperty.PATH_SEPARATOR.value()).split(StandardSystemProperty.JAVA_CLASS_PATH.value()).iterator();
        L4:
            if (r11.hasNext() == false) goto L14;
            String r12 = r11.next();
            r10.add(new File(r12).toURI().toURL());     // Catch: MalformedURLException -> L8 SecurityException -> L10
        L8:
            e = move-exception;
            ClassPath.access$100().log(Level.WARNING, "malformed classpath entry: " + r12, e);
        L10:
            r10.add(new URL("file", null, new File(r12).getAbsolutePath()));     // Catch: MalformedURLException -> L8
            goto L4
        L14:
            return r10.build();
        }

        private void scanFrom(File r10, ClassLoader r11) throws IOException {
            if (r10.exists() == true) goto L6;
            return;
        L6:
            if (r10.isDirectory() == false) goto L8;
            scanDirectory(r11, r10);
            return;
        L8:
            scanJar(r10, r11);
            return;
        L10:
            e = move-exception;
            ClassPath.access$100().warning("Cannot access " + r10 + ": " + e);
        }

        private void scanJar(File r10, ClassLoader r11) throws IOException {
            JarFile r12 = new JarFile(r10);     // Catch: IOException -> L14
            UnmodifiableIterator<File> r13 = getClassPathFromManifest(r10, r12.getManifest()).iterator();     // Catch: Throwable -> L7
        L5:
            if (r13.hasNext() == false) goto L9;
            scan(r13.next(), r11);     // Catch: Throwable -> L7
            goto L5
        L9:
            scanJarFile(r11, r12);     // Catch: Throwable -> L7
            r12.close();     // Catch: IOException -> L15
            return;
        L26:
            return;
        L7:
            th = move-exception;
            r12.close();     // Catch: IOException -> L16
        L13:
            throw th;
        }

        public final void scan(ClassLoader r10) throws IOException {
            UnmodifiableIterator<Map.Entry<File, ClassLoader>> r11 = getClassPathEntries(r10).entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<File, ClassLoader> r12 = r11.next();
            scan(r12.getKey(), r12.getValue());
            goto L4
        }

        public abstract void scanDirectory(ClassLoader r10, File r11) throws IOException;

        public abstract void scanJarFile(ClassLoader r10, JarFile r11) throws IOException;

        @VisibleForTesting
        public final void scan(File r10, ClassLoader r11) throws IOException {
            if (this.scannedUris.add(r10.getCanonicalFile()) == false) goto L6;
            scanFrom(r10, r11);
            return;
        }
    }

    static {
        logger = Logger.getLogger(ClassPath.class.getName());
        IS_TOP_LEVEL = new AnonymousClass1();
        CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(" ").omitEmptyStrings();
    }

    private ClassPath(ImmutableSet<ResourceInfo> r10) {
        this.resources = r10;
    }

    public static /* synthetic */ Logger access$100() {
        return logger;
    }

    public static /* synthetic */ Splitter access$200() {
        return CLASS_PATH_ATTRIBUTE_SEPARATOR;
    }

    public static ClassPath from(ClassLoader r10) throws IOException {
        DefaultScanner r11 = new DefaultScanner();
        r11.scan(r10);
        return new ClassPath(r11.getResources());
    }

    @VisibleForTesting
    public static String getClassName(String r10) {
        return r10.substring(0, r10.length() - 6).replace('/', '.');
    }

    @VisibleForTesting
    public static File toFile(URL r10) {
        Preconditions.checkArgument(r10.getProtocol().equals("file"));
        return new File(r10.toURI());
    L6:
        return new File(r10.getPath());
    }

    public ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).toSet();
    }

    public ImmutableSet<ResourceInfo> getResources() {
        return this.resources;
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).filter(IS_TOP_LEVEL).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String r10) {
        Preconditions.checkNotNull(r10);
        String r11 = r10 + '.';
        ImmutableSet.Builder r12 = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> r13 = getTopLevelClasses().iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        ClassInfo r14 = r13.next();
        if (r14.getName().startsWith(r11) == false) goto L4;
        r12.add(r14);
        goto L4
    L9:
        return r12.build();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses(String r10) {
        Preconditions.checkNotNull(r10);
        ImmutableSet.Builder r11 = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> r12 = getTopLevelClasses().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        ClassInfo r13 = r12.next();
        if (r13.getPackageName().equals(r10) == false) goto L4;
        r11.add(r13);
        goto L4
    L9:
        return r11.build();
    }
}
