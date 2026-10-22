package com.android.server.security;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.RemoteException;
import android.os.ServiceSpecificException;
import android.os.UserHandle;
import android.security.keystore.IKeyAttestationApplicationIdProvider;
import android.security.keystore.KeyAttestationApplicationId;
import android.security.keystore.KeyAttestationPackageInfo;
import android.security.keystore.Signature;

/* JADX INFO: loaded from: classes3.dex */
public class KeyAttestationApplicationIdProviderService extends IKeyAttestationApplicationIdProvider.Stub {
    private PackageManager mPackageManager;

    public KeyAttestationApplicationIdProviderService(Context context) {
        this.mPackageManager = context.getPackageManager();
    }

    @Override // android.security.keystore.IKeyAttestationApplicationIdProvider
    public KeyAttestationApplicationId getKeyAttestationApplicationId(int uid) throws RemoteException {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 1017) goto L5;
    L9:
        long token = Binder.clearCallingIdentity();
        String[] packageNames = this.mPackageManager.getPackagesForUid(uid);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        if (packageNames == null) goto L28;
        int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        KeyAttestationPackageInfo[] keyAttestationPackageInfos = new KeyAttestationPackageInfo[packageNames.length];     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        int i = 0;
    L14:
        if (i >= packageNames.length) goto L25;
        PackageInfo packageInfo = this.mPackageManager.getPackageInfoAsUser(packageNames[i], 64, userId);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        KeyAttestationPackageInfo pInfo = new KeyAttestationPackageInfo();     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        pInfo.packageName = new String(packageNames[i]);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        pInfo.versionCode = packageInfo.getLongVersionCode();     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        pInfo.signatures = new Signature[packageInfo.signatures.length];     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        int index = 0;
    L17:
        if (index >= packageInfo.signatures.length) goto L23;
        Signature sign = new Signature();     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        sign.data = packageInfo.signatures[index].toByteArray();     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        pInfo.signatures[index] = sign;     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        index = index + 1;     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        goto L17
    L23:
        keyAttestationPackageInfos[i] = pInfo;     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        i = i + 1;
        goto L14
    L25:
        Binder.restoreCallingIdentity(token);
        KeyAttestationApplicationId attestAppId = new KeyAttestationApplicationId();
        attestAppId.packageInfos = keyAttestationPackageInfos;
        return attestAppId;
    L28:
        throw new ServiceSpecificException(1, "No package for uid: " + uid);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
    L21:
        nnfe = move-exception;
        throw new RemoteException(nnfe.getMessage());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L5:
        if (callingUid == 1076) goto L9;
        throw new SecurityException("This service can only be used by Keystore or Credstore");
    }
}
