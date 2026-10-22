package com.android.server.security.intrusiondetection;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PermissionEnforcer;
import android.os.RemoteException;
import android.security.intrusiondetection.IIntrusionDetectionService;
import android.security.intrusiondetection.IIntrusionDetectionServiceCommandCallback;
import android.security.intrusiondetection.IIntrusionDetectionServiceStateCallback;
import android.security.intrusiondetection.IntrusionDetectionEvent;
import android.util.Slog;
import com.android.server.ServiceThread;
import com.android.server.SystemService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class IntrusionDetectionService extends SystemService {
    private static final int ERROR_DATA_SOURCE_UNAVAILABLE = 4;
    private static final int ERROR_INVALID_STATE_TRANSITION = 2;
    private static final int ERROR_PERMISSION_DENIED = 1;
    private static final int ERROR_TRANSPORT_UNAVAILABLE = 3;
    private static final int ERROR_UNKNOWN = 0;
    private static final int MAX_STATE_CALLBACK_NUM = 16;
    private static final int MSG_ADD_STATE_CALLBACK = 0;
    private static final int MSG_DISABLE = 3;
    private static final int MSG_ENABLE = 2;
    private static final int MSG_REMOVE_STATE_CALLBACK = 1;
    private static final int MSG_TRANSPORT = 4;
    private static final int STATE_DISABLED = 1;
    private static final int STATE_ENABLED = 2;
    private static final int STATE_UNKNOWN = 0;
    private static final String TAG = "IntrusionDetectionService";
    private final BinderService mBinderService;
    private final Context mContext;
    private final DataAggregator mDataAggregator;
    private final Handler mHandler;
    private final IntrusionDetectionEventTransportConnection mIntrusionDetectionEventTransportConnection;
    private volatile int mState;
    private final ArrayList<IIntrusionDetectionServiceStateCallback> mStateCallbacks;

    private static final class BinderService extends IIntrusionDetectionService.Stub {
        final IntrusionDetectionService mService;

        BinderService(IntrusionDetectionService service, PermissionEnforcer permissionEnforcer) {
            super(permissionEnforcer);
            this.mService = service;
        }

        public void addStateCallback(IIntrusionDetectionServiceStateCallback callback) {
            addStateCallback_enforcePermission();
            IntrusionDetectionService.m8048$$Nest$fgetmHandler(this.mService).obtainMessage(0, callback).sendToTarget();
        }

        public void removeStateCallback(IIntrusionDetectionServiceStateCallback callback) {
            removeStateCallback_enforcePermission();
            IntrusionDetectionService.m8048$$Nest$fgetmHandler(this.mService).obtainMessage(1, callback).sendToTarget();
        }

        public void enable(IIntrusionDetectionServiceCommandCallback callback) {
            enable_enforcePermission();
            IntrusionDetectionService.m8048$$Nest$fgetmHandler(this.mService).obtainMessage(2, callback).sendToTarget();
        }

        public void disable(IIntrusionDetectionServiceCommandCallback callback) {
            disable_enforcePermission();
            IntrusionDetectionService.m8048$$Nest$fgetmHandler(this.mService).obtainMessage(3, callback).sendToTarget();
        }
    }

    private static class EventHandler extends Handler {
        private final IntrusionDetectionService mService;

        EventHandler(Looper looper, IntrusionDetectionService service) {
            super(looper);
            this.mService = service;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L23;
                case 1: goto L27;
                case 2: goto L25;
                case 3: goto L29;
                case 4: goto L5;
                default: goto L4;
            };
        L4:
            Slog.w(IntrusionDetectionService.TAG, "Unknown message: " + msg.what);
            return;
        L5:
            IntrusionDetectionService.m8053$$Nest$mtransport(this.mService, (List) msg.obj);
            return;
        L23:
            IntrusionDetectionService.m8049$$Nest$maddStateCallback(this.mService, (IIntrusionDetectionServiceStateCallback) msg.obj);     // Catch: RemoteException -> L20
            return;
        L20:
            e = move-exception;
            Slog.e(IntrusionDetectionService.TAG, "RemoteException", e);
            return;
        L25:
            IntrusionDetectionService.m8051$$Nest$menable(this.mService, (IIntrusionDetectionServiceCommandCallback) msg.obj);     // Catch: RemoteException -> L12
            return;
        L12:
            e = move-exception;
            Slog.e(IntrusionDetectionService.TAG, "RemoteException", e);
            return;
        L27:
            IntrusionDetectionService.m8052$$Nest$mremoveStateCallback(this.mService, (IIntrusionDetectionServiceStateCallback) msg.obj);     // Catch: RemoteException -> L16
            return;
        L16:
            e = move-exception;
            Slog.e(IntrusionDetectionService.TAG, "RemoteException", e);
            return;
        L29:
            IntrusionDetectionService.m8050$$Nest$mdisable(this.mService, (IIntrusionDetectionServiceCommandCallback) msg.obj);     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            Slog.e(IntrusionDetectionService.TAG, "RemoteException", e);
        }
    }

    interface Injector {
        Context getContext();

        DataAggregator getDataAggregator(IntrusionDetectionService r1);

        IntrusionDetectionEventTransportConnection getIntrusionDetectionEventransportConnection();

        Looper getLooper();

        PermissionEnforcer getPermissionEnforcer();
    }

    private static final class InjectorImpl implements Injector {
        private final Context mContext;

        InjectorImpl(Context context) {
            this.mContext = context;
        }

        @Override // com.android.server.security.intrusiondetection.IntrusionDetectionService.Injector
        public Context getContext() {
            return this.mContext;
        }

        @Override // com.android.server.security.intrusiondetection.IntrusionDetectionService.Injector
        public PermissionEnforcer getPermissionEnforcer() {
            return PermissionEnforcer.fromContext(this.mContext);
        }

        @Override // com.android.server.security.intrusiondetection.IntrusionDetectionService.Injector
        public Looper getLooper() {
            ServiceThread serviceThread = new ServiceThread(IntrusionDetectionService.TAG, -2, true);
            serviceThread.start();
            return serviceThread.getLooper();
        }

        @Override // com.android.server.security.intrusiondetection.IntrusionDetectionService.Injector
        public IntrusionDetectionEventTransportConnection getIntrusionDetectionEventransportConnection() {
            return new IntrusionDetectionEventTransportConnection(this.mContext);
        }

        @Override // com.android.server.security.intrusiondetection.IntrusionDetectionService.Injector
        public DataAggregator getDataAggregator(IntrusionDetectionService intrusionDetectionService) {
            return new DataAggregator(this.mContext, intrusionDetectionService);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m8048$$Nest$fgetmHandler(IntrusionDetectionService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$maddStateCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8049$$Nest$maddStateCallback(IntrusionDetectionService r0, IIntrusionDetectionServiceStateCallback r1) {
        r0.addStateCallback(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdisable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8050$$Nest$mdisable(IntrusionDetectionService r0, IIntrusionDetectionServiceCommandCallback r1) {
        r0.disable(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$menable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8051$$Nest$menable(IntrusionDetectionService r0, IIntrusionDetectionServiceCommandCallback r1) {
        r0.enable(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveStateCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8052$$Nest$mremoveStateCallback(IntrusionDetectionService r0, IIntrusionDetectionServiceStateCallback r1) {
        r0.removeStateCallback(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtransport, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8053$$Nest$mtransport(IntrusionDetectionService r0, List r1) {
        r0.transport(r1);
    }

    public IntrusionDetectionService(Context context) {
        this(new InjectorImpl(context));
    }

    IntrusionDetectionService(Injector injector) {
        super(injector.getContext());
        this.mStateCallbacks = new ArrayList();
        this.mState = 1;
        this.mContext = injector.getContext();
        this.mHandler = new EventHandler(injector.getLooper(), this);
        this.mIntrusionDetectionEventTransportConnection = injector.getIntrusionDetectionEventransportConnection();
        this.mDataAggregator = injector.getDataAggregator(this);
        this.mBinderService = new BinderService(this, injector.getPermissionEnforcer());
    }

    protected void setState(int state) {
        this.mState = state;
    }

    private void addStateCallback(IIntrusionDetectionServiceStateCallback callback) throws RemoteException {
        int i = 0;
    L4:
        if (i >= this.mStateCallbacks.size()) goto L9;
        if (this.mStateCallbacks.get(i).asBinder() == callback.asBinder()) goto L7;
        i = i + 1;
        goto L4
    L7:
        return;
    L9:
        this.mStateCallbacks.add(callback);
        callback.onStateChange(this.mState);
    }

    private void removeStateCallback(IIntrusionDetectionServiceStateCallback callback) throws RemoteException {
        int i = 0;
    L4:
        if (i >= this.mStateCallbacks.size()) goto L11;
        if (this.mStateCallbacks.get(i).asBinder() == callback.asBinder()) goto L7;
        i = i + 1;
        goto L4
    L7:
        this.mStateCallbacks.remove(i);
        return;
    }

    private void notifyStateMonitors() {
        if (this.mStateCallbacks.size() < 16) goto L5;
        this.mStateCallbacks.removeFirst();
    L5:
        int i = 0;
    L7:
        if (i >= this.mStateCallbacks.size()) goto L14;
        this.mStateCallbacks.get(i).onStateChange(this.mState);     // Catch: RemoteException -> L10
    L12:
        i = i + 1;
    L11:
        this.mStateCallbacks.remove(i);
        goto L12
    }

    private void enable(IIntrusionDetectionServiceCommandCallback callback) throws RemoteException {
        if (this.mState != 2) goto L7;
        callback.onSuccess();
        return;
    L7:
        if (this.mIntrusionDetectionEventTransportConnection.initialize() == true) goto L10;
        callback.onFailure(3);
        return;
    L10:
        this.mDataAggregator.enable();
        this.mState = 2;
        notifyStateMonitors();
        callback.onSuccess();
    }

    private void disable(IIntrusionDetectionServiceCommandCallback callback) throws RemoteException {
        if (this.mState != 1) goto L6;
        callback.onSuccess();
        return;
    L6:
        this.mIntrusionDetectionEventTransportConnection.release();
        this.mDataAggregator.disable();
        this.mState = 1;
        notifyStateMonitors();
        callback.onSuccess();
    }

    public void addNewData(List<IntrusionDetectionEvent> events) {
        this.mHandler.obtainMessage(4, events).sendToTarget();
    }

    private void transport(List<IntrusionDetectionEvent> events) {
        this.mIntrusionDetectionEventTransportConnection.addData(events);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("intrusion_detection", this.mBinderService);     // Catch: Throwable -> L4
        return;
    L4:
        t = move-exception;
        Slog.e(TAG, "Could not start the IntrusionDetectionService.", t);
    }

    IIntrusionDetectionService getBinderService() {
        return this.mBinderService;
    }
}
