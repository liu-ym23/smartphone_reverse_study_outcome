package com.android.server.pm.dex;

import android.util.AtomicFile;
import android.util.Slog;
import com.android.internal.util.FastPrintWriter;
import com.android.server.pm.AbstractStatsBase;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
class PackageDynamicCodeLoading extends AbstractStatsBase<Void> {
    private static final char FIELD_SEPARATOR = ':';
    static final int FILE_TYPE_DEX = 68;
    static final int FILE_TYPE_NATIVE = 78;
    private static final String FILE_VERSION_HEADER = "DCL1";
    static final int MAX_FILES_PER_OWNER = 100;
    private static final Pattern PACKAGE_LINE_PATTERN = null;
    private static final String PACKAGE_PREFIX = "P:";
    private static final String PACKAGE_SEPARATOR = ",";
    private static final String TAG = "PackageDynamicCodeLoading";
    private final Object mLock;
    private Map<String, PackageDynamicCode> mPackageMap;

    static class DynamicCodeFile {
        final char mFileType;
        final Set<String> mLoadingPackages;
        final int mUserId;

        /* synthetic */ DynamicCodeFile(char r1, int r2, String[] r3, PackageDynamicCodeLoadingIA r4) {
            this(r1, r2, r3);
        }

        /* synthetic */ DynamicCodeFile(DynamicCodeFile r1, PackageDynamicCodeLoadingIA r2) {
            this(r1);
        }

        private DynamicCodeFile(char type, int user, String... packages) {
            this.mFileType = type;
            this.mUserId = user;
            this.mLoadingPackages = new HashSet(Arrays.asList(packages));
        }

        private DynamicCodeFile(DynamicCodeFile original) {
            this.mFileType = original.mFileType;
            this.mUserId = original.mUserId;
            this.mLoadingPackages = new HashSet(original.mLoadingPackages);
        }
    }

    static class PackageDynamicCode {
        final Map<String, DynamicCodeFile> mFileUsageMap;

        /* JADX INFO: renamed from: -$$Nest$madd, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7055$$Nest$madd(PackageDynamicCode r0, String r1, char r2, int r3, String r4) {
            return r0.add(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mremoveFile, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7056$$Nest$mremoveFile(PackageDynamicCode r0, String r1, int r2) {
            return r0.removeFile(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mremoveUser, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7057$$Nest$mremoveUser(PackageDynamicCode r0, int r1) {
            return r0.removeUser(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msyncData, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7058$$Nest$msyncData(PackageDynamicCode r0, Map r1, Set r2) {
            r0.syncData(r1, r2);
        }

        /* synthetic */ PackageDynamicCode(PackageDynamicCode r1, PackageDynamicCodeLoadingIA r2) {
            this(r1);
        }

        /* synthetic */ PackageDynamicCode(PackageDynamicCodeLoadingIA r1) {
            this();
        }

        private PackageDynamicCode() {
            this.mFileUsageMap = new HashMap();
        }

        private PackageDynamicCode(PackageDynamicCode original) {
            this.mFileUsageMap = new HashMap(original.mFileUsageMap.size());
            Iterator<Map.Entry<String, DynamicCodeFile>> r0 = original.mFileUsageMap.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Map.Entry<String, DynamicCodeFile> entry = r0.next();
            DynamicCodeFile newValue = new DynamicCodeFile(entry.getValue(), null);
            this.mFileUsageMap.put(entry.getKey(), newValue);
            goto L4
        }

        private boolean add(String path, char fileType, int userId, String loadingPackage) {
            DynamicCodeFile fileInfo = this.mFileUsageMap.get(path);
            if (fileInfo != null) goto L10;
            if (this.mFileUsageMap.size() < 100) goto L7;
            return false;
        L7:
            DynamicCodeFile fileInfo2 = new DynamicCodeFile(fileType, userId, new String[]{loadingPackage}, null);
            this.mFileUsageMap.put(path, fileInfo2);
            return true;
        L10:
            if (fileInfo.mUserId == userId) goto L13;
            return false;
        L13:
            return fileInfo.mLoadingPackages.add(loadingPackage);
        }

        private boolean removeUser(int userId) {
            boolean updated = false;
            Iterator<DynamicCodeFile> it = this.mFileUsageMap.values().iterator();
        L4:
            if (it.hasNext() == false) goto L9;
            DynamicCodeFile fileInfo = it.next();
            if (fileInfo.mUserId != userId) goto L4;
            it.remove();
            updated = true;
            goto L4
        L9:
            return updated;
        }

