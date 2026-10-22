package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes4.dex */
public class CleanerImpl {
    private static final String TAG = "CleanerImpl";
    private Map<Integer, List<Integer>> mCleanCacheKeyMaps;
    private Semaphore mCleanCompletedSem;
    private CleanerConfig mCleanerConfig;
    private volatile boolean mIsStop;

    static /* synthetic */ boolean access$002(CleanerImpl r0, boolean r1) {
        r0.mIsStop = r1;
        return r1;
    }

    static /* synthetic */ void access$100(CleanerImpl r0) {
        r0.startClean();
    }

    public CleanerImpl(CleanerConfig r3) {
        this.mCleanCompletedSem = new Semaphore(0);
        this.mIsStop = false;
        this.mCleanerConfig = r3;
        this.mCleanCacheKeyMaps = r3.getCleanCacheKeyMaps();
    }

    public void startSync() {
        if (this.mCleanerConfig.isNoCacheNeedClean() == true) goto L12;
        if (this.mCleanCacheKeyMaps.isEmpty() == true) goto L12;
        long r3 = System.currentTimeMillis();
        Detecter r0 = new Detecter(new AnonymousClass1(this));
        r0.start();
        startClean();
        this.mCleanCompletedSem.acquire();
        r0.stop();
        if (Logger.debug() == false) goto L15;
        Logger.globalDebug(TAG, "startSync", "clear all cache end---cost time=" + (System.currentTimeMillis() - r3));
        return;
    L15:
        return;
    L12:
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "startSync", "CleanCacheKeyMaps Empty");
        return;
    }

    private void startClean() {
        if (this.mIsStop == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, List<Integer>>> r3 = this.mCleanCacheKeyMaps.entrySet().iterator();
    L42:
    L33:
        th = move-exception;
        if (Logger.debug() == false) goto L38;
        th.printStackTrace();
    L38:
        if (Logger.debug() == false) goto L40;
        Logger.globalDebug(TAG, "startClean", "clean completed!");
    L40:
        this.mCleanCompletedSem.release();
        return;
    L7:
        if (r3.hasNext() == false) goto L38;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L33
        Iterator r6 = ((List) ZeusTransformUtils.preCheckCast(r4.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L33
    L10:
        if (r6.hasNext() == false) goto L31;
        if (this.mIsStop == true) goto L14;
        int r7 = ((Integer) ZeusTransformUtils.preCheckCast(r6.next(), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L33
        if (this.mCleanerConfig.isExistInCleanSet(r7) == false) goto L21;
        DownloadUtils.clearDownloadFile(this.mCleanerConfig.getSavePath(r7), this.mCleanerConfig.getTempSavePath(r7), this.mCleanerConfig.getName(r7));     // Catch: Throwable -> L33
        if (this.mCleanerConfig.isOnlyCleanFile(r7) == true) goto L28;
        DownloadComponentManager.getDownloadCache().removeDownloadTaskData(r7);     // Catch: Throwable -> L33
    L28:
        if (Logger.debug() == false) goto L30;
        Logger.globalDebug(TAG, "startClean", "clean cache downloadId=" + r7);     // Catch: Throwable -> L33
    L30:
        r6.remove();     // Catch: Throwable -> L33
        this.mCleanerConfig.removeFromCleanDownloadIdSet(r7);     // Catch: Throwable -> L33
        goto L10
    L21:
        if (Logger.debug() == false) goto L23;
        Logger.globalDebug(TAG, "startClean", "dwg888Find in visit history,can't do clean,downloadId=" + r7);     // Catch: Throwable -> L33
    L23:
        r6.remove();     // Catch: Throwable -> L33
        goto L10
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "startClean", "stop cleaning");     // Catch: Throwable -> L33
    L16:
        this.mIsStop = false;     // Catch: Throwable -> L33
        return;
    L31:
        r3.remove();     // Catch: Throwable -> L33
        this.mCleanerConfig.updateCleanSetting(r5);     // Catch: Throwable -> L33
        goto L42
    }
}
