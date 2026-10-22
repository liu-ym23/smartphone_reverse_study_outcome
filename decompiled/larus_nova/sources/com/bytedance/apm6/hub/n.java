package com.bytedance.apm6.hub;

import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IActivityLifeManager;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements f37.a<IActivityLifeManager> {
    public n() {
    }

    @Override // f37.a
    public final IActivityLifeManager create() {
        return ActivityLifeObserver.getInstance();
    }
}
