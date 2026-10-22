package com.bytedance.android.livesdk.interactivity.api.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o0;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static final boolean a(IBaseUser r100) {
        o0.a r101 = o0.f58946a;
        if (r100 == null) goto L5;
        String r102 = r100.getIdString();
    L6:
        r101.getClass();
        return o0.a.b(r102);
    L5:
        r102 = null;
        goto L6
    }
}
