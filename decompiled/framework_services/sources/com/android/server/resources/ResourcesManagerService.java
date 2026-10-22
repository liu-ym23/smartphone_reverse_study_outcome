package com.android.server.resources;

import android.content.Context;
import android.content.res.ResourceTimer;
import android.os.IBinder;
import android.pico.utils.ExtImplFactory;
import com.android.server.SystemService;
import com.android.server.am.ActivityManagerService;

/* JADX INFO: loaded from: classes3.dex */
public class ResourcesManagerService extends SystemService {
    private ActivityManagerService mActivityManagerService;
    private IExtResourcesManagerService mExt;
    private final IBinder mService;

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManagerService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m7972$$Nest$fgetmActivityManagerService(ResourcesManagerService r0) {
        return r0.mActivityManagerService;
    }

    public ResourcesManagerService(Context context) {
        super(context);
        this.mService = new AnonymousClass1(this);
        this.mExt = (IExtResourcesManagerService) ExtImplFactory.getImpl(IExtResourcesManagerService.class, new Object[]{this});
        publishBinderService("resources", this.mService);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        ResourceTimer.start();
    }

    public void setActivityManagerService(ActivityManagerService activityManagerService) {
        this.mActivityManagerService = activityManagerService;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        getExt().onBootPhase(phase);
    }

    public IExtResourcesManagerService getExt() {
        return this.mExt;
    }
}
