package com.bytedance.ai.applet.grantingV2;

import com.baidu.platform.comapi.map.MapController;
import com.google.gson.JsonSyntaxException;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class z implements h {

    public static final class a {
    }

    static {
    }

    public z() {
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final boolean a(u2.f r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100.b(), "privacy");
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final i b(u2.f r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        String r100 = r110.e();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L37;
    L31:
        u2.j r102 = null;
    L32:
        if (r102 != null) goto L36;
        com.bytedance.ai.utils.g.f37637a.e("PrivacyStrategyProviderV2", "provideStrategy: parse relatedData failed");
        return null;
    L36:
        return new PrivacyStrategy(r110, r102, r111);
    L37:
        Lazy r103 = com.bytedance.ai.applet.base.gson.e.f34515a;     // Catch: Exception -> L27 JsonSyntaxException -> L29
        u2.j r104 = (u2.j) com.bytedance.ai.applet.base.gson.e.a(r100, u2.j.class);     // Catch: Exception -> L27 JsonSyntaxException -> L29
        String r105 = r104.e();     // Catch: Exception -> L27 JsonSyntaxException -> L29
        if (r105 != null) goto L16;
        String r106 = "";
    L17:
        String r107 = r104.f();     // Catch: Exception -> L27 JsonSyntaxException -> L29
        if (r107 != null) goto L20;
        String r108 = "";
    L21:
        String r109 = r104.d();     // Catch: Exception -> L27 JsonSyntaxException -> L29
        if (r109 != null) goto L24;
        String r112 = "";
    L25:
        r102 = u2.j.a(r104, r106, r108, r112, null, null, 120);     // Catch: Exception -> L27 JsonSyntaxException -> L29
    L24:
        r112 = r109;
        goto L25
    L20:
        r108 = r107;
        goto L21
    L16:
        r106 = r105;
    L29:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("PrivacyStrategyProviderV2", "parseData JsonSyntaxException: " + e.getMessage());
    L27:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("PrivacyStrategyProviderV2", "parseData Exception: " + e.getMessage());
        goto L31
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L10
    }
}
