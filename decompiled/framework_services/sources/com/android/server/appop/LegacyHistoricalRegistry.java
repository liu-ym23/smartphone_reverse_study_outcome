package com.android.server.appop;

import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteCallback;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.ArraySet;
import android.util.LongSparseArray;
import android.util.Slog;
import android.util.TimeUtils;
import android.util.Xml;
import com.android.internal.os.AtomicDirectory;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.XmlUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.FgThread;
import com.android.server.IoThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
final class LegacyHistoricalRegistry implements HistoricalRegistryInterface {
    private static final boolean DEBUG = false;
    private static final long DEFAULT_COMPRESSION_STEP = 10;
    private static final int DEFAULT_MODE = 1;
    private static final long DEFAULT_SNAPSHOT_INTERVAL_MILLIS = 0;
    private static final String HISTORY_FILE_SUFFIX = ".xml";
    private static final boolean KEEP_WTF_LOG = false;
    private static final String LOG_TAG = null;
    private static final int MSG_WRITE_PENDING_HISTORY = 1;
    private static final String PARAMETER_ASSIGNMENT = "=";
    private static final String PARAMETER_DELIMITER = ",";
    private long mBaseSnapshotInterval;
    private final Context mContext;
    private AppOpsManager.HistoricalOps mCurrentHistoricalOps;
    private volatile DiscreteOpsRegistry mDiscreteRegistry;
    private final Object mInMemoryLock;
    private long mIntervalCompressionMultiplier;
    private int mMode;
    private long mNextPersistDueTimeMillis;
    private final Object mOnDiskLock;
    private long mPendingHistoryOffsetMillis;
    private LinkedList<AppOpsManager.HistoricalOps> mPendingWrites;
    private Persistence mPersistence;

    private static class HistoricalFilesInvariant {
        private final List<File> mBeginFiles;

        private HistoricalFilesInvariant() {
            this.mBeginFiles = new ArrayList();
        }

        public void startTracking(File folder) {
            File[] files = folder.listFiles();
            if (files == null) goto L6;
            Collections.addAll(this.mBeginFiles, files);
            return;
        }

        public void stopTracking(File folder) {
            List<File> endFiles = new ArrayList();
            File[] files = folder.listFiles();
            if (files == null) goto L5;
            Collections.addAll(endFiles, files);
        L5:
            long beginOldestFileOffsetMillis = getOldestFileOffsetMillis(this.mBeginFiles);
            long endOldestFileOffsetMillis = getOldestFileOffsetMillis(endFiles);
            if (endOldestFileOffsetMillis < beginOldestFileOffsetMillis) goto L8;
            return;
        L8:
            String message = "History loss detected!\nold files: " + this.mBeginFiles;
            LegacyHistoricalRegistry.m1823$$Nest$smwtf(message, null, folder);
            throw new IllegalStateException(message);
        }

        private static long getOldestFileOffsetMillis(List<File> files) {
            if (files.isEmpty() == false) goto L6;
            return 0;
        L6:
            String longestName = files.get(0).getName();
            int fileCount = files.size();
            int i = 1;
        L7:
            if (i >= fileCount) goto L13;
            File file = files.get(i);
            if (file.getName().length() <= longestName.length()) goto L11;
            longestName = file.getName();
        L11:
            i = i + 1;
            goto L7
        L13:
            return Long.parseLong(longestName.replace(LegacyHistoricalRegistry.HISTORY_FILE_SUFFIX, ""));
        }
    }

    private static final class Persistence {
        private static final String ATTR_ACCESS_COUNT = "ac";
        private static final String ATTR_ACCESS_DURATION = "du";
        private static final String ATTR_BEGIN_TIME = "beg";
        private static final String ATTR_END_TIME = "end";
        private static final String ATTR_NAME = "na";
        private static final String ATTR_OVERFLOW = "ov";
        private static final String ATTR_REJECT_COUNT = "rc";
        private static final String ATTR_VERSION = "ver";
        private static final int CURRENT_VERSION = 2;
        private static final boolean DEBUG = false;
        private static final String LOG_TAG = null;
        private static final String TAG_ATTRIBUTION = "ftr";
        private static final String TAG_HISTORY = "history";
        private static final String TAG_OP = "op";
        private static final String TAG_OPS = "ops";
        private static final String TAG_PACKAGE = "pkg";
        private static final String TAG_STATE = "st";
        private static final String TAG_UID = "uid";
        private static final AtomicDirectory sHistoricalAppOpsDir = null;
        private final long mBaseSnapshotInterval;
        private final long mIntervalCompressionMultiplier;

        /* JADX INFO: renamed from: -$$Nest$mcollectHistoricalOpsDLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1824$$Nest$mcollectHistoricalOpsDLocked(Persistence r0, AppOpsManager.HistoricalOps r1, int r2, String r3, String r4, String[] r5, int r6, long r7, long r9, int r11) {
            r0.collectHistoricalOpsDLocked(r1, r2, r3, r4, r5, r6, r7, r9, r11);
        }

        /* JADX INFO: renamed from: -$$Nest$smspliceFromBeginning, reason: not valid java name */
        static /* bridge */ /* synthetic */ AppOpsManager.HistoricalOps m1825$$Nest$smspliceFromBeginning(AppOpsManager.HistoricalOps r0, double r1) {
            return spliceFromBeginning(r0, r1);
        }

        static {
            LOG_TAG = Persistence.class.getSimpleName();
            sHistoricalAppOpsDir = new AtomicDirectory(new File(new File(Environment.getDataSystemDirectory(), "appops"), TAG_HISTORY));
        }

        Persistence(long baseSnapshotInterval, long intervalCompressionMultiplier) {
            this.mBaseSnapshotInterval = baseSnapshotInterval;
            this.mIntervalCompressionMultiplier = intervalCompressionMultiplier;
        }

        private File generateFile(File baseDir, int depth) {
            long globalBeginMillis = computeGlobalIntervalBeginMillis(depth);
            return new File(baseDir, Long.toString(globalBeginMillis) + LegacyHistoricalRegistry.HISTORY_FILE_SUFFIX);
        }

        void clearHistoryDLocked(int uid, String packageName) {
            List<AppOpsManager.HistoricalOps> historicalOps = readHistoryDLocked();
            if (historicalOps != null) goto L5;
            return;
        L5:
            int index = 0;
        L7:
            if (index >= historicalOps.size()) goto L9;
            historicalOps.get(index).clearHistory(uid, packageName);
            index = index + 1;
            goto L7
        L9:
            clearHistoryDLocked();
            persistHistoricalOpsDLocked(historicalOps);
        }

        static void clearHistoryDLocked() {
            sHistoricalAppOpsDir.delete();
        }

        void persistHistoricalOpsDLocked(List<AppOpsManager.HistoricalOps> ops) {
            File newBaseDir = sHistoricalAppOpsDir.startWrite();     // Catch: Throwable -> L8
            File oldBaseDir = sHistoricalAppOpsDir.getBackupDirectory();     // Catch: Throwable -> L8
            Set<String> oldFileNames = getHistoricalFileNames(oldBaseDir);     // Catch: Throwable -> L8
            handlePersistHistoricalOpsRecursiveDLocked(newBaseDir, oldBaseDir, ops, oldFileNames, 0);     // Catch: Throwable -> L6
            sHistoricalAppOpsDir.finishWrite();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Throwable t = th;
        L10:
            LegacyHistoricalRegistry.m1823$$Nest$smwtf("Failed to write historical app ops, restoring backup", t, null);
            sHistoricalAppOpsDir.failWrite();
            return;
        L8:
            th = move-exception;
            t = th;
            goto L10
        }

        List<AppOpsManager.HistoricalOps> readHistoryRawDLocked() {
            return collectHistoricalOpsBaseDLocked(-1, null, null, null, 0, 0, Long.MAX_VALUE, 31);
        }

        List<AppOpsManager.HistoricalOps> readHistoryDLocked() {
            List<AppOpsManager.HistoricalOps> result = readHistoryRawDLocked();
            if (result == null) goto L7;
            int opCount = result.size();
            int i = 0;
        L5:
            if (i >= opCount) goto L7;
            result.get(i).offsetBeginAndEndTime(this.mBaseSnapshotInterval);
            i = i + 1;
        L7:
            return result;
        }

        long getLastPersistTimeMillisDLocked() {
            File baseDir = sHistoricalAppOpsDir.startRead();     // Catch: Throwable -> L18
            File[] files = baseDir.listFiles();     // Catch: Throwable -> L18
            if (files != null) goto L6;
        L24:
            sHistoricalAppOpsDir.finishRead();     // Catch: Throwable -> L18
        L27:
            return 0;
        L6:
            if (files.length <= 0) goto L24;
            File shortestFile = null;
            int r5 = files.length;     // Catch: Throwable -> L18
            int r6 = 0;
        L8:
            if (r6 >= r5) goto L20;
            File candidate = files[r6];     // Catch: Throwable -> L18
            String candidateName = candidate.getName();     // Catch: Throwable -> L18
            if (candidateName.endsWith(LegacyHistoricalRegistry.HISTORY_FILE_SUFFIX) == false) goto L17;
            if (shortestFile != null) goto L15;
            shortestFile = candidate;
            goto L17
        L15:
            if (candidateName.length() >= shortestFile.getName().length()) goto L17;
            shortestFile = candidate;
        L17:
            r6 = r6 + 1;     // Catch: Throwable -> L18
            goto L8
        L20:
            if (shortestFile != null) goto L23;
            return 0;
        L23:
            return shortestFile.lastModified();
        L18:
            e = move-exception;
            LegacyHistoricalRegistry.m1823$$Nest$smwtf("Error reading historical app ops. Deleting history.", e, null);
            sHistoricalAppOpsDir.delete();
            goto L27
        }

        private void collectHistoricalOpsDLocked(AppOpsManager.HistoricalOps currentOps, int filterUid, String filterPackageName, String filterAttributionTag, String[] filterOpNames, int filter, long filterBeingMillis, long filterEndMillis, int filterFlags) {
            List<AppOpsManager.HistoricalOps> readOps = collectHistoricalOpsBaseDLocked(filterUid, filterPackageName, filterAttributionTag, filterOpNames, filter, filterBeingMillis, filterEndMillis, filterFlags);
            if (readOps == null) goto L7;
            int readCount = readOps.size();
            int i = 0;
        L5:
            if (i >= readCount) goto L9;
            AppOpsManager.HistoricalOps readOp = readOps.get(i);
            currentOps.merge(readOp);
            i = i + 1;
            goto L5
        L9:
            return;
        }

