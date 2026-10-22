package com.android.server.usage;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.os.Build;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.LongSparseArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.IndentingPrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes3.dex */
public class UsageStatsDatabase {
    public static final int BACKUP_VERSION = 4;
    private static final String BAK_SUFFIX = ".bak";
    private static final String CHECKED_IN_SUFFIX = "-c";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_CURRENT_VERSION = 5;
    static final boolean KEEP_BACKUP_DIR = false;
    static final String KEY_USAGE_STATS = "usage_stats";
    static final int[] MAX_FILES_PER_INTERVAL_TYPE = null;
    private static final String RETENTION_LEN_KEY = "ro.usagestats.chooser.retention";
    private static final int SELECTION_LOG_RETENTION_LEN = 0;
    private static final String TAG = "UsageStatsDatabase";
    private final File mBackupsDir;
    private final UnixCalendar mCal;
    private int mCurrentVersion;
    private boolean mFirstUpdate;
    private final File[] mIntervalDirs;
    private final Object mLock;
    private boolean mNewUpdate;
    private final File mPackageMappingsFile;
    final PackagesTokenData mPackagesTokenData;
    final LongSparseArray<AtomicFile>[] mSortedStatFiles;
    private final File mUpdateBreadcrumb;
    private boolean mUpgradePerformed;
    private final File mVersionFile;

    public interface CheckinAction {
        boolean checkin(IntervalStats r1);
    }

    public interface StatCombiner<T> {
        boolean combine(IntervalStats r1, boolean r2, List<T> r3);
    }

    static {
        MAX_FILES_PER_INTERVAL_TYPE = new int[]{100, 50, 12, 10};
        SELECTION_LOG_RETENTION_LEN = SystemProperties.getInt(RETENTION_LEN_KEY, 14);
    }

    public UsageStatsDatabase(File dir, int version) {
        this.mLock = new Object();
        this.mPackagesTokenData = new PackagesTokenData();
        this.mIntervalDirs = new File[]{new File(dir, "daily"), new File(dir, "weekly"), new File(dir, "monthly"), new File(dir, "yearly")};
        this.mCurrentVersion = version;
        this.mVersionFile = new File(dir, "version");
        this.mBackupsDir = new File(dir, "backups");
        this.mUpdateBreadcrumb = new File(dir, "breadcrumb");
        this.mSortedStatFiles = new LongSparseArray[this.mIntervalDirs.length];
        this.mPackageMappingsFile = new File(dir, "mappings");
        this.mCal = new UnixCalendar(0);
    }

    public UsageStatsDatabase(File dir) {
        this(dir, 5);
    }

