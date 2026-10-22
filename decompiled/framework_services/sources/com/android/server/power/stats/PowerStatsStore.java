package com.android.server.power.stats;

import android.os.BatteryUsageStats;
import android.os.FileUtils;
import android.os.Handler;
import android.util.AtomicFile;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
public class PowerStatsStore {
    private static final String DIR_LOCK_FILENAME = ".lock";
    private static final long MAX_POWER_STATS_SPAN_STORAGE_BYTES = 102400;
    private static final String POWER_STATS_DIR = "power-stats";
    private static final String POWER_STATS_SPAN_FILE_EXTENSION = ".pss";
    private static final String TAG = "PowerStatsStore";
    private final ReentrantLock mFileLock;
    private final Handler mHandler;
    private FileLock mJvmLock;
    private final File mLockFile;
    private final long mMaxStorageBytes;
    private final Map<String, PowerStatsSpan.SectionReader> mSectionReaders;
    private final File mStoreDir;
    private final File mSystemDir;
    private volatile List<PowerStatsSpan.Metadata> mTableOfContents;

    /* JADX INFO: renamed from: $r8$lambda$55fOWVXVllJ2LR3V-23W75q3gH0, reason: not valid java name */
    public static /* synthetic */ void m7846$r8$lambda$55fOWVXVllJ2LR3V23W75q3gH0(PowerStatsStore r0, long r1, BatteryUsageStats r3) {
        r0.lambda$storeBatteryUsageStatsAsync$2(r1, r3);
    }

    public static /* synthetic */ void $r8$lambda$B2PF4qXDAYWwxqhYeVyGoe0li4E(PowerStatsStore r0) {
        r0.maybeClearLegacyStore();
    }

    /* JADX INFO: renamed from: $r8$lambda$dH-UczunvrzRifb4k-bj8u6NTCU, reason: not valid java name */
    public static /* synthetic */ void m7847$r8$lambda$dHUczunvrzRifb4kbj8u6NTCU(PowerStatsSpan r0, FileOutputStream r1) {
        lambda$storePowerStatsSpan$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$lZFwWJVHGsl5p44v-hX6-z05sXQ, reason: not valid java name */
    public static /* synthetic */ void m7848$r8$lambda$lZFwWJVHGsl5p44vhX6z05sXQ(PowerStatsStore r0, PowerStatsSpan r1, Runnable r2) {
        r0.lambda$storePowerStatsSpanAsync$0(r1, r2);
    }

    public PowerStatsStore(File systemDir, Handler handler) {
        this(systemDir, MAX_POWER_STATS_SPAN_STORAGE_BYTES, handler);
    }

    public PowerStatsStore(File systemDir, long maxStorageBytes, Handler handler) {
        this.mFileLock = new ReentrantLock();
        this.mSectionReaders = new HashMap();
        this.mSystemDir = systemDir;
        this.mStoreDir = new File(systemDir, POWER_STATS_DIR);
        this.mLockFile = new File(this.mStoreDir, DIR_LOCK_FILENAME);
        this.mHandler = handler;
        this.mMaxStorageBytes = maxStorageBytes;
        this.mHandler.post(new PowerStatsStore$$ExternalSyntheticLambda1(this));
    }

    public void addSectionReader(PowerStatsSpan.SectionReader sectionReader) {
        this.mSectionReaders.put(sectionReader.getType(), sectionReader);
    }

    public List<PowerStatsSpan.Metadata> getTableOfContents() {
        List<PowerStatsSpan.Metadata> toc = this.mTableOfContents;
        if (toc == null) goto L5;
        return toc;
    L5:
        TypedXmlPullParser parser = Xml.newBinaryPullParser();
        lockStoreDirectory();
        List<PowerStatsSpan.Metadata> toc2 = new ArrayList();     // Catch: Throwable -> L20
        File[] r3 = this.mStoreDir.listFiles();     // Catch: Throwable -> L20
        int r4 = r3.length;     // Catch: Throwable -> L20
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L32;
        File file = r3[r5];     // Catch: Throwable -> L20
        String fileName = file.getName();     // Catch: Throwable -> L20
        if (fileName.endsWith(POWER_STATS_SPAN_FILE_EXTENSION) == false) goto L31;
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));     // Catch: Throwable -> L20 Throwable -> L22
        parser.setInput(inputStream, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L15
        PowerStatsSpan.Metadata metadata = PowerStatsSpan.Metadata.read(parser);     // Catch: Throwable -> L15
        if (metadata == null) goto L17;
        toc2.add(metadata);     // Catch: Throwable -> L15
    L18:
        inputStream.close();     // Catch: Throwable -> L20 Throwable -> L22 Throwable -> L22
        goto L31
    L17:
        Slog.e(TAG, "Removing incompatible PowerStatsSpan file: " + fileName);     // Catch: Throwable -> L15
        file.delete();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        inputStream.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L20 Throwable -> L22 Throwable -> L22
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L20 Throwable -> L22 Throwable -> L22
    L30:
        Slog.wtf(TAG, "Cannot read PowerStatsSpan file: " + fileName);     // Catch: Throwable -> L20
    L31:
        r5 = r5 + 1;     // Catch: Throwable -> L20
        goto L7
    L32:
        toc2.sort(PowerStatsSpan.Metadata.COMPARATOR);     // Catch: Throwable -> L20
        this.mTableOfContents = Collections.unmodifiableList(toc2);     // Catch: Throwable -> L20
        unlockStoreDirectory();
        return toc2;
    L20:
        th = move-exception;
        unlockStoreDirectory();
        throw th;
    }

