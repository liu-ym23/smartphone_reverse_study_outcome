package com.android.server.os;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IDeviceIdentifiersPolicyService;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import com.android.internal.telephony.TelephonyPermissions;
import com.android.server.SystemService;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceIdentifiersPolicyService extends SystemService {

    private static final class DeviceIdentifiersPolicy extends IDeviceIdentifiersPolicyService.Stub {
        private final Context mContext;

        public DeviceIdentifiersPolicy(Context context) {
            this.mContext = context;
        }

        public String getSerial() throws RemoteException {
            if (TelephonyPermissions.checkCallingOrSelfReadDeviceIdentifiers(this.mContext, null, null, "getSerial") == true) goto L6;
            return "unknown";
        L6:
            return SystemProperties.get("ro.serialno", "unknown");
        }

        public String getSerialForPackage(String callingPackage, String callingFeatureId) throws RemoteException {
            if (checkPackageBelongsToCaller(callingPackage) == false) goto L10;
            if (TelephonyPermissions.checkCallingOrSelfReadDeviceIdentifiers(this.mContext, callingPackage, callingFeatureId, "getSerial") == true) goto L8;
            return "unknown";
        L8:
            return SystemProperties.get("ro.serialno", "unknown");
        L10:
            throw new IllegalArgumentException("Invalid callingPackage or callingPackage does not belong to caller's uid:" + Binder.getCallingUid());
        }

        private boolean checkPackageBelongsToCaller(String callingPackage) {
            int callingUid = Binder.getCallingUid();
            int callingUserId = UserHandle.getUserId(callingUid);
            int callingPackageUid = this.mContext.getPackageManager().getPackageUidAsUser(callingPackage, callingUserId);     // Catch: PackageManager.NameNotFoundException -> L7
            if (callingPackageUid != callingUid) goto L11;
            return true;
        L11:
            return false;
        L8:
            return false;
        }
    }

    public DeviceIdentifiersPolicyService(Context context) {
        super(context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("device_identifiers", new DeviceIdentifiersPolicy(getContext()));
    }
}
