package com.android.server.print;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.Icon;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.print.IPrintSpooler;
import android.print.IPrintSpoolerCallbacks;
import android.print.IPrintSpoolerClient;
import android.print.PrintJobId;
import android.print.PrintJobInfo;
import android.print.PrinterId;
import android.util.Slog;
import android.util.TimedRemoteCaller;
import com.android.internal.os.TransferPipe;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.server.backup.BackupAgentTimeoutParameters;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeoutException;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes3.dex */
final class RemotePrintSpooler {
    private static final long BIND_SPOOLER_SERVICE_TIMEOUT = 0;
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "RemotePrintSpooler";
    private final PrintSpoolerCallbacks mCallbacks;
    private boolean mCanUnbind;
    private final ClearCustomPrinterIconCacheCaller mClearCustomPrinterIconCache;
    private final PrintSpoolerClient mClient;
    private final Context mContext;
    private final OnCustomPrinterIconLoadedCaller mCustomPrinterIconLoadedCaller;
    private boolean mDestroyed;
    private final GetCustomPrinterIconCaller mGetCustomPrinterIconCaller;
    private final GetPrintJobInfoCaller mGetPrintJobInfoCaller;
    private final GetPrintJobInfosCaller mGetPrintJobInfosCaller;
    private final Intent mIntent;
    private boolean mIsBinding;
    private boolean mIsLowPriority;
    private final Object mLock;
    private IPrintSpooler mRemoteInstance;
    private final ServiceConnection mServiceConnection;
    private final SetPrintJobStateCaller mSetPrintJobStatusCaller;
    private final SetPrintJobTagCaller mSetPrintJobTagCaller;
    private final UserHandle mUserHandle;

    private static abstract class BasePrintSpoolerServiceCallbacks extends IPrintSpoolerCallbacks.Stub {
        /* synthetic */ BasePrintSpoolerServiceCallbacks(RemotePrintSpoolerIA r1) {
            this();
        }

        private BasePrintSpoolerServiceCallbacks() {
        }

        public void onGetPrintJobInfosResult(List<PrintJobInfo> printJobIds, int sequence) {
        }

        public void onGetPrintJobInfoResult(PrintJobInfo printJob, int sequence) {
        }

        public void onCancelPrintJobResult(boolean canceled, int sequence) {
        }

        public void onSetPrintJobStateResult(boolean success, int sequece) {
        }

        public void onSetPrintJobTagResult(boolean success, int sequence) {
        }

        public void onCustomPrinterIconCached(int sequence) {
        }

        public void onGetCustomPrinterIconResult(Icon icon, int sequence) {
        }

        public void customPrinterIconCacheCleared(int sequence) {
        }
    }

    private static final class ClearCustomPrinterIconCacheCaller extends TimedRemoteCaller<Void> {
        private final IPrintSpoolerCallbacks mCallback;

        static /* synthetic */ void access$500(ClearCustomPrinterIconCacheCaller x0, Object x1, int x2) {
            x0.onRemoteMethodResult(x1, x2);
        }

        public ClearCustomPrinterIconCacheCaller() {
            super(5000);
            this.mCallback = new AnonymousClass1(this);
        }

        public Void clearCustomPrinterIconCache(IPrintSpooler target) throws RemoteException, TimeoutException {
            int sequence = onBeforeRemoteCall();
            target.clearCustomPrinterIconCache(this.mCallback, sequence);
            return (Void) getResultTimed(sequence);
        }
    }

    private static final class GetCustomPrinterIconCaller extends TimedRemoteCaller<Icon> {
        private final IPrintSpoolerCallbacks mCallback;

        static /* synthetic */ void access$600(GetCustomPrinterIconCaller x0, Object x1, int x2) {
            x0.onRemoteMethodResult(x1, x2);
        }

        public GetCustomPrinterIconCaller() {
            super(5000);
            this.mCallback = new AnonymousClass1(this);
        }

        public Icon getCustomPrinterIcon(IPrintSpooler target, PrinterId printerId) throws RemoteException, TimeoutException {
            int sequence = onBeforeRemoteCall();
            target.getCustomPrinterIcon(printerId, this.mCallback, sequence);
            return (Icon) getResultTimed(sequence);
        }
    }

