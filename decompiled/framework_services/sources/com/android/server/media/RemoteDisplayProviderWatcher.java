package com.android.server.media;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.UserHandle;
import android.util.Log;
import android.util.Slog;
import com.android.server.pm.Settings;
import com.android.server.slice.SliceClientPermissions;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class RemoteDisplayProviderWatcher {
    private static final boolean DEBUG = false;
    private static final String TAG = "RemoteDisplayProvider";
    private final Callback mCallback;
    private final Context mContext;
    private final Handler mHandler;
    private final PackageManager mPackageManager;
    private final ArrayList<RemoteDisplayProviderProxy> mProviders;
    private boolean mRunning;
    private final BroadcastReceiver mScanPackagesReceiver;
    private final Runnable mScanPackagesRunnable;
    private final int mUserId;

    public interface Callback {
        void addProvider(RemoteDisplayProviderProxy r1);

        void removeProvider(RemoteDisplayProviderProxy r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mscanPackages, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5771$$Nest$mscanPackages(RemoteDisplayProviderWatcher r0) {
        r0.scanPackages();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5772$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public RemoteDisplayProviderWatcher(Context context, Callback callback, Handler handler, int userId) {
        this.mProviders = new ArrayList();
        this.mScanPackagesReceiver = new AnonymousClass1(this);
        this.mScanPackagesRunnable = new AnonymousClass2(this);
        this.mContext = context;
        this.mCallback = callback;
        this.mHandler = handler;
        this.mUserId = userId;
        this.mPackageManager = context.getPackageManager();
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "Watcher");
        pw.println(prefix + "  mUserId=" + this.mUserId);
        pw.println(prefix + "  mRunning=" + this.mRunning);
        pw.println(prefix + "  mProviders.size()=" + this.mProviders.size());
    }

    public void start() {
        if (this.mRunning == true) goto L6;
        this.mRunning = true;
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_ADDED");
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        filter.addAction("android.intent.action.PACKAGE_CHANGED");
        filter.addAction("android.intent.action.PACKAGE_REPLACED");
        filter.addAction("android.intent.action.PACKAGE_RESTARTED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiverAsUser(this.mScanPackagesReceiver, new UserHandle(this.mUserId), filter, null, this.mHandler);
        this.mHandler.post(this.mScanPackagesRunnable);
        return;
    }

    public void stop() {
        if (this.mRunning == false) goto L7;
        this.mRunning = false;
        this.mContext.unregisterReceiver(this.mScanPackagesReceiver);
        this.mHandler.removeCallbacks(this.mScanPackagesRunnable);
        int i = this.mProviders.size() - 1;
    L5:
        if (i < 0) goto L9;
        this.mProviders.get(i).stop();
        i = i - 1;
        goto L5
    L9:
        return;
    }

    private void scanPackages() {
        if (this.mRunning == true) goto L5;
        return;
    L5:
        int targetIndex = 0;
        Intent intent = new Intent("com.android.media.remotedisplay.RemoteDisplayProvider");
        Iterator r2 = this.mPackageManager.queryIntentServicesAsUser(intent, 0, this.mUserId).iterator();
    L7:
        if (r2.hasNext() == false) goto L19;
        ResolveInfo resolveInfo = (ResolveInfo) r2.next();
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (serviceInfo == null) goto L7;
        if (verifyServiceTrusted(serviceInfo) == false) goto L7;
        int sourceIndex = findProvider(serviceInfo.packageName, serviceInfo.name);
        if (sourceIndex < 0) goto L14;
        if (sourceIndex < targetIndex) goto L7;
        RemoteDisplayProviderProxy provider = this.mProviders.get(sourceIndex);
        provider.start();
        provider.rebindIfDisconnected();
        Collections.swap(this.mProviders, sourceIndex, targetIndex);
        targetIndex = targetIndex + 1;
        goto L7
    L14:
        RemoteDisplayProviderProxy provider2 = new RemoteDisplayProviderProxy(this.mContext, new ComponentName(serviceInfo.packageName, serviceInfo.name), this.mUserId, this.mHandler.getLooper());
        provider2.start();
        this.mProviders.add(targetIndex, provider2);
        this.mCallback.addProvider(provider2);
        targetIndex = targetIndex + 1;
        goto L7
    L19:
        if (targetIndex >= this.mProviders.size()) goto L23;
        int i = this.mProviders.size() - 1;
    L21:
        if (i < targetIndex) goto L37;
        RemoteDisplayProviderProxy provider3 = this.mProviders.get(i);
        this.mCallback.removeProvider(provider3);
        this.mProviders.remove(provider3);
        provider3.stop();
        i = i - 1;
        goto L21
    L37:
        return;
    }

    private boolean verifyServiceTrusted(ServiceInfo serviceInfo) {
        if (serviceInfo.permission != null) goto L5;
    L13:
        Slog.w(TAG, "Ignoring remote display provider service because it did not require the BIND_REMOTE_DISPLAY permission in its manifest: " + serviceInfo.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + serviceInfo.name);
        return false;
    L5:
        if (serviceInfo.permission.equals("android.permission.BIND_REMOTE_DISPLAY") == false) goto L13;
        if (this.mPackageManager.checkPermission("android.permission.REMOTE_DISPLAY_PROVIDER", serviceInfo.packageName) == 0) goto L11;
        Slog.w(TAG, "Ignoring remote display provider service because it does not have the REMOTE_DISPLAY_PROVIDER permission: " + serviceInfo.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + serviceInfo.name);
        return false;
    L11:
        return true;
    }

    private int findProvider(String packageName, String className) {
        int count = this.mProviders.size();
        int i = 0;
    L3:
        if (i >= count) goto L8;
        RemoteDisplayProviderProxy provider = this.mProviders.get(i);
        if (provider.hasComponentName(packageName, className) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        return i;
    L8:
        return -1;
    }
}
