package com.android.contacts.common.vcard;

import android.app.Service;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.util.SparseArray;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class VCardService extends Service {
    static final String CACHE_FILE_PREFIX = "import_tmp_";
    static final boolean DEBUG = false;
    private static final String LOG_TAG = "VCardService";
    static final int TYPE_EXPORT = 2;
    static final int TYPE_IMPORT = 1;
    static final String X_VCARD_MIME_TYPE = "text/x-vcard";
    private MyBinder mBinder;
    private String mCallingActivity;
    private int mCurrentJobId;
    private final ExecutorService mExecutorService;
    private final List<CustomMediaScannerConnectionClient> mRemainingScannerConnections;
    private final Set<String> mReservedDestination;
    private final SparseArray<ProcessorBase> mRunningJobMap;
    private String selExport;

    private class CustomMediaScannerConnectionClient implements MediaScannerConnection.MediaScannerConnectionClient {
        final MediaScannerConnection mConnection;
        final String mPath;
        final /* synthetic */ VCardService this$0;

        public CustomMediaScannerConnectionClient(VCardService r2, String r3) {
            this.this$0 = r2;
            this.mConnection = new MediaScannerConnection(r2, this);
            this.mPath = r3;
        }

        public void start() {
            this.mConnection.connect();
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            this.mConnection.scanFile(this.mPath, null);
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String r1, Uri r2) {
            this.mConnection.disconnect();
            VCardService.access$000(this.this$0, this);
        }
    }

    public class MyBinder extends Binder {
        final /* synthetic */ VCardService this$0;

        public MyBinder(VCardService r1) {
            this.this$0 = r1;
        }

        public VCardService getService() {
            return this.this$0;
        }
    }

    public VCardService() {
        this.selExport = "";
        this.mExecutorService = Executors.newSingleThreadExecutor();
        this.mRunningJobMap = new SparseArray();
        this.mRemainingScannerConnections = new ArrayList();
        this.mReservedDestination = new HashSet();
    }

    static /* synthetic */ void access$000(VCardService r0, CustomMediaScannerConnectionClient r1) {
        r0.removeConnectionClient(r1);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mBinder = new MyBinder(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r1, int r2, int r3) {
        if (r1 != null) goto L4;
    L6:
        this.mCallingActivity = null;
        return 1;
    L4:
        if (r1.getExtras() == null) goto L6;
        this.mCallingActivity = r1.getExtras().getString(VCardCommonArguments.ARG_CALLING_ACTIVITY);
        return 1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onDestroy() {
        cancelAllRequestsAndShutdown();
        clearCache();
        super.onDestroy();
    }

    public synchronized void handleImportRequest(List<ImportRequest> r6, VCardImportExportListener r7) {
        monitor-enter(this);
        int r0 = r6.size();     // Catch: Throwable -> L14
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L12;
        ImportRequest r2 = r6.get(r1);     // Catch: Throwable -> L14
        if (tryExecute(new ImportProcessor(this, r7, r2, this.mCurrentJobId)) == false) goto L10;
        if (r7 == null) goto L9;
        r7.onImportProcessed(r2, this.mCurrentJobId, r1);     // Catch: Throwable -> L14
    L9:
        this.mCurrentJobId++;     // Catch: Throwable -> L14
        r1 = r1 + 1;     // Catch: Throwable -> L14
        goto L4
    L10:
        if (r7 == null) goto L12;
        r7.onImportFailed(r2);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized void handleExportRequest(ExportRequest r6, VCardImportExportListener r7) {
        monitor-enter(this);
        ExportProcessor r0 = new ExportProcessor(this, r6, this.mCurrentJobId, this.mCallingActivity);     // Catch: Throwable -> L19
        r0.setSelExport(this.selExport);     // Catch: Throwable -> L19
        if (tryExecute(r0) == false) goto L15;
        String r1 = r6.destUri.getEncodedPath();     // Catch: Throwable -> L19
        if (this.mReservedDestination.add(r1) == true) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, String.format("The path %s is already reserved. Reject export request", new Object[]{r1}));     // Catch: Throwable -> L19
        if (r7 == null) goto L10;
        r7.onExportFailed(r6);     // Catch: Throwable -> L19
    L10:
        monitor-exit(this);
        return;
    L12:
        if (r7 == null) goto L14;
        r7.onExportProcessed(r6, this.mCurrentJobId);     // Catch: Throwable -> L19
    L14:
        this.mCurrentJobId++;     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L15:
        if (r7 == null) goto L17;
        r7.onExportFailed(r6);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public void setSelExport(String r1) {
        this.selExport = r1;
    }

    private synchronized boolean tryExecute(ProcessorBase r3) {
        monitor-enter(this);
        this.mExecutorService.execute(r3);     // Catch: Throwable -> L7 RejectedExecutionException -> L9
        this.mRunningJobMap.put(this.mCurrentJobId, r3);     // Catch: Throwable -> L7 RejectedExecutionException -> L9
        monitor-exit(this);
        return true;
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Failed to excetute a job.", e);     // Catch: Throwable -> L7
        return false;
    }

    public synchronized void handleCancelRequest(CancelRequest r5, VCardImportExportListener r6) {
        monitor-enter(this);
        int r0 = r5.jobId;     // Catch: Throwable -> L17
        ProcessorBase r1 = this.mRunningJobMap.get(r0);     // Catch: Throwable -> L17
        this.mRunningJobMap.remove(r0);     // Catch: Throwable -> L17
        if (r1 == null) goto L13;
        r1.cancel(true);     // Catch: Throwable -> L17
        int r2 = r1.getType();     // Catch: Throwable -> L17
        if (r6 == null) goto L9;
        r6.onCancelRequest(r5, r2);     // Catch: Throwable -> L17
    L9:
        if (r2 != 2) goto L14;
        String r7 = ((ExportProcessor) r1).getRequest().destUri.getEncodedPath();     // Catch: Throwable -> L17
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, String.format("Cancel reservation for the path %s if appropriate", new Object[]{r7}));     // Catch: Throwable -> L17
        if (this.mReservedDestination.remove(r7) == true) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Not reserved.");     // Catch: Throwable -> L17
    L14:
        stopServiceIfAppropriate();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, String.format("Tried to remove unknown job (id: %d)", new Object[]{Integer.valueOf(r0)}));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private synchronized void stopServiceIfAppropriate() {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (this.mRunningJobMap.size() <= 0) goto L18;
        int r0 = this.mRunningJobMap.size();     // Catch: Throwable -> L25
        int[] r1 = new int[r0];     // Catch: Throwable -> L25
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L16;
        int r4 = this.mRunningJobMap.keyAt(r3);     // Catch: Throwable -> L25
        if (this.mRunningJobMap.valueAt(r3).isDone() == false) goto L9;
        r1[r3] = r4;     // Catch: Throwable -> L25
        r3 = r3 + 1;     // Catch: Throwable -> L25
        goto L6
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, String.format("Found unfinished job (id: %d)", new Object[]{Integer.valueOf(r4)}));     // Catch: Throwable -> L25
    L10:
        if (r2 >= r3) goto L13;
        this.mRunningJobMap.remove(r1[r2]);     // Catch: Throwable -> L25
        r2 = r2 + 1;
        goto L10
    L13:
        monitor-exit(this);
        return;
    L16:
        this.mRunningJobMap.clear();     // Catch: Throwable -> L25
    L18:
        if (this.mRemainingScannerConnections.isEmpty() == true) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "MediaScanner update is in progress.");     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L22:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "No unfinished job. Stop this service.");     // Catch: Throwable -> L25
        this.mExecutorService.shutdown();     // Catch: Throwable -> L25
        stopSelf();     // Catch: Throwable -> L25
        monitor-exit(this);
    }

    synchronized void updateMediaScanner(String r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mExecutorService.isShutdown() == false) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "MediaScanner update is requested after executor's being shut down. Ignoring the update request");     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        CustomMediaScannerConnectionClient r0 = new CustomMediaScannerConnectionClient(this, r2);     // Catch: Throwable -> L11
        this.mRemainingScannerConnections.add(r0);     // Catch: Throwable -> L11
        r0.start();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private synchronized void removeConnectionClient(CustomMediaScannerConnectionClient r2) {
        monitor-enter(this);
        this.mRemainingScannerConnections.remove(r2);     // Catch: Throwable -> L6
        stopServiceIfAppropriate();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void handleFinishImportNotification(int r1, boolean r2) {
        monitor-enter(this);
        this.mRunningJobMap.remove(r1);     // Catch: Throwable -> L6
        stopServiceIfAppropriate();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void handleFinishExportNotification(int r4, boolean r5) {
        monitor-enter(this);
        ProcessorBase r6 = this.mRunningJobMap.get(r4);     // Catch: Throwable -> L13
        this.mRunningJobMap.remove(r4);     // Catch: Throwable -> L13
        if (r6 != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, String.format("Tried to remove unknown job (id: %d)", new Object[]{Integer.valueOf(r4)}));     // Catch: Throwable -> L13
    L10:
        stopServiceIfAppropriate();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L7:
        if ((r6 instanceof ExportProcessor) == true) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, String.format("Removed job (id: %s) isn't ExportProcessor", new Object[]{Integer.valueOf(r4)}));     // Catch: Throwable -> L13
        goto L10
    L9:
        this.mReservedDestination.remove(((ExportProcessor) r6).getRequest().destUri.getEncodedPath());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private synchronized void cancelAllRequestsAndShutdown() {
        monitor-enter(this);
        int r0 = 0;
    L13:
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0 >= this.mRunningJobMap.size()) goto L7;
        this.mRunningJobMap.valueAt(r0).cancel(true);     // Catch: Throwable -> L10
        r0 = r0 + 1;     // Catch: Throwable -> L10
        goto L13
    L7:
        this.mRunningJobMap.clear();     // Catch: Throwable -> L10
        this.mExecutorService.shutdown();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private void clearCache() {
        String[] r0 = fileList();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        String r3 = r0[r2];
        if (r3.startsWith(CACHE_FILE_PREFIX) == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Remove a temporary file: " + r3);
        deleteFile(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    }
}
