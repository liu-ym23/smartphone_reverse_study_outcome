package com.ss.android.socialbase.downloader.core;

import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadModuleChain implements IDownloadModuleChain {
    private DownloadCommonParams mCommonParams;
    private List<IDownloadModule> mDownloadModules;
    private int mIndex;
    private volatile boolean mStartDownload;

    public DownloadModuleChain(DownloadCommonParams r2) {
        this.mDownloadModules = new CopyOnWriteArrayList();
        this.mStartDownload = false;
        this.mCommonParams = r2;
    }

    public DownloadModuleChain addDownloadModule(IDownloadModule r3) {
        IDownloadModule r4 = ((IDownloadModule) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadModule.class, "com.obric.aiagent.plugin")).init(this.mCommonParams);
        if (r4 != null) goto L5;
        return this;
    L5:
        this.mDownloadModules.add(r4);
        return this;
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModuleChain
    public void proceed() {
        if (this.mIndex != this.mDownloadModules.size()) goto L5;
        return;
    L5:
        IDownloadModule r0 = (IDownloadModule) ZeusTransformUtils.preCheckCast(this.mDownloadModules.get(this.mIndex), IDownloadModule.class, "com.obric.aiagent.plugin");
        this.mIndex++;
        r0.proceed(this);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModuleChain
    public void onDownloadStart() {
        this.mStartDownload = true;
    }

    public void pause() {
        Iterator<IDownloadModule> r3 = this.mDownloadModules.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((IDownloadModule) ZeusTransformUtils.preCheckCast(r3.next(), IDownloadModule.class, "com.obric.aiagent.plugin")).pause();
        goto L4
    }

    public void cancel() {
        Iterator<IDownloadModule> r3 = this.mDownloadModules.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((IDownloadModule) ZeusTransformUtils.preCheckCast(r3.next(), IDownloadModule.class, "com.obric.aiagent.plugin")).cancel();
        goto L4
    }

    public void setThrottleNetSpeed(long r4, int r6) {
        Iterator<IDownloadModule> r3 = this.mDownloadModules.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((IDownloadModule) ZeusTransformUtils.preCheckCast(r3.next(), IDownloadModule.class, "com.obric.aiagent.plugin")).setThrottleNetSpeed(r4, r6);
        goto L4
    }

    public void reset() {
        this.mIndex = 0;
        this.mCommonParams.mHasRunNetworkModule = false;
    }

    public boolean isStartDownload() {
        return this.mStartDownload;
    }
}