        private LinkedList<AppOpsManager.HistoricalOps> collectHistoricalOpsBaseDLocked(int filterUid, String filterPackageName, String filterAttributionTag, String[] filterOpNames, int filter, long filterBeginTimeMillis, long filterEndTimeMillis, int filterFlags) {
            File baseDir = null;
            File baseDir2 = sHistoricalAppOpsDir.startRead();     // Catch: Throwable -> L9
            Set<String> historyFiles = getHistoricalFileNames(baseDir2);     // Catch: Throwable -> L7
            long[] globalContentOffsetMillis = {0};     // Catch: Throwable -> L7
            LinkedList<AppOpsManager.HistoricalOps> ops = collectHistoricalOpsRecursiveDLocked(baseDir2, filterUid, filterPackageName, filterAttributionTag, filterOpNames, filter, filterBeginTimeMillis, filterEndTimeMillis, filterFlags, globalContentOffsetMillis, null, 0, historyFiles);     // Catch: Throwable -> L7
            sHistoricalAppOpsDir.finishRead();     // Catch: Throwable -> L7
            return ops;
        L7:
            t = th;
            baseDir = baseDir2;
        L10:
            LegacyHistoricalRegistry.m1823$$Nest$smwtf("Error reading historical app ops. Deleting history.", t, baseDir);
            sHistoricalAppOpsDir.delete();
            return null;
        L9:
            t = th;
            goto L10
        }

        private LinkedList<AppOpsManager.HistoricalOps> collectHistoricalOpsRecursiveDLocked(File baseDir, int filterUid, String filterPackageName, String filterAttributionTag, String[] filterOpNames, int filter, long filterBeginTimeMillis, long filterEndTimeMillis, int filterFlags, long[] globalContentOffsetMillis, LinkedList<AppOpsManager.HistoricalOps> outOps, int depth, Set<String> historyFiles) throws IOException, XmlPullParserException {
            long previousIntervalEndMillis = ((long) Math.pow(this.mIntervalCompressionMultiplier, depth)) * this.mBaseSnapshotInterval;
            long currentIntervalEndMillis = ((long) Math.pow(this.mIntervalCompressionMultiplier, depth + 1)) * this.mBaseSnapshotInterval;
            long filterBeginTimeMillis2 = Math.max(filterBeginTimeMillis - previousIntervalEndMillis, 0);
            long filterEndTimeMillis2 = filterEndTimeMillis - previousIntervalEndMillis;
            List<AppOpsManager.HistoricalOps> readOps = readHistoricalOpsLocked(baseDir, previousIntervalEndMillis, currentIntervalEndMillis, filterUid, filterPackageName, filterAttributionTag, filterOpNames, filter, filterBeginTimeMillis2, filterEndTimeMillis2, filterFlags, globalContentOffsetMillis, depth, historyFiles);
            if (readOps != null) goto L5;
        L7:
            LinkedList<AppOpsManager.HistoricalOps> outOps2 = collectHistoricalOpsRecursiveDLocked(baseDir, filterUid, filterPackageName, filterAttributionTag, filterOpNames, filter, filterBeginTimeMillis2, filterEndTimeMillis2, filterFlags, globalContentOffsetMillis, outOps, depth + 1, historyFiles);
            if (outOps2 == null) goto L14;
            int opCount = outOps2.size();
            int i = 0;
        L10:
            if (i >= opCount) goto L14;
            AppOpsManager.HistoricalOps collectedOp = outOps2.get(i);
            collectedOp.offsetBeginAndEndTime(currentIntervalEndMillis);
            i = i + 1;
        L14:
            if (readOps == null) goto L20;
            if (outOps2 != null) goto L17;
            outOps2 = new LinkedList();
        L17:
            int opCount2 = readOps.size();
            int i2 = opCount2 - 1;
        L18:
            if (i2 < 0) goto L20;
            outOps2.offerFirst(readOps.get(i2));
            i2 = i2 - 1;
        L20:
            return outOps2;
        L5:
            if (readOps.isEmpty() == false) goto L7;
            return outOps;
        }

        private void handlePersistHistoricalOpsRecursiveDLocked(File newBaseDir, File oldBaseDir, List<AppOpsManager.HistoricalOps> passedOps, Set<String> oldFileNames, int depth) throws IOException, XmlPullParserException {
            long previousIntervalEndMillis = ((long) Math.pow(this.mIntervalCompressionMultiplier, depth)) * this.mBaseSnapshotInterval;
            long currentIntervalEndMillis = ((long) Math.pow(this.mIntervalCompressionMultiplier, depth + 1)) * this.mBaseSnapshotInterval;
            if (passedOps == null) goto L50;
            if (passedOps.isEmpty() == true) goto L50;
            int passedOpCount = passedOps.size();
            int i = 0;
        L8:
            if (i >= passedOpCount) goto L10;
            AppOpsManager.HistoricalOps passedOp = passedOps.get(i);
            passedOp.offsetBeginAndEndTime(-previousIntervalEndMillis);
            i = i + 1;
            goto L8
        L10:
            List<AppOpsManager.HistoricalOps> existingOps = readHistoricalOpsLocked(oldBaseDir, previousIntervalEndMillis, currentIntervalEndMillis, -1, null, null, null, 0, Long.MIN_VALUE, Long.MAX_VALUE, 31, null, depth, null);
            long previousIntervalEndMillis2 = previousIntervalEndMillis;
            if (existingOps == null) goto L17;
            int existingOpCount = existingOps.size();
            if (existingOpCount <= 0) goto L17;
            long elapsedTimeMillis = passedOps.get(passedOps.size() - 1).getEndTimeMillis();
            int i2 = 0;
        L15:
            if (i2 >= existingOpCount) goto L17;
            AppOpsManager.HistoricalOps existingOp = existingOps.get(i2);
            existingOp.offsetBeginAndEndTime(elapsedTimeMillis);
            i2 = i2 + 1;
        L17:
            List<AppOpsManager.HistoricalOps> allOps = new LinkedList(passedOps);
            if (existingOps == null) goto L20;
            allOps.addAll(existingOps);
        L20:
            List<AppOpsManager.HistoricalOps> persistedOps = null;
            List<AppOpsManager.HistoricalOps> overflowedOps = null;
            long intervalOverflowMillis = 0;
            int opCount = allOps.size();
            int i3 = 0;
        L21:
            if (i3 >= opCount) goto L43;
            int i4 = i3;
            AppOpsManager.HistoricalOps op = allOps.get(i3);
            if (op.getEndTimeMillis() > currentIntervalEndMillis) goto L26;
            AppOpsManager.HistoricalOps overflowedOp = null;
            AppOpsManager.HistoricalOps persistedOp = op;
        L32:
            if (persistedOp == null) goto L36;
            if (persistedOps != null) goto L35;
            persistedOps = new ArrayList();
        L35:
            persistedOps.add(persistedOp);
        L36:
            if (overflowedOp == null) goto L41;
            if (overflowedOps != 0) goto L39;
            List<AppOpsManager.HistoricalOps> overflowedOps2 = new ArrayList();
        L40:
            overflowedOps2.add(overflowedOp);
            overflowedOps = overflowedOps2;
        L42:
            i3 = i4 + 1;
            existingOps = existingOps;
            previousIntervalEndMillis2 = previousIntervalEndMillis2;
            goto L21
        L39:
            overflowedOps2 = overflowedOps;
            goto L40
        L41:
            overflowedOps = overflowedOps;
            goto L42
        L26:
            if (op.getBeginTimeMillis() >= currentIntervalEndMillis) goto L31;
            intervalOverflowMillis = op.getEndTimeMillis() - currentIntervalEndMillis;
            if (intervalOverflowMillis <= previousIntervalEndMillis2) goto L30;
            double splitScale = intervalOverflowMillis / op.getDurationMillis();
            AppOpsManager.HistoricalOps overflowedOp2 = spliceFromEnd(op, splitScale);
            intervalOverflowMillis = op.getEndTimeMillis() - currentIntervalEndMillis;
            overflowedOp = overflowedOp2;
            persistedOp = op;
            goto L32
        L30:
            overflowedOp = null;
            persistedOp = op;
            goto L32
        L31:
            overflowedOp = op;
            persistedOp = null;
            goto L32
        L43:
            List<AppOpsManager.HistoricalOps> overflowedOps3 = overflowedOps;
            File newFile = generateFile(newBaseDir, depth);
            oldFileNames.remove(newFile.getName());
            if (persistedOps == null) goto L46;
            normalizeSnapshotForSlotDuration(persistedOps, previousIntervalEndMillis2);
            writeHistoricalOpsDLocked(persistedOps, intervalOverflowMillis, newFile);
        L46:
            handlePersistHistoricalOpsRecursiveDLocked(newBaseDir, oldBaseDir, overflowedOps3, oldFileNames, depth + 1);
            return;
        L50:
            if (oldFileNames.isEmpty() == true) goto L61;
            File oldFile = generateFile(oldBaseDir, r2);
            if (oldFileNames.remove(oldFile.getName()) == false) goto L54;
            Files.createLink(generateFile(newBaseDir, depth).toPath(), oldFile.toPath());
        L54:
            handlePersistHistoricalOpsRecursiveDLocked(newBaseDir, oldBaseDir, passedOps, oldFileNames, r2 + 1);
            return;
        }

        private List<AppOpsManager.HistoricalOps> readHistoricalOpsLocked(File baseDir, long intervalBeginMillis, long intervalEndMillis, int filterUid, String filterPackageName, String filterAttributionTag, String[] filterOpNames, int filter, long filterBeginTimeMillis, long filterEndTimeMillis, int filterFlags, long[] cumulativeOverflowMillis, int depth, Set<String> historyFiles) throws IOException, XmlPullParserException {
            File file = generateFile(baseDir, depth);
            if (historyFiles == null) goto L6;
            historyFiles.remove(file.getName());
        L6:
            if (filterBeginTimeMillis >= filterEndTimeMillis) goto L30;
            if (filterEndTimeMillis < intervalBeginMillis) goto L30;
            long r2 = intervalEndMillis + ((intervalEndMillis - intervalBeginMillis) / this.mIntervalCompressionMultiplier);
            if (cumulativeOverflowMillis == null) goto L13;
            long r4 = cumulativeOverflowMillis[0];
        L15:
            if (filterBeginTimeMillis < (r2 + r4)) goto L17;
        L21:
            if (historyFiles == null) goto L28;
            if (historyFiles.isEmpty() == true) goto L28;
            return null;
        L28:
            return Collections.emptyList();
        L17:
            if (file.exists() == false) goto L21;
            return readHistoricalOpsLocked(file, filterUid, filterPackageName, filterAttributionTag, filterOpNames, filter, filterBeginTimeMillis, filterEndTimeMillis, filterFlags, cumulativeOverflowMillis);
        L13:
            r4 = 0;
        L30:
            return Collections.emptyList();
        }