    public void storePowerStatsSpanAsync(final PowerStatsSpan span, final Runnable onComplete) {
        this.mHandler.post(new PowerStatsStore$$ExternalSyntheticLambda0(this, span, onComplete));
    }

    private /* synthetic */ void lambda$storePowerStatsSpanAsync$0(PowerStatsSpan span, Runnable onComplete) {
        storePowerStatsSpan(span);     // Catch: Throwable -> L5
        onComplete.run();
        return;
    L5:
        th = move-exception;
        onComplete.run();
        throw th;
    }

    public void storePowerStatsSpan(final PowerStatsSpan span) {
        lockStoreDirectory();
    L11:
        th = move-exception;
        unlockStoreDirectory();
        throw th;
    L5:
        if (this.mStoreDir.exists() == false) goto L7;
    L13:
        AtomicFile file = new AtomicFile(makePowerStatsSpanFilename(span.getId()));     // Catch: Throwable -> L11
        file.write(new PowerStatsStore$$ExternalSyntheticLambda2(span));     // Catch: Throwable -> L11 RuntimeException -> L19
    L16:
        this.mTableOfContents = null;     // Catch: Throwable -> L11
        removeOldSpansLocked();     // Catch: Throwable -> L11
        unlockStoreDirectory();
        return;
    L19:
        e = move-exception;
        if (isCausedByIOException(e) == false) goto L26;
        Slog.e(TAG, "Cannot store PowerStatsSpan " + span.getId(), e);     // Catch: Throwable -> L11
        unlockStoreDirectory();
        return;
    L26:
        throw e;     // Catch: Throwable -> L11
    L7:
        if (this.mStoreDir.mkdirs() == true) goto L13;
        Slog.e(TAG, "Could not create a directory for power stats store");     // Catch: Throwable -> L11
        unlockStoreDirectory();
    }