    private static final class GetPrintJobInfoCaller extends TimedRemoteCaller<PrintJobInfo> {
        private final IPrintSpoolerCallbacks mCallback;

        static /* synthetic */ void access$100(GetPrintJobInfoCaller x0, Object x1, int x2) {
            x0.onRemoteMethodResult(x1, x2);
        }

        public GetPrintJobInfoCaller() {
            super(5000);
            this.mCallback = new AnonymousClass1(this);
        }

        public PrintJobInfo getPrintJobInfo(IPrintSpooler target, PrintJobId printJobId, int appId) throws RemoteException, TimeoutException {
            int sequence = onBeforeRemoteCall();
            target.getPrintJobInfo(printJobId, this.mCallback, appId, sequence);
            return (PrintJobInfo) getResultTimed(sequence);
        }
    }

    private static final class GetPrintJobInfosCaller extends TimedRemoteCaller<List<PrintJobInfo>> {
        private final IPrintSpoolerCallbacks mCallback;

        static /* synthetic */ void access$000(GetPrintJobInfosCaller x0, Object x1, int x2) {
            x0.onRemoteMethodResult(x1, x2);
        }

        public GetPrintJobInfosCaller() {
            super(5000);
            this.mCallback = new AnonymousClass1(this);
        }

        public List<PrintJobInfo> getPrintJobInfos(IPrintSpooler target, ComponentName componentName, int state, int appId) throws RemoteException, TimeoutException {
            int sequence = onBeforeRemoteCall();
            target.getPrintJobInfos(this.mCallback, componentName, state, appId, sequence);
            return (List) getResultTimed(sequence);
        }
    }

    private final class MyServiceConnection implements ServiceConnection {
        final /* synthetic */ RemotePrintSpooler this$0;

        /* synthetic */ MyServiceConnection(RemotePrintSpooler r1, RemotePrintSpoolerIA r2) {
            this(r1);
        }

