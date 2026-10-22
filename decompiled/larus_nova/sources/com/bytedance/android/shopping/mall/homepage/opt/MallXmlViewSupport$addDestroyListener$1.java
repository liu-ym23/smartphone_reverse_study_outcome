package com.bytedance.android.shopping.mall.homepage.opt;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0004"}, d2 = {"com/bytedance/android/shopping/mall/homepage/opt/MallXmlViewSupport$addDestroyListener$1", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallXmlViewSupport$addDestroyListener$1 implements LifecycleObserver {
    public MallXmlViewSupport$addDestroyListener$1() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Map<Integer, List<View>> r100 = i.f178253a;
        Object r101 = i.f178254b;
        monitor-enter(r101);
        ((LinkedHashMap) i.f178253a).clear();     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
