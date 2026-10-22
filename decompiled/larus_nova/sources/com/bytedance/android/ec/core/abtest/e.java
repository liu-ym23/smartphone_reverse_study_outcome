package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43640a = 0;

    static {
    }

    public static Object a(Object r100, Object r101) {
        Lazy r102 = ECAppInfoService.f48110a;
        if (ECAppInfoService.h() == false) goto L6;
        return r100;
    L6:
        return r101;
    }
}
