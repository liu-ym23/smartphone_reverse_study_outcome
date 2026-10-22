package com.bytedance.android.shopping.anchorv3.utils;

import android.text.TextUtils;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165300a = 0;

    static {
    }

    public static void b(ECAdLogExtra r100, String r101, Integer r102, Long r110, long r111, String r112) {
        Intrinsics.checkNotNullParameter(r112, "pageSource");
        if (r100 != null) goto L5;
        return;
    L5:
        int r103 = g.f165309a;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        String r104 = r101;
        if (r102 == null) goto L11;
        int r105 = r102.intValue();
    L12:
        if (r110 == null) goto L14;
        long r106 = r110.longValue();
    L15:
        Long r107 = Long.valueOf(r106);
        Long r108 = Long.valueOf(r111);
        Intrinsics.checkNotNullParameter(r100, "adLogExtra");
        Intrinsics.checkNotNullParameter(r104, "promotionId");
        g.b("click_confirm", r100, r104, r105, r107, r108, r112);
        return;
    L14:
        r106 = -1;
        goto L15
    L11:
        r105 = (int) 999;
        goto L12
    }

    public static void c(boolean r100, ECAdLogExtra r101, String r102, Long r110, Long r111, long r112) {
        if (r100 == false) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        int r103 = g.f165309a;
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        String r104 = r102;
        if (r110 == null) goto L12;
        long r105 = r110.longValue();
    L13:
        Long r106 = Long.valueOf(r112);
        Intrinsics.checkNotNullParameter(r101, "adLogExtra");
        Intrinsics.checkNotNullParameter(r104, "promotionId");
        g.b("click_shop_page", r101, r104, (int) r105, r111, r106, "large_stabilization");
        return;
    L12:
        r105 = SourceType.UNKNOWN.getType();
        goto L13
    }

    public static void d(boolean r100, ECAdLogExtra r101, String r102, Integer r110, Long r111, long r112) {
        if (r100 == false) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        int r103 = g.f165309a;
        if (r110 == null) goto L9;
        int r104 = r110.intValue();
    L10:
        Long r105 = Long.valueOf(r112);
        Intrinsics.checkNotNullParameter(r101, "adLogExtra");
        Intrinsics.checkNotNullParameter(r102, "promotionId");
        g.b("click_consult", r101, r102, r104, r111, r105, "large_stabilization");
        return;
    L9:
        r104 = (int) 999;
        goto L10
    }

    public static void e(boolean r100, String r101, long r102, ECAdLogExtra r103, Long r104, long r105) {
        if (r100 == false) goto L4;
        return;
    L4:
        if (r103 != null) goto L6;
        return;
    L6:
        int r106 = g.f165309a;
        int r107 = (int) r102;
        if (r104 == null) goto L9;
        long r108 = r104.longValue();
    L10:
        Intrinsics.checkNotNullParameter(r103, "adLogExtra");
        Intrinsics.checkNotNullParameter(r101, "promotionId");
        HashMap r109 = new HashMap();
        r109.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r101);
        r109.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, String.valueOf(r107));
        r109.put("commodity_price", Long.valueOf(r108));
        r109.put("commodity_duration", Long.valueOf(r105));
        String r110 = "large_stabilization";
        if ((!TextUtils.isEmpty("large_stabilization")) == true) goto L14;
        r110 = null;
    L14:
        if (r110 == null) goto L16;
        r109.put("page_source", r110);
    L16:
        int r111 = l.f165312a;
        String r112 = r103.getCreativeId().toString();
        Long r113 = StringsKt.toLongOrNull(r103.getGroupId());
        if (r113 == null) goto L19;
        long r114 = r113.longValue();
    L20:
        l.d("click_want", r112, r114, l.b(r103.getLogExtra(), l.a(r103.getAdExtraData(), r109), null, null));
        return;
    L19:
        r114 = 0;
        goto L20
    L9:
        r108 = -1;
        goto L10
    }

    public static void a(boolean r100, ECAdLogExtra r101, long r110, String r111, boolean r112, Long r113, Long r114) {
        if (r100 == false) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        long r102 = -1;
        String r103 = "";
        if (r112 == false) goto L19;
        int r104 = g.f165309a;
        if (r111 == null) goto L12;
        r103 = r111;
    L12:
        if (r113 == null) goto L14;
        long r105 = r113.longValue();
    L15:
        int r106 = (int) r105;
        if (r114 == null) goto L18;
        r102 = r114.longValue();
    L18:
        String r107 = r103;
        g.a(r101, r107, r106, r102, r110, "live_click_buy_right_now");
        return;
    L14:
        r105 = SourceType.UNKNOWN.getType();
        goto L15
    L19:
        int r108 = g.f165309a;
        if (r111 == null) goto L23;
        r103 = r111;
    L23:
        if (r113 == null) goto L25;
        long r109 = r113.longValue();
    L26:
        int r115 = (int) r109;
        if (r114 == null) goto L29;
        r102 = r114.longValue();
    L29:
        String r116 = r103;
        g.a(r101, r116, r115, r102, r110, "click_buy_right_now");
        return;
    L25:
        r109 = SourceType.UNKNOWN.getType();
        goto L26
    }
}
