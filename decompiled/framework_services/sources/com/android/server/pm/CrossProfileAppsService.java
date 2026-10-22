package com.android.server.pm;

import android.content.Context;
import android.content.pm.CrossProfileAppsInternal;
import com.android.server.SystemService;

/* JADX INFO: loaded from: classes2.dex */
public class CrossProfileAppsService extends SystemService {
    private final CrossProfileAppsServiceImpl mServiceImpl;

    public CrossProfileAppsService(Context context) {
        super(context);
        this.mServiceImpl = new CrossProfileAppsServiceImpl(context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("crossprofileapps", this.mServiceImpl);
        publishLocalService(CrossProfileAppsInternal.class, this.mServiceImpl.getLocalService());
    }
}
