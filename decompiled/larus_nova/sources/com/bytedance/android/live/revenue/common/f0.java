package com.bytedance.android.live.revenue.common;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: classes47.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90831a = 0;

    static {
    }

    public static String a(IBaseUser r100, boolean r101) {
        if (r100 != null) goto L4;
        String r102 = null;
    L11:
        if (r102 != null) goto L14;
        return "";
    L14:
        return r102;
    L4:
        if (((com.bytedance.android.livesdk.revenue.service.interact.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class)).isAudienceLinkEngineOn() == false) goto L9;
        r102 = r100.getSafeNicName();
        if (TextUtils.isEmpty(r102) == false) goto L11;
        r102 = r100.getProperNickName(r101);
        goto L11
    L9:
        r102 = r100.getProperNickName(r101);
        goto L11
    }
}
