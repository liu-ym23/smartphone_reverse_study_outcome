package com.stepos.pps.data.deviceid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.stepos.openidsdk.OpenIdHelper;
import com.stepos.pps.data.deviceid.IDeviceIdService;

/* loaded from: classes.dex */
public class DeviceIdService extends Service {
    private static final String TAG = "DeviceIdService";
    private final IDeviceIdService.Stub mBinder = new IDeviceIdService.Stub() { // from class: com.stepos.pps.data.deviceid.DeviceIdService.1
        @Override // com.stepos.pps.data.deviceid.IDeviceIdService
        public String getOaid() {
            try {
                String encryptedOaid = SafeCertClient.getEncryptedOaid(DeviceIdService.this.getApplicationContext());
                if (encryptedOaid != null) {
                    return encryptedOaid;
                }
                Log.d(DeviceIdService.TAG, "getOaid: SafeCertService returned null");
                return null;
            } catch (Throwable th) {
                Log.w(DeviceIdService.TAG, "getOaid failed: " + th);
                return null;
            }
        }

        @Override // com.stepos.pps.data.deviceid.IDeviceIdService
        public String getDsid() {
            try {
                if (!OpenIdHelper.isSupported()) {
                    Log.d(DeviceIdService.TAG, "getDsid: openid not supported");
                    return null;
                }
                return OpenIdHelper.getDeviceDsid(DeviceIdService.this.getApplicationContext());
            } catch (Throwable th) {
                Log.w(DeviceIdService.TAG, "getDsid failed: " + th);
                return null;
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
