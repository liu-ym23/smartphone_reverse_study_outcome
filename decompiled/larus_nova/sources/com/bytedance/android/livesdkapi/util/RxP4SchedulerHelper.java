package com.bytedance.android.livesdkapi.util;

import com.bytedance.android.live.core.utils.rxutils.CommonTransformer;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.i;
import k60.b;

/* JADX INFO: loaded from: classes12.dex */
public class RxP4SchedulerHelper {
    public RxP4SchedulerHelper() {
    }

    public static <T> CommonTransformer<T> rxP4SchedulerHelper() {
        if (b.d() == false) goto L7;
        return new i();
    L7:
        return RxUtil.rxSchedulerHelper();
    }
}
