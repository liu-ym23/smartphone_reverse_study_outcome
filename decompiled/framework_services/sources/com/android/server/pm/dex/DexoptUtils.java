package com.android.server.pm.dex;

import android.content.pm.SharedLibraryInfo;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.ClassLoaderFactory;
import com.android.internal.util.ArrayUtils;
import com.android.server.pm.pkg.AndroidPackage;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class DexoptUtils {
    private static final String SHARED_LIBRARY_LOADER_TYPE = null;
    private static final String TAG = "DexoptUtils";

    static {
        SHARED_LIBRARY_LOADER_TYPE = ClassLoaderFactory.getPathClassLoaderName();
    }

    private DexoptUtils() {
    }

    public static String[] getClassLoaderContexts(AndroidPackage pkg, List<SharedLibraryInfo> sharedLibraries, boolean[] pathsWithCode) {
        String sharedLibrariesContext = "";
        if (sharedLibraries == null) goto L5;
        sharedLibrariesContext = encodeSharedLibraries(sharedLibraries);
    L5:
        String baseApkContextClassLoader = encodeClassLoader("", pkg.getClassLoaderName(), sharedLibrariesContext);
        if (ArrayUtils.isEmpty(pkg.getSplitCodePaths()) == true) goto L8;
        String[] splitRelativeCodePaths = getSplitRelativeCodePaths(pkg);
        String baseApkName = new File(pkg.getBaseApkPath()).getName();
        String[] classLoaderContexts = new String[splitRelativeCodePaths.length + 1];
        if (pathsWithCode[0] == false) goto L12;
        String r8 = baseApkContextClassLoader;
    L13:
        classLoaderContexts[0] = r8;
        SparseArray<int[]> splitDependencies = pkg.getSplitDependencies();
        if (pkg.isIsolatedSplitLoading() == false) goto L42;
        if (splitDependencies == null) goto L42;
        if (splitDependencies.size() == 0) goto L42;
        String[] splitClassLoaderEncodingCache = new String[splitRelativeCodePaths.length];
        int i = 0;
    L21:
        if (i >= splitRelativeCodePaths.length) goto L23;
        splitClassLoaderEncodingCache[i] = encodeClassLoader(splitRelativeCodePaths[i], pkg.getSplitClassLoaderNames()[i]);
        i = i + 1;
        goto L21
    L23:
        String splitDependencyOnBase = encodeClassLoader(baseApkName, pkg.getClassLoaderName());
        int i2 = 1;
    L25:
        if (i2 >= splitDependencies.size()) goto L30;
        int splitIndex = splitDependencies.keyAt(i2);
        if (pathsWithCode[splitIndex] == false) goto L29;
        getParentDependencies(splitIndex, splitClassLoaderEncodingCache, splitDependencies, classLoaderContexts, splitDependencyOnBase);
    L29:
        i2 = i2 + 1;
        goto L25
    L30:
        int i3 = 1;
    L32:
        if (i3 >= classLoaderContexts.length) goto L51;
        String splitClassLoader = encodeClassLoader("", pkg.getSplitClassLoaderNames()[i3 - 1]);
        if (pathsWithCode[i3] == true) goto L36;
        classLoaderContexts[i3] = null;
    L41:
        i3 = i3 + 1;
        goto L32
    L36:
        if (classLoaderContexts[i3] != null) goto L38;
        String r13 = splitClassLoader;
    L39:
        classLoaderContexts[i3] = r13;
        goto L41
    L38:
        r13 = encodeClassLoaderChain(splitClassLoader, classLoaderContexts[i3]) + sharedLibrariesContext;
    L51:
        return classLoaderContexts;
    L42:
        String classpath = baseApkName;
        int i4 = 1;
    L44:
        if (i4 >= classLoaderContexts.length) goto L51;
        if (pathsWithCode[i4] == false) goto L48;
        classLoaderContexts[i4] = encodeClassLoader(classpath, pkg.getClassLoaderName(), sharedLibrariesContext);
    L49:
        classpath = encodeClasspath(classpath, splitRelativeCodePaths[i4 - 1]);
        i4 = i4 + 1;
        goto L44
    L48:
        classLoaderContexts[i4] = null;
        goto L49
    L12:
        r8 = null;
        goto L13
    L8:
        return new String[]{baseApkContextClassLoader};
    }

    public static String getClassLoaderContext(SharedLibraryInfo info) {
        String sharedLibrariesContext = "";
        if (info.getDependencies() == null) goto L6;
        sharedLibrariesContext = encodeSharedLibraries(info.getDependencies());
    L6:
        return encodeClassLoader("", SHARED_LIBRARY_LOADER_TYPE, sharedLibrariesContext);
    }

    private static String getParentDependencies(int index, String[] splitClassLoaderEncodingCache, SparseArray<int[]> splitDependencies, String[] classLoaderContexts, String splitDependencyOnBase) {
        if (index != 0) goto L5;
        return splitDependencyOnBase;
    L5:
        if (classLoaderContexts[index] != null) goto L7;
        int parent = splitDependencies.get(index)[0];
        String parentDependencies = getParentDependencies(parent, splitClassLoaderEncodingCache, splitDependencies, classLoaderContexts, splitDependencyOnBase);
        if (parent != 0) goto L11;
        String splitContext = parentDependencies;
    L12:
        classLoaderContexts[index] = splitContext;
        return splitContext;
    L11:
        splitContext = encodeClassLoaderChain(splitClassLoaderEncodingCache[parent - 1], parentDependencies);
        goto L12
    L7:
        return classLoaderContexts[index];
    }

    private static String encodeSharedLibrary(SharedLibraryInfo sharedLibrary) {
        List<String> paths = sharedLibrary.getAllCodePaths();
        String classLoaderSpec = encodeClassLoader(encodeClasspath((String[]) paths.toArray(new String[paths.size()])), SHARED_LIBRARY_LOADER_TYPE);
        if (sharedLibrary.getDependencies() != null) goto L5;
        return classLoaderSpec;
    L5:
        return classLoaderSpec + encodeSharedLibraries(sharedLibrary.getDependencies());
    }

    private static String encodeSharedLibraries(List<SharedLibraryInfo> sharedLibraries) {
        String sharedLibrariesContext = "{";
        boolean first = true;
        Iterator<SharedLibraryInfo> r2 = sharedLibraries.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        SharedLibraryInfo info = r2.next();
        if (first == true) goto L8;
        sharedLibrariesContext = sharedLibrariesContext + "#";
    L8:
        first = false;
        sharedLibrariesContext = sharedLibrariesContext + encodeSharedLibrary(info);
        goto L4
    L10:
        return sharedLibrariesContext + "}";
    }

    private static String encodeClasspath(String[] classpathElements) {
        if (classpathElements != null) goto L4;
        return "";
    L4:
        if (classpathElements.length == 0) goto L19;
        StringBuilder sb = new StringBuilder();
        int r1 = classpathElements.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        String element = classpathElements[r2];
        if (sb.length() == 0) goto L11;
        sb.append(":");
    L11:
        sb.append(element);
        r2 = r2 + 1;
        goto L7
    L13:
        return sb.toString();
    L19:
        return "";
    }

    private static String encodeClasspath(String classpath, String newElement) {
        if (classpath.isEmpty() == false) goto L6;
        return newElement;
    L6:
        return classpath + ":" + newElement;
    }

    static String encodeClassLoader(String classpath, String classLoaderName) {
        classpath.getClass();
        String classLoaderDexoptEncoding = classLoaderName;
        if (ClassLoaderFactory.isPathClassLoaderName(classLoaderName) == false) goto L6;
        classLoaderDexoptEncoding = "PCL";
    L10:
        return classLoaderDexoptEncoding + "[" + classpath + "]";
    L6:
        if (ClassLoaderFactory.isDelegateLastClassLoaderName(classLoaderName) == false) goto L8;
        classLoaderDexoptEncoding = "DLC";
        goto L10
    L8:
        Slog.wtf(TAG, "Unsupported classLoaderName: " + classLoaderName);
        goto L10
    }

    private static String encodeClassLoader(String classpath, String classLoaderName, String sharedLibraries) {
        return encodeClassLoader(classpath, classLoaderName) + sharedLibraries;
    }

    static String encodeClassLoaderChain(String cl1, String cl2) {
        if (cl1.isEmpty() == false) goto L6;
        return cl2;
    L6:
        if (cl2.isEmpty() == false) goto L9;
        return cl1;
    L9:
        return cl1 + ";" + cl2;
    }

    static String[] processContextForDexLoad(List<String> classLoadersNames, List<String> classPaths) {
        if (classLoadersNames.size() != classPaths.size()) goto L28;
        if (classLoadersNames.isEmpty() == true) goto L26;
        String parentContext = "";
        int i = 1;
    L8:
        if (i >= classLoadersNames.size()) goto L16;
        if (ClassLoaderFactory.isValidClassLoaderName(classLoadersNames.get(i)) == false) goto L15;
        if (classPaths.get(i) == null) goto L15;
        String classpath = encodeClasspath(classPaths.get(i).split(File.pathSeparator));
        parentContext = encodeClassLoaderChain(parentContext, encodeClassLoader(classpath, classLoadersNames.get(i)));
        i = i + 1;
    L15:
        return null;
    L16:
        String loadingClassLoader = classLoadersNames.get(0);
        if (ClassLoaderFactory.isValidClassLoaderName(loadingClassLoader) == true) goto L19;
        return null;
    L19:
        String[] loadedDexPaths = classPaths.get(0).split(File.pathSeparator);
        String[] loadedDexPathsContext = new String[loadedDexPaths.length];
        String currentLoadedDexPathClasspath = "";
        int i2 = 0;
    L21:
        if (i2 >= loadedDexPaths.length) goto L24;
        String dexPath = loadedDexPaths[i2];
        String currentContext = encodeClassLoader(currentLoadedDexPathClasspath, loadingClassLoader);
        loadedDexPathsContext[i2] = encodeClassLoaderChain(currentContext, parentContext);
        currentLoadedDexPathClasspath = encodeClasspath(currentLoadedDexPathClasspath, dexPath);
        i2 = i2 + 1;
        goto L21
    L24:
        return loadedDexPathsContext;
    L26:
        throw new IllegalArgumentException("Empty classLoadersNames");
    L28:
        throw new IllegalArgumentException("The size of the class loader names and the dex paths do not match.");
    }

    private static String[] getSplitRelativeCodePaths(AndroidPackage pkg) {
        String baseCodePath = new File(pkg.getBaseApkPath()).getParent();
        String[] splitCodePaths = pkg.getSplitCodePaths();
        String[] splitRelativeCodePaths = new String[ArrayUtils.size(splitCodePaths)];
        int i = 0;
    L4:
        if (i >= splitRelativeCodePaths.length) goto L10;
        File pathFile = new File(splitCodePaths[i]);
        splitRelativeCodePaths[i] = pathFile.getName();
        String basePath = pathFile.getParent();
        if (basePath.equals(baseCodePath) == true) goto L8;
        Slog.wtf(TAG, "Split paths have different base paths: " + basePath + " and " + baseCodePath);
    L8:
        i = i + 1;
        goto L4
    L10:
        return splitRelativeCodePaths;
    }
}
