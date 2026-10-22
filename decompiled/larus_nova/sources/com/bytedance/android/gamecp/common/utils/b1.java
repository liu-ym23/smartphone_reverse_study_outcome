package com.bytedance.android.gamecp.common.utils;

import android.util.Log;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_core.Store;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57209a = 0;

    static {
    }

    public static com.bytedance.ies.sve_core.e a(PureWidget r100, com.bytedance.ies.sve_core.f r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "name");
        return b(r100.Eq(), r101);
    }

    public static com.bytedance.ies.sve_core.e b(Store r100, com.bytedance.ies.sve_core.f r101) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "name");
        return Store.useConstant$default(r100, r101, null, 2, null);
    L5:
        e = move-exception;
        yr.c.b("SVEUtils-obtainConstant", Log.getStackTraceString(e));
        return null;
    }
}
