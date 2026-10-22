package com.bytedance.android.shopping.abscontainer.common_biz.helper;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class RefreshHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f164294a = 0;

    static {
    }

    public static void a(j33.b r100, v43.a r101) {
        Intrinsics.checkNotNullParameter(r100, "fetcher");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        r101.D(r101.h() + 1);
        final int r102 = r101.h();
        r100.a(r101, new RefreshHelper$refresh$1(r102), RefreshHelper$refresh$2.INSTANCE);
    }
}
