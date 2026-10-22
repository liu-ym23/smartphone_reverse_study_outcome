package com.bytedance.android.live.user.api;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f102505a = 0;

    static {
    }

    @JvmStatic
    public static final a a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        IUserServiceV2 r101 = (IUserServiceV2) k.f(IUserServiceV2.class);
        if (r101 == null) goto L5;
        a r102 = r101.getUserContext(r100);
    L6:
        StringBuilder r103 = new StringBuilder("get IUserContext, dataCenter, isNull = ");
        if (r102 != null) goto L9;
        boolean r104 = true;
    L10:
        r103.append(r104);
        ALogger.i("UserCtx", r103.toString());
        return r102;
    L9:
        r104 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
