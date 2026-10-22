package com.bytedance.ai.applet.grantingV2;

import com.baidu.platform.comapi.map.MapController;
import com.google.gson.JsonSyntaxException;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements h {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final boolean a(u2.f r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100.b(), "aweme_login");
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final i b(u2.f r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        String r100 = r110.e();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L36;
    L30:
        u2.d r102 = null;
    L31:
        if (r102 != null) goto L35;
        com.bytedance.ai.utils.g.f37637a.e("FirstPartyLoginStrategyProviderV2", "provideStrategy: parse relatedData failed");
        return null;
    L35:
        return new FirstPartyLoginStrategy(r110, r102, r111);
    L36:
        Lazy r103 = com.bytedance.ai.applet.base.gson.e.f34515a;     // Catch: Exception -> L26 JsonSyntaxException -> L28
        u2.d r104 = (u2.d) com.bytedance.ai.applet.base.gson.e.a(r100, u2.d.class);     // Catch: Exception -> L26 JsonSyntaxException -> L28
        String r105 = r104.b();     // Catch: Exception -> L26 JsonSyntaxException -> L28
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        String r106 = r105;
        String r107 = r104.e();     // Catch: Exception -> L26 JsonSyntaxException -> L28
        if (r107 != null) goto L18;
        r107 = "抖音账号授权登录";
    L18:
        String r108 = r107;
        String r109 = r104.d();     // Catch: Exception -> L26 JsonSyntaxException -> L28
        if (r109 != null) goto L21;
        r109 = "登录后继续使用";
    L21:
        String r112 = r109;
        String r113 = r104.c();     // Catch: Exception -> L26 JsonSyntaxException -> L28
        if (r113 != null) goto L24;
        r113 = "已拒绝登录";
    L24:
        r102 = u2.d.a(r104, r106, r108, r112, r113, 48);     // Catch: Exception -> L26 JsonSyntaxException -> L28
    L28:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("FirstPartyLoginStrategyProviderV2", "parseData JsonSyntaxException: " + e.getMessage());
    L26:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("FirstPartyLoginStrategyProviderV2", "parseData Exception: " + e.getMessage());
        goto L30
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L10
    }
}
