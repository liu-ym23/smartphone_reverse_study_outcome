package com.bytedance.android.live.core.feed;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.ae1;
import com.bytedance.android.livesdk.config.feed.LiveFeedDynamic;
import com.bytedance.android.livesdk.log.u;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes45.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final LiveFeedDynamic a(String r110, String r111, LiveFeedType r210) {
        Intrinsics.checkNotNullParameter(r210, "liveFeedType");
        if (Intrinsics.areEqual("drawer_game", r110) == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L10;
        String r101 = LiveConfigSettingKeys.LIVE_FEED_UNKNOWN_DRAW.getValue();
        if (r101 != null) goto L14;
        r101 = "https://webcast-open.douyin.com/webcast/openapi/feed/?channel_id=999999";
    L14:
        String r102 = r101;
        int r103 = b.f64798a[r210.ordinal()];
        if (r103 == 1) goto L23;
        if (r103 != 2) goto L18;
        List<LiveFeedDynamic> r104 = LiveConfigSettingKeys.LIVE_FEED_DYNAMIC_CONFIG_V2.getValue().getDynamicInnerFlow();
    L24:
        if (r104 == null) goto L85;
        if (ListUtils.isEmpty(r104) == true) goto L85;
        String r105 = r110 + '-' + r111;
        Iterator<LiveFeedDynamic> r106 = r104.iterator();
    L30:
        if (r106.hasNext() == false) goto L58;
        LiveFeedDynamic r107 = r106.next();
        String r112 = r107.getEnterSource();
        if (r112 == null) goto L30;
        if (TextUtils.equals(r112, r105) == true) goto L59;
        String r113 = StringsKt.replace$default(r112, "*", "", false, 4, null);
        if (TextUtils.isEmpty(r113) == true) goto L59;
        if (StringsKt.startsWith$default(r112, "*", false, 2, null) == false) goto L46;
        if (StringsKt.endsWith$default(r105, r113, false, 2, null) == true) goto L59;
    L46:
        if (StringsKt.endsWith$default(r112, "*", false, 2, null) == false) goto L51;
        if (StringsKt.startsWith$default(r105, r113, false, 2, null) == true) goto L59;
    L51:
        if (StringsKt.startsWith$default(r112, "*", false, 2, null) == false) goto L30;
        if (StringsKt.endsWith$default(r112, "*", false, 2, null) == false) goto L30;
        if (StringsKt.contains$default(r105, r113, false, 2, null) == false) goto L30;
    L59:
        if (r107 == null) goto L80;
        if (Intrinsics.areEqual(r107.getLiveFeedUrl(), r102) == true) goto L80;
        if (r210 == LiveFeedType.DRAWER) goto L67;
        b(r110, r111, r210, r107.getLiveFeedUrl(), !StringsKt.contains$default(r107.getLiveFeedUrl(), "channel_id=999999", false, 2, null));
    L67:
        String r108 = r107.getLiveFeedUrl();
        if (r108 != null) goto L70;
    L73:
        boolean r109 = true;
    L74:
        if (r109 == true) goto L77;
        StringsKt.substringBefore$default(StringsKt.substringAfter$default(r108, "channel_id=", null, 2, null), Typography.amp, null, 2, null);
    L77:
        ae1.f119783a.getClass();
        return r107;
    L70:
        if (r108.length() == 0) goto L73;
        r109 = false;
    L80:
        if (r210 == LiveFeedType.DRAWER) goto L83;
        b(r110, r111, r210, r102, false);
    L83:
        return new LiveFeedDynamic(null, r102, false, 5, null);
    L58:
        r107 = null;
    L85:
        if (r210 == LiveFeedType.DRAWER) goto L88;
        b(r110, r111, r210, r102, false);
    L88:
        return new LiveFeedDynamic(null, r102, false, 5, null);
    L18:
        if (r103 != 3) goto L21;
        r104 = LiveConfigSettingKeys.LIVE_FEED_DYNAMIC_CONFIG_V2.getValue().getDynamicDrawer();
        goto L24
    L21:
        throw new NoWhenBranchMatchedException();
    L23:
        r104 = LiveConfigSettingKeys.LIVE_FEED_DYNAMIC_CONFIG_V2.getValue().getDynamicOutFlow();
        goto L24
    L10:
        return new LiveFeedDynamic(null, null, false, 3, null);
    L5:
        if (Intrinsics.areEqual("drawer_cover", r111) == false) goto L7;
        r100 = true;
        goto L8
    }

    public static void b(String r100, String r101, LiveFeedType r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r102, "type");
        Pair[] r105 = new Pair[5];
        r105[0] = TuplesKt.to("enter_from_merge", r100);
        r105[1] = TuplesKt.to("enter_method", r101);
        if (r104 == false) goto L5;
        String r106 = "success";
    L6:
        r105[2] = TuplesKt.to("result", r106);
        r105[3] = TuplesKt.to("feed_type", r102.lowerName());
        r105[4] = TuplesKt.to("live_feed_url", r103);
        Map<String, String> r107 = MapsKt.mapOf(r105);
        u.l().sendLog("livesdk_live_feed_result", r107, new Object[0]);
        return;
    L5:
        r106 = "error";
        goto L6
    }
}
