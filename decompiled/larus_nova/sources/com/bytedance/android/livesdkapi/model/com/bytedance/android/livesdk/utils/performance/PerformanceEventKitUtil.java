package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.performance;

import com.bytedance.android.livesdkapi.service.IPerformanceEventKitService;
import com.bytedance.common.wschannel.WsConstants;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/utils/performance/PerformanceEventKitUtil;", "", "()V", "trigger", "", "event", "", WsConstants.KEY_PAYLOAD, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PerformanceEventKitUtil {
    public static final PerformanceEventKitUtil INSTANCE = null;

    private PerformanceEventKitUtil() {
    }

    static {
        INSTANCE = new PerformanceEventKitUtil();
    }

    public final void trigger(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IPerformanceEventKitService r102 = (IPerformanceEventKitService) k.f(IPerformanceEventKitService.class);
        if (r102 == null) goto L6;
        r102.trigger(r100, r101);
        return;
    }

    public static /* synthetic */ void trigger$default(PerformanceEventKitUtil r100, String r101, Object r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.trigger(r101, r102);
    }
}
