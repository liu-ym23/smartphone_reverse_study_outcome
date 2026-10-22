package com.bytedance.android.livesdk.behavior;

import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveUserBehaviorComponent extends IHostAppMonitorListener.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f104273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f104274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f104275c;

    public LiveUserBehaviorComponent() {
        this.f104274b = LazyKt.lazy(LiveUserBehaviorComponent$mTouchTargetField$2.INSTANCE);
        this.f104275c = LazyKt.lazy(new LiveUserBehaviorComponent$mTouchViewField$2(this));
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
    public final void appEnterBackground(boolean r100, boolean r101) {
        super.appEnterBackground(r100, r101);
    }
}
