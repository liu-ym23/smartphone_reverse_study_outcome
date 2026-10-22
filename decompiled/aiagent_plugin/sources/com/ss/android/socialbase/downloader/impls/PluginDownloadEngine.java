package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class PluginDownloadEngine {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private static final String MONITOR_SCENE = "morpheus_plugin_download";
    private static final String TAG = "PluginDownloadEngine";
    private static volatile PluginDownloadEngine mInstance;
    private AbsDownloadEngine mDownloadEngine;
    private Queue<PluginInfo> mDownloadingPluginQueue;
    private Map<Integer, Future> mFutureTaskRecords;
    private AtomicInteger mIndex;
    private ThreadPoolExecutor mPluginExecutor;
    private int mPluginPoolSize;
    private ThreadPoolExecutor mSingleOPExecutor;
    private Queue<PluginInfo> mWaitingPluginQueue;

    private class PluginInfo {
        DownloadTask mDownloadTask;
        int mId;
        int mIndex;
        int mType;
        final /* synthetic */ PluginDownloadEngine this$0;

        private PluginInfo(PluginDownloadEngine r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PluginInfo(PluginDownloadEngine r1, AnonymousClass1 r2) {
            this(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L15:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L15;
            PluginInfo r6 = (PluginInfo) ZeusTransformUtils.preCheckCast(r5, PluginInfo.class, "com.obric.aiagent.plugin");
            if (this.mId != r6.mId) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mId)});
        }

        public String toString() {
            return "PluginInfo{type=" + this.mType + ", index=" + this.mIndex + ", id=" + this.mId + '}';
        }
    }

    static /* synthetic */ Map access$000(PluginDownloadEngine r0) {
        return r0.mFutureTaskRecords;
    }

    static /* synthetic */ void access$100(PluginDownloadEngine r0, int r1) {
        r0.tryDownloadNext(r1);
    }

    static /* synthetic */ ThreadPoolExecutor access$200(PluginDownloadEngine r0) {
        return r0.mSingleOPExecutor;
    }

    static /* synthetic */ int access$300(PluginDownloadEngine r0, PluginInfo r1, PluginInfo r2) {
        return r0.compareImpl(r1, r2);
    }

    static /* synthetic */ Queue access$400(PluginDownloadEngine r0) {
        return r0.mDownloadingPluginQueue;
    }

    static /* synthetic */ Queue access$500(PluginDownloadEngine r0) {
        return r0.mWaitingPluginQueue;
    }

    static /* synthetic */ void access$600(PluginDownloadEngine r0, int r1, int r2, DownloadTask r3, DownloadInfo r4) {
        r0.downloadImpl(r1, r2, r3, r4);
    }

    private PluginDownloadEngine() {
        this.mPluginPoolSize = getPluginThreadPoolSize();
        final int r3 = this.mPluginPoolSize;
        final TimeUnit r6 = TimeUnit.SECONDS;
        final LinkedBlockingQueue r7 = new LinkedBlockingQueue();
        final DefaultThreadFactory r8 = new DefaultThreadFactory("DownloadThreadPool-plugin", true);
        final long r4 = 15;
        this.mPluginExecutor = new AnonymousClass1(this, r3, r3, r4, r6, r7, r8);
        final TimeUnit r9 = TimeUnit.SECONDS;
        final LinkedBlockingQueue r10 = new LinkedBlockingQueue();
        final DefaultThreadFactory r11 = new DefaultThreadFactory("DownloadThreadPool-plugin-single", true);
        final int r2 = 1;
        final int r5 = 1;
        final long r12 = 30;
        this.mSingleOPExecutor = new AnonymousClass2(this, r2, r5, r12, r9, r10, r11);
        this.mDownloadEngine = DownloadComponentManager.getDownloadEngine();
        this.mDownloadingPluginQueue = new PriorityQueue(11, new AnonymousClass3(this));
        this.mWaitingPluginQueue = new PriorityQueue(11, new AnonymousClass4(this));
        this.mIndex = new AtomicInteger();
        this.mFutureTaskRecords = new HashMap();
    }

    public static PluginDownloadEngine getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(PluginDownloadEngine.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new PluginDownloadEngine();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PluginDownloadEngine.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private int compareImpl(PluginInfo r2, PluginInfo r3) {
        int r1 = Integer.compare(r2.mType, r3.mType);
        if (r1 == 0) goto L6;
        return r1;
    L6:
        if (r2.mType != EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L10;
        return Integer.compare(r3.mIndex, r2.mIndex);
    L10:
        return Integer.compare(r2.mIndex, r3.mIndex);
    }

    public void download(final DownloadTask r3) {
        this.mSingleOPExecutor.execute(new AnonymousClass5(this, r3));
    }

    public ExecutorService getPluginExecutor() {
        return this.mPluginExecutor;
    }

    private void downloadImpl(int r7, int r8, DownloadTask r9, DownloadInfo r10) {
        PluginInfo r0 = findPlugin(this.mDownloadingPluginQueue, r7);
        if (r0 != null) goto L5;
        PluginInfo r1 = findPlugin(this.mWaitingPluginQueue, r7);
        AnonymousClass1 r5 = null;
        if (this.mDownloadingPluginQueue.size() >= this.mPluginPoolSize) goto L43;
        if (this.mWaitingPluginQueue.isEmpty() == true) goto L19;
    L27:
        if (r1 != null) goto L29;
        PluginInfo r11 = new PluginInfo(this, r5);
        r11.mId = r7;
        r11.mType = r8;
        r11.mIndex = this.mIndex.incrementAndGet();
        r11.mDownloadTask = r9;
        this.mWaitingPluginQueue.add(r11);
        return;
    L29:
        if (r8 != EnqueueType.NEW_ENQUEUE_IMMEDIATE.ordinal()) goto L38;
        if (r1.mType != EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L33;
        r1.mType = r8;
    L34:
        this.mWaitingPluginQueue.remove(r1);
        this.mWaitingPluginQueue.add(r1);
        if (Logger.debugScene(r10) == false) goto L69;
        Logger.taskDebug(TAG, r10, "getPluginState", "Update Waiting Queue");
        return;
    L69:
        return;
    L33:
        r1.mIndex = this.mIndex.incrementAndGet();
        goto L34
    L38:
        if (Logger.debugScene(r10) == false) goto L71;
        Logger.taskDebug(TAG, r10, "getPluginState", "In Waiting Queue");
        return;
    L71:
        return;
    L19:
        if (this.mFutureTaskRecords.containsKey(Integer.valueOf(r9.getDownloadId())) == true) goto L27;
        PluginInfo r2 = new PluginInfo(this, r5);
        r2.mId = r7;
        r2.mType = r8;
        r2.mIndex = this.mIndex.incrementAndGet();
        r2.mDownloadTask = r9;
        this.mDownloadingPluginQueue.add(r2);
        if (Logger.debugScene(r10) == false) goto L23;
        Logger.taskDebug(TAG, r10, "getPluginState", "New doDownload");
    L23:
        Future r12 = this.mDownloadEngine.doDownload(r9);
        if (r12 == null) goto L68;
        this.mFutureTaskRecords.put(Integer.valueOf(r9.getDownloadId()), r12);
        return;
    L68:
        return;
    L43:
        if (r1 != null) goto L45;
        PluginInfo r3 = new PluginInfo(this, r5);
        r3.mId = r7;
        r3.mType = r8;
        r3.mIndex = this.mIndex.incrementAndGet();
        r3.mDownloadTask = r9;
        if (r8 == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L58;
        PluginInfo r13 = (PluginInfo) ZeusTransformUtils.preCheckCast(this.mDownloadingPluginQueue.poll(), PluginInfo.class, "com.obric.aiagent.plugin");
        this.mWaitingPluginQueue.add(r13);
        this.mWaitingPluginQueue.add(r3);
        if (Logger.debugScene(r10) == false) goto L64;
        Logger.taskDebug(TAG, r10, "getPluginState", "Pause:" + r13.mId + " Add WaitingQueue");
    L64:
        this.mDownloadEngine.doPause(r13.mDownloadTask.getDownloadId());
        return;
    L58:
        if (Logger.debugScene(r10) == false) goto L60;
        Logger.taskDebug(TAG, r10, "getPluginState", "Add WaitingQueue");
    L60:
        this.mWaitingPluginQueue.add(r3);
        return;
    L45:
        if (r8 == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L47;
        r1.mType = r8;
        r1.mIndex = this.mIndex.incrementAndGet();
        this.mWaitingPluginQueue.remove(r1);
        this.mWaitingPluginQueue.add(r1);
        PluginInfo r14 = (PluginInfo) ZeusTransformUtils.preCheckCast(this.mDownloadingPluginQueue.poll(), PluginInfo.class, "com.obric.aiagent.plugin");
        this.mWaitingPluginQueue.add(r14);
        if (Logger.debugScene(r10) == false) goto L53;
        Logger.taskDebug(TAG, r10, "getPluginState", "Pause:" + r14.mId + " Move WaitingQueue");
    L53:
        this.mDownloadEngine.doPause(r14.mDownloadTask.getDownloadId());
        return;
    L47:
        if (Logger.debugScene(r10) == false) goto L73;
        Logger.taskDebug(TAG, r10, "getPluginState", "In WaitingQueue wait");
        return;
    L73:
        return;
    L5:
        if (r8 == EnqueueType.NEW_ENQUEUE_IMMEDIATE.ordinal()) goto L7;
        return;
    L7:
        if (r0.mType != EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L9;
        r0.mType = r8;
    L10:
        this.mDownloadingPluginQueue.remove(r0);
        this.mDownloadingPluginQueue.add(r0);
        if (Logger.debugScene(r10) == false) goto L67;
        Logger.taskDebug(TAG, r10, "getPluginState", "In DownloadingQueue reorder");
        return;
    L67:
        return;
    L9:
        r0.mIndex = this.mIndex.incrementAndGet();
        goto L10
    }

    private PluginInfo findPlugin(Collection<PluginInfo> r3, int r4) {
        Iterator r2 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        PluginInfo r5 = (PluginInfo) ZeusTransformUtils.preCheckCast(r2.next(), PluginInfo.class, "com.obric.aiagent.plugin");
        if (r5.mId != r4) goto L4;
        return r5;
    L8:
        return null;
    }

    private void tryDownloadNext(int r10) {
        PluginInfo r0 = new PluginInfo(this, null);
        r0.mId = r10;
        this.mDownloadingPluginQueue.remove(r0);
        if (this.mDownloadingPluginQueue.size() >= this.mPluginPoolSize) goto L5;
        PluginInfo r1 = (PluginInfo) ZeusTransformUtils.preCheckCast(this.mWaitingPluginQueue.poll(), PluginInfo.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L11;
        Logger.taskDebug(TAG, r10, MONITOR_SCENE, "tryDownloadNext", "Remove " + r10 + " Try doDownload:" + r1, false);
    L11:
        if (r1 != null) goto L14;
        return;
    L14:
        if (this.mFutureTaskRecords.containsKey(Integer.valueOf(r1.mId)) == false) goto L19;
        this.mWaitingPluginQueue.add(r1);
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L24;
        Logger.taskDebug(TAG, r10, MONITOR_SCENE, "tryDownloadNext", "Task is running", false);
        return;
    L24:
        return;
    L19:
        this.mDownloadingPluginQueue.add(r1);
        Future r11 = this.mDownloadEngine.doDownload(r1.mDownloadTask);
        if (r11 == null) goto L25;
        this.mFutureTaskRecords.put(Integer.valueOf(r1.mDownloadTask.getDownloadId()), r11);
        return;
    L25:
        return;
    L5:
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L23;
        Logger.taskDebug(TAG, r10, MONITOR_SCENE, "tryDownloadNext", "DownloadingPluginQueue full", false);
        return;
    }

    private int getPluginThreadPoolSize() {
        int r2 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.PLUGIN_THREAD_POOL_SIZE, 2);
        if (r2 > 0) goto L6;
        return 2;
    L6:
        return r2;
    }

    public static boolean isEnabledDownloadPluginOpt(DownloadInfo r2) {
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.ENABLE_PLUGIN_DOWNLOAD_OPT) > 0) goto L5;
    L9:
        return false;
    L5:
        if (r2.getEnqueueType() != EnqueueType.NEW_ENQUEUE_NORMAL) goto L7;
    L8:
        return true;
    L7:
        if (r2.getEnqueueType() != EnqueueType.NEW_ENQUEUE_IMMEDIATE) goto L9;
        goto L8
    }
}