        private List<AppOpsManager.HistoricalOps> readHistoricalOpsLocked(File file, int filterUid, String filterPackageName, String filterAttributionTag, String[] filterOpNames, int filter, long filterBeginTimeMillis, long filterEndTimeMillis, int filterFlags, long[] cumulativeOverflowMillis) throws IOException, XmlPullParserException {
            List<AppOpsManager.HistoricalOps> allOps = null;
            FileInputStream stream = new FileInputStream(file);     // Catch: FileNotFoundException -> L30
            TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L18
            XmlUtils.beginDocument(parser, TAG_HISTORY);     // Catch: Throwable -> L18
            int version = parser.getAttributeInt(null, ATTR_VERSION);     // Catch: Throwable -> L18
            if (version < 2) goto L33;
            long overflowMillis = parser.getAttributeLong(null, ATTR_OVERFLOW, 0);     // Catch: Throwable -> L18
            int depth = parser.getDepth();     // Catch: Throwable -> L18
        L9:
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L26;
            if (TAG_OPS.equals(parser.getName()) == false) goto L23;
            int depth2 = depth;
            AppOpsManager.HistoricalOps ops = readeHistoricalOpsDLocked(parser, filterUid, filterPackageName, filterAttributionTag, filterOpNames, filter, filterBeginTimeMillis, filterEndTimeMillis, filterFlags, cumulativeOverflowMillis);     // Catch: Throwable -> L18
            if (ops == null) goto L24;
            if (ops.isEmpty() == true) goto L17;
            if (allOps != null) goto L22;
            allOps = new ArrayList();     // Catch: Throwable -> L18
        L22:
            allOps.add(ops);     // Catch: Throwable -> L18
            depth = depth2;
            goto L9
        L17:
            XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L18
        L24:
            depth = depth2;
            goto L9
        L23:
            depth2 = depth;
            goto L24
        L26:
            if (cumulativeOverflowMillis == null) goto L28;
            cumulativeOverflowMillis[0] = cumulativeOverflowMillis[0] + overflowMillis;     // Catch: Throwable -> L18
        L28:
            stream.close();     // Catch: FileNotFoundException -> L30
            return allOps;
        L33:
            throw new IllegalStateException("Dropping unsupported history version 1 for file:" + file);     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            stream.close();     // Catch: Throwable -> L36
            goto L41
        L57:
            throw th;     // Catch: FileNotFoundException -> L39
        L36:
            th = move-exception;
            th.addSuppressed(th);     // Catch: FileNotFoundException -> L39
            throw th;     // Catch: FileNotFoundException -> L39
        L41:
            Slog.i(LOG_TAG, "No history file: " + file.getName());
            return Collections.emptyList();
        }

        private AppOpsManager.HistoricalOps readeHistoricalOpsDLocked(TypedXmlPullParser parser, int filterUid, String filterPackageName, String filterAttributionTag, String[] filterOpNames, int filter, long filterBeginTimeMillis, long filterEndTimeMillis, int filterFlags, long[] cumulativeOverflowMillis) throws IOException, XmlPullParserException {
            parser = parser;
            long r5 = parser.getAttributeLong(null, ATTR_BEGIN_TIME, 0);
            if (cumulativeOverflowMillis == null) goto L5;
            long r7 = cumulativeOverflowMillis[0];
        L6:
            long beginTimeMillis = r5 + r7;
            long r8 = parser.getAttributeLong(null, ATTR_END_TIME, 0);
            if (cumulativeOverflowMillis == null) goto L9;
            long r9 = cumulativeOverflowMillis[0];
        L10:
            long endTimeMillis = r8 + r9;
            if (filterEndTimeMillis >= beginTimeMillis) goto L14;
            return null;
        L14:
            if (filterBeginTimeMillis > endTimeMillis) goto L16;
            long filteredBeginTimeMillis = Math.max(beginTimeMillis, filterBeginTimeMillis);
            long filteredEndTimeMillis = Math.min(endTimeMillis, filterEndTimeMillis);
            long beginTimeMillis2 = filteredBeginTimeMillis;
            double filterScale = (filteredEndTimeMillis - filteredBeginTimeMillis) / (endTimeMillis - beginTimeMillis);
            AppOpsManager.HistoricalOps ops = null;
            int depth = parser.getDepth();
        L19:
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L28;
            AppOpsManager.HistoricalOps ops2 = ops;
            int depth2 = depth;
            if ("uid".equals(parser.getName()) == true) goto L22;
            ops = ops2;
            depth = depth2;
            beginTimeMillis2 = beginTimeMillis2;
            goto L19
        L22:
            long filteredEndTimeMillis2 = filteredEndTimeMillis;
            long filteredBeginTimeMillis2 = beginTimeMillis2;
            long filteredBeginTimeMillis3 = beginTimeMillis;
            long endTimeMillis2 = endTimeMillis;
            AppOpsManager.HistoricalOps returnedOps = readHistoricalUidOpsDLocked(ops2, parser, filterUid, filterPackageName, filterAttributionTag, filterOpNames, filter, filterFlags, filterScale);
            if (ops2 != null) goto L25;
            ops = returnedOps;
        L26:
            filteredEndTimeMillis = filteredEndTimeMillis2;
            beginTimeMillis = filteredBeginTimeMillis3;
            endTimeMillis = endTimeMillis2;
            depth = depth2;
            beginTimeMillis2 = filteredBeginTimeMillis2;
            goto L19
        L25:
            ops = ops2;
            goto L26
        L28:
            long filteredEndTimeMillis3 = filteredEndTimeMillis;
            long filteredBeginTimeMillis4 = beginTimeMillis2;
            AppOpsManager.HistoricalOps ops3 = ops;
            if (ops3 == null) goto L31;
            ops3.setBeginAndEndTime(filteredBeginTimeMillis4, filteredEndTimeMillis3);
        L31:
            return ops3;
        L16:
            return new AppOpsManager.HistoricalOps(0, 0);
        L9:
            r9 = 0;
            goto L10
        L5:
            r7 = 0;
            goto L6
        }

        private AppOpsManager.HistoricalOps readHistoricalUidOpsDLocked(AppOpsManager.HistoricalOps ops, TypedXmlPullParser parser, int filterUid, String filterPackageName, String filterAttributionTag, String[] filterOpNames, int filter, int filterFlags, double filterScale) throws IOException, XmlPullParserException {
            int uid = parser.getAttributeInt(null, ATTR_NAME);
            if ((filter & 1) == 0) goto L9;
            if (filterUid == uid) goto L9;
            XmlUtils.skipCurrentTag(parser);
            return null;
        L9:
            int depth = parser.getDepth();
            AppOpsManager.HistoricalOps ops2 = ops;
        L11:
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L18;
            if ("pkg".equals(parser.getName()) == false) goto L11;
            AppOpsManager.HistoricalOps returnedOps = readHistoricalPackageOpsDLocked(ops2, uid, parser, filterPackageName, filterAttributionTag, filterOpNames, filter, filterFlags, filterScale);
            if (ops2 != null) goto L11;
            ops2 = returnedOps;
            goto L11
        L18:
            return ops2;
        }

        private AppOpsManager.HistoricalOps readHistoricalPackageOpsDLocked(AppOpsManager.HistoricalOps ops, int uid, TypedXmlPullParser parser, String filterPackageName, String filterAttributionTag, String[] filterOpNames, int filter, int filterFlags, double filterScale) throws IOException, XmlPullParserException {
            parser = parser;
            String packageName = XmlUtils.readStringAttribute(parser, ATTR_NAME);
            if ((filter & 2) == 0) goto L9;
            if (filterPackageName.equals(packageName) == true) goto L9;
            XmlUtils.skipCurrentTag(parser);
            return null;
        L9:
            int depth = parser.getDepth();
            AppOpsManager.HistoricalOps ops2 = ops;
        L11:
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L19;
            if (TAG_ATTRIBUTION.equals(parser.getName()) == false) goto L11;
            AppOpsManager.HistoricalOps returnedOps = readHistoricalAttributionOpsDLocked(ops2, uid, packageName, parser, filterAttributionTag, filterOpNames, filter, filterFlags, filterScale);
            if (ops2 != null) goto L11;
            ops2 = returnedOps;
            goto L11
        L19:
            return ops2;
        }

        private AppOpsManager.HistoricalOps readHistoricalAttributionOpsDLocked(AppOpsManager.HistoricalOps ops, int uid, String packageName, TypedXmlPullParser parser, String filterAttributionTag, String[] filterOpNames, int filter, int filterFlags, double filterScale) throws IOException, XmlPullParserException {
            parser = parser;
            String attributionTag = XmlUtils.readStringAttribute(parser, ATTR_NAME);
            if ((filter & 4) == 0) goto L9;
            if (Objects.equals(filterAttributionTag, attributionTag) == true) goto L9;
            XmlUtils.skipCurrentTag(parser);
            return null;
        L9:
            int depth = parser.getDepth();
            AppOpsManager.HistoricalOps ops2 = ops;
        L11:
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L19;
            if (TAG_OP.equals(parser.getName()) == false) goto L11;
            AppOpsManager.HistoricalOps returnedOps = readHistoricalOpDLocked(ops2, uid, packageName, attributionTag, parser, filterOpNames, filter, filterFlags, filterScale);
            if (ops2 != null) goto L11;
            ops2 = returnedOps;
            goto L11
        L19:
            return ops2;
        }

        private AppOpsManager.HistoricalOps readHistoricalOpDLocked(AppOpsManager.HistoricalOps ops, int uid, String packageName, String attributionTag, TypedXmlPullParser parser, String[] filterOpNames, int filter, int filterFlags, double filterScale) throws IOException, XmlPullParserException {
            parser = parser;
            int op = parser.getAttributeInt(null, ATTR_NAME);
            if ((filter & 8) == 0) goto L9;
            if (ArrayUtils.contains(filterOpNames, AppOpsManager.opToPublicName(op)) == true) goto L9;
            XmlUtils.skipCurrentTag(parser);
            return null;
        L9:
            int depth = parser.getDepth();
            AppOpsManager.HistoricalOps ops2 = ops;
        L11:
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L19;
            if (TAG_STATE.equals(parser.getName()) == false) goto L11;
            AppOpsManager.HistoricalOps returnedOps = readStateDLocked(ops2, uid, packageName, attributionTag, op, parser, filterFlags, filterScale);
            if (ops2 != null) goto L11;
            ops2 = returnedOps;
            goto L11
        L19:
            return ops2;
        }

