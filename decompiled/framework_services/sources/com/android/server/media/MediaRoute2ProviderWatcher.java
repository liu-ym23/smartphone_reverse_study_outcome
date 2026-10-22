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
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import com.android.server.pm.Settings;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class MediaRoute2ProviderWatcher {
    private static final boolean DEBUG = false;
    private static final PackageManager.ResolveInfoFlags RESOLVE_INFO_FLAGS = null;
    private static final String TAG = "MR2ProviderWatcher";
    private final Callback mCallback;
    private final Context mContext;
    private final Handler mHandler;
    private final PackageManager mPackageManager;
    private final ArrayList<MediaRoute2ProviderServiceProxy> mProxies;
    private boolean mRunning;
    private final BroadcastReceiver mScanPackagesReceiver;
    private final Runnable mScanPackagesRunnable;
    private final int mUserId;

    public interface Callback {
        void onAddProviderService(MediaRoute2ProviderServiceProxy r1);

        void onRemoveProviderService(MediaRoute2ProviderServiceProxy r1);
    }

    public static /* synthetic */ void $r8$lambda$uxDP7YbvEhxettSyL1qhqc8pTDY(MediaRoute2ProviderWatcher r0) {
        r0.scanPackages();
    }

    /* JADX INFO: renamed from: -$$Nest$mpostScanPackagesIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5565$$Nest$mpostScanPackagesIfNeeded(MediaRoute2ProviderWatcher r0) {
        r0.postScanPackagesIfNeeded();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5566$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        RESOLVE_INFO_FLAGS = PackageManager.ResolveInfoFlags.of(64);
    }

    MediaRoute2ProviderWatcher(Context context, Callback callback, Handler handler, int userId) {
        this.mProxies = new ArrayList();
        this.mScanPackagesRunnable = new MediaRoute2ProviderWatcher$$ExternalSyntheticLambda0(this);
        this.mScanPackagesReceiver = new AnonymousClass1(this);
        this.mContext = context;
        this.mCallback = callback;
        this.mHandler = handler;
        this.mUserId = userId;
        this.mPackageManager = context.getPackageManager();
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "MediaRoute2ProviderWatcher");
        String prefix2 = prefix + "  ";
        if (this.mProxies.isEmpty() == false) goto L5;
        pw.println(prefix2 + "<no provider service proxies>");
        return;
    L5:
        Iterator<MediaRoute2ProviderServiceProxy> r0 = this.mProxies.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        MediaRoute2ProviderServiceProxy proxy = r0.next();
        proxy.dump(pw, prefix2);
        goto L7
    }

    public void start() {
        if (this.mRunning == true) goto L6;
        this.mRunning = true;
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_ADDED");
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        filter.addAction("android.intent.action.PACKAGE_CHANGED");
        filter.addAction("android.intent.action.PACKAGE_REPLACED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiverAsUser(this.mScanPackagesReceiver, new UserHandle(this.mUserId), filter, null, this.mHandler);
        postScanPackagesIfNeeded();
        return;
    }

    public void stop() {
        if (this.mRunning == false) goto L7;
        this.mRunning = false;
        this.mContext.unregisterReceiver(this.mScanPackagesReceiver);
        this.mHandler.removeCallbacks(this.mScanPackagesRunnable);
        int i = this.mProxies.size() - 1;
    L5:
        if (i < 0) goto L9;
        this.mProxies.get(i).stop();
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
        Intent intent = new Intent("android.media.MediaRoute2ProviderService");
        Iterator r3 = this.mPackageManager.queryIntentServicesAsUser(intent, RESOLVE_INFO_FLAGS, this.mUserId).iterator();
    L6:
        boolean r6 = true;
        if (r3.hasNext() == false) goto L29;
        ResolveInfo resolveInfo = (ResolveInfo) r3.next();
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (serviceInfo == null) goto L6;
        boolean isSelfScanOnlyProvider = false;
        boolean supportsSystemMediaRouting = false;
        Iterator<String> categoriesIterator = resolveInfo.filter.categoriesIterator();
        if (categoriesIterator != null) goto L13;
        boolean isSelfScanOnlyProvider2 = false;
    L17:
        int sourceIndex = findProvider(serviceInfo.packageName, serviceInfo.name);
        if (sourceIndex < 0) goto L19;
        if (sourceIndex < targetIndex) goto L6;
        this.mProxies.get(sourceIndex).start(false);
        Collections.swap(this.mProxies, sourceIndex, targetIndex);
        targetIndex = targetIndex + 1;
        goto L6
    L19:
        boolean supportsSystemMediaRouting2 = supportsSystemMediaRouting & false;
        if (this.mPackageManager.checkPermission("android.permission.MODIFY_AUDIO_ROUTING", serviceInfo.packageName) == 0) goto L23;
        r6 = false;
    L23:
        boolean supportsSystemMediaRouting3 = supportsSystemMediaRouting2 & r6;
        MediaRoute2ProviderServiceProxy proxy = new MediaRoute2ProviderServiceProxy(this.mContext, this.mHandler.getLooper(), new ComponentName(serviceInfo.packageName, serviceInfo.name), isSelfScanOnlyProvider2, supportsSystemMediaRouting3, this.mUserId);
        Slog.i(TAG, TextUtils.formatSimple("Enabling proxy for MediaRoute2ProviderService: %s (isSelfScan=%b, supportsSystemMediaRouting=%b, userId=%d)", new Object[]{proxy.mComponentName, Boolean.valueOf(isSelfScanOnlyProvider2), Boolean.valueOf(supportsSystemMediaRouting3), Integer.valueOf(this.mUserId)}));
        proxy.start(false);
        this.mProxies.add(targetIndex, proxy);
        this.mCallback.onAddProviderService(proxy);
        targetIndex = targetIndex + 1;
    L13:
        if (categoriesIterator.hasNext() == false) goto L15;
        String category = categoriesIterator.next();
        isSelfScanOnlyProvider = isSelfScanOnlyProvider | "android.media.MediaRoute2ProviderService.SELF_SCAN_ONLY".equals(category);
        supportsSystemMediaRouting = supportsSystemMediaRouting | "android.media.MediaRoute2ProviderService.SYSTEM_MEDIA".equals(category);
        goto L13
    L15:
        isSelfScanOnlyProvider2 = isSelfScanOnlyProvider;
        goto L17
    L29:
        if (targetIndex >= this.mProxies.size()) goto L33;
        int i = this.mProxies.size() - 1;
    L31:
        if (i < targetIndex) goto L46;
        MediaRoute2ProviderServiceProxy proxy2 = this.mProxies.get(i);
        Slog.i(TAG, "Disabling proxy for MediaRoute2ProviderService: " + proxy2.mComponentName);
        this.mCallback.onRemoveProviderService(proxy2);
        this.mProxies.remove(proxy2);
        proxy2.stop();
        i = i - 1;
        goto L31
    L46:
        return;
    }

    private int findProvider(String packageName, String className) {
        int count = this.mProxies.size();
        int i = 0;
    L3:
        if (i >= count) goto L8;
        MediaRoute2ProviderServiceProxy proxy = this.mProxies.get(i);
        if (proxy.hasComponentName(packageName, className) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        return i;
    L8:
        return -1;
    }

    private void postScanPackagesIfNeeded() {
        if (this.mHandler.hasCallbacks(this.mScanPackagesRunnable) == true) goto L6;
        this.mHandler.post(this.mScanPackagesRunnable);
        return;
    }
}
