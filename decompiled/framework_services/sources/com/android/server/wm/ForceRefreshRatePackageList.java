package com.android.server.wm;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.view.Display;
import android.view.DisplayInfo;
import com.android.server.UiThread;

/* JADX INFO: compiled from: ForceRefreshRatePackagelist.java */
/* JADX INFO: loaded from: classes3.dex */
class ForceRefreshRatePackageList {
    private static final String KEY_FORCE_REFRESH_RATE_LIST = "ext_force_refresh_rate_list";
    private static final float REFRESH_RATE_EPSILON = 0.01f;
    private static final String TAG = null;
    private DisplayInfo mDisplayInfo;
    private final ArrayMap<String, Float> mForcedPackageList;
    private final Handler mHandler;
    private final Object mLock;
    private SettingsObserver mSettingsObserver;

    /* JADX INFO: compiled from: ForceRefreshRatePackagelist.java */
    private class SettingsObserver extends ContentObserver {
        private Context mContext;
        private final Uri mForceRefreshRateListSetting;
        final /* synthetic */ ForceRefreshRatePackageList this$0;

        SettingsObserver(ForceRefreshRatePackageList r1, Context context) {
            this.this$0 = r1;
            super(ForceRefreshRatePackageList.m9991$$Nest$fgetmHandler(r1));
            this.mForceRefreshRateListSetting = Settings.System.getUriFor(ForceRefreshRatePackageList.KEY_FORCE_REFRESH_RATE_LIST);
            this.mContext = context;
        }

        public void observe() {
            ContentResolver cr = this.mContext.getContentResolver();
            cr.registerContentObserver(this.mForceRefreshRateListSetting, false, this, 0);
            ForceRefreshRatePackageList.m9992$$Nest$mupdateForcedPackagelist(this.this$0, getForcePackages());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            if (this.mForceRefreshRateListSetting.equals(uri) == false) goto L6;
            ForceRefreshRatePackageList.m9992$$Nest$mupdateForcedPackagelist(this.this$0, getForcePackages());
            return;
        }

        private String getForcePackages() {
            ContentResolver cr = this.mContext.getContentResolver();
            return Settings.System.getString(cr, ForceRefreshRatePackageList.KEY_FORCE_REFRESH_RATE_LIST);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m9991$$Nest$fgetmHandler(ForceRefreshRatePackageList r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateForcedPackagelist, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9992$$Nest$mupdateForcedPackagelist(ForceRefreshRatePackageList r0, String r1) {
        r0.updateForcedPackagelist(r1);
    }

    static {
        TAG = ForceRefreshRatePackageList.class.getSimpleName();
    }

    ForceRefreshRatePackageList(WindowManagerService wmService, DisplayInfo displayInfo) {
        this.mForcedPackageList = new ArrayMap();
        this.mLock = new Object();
        this.mDisplayInfo = displayInfo;
        Looper looper = UiThread.getHandler().getLooper();
        this.mHandler = new Handler(looper);
        this.mSettingsObserver = new SettingsObserver(this, wmService.mContext);
        Handler r1 = this.mHandler;
        final SettingsObserver r2 = this.mSettingsObserver;
        r2.getClass();
        r1.post(new ForceRefreshRatePackageList$$ExternalSyntheticLambda0(r2));
    }

    private void updateForcedPackagelist(String forcePackagesStr) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mForcedPackageList.clear();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(forcePackagesStr) == true) goto L23;
        String[] pairs = forcePackagesStr.split(";");     // Catch: Throwable -> L18
        int r2 = pairs.length;     // Catch: Throwable -> L18
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L23;
        String pair = pairs[r4];     // Catch: Throwable -> L18
        String[] keyValue = pair.split(",");     // Catch: Throwable -> L18
        if (keyValue == null) goto L22;
        if (keyValue.length != 2) goto L22;
        if (TextUtils.isEmpty(keyValue[0].trim()) == true) goto L22;
        if (TextUtils.isEmpty(keyValue[1].trim()) == true) goto L22;
        String packageName = keyValue[0].trim();     // Catch: Throwable -> L18 NumberFormatException -> L20
        Float refreshRate = new Float(keyValue[1].trim());     // Catch: Throwable -> L18 NumberFormatException -> L20
        this.mForcedPackageList.put(packageName, refreshRate);     // Catch: Throwable -> L18 NumberFormatException -> L20
    L21:
        Log.e(TAG, "Invalid refresh rate input! input: " + keyValue);     // Catch: Throwable -> L18
    L22:
        r4 = r4 + 1;     // Catch: Throwable -> L18
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    int getForceRefreshRateId(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r2 = 0;
        if (this.mForcedPackageList.containsKey(packageName) == false) goto L13;
        float refreshRate = this.mForcedPackageList.get(packageName).floatValue();     // Catch: Throwable -> L9
        Display.Mode mode = findModeByRefreshRate(refreshRate);     // Catch: Throwable -> L9
        if (mode == null) goto L11;
        r2 = mode.getModeId();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L9:
        th = move-exception;
        throw th;
    }

    float getForceRefreshRate(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        float r2 = 0.0f;
        if (this.mForcedPackageList.containsKey(packageName) == false) goto L13;
        float refreshRate = this.mForcedPackageList.get(packageName).floatValue();     // Catch: Throwable -> L9
        Display.Mode mode = findModeByRefreshRate(refreshRate);     // Catch: Throwable -> L9
        if (mode == null) goto L11;
        r2 = mode.getRefreshRate();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0.0f;
    L9:
        th = move-exception;
        throw th;
    }

    private Display.Mode findModeByRefreshRate(float refreshRate) {
        Display.Mode[] modes = this.mDisplayInfo.supportedModes;
        int i = 0;
    L4:
        if (i >= modes.length) goto L10;
        if (Math.abs(modes[i].getRefreshRate() - refreshRate) < 0.01f) goto L8;
        i = i + 1;
        goto L4
    L8:
        return modes[i];
    L10:
        return null;
    }
}