        private MyServiceConnection(RemotePrintSpooler r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Object r0 = RemotePrintSpooler.m7939$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            RemotePrintSpooler.m7941$$Nest$fputmRemoteInstance(this.this$0, IPrintSpooler.Stub.asInterface(service));     // Catch: Throwable -> L7
            RemotePrintSpooler.m7945$$Nest$msetClientLocked(this.this$0);     // Catch: Throwable -> L7
            RemotePrintSpooler.m7939$$Nest$fgetmLock(this.this$0).notifyAll();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Object r0 = RemotePrintSpooler.m7939$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (RemotePrintSpooler.m7940$$Nest$fgetmRemoteInstance(this.this$0) == null) goto L9;
            RemotePrintSpooler.m7942$$Nest$mclearClientLocked(this.this$0);     // Catch: Throwable -> L7
            RemotePrintSpooler.m7941$$Nest$fputmRemoteInstance(this.this$0, null);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    private static final class OnCustomPrinterIconLoadedCaller extends TimedRemoteCaller<Void> {
        private final IPrintSpoolerCallbacks mCallback;

        static /* synthetic */ void access$400(OnCustomPrinterIconLoadedCaller x0, Object x1, int x2) {
            x0.onRemoteMethodResult(x1, x2);
        }

        public OnCustomPrinterIconLoadedCaller() {
            super(5000);
            this.mCallback = new AnonymousClass1(this);
        }

        public Void onCustomPrinterIconLoaded(IPrintSpooler target, PrinterId printerId, Icon icon) throws RemoteException, TimeoutException {
            int sequence = onBeforeRemoteCall();
            target.onCustomPrinterIconLoaded(printerId, icon, this.mCallback, sequence);
            return (Void) getResultTimed(sequence);
        }
    }

    public interface PrintSpoolerCallbacks {
        void onAllPrintJobsForServiceHandled(ComponentName r1);

        void onPrintJobQueued(PrintJobInfo r1);

        void onPrintJobStateChanged(PrintJobInfo r1);
    }

    private static final class PrintSpoolerClient extends IPrintSpoolerClient.Stub {
        private final WeakReference<RemotePrintSpooler> mWeakSpooler;

        public PrintSpoolerClient(RemotePrintSpooler spooler) {
            this.mWeakSpooler = new WeakReference(spooler);
        }

        public void onPrintJobQueued(PrintJobInfo printJob) {
            RemotePrintSpooler spooler = this.mWeakSpooler.get();
            if (spooler == null) goto L10;
            long identity = Binder.clearCallingIdentity();
            RemotePrintSpooler.m7938$$Nest$fgetmCallbacks(spooler).onPrintJobQueued(printJob);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void onAllPrintJobsForServiceHandled(ComponentName printService) {
            RemotePrintSpooler spooler = this.mWeakSpooler.get();
            if (spooler == null) goto L10;
            long identity = Binder.clearCallingIdentity();
            RemotePrintSpooler.m7938$$Nest$fgetmCallbacks(spooler).onAllPrintJobsForServiceHandled(printService);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void onAllPrintJobsHandled() {
            RemotePrintSpooler spooler = this.mWeakSpooler.get();
            if (spooler == null) goto L10;
            long identity = Binder.clearCallingIdentity();
            RemotePrintSpooler.m7943$$Nest$monAllPrintJobsHandled(spooler);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void onPrintJobStateChanged(PrintJobInfo printJob) {
            RemotePrintSpooler spooler = this.mWeakSpooler.get();
            if (spooler == null) goto L10;
            long identity = Binder.clearCallingIdentity();
            RemotePrintSpooler.m7944$$Nest$monPrintJobStateChanged(spooler, printJob);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }
    }

    private static final class SetPrintJobStateCaller extends TimedRemoteCaller<Boolean> {
        private final IPrintSpoolerCallbacks mCallback;

        static /* synthetic */ void access$200(SetPrintJobStateCaller x0, Object x1, int x2) {
            x0.onRemoteMethodResult(x1, x2);
        }

        public SetPrintJobStateCaller() {
            super(5000);
            this.mCallback = new AnonymousClass1(this);
        }

        public boolean setPrintJobState(IPrintSpooler target, PrintJobId printJobId, int status, String error) throws RemoteException, TimeoutException {
            int sequence = onBeforeRemoteCall();
            target.setPrintJobState(printJobId, status, error, this.mCallback, sequence);
            return ((Boolean) getResultTimed(sequence)).booleanValue();
        }
    }

    private static final class SetPrintJobTagCaller extends TimedRemoteCaller<Boolean> {
        private final IPrintSpoolerCallbacks mCallback;

        static /* synthetic */ void access$300(SetPrintJobTagCaller x0, Object x1, int x2) {
            x0.onRemoteMethodResult(x1, x2);
        }

        public SetPrintJobTagCaller() {
            super(5000);
            this.mCallback = new AnonymousClass1(this);
        }

        public boolean setPrintJobTag(IPrintSpooler target, PrintJobId printJobId, String tag) throws RemoteException, TimeoutException {
            int sequence = onBeforeRemoteCall();
            target.setPrintJobTag(printJobId, tag, this.mCallback, sequence);
            return ((Boolean) getResultTimed(sequence)).booleanValue();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ PrintSpoolerCallbacks m7938$$Nest$fgetmCallbacks(RemotePrintSpooler r0) {
        return r0.mCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7939$$Nest$fgetmLock(RemotePrintSpooler r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteInstance, reason: not valid java name */
    static /* bridge */ /* synthetic */ IPrintSpooler m7940$$Nest$fgetmRemoteInstance(RemotePrintSpooler r0) {
        return r0.mRemoteInstance;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRemoteInstance, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7941$$Nest$fputmRemoteInstance(RemotePrintSpooler r0, IPrintSpooler r1) {
        r0.mRemoteInstance = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mclearClientLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7942$$Nest$mclearClientLocked(RemotePrintSpooler r0) {
        r0.clearClientLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$monAllPrintJobsHandled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7943$$Nest$monAllPrintJobsHandled(RemotePrintSpooler r0) {
        r0.onAllPrintJobsHandled();
    }

    /* JADX INFO: renamed from: -$$Nest$monPrintJobStateChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7944$$Nest$monPrintJobStateChanged(RemotePrintSpooler r0, PrintJobInfo r1) {
        r0.onPrintJobStateChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetClientLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7945$$Nest$msetClientLocked(RemotePrintSpooler r0) {
        r0.setClientLocked();
    }

    static {
        if (Build.IS_ENG == false) goto L5;
        long r0 = 120000;
    L6:
        BIND_SPOOLER_SERVICE_TIMEOUT = r0;
        return;
    L5:
        r0 = BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS;
        goto L6
    }

    public RemotePrintSpooler(Context context, int userId, boolean lowPriority, PrintSpoolerCallbacks callbacks) {
        this.mLock = new Object();
        this.mGetPrintJobInfosCaller = new GetPrintJobInfosCaller();
        this.mGetPrintJobInfoCaller = new GetPrintJobInfoCaller();
        this.mSetPrintJobStatusCaller = new SetPrintJobStateCaller();
        this.mSetPrintJobTagCaller = new SetPrintJobTagCaller();
        this.mCustomPrinterIconLoadedCaller = new OnCustomPrinterIconLoadedCaller();
        this.mClearCustomPrinterIconCache = new ClearCustomPrinterIconCacheCaller();
        this.mGetCustomPrinterIconCaller = new GetCustomPrinterIconCaller();
        this.mServiceConnection = new MyServiceConnection(this, null);
        this.mContext = context;
        this.mUserHandle = new UserHandle(userId);
        this.mCallbacks = callbacks;
        this.mIsLowPriority = lowPriority;
        this.mClient = new PrintSpoolerClient(this);
        this.mIntent = new Intent();
        this.mIntent.setComponent(new ComponentName("com.android.printspooler", "com.android.printspooler.model.PrintSpoolerService"));
    }

    public void increasePriority() {
        if (this.mIsLowPriority == false) goto L20;
        this.mIsLowPriority = false;
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L11
    L8:
        if (this.mCanUnbind == true) goto L15;
        this.mLock.wait();     // Catch: Throwable -> L11 InterruptedException -> L13
    L14:
        Slog.e(LOG_TAG, "Interrupted while waiting for operation to complete");     // Catch: Throwable -> L11
        goto L8
    L15:
        unbindLocked();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final List<PrintJobInfo> getPrintJobInfos(ComponentName componentName, int state, int appId) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        List<PrintJobInfo> r1 = this.mGetPrintJobInfosCaller.getPrintJobInfos(getRemoteInstanceLazy(), componentName, state, appId);     // Catch: Throwable -> L16 Throwable -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        this.mLock.notifyAll();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error getting print jobs.", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        this.mLock.notifyAll();     // Catch: Throwable -> L26
        return null;
    L26:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void createPrintJob(PrintJobInfo r5) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        boolean r1 = 1;
        r1 = 1;
        getRemoteInstanceLazy().createPrintJob(r5);     // Catch: Throwable -> L16 Throwable -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        Object r3 = this.mLock;     // Catch: Throwable -> L13
        r3.notifyAll();     // Catch: Throwable -> L13
        r1 = r3;
        monitor-exit(r2);     // Catch: Throwable -> L13
    L12:
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = r1;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error creating print job.", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        Object r4 = this.mLock;     // Catch: Throwable -> L26
        r4.notifyAll();     // Catch: Throwable -> L26
        r1 = r4;
    L26:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    public final void writePrintJobData(ParcelFileDescriptor fd, PrintJobId printJobId) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        getRemoteInstanceLazy().writePrintJobData(fd, printJobId);     // Catch: Throwable -> L16 Throwable -> L18
        IoUtils.closeQuietly(fd);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        this.mLock.notifyAll();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
    L25:
        return;
    L13:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error writing print job data.", e);     // Catch: Throwable -> L16
        IoUtils.closeQuietly(fd);
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        this.mLock.notifyAll();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        IoUtils.closeQuietly(fd);
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    public final PrintJobInfo getPrintJobInfo(PrintJobId printJobId, int appId) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        PrintJobInfo r1 = this.mGetPrintJobInfoCaller.getPrintJobInfo(getRemoteInstanceLazy(), printJobId, appId);     // Catch: Throwable -> L16 Throwable -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        this.mLock.notifyAll();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error getting print job info.", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        this.mLock.notifyAll();     // Catch: Throwable -> L26
        return null;
    L26:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    public final boolean setPrintJobState(PrintJobId printJobId, int state, String error) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L36
        this.mCanUnbind = false;     // Catch: Throwable -> L36
        monitor-exit(r0);     // Catch: Throwable -> L36
        boolean r1 = this.mSetPrintJobStatusCaller.setPrintJobState(getRemoteInstanceLazy(), printJobId, state, error);     // Catch: Throwable -> L16 Throwable -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        this.mLock.notifyAll();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error setting print job state.", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L25
        this.mLock.notifyAll();     // Catch: Throwable -> L25
        return false;
    L25:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L33
        this.mLock.notifyAll();     // Catch: Throwable -> L33
        throw th;
    L33:
        th = move-exception;
        throw th;
    L36:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setProgress(PrintJobId r5, float r6) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        boolean r1 = 1;
        r1 = 1;
        getRemoteInstanceLazy().setProgress(r5, r6);     // Catch: Throwable -> L16 Throwable -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        Object r3 = this.mLock;     // Catch: Throwable -> L13
        r3.notifyAll();     // Catch: Throwable -> L13
        r1 = r3;
        monitor-exit(r2);     // Catch: Throwable -> L13
    L12:
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = r1;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error setting progress.", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        Object r4 = this.mLock;     // Catch: Throwable -> L26
        r4.notifyAll();     // Catch: Throwable -> L26
        r1 = r4;
    L26:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setStatus(PrintJobId r5, CharSequence r6) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        boolean r1 = 1;
        r1 = 1;
        getRemoteInstanceLazy().setStatus(r5, r6);     // Catch: Throwable -> L16 Throwable -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        Object r3 = this.mLock;     // Catch: Throwable -> L13
        r3.notifyAll();     // Catch: Throwable -> L13
        r1 = r3;
        monitor-exit(r2);     // Catch: Throwable -> L13
    L12:
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = r1;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error setting status.", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        Object r4 = this.mLock;     // Catch: Throwable -> L26
        r4.notifyAll();     // Catch: Throwable -> L26
        r1 = r4;
    L26:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setStatus(PrintJobId r5, int r6, CharSequence r7) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        boolean r1 = 1;
        r1 = 1;
        getRemoteInstanceLazy().setStatusRes(r5, r6, r7);     // Catch: Throwable -> L16 Throwable -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        Object r3 = this.mLock;     // Catch: Throwable -> L13
        r3.notifyAll();     // Catch: Throwable -> L13
        r1 = r3;
        monitor-exit(r2);     // Catch: Throwable -> L13
    L12:
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = r1;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error setting status.", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        Object r4 = this.mLock;     // Catch: Throwable -> L26
        r4.notifyAll();     // Catch: Throwable -> L26
        r1 = r4;
    L26:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    public final void onCustomPrinterIconLoaded(PrinterId printerId, Icon icon) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        this.mCustomPrinterIconLoadedCaller.onCustomPrinterIconLoaded(getRemoteInstanceLazy(), printerId, icon);     // Catch: Throwable -> L16 Throwable -> L18
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        this.mLock.notifyAll();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
    L25:
        return;
    L13:
        th = move-exception;
        throw th;
    L18:
        re = move-exception;
        Slog.e(LOG_TAG, "Error loading new custom printer icon.", re);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        this.mLock.notifyAll();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    public final Icon getCustomPrinterIcon(PrinterId printerId) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        Icon r1 = this.mGetCustomPrinterIconCaller.getCustomPrinterIcon(getRemoteInstanceLazy(), printerId);     // Catch: Throwable -> L16 Throwable -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        this.mLock.notifyAll();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error getting custom printer icon.", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        this.mLock.notifyAll();     // Catch: Throwable -> L26
        return null;
    L26:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    public void clearCustomPrinterIconCache() {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        this.mClearCustomPrinterIconCache.clearCustomPrinterIconCache(getRemoteInstanceLazy());     // Catch: Throwable -> L16 Throwable -> L18
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        this.mLock.notifyAll();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
    L25:
        return;
    L13:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error clearing custom printer icon cache.", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        this.mLock.notifyAll();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    public final boolean setPrintJobTag(PrintJobId printJobId, String tag) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L36
        this.mCanUnbind = false;     // Catch: Throwable -> L36
        monitor-exit(r0);     // Catch: Throwable -> L36
        boolean r1 = this.mSetPrintJobTagCaller.setPrintJobTag(getRemoteInstanceLazy(), printJobId, tag);     // Catch: Throwable -> L16 Throwable -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        this.mLock.notifyAll();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error setting print job tag.", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L25
        this.mLock.notifyAll();     // Catch: Throwable -> L25
        return false;
    L25:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L33
        this.mLock.notifyAll();     // Catch: Throwable -> L33
        throw th;
    L33:
        th = move-exception;
        throw th;
    L36:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPrintJobCancelling(PrintJobId r5, boolean r6) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        boolean r1 = 1;
        r1 = 1;
        getRemoteInstanceLazy().setPrintJobCancelling(r5, r6);     // Catch: Throwable -> L16 Throwable -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        Object r3 = this.mLock;     // Catch: Throwable -> L13
        r3.notifyAll();     // Catch: Throwable -> L13
        r1 = r3;
        monitor-exit(r2);     // Catch: Throwable -> L13
    L12:
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = r1;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error setting print job cancelling.", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        Object r4 = this.mLock;     // Catch: Throwable -> L26
        r4.notifyAll();     // Catch: Throwable -> L26
        r1 = r4;
    L26:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void pruneApprovedPrintServices(List<ComponentName> r5) {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        boolean r1 = 1;
        r1 = 1;
        getRemoteInstanceLazy().pruneApprovedPrintServices(r5);     // Catch: Throwable -> L16 Throwable -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        Object r3 = this.mLock;     // Catch: Throwable -> L13
        r3.notifyAll();     // Catch: Throwable -> L13
        r1 = r3;
        monitor-exit(r2);     // Catch: Throwable -> L13
    L12:
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = r1;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error pruning approved print services.", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        Object r4 = this.mLock;     // Catch: Throwable -> L26
        r4.notifyAll();     // Catch: Throwable -> L26
        r1 = r4;
    L26:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeObsoletePrintJobs() {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L37
        this.mCanUnbind = false;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        boolean r1 = 1;
        r1 = 1;
        getRemoteInstanceLazy().removeObsoletePrintJobs();     // Catch: Throwable -> L16 Throwable -> L18
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mCanUnbind = true;     // Catch: Throwable -> L13
        Object r3 = this.mLock;     // Catch: Throwable -> L13
        r3.notifyAll();     // Catch: Throwable -> L13
        r1 = r3;
        monitor-exit(r2);     // Catch: Throwable -> L13
    L12:
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mCanUnbind = r1;     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error removing obsolete print jobs .", e);     // Catch: Throwable -> L16
        monitor-enter(this.mLock);
        this.mCanUnbind = true;     // Catch: Throwable -> L26
        Object r4 = this.mLock;     // Catch: Throwable -> L26
        r4.notifyAll();     // Catch: Throwable -> L26
        r1 = r4;
    L26:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    public final void destroy() {
        throwIfCalledOnMainThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L7
        unbindLocked();     // Catch: Throwable -> L7
        this.mDestroyed = true;     // Catch: Throwable -> L7
        this.mCanUnbind = false;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(DualDumpOutputStream dumpStream) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        dumpStream.write("is_destroyed", 1133871366145L, this.mDestroyed);     // Catch: Throwable -> L19
        if (this.mRemoteInstance == null) goto L7;
        boolean r2 = true;
    L8:
        dumpStream.write("is_bound", 1133871366146L, r2);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
    L13:
        e = move-exception;
        Slog.e(LOG_TAG, "Failed to dump remote instance", e);
        return;
    L11:
        if (dumpStream.isProto() == false) goto L15;
        dumpStream.write(null, 1146756268035L, TransferPipe.dumpAsync(getRemoteInstanceLazy().asBinder(), new String[]{"--proto"}));     // Catch: Throwable -> L13
    L24:
        return;
    L15:
        dumpStream.writeNested("internal_state", TransferPipe.dumpAsync(getRemoteInstanceLazy().asBinder(), new String[0]));     // Catch: Throwable -> L13
        goto L24
    L7:
        r2 = false;
    L19:
        th = move-exception;
        throw th;
    }

    private void onAllPrintJobsHandled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L7
        unbindLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onPrintJobStateChanged(PrintJobInfo printJob) {
        this.mCallbacks.onPrintJobStateChanged(printJob);
    }

    private IPrintSpooler getRemoteInstanceLazy() throws TimeoutException, InterruptedException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mRemoteInstance == null) goto L11;
        IPrintSpooler r1 = this.mRemoteInstance;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        bindLocked();     // Catch: Throwable -> L9
        IPrintSpooler r2 = this.mRemoteInstance;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    }

    private void bindLocked() throws TimeoutException, InterruptedException {
    L3:
        if (this.mIsBinding == false) goto L6;
        this.mLock.wait();
        goto L3
    L6:
        if (this.mRemoteInstance == null) goto L8;
        return;
    L8:
        this.mIsBinding = true;
    L19:
        th = move-exception;
        this.mIsBinding = false;
        this.mLock.notifyAll();
        throw th;
    L10:
        if (this.mIsLowPriority == false) goto L12;
        int flags = 1;
    L13:
        this.mContext.bindServiceAsUser(this.mIntent, this.mServiceConnection, flags, this.mUserHandle);     // Catch: Throwable -> L19
        long startMillis = SystemClock.uptimeMillis();     // Catch: Throwable -> L19
    L15:
        if (this.mRemoteInstance != null) goto L16;
        long elapsedMillis = SystemClock.uptimeMillis() - startMillis;     // Catch: Throwable -> L19
        long remainingMillis = BIND_SPOOLER_SERVICE_TIMEOUT - elapsedMillis;     // Catch: Throwable -> L19
        if (remainingMillis <= 0) goto L25;
        this.mLock.wait(remainingMillis);     // Catch: Throwable -> L19
        goto L15
    L25:
        throw new TimeoutException("Cannot get spooler!");     // Catch: Throwable -> L19
    L16:
        this.mCanUnbind = true;     // Catch: Throwable -> L19
        this.mIsBinding = false;
        this.mLock.notifyAll();
        return;
    L12:
        flags = AudioFormat.AAC_MAIN;
        goto L13
    }

    private void unbindLocked() {
        if (this.mRemoteInstance != null) goto L6;
        return;
    L6:
        if (this.mCanUnbind == true) goto L7;
        this.mLock.wait();     // Catch: InterruptedException -> L11
        goto L6
    L7:
        clearClientLocked();
        this.mRemoteInstance = null;
        this.mContext.unbindService(this.mServiceConnection);
    }

    private void setClientLocked() {
        this.mRemoteInstance.setClient(this.mClient);     // Catch: RemoteException -> L4
        return;
    L4:
        re = move-exception;
        Slog.d(LOG_TAG, "Error setting print spooler client", re);
    }

    private void clearClientLocked() {
        this.mRemoteInstance.setClient(null);     // Catch: RemoteException -> L4
        return;
    L4:
        re = move-exception;
        Slog.d(LOG_TAG, "Error clearing print spooler client", re);
    }

    private void throwIfDestroyedLocked() {
        if (this.mDestroyed == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot interact with a destroyed instance.");
    }

    private void throwIfCalledOnMainThread() {
        if (Thread.currentThread() == this.mContext.getMainLooper().getThread()) goto L6;
        return;
    L6:
        throw new RuntimeException("Cannot invoke on the main thread");
    }
}
