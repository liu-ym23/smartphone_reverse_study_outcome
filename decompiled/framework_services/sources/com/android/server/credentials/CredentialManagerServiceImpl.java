package com.android.server.credentials;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.credentials.CredentialProviderInfo;
import android.service.credentials.CredentialProviderInfoFactory;
import android.util.Slog;
import com.android.server.infra.AbstractPerUserSystemService;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class CredentialManagerServiceImpl extends AbstractPerUserSystemService<CredentialManagerServiceImpl, CredentialManagerService> {
    private static final String TAG = "CredentialManager";
    private CredentialProviderInfo mInfo;

    CredentialManagerServiceImpl(CredentialManagerService master, Object lock, int userId, String serviceName) throws PackageManager.NameNotFoundException {
        super(master, lock, userId);
        Slog.i(TAG, "CredentialManagerServiceImpl constructed for: " + serviceName);
        Object r0 = this.mLock;
        monitor-enter(r0);
        newServiceInfoLocked(ComponentName.unflattenFromString(serviceName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    public ComponentName getServiceComponentName() {
        return getComponentName();
    }

    public ComponentName getComponentName() {
        return this.mInfo.getServiceInfo().getComponentName();
    }

    CredentialManagerServiceImpl(CredentialManagerService master, Object lock, int userId, CredentialProviderInfo providerInfo) {
        super(master, lock, userId);
        Slog.i(TAG, "CredentialManagerServiceImpl constructed for: " + providerInfo.getServiceInfo().getComponentName().flattenToString());
        this.mInfo = providerInfo;
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException, SecurityException, NullPointerException {
        boolean isSystemProvider = false;
        if (this.mInfo == null) goto L5;
        Slog.i(TAG, "newServiceInfoLocked, mInfo not null : " + this.mInfo.getServiceInfo().getComponentName().flattenToString() + " , " + serviceComponent.flattenToString());
        isSystemProvider = this.mInfo.isSystemProvider();
    L6:
        Set<ComponentName> primaryProviders = CredentialManagerService.getPrimaryProvidersForUserId(((CredentialManagerService) this.mMaster).getContext(), this.mUserId);
        this.mInfo = CredentialProviderInfoFactory.create(getContext(), serviceComponent, this.mUserId, isSystemProvider, primaryProviders.contains(serviceComponent));
        return this.mInfo.getServiceInfo();
    L5:
        Slog.i(TAG, "newServiceInfoLocked, mInfo null, " + serviceComponent.flattenToString());
        goto L6
    }

    public ProviderSession initiateProviderSessionForRequestLocked(RequestSession requestSession, List<String> requestOptions) {
        if (requestOptions.isEmpty() == true) goto L11;
        if (isServiceCapableLocked(requestOptions) == true) goto L11;
        if (this.mInfo == null) goto L9;
        Slog.i(TAG, "Service does not have the required capabilities: " + this.mInfo.getComponentName());
    L9:
        return null;
    L11:
        if (this.mInfo != null) goto L14;
        Slog.w(TAG, "Initiating provider session for request but mInfo is null. This shouldn't happen");
        return null;
    L14:
        RemoteCredentialService remoteService = new RemoteCredentialService(getContext(), this.mInfo.getServiceInfo().getComponentName(), this.mUserId);
        return requestSession.initiateProviderSession(this.mInfo, remoteService);
    }

    boolean isServiceCapableLocked(List<String> requestedOptions) {
        if (this.mInfo != null) goto L5;
        return false;
    L5:
        Iterator<String> r0 = requestedOptions.iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        String capability = r0.next();
        if (this.mInfo.hasCapability(capability) == false) goto L7;
        return true;
    L13:
        return false;
    }

    public CredentialProviderInfo getCredentialProviderInfo() {
        return this.mInfo;
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected void handlePackageUpdateLocked(String packageName) {
        if (this.mInfo != null) goto L5;
        return;
    L5:
        if (this.mInfo.getServiceInfo() != null) goto L7;
        return;
    L7:
        if (this.mInfo.getServiceInfo().getComponentName().getPackageName().equals(packageName) == false) goto L16;
        updateCredentialProviderInfo(this.mInfo.getServiceInfo().getComponentName(), this.mInfo.isSystemProvider());     // Catch: Throwable -> L10
        return;
    L10:
        e = move-exception;
        Slog.w(TAG, "Unable to update provider, must be removed: " + e.getMessage());
        ((CredentialManagerService) this.mMaster).handleServiceRemovedMultiModeLocked(this.mInfo.getComponentName(), this.mUserId);
        return;
    }

    private void updateCredentialProviderInfo(ComponentName componentName, boolean isSystemProvider) throws SecurityException, PackageManager.NameNotFoundException {
        Slog.d(TAG, "Updating credential provider: " + componentName.flattenToString());
        if (isValidCredentialProviderInfo(componentName, this.mUserId, isSystemProvider) == false) goto L7;
        newServiceInfoLocked(componentName);
        return;
    L7:
        throw new SecurityException("Service has not been set up correctly");
    }

    private boolean isValidCredentialProviderInfo(ComponentName componentName, int userId, boolean isSystemProvider) {
        Context context = getContext();
        if (context != null) goto L5;
        return false;
    L5:
        String serviceInterface = "android.service.credentials.CredentialProviderService";
        if (isSystemProvider == false) goto L8;
        serviceInterface = "android.service.credentials.system.CredentialProviderService";
    L8:
        List<ResolveInfo> resolveInfos = context.getPackageManager().queryIntentServicesAsUser(new Intent(serviceInterface), PackageManager.ResolveInfoFlags.of(128), userId);
        Iterator<ResolveInfo> r4 = resolveInfos.iterator();
    L10:
        if (r4.hasNext() == false) goto L16;
        ResolveInfo resolveInfo = r4.next();
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (serviceInfo.getComponentName().equals(componentName) == false) goto L10;
        return true;
    L16:
        return false;
    }
}
