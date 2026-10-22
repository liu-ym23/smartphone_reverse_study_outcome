package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
final class DefaultConnectivityMonitor implements ConnectivityMonitor {
    private static final String TAG = "ConnectivityMonitor";
    private final BroadcastReceiver connectivityReceiver;
    private final Context context;
    boolean isConnected;
    private boolean isRegistered;
    final ConnectivityMonitor.ConnectivityListener listener;

    public DefaultConnectivityMonitor(@NonNull Context r10, @NonNull ConnectivityMonitor.ConnectivityListener r11) {
        this.connectivityReceiver = new AnonymousClass1(this);
        this.context = r10.getApplicationContext();
        this.listener = r11;
    }

    private void register() {
        if (this.isRegistered == false) goto L5;
        return;
    L5:
        this.isConnected = isConnected(this.context);
        this.context.registerReceiver(this.connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));     // Catch: SecurityException -> L8
        this.isRegistered = true;     // Catch: SecurityException -> L8
        return;
    L8:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L15;
        Log.w(TAG, "Failed to register", e);
        return;
    }

    private void unregister() {
        if (this.isRegistered == true) goto L5;
        return;
    L5:
        this.context.unregisterReceiver(this.connectivityReceiver);
        this.isRegistered = false;
    }

    @SuppressLint({"MissingPermission"})
    public boolean isConnected(@NonNull Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) Preconditions.checkNotNull((ConnectivityManager) r10.getSystemService("connectivity"))).getActiveNetworkInfo();     // Catch: RuntimeException -> L10
        if (r11 != null) goto L6;
    L8:
        return false;
    L6:
        if (r11.isConnected() == false) goto L8;
        return true;
    L10:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L14;
        Log.w(TAG, "Failed to determine connectivity status when connectivity changed", e);
    L14:
        return true;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        register();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        unregister();
    }
}
