package com.android.server.security.authenticationpolicy;

import android.content.Context;
import android.security.authenticationpolicy.DisableSecureLockDeviceParams;
import android.security.authenticationpolicy.EnableSecureLockDeviceParams;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.SystemService;

/* JADX INFO: loaded from: classes3.dex */
public class SecureLockDeviceService extends SecureLockDeviceServiceInternal {
    private static final String TAG = "SecureLockDeviceService";
    private final Context mContext;

    public static final class Lifecycle extends SystemService {
        private final SecureLockDeviceService mService;

        public Lifecycle(Context context) {
            super(context);
            this.mService = new SecureLockDeviceService(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            Slog.i(SecureLockDeviceService.TAG, "Starting SecureLockDeviceService");
            SecureLockDeviceService.m8044$$Nest$mstart(this.mService);
            Slog.i(SecureLockDeviceService.TAG, "Started SecureLockDeviceService");
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mstart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8044$$Nest$mstart(SecureLockDeviceService r0) {
        r0.start();
    }

    public SecureLockDeviceService(Context context) {
        this.mContext = context;
    }

    private void start() {
        LocalServices.addService(SecureLockDeviceServiceInternal.class, this);
    }

    @Override // com.android.server.security.authenticationpolicy.SecureLockDeviceServiceInternal
    public int enableSecureLockDevice(EnableSecureLockDeviceParams params) {
        return 2;
    }

    @Override // com.android.server.security.authenticationpolicy.SecureLockDeviceServiceInternal
    public int disableSecureLockDevice(DisableSecureLockDeviceParams params) {
        return 2;
    }
}
