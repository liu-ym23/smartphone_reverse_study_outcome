package com.android.server.print;

import android.R;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.UserHandle;
import android.print.IPrintDocumentAdapter;
import android.print.IPrintJobStateChangeListener;
import android.print.IPrintServicesChangeListener;
import android.print.IPrinterDiscoveryObserver;
import android.print.PrintAttributes;
import android.print.PrintJobId;
import android.print.PrintJobInfo;
import android.print.PrinterId;
import android.print.PrinterInfo;
import android.printservice.PrintServiceInfo;
import android.printservice.recommendation.IRecommendationsChangeListener;
import android.printservice.recommendation.RecommendationInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.os.BackgroundThread;
import com.android.internal.print.DumpUtils;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.internal.util.function.pooled.PooledLambda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntSupplier;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: loaded from: classes3.dex */
final class UserState implements RemotePrintSpooler.PrintSpoolerCallbacks, RemotePrintService.PrintServiceCallbacks, RemotePrintServiceRecommendationService.RemotePrintServiceRecommendationServiceCallbacks {
    private static final char COMPONENT_NAME_SEPARATOR = ':';
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "UserState";
    private static final int SERVICE_RESTART_DELAY_MILLIS = 500;
    private final ArrayMap<ComponentName, RemotePrintService> mActiveServices;
    private final Context mContext;
    private boolean mDestroyed;
    private final Set<ComponentName> mDisabledServices;
    private final List<PrintServiceInfo> mInstalledServices;
    private boolean mIsInstantServiceAllowed;
    private final Object mLock;
    private final PrintJobForAppCache mPrintJobForAppCache;
    private List<PrintJobStateChangeListenerRecord> mPrintJobStateChangeListenerRecords;
    private List<RecommendationInfo> mPrintServiceRecommendations;
    private List<ListenerRecord<IRecommendationsChangeListener>> mPrintServiceRecommendationsChangeListenerRecords;
    private RemotePrintServiceRecommendationService mPrintServiceRecommendationsService;
    private List<ListenerRecord<IPrintServicesChangeListener>> mPrintServicesChangeListenerRecords;
    private PrinterDiscoverySessionMediator mPrinterDiscoverySession;
    private final Intent mQueryIntent;
    private final RemotePrintSpooler mSpooler;
    private final TextUtils.SimpleStringSplitter mStringColonSplitter;
    private final int mUserId;

    private abstract class ListenerRecord<T extends IInterface> implements IBinder.DeathRecipient {
        final T listener;

        public abstract void onBinderDied();

        public ListenerRecord(UserState r2, T listener) throws RemoteException {
            this.listener = listener;
            listener.asBinder().linkToDeath(this, 0);
        }

        public void destroy() {
            this.listener.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.listener.asBinder().unlinkToDeath(this, 0);
            onBinderDied();
        }
    }

    private final class PrintJobForAppCache {
        private final SparseArray<List<PrintJobInfo>> mPrintJobsForRunningApp;
        final /* synthetic */ UserState this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmPrintJobsForRunningApp, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseArray m7956$$Nest$fgetmPrintJobsForRunningApp(PrintJobForAppCache r0) {
            return r0.mPrintJobsForRunningApp;
        }

        /* synthetic */ PrintJobForAppCache(UserState r1, UserStateIA r2) {
            this(r1);
        }

        private PrintJobForAppCache(UserState r1) {
            this.this$0 = r1;
            this.mPrintJobsForRunningApp = new SparseArray();
        }

        public boolean onPrintJobCreated(final IBinder creator, final int appId, PrintJobInfo printJob) {
            creator.linkToDeath(new AnonymousClass1(this, creator, appId), 0);     // Catch: RemoteException -> L17
            Object r1 = UserState.m7950$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            List<PrintJobInfo> printJobsForApp = this.mPrintJobsForRunningApp.get(appId);     // Catch: Throwable -> L9
            if (printJobsForApp != null) goto L11;
            printJobsForApp = new ArrayList();     // Catch: Throwable -> L9
            this.mPrintJobsForRunningApp.put(appId, printJobsForApp);     // Catch: Throwable -> L9
        L11:
            printJobsForApp.add(printJob);     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            return true;
        L9:
            th = move-exception;
            throw th;
        L18:
            return false;
        }

