package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class IndependentDownloadServiceHandler extends AbsDownloadServiceHandler implements ServiceConnection {
    private static final String TAG = "IndependentDownloadServiceHandler";
    private IDownloadAidlService aidlService;
    private IDownloadServiceConnectionListener connectionListener;
    private int logLevel;

    static {
    }

    public IndependentDownloadServiceHandler() {
        this.logLevel = -1;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startService(Context r4, ServiceConnection r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        ServiceConnection r6 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r5, ServiceConnection.class, "com.obric.aiagent.plugin");
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "startService", "BindService");     // Catch: Throwable -> L11
    L6:
        Intent r7 = new Intent(r3, IndependentProcessDownloadService.class);     // Catch: Throwable -> L11
        if (r6 == null) goto L9;
        ZeusTransformUtils.bindService(r3, r7, r6, 1, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
    L9:
        ZeusTransformUtils.startService(r3, r7, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void stopService(Context r5, ServiceConnection r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        ServiceConnection r8 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r6, ServiceConnection.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "stopService", "Run");
    L5:
        this.isServiceAlive = false;
        Intent r4 = new Intent(r7, IndependentProcessDownloadService.class);
        if (r8 == null) goto L8;
        ZeusTransformUtils.unbindService(r7, r8, "com.obric.aiagent.plugin");
    L8:
        ZeusTransformUtils.stopService(r7, r4, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public IBinder onBind(Intent r2) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "onBind", "IndependentDownloadBinder");
    L6:
        return new IndependentDownloadBinder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownload(DownloadTask r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L12;
        String r0 = TAG;
        int r1 = r5.getDownloadId();
        StringBuilder r2 = new StringBuilder().append("AidlService == null:");
        if (this.aidlService != null) goto L9;
        boolean r3 = true;
    L10:
        Logger.taskDebug(r0, r1, "tryDownload", r2.append(r3).toString());
        goto L12
    L9:
        r3 = false;
    L12:
        if (this.aidlService != null) goto L14;
        pendDownloadTask(r5);
        startService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this);
        return;
    L14:
        resumePendingTaskForIndependent();
        this.aidlService.tryDownload(IPCUtils.convertDownloadTaskToAidl(r5));     // Catch: RemoteException -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    private void resumePendingTaskForIndependent() {
        SparseArray<List<DownloadTask>> r0 = this.pendingTasks;     // Catch: Throwable -> L29
        monitor-enter(r0);     // Catch: Throwable -> L29
        SparseArray<List<DownloadTask>> r1 = this.pendingTasks.clone();     // Catch: Throwable -> L26
        this.pendingTasks.clear();     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.size() > 0) goto L10;
        return;
    L10:
        if (DownloadComponentManager.getDownloadEngine() == null) goto L45;
        int r2 = 0;
    L13:
        if (r2 >= r1.size()) goto L46;
        List r3 = (List) ZeusTransformUtils.preCheckCast(r1.get(r1.keyAt(r2)), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (r3 == null) goto L25;
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L29
    L18:
        if (r4.hasNext() == false) goto L25;
        this.aidlService.tryDownload(IPCUtils.convertDownloadTaskToAidl((DownloadTask) ZeusTransformUtils.preCheckCast(r4.next(), DownloadTask.class, "com.obric.aiagent.plugin")));     // Catch: RemoteException -> L22 Throwable -> L29
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
    L25:
        r2 = r2 + 1;
        goto L13
    L46:
        return;
    L45:
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Logger.globalError(TAG, "resumePendingTaskForIndependent", "Exception:" + th);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownloadWithEngine(DownloadTask r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        DownloadProcessDispatcher.getInstance().setDownloadWithIndependentProcessStatus(r3.getDownloadId(), true);
        AbsDownloadEngine r2 = DownloadComponentManager.getDownloadEngine();
        if (r2 == null) goto L8;
        r2.tryDownload(r3);
        return;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r5, IBinder r6) {
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "onServiceConnected", "Run");
    L5:
        this.aidlService = IDownloadAidlService.Stub.asInterface(r7);
        IDownloadServiceConnectionListener r8 = this.connectionListener;
        if (r8 == null) goto L9;
        r8.onServiceConnection(r7);
    L9:
        if (Logger.debug() == false) goto L16;
        String r9 = TAG;
        StringBuilder r2 = new StringBuilder().append("AidlService!=null");
        if (this.aidlService == null) goto L13;
        boolean r3 = true;
    L14:
        Logger.globalDebug(r9, "onServiceConnected", r2.append(r3).append(" pendingTasks.size:").append(this.pendingTasks.size()).toString());
        goto L16
    L13:
        r3 = false;
    L16:
        if (this.aidlService == null) goto L29;
        DownloadProcessDispatcher.getInstance().dispatchDownloaderProcessConnectedEvent();
        this.isServiceAlive = true;
        this.isInvokeStartService.set(false);
        int r10 = this.logLevel;
        if (r10 == (-1)) goto L24;
        this.aidlService.setLogLevel(r10);     // Catch: RemoteException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        if (this.aidlService == null) goto L30;
        resumePendingTaskForIndependent();
        return;
    L30:
        return;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r3) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "onServiceDisconnected", "Run");
    L5:
        this.aidlService = null;
        this.isServiceAlive = false;
        IDownloadServiceConnectionListener r2 = this.connectionListener;
        if (r2 == null) goto L9;
        r2.onServiceDisConnection();
        return;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName r1) {
        this.aidlService = null;
        IDownloadServiceConnectionListener r0 = this.connectionListener;
        if (r0 == null) goto L6;
        r0.onServiceDisConnection();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setServiceConnectionListener(IDownloadServiceConnectionListener r3) {
        this.connectionListener = (IDownloadServiceConnectionListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadServiceConnectionListener.class, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setLogLevel(int r2) {
        IDownloadAidlService r0 = this.aidlService;
        if (r0 != null) goto L10;
        this.logLevel = r2;
        return;
    L10:
        r0.setLogLevel(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startService() {
        if (this.aidlService != null) goto L6;
        startService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this);
        return;
    }
}
