package com.android.server.infra;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Slog;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractPerUserSystemService<S extends AbstractPerUserSystemService<S, M>, M extends AbstractMasterSystemService<M, S>> {
    private boolean mDisabled;
    public final Object mLock;
    protected final M mMaster;
    private ServiceInfo mServiceInfo;
    private boolean mSetupComplete;
    protected final String mTag;
    protected final int mUserId;

    protected AbstractPerUserSystemService(M master, Object lock, int userId) {
        this.mTag = getClass().getSimpleName();
        this.mMaster = master;
        this.mLock = lock;
        this.mUserId = userId;
        updateIsSetupComplete(userId);
    }

    private void updateIsSetupComplete(int userId) {
        String setupComplete = Settings.Secure.getStringForUser(getContext().getContentResolver(), "user_setup_complete", userId);
        this.mSetupComplete = "1".equals(setupComplete);
    }

    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        throw new UnsupportedOperationException("not overridden");
    }

    protected void handlePackageUpdateLocked(String packageName) {
    }

    protected boolean isEnabledLocked() {
        if (this.mSetupComplete == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mServiceInfo == null) goto L9;
        if (this.mDisabled == true) goto L9;
        return true;
    }

    protected final boolean isDisabledByUserRestrictionsLocked() {
        return this.mDisabled;
    }

    protected boolean updateLocked(boolean disabled) {
        boolean wasEnabled = isEnabledLocked();
        if (this.mMaster.verbose == false) goto L5;
        Slog.v(this.mTag, "updateLocked(u=" + this.mUserId + "): wasEnabled=" + wasEnabled + ", mSetupComplete=" + this.mSetupComplete + ", disabled=" + disabled + ", mDisabled=" + this.mDisabled);
    L5:
        updateIsSetupComplete(this.mUserId);
        this.mDisabled = disabled;
        if (this.mMaster.mServiceNameResolver != null) goto L8;
    L12:
        updateServiceInfoLocked();
    L14:
        if (wasEnabled == isEnabledLocked()) goto L16;
        return true;
    L16:
        return false;
    L8:
        if (this.mMaster.mServiceNameResolver.isConfiguredInMultipleMode() == false) goto L12;
        if (this.mMaster.debug == false) goto L14;
        Slog.d(this.mTag, "Should not end up in updateLocked when isConfiguredInMultipleMode is true");
        goto L14
    }

    protected final ComponentName updateServiceInfoLocked() {
        ComponentName[] componentNames = updateServiceInfoListLocked();
        if (componentNames != null) goto L5;
    L8:
        return null;
    L5:
        if (componentNames.length == 0) goto L8;
        return componentNames[0];
    }

    protected final ComponentName[] updateServiceInfoListLocked() {
        if (this.mMaster.mServiceNameResolver != null) goto L6;
        return null;
    L6:
        if (this.mMaster.mServiceNameResolver.isConfiguredInMultipleMode() == true) goto L9;
        String componentName = getComponentNameLocked();
        return new ComponentName[]{getServiceComponent(componentName)};
    L9:
        String[] componentNames = this.mMaster.mServiceNameResolver.getServiceNameList(this.mUserId);
        if (componentNames != null) goto L12;
        return null;
    L12:
        ComponentName[] serviceComponents = new ComponentName[componentNames.length];
        int i = 0;
    L14:
        if (i >= componentNames.length) goto L17;
        serviceComponents[i] = getServiceComponent(componentNames[i]);
        i = i + 1;
        goto L14
    L17:
        return serviceComponents;
    }

    private ComponentName getServiceComponent(String componentName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ServiceInfo serviceInfo = null;
        ComponentName serviceComponent = null;
    L11:
        th = move-exception;
        throw th;
    L6:
        if (TextUtils.isEmpty(componentName) == true) goto L39;
        serviceComponent = ComponentName.unflattenFromString(componentName);     // Catch: Throwable -> L11 Throwable -> L13
        serviceInfo = AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 0, this.mUserId);     // Catch: Throwable -> L11 Throwable -> L13
        if (serviceInfo != null) goto L39;
        Slog.e(this.mTag, "Bad service name: " + componentName);     // Catch: Throwable -> L11 Throwable -> L13
    L13:
        e = move-exception;
        Slog.e(this.mTag, "Error getting service info for '" + componentName + "': " + e);     // Catch: Throwable -> L11
        serviceInfo = null;
    L39:
        if (serviceInfo == null) goto L26;
        this.mServiceInfo = newServiceInfoLocked(serviceComponent);     // Catch: Throwable -> L11 Exception -> L24
        if (this.mMaster.debug == false) goto L38;
        Slog.d(this.mTag, "Set component for user " + this.mUserId + " as " + serviceComponent + " and info as " + this.mServiceInfo);     // Catch: Throwable -> L11 Exception -> L24
    L38:
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return serviceComponent;
    L26:
        this.mServiceInfo = null;     // Catch: Throwable -> L11 Exception -> L24
        if (this.mMaster.debug == false) goto L38;
        Slog.d(this.mTag, "Reset component for user " + this.mUserId + ":" + componentName);     // Catch: Throwable -> L11 Exception -> L24
    L24:
        e = move-exception;
        Slog.e(this.mTag, "Bad ServiceInfo for '" + componentName + "': " + e);     // Catch: Throwable -> L11
        this.mServiceInfo = null;     // Catch: Throwable -> L11
        goto L32
    }

    public final int getUserId() {
        return this.mUserId;
    }

    public final M getMaster() {
        return this.mMaster;
    }

    protected final int getServiceUidLocked() {
        if (this.mServiceInfo != null) goto L10;
        if (this.mMaster.verbose == false) goto L11;
        Slog.v(this.mTag, "getServiceUidLocked(): no mServiceInfo");
        return -1;
    L11:
        return -1;
    L10:
        return this.mServiceInfo.applicationInfo.uid;
    }

    protected final String getComponentNameLocked() {
        return this.mMaster.mServiceNameResolver.getServiceName(this.mUserId);
    }

    protected final String getComponentNameForMultipleLocked(String serviceName) {
        String[] services = this.mMaster.mServiceNameResolver.getServiceNameList(this.mUserId);
        int i = 0;
    L4:
        if (i >= services.length) goto L10;
        if (serviceName.equals(services[i]) == true) goto L8;
        i = i + 1;
        goto L4
    L8:
        return services[i];
    L10:
        return null;
    }

    public final boolean isTemporaryServiceSetLocked() {
        return this.mMaster.mServiceNameResolver.isTemporary(this.mUserId);
    }

    protected final void resetTemporaryServiceLocked() {
        this.mMaster.mServiceNameResolver.resetTemporaryService(this.mUserId);
    }

    public final ServiceInfo getServiceInfo() {
        return this.mServiceInfo;
    }

    public ComponentName getServiceComponentName() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mServiceInfo != null) goto L7;
        ComponentName r1 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = this.mServiceInfo.getComponentName();     // Catch: Throwable -> L10
        goto L8
    }

    public final String getServicePackageName() {
        ComponentName serviceComponent = getServiceComponentName();
        if (serviceComponent != null) goto L6;
        return null;
    L6:
        return serviceComponent.getPackageName();
    }

    public final CharSequence getServiceLabelLocked() {
        if (this.mServiceInfo != null) goto L6;
        return null;
    L6:
        return this.mServiceInfo.loadSafeLabel(getContext().getPackageManager(), 0.0f, 5);
    }

    public final Drawable getServiceIconLocked() {
        if (this.mServiceInfo != null) goto L6;
        return null;
    L6:
        return this.mServiceInfo.loadIcon(getContext().getPackageManager());
    }

    protected final void removeSelfFromCache() {
        Object r0 = this.mMaster.mLock;
        monitor-enter(r0);
        this.mMaster.removeCachedServiceListLocked(this.mUserId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean isDebug() {
        return this.mMaster.debug;
    }

    public final boolean isVerbose() {
        return this.mMaster.verbose;
    }

    public final int getTargedSdkLocked() {
        if (this.mServiceInfo != null) goto L6;
        return 0;
    L6:
        return this.mServiceInfo.applicationInfo.targetSdkVersion;
    }

    protected final boolean isSetupCompletedLocked() {
        return this.mSetupComplete;
    }

    protected final Context getContext() {
        return this.mMaster.getContext();
    }

    protected void dumpLocked(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("User: ");
        pw.println(this.mUserId);
        if (this.mServiceInfo == null) goto L6;
        pw.print(prefix);
        pw.print("Service Label: ");
        pw.println(getServiceLabelLocked());
        pw.print(prefix);
        pw.print("Target SDK: ");
        pw.println(getTargedSdkLocked());
    L6:
        if (this.mMaster.mServiceNameResolver == null) goto L8;
        pw.print(prefix);
        pw.print("Name resolver: ");
        this.mMaster.mServiceNameResolver.dumpShort(pw, this.mUserId);
        pw.println();
    L8:
        pw.print(prefix);
        pw.print("Disabled by UserManager: ");
        pw.println(this.mDisabled);
        pw.print(prefix);
        pw.print("Setup complete: ");
        pw.println(this.mSetupComplete);
        if (this.mServiceInfo == null) goto L11;
        pw.print(prefix);
        pw.print("Service UID: ");
        pw.println(this.mServiceInfo.applicationInfo.uid);
    L11:
        pw.println();
    }
}
