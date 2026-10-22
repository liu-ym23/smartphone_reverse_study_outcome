package com.bytedance.server.virt;

import android.content.Context;
import android.util.Log;
import com.android.server.SystemService;

/* JADX INFO: loaded from: classes3.dex */
public class VirtService extends SystemService {
    private static final String TAG = "VirtService";
    private final VirtServiceProxy proxy;

    public VirtService(Context context) {
        super(context);
        this.proxy = VirtServiceProxy.getInstance(context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        if (this.proxy != null) goto L5;
        Log.e(TAG, "VirtService onStart failed.");
        return;
    L5:
        this.proxy.onStart();
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (this.proxy != null) goto L5;
        Log.e(TAG, "VirtService onBootPhase failed.");
        return;
    L5:
        this.proxy.onBootPhase(phase);
    }
}
