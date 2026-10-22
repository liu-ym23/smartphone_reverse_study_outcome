package com.bytedance.android.live.core.utils;

import com.bytedance.android.live.core.utils.rxutils.CommonTransformer;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.config.fe;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f66123a = 0;

    static {
    }

    public static CommonTransformer a(boolean r100) {
        if (r100 == false) goto L9;
        Integer r101 = fe.f120195a.getValue();
        if (r101 == null) goto L9;
        if (r101.intValue() != 2) goto L9;
        return new com.bytedance.android.live.core.utils.rxutils.h();
    L9:
        if (r100 == false) goto L17;
        Integer r102 = fe.f120195a.getValue();
        if (r102 == null) goto L17;
        if (r102.intValue() != 3) goto L17;
        return new com.bytedance.android.live.core.utils.rxutils.i();
    L17:
        return RxUtil.rxSchedulerHelper();
    }
}