        public void onPrintJobStateChanged(PrintJobInfo printJob) {
            Object r0 = UserState.m7950$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            List<PrintJobInfo> printJobsForApp = this.mPrintJobsForRunningApp.get(printJob.getAppId());     // Catch: Throwable -> L8
            if (printJobsForApp != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            int printJobCount = printJobsForApp.size();     // Catch: Throwable -> L8
            int i = 0;
        L11:
            if (i >= printJobCount) goto L17;
            PrintJobInfo oldPrintJob = printJobsForApp.get(i);     // Catch: Throwable -> L8
            if (oldPrintJob.getId().equals(printJob.getId()) == false) goto L15;
            printJobsForApp.set(i, printJob);     // Catch: Throwable -> L8
        L15:
            i = i + 1;     // Catch: Throwable -> L8
            goto L11
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public PrintJobInfo getPrintJob(PrintJobId printJobId, int appId) {
            Object r0 = UserState.m7950$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            List<PrintJobInfo> printJobsForApp = this.mPrintJobsForRunningApp.get(appId);     // Catch: Throwable -> L8
            if (printJobsForApp != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L10:
            int printJobCount = printJobsForApp.size();     // Catch: Throwable -> L8
            int i = 0;
        L11:
            if (i >= printJobCount) goto L18;
            PrintJobInfo printJob = printJobsForApp.get(i);     // Catch: Throwable -> L8
            if (printJob.getId().equals(printJobId) == true) goto L14;
            i = i + 1;     // Catch: Throwable -> L8
            goto L11
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return printJob;
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L8:
            th = move-exception;
            throw th;
        }

        public List<PrintJobInfo> getPrintJobs(int appId) {
            Object r0 = UserState.m7950$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            List<PrintJobInfo> printJobs = null;
            if (appId != (-2)) goto L15;
            int bucketCount = this.mPrintJobsForRunningApp.size();     // Catch: Throwable -> L11
            int i = 0;
        L7:
            if (i >= bucketCount) goto L20;
            List<PrintJobInfo> bucket = this.mPrintJobsForRunningApp.valueAt(i);     // Catch: Throwable -> L11
            if (printJobs != null) goto L13;
            printJobs = new ArrayList();     // Catch: Throwable -> L11
        L13:
            printJobs.addAll(bucket);     // Catch: Throwable -> L11
            i = i + 1;     // Catch: Throwable -> L11
        L20:
            if (printJobs == null) goto L23;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return printJobs;
        L23:
            List<PrintJobInfo> r2 = Collections.emptyList();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L15:
            List<PrintJobInfo> bucket2 = this.mPrintJobsForRunningApp.get(appId);     // Catch: Throwable -> L11
            if (bucket2 == null) goto L20;
            if (0 != 0) goto L19;
            printJobs = new ArrayList();     // Catch: Throwable -> L11
        L19:
            printJobs.addAll(bucket2);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        public void dumpLocked(DualDumpOutputStream dumpStream) {
            int bucketCount = this.mPrintJobsForRunningApp.size();
            int i = 0;
        L3:
            if (i >= bucketCount) goto L9;
            int appId = this.mPrintJobsForRunningApp.keyAt(i);
            List<PrintJobInfo> bucket = this.mPrintJobsForRunningApp.valueAt(i);
            int printJobCount = bucket.size();
            int j = 0;
        L5:
            if (j >= printJobCount) goto L7;
            long token = dumpStream.start("cached_print_jobs", 2246267895813L);
            dumpStream.write("app_id", 1120986464257L, appId);
            DumpUtils.writePrintJobInfo(UserState.m7948$$Nest$fgetmContext(this.this$0), dumpStream, "print_job", 1146756268034L, bucket.get(j));
            dumpStream.end(token);
            j = j + 1;
            goto L5
        L7:
            i = i + 1;
            goto L3
        }
    }

    private abstract class PrintJobStateChangeListenerRecord implements IBinder.DeathRecipient {
        final int appId;
        final IPrintJobStateChangeListener listener;

        public abstract void onBinderDied();

        public PrintJobStateChangeListenerRecord(UserState r2, IPrintJobStateChangeListener listener, int appId) throws RemoteException {
            this.listener = listener;
            this.appId = appId;
            listener.asBinder().linkToDeath(this, 0);
        }

        public void destroy() {
            this.listener.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.listener.asBinder().unlinkToDeath(this, 0);
            onBinderDied();
        }
    }

    private class PrinterDiscoverySessionMediator {
        private final RemoteCallbackList<IPrinterDiscoveryObserver> mDiscoveryObservers;
        private boolean mIsDestroyed;
        private final ArrayMap<PrinterId, PrinterInfo> mPrinters;
        private final List<IBinder> mStartedPrinterDiscoveryTokens;
        private final List<PrinterId> mStateTrackedPrinters;
        final /* synthetic */ UserState this$0;

        /* JADX INFO: renamed from: $r8$lambda$-DzYs22QLZH275KuKpqnAQWS6Vo, reason: not valid java name */
        public static /* synthetic */ void m7957$r8$lambda$DzYs22QLZH275KuKpqnAQWS6Vo(PrinterDiscoverySessionMediator r0, List r1) {
            r0.handleDispatchStopPrinterDiscovery(r1);
        }

        public static /* synthetic */ void $r8$lambda$2VQIkyOWRXvY4YBkdzN6Mov5Uz8(PrinterDiscoverySessionMediator r0, List r1) {
            r0.handleDispatchPrintersAdded(r1);
        }

        public static /* synthetic */ void $r8$lambda$3zS9SIPoS8ZZO1U7IjHAJJSn1Jk(PrinterDiscoverySessionMediator r0, RemotePrintService r1, List r2) {
            r0.handleValidatePrinters(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$DjMs_wX-OHoKgWnMrABgq5-M0p0, reason: not valid java name */
        public static /* synthetic */ void m7958$r8$lambda$DjMs_wXOHoKgWnMrABgq5M0p0(PrinterDiscoverySessionMediator r0, List r1) {
            r0.handleDispatchCreatePrinterDiscoverySession(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$EZ63pQHK1bA8jicPJ5-fZF8iB_o, reason: not valid java name */
        public static /* synthetic */ void m7959$r8$lambda$EZ63pQHK1bA8jicPJ5fZF8iB_o(PrinterDiscoverySessionMediator r0, List r1) {
            r0.handleDispatchDestroyPrinterDiscoverySession(r1);
        }

        public static /* synthetic */ void $r8$lambda$KT_GTZ3BXgD4vZSLgjj0In9cQBQ(PrinterDiscoverySessionMediator r0, IPrinterDiscoveryObserver r1, List r2) {
            r0.handlePrintersAdded(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$PXizaL7uqZ0hy6Znlch2sMJ1Xuk(PrinterDiscoverySessionMediator r0, List r1) {
            r0.handleDispatchPrintersRemoved(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$YlEnn8fEn1_-qz9tejHgoVMq9eo, reason: not valid java name */
        public static /* synthetic */ void m7960$r8$lambda$YlEnn8fEn1_qz9tejHgoVMq9eo(PrinterDiscoverySessionMediator r0, List r1) {
            r0.handleDispatchPrintersAdded(r1);
        }

        public static /* synthetic */ void $r8$lambda$akQ1_TmeJZjxleGls9Lz9pg9t7w(PrinterDiscoverySessionMediator r0, RemotePrintService r1, PrinterId r2) {
            r0.handleStopPrinterStateTracking(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$iF_lMZdUsoRpijuUWdOA18Y0HAg(PrinterDiscoverySessionMediator r0, RemotePrintService r1, PrinterId r2) {
            r0.handleStartPrinterStateTracking(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$yZhO11V72tXNeXu8GkkfpixmEZU(PrinterDiscoverySessionMediator r0, List r1, List r2) {
            r0.handleDispatchStartPrinterDiscovery(r1, r2);
        }

        PrinterDiscoverySessionMediator(UserState r4) {
            this.this$0 = r4;
            this.mPrinters = new ArrayMap();
            this.mDiscoveryObservers = new AnonymousClass1(this);
            this.mStartedPrinterDiscoveryTokens = new ArrayList();
            this.mStateTrackedPrinters = new ArrayList();
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda0(), this, new ArrayList(UserState.m7947$$Nest$fgetmActiveServices(r4).values())));
        }

        public void addObserverLocked(IPrinterDiscoveryObserver observer) {
            this.mDiscoveryObservers.register(observer);
            if (this.mPrinters.isEmpty() == true) goto L6;
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda8(), this, observer, new ArrayList(this.mPrinters.values())));
            return;
        }

        public void removeObserverLocked(IPrinterDiscoveryObserver observer) {
            this.mDiscoveryObservers.unregister(observer);
            if (this.mDiscoveryObservers.getRegisteredCallbackCount() != 0) goto L6;
            destroyLocked();
            return;
        }

        public final void startPrinterDiscoveryLocked(IPrinterDiscoveryObserver observer, List<PrinterId> priorityList) {
            if (this.mIsDestroyed == false) goto L6;
            Log.w(UserState.LOG_TAG, "Not starting dicovery - session destroyed");
            return;
        L6:
            boolean discoveryStarted = !this.mStartedPrinterDiscoveryTokens.isEmpty();
            this.mStartedPrinterDiscoveryTokens.add(observer.asBinder());
            if (discoveryStarted == false) goto L14;
            if (priorityList == null) goto L14;
            if (priorityList.isEmpty() == true) goto L14;
            this.this$0.validatePrinters(priorityList);
            return;
        L14:
            if (this.mStartedPrinterDiscoveryTokens.size() <= 1) goto L16;
            return;
        L16:
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda6(), this, new ArrayList(UserState.m7947$$Nest$fgetmActiveServices(this.this$0).values()), priorityList));
        }

        public final void stopPrinterDiscoveryLocked(IPrinterDiscoveryObserver observer) {
            if (this.mIsDestroyed == false) goto L7;
            Log.w(UserState.LOG_TAG, "Not stopping dicovery - session destroyed");
            return;
        L7:
            if (this.mStartedPrinterDiscoveryTokens.remove(observer.asBinder()) == true) goto L10;
            return;
        L10:
            if (this.mStartedPrinterDiscoveryTokens.isEmpty() == true) goto L12;
            return;
        L12:
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda10(), this, new ArrayList(UserState.m7947$$Nest$fgetmActiveServices(this.this$0).values())));
        }

        public void validatePrintersLocked(List<PrinterId> printerIds) {
            if (this.mIsDestroyed == false) goto L6;
            Log.w(UserState.LOG_TAG, "Not validating pritners - session destroyed");
            return;
        L6:
            List<PrinterId> remainingList = new ArrayList(printerIds);
        L8:
            if (remainingList.isEmpty() == true) goto L25;
            Iterator<PrinterId> iterator = remainingList.iterator();
            List<PrinterId> updateList = new ArrayList();
            ComponentName serviceName = null;
        L11:
            if (iterator.hasNext() == false) goto L21;
            PrinterId printerId = iterator.next();
            if (printerId == null) goto L11;
            if (updateList.isEmpty() == true) goto L16;
            if (printerId.getServiceName().equals(serviceName) == false) goto L11;
            updateList.add(printerId);
            iterator.remove();
            goto L11
        L16:
            updateList.add(printerId);
            serviceName = printerId.getServiceName();
            iterator.remove();
            goto L11
        L21:
            RemotePrintService service = (RemotePrintService) UserState.m7947$$Nest$fgetmActiveServices(this.this$0).get(serviceName);
            if (service == null) goto L8;
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda12(), this, service, updateList));
            goto L8
        }

        public final void startPrinterStateTrackingLocked(PrinterId printerId) {
            if (this.mIsDestroyed == false) goto L7;
            Log.w(UserState.LOG_TAG, "Not starting printer state tracking - session destroyed");
            return;
        L7:
            if (this.mStartedPrinterDiscoveryTokens.isEmpty() == false) goto L9;
            return;
        L9:
            boolean containedPrinterId = this.mStateTrackedPrinters.contains(printerId);
            this.mStateTrackedPrinters.add(printerId);
            if (containedPrinterId == false) goto L12;
            return;
        L12:
            RemotePrintService service = (RemotePrintService) UserState.m7947$$Nest$fgetmActiveServices(this.this$0).get(printerId.getServiceName());
            if (service != null) goto L15;
            return;
        L15:
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda11(), this, service, printerId));
        }

        public final void stopPrinterStateTrackingLocked(PrinterId printerId) {
            if (this.mIsDestroyed == false) goto L7;
            Log.w(UserState.LOG_TAG, "Not stopping printer state tracking - session destroyed");
            return;
        L7:
            if (this.mStartedPrinterDiscoveryTokens.isEmpty() == false) goto L10;
            return;
        L10:
            if (this.mStateTrackedPrinters.remove(printerId) == true) goto L12;
            return;
        L12:
            RemotePrintService service = (RemotePrintService) UserState.m7947$$Nest$fgetmActiveServices(this.this$0).get(printerId.getServiceName());
            if (service != null) goto L15;
            return;
        L15:
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda13(), this, service, printerId));
        }

        public void onDestroyed() {
        }

        public void destroyLocked() {
            if (this.mIsDestroyed == false) goto L6;
            Log.w(UserState.LOG_TAG, "Not destroying - session destroyed");
            return;
        L6:
            this.mIsDestroyed = true;
            int printerCount = this.mStateTrackedPrinters.size();
            int i = 0;
        L7:
            if (i >= printerCount) goto L9;
            PrinterId printerId = this.mStateTrackedPrinters.get(i);
            this.this$0.stopPrinterStateTracking(printerId);
            i = i + 1;
            goto L7
        L9:
            int observerCount = this.mStartedPrinterDiscoveryTokens.size();
            int i2 = 0;
        L10:
            if (i2 >= observerCount) goto L12;
            IBinder token = this.mStartedPrinterDiscoveryTokens.get(i2);
            stopPrinterDiscoveryLocked(IPrinterDiscoveryObserver.Stub.asInterface(token));
            i2 = i2 + 1;
            goto L10
        L12:
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda7(), this, new ArrayList(UserState.m7947$$Nest$fgetmActiveServices(this.this$0).values())));
        }

