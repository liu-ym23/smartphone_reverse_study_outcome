package br6;

import com.bytedance.locallife.groupon.fence.GuideTypeModel;
import com.bytedance.locallife.groupon.fence.NearbyC2SearchStyleConfig;
import com.bytedance.locallife.groupon.fence.NearbyDualAbParam;
import com.bytedance.locallife.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b7\u0018\u00002\u00020\u0001B\b¢\u0006\u0005\b\u008b\u0001\u0010oR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0015\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019R$\u00103\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0015\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R\u001c\u00106\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010+\u001a\u0004\b;\u0010-R\u001c\u0010<\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010+\u001a\u0004\b<\u0010-R\u001c\u0010>\u001a\u0004\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010+\u001a\u0004\bC\u0010-R\"\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001c\u0010J\u001a\u0004\u0018\u00010I8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR$\u0010O\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010V\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010\\\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\\\u0010W\u001a\u0004\b]\u0010Y\"\u0004\b^\u0010[R\"\u0010_\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b_\u0010#\u001a\u0004\b`\u0010$\"\u0004\ba\u0010&R$\u0010b\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u0010\u0015\u001a\u0004\bc\u0010\u0017\"\u0004\bd\u0010\u0019R$\u0010e\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010\u0015\u001a\u0004\bf\u0010\u0017\"\u0004\bg\u0010\u0019R$\u0010h\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bh\u0010\u0015\u001a\u0004\bi\u0010\u0017\"\u0004\bj\u0010\u0019R*\u0010k\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bk\u0010\u0015\u0012\u0004\bn\u0010o\u001a\u0004\bl\u0010\u0017\"\u0004\bm\u0010\u0019R$\u0010p\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bp\u0010\u0015\u001a\u0004\bq\u0010\u0017\"\u0004\br\u0010\u0019R$\u0010s\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR$\u0010y\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\by\u0010t\u001a\u0004\bz\u0010v\"\u0004\b{\u0010xR$\u0010|\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b|\u0010W\u001a\u0004\b}\u0010Y\"\u0004\b~\u0010[R$\u0010\u007f\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010#\u001a\u0005\b\u0080\u0001\u0010$\"\u0005\b\u0081\u0001\u0010&R&\u0010\u0082\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010\u0004\u001a\u0005\b\u0083\u0001\u0010\u0006\"\u0005\b\u0084\u0001\u0010\bR&\u0010\u0085\u0001\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010#\u001a\u0005\b\u0086\u0001\u0010$\"\u0005\b\u0087\u0001\u0010&R(\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010\u0015\u001a\u0005\b\u0089\u0001\u0010\u0017\"\u0005\b\u008a\u0001\u0010\u0019¨\u0006\u008c\u0001"}, d2 = {"Lbr6/c;", "Lcom/bytedance/locallife/model/response/BaseResponse;", "", "dualMode", "I", "getDualMode", "()I", "setDualMode", "(I)V", "preMode", "getPreMode", "setPreMode", "", "guideTimeStamp", "J", "getGuideTimeStamp", "()J", "setGuideTimeStamp", "(J)V", "", "guideDsl", "Ljava/lang/String;", "getGuideDsl", "()Ljava/lang/String;", "setGuideDsl", "(Ljava/lang/String;)V", "Lcom/bytedance/locallife/groupon/fence/NearbyDualAbParam;", "nearbyDualAbParam", "Lcom/bytedance/locallife/groupon/fence/NearbyDualAbParam;", "getNearbyDualAbParam", "()Lcom/bytedance/locallife/groupon/fence/NearbyDualAbParam;", "setNearbyDualAbParam", "(Lcom/bytedance/locallife/groupon/fence/NearbyDualAbParam;)V", "", "isNearbyFeedCard", "Z", "()Z", "setNearbyFeedCard", "(Z)V", "nearbyBigCardSettings", "getNearbyBigCardSettings", "setNearbyBigCardSettings", "nearbyBigCardSwitch", "Ljava/lang/Integer;", "getNearbyBigCardSwitch", "()Ljava/lang/Integer;", "setNearbyBigCardSwitch", "(Ljava/lang/Integer;)V", "nearby2TabSettings", "getNearby2TabSettings", "setNearby2TabSettings", "nearbyPrivacySwitchSetting", "getNearbyPrivacySwitchSetting", "setNearbyPrivacySwitchSetting", "enableSwitchFeedStyle", "Ljava/lang/Boolean;", "getEnableSwitchFeedStyle", "()Ljava/lang/Boolean;", "dualModeBySetting", "getDualModeBySetting", "isOversea", "Lbr6/a;", "dualButtonGuide", "Lbr6/a;", "getDualButtonGuide", "()Lbr6/a;", "dualModeForGuideSetting", "getDualModeForGuideSetting", "", "nearbyForGuideCityCodeList", "Ljava/util/List;", "getNearbyForGuideCityCodeList", "()Ljava/util/List;", "Lbr6/b;", "fullButtonGuide", "Lbr6/b;", "getFullButtonGuide", "()Lbr6/b;", "Lcom/bytedance/locallife/groupon/fence/NearbyC2SearchStyleConfig;", "searchBarConfig", "Lcom/bytedance/locallife/groupon/fence/NearbyC2SearchStyleConfig;", "getSearchBarConfig", "()Lcom/bytedance/locallife/groupon/fence/NearbyC2SearchStyleConfig;", "setSearchBarConfig", "(Lcom/bytedance/locallife/groupon/fence/NearbyC2SearchStyleConfig;)V", "Lcom/bytedance/locallife/groupon/fence/GuideTypeModel;", "nearbyFirstGuide", "Lcom/bytedance/locallife/groupon/fence/GuideTypeModel;", "getNearbyFirstGuide", "()Lcom/bytedance/locallife/groupon/fence/GuideTypeModel;", "setNearbyFirstGuide", "(Lcom/bytedance/locallife/groupon/fence/GuideTypeModel;)V", "nearbySecondGuide", "getNearbySecondGuide", "setNearbySecondGuide", "needSkipDiamond", "getNeedSkipDiamond", "setNeedSkipDiamond", "nearbyCapsuleText", "getNearbyCapsuleText", "setNearbyCapsuleText", "collectInitInfo", "getCollectInitInfo", "setCollectInitInfo", "transParam", "getTransParam", "setTransParam", "nearbyDiamondIcon", "getNearbyDiamondIcon", "setNearbyDiamondIcon", "getNearbyDiamondIcon$annotations", "()V", "nearbyPreloadResource", "getNearbyPreloadResource", "setNearbyPreloadResource", "tabGrouponInfo", "Lbr6/c;", "getTabGrouponInfo", "()Lbr6/c;", "setTabGrouponInfo", "(Lbr6/c;)V", "pageGrouponInfo", "getPageGrouponInfo", "setPageGrouponInfo", "nearbyDiamondOfflineGuide", "getNearbyDiamondOfflineGuide", "setNearbyDiamondOfflineGuide", "multiTabEnable", "getMultiTabEnable", "setMultiTabEnable", "pageStyle", "getPageStyle", "setPageStyle", "grouponTabEnable", "getGrouponTabEnable", "setGrouponTabEnable", "poiHalfScreenFilterConfig", "getPoiHalfScreenFilterConfig", "setPoiHalfScreenFilterConfig", "<init>", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class c extends BaseResponse {

    @SerializedName("collect_init_info")
    private String collectInitInfo;

    @SerializedName("dual_button_guide")
    private final a dualButtonGuide;

    @SerializedName("nearby_feed_dual_mode")
    private int dualMode;

    @SerializedName("dual_mode_by_setting")
    private final Integer dualModeBySetting;

    @SerializedName("dual_mode_for_guide_setting")
    private final Integer dualModeForGuideSetting;

    @SerializedName("enable_switch_feed_style")
    private final Boolean enableSwitchFeedStyle;

    @SerializedName("full_button_guide")
    private final b fullButtonGuide;

    @SerializedName("groupon_tab_enable")
    private boolean grouponTabEnable;

    @SerializedName("guide_dsl")
    private String guideDsl;

    @SerializedName("guide_time_stamp")
    private long guideTimeStamp;

    @SerializedName("is_nearby_feed_card")
    private boolean isNearbyFeedCard;

    @SerializedName("is_oversea_country")
    private final Integer isOversea;

    @SerializedName("multi_tab_enable")
    private boolean multiTabEnable;

    @SerializedName("nearby_secondary_tab_setting")
    private String nearby2TabSettings;

    @SerializedName("nearby_big_card_setting")
    private String nearbyBigCardSettings;

    @SerializedName("nearby_big_card_switch")
    private Integer nearbyBigCardSwitch;

    @SerializedName("nearby_capsule_text")
    private String nearbyCapsuleText;

    @SerializedName("nearby_diamond_icon")
    private String nearbyDiamondIcon;

    @SerializedName("offline_diamond_notice")
    private GuideTypeModel nearbyDiamondOfflineGuide;

    @SerializedName("dual_ab_param")
    private NearbyDualAbParam nearbyDualAbParam;

    @SerializedName("first_guide_model")
    private GuideTypeModel nearbyFirstGuide;

    @SerializedName("nearby_for_guide_city_code_list")
    private final List<String> nearbyForGuideCityCodeList;

    @SerializedName("nearby_preload_resource")
    private String nearbyPreloadResource;

    @SerializedName("nearby_privacy_switch_setting")
    private String nearbyPrivacySwitchSetting;

    @SerializedName("second_guide_model")
    private GuideTypeModel nearbySecondGuide;

    @SerializedName("skip_query_diamond")
    private boolean needSkipDiamond;

    @SerializedName("groupon_page_init_info")
    private c pageGrouponInfo;

    @SerializedName("page_style")
    private int pageStyle;

    @SerializedName("poi_half_screen_filter_config")
    private String poiHalfScreenFilterConfig;

    @SerializedName("nearby_pre_mode")
    private int preMode;

    @SerializedName("search_bar_config")
    private NearbyC2SearchStyleConfig searchBarConfig;

    @SerializedName("groupon_tab_init_info")
    private c tabGrouponInfo;

    @SerializedName("trans_param")
    private String transParam;

    public c() {
        this.nearbyDualAbParam = new NearbyDualAbParam();
        this.transParam = "";
    }
}
