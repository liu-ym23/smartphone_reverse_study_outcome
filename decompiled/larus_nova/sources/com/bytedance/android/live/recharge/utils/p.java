package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.revlink.api.ILinkService;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90494a = 0;

    public static boolean a() {
        p11.h r100 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getPkService();
        if (r100.d() == RevPkState.PK) goto L5;
    L7:
        return false;
    L5:
        if (r100.isInBreakThrough() == true) goto L7;
        return true;
    }

    static {
    }
}
