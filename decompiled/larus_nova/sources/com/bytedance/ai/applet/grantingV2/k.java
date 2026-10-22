package com.bytedance.ai.applet.grantingV2;

import com.baidu.platform.comapi.map.MapController;
import com.google.gson.JsonSyntaxException;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class k implements h {

    public static final class a {
    }

    static {
    }

    public k() {
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final boolean a(u2.f r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if (Intrinsics.areEqual(r100.b(), "login") == false) goto L13;
        String r101 = r100.e();
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (StringsKt.contains$default(r101, "bizLoginDescription", false, 2, null) != true) goto L9;
        r102 = true;
        goto L10
    L13:
        return false;
    }

    @Override // com.bytedance.ai.applet.grantingV2.h
    public final i b(u2.f r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        String r100 = r110.e();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L45;
    L39:
        u2.j r102 = null;
    L40:
        if (r102 != null) goto L44;
        com.bytedance.ai.utils.g.f37637a.e("LoginStrategyProviderV2", "provideStrategy: parse relatedData failed");
        return null;
    L44:
        return new LoginStrategy(r110, r102, r111);
    L45:
        Lazy r103 = com.bytedance.ai.applet.base.gson.e.f34515a;     // Catch: Exception -> L35 JsonSyntaxException -> L37
        u2.j r104 = (u2.j) com.bytedance.ai.applet.base.gson.e.a(r100, u2.j.class);     // Catch: Exception -> L35 JsonSyntaxException -> L37
        String r105 = r104.e();     // Catch: Exception -> L35 JsonSyntaxException -> L37
        if (r105 != null) goto L16;
        String r106 = "";
    L17:
        String r107 = r104.f();     // Catch: Exception -> L35 JsonSyntaxException -> L37
        if (r107 != null) goto L20;
        String r108 = "";
    L21:
        String r109 = r104.d();     // Catch: Exception -> L35 JsonSyntaxException -> L37
        if (r109 != null) goto L24;
        String r112 = "";
    L25:
        String r113 = r104.c();     // Catch: Exception -> L35 JsonSyntaxException -> L37
        if (r113 != null) goto L28;
        String r114 = "";
    L29:
        String r115 = r104.b();     // Catch: Exception -> L35 JsonSyntaxException -> L37
        if (r115 != null) goto L32;
        String r116 = "";
    L33:
        r102 = u2.j.a(r104, r106, r108, r112, r114, r116, 96);     // Catch: Exception -> L35 JsonSyntaxException -> L37
    L32:
        r116 = r115;
        goto L33
    L28:
        r114 = r113;
        goto L29
    L24:
        r112 = r109;
        goto L25
    L20:
        r108 = r107;
        goto L21
    L16:
        r106 = r105;
    L37:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("LoginStrategyProviderV2", "parseData JsonSyntaxException: " + e.getMessage());
    L35:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("LoginStrategyProviderV2", "parseData Exception: " + e.getMessage());
        goto L39
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L10
    }
}
