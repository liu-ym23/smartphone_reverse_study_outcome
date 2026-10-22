package com.bytedance.android.shopping.anchorv4.experiment;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.model.ECCacheMonitorStruct;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECCacheMonitorStruct f166754a = null;

    static {
        f166754a = ECSettingKeys.w();
    }

    public static boolean a(Boolean r100) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L6;
        return false;
    L6:
        return f166754a.getOptimizeOn();
    }
}
