package com.google.common.reflect;

import com.android.contacts.util.HanziToPinyin;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ClassPath {
    private static final String CLASS_FILE_NAME_EXTENSION = ".class";
    private static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR = null;
    private static final Predicate<ClassInfo> IS_TOP_LEVEL = null;
    private static final Logger logger = null;
    private final ImmutableSet<ResourceInfo> resources;

    public static final class ClassInfo extends ResourceInfo {
        private final String className;

        static /* synthetic */ String access$000(ClassInfo r0) {
            return r0.className;
        }

        ClassInfo(String r1, ClassLoader r2) {
            super(r1, r2);
            this.className = ClassPath.getClassName(r1);
        }

        public String getPackageName() {
            return Reflection.getPackageName(this.className);
        }

        public String getSimpleName() {
            int r0 = this.className.lastIndexOf(36);
            if (r0 == (-1)) goto L6;
            String r2 = this.className.substring(r0 + 1);
            return CharMatcher.DIGIT.trimLeadingFrom(r2);
        L6:
            String r1 = getPackageName();
            if (r1.isEmpty() == false) goto L11;
            return this.className;
        L11:
            return this.className.substring(r1.length() + 1);
        }

        public String getName() {
            return this.className;
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

    public static class ResourceInfo {
        final ClassLoader loader;
        private final String resourceName;

        static ResourceInfo of(String r1, ClassLoader r2) {
            if (r1.endsWith(ClassPath.CLASS_FILE_NAME_EXTENSION) == false) goto L7;
            return new ClassInfo(r1, r2);
        L7:
            return new ResourceInfo(r1, r2);
        }

        ResourceInfo(String r1, ClassLoader r2) {
            this.resourceName = (String) Preconditions.checkNotNull(r1);
            this.loader = (ClassLoader) Preconditions.checkNotNull(r2);
        }

        public final URL url() {
            return (URL) Preconditions.checkNotNull(this.loader.getResource(this.resourceName), "Failed to load resource: %s", new Object[]{this.resourceName});
        }

        public final String getResourceName() {
            return this.resourceName;
        }

        public int hashCode() {
            return this.resourceName.hashCode();
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof ResourceInfo) == false) goto L10;
            ResourceInfo r5 = (ResourceInfo) r4;
            if (this.resourceName.equals(r5.resourceName) == true) goto L7;
            return false;
        L7:
            if (this.loader != r5.loader) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public String toString() {
            return this.resourceName;
        }
    }

    static final class Scanner {
        private final ImmutableSortedSet.Builder<ResourceInfo> resources;
        private final Set<URI> scannedUris;

        Scanner() {
            this.resources = new ImmutableSortedSet.Builder(Ordering.usingToString());
            this.scannedUris = Sets.newHashSet();
        }

        ImmutableSortedSet<ResourceInfo> getResources() {
            return this.resources.build();
        }

        void scan(URI r3, ClassLoader r4) throws IOException {
            if (r3.getScheme().equals("file") == true) goto L5;
            return;
        L5:
            if (this.scannedUris.add(r3) == false) goto L9;
            scanFrom(new File(r3), r4);
            return;
        }

        void scanFrom(File r2, ClassLoader r3) throws IOException {
            if (r2.exists() == true) goto L6;
            return;
        L6:
            if (r2.isDirectory() == false) goto L8;
            scanDirectory(r2, r3);
            return;
        L8:
            scanJar(r2, r3);
        }

        private void scanDirectory(File r3, ClassLoader r4) throws IOException {
            scanDirectory(r3, r4, "", ImmutableSet.of());
        }

        private void scanDirectory(File r6, ClassLoader r7, String r8, ImmutableSet<File> r9) throws IOException {
            File r0 = r6.getCanonicalFile();
            if (r9.contains(r0) == false) goto L5;
            return;
        L5:
            File[] r1 = r6.listFiles();
            if (r1 != null) goto L9;
            ClassPath.access$100().warning("Cannot read directory " + r6);
            return;
        L9:
            ImmutableSet<File> r10 = ImmutableSet.builder().addAll(r9).add(r0).build();
            int r11 = r1.length;
            int r2 = 0;
        L10:
            if (r2 >= r11) goto L18;
            File r3 = r1[r2];
            String r4 = r3.getName();
            if (r3.isDirectory() == false) goto L14;
            scanDirectory(r3, r7, r8 + r4 + LibrarianImpl.Constants.SEPARATOR, r10);
        L17:
            r2 = r2 + 1;
            goto L10
        L14:
            String r5 = r8 + r4;
            if (r5.equals("META-INF/MANIFEST.MF") == true) goto L17;
            this.resources.add(ResourceInfo.of(r5, r7));
            goto L17
        }

        private void scanJar(File r5, ClassLoader r6) throws IOException {
            JarFile r0 = new JarFile(r5);     // Catch: IOException -> L22
            UnmodifiableIterator<URI> r7 = getClassPathFromManifest(r5, r0.getManifest()).iterator();     // Catch: Throwable -> L19
        L5:
            if (r7.hasNext() == false) goto L7;
            scan(r7.next(), r6);     // Catch: Throwable -> L19
            goto L5
        L7:
            Enumeration<JarEntry> r8 = r0.entries();     // Catch: Throwable -> L19
        L8:
            if (r8.hasMoreElements() == false) goto L27;
            JarEntry r1 = r8.nextElement();     // Catch: Throwable -> L19
            if (r1.isDirectory() == true) goto L8;
            if (r1.getName().equals("META-INF/MANIFEST.MF") == true) goto L8;
            this.resources.add(ResourceInfo.of(r1.getName(), r6));     // Catch: Throwable -> L19
            goto L8
        L27:
            r0.close();     // Catch: IOException -> L23
            return;
        L41:
            return;
        L19:
            th = move-exception;
            r0.close();     // Catch: IOException -> L24
        L21:
            throw th;
        }

        static ImmutableSet<URI> getClassPathFromManifest(File r5, @Nullable Manifest r6) {
            if (r6 == null) goto L4;
            ImmutableSet.Builder r0 = ImmutableSet.builder();
            String r7 = r6.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
            if (r7 == null) goto L15;
            Iterator<String> r8 = ClassPath.access$200().split(r7).iterator();
        L9:
            if (r8.hasNext() == false) goto L15;
            String r1 = r8.next();
            r0.add(getClassPathEntry(r5, r1));
        L13:
            ClassPath.access$100().warning("Invalid Class-Path entry: " + r1);
        L15:
            return r0.build();
        L4:
            return ImmutableSet.of();
        }

        static URI getClassPathEntry(File r3, String r4) throws URISyntaxException {
            URI r0 = new URI(r4);
            if (r0.isAbsolute() == false) goto L6;
            return r0;
        L6:
            return new File(r3.getParentFile(), r4.replace('/', File.separatorChar)).toURI();
        }
    }

    static /* synthetic */ Logger access$100() {
        return logger;
    }

    static /* synthetic */ Splitter access$200() {
        return CLASS_PATH_ATTRIBUTE_SEPARATOR;
    }

    static {
        logger = Logger.getLogger(ClassPath.class.getName());
        IS_TOP_LEVEL = new AnonymousClass1();
        CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(HanziToPinyin.Token.SEPARATOR).omitEmptyStrings();
    }

    private ClassPath(ImmutableSet<ResourceInfo> r1) {
        this.resources = r1;
    }

    public static ClassPath from(ClassLoader r3) throws IOException {
        Scanner r0 = new Scanner();
        UnmodifiableIterator<Map.Entry<URI, ClassLoader>> r4 = getClassPathEntries(r3).entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        Map.Entry<URI, ClassLoader> r1 = r4.next();
        r0.scan(r1.getKey(), r1.getValue());
        goto L4
    L7:
        return new ClassPath(r0.getResources());
    }

    public ImmutableSet<ResourceInfo> getResources() {
        return this.resources;
    }

    public ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).filter(IS_TOP_LEVEL).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses(String r4) {
        Preconditions.checkNotNull(r4);
        ImmutableSet.Builder r0 = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> r3 = getTopLevelClasses().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        ClassInfo r1 = r3.next();
        if (r1.getPackageName().equals(r4) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return r0.build();
    }

    public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String r4) {
        Preconditions.checkNotNull(r4);
        String r5 = r4 + '.';
        ImmutableSet.Builder r0 = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> r3 = getTopLevelClasses().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        ClassInfo r1 = r3.next();
        if (r1.getName().startsWith(r5) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return r0.build();
    }

    static ImmutableMap<URI, ClassLoader> getClassPathEntries(ClassLoader r6) {
        LinkedHashMap r0 = Maps.newLinkedHashMap();
        ClassLoader r1 = r6.getParent();
        if (r1 == null) goto L6;
        r0.putAll(getClassPathEntries(r1));
    L6:
        if ((r6 instanceof URLClassLoader) == false) goto L19;
        URL[] r2 = ((URLClassLoader) r6).getURLs();
        int r3 = r2.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L19;
        URI r5 = r2[r4].toURI();     // Catch: URISyntaxException -> L15
        if (r0.containsKey(r5) == true) goto L14;
        r0.put(r5, r6);
    L14:
        r4 = r4 + 1;
    L15:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L19:
        return ImmutableMap.copyOf(r0);
    }

    static String getClassName(String r2) {
        return r2.substring(0, r2.length() - 6).replace('/', '.');
    }
}
