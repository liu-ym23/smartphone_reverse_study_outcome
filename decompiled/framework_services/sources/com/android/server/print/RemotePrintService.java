package com.android.server.print;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ParceledListSlice;
import android.graphics.drawable.Icon;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.UserHandle;
import android.print.PrintJobId;
import android.print.PrintJobInfo;
import android.print.PrinterId;
import android.print.PrinterInfo;
import android.printservice.IPrintService;
import android.printservice.IPrintServiceClient;
import android.util.Slog;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.internal.util.dump.DumpUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class RemotePrintService implements IBinder.DeathRecipient {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "RemotePrintService";
    private boolean mBinding;
    private final PrintServiceCallbacks mCallbacks;
    private final ComponentName mComponentName;
    private final Context mContext;
    private boolean mDestroyed;
    private List<PrinterId> mDiscoveryPriorityList;
    private boolean mHasActivePrintJobs;
    private boolean mHasPrinterDiscoverySession;
    private final Intent mIntent;
    private final Object mLock;
    private final List<Runnable> mPendingCommands;
    private IPrintService mPrintService;
    private final RemotePrintServiceClient mPrintServiceClient;
    private final ServiceConnection mServiceConnection;
    private boolean mServiceDied;
    private final RemotePrintSpooler mSpooler;
    private List<PrinterId> mTrackedPrinterList;
    private final int mUserId;

    public interface PrintServiceCallbacks {
        void onCustomPrinterIconLoaded(PrinterId r1, Icon r2);

        void onPrintersAdded(List<PrinterInfo> r1);

        void onPrintersRemoved(List<PrinterId> r1);

        void onServiceDied(RemotePrintService r1);
    }

    private static final class RemotePrintServiceClient extends IPrintServiceClient.Stub {
        private final WeakReference<RemotePrintService> mWeakService;

        public RemotePrintServiceClient(RemotePrintService service) {
            this.mWeakService = new WeakReference(service);
        }

        public List<PrintJobInfo> getPrintJobInfos() {
            RemotePrintService service = this.mWeakService.get();
            if (service == null) goto L11;
            long identity = Binder.clearCallingIdentity();
            List<PrintJobInfo> r3 = RemotePrintService.m7916$$Nest$fgetmSpooler(service).getPrintJobInfos(RemotePrintService.m7904$$Nest$fgetmComponentName(service), -4, -2);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return r3;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L11:
            return null;
        }

        public PrintJobInfo getPrintJobInfo(PrintJobId printJobId) {
            RemotePrintService service = this.mWeakService.get();
            if (service == null) goto L11;
            long identity = Binder.clearCallingIdentity();
            PrintJobInfo r3 = RemotePrintService.m7916$$Nest$fgetmSpooler(service).getPrintJobInfo(printJobId, -2);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return r3;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L11:
            return null;
        }

        public boolean setPrintJobState(PrintJobId printJobId, int state, String error) {
            RemotePrintService service = this.mWeakService.get();
            if (service == null) goto L11;
            long identity = Binder.clearCallingIdentity();
            boolean r3 = RemotePrintService.m7916$$Nest$fgetmSpooler(service).setPrintJobState(printJobId, state, error);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return r3;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L11:
            return false;
        }

        public boolean setPrintJobTag(PrintJobId printJobId, String tag) {
            RemotePrintService service = this.mWeakService.get();
            if (service == null) goto L11;
            long identity = Binder.clearCallingIdentity();
            boolean r3 = RemotePrintService.m7916$$Nest$fgetmSpooler(service).setPrintJobTag(printJobId, tag);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return r3;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L11:
            return false;
        }

        public void writePrintJobData(ParcelFileDescriptor fd, PrintJobId printJobId) {
            RemotePrintService service = this.mWeakService.get();
            if (service == null) goto L10;
            long identity = Binder.clearCallingIdentity();
            RemotePrintService.m7916$$Nest$fgetmSpooler(service).writePrintJobData(fd, printJobId);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setProgress(PrintJobId printJobId, float progress) {
            RemotePrintService service = this.mWeakService.get();
            if (service == null) goto L10;
            long identity = Binder.clearCallingIdentity();
            RemotePrintService.m7916$$Nest$fgetmSpooler(service).setProgress(printJobId, progress);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setStatus(PrintJobId printJobId, CharSequence status) {
            RemotePrintService service = this.mWeakService.get();
            if (service == null) goto L10;
            long identity = Binder.clearCallingIdentity();
            RemotePrintService.m7916$$Nest$fgetmSpooler(service).setStatus(printJobId, status);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setStatusRes(PrintJobId printJobId, int status, CharSequence appPackageName) {
            RemotePrintService service = this.mWeakService.get();
            if (service == null) goto L10;
            long identity = Binder.clearCallingIdentity();
            RemotePrintService.m7916$$Nest$fgetmSpooler(service).setStatus(printJobId, status, appPackageName);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void onPrintersAdded(ParceledListSlice printers) {
            RemotePrintService service = this.mWeakService.get();
            if (service == null) goto L10;
            List<PrinterInfo> addedPrinters = printers.getList();
            throwIfPrinterIdsForPrinterInfoTampered(RemotePrintService.m7904$$Nest$fgetmComponentName(service), addedPrinters);
            long identity = Binder.clearCallingIdentity();
            RemotePrintService.m7903$$Nest$fgetmCallbacks(service).onPrintersAdded(addedPrinters);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void onPrintersRemoved(ParceledListSlice printerIds) {
            RemotePrintService service = this.mWeakService.get();
            if (service == null) goto L10;
            List<PrinterId> removedPrinterIds = printerIds.getList();
            throwIfPrinterIdsTampered(RemotePrintService.m7904$$Nest$fgetmComponentName(service), removedPrinterIds);
            long identity = Binder.clearCallingIdentity();
            RemotePrintService.m7903$$Nest$fgetmCallbacks(service).onPrintersRemoved(removedPrinterIds);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private void throwIfPrinterIdsForPrinterInfoTampered(ComponentName serviceName, List<PrinterInfo> printerInfos) {
            int printerInfoCount = printerInfos.size();
            int i = 0;
        L3:
            if (i >= printerInfoCount) goto L6;
            PrinterId printerId = printerInfos.get(i).getId();
            throwIfPrinterIdTampered(serviceName, printerId);
            i = i + 1;
            goto L3
        }

        private void throwIfPrinterIdsTampered(ComponentName serviceName, List<PrinterId> printerIds) {
            int printerIdCount = printerIds.size();
            int i = 0;
        L3:
            if (i >= printerIdCount) goto L6;
            PrinterId printerId = printerIds.get(i);
            throwIfPrinterIdTampered(serviceName, printerId);
            i = i + 1;
            goto L3
        }

        private void throwIfPrinterIdTampered(ComponentName serviceName, PrinterId printerId) {
            if (printerId == null) goto L7;
            if (printerId.getServiceName().equals(serviceName) == false) goto L7;
            return;
        L7:
            throw new IllegalArgumentException("Invalid printer id: " + printerId);
        }

        public void onCustomPrinterIconLoaded(PrinterId printerId, Icon icon) throws RemoteException {
            RemotePrintService service = this.mWeakService.get();
            if (service == null) goto L10;
            long identity = Binder.clearCallingIdentity();
            RemotePrintService.m7903$$Nest$fgetmCallbacks(service).onCustomPrinterIconLoaded(printerId, icon);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }
    }

    private class RemoteServiceConneciton implements ServiceConnection {
        final /* synthetic */ RemotePrintService this$0;

        /* synthetic */ RemoteServiceConneciton(RemotePrintService r1, RemotePrintServiceIA r2) {
            this(r1);
        }

        private RemoteServiceConneciton(RemotePrintService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            if (RemotePrintService.m7906$$Nest$fgetmDestroyed(this.this$0) == false) goto L5;
        L50:
            RemotePrintService.m7905$$Nest$fgetmContext(this.this$0).unbindService(RemotePrintService.m7914$$Nest$fgetmServiceConnection(this.this$0));
            return;
        L5:
            if (RemotePrintService.m7902$$Nest$fgetmBinding(this.this$0) == false) goto L50;
            RemotePrintService.m7918$$Nest$fputmBinding(this.this$0, false);
            RemotePrintService.m7919$$Nest$fputmPrintService(this.this$0, IPrintService.Stub.asInterface(service));
            service.linkToDeath(this.this$0, 0);     // Catch: RemoteException -> L47
            RemotePrintService.m7912$$Nest$fgetmPrintService(this.this$0).setClient(RemotePrintService.m7913$$Nest$fgetmPrintServiceClient(this.this$0));     // Catch: RemoteException -> L44
            if (RemotePrintService.m7915$$Nest$fgetmServiceDied(this.this$0) == false) goto L16;
            if (RemotePrintService.m7909$$Nest$fgetmHasPrinterDiscoverySession(this.this$0) == false) goto L16;
            RemotePrintService.m7923$$Nest$mhandleCreatePrinterDiscoverySession(this.this$0);
        L16:
            if (RemotePrintService.m7915$$Nest$fgetmServiceDied(this.this$0) == true) goto L18;
        L20:
            Object r0 = RemotePrintService.m7910$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L29:
            th = move-exception;
            throw th;
        L23:
            if (RemotePrintService.m7915$$Nest$fgetmServiceDied(this.this$0) == true) goto L25;
        L31:
            monitor-exit(r0);     // Catch: Throwable -> L29
        L33:
            if (RemotePrintService.m7911$$Nest$fgetmPendingCommands(this.this$0).isEmpty() == true) goto L36;
            Runnable pendingCommand = (Runnable) RemotePrintService.m7911$$Nest$fgetmPendingCommands(this.this$0).remove(0);
            pendingCommand.run();
            goto L33
        L36:
            if (RemotePrintService.m7909$$Nest$fgetmHasPrinterDiscoverySession(this.this$0) == false) goto L38;
        L40:
            RemotePrintService.m7920$$Nest$fputmServiceDied(this.this$0, false);
            return;
        L38:
            if (RemotePrintService.m7908$$Nest$fgetmHasActivePrintJobs(this.this$0) == true) goto L40;
            RemotePrintService.m7921$$Nest$mensureUnbound(this.this$0);
            goto L40
        L25:
            if (RemotePrintService.m7917$$Nest$fgetmTrackedPrinterList(this.this$0) == null) goto L31;
            int trackedPrinterCount = RemotePrintService.m7917$$Nest$fgetmTrackedPrinterList(this.this$0).size();     // Catch: Throwable -> L29
            int i = 0;
        L27:
            if (i >= trackedPrinterCount) goto L31;
            RemotePrintService.m7929$$Nest$mhandleStartPrinterStateTracking(this.this$0, (PrinterId) RemotePrintService.m7917$$Nest$fgetmTrackedPrinterList(this.this$0).get(i));     // Catch: Throwable -> L29
            i = i + 1;     // Catch: Throwable -> L29
            goto L27
        L18:
            if (RemotePrintService.m7907$$Nest$fgetmDiscoveryPriorityList(this.this$0) == null) goto L20;
            RemotePrintService.m7928$$Nest$mhandleStartPrinterDiscovery(this.this$0, RemotePrintService.m7907$$Nest$fgetmDiscoveryPriorityList(this.this$0));
        L44:
            re = move-exception;
            Slog.e(RemotePrintService.LOG_TAG, "Error setting client for: " + service, re);
            RemotePrintService.m7922$$Nest$mhandleBinderDied(this.this$0);
            return;
        L48:
            RemotePrintService.m7922$$Nest$mhandleBinderDied(this.this$0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            RemotePrintService.m7918$$Nest$fputmBinding(this.this$0, true);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-nst9wg0OGFoVWt-WNv8g2m4ADc, reason: not valid java name */
    public static /* synthetic */ void m7897$r8$lambda$nst9wg0OGFoVWtWNv8g2m4ADc(RemotePrintService r0, PrintJobInfo r1) {
        r0.handleOnPrintJobQueued(r1);
    }

    public static /* synthetic */ void $r8$lambda$92qc23hgKuJl_NjcBLAZHZjsP2Q(RemotePrintService r0) {
        r0.handleStopPrinterDiscovery();
    }

    /* JADX INFO: renamed from: $r8$lambda$Fju7-nBwuiEtoap6zGytV-Zcd-Y, reason: not valid java name */
    public static /* synthetic */ void m7898$r8$lambda$Fju7nBwuiEtoap6zGytVZcdY(RemotePrintService r0, PrinterId r1) {
        r0.lambda$handleRequestCustomPrinterIcon$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Mr-Bh-RKGe4sQIAvAIPlAOJh8x4, reason: not valid java name */
    public static /* synthetic */ void m7899$r8$lambda$MrBhRKGe4sQIAvAIPlAOJh8x4(RemotePrintService r0) {
        r0.handleDestroyPrinterDiscoverySession();
    }

    public static /* synthetic */ void $r8$lambda$SfFb4FyuyTeggl1rmLjkGRBbNjM(RemotePrintService r0) {
        r0.handleCreatePrinterDiscoverySession();
    }

    public static /* synthetic */ void $r8$lambda$e6sMxRRj4jbOUp6Q9feiUDKgQ94(RemotePrintService r0, List r1) {
        r0.handleValidatePrinters(r1);
    }

    public static /* synthetic */ void $r8$lambda$iAhvxCqDRQiItC2o973LGH_1xwU(RemotePrintService r0, PrinterId r1) {
        r0.handleStopPrinterStateTracking(r1);
    }

    public static /* synthetic */ void $r8$lambda$ilTJ5mT9u5V6gEFn3v2geV_YhXs(RemotePrintService r0) {
        r0.handleOnAllPrintJobsHandled();
    }

    /* JADX INFO: renamed from: $r8$lambda$ncr8Pk-XEu0yvoOq5n1S-2-o41s, reason: not valid java name */
    public static /* synthetic */ void m7900$r8$lambda$ncr8PkXEu0yvoOq5n1S2o41s(RemotePrintService r0, PrinterId r1) {
        r0.handleRequestCustomPrinterIcon(r1);
    }

    public static /* synthetic */ void $r8$lambda$oEn_VVsWTFBnknx4JEUF4nFMcJo(RemotePrintService r0) {
        r0.handleDestroy();
    }

    public static /* synthetic */ void $r8$lambda$pIFmaIit_Y4GPeVuaPBzlzpmPuA(RemotePrintService r0, PrinterId r1) {
        r0.handleStartPrinterStateTracking(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$pt8QTz2qe8N3xc3ZCGLFc-zMYVs, reason: not valid java name */
    public static /* synthetic */ void m7901$r8$lambda$pt8QTz2qe8N3xc3ZCGLFczMYVs(RemotePrintService r0, PrintJobInfo r1) {
        r0.handleRequestCancelPrintJob(r1);
    }

    public static /* synthetic */ void $r8$lambda$qUlVgxEuzd2N1jxoqULDYERZc28(RemotePrintService r0, List r1) {
        r0.handleStartPrinterDiscovery(r1);
    }

    public static /* synthetic */ void $r8$lambda$zqvfL4OvTBPKNT2K7H1fwUbNP_M(RemotePrintService r0) {
        r0.handleBinderDied();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBinding, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7902$$Nest$fgetmBinding(RemotePrintService r0) {
        return r0.mBinding;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ PrintServiceCallbacks m7903$$Nest$fgetmCallbacks(RemotePrintService r0) {
        return r0.mCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmComponentName, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m7904$$Nest$fgetmComponentName(RemotePrintService r0) {
        return r0.mComponentName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7905$$Nest$fgetmContext(RemotePrintService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDestroyed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7906$$Nest$fgetmDestroyed(RemotePrintService r0) {
        return r0.mDestroyed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDiscoveryPriorityList, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m7907$$Nest$fgetmDiscoveryPriorityList(RemotePrintService r0) {
        return r0.mDiscoveryPriorityList;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHasActivePrintJobs, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7908$$Nest$fgetmHasActivePrintJobs(RemotePrintService r0) {
        return r0.mHasActivePrintJobs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHasPrinterDiscoverySession, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7909$$Nest$fgetmHasPrinterDiscoverySession(RemotePrintService r0) {
        return r0.mHasPrinterDiscoverySession;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7910$$Nest$fgetmLock(RemotePrintService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingCommands, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m7911$$Nest$fgetmPendingCommands(RemotePrintService r0) {
        return r0.mPendingCommands;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPrintService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IPrintService m7912$$Nest$fgetmPrintService(RemotePrintService r0) {
        return r0.mPrintService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPrintServiceClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemotePrintServiceClient m7913$$Nest$fgetmPrintServiceClient(RemotePrintService r0) {
        return r0.mPrintServiceClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ ServiceConnection m7914$$Nest$fgetmServiceConnection(RemotePrintService r0) {
        return r0.mServiceConnection;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7915$$Nest$fgetmServiceDied(RemotePrintService r0) {
        return r0.mServiceDied;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSpooler, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemotePrintSpooler m7916$$Nest$fgetmSpooler(RemotePrintService r0) {
        return r0.mSpooler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrackedPrinterList, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m7917$$Nest$fgetmTrackedPrinterList(RemotePrintService r0) {
        return r0.mTrackedPrinterList;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBinding, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7918$$Nest$fputmBinding(RemotePrintService r0, boolean r1) {
        r0.mBinding = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPrintService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7919$$Nest$fputmPrintService(RemotePrintService r0, IPrintService r1) {
        r0.mPrintService = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmServiceDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7920$$Nest$fputmServiceDied(RemotePrintService r0, boolean r1) {
        r0.mServiceDied = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mensureUnbound, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7921$$Nest$mensureUnbound(RemotePrintService r0) {
        r0.ensureUnbound();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleBinderDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7922$$Nest$mhandleBinderDied(RemotePrintService r0) {
        r0.handleBinderDied();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleCreatePrinterDiscoverySession, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7923$$Nest$mhandleCreatePrinterDiscoverySession(RemotePrintService r0) {
        r0.handleCreatePrinterDiscoverySession();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleDestroyPrinterDiscoverySession, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7924$$Nest$mhandleDestroyPrinterDiscoverySession(RemotePrintService r0) {
        r0.handleDestroyPrinterDiscoverySession();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnAllPrintJobsHandled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7925$$Nest$mhandleOnAllPrintJobsHandled(RemotePrintService r0) {
        r0.handleOnAllPrintJobsHandled();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnPrintJobQueued, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7926$$Nest$mhandleOnPrintJobQueued(RemotePrintService r0, PrintJobInfo r1) {
        r0.handleOnPrintJobQueued(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleRequestCancelPrintJob, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7927$$Nest$mhandleRequestCancelPrintJob(RemotePrintService r0, PrintJobInfo r1) {
        r0.handleRequestCancelPrintJob(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleStartPrinterDiscovery, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7928$$Nest$mhandleStartPrinterDiscovery(RemotePrintService r0, List r1) {
        r0.handleStartPrinterDiscovery(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleStartPrinterStateTracking, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7929$$Nest$mhandleStartPrinterStateTracking(RemotePrintService r0, PrinterId r1) {
        r0.handleStartPrinterStateTracking(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleStopPrinterDiscovery, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7930$$Nest$mhandleStopPrinterDiscovery(RemotePrintService r0) {
        r0.handleStopPrinterDiscovery();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleStopPrinterStateTracking, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7931$$Nest$mhandleStopPrinterStateTracking(RemotePrintService r0, PrinterId r1) {
        r0.handleStopPrinterStateTracking(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleValidatePrinters, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7932$$Nest$mhandleValidatePrinters(RemotePrintService r0, List r1) {
        r0.handleValidatePrinters(r1);
    }

    public RemotePrintService(Context context, ComponentName componentName, int userId, RemotePrintSpooler spooler, PrintServiceCallbacks callbacks) {
        this.mLock = new Object();
        this.mPendingCommands = new ArrayList();
        this.mServiceConnection = new RemoteServiceConneciton(this, null);
        this.mContext = context;
        this.mCallbacks = callbacks;
        this.mComponentName = componentName;
        this.mIntent = new Intent().setComponent(this.mComponentName);
        this.mUserId = userId;
        this.mSpooler = spooler;
        this.mPrintServiceClient = new RemotePrintServiceClient(this);
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public void destroy() {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda13(), this));
    }

    private void handleDestroy() {
        stopTrackingAllPrinters();
        if (this.mDiscoveryPriorityList == null) goto L6;
        handleStopPrinterDiscovery();
    L6:
        if (this.mHasPrinterDiscoverySession == false) goto L8;
        handleDestroyPrinterDiscoverySession();
    L8:
        ensureUnbound();
        this.mDestroyed = true;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda2(), this));
    }

    private void handleBinderDied() {
        if (this.mPrintService == null) goto L5;
        this.mPrintService.asBinder().unlinkToDeath(this, 0);
    L5:
        this.mPrintService = null;
        this.mServiceDied = true;
        this.mCallbacks.onServiceDied(this);
    }

    public void onAllPrintJobsHandled() {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda12(), this));
    }

    private void handleOnAllPrintJobsHandled() {
        this.mHasActivePrintJobs = false;
        if (isBound() == true) goto L12;
        if (this.mServiceDied == true) goto L7;
    L10:
        ensureBound();
        this.mPendingCommands.add(new AnonymousClass1(this));
        return;
    L7:
        if (this.mHasPrinterDiscoverySession == true) goto L10;
        ensureUnbound();
        return;
    L12:
        if (this.mHasPrinterDiscoverySession == true) goto L16;
        ensureUnbound();
        return;
    }

    public void onRequestCancelPrintJob(PrintJobInfo printJob) {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda10(), this, printJob));
    }

    private void handleRequestCancelPrintJob(final PrintJobInfo printJob) {
        if (isBound() == true) goto L10;
        ensureBound();
        this.mPendingCommands.add(new AnonymousClass2(this, printJob));
        return;
    L10:
        this.mPrintService.requestCancelPrintJob(printJob);     // Catch: RemoteException -> L7
        return;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error canceling a pring job.", re);
    }

    public void onPrintJobQueued(PrintJobInfo printJob) {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda6(), this, printJob));
    }

    private void handleOnPrintJobQueued(final PrintJobInfo printJob) {
        this.mHasActivePrintJobs = true;
        if (isBound() == true) goto L10;
        ensureBound();
        this.mPendingCommands.add(new AnonymousClass3(this, printJob));
        return;
    L10:
        this.mPrintService.onPrintJobQueued(printJob);     // Catch: RemoteException -> L7
        return;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error announcing queued pring job.", re);
    }

    public void createPrinterDiscoverySession() {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda3(), this));
    }

    private void handleCreatePrinterDiscoverySession() {
        this.mHasPrinterDiscoverySession = true;
        if (isBound() == true) goto L10;
        ensureBound();
        this.mPendingCommands.add(new AnonymousClass4(this));
        return;
    L10:
        this.mPrintService.createPrinterDiscoverySession();     // Catch: RemoteException -> L7
        return;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error creating printer discovery session.", re);
    }

    public void destroyPrinterDiscoverySession() {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda9(), this));
    }

    private void handleDestroyPrinterDiscoverySession() {
        this.mHasPrinterDiscoverySession = false;
        if (isBound() == false) goto L5;
        this.mPrintService.destroyPrinterDiscoverySession();     // Catch: RemoteException -> L13
    L16:
        if (this.mHasActivePrintJobs == true) goto L22;
        ensureUnbound();
        return;
    L22:
        return;
    L13:
        re = move-exception;
        Slog.e(LOG_TAG, "Error destroying printer dicovery session.", re);
        goto L16
    L5:
        if (this.mServiceDied == true) goto L7;
    L10:
        ensureBound();
        this.mPendingCommands.add(new AnonymousClass5(this));
        return;
    L7:
        if (this.mHasActivePrintJobs == true) goto L10;
        ensureUnbound();
    }

    public void startPrinterDiscovery(List<PrinterId> priorityList) {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda0(), this, priorityList));
    }

    private void handleStartPrinterDiscovery(final List<PrinterId> priorityList) {
        this.mDiscoveryPriorityList = new ArrayList();
        if (priorityList == null) goto L6;
        this.mDiscoveryPriorityList.addAll(priorityList);
    L6:
        if (isBound() == true) goto L13;
        ensureBound();
        this.mPendingCommands.add(new AnonymousClass6(this, priorityList));
        return;
    L13:
        this.mPrintService.startPrinterDiscovery(priorityList);     // Catch: RemoteException -> L10
        return;
    L10:
        re = move-exception;
        Slog.e(LOG_TAG, "Error starting printer dicovery.", re);
    }

    public void stopPrinterDiscovery() {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda1(), this));
    }

    private void handleStopPrinterDiscovery() {
        this.mDiscoveryPriorityList = null;
        if (isBound() == true) goto L5;
        ensureBound();
        this.mPendingCommands.add(new AnonymousClass7(this));
        return;
    L5:
        stopTrackingAllPrinters();
        this.mPrintService.stopPrinterDiscovery();     // Catch: RemoteException -> L8
        return;
    L8:
        re = move-exception;
        Slog.e(LOG_TAG, "Error stopping printer discovery.", re);
    }

    public void validatePrinters(List<PrinterId> printerIds) {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda11(), this, printerIds));
    }

    private void handleValidatePrinters(final List<PrinterId> printerIds) {
        if (isBound() == true) goto L10;
        ensureBound();
        this.mPendingCommands.add(new AnonymousClass8(this, printerIds));
        return;
    L10:
        this.mPrintService.validatePrinters(printerIds);     // Catch: RemoteException -> L7
        return;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error requesting printers validation.", re);
    }

    public void startPrinterStateTracking(PrinterId printerId) {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda7(), this, printerId));
    }

    public void requestCustomPrinterIcon(PrinterId printerId) {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda4(), this, printerId));
    }

    private void handleRequestCustomPrinterIcon(final PrinterId printerId) {
        if (isBound() == true) goto L10;
        ensureBound();
        this.mPendingCommands.add(new RemotePrintService$$ExternalSyntheticLambda8(this, printerId));
        return;
    L10:
        this.mPrintService.requestCustomPrinterIcon(printerId);     // Catch: RemoteException -> L7
        return;
    L7:
        re = move-exception;
        Slog.e(LOG_TAG, "Error requesting icon for " + printerId, re);
    }

    private /* synthetic */ void lambda$handleRequestCustomPrinterIcon$0(PrinterId printerId) {
        handleRequestCustomPrinterIcon(printerId);
    }

    private void handleStartPrinterStateTracking(final PrinterId printerId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mTrackedPrinterList != null) goto L9;
        this.mTrackedPrinterList = new ArrayList();     // Catch: Throwable -> L7
    L9:
        this.mTrackedPrinterList.add(printerId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        if (isBound() == true) goto L21;
        ensureBound();
        this.mPendingCommands.add(new AnonymousClass9(this, printerId));
        return;
    L21:
        this.mPrintService.startPrinterStateTracking(printerId);     // Catch: RemoteException -> L16
        return;
    L16:
        re = move-exception;
        Slog.e(LOG_TAG, "Error requesting start printer tracking.", re);
    }

    public void stopPrinterStateTracking(PrinterId printerId) {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new RemotePrintService$$ExternalSyntheticLambda5(), this, printerId));
    }

    private void handleStopPrinterStateTracking(final PrinterId printerId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mTrackedPrinterList == null) goto L23;
        if (this.mTrackedPrinterList.remove(printerId) == false) goto L23;
        if (this.mTrackedPrinterList.isEmpty() == false) goto L14;
        this.mTrackedPrinterList = null;     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (isBound() == true) goto L27;
        ensureBound();
        this.mPendingCommands.add(new AnonymousClass10(this, printerId));
        return;
    L27:
        this.mPrintService.stopPrinterStateTracking(printerId);     // Catch: RemoteException -> L20
        return;
    L20:
        re = move-exception;
        Slog.e(LOG_TAG, "Error requesting stop printer tracking.", re);
        return;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    private void stopTrackingAllPrinters() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mTrackedPrinterList != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int trackedPrinterCount = this.mTrackedPrinterList.size();     // Catch: Throwable -> L8
        int i = trackedPrinterCount - 1;     // Catch: Throwable -> L8
    L11:
        if (i < 0) goto L17;
        PrinterId printerId = this.mTrackedPrinterList.get(i);     // Catch: Throwable -> L8
        if (printerId.getServiceName().equals(this.mComponentName) == false) goto L15;
        handleStopPrinterStateTracking(printerId);     // Catch: Throwable -> L8
    L15:
        i = i - 1;     // Catch: Throwable -> L8
        goto L11
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void dump(DualDumpOutputStream proto) {
        DumpUtils.writeComponentName(proto, "component_name", 1146756268033L, this.mComponentName);
        proto.write("is_destroyed", 1133871366146L, this.mDestroyed);
        proto.write("is_bound", 1133871366147L, isBound());
        proto.write("has_discovery_session", 1133871366148L, this.mHasPrinterDiscoverySession);
        proto.write("has_active_print_jobs", 1133871366149L, this.mHasActivePrintJobs);
        if (this.mDiscoveryPriorityList == null) goto L5;
        boolean r1 = true;
    L6:
        proto.write("is_discovering_printers", 1133871366150L, r1);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mTrackedPrinterList == null) goto L15;
        int numTrackedPrinters = this.mTrackedPrinterList.size();     // Catch: Throwable -> L13
        int i = 0;
    L11:
        if (i >= numTrackedPrinters) goto L15;
        com.android.internal.print.DumpUtils.writePrinterId(proto, "tracked_printers", 2246267895815L, this.mTrackedPrinterList.get(i));     // Catch: Throwable -> L13
        i = i + 1;     // Catch: Throwable -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L5:
        r1 = false;
        goto L6
    }

    private boolean isBound() {
        if (this.mPrintService == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void ensureBound() {
        if (isBound() == false) goto L5;
        return;
    L5:
        if (this.mBinding == true) goto L16;
        this.mBinding = true;
        boolean wasBound = this.mContext.bindServiceAsUser(this.mIntent, this.mServiceConnection, 71303169, new UserHandle(this.mUserId));
        if (wasBound == true) goto L14;
        this.mBinding = false;
        if (this.mServiceDied == true) goto L15;
        handleBinderDied();
        return;
    L15:
        return;
    L14:
        return;
    }

    private void ensureUnbound() {
        if (isBound() == false) goto L5;
    L7:
        this.mBinding = false;
        this.mPendingCommands.clear();
        this.mHasActivePrintJobs = false;
        this.mHasPrinterDiscoverySession = false;
        this.mDiscoveryPriorityList = null;
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mTrackedPrinterList = null;     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        if (isBound() == false) goto L25;
        this.mPrintService.setClient(null);     // Catch: RemoteException -> L15
    L16:
        this.mPrintService.asBinder().unlinkToDeath(this, 0);
        this.mPrintService = null;
        this.mContext.unbindService(this.mServiceConnection);
        return;
    L25:
        return;
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mBinding == true) goto L7;
    }
}
