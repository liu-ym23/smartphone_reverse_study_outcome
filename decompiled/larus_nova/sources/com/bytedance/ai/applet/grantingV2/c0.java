package com.bytedance.ai.applet.grantingV2;

import com.baidu.platform.comapi.map.MapController;
import com.google.gson.JsonSyntaxException;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c0 implements h {

    public static final class a {
    }

    static {
    }

    public c0() {
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
        if (StringsKt.contains$default(r101, "authLink", false, 2, null) != true) goto L9;
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
        if (r101 == false) goto L42;
    L36:
        u2.l r102 = null;
    L37:
        if (r102 != null) goto L41;
        com.bytedance.ai.utils.g.f37637a.e("QSMusicLoginStrategyProviderV2", "provideStrategy: parse relatedData failed");
        return null;
    L41:
        return new QSMusicLoginStrategy(r110, r102, r111);
    L42:
        Lazy r103 = com.bytedance.ai.applet.base.gson.e.f34515a;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        u2.l r104 = (u2.l) com.bytedance.ai.applet.base.gson.e.a(r100, u2.l.class);     // Catch: Exception -> L32 JsonSyntaxException -> L34
        String r105 = r104.b();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        String r106 = r105;
        String r107 = r104.g();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r107 != null) goto L18;
        r107 = "在豆包内使用汽水音乐";
    L18:
        String r108 = r107;
        String r109 = r104.f();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r109 != null) goto L21;
        r109 = "登录后获取更优质的音乐体验";
    L21:
        String r112 = r109;
        String r113 = r104.e();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r113 != null) goto L24;
        r113 = "已拒绝登录汽水音乐";
    L24:
        String r114 = r113;
        String r115 = r104.c();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r115 != null) goto L27;
        r115 = "登录";
    L27:
        String r116 = r115;
        String r117 = r104.d();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r117 != null) goto L30;
        r117 = "不登录";
    L30:
        r102 = u2.l.a(r104, r106, r108, r112, r114, r116, r117, 192);     // Catch: Exception -> L32 JsonSyntaxException -> L34
    L34:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("QSMusicLoginStrategyProviderV2", "parseData JsonSyntaxException: " + e.getMessage());
    L32:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("QSMusicLoginStrategyProviderV2", "parseData Exception: " + e.getMessage());
        goto L36
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L10
    }
}
