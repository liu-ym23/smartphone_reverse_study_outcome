package com.bytedance.android.livesdkapi.lifecycle;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.lifecycle.LifeCycleService")
public interface ILiveLifecycle extends IService, ILiveLifecycleForSaas {
    void addObserver(ILiveLifecycleObserver r100);

    void removeObserver(ILiveLifecycleObserver r100);
}