        private boolean removeFile(String filePath, int userId) {
            DynamicCodeFile fileInfo = this.mFileUsageMap.get(filePath);
            if (fileInfo != null) goto L5;
            return false;
        L5:
            if (fileInfo.mUserId != userId) goto L11;
            this.mFileUsageMap.remove(filePath);
            return true;
        L11:
            return false;
        }

        private void syncData(Map<String, Set<Integer>> packageToUsersMap, Set<Integer> owningPackageUsers) {
            Iterator<DynamicCodeFile> fileIt = this.mFileUsageMap.values().iterator();
        L4:
            if (fileIt.hasNext() == false) goto L21;
            DynamicCodeFile fileInfo = fileIt.next();
            int fileUserId = fileInfo.mUserId;
            if (owningPackageUsers.contains(Integer.valueOf(fileUserId)) == false) goto L7;
            Iterator<String> loaderIt = fileInfo.mLoadingPackages.iterator();
        L10:
            if (loaderIt.hasNext() == false) goto L18;
            String loader = loaderIt.next();
            Set<Integer> loadingPackageUsers = packageToUsersMap.get(loader);
            if (loadingPackageUsers == null) goto L15;
            if (loadingPackageUsers.contains(Integer.valueOf(fileUserId)) == true) goto L10;
        L15:
            loaderIt.remove();
            goto L10
        L18:
            if (fileInfo.mLoadingPackages.isEmpty() == false) goto L4;
            fileIt.remove();
            goto L4
        L7:
            fileIt.remove();
            goto L4
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

    static {
        PACKAGE_LINE_PATTERN = Pattern.compile("([A-Z]):([0-9]+):([^:]*):(.*)");
    }

    PackageDynamicCodeLoading() {
        super("package-dcl.list", "PackageDynamicCodeLoading_DiskWriter", false);
        this.mLock = new Object();
        this.mPackageMap = new HashMap();
    }

    boolean record(String owningPackageName, String filePath, int fileType, int ownerUserId, String loadingPackageName) {
        if (isValidFileType(fileType) == false) goto L17;
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackageDynamicCode packageInfo = this.mPackageMap.get(owningPackageName);     // Catch: Throwable -> L9
        if (packageInfo != null) goto L11;
        packageInfo = new PackageDynamicCode(null);     // Catch: Throwable -> L9
        this.mPackageMap.put(owningPackageName, packageInfo);     // Catch: Throwable -> L9
    L11:
        boolean r2 = PackageDynamicCode.m7055$$Nest$madd(packageInfo, filePath, (char) fileType, ownerUserId, loadingPackageName);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalArgumentException("Bad file type: " + fileType);
    }

    private static boolean isValidFileType(int fileType) {
        if (fileType != 68) goto L5;
    L8:
        return true;
    L5:
        if (fileType == 78) goto L8;
        return false;
    }

    Set<String> getAllPackagesWithDynamicCodeLoading() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        HashSet r1 = new HashSet(this.mPackageMap.keySet());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    PackageDynamicCode getPackageDynamicCodeInfo(String r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackageDynamicCode r1 = this.mPackageMap.get(r5);     // Catch: Throwable -> L10
        PackageDynamicCode r2 = null;
        Object[] r3 = 0;
        if (r1 == null) goto L8;
        r2 = new PackageDynamicCode(r1, r3 == true ? 1 : 0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    void clear() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPackageMap.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean removePackage(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mPackageMap.remove(packageName) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    boolean removeUserPackage(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackageDynamicCode packageDynamicCode = this.mPackageMap.get(packageName);     // Catch: Throwable -> L8
        if (packageDynamicCode != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L11:
        if (PackageDynamicCode.m7057$$Nest$mremoveUser(packageDynamicCode, userId) == true) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L13:
        if (packageDynamicCode.mFileUsageMap.isEmpty() == false) goto L15;
        this.mPackageMap.remove(packageName);     // Catch: Throwable -> L8
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    boolean removeFile(String packageName, String filePath, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackageDynamicCode packageDynamicCode = this.mPackageMap.get(packageName);     // Catch: Throwable -> L8
        if (packageDynamicCode != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L11:
        if (PackageDynamicCode.m7056$$Nest$mremoveFile(packageDynamicCode, filePath, userId) == true) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L13:
        if (packageDynamicCode.mFileUsageMap.isEmpty() == false) goto L15;
        this.mPackageMap.remove(packageName);     // Catch: Throwable -> L8
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    void syncData(Map<String, Set<Integer>> packageToUsersMap) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<Map.Entry<String, PackageDynamicCode>> it = this.mPackageMap.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (it.hasNext() == false) goto L17;
        Map.Entry<String, PackageDynamicCode> entry = it.next();     // Catch: Throwable -> L10
        Set<Integer> packageUsers = packageToUsersMap.get(entry.getKey());     // Catch: Throwable -> L10
        if (packageUsers != null) goto L12;
        it.remove();     // Catch: Throwable -> L10
        goto L6
    L12:
        PackageDynamicCode packageDynamicCode = entry.getValue();     // Catch: Throwable -> L10
        PackageDynamicCode.m7058$$Nest$msyncData(packageDynamicCode, packageToUsersMap, packageUsers);     // Catch: Throwable -> L10
        if (packageDynamicCode.mFileUsageMap.isEmpty() == false) goto L6;
        it.remove();     // Catch: Throwable -> L10
        goto L6
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void maybeWriteAsync() {
        super.maybeWriteAsync(null);
    }

    void writeNow() {
        super.writeNow(null);
    }

    /* JADX INFO: renamed from: writeInternal, reason: avoid collision after fix types in other method */
    protected final void writeInternal2(Void data) {
        AtomicFile file = getFile();
        FileOutputStream output = null;
        output = file.startWrite();     // Catch: IOException -> L5
        write(output);     // Catch: IOException -> L5
        file.finishWrite(output);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        file.failWrite(output);
        Slog.e(TAG, "Failed to write dynamic usage for secondary code files.", e);
    }

    void write(OutputStream output) throws IOException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Map<String, PackageDynamicCode> copiedMap = new HashMap(this.mPackageMap.size());     // Catch: Throwable -> L8
        Iterator<Map.Entry<String, PackageDynamicCode>> r2 = this.mPackageMap.entrySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<String, PackageDynamicCode> entry = r2.next();     // Catch: Throwable -> L8
        PackageDynamicCode copiedValue = new PackageDynamicCode(entry.getValue(), null);     // Catch: Throwable -> L8
        copiedMap.put(entry.getKey(), copiedValue);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        write(output, copiedMap);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static void write(OutputStream output, Map<String, PackageDynamicCode> packageMap) throws IOException {
        FastPrintWriter r0 = new FastPrintWriter(output);
        r0.println(FILE_VERSION_HEADER);
        Iterator<Map.Entry<String, PackageDynamicCode>> r1 = packageMap.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, PackageDynamicCode> packageEntry = r1.next();
        r0.print(PACKAGE_PREFIX);
        r0.println(packageEntry.getKey());
        Map<String, DynamicCodeFile> mFileUsageMap = packageEntry.getValue().mFileUsageMap;
        Iterator<Map.Entry<String, DynamicCodeFile>> r4 = mFileUsageMap.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        Map.Entry<String, DynamicCodeFile> fileEntry = r4.next();
        String path = fileEntry.getKey();
        DynamicCodeFile dynamicCodeFile = fileEntry.getValue();
        r0.print(dynamicCodeFile.mFileType);
        r0.print(FIELD_SEPARATOR);
        r0.print(dynamicCodeFile.mUserId);
        r0.print(FIELD_SEPARATOR);
        String prefix = "";
        Iterator<String> r10 = dynamicCodeFile.mLoadingPackages.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        String packageName = r10.next();
        r0.print(prefix);
        r0.print(packageName);
        prefix = PACKAGE_SEPARATOR;
        goto L10
    L12:
        r0.print(FIELD_SEPARATOR);
        r0.println(escape(path));
        goto L7
    L14:
        r0.flush();
        if (r0.checkError() == true) goto L18;
        return;
    L18:
        throw new IOException("Writer failed");
    }

    void read() {
        super.read(null);
    }

    /* JADX INFO: renamed from: readInternal, reason: avoid collision after fix types in other method */
    protected final void readInternal2(Void data) {
        AtomicFile file = getFile();
        FileInputStream stream = null;
        stream = file.openRead();     // Catch: Throwable -> L6 IOException -> L8 FileNotFoundException -> L10
        read(stream);     // Catch: Throwable -> L6 IOException -> L8 FileNotFoundException -> L10
    L18:
        goto L5
    L6:
        th = move-exception;
        IoUtils.closeQuietly(stream);
        throw th;
    L8:
        e = move-exception;
        Slog.w(TAG, "Failed to parse dynamic usage for secondary code files.", e);     // Catch: Throwable -> L6
    L5:
        IoUtils.closeQuietly(stream);
    }

    void read(InputStream stream) throws IOException {
        Map<String, PackageDynamicCode> newPackageMap = new HashMap();
        read(stream, newPackageMap);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mPackageMap = newPackageMap;     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void read(InputStream stream, Map<String, PackageDynamicCode> packageMap) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String versionLine = reader.readLine();
        if (FILE_VERSION_HEADER.equals(versionLine) == false) goto L25;
        String line = reader.readLine();
        if (line == null) goto L11;
        if (line.startsWith(PACKAGE_PREFIX) == true) goto L11;
        throw new IOException("Malformed line: " + line);
    L11:
        if (line == null) goto L23;
        String packageName = line.substring(PACKAGE_PREFIX.length());
        PackageDynamicCode packageInfo = new PackageDynamicCode(null);
    L13:
        line = reader.readLine();
        if (line == null) goto L20;
        if (line.startsWith(PACKAGE_PREFIX) == true) goto L20;
        readFileInfo(line, packageInfo);
    L20:
        if (packageInfo.mFileUsageMap.isEmpty() == true) goto L11;
        packageMap.put(packageName, packageInfo);
        goto L11
    L23:
        return;
    L25:
        throw new IOException("Incorrect version line: " + versionLine);
    }

    private static void readFileInfo(String line, PackageDynamicCode output) throws IOException {
        Matcher matcher = PACKAGE_LINE_PATTERN.matcher(line);     // Catch: RuntimeException -> L12
        if (matcher.matches() == false) goto L19;
        char type = matcher.group(1).charAt(0);     // Catch: RuntimeException -> L12
        int user = Integer.parseInt(matcher.group(2));     // Catch: RuntimeException -> L12
        String[] packages = matcher.group(3).split(PACKAGE_SEPARATOR);     // Catch: RuntimeException -> L12
        String path = unescape(matcher.group(4));     // Catch: RuntimeException -> L12
        if (packages.length == 0) goto L17;
        if (isValidFileType(type) == false) goto L15;
        output.mFileUsageMap.put(path, new DynamicCodeFile(type, user, packages, null));     // Catch: RuntimeException -> L12
        return;
    L15:
        throw new IOException("Unknown file type: " + line);     // Catch: RuntimeException -> L12
    L17:
        throw new IOException("Malformed line: " + line);     // Catch: RuntimeException -> L12
    L19:
        throw new IOException("Malformed line: " + line);     // Catch: RuntimeException -> L12
    L12:
        e = move-exception;
        throw new IOException("Unable to parse line: " + line, e);
    }

    static String escape(String path) {
        if (path.indexOf(92) == (-1)) goto L5;
    L9:
        StringBuilder result = new StringBuilder(path.length() + 10);
        int i = 0;
    L11:
        if (i >= path.length()) goto L20;
        char c = path.charAt(i);
        switch(c) {
            case 10: goto L17;
            case 13: goto L16;
            case 92: goto L15;
            default: goto L14;
        };
    L14:
        result.append(c);
    L18:
        i = i + 1;
        goto L11
    L15:
        result.append("\\\\");
        goto L18
    L16:
        result.append("\\r");
        goto L18
    L17:
        result.append("\\n");
        goto L18
    L20:
        return result.toString();
    L5:
        if (path.indexOf(10) != (-1)) goto L9;
        if (path.indexOf(13) != (-1)) goto L9;
        return path;
    }

    static String unescape(String escaped) throws IOException {
        int start = 0;
        int finish = escaped.indexOf(92);
        if (finish != (-1)) goto L5;
        return escaped;
    L5:
        StringBuilder result = new StringBuilder(escaped.length());
    L7:
        if (finish >= (escaped.length() - 1)) goto L20;
        result.append(escaped, start, finish);
        switch(escaped.charAt(finish + 1)) {
            case 92: goto L14;
            case 110: goto L13;
            case 114: goto L12;
            default: goto L11;
        };
    L12:
        result.append('\r');
    L15:
        start = finish + 2;
        finish = escaped.indexOf(92, start);
        if (finish != (-1)) goto L7;
        result.append(escaped, start, escaped.length());
        return result.toString();
    L13:
        result.append('\n');
        goto L15
    L14:
        result.append('\\');
        goto L15
    L11:
        throw new IOException("Bad escape in: " + escaped);
    L20:
        throw new IOException("Unexpected \\ in: " + escaped);
    }
}
