package com.bytedance.android.shopping.collect.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import bf.b;
import bf.e;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.collect.container.ECFavoriteActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ECFavoriteRouter implements e {

    public static final class a {
    }

    static {
    }

    public ECFavoriteRouter() {
    }

    @Override // bf.e
    public final boolean a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Lazy r101 = ECAppInfoService.f48110a;
        boolean r102 = false;
        if (we.a.f559330a == true) goto L5;
        return false;
    L5:
        int r103 = b.f18807a;
        Integer r104 = null;
        if (r100 != null) goto L8;
        String r105 = null;
    L10:
        if ((!Intrinsics.areEqual(r105, "favorite")) == false) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r100, com.bytedance.android.ec.core.event.a.KEY_TAB_NAME), "goods") == true) goto L25;
        String r106 = UriProtector.getQueryParameter(r100, "type");
        if (r106 == null) goto L18;
        r104 = StringsKt.toIntOrNull(r106);
    L18:
        if (r104 == null) goto L24;
        if (r104.intValue() != 6) goto L24;
        r102 = true;
    L24:
        return r102;
    L25:
        return true;
    L8:
        r105 = b.a(r100.getHost(), r100.getPath());
        goto L10
    }

    @Override // bf.e
    public final boolean open(final Context r100, final Uri r101, boolean r110, final boolean r111) {
        if (r100 == null) goto L18;
        if (r101 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof Activity) == true) goto L8;
        Context r102 = null;
    L9:
        Activity r103 = (Activity) r102;
        if (r110 == true) goto L16;
        if (r103 == null) goto L16;
        r r104 = r.f48132a;
        if (r104.isLogin() == true) goto L16;
        r104.showLogin(r103, "favorite_login_guide", "favorite_login_guide_click", new AnonymousClass1(r100, r101, r111), null);
        return true;
    L16:
        int r112 = ECFavoriteActivity.f172147m;
        ECFavoriteActivity.a.a(r100, r101, r111);
        return true;
    L8:
        r102 = r100;
        goto L9
    L18:
        return false;
    }
}