        public void onPrintersAddedLocked(List<PrinterInfo> printers) {
            if (this.mIsDestroyed == false) goto L6;
            Log.w(UserState.LOG_TAG, "Not adding printers - session destroyed");
            return;
        L6:
            List<PrinterInfo> addedPrinters = null;
            int addedPrinterCount = printers.size();
            int i = 0;
        L7:
            if (i >= addedPrinterCount) goto L17;
            PrinterInfo printer = printers.get(i);
            PrinterInfo oldPrinter = this.mPrinters.put(printer.getId(), printer);
            if (oldPrinter != null) goto L11;
        L12:
            if (addedPrinters != null) goto L14;
            addedPrinters = new ArrayList();
        L14:
            addedPrinters.add(printer);
        L15:
            i = i + 1;
            goto L7
        L11:
            if (oldPrinter.equals(printer) == true) goto L15;
        L17:
            if (addedPrinters == null) goto L23;
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda9(), this, addedPrinters));
            return;
        }

        public void onPrintersRemovedLocked(List<PrinterId> printerIds) {
            if (this.mIsDestroyed == false) goto L6;
            Log.w(UserState.LOG_TAG, "Not removing printers - session destroyed");
            return;
        L6:
            List<PrinterId> removedPrinterIds = null;
            int removedPrinterCount = printerIds.size();
            int i = 0;
        L7:
            if (i >= removedPrinterCount) goto L15;
            PrinterId removedPrinterId = printerIds.get(i);
            if (this.mPrinters.remove(removedPrinterId) == null) goto L13;
            if (removedPrinterIds != null) goto L12;
            removedPrinterIds = new ArrayList();
        L12:
            removedPrinterIds.add(removedPrinterId);
        L13:
            i = i + 1;
            goto L7
        L15:
            if (removedPrinterIds == null) goto L21;
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda5(), this, removedPrinterIds));
            return;
        }

        public void onServiceRemovedLocked(RemotePrintService service) {
            if (this.mIsDestroyed == false) goto L6;
            Log.w(UserState.LOG_TAG, "Not updating removed service - session destroyed");
            return;
        L6:
            ComponentName serviceName = service.getComponentName();
            removePrintersForServiceLocked(serviceName);
            service.destroy();
        }

        public void onCustomPrinterIconLoadedLocked(PrinterId printerId) {
            if (this.mIsDestroyed == false) goto L6;
            Log.w(UserState.LOG_TAG, "Not updating printer - session destroyed");
            return;
        L6:
            PrinterInfo printer = this.mPrinters.get(printerId);
            if (printer == null) goto L10;
            PrinterInfo newPrinter = new PrinterInfo.Builder(printer).incCustomPrinterIconGen().build();
            this.mPrinters.put(printerId, newPrinter);
            ArrayList<PrinterInfo> addedPrinters = new ArrayList(1);
            addedPrinters.add(newPrinter);
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda1(), this, addedPrinters));
            return;
        }

        public void onServiceDiedLocked(RemotePrintService service) {
            UserState.m7955$$Nest$mremoveServiceLocked(this.this$0, service);
        }

        public void onServiceAddedLocked(RemotePrintService service) {
            if (this.mIsDestroyed == false) goto L6;
            Log.w(UserState.LOG_TAG, "Not updating added service - session destroyed");
            return;
        L6:
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda2(), service));
            if (this.mStartedPrinterDiscoveryTokens.isEmpty() == true) goto L9;
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda3(), service, null));
        L9:
            int trackedPrinterCount = this.mStateTrackedPrinters.size();
            int i = 0;
        L10:
            if (i >= trackedPrinterCount) goto L16;
            PrinterId printerId = this.mStateTrackedPrinters.get(i);
            if (printerId.getServiceName().equals(service.getComponentName()) == false) goto L14;
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda4(), service, printerId));
        L14:
            i = i + 1;
            goto L10
        }

        public void dumpLocked(DualDumpOutputStream dumpStream) {
            dumpStream.write("is_destroyed", 1133871366145L, UserState.m7949$$Nest$fgetmDestroyed(this.this$0));
            dumpStream.write("is_printer_discovery_in_progress", 1133871366146L, !this.mStartedPrinterDiscoveryTokens.isEmpty());
            int observerCount = this.mDiscoveryObservers.beginBroadcast();
            int i = 0;
        L3:
            if (i >= observerCount) goto L5;
            IPrinterDiscoveryObserver observer = this.mDiscoveryObservers.getBroadcastItem(i);
            dumpStream.write("printer_discovery_observers", 2237677961219L, observer.toString());
            i = i + 1;
            goto L3
        L5:
            this.mDiscoveryObservers.finishBroadcast();
            int tokenCount = this.mStartedPrinterDiscoveryTokens.size();
            int i2 = 0;
        L6:
            if (i2 >= tokenCount) goto L8;
            IBinder token = this.mStartedPrinterDiscoveryTokens.get(i2);
            dumpStream.write("discovery_requests", 2237677961220L, token.toString());
            i2 = i2 + 1;
            goto L6
        L8:
            int trackedPrinters = this.mStateTrackedPrinters.size();
            int i3 = 0;
        L9:
            if (i3 >= trackedPrinters) goto L11;
            PrinterId printer = this.mStateTrackedPrinters.get(i3);
            DumpUtils.writePrinterId(dumpStream, "tracked_printer_requests", 2246267895813L, printer);
            i3 = i3 + 1;
            goto L9
        L11:
            int printerCount = this.mPrinters.size();
            int i4 = 0;
        L12:
            if (i4 >= printerCount) goto L15;
            PrinterInfo printer2 = this.mPrinters.valueAt(i4);
            DumpUtils.writePrinterInfo(UserState.m7948$$Nest$fgetmContext(this.this$0), dumpStream, "printer", 2246267895814L, printer2);
            i4 = i4 + 1;
            goto L12
        }

        private void removePrintersForServiceLocked(ComponentName serviceName) {
            if (this.mPrinters.isEmpty() == false) goto L5;
            return;
        L5:
            List<PrinterId> removedPrinterIds = null;
            int printerCount = this.mPrinters.size();
            int i = 0;
        L6:
            if (i >= printerCount) goto L14;
            PrinterId printerId = this.mPrinters.keyAt(i);
            if (printerId.getServiceName().equals(serviceName) == false) goto L12;
            if (removedPrinterIds != null) goto L11;
            removedPrinterIds = new ArrayList();
        L11:
            removedPrinterIds.add(printerId);
        L12:
            i = i + 1;
            goto L6
        L14:
            if (removedPrinterIds == null) goto L24;
            int removedPrinterCount = removedPrinterIds.size();
            int i2 = 0;
        L16:
            if (i2 >= removedPrinterCount) goto L18;
            this.mPrinters.remove(removedPrinterIds.get(i2));
            i2 = i2 + 1;
            goto L16
        L18:
            Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$PrinterDiscoverySessionMediator$$ExternalSyntheticLambda5(), this, removedPrinterIds));
            return;
        }

        private void handleDispatchPrintersAdded(List<PrinterInfo> addedPrinters) {
            int observerCount = this.mDiscoveryObservers.beginBroadcast();
            int i = 0;
        L3:
            if (i >= observerCount) goto L5;
            IPrinterDiscoveryObserver observer = (IPrinterDiscoveryObserver) this.mDiscoveryObservers.getBroadcastItem(i);
            handlePrintersAdded(observer, addedPrinters);
            i = i + 1;
            goto L3
        L5:
            this.mDiscoveryObservers.finishBroadcast();
        }

        private void handleDispatchPrintersRemoved(List<PrinterId> removedPrinterIds) {
            int observerCount = this.mDiscoveryObservers.beginBroadcast();
            int i = 0;
        L3:
            if (i >= observerCount) goto L5;
            IPrinterDiscoveryObserver observer = (IPrinterDiscoveryObserver) this.mDiscoveryObservers.getBroadcastItem(i);
            handlePrintersRemoved(observer, removedPrinterIds);
            i = i + 1;
            goto L3
        L5:
            this.mDiscoveryObservers.finishBroadcast();
        }

        private void handleDispatchCreatePrinterDiscoverySession(List<RemotePrintService> services) {
            int serviceCount = services.size();
            int i = 0;
        L3:
            if (i >= serviceCount) goto L6;
            RemotePrintService service = services.get(i);
            service.createPrinterDiscoverySession();
            i = i + 1;
            goto L3
        }

        private void handleDispatchDestroyPrinterDiscoverySession(List<RemotePrintService> services) {
            int serviceCount = services.size();
            int i = 0;
        L3:
            if (i >= serviceCount) goto L5;
            RemotePrintService service = services.get(i);
            service.destroyPrinterDiscoverySession();
            i = i + 1;
            goto L3
        L5:
            onDestroyed();
        }

        private void handleDispatchStartPrinterDiscovery(List<RemotePrintService> services, List<PrinterId> printerIds) {
            int serviceCount = services.size();
            int i = 0;
        L3:
            if (i >= serviceCount) goto L6;
            RemotePrintService service = services.get(i);
            service.startPrinterDiscovery(printerIds);
            i = i + 1;
            goto L3
        }

        private void handleDispatchStopPrinterDiscovery(List<RemotePrintService> services) {
            int serviceCount = services.size();
            int i = 0;
        L3:
            if (i >= serviceCount) goto L6;
            RemotePrintService service = services.get(i);
            service.stopPrinterDiscovery();
            i = i + 1;
            goto L3
        }

        private void handleValidatePrinters(RemotePrintService service, List<PrinterId> printerIds) {
            service.validatePrinters(printerIds);
        }

        private void handleStartPrinterStateTracking(RemotePrintService service, PrinterId printerId) {
            service.startPrinterStateTracking(printerId);
        }

        private void handleStopPrinterStateTracking(RemotePrintService service, PrinterId printerId) {
            service.stopPrinterStateTracking(printerId);
        }

        private void handlePrintersAdded(IPrinterDiscoveryObserver observer, List<PrinterInfo> printers) {
            observer.onPrintersAdded(new ParceledListSlice(printers));     // Catch: RemoteException -> L4
            return;
        L4:
            re = move-exception;
            Log.e(UserState.LOG_TAG, "Error sending added printers", re);
        }

        private void handlePrintersRemoved(IPrinterDiscoveryObserver observer, List<PrinterId> printerIds) {
            observer.onPrintersRemoved(new ParceledListSlice(printerIds));     // Catch: RemoteException -> L4
            return;
        L4:
            re = move-exception;
            Log.e(UserState.LOG_TAG, "Error sending removed printers", re);
        }
    }

    public static /* synthetic */ void $r8$lambda$MP5uV7gqJs9XgyfNvgB66sfsHXk(UserState r0, List r1) {
        r0.handleDispatchPrintServiceRecommendationsUpdated(r1);
    }

    public static /* synthetic */ void $r8$lambda$bANLD0jfi8VwLPSTVtTkuQV_1jA(UserState r0) {
        r0.handleDispatchPrintServicesChanged();
    }

    /* JADX INFO: renamed from: $r8$lambda$fUjl-3TPhEZ-0EeBv1E8EM9SRc8, reason: not valid java name */
    public static /* synthetic */ void m7946$r8$lambda$fUjl3TPhEZ0EeBv1E8EM9SRc8(UserState r0) {
        r0.onConfigurationChanged();
    }

    public static /* synthetic */ void $r8$lambda$nEZwEnf7T5SIUrAUYJ4NuRlLMak(UserState r0, ComponentName r1) {
        r0.failScheduledPrintJobsForServiceInternal(r1);
    }

    public static /* synthetic */ void $r8$lambda$tlPZXpotZTo9hmEb5tVjkWARK8w(UserState r0, PrintJobId r1, IntSupplier r2) {
        r0.handleDispatchPrintJobStateChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveServices, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m7947$$Nest$fgetmActiveServices(UserState r0) {
        return r0.mActiveServices;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7948$$Nest$fgetmContext(UserState r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDestroyed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7949$$Nest$fgetmDestroyed(UserState r0) {
        return r0.mDestroyed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7950$$Nest$fgetmLock(UserState r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPrintJobStateChangeListenerRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m7951$$Nest$fgetmPrintJobStateChangeListenerRecords(UserState r0) {
        return r0.mPrintJobStateChangeListenerRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPrintServiceRecommendationsChangeListenerRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m7952$$Nest$fgetmPrintServiceRecommendationsChangeListenerRecords(UserState r0) {
        return r0.mPrintServiceRecommendationsChangeListenerRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPrintServicesChangeListenerRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m7953$$Nest$fgetmPrintServicesChangeListenerRecords(UserState r0) {
        return r0.mPrintServicesChangeListenerRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPrinterDiscoverySession, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7954$$Nest$fputmPrinterDiscoverySession(UserState r0, PrinterDiscoverySessionMediator r1) {
        r0.mPrinterDiscoverySession = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveServiceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7955$$Nest$mremoveServiceLocked(UserState r0, RemotePrintService r1) {
        r0.removeServiceLocked(r1);
    }

    public UserState(Context context, int userId, Object lock, boolean lowPriority) {
        this.mStringColonSplitter = new TextUtils.SimpleStringSplitter(COMPONENT_NAME_SEPARATOR);
        this.mQueryIntent = new Intent("android.printservice.PrintService");
        this.mActiveServices = new ArrayMap();
        this.mInstalledServices = new ArrayList();
        this.mDisabledServices = new ArraySet();
        this.mPrintJobForAppCache = new PrintJobForAppCache(this, null);
        this.mContext = context;
        this.mUserId = userId;
        this.mLock = lock;
        this.mSpooler = new RemotePrintSpooler(context, userId, lowPriority, this);
        Object r0 = this.mLock;
        monitor-enter(r0);
        readInstalledPrintServicesLocked();     // Catch: Throwable -> L8
        upgradePersistentStateIfNeeded();     // Catch: Throwable -> L8
        readDisabledPrintServicesLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        prunePrintServices();
        onConfigurationChanged();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void increasePriority() {
        this.mSpooler.increasePriority();
    }

    @Override // com.android.server.print.RemotePrintSpooler.PrintSpoolerCallbacks
    public void onPrintJobQueued(PrintJobInfo printJob) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L10
        ComponentName printServiceName = printJob.getPrinterId().getServiceName();     // Catch: Throwable -> L10
        RemotePrintService service = this.mActiveServices.get(printServiceName);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (service == null) goto L8;
        service.onPrintJobQueued(printJob);
        return;
    L8:
        this.mSpooler.setPrintJobState(printJob.getId(), 6, this.mContext.getString(R.string.silent_mode_silent));
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.print.RemotePrintSpooler.PrintSpoolerCallbacks
    public void onAllPrintJobsForServiceHandled(ComponentName printService) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L9
        RemotePrintService service = this.mActiveServices.get(printService);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (service == null) goto L14;
        service.onAllPrintJobsHandled();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void removeObsoletePrintJobs() {
        this.mSpooler.removeObsoletePrintJobs();
    }

    public Bundle print(String printJobName, IPrintDocumentAdapter adapter, PrintAttributes attributes, String packageName, int appId) {
        PrintJobInfo printJob = new PrintJobInfo();
        printJob.setId(new PrintJobId());
        printJob.setAppId(appId);
        printJob.setLabel(printJobName);
        printJob.setAttributes(attributes);
        printJob.setState(1);
        printJob.setCopies(1);
        printJob.setCreationTime(System.currentTimeMillis());
        if (this.mPrintJobForAppCache.onPrintJobCreated(adapter.asBinder(), appId, printJob) == true) goto L5;
        return null;
    L5:
        long identity = Binder.clearCallingIdentity();
        Intent intent = new Intent("android.print.PRINT_DIALOG");     // Catch: Throwable -> L13
        intent.setData(Uri.fromParts("printjob", printJob.getId().flattenToString(), null));     // Catch: Throwable -> L13
        intent.putExtra("android.print.intent.extra.EXTRA_PRINT_DOCUMENT_ADAPTER", adapter.asBinder());     // Catch: Throwable -> L13
        intent.putExtra("android.print.intent.extra.EXTRA_PRINT_JOB", printJob);     // Catch: Throwable -> L13
        intent.putExtra("android.intent.extra.PACKAGE_NAME", packageName);     // Catch: Throwable -> L11
        ActivityOptions activityOptions = ActivityOptions.makeBasic().setPendingIntentCreatorBackgroundActivityStartMode(2);     // Catch: Throwable -> L11
        IntentSender intentSender = PendingIntent.getActivityAsUser(this.mContext, 0, intent, 1409286144, activityOptions.toBundle(), new UserHandle(this.mUserId)).getIntentSender();     // Catch: Throwable -> L11
        Bundle result = new Bundle();     // Catch: Throwable -> L11
        result.putParcelable("android.print.intent.extra.EXTRA_PRINT_JOB", printJob);     // Catch: Throwable -> L11
        result.putParcelable("android.print.intent.extra.EXTRA_PRINT_DIALOG_INTENT", intentSender);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(identity);
        return result;
    L11:
        th = th;
    L15:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L13:
        th = th;
        goto L15
    }

    public List<PrintJobInfo> getPrintJobInfos(int appId) {
        List<PrintJobInfo> cachedPrintJobs = this.mPrintJobForAppCache.getPrintJobs(appId);
        ArrayMap<PrintJobId, PrintJobInfo> result = new ArrayMap();
        int cachedPrintJobCount = cachedPrintJobs.size();
        int i = 0;
    L4:
        if (i >= cachedPrintJobCount) goto L6;
        PrintJobInfo cachedPrintJob = cachedPrintJobs.get(i);
        result.put(cachedPrintJob.getId(), cachedPrintJob);
        cachedPrintJob.setTag(null);
        cachedPrintJob.setAdvancedOptions(null);
        i = i + 1;
        goto L4
    L6:
        List<PrintJobInfo> printJobs = this.mSpooler.getPrintJobInfos(null, -1, appId);
        if (printJobs == null) goto L12;
        int printJobCount = printJobs.size();
        int i2 = 0;
    L9:
        if (i2 >= printJobCount) goto L12;
        PrintJobInfo printJob = printJobs.get(i2);
        result.put(printJob.getId(), printJob);
        printJob.setTag(null);
        printJob.setAdvancedOptions(null);
        i2 = i2 + 1;
    L12:
        return new ArrayList(result.values());
    }

    public PrintJobInfo getPrintJobInfo(PrintJobId printJobId, int appId) {
        PrintJobInfo printJob = this.mPrintJobForAppCache.getPrintJob(printJobId, appId);
        if (printJob != null) goto L5;
        printJob = this.mSpooler.getPrintJobInfo(printJobId, appId);
    L5:
        if (printJob == null) goto L7;
        printJob.setTag(null);
        printJob.setAdvancedOptions(null);
    L7:
        return printJob;
    }

    public Icon getCustomPrinterIcon(PrinterId printerId) {
        Icon icon = this.mSpooler.getCustomPrinterIcon(printerId);
        if (icon != null) goto L7;
        RemotePrintService service = this.mActiveServices.get(printerId.getServiceName());
        if (service == null) goto L7;
        service.requestCustomPrinterIcon(printerId);
    L7:
        return icon;
    }

    public void cancelPrintJob(PrintJobId printJobId, int appId) {
        PrintJobInfo printJobInfo = this.mSpooler.getPrintJobInfo(printJobId, appId);
        if (printJobInfo != null) goto L5;
        return;
    L5:
        this.mSpooler.setPrintJobCancelling(printJobId, true);
        if (printJobInfo.getState() == 6) goto L20;
        PrinterId printerId = printJobInfo.getPrinterId();
        if (printerId == null) goto L24;
        ComponentName printServiceName = printerId.getServiceName();
        Object r4 = this.mLock;
        monitor-enter(r4);
        RemotePrintService printService = this.mActiveServices.get(printServiceName);     // Catch: Throwable -> L16
        monitor-exit(r4);     // Catch: Throwable -> L16
        if (printService != null) goto L15;
        return;
    L15:
        printService.onRequestCancelPrintJob(printJobInfo);
        return;
    L16:
        th = move-exception;
        throw th;
    L24:
        return;
    L20:
        this.mSpooler.setPrintJobState(printJobId, 7, null);
    }

    public void restartPrintJob(PrintJobId printJobId, int appId) {
        PrintJobInfo printJobInfo = getPrintJobInfo(printJobId, appId);
        if (printJobInfo != null) goto L5;
        return;
    L5:
        if (printJobInfo.getState() != 6) goto L10;
        this.mSpooler.setPrintJobState(printJobId, 2, null);
        return;
    }

    public List<PrintServiceInfo> getPrintServices(int selectionFlags) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<PrintServiceInfo> selectedServices = null;
        int installedServiceCount = this.mInstalledServices.size();     // Catch: Throwable -> L17
        int i = 0;
    L6:
        if (i >= installedServiceCount) goto L22;
        PrintServiceInfo installedService = this.mInstalledServices.get(i);     // Catch: Throwable -> L17
        ComponentName componentName = new ComponentName(installedService.getResolveInfo().serviceInfo.packageName, installedService.getResolveInfo().serviceInfo.name);     // Catch: Throwable -> L17
        installedService.setIsEnabled(this.mActiveServices.containsKey(componentName));     // Catch: Throwable -> L17
        if (installedService.isEnabled() == false) goto L13;
        if ((selectionFlags & 1) == 0) goto L20;
    L15:
        if (selectedServices != null) goto L19;
        selectedServices = new ArrayList();     // Catch: Throwable -> L17
    L19:
        selectedServices.add(installedService);     // Catch: Throwable -> L17
    L20:
        i = i + 1;     // Catch: Throwable -> L17
        goto L6
    L13:
        if ((selectionFlags & 2) != 0) goto L15;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return selectedServices;
    L17:
        th = move-exception;
        throw th;
    }

    public void setPrintServiceEnabled(ComponentName serviceName, boolean isEnabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean isChanged = false;
        if (isEnabled == false) goto L9;
        isChanged = this.mDisabledServices.remove(serviceName);     // Catch: Throwable -> L7
    L15:
        if (isChanged == false) goto L21;
        writeDisabledPrintServicesLocked(this.mDisabledServices);     // Catch: Throwable -> L7
        Context r2 = this.mContext;     // Catch: Throwable -> L7
        if (isEnabled == false) goto L19;
        int r3 = 0;
    L20:
        MetricsLogger.action(r2, UnixStat.DEFAULT_LINK_PERM, r3);     // Catch: Throwable -> L7
        onConfigurationChangedLocked();     // Catch: Throwable -> L7
        goto L21
    L19:
        r3 = 1;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        int numServices = this.mInstalledServices.size();     // Catch: Throwable -> L7
        int i = 0;
    L10:
        if (i >= numServices) goto L15;
        PrintServiceInfo service = this.mInstalledServices.get(i);     // Catch: Throwable -> L7
        if (service.getComponentName().equals(serviceName) == true) goto L13;
        i = i + 1;     // Catch: Throwable -> L7
        goto L10
    L13:
        this.mDisabledServices.add(serviceName);     // Catch: Throwable -> L7
        isChanged = true;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isPrintServiceEnabled(ComponentName serviceName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDisabledServices.contains(serviceName) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    }

    public List<RecommendationInfo> getPrintServiceRecommendations() {
        return this.mPrintServiceRecommendations;
    }

    public void createPrinterDiscoverySession(IPrinterDiscoveryObserver observer) {
        this.mSpooler.clearCustomPrinterIconCache();
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L7
        if (this.mPrinterDiscoverySession != null) goto L9;
        this.mPrinterDiscoverySession = new AnonymousClass1(this);     // Catch: Throwable -> L7
        this.mPrinterDiscoverySession.addObserverLocked(observer);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mPrinterDiscoverySession.addObserverLocked(observer);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void destroyPrinterDiscoverySession(IPrinterDiscoveryObserver observer) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPrinterDiscoverySession != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPrinterDiscoverySession.removeObserverLocked(observer);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void startPrinterDiscovery(IPrinterDiscoveryObserver observer, List<PrinterId> printerIds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L8
        if (this.mPrinterDiscoverySession != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPrinterDiscoverySession.startPrinterDiscoveryLocked(observer, printerIds);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void stopPrinterDiscovery(IPrinterDiscoveryObserver observer) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L8
        if (this.mPrinterDiscoverySession != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPrinterDiscoverySession.stopPrinterDiscoveryLocked(observer);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void validatePrinters(List<PrinterId> printerIds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L8
        if (this.mActiveServices.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mPrinterDiscoverySession != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mPrinterDiscoverySession.validatePrintersLocked(printerIds);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void startPrinterStateTracking(PrinterId printerId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L8
        if (this.mActiveServices.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mPrinterDiscoverySession != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mPrinterDiscoverySession.startPrinterStateTrackingLocked(printerId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void stopPrinterStateTracking(PrinterId printerId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L8
        if (this.mActiveServices.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mPrinterDiscoverySession != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mPrinterDiscoverySession.stopPrinterStateTrackingLocked(printerId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void addPrintJobStateChangeListener(final IPrintJobStateChangeListener listener, final int appId) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L7
        if (this.mPrintJobStateChangeListenerRecords != null) goto L9;
        this.mPrintJobStateChangeListenerRecords = new ArrayList();     // Catch: Throwable -> L7
    L9:
        this.mPrintJobStateChangeListenerRecords.add(new AnonymousClass2(this, listener, appId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removePrintJobStateChangeListener(IPrintJobStateChangeListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L8
        if (this.mPrintJobStateChangeListenerRecords != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int recordCount = this.mPrintJobStateChangeListenerRecords.size();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= recordCount) goto L17;
        PrintJobStateChangeListenerRecord record = this.mPrintJobStateChangeListenerRecords.get(i);     // Catch: Throwable -> L8
        if (record.listener.asBinder().equals(listener.asBinder()) == true) goto L14;
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L14:
        record.destroy();     // Catch: Throwable -> L8
        this.mPrintJobStateChangeListenerRecords.remove(i);     // Catch: Throwable -> L8
    L17:
        if (this.mPrintJobStateChangeListenerRecords.isEmpty() == false) goto L19;
        this.mPrintJobStateChangeListenerRecords = null;     // Catch: Throwable -> L8
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void addPrintServicesChangeListener(final IPrintServicesChangeListener listener) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L7
        if (this.mPrintServicesChangeListenerRecords != null) goto L9;
        this.mPrintServicesChangeListenerRecords = new ArrayList();     // Catch: Throwable -> L7
    L9:
        this.mPrintServicesChangeListenerRecords.add(new AnonymousClass3(this, listener));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removePrintServicesChangeListener(IPrintServicesChangeListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L8
        if (this.mPrintServicesChangeListenerRecords != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int recordCount = this.mPrintServicesChangeListenerRecords.size();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= recordCount) goto L17;
        ListenerRecord<IPrintServicesChangeListener> record = this.mPrintServicesChangeListenerRecords.get(i);     // Catch: Throwable -> L8
        if (record.listener.asBinder().equals(listener.asBinder()) == true) goto L14;
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L14:
        record.destroy();     // Catch: Throwable -> L8
        this.mPrintServicesChangeListenerRecords.remove(i);     // Catch: Throwable -> L8
    L17:
        if (this.mPrintServicesChangeListenerRecords.isEmpty() == false) goto L19;
        this.mPrintServicesChangeListenerRecords = null;     // Catch: Throwable -> L8
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void addPrintServiceRecommendationsChangeListener(final IRecommendationsChangeListener listener) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L7
        if (this.mPrintServiceRecommendationsChangeListenerRecords != null) goto L9;
        this.mPrintServiceRecommendationsChangeListenerRecords = new ArrayList();     // Catch: Throwable -> L7
        this.mPrintServiceRecommendationsService = new RemotePrintServiceRecommendationService(this.mContext, UserHandle.of(this.mUserId), this);     // Catch: Throwable -> L7
    L9:
        this.mPrintServiceRecommendationsChangeListenerRecords.add(new AnonymousClass4(this, listener));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removePrintServiceRecommendationsChangeListener(IRecommendationsChangeListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L8
        if (this.mPrintServiceRecommendationsChangeListenerRecords != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int recordCount = this.mPrintServiceRecommendationsChangeListenerRecords.size();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= recordCount) goto L17;
        ListenerRecord<IRecommendationsChangeListener> record = this.mPrintServiceRecommendationsChangeListenerRecords.get(i);     // Catch: Throwable -> L8
        if (record.listener.asBinder().equals(listener.asBinder()) == true) goto L14;
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L14:
        record.destroy();     // Catch: Throwable -> L8
        this.mPrintServiceRecommendationsChangeListenerRecords.remove(i);     // Catch: Throwable -> L8
    L17:
        if (this.mPrintServiceRecommendationsChangeListenerRecords.isEmpty() == false) goto L19;
        this.mPrintServiceRecommendationsChangeListenerRecords = null;     // Catch: Throwable -> L8
        this.mPrintServiceRecommendations = null;     // Catch: Throwable -> L8
        this.mPrintServiceRecommendationsService.close();     // Catch: Throwable -> L8
        this.mPrintServiceRecommendationsService = null;     // Catch: Throwable -> L8
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.print.RemotePrintSpooler.PrintSpoolerCallbacks
    public void onPrintJobStateChanged(PrintJobInfo printJob) {
        this.mPrintJobForAppCache.onPrintJobStateChanged(printJob);
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$$ExternalSyntheticLambda3(), this, printJob.getId(), PooledLambda.obtainSupplier(printJob.getAppId()).recycleOnUse()));
    }

    public void onPrintServicesChanged() {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$$ExternalSyntheticLambda0(), this));
    }

    @Override // com.android.server.print.RemotePrintServiceRecommendationService.RemotePrintServiceRecommendationServiceCallbacks
    public void onPrintServiceRecommendationsUpdated(List<RecommendationInfo> recommendations) {
        Handler.getMain().sendMessage(PooledLambda.obtainMessage(new UserState$$ExternalSyntheticLambda4(), this, recommendations));
    }

    @Override // com.android.server.print.RemotePrintService.PrintServiceCallbacks
    public void onPrintersAdded(List<PrinterInfo> printers) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L8
        if (this.mActiveServices.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mPrinterDiscoverySession != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mPrinterDiscoverySession.onPrintersAddedLocked(printers);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.print.RemotePrintService.PrintServiceCallbacks
    public void onPrintersRemoved(List<PrinterId> printerIds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L8
        if (this.mActiveServices.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mPrinterDiscoverySession != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mPrinterDiscoverySession.onPrintersRemovedLocked(printerIds);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.print.RemotePrintService.PrintServiceCallbacks
    public void onCustomPrinterIconLoaded(PrinterId printerId, Icon icon) {
        this.mSpooler.onCustomPrinterIconLoaded(printerId, icon);
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L8
        if (this.mPrinterDiscoverySession != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPrinterDiscoverySession.onCustomPrinterIconLoadedLocked(printerId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.print.RemotePrintService.PrintServiceCallbacks
    public void onServiceDied(RemotePrintService service) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfDestroyedLocked();     // Catch: Throwable -> L8
        if (this.mActiveServices.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        failActivePrintJobsForService(service.getComponentName());     // Catch: Throwable -> L8
        service.onAllPrintJobsHandled();     // Catch: Throwable -> L8
        this.mActiveServices.remove(service.getComponentName());     // Catch: Throwable -> L8
        Handler.getMain().sendMessageDelayed(PooledLambda.obtainMessage(new UserState$$ExternalSyntheticLambda1(), this), 500);     // Catch: Throwable -> L8
        if (this.mPrinterDiscoverySession != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mPrinterDiscoverySession.onServiceDiedLocked(service);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void updateIfNeededLocked() {
        throwIfDestroyedLocked();
        readConfigurationLocked();
        onConfigurationChangedLocked();
    }

    public void destroyLocked() {
        throwIfDestroyedLocked();
        this.mSpooler.destroy();
        Iterator<RemotePrintService> r0 = this.mActiveServices.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        RemotePrintService service = r0.next();
        service.destroy();
        goto L4
    L6:
        this.mActiveServices.clear();
        this.mInstalledServices.clear();
        this.mDisabledServices.clear();
        if (this.mPrinterDiscoverySession == null) goto L9;
        this.mPrinterDiscoverySession.destroyLocked();
        this.mPrinterDiscoverySession = null;
    L9:
        this.mDestroyed = true;
    }

    public void dump(DualDumpOutputStream dumpStream) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        dumpStream.write("user_id", 1120986464257L, this.mUserId);     // Catch: Throwable -> L7
        int installedServiceCount = this.mInstalledServices.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= installedServiceCount) goto L9;
        long token = dumpStream.start("installed_services", 2246267895810L);     // Catch: Throwable -> L7
        PrintServiceInfo installedService = this.mInstalledServices.get(i);     // Catch: Throwable -> L7
        ResolveInfo resolveInfo = installedService.getResolveInfo();     // Catch: Throwable -> L7
        com.android.internal.util.dump.DumpUtils.writeComponentName(dumpStream, "component_name", 1146756268033L, new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name));     // Catch: Throwable -> L7
        com.android.internal.util.dump.DumpUtils.writeStringIfNotNull(dumpStream, "settings_activity", 1138166333442L, installedService.getSettingsActivityName());     // Catch: Throwable -> L7
        com.android.internal.util.dump.DumpUtils.writeStringIfNotNull(dumpStream, "add_printers_activity", 1138166333443L, installedService.getAddPrintersActivityName());     // Catch: Throwable -> L7
        com.android.internal.util.dump.DumpUtils.writeStringIfNotNull(dumpStream, "advanced_options_activity", 1138166333444L, installedService.getAdvancedOptionsActivityName());     // Catch: Throwable -> L7
        dumpStream.end(token);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        Iterator<ComponentName> r2 = this.mDisabledServices.iterator();     // Catch: Throwable -> L7
    L11:
        if (r2.hasNext() == false) goto L13;
        ComponentName disabledService = r2.next();     // Catch: Throwable -> L7
        com.android.internal.util.dump.DumpUtils.writeComponentName(dumpStream, "disabled_services", 2246267895811L, disabledService);     // Catch: Throwable -> L7
        goto L11
    L13:
        int activeServiceCount = this.mActiveServices.size();     // Catch: Throwable -> L7
        int i2 = 0;
    L14:
        if (i2 >= activeServiceCount) goto L16;
        long token2 = dumpStream.start("actives_services", 2246267895812L);     // Catch: Throwable -> L7
        this.mActiveServices.valueAt(i2).dump(dumpStream);     // Catch: Throwable -> L7
        dumpStream.end(token2);     // Catch: Throwable -> L7
        i2 = i2 + 1;     // Catch: Throwable -> L7
        goto L14
    L16:
        this.mPrintJobForAppCache.dumpLocked(dumpStream);     // Catch: Throwable -> L7
        if (this.mPrinterDiscoverySession == null) goto L19;
        long token3 = dumpStream.start("discovery_service", 2246267895814L);     // Catch: Throwable -> L7
        this.mPrinterDiscoverySession.dumpLocked(dumpStream);     // Catch: Throwable -> L7
        dumpStream.end(token3);     // Catch: Throwable -> L7
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L7
        long token4 = dumpStream.start("print_spooler_state", 1146756268039L);
        this.mSpooler.dump(dumpStream);
        dumpStream.end(token4);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void readConfigurationLocked() {
        readInstalledPrintServicesLocked();
        readDisabledPrintServicesLocked();
    }

    private void readInstalledPrintServicesLocked() {
        Set<PrintServiceInfo> tempPrintServices = new HashSet();
        int queryIntentFlags = 268435588;
        if (this.mIsInstantServiceAllowed == false) goto L5;
        queryIntentFlags = 268435588 | 8388608;
    L5:
        List<ResolveInfo> installedServices = this.mContext.getPackageManager().queryIntentServicesAsUser(this.mQueryIntent, queryIntentFlags, this.mUserId);
        int installedCount = installedServices.size();
        int i = 0;
    L6:
        if (i >= installedCount) goto L12;
        ResolveInfo installedService = installedServices.get(i);
        if ("android.permission.BIND_PRINT_SERVICE".equals(installedService.serviceInfo.permission) == true) goto L10;
        ComponentName serviceName = new ComponentName(installedService.serviceInfo.packageName, installedService.serviceInfo.name);
        Slog.w(LOG_TAG, "Skipping print service " + serviceName.flattenToShortString() + " since it does not require permission android.permission.BIND_PRINT_SERVICE");
    L11:
        i = i + 1;
        goto L6
    L10:
        tempPrintServices.add(PrintServiceInfo.create(this.mContext, installedService));
        goto L11
    L12:
        this.mInstalledServices.clear();
        this.mInstalledServices.addAll(tempPrintServices);
    }

    private void upgradePersistentStateIfNeeded() {
        String enabledSettingValue = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "enabled_print_services", this.mUserId);
        if (enabledSettingValue == null) goto L15;
        Set<ComponentName> enabledServiceNameSet = new HashSet();
        readPrintServicesFromSettingLocked("enabled_print_services", enabledServiceNameSet);
        ArraySet<ComponentName> disabledServices = new ArraySet();
        int numInstalledServices = this.mInstalledServices.size();
        int i = 0;
    L5:
        if (i >= numInstalledServices) goto L10;
        ComponentName serviceName = this.mInstalledServices.get(i).getComponentName();
        if (enabledServiceNameSet.contains(serviceName) == true) goto L9;
        disabledServices.add(serviceName);
    L9:
        i = i + 1;
        goto L5
    L10:
        writeDisabledPrintServicesLocked(disabledServices);
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), "enabled_print_services", null, this.mUserId);
        return;
    }

    private void readDisabledPrintServicesLocked() {
        Set<ComponentName> tempDisabledServiceNameSet = new HashSet();
        readPrintServicesFromSettingLocked("disabled_print_services", tempDisabledServiceNameSet);
        if (tempDisabledServiceNameSet.equals(this.mDisabledServices) == true) goto L6;
        this.mDisabledServices.clear();
        this.mDisabledServices.addAll(tempDisabledServiceNameSet);
        return;
    }

    private void readPrintServicesFromSettingLocked(String setting, Set<ComponentName> outServiceNames) {
        String settingValue = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), setting, this.mUserId);
        if (TextUtils.isEmpty(settingValue) == true) goto L14;
        TextUtils.SimpleStringSplitter splitter = this.mStringColonSplitter;
        splitter.setString(settingValue);
    L6:
        if (splitter.hasNext() == false) goto L22;
        String string = splitter.next();
        if (TextUtils.isEmpty(string) == true) goto L6;
        ComponentName componentName = ComponentName.unflattenFromString(string);
        if (componentName == null) goto L6;
        outServiceNames.add(componentName);
        goto L6
    L22:
        return;
    }

    private void writeDisabledPrintServicesLocked(Set<ComponentName> disabledServices) {
        StringBuilder builder = new StringBuilder();
        Iterator<ComponentName> r1 = disabledServices.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        ComponentName componentName = r1.next();
        if (builder.length() <= 0) goto L8;
        builder.append(COMPONENT_NAME_SEPARATOR);
    L8:
        builder.append(componentName.flattenToShortString());
        goto L4
    L9:
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), "disabled_print_services", builder.toString(), this.mUserId);
    }

    private ArrayList<ComponentName> getInstalledComponents() {
        ArrayList<ComponentName> installedComponents = new ArrayList();
        int installedCount = this.mInstalledServices.size();
        int i = 0;
    L3:
        if (i >= installedCount) goto L6;
        ResolveInfo resolveInfo = this.mInstalledServices.get(i).getResolveInfo();
        ComponentName serviceName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        installedComponents.add(serviceName);
        i = i + 1;
        goto L3
    L6:
        return installedComponents;
    }

    public void prunePrintServices() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<ComponentName> installedComponents = getInstalledComponents();     // Catch: Throwable -> L7
        boolean disabledServicesUninstalled = this.mDisabledServices.retainAll(installedComponents);     // Catch: Throwable -> L7
        if (disabledServicesUninstalled == false) goto L9;
        writeDisabledPrintServicesLocked(this.mDisabledServices);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mSpooler.pruneApprovedPrintServices(installedComponents);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onConfigurationChangedLocked() {
        ArrayList<ComponentName> installedComponents = getInstalledComponents();
        int installedCount = installedComponents.size();
        int i = 0;
    L3:
        if (i >= installedCount) goto L14;
        ComponentName serviceName = installedComponents.get(i);
        if (this.mDisabledServices.contains(serviceName) == false) goto L7;
        RemotePrintService service = this.mActiveServices.remove(serviceName);
        if (service == null) goto L13;
        removeServiceLocked(service);
    L13:
        i = i + 1;
        goto L3
    L7:
        if (this.mActiveServices.containsKey(serviceName) == true) goto L13;
        RemotePrintService service2 = new RemotePrintService(this.mContext, serviceName, this.mUserId, this.mSpooler, this);
        addServiceLocked(service2);
        goto L13
    L14:
        Iterator<Map.Entry<ComponentName, RemotePrintService>> iterator = this.mActiveServices.entrySet().iterator();
    L16:
        if (iterator.hasNext() == false) goto L21;
        Map.Entry<ComponentName, RemotePrintService> entry = iterator.next();
        ComponentName serviceName2 = entry.getKey();
        RemotePrintService service3 = entry.getValue();
        if (installedComponents.contains(serviceName2) == true) goto L16;
        removeServiceLocked(service3);
        iterator.remove();
        goto L16
    L21:
        onPrintServicesChanged();
    }

    private void addServiceLocked(RemotePrintService service) {
        this.mActiveServices.put(service.getComponentName(), service);
        if (this.mPrinterDiscoverySession == null) goto L6;
        this.mPrinterDiscoverySession.onServiceAddedLocked(service);
        return;
    }

    private void removeServiceLocked(RemotePrintService service) {
        failActivePrintJobsForService(service.getComponentName());
        if (this.mPrinterDiscoverySession == null) goto L5;
        this.mPrinterDiscoverySession.onServiceRemovedLocked(service);
        return;
    L5:
        service.destroy();
    }

    private void failActivePrintJobsForService(ComponentName serviceName) {
        if (Looper.getMainLooper().isCurrentThread() == false) goto L5;
        BackgroundThread.getHandler().sendMessage(PooledLambda.obtainMessage(new UserState$$ExternalSyntheticLambda2(), this, serviceName));
        return;
    L5:
        failScheduledPrintJobsForServiceInternal(serviceName);
    }

    private void failScheduledPrintJobsForServiceInternal(ComponentName serviceName) {
        List<PrintJobInfo> printJobs = this.mSpooler.getPrintJobInfos(serviceName, -4, -2);
        if (printJobs != null) goto L5;
        return;
    L5:
        long identity = Binder.clearCallingIdentity();
        int printJobCount = printJobs.size();     // Catch: Throwable -> L10
        int i = 0;
    L7:
        if (i >= printJobCount) goto L12;
        PrintJobInfo printJob = printJobs.get(i);     // Catch: Throwable -> L10
        this.mSpooler.setPrintJobState(printJob.getId(), 6, this.mContext.getString(R.string.silent_mode_silent));     // Catch: Throwable -> L10
        i = i + 1;
        goto L7
    L12:
        Binder.restoreCallingIdentity(identity);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void throwIfDestroyedLocked() {
        if (this.mDestroyed == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot interact with a destroyed instance.");
    }

    private void handleDispatchPrintJobStateChanged(PrintJobId printJobId, IntSupplier appIdSupplier) {
        int appId = appIdSupplier.getAsInt();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPrintJobStateChangeListenerRecords != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        List<PrintJobStateChangeListenerRecord> records = new ArrayList(this.mPrintJobStateChangeListenerRecords);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        int recordCount = records.size();
        int i = 0;
    L13:
        if (i >= recordCount) goto L24;
        PrintJobStateChangeListenerRecord record = records.get(i);
        if (record.appId != (-2)) goto L17;
    L27:
        record.listener.onPrintJobStateChanged(printJobId);     // Catch: RemoteException -> L20
    L22:
        i = i + 1;
    L20:
        re = move-exception;
        Log.e(LOG_TAG, "Error notifying for print job state change", re);
        goto L22
    L17:
        if (record.appId != appId) goto L22;
    }

    private void handleDispatchPrintServicesChanged() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPrintServicesChangeListenerRecords != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        List<ListenerRecord<IPrintServicesChangeListener>> records = new ArrayList(this.mPrintServicesChangeListenerRecords);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        int recordCount = records.size();
        int i = 0;
    L13:
        if (i >= recordCount) goto L21;
        ListenerRecord<IPrintServicesChangeListener> record = records.get(i);
        record.listener.onPrintServicesChanged();     // Catch: RemoteException -> L17
    L19:
        i = i + 1;
    L17:
        re = move-exception;
        Log.e(LOG_TAG, "Error notifying for print services change", re);
        goto L19
    }

    private void handleDispatchPrintServiceRecommendationsUpdated(List<RecommendationInfo> recommendations) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPrintServiceRecommendationsChangeListenerRecords != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        List<ListenerRecord<IRecommendationsChangeListener>> records = new ArrayList(this.mPrintServiceRecommendationsChangeListenerRecords);     // Catch: Throwable -> L8
        this.mPrintServiceRecommendations = recommendations;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        int recordCount = records.size();
        int i = 0;
    L13:
        if (i >= recordCount) goto L21;
        ListenerRecord<IRecommendationsChangeListener> record = records.get(i);
        record.listener.onRecommendationsChanged();     // Catch: RemoteException -> L17
    L19:
        i = i + 1;
    L17:
        re = move-exception;
        Log.e(LOG_TAG, "Error notifying for print service recommendations change", re);
        goto L19
    }

    private void onConfigurationChanged() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        onConfigurationChangedLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean getBindInstantServiceAllowed() {
        return this.mIsInstantServiceAllowed;
    }

    public void setBindInstantServiceAllowed(boolean allowed) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsInstantServiceAllowed = allowed;     // Catch: Throwable -> L7
        updateIfNeededLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