        private AppOpsManager.HistoricalOps readStateDLocked(AppOpsManager.HistoricalOps ops, int uid, String packageName, String attributionTag, int op, TypedXmlPullParser parser, int filterFlags, double filterScale) throws IOException, XmlPullParserException {
            long key = parser.getAttributeLong(null, ATTR_NAME);
            int flags = AppOpsManager.extractFlagsFromKey(key) & filterFlags;
            if (flags != 0) goto L5;
            return null;
        L5:
            int uidState = AppOpsManager.extractUidStateFromKey(key);
            long accessCount = parser.getAttributeLong(null, ATTR_ACCESS_COUNT, 0);
            if (accessCount > 0) goto L8;
            AppOpsManager.HistoricalOps ops2 = ops;
        L16:
            long rejectCount = parser.getAttributeLong(null, ATTR_REJECT_COUNT, 0);
            if (rejectCount <= 0) goto L26;
            if (Double.isNaN(filterScale) == true) goto L21;
            long rejectCount2 = (long) AppOpsManager.HistoricalOps.round(rejectCount * filterScale);
        L22:
            if (ops2 != null) goto L24;
            ops2 = new AppOpsManager.HistoricalOps(0, 0);
        L24:
            ops2.increaseRejectCount(op, uid, packageName, attributionTag, uidState, flags, rejectCount2);
            goto L26
        L21:
            rejectCount2 = rejectCount;
        L26:
            long accessDuration = parser.getAttributeLong(null, ATTR_ACCESS_DURATION, 0);
            if (accessDuration > 0) goto L29;
        L35:
            return ops2;
        L29:
            if (Double.isNaN(filterScale) == true) goto L31;
            long accessDuration2 = (long) AppOpsManager.HistoricalOps.round(accessDuration * filterScale);
        L32:
            if (ops2 != null) goto L34;
            ops2 = new AppOpsManager.HistoricalOps(0, 0);
        L34:
            ops2.increaseAccessDuration(op, uid, packageName, attributionTag, uidState, flags, accessDuration2);
            goto L35
        L31:
            accessDuration2 = accessDuration;
            goto L32
        L8:
            if (Double.isNaN(filterScale) == true) goto L10;
            long accessCount2 = (long) AppOpsManager.HistoricalOps.round(accessCount * filterScale);
        L11:
            if (ops != null) goto L13;
            ops2 = new AppOpsManager.HistoricalOps(0, 0);
        L14:
            ops2.increaseAccessCount(op, uid, packageName, attributionTag, uidState, flags, accessCount2);
            goto L16
        L13:
            ops2 = ops;
            goto L14
        L10:
            accessCount2 = accessCount;
            goto L11
        }

        private void writeHistoricalOpsDLocked(List<AppOpsManager.HistoricalOps> allOps, long intervalOverflowMillis, File file) throws IOException {
            FileOutputStream output = sHistoricalAppOpsDir.openWrite(file);
            TypedXmlSerializer serializer = Xml.resolveSerializer(output);     // Catch: IOException -> L6
            serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: IOException -> L6
            serializer.startDocument(null, true);     // Catch: IOException -> L6
            serializer.startTag(null, TAG_HISTORY);     // Catch: IOException -> L6
            serializer.attributeInt(null, ATTR_VERSION, 2);     // Catch: IOException -> L6
            if (intervalOverflowMillis == 0) goto L8;
            serializer.attributeLong(null, ATTR_OVERFLOW, intervalOverflowMillis);     // Catch: IOException -> L6
        L8:
            if (allOps == null) goto L12;
            int opsCount = allOps.size();     // Catch: IOException -> L6
            int i = 0;
        L10:
            if (i >= opsCount) goto L12;
            AppOpsManager.HistoricalOps ops = allOps.get(i);     // Catch: IOException -> L6
            writeHistoricalOpDLocked(ops, serializer);     // Catch: IOException -> L6
            i = i + 1;     // Catch: IOException -> L6
        L12:
            serializer.endTag(null, TAG_HISTORY);     // Catch: IOException -> L6
            serializer.endDocument();     // Catch: IOException -> L6
            sHistoricalAppOpsDir.closeWrite(output);     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            sHistoricalAppOpsDir.failWrite(output);
            throw e;
        }

        private void writeHistoricalOpDLocked(AppOpsManager.HistoricalOps ops, TypedXmlSerializer serializer) throws IOException {
            serializer.startTag(null, TAG_OPS);
            serializer.attributeLong(null, ATTR_BEGIN_TIME, ops.getBeginTimeMillis());
            serializer.attributeLong(null, ATTR_END_TIME, ops.getEndTimeMillis());
            int uidCount = ops.getUidCount();
            int i = 0;
        L3:
            if (i >= uidCount) goto L5;
            AppOpsManager.HistoricalUidOps uidOp = ops.getUidOpsAt(i);
            writeHistoricalUidOpsDLocked(uidOp, serializer);
            i = i + 1;
            goto L3
        L5:
            serializer.endTag(null, TAG_OPS);
        }

        private void writeHistoricalUidOpsDLocked(AppOpsManager.HistoricalUidOps uidOps, TypedXmlSerializer serializer) throws IOException {
            serializer.startTag(null, "uid");
            serializer.attributeInt(null, ATTR_NAME, uidOps.getUid());
            int packageCount = uidOps.getPackageCount();
            int i = 0;
        L3:
            if (i >= packageCount) goto L5;
            AppOpsManager.HistoricalPackageOps packageOps = uidOps.getPackageOpsAt(i);
            writeHistoricalPackageOpsDLocked(packageOps, serializer);
            i = i + 1;
            goto L3
        L5:
            serializer.endTag(null, "uid");
        }

        private void writeHistoricalPackageOpsDLocked(AppOpsManager.HistoricalPackageOps packageOps, TypedXmlSerializer serializer) throws IOException {
            serializer.startTag(null, "pkg");
            serializer.attributeInterned(null, ATTR_NAME, packageOps.getPackageName());
            int numAttributions = packageOps.getAttributedOpsCount();
            int i = 0;
        L3:
            if (i >= numAttributions) goto L5;
            AppOpsManager.AttributedHistoricalOps op = packageOps.getAttributedOpsAt(i);
            writeHistoricalAttributionOpsDLocked(op, serializer);
            i = i + 1;
            goto L3
        L5:
            serializer.endTag(null, "pkg");
        }

        private void writeHistoricalAttributionOpsDLocked(AppOpsManager.AttributedHistoricalOps attributionOps, TypedXmlSerializer serializer) throws IOException {
            serializer.startTag(null, TAG_ATTRIBUTION);
            XmlUtils.writeStringAttribute(serializer, ATTR_NAME, attributionOps.getTag());
            int opCount = attributionOps.getOpCount();
            int i = 0;
        L3:
            if (i >= opCount) goto L5;
            AppOpsManager.HistoricalOp op = attributionOps.getOpAt(i);
            writeHistoricalOpDLocked(op, serializer);
            i = i + 1;
            goto L3
        L5:
            serializer.endTag(null, TAG_ATTRIBUTION);
        }

        private void writeHistoricalOpDLocked(AppOpsManager.HistoricalOp op, TypedXmlSerializer serializer) throws IOException {
            LongSparseArray keys = op.collectKeys();
            if (keys != null) goto L5;
            return;
        L5:
            if (keys.size() <= 0) goto L14;
            serializer.startTag(null, TAG_OP);
            serializer.attributeInt(null, ATTR_NAME, op.getOpCode());
            int keyCount = keys.size();
            int i = 0;
        L8:
            if (i >= keyCount) goto L10;
            writeStateOnLocked(op, keys.keyAt(i), serializer);
            i = i + 1;
            goto L8
        L10:
            serializer.endTag(null, TAG_OP);
            return;
        }

        private void writeStateOnLocked(AppOpsManager.HistoricalOp op, long key, TypedXmlSerializer serializer) throws IOException {
            int uidState = AppOpsManager.extractUidStateFromKey(key);
            int flags = AppOpsManager.extractFlagsFromKey(key);
            long accessCount = op.getAccessCount(uidState, uidState, flags);
            long rejectCount = op.getRejectCount(uidState, uidState, flags);
            long accessDuration = op.getAccessDuration(uidState, uidState, flags);
            if (accessCount <= 0) goto L5;
        L9:
            serializer.startTag(null, TAG_STATE);
            serializer.attributeLong(null, ATTR_NAME, key);
            if (accessCount <= 0) goto L13;
            serializer.attributeLong(null, ATTR_ACCESS_COUNT, accessCount);
        L13:
            if (rejectCount <= 0) goto L16;
            serializer.attributeLong(null, ATTR_REJECT_COUNT, rejectCount);
        L16:
            if (accessDuration <= 0) goto L18;
            serializer.attributeLong(null, ATTR_ACCESS_DURATION, accessDuration);
        L18:
            serializer.endTag(null, TAG_STATE);
            return;
        L5:
            if (rejectCount > 0) goto L9;
            if (accessDuration > 0) goto L9;
        }

        private static void enforceOpsWellFormed(List<AppOpsManager.HistoricalOps> ops) {
            if (ops != null) goto L4;
            return;
        L4:
            AppOpsManager.HistoricalOps current = null;
            int opsCount = ops.size();
            int i = 0;
        L5:
            if (i >= opsCount) goto L26;
            AppOpsManager.HistoricalOps previous = current;
            AppOpsManager.HistoricalOps current2 = ops.get(i);
            current = current2;
            if (current.isEmpty() == true) goto L24;
            if (current.getEndTimeMillis() < current.getBeginTimeMillis()) goto L22;
            if (previous == null) goto L20;
            if (previous.getEndTimeMillis() > current.getBeginTimeMillis()) goto L19;
            if (previous.getBeginTimeMillis() <= current.getBeginTimeMillis()) goto L20;
            throw new IllegalStateException("Non increasing ops:\n" + opsToDebugString(ops));
        L19:
            throw new IllegalStateException("Intersecting ops:\n" + opsToDebugString(ops));
        L20:
            i = i + 1;
            goto L5
        L22:
            throw new IllegalStateException("Begin after end:\n" + opsToDebugString(ops));
        L24:
            throw new IllegalStateException("Empty ops:\n" + opsToDebugString(ops));
        }

