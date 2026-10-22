package com.android.server.vr;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.content.PackageMonitor;
import com.android.server.slice.SliceClientPermissions;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class EnabledComponentsObserver implements SettingsObserver.SettingChangeListener {
    public static final int DISABLED = -1;
    private static final String ENABLED_SERVICES_SEPARATOR = ":";
    public static final int NOT_INSTALLED = -2;
    public static final int NO_ERROR = 0;
    private static final String TAG = null;
    private final Context mContext;
    private final Set<EnabledComponentChangeListener> mEnabledComponentListeners;
    private final SparseArray<ArraySet<ComponentName>> mEnabledSet;
    private final SparseArray<ArraySet<ComponentName>> mInstalledSet;
    private final Object mLock;
    private final PackageMonitor mPackageMonitor;
    private final String mServiceName;
    private final String mServicePermission;
    private final String mSettingName;

    public interface EnabledComponentChangeListener {
        void onEnabledComponentChanged();
    }

    static {
        TAG = EnabledComponentsObserver.class.getSimpleName();
    }

    private EnabledComponentsObserver(Context context, String settingName, String servicePermission, String serviceName, Object lock, Collection<EnabledComponentChangeListener> listeners, Looper looper) {
        this.mInstalledSet = new SparseArray();
        this.mEnabledSet = new SparseArray();
        this.mEnabledComponentListeners = new ArraySet();
        this.mLock = lock;
        this.mContext = context;
        this.mSettingName = settingName;
        this.mServiceName = serviceName;
        this.mServicePermission = servicePermission;
        this.mEnabledComponentListeners.addAll(listeners);
        final boolean r1 = true;
        this.mPackageMonitor = new AnonymousClass1(this, r1);
        this.mPackageMonitor.register(context, looper, UserHandle.ALL, true);
    }

    public static EnabledComponentsObserver build(Context context, Handler handler, String settingName, Looper looper, String servicePermission, String serviceName, Object lock, Collection<EnabledComponentChangeListener> listeners) {
        SettingsObserver s = SettingsObserver.build(context, handler, settingName);
        EnabledComponentsObserver o = new EnabledComponentsObserver(context, settingName, servicePermission, serviceName, lock, listeners, looper);
        s.addListener(o);
        return o;
    }

    public void onPackagesChanged() {
        rebuildAll();
    }

    @Override // com.android.server.vr.SettingsObserver.SettingChangeListener
    public void onSettingChanged() {
        rebuildAll();
    }

    @Override // com.android.server.vr.SettingsObserver.SettingChangeListener
    public void onSettingRestored(String prevValue, String newValue, int userId) {
        rebuildAll();
    }

    public void onUsersChanged() {
        rebuildAll();
    }

    public void rebuildAll() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInstalledSet.clear();     // Catch: Throwable -> L8
        this.mEnabledSet.clear();     // Catch: Throwable -> L8
        int[] userIds = getCurrentProfileIds();     // Catch: Throwable -> L8
        int r2 = userIds.length;     // Catch: Throwable -> L8
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L10;
        int i = userIds[r3];     // Catch: Throwable -> L8
        ArraySet<ComponentName> implementingPackages = loadComponentNamesForUser(i);     // Catch: Throwable -> L8
        ArraySet<ComponentName> packagesFromSettings = loadComponentNamesFromSetting(this.mSettingName, i);     // Catch: Throwable -> L8
        packagesFromSettings.retainAll(implementingPackages);     // Catch: Throwable -> L8
        this.mInstalledSet.put(i, implementingPackages);     // Catch: Throwable -> L8
        this.mEnabledSet.put(i, packagesFromSettings);     // Catch: Throwable -> L8
        r3 = r3 + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        sendSettingChanged();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public int isValid(ComponentName component, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<ComponentName> installedComponents = this.mInstalledSet.get(userId);     // Catch: Throwable -> L17
        if (installedComponents == null) goto L22;
        if (installedComponents.contains(component) == false) goto L22;
        ArraySet<ComponentName> validComponents = this.mEnabledSet.get(userId);     // Catch: Throwable -> L17
        if (validComponents == null) goto L19;
        if (validComponents.contains(component) == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return 0;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return -1;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return -2;
    L17:
        th = move-exception;
        throw th;
    }

    public ArraySet<ComponentName> getInstalled(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<ComponentName> ret = this.mInstalledSet.get(userId);     // Catch: Throwable -> L9
        if (ret != null) goto L11;
        ArraySet<ComponentName> r2 = new ArraySet();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return ret;
    L9:
        th = move-exception;
        throw th;
    }

    public ArraySet<ComponentName> getEnabled(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<ComponentName> ret = this.mEnabledSet.get(userId);     // Catch: Throwable -> L9
        if (ret != null) goto L11;
        ArraySet<ComponentName> r2 = new ArraySet();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return ret;
    L9:
        th = move-exception;
        throw th;
    }

    private int[] getCurrentProfileIds() {
        UserManager userManager = (UserManager) this.mContext.getSystemService("user");
        if (userManager != null) goto L7;
        return null;
    L7:
        return userManager.getEnabledProfileIds(ActivityManager.getCurrentUser());
    }

    public static ArraySet<ComponentName> loadComponentNames(PackageManager pm, int userId, String serviceName, String permissionName) {
        ArraySet<ComponentName> installed = new ArraySet();
        Intent queryIntent = new Intent(serviceName);
        List<ResolveInfo> installedServices = pm.queryIntentServicesAsUser(queryIntent, 786564, userId);
        if (installedServices == null) goto L11;
        int i = 0;
        int count = installedServices.size();
    L5:
        if (i >= count) goto L11;
        ResolveInfo resolveInfo = installedServices.get(i);
        ServiceInfo info = resolveInfo.serviceInfo;
        ComponentName component = new ComponentName(info.packageName, info.name);
        if (permissionName.equals(info.permission) == true) goto L9;
        Slog.w(TAG, "Skipping service " + info.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + info.name + ": it does not require the permission " + permissionName);
    L10:
        i = i + 1;
        goto L5
    L9:
        installed.add(component);
    L11:
        return installed;
    }

    private ArraySet<ComponentName> loadComponentNamesForUser(int userId) {
        return loadComponentNames(this.mContext.getPackageManager(), userId, this.mServiceName, this.mServicePermission);
    }

    private ArraySet<ComponentName> loadComponentNamesFromSetting(String settingName, int userId) {
        ContentResolver cr = this.mContext.getContentResolver();
        String settingValue = Settings.Secure.getStringForUser(cr, settingName, userId);
        if (TextUtils.isEmpty(settingValue) == true) goto L5;
        String[] restored = settingValue.split(ENABLED_SERVICES_SEPARATOR);
        ArraySet<ComponentName> result = new ArraySet(restored.length);
        int i = 0;
    L8:
        if (i >= restored.length) goto L14;
        ComponentName value = ComponentName.unflattenFromString(restored[i]);
        if (value == null) goto L12;
        result.add(value);
    L12:
        i = i + 1;
        goto L8
    L14:
        return result;
    L5:
        return new ArraySet();
    }

    private void sendSettingChanged() {
        Iterator<EnabledComponentChangeListener> r0 = this.mEnabledComponentListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        EnabledComponentChangeListener l = r0.next();
        l.onEnabledComponentChanged();
        goto L4
    }
}
