package com.bytedance.android.gamecp.business.download.ai;

import com.bytedance.android.gamecp.business.GamePromoteTrack;
import com.bytedance.android.gamecp.common.model.GameStageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class z {
    public static final com.bytedance.android.gamecp.host_api.model.j a(com.bytedance.android.gamecp.business.download.p r100) {
        Intrinsics.checkNotNullParameter(r100, "downloadInfo");
        com.bytedance.android.gamecp.host_api.model.j r101 = new com.bytedance.android.gamecp.host_api.model.j();
        Intrinsics.checkNotNullParameter("local", "<set-?>");
        r101.f57396a = "local";
        int r102 = GamePromoteTrack.f51759a;
        String r103 = GamePromoteTrack.g(r100.f52880w0);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f57397b = r103;
        r101.gameId = r100.f52855k;
        r101.c(r100.f52836a0);
        r101.androidPackageSize = String.valueOf(r100.f52854j0);
        r101.tags = r100.f52857l;
        String r104 = r100.f52860m0;
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r101.androidPackageName = r104;
        r101.d(GameStageType.DOWNLOAD.getType());
        r101.gameUnionType = GameUnionType.UNION_GAME.getType();
        r101.gameCategoryId = 0;
        r101.gameTagId = 0;
        return r101;
    }

    public static final com.bytedance.android.gamecp.host_api.model.j b(com.bytedance.android.gamecp.host_api.model.toolbar.a r100) {
        Intrinsics.checkNotNullParameter(com.alipay.sdk.m.k.b.f25406k, "from");
        String r101 = "";
        Intrinsics.checkNotNullParameter("", "downloadStatus");
        Intrinsics.checkNotNullParameter(r100, "info");
        com.bytedance.android.gamecp.host_api.model.j r102 = new com.bytedance.android.gamecp.host_api.model.j();
        Intrinsics.checkNotNullParameter(com.alipay.sdk.m.k.b.f25406k, "<set-?>");
        r102.f57396a = com.alipay.sdk.m.k.b.f25406k;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r102.f57397b = "";
        String r103 = r100.gameId;
        if (r103 == null) goto L6;
        r101 = r103;
    L6:
        r102.gameId = r101;
        r102.c(r100.gameName);
        r102.androidPackageSize = r100.androidPackageSize;
        r102.tags = r100.tags;
        r102.androidPackageName = r100.androidPackageName;
        r102.d(r100.stage);
        r102.gameUnionType = r100.gameUnionType;
        r102.gameCategoryId = r100.gameCategoryId;
        r102.gameTagId = r100.gameTagId;
        return r102;
    }
}
