package com.android.server.os;

import android.content.Context;
import com.android.server.LocalServices;
import com.android.server.SystemService;

/* JADX INFO: loaded from: classes2.dex */
public class NativeTombstoneManagerService extends SystemService {
    private static final String TAG = "NativeTombstoneManagerService";
    private NativeTombstoneManager mManager;

    public NativeTombstoneManagerService(Context context) {
        super(context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mManager = new NativeTombstoneManager(getContext());
        LocalServices.addService(NativeTombstoneManager.class, this.mManager);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 550) goto L6;
        this.mManager.onSystemReady();
        return;
    }
}
