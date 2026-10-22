package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001:\u0002BCB\u0093\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0015\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00109\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u009c\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0007HÖ\u0001J\u0006\u0010@\u001a\u00020\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b*\u0010$R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006D"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard;", "", "tagUrl", "", "wysiwygParam", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/WysiwygParam;", "type", "", "product", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct;", "user", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECUserStruct;", "live", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECLiveStruct;", AnchorBenefitToast.TYPE_COUPON, "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Coupon4Activity;", "position", "extra", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$Extra;", "entrancePit", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;", "animItems", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$AnimItem;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/WysiwygParam;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECUserStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECLiveStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Coupon4Activity;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$Extra;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;Ljava/util/Map;)V", "getAnimItems", "()Ljava/util/Map;", "getCoupon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Coupon4Activity;", "getEntrancePit", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$Extra;", "getLive", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECLiveStruct;", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProduct", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct;", "getTagUrl", "()Ljava/lang/String;", "getType", "getUser", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECUserStruct;", "getWysiwygParam", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/WysiwygParam;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/WysiwygParam;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECUserStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECLiveStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Coupon4Activity;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$Extra;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;Ljava/util/Map;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard;", "equals", "", "other", "hashCode", "recommendFromItem", "toString", "AnimItem", "Extra", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCommonCard {
    private final Map<Integer, AnimItem> animItems;

    @SerializedName(AnchorBenefitToast.TYPE_COUPON)
    private final Coupon4Activity coupon;

    @SerializedName("entrance_pit")
    private final ChannelVO.Data.EntrancePit entrancePit;

    @SerializedName("extra")
    private final Extra extra;

    @SerializedName("live")
    private final ECLiveStruct live;

    @SerializedName("position")
    private final Integer position;

    @SerializedName("product")
    private final ECProductStruct product;

    @SerializedName("tag_url")
    private final String tagUrl;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("user")
    private final ECUserStruct user;

    @SerializedName("wysiwyg_param")
    private final WysiwygParam wysiwygParam;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010Jz\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0013R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001c\u0010\u0010¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$AnimItem;", "", "tagType", "", "tagContent", "", "imageUrl", "idx", "subIdx", "pictureType", "delayTime", "", VideoThumbInfo.KEY_INTERVAL, "times", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getDelayTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getIdx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageUrl", "()Ljava/lang/String;", "getInterval", "getPictureType", "getSubIdx", "getTagContent", "getTagType", "getTimes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$AnimItem;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnimItem {
        private final Long delayTime;
        private final Integer idx;
        private final String imageUrl;
        private final Long interval;
        private final String pictureType;
        private final Integer subIdx;
        private final String tagContent;
        private final Integer tagType;
        private final Long times;

        public AnimItem() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ AnimItem copy$default(AnimItem r110, Integer r111, String r112, String r113, Integer r114, Integer r115, String r116, Long r117, Long r118, Long r119, int r210, Object r211) {
            if ((r210 & 1) == 0) goto L5;
            Integer r100 = r110.tagType;
        L7:
            if ((r210 & 2) == 0) goto L9;
            String r101 = r110.tagContent;
        L11:
            if ((r210 & 4) == 0) goto L13;
            String r102 = r110.imageUrl;
        L15:
            if ((r210 & 8) == 0) goto L17;
            Integer r103 = r110.idx;
        L19:
            if ((r210 & 16) == 0) goto L21;
            Integer r104 = r110.subIdx;
        L23:
            if ((r210 & 32) == 0) goto L25;
            String r105 = r110.pictureType;
        L27:
            if ((r210 & 64) == 0) goto L29;
            Long r106 = r110.delayTime;
        L31:
            if ((r210 & 128) == 0) goto L33;
            Long r107 = r110.interval;
        L35:
            if ((r210 & 256) == 0) goto L37;
            Long r108 = r110.times;
        L39:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        L37:
            r108 = r119;
            goto L39
        L33:
            r107 = r118;
            goto L35
        L29:
            r106 = r117;
            goto L31
        L25:
            r105 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final Integer component1() {
            return this.tagType;
        }

        public final String component2() {
            return this.tagContent;
        }

        public final String component3() {
            return this.imageUrl;
        }

        public final Integer component4() {
            return this.idx;
        }

        public final Integer component5() {
            return this.subIdx;
        }

        public final String component6() {
            return this.pictureType;
        }

        public final Long component7() {
            return this.delayTime;
        }

        public final Long component8() {
            return this.interval;
        }

        public final Long component9() {
            return this.times;
        }

        public final AnimItem copy(Integer r110, String r111, String r112, Integer r113, Integer r114, String r115, Long r116, Long r117, Long r210) {
            return new AnimItem(r110, r111, r112, r113, r114, r115, r116, r117, r210);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof AnimItem) == false) goto L24;
            AnimItem r101 = (AnimItem) r100;
            if (Intrinsics.areEqual(this.tagType, r101.tagType) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.tagContent, r101.tagContent) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.idx, r101.idx) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.subIdx, r101.subIdx) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.pictureType, r101.pictureType) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.delayTime, r101.delayTime) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.interval, r101.interval) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.times, r101.times) == true) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        public int hashCode() {
            Integer r100 = this.tagType;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.tagContent;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.imageUrl;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.idx;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.subIdx;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.pictureType;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            Long r119 = this.delayTime;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            Long r122 = this.interval;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            Long r125 = this.times;
            if (r125 == null) goto L38;
            r101 = r125.hashCode();
        L38:
            return r124 + r101;
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "AnimItem(tagType=" + this.tagType + ", tagContent=" + this.tagContent + ", imageUrl=" + this.imageUrl + ", idx=" + this.idx + ", subIdx=" + this.subIdx + ", pictureType=" + this.pictureType + ", delayTime=" + this.delayTime + ", interval=" + this.interval + ", times=" + this.times + ")";
        }

        public final Long getDelayTime() {
            return this.delayTime;
        }

        public final Integer getIdx() {
            return this.idx;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final Long getInterval() {
            return this.interval;
        }

        public final String getPictureType() {
            return this.pictureType;
        }

        public final Integer getSubIdx() {
            return this.subIdx;
        }

        public final String getTagContent() {
            return this.tagContent;
        }

        public final Integer getTagType() {
            return this.tagType;
        }

        public final Long getTimes() {
            return this.times;
        }

        public AnimItem(Integer r100, String r101, String r102, Integer r103, Integer r104, String r105, Long r106, Long r107, Long r108) {
            this.tagType = r100;
            this.tagContent = r101;
            this.imageUrl = r102;
            this.idx = r103;
            this.subIdx = r104;
            this.pictureType = r105;
            this.delayTime = r106;
            this.interval = r107;
            this.times = r108;
        }

        public /* synthetic */ AnimItem(Integer r110, String r111, String r112, Integer r113, Integer r114, String r115, Long r116, Long r117, Long r118, int r210, DefaultConstructorMarker r211) {
            Long r100 = null;
            if ((r210 & 1) == 0) goto L5;
            Integer r101 = null;
        L7:
            if ((r210 & 2) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r210 & 4) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r210 & 8) == 0) goto L17;
            Integer r104 = null;
        L19:
            if ((r210 & 16) == 0) goto L21;
            Integer r105 = null;
        L23:
            if ((r210 & 32) == 0) goto L25;
            String r106 = null;
        L27:
            if ((r210 & 64) == 0) goto L29;
            Long r107 = null;
        L31:
            if ((r210 & 128) == 0) goto L33;
            Long r108 = null;
        L35:
            if ((r210 & 256) != 0) goto L38;
            r100 = r118;
        L38:
            this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
            return;
        L33:
            r108 = r117;
            goto L35
        L29:
            r107 = r116;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard$Extra;", "", "recommendInfo", "", "(Ljava/lang/String;)V", "getRecommendInfo", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Extra {

        @SerializedName(a.KEY_RECOMMEND_INFO)
        private final String recommendInfo;

        /* JADX WARN: Multi-variable type inference failed */
        public Extra() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Extra copy$default(Extra r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.recommendInfo;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.recommendInfo;
        }

        public final Extra copy(String r100) {
            return new Extra(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Extra) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.recommendInfo, ((Extra) r100).recommendInfo) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r100 = this.recommendInfo;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "Extra(recommendInfo=" + this.recommendInfo + ")";
        }

        public final String getRecommendInfo() {
            return this.recommendInfo;
        }

        public Extra(String r100) {
            this.recommendInfo = r100;
        }

        public /* synthetic */ Extra(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    public ECCommonCard() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECCommonCard copy$default(ECCommonCard r110, String r111, WysiwygParam r112, Integer r113, ECProductStruct r114, ECUserStruct r115, ECLiveStruct r116, Coupon4Activity r117, Integer r210, Extra r211, ChannelVO.Data.EntrancePit r212, Map r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.tagUrl;
    L7:
        if ((r214 & 2) == 0) goto L9;
        WysiwygParam r101 = r110.wysiwygParam;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r102 = r110.type;
    L15:
        if ((r214 & 8) == 0) goto L17;
        ECProductStruct r103 = r110.product;
    L19:
        if ((r214 & 16) == 0) goto L21;
        ECUserStruct r104 = r110.user;
    L23:
        if ((r214 & 32) == 0) goto L25;
        ECLiveStruct r105 = r110.live;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Coupon4Activity r106 = r110.coupon;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Integer r107 = r110.position;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Extra r118 = r110.extra;
    L39:
        if ((r214 & 512) == 0) goto L41;
        ChannelVO.Data.EntrancePit r119 = r110.entrancePit;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Map r108 = r110.animItems;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.tagUrl;
    }

    public final ChannelVO.Data.EntrancePit component10() {
        return this.entrancePit;
    }

    public final Map<Integer, AnimItem> component11() {
        return this.animItems;
    }

    public final WysiwygParam component2() {
        return this.wysiwygParam;
    }

    public final Integer component3() {
        return this.type;
    }

    public final ECProductStruct component4() {
        return this.product;
    }

    public final ECUserStruct component5() {
        return this.user;
    }

    public final ECLiveStruct component6() {
        return this.live;
    }

    public final Coupon4Activity component7() {
        return this.coupon;
    }

    public final Integer component8() {
        return this.position;
    }

    public final Extra component9() {
        return this.extra;
    }

    public final ECCommonCard copy(String r110, WysiwygParam r111, Integer r112, ECProductStruct r113, ECUserStruct r114, ECLiveStruct r115, Coupon4Activity r210, Integer r211, Extra r212, ChannelVO.Data.EntrancePit r213, Map<Integer, AnimItem> r214) {
        Intrinsics.checkNotNullParameter(r214, "animItems");
        return new ECCommonCard(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECCommonCard) == false) goto L28;
        ECCommonCard r101 = (ECCommonCard) r100;
        if (Intrinsics.areEqual(this.tagUrl, r101.tagUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.wysiwygParam, r101.wysiwygParam) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.product, r101.product) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.user, r101.user) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.live, r101.live) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.coupon, r101.coupon) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.entrancePit, r101.entrancePit) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.animItems, r101.animItems) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        String r100 = this.tagUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        WysiwygParam r104 = this.wysiwygParam;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.type;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECProductStruct r110 = this.product;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ECUserStruct r113 = this.user;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ECLiveStruct r116 = this.live;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Coupon4Activity r119 = this.coupon;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.position;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Extra r125 = this.extra;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        ChannelVO.Data.EntrancePit r128 = this.entrancePit;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Map<Integer, AnimItem> r131 = this.animItems;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECCommonCard(tagUrl=" + this.tagUrl + ", wysiwygParam=" + this.wysiwygParam + ", type=" + this.type + ", product=" + this.product + ", user=" + this.user + ", live=" + this.live + ", coupon=" + this.coupon + ", position=" + this.position + ", extra=" + this.extra + ", entrancePit=" + this.entrancePit + ", animItems=" + this.animItems + ")";
    }

    public final String recommendFromItem() {
        ECProductStruct r100 = this.product;
        if (r100 == null) goto L5;
        String r101 = r100.getRecommendInfo();
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L19;
        Extra r103 = this.extra;
        if (r103 == null) goto L17;
        String r104 = r103.getRecommendInfo();
        if (r104 == null) goto L17;
        return r104;
    L17:
        return "";
    L19:
        return r101;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public final Map<Integer, AnimItem> getAnimItems() {
        return this.animItems;
    }

    public final Coupon4Activity getCoupon() {
        return this.coupon;
    }

    public final ChannelVO.Data.EntrancePit getEntrancePit() {
        return this.entrancePit;
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final ECLiveStruct getLive() {
        return this.live;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final ECProductStruct getProduct() {
        return this.product;
    }

    public final String getTagUrl() {
        return this.tagUrl;
    }

    public final Integer getType() {
        return this.type;
    }

    public final ECUserStruct getUser() {
        return this.user;
    }

    public final WysiwygParam getWysiwygParam() {
        return this.wysiwygParam;
    }

    public ECCommonCard(String r100, WysiwygParam r101, Integer r102, ECProductStruct r103, ECUserStruct r104, ECLiveStruct r105, Coupon4Activity r106, Integer r107, Extra r110, ChannelVO.Data.EntrancePit r111, Map<Integer, AnimItem> r112) {
        Intrinsics.checkNotNullParameter(r112, "animItems");
        this.tagUrl = r100;
        this.wysiwygParam = r101;
        this.type = r102;
        this.product = r103;
        this.user = r104;
        this.live = r105;
        this.coupon = r106;
        this.position = r107;
        this.extra = r110;
        this.entrancePit = r111;
        this.animItems = r112;
    }

    public /* synthetic */ ECCommonCard(String r110, WysiwygParam r111, Integer r112, ECProductStruct r113, ECUserStruct r114, ECLiveStruct r115, Coupon4Activity r116, Integer r210, Extra r211, ChannelVO.Data.EntrancePit r212, Map r213, int r214, DefaultConstructorMarker r215) {
        ChannelVO.Data.EntrancePit r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        WysiwygParam r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        ECProductStruct r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        ECUserStruct r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        ECLiveStruct r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Coupon4Activity r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Extra r117 = null;
    L39:
        if ((r214 & 512) != 0) goto L43;
        r100 = r212;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Map r109 = new LinkedHashMap();
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r100, r109);
        return;
    L45:
        r109 = r213;
        goto L46
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
