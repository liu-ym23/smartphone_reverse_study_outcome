package com.bytedance.apm6.disk;

import android.app.Application;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.android.contacts.ContactsUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.listener.IStorageCheckListener;
import com.bytedance.apm.util.TopK;
import com.bytedance.apm6.disk.config.DiskConfig;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DiskStatistics {
    private static final String EXTERNAL_PREFIX = "external";
    private static final long FACTOR_1024 = 1024;
    private static final String INTERNAL_PREFIX = "internal";
    private static final long MAX_STORAGE_CHECK_VALUE_BYTES = 17179869184L;
    private static final long MIN_OUTDATE_FILE_SIZE_BYTES = 102400;
    private static final String OUTSIDE_STORAGE = "/Android/data/";
    private static final String PERF_DISK_FILE_NAME = "name";
    private static final String PERF_DISK_FILE_NUM = "num";
    private static final String PERF_DISK_FILE_SIZE = "size";
    private static final long SHORT_UNIT = 1000;
    private static DiskStatistics instance;
    private List<String> compliancePaths;
    private DiskConfig config;
    private List<String> customCollectPaths;
    private List<String> ignoredPaths;
    private volatile boolean initException;
    private boolean inited;
    private String insideCachePath;
    private long insideCacheSize;
    private String insideDataPath;
    private long insideDataSize;
    private IStorageCheckListener listener;
    private String outsideCachePath;
    private long outsideCacheSize;
    private String outsideDataPath;
    private long outsideDataSize;

    /* JADX INFO: renamed from: com.bytedance.apm6.disk.DiskStatistics$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class DiskInfoNode {
        public static final String TYPE_CUSTOM = "custom";
        public static final String TYPE_NORMAL = "normal";
        public boolean isFolder;
        public List<DiskInfoNode> nextDisk;
        public String path;
        public String reportType;
        public long size;
        public float sizeRate;
        final /* synthetic */ DiskStatistics this$0;

        private DiskInfoNode(DiskStatistics r1) {
            this.this$0 = r1;
            this.reportType = "normal";
            this.nextDisk = new ArrayList();
        }

        /* synthetic */ DiskInfoNode(DiskStatistics r1, AnonymousClass1 r2) {
            this(r1);
        }

        public JSONObject toJson() {
            JSONObject r0 = new JSONObject();
            r0.put("path", parsePath());     // Catch: JSONException -> L11
            r0.put("size", this.size);     // Catch: JSONException -> L11
            r0.put("size_rate", this.sizeRate);     // Catch: JSONException -> L11
            r0.put("is_folder", this.isFolder);     // Catch: JSONException -> L11
            r0.put("report_type", this.reportType);     // Catch: JSONException -> L11
            if (this.nextDisk.isEmpty() == true) goto L13;
            JSONArray r1 = new JSONArray();     // Catch: JSONException -> L11
            Iterator<DiskInfoNode> r4 = this.nextDisk.iterator();     // Catch: JSONException -> L11
        L7:
            if (r4.hasNext() == false) goto L9;
            r1.put(r4.next().toJson());     // Catch: JSONException -> L11
            goto L7
        L9:
            r0.put("next_disk", r1);     // Catch: JSONException -> L11
        L13:
            return r0;
        L11:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }

        private String parsePath() {
            String r0 = this.path;
            String r1 = DiskStatistics.access$700(this.this$0, r0);
            if (r1 == null) goto L6;
            r0 = r1;
        L6:
            if (r0.contains(DiskStatistics.access$800(this.this$0)) == false) goto L9;
            return r0.replace(DiskStatistics.access$800(this.this$0), DiskStatistics.INTERNAL_PREFIX);
        L9:
            if (r0.contains(DiskStatistics.access$900(this.this$0)) == true) goto L11;
            return r0;
        L11:
            return r0.replace(DiskStatistics.access$900(this.this$0), DiskStatistics.EXTERNAL_PREFIX);
        }
    }

    private class FileNode implements Comparable {
        private int num;
        private String path;
        public long size;
        final /* synthetic */ DiskStatistics this$0;

        static /* synthetic */ String access$100(FileNode r0) {
            return r0.path;
        }

        public FileNode(DiskStatistics r1) {
            this.this$0 = r1;
        }

        public FileNode(DiskStatistics r1, String r2, long r3, int r5) {
            this.this$0 = r1;
            this.path = r2;
            this.size = r3;
            this.num = r5;
        }

        public JSONObject toJSON() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
            r0.put("name", parsePath());     // Catch: Exception -> L6
            r0.put("size", this.size);     // Catch: Exception -> L6
            int r4 = this.num;     // Catch: Exception -> L6
            if (r4 <= 0) goto L5;
            r0.put("num", r4);     // Catch: Exception -> L6
        L5:
            return r0;
        L6:
            return null;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r4) {
            long r0 = this.size;
            long r3 = ((FileNode) r4).size;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 <= r3) goto L10;
            return 1;
        L10:
            return -1;
        }

        private String parsePath() {
            String r0 = this.path;
            String r1 = DiskStatistics.access$700(this.this$0, r0);
            if (r1 == null) goto L6;
            r0 = r1;
        L6:
            if (r0.contains(DiskStatistics.access$800(this.this$0)) == false) goto L9;
            return r0.replace(DiskStatistics.access$800(this.this$0), DiskStatistics.INTERNAL_PREFIX);
        L9:
            if (r0.contains(DiskStatistics.access$900(this.this$0)) == true) goto L11;
            return r0;
        L11:
            return r0.replace(DiskStatistics.access$900(this.this$0), DiskStatistics.EXTERNAL_PREFIX);
        }
    }

    private class Node {
        private int childAccuCount;
        private int childCount;
        private boolean isChildExceedThreshold;
        private boolean isOutdated;
        private long outdateInterval;
        public Node parent;
        private String path;
        public long size;
        final /* synthetic */ DiskStatistics this$0;

        private Node(DiskStatistics r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Node(DiskStatistics r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ String access$000(Node r0) {
            return r0.path;
        }

        static /* synthetic */ String access$002(Node r0, String r1) {
            r0.path = r1;
            return r1;
        }

        static /* synthetic */ int access$302(Node r0, int r1) {
            r0.childCount = r1;
            return r1;
        }

        static /* synthetic */ int access$310(Node r2) {
            int r0 = r2.childCount;
            r2.childCount = r0 - 1;
            return r0;
        }

        static /* synthetic */ boolean access$400(Node r0) {
            return r0.isOutdated;
        }

        static /* synthetic */ boolean access$402(Node r0, boolean r1) {
            r0.isOutdated = r1;
            return r1;
        }

        static /* synthetic */ long access$502(Node r0, long r1) {
            r0.outdateInterval = r1;
            return r1;
        }

        public boolean isFull() {
            if (this.childAccuCount != this.childCount) goto L5;
            return true;
        L5:
            return false;
        }

        public void appendChildInfo(long r9, TopK<FileNode> r11, TopK<FileNode> r12) {
            this.size += r9;
            this.childAccuCount++;
            if (this.parent != null) goto L5;
            return;
        L5:
            if (isFull() == true) goto L7;
            return;
        L7:
            if (this.isChildExceedThreshold == false) goto L10;
            this.parent.isChildExceedThreshold = true;
        L10:
            if (this.size >= DiskStatistics.access$1000(this.this$0).getFolderThresholdBytes()) goto L12;
        L17:
            this.parent.appendChildInfo(this.size, r11, r12);
            if (this.isOutdated == true) goto L20;
            return;
        L20:
            if (this.this$0.isOutdatedFileSizeValid(this.size) == false) goto L26;
            DiskStatistics r1 = this.this$0;
            String r2 = this.path;
            long r3 = this.size;
            int r5 = this.childCount;
            r11.add(new OutdatedNode(r1, r2, r3, r5, r5));
            return;
        L26:
            return;
        L12:
            if (this.isChildExceedThreshold == true) goto L17;
            if (DiskStatistics.access$1100(this.this$0, this.size) == true) goto L16;
            r12.add(new FileNode(this.this$0, this.path, this.size, this.childCount));
        L16:
            this.parent.isChildExceedThreshold = true;
            goto L17
        }
    }

    private class OutdatedNode extends FileNode {
        private int num;
        private long outdatedInterval;
        private final String path;
        public long size;
        final /* synthetic */ DiskStatistics this$0;

        public OutdatedNode(DiskStatistics r1, String r2, long r3, int r5, long r6) {
            this.this$0 = r1;
            super(r1);
            this.path = r2;
            this.size = r3;
            this.num = r5;
            this.outdatedInterval = r6;
        }

        @Override // com.bytedance.apm6.disk.DiskStatistics.FileNode
        public JSONObject toJSON() {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
            r0.put("name", parsePath());     // Catch: Exception -> L7
            r0.put("size", this.size);     // Catch: Exception -> L7
            int r1 = this.num;     // Catch: Exception -> L7
            if (r1 <= 0) goto L5;
            r0.put("num", r1);     // Catch: Exception -> L7
        L5:
            r0.put(PerfConsts.PERF_DISK_FILE_OUTDATE_INTERVAL, this.outdatedInterval);     // Catch: Exception -> L7
            return r0;
        L7:
            return null;
        }

        @Override // com.bytedance.apm6.disk.DiskStatistics.FileNode, java.lang.Comparable
        public int compareTo(Object r4) {
            long r0 = this.outdatedInterval;
            long r3 = ((OutdatedNode) r4).outdatedInterval;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 <= r3) goto L10;
            return 1;
        L10:
            return -1;
        }

        private String parsePath() {
            String r0 = this.path;
            String r1 = DiskStatistics.access$700(this.this$0, r0);
            if (r1 == null) goto L6;
            r0 = r1;
        L6:
            if (r0.contains(DiskStatistics.access$800(this.this$0)) == false) goto L9;
            return r0.replace(DiskStatistics.access$800(this.this$0), DiskStatistics.INTERNAL_PREFIX);
        L9:
            if (r0.contains(DiskStatistics.access$900(this.this$0)) == true) goto L11;
            return r0;
        L11:
            return r0.replace(DiskStatistics.access$900(this.this$0), DiskStatistics.EXTERNAL_PREFIX);
        }
    }

    private boolean isOutOfMaxCheckSize(long r3) {
        if (r3 >= 0) goto L5;
    L8:
        return true;
    L5:
        if (r3 > MAX_STORAGE_CHECK_VALUE_BYTES) goto L8;
        return false;
    }

    boolean isOutdatedFileSizeValid(long r3) {
        if (r3 >= 104857600) goto L5;
    L7:
        return false;
    L5:
        if (r3 > MAX_STORAGE_CHECK_VALUE_BYTES) goto L7;
        return true;
    }

    static /* synthetic */ DiskConfig access$1000(DiskStatistics r0) {
        return r0.config;
    }

    static /* synthetic */ boolean access$1100(DiskStatistics r0, long r1) {
        return r0.isOutOfMaxCheckSize(r1);
    }

    static /* synthetic */ String access$700(DiskStatistics r0, String r1) {
        return r0.getCompliancePath(r1);
    }

    static /* synthetic */ String access$800(DiskStatistics r0) {
        return r0.insideDataPath;
    }

    static /* synthetic */ String access$900(DiskStatistics r0) {
        return r0.outsideDataPath;
    }

    static {
        instance = new DiskStatistics();
    }

    private DiskStatistics() {
        this.initException = false;
        this.insideDataSize = 0;
        this.outsideDataSize = 0;
        this.insideCacheSize = 0;
        this.outsideCacheSize = 0;
    }

    public static DiskStatistics getInstance() {
        return instance;
    }

    DiskReportEvent collect(DiskConfig r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (this.initException == false) goto L8;
        return null;
    L8:
        this.config = r3;
        initPaths();
        this.ignoredPaths = toAbsolutePath(r3.getIgnoredRelativePaths());
        this.customCollectPaths = toAbsolutePath(r3.getCustomRelativePaths());
        this.compliancePaths = toAbsolutePath(r3.getComplianceRelativePaths());
        return calculate();
    }

    public void setListener(IStorageCheckListener r1) {
        this.listener = r1;
    }

    private DiskReportEvent calculate() {
        ArrayList r0 = new ArrayList();
        calculateFirstLevelDiskInfo(new File(this.insideDataPath), r0);
        calculateFirstLevelDiskInfo(new File(this.outsideDataPath), r0);
        ArrayList r1 = new ArrayList();
        Iterator<DiskInfoNode> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        DiskInfoNode r3 = r2.next();
        Iterator<DiskInfoNode> r4 = r3.nextDisk.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        if (r4.next().isFolder == false) goto L7;
        boolean r5 = false;
    L12:
        if (r5 == false) goto L4;
        r1.remove(r3);
        goto L4
    L11:
        r5 = true;
        goto L12
    L14:
        r0.removeAll(r1);
        if (ApmContext.isDebugMode() == false) goto L20;
        Iterator<DiskInfoNode> r6 = r0.iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        Logger.d(Constants.TAG, "diskInfoNodes:" + r6.next().toJson());
    L20:
        TopK<FileNode> r7 = new TopK(this.config.getReportMaxTopCount());
        TopK<FileNode> r8 = new TopK(this.config.getReportExceptionDirMaxCount());
        TopK<FileNode> r10 = new TopK(this.config.getReportMaxOutdatedCount());
        List<String> r11 = new ArrayList();
        r11.add(this.insideDataPath);
        r11.add(this.insideCachePath);
        calculateDiskTotalSize(calculateDiskTopK(this.insideDataPath, r7, r8, r10, r11));
        r11.clear();
        r11.add(this.outsideCachePath);
        r11.add(this.outsideDataPath);
        calculateDiskTotalSize(calculateDiskTopK(this.outsideDataPath, r7, r8, r10, r11));
        if (ApmContext.isDebugMode() == false) goto L35;
        Iterator r9 = r7.sortedList().iterator();
    L24:
        if (r9.hasNext() == false) goto L26;
        Logger.d(Constants.TAG, "fileListTopK:" + ((FileNode) r9.next()).toJSON());
        goto L24
    L26:
        Iterator r12 = r8.sortedList().iterator();
    L28:
        if (r12.hasNext() == false) goto L30;
        Logger.d(Constants.TAG, "dirListTopK:" + ((FileNode) r12.next()).toJSON());
        goto L28
    L30:
        Iterator r13 = r10.sortedList().iterator();
    L32:
        if (r13.hasNext() == false) goto L34;
        Logger.d(Constants.TAG, "outdatedListTopK:" + ((FileNode) r13.next()).toJSON());
        goto L32
    L34:
        Logger.d(Constants.TAG, "insideDataSize:" + this.insideDataSize + " outsideDataSize:" + this.outsideDataSize + " insideCacheSize:" + this.insideCacheSize + " outsideCacheSize:" + this.outsideCacheSize);
    L35:
        calculateCustomDiskInfo(r0);
        return createReportEvent(r7, r8, r10, r0);
    }

    private void calculateDiskTotalSize(List<Node> r4) {
        if (ListUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        Iterator<Node> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L20;
        Node r0 = r5.next();
        if (TextUtils.equals(Node.access$000(r0), this.insideDataPath) == true) goto L10;
        if (TextUtils.equals(Node.access$000(r0), this.outsideDataPath) == true) goto L13;
        if (TextUtils.equals(Node.access$000(r0), this.insideCachePath) == true) goto L16;
        if (TextUtils.equals(Node.access$000(r0), this.outsideCachePath) == false) goto L7;
        this.outsideCacheSize = r0.size;
        goto L7
    L16:
        this.insideCacheSize = r0.size;
        goto L7
    L13:
        this.outsideDataSize = r0.size;
        goto L7
    L10:
        this.insideDataSize = r0.size;
        goto L7
    }

    private DiskReportEvent createReportEvent(TopK<FileNode> r30, TopK<FileNode> r31, TopK<FileNode> r32, List<DiskInfoNode> r33) {
        long r9 = this.insideDataSize + this.outsideDataSize;     // Catch: Throwable -> L14
        long r4 = this.insideCacheSize + this.outsideCacheSize;     // Catch: Throwable -> L14
        long r13 = Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace();     // Catch: Throwable -> L14
        long r15 = Environment.getDataDirectory().getFreeSpace();     // Catch: Throwable -> L14
        long r11 = Math.min(r9, MAX_STORAGE_CHECK_VALUE_BYTES);     // Catch: Throwable -> L14
        long r5 = Math.min(r4, MAX_STORAGE_CHECK_VALUE_BYTES);     // Catch: Throwable -> L14
        if (r11 >= 0) goto L7;
        return null;
    L7:
        if (this.listener == null) goto L9;
        this.listener.onDetectException(this.config.getDiskThresholdBytes(), r11, convertFileNodeList(r30), convertFileNodeList(r31), convertFileNodeList(r32));     // Catch: Throwable -> L14
    L9:
        Pair<Long, Long> r6 = getPhoneStorage();     // Catch: Throwable -> L14
        long r7 = getAppUsage();     // Catch: Throwable -> L14
        if (ApmContext.isDebugMode() == false) goto L12;
        Logger.d(Constants.TAG, "appUsage:" + r7);     // Catch: Throwable -> L14
    L12:
        return new DiskReportEvent(r9, r5, r13, r15, r7, ((Long) r6.first).longValue(), ((Long) r6.second).longValue(), getRate(r7, new BigDecimal(r13)), createJSONArray(r30), createJSONArray(r31), createJSONArray(r32), createDiskInfo(r33, r11));
    L14:
        th = move-exception;
        Log.e(Constants.TAG, "error", th);
        return null;
    }

    private Pair<Long, Long> getPhoneStorage() {
        StorageStatsManager r9 = (StorageStatsManager) ApmContext.getContext().getSystemService("storagestats");     // Catch: Throwable -> L12
        StorageManager r0 = (StorageManager) ApmContext.getContext().getSystemService("storage");     // Catch: Throwable -> L12
        Iterator<StorageVolume> r1 = r0.getStorageVolumes().iterator();     // Catch: Throwable -> L12
        long r2 = 0;
        long r4 = 0;
    L4:
        if (r1.hasNext() == false) goto L10;
        String r6 = r1.next().getUuid();     // Catch: Throwable -> L12
        if (r6 != null) goto L8;
        UUID r7 = StorageManager.UUID_DEFAULT;     // Catch: Throwable -> L12
    L9:
        r2 = r2 + r9.getTotalBytes(r7);     // Catch: Throwable -> L12
        r4 = r4 + r0.getAllocatableBytes(r7);     // Catch: Throwable -> L12
        goto L4
    L8:
        r7 = UUID.fromString(r6);     // Catch: Throwable -> L12
        goto L9
    L10:
        return new Pair(Long.valueOf((((r2 / 1000) / 1000) * 1024) * 1024), Long.valueOf((((r4 / 1000) / 1000) * 1024) * 1024));
    L13:
        return new Pair(Long.valueOf(FileUtils.getTotalStorageSize(Environment.getDataDirectory().getPath()) + FileUtils.getTotalStorageSize(Environment.getRootDirectory().getPath())), Long.valueOf(FileUtils.getAvailableStorage(Environment.getDataDirectory().getPath())));
    }

    private static Method reflectHideMethod(Class r7, String r8, Class<?>... r9) {
        Method r10 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9});     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return r10;
    L4:
        return null;
    }

    private long getAppUsage() {
        Application r2 = ApmContext.getContext();     // Catch: Throwable -> L8
        String r3 = r2.getPackageName();     // Catch: Throwable -> L8
        StorageStats r4 = ((StorageStatsManager) r2.getSystemService("storagestats")).queryStatsForUid(((StorageManager) r2.getSystemService("storage")).getUuidForPath(new File(r2.getDataDir().getParent(), r3)), r2.getPackageManager().getApplicationInfo(r3, 128).uid);     // Catch: Throwable -> L8
        if (ApmContext.isDebugMode() == false) goto L6;
        Log.e(Constants.TAG, "storageStats.getAppBytes():" + r4.getAppBytes());     // Catch: Throwable -> L8
    L6:
        return r4.getAppBytes();
    L8:
        long r5 = getFolderSize(new File(ApmContext.getContext().getPackageManager().getApplicationInfo(ApmContext.getContext().getPackageName(), 0).sourceDir).getParentFile());     // Catch: Exception -> L14
        if (ApmContext.isDebugMode() == false) goto L11;
        Log.e(Constants.TAG, "storageStats.getAppBytes():" + (((getMediaDirLength() + r5) + this.insideDataSize) + this.outsideDataSize));     // Catch: Exception -> L14
    L11:
        return ((r5 + getMediaDirLength()) + this.insideDataSize) + this.outsideDataSize;
    L14:
        return 0;
    }

    private long getMediaDirLength() {
        File[] r0 = ApmContext.getContext().getApplicationContext().getExternalMediaDirs();
        int r1 = r0.length;
        long r2 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        r2 = r2 + getFolderSize(r0[r4]);
        r4 = r4 + 1;
        goto L3
    L5:
        return r2;
    }

    private JSONArray createDiskInfo(List<DiskInfoNode> r7, long r8) {
        if (r7 != null) goto L4;
        return null;
    L4:
        if (r7.isEmpty() == true) goto L36;
        BigDecimal r0 = new BigDecimal(r8);
        JSONArray r9 = new JSONArray();
        Iterator<DiskInfoNode> r10 = r7.iterator();
    L7:
        if (r10.hasNext() == false) goto L24;
        DiskInfoNode r11 = r10.next();
        if (isIgnoredNode(r11) == false) goto L11;
        r11.sizeRate = 0.0f;
    L12:
        List<DiskInfoNode> r1 = r11.nextDisk;
        if (r1 == null) goto L23;
        if (r1.size() <= 0) goto L23;
        Iterator<DiskInfoNode> r2 = r1.iterator();
    L18:
        if (r2.hasNext() == false) goto L23;
        DiskInfoNode r3 = r2.next();
        if (isIgnoredNode(r3) == true) goto L21;
        r3.sizeRate = getRate(r3.size, r0);
        goto L18
    L21:
        r3.sizeRate = 0.0f;
    L23:
        r9.put(r11.toJson());
        goto L7
    L11:
        r11.sizeRate = getRate(r11.size, r0);
        goto L12
    L24:
        return r9;
    L36:
        return null;
    }

    private float getRate(long r1, BigDecimal r3) {
        return (float) new BigDecimal(r1).divide(r3, 4, 4).doubleValue();
    }

    private boolean isIgnoredNode(DiskInfoNode r3) {
        Iterator<String> r2 = this.ignoredPaths.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        String r0 = r2.next();
        if (r3.path.contains(r0) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private List<String> toAbsolutePath(List<String> r5) {
        ArrayList r0 = new ArrayList();
        if (ListUtils.isEmpty(r5) == false) goto L5;
        return r0;
    L5:
        Iterator<String> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L14;
        String r1 = r6.next();
        if (r1.contains(INTERNAL_PREFIX) == true) goto L10;
        if (r1.contains(EXTERNAL_PREFIX) == false) goto L7;
        r0.add(r1.replace(EXTERNAL_PREFIX, this.outsideDataPath));
        goto L7
    L10:
        r0.add(r1.replace(INTERNAL_PREFIX, this.insideDataPath));
        goto L7
    L14:
        return r0;
    }

    private static List<String> convertFileNodeList(TopK<? extends FileNode> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        LinkedList r0 = new LinkedList();
        Iterator r3 = r2.sortedList().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.add(FileNode.access$100((FileNode) r3.next()));
        goto L7
    L9:
        return r0;
    }

    JSONArray createJSONArray(TopK<FileNode> r2) {
        JSONArray r1 = new JSONArray();
        Iterator r3 = r2.sortedList().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        JSONObject r0 = ((FileNode) r3.next()).toJSON();
        if (r0 == null) goto L4;
        r1.put(r0);
        goto L4
    L8:
        return r1;
    }

    private List<Node> calculateDiskTopK(String r23, TopK<FileNode> r24, TopK<FileNode> r25, TopK<FileNode> r26, List<String> r27) {
        List<String> r11 = r27;
        ArrayList r12 = new ArrayList();
        File r1 = new File(r23);
        AnonymousClass1 r13 = null;
        Node r2 = new Node(this, r13);
        Node.access$002(r2, r23);
        r2.parent = new Node(this, r13);
        File[] r0 = r1.listFiles();
        if (r0 == null) goto L69;
        if (r0.length == 0) goto L69;
        if (r11.contains(r1.getAbsolutePath()) == false) goto L10;
        r12.add(r2);
        r11.remove(r1.getAbsolutePath());
    L10:
        Node.access$302(r2, r0.length);
        LinkedList r14 = new LinkedList();
        r14.offer(r2);
    L12:
        if (r14.isEmpty() == true) goto L67;
        int r15 = r14.size();
        int r6 = 0;
    L14:
        if (r6 >= r15) goto L12;
        Node r7 = (Node) r14.poll();
        if (r7 != null) goto L18;
        r27 = r11;
        ArrayList r3 = r12;
        LinkedList r16 = r14;
        int r17 = r15;
        r6 = r6;
    L65:
        r6 = r6 + 1;
        r12 = r3;
        r14 = r16;
        r15 = r17;
        r11 = r27;
        goto L14
    L18:
        String r5 = Node.access$000(r7);
        File r4 = new File(r5);
        if (r4.exists() == true) goto L21;
    L64:
        r27 = r11;
        r3 = r12;
        r16 = r14;
        r17 = r15;
        r6 = r6;
        Node.access$310(r7.parent);
        goto L65
    L21:
        if (isIgnored(r4) == true) goto L64;
        if (r4.isFile() == false) goto L42;
        r16 = r14;
        long r18 = r4.length();
        if (isOutOfMaxCheckSize(r18) == true) goto L30;
        r24.add(new FileNode(this, r5, r18, 1));
    L30:
        if (r7.parent != null) goto L32;
        r6 = r6;
    L41:
        r17 = r15;
        r3 = r12;
        goto L65
    L32:
        r7.parent.appendChildInfo(r18, r26, r25);
        if (Node.access$400(r7.parent) == true) goto L41;
        long r20 = getOutOfDateInterval(r4.lastModified());
        if (r20 <= 0) goto L41;
        if (isOutdatedFileSizeValid(r18) == false) goto L41;
        r26.add(new OutdatedNode(this, r5, r15, 0, r20));
        goto L41
    L42:
        ArrayList r19 = r12;
        LinkedList r28 = r14;
        r6 = r6;
        r27 = r27;
        if (r27.contains(r4.getAbsolutePath()) == false) goto L45;
        r3 = r19;
        r3.add(r7);
        r27.remove(r4.getAbsolutePath());
    L46:
        File[] r8 = r4.listFiles();
        if (r8 != null) goto L49;
    L63:
        r16 = r28;
        r17 = r15;
        r7.parent.appendChildInfo(0, r26, r25);
        goto L65
    L49:
        if (r8.length == 0) goto L63;
        Node.access$302(r7, r8.length);
        int r9 = r8.length;
        int r10 = 0;
    L52:
        if (r10 >= r9) goto L62;
        File r110 = r8[r10];
        Node r111 = new Node(this, null);
        r111.parent = r7;
        Node.access$002(r111, r110.getAbsolutePath());
        if (r110.isDirectory() == true) goto L56;
    L60:
        int r112 = r15;
    L61:
        LinkedList r113 = r28;
        r113.offer(r111);
        r10 = r10 + 1;
        r28 = r113;
        r15 = r112;
        goto L52
    L56:
        if (Node.access$400(r7) == true) goto L60;
        r112 = r15;
        long r114 = getOutOfDateInterval(r110.lastModified());
        if (r114 <= 0) goto L61;
        Node.access$402(r111, true);
        Node.access$502(r111, r114);
        goto L61
    L62:
        r16 = r28;
        r17 = r15;
        goto L65
    L45:
        r3 = r19;
        goto L46
    L67:
        return r12;
    L69:
        return null;
    }

    private void calculateCustomDiskInfo(List<DiskInfoNode> r4) {
        if (ListUtils.isEmpty(this.customCollectPaths) == false) goto L5;
        return;
    L5:
        Iterator<String> r0 = this.customCollectPaths.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        calculateCustomDiskInfo(new File(r0.next()), r4);
        goto L7
    }

    private void initPaths() {
        if (this.inited == false) goto L5;
        return;
    L5:
        this.inited = true;
        Application r1 = ApmContext.getContext();
        r1.getPackageName();     // Catch: Exception -> L10
        this.insideDataPath = r1.getFilesDir().getParent();     // Catch: Exception -> L10
        this.insideCachePath = r1.getCacheDir().getAbsolutePath();     // Catch: Exception -> L10
        this.outsideDataPath = getExternalDir(r1);     // Catch: Exception -> L10
        File r2 = r1.getExternalCacheDir();     // Catch: Exception -> L10
        if (r2 == null) goto L14;
        this.outsideCachePath = r2.getAbsolutePath();     // Catch: Exception -> L10
        return;
    L14:
        return;
    L10:
        this.initException = true;
    }

    private String getExternalDir(Context r1) {
        return r1.getExternalFilesDir(null).getParentFile().getAbsolutePath();
    L8:
        return null;
    }

    private void calculateFirstLevelDiskInfo(File r4, List<DiskInfoNode> r5) {
        File[] r6 = r4.listFiles();
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length == 0) goto L12;
        int r0 = r6.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L13;
        calculateDiskInfo(r6[r1], r5);
        r1 = r1 + 1;
        goto L8
    L13:
        return;
    }

    private String getCompliancePath(String r3) {
        String r2 = findFirstCompliancePath(r3);
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return null;
    L6:
        return r2 + r3.substring(r2.length()).replaceAll("[^/]", ContactsUtils.CHAR_STAR);
    L7:
        return null;
    }

    private long calculateDiskInfo(File r9, List<DiskInfoNode> r10) {
        long r0 = 0;
        if (r9 != null) goto L5;
    L33:
        return r0;
    L5:
        if (r9.exists() == false) goto L33;
        if (isIgnored(r9) == true) goto L33;
        int r3 = 0;
        AnonymousClass1 r4 = null;
        if (r9.isFile() == false) goto L16;
        long r1 = r9.length();
        if (r1 >= this.config.getFileThresholdBytes()) goto L14;
        return r1;
    L14:
        DiskInfoNode r2 = new DiskInfoNode(this, r4);
        r2.isFolder = false;
        r2.path = r9.getAbsolutePath();
        r2.size = r1;
        r10.add(r2);
        return r1;
    L16:
        File[] r5 = r9.listFiles();
        if (r5 == null) goto L33;
        if (r5.length == 0) goto L33;
        DiskInfoNode r6 = new DiskInfoNode(this, r4);
        r6.isFolder = r9.isDirectory();
        r6.path = r9.getAbsolutePath();
        ArrayList r11 = new ArrayList();
        r6.nextDisk = r11;
        r10.add(r6);
        int r12 = r5.length;
    L22:
        if (r3 >= r12) goto L32;
        File r7 = r5[r3];
        if (r7 == null) goto L31;
        if (r7.exists() == false) goto L31;
        if (isIgnored(r7) == true) goto L31;
        r0 = r0 + calculateDiskInfo(r7, r11);
    L31:
        r3 = r3 + 1;
        goto L22
    L32:
        r6.size = r0;
        goto L33
    }

    private void calculateCustomDiskInfo(File r6, List<DiskInfoNode> r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.exists() == true) goto L6;
        return;
    L6:
        if (isIgnored(r6) == true) goto L16;
        AnonymousClass1 r2 = null;
        if (r6.isFile() == false) goto L12;
        long r3 = r6.length();
        DiskInfoNode r0 = new DiskInfoNode(this, r2);
        r0.isFolder = false;
        r0.path = r6.getAbsolutePath();
        r0.size = r3;
        r0.reportType = "custom";
        r7.add(r0);
        return;
    L12:
        DiskInfoNode r1 = new DiskInfoNode(this, r2);
        r1.isFolder = true;
        r1.reportType = "custom";
        r1.path = r6.getAbsolutePath();
        r1.size = getFolderSize(r6);
        r7.add(r1);
        return;
    }

    private boolean isIgnored(File r2) {
        if (ListUtils.isEmpty(this.ignoredPaths) == false) goto L5;
        return false;
    L5:
        return this.ignoredPaths.contains(r2.getAbsolutePath());
    }

    private String findFirstCompliancePath(String r3) {
        if (ListUtils.isEmpty(this.compliancePaths) == true) goto L11;
        if (r3 == null) goto L16;
        Iterator<String> r2 = this.compliancePaths.iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        String r0 = r2.next();
        if (r3.startsWith(r0) == false) goto L7;
        return r0;
    L17:
        return null;
    L16:
        return null;
    L11:
        return null;
    }

    private long getOutOfDateInterval(long r3) {
        long r0 = System.currentTimeMillis() - r3;
        if (r0 >= this.config.getOutdatedIntervalMs()) goto L5;
        return 0;
    L5:
        if (r0 >= 62899200000L) goto L9;
        return r0;
    L9:
        return 0;
    }

    private long getFolderSize(File r7) {
        long r0 = 0;
        File[] r8 = r7.listFiles();     // Catch: Exception -> L16
        if (r8 != null) goto L6;
    L15:
        return 0;
    L6:
        if (r8.length == 0) goto L15;
        int r2 = r8.length;     // Catch: Exception -> L16
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L18;
        File r4 = r8[r3];     // Catch: Exception -> L16
        if (r4.isDirectory() == false) goto L13;
        long r5 = getFolderSize(r4);     // Catch: Exception -> L16
    L14:
        r0 = r0 + r5;
        r3 = r3 + 1;
        goto L9
    L13:
        r5 = r4.length();     // Catch: Exception -> L16
    L18:
        return r0;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }
}
