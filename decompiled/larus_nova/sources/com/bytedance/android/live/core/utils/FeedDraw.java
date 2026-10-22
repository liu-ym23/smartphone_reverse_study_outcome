package com.bytedance.android.live.core.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.common.utility.StringUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class FeedDraw {

    @SerializedName("city_url")
    private String cityFeedUrl;

    @SerializedName("more_live_url")
    private String followDrawerUrl;

    @SerializedName("pk_url")
    private String pkUrl;

    @SerializedName("settings")
    private Map<String, Integer> settings;

    @SerializedName("url")
    private String url;

    public FeedDraw() {
        this.settings = new HashMap();
    }

    public String getFollowDrawerUrl() {
        return this.followDrawerUrl;
    }

    public String getPkUrl() {
        return this.pkUrl;
    }

    public Map<String, Integer> getSettings() {
        return this.settings;
    }

    public String getUrl() {
        return this.url;
    }

    public static FeedDraw defaultInstance(String r100) {
        FeedDraw r101 = new FeedDraw();
        if (tb1.c.f545229a == false) goto L5;
        r101.url = "https://" + r100 + "/webcast/feed/?content_type=0&channel_id=25&is_draw=1";
    L6:
        return r101;
    L5:
        r101.url = "";
        goto L6
    }

    public static boolean needCollectUnRead(String r100) {
        if (StringUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (r100.startsWith("homepage_follow_stream") == false) goto L8;
        return false;
    L8:
        return true;
    }

    public String getInnerUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        if (r100.equals(PbRequest.SwitchType.PK) == false) goto L11;
        return this.pkUrl;
    L11:
        if (r100.equals("city_feed") == false) goto L15;
        return this.cityFeedUrl;
    L15:
        return this.url;
    }

    public boolean isSupportedRequestFrom(String r100) {
        if (StringUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        Integer r101 = this.settings.get(r100);
        if (r101 == null) goto L11;
        if (r101.intValue() != 1) goto L11;
        return true;
    L11:
        if (r100.equals(PbRequest.SwitchType.PK) == false) goto L15;
        return !TextUtils.isEmpty(this.pkUrl);
    L15:
        if (r100.equals("city_feed") == true) goto L17;
        return false;
    L17:
        return !TextUtils.isEmpty(this.cityFeedUrl);
    }

    public void setPkUrl(String r100) {
        this.pkUrl = r100;
    }

    public static String conventRequestFrom(String r100, String r101, Bundle r102) {
        if (tb1.c.f545229a == false) goto L105;
        if (r100 != null) goto L7;
        return "";
    L7:
        if ("live_merge".equals(r100) == false) goto L13;
        if ("live_cover".equals(r101) == false) goto L11;
        return "feed_draw";
    L11:
        return "";
    L13:
        if ("discover_page".equals(r100) == false) goto L23;
        if ("draw_more".equals(r101) == false) goto L17;
        return "from_discover";
    L17:
        if ("living_icon".equals(r101) == true) goto L107;
        return "";
    L107:
        return "from_discover";
    L23:
        if ("live_merge_activity".equals(r100) == false) goto L32;
        if ("live_k_activity".equals(r101) == false) goto L27;
    L30:
        return "feed_draw";
    L27:
        if ("live_d3_activity".equals(r101) == true) goto L30;
        return "";
    L32:
        if (r100.equals(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT) == false) goto L43;
        if ("live_cell".equals(r101) == false) goto L38;
        return "homepage_hot_draw";
    L38:
        if ("video_head".equals(r101) == false) goto L41;
        return "homepage_hot_head";
    L41:
        return "";
    L43:
        if (r100.equals("homepage_fresh") == false) goto L47;
        return "homepage_fresh_head";
    L47:
        if (r100.equals("homepage_follow") == false) goto L55;
        if (r101.equals("live_cell_cover") == false) goto L51;
    L52:
        return "homepage_follow_stream";
    L51:
        if (r101.equals("live_cell") == true) goto L52;
        return "";
    L55:
        if (r100.equals("others_homepage") == false) goto L68;
        if (r101 != null) goto L59;
        return "";
    L59:
        if (r101.equals("others_photo") == false) goto L63;
        return "others_homepage_photo";
    L63:
        if (r101.equals("video_head") == false) goto L66;
        return "others_homepage_head";
    L66:
        return "";
    L68:
        if (r100.equals(SearchResultParam.ENTER_PAGE_GENERAL_SEARCH) == false) goto L84;
        if (r101 != null) goto L72;
        return "";
    L72:
        if (r101.equals("others_photo") == false) goto L76;
        return "general_search_photo";
    L76:
        if (r101.equals("video_head") == false) goto L80;
        return "general_search_head";
    L80:
        if (r101.equals("drawer_cover") == false) goto L82;
        return "feed_draw";
    L82:
        return "";
    L84:
        if (r100.equals("live_detail") == false) goto L96;
        if ("right_anchor".equals(r101) == false) goto L90;
        return "live_detail_pk";
    L90:
        if ("top_message".equals(r101) == false) goto L93;
        return "live_detail_top_message";
    L93:
        return "live_detail_hourly_rank";
    L96:
        if (r100.equals("live_end") == false) goto L100;
        return "live_end_cover";
    L100:
        if (r100.equals("push") == false) goto L103;
        return "push";
    L103:
        if (r100.equals("h5") == false) goto L105;
        return "h5";
    L105:
        return "";
    }
}
