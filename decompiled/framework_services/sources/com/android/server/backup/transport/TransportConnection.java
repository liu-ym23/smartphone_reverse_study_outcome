package com.android.server.backup.transport;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.format.DateFormat;
import android.util.ArrayMap;
import android.util.EventLog;
import com.android.internal.backup.IBackupTransport;
import com.android.internal.util.Preconditions;
import com.android.server.EventLogTags;
import dalvik.system.CloseGuard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes.dex */
public class TransportConnection {
    private static final int LOG_BUFFER_SIZE = 5;
    static final String TAG = "TransportConnection";
    private final Intent mBindIntent;
    private final CloseGuard mCloseGuard;
    private final ServiceConnection mConnection;
    private final Context mContext;
    private final String mCreatorLogString;
    private final String mIdentifier;
    private final Handler mListenerHandler;
    private final Map<TransportConnectionListener, String> mListeners;
    private final List<String> mLogBuffer;
    private final Object mLogBufferLock;
    private final String mPrefixForLog;
    private int mState;
    private final Object mStateLock;
    private volatile BackupTransportClient mTransport;
    private final ComponentName mTransportComponent;
    private final TransportStats mTransportStats;
    private final int mUserId;

    @Retention(RetentionPolicy.SOURCE)
    private @interface State {
        public static final int BOUND_AND_CONNECTING = 2;
        public static final int CONNECTED = 3;
        public static final int IDLE = 1;
        public static final int UNUSABLE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface Transition {
        public static final int DOWN = -1;
        public static final int NO_TRANSITION = 0;
        public static final int UP = 1;
    }

    static class TransportConnectionMonitor implements ServiceConnection {
        private final Context mContext;
        private final WeakReference<TransportConnection> mTransportClientRef;

        TransportConnectionMonitor(Context context, TransportConnection transportConnection) {
            this.mContext = context;
            this.mTransportClientRef = new WeakReference(transportConnection);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName transportComponent, IBinder binder) {
            TransportConnection transportConnection = this.mTransportClientRef.get();
            if (transportConnection != null) goto L6;
            referenceLost("TransportConnection.onServiceConnected()");
            return;
        L6:
            Binder.allowBlocking(binder);
            TransportConnection.m2546$$Nest$monServiceConnected(transportConnection, binder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName transportComponent) {
            TransportConnection transportConnection = this.mTransportClientRef.get();
            if (transportConnection != null) goto L6;
            referenceLost("TransportConnection.onServiceDisconnected()");
            return;
        L6:
            TransportConnection.m2547$$Nest$monServiceDisconnected(transportConnection);
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName transportComponent) {
            TransportConnection transportConnection = this.mTransportClientRef.get();
            if (transportConnection != null) goto L6;
            referenceLost("TransportConnection.onBindingDied()");
            return;
        L6:
            TransportConnection.m2545$$Nest$monBindingDied(transportConnection);
        }

        private void referenceLost(String caller) {
            this.mContext.unbindService(this);     // Catch: IllegalArgumentException -> L6
            TransportUtils.log(4, TransportConnection.TAG, caller + " called but TransportClient reference has been GC'ed");
            return;
        L6:
            e = move-exception;
            TransportUtils.log(5, TransportConnection.TAG, caller + " called but unbindService failed: " + e.getMessage());
        }
    }

