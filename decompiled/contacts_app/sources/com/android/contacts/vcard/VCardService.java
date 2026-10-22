package com.android.contacts.vcard;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.FileProviderCompat;
import com.obric.privacyhook.BaseService;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public class VCardService extends BaseService {
    private static final boolean ALLOW_LONG_FILE_NAME = false;
    static final String CACHE_FILE_PREFIX = "import_tmp_";
    static final boolean DEBUG = false;
    private static final String LOG_TAG = "VCardService";
    static final int MSG_CANCEL_REQUEST = 3;
    static final int MSG_EXPORT_REQUEST = 2;
    static final int MSG_IMPORT_REQUEST = 1;
    static final int MSG_REQUEST_AVAILABLE_EXPORT_DESTINATION = 4;
    static final int MSG_SET_AVAILABLE_EXPORT_DESTINATION = 5;
    static final int TYPE_EXPORT = 2;
    static final int TYPE_IMPORT = 1;
    private MyBinder mBinder;
    private int mCurrentJobId;
    private String mErrorReason;
    private final ExecutorService mExecutorService;
    private Set<String> mExtensionsToConsider;
    private int mFileIndexMaximum;
    private int mFileIndexMinimum;
    private String mFileNameExtension;
    private String mFileNamePrefix;
    private String mFileNameSuffix;
    private final List<CustomMediaScannerConnectionClient> mRemainingScannerConnections;
    private final Set<String> mReservedDestination;
    private final Map<Integer, ProcessorBase> mRunningJobMap;
    private String mTargetDirectory;

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
            if (VCardService.DEBUG == false) goto L5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(VCardService.LOG_TAG, "Connected to MediaScanner. Start scanning.");
        L5:
            this.mConnection.scanFile(this.mPath, null);
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String r2, Uri r3) {
            if (VCardService.DEBUG == false) goto L5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(VCardService.LOG_TAG, "scan completed: " + r2);
        L5:
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
        this.mExecutorService = Executors.newSingleThreadExecutor();
        this.mRunningJobMap = new HashMap();
        this.mRemainingScannerConnections = new ArrayList();
        this.mReservedDestination = new HashSet();
    }

    static /* synthetic */ void access$000(VCardService r0, CustomMediaScannerConnectionClient r1) {
        r0.removeConnectionClient(r1);
    }

    static {
        DEBUG = ContactsUtils.DEBUG;
    }

    @Override // com.obric.privacyhook.BaseService
    protected void handleAuthorizedAction(Intent r1) {
        initExporterParams();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mBinder = new MyBinder(this);
        if (DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "vCard Service is being created.");
        return;
    }

    private void initExporterParams() {
        this.mTargetDirectory = FileProviderCompat.getConfigDir(this).getAbsolutePath();
        this.mFileNamePrefix = getString(R.string.config_export_file_prefix);
        this.mFileNameSuffix = getString(R.string.config_export_file_suffix);
        this.mFileNameExtension = getString(R.string.config_export_file_extension);
        HashSet r0 = new HashSet();
        this.mExtensionsToConsider = r0;
        r0.add(this.mFileNameExtension);
        String r1 = getString(R.string.config_export_extensions_to_consider);
        if (TextUtils.isEmpty(r1) == true) goto L10;
        String[] r2 = r1.split(SimContactsConstants.EMAIL_SEP);
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L10;
        String r5 = r2[r4].trim();
        if (r5.length() <= 0) goto L9;
        this.mExtensionsToConsider.add(r5);
    L9:
        r4 = r4 + 1;
    L10:
        Resources r6 = getResources();
        this.mFileIndexMinimum = r6.getInteger(R.integer.config_export_file_min_index);
        this.mFileIndexMaximum = r6.getInteger(R.integer.config_export_file_max_index);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "VCardService is being destroyed.");
    L5:
        cancelAllRequestsAndShutdown();
        clearCache();
        super.onDestroy();
    }

    public synchronized void handleImportRequest(List<ImportRequest> r12, VCardImportExportListener r13, boolean r14) {
        monitor-enter(this);
        int r1 = 0;
        if (DEBUG == false) goto L14;
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L25
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L25
        Iterator<ImportRequest> r4 = r12.iterator();     // Catch: Throwable -> L25
    L7:
        if (r4.hasNext() == false) goto L13;
        ImportRequest r5 = r4.next();     // Catch: Throwable -> L25
        if (r5.uri != null) goto L11;
        String r6 = "null";
    L12:
        r0.add(r6);     // Catch: Throwable -> L25
        r3.add(r5.displayName);     // Catch: Throwable -> L25
        goto L7
    L11:
        r6 = r5.uri.toString();     // Catch: Throwable -> L25
        goto L12
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, String.format("received multiple import request (uri: %s, displayName: %s)", new Object[]{r0.toString(), r3.toString()}));     // Catch: Throwable -> L25
    L14:
        int r2 = r12.size();     // Catch: Throwable -> L25
    L15:
        if (r1 >= r2) goto L23;
        ImportRequest r7 = r12.get(r1);     // Catch: Throwable -> L25
        if (tryExecute(new ImportProcessor(this, r13, r7, this.mCurrentJobId, r14)) == false) goto L21;
        if (r13 == null) goto L20;
        r13.onImportProcessed(r7, this.mCurrentJobId, r1, r2);     // Catch: Throwable -> L25
    L20:
        this.mCurrentJobId++;     // Catch: Throwable -> L25
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L15
    L21:
        if (r13 == null) goto L23;
        r13.onImportFailed(r7);     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public synchronized void handleExportRequest(ExportRequest r6, VCardImportExportListener r7) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (tryExecute(new ExportProcessor(this, r7, r6, this.mCurrentJobId)) == false) goto L19;
        String r1 = r6.destUri.getEncodedPath();     // Catch: Throwable -> L23
        if (DEBUG == false) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "Reserve the path " + r1);     // Catch: Throwable -> L23
    L10:
        if (this.mReservedDestination.add(r1) == true) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, String.format("The path %s is already reserved. Reject export request", new Object[]{r1}));     // Catch: Throwable -> L23
        if (r7 == null) goto L14;
        r7.onExportFailed(r6);     // Catch: Throwable -> L23
    L14:
        monitor-exit(this);
        return;
    L16:
        if (r7 == null) goto L18;
        r7.onExportProcessed(r6, this.mCurrentJobId);     // Catch: Throwable -> L23
    L18:
        this.mCurrentJobId++;     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L19:
        if (r7 == null) goto L21;
        r7.onExportFailed(r6);     // Catch: Throwable -> L23
        goto L21
    }

    private synchronized boolean tryExecute(ProcessorBase r4) {
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
            java.lang.String r0 = "Executor service status: shutdown: "
            monitor-enter(r3)
            boolean r1 = com.android.contacts.vcard.VCardService.DEBUG     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            if (r1 == 0) goto L2f
            java.lang.String r1 = "VCardService"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            java.util.concurrent.ExecutorService r0 = r3.mExecutorService     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            boolean r0 = r0.isShutdown()     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            java.lang.String r2 = ", terminated: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            java.util.concurrent.ExecutorService r2 = r3.mExecutorService     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            boolean r2 = r2.isTerminated()     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            com.GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r1, r0)     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
        L2f:
            java.util.concurrent.ExecutorService r0 = r3.mExecutorService     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            r0.execute(r4)     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            java.util.Map<java.lang.Integer, com.android.contacts.vcard.ProcessorBase> r0 = r3.mRunningJobMap     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            int r1 = r3.mCurrentJobId     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            r0.put(r1, r4)     // Catch: java.lang.Throwable -> L42 java.util.concurrent.RejectedExecutionException -> L44
            monitor-exit(r3)
            r3 = 1
            return r3
        L42:
            r4 = move-exception
            goto L4f
        L44:
            r4 = move-exception
            java.lang.String r0 = "VCardService"
            java.lang.String r1 = "Failed to excetute a job."
            com.GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(r0, r1, r4)     // Catch: java.lang.Throwable -> L42
            monitor-exit(r3)
            r3 = 0
            return r3
        L4f:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.vcard.VCardService.tryExecute(com.android.contacts.vcard.ProcessorBase):boolean");
    }

    public synchronized void handleCancelRequest(CancelRequest r8, VCardImportExportListener r9) {
        monitor-enter(this);
        int r0 = r8.jobId;     // Catch: Throwable -> L20
        if (DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, String.format("Received cancel request. (id: %d)", new Object[]{Integer.valueOf(r0)}));     // Catch: Throwable -> L20
    L6:
        ProcessorBase r1 = this.mRunningJobMap.remove(Integer.valueOf(r0));     // Catch: Throwable -> L20
        if (r1 == null) goto L16;
        r1.cancel(true);     // Catch: Throwable -> L20
        int r2 = r1.getType();     // Catch: Throwable -> L20
        if (r9 == null) goto L12;
        r9.onCancelRequest(r8, r2);     // Catch: Throwable -> L20
    L12:
        if (r2 != 2) goto L17;
        String r10 = ((ExportProcessor) r1).getRequest().destUri.getEncodedPath();     // Catch: Throwable -> L20
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, String.format("Cancel reservation for the path %s if appropriate", new Object[]{r10}));     // Catch: Throwable -> L20
        if (this.mReservedDestination.remove(r10) == true) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Not reserved.");     // Catch: Throwable -> L20
    L17:
        stopServiceIfAppropriate();     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, String.format("Tried to remove unknown job (id: %d)", new Object[]{Integer.valueOf(r0)}));     // Catch: Throwable -> L20
        ((NotificationManager) getBaseContext().getSystemService("notification")).notify("VCardServiceProgress", r0, NotificationImportExportListener.constructCancelNotification(getBaseContext(), getBaseContext().getString(R.string.importing_or_exporting_vcard_canceled_title, new Object[]{r8.displayName})));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized void handleRequestAvailableExportDestination(Messenger r5, boolean r6) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "Received available export destination request.");     // Catch: Throwable -> L23
    L7:
        if (r6 == true) goto L9;
        String r7 = getAppropriateDestination(this.mTargetDirectory);     // Catch: Throwable -> L23
    L14:
        if (r7 == null) goto L16;
        Message r8 = Message.obtain(null, 5, 0, 0, r7);     // Catch: Throwable -> L23
    L26:
        r5.send(r8);     // Catch: RemoteException -> L19 Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L19:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Failed to send reply for available export destination request.", e);     // Catch: Throwable -> L23
        goto L21
    L16:
        r8 = Message.obtain(null, 5, R.id.dialog_fail_to_export_with_reason, 0, this.mErrorReason);     // Catch: Throwable -> L23
        goto L26
    L9:
        if (ContactsUtils.getExternalSdcardExportDirectoryPath() == null) goto L11;
        r7 = getAppropriateDestination(ContactsUtils.getExternalSdcardExportDirectoryPath());     // Catch: Throwable -> L23
        goto L14
    L11:
        r7 = null;
        goto L14
    }

    private synchronized void stopServiceIfAppropriate() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.mRunningJobMap.size() <= 0) goto L15;
        Iterator<Map.Entry<Integer, ProcessorBase>> r0 = this.mRunningJobMap.entrySet().iterator();     // Catch: Throwable -> L22
    L7:
        if (r0.hasNext() == false) goto L15;
        Map.Entry<Integer, ProcessorBase> r1 = r0.next();     // Catch: Throwable -> L22
        int r2 = r1.getKey().intValue();     // Catch: Throwable -> L22
        if (r1.getValue().isDone() == false) goto L11;
        this.mRunningJobMap.remove(Integer.valueOf(r2));     // Catch: Throwable -> L22
        goto L7
    L11:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, String.format("Found unfinished job (id: %d)", new Object[]{Integer.valueOf(r2)}));     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L15:
        if (this.mRemainingScannerConnections.isEmpty() == true) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "MediaScanner update is in progress.");     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L19:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "No unfinished job. Stop this service.");     // Catch: Throwable -> L22
        this.mExecutorService.shutdown();     // Catch: Throwable -> L22
        stopSelf();     // Catch: Throwable -> L22
        monitor-exit(this);
    }

    synchronized void updateMediaScanner(String r4) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (DEBUG == false) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "MediaScanner is being updated: " + r4);     // Catch: Throwable -> L15
    L8:
        if (this.mExecutorService.isShutdown() == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "MediaScanner update is requested after executor's being shut down. Ignoring the update request");     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L12:
        CustomMediaScannerConnectionClient r0 = new CustomMediaScannerConnectionClient(this, r4);     // Catch: Throwable -> L15
        this.mRemainingScannerConnections.add(r0);     // Catch: Throwable -> L15
        r0.start();     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    private synchronized void removeConnectionClient(CustomMediaScannerConnectionClient r3) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "Removing custom MediaScannerConnectionClient.");     // Catch: Throwable -> L9
    L6:
        this.mRemainingScannerConnections.remove(r3);     // Catch: Throwable -> L9
        stopServiceIfAppropriate();     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    synchronized void handleFinishImportNotification(int r7, boolean r8) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (DEBUG == false) goto L11;
        Object[] r4 = new Object[2];     // Catch: Throwable -> L16
        r4[0] = Integer.valueOf(r7);     // Catch: Throwable -> L16
        if (r8 == false) goto L8;
        String r9 = "success";
    L9:
        r4[1] = r9;     // Catch: Throwable -> L16
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, String.format("Received vCard import finish notification (id: %d). Result: %b", r4));     // Catch: Throwable -> L16
        goto L11
    L8:
        r9 = "failure";
    L11:
        if (this.mRunningJobMap.remove(Integer.valueOf(r7)) != null) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, String.format("Tried to remove unknown job (id: %d)", new Object[]{Integer.valueOf(r7)}));     // Catch: Throwable -> L16
    L13:
        stopServiceIfAppropriate();     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    synchronized void handleFinishExportNotification(int r9, boolean r10) {
        monitor-enter(this);
        boolean r1 = DEBUG;     // Catch: Throwable -> L24
        if (r1 == false) goto L11;
        Object[] r6 = new Object[2];     // Catch: Throwable -> L24
        r6[0] = Integer.valueOf(r9);     // Catch: Throwable -> L24
        if (r10 == false) goto L9;
        String r11 = "success";
    L10:
        r6[1] = r11;     // Catch: Throwable -> L24
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, String.format("Received vCard export finish notification (id: %d). Result: %b", r6));     // Catch: Throwable -> L24
        goto L11
    L9:
        r11 = "failure";
    L11:
        ProcessorBase r12 = this.mRunningJobMap.remove(Integer.valueOf(r9));     // Catch: Throwable -> L24
        if (r12 != null) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, String.format("Tried to remove unknown job (id: %d)", new Object[]{Integer.valueOf(r9)}));     // Catch: Throwable -> L24
    L21:
        stopServiceIfAppropriate();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L15:
        if ((r12 instanceof ExportProcessor) == true) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, String.format("Removed job (id: %s) isn't ExportProcessor", new Object[]{Integer.valueOf(r9)}));     // Catch: Throwable -> L24
        goto L21
    L17:
        String r13 = ((ExportProcessor) r12).getRequest().destUri.getEncodedPath();     // Catch: Throwable -> L24
        if (r1 == false) goto L20;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "Remove reserved path " + r13);     // Catch: Throwable -> L24
    L20:
        this.mReservedDestination.remove(r13);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private synchronized void cancelAllRequestsAndShutdown() {
        monitor-enter(this);
        Iterator<Map.Entry<Integer, ProcessorBase>> r0 = this.mRunningJobMap.entrySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        r0.next().getValue().cancel(true);     // Catch: Throwable -> L10
        goto L5
    L7:
        this.mRunningJobMap.clear();     // Catch: Throwable -> L10
        this.mExecutorService.shutdown();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
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

    private String getAppropriateDestination(String r13) {
        int r0 = this.mFileIndexMaximum;
        int r2 = 0;
    L3:
        if (r0 <= 0) goto L5;
        r2 = r2 + 1;
        r0 = r0 / 10;
        goto L3
    L5:
        String r1 = "%s%0" + r2 + "d%s";
        String r3 = String.format(r1, new Object[]{this.mFileNamePrefix, 1, this.mFileNameSuffix});
        if (r3.length() <= 8) goto L8;
    L40:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "This code does not allow any long file name.");
        this.mErrorReason = getString(R.string.fail_reason_too_long_filename, new Object[]{String.format("%s.%s", new Object[]{r3, this.mFileNameExtension})});
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "File name becomes too long.");
        return null;
    L8:
        if (this.mFileNameExtension.length() > 3) goto L40;
        int r4 = this.mFileIndexMinimum;
    L12:
        if (r4 > this.mFileIndexMaximum) goto L38;
        Iterator<String> r5 = this.mExtensionsToConsider.iterator();
        String r7 = null;
    L15:
        if (r5.hasNext() == false) goto L33;
        String r8 = r5.next();
        String r9 = String.format(r1, new Object[]{this.mFileNamePrefix, Integer.valueOf(r4), this.mFileNameSuffix});
        String r10 = String.format("%s/%s.%s", new Object[]{r13, r9, r8});
        monitor-enter(this);
        if (this.mReservedDestination.contains(r10) == true) goto L21;
        monitor-exit(this);     // Catch: Throwable -> L30
        if (new File(r10).exists() == true) goto L28;
        r7 = r9;
    L28:
        boolean r6 = false;
        r7 = r9;
    L34:
        if (r6 == true) goto L36;
        r4 = r4 + 1;
        goto L12
    L36:
        return String.format("%s/%s.%s", new Object[]{r13, r7, this.mFileNameExtension});
    L21:
        if (DEBUG == false) goto L23;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, String.format("The path %s is reserved.", new Object[]{r10}));     // Catch: Throwable -> L30
    L23:
        monitor-exit(this);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L33:
        r6 = true;
        goto L34
    L38:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Reached vCard number limit. Maybe there are too many vCard in the storage");
        this.mErrorReason = getString(R.string.fail_reason_too_many_vcard);
        return null;
    }
}
