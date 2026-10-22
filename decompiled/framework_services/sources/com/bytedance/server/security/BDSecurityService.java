package com.bytedance.server.security;

import android.content.Context;
import android.util.Log;
import com.android.server.SystemService;

/* JADX INFO: loaded from: classes3.dex */
public class BDSecurityService extends SystemService {
    private static final String TAG = "BDSecurityService";
    private final BDSecurityServiceProxy proxy;

    public BDSecurityService(Context context) {
        super(context);
        this.proxy = BDSecurityServiceProxy.getInstance(context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        if (this.proxy != null) goto L5;
        Log.e(TAG, "BDSecurityService onStart failed.");
        return;
    L5:
        this.proxy.onStart();
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (this.proxy != null) goto L5;
        Log.e(TAG, "BDSecurityService onBootPhase failed.");
        return;
    L5:
        this.proxy.onBootPhase(phase);
    }
}
