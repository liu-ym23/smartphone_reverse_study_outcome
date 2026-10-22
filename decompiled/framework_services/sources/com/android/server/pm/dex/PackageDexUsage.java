package com.android.server.pm.dex;

import android.os.Build;
import android.util.AtomicFile;
import android.util.Slog;
import com.android.internal.util.FastPrintWriter;
import com.android.server.pm.AbstractStatsBase;
import com.android.server.pm.PackageManagerServiceUtils;
import dalvik.system.VMRuntime;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PackageDexUsage extends AbstractStatsBase<Void> {
    private static final String CODE_PATH_LINE_CHAR = "+";
    private static final String DEX_LINE_CHAR = "#";
    private static final String LOADING_PACKAGE_CHAR = "@";
    static final int MAX_SECONDARY_FILES_PER_OWNER = 100;
    private static final int PACKAGE_DEX_USAGE_VERSION = 2;
    private static final String PACKAGE_DEX_USAGE_VERSION_HEADER = "PACKAGE_MANAGER__PACKAGE_DEX_USAGE__";
    private static final String SPLIT_CHAR = ",";
    private static final String TAG = "PackageDexUsage";
    static final String UNSUPPORTED_CLASS_LOADER_CONTEXT = "=UnsupportedClassLoaderContext=";
    static final String VARIABLE_CLASS_LOADER_CONTEXT = "=VariableClassLoaderContext=";
    private final Map<String, PackageUseInfo> mPackageUseInfoMap;

    public static class DexUseInfo {
        private String mClassLoaderContext;
        private boolean mIsUsedByOtherApps;
        private final Set<String> mLoaderIsas;
        private final Set<String> mLoadingPackages;
        private final int mOwnerUserId;

        /* JADX INFO: renamed from: -$$Nest$fgetmIsUsedByOtherApps, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7047$$Nest$fgetmIsUsedByOtherApps(DexUseInfo r0) {
            return r0.mIsUsedByOtherApps;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLoaderIsas, reason: not valid java name */
        static /* bridge */ /* synthetic */ Set m7048$$Nest$fgetmLoaderIsas(DexUseInfo r0) {
            return r0.mLoaderIsas;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLoadingPackages, reason: not valid java name */
        static /* bridge */ /* synthetic */ Set m7049$$Nest$fgetmLoadingPackages(DexUseInfo r0) {
            return r0.mLoadingPackages;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOwnerUserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7050$$Nest$fgetmOwnerUserId(DexUseInfo r0) {
            return r0.mOwnerUserId;
        }

        /* JADX INFO: renamed from: -$$Nest$mmerge, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7051$$Nest$mmerge(DexUseInfo r0, DexUseInfo r1, boolean r2) {
            return r0.merge(r1, r2);
        }

        /* synthetic */ DexUseInfo(DexUseInfo r1, PackageDexUsageIA r2) {
            this(r1);
        }

        DexUseInfo(boolean isUsedByOtherApps, int ownerUserId, String classLoaderContext, String loaderIsa) {
            this.mIsUsedByOtherApps = isUsedByOtherApps;
            this.mOwnerUserId = ownerUserId;
            this.mClassLoaderContext = classLoaderContext;
            this.mLoaderIsas = new HashSet();
            if (loaderIsa == null) goto L5;
            this.mLoaderIsas.add(loaderIsa);
        L5:
            this.mLoadingPackages = new HashSet();
        }

        private DexUseInfo(DexUseInfo other) {
            this.mIsUsedByOtherApps = other.mIsUsedByOtherApps;
            this.mOwnerUserId = other.mOwnerUserId;
            this.mClassLoaderContext = other.mClassLoaderContext;
            this.mLoaderIsas = new HashSet(other.mLoaderIsas);
            this.mLoadingPackages = new HashSet(other.mLoadingPackages);
        }

        private boolean merge(DexUseInfo dexUseInfo, boolean overwriteCLC) {
            boolean oldIsUsedByOtherApps = this.mIsUsedByOtherApps;
            if (this.mIsUsedByOtherApps == false) goto L5;
        L8:
            boolean r1 = true;
        L9:
            this.mIsUsedByOtherApps = r1;
            boolean updateIsas = this.mLoaderIsas.addAll(dexUseInfo.mLoaderIsas);
            boolean updateLoadingPackages = this.mLoadingPackages.addAll(dexUseInfo.mLoadingPackages);
            String oldClassLoaderContext = this.mClassLoaderContext;
            if (overwriteCLC == false) goto L13;
            this.mClassLoaderContext = dexUseInfo.mClassLoaderContext;
        L18:
            if (updateIsas == false) goto L20;
            return true;
        L20:
            if (oldIsUsedByOtherApps != this.mIsUsedByOtherApps) goto L29;
            if (updateLoadingPackages == false) goto L23;
            return true;
        L23:
            if (Objects.equals(oldClassLoaderContext, this.mClassLoaderContext) == true) goto L27;
            return true;
        L27:
            return false;
        L29:
            return true;
        L13:
            if (isUnsupportedContext(this.mClassLoaderContext) == false) goto L16;
            this.mClassLoaderContext = dexUseInfo.mClassLoaderContext;
            goto L18
        L16:
            if (Objects.equals(this.mClassLoaderContext, dexUseInfo.mClassLoaderContext) == true) goto L18;
            this.mClassLoaderContext = PackageDexUsage.VARIABLE_CLASS_LOADER_CONTEXT;
            goto L18
        L5:
            if (dexUseInfo.mIsUsedByOtherApps == true) goto L8;
            r1 = false;
            goto L9
        }

        private static boolean isUnsupportedContext(String context) {
            return PackageDexUsage.UNSUPPORTED_CLASS_LOADER_CONTEXT.equals(context);
        }

        public boolean isUsedByOtherApps() {
            return this.mIsUsedByOtherApps;
        }

        int getOwnerUserId() {
            return this.mOwnerUserId;
        }

        public Set<String> getLoaderIsas() {
            return this.mLoaderIsas;
        }

        public Set<String> getLoadingPackages() {
            return this.mLoadingPackages;
        }

        public String getClassLoaderContext() {
            return this.mClassLoaderContext;
        }

        public boolean isUnsupportedClassLoaderContext() {
            return isUnsupportedContext(this.mClassLoaderContext);
        }

        public boolean isVariableClassLoaderContext() {
            return PackageDexUsage.VARIABLE_CLASS_LOADER_CONTEXT.equals(this.mClassLoaderContext);
        }
    }

    public static class PackageUseInfo {
        private final Map<String, DexUseInfo> mDexUseInfoMap;
        private final String mPackageName;
        private final Map<String, Set<String>> mPrimaryCodePaths;

        /* JADX INFO: renamed from: -$$Nest$fgetmDexUseInfoMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m7052$$Nest$fgetmDexUseInfoMap(PackageUseInfo r0) {
            return r0.mDexUseInfoMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPrimaryCodePaths, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m7053$$Nest$fgetmPrimaryCodePaths(PackageUseInfo r0) {
            return r0.mPrimaryCodePaths;
        }

        /* JADX INFO: renamed from: -$$Nest$mmergePrimaryCodePaths, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7054$$Nest$mmergePrimaryCodePaths(PackageUseInfo r0, String r1, String r2) {
            return r0.mergePrimaryCodePaths(r1, r2);
        }

        /* synthetic */ PackageUseInfo(PackageUseInfo r1, PackageDexUsageIA r2) {
            this(r1);
        }

        PackageUseInfo(String packageName) {
            this.mPrimaryCodePaths = new HashMap();
            this.mDexUseInfoMap = new HashMap();
            this.mPackageName = packageName;
        }

        private PackageUseInfo(PackageUseInfo other) {
            this.mPackageName = other.mPackageName;
            this.mPrimaryCodePaths = new HashMap();
            Iterator<Map.Entry<String, Set<String>>> r0 = other.mPrimaryCodePaths.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Map.Entry<String, Set<String>> e = r0.next();
            this.mPrimaryCodePaths.put(e.getKey(), new HashSet(e.getValue()));
            goto L4
        L6:
            this.mDexUseInfoMap = new HashMap();
            Iterator<Map.Entry<String, DexUseInfo>> r1 = other.mDexUseInfoMap.entrySet().iterator();
        L8:
            if (r1.hasNext() == false) goto L10;
            Map.Entry<String, DexUseInfo> e2 = r1.next();
            this.mDexUseInfoMap.put(e2.getKey(), new DexUseInfo(e2.getValue(), null));
            goto L8
        }

        private boolean mergePrimaryCodePaths(String codePath, String loadingPackage) {
            Set<String> loadingPackages = this.mPrimaryCodePaths.get(codePath);
            if (loadingPackages != null) goto L6;
            loadingPackages = new HashSet();
            this.mPrimaryCodePaths.put(codePath, loadingPackages);
        L6:
            return loadingPackages.add(loadingPackage);
        }

        public boolean isUsedByOtherApps(String codePath) {
            if (this.mPrimaryCodePaths.containsKey(codePath) == false) goto L12;
            Set<String> loadingPackages = this.mPrimaryCodePaths.get(codePath);
            if (loadingPackages.contains(this.mPackageName) == false) goto L11;
            if (loadingPackages.size() > 1) goto L9;
            return false;
        L9:
            return true;
        L11:
            return !loadingPackages.isEmpty();
        L12:
            return false;
        }

        public Map<String, DexUseInfo> getDexUseInfoMap() {
            return this.mDexUseInfoMap;
        }

        public Set<String> getLoadingPackages(String codePath) {
            return this.mPrimaryCodePaths.getOrDefault(codePath, null);
        }

        public boolean isAnyCodePathUsedByOtherApps() {
            return !this.mPrimaryCodePaths.isEmpty();
        }

        boolean clearCodePathUsedByOtherApps() {
            boolean updated = false;
            List<String> retainOnlyOwningPackage = new ArrayList(1);
            retainOnlyOwningPackage.add(this.mPackageName);
            Iterator<Map.Entry<String, Set<String>>> r2 = this.mPrimaryCodePaths.entrySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            Map.Entry<String, Set<String>> entry = r2.next();
            if (entry.getValue().retainAll(retainOnlyOwningPackage) == false) goto L4;
            updated = true;
            goto L4
        L9:
            return updated;
        }
    }

    @Override // com.android.server.pm.AbstractStatsBase
    protected /* bridge */ /* synthetic */ void readInternal(Void r1) {
        readInternal2(r1);
    }

    @Override // com.android.server.pm.AbstractStatsBase
    protected /* bridge */ /* synthetic */ void writeInternal(Void r1) {
        writeInternal2(r1);
    }

    PackageDexUsage() {
        super("package-dex-usage.list", "PackageDexUsage_DiskWriter", false);
        this.mPackageUseInfoMap = new HashMap();
    }

    boolean record(String owningPackageName, String dexPath, int ownerUserId, String loaderIsa, boolean primaryOrSplit, String loadingPackageName, String classLoaderContext, boolean overwriteCLC) {
        if (PackageManagerServiceUtils.checkISA(loaderIsa) == false) goto L53;
        if (classLoaderContext == null) goto L51;
        boolean r8 = false;
        if (classLoaderContext.equals(UNSUPPORTED_CLASS_LOADER_CONTEXT) == false) goto L9;
        Slog.e(TAG, "Unsupported context?");
        return false;
    L9:
        boolean isUsedByOtherApps = !owningPackageName.equals(loadingPackageName);
        Map<String, PackageUseInfo> r11 = this.mPackageUseInfoMap;
        monitor-enter(r11);
        PackageUseInfo packageUseInfo = this.mPackageUseInfoMap.get(owningPackageName);     // Catch: Throwable -> L16
        if (packageUseInfo != null) goto L22;
        PackageUseInfo packageUseInfo2 = new PackageUseInfo(owningPackageName);     // Catch: Throwable -> L16
        if (primaryOrSplit == false) goto L18;
        PackageUseInfo.m7054$$Nest$mmergePrimaryCodePaths(packageUseInfo2, dexPath, loadingPackageName);     // Catch: Throwable -> L16
    L19:
        this.mPackageUseInfoMap.put(owningPackageName, packageUseInfo2);     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
        return true;
    L18:
        DexUseInfo newData = new DexUseInfo(isUsedByOtherApps, ownerUserId, classLoaderContext, loaderIsa);     // Catch: Throwable -> L16
        PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(packageUseInfo2).put(dexPath, newData);     // Catch: Throwable -> L16
        maybeAddLoadingPackage(owningPackageName, loadingPackageName, DexUseInfo.m7049$$Nest$fgetmLoadingPackages(newData));     // Catch: Throwable -> L16
        goto L19
    L22:
        if (primaryOrSplit == false) goto L26;
        boolean r9 = PackageUseInfo.m7054$$Nest$mmergePrimaryCodePaths(packageUseInfo, dexPath, loadingPackageName);     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
        return r9;
    L26:
        DexUseInfo newData2 = new DexUseInfo(isUsedByOtherApps, ownerUserId, classLoaderContext, loaderIsa);     // Catch: Throwable -> L16
        boolean updateLoadingPackages = maybeAddLoadingPackage(owningPackageName, loadingPackageName, DexUseInfo.m7049$$Nest$fgetmLoadingPackages(newData2));     // Catch: Throwable -> L16
        DexUseInfo existingData = (DexUseInfo) PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(packageUseInfo).get(dexPath);     // Catch: Throwable -> L16
        if (existingData != null) goto L36;
        if (PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(packageUseInfo).size() >= 100) goto L33;
        PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(packageUseInfo).put(dexPath, newData2);     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
        return true;
    L33:
        monitor-exit(r11);     // Catch: Throwable -> L16
        return updateLoadingPackages;
    L36:
        if (ownerUserId != DexUseInfo.m7050$$Nest$fgetmOwnerUserId(existingData)) goto L47;
        if (DexUseInfo.m7051$$Nest$mmerge(existingData, newData2, overwriteCLC) == true) goto L41;
        if (updateLoadingPackages == true) goto L41;
    L42:
        monitor-exit(r11);     // Catch: Throwable -> L44
        return r8;
    L41:
        r8 = true;
        goto L42
    L47:
        throw new IllegalArgumentException("Trying to change ownerUserId for  dex path " + dexPath + " from " + DexUseInfo.m7050$$Nest$fgetmOwnerUserId(existingData) + " to " + ownerUserId);     // Catch: Throwable -> L44
    L44:
        th = th;
    L48:
        monitor-exit(r11);     // Catch: Throwable -> L44
        throw th;
    L16:
        th = th;
        goto L48
    L51:
        throw new IllegalArgumentException("Null classLoaderContext");
    L53:
        throw new IllegalArgumentException("loaderIsa " + loaderIsa + " is unsupported");
    }

    void read() {
        read(null);
    }

    void maybeWriteAsync() {
        maybeWriteAsync(null);
    }

    void writeNow() {
        writeInternal2(null);
    }

    /* JADX INFO: renamed from: writeInternal, reason: avoid collision after fix types in other method */
    protected void writeInternal2(Void data) {
        AtomicFile file = getFile();
        FileOutputStream f = null;
        f = file.startWrite();     // Catch: IOException -> L5
        OutputStreamWriter osw = new OutputStreamWriter(f);     // Catch: IOException -> L5
        write(osw);     // Catch: IOException -> L5
        osw.flush();     // Catch: IOException -> L5
        file.finishWrite(f);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        if (f == null) goto L8;
        file.failWrite(f);
    L8:
        Slog.e(TAG, "Failed to write usage for dex files", e);
    }

    void write(Writer out) {
        Map<String, PackageUseInfo> packageUseInfoMapClone = clonePackageUseInfoMap();
        FastPrintWriter fpw = new FastPrintWriter(out);
        fpw.print(PACKAGE_DEX_USAGE_VERSION_HEADER);
        int r3 = 2;
        fpw.println(2);
        Iterator<Map.Entry<String, PackageUseInfo>> r4 = packageUseInfoMapClone.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L18;
        Map.Entry<String, PackageUseInfo> pEntry = r4.next();
        String packageName = pEntry.getKey();
        PackageUseInfo packageUseInfo = pEntry.getValue();
        fpw.println(packageName);
        Iterator r8 = PackageUseInfo.m7053$$Nest$fgetmPrimaryCodePaths(packageUseInfo).entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        Map.Entry<String, Set<String>> codeEntry = (Map.Entry) r8.next();
        String codePath = codeEntry.getKey();
        Set<String> loadingPackages = codeEntry.getValue();
        fpw.println(CODE_PATH_LINE_CHAR + codePath);
        fpw.println(LOADING_PACKAGE_CHAR + String.join(SPLIT_CHAR, loadingPackages));
        goto L7
    L9:
        Iterator r9 = PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(packageUseInfo).entrySet().iterator();
    L11:
        if (r9.hasNext() == false) goto L17;
        Map.Entry<String, DexUseInfo> dEntry = (Map.Entry) r9.next();
        String dexPath = dEntry.getKey();
        DexUseInfo dexUseInfo = dEntry.getValue();
        fpw.println(DEX_LINE_CHAR + dexPath);
        CharSequence[] r14 = new CharSequence[r3];
        r14[0] = Integer.toString(DexUseInfo.m7050$$Nest$fgetmOwnerUserId(dexUseInfo));
        r14[1] = writeBoolean(DexUseInfo.m7047$$Nest$fgetmIsUsedByOtherApps(dexUseInfo));
        fpw.print(String.join(SPLIT_CHAR, r14));
        Iterator r15 = DexUseInfo.m7048$$Nest$fgetmLoaderIsas(dexUseInfo).iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        String isa = (String) r15.next();
        fpw.print(SPLIT_CHAR + isa);
        packageUseInfoMapClone = packageUseInfoMapClone;
        goto L14
    L16:
        fpw.println();
        fpw.println(LOADING_PACKAGE_CHAR + String.join(SPLIT_CHAR, DexUseInfo.m7049$$Nest$fgetmLoadingPackages(dexUseInfo)));
        fpw.println(dexUseInfo.getClassLoaderContext());
        packageUseInfoMapClone = packageUseInfoMapClone;
        r3 = 2;
        goto L11
    L17:
        r3 = 2;
        goto L4
    L18:
        fpw.flush();
    }

    /* JADX INFO: renamed from: readInternal, reason: avoid collision after fix types in other method */
    protected void readInternal2(Void data) {
        AtomicFile file = getFile();
        BufferedReader in = null;
        in = new BufferedReader(new InputStreamReader(file.openRead()));     // Catch: Throwable -> L6 IOException -> L8 FileNotFoundException -> L10
        read(in);     // Catch: Throwable -> L6 IOException -> L8 FileNotFoundException -> L10
    L18:
        goto L5
    L6:
        th = move-exception;
        IoUtils.closeQuietly(in);
        throw th;
    L8:
        e = move-exception;
        Slog.w(TAG, "Failed to parse package dex usage.", e);     // Catch: Throwable -> L6
    L5:
        IoUtils.closeQuietly(in);
    }

    void read(Reader reader) throws IOException {
        Map<String, PackageUseInfo> data = new HashMap();
        BufferedReader in = new BufferedReader(reader);
        String versionLine = in.readLine();
        if (versionLine == null) goto L61;
        if (versionLine.startsWith(PACKAGE_DEX_USAGE_VERSION_HEADER) == false) goto L59;
        int version = Integer.parseInt(versionLine.substring(PACKAGE_DEX_USAGE_VERSION_HEADER.length()));
        if (isSupportedVersion(version) == true) goto L10;
        Slog.w(TAG, "Unexpected package-dex-use version: " + version + ". Not reading from it");
        return;
    L10:
        Set<String> supportedIsas = new HashSet();
        String[] r9 = Build.SUPPORTED_ABIS;
        int r10 = r9.length;
        char r11 = 0;
        int r12 = 0;
    L12:
        if (r12 >= r10) goto L14;
        String abi = r9[r12];
        supportedIsas.add(VMRuntime.getInstructionSet(abi));
        r12 = r12 + 1;
        goto L12
    L14:
        PackageUseInfo currentPackageData = null;
        String currentPackage = null;
    L15:
        String line = in.readLine();
        if (line == null) goto L50;
        if (line.startsWith(DEX_LINE_CHAR) == true) goto L19;
        String currentPackage2 = currentPackage;
        Set<String> supportedIsas2 = supportedIsas;
        PackageUseInfo currentPackageData2 = currentPackageData;
        if (line.startsWith(CODE_PATH_LINE_CHAR) == true) goto L47;
        currentPackage = line;
        currentPackageData = new PackageUseInfo(currentPackage);
        data.put(currentPackage, currentPackageData);
        supportedIsas = supportedIsas2;
        r11 = 0;
        goto L15
    L47:
        String codePath = line.substring(CODE_PATH_LINE_CHAR.length());
        Set<String> loadingPackages = readLoadingPackages(in, version);
        PackageUseInfo.m7053$$Nest$fgetmPrimaryCodePaths(currentPackageData2).put(codePath, loadingPackages);
    L48:
        currentPackage = currentPackage2;
        currentPackageData = currentPackageData2;
        supportedIsas = supportedIsas2;
        r11 = 0;
        goto L15
    L19:
        if (currentPackage == null) goto L44;
        String dexPath = line.substring(DEX_LINE_CHAR.length());
        String line2 = in.readLine();
        if (line2 == null) goto L42;
        String[] elems = line2.split(SPLIT_CHAR);
        if (elems.length < 3) goto L40;
        Set<String> loadingPackages2 = readLoadingPackages(in, version);
        String classLoaderContext = readClassLoaderContext(in, version);
        if (UNSUPPORTED_CLASS_LOADER_CONTEXT.equals(classLoaderContext) == false) goto L27;
        currentPackage2 = currentPackage;
        supportedIsas2 = supportedIsas;
        currentPackageData2 = currentPackageData;
        goto L48
    L27:
        int ownerUserId = Integer.parseInt(elems[r11]);
        boolean isUsedByOtherApps = readBoolean(elems[1]);
        currentPackage2 = currentPackage;
        DexUseInfo dexUseInfo = new DexUseInfo(isUsedByOtherApps, ownerUserId, classLoaderContext, null);
        DexUseInfo.m7049$$Nest$fgetmLoadingPackages(dexUseInfo).addAll(loadingPackages2);
        int i = 2;
    L28:
        currentPackageData2 = currentPackageData;
        if (i >= elems.length) goto L35;
        String isa = elems[i];
        if (supportedIsas.contains(isa) == false) goto L33;
        int i2 = i;
        DexUseInfo.m7048$$Nest$fgetmLoaderIsas(dexUseInfo).add(elems[i2]);
    L34:
        i = i2 + 1;
        currentPackageData = currentPackageData2;
        supportedIsas = supportedIsas;
        isUsedByOtherApps = isUsedByOtherApps;
        goto L28
    L33:
        i2 = i;
        Slog.wtf(TAG, "Unsupported ISA when parsing PackageDexUsage: " + isa);
        goto L34
    L35:
        supportedIsas2 = supportedIsas;
        if (supportedIsas2.isEmpty() == false) goto L38;
        Slog.wtf(TAG, "Ignore dexPath when parsing PackageDexUsage because of unsupported isas. dexPath=" + dexPath);
        goto L48
    L38:
        PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(currentPackageData2).put(dexPath, dexUseInfo);
        goto L48
    L40:
        throw new IllegalStateException("Invalid PackageDexUsage line: " + line2);
    L42:
        throw new IllegalStateException("Could not find dexUseInfo line");
    L44:
        throw new IllegalStateException("Malformed PackageDexUsage file. Expected package line before dex line.");
    L50:
        Map<String, PackageUseInfo> r3 = this.mPackageUseInfoMap;
        monitor-enter(r3);
        this.mPackageUseInfoMap.clear();     // Catch: Throwable -> L55
        this.mPackageUseInfoMap.putAll(data);     // Catch: Throwable -> L55
        monitor-exit(r3);     // Catch: Throwable -> L55
        return;
    L55:
        th = move-exception;
        throw th;
    L59:
        throw new IllegalStateException("Invalid version line: " + versionLine);
    L61:
        throw new IllegalStateException("No version line found.");
    }

    private String readClassLoaderContext(BufferedReader in, int version) throws IOException {
        String context = in.readLine();
        if (context == null) goto L6;
        return context;
    L6:
        throw new IllegalStateException("Could not find the classLoaderContext line.");
    }

    private Set<String> readLoadingPackages(BufferedReader in, int version) throws IOException {
        String line = in.readLine();
        if (line == null) goto L9;
        Set<String> result = new HashSet();
        if (line.length() == LOADING_PACKAGE_CHAR.length()) goto L7;
        Collections.addAll(result, line.substring(LOADING_PACKAGE_CHAR.length()).split(SPLIT_CHAR));
    L7:
        return result;
    L9:
        throw new IllegalStateException("Could not find the loadingPackages line.");
    }

    private boolean maybeAddLoadingPackage(String owningPackage, String loadingPackage, Set<String> loadingPackages) {
        if (owningPackage.equals(loadingPackage) == false) goto L5;
    L7:
        return false;
    L5:
        if (loadingPackages.add(loadingPackage) == false) goto L7;
        return true;
    }

    private boolean isSupportedVersion(int version) {
        if (version != 2) goto L5;
        return true;
    L5:
        return false;
    }

    void syncData(Map<String, Set<Integer>> packageToUsersMap, Map<String, Set<String>> packageToCodePaths, List<String> packagesToKeepDataAbout) {
        Map<String, PackageUseInfo> r4 = this.mPackageUseInfoMap;
        monitor-enter(r4);
        Iterator<Map.Entry<String, PackageUseInfo>> pIt = this.mPackageUseInfoMap.entrySet().iterator();     // Catch: Throwable -> L13
    L5:
        if (pIt.hasNext() == false) goto L49;
        Map.Entry<String, PackageUseInfo> pEntry = pIt.next();     // Catch: Throwable -> L13
        String packageName = pEntry.getKey();     // Catch: Throwable -> L13
        if (packagesToKeepDataAbout.contains(packageName) == true) goto L5;
        PackageUseInfo packageUseInfo = pEntry.getValue();     // Catch: Throwable -> L13
        Set<Integer> users = packageToUsersMap.get(packageName);     // Catch: Throwable -> L13
        if (users != null) goto L15;
        pIt.remove();     // Catch: Throwable -> L13
        Iterator<Map.Entry<String, PackageUseInfo>> pIt2 = pIt;
    L47:
        pIt = pIt2;
        goto L5
    L15:
        Iterator<Map.Entry<String, DexUseInfo>> dIt = PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(packageUseInfo).entrySet().iterator();     // Catch: Throwable -> L13
    L17:
        if (dIt.hasNext() == false) goto L55;
        DexUseInfo dexUseInfo = dIt.next().getValue();     // Catch: Throwable -> L13
        if (users.contains(Integer.valueOf(DexUseInfo.m7050$$Nest$fgetmOwnerUserId(dexUseInfo))) == true) goto L17;
        dIt.remove();     // Catch: Throwable -> L13
        goto L17
    L55:
        Set<String> codePaths = packageToCodePaths.get(packageName);     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, Set<String>>> recordedIt = PackageUseInfo.m7053$$Nest$fgetmPrimaryCodePaths(packageUseInfo).entrySet().iterator();     // Catch: Throwable -> L29
    L25:
        if (recordedIt.hasNext() == false) goto L42;
        Map.Entry<String, Set<String>> entry = recordedIt.next();     // Catch: Throwable -> L29
        String recordedCodePath = entry.getKey();     // Catch: Throwable -> L29
        if (codePaths.contains(recordedCodePath) == true) goto L31;
        recordedIt.remove();     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, PackageUseInfo>> pIt3 = pIt;
    L41:
        pIt = pIt3;
        goto L25
    L31:
        Set<String> recordedLoadingPackages = entry.getValue();     // Catch: Throwable -> L29
        Iterator<String> recordedLoadingPackagesIt = recordedLoadingPackages.iterator();     // Catch: Throwable -> L29
    L33:
        if (recordedLoadingPackagesIt.hasNext() == false) goto L40;
        String recordedLoadingPackage = recordedLoadingPackagesIt.next();     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, PackageUseInfo>> pIt4 = pIt;
        if (packagesToKeepDataAbout.contains(recordedLoadingPackage) == true) goto L39;
        if (packageToUsersMap.containsKey(recordedLoadingPackage) == true) goto L39;
        recordedLoadingPackagesIt.remove();     // Catch: Throwable -> L29
    L39:
        pIt = pIt4;
        goto L33
    L40:
        pIt3 = pIt;
        goto L41
    L42:
        pIt2 = pIt;
        if (packageUseInfo.isAnyCodePathUsedByOtherApps() == true) goto L47;
        if (PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(packageUseInfo).isEmpty() == false) goto L47;
        pIt2.remove();     // Catch: Throwable -> L29
    L29:
        th = th;
    L51:
        monitor-exit(r4);     // Catch: Throwable -> L29
        throw th;
    L49:
        monitor-exit(r4);     // Catch: Throwable -> L29
        return;
    L13:
        th = th;
        goto L51
    }

    boolean clearUsedByOtherApps(String packageName) {
        Map<String, PackageUseInfo> r0 = this.mPackageUseInfoMap;
        monitor-enter(r0);
        PackageUseInfo packageUseInfo = this.mPackageUseInfoMap.get(packageName);     // Catch: Throwable -> L9
        if (packageUseInfo != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = packageUseInfo.clearCodePathUsedByOtherApps();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    boolean removePackage(String packageName) {
        Map<String, PackageUseInfo> r0 = this.mPackageUseInfoMap;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mPackageUseInfoMap.remove(packageName) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    boolean removeUserPackage(String packageName, int userId) {
        Map<String, PackageUseInfo> r0 = this.mPackageUseInfoMap;
        monitor-enter(r0);
        PackageUseInfo packageUseInfo = this.mPackageUseInfoMap.get(packageName);     // Catch: Throwable -> L9
        if (packageUseInfo != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean updated = false;
        Iterator<Map.Entry<String, DexUseInfo>> dIt = PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(packageUseInfo).entrySet().iterator();     // Catch: Throwable -> L9
    L13:
        if (dIt.hasNext() == false) goto L19;
        DexUseInfo dexUseInfo = dIt.next().getValue();     // Catch: Throwable -> L9
        if (DexUseInfo.m7050$$Nest$fgetmOwnerUserId(dexUseInfo) != userId) goto L13;
        dIt.remove();     // Catch: Throwable -> L9
        updated = true;
        goto L13
    L19:
        if (PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(packageUseInfo).isEmpty() == true) goto L21;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return updated;
    L21:
        if (packageUseInfo.isAnyCodePathUsedByOtherApps() == true) goto L23;
        this.mPackageUseInfoMap.remove(packageName);     // Catch: Throwable -> L9
        updated = true;
    L9:
        th = move-exception;
        throw th;
    }

    boolean removeDexFile(String packageName, String dexFile, int userId) {
        Map<String, PackageUseInfo> r0 = this.mPackageUseInfoMap;
        monitor-enter(r0);
        PackageUseInfo packageUseInfo = this.mPackageUseInfoMap.get(packageName);     // Catch: Throwable -> L9
        if (packageUseInfo != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = removeDexFile(packageUseInfo, dexFile, userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean removeDexFile(PackageUseInfo packageUseInfo, String dexFile, int userId) {
        DexUseInfo dexUseInfo = (DexUseInfo) PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(packageUseInfo).get(dexFile);
        if (dexUseInfo != null) goto L6;
        return false;
    L6:
        if (DexUseInfo.m7050$$Nest$fgetmOwnerUserId(dexUseInfo) != userId) goto L9;
        PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(packageUseInfo).remove(dexFile);
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    PackageUseInfo getPackageUseInfo(String r5) {
        Map<String, PackageUseInfo> r0 = this.mPackageUseInfoMap;
        monitor-enter(r0);
        PackageUseInfo r1 = this.mPackageUseInfoMap.get(r5);     // Catch: Throwable -> L10
        PackageUseInfo r2 = null;
        Object[] r3 = 0;
        if (r1 == null) goto L8;
        r2 = new PackageUseInfo(r1, r3 == true ? 1 : 0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    Set<String> getAllPackagesWithSecondaryDexFiles() {
        Set<String> packages = new HashSet();
        Map<String, PackageUseInfo> r1 = this.mPackageUseInfoMap;
        monitor-enter(r1);
        Iterator<Map.Entry<String, PackageUseInfo>> r2 = this.mPackageUseInfoMap.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        Map.Entry<String, PackageUseInfo> entry = r2.next();     // Catch: Throwable -> L10
        if (PackageUseInfo.m7052$$Nest$fgetmDexUseInfoMap(entry.getValue()).isEmpty() == true) goto L6;
        packages.add(entry.getKey());     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return packages;
    L10:
        th = move-exception;
        throw th;
    }

    void clear() {
        Map<String, PackageUseInfo> r0 = this.mPackageUseInfoMap;
        monitor-enter(r0);
        this.mPackageUseInfoMap.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private Map<String, PackageUseInfo> clonePackageUseInfoMap() {
        Map<String, PackageUseInfo> clone = new HashMap();
        Map<String, PackageUseInfo> r1 = this.mPackageUseInfoMap;
        monitor-enter(r1);
        Iterator<Map.Entry<String, PackageUseInfo>> r2 = this.mPackageUseInfoMap.entrySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<String, PackageUseInfo> e = r2.next();     // Catch: Throwable -> L8
        clone.put(e.getKey(), new PackageUseInfo(e.getValue(), null));     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return clone;
    L8:
        th = move-exception;
        throw th;
    }

    private String writeBoolean(boolean bool) {
        if (bool == false) goto L4;
        return "1";
    L4:
        return "0";
    }

    private boolean readBoolean(String bool) {
        if ("0".equals(bool) == false) goto L7;
        return false;
    L7:
        if ("1".equals(bool) == false) goto L11;
        return true;
    L11:
        throw new IllegalArgumentException("Unknown bool encoding: " + bool);
    }

    String dump() {
        StringWriter sw = new StringWriter();
        write(sw);
        return sw.toString();
    }
}
