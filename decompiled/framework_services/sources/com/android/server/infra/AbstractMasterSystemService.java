package com.android.server.infra;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.UserInfo;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.android.internal.content.PackageMonitor;
import com.android.internal.os.BackgroundThread;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.pm.UserManagerInternal;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractMasterSystemService<M extends AbstractMasterSystemService<M, S>, S extends AbstractPerUserSystemService<S, M>> extends SystemService {
    public static final int PACKAGE_RESTART_POLICY_NO_REFRESH = 16;
    public static final int PACKAGE_RESTART_POLICY_REFRESH_EAGER = 64;
    public static final int PACKAGE_RESTART_POLICY_REFRESH_LAZY = 32;
    public static final int PACKAGE_UPDATE_POLICY_NO_REFRESH = 1;
    public static final int PACKAGE_UPDATE_POLICY_REFRESH_EAGER = 4;
    public static final int PACKAGE_UPDATE_POLICY_REFRESH_LAZY = 2;
    public boolean debug;
    protected boolean mAllowInstantService;
    private final SparseBooleanArray mDisabledByUserRestriction;
    protected final Object mLock;
    private final AbstractMasterSystemService<M, S>.MyPackageMonitor mPackageMonitor;
    protected final ServiceNameResolver mServiceNameResolver;
    private final int mServicePackagePolicyFlags;
    private final SparseArray<List<S>> mServicesCacheList;
    protected final String mTag;
    private UserManagerInternal mUm;
    private SparseArray<String> mUpdatingPackageNames;
    public boolean verbose;

    private class MyPackageMonitor extends PackageMonitor {
        final /* synthetic */ AbstractMasterSystemService this$0;

        public static /* synthetic */ void $r8$lambda$WJOav7o2UH2fVtcWZYNxlSqiN4Y(String r0, AbstractPerUserSystemService r1) {
            lambda$handlePackageUpdateLocked$0(r0, r1);
        }

        MyPackageMonitor(AbstractMasterSystemService r1, boolean supportsPackageRestartQuery) {
            this.this$0 = r1;
            super(supportsPackageRestartQuery);
        }

        public void onPackageUpdateStarted(String packageName, int uid) {
            if (this.this$0.verbose == false) goto L5;
            Slog.v(this.this$0.mTag, "onPackageUpdateStarted(): " + packageName);
        L5:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            String activePackageName = getActiveServicePackageNameLocked();     // Catch: Throwable -> L11
            if (packageName.equals(activePackageName) == true) goto L13;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            int userId = getChangingUserId();     // Catch: Throwable -> L11
            if (AbstractMasterSystemService.m4460$$Nest$fgetmUpdatingPackageNames(this.this$0) != null) goto L16;
            AbstractMasterSystemService.m4461$$Nest$fputmUpdatingPackageNames(this.this$0, new SparseArray(AbstractMasterSystemService.m4459$$Nest$fgetmServicesCacheList(this.this$0).size()));     // Catch: Throwable -> L11
        L16:
            AbstractMasterSystemService.m4460$$Nest$fgetmUpdatingPackageNames(this.this$0).put(userId, packageName);     // Catch: Throwable -> L11
            this.this$0.onServicePackageUpdatingLocked(userId);     // Catch: Throwable -> L11
            if ((AbstractMasterSystemService.m4458$$Nest$fgetmServicePackagePolicyFlags(this.this$0) & 1) == 0) goto L22;
            if (this.this$0.debug == false) goto L30;
            Slog.d(this.this$0.mTag, "Holding service for user " + userId + " while package " + activePackageName + " is being updated");     // Catch: Throwable -> L11
        L30:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L22:
            if (this.this$0.debug == false) goto L24;
            Slog.d(this.this$0.mTag, "Removing service for user " + userId + " because package " + activePackageName + " is being updated");     // Catch: Throwable -> L11
        L24:
            this.this$0.removeCachedServiceListLocked(userId);     // Catch: Throwable -> L11
            if ((AbstractMasterSystemService.m4458$$Nest$fgetmServicePackagePolicyFlags(this.this$0) & 4) == 0) goto L30;
            if (this.this$0.debug == false) goto L29;
            Slog.d(this.this$0.mTag, "Eagerly recreating service for user " + userId);     // Catch: Throwable -> L11
        L29:
            this.this$0.getServiceForUserLocked(userId);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        public void onPackageUpdateFinished(String packageName, int uid) {
            if (this.this$0.verbose == false) goto L5;
            Slog.v(this.this$0.mTag, "onPackageUpdateFinished(): " + packageName);
        L5:
            int userId = getChangingUserId();
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
        L18:
            th = move-exception;
            throw th;
        L8:
            if (AbstractMasterSystemService.m4460$$Nest$fgetmUpdatingPackageNames(this.this$0) != null) goto L10;
            String activePackageName = null;
        L12:
            if (packageName.equals(activePackageName) == true) goto L14;
            handlePackageUpdateLocked(packageName);     // Catch: Throwable -> L18
        L22:
            monitor-exit(r1);     // Catch: Throwable -> L18
            return;
        L14:
            if (AbstractMasterSystemService.m4460$$Nest$fgetmUpdatingPackageNames(this.this$0) == null) goto L20;
            AbstractMasterSystemService.m4460$$Nest$fgetmUpdatingPackageNames(this.this$0).remove(userId);     // Catch: Throwable -> L18
            if (AbstractMasterSystemService.m4460$$Nest$fgetmUpdatingPackageNames(this.this$0).size() != 0) goto L20;
            AbstractMasterSystemService.m4461$$Nest$fputmUpdatingPackageNames(this.this$0, null);     // Catch: Throwable -> L18
        L20:
            this.this$0.onServicePackageUpdatedLocked(userId);     // Catch: Throwable -> L18
            goto L22
        L10:
            activePackageName = (String) AbstractMasterSystemService.m4460$$Nest$fgetmUpdatingPackageNames(this.this$0).get(userId);     // Catch: Throwable -> L18
            goto L12
        }

        public void onPackageRemoved(String packageName, int uid) {
            if (this.this$0.mServiceNameResolver != null) goto L5;
        L14:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int userId = getChangingUserId();     // Catch: Throwable -> L23
            AbstractPerUserSystemService r2 = this.this$0.peekServiceForUserLocked(userId);     // Catch: Throwable -> L23
            if (r2 == null) goto L25;
            ComponentName componentName = r2.getServiceComponentName();     // Catch: Throwable -> L23
            if (componentName == null) goto L25;
            if (packageName.equals(componentName.getPackageName()) == false) goto L25;
            handleActiveServiceRemoved(userId);     // Catch: Throwable -> L23
        L25:
            monitor-exit(r0);     // Catch: Throwable -> L23
            return;
        L23:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mServiceNameResolver.isConfiguredInMultipleMode() == false) goto L14;
            int userId2 = getChangingUserId();
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            this.this$0.handlePackageRemovedMultiModeLocked(packageName, userId2);     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean onHandleForceStop(Intent intent, String[] packages, int uid, boolean doit) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            String activePackageName = getActiveServicePackageNameLocked();     // Catch: Throwable -> L13
            int r2 = packages.length;     // Catch: Throwable -> L13
            int r4 = 0;
        L6:
            if (r4 >= r2) goto L22;
            String pkg = packages[r4];     // Catch: Throwable -> L13
            if (pkg.equals(activePackageName) == false) goto L20;
            if (doit == false) goto L10;
            String action = intent.getAction();     // Catch: Throwable -> L13
            int userId = getChangingUserId();     // Catch: Throwable -> L13
            if ("android.intent.action.PACKAGE_RESTARTED".equals(action) == false) goto L18;
            handleActiveServiceRestartedLocked(activePackageName, userId);     // Catch: Throwable -> L13
        L21:
            r4 = r4 + 1;     // Catch: Throwable -> L13
            goto L6
        L18:
            this.this$0.removeCachedServiceListLocked(userId);     // Catch: Throwable -> L13
            goto L21
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return true;
        L20:
            handlePackageUpdateLocked(pkg);     // Catch: Throwable -> L13
            goto L21
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return false;
        L13:
            th = move-exception;
            throw th;
        }

        public void onPackageDataCleared(String packageName, int uid) {
            if (this.this$0.verbose == false) goto L5;
            Slog.v(this.this$0.mTag, "onPackageDataCleared(): " + packageName);
        L5:
            int userId = getChangingUserId();
            if (this.this$0.mServiceNameResolver != null) goto L8;
        L17:
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            AbstractPerUserSystemService r2 = this.this$0.peekServiceForUserLocked(userId);     // Catch: Throwable -> L26
            if (r2 == null) goto L28;
            ComponentName componentName = r2.getServiceComponentName();     // Catch: Throwable -> L26
            if (componentName == null) goto L28;
            if (packageName.equals(componentName.getPackageName()) == false) goto L28;
            this.this$0.onServicePackageDataClearedLocked(userId);     // Catch: Throwable -> L26
        L28:
            monitor-exit(r1);     // Catch: Throwable -> L26
            return;
        L26:
            th = move-exception;
            throw th;
        L8:
            if (this.this$0.mServiceNameResolver.isConfiguredInMultipleMode() == false) goto L17;
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
            this.this$0.onServicePackageDataClearedMultiModeLocked(packageName, userId);     // Catch: Throwable -> L14
            monitor-exit(r3);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        private void handleActiveServiceRemoved(int userId) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.removeCachedServiceListLocked(userId);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            String serviceSettingsProperty = this.this$0.getServiceSettingsProperty();
            if (serviceSettingsProperty == null) goto L15;
            Settings.Secure.putStringForUser(this.this$0.getContext().getContentResolver(), serviceSettingsProperty, null, userId);
            return;
        L15:
            return;
        L10:
            th = move-exception;
            throw th;
        }

        private void handleActiveServiceRestartedLocked(String activePackageName, int userId) {
            if ((AbstractMasterSystemService.m4458$$Nest$fgetmServicePackagePolicyFlags(this.this$0) & 16) == 0) goto L8;
            if (this.this$0.debug == false) goto L16;
            Slog.d(this.this$0.mTag, "Holding service for user " + userId + " while package " + activePackageName + " is being restarted");
        L16:
            this.this$0.onServicePackageRestartedLocked(userId);
            return;
        L8:
            if (this.this$0.debug == false) goto L10;
            Slog.d(this.this$0.mTag, "Removing service for user " + userId + " because package " + activePackageName + " is being restarted");
        L10:
            this.this$0.removeCachedServiceListLocked(userId);
            if ((AbstractMasterSystemService.m4458$$Nest$fgetmServicePackagePolicyFlags(this.this$0) & 64) == 0) goto L16;
            if (this.this$0.debug == false) goto L15;
            Slog.d(this.this$0.mTag, "Eagerly recreating service for user " + userId);
        L15:
            this.this$0.updateCachedServiceLocked(userId);
            goto L16
        }

        public void onPackageModified(String packageName) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.verbose == false) goto L10;
            Slog.v(this.this$0.mTag, "onPackageModified(): " + packageName);     // Catch: Throwable -> L7
        L10:
            if (this.this$0.mServiceNameResolver != null) goto L13;
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L13:
            int userId = getChangingUserId();     // Catch: Throwable -> L7
            String[] serviceNames = this.this$0.mServiceNameResolver.getDefaultServiceNameList(userId);     // Catch: Throwable -> L7
            if (serviceNames != null) goto L16;
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L16:
            if (this.this$0.mServiceNameResolver.isConfiguredInMultipleMode() == false) goto L18;
            AbstractMasterSystemService.m4462$$Nest$mremoveInvalidCachedServicesLocked(this.this$0, serviceNames, packageName, userId);     // Catch: Throwable -> L7
        L18:
            int i = 0;
        L20:
            if (i >= serviceNames.length) goto L22;
            peekAndUpdateCachedServiceLocked(packageName, userId, serviceNames[i]);     // Catch: Throwable -> L7
            i = i + 1;     // Catch: Throwable -> L7
            goto L20
        }

        private void peekAndUpdateCachedServiceLocked(String packageName, int userId, String serviceName) {
            if (serviceName != null) goto L4;
            return;
        L4:
            ComponentName serviceComponentName = ComponentName.unflattenFromString(serviceName);
            if (serviceComponentName != null) goto L7;
            return;
        L7:
            if (serviceComponentName.getPackageName().equals(packageName) == false) goto L21;
            AbstractPerUserSystemService r1 = this.this$0.peekServiceForUserLocked(userId);
            if (r1 == null) goto L19;
            ComponentName componentName = r1.getServiceComponentName();
            if (componentName == null) goto L14;
            return;
        L14:
            if (this.this$0.verbose == false) goto L16;
            Slog.v(this.this$0.mTag, "update cached");
        L16:
            this.this$0.updateCachedServiceLocked(userId);
            return;
        L19:
            return;
        }

        private String getActiveServicePackageNameLocked() {
            int userId = getChangingUserId();
            AbstractPerUserSystemService r1 = this.this$0.peekServiceForUserLocked(userId);
            if (r1 != null) goto L5;
            return null;
        L5:
            ComponentName serviceComponent = r1.getServiceComponentName();
            if (serviceComponent != null) goto L9;
            return null;
        L9:
            return serviceComponent.getPackageName();
        }

        private void handlePackageUpdateLocked(final String packageName) {
            this.this$0.visitServicesLocked(new AbstractMasterSystemService$MyPackageMonitor$$ExternalSyntheticLambda0(packageName));
        }

        private static /* synthetic */ void lambda$handlePackageUpdateLocked$0(String packageName, AbstractPerUserSystemService s) {
            s.handlePackageUpdateLocked(packageName);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ServicePackagePolicyFlags {
    }

    private final class SettingsObserver extends ContentObserver {
        final /* synthetic */ AbstractMasterSystemService this$0;

        SettingsObserver(AbstractMasterSystemService r6, Handler handler) {
            this.this$0 = r6;
            super(handler);
            ContentResolver resolver = r6.getContext().getContentResolver();
            String serviceProperty = r6.getServiceSettingsProperty();
            if (serviceProperty == null) goto L5;
            resolver.registerContentObserver(Settings.Secure.getUriFor(serviceProperty), false, this, -1);
        L5:
            resolver.registerContentObserver(Settings.Secure.getUriFor("user_setup_complete"), false, this, -1);
            r6.registerForExtraSettingsChanges(resolver, this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            if (this.this$0.verbose == false) goto L5;
            Slog.v(this.this$0.mTag, "onChange(): uri=" + uri + ", userId=" + userId);
        L5:
            String property = uri.getLastPathSegment();
            if (property != null) goto L9;
            return;
        L9:
            if (property.equals(this.this$0.getServiceSettingsProperty()) == false) goto L11;
        L14:
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            this.this$0.updateCachedServiceLocked(userId);     // Catch: Throwable -> L19
            monitor-exit(r1);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        L11:
            if (property.equals("user_setup_complete") == true) goto L14;
            this.this$0.onSettingsChanged(userId, property);
        }
    }

    public interface Visitor<S> {
        void visit(S r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$RA3RLycuq2feiRoZAhxs-zRKZAc, reason: not valid java name */
    public static /* synthetic */ void m4456$r8$lambda$RA3RLycuq2feiRoZAhxszRKZAc(AbstractMasterSystemService r0, int r1, String r2, String[] r3, AbstractPerUserSystemService r4) {
        r0.lambda$removeInvalidCachedServicesLocked$1(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$yQXMQpvyX7O-8cCohpM5rzwYjzM, reason: not valid java name */
    public static /* synthetic */ void m4457$r8$lambda$yQXMQpvyX7O8cCohpM5rzwYjzM(AbstractMasterSystemService r0, String r1, int r2, Bundle r3, Bundle r4) {
        r0.lambda$new$0(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServicePackagePolicyFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4458$$Nest$fgetmServicePackagePolicyFlags(AbstractMasterSystemService r0) {
        return r0.mServicePackagePolicyFlags;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServicesCacheList, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4459$$Nest$fgetmServicesCacheList(AbstractMasterSystemService r0) {
        return r0.mServicesCacheList;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUpdatingPackageNames, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4460$$Nest$fgetmUpdatingPackageNames(AbstractMasterSystemService r0) {
        return r0.mUpdatingPackageNames;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUpdatingPackageNames, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4461$$Nest$fputmUpdatingPackageNames(AbstractMasterSystemService r0, SparseArray r1) {
        r0.mUpdatingPackageNames = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveInvalidCachedServicesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4462$$Nest$mremoveInvalidCachedServicesLocked(AbstractMasterSystemService r0, String[] r1, String r2, int r3) {
        r0.removeInvalidCachedServicesLocked(r1, r2, r3);
    }

    protected abstract S newServiceLocked(int r1, boolean r2);

    protected AbstractMasterSystemService(Context context, ServiceNameResolver serviceNameResolver, String disallowProperty) {
        this(context, serviceNameResolver, disallowProperty, 34);
    }

    protected AbstractMasterSystemService(Context context, ServiceNameResolver serviceNameResolver, final String disallowProperty, int servicePackagePolicyFlags) {
        super(context);
        this.mTag = getClass().getSimpleName();
        this.mLock = new Object();
        this.verbose = false;
        this.debug = false;
        this.mServicesCacheList = new SparseArray();
        if ((servicePackagePolicyFlags & 7) != 0) goto L6;
        servicePackagePolicyFlags = servicePackagePolicyFlags | 2;
    L6:
        if ((servicePackagePolicyFlags & 112) != 0) goto L8;
        servicePackagePolicyFlags = servicePackagePolicyFlags | 32;
    L8:
        this.mServicePackagePolicyFlags = servicePackagePolicyFlags;
        this.mServiceNameResolver = serviceNameResolver;
        if (this.mServiceNameResolver == null) goto L11;
        this.mServiceNameResolver.setOnTemporaryServiceNameChangedCallback(new AbstractMasterSystemService$$ExternalSyntheticLambda0(this));
    L11:
        if (disallowProperty != null) goto L13;
        this.mDisabledByUserRestriction = null;
    L21:
        this.mPackageMonitor = new MyPackageMonitor(this, true);
        startTrackingPackageChanges();
        return;
    L13:
        this.mDisabledByUserRestriction = new SparseBooleanArray();
        UserManagerInternal umi = getUserManagerInternal();
        List<UserInfo> users = getSupportedUsers();
        int i = 0;
    L15:
        if (i >= users.size()) goto L20;
        int userId = users.get(i).id;
        boolean disabled = umi.getUserRestriction(userId, disallowProperty);
        if (disabled == false) goto L19;
        Slog.i(this.mTag, "Disabling by restrictions user " + userId);
        this.mDisabledByUserRestriction.put(userId, disabled);
    L19:
        i = i + 1;
        goto L15
    L20:
        umi.addUserRestrictionsListener(new AbstractMasterSystemService$$ExternalSyntheticLambda1(this, disallowProperty));
        goto L21
    }

    private /* synthetic */ void lambda$new$0(String disallowProperty, int userId, Bundle newRestrictions, Bundle prevRestrictions) {
        boolean disabledNow = newRestrictions.getBoolean(disallowProperty, false);
        Object r1 = this.mLock;
        monitor-enter(r1);
        boolean disabledBefore = this.mDisabledByUserRestriction.get(userId);     // Catch: Throwable -> L11
        if (disabledBefore == disabledNow) goto L7;
    L13:
        Slog.i(this.mTag, "Updating for user " + userId + ": disabled=" + disabledNow);     // Catch: Throwable -> L11
        this.mDisabledByUserRestriction.put(userId, disabledNow);     // Catch: Throwable -> L11
        updateCachedServiceLocked(userId, disabledNow);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.debug == false) goto L13;
        Slog.d(this.mTag, "Restriction did not change for user " + userId);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 600) goto L6;
        new SettingsObserver(this, BackgroundThread.getHandler());
        return;
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocking(SystemService.TargetUser user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        updateCachedServiceLocked(user.getUserIdentifier());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserStopped(SystemService.TargetUser user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeCachedServiceListLocked(user.getUserIdentifier());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean getAllowInstantService() {
        enforceCallingPermissionForManagement();
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mAllowInstantService;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean isBindInstantServiceAllowed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mAllowInstantService;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final void setAllowInstantService(boolean mode) {
        Slog.i(this.mTag, "setAllowInstantService(): " + mode);
        enforceCallingPermissionForManagement();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAllowInstantService = mode;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void setTemporaryService(int userId, String componentName, int durationMs) {
        Slog.i(this.mTag, "setTemporaryService(" + userId + ") to " + componentName + " for " + durationMs + "ms");
        if (this.mServiceNameResolver != null) goto L5;
        return;
    L5:
        enforceCallingPermissionForManagement();
        componentName.getClass();
        int maxDurationMs = getMaximumTemporaryServiceDurationMs();
        if (durationMs > maxDurationMs) goto L20;
        Object r1 = this.mLock;
        monitor-enter(r1);
        AbstractPerUserSystemService r2 = peekServiceForUserLocked(userId);     // Catch: Throwable -> L12
        if (r2 == null) goto L14;
        r2.removeSelfFromCache();     // Catch: Throwable -> L12
    L14:
        this.mServiceNameResolver.setTemporaryService(userId, componentName, durationMs);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L20:
        throw new IllegalArgumentException("Max duration is " + maxDurationMs + " (called with " + durationMs + ")");
    }

    public final void setTemporaryServices(int userId, String[] componentNames, int durationMs) {
        Slog.i(this.mTag, "setTemporaryService(" + userId + ") to " + Arrays.toString(componentNames) + " for " + durationMs + "ms");
        if (this.mServiceNameResolver != null) goto L5;
        return;
    L5:
        enforceCallingPermissionForManagement();
        componentNames.getClass();
        int maxDurationMs = getMaximumTemporaryServiceDurationMs();
        if (durationMs > maxDurationMs) goto L20;
        Object r1 = this.mLock;
        monitor-enter(r1);
        AbstractPerUserSystemService r2 = peekServiceForUserLocked(userId);     // Catch: Throwable -> L12
        if (r2 == null) goto L14;
        r2.removeSelfFromCache();     // Catch: Throwable -> L12
    L14:
        this.mServiceNameResolver.setTemporaryServices(userId, componentNames, durationMs);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L20:
        throw new IllegalArgumentException("Max duration is " + maxDurationMs + " (called with " + durationMs + ")");
    }

    public final boolean setDefaultServiceEnabled(int userId, boolean enabled) {
        Slog.i(this.mTag, "setDefaultServiceEnabled() for userId " + userId + ": " + enabled);
        enforceCallingPermissionForManagement();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mServiceNameResolver != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        boolean changed = this.mServiceNameResolver.setDefaultServiceEnabled(userId, enabled);     // Catch: Throwable -> L8
        if (changed == false) goto L13;
        AbstractPerUserSystemService r2 = peekServiceForUserLocked(userId);     // Catch: Throwable -> L8
        if (r2 == null) goto L20;
        r2.removeSelfFromCache();     // Catch: Throwable -> L8
    L20:
        updateCachedServiceLocked(userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L13:
        if (this.verbose == false) goto L15;
        Slog.v(this.mTag, "setDefaultServiceEnabled(" + userId + "): already " + enabled);     // Catch: Throwable -> L8
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    }

    public final boolean isDefaultServiceEnabled(int userId) {
        enforceCallingPermissionForManagement();
        if (this.mServiceNameResolver != null) goto L6;
        return false;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mServiceNameResolver.isDefaultServiceEnabled(userId);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    protected int getMaximumTemporaryServiceDurationMs() {
        throw new UnsupportedOperationException("Not implemented by " + getClass());
    }

    public final void resetTemporaryService(int userId) {
        Slog.i(this.mTag, "resetTemporaryService(): " + userId);
        enforceCallingPermissionForManagement();
        Object r0 = this.mLock;
        monitor-enter(r0);
        AbstractPerUserSystemService r1 = getServiceForUserLocked(userId);     // Catch: Throwable -> L7
        if (r1 == null) goto L9;
        r1.resetTemporaryServiceLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected void enforceCallingPermissionForManagement() {
        throw new UnsupportedOperationException("Not implemented by " + getClass());
    }

    protected List<S> newServiceListLocked(int resolvedUserId, boolean disabled, String[] serviceNames) {
        throw new UnsupportedOperationException("newServiceListLocked not implemented. ");
    }

    protected void registerForExtraSettingsChanges(ContentResolver resolver, ContentObserver observer) {
    }

    protected void onSettingsChanged(int userId, String property) {
    }

    protected S getServiceForUserLocked(int userId) {
        List<S> services = getServiceListForUserLocked(userId);
        if (services != null) goto L5;
    L8:
        return null;
    L5:
        if (services.size() == 0) goto L8;
        return services.get(0);
    }

    protected List<S> getServiceListForUserLocked(int userId) {
        int resolvedUserId = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, false, null, null);
        List<S> services = this.mServicesCacheList.get(resolvedUserId);
        if (services != null) goto L5;
    L6:
        boolean disabled = isDisabledLocked(userId);
        if (this.mServiceNameResolver != null) goto L9;
    L11:
        ArrayList r3 = new ArrayList();
        r3.add(newServiceLocked(resolvedUserId, disabled));
        services = r3;
    L12:
        if (disabled == true) goto L17;
        int i = 0;
    L15:
        if (i >= services.size()) goto L17;
        onServiceEnabledLocked(services.get(i), resolvedUserId);
        i = i + 1;
    L17:
        this.mServicesCacheList.put(userId, services);
    L18:
        return services;
    L9:
        if (this.mServiceNameResolver.isConfiguredInMultipleMode() == false) goto L11;
        services = newServiceListLocked(resolvedUserId, disabled, this.mServiceNameResolver.getServiceNameList(userId));
        goto L12
    L5:
        if (services.size() != 0) goto L18;
        goto L6
    }

    protected S peekServiceForUserLocked(int userId) {
        List<S> serviceList = peekServiceListForUserLocked(userId);
        if (serviceList != null) goto L5;
    L8:
        return null;
    L5:
        if (serviceList.size() == 0) goto L8;
        return serviceList.get(0);
    }

    protected List<S> peekServiceListForUserLocked(int userId) {
        int resolvedUserId = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, false, null, null);
        return this.mServicesCacheList.get(resolvedUserId);
    }

    protected void updateCachedServiceLocked(int userId) {
        updateCachedServiceListLocked(userId, isDisabledLocked(userId));
    }

    protected boolean isDisabledLocked(int userId) {
        if (this.mDisabledByUserRestriction != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mDisabledByUserRestriction.get(userId) == false) goto L7;
        return true;
    }

    protected S updateCachedServiceLocked(int r2, boolean r3) {
        S r0 = (S) getServiceForUserLocked(r2);
        updateCachedServiceListLocked(r2, r3);
        return r0;
    }

    protected List<S> updateCachedServiceListLocked(int userId, boolean disabled) {
        if (this.mServiceNameResolver != null) goto L5;
    L8:
        List<S> services = getServiceListForUserLocked(userId);
        if (services != null) goto L12;
        return null;
    L12:
        int i = 0;
    L14:
        if (i >= services.size()) goto L31;
        S service = services.get(i);
        if (service == null) goto L29;
        Object r3 = service.mLock;
        monitor-enter(r3);
        service.updateLocked(disabled);     // Catch: Throwable -> L22
        if (service.isEnabledLocked() == true) goto L24;
        removeCachedServiceListLocked(userId);     // Catch: Throwable -> L22
    L25:
        monitor-exit(r3);     // Catch: Throwable -> L22
        goto L29
    L24:
        onServiceEnabledLocked(services.get(i), userId);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L29:
        i = i + 1;
        goto L14
    L31:
        return services;
    L5:
        if (this.mServiceNameResolver.isConfiguredInMultipleMode() == false) goto L8;
        return updateCachedServiceListMultiModeLocked(userId, disabled);
    }

    private List<S> updateCachedServiceListMultiModeLocked(int userId, boolean disabled) {
        int resolvedUserId = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, false, null, null);
        new ArrayList();
        Object r3 = this.mLock;
        monitor-enter(r3);
        removeCachedServiceListLocked(resolvedUserId);     // Catch: Throwable -> L7
        List<S> services = getServiceListForUserLocked(userId);     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        return services;
    L7:
        th = move-exception;
        throw th;
    }

    protected String getServiceSettingsProperty() {
        return null;
    }

    protected void onServiceEnabledLocked(S service, int userId) {
    }

    protected final List<S> removeCachedServiceListLocked(int userId) {
        List<S> services = peekServiceListForUserLocked(userId);
        if (services == null) goto L8;
        this.mServicesCacheList.delete(userId);
        int i = 0;
    L6:
        if (i >= services.size()) goto L8;
        onServiceRemoved(services.get(i), userId);
        i = i + 1;
    L8:
        return services;
    }

    protected void onServicePackageUpdatingLocked(int userId) {
        if (this.verbose == false) goto L6;
        Slog.v(this.mTag, "onServicePackageUpdatingLocked(" + userId + ")");
        return;
    }

    protected void onServicePackageUpdatedLocked(int userId) {
        if (this.verbose == false) goto L6;
        Slog.v(this.mTag, "onServicePackageUpdated(" + userId + ")");
        return;
    }

    protected void onServicePackageDataClearedLocked(int userId) {
        if (this.verbose == false) goto L6;
        Slog.v(this.mTag, "onServicePackageDataCleared(" + userId + ")");
        return;
    }

    protected void onServicePackageRestartedLocked(int userId) {
        if (this.verbose == false) goto L6;
        Slog.v(this.mTag, "onServicePackageRestarted(" + userId + ")");
        return;
    }

    protected void onServiceRemoved(S service, int userId) {
    }

    protected void onServiceNameChanged(int userId, String serviceName, boolean isTemporary) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        updateCachedServiceListLocked(userId, isDisabledLocked(userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected void onServiceNameListChanged(int userId, String[] serviceNames, boolean isTemporary) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        updateCachedServiceListLocked(userId, isDisabledLocked(userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected void visitServicesLocked(Visitor<S> visitor) {
        int size = this.mServicesCacheList.size();
        int i = 0;
    L3:
        if (i >= size) goto L10;
        List<S> services = this.mServicesCacheList.valueAt(i);
        int j = 0;
    L6:
        if (j >= services.size()) goto L8;
        visitor.visit(services.get(j));
        j = j + 1;
        goto L6
    L8:
        i = i + 1;
        goto L3
    }

    protected void clearCacheLocked() {
        this.mServicesCacheList.clear();
    }

    protected UserManagerInternal getUserManagerInternal() {
        if (this.mUm != null) goto L9;
        if (this.verbose == false) goto L7;
        Slog.v(this.mTag, "lazy-loading UserManagerInternal");
    L7:
        this.mUm = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
    L9:
        return this.mUm;
    }

    protected List<UserInfo> getSupportedUsers() {
        UserInfo[] allUsers = getUserManagerInternal().getUserInfos();
        int size = allUsers.length;
        List<UserInfo> supportedUsers = new ArrayList(size);
        int i = 0;
    L3:
        if (i >= size) goto L9;
        UserInfo userInfo = allUsers[i];
        if (isUserSupported(new SystemService.TargetUser(userInfo)) == false) goto L7;
        supportedUsers.add(userInfo);
    L7:
        i = i + 1;
        goto L3
    L9:
        return supportedUsers;
    }

    protected void assertCalledByPackageOwner(String packageName) {
        packageName.getClass();
        int uid = Binder.getCallingUid();
        String[] packages = getContext().getPackageManager().getPackagesForUid(uid);
        if (packages == null) goto L12;
        int r2 = packages.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        String candidate = packages[r3];
        if (packageName.equals(candidate) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return;
    L12:
        throw new SecurityException("UID " + uid + " does not own " + packageName);
    }

    protected void dumpLocked(String prefix, PrintWriter pw) {
        boolean realDebug = this.debug;
        boolean realVerbose = this.verbose;
        this.verbose = true;     // Catch: Throwable -> L6
        this.debug = true;     // Catch: Throwable -> L6
        int size = this.mServicesCacheList.size();     // Catch: Throwable -> L6
        pw.print(prefix);     // Catch: Throwable -> L6
        pw.print("Debug: ");     // Catch: Throwable -> L6
        pw.print(realDebug);     // Catch: Throwable -> L6
        pw.print(" Verbose: ");     // Catch: Throwable -> L6
        pw.println(realVerbose);     // Catch: Throwable -> L6
        pw.print("Package policy flags: ");     // Catch: Throwable -> L6
        pw.println(this.mServicePackagePolicyFlags);     // Catch: Throwable -> L6
        if (this.mUpdatingPackageNames == null) goto L8;
        pw.print("Packages being updated: ");     // Catch: Throwable -> L6
        pw.println(this.mUpdatingPackageNames);     // Catch: Throwable -> L6
    L8:
        dumpSupportedUsers(pw, prefix);     // Catch: Throwable -> L6
        if (this.mServiceNameResolver == null) goto L14;
        pw.print(prefix);     // Catch: Throwable -> L6
        pw.print("Name resolver: ");     // Catch: Throwable -> L6
        this.mServiceNameResolver.dumpShort(pw);     // Catch: Throwable -> L6
        pw.println();     // Catch: Throwable -> L6
        List<UserInfo> users = getSupportedUsers();     // Catch: Throwable -> L6
        int i = 0;
    L12:
        if (i >= users.size()) goto L14;
        int userId = users.get(i).id;     // Catch: Throwable -> L6
        pw.print("    ");     // Catch: Throwable -> L6
        pw.print(userId);     // Catch: Throwable -> L6
        pw.print(": ");     // Catch: Throwable -> L6
        this.mServiceNameResolver.dumpShort(pw, userId);     // Catch: Throwable -> L6
        pw.println();     // Catch: Throwable -> L6
        i = i + 1;     // Catch: Throwable -> L6
    L14:
        pw.print(prefix);     // Catch: Throwable -> L6
        pw.print("Users disabled by restriction: ");     // Catch: Throwable -> L6
        pw.println(this.mDisabledByUserRestriction);     // Catch: Throwable -> L6
        pw.print(prefix);     // Catch: Throwable -> L6
        pw.print("Allow instant service: ");     // Catch: Throwable -> L6
        pw.println(this.mAllowInstantService);     // Catch: Throwable -> L6
        String settingsProperty = getServiceSettingsProperty();     // Catch: Throwable -> L6
        if (settingsProperty == null) goto L17;
        pw.print(prefix);     // Catch: Throwable -> L6
        pw.print("Settings property: ");     // Catch: Throwable -> L6
        pw.println(settingsProperty);     // Catch: Throwable -> L6
    L17:
        pw.print(prefix);     // Catch: Throwable -> L6
        pw.print("Cached services: ");     // Catch: Throwable -> L6
        if (size != 0) goto L20;
        pw.println("none");     // Catch: Throwable -> L6
    L35:
        this.debug = realDebug;
        this.verbose = realVerbose;
        return;
    L20:
        pw.println(size);     // Catch: Throwable -> L6
        int i2 = 0;
    L21:
        if (i2 >= size) goto L35;
        pw.print(prefix);     // Catch: Throwable -> L6
        pw.print("Service at ");     // Catch: Throwable -> L6
        pw.print(i2);     // Catch: Throwable -> L6
        pw.println(": ");     // Catch: Throwable -> L6
        List<S> services = this.mServicesCacheList.valueAt(i2);     // Catch: Throwable -> L6
        int j = 0;
    L24:
        if (j >= services.size()) goto L33;
        S service = services.get(j);     // Catch: Throwable -> L6
        Object r9 = service.mLock;     // Catch: Throwable -> L6
        monitor-enter(r9);     // Catch: Throwable -> L6
        service.dumpLocked("    ", pw);     // Catch: Throwable -> L30
        monitor-exit(r9);     // Catch: Throwable -> L30
        j = j + 1;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L6
    L33:
        pw.println();     // Catch: Throwable -> L6
        i2 = i2 + 1;
    L6:
        th = move-exception;
        this.debug = realDebug;
        this.verbose = realVerbose;
        throw th;
    }

    private void startTrackingPackageChanges() {
        this.mPackageMonitor.register(getContext(), null, UserHandle.ALL, true);
    }

    private void removeInvalidCachedServicesLocked(final String[] validServices, final String packageName, final int userId) {
        visitServicesLocked(new AbstractMasterSystemService$$ExternalSyntheticLambda2(this, userId, packageName, validServices));
    }

    private /* synthetic */ void lambda$removeInvalidCachedServicesLocked$1(int userId, String packageName, String[] validServices, AbstractPerUserSystemService s) {
        ComponentName serviceComponentName = s.getServiceComponentName();
        int serviceUserId = s.getUserId();
        if (serviceComponentName == null) goto L11;
        if (serviceUserId == userId) goto L6;
        return;
    L6:
        if (serviceComponentName.getPackageName().equals(packageName) == true) goto L8;
        return;
    L8:
        if (serviceInValidServiceList(serviceComponentName, validServices) == true) goto L14;
        handleServiceRemovedMultiModeLocked(serviceComponentName, userId);
        return;
    L14:
        return;
    }

    private boolean serviceInValidServiceList(ComponentName serviceComponentName, String[] serviceNames) {
        int r0 = serviceNames.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        String service = serviceNames[r2];
        ComponentName componentName = ComponentName.unflattenFromString(service);
        if (componentName == null) goto L10;
        if (componentName.equals(serviceComponentName) == false) goto L10;
        return true;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return false;
    }

    protected void onServicePackageDataClearedMultiModeLocked(String packageName, int userId) {
        if (this.verbose == false) goto L6;
        Slog.v(this.mTag, "onServicePackageDataClearedMultiModeLocked(" + userId + ")");
        return;
    }

    protected void handlePackageRemovedMultiModeLocked(String packageName, int userId) {
        if (this.verbose == false) goto L6;
        Slog.v(this.mTag, "handlePackageRemovedMultiModeLocked(" + userId + ")");
        return;
    }

    protected void handleServiceRemovedMultiModeLocked(ComponentName serviceComponentName, int userId) {
        if (this.verbose == false) goto L6;
        Slog.v(this.mTag, "handleServiceRemovedMultiModeLocked(" + userId + ")");
        return;
    }

    protected void removeServiceFromCache(S service, int userId) {
        if (this.mServicesCacheList.get(userId) == null) goto L6;
        this.mServicesCacheList.get(userId).remove(service);
        return;
    }

    protected void removeServiceFromMultiModeSettings(String serviceComponentName, int userId) {
        String serviceSettingsProperty = getServiceSettingsProperty();
        if (serviceSettingsProperty == null) goto L18;
        if (this.mServiceNameResolver == null) goto L18;
        if (this.mServiceNameResolver.isConfiguredInMultipleMode() == false) goto L18;
        String[] settingComponentNames = this.mServiceNameResolver.getServiceNameList(userId);
        List<String> remainingServices = new ArrayList();
        int r3 = settingComponentNames.length;
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L15;
        String settingComponentName = settingComponentNames[r4];
        if (settingComponentName.equals(serviceComponentName) == true) goto L14;
        remainingServices.add(settingComponentName);
    L14:
        r4 = r4 + 1;
        goto L10
    L15:
        this.mServiceNameResolver.setServiceNameList(remainingServices, userId);
        return;
    L18:
        if (this.verbose == false) goto L24;
        Slog.v(this.mTag, "removeServiceFromSettings not implemented  for single backend implementation");
        return;
    }
}
