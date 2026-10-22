package com.android.server.am;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import com.android.internal.content.PackageMonitor;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.compat.PlatformCompat;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ComponentAliasResolver {
    private static final String ALIAS_FILTER_ACTION = "com.android.intent.action.EXPERIMENTAL_IS_ALIAS";
    private static final String ALIAS_FILTER_ACTION_ALT = "android.intent.action.EXPERIMENTAL_IS_ALIAS";
    private static final boolean DEBUG = true;
    private static final String META_DATA_ALIAS_TARGET = "alias_target";
    private static final String OPT_IN_PROPERTY = "com.android.EXPERIMENTAL_COMPONENT_ALIAS_OPT_IN";
    private static final int PACKAGE_QUERY_FLAGS = 4989056;
    private static final String TAG = "ComponentAliasResolver";
    public static final long USE_EXPERIMENTAL_COMPONENT_ALIAS = 196254758;
    private final ActivityManagerService mAm;
    private final Context mContext;
    private boolean mEnabled;
    private boolean mEnabledByDeviceConfig;
    private final ArrayMap<ComponentName, ComponentName> mFromTo;
    private final Object mLock;
    private String mOverrideString;
    final PackageMonitor mPackageMonitor;
    private PlatformCompat mPlatformCompat;

    public static class Resolution<T> {
        public final T resolved;
        public final T source;

        public Resolution(T source, T resolved) {
            this.source = source;
            this.resolved = resolved;
        }

        public boolean isAlias() {
            if (this.resolved == null) goto L5;
            return true;
        L5:
            return false;
        }

        public T getAlias() {
            if (isAlias() == true) goto L7;
            return null;
        L7:
            return this.source;
        }

        public T getTarget() {
            if (isAlias() == true) goto L7;
            return null;
        L7:
            return this.resolved;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$7HSIXW-bnHBdHaW1w1BvxdFH7hM, reason: not valid java name */
    public static /* synthetic */ void m1495$r8$lambda$7HSIXWbnHBdHaW1w1BvxdFH7hM(ComponentAliasResolver r0) {
        r0.lambda$update$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$jzDSoplopK0y2WasSsxZRtHLY-0, reason: not valid java name */
    public static /* synthetic */ ComponentName m1496$r8$lambda$jzDSoplopK0y2WasSsxZRtHLY0(ResolveInfo r0) {
        return lambda$resolveReceiver$2(r0);
    }

    public static /* synthetic */ ComponentName $r8$lambda$w_UDsI7lyPAfPRG4TDZeP8takq8(Intent r0, String r1, int r2, int r3, int r4) {
        return lambda$resolveService$1(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mrefresh, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1497$$Nest$mrefresh(ComponentAliasResolver r0) {
        r0.refresh();
    }

    public ComponentAliasResolver(ActivityManagerService service) {
        this.mLock = new Object();
        this.mFromTo = new ArrayMap();
        this.mPackageMonitor = new AnonymousClass1(this);
        this.mAm = service;
        this.mContext = service.mContext;
    }

    public boolean isEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void onSystemReady(boolean enabledByDeviceConfig, String overrides) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPlatformCompat = (PlatformCompat) ServiceManager.getService("platform_compat");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        Slog.d(TAG, "Compat listener set.");
        update(enabledByDeviceConfig, overrides);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void update(boolean enabledByDeviceConfig, String overrides) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPlatformCompat != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mEnabled == false) goto L13;
        Slog.i(TAG, "Disabling component aliases...");     // Catch: Throwable -> L8
        FgThread.getHandler().post(new ComponentAliasResolver$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L8
    L13:
        this.mEnabled = false;     // Catch: Throwable -> L8
        this.mEnabledByDeviceConfig = enabledByDeviceConfig;     // Catch: Throwable -> L8
        this.mOverrideString = overrides;     // Catch: Throwable -> L8
        if (this.mEnabled == false) goto L16;
        refreshLocked();     // Catch: Throwable -> L8
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L16:
        this.mFromTo.clear();     // Catch: Throwable -> L8
        goto L17
    }

    private /* synthetic */ void lambda$update$0() {
        this.mPackageMonitor.unregister();
    }

    private void refresh() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        update(this.mEnabledByDeviceConfig, this.mOverrideString);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void refreshLocked() {
        Slog.d(TAG, "Refreshing aliases...");
        this.mFromTo.clear();
        loadFromMetadataLocked();
        loadOverridesLocked();
    }

    private void loadFromMetadataLocked() {
        Slog.d(TAG, "Scanning service aliases...");
        loadFromMetadataLockedInner(new Intent(ALIAS_FILTER_ACTION_ALT));
        loadFromMetadataLockedInner(new Intent(ALIAS_FILTER_ACTION));
    }

    private void loadFromMetadataLockedInner(Intent i) {
        List services = this.mContext.getPackageManager().queryIntentServicesAsUser(i, PACKAGE_QUERY_FLAGS, 0);
        extractAliasesLocked(services);
        Slog.d(TAG, "Scanning receiver aliases...");
        List receivers = this.mContext.getPackageManager().queryBroadcastReceiversAsUser(i, PACKAGE_QUERY_FLAGS, 0);
        extractAliasesLocked(receivers);
    }

    private boolean isEnabledForPackageLocked(String packageName) {
        boolean enabled = false;
        PackageManager.Property p = this.mContext.getPackageManager().getProperty(OPT_IN_PROPERTY, packageName);     // Catch: PackageManager.NameNotFoundException -> L5
        enabled = p.getBoolean();     // Catch: PackageManager.NameNotFoundException -> L5
    L6:
        if (enabled == true) goto L8;
        Slog.w(TAG, "USE_EXPERIMENTAL_COMPONENT_ALIAS not enabled for " + packageName);
    L8:
        return enabled;
    }

    private static boolean validateAlias(ComponentName from, ComponentName to) {
        String fromPackage = from.getPackageName();
        String toPackage = to.getPackageName();
        if (Objects.equals(fromPackage, toPackage) == false) goto L6;
        return true;
    L6:
        if (toPackage.startsWith(fromPackage + ".") == false) goto L8;
        return true;
    L8:
        Slog.w(TAG, "Invalid alias: " + from.flattenToShortString() + " -> " + to.flattenToShortString());
        return false;
    }

    private void validateAndAddAliasLocked(ComponentName from, ComponentName to) {
        Slog.d(TAG, "" + from.flattenToShortString() + " -> " + to.flattenToShortString());
        if (validateAlias(from, to) == true) goto L6;
        return;
    L6:
        if (isEnabledForPackageLocked(from.getPackageName()) == true) goto L8;
        return;
    L8:
        if (isEnabledForPackageLocked(to.getPackageName()) == false) goto L13;
        this.mFromTo.put(from, to);
        return;
    }

    private void extractAliasesLocked(List<ResolveInfo> components) {
        Iterator<ResolveInfo> r0 = components.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ResolveInfo ri = r0.next();
        ComponentInfo ci = ri.getComponentInfo();
        ComponentName from = ci.getComponentName();
        ComponentName to = unflatten(ci.metaData.getString(META_DATA_ALIAS_TARGET));
        if (to == null) goto L4;
        validateAndAddAliasLocked(from, to);
        goto L4
    }

    private void loadOverridesLocked() {
        Slog.d(TAG, "Loading aliases overrides ...");
        String[] r0 = this.mOverrideString.split("\\,+");
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L18;
        String line = r0[r4];
        String[] fields = line.split("\\:+", 2);
        if (TextUtils.isEmpty(fields[0]) == true) goto L17;
        ComponentName from = unflatten(fields[0]);
        if (from == null) goto L17;
        if (fields.length != 1) goto L13;
        Slog.d(TAG, "" + from.flattenToShortString() + " [removed]");
        this.mFromTo.remove(from);
        goto L17
    L13:
        ComponentName to = unflatten(fields[1]);
        if (to == null) goto L17;
        validateAndAddAliasLocked(from, to);
    L17:
        r4 = r4 + 1;
        goto L3
    }

    private static ComponentName unflatten(String name) {
        ComponentName cn = ComponentName.unflattenFromString(name);
        if (cn == null) goto L5;
        return cn;
    L5:
        Slog.e(TAG, "Invalid component name detected: " + name);
        return null;
    }

    public void dump(PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("ACTIVITY MANAGER COMPONENT-ALIAS (dumpsys activity component-alias)");     // Catch: Throwable -> L8
        pw.print("  Enabled: ");     // Catch: Throwable -> L8
        pw.println(this.mEnabled);     // Catch: Throwable -> L8
        pw.println("  Aliases:");     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mFromTo.size()) goto L10;
        ComponentName from = this.mFromTo.keyAt(i);     // Catch: Throwable -> L8
        ComponentName to = this.mFromTo.valueAt(i);     // Catch: Throwable -> L8
        pw.print("    ");     // Catch: Throwable -> L8
        pw.print(from.flattenToShortString());     // Catch: Throwable -> L8
        pw.print(" -> ");     // Catch: Throwable -> L8
        pw.print(to.flattenToShortString());     // Catch: Throwable -> L8
        pw.println();     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        pw.println();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public Resolution<ComponentName> resolveComponentAlias(Supplier<ComponentName> aliasSupplier) {
        long identity = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L25
        monitor-enter(r2);     // Catch: Throwable -> L25
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L6:
        if (this.mEnabled == true) goto L13;
        Resolution<ComponentName> r3 = new Resolution(null, null);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(identity);
        return r3;
    L13:
        ComponentName alias = aliasSupplier.get();     // Catch: Throwable -> L11
        ComponentName target = this.mFromTo.get(alias);     // Catch: Throwable -> L11
        if (target == null) goto L19;
        Exception stacktrace = null;
        if (Log.isLoggable(TAG, 2) == false) goto L18;
        stacktrace = new RuntimeException("STACKTRACE");     // Catch: Throwable -> L11
    L18:
        Slog.d(TAG, "Alias resolved: " + alias.flattenToShortString() + " -> " + target.flattenToShortString(), stacktrace);     // Catch: Throwable -> L11
    L19:
        Resolution<ComponentName> r5 = new Resolution(alias, target);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(identity);
        return r5;
    L25:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public Resolution<ComponentName> resolveService(final Intent service, final String resolvedType, final int packageFlags, final int userId, final int callingUid) {
        Resolution<ComponentName> result = resolveComponentAlias(new ComponentAliasResolver$$ExternalSyntheticLambda0(service, resolvedType, packageFlags, userId, callingUid));
        if (result != null) goto L5;
    L7:
        return result;
    L5:
        if (result.isAlias() == false) goto L7;
        service.setOriginalIntent(new Intent(service));
        service.setPackage(null);
        service.setComponent(result.getTarget());
        goto L7
    }

    private static /* synthetic */ ComponentName lambda$resolveService$1(Intent service, String resolvedType, int packageFlags, int userId, int callingUid) {
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        ResolveInfo rInfo = pmi.resolveService(service, resolvedType, packageFlags, userId, callingUid);
        if (rInfo == null) goto L5;
        ServiceInfo sInfo = rInfo.serviceInfo;
    L6:
        if (sInfo != null) goto L9;
        return null;
    L9:
        return new ComponentName(sInfo.applicationInfo.packageName, sInfo.name);
    L5:
        sInfo = null;
        goto L6
    }

    public Resolution<ResolveInfo> resolveReceiver(Intent intent, final ResolveInfo receiver, String resolvedType, long packageFlags, int userId, int callingUid, int callingPid) {
        Resolution<ComponentName> resolution = resolveComponentAlias(new ComponentAliasResolver$$ExternalSyntheticLambda2(receiver));
        ComponentName target = resolution.getTarget();
        if (target == null) goto L5;
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        Intent i = new Intent(intent);
        i.setPackage(null);
        i.setComponent(resolution.getTarget());
        List<ResolveInfo> resolved = pmi.queryIntentReceivers(i, resolvedType, packageFlags, callingUid, callingPid, userId, true);
        if (resolved != null) goto L9;
    L13:
        Slog.w(TAG, "Alias target " + target.flattenToShortString() + " not found");
        return null;
    L9:
        if (resolved.size() == 0) goto L13;
        return new Resolution(receiver, resolved.get(0));
    L5:
        return new Resolution(receiver, null);
    }

    private static /* synthetic */ ComponentName lambda$resolveReceiver$2(ResolveInfo receiver) {
        return receiver.activityInfo.getComponentName();
    }
}
