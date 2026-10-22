package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b@\u0010AR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R \u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R \u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R \u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001a\u0010'\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010\u0018R\u001a\u0010,\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006R\u001a\u0010.\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006R\u001a\u00100\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006R \u00102\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u0016\u001a\u0004\b3\u0010\u0018R \u00104\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0016\u001a\u0004\b5\u0010\u0018R \u00106\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u0016\u001a\u0004\b7\u0010\u0018R\u001a\u00108\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006R\u001a\u0010:\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006R\u001a\u0010<\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006R \u0010>\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010\u0016\u001a\u0004\b?\u0010\u0018¨\u0006B"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/t;", "", "", "switch", "I", "q", "()I", "replaceSearchParams", "getReplaceSearchParams", "enableDirectJump", "d", "replaceSearchParamsJump", RXScreenCaptureService.KEY_INDEX, "", "trackGraph", "Ljava/lang/String;", "r", "()Ljava/lang/String;", "btmListLength", "b", "", "jumpPageList", "Ljava/util/List;", "f", "()Ljava/util/List;", "filterBtmList", "e", "alogBtmListParamsSwitch", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "forced1SourceList", "getForced1SourceList", "forced2SourceList", "getForced2SourceList", "forced3SourceList", "getForced3SourceList", "searchPageList", "p", "checkKeyList", "c", "paramsCheckSwitch", ce.f26391f, "Lcom/bytedance/android/ecom/bcm/track/impl/setting/j;", "crashRules", "getCrashRules", "fillPreviousPage", "getFillPreviousPage", "replaceWhenBcmEmpty", "getReplaceWhenBcmEmpty", "removeLogExtra", "h", "searchPageBtmList", OfficeSDKRequestTag.KEY_NEW_USER, "searchPageCutBtmList", "o", "searchPageAfterSpecialBtmList", "m", "searchOpenBtmLastAttribution", "l", "videoOrLiveToPhotoSearchSwitch", "s", "searchLastAttributionV2", ce.f26396k, "searchBuildSearchParamsKeys", ce.f26395j, "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class t {

    @SerializedName("alog_btmlist_params_switch")
    private final int alogBtmListParamsSwitch;

    @SerializedName("btm_list_length")
    private final int btmListLength;

    @SerializedName("check_key_list")
    private final List<String> checkKeyList;

    @SerializedName("crash_rules")
    private final List<j> crashRules;

    @SerializedName("enable_direct_jump")
    private final int enableDirectJump;

    @SerializedName("fill_previous_page")
    private final int fillPreviousPage;

    @SerializedName("filter_btm_list")
    private final List<String> filterBtmList;

    @SerializedName("forced_1_source_list")
    private final List<String> forced1SourceList;

    @SerializedName("forced_2_source_list")
    private final List<String> forced2SourceList;

    @SerializedName("forced_3_source_list")
    private final List<String> forced3SourceList;

    @SerializedName("jump_page_list")
    private final List<String> jumpPageList;

    @SerializedName("params_check_switch")
    private final int paramsCheckSwitch;

    @SerializedName("remove_log_extra")
    private final int removeLogExtra;

    @SerializedName("replace_search_params")
    private final int replaceSearchParams;

    @SerializedName("replace_search_params_jump")
    private final int replaceSearchParamsJump;

    @SerializedName("replace_when_bcm_empty")
    private final int replaceWhenBcmEmpty;

    @SerializedName("search_build_search_params_keys")
    private final List<String> searchBuildSearchParamsKeys;

    @SerializedName("search_last_attribution_v2")
    private final int searchLastAttributionV2;

    @SerializedName("search_open_btm_last_attribution")
    private final int searchOpenBtmLastAttribution;

    @SerializedName("search_page_after_special_btm_list")
    private final List<String> searchPageAfterSpecialBtmList;

    @SerializedName("search_page_btm_list")
    private final List<String> searchPageBtmList;

    @SerializedName("search_page_cut_btm_list")
    private final List<String> searchPageCutBtmList;

    @SerializedName("search_page_list")
    private final List<String> searchPageList;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f78switch;

    @SerializedName("track_graph")
    private final String trackGraph;

    @SerializedName("video_or_live_to_photo_search_switch")
    private final int videoOrLiveToPhotoSearchSwitch;

    public t() {
        this.f78switch = 1;
        this.trackGraph = "";
        this.btmListLength = 20;
        this.jumpPageList = CollectionsKt.listOf(new String[]{"b8274.", "b7635.", "b6269.", "b0547.", "b3628.", "b6539.", "b5939.", "b1923.", "b2910.", "bmix_", "a1.b9882.", "a1.b0291.", "a1.b1422."});
        this.filterBtmList = CollectionsKt.emptyList();
        this.forced1SourceList = CollectionsKt.emptyList();
        this.forced2SourceList = CollectionsKt.listOf(new String[]{SearchResultParam.ENTER_PAGE_GENERAL_SEARCH, "search_ecommerce", "search_result", "search_result_live", "search_product_detail", "search_order_center"});
        this.forced3SourceList = CollectionsKt.listOf(new String[]{SearchResultParam.ENTER_PAGE_GENERAL_SEARCH, "search_ecommerce", "search_result", "search_result_live", "search_product_detail", "search_order_center", "ecom_video_product_inner", "ecom_video_detail", "photo_search", "general_search_scan", "search_ecommerce_scan", "search_experience", "store_page", "search_live_product", "search_product_detail_half_screen"});
        this.searchPageList = CollectionsKt.listOf(new String[]{SearchResultParam.ENTER_PAGE_GENERAL_SEARCH, "search_ecommerce", "search_result", "search_result_live", "search_product_detail", "search_order_center", "ecom_video_product_inner", "ecom_video_detail", "photo_search", "general_search_scan", "search_ecommerce_scan", "search_experience", "store_page", "search_live_product", "search_product_detail_half_screen"});
        this.checkKeyList = CollectionsKt.listOf(new String[]{"search_id", "search_result_id", ILiveRoomPlayFragmentConstant.EXTRA_LIST_ITEM_ID, "enter_from", com.bytedance.android.ec.core.event.a.KEY_SEARCH_METHOD, "is_origin_product", "search_keyword"});
        this.searchPageBtmList = CollectionsKt.listOf(new String[]{"b9768", "b0534", "b3541", "b6074", "b6041", "b4421", "b2308", "b25117", "b94620", "b795629", "b34160", "b5418.c7615", "b72867", "b4329", "b00325.c6098", "b4038", "b87438", "b00907", "b795629"});
        this.searchPageCutBtmList = CollectionsKt.listOf(new String[]{"b0438", "b15297", "b9655", "b8477", "b293805", "b742768", "b90199", "b6207", "b1923", "b250658", "b6388", "b6573", "b4809", "b1693", "b2717", "b887131", "b626969", "b735718"});
        this.searchPageAfterSpecialBtmList = CollectionsKt.listOf(new String[]{"b3295", "b7947"});
        this.searchOpenBtmLastAttribution = 1;
        this.videoOrLiveToPhotoSearchSwitch = 1;
        this.searchBuildSearchParamsKeys = CollectionsKt.listOf(new String[]{"search_id", "search_result_id", ILiveRoomPlayFragmentConstant.EXTRA_LIST_ITEM_ID});
    }

    public final int a() {
        return this.alogBtmListParamsSwitch;
    }

    public final int b() {
        return this.btmListLength;
    }

    public final List<String> c() {
        return this.checkKeyList;
    }

    public final int d() {
        return this.enableDirectJump;
    }

    public final List<String> e() {
        return this.filterBtmList;
    }

    public final List<String> f() {
        return this.jumpPageList;
    }

    public final int g() {
        return this.paramsCheckSwitch;
    }

    public final int h() {
        return this.removeLogExtra;
    }

    public final int i() {
        return this.replaceSearchParamsJump;
    }

    public final List<String> j() {
        return this.searchBuildSearchParamsKeys;
    }

    public final int k() {
        return this.searchLastAttributionV2;
    }

    public final int l() {
        return this.searchOpenBtmLastAttribution;
    }

    public final List<String> m() {
        return this.searchPageAfterSpecialBtmList;
    }

    public final List<String> n() {
        return this.searchPageBtmList;
    }

    public final List<String> o() {
        return this.searchPageCutBtmList;
    }

    public final List<String> p() {
        return this.searchPageList;
    }

    public final int q() {
        return this.f78switch;
    }

    public final String r() {
        return this.trackGraph;
    }

    public final int s() {
        return this.videoOrLiveToPhotoSearchSwitch;
    }
}
