package com.bytedance.ai.applet.grantingV2;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {
    public static final boolean c(String r100) {
        if (Intrinsics.areEqual(r100, AiBotPollingAuthResult.STATUS_PENDING) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "revoked") == true) goto L8;
        return false;
    }

    public static final b a(String r100, String r101) {
        if (c(r100) == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r101, AiBotPollingAuthResult.STATUS_EXPIRED) == true) goto L8;
        return null;
    L8:
        String r102 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_dyAuth_Card_desc_expired_cn");
        if (r102 != null) goto L12;
        r102 = "已过期，暂无法操作";
    L12:
        return new b(r102, false);
    }

    public static final boolean b(u2.f r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if (c(r100.c()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r101, AiBotPollingAuthResult.STATUS_EXPIRED) == false) goto L7;
        return true;
    }
}
