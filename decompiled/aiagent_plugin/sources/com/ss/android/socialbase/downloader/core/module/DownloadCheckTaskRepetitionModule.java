package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadCheckTaskRepetitionModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckTaskRepetitionModule";
    private static Set mDownloadingIdSet;
    private static Object mLock;

    public DownloadCheckTaskRepetitionModule() {
    }

    static {
        mLock = new Object();
        mDownloadingIdSet = new HashSet();
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r3) {
        if (r3.mSetting.optInt(DownloadSettingKeys.FIX_TASK_REPETITION) > 0) goto L5;
        return null;
    L5:
        return super.init(r3);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r4) {
        IDownloadModuleChain r5 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        int r3 = this.mDownloadInfo.getId();
        Object r0 = mLock;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (mDownloadingIdSet.contains(Integer.valueOf(r3)) == false) goto L9;
        Logger.taskError(TAG, r3, "proceed", "Repetitive task");     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        return;
    L9:
        mDownloadingIdSet.add(Integer.valueOf(r3));     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        r5.proceed();     // Catch: Throwable -> L20
        Object r6 = mLock;
        monitor-enter(r6);
        mDownloadingIdSet.remove(Integer.valueOf(r3));     // Catch: Throwable -> L17
        monitor-exit(r6);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L20:
        th = move-exception;
        monitor-enter(mLock);
        mDownloadingIdSet.remove(Integer.valueOf(r3));     // Catch: Throwable -> L26
        throw th;
    L26:
        th = move-exception;
        throw th;
    }
}
