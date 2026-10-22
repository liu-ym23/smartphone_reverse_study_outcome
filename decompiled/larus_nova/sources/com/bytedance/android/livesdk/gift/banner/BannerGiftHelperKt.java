package com.bytedance.android.livesdk.gift.banner;

import android.content.Context;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.i2;
import zz0.g;

/* JADX INFO: loaded from: classes9.dex */
public final class BannerGiftHelperKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f125841a = 0;

    static {
    }

    public static void a(Context r100, final b1 r110, Map r111) {
        Intrinsics.checkNotNullParameter(r110, "banner");
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r110.getActionType();
        int r102 = 1;
        if (r101 != 1) goto L8;
        UrlBuilder r112 = new UrlBuilder(r110.getSchemaUrl());
        r112.addParam("title", r110.getTitle());
        ((g) f.a(g.class)).S2(r100, r112.build());
        return;
    L8:
        if (r101 != 2) goto L10;
        UrlBuilder r103 = new UrlBuilder(r110.getSchemaUrl());
        py.d r104 = ((l01.d) f.a(l01.d.class)).b().getUserHonor();
        if (r104 != null) goto L16;
    L18:
        r102 = 0;
    L19:
        r103.addParam("is_first_consume", String.valueOf(r102));
        if (r111 == null) goto L27;
        HashMap r113 = (HashMap) r111;
        if (r113.size() <= 0) goto L27;
        Iterator r114 = r113.entrySet().iterator();
    L25:
        if (r114.hasNext() == false) goto L27;
        Map.Entry r105 = (Map.Entry) r114.next();
        r103.addParam((String) r105.getKey(), r105.getValue().toString());
    L27:
        int r106 = r110.getWidth();
        int r107 = r110.getHeight();
        xs2.b.a().post(new i2(r103.build(), "banner", 17, r106, r107, 2));
        return;
    L16:
        if (r104.getLevel() <= 0) goto L18;
    L10:
        if (r101 == 3) goto L12;
        UrlBuilder r115 = new UrlBuilder(r110.getSchemaUrl());
        r115.addParam("title", r110.getTitle());
        ((g) f.a(g.class)).S2(r100, r115.build());
        return;
    L12:
        ((vy0.c) f.a(vy0.c.class)).x6(r100, r110.getSchemaUrl(), new BannerGiftHelperKt$bannerClick$1(r110));
    }
}
