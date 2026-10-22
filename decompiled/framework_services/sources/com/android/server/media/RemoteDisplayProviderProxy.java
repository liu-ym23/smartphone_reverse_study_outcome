package com.android.server.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.media.IRemoteDisplayCallback;
import android.media.IRemoteDisplayProvider;
import android.media.RemoteDisplayState;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;
import android.util.Slog;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class RemoteDisplayProviderProxy {
    private static final boolean DEBUG = false;
    private static final String TAG = "RemoteDisplayProvider";
    private Connection mActiveConnection;
    private boolean mBound;
    private final ComponentName mComponentName;
    private boolean mConnectionReady;
    private final Context mContext;
    private int mDiscoveryMode;
    private RemoteDisplayState mDisplayState;
    private Callback mDisplayStateCallback;
    private final Runnable mDisplayStateChanged;
    private final Handler mHandler;
    private boolean mRunning;
    private boolean mScheduledDisplayStateChangedCallback;
    private String mSelectedDisplayId;
    private final ServiceConnection mServiceConnection;
    private final int mUserId;

    public interface Callback {
        void onDisplayStateChanged(RemoteDisplayProviderProxy r1, RemoteDisplayState r2);
    }

    private final class Connection implements IBinder.DeathRecipient {
        private final ProviderCallback mCallback;
        private final IRemoteDisplayProvider mProvider;
        final /* synthetic */ RemoteDisplayProviderProxy this$0;

        public Connection(RemoteDisplayProviderProxy r1, IRemoteDisplayProvider provider) {
            this.this$0 = r1;
            this.mProvider = provider;
            this.mCallback = new ProviderCallback(this);
        }

        public boolean register() {
            this.mProvider.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L6
            this.mProvider.setCallback(this.mCallback);     // Catch: RemoteException -> L6
            RemoteDisplayProviderProxy.m5763$$Nest$fgetmHandler(this.this$0).post(new AnonymousClass1(this));     // Catch: RemoteException -> L6
            return true;
        L7:
            binderDied();
            return false;
        }

        public void dispose() {
            this.mProvider.asBinder().unlinkToDeath(this, 0);
            this.mCallback.dispose();
        }

        public void setDiscoveryMode(int mode) {
            this.mProvider.setDiscoveryMode(mode);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(RemoteDisplayProviderProxy.TAG, "Failed to deliver request to set discovery mode.", ex);
        }

        public void connect(String id) {
            this.mProvider.connect(id);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(RemoteDisplayProviderProxy.TAG, "Failed to deliver request to connect to display.", ex);
        }

        public void disconnect(String id) {
            this.mProvider.disconnect(id);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(RemoteDisplayProviderProxy.TAG, "Failed to deliver request to disconnect from display.", ex);
        }

        public void setVolume(String id, int volume) {
            this.mProvider.setVolume(id, volume);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(RemoteDisplayProviderProxy.TAG, "Failed to deliver request to set display volume.", ex);
        }

        public void adjustVolume(String id, int volume) {
            this.mProvider.adjustVolume(id, volume);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(RemoteDisplayProviderProxy.TAG, "Failed to deliver request to adjust display volume.", ex);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            RemoteDisplayProviderProxy.m5763$$Nest$fgetmHandler(this.this$0).post(new AnonymousClass2(this));
        }

        void postStateChanged(final RemoteDisplayState state) {
            RemoteDisplayProviderProxy.m5763$$Nest$fgetmHandler(this.this$0).post(new AnonymousClass3(this, state));
        }
    }

    private static final class ProviderCallback extends IRemoteDisplayCallback.Stub {
        private final WeakReference<Connection> mConnectionRef;

        public ProviderCallback(Connection connection) {
            this.mConnectionRef = new WeakReference(connection);
        }

        public void dispose() {
            this.mConnectionRef.clear();
        }

        public void onStateChanged(RemoteDisplayState state) throws RemoteException {
            Connection connection = this.mConnectionRef.get();
            if (connection == null) goto L6;
            connection.postStateChanged(state);
            return;
        }
    }

    private final class ServiceConnectionImpl implements ServiceConnection {
        final /* synthetic */ RemoteDisplayProviderProxy this$0;

        public static /* synthetic */ void $r8$lambda$oZOxOFX7h9AOM2Le5OkX6s4p4Z0(RemoteDisplayProviderProxy r0) {
            RemoteDisplayProviderProxy.m5769$$Nest$monServiceDisconnectedOnHandler(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$znYBgEL_xguLMhyRrji-XDa0Ns8, reason: not valid java name */
        public static /* synthetic */ void m5770$r8$lambda$znYBgEL_xguLMhyRrjiXDa0Ns8(ServiceConnectionImpl r0, IBinder r1) {
            r0.lambda$onServiceConnected$0(r1);
        }

        /* synthetic */ ServiceConnectionImpl(RemoteDisplayProviderProxy r1, RemoteDisplayProviderProxyIA r2) {
            this(r1);
        }

        private ServiceConnectionImpl(RemoteDisplayProviderProxy r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void lambda$onServiceConnected$0(IBinder service) {
            RemoteDisplayProviderProxy.m5768$$Nest$monServiceConnectedOnHandler(this.this$0, service);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, final IBinder service) {
            RemoteDisplayProviderProxy.m5763$$Nest$fgetmHandler(this.this$0).post(new RemoteDisplayProviderProxy$ServiceConnectionImpl$$ExternalSyntheticLambda0(this, service));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Handler r0 = RemoteDisplayProviderProxy.m5763$$Nest$fgetmHandler(this.this$0);
            final RemoteDisplayProviderProxy r1 = this.this$0;
            r0.post(new RemoteDisplayProviderProxy$ServiceConnectionImpl$$ExternalSyntheticLambda1(r1));
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayState, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteDisplayState m5761$$Nest$fgetmDisplayState(RemoteDisplayProviderProxy r0) {
        return r0.mDisplayState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayStateCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ Callback m5762$$Nest$fgetmDisplayStateCallback(RemoteDisplayProviderProxy r0) {
        return r0.mDisplayStateCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m5763$$Nest$fgetmHandler(RemoteDisplayProviderProxy r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmScheduledDisplayStateChangedCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5764$$Nest$fputmScheduledDisplayStateChangedCallback(RemoteDisplayProviderProxy r0, boolean r1) {
        r0.mScheduledDisplayStateChangedCallback = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$monConnectionDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5765$$Nest$monConnectionDied(RemoteDisplayProviderProxy r0, Connection r1) {
        r0.onConnectionDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monConnectionReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5766$$Nest$monConnectionReady(RemoteDisplayProviderProxy r0, Connection r1) {
        r0.onConnectionReady(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monDisplayStateChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5767$$Nest$monDisplayStateChanged(RemoteDisplayProviderProxy r0, Connection r1, RemoteDisplayState r2) {
        r0.onDisplayStateChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monServiceConnectedOnHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5768$$Nest$monServiceConnectedOnHandler(RemoteDisplayProviderProxy r0, IBinder r1) {
        r0.onServiceConnectedOnHandler(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monServiceDisconnectedOnHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5769$$Nest$monServiceDisconnectedOnHandler(RemoteDisplayProviderProxy r0) {
        r0.onServiceDisconnectedOnHandler();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    RemoteDisplayProviderProxy(Context context, ComponentName componentName, int userId, Looper looper) {
        this.mServiceConnection = new ServiceConnectionImpl(this, null);
        this.mDisplayStateChanged = new AnonymousClass1(this);
        this.mContext = context;
        this.mComponentName = componentName;
        this.mUserId = userId;
        this.mHandler = new Handler(looper);
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "Proxy");
        pw.println(prefix + "  mUserId=" + this.mUserId);
        pw.println(prefix + "  mRunning=" + this.mRunning);
        pw.println(prefix + "  mBound=" + this.mBound);
        pw.println(prefix + "  mActiveConnection=" + this.mActiveConnection);
        pw.println(prefix + "  mConnectionReady=" + this.mConnectionReady);
        pw.println(prefix + "  mDiscoveryMode=" + this.mDiscoveryMode);
        pw.println(prefix + "  mSelectedDisplayId=" + this.mSelectedDisplayId);
        pw.println(prefix + "  mDisplayState=" + this.mDisplayState);
    }

    public void setCallback(Callback callback) {
        this.mDisplayStateCallback = callback;
    }

    public RemoteDisplayState getDisplayState() {
        return this.mDisplayState;
    }

    public void setDiscoveryMode(int mode) {
        if (this.mDiscoveryMode == mode) goto L9;
        this.mDiscoveryMode = mode;
        if (this.mConnectionReady == false) goto L7;
        this.mActiveConnection.setDiscoveryMode(mode);
    L7:
        updateBinding();
        return;
    }

    public void setSelectedDisplay(String id) {
        if (Objects.equals(this.mSelectedDisplayId, id) == false) goto L5;
        return;
    L5:
        if (this.mConnectionReady == true) goto L7;
    L9:
        this.mSelectedDisplayId = id;
        if (this.mConnectionReady == false) goto L13;
        if (id == null) goto L13;
        this.mActiveConnection.connect(id);
    L13:
        updateBinding();
        return;
    L7:
        if (this.mSelectedDisplayId == null) goto L9;
        this.mActiveConnection.disconnect(this.mSelectedDisplayId);
        goto L9
    }

    public void setDisplayVolume(int volume) {
        if (this.mConnectionReady == true) goto L5;
        return;
    L5:
        if (this.mSelectedDisplayId == null) goto L9;
        this.mActiveConnection.setVolume(this.mSelectedDisplayId, volume);
        return;
    }

    public void adjustDisplayVolume(int delta) {
        if (this.mConnectionReady == true) goto L5;
        return;
    L5:
        if (this.mSelectedDisplayId == null) goto L9;
        this.mActiveConnection.adjustVolume(this.mSelectedDisplayId, delta);
        return;
    }

    public boolean hasComponentName(String packageName, String className) {
        if (this.mComponentName.getPackageName().equals(packageName) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mComponentName.getClassName().equals(className) == false) goto L7;
        return true;
    }

    public String getFlattenedComponentName() {
        return this.mComponentName.flattenToShortString();
    }

    public void start() {
        if (this.mRunning == false) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Starting");
    L7:
        this.mRunning = true;
        updateBinding();
    }

    public void stop() {
        if (this.mRunning == true) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Stopping");
    L7:
        this.mRunning = false;
        updateBinding();
    }

    public void rebindIfDisconnected() {
        if (this.mActiveConnection == null) goto L5;
        return;
    L5:
        if (shouldBind() == false) goto L9;
        unbind();
        bind();
        return;
    }

    private void updateBinding() {
        if (shouldBind() == false) goto L5;
        bind();
        return;
    L5:
        unbind();
    }

    private boolean shouldBind() {
        if (this.mRunning == true) goto L5;
        return false;
    L5:
        if (this.mDiscoveryMode == 0) goto L7;
        return true;
    L7:
        if (this.mSelectedDisplayId == null) goto L13;
        return true;
    L13:
        return false;
    }

    private void bind() {
        if (this.mBound == false) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Binding");
    L7:
        Intent service = new Intent("com.android.media.remotedisplay.RemoteDisplayProvider");
        service.setComponent(this.mComponentName);
        this.mBound = this.mContext.bindServiceAsUser(service, this.mServiceConnection, AudioFormat.AAC_MAIN, new UserHandle(this.mUserId));     // Catch: SecurityException -> L14
        if (this.mBound == false) goto L11;
        return;
    L11:
        if (DEBUG == false) goto L26;
        Slog.d(TAG, this + ": Bind failed");     // Catch: SecurityException -> L14
        return;
    L26:
        return;
    L14:
        ex = move-exception;
        if (DEBUG == false) goto L24;
        Slog.d(TAG, this + ": Bind failed", ex);
        return;
    }

    private void unbind() {
        if (this.mBound == true) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Unbinding");
    L7:
        this.mBound = false;
        disconnect();
        this.mContext.unbindService(this.mServiceConnection);
    }

    private void onServiceConnectedOnHandler(IBinder service) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, this + ": Connected");
    L6:
        if (this.mBound == false) goto L18;
        disconnect();
        IRemoteDisplayProvider provider = IRemoteDisplayProvider.Stub.asInterface(service);
        if (provider == null) goto L16;
        Connection connection = new Connection(this, provider);
        if (connection.register() == false) goto L13;
        this.mActiveConnection = connection;
        return;
    L13:
        if (DEBUG == false) goto L21;
        Slog.d(TAG, this + ": Registration failed");
        return;
    L21:
        return;
    L16:
        Slog.e(TAG, this + ": Service returned invalid remote display provider binder");
        return;
    }

    private void onServiceDisconnectedOnHandler() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, this + ": Service disconnected");
    L5:
        disconnect();
    }

    private void onConnectionReady(Connection connection) {
        if (this.mActiveConnection != connection) goto L11;
        this.mConnectionReady = true;
        if (this.mDiscoveryMode == 0) goto L8;
        this.mActiveConnection.setDiscoveryMode(this.mDiscoveryMode);
    L8:
        if (this.mSelectedDisplayId == null) goto L12;
        this.mActiveConnection.connect(this.mSelectedDisplayId);
        return;
    L12:
        return;
    }

    private void onConnectionDied(Connection connection) {
        if (this.mActiveConnection == connection) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Service connection died");
    L7:
        disconnect();
    }

    private void onDisplayStateChanged(Connection connection, RemoteDisplayState state) {
        if (this.mActiveConnection == connection) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": State changed, state=" + state);
    L7:
        setDisplayState(state);
    }

    private void disconnect() {
        if (this.mActiveConnection != null) goto L5;
        return;
    L5:
        if (this.mSelectedDisplayId == null) goto L7;
        this.mActiveConnection.disconnect(this.mSelectedDisplayId);
    L7:
        this.mConnectionReady = false;
        this.mActiveConnection.dispose();
        this.mActiveConnection = null;
        setDisplayState(null);
    }

    private void setDisplayState(RemoteDisplayState state) {
        if (Objects.equals(this.mDisplayState, state) == true) goto L8;
        this.mDisplayState = state;
        if (this.mScheduledDisplayStateChangedCallback == true) goto L9;
        this.mScheduledDisplayStateChangedCallback = true;
        this.mHandler.post(this.mDisplayStateChanged);
        return;
    L9:
        return;
    }

    public String toString() {
        return "Service connection " + this.mComponentName.flattenToShortString();
    }
}