        private long computeGlobalIntervalBeginMillis(int depth) {
            long beginTimeMillis = 0;
            int i = 0;
        L4:
            if (i >= (depth + 1)) goto L7;
            beginTimeMillis = (long) (beginTimeMillis + Math.pow(this.mIntervalCompressionMultiplier, i));
            i = i + 1;
            goto L4
        L7:
            return this.mBaseSnapshotInterval * beginTimeMillis;
        }

        private static AppOpsManager.HistoricalOps spliceFromEnd(AppOpsManager.HistoricalOps ops, double spliceRatio) {
            AppOpsManager.HistoricalOps splice = ops.spliceFromEnd(spliceRatio);
            return splice;
        }

        private static AppOpsManager.HistoricalOps spliceFromBeginning(AppOpsManager.HistoricalOps ops, double spliceRatio) {
            AppOpsManager.HistoricalOps splice = ops.spliceFromBeginning(spliceRatio);
            return splice;
        }

        private static void normalizeSnapshotForSlotDuration(List<AppOpsManager.HistoricalOps> ops, long slotDurationMillis) {
            int opCount = ops.size();
            int processedIdx = opCount - 1;
        L3:
            if (processedIdx < 0) goto L21;
            AppOpsManager.HistoricalOps processedOp = ops.get(processedIdx);
            long slotBeginTimeMillis = Math.max(processedOp.getEndTimeMillis() - slotDurationMillis, 0);
            int candidateIdx = processedIdx - 1;
        L5:
            if (candidateIdx < 0) goto L19;
            AppOpsManager.HistoricalOps candidateOp = ops.get(candidateIdx);
            long candidateSlotIntersectionMillis = candidateOp.getEndTimeMillis() - Math.min(slotBeginTimeMillis, processedOp.getBeginTimeMillis());
            if (candidateSlotIntersectionMillis <= 0) goto L19;
            float candidateSplitRatio = candidateSlotIntersectionMillis / candidateOp.getDurationMillis();
            if (Float.compare(candidateSplitRatio, 1.0f) < 0) goto L12;
            ops.remove(candidateIdx);
            processedIdx = processedIdx - 1;
            processedOp.merge(candidateOp);
        L18:
            candidateIdx = candidateIdx - 1;
            goto L5
        L12:
            AppOpsManager.HistoricalOps endSplice = spliceFromEnd(candidateOp, candidateSplitRatio);
            if (endSplice == null) goto L16;
            processedOp.merge(endSplice);
        L16:
            if (candidateOp.isEmpty() == false) goto L18;
            ops.remove(candidateIdx);
            processedIdx = processedIdx - 1;
        L19:
            processedIdx = processedIdx - 1;
            goto L3
        }

        private static String opsToDebugString(List<AppOpsManager.HistoricalOps> ops) {
            StringBuilder builder = new StringBuilder();
            int opCount = ops.size();
            int i = 0;
        L3:
            if (i >= opCount) goto L9;
            builder.append("  ");
            builder.append(ops.get(i));
            if (i >= (opCount - 1)) goto L7;
            builder.append('\n');
        L7:
            i = i + 1;
            goto L3
        L9:
            return builder.toString();
        }

        private static Set<String> getHistoricalFileNames(File historyDir) {
            File[] files = historyDir.listFiles();
            if (files == null) goto L5;
            ArraySet<String> fileNames = new ArraySet(files.length);
            int r2 = files.length;
            int r3 = 0;
        L7:
            if (r3 >= r2) goto L9;
            File file = files[r3];
            fileNames.add(file.getName());
            r3 = r3 + 1;
            goto L7
        L9:
            return fileNames;
        L5:
            return Collections.emptySet();
        }
    }

    private final class StringDumpVisitor implements AppOpsManager.HistoricalOpsVisitor {
        private final String mAttributionPrefix;
        private final Date mDate;
        private final SimpleDateFormat mDateFormatter;
        private final String mEntryPrefix;
        private final int mFilter;
        private final String mFilterAttributionTag;
        private final int mFilterOp;
        private final String mFilterPackage;
        private final int mFilterUid;
        private final long mNow;
        private final String mOpsPrefix;
        private final String mPackagePrefix;
        private final String mUidPrefix;
        private final String mUidStatePrefix;
        private final PrintWriter mWriter;

        StringDumpVisitor(LegacyHistoricalRegistry r3, String prefix, PrintWriter writer, int filterUid, String filterPackage, String filterAttributionTag, int filterOp, int filter) {
            this.mNow = System.currentTimeMillis();
            this.mDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            this.mDate = new Date();
            this.mOpsPrefix = prefix + "  ";
            this.mUidPrefix = this.mOpsPrefix + "  ";
            this.mPackagePrefix = this.mUidPrefix + "  ";
            this.mAttributionPrefix = this.mPackagePrefix + "  ";
            this.mEntryPrefix = this.mAttributionPrefix + "  ";
            this.mUidStatePrefix = this.mEntryPrefix + "  ";
            this.mWriter = writer;
            this.mFilterUid = filterUid;
            this.mFilterPackage = filterPackage;
            this.mFilterAttributionTag = filterAttributionTag;
            this.mFilterOp = filterOp;
            this.mFilter = filter;
        }

        public void visitHistoricalOps(AppOpsManager.HistoricalOps ops) {
            this.mWriter.println();
            this.mWriter.print(this.mOpsPrefix);
            this.mWriter.println("snapshot:");
            this.mWriter.print(this.mUidPrefix);
            this.mWriter.print("begin = ");
            this.mDate.setTime(ops.getBeginTimeMillis());
            this.mWriter.print(this.mDateFormatter.format(this.mDate));
            this.mWriter.print("  (");
            TimeUtils.formatDuration(ops.getBeginTimeMillis() - this.mNow, this.mWriter);
            this.mWriter.println(")");
            this.mWriter.print(this.mUidPrefix);
            this.mWriter.print("end = ");
            this.mDate.setTime(ops.getEndTimeMillis());
            this.mWriter.print(this.mDateFormatter.format(this.mDate));
            this.mWriter.print("  (");
            TimeUtils.formatDuration(ops.getEndTimeMillis() - this.mNow, this.mWriter);
            this.mWriter.println(")");
        }

        public void visitHistoricalUidOps(AppOpsManager.HistoricalUidOps ops) {
            if ((this.mFilter & 1) != 0) goto L5;
        L7:
            this.mWriter.println();
            this.mWriter.print(this.mUidPrefix);
            this.mWriter.print("Uid ");
            UserHandle.formatUid(this.mWriter, ops.getUid());
            this.mWriter.println(":");
            return;
        L5:
            if (this.mFilterUid == ops.getUid()) goto L7;
        }

        public void visitHistoricalPackageOps(AppOpsManager.HistoricalPackageOps ops) {
            if ((this.mFilter & 2) != 0) goto L5;
        L7:
            this.mWriter.print(this.mPackagePrefix);
            this.mWriter.print("Package ");
            this.mWriter.print(ops.getPackageName());
            this.mWriter.println(":");
            return;
        L5:
            if (this.mFilterPackage.equals(ops.getPackageName()) == true) goto L7;
        }

        public void visitHistoricalAttributionOps(AppOpsManager.AttributedHistoricalOps ops) {
            if ((this.mFilter & 4) != 0) goto L5;
        L7:
            this.mWriter.print(this.mAttributionPrefix);
            this.mWriter.print("Attribution ");
            this.mWriter.print(ops.getTag());
            this.mWriter.println(":");
            return;
        L5:
            if (Objects.equals(this.mFilterPackage, ops.getTag()) == true) goto L7;
        }

