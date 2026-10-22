package com.android.server.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.DataLoaderParamsParcel;
import android.content.pm.IDataLoader;
import android.content.pm.IDataLoaderManager;
import android.content.pm.IDataLoaderStatusListener;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.SystemService;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DataLoaderManagerService extends SystemService {
    private static final String TAG = "DataLoaderManager";
    private final DataLoaderManagerBinderService mBinderService;
    private final Context mContext;
    private final Handler mHandler;
    private final SparseArray<DataLoaderServiceConnection> mServiceConnections;

    final class DataLoaderManagerBinderService extends IDataLoaderManager.Stub {
        final /* synthetic */ DataLoaderManagerService this$0;

        public static /* synthetic */ void $r8$lambda$soTuULaL7NmdxaXk7LcsdvltKqw(DataLoaderManagerBinderService r0, Intent r1, DataLoaderServiceConnection r2, ComponentName r3, int r4) {
            r0.lambda$bindToDataLoader$0(r1, r2, r3, r4);
        }

        DataLoaderManagerBinderService(DataLoaderManagerService this$0) {
            this.this$0 = this$0;
        }

        public boolean bindToDataLoader(final int dataLoaderId, DataLoaderParamsParcel params, long bindDelayMs, IDataLoaderStatusListener listener) {
            SparseArray r1 = DataLoaderManagerService.m6628$$Nest$fgetmServiceConnections(this.this$0);
            monitor-enter(r1);
        L18:
            th = th;
        L28:
            monitor-exit(r1);     // Catch: Throwable -> L22
            throw th;
        L22:
            th = th;
            goto L28
        L5:
            if (DataLoaderManagerService.m6628$$Nest$fgetmServiceConnections(this.this$0).get(dataLoaderId) != null) goto L24;
            monitor-exit(r1);     // Catch: Throwable -> L18
            ComponentName componentName = new ComponentName(params.packageName, params.className);
            final ComponentName dataLoaderComponent = resolveDataLoaderComponentName(componentName);
            if (dataLoaderComponent != null) goto L16;
            Slog.e(DataLoaderManagerService.TAG, "Invalid component: " + componentName + " for ID=" + dataLoaderId);
            return false;
        L16:
            final DataLoaderServiceConnection connection = new DataLoaderServiceConnection(this.this$0, dataLoaderId, listener);
            final Intent intent = new Intent();
            intent.setComponent(dataLoaderComponent);
            return DataLoaderManagerService.m6627$$Nest$fgetmHandler(this.this$0).postDelayed(new DataLoaderManagerService$DataLoaderManagerBinderService$$ExternalSyntheticLambda0(this, intent, connection, dataLoaderComponent, dataLoaderId), bindDelayMs);
        L24:
            monitor-exit(r1);     // Catch: Throwable -> L9
            return true;
        L9:
            th = th;
            goto L28
        }

        private /* synthetic */ void lambda$bindToDataLoader$0(Intent intent, DataLoaderServiceConnection connection, ComponentName dataLoaderComponent, int dataLoaderId) {
            if (DataLoaderManagerService.m6626$$Nest$fgetmContext(this.this$0).bindServiceAsUser(intent, connection, 1, DataLoaderManagerService.m6627$$Nest$fgetmHandler(this.this$0), UserHandle.of(UserHandle.getCallingUserId())) == true) goto L6;
            Slog.e(DataLoaderManagerService.TAG, "Failed to bind to: " + dataLoaderComponent + " for ID=" + dataLoaderId);
            DataLoaderManagerService.m6626$$Nest$fgetmContext(this.this$0).unbindService(connection);
            return;
        }

        private ComponentName resolveDataLoaderComponentName(ComponentName componentName) {
            PackageManager pm = DataLoaderManagerService.m6626$$Nest$fgetmContext(this.this$0).getPackageManager();
            if (pm != null) goto L6;
            Slog.e(DataLoaderManagerService.TAG, "PackageManager is not available.");
            return null;
        L6:
            Intent intent = new Intent("android.intent.action.LOAD_DATA");
            intent.setComponent(componentName);
            List<ResolveInfo> services = pm.queryIntentServicesAsUser(intent, 0, UserHandle.getCallingUserId());
            if (services != null) goto L9;
        L17:
            Slog.e(DataLoaderManagerService.TAG, "Failed to find data loader service provider in " + componentName);
            return null;
        L9:
            if (services.isEmpty() == true) goto L17;
            int numServices = services.size();
            if (0 >= numServices) goto L15;
            ResolveInfo ri = services.get(0);
            ComponentName resolved = new ComponentName(ri.serviceInfo.packageName, ri.serviceInfo.name);
            return resolved;
        L15:
            Slog.e(DataLoaderManagerService.TAG, "Didn't find any matching data loader service provider.");
            return null;
        }

        public IDataLoader getDataLoader(int dataLoaderId) {
            SparseArray r0 = DataLoaderManagerService.m6628$$Nest$fgetmServiceConnections(this.this$0);
            monitor-enter(r0);
            DataLoaderServiceConnection serviceConnection = (DataLoaderServiceConnection) DataLoaderManagerService.m6628$$Nest$fgetmServiceConnections(this.this$0).get(dataLoaderId, null);     // Catch: Throwable -> L8
            if (serviceConnection != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L10:
            IDataLoader r2 = serviceConnection.getDataLoader();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r2;
        L8:
            th = move-exception;
            throw th;
        }

        public void unbindFromDataLoader(int dataLoaderId) {
            SparseArray r0 = DataLoaderManagerService.m6628$$Nest$fgetmServiceConnections(this.this$0);
            monitor-enter(r0);
            DataLoaderServiceConnection serviceConnection = (DataLoaderServiceConnection) DataLoaderManagerService.m6628$$Nest$fgetmServiceConnections(this.this$0).get(dataLoaderId, null);     // Catch: Throwable -> L8
            if (serviceConnection != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            serviceConnection.destroy();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    private class DataLoaderServiceConnection implements ServiceConnection, IBinder.DeathRecipient {
        IDataLoader mDataLoader;
        final int mId;
        final IDataLoaderStatusListener mListener;
        final /* synthetic */ DataLoaderManagerService this$0;

        DataLoaderServiceConnection(DataLoaderManagerService r1, int id, IDataLoaderStatusListener listener) {
            this.this$0 = r1;
            this.mId = id;
            this.mListener = listener;
            this.mDataLoader = null;
            callListener(1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName className, IBinder service) {
            this.mDataLoader = IDataLoader.Stub.asInterface(service);
            if (this.mDataLoader != null) goto L7;
            onNullBinding(className);
            return;
        L7:
            if (append() == true) goto L17;
            DataLoaderManagerService.m6626$$Nest$fgetmContext(this.this$0).unbindService(this);
            return;
        L17:
            service.linkToDeath(this, 0);     // Catch: RemoteException -> L14
            callListener(2);
            return;
        L14:
            e = move-exception;
            Slog.e(DataLoaderManagerService.TAG, "Failed to link to DataLoader's death: " + this.mId, e);
            onBindingDied(className);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName arg0) {
            Slog.i(DataLoaderManagerService.TAG, "DataLoader " + this.mId + " disconnected, but will try to recover");
            unbindAndReportDestroyed();
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName name) {
            Slog.i(DataLoaderManagerService.TAG, "DataLoader " + this.mId + " died");
            unbindAndReportDestroyed();
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName name) {
            Slog.i(DataLoaderManagerService.TAG, "DataLoader " + this.mId + " failed to start");
            unbindAndReportDestroyed();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Slog.i(DataLoaderManagerService.TAG, "DataLoader " + this.mId + " died");
            unbindAndReportDestroyed();
        }

        IDataLoader getDataLoader() {
            return this.mDataLoader;
        }

        private void unbindAndReportDestroyed() {
            if (unbind() == false) goto L6;
            callListener(0);
            return;
        }

        void destroy() {
            if (this.mDataLoader != null) goto L10;
        L8:
            unbind();
            return;
        L10:
            this.mDataLoader.destroy(this.mId);     // Catch: RemoteException -> L6
        L7:
            this.mDataLoader = null;
            goto L8
        }

        boolean unbind() {
            DataLoaderManagerService.m6626$$Nest$fgetmContext(this.this$0).unbindService(this);     // Catch: Exception -> L4
        L6:
            return remove();
        }

        private boolean append() {
            SparseArray r0 = DataLoaderManagerService.m6628$$Nest$fgetmServiceConnections(this.this$0);
            monitor-enter(r0);
            DataLoaderServiceConnection bound = (DataLoaderServiceConnection) DataLoaderManagerService.m6628$$Nest$fgetmServiceConnections(this.this$0).get(this.mId);     // Catch: Throwable -> L8
            if (bound != this) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return true;
        L10:
            if (bound == null) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L14:
            DataLoaderManagerService.m6628$$Nest$fgetmServiceConnections(this.this$0).append(this.mId, this);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return true;
        L8:
            th = move-exception;
            throw th;
        }

        private boolean remove() {
            SparseArray r0 = DataLoaderManagerService.m6628$$Nest$fgetmServiceConnections(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (DataLoaderManagerService.m6628$$Nest$fgetmServiceConnections(this.this$0).get(this.mId) != this) goto L12;
            DataLoaderManagerService.m6628$$Nest$fgetmServiceConnections(this.this$0).remove(this.mId);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return true;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return false;
        }

        private void callListener(int status) {
            if (this.mListener == null) goto L10;
            this.mListener.onStatusChanged(this.mId, status);     // Catch: RemoteException -> L6
            return;
        L7:
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m6626$$Nest$fgetmContext(DataLoaderManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m6627$$Nest$fgetmHandler(DataLoaderManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceConnections, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m6628$$Nest$fgetmServiceConnections(DataLoaderManagerService r0) {
        return r0.mServiceConnections;
    }

    public DataLoaderManagerService(Context context) {
        super(context);
        this.mServiceConnections = new SparseArray();
        this.mContext = context;
        HandlerThread thread = new HandlerThread(TAG);
        thread.start();
        this.mHandler = new Handler(thread.getLooper());
        this.mBinderService = new DataLoaderManagerBinderService(this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("dataloader_manager", this.mBinderService);
    }
}
