package com.bytedance.android.shopping.anchorv4.experiment;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes12.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f166756a = false;

    static {
        Lazy r100 = ECAppInfoService.f48110a;
        if (ECAppInfoService.h() == false) goto L5;
        boolean r101 = com.bytedance.android.ec.core.opt.ab.c.p();
    L6:
        f166756a = r101;
        return;
    L5:
        r101 = com.bytedance.android.ec.core.abtest.d.z();
        goto L6
    }
}
