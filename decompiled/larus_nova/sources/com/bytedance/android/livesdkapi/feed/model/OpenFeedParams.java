package com.bytedance.android.livesdkapi.feed.model;

import android.graphics.drawable.Drawable;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.feed.constant.CardStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.constant.OpenFeedConstantKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b-\u0018\u00002\u00020\u0001:\u0004CDEFBñ\u0001\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u001eR\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\"\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b'\u0010 \"\u0004\b(\u0010)R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0016\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0016\u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010,R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010,R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b3\u00100R\u0016\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010,R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0016\u0010\u0016\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0016\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00108R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010%R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b@\u0010 R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\bA\u0010 R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\bB\u00100¨\u0006G"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/model/OpenFeedParams;", "", "feedType", "Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;", "feedStyle", "Lcom/bytedance/android/livesdkapi/feed/constant/FeedStyle;", "enableFeedTitle", "", "feedTitle", "", "enableFeedBackIcon", "feedBackIcon", "Landroid/graphics/drawable/Drawable;", "feedItemDecorationVertical", "", "feedItemDecorationHorizontal", "enableOperationLabel", "enableContentLabel", "enableCategoryLabel", "liveTagColor", "liveTagRadius", "enableCoverAvatar", "feedCardCornerRadius", "supportFollowListInFeed", "enableMoreLiveEntry", "cardStyle", "Lcom/bytedance/android/livesdkapi/feed/constant/CardStyle;", "cardCount", "channelName", "drawerPage", "(Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;Lcom/bytedance/android/livesdkapi/feed/constant/FeedStyle;ZLjava/lang/String;Ljava/lang/Boolean;Landroid/graphics/drawable/Drawable;IIZZZLjava/lang/Integer;Ljava/lang/Integer;ZILjava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/android/livesdkapi/feed/constant/CardStyle;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCardCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCardStyle", "()Lcom/bytedance/android/livesdkapi/feed/constant/CardStyle;", "getChannelName", "()Ljava/lang/String;", "doubleColumnLayoutId", "getDoubleColumnLayoutId", "setDoubleColumnLayoutId", "(Ljava/lang/Integer;)V", "getDrawerPage", "getEnableCategoryLabel", "()Z", "getEnableContentLabel", "getEnableCoverAvatar", "getEnableFeedBackIcon", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableFeedTitle", "getEnableMoreLiveEntry", "getEnableOperationLabel", "getFeedBackIcon", "()Landroid/graphics/drawable/Drawable;", "getFeedCardCornerRadius", "()I", "getFeedItemDecorationHorizontal", "getFeedItemDecorationVertical", "getFeedStyle", "()Lcom/bytedance/android/livesdkapi/feed/constant/FeedStyle;", "getFeedTitle", "getFeedType", "()Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;", "getLiveTagColor", "getLiveTagRadius", "getSupportFollowListInFeed", "BlockParamsBuilder", "Builder", "CardParamsBuilder", "FeedBuilder", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeedParams {

    @SerializedName("card_count")
    private final Integer cardCount;

    @SerializedName("card_style")
    private final CardStyle cardStyle;

    @SerializedName(OpenFeedConstantKt.KEY_CHANNEL_NAME)
    private final String channelName;
    private Integer doubleColumnLayoutId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_VS_DRAWER_PAGE)
    private final String drawerPage;

    @SerializedName("enable_category_label")
    private final boolean enableCategoryLabel;

    @SerializedName("enable_content_label")
    private final boolean enableContentLabel;

    @SerializedName("enable_cover_avatar")
    private final boolean enableCoverAvatar;

    @SerializedName("enable_feed_back_icon")
    private final Boolean enableFeedBackIcon;

    @SerializedName("enable_feed_title")
    private final boolean enableFeedTitle;

    @SerializedName("enable_more_live_entry")
    private final Boolean enableMoreLiveEntry;

    @SerializedName("enable_operation_label")
    private final boolean enableOperationLabel;

    @SerializedName("feed_back_icon")
    private final Drawable feedBackIcon;

    @SerializedName("feed_card_corner_radius")
    private final int feedCardCornerRadius;

    @SerializedName("feed_ite_decoration_horizontal")
    private final int feedItemDecorationHorizontal;

    @SerializedName("feed_item_decoration_vertical")
    private final int feedItemDecorationVertical;

    @SerializedName(IHostFeed.KEY_FEED_STYLE)
    private final FeedStyle feedStyle;

    @SerializedName("feed_title")
    private final String feedTitle;

    @SerializedName("feed_type")
    private final FeedType feedType;

    @SerializedName("live_tag_color")
    private final Integer liveTagColor;

    @SerializedName("live_tag_radius")
    private final Integer liveTagRadius;

    @SerializedName("support_follow_list_in_feed")
    private final Boolean supportFollowListInFeed;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/model/OpenFeedParams$BlockParamsBuilder;", "", "()V", "enableMoreLiveEntry", "", "feedStyle", "Lcom/bytedance/android/livesdkapi/feed/constant/FeedStyle;", "feedTitle", "", "build", "Lcom/bytedance/android/livesdkapi/feed/model/OpenFeedParams;", "setEnableMoreLiveEntry", "enable", "setFeedTitle", "title", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BlockParamsBuilder {
        private boolean enableMoreLiveEntry;
        private FeedStyle feedStyle;
        private String feedTitle;

        public final OpenFeedParams build() {
            Boolean r110 = Boolean.valueOf(this.enableMoreLiveEntry);
            boolean r100 = true;
            return new OpenFeedParams(null, this.feedStyle, r100, this.feedTitle, null, null, 0, 0, false, false, false, null, null, false, 0, null, r110, null, null, null, "homepage_hot_more", 983025, null);
        }

        public BlockParamsBuilder() {
            this.feedStyle = FeedStyle.DOUBLE_LIST_D;
        }

        public final BlockParamsBuilder feedStyle(FeedStyle r100) {
            Intrinsics.checkNotNullParameter(r100, "feedStyle");
            this.feedStyle = r100;
            return this;
        }

        public final BlockParamsBuilder setEnableMoreLiveEntry(boolean r100) {
            this.enableMoreLiveEntry = r100;
            return this;
        }

        public final BlockParamsBuilder setFeedTitle(String r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.feedTitle = r100;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\fJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\fJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\fJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\fJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\fJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\fJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0014J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0006J\u000e\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u00020\nJ\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0006J\u000e\u00104\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006J\u000e\u00106\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/model/OpenFeedParams$Builder;", "", "feedType", "Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;", "(Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;)V", "cardCount", "", "cardStyle", "Lcom/bytedance/android/livesdkapi/feed/constant/CardStyle;", "channelName", "", "enableCategoryLabel", "", "enableContentLabel", "enableCoverAvatar", "enableFeedBackIcon", "enableFeedTitle", "enableMoreLiveEntry", "enableOperationLabel", "feedBackIcon", "Landroid/graphics/drawable/Drawable;", "feedCardCornerRadius", "feedItemDecorationHorizontal", "feedItemDecorationVertical", "feedStyle", "Lcom/bytedance/android/livesdkapi/feed/constant/FeedStyle;", "feedTitle", "liveTagColor", "Ljava/lang/Integer;", "liveTagRadius", "supportFollowListInFeed", "build", "Lcom/bytedance/android/livesdkapi/feed/model/OpenFeedParams;", "setCardCount", "count", "setCardStyle", "setChannelName", "setEnableCategoryLabel", "enable", "setEnableContentLabel", "setEnableCoverAvatar", "setEnableFeedBackIcon", "setEnableFeedTitle", "setEnableOperationLabel", "setFeedBackIcon", "icon", "setFeedCardCornerRadius", "radius", "setFeedTitle", "title", "setHorizontalFeedItemDecoration", "itemDecorationPx", "setLiveTagColor", "setLiveTagRadius", "setVerticalFeedItemDecoration", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {
        private int cardCount;
        private CardStyle cardStyle;
        private String channelName;
        private boolean enableCategoryLabel;
        private boolean enableContentLabel;
        private boolean enableCoverAvatar;
        private boolean enableFeedBackIcon;
        private boolean enableFeedTitle;
        private boolean enableMoreLiveEntry;
        private boolean enableOperationLabel;
        private Drawable feedBackIcon;
        private int feedCardCornerRadius;
        private int feedItemDecorationHorizontal;
        private int feedItemDecorationVertical;
        private FeedStyle feedStyle;
        private String feedTitle;
        private final FeedType feedType;
        private Integer liveTagColor;
        private Integer liveTagRadius;
        private boolean supportFollowListInFeed;

        public final OpenFeedParams build() {
            boolean r110 = this.enableCategoryLabel;
            boolean r111 = this.enableCoverAvatar;
            int r112 = this.feedCardCornerRadius;
            Boolean r113 = Boolean.valueOf(this.supportFollowListInFeed);
            Boolean r114 = Boolean.valueOf(this.enableMoreLiveEntry);
            CardStyle r115 = this.cardStyle;
            Integer r116 = this.liveTagRadius;
            Integer r117 = this.liveTagColor;
            String r100 = this.channelName;
            Drawable r101 = null;
            return new OpenFeedParams(this.feedType, this.feedStyle, this.enableFeedTitle, this.feedTitle, Boolean.valueOf(this.enableFeedBackIcon), r101, 0, 0, false, false, r110, r117, r116, r111, r112, r113, r114, r115, Integer.valueOf(this.cardCount), r100, null, 1049568, null);
        }

        public Builder(FeedType r100) {
            Intrinsics.checkNotNullParameter(r100, "feedType");
            this.feedType = r100;
            this.enableOperationLabel = true;
            this.enableContentLabel = true;
            this.enableCategoryLabel = true;
            this.enableCoverAvatar = true;
            this.feedCardCornerRadius = -1;
        }

        public final Builder feedStyle(FeedStyle r100) {
            Intrinsics.checkNotNullParameter(r100, "feedStyle");
            this.feedStyle = r100;
            return this;
        }

        public final Builder setCardCount(int r100) {
            this.cardCount = r100;
            return this;
        }

        public final Builder setCardStyle(CardStyle r100) {
            Intrinsics.checkNotNullParameter(r100, "cardStyle");
            this.cardStyle = r100;
            return this;
        }

        public final Builder setChannelName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "channelName");
            this.channelName = r100;
            return this;
        }

        public final Builder setEnableCategoryLabel(boolean r100) {
            this.enableCategoryLabel = r100;
            return this;
        }

        public final Builder setEnableContentLabel(boolean r100) {
            this.enableContentLabel = r100;
            return this;
        }

        public final Builder setEnableCoverAvatar(boolean r100) {
            this.enableCoverAvatar = r100;
            return this;
        }

        public final Builder setEnableFeedBackIcon(boolean r100) {
            this.enableFeedBackIcon = r100;
            return this;
        }

        public final Builder setEnableFeedTitle(boolean r100) {
            this.enableFeedTitle = r100;
            return this;
        }

        public final Builder setEnableOperationLabel(boolean r100) {
            this.enableOperationLabel = r100;
            return this;
        }

        public final Builder setFeedBackIcon(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            this.feedBackIcon = r100;
            return this;
        }

        public final Builder setFeedCardCornerRadius(int r100) {
            this.feedCardCornerRadius = r100;
            return this;
        }

        public final Builder setFeedTitle(String r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.feedTitle = r100;
            return this;
        }

        public final Builder setHorizontalFeedItemDecoration(int r100) {
            this.feedItemDecorationHorizontal = r100;
            return this;
        }

        public final Builder setLiveTagColor(int r100) {
            this.liveTagColor = Integer.valueOf(r100);
            return this;
        }

        public final Builder setLiveTagRadius(int r100) {
            this.liveTagRadius = Integer.valueOf(r100);
            return this;
        }

        public final Builder setVerticalFeedItemDecoration(int r100) {
            this.feedItemDecorationVertical = r100;
            return this;
        }

        public final Builder supportFollowListInFeed(boolean r100) {
            this.supportFollowListInFeed = r100;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/model/OpenFeedParams$CardParamsBuilder;", "", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CardParamsBuilder {
        public CardParamsBuilder() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\bJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\bJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\bJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u000eJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0010J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0006J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0010J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0010J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0010J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0010J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/model/OpenFeedParams$FeedBuilder;", "", "feedType", "Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;", "(Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;)V", "channelName", "", "enableCategoryLabel", "", "enableContentLabel", "enableFeedBackIcon", "enableFeedTitle", "enableOperationLabel", "feedBackIcon", "Landroid/graphics/drawable/Drawable;", "feedCardCornerRadius", "", "feedItemDecorationHorizontal", "feedItemDecorationVertical", "feedStyle", "Lcom/bytedance/android/livesdkapi/feed/constant/FeedStyle;", "feedTitle", "getFeedType", "()Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;", "liveTagColor", "Ljava/lang/Integer;", "liveTagRadius", "supportFollowListInFeed", "build", "Lcom/bytedance/android/livesdkapi/feed/model/OpenFeedParams;", "setChannelName", "setEnableCategoryLabel", "enable", "setEnableContentLabel", "setEnableFeedBackIcon", "setEnableFeedTitle", "setEnableOperationLabel", "setFeedBackIcon", "icon", "setFeedCardCornerRadius", "radius", "setFeedTitle", "title", "setHorizontalFeedItemDecoration", "itemDecorationPx", "setLiveTagColor", "setLiveTagRadius", "setVerticalFeedItemDecoration", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FeedBuilder {
        private String channelName;
        private boolean enableCategoryLabel;
        private boolean enableContentLabel;
        private boolean enableFeedBackIcon;
        private boolean enableFeedTitle;
        private boolean enableOperationLabel;
        private Drawable feedBackIcon;
        private int feedCardCornerRadius;
        private int feedItemDecorationHorizontal;
        private int feedItemDecorationVertical;
        private FeedStyle feedStyle;
        private String feedTitle;
        private final FeedType feedType;
        private Integer liveTagColor;
        private Integer liveTagRadius;
        private boolean supportFollowListInFeed;

        public final OpenFeedParams build() {
            FeedType r100 = this.feedType;
            FeedStyle r101 = this.feedStyle;
            boolean r102 = this.enableFeedTitle;
            String r103 = this.feedTitle;
            Boolean r104 = Boolean.valueOf(this.enableFeedBackIcon);
            Drawable r105 = this.feedBackIcon;
            int r106 = this.feedItemDecorationVertical;
            int r107 = this.feedItemDecorationHorizontal;
            boolean r110 = this.enableOperationLabel;
            boolean r111 = this.enableContentLabel;
            int r112 = this.feedCardCornerRadius;
            boolean r113 = false;
            return new OpenFeedParams(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, this.enableCategoryLabel, this.liveTagColor, this.liveTagRadius, r113, r112, null, null, null, null, this.channelName, null, 1548288, null);
        }

        public final FeedType getFeedType() {
            return this.feedType;
        }

        public FeedBuilder(FeedType r100) {
            Intrinsics.checkNotNullParameter(r100, "feedType");
            this.feedType = r100;
            this.enableOperationLabel = true;
            this.enableContentLabel = true;
            this.enableCategoryLabel = true;
            this.feedCardCornerRadius = -1;
        }

        public final FeedBuilder feedStyle(FeedStyle r100) {
            Intrinsics.checkNotNullParameter(r100, "feedStyle");
            this.feedStyle = r100;
            return this;
        }

        public final FeedBuilder setChannelName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "channelName");
            this.channelName = r100;
            return this;
        }

        public final FeedBuilder setEnableCategoryLabel(boolean r100) {
            this.enableCategoryLabel = r100;
            return this;
        }

        public final FeedBuilder setEnableContentLabel(boolean r100) {
            this.enableContentLabel = r100;
            return this;
        }

        public final FeedBuilder setEnableFeedBackIcon(boolean r100) {
            this.enableFeedBackIcon = r100;
            return this;
        }

        public final FeedBuilder setEnableFeedTitle(boolean r100) {
            this.enableFeedTitle = r100;
            return this;
        }

        public final FeedBuilder setEnableOperationLabel(boolean r100) {
            this.enableOperationLabel = r100;
            return this;
        }

        public final FeedBuilder setFeedBackIcon(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            this.feedBackIcon = r100;
            return this;
        }

        public final FeedBuilder setFeedCardCornerRadius(int r100) {
            this.feedCardCornerRadius = r100;
            return this;
        }

        public final FeedBuilder setFeedTitle(String r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.feedTitle = r100;
            return this;
        }

        public final FeedBuilder setHorizontalFeedItemDecoration(int r100) {
            this.feedItemDecorationHorizontal = r100;
            return this;
        }

        public final FeedBuilder setLiveTagColor(int r100) {
            this.liveTagColor = Integer.valueOf(r100);
            return this;
        }

        public final FeedBuilder setLiveTagRadius(int r100) {
            this.liveTagRadius = Integer.valueOf(r100);
            return this;
        }

        public final FeedBuilder setVerticalFeedItemDecoration(int r100) {
            this.feedItemDecorationVertical = r100;
            return this;
        }

        public final FeedBuilder supportFollowListInFeed(boolean r100) {
            this.supportFollowListInFeed = r100;
            return this;
        }
    }

    public final Integer getCardCount() {
        return this.cardCount;
    }

    public final CardStyle getCardStyle() {
        return this.cardStyle;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final Integer getDoubleColumnLayoutId() {
        return this.doubleColumnLayoutId;
    }

    public final String getDrawerPage() {
        return this.drawerPage;
    }

    public final boolean getEnableCategoryLabel() {
        return this.enableCategoryLabel;
    }

    public final boolean getEnableContentLabel() {
        return this.enableContentLabel;
    }

    public final boolean getEnableCoverAvatar() {
        return this.enableCoverAvatar;
    }

    public final Boolean getEnableFeedBackIcon() {
        return this.enableFeedBackIcon;
    }

    public final boolean getEnableFeedTitle() {
        return this.enableFeedTitle;
    }

    public final Boolean getEnableMoreLiveEntry() {
        return this.enableMoreLiveEntry;
    }

    public final boolean getEnableOperationLabel() {
        return this.enableOperationLabel;
    }

    public final Drawable getFeedBackIcon() {
        return this.feedBackIcon;
    }

    public final int getFeedCardCornerRadius() {
        return this.feedCardCornerRadius;
    }

    public final int getFeedItemDecorationHorizontal() {
        return this.feedItemDecorationHorizontal;
    }

    public final int getFeedItemDecorationVertical() {
        return this.feedItemDecorationVertical;
    }

    public final FeedStyle getFeedStyle() {
        return this.feedStyle;
    }

    public final String getFeedTitle() {
        return this.feedTitle;
    }

    public final FeedType getFeedType() {
        return this.feedType;
    }

    public final Integer getLiveTagColor() {
        return this.liveTagColor;
    }

    public final Integer getLiveTagRadius() {
        return this.liveTagRadius;
    }

    public final Boolean getSupportFollowListInFeed() {
        return this.supportFollowListInFeed;
    }

    public final void setDoubleColumnLayoutId(Integer r100) {
        this.doubleColumnLayoutId = r100;
    }

    private OpenFeedParams(FeedType r100, FeedStyle r101, boolean r102, String r103, Boolean r104, Drawable r105, int r106, int r110, boolean r111, boolean r112, boolean r113, Integer r114, Integer r115, boolean r116, int r117, Boolean r118, Boolean r119, CardStyle r210, Integer r211, String r212, String r213) {
        this.feedType = r100;
        this.feedStyle = r101;
        this.enableFeedTitle = r102;
        this.feedTitle = r103;
        this.enableFeedBackIcon = r104;
        this.feedBackIcon = r105;
        this.feedItemDecorationVertical = r106;
        this.feedItemDecorationHorizontal = r110;
        this.enableOperationLabel = r111;
        this.enableContentLabel = r112;
        this.enableCategoryLabel = r113;
        this.liveTagColor = r114;
        this.liveTagRadius = r115;
        this.enableCoverAvatar = r116;
        this.feedCardCornerRadius = r117;
        this.supportFollowListInFeed = r118;
        this.enableMoreLiveEntry = r119;
        this.cardStyle = r210;
        this.cardCount = r211;
        this.channelName = r212;
        this.drawerPage = r213;
    }

    public /* synthetic */ OpenFeedParams(FeedType r210, FeedStyle r211, boolean r212, String r213, Boolean r214, Drawable r215, int r216, int r310, boolean r311, boolean r312, boolean r313, Integer r314, Integer r315, boolean r316, int r317, Boolean r318, Boolean r319, CardStyle r410, Integer r411, String r412, String r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        FeedType r100 = FeedType.COMMON_FEED;
    L7:
        if ((r414 & 2) == 0) goto L9;
        FeedStyle r101 = FeedStyle.SINGLE_LIST_H;
    L11:
        if ((r414 & 4) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r414 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r414 & 16) == 0) goto L21;
        Boolean r104 = Boolean.TRUE;
    L23:
        if ((r414 & 32) == 0) goto L25;
        Drawable r105 = null;
    L27:
        if ((r414 & 64) == 0) goto L29;
        int r106 = 0;
    L31:
        if ((r414 & 128) == 0) goto L33;
        int r110 = 0;
    L35:
        if ((r414 & 256) == 0) goto L37;
        boolean r111 = true;
    L39:
        if ((r414 & 512) == 0) goto L41;
        boolean r112 = true;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        boolean r113 = true;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        Integer r114 = null;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        Integer r107 = null;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        boolean r108 = true;
    L59:
        if ((r414 & 16384) == 0) goto L61;
        int r115 = -1;
    L63:
        if ((r414 & 32768) == 0) goto L65;
        Boolean r116 = Boolean.FALSE;
    L67:
        if ((r414 & 65536) == 0) goto L69;
        Boolean r117 = Boolean.FALSE;
    L71:
        if ((r414 & 131072) == 0) goto L73;
        CardStyle r118 = null;
    L75:
        if ((r414 & 262144) == 0) goto L77;
        Integer r119 = 0;
    L79:
        if ((r414 & 524288) == 0) goto L81;
        String r217 = null;
    L83:
        if ((r414 & 1048576) == 0) goto L85;
        String r109 = null;
    L86:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107, r108, r115, r116, r117, r118, r119, r217, r109);
        return;
    L85:
        r109 = r413;
        goto L86
    L81:
        r217 = r412;
        goto L83
    L77:
        r119 = r411;
        goto L79
    L73:
        r118 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L71
    L65:
        r116 = r318;
        goto L67
    L61:
        r115 = r317;
        goto L63
    L57:
        r108 = r316;
        goto L59
    L53:
        r107 = r315;
        goto L55
    L49:
        r114 = r314;
        goto L51
    L45:
        r113 = r313;
        goto L47
    L41:
        r112 = r312;
        goto L43
    L37:
        r111 = r311;
        goto L39
    L33:
        r110 = r310;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