        public void visitHistoricalOp(AppOpsManager.HistoricalOp ops) {
            AppOpsManager.HistoricalOp r1 = ops;
            if ((this.mFilter & 8) != 0) goto L5;
        L7:
            this.mWriter.print(this.mEntryPrefix);
            this.mWriter.print(AppOpsManager.opToName(r1.getOpCode()));
            this.mWriter.println(":");
            LongSparseArray keys = r1.collectKeys();
            int keyCount = keys.size();
            int i = 0;
        L8:
            if (i >= keyCount) goto L33;
            long key = keys.keyAt(i);
            int uidState = AppOpsManager.extractUidStateFromKey(key);
            int flags = AppOpsManager.extractFlagsFromKey(key);
            boolean printedUidState = false;
            long accessCount = r1.getAccessCount(uidState, uidState, flags);
            long r12 = 0;
            if (accessCount <= 0) goto L15;
            if (0 != 0) goto L14;
            this.mWriter.print(this.mUidStatePrefix);
            this.mWriter.print(AppOpsManager.keyToString(key));
            this.mWriter.print(" = ");
            printedUidState = true;
        L14:
            this.mWriter.print("access=");
            this.mWriter.print(accessCount);
        L16:
            long rejectCount = r1.getRejectCount(uidState, uidState, flags);
            LongSparseArray keys2 = keys;
            if (rejectCount <= r12) goto L22;
            if (printedUidState == true) goto L20;
            this.mWriter.print(this.mUidStatePrefix);
            this.mWriter.print(AppOpsManager.keyToString(key));
            this.mWriter.print(" = ");
            printedUidState = true;
        L21:
            this.mWriter.print("reject=");
            this.mWriter.print(rejectCount);
        L23:
            int i2 = i;
            long accessDuration = r1.getAccessDuration(uidState, uidState, flags);
            if (accessDuration <= r12) goto L29;
            if (printedUidState == true) goto L27;
            this.mWriter.print(this.mUidStatePrefix);
            this.mWriter.print(AppOpsManager.keyToString(key));
            this.mWriter.print(" = ");
            printedUidState = true;
        L28:
            this.mWriter.print("duration=");
            TimeUtils.formatDuration(accessDuration, this.mWriter);
            goto L29
        L27:
            this.mWriter.print(", ");
        L29:
            if (printedUidState == false) goto L31;
            this.mWriter.println("");
        L31:
            i = i2 + 1;
            r1 = ops;
            keys = keys2;
            keyCount = keyCount;
            goto L8
        L20:
            this.mWriter.print(", ");
            goto L21
        L22:
            keyCount = keyCount;
            goto L23
        L15:
            r12 = 0;
            goto L16
        L33:
            return;
        L5:
            if (this.mFilterOp == r1.getOpCode()) goto L7;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateParametersFromSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1822$$Nest$mupdateParametersFromSetting(LegacyHistoricalRegistry r0, ContentResolver r1) {
        r0.updateParametersFromSetting(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smwtf, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1823$$Nest$smwtf(String r0, Throwable r1, File r2) {
        wtf(r0, r1, r2);
    }

    static {
        KEEP_WTF_LOG = Build.IS_DEBUGGABLE;
        LOG_TAG = LegacyHistoricalRegistry.class.getSimpleName();
        DEFAULT_SNAPSHOT_INTERVAL_MILLIS = TimeUnit.MINUTES.toMillis(15);
    }

    LegacyHistoricalRegistry(Object lock, Context context) {
        this.mPendingWrites = new LinkedList();
        this.mOnDiskLock = new Object();
        this.mMode = 1;
        this.mBaseSnapshotInterval = DEFAULT_SNAPSHOT_INTERVAL_MILLIS;
        this.mIntervalCompressionMultiplier = DEFAULT_COMPRESSION_STEP;
        this.mInMemoryLock = lock;
        this.mContext = context;
        this.mDiscreteRegistry = new DiscreteOpsXmlRegistry(lock);
    }

    LegacyHistoricalRegistry(LegacyHistoricalRegistry other) {
        this(other.mInMemoryLock, other.mContext);
        this.mMode = other.mMode;
        this.mBaseSnapshotInterval = other.mBaseSnapshotInterval;
        this.mIntervalCompressionMultiplier = other.mIntervalCompressionMultiplier;
        this.mDiscreteRegistry = other.mDiscreteRegistry;
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void systemReady(final ContentResolver resolver) {
        this.mDiscreteRegistry.systemReady();
        Uri uri = Settings.Global.getUriFor("appop_history_parameters");
        final Handler r2 = FgThread.getHandler();
        resolver.registerContentObserver(uri, false, new AnonymousClass1(this, r2, resolver));
        updateParametersFromSetting(resolver);
        Object r1 = this.mOnDiskLock;
        monitor-enter(r1);
        Object r3 = this.mInMemoryLock;     // Catch: Throwable -> L22
        monitor-enter(r3);     // Catch: Throwable -> L22
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L7:
        if (this.mMode != 0) goto L9;
    L16:
        monitor-exit(r3);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L22
        if (DiscreteOpsDbHelper.getDatabaseFile().exists() == false) goto L31;
        DiscreteOpsSqlRegistry sqlRegistry = new DiscreteOpsSqlRegistry(this.mContext);
        DiscreteOpsXmlRegistry xmlRegistry = (DiscreteOpsXmlRegistry) this.mDiscreteRegistry;
        DiscreteOpsMigrationHelper.migrateDiscreteOpsToXml(sqlRegistry, xmlRegistry);
        return;
    L31:
        return;
    L9:
        if (isPersistenceInitializedMLocked() == true) goto L13;
        this.mPersistence = new Persistence(this.mBaseSnapshotInterval, this.mIntervalCompressionMultiplier);     // Catch: Throwable -> L11
    L13:
        long lastPersistTimeMills = this.mPersistence.getLastPersistTimeMillisDLocked();     // Catch: Throwable -> L11
        if (lastPersistTimeMills <= 0) goto L16;
        this.mPendingHistoryOffsetMillis = System.currentTimeMillis() - lastPersistTimeMills;     // Catch: Throwable -> L11
    L22:
        th = move-exception;
        throw th;
    }

    private boolean isPersistenceInitializedMLocked() {
        if (this.mPersistence == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateParametersFromSetting(ContentResolver resolver) {
        String setting = Settings.Global.getString(resolver, "appop_history_parameters");
        if (setting != null) goto L5;
        return;
    L5:
        String[] parameters = setting.split(PARAMETER_DELIMITER);
        int r5 = parameters.length;
        String intervalMultiplierValue = null;
        String baseSnapshotIntervalValue = null;
        String modeValue = null;
        int r0 = 0;
    L6:
        if (r0 >= r5) goto L28;
        String parameter = parameters[r0];
        String[] parts = parameter.split(PARAMETER_ASSIGNMENT);
        byte r11 = 2;
        if (parts.length != 2) goto L27;
        String key = parts[0].trim();
        switch(key.hashCode()) {
            case -190198682: goto L19;
            case 3357091: goto L16;
            case 245634204: goto L13;
            default: goto L21;
        };
    L21:
        r11 = -1;
    L22:
        switch(r11) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            default: goto L23;
        };
    L23:
        Slog.w(LOG_TAG, "Unknown parameter: " + parameter);
        goto L27
    L24:
        intervalMultiplierValue = parts[1].trim();
        goto L27
    L25:
        baseSnapshotIntervalValue = parts[1].trim();
        goto L27
    L26:
        modeValue = parts[1].trim();
        goto L27
    L13:
        if (key.equals("baseIntervalMillis") == false) goto L21;
        r11 = 1;
        goto L22
    L16:
        if (key.equals("mode") == false) goto L21;
        r11 = 0;
        goto L22
    L19:
        if (key.equals("intervalMultiplier") == false) goto L21;
    L27:
        r0 = r0 + 1;
        goto L6
    L28:
        if (modeValue == null) goto L34;
        if (baseSnapshotIntervalValue == null) goto L34;
        if (intervalMultiplierValue == null) goto L34;
        int mode = AppOpsManager.parseHistoricalMode(modeValue);     // Catch: NumberFormatException -> L33
        long baseSnapshotInterval = Long.parseLong(baseSnapshotIntervalValue);     // Catch: NumberFormatException -> L33
        int intervalCompressionMultiplier = Integer.parseInt(intervalMultiplierValue);     // Catch: NumberFormatException -> L33
        setHistoryParameters(mode, baseSnapshotInterval, intervalCompressionMultiplier);     // Catch: NumberFormatException -> L33
        return;
    L34:
        Slog.w(LOG_TAG, "Bad value forappop_history_parameters=" + setting + " resetting!");
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void dump(String prefix, PrintWriter pw, int filterUid, String filterPackage, String filterAttributionTag, int filterOp, int filter) {
        Object r11 = this.mOnDiskLock;
        monitor-enter(r11);
        Object r12 = this.mInMemoryLock;     // Catch: Throwable -> L12
        monitor-enter(r12);     // Catch: Throwable -> L12
        pw.println();     // Catch: Throwable -> L14
        pw.print(prefix);     // Catch: Throwable -> L14
        pw.print("History:");     // Catch: Throwable -> L14
        pw.print("  mode=");     // Catch: Throwable -> L14
        pw.println(AppOpsManager.historicalModeToString(this.mMode));     // Catch: Throwable -> L14
        StringDumpVisitor visitor = new StringDumpVisitor(this, prefix + "  ", pw, filterUid, filterPackage, filterAttributionTag, filterOp, filter);     // Catch: Throwable -> L14
        long nowMillis = System.currentTimeMillis();     // Catch: Throwable -> L14
        AppOpsManager.HistoricalOps currentOps = getUpdatedPendingHistoricalOpsMLocked(nowMillis);     // Catch: Throwable -> L14
        makeRelativeToEpochStart(currentOps, nowMillis);     // Catch: Throwable -> L14
        currentOps.accept(visitor);     // Catch: Throwable -> L14
        if (isPersistenceInitializedMLocked() == true) goto L16;
        Slog.e(LOG_TAG, "Interaction before persistence initialized");     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L16:
        List<AppOpsManager.HistoricalOps> ops = this.mPersistence.readHistoryDLocked();     // Catch: Throwable -> L14
        if (ops == null) goto L22;
        long remainingToFillBatchMillis = (this.mNextPersistDueTimeMillis - nowMillis) - this.mBaseSnapshotInterval;     // Catch: Throwable -> L14
        int opCount = ops.size();     // Catch: Throwable -> L14
        int i = 0;
    L19:
        if (i >= opCount) goto L23;
        AppOpsManager.HistoricalOps op = ops.get(i);     // Catch: Throwable -> L14
        op.offsetBeginAndEndTime(remainingToFillBatchMillis);     // Catch: Throwable -> L14
        makeRelativeToEpochStart(op, nowMillis);     // Catch: Throwable -> L14
        op.accept(visitor);     // Catch: Throwable -> L14
        i = i + 1;     // Catch: Throwable -> L14
    L23:
        monitor-exit(r12);     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L22:
        pw.println("  Empty");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void dumpDiscreteData(PrintWriter pw, int uidFilter, String packageNameFilter, String attributionTagFilter, int filter, int dumpOp, SimpleDateFormat sdf, Date date, String prefix, int nDiscreteOps) {
        this.mDiscreteRegistry.dump(pw, uidFilter, packageNameFilter, attributionTagFilter, filter, dumpOp, sdf, date, prefix, nDiscreteOps);
    }

    int getMode() {
        Object r0 = this.mInMemoryLock;
        monitor-enter(r0);
        int r1 = this.mMode;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void getHistoricalOpsFromDiskRaw(int uid, String packageName, String attributionTag, String[] opNames, int historyFlags, int filter, long beginTimeMillis, long endTimeMillis, int flags, String[] attributionExemptedPackages, RemoteCallback callback) {
        AppOpsManager.HistoricalOps result = new AppOpsManager.HistoricalOps(beginTimeMillis, endTimeMillis);
        if ((historyFlags & 1) == 0) goto L27;
        Object r15 = this.mOnDiskLock;
        monitor-enter(r15);
        Object r3 = this.mInMemoryLock;     // Catch: Throwable -> L14
        monitor-enter(r3);     // Catch: Throwable -> L14
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L9:
        if (isPersistenceInitializedMLocked() == true) goto L18;
        Slog.e(LOG_TAG, "Interaction before persistence initialized");     // Catch: Throwable -> L16
        callback.sendResult(new Bundle());     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        monitor-exit(r15);     // Catch: Throwable -> L14
        return;
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L16
        Persistence.m1824$$Nest$mcollectHistoricalOpsDLocked(this.mPersistence, result, uid, packageName, attributionTag, opNames, filter, beginTimeMillis, endTimeMillis, flags);     // Catch: Throwable -> L14
        monitor-exit(r15);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L27:
        if ((historyFlags & 2) == 0) goto L29;
        this.mDiscreteRegistry.addFilteredDiscreteOpsToHistoricalOps(result, beginTimeMillis, endTimeMillis, filter, uid, packageName, opNames, attributionTag, flags, new ArraySet(attributionExemptedPackages));
    L29:
        Bundle payload = new Bundle();
        payload.putParcelable("historical_ops", result);
        callback.sendResult(payload);
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void getHistoricalOps(int uid, String packageName, String attributionTag, String[] opNames, int historyFlags, int filter, long beginTimeMillis, long endTimeMillis, int flags, String[] attributionExemptPkgs, RemoteCallback callback) {
        long currentTimeMillis = System.currentTimeMillis();
        if (endTimeMillis != Long.MAX_VALUE) goto L5;
        long endTimeMillis2 = currentTimeMillis;
    L6:
        Bundle payload = new Bundle();
        long inMemoryAdjBeginTimeMillis = Math.max(currentTimeMillis - endTimeMillis2, 0);
        long inMemoryAdjEndTimeMillis = Math.max(currentTimeMillis - beginTimeMillis, 0);
        AppOpsManager.HistoricalOps result = new AppOpsManager.HistoricalOps(inMemoryAdjBeginTimeMillis, inMemoryAdjEndTimeMillis);
        if ((historyFlags & 2) == 0) goto L9;
        AppOpsManager.HistoricalOps result2 = result;
        long currentTimeMillis2 = currentTimeMillis;
        long r4 = beginTimeMillis;
        this.mDiscreteRegistry.addFilteredDiscreteOpsToHistoricalOps(result2, r4, endTimeMillis2, filter, uid, packageName, opNames, attributionTag, flags, new ArraySet(attributionExemptPkgs));
    L11:
        if ((historyFlags & 1) == 0) goto L83;
        Object r2 = this.mOnDiskLock;
        monitor-enter(r2);
        Object r8 = this.mInMemoryLock;     // Catch: Throwable -> L79
        monitor-enter(r8);     // Catch: Throwable -> L79
        if (isPersistenceInitializedMLocked() == false) goto L106;
        long currentTimeMillis3 = currentTimeMillis2;
        AppOpsManager.HistoricalOps currentOps = getUpdatedPendingHistoricalOpsMLocked(currentTimeMillis3);     // Catch: Throwable -> L71
        if (inMemoryAdjBeginTimeMillis < currentOps.getEndTimeMillis()) goto L108;
        long inMemoryAdjBeginTimeMillis2 = inMemoryAdjBeginTimeMillis;
    L96:
        AppOpsManager.HistoricalOps result3 = result2;
        List<AppOpsManager.HistoricalOps> pendingWrites = new ArrayList(this.mPendingWrites);     // Catch: Throwable -> L67
        this.mPendingWrites.clear();     // Catch: Throwable -> L67
        if (inMemoryAdjEndTimeMillis <= currentOps.getEndTimeMillis()) goto L47;
        boolean collectOpsFromDisk = true;
    L48:
        monitor-exit(r8);     // Catch: Throwable -> L67
        if (collectOpsFromDisk == false) goto L63;
        persistPendingHistory(pendingWrites);     // Catch: Throwable -> L60
        long onDiskAndInMemoryOffsetMillis = (currentTimeMillis3 - this.mNextPersistDueTimeMillis) + this.mBaseSnapshotInterval;
        long onDiskAdjBeginTimeMillis = Math.max(inMemoryAdjBeginTimeMillis2 - onDiskAndInMemoryOffsetMillis, 0);     // Catch: Throwable -> L56
        long onDiskAdjEndTimeMillis = Math.max(inMemoryAdjEndTimeMillis - onDiskAndInMemoryOffsetMillis, 0);     // Catch: Throwable -> L56
        Persistence.m1824$$Nest$mcollectHistoricalOpsDLocked(this.mPersistence, result3, uid, packageName, attributionTag, opNames, filter, onDiskAdjBeginTimeMillis, onDiskAdjEndTimeMillis, flags);     // Catch: Throwable -> L56
    L56:
        th = th;
    L81:
        monitor-exit(r2);     // Catch: Throwable -> L65
        throw th;
    L58:
        th = th;
    L60:
        th = th;
    L63:
        monitor-exit(r2);     // Catch: Throwable -> L65
    L84:
        result3.setBeginAndEndTime(r4, endTimeMillis2);
        payload.putParcelable("historical_ops", result3);
        callback.sendResult(payload);
        return;
    L47:
        collectOpsFromDisk = false;
    L67:
        th = th;
    L87:
        monitor-exit(r8);     // Catch: Throwable -> L77
        throw th;     // Catch: Throwable -> L65
    L77:
        th = th;
    L69:
        th = th;
        goto L87
    L108:
    L38:
        th = th;
        goto L87
    L31:
        if (inMemoryAdjEndTimeMillis <= currentOps.getBeginTimeMillis()) goto L40;
        AppOpsManager.HistoricalOps currentOpsCopy = new AppOpsManager.HistoricalOps(currentOps);     // Catch: Throwable -> L38
        currentOpsCopy.filter(uid, packageName, attributionTag, opNames, historyFlags, filter, inMemoryAdjBeginTimeMillis, inMemoryAdjEndTimeMillis);     // Catch: Throwable -> L38
        inMemoryAdjBeginTimeMillis2 = inMemoryAdjBeginTimeMillis;
        result2.merge(currentOpsCopy);     // Catch: Throwable -> L36
    L36:
        th = th;
        goto L87
    L40:
        inMemoryAdjBeginTimeMillis2 = inMemoryAdjBeginTimeMillis;
    L71:
        th = th;
        goto L87
    L106:
        Slog.e(LOG_TAG, "Interaction before persistence initialized");     // Catch: Throwable -> L24
        callback.sendResult(new Bundle());     // Catch: Throwable -> L24
        monitor-exit(r8);     // Catch: Throwable -> L24
        monitor-exit(r2);     // Catch: Throwable -> L22
        return;
    L22:
        th = th;
    L24:
        th = th;
    L73:
        th = th;
    L65:
        th = th;
    L79:
        th = th;
        goto L81
    L83:
        result3 = result2;
        goto L84
    L9:
        currentTimeMillis2 = currentTimeMillis;
        result2 = result;
        r4 = beginTimeMillis;
        goto L11
    L5:
        endTimeMillis2 = endTimeMillis;
        goto L6
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void incrementOpAccessedCount(int op, int uid, String packageName, String deviceId, String attributionTag, int uidState, int flags, long accessTime, int attributionFlags, int attributionChainId, int accessCount) {
        Object r2 = this.mInMemoryLock;
        monitor-enter(r2);
    L16:
        th = th;
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L16
        throw th;
    L11:
        th = th;
        goto L21
    L5:
        if (this.mMode != 1) goto L19;
        if (isPersistenceInitializedMLocked() == true) goto L15;
        Slog.v(LOG_TAG, "Interaction before persistence initialized");     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L15:
        getUpdatedPendingHistoricalOpsMLocked(System.currentTimeMillis()).increaseAccessCount(op, uid, packageName, attributionTag, uidState, flags, accessCount);     // Catch: Throwable -> L16
        this.mDiscreteRegistry.recordDiscreteAccess(uid, packageName, deviceId, op, attributionTag, flags, uidState, accessTime, -1, attributionFlags, attributionChainId);     // Catch: Throwable -> L16
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L16
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void incrementOpRejectedCount(int op, int uid, String packageName, String attributionTag, int uidState, int flags) {
        Object r1 = this.mInMemoryLock;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mMode == 1) goto L7;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L7:
        if (isPersistenceInitializedMLocked() == true) goto L13;
        Slog.v(LOG_TAG, "Interaction before persistence initialized");     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L13:
        getUpdatedPendingHistoricalOpsMLocked(System.currentTimeMillis()).increaseRejectCount(op, uid, packageName, attributionTag, uidState, flags, 1);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void increaseOpAccessDuration(int op, int uid, String packageName, String deviceId, String attributionTag, int uidState, int flags, long eventStartTime, long increment, int attributionFlags, int attributionChainId) {
        Object r2 = this.mInMemoryLock;
        monitor-enter(r2);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mMode == 1) goto L7;
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L7:
        if (isPersistenceInitializedMLocked() == true) goto L13;
        Slog.v(LOG_TAG, "Interaction before persistence initialized");     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L13:
        getUpdatedPendingHistoricalOpsMLocked(System.currentTimeMillis()).increaseAccessDuration(op, uid, packageName, attributionTag, uidState, flags, increment);     // Catch: Throwable -> L11
        this.mDiscreteRegistry.recordDiscreteAccess(uid, packageName, deviceId, op, attributionTag, flags, uidState, eventStartTime, increment, attributionFlags, attributionChainId);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void setHistoryParameters(int mode, long baseSnapshotInterval, long intervalCompressionMultiplier) {
        boolean resampleHistory = false;
        Object r1 = this.mOnDiskLock;
        monitor-enter(r1);
        Object r2 = this.mInMemoryLock;     // Catch: Throwable -> L26
        monitor-enter(r2);     // Catch: Throwable -> L26
        Slog.i(LOG_TAG, "New history parameters: mode:" + AppOpsManager.historicalModeToString(mode) + " baseSnapshotInterval:" + baseSnapshotInterval + " intervalCompressionMultiplier:" + intervalCompressionMultiplier);     // Catch: Throwable -> L11
        if (this.mMode == mode) goto L17;
        this.mMode = mode;     // Catch: Throwable -> L11
        if (this.mMode != 0) goto L14;
        clearHistoryOnDiskDLocked();     // Catch: Throwable -> L11
    L14:
        if (this.mMode != 2) goto L17;
        this.mDiscreteRegistry.setDebugMode(true);     // Catch: Throwable -> L11
    L17:
        if (this.mBaseSnapshotInterval == baseSnapshotInterval) goto L20;
        this.mBaseSnapshotInterval = baseSnapshotInterval;     // Catch: Throwable -> L11
        resampleHistory = true;
    L20:
        if (this.mIntervalCompressionMultiplier == intervalCompressionMultiplier) goto L22;
        this.mIntervalCompressionMultiplier = intervalCompressionMultiplier;     // Catch: Throwable -> L11
        resampleHistory = true;
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L11
        if (resampleHistory == true) goto L25;
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L26
        return;
    L25:
        resampleHistoryOnDiskInMemoryDMLocked(0);     // Catch: Throwable -> L26
        goto L28
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void offsetHistory(long offsetMillis) {
        Object r0 = this.mOnDiskLock;
        monitor-enter(r0);
        Object r1 = this.mInMemoryLock;     // Catch: Throwable -> L12
        monitor-enter(r1);     // Catch: Throwable -> L12
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L7:
        if (isPersistenceInitializedMLocked() == true) goto L16;
        Slog.e(LOG_TAG, "Interaction before persistence initialized");     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L14
        List<AppOpsManager.HistoricalOps> history = this.mPersistence.readHistoryDLocked();     // Catch: Throwable -> L12
        clearHistoricalRegistry();     // Catch: Throwable -> L12
        if (history == null) goto L26;
        int historySize = history.size();     // Catch: Throwable -> L12
        int i = 0;
    L20:
        if (i >= historySize) goto L23;
        AppOpsManager.HistoricalOps ops = history.get(i);     // Catch: Throwable -> L12
        ops.offsetBeginAndEndTime(offsetMillis);     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
        goto L20
    L23:
        if (offsetMillis >= 0) goto L25;
        pruneFutureOps(history);     // Catch: Throwable -> L12
    L25:
        this.mPersistence.persistHistoricalOpsDLocked(history);     // Catch: Throwable -> L12
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L12
        this.mDiscreteRegistry.offsetHistory(offsetMillis);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void addHistoricalOps(AppOpsManager.HistoricalOps ops) {
        Object r0 = this.mInMemoryLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isPersistenceInitializedMLocked() == true) goto L11;
        Slog.d(LOG_TAG, "Interaction before persistence initialized");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        ops.offsetBeginAndEndTime(this.mBaseSnapshotInterval);     // Catch: Throwable -> L9
        this.mPendingWrites.offerFirst(ops);     // Catch: Throwable -> L9
        List<AppOpsManager.HistoricalOps> pendingWrites = new ArrayList(this.mPendingWrites);     // Catch: Throwable -> L9
        this.mPendingWrites.clear();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        persistPendingHistory(pendingWrites);
    }

    private void resampleHistoryOnDiskInMemoryDMLocked(long offsetMillis) {
        Object r0 = this.mInMemoryLock;
        monitor-enter(r0);
        this.mPersistence = new Persistence(this.mBaseSnapshotInterval, this.mIntervalCompressionMultiplier);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        offsetHistory(offsetMillis);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void resetHistoryParameters() {
        if (isPersistenceInitializedMLocked() == true) goto L6;
        Slog.d(LOG_TAG, "Interaction before persistence initialized");
        return;
    L6:
        setHistoryParameters(1, DEFAULT_SNAPSHOT_INTERVAL_MILLIS, DEFAULT_COMPRESSION_STEP);
        this.mDiscreteRegistry.setDebugMode(false);
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void clearHistory(int uid, String packageName) {
        Object r0 = this.mOnDiskLock;
        monitor-enter(r0);
        Object r1 = this.mInMemoryLock;     // Catch: Throwable -> L12
        monitor-enter(r1);     // Catch: Throwable -> L12
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L7:
        if (isPersistenceInitializedMLocked() == true) goto L17;
        Slog.d(LOG_TAG, "Interaction before persistence initialized");     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L17:
        if (this.mMode == 1) goto L21;
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L21:
        int index = 0;
    L23:
        if (index >= this.mPendingWrites.size()) goto L25;
        this.mPendingWrites.get(index).clearHistory(uid, packageName);     // Catch: Throwable -> L14
        index = index + 1;     // Catch: Throwable -> L14
        goto L23
    L25:
        getUpdatedPendingHistoricalOpsMLocked(System.currentTimeMillis()).clearHistory(uid, packageName);     // Catch: Throwable -> L14
        this.mPersistence.clearHistoryDLocked(uid, packageName);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        this.mDiscreteRegistry.clearHistory(uid, packageName);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void writeAndClearDiscreteHistory() {
        this.mDiscreteRegistry.writeAndClearOldAccessHistory();
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void clearAllHistory() {
        clearHistoricalRegistry();
        this.mDiscreteRegistry.clearHistory();
    }

    void clearHistoricalRegistry() {
        Object r0 = this.mOnDiskLock;
        monitor-enter(r0);
        Object r1 = this.mInMemoryLock;     // Catch: Throwable -> L12
        monitor-enter(r1);     // Catch: Throwable -> L12
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L7:
        if (isPersistenceInitializedMLocked() == true) goto L16;
        Slog.d(LOG_TAG, "Interaction before persistence initialized");     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L16:
        clearHistoryOnDiskDLocked();     // Catch: Throwable -> L14
        this.mNextPersistDueTimeMillis = 0;     // Catch: Throwable -> L14
        this.mPendingHistoryOffsetMillis = 0;     // Catch: Throwable -> L14
        this.mCurrentHistoricalOps = null;     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void clearHistoryOnDiskDLocked() {
        IoThread.getHandler().removeMessages(1);
        Object r0 = this.mInMemoryLock;
        monitor-enter(r0);
        this.mCurrentHistoricalOps = null;     // Catch: Throwable -> L9
        this.mNextPersistDueTimeMillis = System.currentTimeMillis();     // Catch: Throwable -> L9
        this.mPendingWrites.clear();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        Persistence.clearHistoryDLocked();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private AppOpsManager.HistoricalOps getUpdatedPendingHistoricalOpsMLocked(long now) {
        if (this.mCurrentHistoricalOps == null) goto L16;
        long remainingTimeMillis = this.mNextPersistDueTimeMillis - now;
        if (remainingTimeMillis <= this.mBaseSnapshotInterval) goto L7;
        this.mPendingHistoryOffsetMillis = remainingTimeMillis - this.mBaseSnapshotInterval;
    L7:
        long elapsedTimeMillis = this.mBaseSnapshotInterval - remainingTimeMillis;
        this.mCurrentHistoricalOps.setEndTime(elapsedTimeMillis);
        if (remainingTimeMillis <= 0) goto L12;
        return this.mCurrentHistoricalOps;
    L12:
        if (this.mCurrentHistoricalOps.isEmpty() == false) goto L15;
        this.mCurrentHistoricalOps.setBeginAndEndTime(0, 0);
        this.mNextPersistDueTimeMillis = this.mBaseSnapshotInterval + now;
        return this.mCurrentHistoricalOps;
    L15:
        this.mCurrentHistoricalOps.offsetBeginAndEndTime(this.mBaseSnapshotInterval);
        this.mCurrentHistoricalOps.setBeginTime(this.mCurrentHistoricalOps.getEndTimeMillis() - this.mBaseSnapshotInterval);
        long overdueTimeMillis = Math.abs(remainingTimeMillis);
        this.mCurrentHistoricalOps.offsetBeginAndEndTime(overdueTimeMillis);
        schedulePersistHistoricalOpsMLocked(this.mCurrentHistoricalOps);
    L16:
        this.mCurrentHistoricalOps = new AppOpsManager.HistoricalOps(0, 0);
        this.mNextPersistDueTimeMillis = this.mBaseSnapshotInterval + now;
        return this.mCurrentHistoricalOps;
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void shutdown() {
        Object r0 = this.mInMemoryLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mMode != 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        persistPendingHistory();
        this.mDiscreteRegistry.shutdown();
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void persistPendingHistory() {
        long offsetMillis = 0;
        Object r2 = this.mOnDiskLock;
        monitor-enter(r2);
        Object r3 = this.mInMemoryLock;     // Catch: Throwable -> L15
        monitor-enter(r3);     // Catch: Throwable -> L15
        List<AppOpsManager.HistoricalOps> pendingWrites = new ArrayList(this.mPendingWrites);     // Catch: Throwable -> L9
        this.mPendingWrites.clear();     // Catch: Throwable -> L9
        if (this.mPendingHistoryOffsetMillis == 0) goto L11;
        offsetMillis = this.mPendingHistoryOffsetMillis;     // Catch: Throwable -> L9
        this.mPendingHistoryOffsetMillis = 0;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r3);     // Catch: Throwable -> L9
    L13:
        if (offsetMillis == 0) goto L17;
        resampleHistoryOnDiskInMemoryDMLocked(offsetMillis);     // Catch: Throwable -> L15
    L17:
        persistPendingHistory(pendingWrites);     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        this.mDiscreteRegistry.writeAndClearOldAccessHistory();
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private void persistPendingHistory(List<AppOpsManager.HistoricalOps> pendingWrites) {
        Object r0 = this.mOnDiskLock;
        monitor-enter(r0);
        IoThread.getHandler().removeMessages(1);     // Catch: Throwable -> L8
        if (pendingWrites.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int opCount = pendingWrites.size();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= opCount) goto L16;
        AppOpsManager.HistoricalOps current = pendingWrites.get(i);     // Catch: Throwable -> L8
        if (i <= 0) goto L15;
        AppOpsManager.HistoricalOps previous = pendingWrites.get(i - 1);     // Catch: Throwable -> L8
        current.offsetBeginAndEndTime(previous.getBeginTimeMillis());     // Catch: Throwable -> L8
    L15:
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L16:
        this.mPersistence.persistHistoricalOpsDLocked(pendingWrites);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void schedulePersistHistoricalOpsMLocked(AppOpsManager.HistoricalOps ops) {
        Message message = PooledLambda.obtainMessage(new LegacyHistoricalRegistry$$ExternalSyntheticLambda0(), this);
        message.what = 1;
        IoThread.getHandler().sendMessage(message);
        this.mPendingWrites.offerFirst(ops);
    }

    private static void makeRelativeToEpochStart(AppOpsManager.HistoricalOps ops, long nowMillis) {
        ops.setBeginAndEndTime(nowMillis - ops.getEndTimeMillis(), nowMillis - ops.getBeginTimeMillis());
    }

    private void pruneFutureOps(List<AppOpsManager.HistoricalOps> ops) {
        int opCount = ops.size();
        int i = opCount - 1;
    L3:
        if (i < 0) goto L12;
        AppOpsManager.HistoricalOps op = ops.get(i);
        if (op.getEndTimeMillis() > this.mBaseSnapshotInterval) goto L8;
        ops.remove(i);
    L10:
        i = i - 1;
        goto L3
    L8:
        if (op.getBeginTimeMillis() >= this.mBaseSnapshotInterval) goto L10;
        double filterScale = (op.getEndTimeMillis() - this.mBaseSnapshotInterval) / op.getDurationMillis();
        Persistence.m1825$$Nest$smspliceFromBeginning(op, filterScale);
        goto L10
    }

    private static void wtf(String message, Throwable t, File storage) {
        Slog.wtf(LOG_TAG, message, t);
        if (KEEP_WTF_LOG == true) goto L27;
        return;
    L27:
        File file = new File(new File(Environment.getDataSystemDirectory(), "appops"), "wtf" + TimeUtils.formatForLogging(System.currentTimeMillis()));     // Catch: IOException -> L18
        if (file.createNewFile() == false) goto L32;
        PrintWriter writer = new PrintWriter(file);     // Catch: IOException -> L18
        if (t != null) goto L30;
    L12:
        writer.append('\n').append(Debug.getCallers(10));     // Catch: Throwable -> L10
        if (storage == null) goto L15;
        writer.append("\nfiles: " + Arrays.toString(storage.listFiles()));     // Catch: Throwable -> L10
    L16:
        writer.close();     // Catch: IOException -> L18
        return;
    L15:
        writer.append("\nfiles: none");     // Catch: Throwable -> L10
        goto L16
    L30:
        writer.append('\n').append(t.toString());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        writer.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: IOException -> L18
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L18
        goto L24
    L32:
        return;
    }
}