    public static /* synthetic */ void $r8$lambda$_NPv7c2usY4KXACL8fH382mvHRc(CompletableFuture r0, BackupTransportClient r1, TransportConnection r2) {
        lambda$connect$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$jVSSVWqIk1ltkKJM8W2iUWztX6Y(TransportConnection r0, TransportConnectionListener r1, BackupTransportClient r2) {
        r0.lambda$notifyListener$1(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monBindingDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2545$$Nest$monBindingDied(TransportConnection r0) {
        r0.onBindingDied();
    }

    /* JADX INFO: renamed from: -$$Nest$monServiceConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2546$$Nest$monServiceConnected(TransportConnection r0, IBinder r1) {
        r0.onServiceConnected(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monServiceDisconnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2547$$Nest$monServiceDisconnected(TransportConnection r0) {
        r0.onServiceDisconnected();
    }

    TransportConnection(int userId, Context context, TransportStats transportStats, Intent bindIntent, ComponentName transportComponent, String identifier, String caller) {
        this(userId, context, transportStats, bindIntent, transportComponent, identifier, caller, new Handler(Looper.getMainLooper()));
    }

    TransportConnection(int userId, Context context, TransportStats transportStats, Intent bindIntent, ComponentName transportComponent, String identifier, String caller, Handler listenerHandler) {
        this.mStateLock = new Object();
        this.mLogBufferLock = new Object();
        this.mCloseGuard = CloseGuard.get();
        this.mLogBuffer = new LinkedList();
        this.mListeners = new ArrayMap();
        this.mState = 1;
        this.mUserId = userId;
        this.mContext = context;
        this.mTransportStats = transportStats;
        this.mTransportComponent = transportComponent;
        this.mBindIntent = bindIntent;
        this.mIdentifier = identifier;
        this.mCreatorLogString = caller;
        this.mListenerHandler = listenerHandler;
        this.mConnection = new TransportConnectionMonitor(context, this);
        String classNameForLog = this.mTransportComponent.getShortClassName().replaceFirst(".*\\.", "");
        this.mPrefixForLog = classNameForLog + "#" + this.mIdentifier + ":";
        this.mCloseGuard.open("markAsDisposed");
    }

    public ComponentName getTransportComponent() {
        return this.mTransportComponent;
    }

    public void connectAsync(TransportConnectionListener listener, String caller) {
        Object r0 = this.mStateLock;
        monitor-enter(r0);
        checkStateIntegrityLocked();     // Catch: Throwable -> L8
        switch(this.mState) {
            case 0: goto L15;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L7;
            default: goto L16;
        };     // Catch: Throwable -> L8
    L7:
        log(3, caller, "Async connect: reusing transport");     // Catch: Throwable -> L8
        notifyListener(listener, this.mTransport, caller);     // Catch: Throwable -> L8
        goto L16
    L10:
        log(3, caller, "Async connect: already connecting, adding listener");     // Catch: Throwable -> L8
        this.mListeners.put(listener, caller);     // Catch: Throwable -> L8
        goto L16
    L11:
        boolean hasBound = this.mContext.bindServiceAsUser(this.mBindIntent, this.mConnection, 1, UserHandle.of(this.mUserId));     // Catch: Throwable -> L8
        if (hasBound == false) goto L14;
        log(3, caller, "Async connect: service bound, connecting");     // Catch: Throwable -> L8
        setStateLocked(2, null);     // Catch: Throwable -> L8
        this.mListeners.put(listener, caller);     // Catch: Throwable -> L8
        goto L16
    L14:
        log(6, "Async connect: bindService returned false");     // Catch: Throwable -> L8
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L8
        notifyListener(listener, null, caller);     // Catch: Throwable -> L8
        goto L16
    L15:
        log(5, caller, "Async connect: UNUSABLE client");     // Catch: Throwable -> L8
        notifyListener(listener, null, caller);     // Catch: Throwable -> L8
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unbind(String caller) {
        Object r0 = this.mStateLock;
        monitor-enter(r0);
        checkStateIntegrityLocked();     // Catch: Throwable -> L8
        log(3, caller, "Unbind requested (was " + stateToString(this.mState) + ")");     // Catch: Throwable -> L8
        switch(this.mState) {
            case 0: goto L12;
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L7;
            default: goto L12;
        };     // Catch: Throwable -> L8
    L7:
        setStateLocked(1, null);     // Catch: Throwable -> L8
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L8
        goto L12
    L10:
        setStateLocked(1, null);     // Catch: Throwable -> L8
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L8
        notifyListenersAndClearLocked(null);     // Catch: Throwable -> L8
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void markAsDisposed() {
        Object r0 = this.mStateLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mState >= 2) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1, "Can't mark as disposed if still bound");     // Catch: Throwable -> L11
        this.mCloseGuard.close();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r1 = false;
        goto L8
    }

    public BackupTransportClient connect(String caller) {
        Preconditions.checkState(!Looper.getMainLooper().isCurrentThread(), "Can't call connect() on main thread");
        BackupTransportClient transport = this.mTransport;
        if (transport == null) goto L6;
        log(3, caller, "Sync connect: reusing transport");
        return transport;
    L6:
        Object r2 = this.mStateLock;
        monitor-enter(r2);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mState != 0) goto L15;
        log(5, caller, "Sync connect: UNUSABLE client");     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return null;
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L13
        final CompletableFuture<BackupTransportClient> transportFuture = new CompletableFuture();
        TransportConnectionListener requestListener = new TransportConnection$$ExternalSyntheticLambda0(transportFuture);
        long requestTime = SystemClock.elapsedRealtime();
        log(3, caller, "Sync connect: calling async");
        connectAsync(requestListener, caller);
        BackupTransportClient transport2 = transportFuture.get();     // Catch: Throwable -> L19
        long time = SystemClock.elapsedRealtime() - requestTime;     // Catch: Throwable -> L19
        this.mTransportStats.registerConnectionTime(this.mTransportComponent, time);     // Catch: Throwable -> L19
        log(3, caller, String.format(Locale.US, "Connect took %d ms", new Object[]{Long.valueOf(time)}));     // Catch: Throwable -> L19
        return transport2;
    L19:
        e = move-exception;
        String error = e.getClass().getSimpleName();
        log(6, caller, error + " while waiting for transport: " + e.getMessage());
        return null;
    }

    private static /* synthetic */ void lambda$connect$0(CompletableFuture transportFuture, BackupTransportClient requestedTransport, TransportConnection transportClient) {
        transportFuture.complete(requestedTransport);
    }

    public BackupTransportClient connectOrThrow(String caller) throws TransportNotAvailableException {
        BackupTransportClient transport = connect(caller);
        if (transport == null) goto L5;
        return transport;
    L5:
        log(6, caller, "Transport connection failed");
        throw new TransportNotAvailableException();
    }

    public BackupTransportClient getConnectedTransport(String caller) throws TransportNotAvailableException {
        BackupTransportClient transport = this.mTransport;
        if (transport == null) goto L5;
        return transport;
    L5:
        log(6, caller, "Transport not connected");
        throw new TransportNotAvailableException();
    }

    public String toString() {
        return "TransportClient{" + this.mTransportComponent.flattenToShortString() + "#" + this.mIdentifier + "}";
    }

    protected void finalize() throws Throwable {
        Object r0 = this.mStateLock;
        monitor-enter(r0);
        this.mCloseGuard.warnIfOpen();     // Catch: Throwable -> L9
        if (this.mState < 2) goto L12;
        log(6, "TransportClient.finalize()", "Dangling TransportClient created in [" + this.mCreatorLogString + "] being GC'ed. Left bound, unbinding...");     // Catch: Throwable -> L9
        unbind("TransportClient.finalize()");     // Catch: Throwable -> L9 IllegalStateException -> L11
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onServiceConnected(IBinder binder) {
        IBackupTransport transportBinder = IBackupTransport.Stub.asInterface(binder);
        BackupTransportClient transport = new BackupTransportClient(transportBinder);
        Object r2 = this.mStateLock;
        monitor-enter(r2);
        checkStateIntegrityLocked();     // Catch: Throwable -> L7
        if (this.mState == 0) goto L9;
        log(3, "Transport connected");     // Catch: Throwable -> L7
        setStateLocked(3, transport);     // Catch: Throwable -> L7
        notifyListenersAndClearLocked(transport);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onServiceDisconnected() {
        Object r0 = this.mStateLock;
        monitor-enter(r0);
        log(6, "Service disconnected: client UNUSABLE");     // Catch: Throwable -> L7
        if (this.mTransport == null) goto L9;
        this.mTransport.onBecomingUnusable();     // Catch: Throwable -> L7
    L9:
        setStateLocked(0, null);     // Catch: Throwable -> L7
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L7 IllegalArgumentException -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L12:
        e = move-exception;
        log(5, "Exception trying to unbind onServiceDisconnected(): " + e.getMessage());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void onBindingDied() {
        Object r0 = this.mStateLock;
        monitor-enter(r0);
        checkStateIntegrityLocked();     // Catch: Throwable -> L7
        log(6, "Binding died: client UNUSABLE");     // Catch: Throwable -> L7
        if (this.mTransport == null) goto L10;
        this.mTransport.onBecomingUnusable();     // Catch: Throwable -> L7
    L10:
        switch(this.mState) {
            case 0: goto L16;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            default: goto L16;
        };     // Catch: Throwable -> L7
    L12:
        setStateLocked(0, null);     // Catch: Throwable -> L7
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L7
        goto L16
    L13:
        setStateLocked(0, null);     // Catch: Throwable -> L7
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L7
        notifyListenersAndClearLocked(null);     // Catch: Throwable -> L7
        goto L16
    L14:
        log(6, "Unexpected state transition IDLE => UNUSABLE");     // Catch: Throwable -> L7
        setStateLocked(0, null);     // Catch: Throwable -> L7
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void notifyListener(final TransportConnectionListener listener, final BackupTransportClient transport, String caller) {
        if (transport == null) goto L4;
        String transportString = "BackupTransportClient";
    L5:
        log(4, "Notifying [" + caller + "] transport = " + transportString);
        this.mListenerHandler.post(new TransportConnection$$ExternalSyntheticLambda1(this, listener, transport));
        return;
    L4:
        transportString = "null";
        goto L5
    }

    private /* synthetic */ void lambda$notifyListener$1(TransportConnectionListener listener, BackupTransportClient transport) {
        listener.onTransportConnectionResult(transport, this);
    }

    private void notifyListenersAndClearLocked(BackupTransportClient transport) {
        Iterator<Map.Entry<TransportConnectionListener, String>> r0 = this.mListeners.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<TransportConnectionListener, String> entry = r0.next();
        TransportConnectionListener listener = entry.getKey();
        String caller = entry.getValue();
        notifyListener(listener, transport, caller);
        goto L4
    L6:
        this.mListeners.clear();
    }

    private void setStateLocked(int state, BackupTransportClient transport) {
        log(2, "State: " + stateToString(this.mState) + " => " + stateToString(state));
        onStateTransition(this.mState, state);
        this.mState = state;
        this.mTransport = transport;
    }

    private void onStateTransition(int oldState, int newState) {
        String transport = this.mTransportComponent.flattenToShortString();
        int bound = transitionThroughState(oldState, newState, 2);
        int connected = transitionThroughState(oldState, newState, 3);
        int value = 0;
        if (bound == 0) goto L8;
        if (bound != 1) goto L6;
        int value2 = 1;
    L7:
        EventLog.writeEvent(EventLogTags.BACKUP_TRANSPORT_LIFECYCLE, new Object[]{transport, Integer.valueOf(value2)});
        goto L8
    L6:
        value2 = 0;
    L8:
        if (connected == 0) goto L13;
        if (connected != 1) goto L11;
        value = 1;
    L11:
        EventLog.writeEvent(EventLogTags.BACKUP_TRANSPORT_CONNECTION, new Object[]{transport, Integer.valueOf(value)});
        return;
    }

    private int transitionThroughState(int oldState, int newState, int stateReference) {
        if (oldState >= stateReference) goto L6;
        if (stateReference > newState) goto L6;
        return 1;
    L6:
        if (oldState < stateReference) goto L10;
        if (stateReference <= newState) goto L12;
        return -1;
    L12:
        return 0;
    L10:
        return 0;
    }

    private void checkStateIntegrityLocked() {
        boolean r1 = true;
        switch(this.mState) {
            case 0: goto L15;
            case 1: goto L20;
            case 2: goto L11;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        checkState(false, "Unexpected state = " + stateToString(this.mState));
        return;
    L5:
        checkState(this.mListeners.isEmpty(), "Unexpected listeners when state = CONNECTED");
        if (this.mTransport != null) goto L9;
        r1 = false;
    L9:
        checkState(r1, "Transport expected to be non-null when state = CONNECTED");
        return;
    L15:
        checkState(this.mListeners.isEmpty(), "Unexpected listeners when state = UNUSABLE");
        if (this.mTransport != null) goto L18;
        boolean r0 = true;
    L19:
        checkState(r0, "Transport expected to be null when state = UNUSABLE");
        goto L20
    L18:
        r0 = false;
    L20:
        checkState(this.mListeners.isEmpty(), "Unexpected listeners when state = IDLE");
        if (this.mTransport == null) goto L24;
        r1 = false;
    L24:
        checkState(r1, "Transport expected to be null when state = IDLE");
        return;
    L11:
        if (this.mTransport == null) goto L14;
        r1 = false;
    L14:
        checkState(r1, "Transport expected to be null when state = BOUND_AND_CONNECTING");
    }

    private void checkState(boolean assertion, String message) {
        if (assertion == true) goto L5;
        log(6, message);
        return;
    }

    private String stateToString(int state) {
        switch(state) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "CONNECTED";
    L7:
        return "BOUND_AND_CONNECTING";
    L9:
        return "IDLE";
    L11:
        return "UNUSABLE";
    L4:
        return "<UNKNOWN = " + state + ">";
    }

    private void log(int priority, String message) {
        TransportUtils.log(priority, TAG, TransportUtils.formatMessage(this.mPrefixForLog, null, message));
        saveLogEntry(TransportUtils.formatMessage(null, null, message));
    }

    private void log(int priority, String caller, String message) {
        TransportUtils.log(priority, TAG, TransportUtils.formatMessage(this.mPrefixForLog, caller, message));
        saveLogEntry(TransportUtils.formatMessage(null, caller, message));
    }

    private void saveLogEntry(String message) {
        CharSequence time = DateFormat.format("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis());
        String message2 = time + " " + message;
        Object r1 = this.mLogBufferLock;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mLogBuffer.size() != 5) goto L9;
        this.mLogBuffer.remove(this.mLogBuffer.size() - 1);     // Catch: Throwable -> L7
    L9:
        this.mLogBuffer.add(0, message2);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
    }

    List<String> getLogBuffer() {
        Object r0 = this.mLogBufferLock;
        monitor-enter(r0);
        List<String> r1 = Collections.unmodifiableList(this.mLogBuffer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
