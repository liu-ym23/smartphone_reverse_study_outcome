package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001e\u0010\t\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\b\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\b\u001a\u0004\b \u0010\u0011R\u001c\u0010'\u001a\u0004\u0018\u00010#8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\b\u001a\u0004\b$\u0010%R\u001c\u0010,\u001a\u0004\u0018\u00010(8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\b\u001a\u0004\b)\u0010*R\u001c\u0010/\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\b\u001a\u0004\b-\u0010\u0011R\u001a\u00104\u001a\u0002008&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\b\u001a\u0004\b1\u00102R\u001c\u00109\u001a\u0004\u0018\u0001058&X§\u0004¢\u0006\f\u0012\u0004\b8\u0010\b\u001a\u0004\b6\u00107R\u001c\u0010>\u001a\u0004\u0018\u00010:8&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\b\u001a\u0004\b;\u0010<R\u001a\u0010C\u001a\u00020?8&X§\u0004¢\u0006\f\u0012\u0004\bB\u0010\b\u001a\u0004\b@\u0010AR\u001a\u0010F\u001a\u00020?8&X§\u0004¢\u0006\f\u0012\u0004\bE\u0010\b\u001a\u0004\bD\u0010AR\u001c\u0010K\u001a\u0004\u0018\u00010G8&X§\u0004¢\u0006\f\u0012\u0004\bJ\u0010\b\u001a\u0004\bH\u0010I¨\u0006L"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/g0;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/gift/model/m1;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getGiftId", "()J", "getGiftId$annotations", "()V", "giftId", "Lcom/bytedance/android/livesdk/gift/model/q3;", "getSubscribeGiftPackInfo", "()Lcom/bytedance/android/livesdk/gift/model/q3;", "getSubscribeGiftPackInfo$annotations", "subscribeGiftPackInfo", "", "getBannerGiftInfo", "()Ljava/lang/String;", "getBannerGiftInfo$annotations", "bannerGiftInfo", "", "Lcom/bytedance/android/livesdk/gift/model/l1;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getGiftBuffInfos", "()Ljava/util/List;", "getGiftBuffInfos$annotations", "giftBuffInfos", "Lcom/bytedance/android/livesdk/gift/model/p;", "getDiyGiftToolbarInfo", "()Lcom/bytedance/android/livesdk/gift/model/p;", "getDiyGiftToolbarInfo$annotations", "diyGiftToolbarInfo", "getGiftHonorLevelUrl", "getGiftHonorLevelUrl$annotations", "giftHonorLevelUrl", "Lcom/bytedance/android/livesdk/gift/model/ComboHintInfo;", "getComboHintInfo", "()Lcom/bytedance/android/livesdk/gift/model/ComboHintInfo;", "getComboHintInfo$annotations", "comboHintInfo", "Lcom/bytedance/android/livesdk/gift/model/l3;", "getSeriesGift", "()Lcom/bytedance/android/livesdk/gift/model/l3;", "getSeriesGift$annotations", "seriesGift", "getMetaInfo", "getMetaInfo$annotations", "metaInfo", "", "getShowComboTray", "()Z", "getShowComboTray$annotations", "showComboTray", "Lcom/bytedance/android/livesdk/gift/model/IGiftExposureAnimInfo;", "getGiftExposureAnimInfo", "()Lcom/bytedance/android/livesdk/gift/model/IGiftExposureAnimInfo;", "getGiftExposureAnimInfo$annotations", "giftExposureAnimInfo", "Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "getGiftMarketingInfo", "()Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "getGiftMarketingInfo$annotations", "giftMarketingInfo", "", "getGiftSelectedStyle", "()I", "getGiftSelectedStyle$annotations", "giftSelectedStyle", "getGiftPlayNowStrategy", "getGiftPlayNowStrategy$annotations", "giftPlayNowStrategy", "Lcom/bytedance/android/livesdk/gift/model/k1;", "getBottomLabel", "()Lcom/bytedance/android/livesdk/gift/model/k1;", "getBottomLabel$annotations", "bottomLabel", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g0 extends vh7.c<g0>, m1 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "banner_gift_info")
    String getBannerGiftInfo();

    @FieldName(name = "bottom_label")
    k1 getBottomLabel();

    @FieldName(name = "combo_hint_info")
    ComboHintInfo getComboHintInfo();

    @FieldName(name = "diy_gift_toolbar_info")
    p getDiyGiftToolbarInfo();

    @FieldName(name = "gift_buff_infos")
    List<l1> getGiftBuffInfos();

    @FieldName(name = "icon_autoplay_asset_info")
    IGiftExposureAnimInfo getGiftExposureAnimInfo();

    @FieldName(name = "gift_panel_top_desc_scheme_url")
    String getGiftHonorLevelUrl();

    @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    long getGiftId();

    @FieldName(name = "gift_marketing_info")
    IGiftMarketingInfo getGiftMarketingInfo();

    @FieldName(name = "asset_display_strategy")
    int getGiftPlayNowStrategy();

    @FieldName(name = "gift_selected_style")
    int getGiftSelectedStyle();

    @FieldName(name = "meta_info")
    String getMetaInfo();

    @FieldName(name = "series_gifts_info")
    l3 getSeriesGift();

    @FieldName(name = "show_combo_tray")
    boolean getShowComboTray();

    @FieldName(name = "subscribe_gift_pack_info")
    q3 getSubscribeGiftPackInfo();
}