    public void init(long currentTimeMillis) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        File[] r1 = this.mIntervalDirs;     // Catch: Throwable -> L11
        int r2 = r1.length;     // Catch: Throwable -> L11
        int r3 = 0;
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L13;
        File f = r1[r4];     // Catch: Throwable -> L11
        f.mkdirs();     // Catch: Throwable -> L11
        if (f.exists() == false) goto L10;
        r4 = r4 + 1;     // Catch: Throwable -> L11
        goto L5
    L10:
        throw new IllegalStateException("Failed to create directory " + f.getAbsolutePath());     // Catch: Throwable -> L11
    L13:
        checkVersionAndBuildLocked();     // Catch: Throwable -> L11
        if (this.mUpgradePerformed == false) goto L16;
        prune(currentTimeMillis);     // Catch: Throwable -> L11
    L17:
        LongSparseArray<AtomicFile>[] r5 = this.mSortedStatFiles;     // Catch: Throwable -> L11
        int r6 = r5.length;     // Catch: Throwable -> L11
    L18:
        if (r3 >= r6) goto L29;
        LongSparseArray<AtomicFile> files = r5[r3];     // Catch: Throwable -> L11
        int startIndex = files.firstIndexOnOrAfter(currentTimeMillis);     // Catch: Throwable -> L11
        if (startIndex < 0) goto L28;
        int fileCount = files.size();     // Catch: Throwable -> L11
        int i = startIndex;
    L23:
        if (i >= fileCount) goto L25;
        files.valueAt(i).delete();     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L23
    L25:
        int i2 = startIndex;
    L26:
        if (i2 >= fileCount) goto L28;
        files.removeAt(i2);     // Catch: Throwable -> L11
        i2 = i2 + 1;     // Catch: Throwable -> L11
    L28:
        r3 = r3 + 1;     // Catch: Throwable -> L11
        goto L18
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L16:
        indexFilesLocked();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public boolean checkinDailyFiles(CheckinAction checkinAction) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LongSparseArray<AtomicFile> files = this.mSortedStatFiles[0];     // Catch: Throwable -> L11
        int fileCount = files.size();     // Catch: Throwable -> L11
        int lastCheckin = -1;
        int i = 0;
    L6:
        if (i >= (fileCount - 1)) goto L13;
        if (files.valueAt(i).getBaseFile().getPath().endsWith(CHECKED_IN_SUFFIX) == false) goto L10;
        lastCheckin = i;
    L10:
        i = i + 1;     // Catch: Throwable -> L11
        goto L6
    L13:
        int i2 = lastCheckin + 1;     // Catch: Throwable -> L11
        if (i2 != (fileCount - 1)) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L17:
        int i3 = i2;
    L19:
        if (i3 >= (fileCount - 1)) goto L29;
        IntervalStats stats = new IntervalStats();     // Catch: Throwable -> L11 Exception -> L25
        readLocked(files.valueAt(i3), stats, false);     // Catch: Throwable -> L11 Exception -> L25
        if (checkinAction.checkin(stats) == false) goto L22;
        i3 = i3 + 1;     // Catch: Throwable -> L11
        goto L19
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L25:
        e = move-exception;
        Slog.e(TAG, "Failed to check-in", e);     // Catch: Throwable -> L11
        return false;
    L29:
        int i4 = i2;
    L31:
        if (i4 >= (fileCount - 1)) goto L39;
        AtomicFile file = files.valueAt(i4);     // Catch: Throwable -> L11
        File checkedInFile = new File(file.getBaseFile().getPath() + CHECKED_IN_SUFFIX);     // Catch: Throwable -> L11
        if (file.getBaseFile().renameTo(checkedInFile) == false) goto L34;
        files.setValueAt(i4, new AtomicFile(checkedInFile));     // Catch: Throwable -> L11
        i4 = i4 + 1;     // Catch: Throwable -> L11
        goto L31
    L34:
        Slog.e(TAG, "Failed to mark file " + file.getBaseFile().getPath() + " as checked-in");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L39:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        throw th;
    }

    void forceIndexFiles() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        indexFilesLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void indexFilesLocked() {
        FilenameFilter backupFileFilter = new AnonymousClass1(this);
        int i = 0;
    L4:
        if (i >= this.mSortedStatFiles.length) goto L28;
        if (this.mSortedStatFiles[i] != null) goto L8;
        this.mSortedStatFiles[i] = new LongSparseArray();
    L9:
        File[] files = this.mIntervalDirs[i].listFiles(backupFileFilter);
        if (files == null) goto L26;
        int len = files.length;
        int j = 0;
    L13:
        if (j >= len) goto L20;
        File f = files[j];
        AtomicFile af = new AtomicFile(f);
        this.mSortedStatFiles[i].put(parseBeginTime(af), af);     // Catch: IOException -> L17
    L19:
        j = j + 1;
    L17:
        e = move-exception;
        Slog.e(TAG, "failed to index file: " + f, e);
        goto L19
    L20:
        int toDelete = this.mSortedStatFiles[i].size() - MAX_FILES_PER_INTERVAL_TYPE[i];
        if (toDelete <= 0) goto L26;
        int j2 = 0;
    L23:
        if (j2 >= toDelete) goto L25;
        this.mSortedStatFiles[i].valueAt(0).delete();
        this.mSortedStatFiles[i].removeAt(0);
        j2 = j2 + 1;
        goto L23
    L25:
        Slog.d(TAG, "Deleted " + toDelete + " stat files for interval " + i);
    L26:
        i = i + 1;
        goto L4
    L8:
        this.mSortedStatFiles[i].clear();
        goto L9
    }

    boolean isFirstUpdate() {
        return this.mFirstUpdate;
    }

    boolean isNewUpdate() {
        return this.mNewUpdate;
    }

    boolean wasUpgradePerformed() {
        return this.mUpgradePerformed;
    }

    private void checkVersionAndBuildLocked() {
        String currentFingerprint = getBuildFingerprint();
        this.mFirstUpdate = true;
        this.mNewUpdate = true;
        BufferedReader reader = new BufferedReader(new FileReader(this.mVersionFile));     // Catch: Throwable -> L14
        int version = Integer.parseInt(reader.readLine());     // Catch: Throwable -> L7
        String buildFingerprint = reader.readLine();     // Catch: Throwable -> L7
        if (buildFingerprint == null) goto L10;
        this.mFirstUpdate = false;     // Catch: Throwable -> L7
    L10:
        if (currentFingerprint.equals(buildFingerprint) == false) goto L12;
        this.mNewUpdate = false;     // Catch: Throwable -> L7
    L12:
        reader.close();     // Catch: Throwable -> L14 Throwable -> L14
    L23:
        if (version == this.mCurrentVersion) goto L33;
        Slog.i(TAG, "Upgrading from version " + version + " to " + this.mCurrentVersion);
        if (this.mUpdateBreadcrumb.exists() == false) goto L88;
        Slog.i(TAG, "Version upgrade breadcrumb found on disk! Continuing version upgrade");
        goto L33
    L88:
        doUpgradeLocked(version);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        Slog.e(TAG, "Failed to upgrade from version " + version + " to " + this.mCurrentVersion, e);
        this.mCurrentVersion = version;
        return;
    L33:
        if (this.mUpdateBreadcrumb.exists() == false) goto L52;
        BufferedReader reader2 = new BufferedReader(new FileReader(this.mUpdateBreadcrumb));     // Catch: Throwable -> L41
        long token = Long.parseLong(reader2.readLine());     // Catch: Throwable -> L43
        int previousVersion = Integer.parseInt(reader2.readLine());     // Catch: Throwable -> L43
        reader2.close();     // Catch: Throwable -> L41 Throwable -> L41
        if (this.mCurrentVersion < 4) goto L40;
        continueUpgradeLocked(previousVersion, token);
        goto L52
    L40:
        Slog.wtf(TAG, "Attempting to upgrade to an unsupported version: " + this.mCurrentVersion);
    L43:
        th = move-exception;
        reader2.close();     // Catch: Throwable -> L46
    L48:
        throw th;     // Catch: Throwable -> L41 Throwable -> L41
    L46:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L41 Throwable -> L41
    L41:
        e = move-exception;
        Slog.e(TAG, "Failed read version upgrade breadcrumb");
        throw new RuntimeException(e);
    L52:
        if (version == this.mCurrentVersion) goto L54;
    L78:
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.mVersionFile));     // Catch: IOException -> L65
        writer.write(Integer.toString(this.mCurrentVersion));     // Catch: Throwable -> L67
        writer.write("\n");     // Catch: Throwable -> L67
        writer.write(currentFingerprint);     // Catch: Throwable -> L67
        writer.write("\n");     // Catch: Throwable -> L67
        writer.flush();     // Catch: Throwable -> L67
        writer.close();     // Catch: IOException -> L65
    L59:
        if (this.mUpdateBreadcrumb.exists() == false) goto L62;
        this.mUpdateBreadcrumb.delete();
        this.mUpgradePerformed = true;
    L62:
        if (this.mBackupsDir.exists() == false) goto L92;
        this.mUpgradePerformed = true;
        deleteDirectory(this.mBackupsDir);
        return;
    L92:
        return;
    L67:
        th = move-exception;
        writer.close();     // Catch: Throwable -> L70
    L72:
        throw th;     // Catch: IOException -> L65
    L70:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L65
    L65:
        e = move-exception;
        Slog.e(TAG, "Failed to write new version");
        throw new RuntimeException(e);
    L54:
        if (this.mNewUpdate == false) goto L59;
    L7:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L14 Throwable -> L14
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14 Throwable -> L14
        goto L20
    L21:
        version = 0;
        goto L23
    }

    private String getBuildFingerprint() {
        return Build.VERSION.RELEASE + ";" + Build.VERSION.CODENAME + ";" + Build.VERSION.INCREMENTAL;
    }

    private void doUpgradeLocked(int thisVersion) {
        char r3 = 0;
        if (thisVersion >= 2) goto L15;
        Slog.i(TAG, "Deleting all usage stats files");
        int i = 0;
    L6:
        if (i >= this.mIntervalDirs.length) goto L69;
        File[] files = this.mIntervalDirs[i].listFiles();
        if (files == null) goto L13;
        int r4 = files.length;
        int r6 = 0;
    L11:
        if (r6 >= r4) goto L13;
        File f = files[r6];
        f.delete();
        r6 = r6 + 1;
    L13:
        i = i + 1;
        goto L6
    L69:
        return;
    L15:
        long token = System.currentTimeMillis();
        File backupDir = new File(this.mBackupsDir, Long.toString(token));
        backupDir.mkdirs();
        if (backupDir.exists() == false) goto L54;
        Files.copy(this.mVersionFile.toPath(), new File(backupDir, this.mVersionFile.getName()).toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});     // Catch: IOException -> L50
        int i2 = 0;
    L20:
        if (i2 >= this.mIntervalDirs.length) goto L39;
        File backupIntervalDir = new File(backupDir, this.mIntervalDirs[i2].getName());
        backupIntervalDir.mkdir();
        if (backupIntervalDir.exists() == false) goto L38;
        File[] files2 = this.mIntervalDirs[i2].listFiles();
        if (files2 == null) goto L36;
        int j = 0;
    L27:
        if (j >= files2.length) goto L36;
        File backupFile = new File(backupIntervalDir, files2[j].getName());
        Path r14 = files2[j].toPath();     // Catch: IOException -> L31
        Path r15 = backupFile.toPath();     // Catch: IOException -> L31
        char r16 = r3;
        CopyOption[] r5 = new CopyOption[1];     // Catch: IOException -> L31
        r5[r16] = StandardCopyOption.REPLACE_EXISTING;     // Catch: IOException -> L31
        Files.move(r14, r15, r5);     // Catch: IOException -> L31
        j = j + 1;
        r3 = r16;
    L31:
        e = move-exception;
        Slog.e(TAG, "Failed to back up file : " + files2[j].toString());
        throw new RuntimeException(e);
    L36:
        i2 = i2 + 1;
        r3 = r3;
        goto L20
    L38:
        throw new IllegalStateException("Failed to create interval backup directory " + backupIntervalDir.getAbsolutePath());
    L39:
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(this.mUpdateBreadcrumb));     // Catch: Throwable -> L43 IOException -> L45
        writer.write(Long.toString(token));     // Catch: Throwable -> L43 IOException -> L45
        writer.write("\n");     // Catch: Throwable -> L43 IOException -> L45
        writer.write(Integer.toString(thisVersion));     // Catch: Throwable -> L43 IOException -> L45
        writer.write("\n");     // Catch: Throwable -> L43 IOException -> L45
        writer.flush();     // Catch: Throwable -> L43 IOException -> L45
        IoUtils.closeQuietly(writer);
        return;
    L45:
        e = move-exception;
        Slog.e(TAG, "Failed to write new version upgrade breadcrumb");     // Catch: Throwable -> L43
        throw new RuntimeException(e);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        IoUtils.closeQuietly(writer);
        throw th;
    L50:
        e = move-exception;
        Slog.e(TAG, "Failed to back up version file : " + this.mVersionFile.toString());
        throw new RuntimeException(e);
    L54:
        throw new IllegalStateException("Failed to create backup directory " + backupDir.getAbsolutePath());
    }

    private void continueUpgradeLocked(int version, long token) {
        if (version > 3) goto L5;
        Slog.w(TAG, "Reading UsageStats as XML; current database version: " + this.mCurrentVersion);
    L5:
        File backupDir = new File(this.mBackupsDir, Long.toString(token));
        if (version < 5) goto L8;
        readMappingsLocked();
    L8:
        int i = 0;
    L10:
        if (i >= this.mIntervalDirs.length) goto L27;
        File backedUpInterval = new File(backupDir, this.mIntervalDirs[i].getName());
        File[] files = backedUpInterval.listFiles();
        if (files == null) goto L25;
        int j = 0;
    L15:
        if (j >= files.length) goto L25;
        IntervalStats stats = new IntervalStats();     // Catch: Exception -> L19
        readLocked(new AtomicFile(files[j]), stats, version, this.mPackagesTokenData, false);     // Catch: Exception -> L19
        if (this.mCurrentVersion < 5) goto L21;
        stats.obfuscateData(this.mPackagesTokenData);     // Catch: Exception -> L19
    L21:
        writeLocked(new AtomicFile(new File(this.mIntervalDirs[i], Long.toString(stats.beginTime))), stats, this.mCurrentVersion, this.mPackagesTokenData);     // Catch: Exception -> L19
    L24:
        j = j + 1;
    L23:
        Slog.e(TAG, "Failed to upgrade backup file : " + files[j].toString());
    L25:
        i = i + 1;
        goto L10
    L27:
        if (this.mCurrentVersion < 5) goto L42;
        writeMappingsLocked();     // Catch: IOException -> L30
        return;
    L31:
        Slog.e(TAG, "Failed to write the tokens mappings file.");
        return;
    }

    int onPackageRemoved(String packageName, long timeRemoved) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int tokenRemoved = this.mPackagesTokenData.removePackage(packageName, timeRemoved);     // Catch: Throwable -> L7
        writeMappingsLocked();     // Catch: Throwable -> L7 Exception -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return tokenRemoved;
    L10:
        Slog.w(TAG, "Unable to update package mappings on disk after removing token " + tokenRemoved);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    boolean pruneUninstalledPackagesData() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L40:
    L18:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mIntervalDirs.length) goto L36;
        File[] files = this.mIntervalDirs[i].listFiles();     // Catch: Throwable -> L18
        if (files == null) goto L24;
        int j = 0;
    L12:
        if (j >= files.length) goto L24;
        IntervalStats stats = new IntervalStats();     // Catch: Throwable -> L18 Exception -> L20
        AtomicFile atomicFile = new AtomicFile(files[j]);     // Catch: Throwable -> L18 Exception -> L20
        if (readLocked(atomicFile, stats, this.mCurrentVersion, this.mPackagesTokenData, false) == false) goto L17;
        writeLocked(atomicFile, stats, this.mCurrentVersion, this.mPackagesTokenData);     // Catch: Throwable -> L18 Exception -> L20
    L17:
        j = j + 1;
    L21:
        Slog.e(TAG, "Failed to prune data from: " + files[j].toString());     // Catch: Throwable -> L18
        return false;
    L24:
        i = i + 1;
        goto L40
    L36:
        writeMappingsLocked();     // Catch: Throwable -> L18 IOException -> L30
        monitor-exit(r0);     // Catch: Throwable -> L18
        return true;
    L31:
        Slog.e(TAG, "Failed to write package mappings after pruning data.");     // Catch: Throwable -> L18
        return false;
    }

    void prunePackagesDataOnUpgrade(HashMap<String, Long> installedPackages) {
        if (ArrayUtils.isEmpty(installedPackages) == false) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L32:
    L21:
        th = move-exception;
        throw th;
    L9:
        if (i >= this.mIntervalDirs.length) goto L28;
        File[] files = this.mIntervalDirs[i].listFiles();     // Catch: Throwable -> L21
        if (files == null) goto L26;
        int j = 0;
    L15:
        if (j >= files.length) goto L26;
        IntervalStats stats = new IntervalStats();     // Catch: Throwable -> L21 Exception -> L23
        AtomicFile atomicFile = new AtomicFile(files[j]);     // Catch: Throwable -> L21 Exception -> L23
        readLocked(atomicFile, stats, this.mCurrentVersion, this.mPackagesTokenData, false);     // Catch: Throwable -> L21 Exception -> L23
        if (pruneStats(installedPackages, stats) == false) goto L25;
        writeLocked(atomicFile, stats, this.mCurrentVersion, this.mPackagesTokenData);     // Catch: Throwable -> L21 Exception -> L23
    L25:
        j = j + 1;     // Catch: Throwable -> L21
    L24:
        Slog.e(TAG, "Failed to prune data from: " + files[j].toString());     // Catch: Throwable -> L21
    L26:
        i = i + 1;     // Catch: Throwable -> L21
        goto L32
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L21
    }

    private boolean pruneStats(HashMap<String, Long> installedPackages, IntervalStats stats) {
        boolean dataPruned = false;
        int i = stats.packageStats.size() - 1;
    L3:
        if (i < 0) goto L11;
        UsageStats usageStats = stats.packageStats.valueAt(i);
        Long timeInstalled = installedPackages.get(usageStats.mPackageName);
        if (timeInstalled != null) goto L7;
    L8:
        stats.packageStats.removeAt(i);
        dataPruned = true;
    L9:
        i = i - 1;
        goto L3
    L7:
        if (timeInstalled.longValue() <= usageStats.mEndTimeStamp) goto L9;
    L11:
        if (dataPruned == false) goto L13;
        stats.packageStatsObfuscated.clear();
    L13:
        int i2 = stats.events.size() - 1;
    L14:
        if (i2 < 0) goto L22;
        UsageEvents.Event event = stats.events.get(i2);
        Long timeInstalled2 = installedPackages.get(event.mPackage);
        if (timeInstalled2 != null) goto L18;
    L19:
        stats.events.remove(i2);
        dataPruned = true;
    L20:
        i2 = i2 - 1;
        goto L14
    L18:
        if (timeInstalled2.longValue() <= event.mTimeStamp) goto L20;
    L22:
        return dataPruned;
    }

    public void onTimeChanged(long timeDiffMillis) {
        long r2 = timeDiffMillis;
        Object r4 = this.mLock;
        monitor-enter(r4);
        StringBuilder logBuilder = new StringBuilder();     // Catch: Throwable -> L12
        logBuilder.append("Time changed by ");     // Catch: Throwable -> L12
        TimeUtils.formatDuration(r2, logBuilder);     // Catch: Throwable -> L12
        logBuilder.append(".");     // Catch: Throwable -> L12
        int filesDeleted = 0;
        int filesDeleted2 = 0;
        LongSparseArray<AtomicFile>[] r7 = this.mSortedStatFiles;     // Catch: Throwable -> L12
        int r8 = r7.length;     // Catch: Throwable -> L12
        int r9 = 0;
    L5:
        if (r9 >= r8) goto L23;
        LongSparseArray<AtomicFile> files = r7[r9];     // Catch: Throwable -> L12
        int fileCount = files.size();     // Catch: Throwable -> L12
        int i = 0;
        int filesMoved = filesDeleted2;
        int filesDeleted3 = filesDeleted;
    L7:
        if (i >= fileCount) goto L22;
        AtomicFile file = files.valueAt(i);     // Catch: Throwable -> L12
        long newTime = files.keyAt(i) + r2;     // Catch: Throwable -> L12
        if (newTime >= 0) goto L30;
        filesDeleted3 = filesDeleted3 + 1;     // Catch: Throwable -> L12
        file.delete();     // Catch: Throwable -> L12
    L21:
        i = i + 1;     // Catch: Throwable -> L12
        r2 = timeDiffMillis;
        goto L7
    L30:
        file.openRead().close();     // Catch: Throwable -> L12 IOException -> L16
    L17:
        String newName = Long.toString(newTime);     // Catch: Throwable -> L12
        if (file.getBaseFile().getName().endsWith(CHECKED_IN_SUFFIX) == false) goto L20;
        newName = newName + CHECKED_IN_SUFFIX;     // Catch: Throwable -> L12
    L20:
        File newFile = new File(file.getBaseFile().getParentFile(), newName);     // Catch: Throwable -> L12
        filesMoved = filesMoved + 1;     // Catch: Throwable -> L12
        file.getBaseFile().renameTo(newFile);     // Catch: Throwable -> L12
        goto L21
    L22:
        files.clear();     // Catch: Throwable -> L12
        r9 = r9 + 1;     // Catch: Throwable -> L12
        r2 = timeDiffMillis;
        filesDeleted = filesDeleted3;
        filesDeleted2 = filesMoved;
        goto L5
    L23:
        logBuilder.append(" files deleted: ");     // Catch: Throwable -> L12
        logBuilder.append(filesDeleted);     // Catch: Throwable -> L12
        logBuilder.append(" files moved: ");     // Catch: Throwable -> L12
        logBuilder.append(filesDeleted2);     // Catch: Throwable -> L12
        Slog.i(TAG, logBuilder.toString());     // Catch: Throwable -> L12
        indexFilesLocked();     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public IntervalStats getLatestUsageStats(int intervalType) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (intervalType < 0) goto L21;
    L11:
        th = move-exception;
        throw th;
    L6:
        if (intervalType >= this.mIntervalDirs.length) goto L21;
        int fileCount = this.mSortedStatFiles[intervalType].size();     // Catch: Throwable -> L11
        if (fileCount != 0) goto L24;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L24:
        AtomicFile f = this.mSortedStatFiles[intervalType].valueAt(fileCount - 1);     // Catch: Throwable -> L11 Exception -> L16
        IntervalStats stats = new IntervalStats();     // Catch: Throwable -> L11 Exception -> L16
        readLocked(f, stats, false);     // Catch: Throwable -> L11 Exception -> L16
        monitor-exit(r0);     // Catch: Throwable -> L11
        return stats;
    L16:
        e = move-exception;
        Slog.e(TAG, "Failed to read usage stats file", e);     // Catch: Throwable -> L11
        return null;
    L21:
        throw new IllegalArgumentException("Bad interval type " + intervalType);     // Catch: Throwable -> L11
    }

    public IntervalStats[] getIntervalStatsByType(int intervalType) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int fileCount = this.mSortedStatFiles[intervalType].size();     // Catch: Throwable -> L8
        if (fileCount != 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        IntervalStats[] mIntervalStats = new IntervalStats[fileCount];     // Catch: Throwable -> L8
        int i = 0;
    L12:
        if (i >= fileCount) goto L20;
        AtomicFile f = this.mSortedStatFiles[intervalType].valueAt(i);     // Catch: Throwable -> L8 Exception -> L15
        IntervalStats stats = new IntervalStats();     // Catch: Throwable -> L8 Exception -> L15
        readLocked(f, stats, false);     // Catch: Throwable -> L8 Exception -> L15
        mIntervalStats[i] = stats;     // Catch: Throwable -> L8 Exception -> L15
        i = i + 1;
        goto L12
    L15:
        e = move-exception;
        Slog.e(TAG, "Failed to read usage stats file", e);     // Catch: Throwable -> L8
        return null;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return mIntervalStats;
    L8:
        th = move-exception;
        throw th;
    }

    void filterStats(IntervalStats stats) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPackagesTokenData.removedPackagesMap.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ArrayMap<String, Long> removedPackagesMap = this.mPackagesTokenData.removedPackagesMap;     // Catch: Throwable -> L8
        int removedPackagesSize = removedPackagesMap.size();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= removedPackagesSize) goto L18;
        String removedPackage = removedPackagesMap.keyAt(i);     // Catch: Throwable -> L8
        UsageStats usageStats = stats.packageStats.get(removedPackage);     // Catch: Throwable -> L8
        if (usageStats == null) goto L17;
        if (usageStats.mEndTimeStamp >= removedPackagesMap.valueAt(i).longValue()) goto L17;
        stats.packageStats.remove(removedPackage);     // Catch: Throwable -> L8
    L17:
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L18:
        int i2 = stats.events.size() - 1;     // Catch: Throwable -> L8
    L19:
        if (i2 < 0) goto L27;
        UsageEvents.Event event = stats.events.get(i2);     // Catch: Throwable -> L8
        Long timeRemoved = removedPackagesMap.get(event.mPackage);     // Catch: Throwable -> L8
        if (timeRemoved == null) goto L25;
        if (timeRemoved.longValue() <= event.mTimeStamp) goto L25;
        stats.events.remove(i2);     // Catch: Throwable -> L8
    L25:
        i2 = i2 - 1;     // Catch: Throwable -> L8
        goto L19
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public <T> List<T> queryUsageStats(int intervalType, long beginTime, long endTime, StatCombiner<T> combiner, boolean skipEvents) {
        UsageStatsDatabase r1 = this;
        long r3 = beginTime;
        if (intervalType < 0) goto L59;
        if (intervalType >= r1.mIntervalDirs.length) goto L59;
        if (endTime > r3) goto L9;
        return null;
    L9:
        Object r8 = r1.mLock;
        monitor-enter(r8);
        LongSparseArray<AtomicFile> intervalStats = r1.mSortedStatFiles[intervalType];     // Catch: Throwable -> L15
        int endIndex = intervalStats.lastIndexOnOrBefore(endTime);     // Catch: Throwable -> L15
        if (endIndex >= 0) goto L18;
        monitor-exit(r8);     // Catch: Throwable -> L15
        return null;
    L18:
        if (intervalStats.keyAt(endIndex) != endTime) goto L24;
        int endIndex2 = endIndex - 1;     // Catch: Throwable -> L15
        if (endIndex2 >= 0) goto L23;
        monitor-exit(r8);     // Catch: Throwable -> L15
        return null;
    L23:
        int endIndex3 = endIndex2;
    L25:
        int startIndex = intervalStats.lastIndexOnOrBefore(r3);     // Catch: Throwable -> L15
        if (startIndex >= 0) goto L28;
        int startIndex2 = 0;
    L29:
        ArrayList<T> results = new ArrayList();     // Catch: Throwable -> L15
        int i = startIndex2;
    L30:
        if (i > endIndex3) goto L54;
        AtomicFile f = intervalStats.valueAt(i);     // Catch: Throwable -> L15
        IntervalStats stats = new IntervalStats();     // Catch: Throwable -> L15
        r1.readLocked(f, stats, skipEvents);     // Catch: Throwable -> L46 Exception -> L48
    L35:
        if (r3 >= stats.endTime) goto L52;
        if (combiner.combine(stats, false, results) == true) goto L52;
    L42:
        e = e;
    L51:
        Slog.e(TAG, "Failed to read usage stats file", e);     // Catch: Throwable -> L40
    L52:
        i = i + 1;     // Catch: Throwable -> L40
        r1 = this;
        r3 = beginTime;
    L48:
        e = e;
    L46:
        th = th;
    L56:
        monitor-exit(r8);     // Catch: Throwable -> L40
        throw th;
    L54:
        monitor-exit(r8);     // Catch: Throwable -> L40
        return results;
    L28:
        startIndex2 = startIndex;
        goto L29
    L24:
        endIndex3 = endIndex;
    L40:
        th = th;
    L15:
        th = th;
    L59:
        throw new IllegalArgumentException("Bad interval type " + intervalType);
    }

    public int findBestFitBucket(long beginTimeStamp, long endTimeStamp) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int bestBucket = -1;
        long smallestDiff = Long.MAX_VALUE;
        int i = this.mSortedStatFiles.length - 1;     // Catch: Throwable -> L13
    L6:
        if (i < 0) goto L17;
        int index = this.mSortedStatFiles[i].lastIndexOnOrBefore(beginTimeStamp);     // Catch: Throwable -> L13
        int size = this.mSortedStatFiles[i].size();     // Catch: Throwable -> L13
        if (index < 0) goto L15;
        if (index >= size) goto L15;
        long diff = Math.abs(this.mSortedStatFiles[i].keyAt(index) - beginTimeStamp);     // Catch: Throwable -> L13
        if (diff >= smallestDiff) goto L15;
        smallestDiff = diff;
        bestBucket = i;
    L15:
        i = i - 1;     // Catch: Throwable -> L13
        goto L6
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return bestBucket;
    L13:
        th = move-exception;
        throw th;
    }

    public void prune(long currentTimeMillis) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCal.setTimeInMillis(currentTimeMillis);     // Catch: Throwable -> L8
        this.mCal.addYears(-2);     // Catch: Throwable -> L8
        pruneFilesOlderThan(this.mIntervalDirs[3], this.mCal.getTimeInMillis());     // Catch: Throwable -> L8
        this.mCal.setTimeInMillis(currentTimeMillis);     // Catch: Throwable -> L8
        this.mCal.addMonths(-6);     // Catch: Throwable -> L8
        pruneFilesOlderThan(this.mIntervalDirs[2], this.mCal.getTimeInMillis());     // Catch: Throwable -> L8
        this.mCal.setTimeInMillis(currentTimeMillis);     // Catch: Throwable -> L8
        this.mCal.addWeeks(-4);     // Catch: Throwable -> L8
        pruneFilesOlderThan(this.mIntervalDirs[1], this.mCal.getTimeInMillis());     // Catch: Throwable -> L8
        this.mCal.setTimeInMillis(currentTimeMillis);     // Catch: Throwable -> L8
        this.mCal.addDays(-10);     // Catch: Throwable -> L8
        pruneFilesOlderThan(this.mIntervalDirs[0], this.mCal.getTimeInMillis());     // Catch: Throwable -> L8
        this.mCal.setTimeInMillis(currentTimeMillis);     // Catch: Throwable -> L8
        this.mCal.addDays(-SELECTION_LOG_RETENTION_LEN);     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mIntervalDirs.length) goto L10;
        pruneChooserCountsOlderThan(this.mIntervalDirs[i], this.mCal.getTimeInMillis());     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        indexFilesLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static void pruneFilesOlderThan(File dir, long expiryTime) {
        File[] files = dir.listFiles();
        if (files == null) goto L16;
        int r1 = files.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L22;
        File f = files[r2];
        long beginTime = parseBeginTime(f);     // Catch: IOException -> L10
    L13:
        if (beginTime >= expiryTime) goto L15;
        new AtomicFile(f).delete();
    L15:
        r2 = r2 + 1;
    L11:
        beginTime = 0;
        goto L13
    L22:
        return;
    }

    private void pruneChooserCountsOlderThan(File dir, long expiryTime) {
        File[] files = dir.listFiles();
        if (files == null) goto L26;
        int r2 = files.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L38;
        File f = files[r4];
        long beginTime = parseBeginTime(f);     // Catch: IOException -> L10
    L13:
        if (beginTime >= expiryTime) goto L25;
        AtomicFile af = new AtomicFile(f);     // Catch: Exception -> L19
        IntervalStats stats = new IntervalStats();     // Catch: Exception -> L19
        readLocked(af, stats, false);     // Catch: Exception -> L19
        int pkgCount = stats.packageStats.size();     // Catch: Exception -> L19
        int i = 0;
    L15:
        if (i >= pkgCount) goto L22;
        UsageStats pkgStats = stats.packageStats.valueAt(i);     // Catch: Exception -> L19
        if (pkgStats.mChooserCounts == null) goto L21;
        pkgStats.mChooserCounts.clear();     // Catch: Exception -> L19
    L21:
        i = i + 1;     // Catch: Exception -> L19
        goto L15
    L22:
        writeLocked(af, stats);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        Slog.e(TAG, "Failed to delete chooser counts from usage stats file", e);
    L25:
        r4 = r4 + 1;
    L11:
        beginTime = 0;
        goto L13
    L38:
        return;
    }

    private static long parseBeginTime(AtomicFile file) throws IOException {
        return parseBeginTime(file.getBaseFile());
    }

    private static long parseBeginTime(File file) throws IOException {
        String name = file.getName();
        int i = 0;
    L4:
        if (i >= name.length()) goto L17;
        char c = name.charAt(i);
        if (c < '0') goto L11;
        if (c > '9') goto L11;
        i = i + 1;
    L11:
        name = name.substring(0, i);
    L17:
        return Long.parseLong(name);
    L14:
        e = move-exception;
        throw new IOException(e);
    }

    private void writeLocked(AtomicFile file, IntervalStats stats) throws IOException, RuntimeException {
        if (this.mCurrentVersion > 3) goto L6;
        Slog.wtf(TAG, "Attempting to write UsageStats as XML with version " + this.mCurrentVersion);
        return;
    L6:
        writeLocked(file, stats, this.mCurrentVersion, this.mPackagesTokenData);
    }

    private static void writeLocked(AtomicFile file, IntervalStats stats, int version, PackagesTokenData packagesTokenData) throws IOException, RuntimeException {
        FileOutputStream fos = file.startWrite();
        writeLocked(fos, stats, version, packagesTokenData);     // Catch: Throwable -> L6 Exception -> L8
        file.finishWrite(fos);     // Catch: Throwable -> L6 Exception -> L8
        fos = null;
        goto L5
    L6:
        th = move-exception;
        file.failWrite(fos);
        throw th;
    L5:
        file.failWrite(fos);
    }

    private static void writeLocked(OutputStream out, IntervalStats stats, int version, PackagesTokenData packagesTokenData) throws Exception {
        switch(version) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L17;
            case 4: goto L21;
            case 5: goto L6;
            default: goto L5;
        };
    L6:
        stats.obfuscateData(packagesTokenData);
        UsageStatsProtoV2.write(out, stats);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Unable to write interval stats to proto.", e);
        throw e;
    L17:
        Slog.wtf(TAG, "Attempting to write UsageStats as XML with version " + version);
        return;
    L21:
        UsageStatsProto.write(out, stats);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Slog.e(TAG, "Unable to write interval stats to proto.", e);
        throw e;
    L5:
        throw new RuntimeException("Unhandled UsageStatsDatabase version: " + Integer.toString(version) + " on write.");
    }

    private void readLocked(AtomicFile file, IntervalStats statsOut, boolean skipEvents) throws IOException, RuntimeException {
        if (this.mCurrentVersion > 3) goto L5;
        Slog.wtf(TAG, "Reading UsageStats as XML; current database version: " + this.mCurrentVersion);
    L5:
        readLocked(file, statsOut, this.mCurrentVersion, this.mPackagesTokenData, skipEvents);
    }

    private static boolean readLocked(AtomicFile file, IntervalStats statsOut, int version, PackagesTokenData packagesTokenData, boolean skipEvents) throws IOException, RuntimeException {
        FileInputStream in = file.openRead();     // Catch: FileNotFoundException -> L16
        statsOut.beginTime = parseBeginTime(file);     // Catch: Throwable -> L10
        boolean dataOmitted = readLocked(in, statsOut, version, packagesTokenData, skipEvents);     // Catch: Throwable -> L10
        statsOut.lastTimeSaved = file.getLastModifiedTime();     // Catch: Throwable -> L10
        in.close();     // Catch: IOException -> L7
    L9:
        return dataOmitted;
    L10:
        th = move-exception;
        in.close();     // Catch: IOException -> L13
    L15:
        throw th;     // Catch: FileNotFoundException -> L16
    L16:
        e = move-exception;
        Slog.e(TAG, TAG, e);
        throw e;
    }

    private static boolean readLocked(InputStream in, IntervalStats statsOut, int version, PackagesTokenData packagesTokenData, boolean skipEvents) throws RuntimeException {
        switch(version) {
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L15;
            case 4: goto L23;
            case 5: goto L21;
            default: goto L5;
        };
    L15:
        Slog.w(TAG, "Reading UsageStats as XML; database version: " + version);
        UsageStatsXml.read(in, statsOut);     // Catch: Exception -> L18
        return false;
    L18:
        e = move-exception;
        Slog.e(TAG, "Unable to read interval stats from XML", e);
        return false;
    L21:
        UsageStatsProtoV2.read(in, statsOut, skipEvents);     // Catch: Exception -> L8
    L10:
        boolean dataOmitted = statsOut.deobfuscateData(packagesTokenData);
        return dataOmitted;
    L8:
        e = move-exception;
        Slog.e(TAG, "Unable to read interval stats from proto.", e);
        goto L10
    L23:
        UsageStatsProto.read(in, statsOut);     // Catch: Exception -> L13
        return false;
    L13:
        e = move-exception;
        Slog.e(TAG, "Unable to read interval stats from proto.", e);
        return false;
    L5:
        throw new RuntimeException("Unhandled UsageStatsDatabase version: " + Integer.toString(version) + " on read.");
    }

    public void readMappingsLocked() {
        if (this.mPackageMappingsFile.exists() == true) goto L30;
        return;
    L30:
        FileInputStream in = new AtomicFile(this.mPackageMappingsFile).openRead();     // Catch: Exception -> L10
        UsageStatsProtoV2.readObfuscatedData(in, this.mPackagesTokenData);     // Catch: Throwable -> L20
        if (in == null) goto L12;
        in.close();     // Catch: Exception -> L10
    L12:
        SparseArray<ArrayList<String>> tokensToPackagesMap = this.mPackagesTokenData.tokensToPackagesMap;
        int tokensToPackagesMapSize = tokensToPackagesMap.size();
        int i = 0;
    L13:
        if (i >= tokensToPackagesMapSize) goto L19;
        int packageToken = tokensToPackagesMap.keyAt(i);
        ArrayList<String> tokensMap = tokensToPackagesMap.valueAt(i);
        ArrayMap<String, Integer> packageStringsMap = new ArrayMap();
        int tokensMapSize = tokensMap.size();
        packageStringsMap.put(tokensMap.get(0), Integer.valueOf(packageToken));
        int j = 1;
    L15:
        if (j >= tokensMapSize) goto L17;
        packageStringsMap.put(tokensMap.get(j), Integer.valueOf(j));
        j = j + 1;
        goto L15
    L17:
        this.mPackagesTokenData.packagesToTokensMap.put(tokensMap.get(0), packageStringsMap);
        i = i + 1;
        goto L13
    L19:
        return;
    L20:
        th = move-exception;
        if (in != null) goto L33;
    L27:
        throw th;     // Catch: Exception -> L10
    L33:
        in.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to read the obfuscated packages mapping file.", e);
    }

    void writeMappingsLocked() throws IOException {
        AtomicFile file = new AtomicFile(this.mPackageMappingsFile);
        FileOutputStream fos = file.startWrite();
        UsageStatsProtoV2.writeObfuscatedData(fos, this.mPackagesTokenData);     // Catch: Throwable -> L6 Exception -> L8
        file.finishWrite(fos);     // Catch: Throwable -> L6 Exception -> L8
        fos = null;
    L5:
        file.failWrite(fos);
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Unable to write obfuscated data to proto.", e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        file.failWrite(fos);
        throw th;
    }

    void obfuscateCurrentStats(IntervalStats[] currentStats) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentVersion >= 5) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int i = 0;
    L12:
        if (i >= currentStats.length) goto L15;
        IntervalStats stats = currentStats[i];     // Catch: Throwable -> L8
        stats.obfuscateData(this.mPackagesTokenData);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void putUsageStats(int intervalType, IntervalStats stats) throws IOException {
        if (stats != null) goto L4;
        return;
    L4:
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (intervalType < 0) goto L18;
    L12:
        th = move-exception;
        throw th;
    L8:
        if (intervalType >= this.mIntervalDirs.length) goto L18;
        AtomicFile f = this.mSortedStatFiles[intervalType].get(stats.beginTime);     // Catch: Throwable -> L12
        if (f != null) goto L14;
        f = new AtomicFile(new File(this.mIntervalDirs[intervalType], Long.toString(stats.beginTime)));     // Catch: Throwable -> L12
        this.mSortedStatFiles[intervalType].put(stats.beginTime, f);     // Catch: Throwable -> L12
    L14:
        writeLocked(f, stats);     // Catch: Throwable -> L12
        stats.lastTimeSaved = f.getLastModifiedTime();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L18:
        throw new IllegalArgumentException("Bad interval type " + intervalType);     // Catch: Throwable -> L12
    }

    byte[] getBackupPayload(String key) {
        return getBackupPayload(key, 4);
    }

    public byte[] getBackupPayload(String key, int version) {
        if (version < 1) goto L7;
        if (version > 3) goto L7;
        Slog.wtf(TAG, "Attempting to backup UsageStats as XML with version " + version);
        return null;
    L7:
        if (version >= 1) goto L9;
    L45:
        Slog.wtf(TAG, "Attempting to backup UsageStats with an unknown version: " + version);
        return null;
    L9:
        if (version > 4) goto L45;
        Object r3 = this.mLock;
        monitor-enter(r3);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();     // Catch: Throwable -> L20
        if (KEY_USAGE_STATS.equals(key) == false) goto L40;
        prune(System.currentTimeMillis());     // Catch: Throwable -> L20
        DataOutputStream out = new DataOutputStream(baos);     // Catch: Throwable -> L20
        out.writeInt(version);     // Catch: Throwable -> L20 IOException -> L22
        out.writeInt(this.mSortedStatFiles[0].size());     // Catch: Throwable -> L20 IOException -> L22
        int i = 0;
    L18:
        if (i >= this.mSortedStatFiles[0].size()) goto L24;
        writeIntervalStatsToStream(out, this.mSortedStatFiles[0].valueAt(i), version);     // Catch: Throwable -> L20 IOException -> L22
        i = i + 1;     // Catch: Throwable -> L20 IOException -> L22
        goto L18
    L24:
        out.writeInt(this.mSortedStatFiles[1].size());     // Catch: Throwable -> L20 IOException -> L22
        int i2 = 0;
    L26:
        if (i2 >= this.mSortedStatFiles[1].size()) goto L28;
        writeIntervalStatsToStream(out, this.mSortedStatFiles[1].valueAt(i2), version);     // Catch: Throwable -> L20 IOException -> L22
        i2 = i2 + 1;     // Catch: Throwable -> L20 IOException -> L22
        goto L26
    L28:
        out.writeInt(this.mSortedStatFiles[2].size());     // Catch: Throwable -> L20 IOException -> L22
        int i3 = 0;
    L30:
        if (i3 >= this.mSortedStatFiles[2].size()) goto L32;
        writeIntervalStatsToStream(out, this.mSortedStatFiles[2].valueAt(i3), version);     // Catch: Throwable -> L20 IOException -> L22
        i3 = i3 + 1;     // Catch: Throwable -> L20 IOException -> L22
        goto L30
    L32:
        out.writeInt(this.mSortedStatFiles[3].size());     // Catch: Throwable -> L20 IOException -> L22
        int i4 = 0;
    L33:
        if (i4 >= this.mSortedStatFiles[3].size()) goto L40;
        writeIntervalStatsToStream(out, this.mSortedStatFiles[3].valueAt(i4), version);     // Catch: Throwable -> L20 IOException -> L22
        i4 = i4 + 1;
        goto L33
    L22:
        ioe = move-exception;
        Slog.d(TAG, "Failed to write data to output stream", ioe);     // Catch: Throwable -> L20
        baos.reset();     // Catch: Throwable -> L20
    L40:
        byte[] r1 = baos.toByteArray();     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        return r1;
    L20:
        th = move-exception;
        throw th;
    }

    private void calculatePackagesUsedWithinTimeframe(IntervalStats stats, Set<String> packagesList, long timeframeMs) {
        Iterator<UsageStats> r0 = stats.packageStats.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        UsageStats stat = r0.next();
        if (stat.getLastTimePackageUsed() <= timeframeMs) goto L4;
        packagesList.add(stat.mPackageName);
        goto L4
    }

    public Set<String> applyRestoredPayload(String key, byte[] payload) {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L67:
        th = th;
    L72:
        monitor-exit(r2);     // Catch: Throwable -> L46
        throw th;
    L5:
        if (KEY_USAGE_STATS.equals(key) == true) goto L76;
        Set<String> r0 = Collections.EMPTY_SET;     // Catch: Throwable -> L46
        monitor-exit(r2);     // Catch: Throwable -> L46
        return r0;
    L76:
        IntervalStats dailyConfigSource = getLatestUsageStats(0);     // Catch: Throwable -> L67
        IntervalStats weeklyConfigSource = getLatestUsageStats(1);     // Catch: Throwable -> L67
        IntervalStats monthlyConfigSource = getLatestUsageStats(2);     // Catch: Throwable -> L67
        IntervalStats yearlyConfigSource = getLatestUsageStats(3);     // Catch: Throwable -> L67
        Set<String> packagesRestored = new ArraySet();     // Catch: Throwable -> L67
    L80:
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(payload));     // Catch: Throwable -> L48 IOException -> L50
        int backupDataVersion = in.readInt();     // Catch: Throwable -> L48 IOException -> L50
        if (backupDataVersion < 1) goto L53;
        if (backupDataVersion > 4) goto L53;
        int i = 0;
    L16:
        if (i >= this.mIntervalDirs.length) goto L24;
        deleteDirectoryContents(this.mIntervalDirs[i]);     // Catch: Throwable -> L19 IOException -> L21
        i = i + 1;
        goto L16
    L21:
        ioe = e;
    L61:
        Slog.d(TAG, "Failed to read data from input stream", ioe);     // Catch: Throwable -> L29
        indexFilesLocked();     // Catch: Throwable -> L46
    L63:
        monitor-exit(r2);     // Catch: Throwable -> L46
        return packagesRestored;
    L19:
        th = th;
    L65:
        indexFilesLocked();     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L24:
    L78:
        long timeframe = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(90);     // Catch: Throwable -> L29 IOException -> L31
        int fileCount = in.readInt();     // Catch: Throwable -> L29 IOException -> L31
        int i2 = 0;
    L27:
        if (i2 >= fileCount) goto L33;
        IntervalStats stats = deserializeIntervalStats(getIntervalStatsBytes(in), backupDataVersion);     // Catch: Throwable -> L29 IOException -> L31
        calculatePackagesUsedWithinTimeframe(stats, packagesRestored, timeframe);     // Catch: Throwable -> L29 IOException -> L31
        packagesRestored.addAll(stats.packageStats.keySet());     // Catch: Throwable -> L29 IOException -> L31
        putUsageStats(0, mergeStats(stats, dailyConfigSource));     // Catch: Throwable -> L29 IOException -> L31
        i2 = i2 + 1;     // Catch: Throwable -> L29 IOException -> L31
        goto L27
    L33:
        int fileCount2 = in.readInt();     // Catch: Throwable -> L29 IOException -> L31
        int i3 = 0;
    L34:
        if (i3 >= fileCount2) goto L36;
        IntervalStats stats2 = deserializeIntervalStats(getIntervalStatsBytes(in), backupDataVersion);     // Catch: Throwable -> L29 IOException -> L31
        calculatePackagesUsedWithinTimeframe(stats2, packagesRestored, timeframe);     // Catch: Throwable -> L29 IOException -> L31
        putUsageStats(1, mergeStats(stats2, weeklyConfigSource));     // Catch: Throwable -> L29 IOException -> L31
        i3 = i3 + 1;     // Catch: Throwable -> L29 IOException -> L31
        goto L34
    L36:
        int fileCount3 = in.readInt();     // Catch: Throwable -> L29 IOException -> L31
        int i4 = 0;
    L37:
        if (i4 >= fileCount3) goto L39;
        IntervalStats stats3 = deserializeIntervalStats(getIntervalStatsBytes(in), backupDataVersion);     // Catch: Throwable -> L29 IOException -> L31
        calculatePackagesUsedWithinTimeframe(stats3, packagesRestored, timeframe);     // Catch: Throwable -> L29 IOException -> L31
        putUsageStats(2, mergeStats(stats3, monthlyConfigSource));     // Catch: Throwable -> L29 IOException -> L31
        i4 = i4 + 1;     // Catch: Throwable -> L29 IOException -> L31
        goto L37
    L39:
        int fileCount4 = in.readInt();     // Catch: Throwable -> L29 IOException -> L31
        int i5 = 0;
    L40:
        if (i5 >= fileCount4) goto L44;
        IntervalStats stats4 = deserializeIntervalStats(getIntervalStatsBytes(in), backupDataVersion);     // Catch: Throwable -> L29 IOException -> L31
        calculatePackagesUsedWithinTimeframe(stats4, packagesRestored, timeframe);     // Catch: Throwable -> L29 IOException -> L31
        putUsageStats(3, mergeStats(stats4, yearlyConfigSource));     // Catch: Throwable -> L29 IOException -> L31
        i5 = i5 + 1;
        goto L40
    L44:
        indexFilesLocked();     // Catch: Throwable -> L46
    L31:
        ioe = e;
    L53:
        indexFilesLocked();     // Catch: Throwable -> L46
        monitor-exit(r2);     // Catch: Throwable -> L46
        return packagesRestored;
    L50:
        ioe = e;
    L48:
        th = th;
    L58:
        ioe = e;
    L56:
        th = th;
    L29:
        th = th;
    L46:
        th = th;
        goto L72
    }

    private IntervalStats mergeStats(IntervalStats beingRestored, IntervalStats onDevice) {
        if (onDevice != null) goto L4;
        return beingRestored;
    L4:
        if (beingRestored != null) goto L7;
        return null;
    L7:
        beingRestored.activeConfiguration = onDevice.activeConfiguration;
        beingRestored.configurations.putAll(onDevice.configurations);
        beingRestored.events.clear();
        beingRestored.events.merge(onDevice.events);
        return beingRestored;
    }

    private void writeIntervalStatsToStream(DataOutputStream out, AtomicFile statsFile, int version) throws IOException {
        IntervalStats stats = new IntervalStats();
        readLocked(statsFile, stats, false);     // Catch: IOException -> L6
        sanitizeIntervalStatsForBackup(stats);
        byte[] data = serializeIntervalStats(stats, version);
        out.writeInt(data.length);
        out.write(data);
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to read usage stats file", e);
        out.writeInt(0);
    }

    private static byte[] getIntervalStatsBytes(DataInputStream in) throws IOException {
        int length = in.readInt();
        byte[] buffer = new byte[length];
        in.read(buffer, 0, length);
        return buffer;
    }

    private static void sanitizeIntervalStatsForBackup(IntervalStats stats) {
        if (stats != null) goto L4;
        return;
    L4:
        stats.activeConfiguration = null;
        stats.configurations.clear();
        stats.events.clear();
    }

    private byte[] serializeIntervalStats(IntervalStats stats, int version) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        out.writeLong(stats.beginTime);     // Catch: Exception -> L5
        writeLocked(out, stats, version, this.mPackagesTokenData);     // Catch: Exception -> L5
    L8:
        return baos.toByteArray();
    L5:
        ioe = move-exception;
        Slog.d(TAG, "Serializing IntervalStats Failed", ioe);
        baos.reset();
        goto L8
    }

    private IntervalStats deserializeIntervalStats(byte[] data, int version) {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream in = new DataInputStream(bais);
        IntervalStats stats = new IntervalStats();
        stats.beginTime = in.readLong();     // Catch: Exception -> L5
        readLocked(in, stats, version, this.mPackagesTokenData, false);     // Catch: Exception -> L5
        return stats;
    L5:
        e = move-exception;
        Slog.d(TAG, "DeSerializing IntervalStats Failed", e);
        return null;
    }

    private static void deleteDirectoryContents(File directory) {
        File[] files = directory.listFiles();
        int r1 = files.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        File file = files[r2];
        deleteDirectory(file);
        r2 = r2 + 1;
        goto L3
    }

    private static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files == null) goto L12;
        int r1 = files.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        File file = files[r2];
        if (file.isDirectory() == true) goto L10;
        file.delete();
    L11:
        r2 = r2 + 1;
        goto L6
    L10:
        deleteDirectory(file);
    L12:
        directory.delete();
    }

    public void dump(IndentingPrintWriter pw, boolean compact) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println();     // Catch: Throwable -> L12
        pw.println("UsageStatsDatabase:");     // Catch: Throwable -> L12
        pw.increaseIndent();     // Catch: Throwable -> L12
        dumpMappings(pw);     // Catch: Throwable -> L12
        pw.decreaseIndent();     // Catch: Throwable -> L12
        pw.println("Database Summary:");     // Catch: Throwable -> L12
        pw.increaseIndent();     // Catch: Throwable -> L12
        int i = 0;
    L6:
        if (i >= this.mSortedStatFiles.length) goto L17;
        LongSparseArray<AtomicFile> files = this.mSortedStatFiles[i];     // Catch: Throwable -> L12
        int size = files.size();     // Catch: Throwable -> L12
        pw.print(UserUsageStatsService.intervalToString(i));     // Catch: Throwable -> L12
        pw.print(" stats files: ");     // Catch: Throwable -> L12
        pw.print(size);     // Catch: Throwable -> L12
        pw.println(", sorted list of files:");     // Catch: Throwable -> L12
        pw.increaseIndent();     // Catch: Throwable -> L12
        int f = 0;
    L8:
        if (f >= size) goto L16;
        long fileName = files.keyAt(f);     // Catch: Throwable -> L12
        if (compact == false) goto L14;
        pw.print(UserUsageStatsService.formatDateTime(fileName, false));     // Catch: Throwable -> L12
    L15:
        pw.println();     // Catch: Throwable -> L12
        f = f + 1;     // Catch: Throwable -> L12
        goto L8
    L14:
        pw.printPair(Long.toString(fileName), UserUsageStatsService.formatDateTime(fileName, true));     // Catch: Throwable -> L12
        goto L15
    L16:
        pw.decreaseIndent();     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
        goto L6
    L17:
        pw.decreaseIndent();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void dumpMappings(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("Obfuscated Packages Mappings:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        pw.println("Counter: " + this.mPackagesTokenData.counter);     // Catch: Throwable -> L7
        pw.println("Tokens Map Size: " + this.mPackagesTokenData.tokensToPackagesMap.size());     // Catch: Throwable -> L7
        if (this.mPackagesTokenData.removedPackageTokens.isEmpty() == true) goto L9;
        pw.println("Removed Package Tokens: " + Arrays.toString(this.mPackagesTokenData.removedPackageTokens.toArray()));     // Catch: Throwable -> L7
    L9:
        int i = 0;
    L11:
        if (i >= this.mPackagesTokenData.tokensToPackagesMap.size()) goto L13;
        int packageToken = this.mPackagesTokenData.tokensToPackagesMap.keyAt(i);     // Catch: Throwable -> L7
        String packageStrings = String.join(", ", this.mPackagesTokenData.tokensToPackagesMap.valueAt(i));     // Catch: Throwable -> L7
        pw.println("Token " + packageToken + ": [" + packageStrings + "]");     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L11
    L13:
        pw.println();     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void deleteDataFor(String pkg) {
        prunePackagesDataOnUpgrade(new HashMap(Collections.singletonMap(pkg, Long.valueOf(SystemClock.elapsedRealtime()))));
    }

    IntervalStats readIntervalStatsForFile(int interval, long fileName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IntervalStats stats = new IntervalStats();     // Catch: Throwable -> L9
        readLocked(this.mSortedStatFiles[interval].get(fileName, null), stats, false);     // Catch: Throwable -> L9 Exception -> L11
        monitor-exit(r0);     // Catch: Throwable -> L9
        return stats;
    L13:
        return null;
    L9:
        th = move-exception;
        throw th;
    }
}
