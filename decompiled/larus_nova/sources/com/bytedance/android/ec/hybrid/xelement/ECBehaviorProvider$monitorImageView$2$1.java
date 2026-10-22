package com.bytedance.android.ec.hybrid.xelement;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.imagex.l0;
import com.bytedance.android.ec.core.imagex.m0;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.optimize.statistics.FrescoMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0004"}, d2 = {"com/bytedance/android/ec/hybrid/xelement/ECBehaviorProvider$monitorImageView$2$1", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "ec-xelement_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECBehaviorProvider$monitorImageView$2$1 implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        int r100 = l0.f44688a;
        Intrinsics.checkNotNullParameter(null, "monitorHook");
        m0.c("ImageMonitorHook.unregisterMonitorHook");
        if (m0.a() == false) goto L7;
        FrescoMonitor.removeMonitorHookV2(null);
        throw null;
    L7:
        throw null;
    }
}
