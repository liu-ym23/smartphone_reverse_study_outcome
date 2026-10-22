package com.android.server.tv;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.media.tv.ITvRemoteProvider;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;
import android.util.Slog;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
final class TvRemoteProviderProxy implements ServiceConnection {
    private static final boolean DEBUG = false;
    protected static final String SERVICE_INTERFACE = "com.android.media.tv.remoteprovider.TvRemoteProvider";
    private static final String TAG = "TvRemoteProviderProxy";
    private boolean mBound;
    private final ComponentName mComponentName;
    private boolean mConnected;
    private final Context mContext;
    private final Object mLock;
    private boolean mRunning;
    private final int mUid;
    private final int mUserId;

    static {
        DEBUG = Log.isLoggable(TAG, 2);
    }

    TvRemoteProviderProxy(Context context, Object lock, ComponentName componentName, int userId, int uid) {
        this.mContext = context;
        this.mLock = lock;
        this.mComponentName = componentName;
        this.mUserId = userId;
        this.mUid = uid;
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "Proxy");
        pw.println(prefix + "  mUserId=" + this.mUserId);
        pw.println(prefix + "  mRunning=" + this.mRunning);
        pw.println(prefix + "  mBound=" + this.mBound);
        pw.println(prefix + "  mConnected=" + this.mConnected);
    }

    public boolean hasComponentName(String packageName, String className) {
        if (this.mComponentName.getPackageName().equals(packageName) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mComponentName.getClassName().equals(className) == false) goto L7;
        return true;
    }

    public void start() {
        if (this.mRunning == false) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Starting");
    L7:
        this.mRunning = true;
        bind();
    }

    public void stop() {
        if (this.mRunning == true) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Stopping");
    L7:
        this.mRunning = false;
        unbind();
    }

    public void rebindIfDisconnected() {
        if (this.mRunning == true) goto L5;
        return;
    L5:
        if (this.mConnected == true) goto L9;
        unbind();
        bind();
        return;
    }

    private void bind() {
        if (this.mBound == false) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, this + ": Binding");
    L7:
        Intent service = new Intent(SERVICE_INTERFACE);
        service.setComponent(this.mComponentName);
        this.mBound = this.mContext.bindServiceAsUser(service, this, AudioFormat.AAC_MAIN, new UserHandle(this.mUserId));     // Catch: SecurityException -> L14
        if (DEBUG == true) goto L11;
        return;
    L11:
        if (this.mBound == true) goto L26;
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
        this.mContext.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, this + ": onServiceConnected()");
    L5:
        this.mConnected = true;
        ITvRemoteProvider provider = ITvRemoteProvider.Stub.asInterface(service);
        if (provider != null) goto L14;
        Slog.e(TAG, this + ": Invalid binder");
        return;
    L14:
        provider.setRemoteServiceInputSink(new TvRemoteServiceInput(this.mLock, provider));     // Catch: RemoteException -> L11
        return;
    L12:
        Slog.e(TAG, this + ": Failed remote call to setRemoteServiceInputSink");
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        this.mConnected = false;
        if (DEBUG == false) goto L6;
        Slog.d(TAG, this + ": onServiceDisconnected()");
        return;
    }
}
