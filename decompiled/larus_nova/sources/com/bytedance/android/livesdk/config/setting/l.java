package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.live.base.model.longpresspanel.ItemConfig;
import com.bytedance.android.livesdk.config.zc0;
import com.ss.android.lark.url.card.UrlCardProperty;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f121213a = 0;

    @JvmStatic
    public static final List<ItemConfig> a() {
        List<ItemConfig> r100 = zc0.f121752a.getValue().liveFeedItemList;
        if (r100 == null) goto L5;
        return r100;
    L5:
        if (tb1.c.f545231c == false) goto L7;
        ItemConfig r101 = new ItemConfig();
        r101.setIdentity("live_notification");
        r101.setType(2);
        r101.setPriority(1900);
        Unit r102 = Unit.INSTANCE;
        ItemConfig r103 = new ItemConfig();
        r103.setIdentity("dislike_current_live");
        r103.setType(2);
        r103.setPriority(2000);
        ItemConfig r104 = new ItemConfig();
        r104.setIdentity("report");
        r104.setType(2);
        r104.setPriority(1600);
        ItemConfig r105 = new ItemConfig();
        r105.setIdentity("recommend_to_friends");
        r105.setType(1);
        r105.setPriority(2000);
        ItemConfig r106 = new ItemConfig();
        r106.setIdentity("follow");
        r106.setType(2);
        r106.setPriority(1800);
        ItemConfig r107 = new ItemConfig();
        r107.setIdentity("unfollow");
        r107.setType(2);
        r107.setPriority(1500);
        ItemConfig r108 = new ItemConfig();
        r108.setIdentity("feed_live_share");
        r108.setType(2);
        r108.setPriority(1200);
        ItemConfig r109 = new ItemConfig();
        r109.setIdentity(UrlCardProperty.URL_PREVIEW_BUSINESS_HOST);
        r109.setType(0);
        r109.setPriority(2000);
        return CollectionsKt.mutableListOf(new ItemConfig[]{r101, r103, r104, r105, r106, r107, r108, r109});
    L7:
        ItemConfig r110 = new ItemConfig();
        r110.setIdentity("live_notification");
        r110.setType(2);
        r110.setPriority(1900);
        Unit r111 = Unit.INSTANCE;
        ItemConfig r112 = new ItemConfig();
        r112.setIdentity("opt_recommend");
        r112.setType(2);
        r112.setPriority(1700);
        ItemConfig r113 = new ItemConfig();
        r113.setIdentity("dislike_current_live");
        r113.setType(2);
        r113.setPriority(2000);
        ItemConfig r114 = new ItemConfig();
        r114.setIdentity("report");
        r114.setType(2);
        r114.setPriority(1600);
        ItemConfig r115 = new ItemConfig();
        r115.setIdentity("recommend_to_friends");
        r115.setType(1);
        r115.setPriority(2000);
        ItemConfig r116 = new ItemConfig();
        r116.setIdentity("follow");
        r116.setType(2);
        r116.setPriority(1800);
        ItemConfig r117 = new ItemConfig();
        r117.setIdentity("unfollow");
        r117.setType(2);
        r117.setPriority(1500);
        ItemConfig r118 = new ItemConfig();
        r118.setIdentity("feed_live_share");
        r118.setType(2);
        r118.setPriority(1200);
        ItemConfig r119 = new ItemConfig();
        r119.setIdentity(UrlCardProperty.URL_PREVIEW_BUSINESS_HOST);
        r119.setType(0);
        r119.setPriority(2000);
        return CollectionsKt.mutableListOf(new ItemConfig[]{r110, r112, r113, r114, r115, r116, r117, r118, r119});
    }

    @JvmStatic
    public static final List<ItemConfig> b() {
        List<ItemConfig> r100 = zc0.f121752a.getValue().liveRoomItemList;
        if (r100 == null) goto L5;
        return r100;
    L5:
        if (tb1.c.f545231c == false) goto L7;
        ItemConfig r101 = new ItemConfig();
        r101.setIdentity("live_notification");
        r101.setType(2);
        r101.setPriority(1900);
        Unit r102 = Unit.INSTANCE;
        ItemConfig r103 = new ItemConfig();
        r103.setIdentity("dislike_current_live");
        r103.setType(2);
        r103.setPriority(2000);
        ItemConfig r104 = new ItemConfig();
        r104.setIdentity("report");
        r104.setType(2);
        r104.setPriority(1600);
        ItemConfig r105 = new ItemConfig();
        r105.setIdentity("recommend_to_friends");
        r105.setType(1);
        r105.setPriority(2000);
        ItemConfig r106 = new ItemConfig();
        r106.setIdentity("follow");
        r106.setType(2);
        r106.setPriority(1800);
        ItemConfig r107 = new ItemConfig();
        r107.setIdentity("unfollow");
        r107.setType(2);
        r107.setPriority(1500);
        ItemConfig r108 = new ItemConfig();
        r108.setIdentity("float_window");
        r108.setType(2);
        r108.setPriority(1400);
        ItemConfig r109 = new ItemConfig();
        r109.setIdentity("feed_live_share");
        r109.setType(2);
        r109.setPriority(1200);
        ItemConfig r110 = new ItemConfig();
        r110.setIdentity("pk_feedback");
        r110.setType(2);
        r110.setPriority(900);
        ItemConfig r111 = new ItemConfig();
        r111.setIdentity(UrlCardProperty.URL_PREVIEW_BUSINESS_HOST);
        r111.setType(0);
        r111.setPriority(2000);
        ItemConfig r112 = new ItemConfig();
        r112.setIdentity("screen_record");
        r112.setType(2);
        r112.setPriority(1000);
        return CollectionsKt.mutableListOf(new ItemConfig[]{r101, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112});
    L7:
        ItemConfig r113 = new ItemConfig();
        r113.setIdentity("live_notification");
        r113.setType(2);
        r113.setPriority(1900);
        Unit r114 = Unit.INSTANCE;
        ItemConfig r115 = new ItemConfig();
        r115.setIdentity("opt_recommend");
        r115.setType(2);
        r115.setPriority(1700);
        ItemConfig r116 = new ItemConfig();
        r116.setIdentity("dislike_current_live");
        r116.setType(2);
        r116.setPriority(2000);
        ItemConfig r117 = new ItemConfig();
        r117.setIdentity("report");
        r117.setType(2);
        r117.setPriority(1600);
        ItemConfig r118 = new ItemConfig();
        r118.setIdentity("recommend_to_friends");
        r118.setType(1);
        r118.setPriority(2000);
        ItemConfig r119 = new ItemConfig();
        r119.setIdentity("follow");
        r119.setType(2);
        r119.setPriority(1800);
        ItemConfig r120 = new ItemConfig();
        r120.setIdentity("unfollow");
        r120.setType(2);
        r120.setPriority(1500);
        ItemConfig r121 = new ItemConfig();
        r121.setIdentity("float_window");
        r121.setType(2);
        r121.setPriority(1400);
        ItemConfig r122 = new ItemConfig();
        r122.setIdentity("add_to_desktop");
        r122.setType(2);
        r122.setPriority(1300);
        ItemConfig r123 = new ItemConfig();
        r123.setIdentity("feed_live_share");
        r123.setType(2);
        r123.setPriority(1200);
        ItemConfig r124 = new ItemConfig();
        r124.setIdentity("audio_feedback");
        r124.setType(2);
        r124.setPriority(1100);
        ItemConfig r125 = new ItemConfig();
        r125.setIdentity("pk_feedback");
        r125.setType(2);
        r125.setPriority(900);
        ItemConfig r126 = new ItemConfig();
        r126.setIdentity(UrlCardProperty.URL_PREVIEW_BUSINESS_HOST);
        r126.setType(0);
        r126.setPriority(2000);
        ItemConfig r127 = new ItemConfig();
        r127.setIdentity("screen_record");
        r127.setType(2);
        r127.setPriority(1000);
        return CollectionsKt.mutableListOf(new ItemConfig[]{r113, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127});
    }

    @JvmStatic
    public static final boolean c() {
        Integer r100 = zc0.f121752a.getValue().style;
        if (r100 != null) goto L6;
    L7:
        return true;
    L6:
        if (r100.intValue() != 0) goto L7;
        return false;
    }

    static {
    }
}
