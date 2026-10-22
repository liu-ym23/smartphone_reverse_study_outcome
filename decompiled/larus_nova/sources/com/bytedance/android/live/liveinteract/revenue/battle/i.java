package com.bytedance.android.live.liveinteract.revenue.battle;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f78024a = 0;

    public static long a() {
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L7;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L7;
        return r101.getRoomId();
    L7:
        return 0;
    }

    static {
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dressId");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [getTextBgColorByDressId] dressId ".concat(r100));
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L11;
        zt0.e r102 = yt0.c.a();
        Intrinsics.checkNotNull(r100);
        com.bytedance.android.live.profit.dress.s r103 = (com.bytedance.android.live.profit.dress.s) r102.getDressData(r100, 33, a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new f());
        if (r103 == null) goto L11;
        return r103.f87165g;
    L11:
        return null;
    L5:
        r101 = false;
        goto L6
    }

    public static String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dressId");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [getTextColorByDressId] dressId ".concat(r100));
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L11;
        zt0.e r102 = yt0.c.a();
        Intrinsics.checkNotNull(r100);
        com.bytedance.android.live.profit.dress.s r103 = (com.bytedance.android.live.profit.dress.s) r102.getDressData(r100, 33, a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new g());
        if (r103 == null) goto L11;
        return r103.f87166h;
    L11:
        return null;
    L5:
        r101 = false;
        goto L6
    }

    public static Uri d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dressId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L12;
        zt0.e r102 = yt0.c.a();
        Intrinsics.checkNotNull(r100);
        com.bytedance.android.live.profit.dress.s r103 = (com.bytedance.android.live.profit.dress.s) r102.getDressData(r100, 33, a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new d());
        if (r103 == null) goto L12;
        String r104 = r103.f87160b;
    L14:
        if (TextUtils.isEmpty(r104) == false) goto L17;
        return null;
    L17:
        return UriProtector.parse(r104);
    L12:
        r104 = null;
        goto L14
    L5:
        r101 = false;
        goto L7
    }
}
