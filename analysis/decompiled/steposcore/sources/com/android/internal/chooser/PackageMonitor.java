package com.android.internal.chooser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes.dex */
public abstract class PackageMonitor extends BroadcastReceiver {
    private Context mContext;
    private boolean mIsRegistered = false;

    protected abstract void onPackageChanged();

    public synchronized void register(Context context) {
        if (this.mIsRegistered) {
            return;
        }
        this.mIsRegistered = true;
        this.mContext = context;
        IntentFilter mFilter = new IntentFilter();
        mFilter.addDataScheme("package");
        mFilter.addAction("android.intent.action.PACKAGE_ADDED");
        mFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        mFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        context.registerReceiver(this, mFilter);
    }

    public synchronized void unregister() {
        if (this.mIsRegistered) {
            this.mIsRegistered = false;
            this.mContext.unregisterReceiver(this);
            this.mContext = null;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        onPackageChanged();
    }
}
