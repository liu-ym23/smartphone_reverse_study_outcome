package com.android.server.integrity;

import android.content.Context;
import com.android.server.SystemService;

/* JADX INFO: loaded from: classes2.dex */
public class AppIntegrityManagerService extends SystemService {
    private Context mContext;
    private AppIntegrityManagerServiceImpl mService;

    public AppIntegrityManagerService(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mService = AppIntegrityManagerServiceImpl.create(this.mContext);
        publishBinderService("app_integrity", this.mService);
    }
}
