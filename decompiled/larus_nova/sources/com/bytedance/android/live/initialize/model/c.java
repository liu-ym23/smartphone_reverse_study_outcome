package com.bytedance.android.live.initialize.model;

import com.bytedance.android.live.initialize.IWTOSingleTask;
import com.bytedance.android.live.initialize.IWTOTask;
import com.bytedance.android.live.initialize.WTOSingleTaskCollection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {
    public static final WTOTaskProxy a(IWTOTask r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$proxy");
        if ((r100 instanceof IWTOSingleTask) == false) goto L9;
        WTOSingleTaskCollection r101 = WTOSingleTaskCollection.INSTANCE;
        WTOTaskProxy r102 = r101.getSingleTask2Proxy$live_initialize_scheduler_saasRelease().get(r100);
        if (r102 != null) goto L10;
        WTOTaskProxy r103 = new WTOTaskProxy(r100);
        r101.getSingleTask2Proxy$live_initialize_scheduler_saasRelease().put(r100, r103);
        return r103;
    L10:
        return r102;
    L9:
        return new WTOTaskProxy(r100);
    }
}