    private static /* synthetic */ void lambda$storePowerStatsSpan$1(PowerStatsSpan span, FileOutputStream out) {
        span.writeXml(out, Xml.newBinarySerializer());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public PowerStatsSpan loadPowerStatsSpan(long id, String... sectionTypes) {
        TypedXmlPullParser parser = Xml.newBinaryPullParser();
        lockStoreDirectory();
        File file = makePowerStatsSpanFilename(id);     // Catch: Throwable -> L13
        if (file.exists() == true) goto L33;
        unlockStoreDirectory();
        return null;
    L33:
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));     // Catch: Throwable -> L13 Throwable -> L15
        PowerStatsSpan r4 = PowerStatsSpan.read(inputStream, parser, this.mSectionReaders, sectionTypes);     // Catch: Throwable -> L17
        inputStream.close();     // Catch: Throwable -> L13 Throwable -> L15 Throwable -> L15
        unlockStoreDirectory();
        return r4;
    L17:
        th = move-exception;
        inputStream.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Throwable -> L13 Throwable -> L15 Throwable -> L15
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13 Throwable -> L15 Throwable -> L15
    L15:
        e = move-exception;
        Slog.wtf(TAG, "Cannot read PowerStatsSpan file: " + file, e);     // Catch: Throwable -> L13
        unlockStoreDirectory();
        return null;
    L13:
        th = move-exception;
        unlockStoreDirectory();
        throw th;
    }

    public void storeBatteryUsageStatsAsync(final long monotonicStartTime, final BatteryUsageStats batteryUsageStats) {
        if (this.mHandler.getLooper().isCurrentThread() == false) goto L5;
        storeBatteryUsageStats(monotonicStartTime, batteryUsageStats);
        return;
    L5:
        this.mHandler.post(new PowerStatsStore$$ExternalSyntheticLambda3(this, monotonicStartTime, batteryUsageStats));
    }

    private /* synthetic */ void lambda$storeBatteryUsageStatsAsync$2(long monotonicStartTime, BatteryUsageStats batteryUsageStats) {
        storeBatteryUsageStats(monotonicStartTime, batteryUsageStats);
    }

    private void storeBatteryUsageStats(long monotonicStartTime, BatteryUsageStats batteryUsageStats) {
        PowerStatsSpan span = new PowerStatsSpan(monotonicStartTime);     // Catch: Throwable -> L13
        span.addTimeFrame(monotonicStartTime, batteryUsageStats.getStatsStartTimestamp(), batteryUsageStats.getStatsDuration());     // Catch: Throwable -> L11
        span.addSection(new BatteryUsageStatsSection(batteryUsageStats));     // Catch: Throwable -> L11
        storePowerStatsSpan(span);     // Catch: Throwable -> L11
        batteryUsageStats.close();     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Cannot close BatteryUsageStats", e);
        return;
    L11:
        th = move-exception;
        Throwable r11 = th;
    L22:
        batteryUsageStats.close();     // Catch: IOException -> L17
        throw r11;
    L17:
        e = move-exception;
        Slog.e(TAG, "Cannot close BatteryUsageStats", e);
        throw r11;
    L13:
        th = move-exception;
        r11 = th;
        goto L22
    }

    private File makePowerStatsSpanFilename(long id) {
        return new File(this.mStoreDir, String.format(Locale.ENGLISH, "%019d", new Object[]{Long.valueOf(id)}) + POWER_STATS_SPAN_FILE_EXTENSION);
    }

    private void maybeClearLegacyStore() {
        File legacyStoreDir = new File(this.mSystemDir, BatteryUsageStatsSection.TYPE);
        if (legacyStoreDir.exists() == false) goto L6;
        FileUtils.deleteContentsAndDir(legacyStoreDir);
        return;
    }

    private void lockStoreDirectory() {
        this.mFileLock.lock();
    L6:
        e = move-exception;
        Slog.e(TAG, "Cannot lock snapshot directory", e);
        return;
    L4:
        if (this.mLockFile.exists() == true) goto L8;
        this.mLockFile.getParentFile().mkdirs();     // Catch: IOException -> L6
        this.mLockFile.createNewFile();     // Catch: IOException -> L6
    L8:
        this.mJvmLock = FileChannel.open(this.mLockFile.toPath(), new OpenOption[]{StandardOpenOption.WRITE}).lock();     // Catch: IOException -> L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.concurrent.locks.ReentrantLock] */
    /* JADX WARN: Type inference failed for: r0v4 */
    private void unlockStoreDirectory() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            r0 = 0
            java.nio.channels.FileLock r1 = r4.mJvmLock     // Catch: java.lang.Throwable -> L14 java.io.IOException -> L16
            if (r1 == 0) goto L18
            java.nio.channels.FileLock r1 = r4.mJvmLock     // Catch: java.lang.Throwable -> L14 java.io.IOException -> L16
            java.nio.channels.Channel r1 = r1.acquiredBy()     // Catch: java.lang.Throwable -> L14 java.io.IOException -> L16
            java.nio.channels.FileLock r2 = r4.mJvmLock     // Catch: java.lang.Throwable -> L14 java.io.IOException -> L16
            r2.release()     // Catch: java.lang.Throwable -> L14 java.io.IOException -> L16
            r1.close()     // Catch: java.lang.Throwable -> L14 java.io.IOException -> L16
            goto L18
        L14:
            r1 = move-exception
            goto L2c
        L16:
            r1 = move-exception
            goto L21
        L18:
        L19:
            r4.mJvmLock = r0
            java.util.concurrent.locks.ReentrantLock r0 = r4.mFileLock
            r0.unlock()
            goto L2b
        L21:
            java.lang.String r2 = "PowerStatsStore"
            java.lang.String r3 = "Cannot unlock snapshot directory"
            android.util.Slog.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L14
            goto L19
        L2b:
            return
        L2c:
            r4.mJvmLock = r0
            java.util.concurrent.locks.ReentrantLock r0 = r4.mFileLock
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.power.stats.PowerStatsStore.unlockStoreDirectory():void");
    }

    private static boolean isCausedByIOException(Throwable throwable) {
    L2:
        if (throwable == null) goto L8;
        if ((throwable instanceof IOException) == true) goto L5;
        throwable = throwable.getCause();
        goto L2
    L5:
        return true;
    L8:
        return false;
    }

    private void removeOldSpansLocked() {
        long totalSize = 0;
        TreeMap<File, Long> mFileSizes = new TreeMap();
        File[] r3 = this.mStoreDir.listFiles();
        int r4 = r3.length;
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L10;
        File file = r3[r5];
        long fileSize = file.length();
        totalSize = totalSize + fileSize;
        if (file.getName().endsWith(POWER_STATS_SPAN_FILE_EXTENSION) == false) goto L8;
        mFileSizes.put(file, Long.valueOf(fileSize));
    L8:
        r5 = r5 + 1;
    L10:
        if (totalSize <= this.mMaxStorageBytes) goto L18;
        Map.Entry<File, Long> entry = mFileSizes.firstEntry();
        if (entry == null) goto L26;
        File file2 = entry.getKey();
        if (file2.delete() == true) goto L17;
        Slog.e(TAG, "Cannot delete power stats span " + file2);
    L17:
        totalSize = totalSize - entry.getValue().longValue();
        mFileSizes.remove(file2);
        this.mTableOfContents = null;
        goto L10
    L26:
        return;
    }

    public void reset() {
        lockStoreDirectory();
        File[] r0 = this.mStoreDir.listFiles();     // Catch: Throwable -> L10
        int r1 = r0.length;     // Catch: Throwable -> L10
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L13;
        File file = r0[r2];     // Catch: Throwable -> L10
        if (file.getName().endsWith(POWER_STATS_SPAN_FILE_EXTENSION) == false) goto L12;
        if (file.delete() == true) goto L12;
        Slog.e(TAG, "Cannot delete power stats span " + file);     // Catch: Throwable -> L10
    L12:
        r2 = r2 + 1;     // Catch: Throwable -> L10
        goto L4
    L13:
        this.mTableOfContents = List.of();     // Catch: Throwable -> L10
        unlockStoreDirectory();
        return;
    L10:
        th = move-exception;
        unlockStoreDirectory();
        throw th;
    }

    public void dumpTableOfContents(IndentingPrintWriter ipw) {
        ipw.println("Power stats store TOC");
        ipw.increaseIndent();
        List<PowerStatsSpan.Metadata> contents = getTableOfContents();
        Iterator<PowerStatsSpan.Metadata> r1 = contents.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        PowerStatsSpan.Metadata metadata = r1.next();
        metadata.dump(ipw);
        goto L4
    L6:
        ipw.decreaseIndent();
    }

    public void dump(IndentingPrintWriter ipw) {
        ipw.println("Power stats store");
        ipw.increaseIndent();
        List<PowerStatsSpan.Metadata> contents = getTableOfContents();
        Iterator<PowerStatsSpan.Metadata> r1 = contents.iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        PowerStatsSpan.Metadata metadata = r1.next();
        PowerStatsSpan span = loadPowerStatsSpan(metadata.getId(), new String[0]);
        if (span != null) goto L22;
    L15:
        if (span == null) goto L4;
        span.close();
        goto L4
    L22:
        span.dump(ipw);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        span.close();     // Catch: Throwable -> L12
    L14:
        throw th;
    L12:
        th = move-exception;
        th.addSuppressed(th);
        goto L14
    L18:
        ipw.decreaseIndent();
    }
}
