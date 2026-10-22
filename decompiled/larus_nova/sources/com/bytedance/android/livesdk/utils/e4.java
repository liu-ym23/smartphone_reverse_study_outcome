package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdk.config.im0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f158939a = null;

    static {
        f158939a = im0.f120465a.getValue();
    }

    public static String a() {
        String r100 = f158939a;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        return r100;
    L11:
        return com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_recharge_desc_default);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
