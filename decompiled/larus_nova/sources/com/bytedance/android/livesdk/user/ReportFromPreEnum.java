package com.bytedance.android.livesdk.user;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b:\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u000e\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\u0010\u0010\rj\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bA¨\u0006B"}, d2 = {"Lcom/bytedance/android/livesdk/user/ReportFromPreEnum;", "", "Lcom/bytedance/android/livesdk/user/LiveFollowScene;", "followScene", "", "enterFromMerge", "enterMethod", ReportConstant.COMMON_ACTION_TYPE, "", "match", "getReportFromPre", "reportFromPre", "Ljava/lang/String;", "()Ljava/lang/String;", "getEnterFromMerge", "getEnterMethod", "getActionType", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "HOMEPAGEHOT_LIVECELL_CLICK", "HOMEPAGEHOT_LIVECELL_DRAW", "HOMEPAGEHOT_VIDEOHEAD_CLICK", "HOMEPAGEHOT_VIDEOHEAD_DRAW", "HOMEPAGEHOT_VIDEOSTICKER", "HOMEPAGEHOT_LEAVEWINDOW", "HOMEPAGEHOT_PERSONALCARD", "HOMEPAGEHOT_VIDEOPOINT", "HOMEPAGEHOT_APPOINT", "HOMEPAGESQUARE_APPOINT", "HOMEPAGEFOLLOW_LIVECOVER", "HOMEPAGEFOLLOW_LIVECELL", "HOMEPAGEFOLLOW_VIDEOHEAD", "SEARCH_LIVECELL", "SEARCH_LIVECOVER", "SEARCH_VIDEOHEAD", "SEARCH_OTHERS", "SEARCHRESULTLIVE", "OTHERSHOMEPAGE_VIDEOHEAD", "OTHERSHOMEPAGE_OTHERSPHOTO", "PERSONALHOMEPAGE", "HOLLOWFINGHOMEPAGE", "CHAT_FANSGROUP", "GROUPCHAT", "SHAREALERT", "MESSAGE_IM", "MESSAGE_LIVECOVER", "PRIVATECHAT", "INNERPUSH", FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, "HOMEPAGETABLIVE", "HOMEPAGEXLIVE", "HOMEPAGEFAMILIAR", "HOMEPAGEFRESH", "LIVE_POPRANK", "LIVE_HOURLYRANK", "LIVE_REGIONRANK", "LIVE_SALERANK", "LIVE_TOPMESSAGE", "LIVE_PERSONALCARD", "ECOMMERCE", "LIVEEND", "LIVE_MORELIVE", "LIVE_HISTORY", "AD", "HOMEPAGELIFE", FlowDoraWifiScene.OTHER, "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public enum ReportFromPreEnum extends Enum<ReportFromPreEnum> {
    public static final ReportFromPreEnum AD = null;
    public static final ReportFromPreEnum CHAT_FANSGROUP = null;
    public static final a Companion = null;
    public static final ReportFromPreEnum ECOMMERCE = null;
    public static final ReportFromPreEnum GROUPCHAT = null;
    public static final ReportFromPreEnum HOLLOWFINGHOMEPAGE = null;
    public static final ReportFromPreEnum HOMEPAGEFAMILIAR = null;
    public static final ReportFromPreEnum HOMEPAGEFOLLOW_LIVECELL = null;
    public static final ReportFromPreEnum HOMEPAGEFOLLOW_LIVECOVER = null;
    public static final ReportFromPreEnum HOMEPAGEFOLLOW_VIDEOHEAD = null;
    public static final ReportFromPreEnum HOMEPAGEFRESH = null;
    public static final ReportFromPreEnum HOMEPAGEHOT_APPOINT = null;
    public static final ReportFromPreEnum HOMEPAGEHOT_LEAVEWINDOW = null;
    public static final ReportFromPreEnum HOMEPAGEHOT_LIVECELL_CLICK = null;
    public static final ReportFromPreEnum HOMEPAGEHOT_LIVECELL_DRAW = null;
    public static final ReportFromPreEnum HOMEPAGEHOT_PERSONALCARD = null;
    public static final ReportFromPreEnum HOMEPAGEHOT_VIDEOHEAD_CLICK = null;
    public static final ReportFromPreEnum HOMEPAGEHOT_VIDEOHEAD_DRAW = null;
    public static final ReportFromPreEnum HOMEPAGEHOT_VIDEOPOINT = null;
    public static final ReportFromPreEnum HOMEPAGEHOT_VIDEOSTICKER = null;
    public static final ReportFromPreEnum HOMEPAGELIFE = null;
    public static final ReportFromPreEnum HOMEPAGESQUARE_APPOINT = null;
    public static final ReportFromPreEnum HOMEPAGETABLIVE = null;
    public static final ReportFromPreEnum HOMEPAGEXLIVE = null;
    public static final ReportFromPreEnum INNERPUSH = null;
    public static final ReportFromPreEnum LIVEEND = null;
    public static final ReportFromPreEnum LIVE_HISTORY = null;
    public static final ReportFromPreEnum LIVE_HOURLYRANK = null;
    public static final ReportFromPreEnum LIVE_MORELIVE = null;
    public static final ReportFromPreEnum LIVE_PERSONALCARD = null;
    public static final ReportFromPreEnum LIVE_POPRANK = null;
    public static final ReportFromPreEnum LIVE_REGIONRANK = null;
    public static final ReportFromPreEnum LIVE_SALERANK = null;
    public static final ReportFromPreEnum LIVE_TOPMESSAGE = null;
    public static final ReportFromPreEnum MESSAGE_IM = null;
    public static final ReportFromPreEnum MESSAGE_LIVECOVER = null;
    public static final ReportFromPreEnum OTHER = null;
    public static final ReportFromPreEnum OTHERSHOMEPAGE_OTHERSPHOTO = null;
    public static final ReportFromPreEnum OTHERSHOMEPAGE_VIDEOHEAD = null;
    public static final ReportFromPreEnum PERSONALHOMEPAGE = null;
    public static final ReportFromPreEnum PRIVATECHAT = null;
    public static final ReportFromPreEnum PUSH = null;
    public static final ReportFromPreEnum SEARCHRESULTLIVE = null;
    public static final ReportFromPreEnum SEARCH_LIVECELL = null;
    public static final ReportFromPreEnum SEARCH_LIVECOVER = null;
    public static final ReportFromPreEnum SEARCH_OTHERS = null;
    public static final ReportFromPreEnum SEARCH_VIDEOHEAD = null;
    public static final ReportFromPreEnum SHAREALERT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReportFromPreEnum[] f158633a = null;
    private final String actionType;
    private final String enterFromMerge;
    private final String enterMethod;
    private final String reportFromPre;

    public static final class a {
        public a() {
        }
    }

    public static ReportFromPreEnum valueOf(String r100) {
        return (ReportFromPreEnum) r27.a.a(ReportFromPreEnum.class, r100);
    }

    public static ReportFromPreEnum[] values() {
        return (ReportFromPreEnum[]) f158633a.clone();
    }

    static {
        ReportFromPreEnum r100 = new ReportFromPreEnum("HOMEPAGEHOT_LIVECELL_CLICK", 0, "13", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "live_cell", "click");
        HOMEPAGEHOT_LIVECELL_CLICK = r100;
        ReportFromPreEnum r101 = new ReportFromPreEnum("HOMEPAGEHOT_LIVECELL_DRAW", 1, "13", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "live_cell", "draw");
        HOMEPAGEHOT_LIVECELL_DRAW = r101;
        ReportFromPreEnum r102 = new ReportFromPreEnum("HOMEPAGEHOT_VIDEOHEAD_CLICK", 2, "13", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "video_head", "click");
        HOMEPAGEHOT_VIDEOHEAD_CLICK = r102;
        ReportFromPreEnum r103 = new ReportFromPreEnum("HOMEPAGEHOT_VIDEOHEAD_DRAW", 3, "13", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "video_head", "draw");
        HOMEPAGEHOT_VIDEOHEAD_DRAW = r103;
        ReportFromPreEnum r104 = new ReportFromPreEnum("HOMEPAGEHOT_VIDEOSTICKER", 4, "13", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "video_sticker", null);
        HOMEPAGEHOT_VIDEOSTICKER = r104;
        ReportFromPreEnum r105 = new ReportFromPreEnum("HOMEPAGEHOT_LEAVEWINDOW", 5, "13", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "leave_window", null);
        HOMEPAGEHOT_LEAVEWINDOW = r105;
        ReportFromPreEnum r106 = new ReportFromPreEnum("HOMEPAGEHOT_PERSONALCARD", 6, "13", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "personal_card", null);
        HOMEPAGEHOT_PERSONALCARD = r106;
        ReportFromPreEnum r107 = new ReportFromPreEnum("HOMEPAGEHOT_VIDEOPOINT", 7, "13", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "video_point", null);
        HOMEPAGEHOT_VIDEOPOINT = r107;
        ReportFromPreEnum r108 = new ReportFromPreEnum("HOMEPAGEHOT_APPOINT", 8, "13", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "appoint_anchor_point", null);
        HOMEPAGEHOT_APPOINT = r108;
        ReportFromPreEnum r109 = new ReportFromPreEnum("HOMEPAGESQUARE_APPOINT", 9, "195", "homepage_square", "double_cover", null);
        HOMEPAGESQUARE_APPOINT = r109;
        ReportFromPreEnum r110 = new ReportFromPreEnum("HOMEPAGEFOLLOW_LIVECOVER", 10, Constants.VIA_REPORT_TYPE_CHAT_AUDIO, "homepage_follow", "live_cover", null);
        HOMEPAGEFOLLOW_LIVECOVER = r110;
        ReportFromPreEnum r111 = new ReportFromPreEnum("HOMEPAGEFOLLOW_LIVECELL", 11, Constants.VIA_REPORT_TYPE_CHAT_AUDIO, "homepage_follow", "live_cell", null);
        HOMEPAGEFOLLOW_LIVECELL = r111;
        ReportFromPreEnum r112 = new ReportFromPreEnum("HOMEPAGEFOLLOW_VIDEOHEAD", 12, Constants.VIA_REPORT_TYPE_CHAT_AUDIO, "homepage_follow", "video_head", null);
        HOMEPAGEFOLLOW_VIDEOHEAD = r112;
        ReportFromPreEnum r113 = new ReportFromPreEnum("SEARCH_LIVECELL", 13, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, SearchResultParam.ENTER_PAGE_GENERAL_SEARCH, "live_cell", null);
        SEARCH_LIVECELL = r113;
        ReportFromPreEnum r114 = new ReportFromPreEnum("SEARCH_LIVECOVER", 14, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, SearchResultParam.ENTER_PAGE_GENERAL_SEARCH, "live_cover", null);
        SEARCH_LIVECOVER = r114;
        ReportFromPreEnum r115 = new ReportFromPreEnum("SEARCH_VIDEOHEAD", 15, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, SearchResultParam.ENTER_PAGE_GENERAL_SEARCH, "video_head", null);
        SEARCH_VIDEOHEAD = r115;
        ReportFromPreEnum r116 = new ReportFromPreEnum("SEARCH_OTHERS", 16, "1401", SearchResultParam.ENTER_PAGE_GENERAL_SEARCH, "others_photo", null);
        SEARCH_OTHERS = r116;
        ReportFromPreEnum r117 = new ReportFromPreEnum("SEARCHRESULTLIVE", 17, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "search_result_live", null, null);
        SEARCHRESULTLIVE = r117;
        ReportFromPreEnum r118 = new ReportFromPreEnum("OTHERSHOMEPAGE_VIDEOHEAD", 18, Constants.VIA_ACT_TYPE_NINETEEN, "others_homepage", "video_head", null);
        OTHERSHOMEPAGE_VIDEOHEAD = r118;
        ReportFromPreEnum r119 = new ReportFromPreEnum("OTHERSHOMEPAGE_OTHERSPHOTO", 19, Constants.VIA_ACT_TYPE_NINETEEN, "others_homepage", "others_photo", null);
        OTHERSHOMEPAGE_OTHERSPHOTO = r119;
        ReportFromPreEnum r120 = new ReportFromPreEnum("PERSONALHOMEPAGE", 20, BDLocationException.ERROR_ABNORMAL_NETWORK, com.bytedance.android.ec.core.event.a.VALUE_PERSONAL_HOMEPAGE, null, null);
        PERSONALHOMEPAGE = r120;
        ReportFromPreEnum r121 = new ReportFromPreEnum("HOLLOWFINGHOMEPAGE", 21, BDLocationException.ERROR_ABNORMAL_NETWORK, "following_liveplay", null, null);
        HOLLOWFINGHOMEPAGE = r121;
        ReportFromPreEnum r122 = new ReportFromPreEnum("CHAT_FANSGROUP", 22, "2704", "chat", "fansgroup_live_cover", null);
        CHAT_FANSGROUP = r122;
        ReportFromPreEnum r123 = new ReportFromPreEnum("GROUPCHAT", 23, "27", "group_chat", null, null);
        GROUPCHAT = r123;
        ReportFromPreEnum r124 = new ReportFromPreEnum("SHAREALERT", 24, "6", "share_alert", null, null);
        SHAREALERT = r124;
        ReportFromPreEnum r125 = new ReportFromPreEnum("MESSAGE_IM", 25, "8", "message", "im_list", null);
        MESSAGE_IM = r125;
        ReportFromPreEnum r126 = new ReportFromPreEnum("MESSAGE_LIVECOVER", 26, "8", "message", "live_cover", null);
        MESSAGE_LIVECOVER = r126;
        ReportFromPreEnum r127 = new ReportFromPreEnum("PRIVATECHAT", 27, "8", "private_chat", null, null);
        PRIVATECHAT = r127;
        ReportFromPreEnum r128 = new ReportFromPreEnum("INNERPUSH", 28, "35", "inner_push", null, null);
        INNERPUSH = r128;
        ReportFromPreEnum r129 = new ReportFromPreEnum(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 29, BDLocationException.ERROR_DISPUTED_AREA, "push", null, null);
        PUSH = r129;
        ReportFromPreEnum r130 = new ReportFromPreEnum("HOMEPAGETABLIVE", 30, Constants.VIA_REPORT_TYPE_START_WAP, "homepage_tablive", null, null);
        HOMEPAGETABLIVE = r130;
        ReportFromPreEnum r131 = new ReportFromPreEnum("HOMEPAGEXLIVE", 31, Constants.VIA_REPORT_TYPE_START_WAP, "homepage_xlive", null, null);
        HOMEPAGEXLIVE = r131;
        ReportFromPreEnum r132 = new ReportFromPreEnum("HOMEPAGEFAMILIAR", 32, "24", "homepage_familiar", null, null);
        HOMEPAGEFAMILIAR = r132;
        ReportFromPreEnum r133 = new ReportFromPreEnum("HOMEPAGEFRESH", 33, Constants.VIA_REPORT_TYPE_WPA_STATE, "homepage_fresh", null, null);
        HOMEPAGEFRESH = r133;
        ReportFromPreEnum r134 = new ReportFromPreEnum("LIVE_POPRANK", 34, "131", "live_detail", "pop_rank", null);
        LIVE_POPRANK = r134;
        ReportFromPreEnum r135 = new ReportFromPreEnum("LIVE_HOURLYRANK", 35, "131", "live_detail", "hourly_rank", null);
        LIVE_HOURLYRANK = r135;
        ReportFromPreEnum r136 = new ReportFromPreEnum("LIVE_REGIONRANK", 36, "131", "live_detail", "region_rank", null);
        LIVE_REGIONRANK = r136;
        ReportFromPreEnum r137 = new ReportFromPreEnum("LIVE_SALERANK", 37, "131", "live_detail", "sale_rank", null);
        LIVE_SALERANK = r137;
        ReportFromPreEnum r138 = new ReportFromPreEnum("LIVE_TOPMESSAGE", 38, "131", "live_detail", "top_message", null);
        LIVE_TOPMESSAGE = r138;
        ReportFromPreEnum r139 = new ReportFromPreEnum("LIVE_PERSONALCARD", 39, "131", "live_detail", "personal_card", null);
        LIVE_PERSONALCARD = r139;
        final String r140 = "ECOMMERCE";
        final int r141 = 40;
        ReportFromPreEnum r142 = new ECOMMERCE(r140, r141);
        ECOMMERCE = r142;
        final String r143 = "LIVEEND";
        final int r144 = 41;
        ReportFromPreEnum r145 = new LIVEEND(r143, r144);
        LIVEEND = r145;
        final String r146 = "LIVE_MORELIVE";
        final int r147 = 42;
        ReportFromPreEnum r148 = new LIVE_MORELIVE(r146, r147);
        LIVE_MORELIVE = r148;
        final String r149 = "LIVE_HISTORY";
        final int r150 = 43;
        ReportFromPreEnum r151 = new LIVE_HISTORY(r149, r150);
        LIVE_HISTORY = r151;
        final String r152 = "AD";
        final int r153 = 44;
        ReportFromPreEnum r154 = new AD(r152, r153);
        AD = r154;
        final String r155 = "HOMEPAGELIFE";
        final int r156 = 45;
        ReportFromPreEnum r157 = new HOMEPAGELIFE(r155, r156);
        HOMEPAGELIFE = r157;
        final String r158 = FlowDoraWifiScene.OTHER;
        final int r159 = 46;
        ReportFromPreEnum r160 = new OTHER(r158, r159);
        OTHER = r160;
        f158633a = new ReportFromPreEnum[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r142, r145, r148, r151, r154, r157, r160};
        Companion = new a();
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getReportFromPre() {
        return this.reportFromPre;
    }

    public String getReportFromPre(LiveFollowScene r100) {
        Intrinsics.checkNotNullParameter(r100, "followScene");
        return this.reportFromPre;
    }

    public boolean match(LiveFollowScene r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "followScene");
        Intrinsics.checkNotNullParameter(r101, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        Intrinsics.checkNotNullParameter(r103, ReportConstant.COMMON_ACTION_TYPE);
        if ((!Intrinsics.areEqual(this.enterFromMerge, r101)) == false) goto L5;
        return false;
    L5:
        String r104 = this.enterMethod;
        if (r104 != null) goto L8;
    L10:
        String r105 = this.actionType;
        if (r105 != null) goto L13;
    L15:
        return true;
    L13:
        if ((!Intrinsics.areEqual(r105, r103)) == false) goto L15;
        return false;
    L8:
        if ((!Intrinsics.areEqual(r104, r102)) == false) goto L10;
        return false;
    }

    public ReportFromPreEnum(String r100, int r101, String r102, String r103, String r104, String r105) {
        super(r100, r101);
        this.reportFromPre = r102;
        this.enterFromMerge = r103;
        this.enterMethod = r104;
        this.actionType = r105;
    }

    public /* synthetic */ ReportFromPreEnum(String r100, int r101, String r102, String r103, String r104, String r105, DefaultConstructorMarker r106) {
        this(r100, r101, r102, r103, r104, r105);
    }
}
