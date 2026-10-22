package com.android.server.tv;

import android.R;
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
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import com.android.server.pm.Settings;
import com.android.server.slice.SliceClientPermissions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class TvRemoteProviderWatcher {
    private static final boolean DEBUG = false;
    private static final String TAG = "TvRemoteProviderWatcher";
    private final Context mContext;
    private final Handler mHandler;
    private final Object mLock;
    private final PackageManager mPackageManager;
    private final ArrayList<TvRemoteProviderProxy> mProviderProxies;
    private boolean mRunning;
    private final BroadcastReceiver mScanPackagesReceiver;
    private final Runnable mScanPackagesRunnable;
    private final Set<String> mUnbundledServicePackages;
    private final int mUserId;

    public static /* synthetic */ void $r8$lambda$KLb5GFbNkNzM0GX2sKFWBRaPkqk(TvRemoteProviderWatcher r0, String r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m8874$$Nest$fgetmHandler(TvRemoteProviderWatcher r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScanPackagesRunnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m8875$$Nest$fgetmScanPackagesRunnable(TvRemoteProviderWatcher r0) {
        return r0.mScanPackagesRunnable;
    }

    /* JADX INFO: renamed from: -$$Nest$mscanPackages, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8876$$Nest$mscanPackages(TvRemoteProviderWatcher r0) {
        r0.scanPackages();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8877$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 2);
    }

    TvRemoteProviderWatcher(Context context, Object lock, Handler handler) {
        this.mProviderProxies = new ArrayList();
        this.mUnbundledServicePackages = new HashSet();
        this.mScanPackagesReceiver = new AnonymousClass1(this);
        this.mScanPackagesRunnable = new AnonymousClass2(this);
        this.mContext = context;
        this.mHandler = handler;
        this.mUserId = UserHandle.myUserId();
        this.mPackageManager = context.getPackageManager();
        this.mLock = lock;
        TextUtils.SimpleStringSplitter splitter = new TextUtils.SimpleStringSplitter(',');
        splitter.setString(context.getString(R.string.data_saver_description));
        splitter.forEach(new TvRemoteProviderWatcher$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$new$0(String packageName) {
        String packageName2 = packageName.trim();
        if (packageName2.isEmpty() == true) goto L6;
        this.mUnbundledServicePackages.add(packageName2);
        return;
    }

    TvRemoteProviderWatcher(Context context, Object lock) {
        this(context, lock, new Handler(true));
    }

    public void start() {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "start()");
    L6:
        if (this.mRunning == true) goto L9;
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
        int i = this.mProviderProxies.size() - 1;
    L5:
        if (i < 0) goto L9;
        this.mProviderProxies.get(i).stop();
        i = i - 1;
        goto L5
    L9:
        return;
    }

    private void scanPackages() {
        if (this.mRunning == true) goto L6;
        return;
    L6:
        if (DEBUG == false) goto L8;
        Log.d(TAG, "scanPackages()");
    L8:
        int targetIndex = 0;
        Intent intent = new Intent("com.android.media.tv.remoteprovider.TvRemoteProvider");
        Iterator r3 = this.mPackageManager.queryIntentServicesAsUser(intent, 0, this.mUserId).iterator();
    L10:
        if (r3.hasNext() == false) goto L22;
        ResolveInfo resolveInfo = (ResolveInfo) r3.next();
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (serviceInfo == null) goto L10;
        if (verifyServiceTrusted(serviceInfo) == false) goto L10;
        int sourceIndex = findProvider(serviceInfo.packageName, serviceInfo.name);
        if (sourceIndex < 0) goto L17;
        if (sourceIndex < targetIndex) goto L10;
        TvRemoteProviderProxy provider = this.mProviderProxies.get(sourceIndex);
        provider.start();
        provider.rebindIfDisconnected();
        Collections.swap(this.mProviderProxies, sourceIndex, targetIndex);
        targetIndex = targetIndex + 1;
        goto L10
    L17:
        TvRemoteProviderProxy providerProxy = new TvRemoteProviderProxy(this.mContext, this.mLock, new ComponentName(serviceInfo.packageName, serviceInfo.name), this.mUserId, serviceInfo.applicationInfo.uid);
        providerProxy.start();
        this.mProviderProxies.add(targetIndex, providerProxy);
        targetIndex = targetIndex + 1;
        goto L10
    L22:
        if (DEBUG == false) goto L25;
        Log.d(TAG, "scanPackages() targetIndex " + targetIndex);
    L25:
        if (targetIndex >= this.mProviderProxies.size()) goto L29;
        int i = this.mProviderProxies.size() - 1;
    L27:
        if (i < targetIndex) goto L43;
        TvRemoteProviderProxy providerProxy2 = this.mProviderProxies.get(i);
        this.mProviderProxies.remove(providerProxy2);
        providerProxy2.stop();
        i = i - 1;
        goto L27
    L43:
        return;
    }

    boolean verifyServiceTrusted(ServiceInfo serviceInfo) {
        if (serviceInfo.permission != null) goto L5;
    L17:
        Slog.w(TAG, "Ignoring atv remote provider service because it did not require the BIND_TV_REMOTE_SERVICE permission in its manifest: " + serviceInfo.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + serviceInfo.name);
        return false;
    L5:
        if (serviceInfo.permission.equals("android.permission.BIND_TV_REMOTE_SERVICE") == false) goto L17;
        if (this.mUnbundledServicePackages.contains(serviceInfo.packageName) == true) goto L12;
        Slog.w(TAG, "Ignoring atv remote provider service because the package has not been set and/or whitelisted: " + serviceInfo.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + serviceInfo.name);
        return false;
    L12:
        if (hasNecessaryPermissions(serviceInfo.packageName) == true) goto L15;
        Slog.w(TAG, "Ignoring atv remote provider service because its package does not have TV_VIRTUAL_REMOTE_CONTROLLER permission: " + serviceInfo.packageName);
        return false;
    L15:
        return true;
    }

    private boolean hasNecessaryPermissions(String packageName) {
        if (this.mPackageManager.checkPermission("android.permission.TV_VIRTUAL_REMOTE_CONTROLLER", packageName) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    private int findProvider(String packageName, String className) {
        int count = this.mProviderProxies.size();
        int i = 0;
    L3:
        if (i >= count) goto L8;
        TvRemoteProviderProxy provider = this.mProviderProxies.get(i);
        if (provider.hasComponentName(packageName, className) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        return i;
    L8:
        return -1;
    }
}
