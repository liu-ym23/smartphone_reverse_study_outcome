package com.android.server.pm;

import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Log;
import com.android.internal.util.FastPrintWriter;
import com.android.internal.util.IndentingPrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
class CompilerStats extends AbstractStatsBase<Void> {
    private static final int COMPILER_STATS_VERSION = 1;
    private static final String COMPILER_STATS_VERSION_HEADER = "PACKAGE_MANAGER__COMPILER_STATS__";
    private final Map<String, PackageStats> packageStats;

    static class PackageStats {
        private final Map<String, Long> compileTimePerCodePath;
        private final String packageName;

        /* JADX INFO: renamed from: -$$Nest$fgetcompileTimePerCodePath, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m6614$$Nest$fgetcompileTimePerCodePath(PackageStats r0) {
            return r0.compileTimePerCodePath;
        }

        public PackageStats(String packageName) {
            this.packageName = packageName;
            this.compileTimePerCodePath = new ArrayMap(2);
        }

        public String getPackageName() {
            return this.packageName;
        }

        public long getCompileTime(String codePath) {
            String storagePath = getStoredPathFromCodePath(codePath);
            Map<String, Long> r1 = this.compileTimePerCodePath;
            monitor-enter(r1);
            Long l = this.compileTimePerCodePath.get(storagePath);     // Catch: Throwable -> L9
            if (l != null) goto L11;
            monitor-exit(r1);     // Catch: Throwable -> L9
            return 0;
        L11:
            long r3 = l.longValue();     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            return r3;
        L9:
            th = move-exception;
            throw th;
        }

        public void setCompileTime(String codePath, long compileTimeInMs) {
            String storagePath = getStoredPathFromCodePath(codePath);
            Map<String, Long> r1 = this.compileTimePerCodePath;
            monitor-enter(r1);
            if (compileTimeInMs > 0) goto L9;
            this.compileTimePerCodePath.remove(storagePath);     // Catch: Throwable -> L7
        L10:
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L9:
            this.compileTimePerCodePath.put(storagePath, Long.valueOf(compileTimeInMs));     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        private static String getStoredPathFromCodePath(String codePath) {
            int lastSlash = codePath.lastIndexOf(File.separatorChar);
            return codePath.substring(lastSlash + 1);
        }

        public void dump(IndentingPrintWriter ipw) {
            Map<String, Long> r0 = this.compileTimePerCodePath;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.compileTimePerCodePath.size() != 0) goto L9;
            ipw.println("(No recorded stats)");     // Catch: Throwable -> L7
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            Iterator<Map.Entry<String, Long>> r1 = this.compileTimePerCodePath.entrySet().iterator();     // Catch: Throwable -> L7
        L11:
            if (r1.hasNext() == false) goto L13;
            Map.Entry<String, Long> e = r1.next();     // Catch: Throwable -> L7
            ipw.println(" " + e.getKey() + " - " + e.getValue());     // Catch: Throwable -> L7
            goto L11
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

    public CompilerStats() {
        super("package-cstats.list", "CompilerStats_DiskWriter", false);
        this.packageStats = new HashMap();
    }

    public PackageStats getPackageStats(String packageName) {
        Map<String, PackageStats> r0 = this.packageStats;
        monitor-enter(r0);
        PackageStats r1 = this.packageStats.get(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setPackageStats(String packageName, PackageStats stats) {
        Map<String, PackageStats> r0 = this.packageStats;
        monitor-enter(r0);
        this.packageStats.put(packageName, stats);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public PackageStats createPackageStats(String packageName) {
        Map<String, PackageStats> r0 = this.packageStats;
        monitor-enter(r0);
        PackageStats newStats = new PackageStats(packageName);     // Catch: Throwable -> L7
        this.packageStats.put(packageName, newStats);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return newStats;
    L7:
        th = move-exception;
        throw th;
    }

    public PackageStats getOrCreatePackageStats(String packageName) {
        Map<String, PackageStats> r0 = this.packageStats;
        monitor-enter(r0);
        PackageStats existingStats = this.packageStats.get(packageName);     // Catch: Throwable -> L8
        if (existingStats == null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return existingStats;
    L10:
        PackageStats r2 = createPackageStats(packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    public void deletePackageStats(String packageName) {
        Map<String, PackageStats> r0 = this.packageStats;
        monitor-enter(r0);
        this.packageStats.remove(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void write(Writer out) {
        FastPrintWriter fpw = new FastPrintWriter(out);
        fpw.print(COMPILER_STATS_VERSION_HEADER);
        fpw.println(1);
        Map<String, PackageStats> r1 = this.packageStats;
        monitor-enter(r1);
        Iterator<PackageStats> r2 = this.packageStats.values().iterator();     // Catch: Throwable -> L21
    L6:
        if (r2.hasNext() == false) goto L23;
        PackageStats pkg = r2.next();     // Catch: Throwable -> L21
        Map r4 = PackageStats.m6614$$Nest$fgetcompileTimePerCodePath(pkg);     // Catch: Throwable -> L21
        monitor-enter(r4);     // Catch: Throwable -> L21
        if (PackageStats.m6614$$Nest$fgetcompileTimePerCodePath(pkg).isEmpty() == true) goto L17;
        fpw.println(pkg.getPackageName());     // Catch: Throwable -> L15
        Iterator r5 = PackageStats.m6614$$Nest$fgetcompileTimePerCodePath(pkg).entrySet().iterator();     // Catch: Throwable -> L15
    L13:
        if (r5.hasNext() == false) goto L17;
        Map.Entry<String, Long> e = (Map.Entry) r5.next();     // Catch: Throwable -> L15
        fpw.println("-" + e.getKey() + ":" + e.getValue());     // Catch: Throwable -> L15
    L17:
        monitor-exit(r4);     // Catch: Throwable -> L15
        goto L6
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L21
        fpw.flush();
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public boolean read(Reader r) {
        Map<String, PackageStats> r0 = this.packageStats;
        monitor-enter(r0);
        this.packageStats.clear();     // Catch: Throwable -> L20
        BufferedReader in = new BufferedReader(r);     // Catch: Throwable -> L20 Exception -> L22
        String versionLine = in.readLine();     // Catch: Throwable -> L20 Exception -> L22
        if (versionLine == null) goto L36;
        if (versionLine.startsWith(COMPILER_STATS_VERSION_HEADER) == false) goto L34;
        int version = Integer.parseInt(versionLine.substring(COMPILER_STATS_VERSION_HEADER.length()));     // Catch: Throwable -> L20 Exception -> L22
        if (version != 1) goto L32;
        PackageStats currentPackage = new PackageStats("fake package");     // Catch: Throwable -> L20 Exception -> L22
    L12:
        String s = in.readLine();     // Catch: Throwable -> L20 Exception -> L22
        if (s == null) goto L29;
        if (s.startsWith("-") == true) goto L16;
        currentPackage = getOrCreatePackageStats(s);     // Catch: Throwable -> L20 Exception -> L22
        goto L12
    L16:
        int colonIndex = s.indexOf(58);     // Catch: Throwable -> L20 Exception -> L22
        if (colonIndex == (-1)) goto L25;
        if (colonIndex == 1) goto L25;
        String codePath = s.substring(1, colonIndex);     // Catch: Throwable -> L20 Exception -> L22
        long time = Long.parseLong(s.substring(colonIndex + 1));     // Catch: Throwable -> L20 Exception -> L22
        currentPackage.setCompileTime(codePath, time);     // Catch: Throwable -> L20 Exception -> L22
    L25:
        throw new IllegalArgumentException("Could not parse data " + s);     // Catch: Throwable -> L20 Exception -> L22
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return true;
    L32:
        throw new IllegalArgumentException("Unexpected version: " + version);     // Catch: Throwable -> L20 Exception -> L22
    L34:
        throw new IllegalArgumentException("Invalid version line: " + versionLine);     // Catch: Throwable -> L20 Exception -> L22
    L36:
        throw new IllegalArgumentException("No version line found.");     // Catch: Throwable -> L20 Exception -> L22
    L22:
        e = move-exception;
        Log.e(PackageManagerServiceMonitorEx.TAG, "Error parsing compiler stats", e);     // Catch: Throwable -> L20
        return false;
    L20:
        th = move-exception;
        throw th;
    }

    void writeNow() {
        writeNow(null);
    }

    boolean maybeWriteAsync() {
        return maybeWriteAsync(null);
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
        Log.e(PackageManagerServiceMonitorEx.TAG, "Failed to write compiler stats", e);
    }

    void read() {
        read(null);
    }

    /* JADX INFO: renamed from: readInternal, reason: avoid collision after fix types in other method */
    protected void readInternal2(Void data) {
        AtomicFile file = getFile();
        BufferedReader in = null;
        in = new BufferedReader(new InputStreamReader(file.openRead()));     // Catch: Throwable -> L5 FileNotFoundException -> L7
        read(in);     // Catch: Throwable -> L5 FileNotFoundException -> L7
    L5:
        th = move-exception;
        IoUtils.closeQuietly(in);
        throw th;
    L4:
        IoUtils.closeQuietly(in);
    }
}
