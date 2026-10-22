package com.bytedance.android.livesdk.livecommerce.promotion.card;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b1\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/PromotionCardModuleName;", "", "", TextureRenderKeys.KEY_MODULE_NAME, "Ljava/lang/String;", "getModuleName", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Title", "TitleTag", "ImageAreaIndex", "ImageAreaBottomTip", "ImageAreaStatusTag", "ImageAreaFlickerIcon", "ImageAreaExplainingBar", "ImageAreaExplainingBarTip", "ImageAreaExplainingBarAnim", "ImageAreaModule", "InfoAreaModule", "InfoAreaInnerModule", "InfoAreaSalePointModule", "InfoAreaUserRightLabelModule", "InfoAreaBenefitLabelModule", "InfoAreaBenefitLabelTextModule", "InfoAreaSecKillModule", "InfoAreaSecKillTextModule", "PriceAreaModule", "PriceAreaIntegerTextModule", "PriceAreaIntegerModule", "PriceAreaDecimalModule", "PriceAreaYuanModule", "PriceAreaPrefixModule", "PriceAreaSuffixModule", "OriginPriceAreaIntegerModule", "OriginPriceAreaDecimalModule", "OriginPriceAreaYuanModule", "OriginPriceAreaPrefixModule", "OriginPriceAreaSuffixModule", "DescPriceAreaModule", "ButtonAreaModule", "AddCartModule", "BuyModule", "BottomModule", "TopModule", "CloseModule", "Parent", "CardModule", "StepperIcon", "StepperLabel", "HotAtmosphere", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum PromotionCardModuleName extends Enum<PromotionCardModuleName> {

    @SerializedName("add_cart_module")
    public static final PromotionCardModuleName AddCartModule = null;

    @SerializedName("bottom_module")
    public static final PromotionCardModuleName BottomModule = null;

    @SerializedName("button_area_module")
    public static final PromotionCardModuleName ButtonAreaModule = null;

    @SerializedName("buy_module")
    public static final PromotionCardModuleName BuyModule = null;

    @SerializedName("card_module")
    public static final PromotionCardModuleName CardModule = null;

    @SerializedName("close_module")
    public static final PromotionCardModuleName CloseModule = null;
    public static final a Companion = null;

    @SerializedName("desc_price_area_module")
    public static final PromotionCardModuleName DescPriceAreaModule = null;

    @SerializedName("hot_atmosphere")
    public static final PromotionCardModuleName HotAtmosphere = null;

    @SerializedName("image_area_bottom_tip")
    public static final PromotionCardModuleName ImageAreaBottomTip = null;

    @SerializedName("image_area_explaining_bar")
    public static final PromotionCardModuleName ImageAreaExplainingBar = null;

    @SerializedName("image_area_explaining_bar_anim")
    public static final PromotionCardModuleName ImageAreaExplainingBarAnim = null;

    @SerializedName("image_area_explaining_bar_tip")
    public static final PromotionCardModuleName ImageAreaExplainingBarTip = null;

    @SerializedName("image_flicker_icon")
    public static final PromotionCardModuleName ImageAreaFlickerIcon = null;

    @SerializedName("image_area_index")
    public static final PromotionCardModuleName ImageAreaIndex = null;

    @SerializedName("image_area_module")
    public static final PromotionCardModuleName ImageAreaModule = null;

    @SerializedName("image_area_status_tag")
    public static final PromotionCardModuleName ImageAreaStatusTag = null;

    @SerializedName("info_area_benefit_label_module")
    public static final PromotionCardModuleName InfoAreaBenefitLabelModule = null;

    @SerializedName("info_area_benefit_label_text_module")
    public static final PromotionCardModuleName InfoAreaBenefitLabelTextModule = null;

    @SerializedName("info_area_inner_module")
    public static final PromotionCardModuleName InfoAreaInnerModule = null;

    @SerializedName("info_area_module")
    public static final PromotionCardModuleName InfoAreaModule = null;

    @SerializedName("info_area_sale_point_module")
    public static final PromotionCardModuleName InfoAreaSalePointModule = null;

    @SerializedName("info_area_seckill_module")
    public static final PromotionCardModuleName InfoAreaSecKillModule = null;

    @SerializedName("info_area_seckill_text_module")
    public static final PromotionCardModuleName InfoAreaSecKillTextModule = null;

    @SerializedName("info_area_user_right_label_module")
    public static final PromotionCardModuleName InfoAreaUserRightLabelModule = null;

    @SerializedName("origin_price_area_decimal_module")
    public static final PromotionCardModuleName OriginPriceAreaDecimalModule = null;

    @SerializedName("origin_price_area_integer_module")
    public static final PromotionCardModuleName OriginPriceAreaIntegerModule = null;

    @SerializedName("origin_price_area_prefix_module")
    public static final PromotionCardModuleName OriginPriceAreaPrefixModule = null;

    @SerializedName("origin_price_area_suffix_module")
    public static final PromotionCardModuleName OriginPriceAreaSuffixModule = null;

    @SerializedName("origin_price_area_yuan_module")
    public static final PromotionCardModuleName OriginPriceAreaYuanModule = null;

    @SerializedName("parent")
    public static final PromotionCardModuleName Parent = null;

    @SerializedName("price_area_decimal_module")
    public static final PromotionCardModuleName PriceAreaDecimalModule = null;

    @SerializedName("price_area_integer_module")
    public static final PromotionCardModuleName PriceAreaIntegerModule = null;

    @SerializedName("price_area_integer_text_module")
    public static final PromotionCardModuleName PriceAreaIntegerTextModule = null;

    @SerializedName("price_area_module")
    public static final PromotionCardModuleName PriceAreaModule = null;

    @SerializedName("price_area_prefix_module")
    public static final PromotionCardModuleName PriceAreaPrefixModule = null;

    @SerializedName("price_area_suffix_module")
    public static final PromotionCardModuleName PriceAreaSuffixModule = null;

    @SerializedName("price_area_yuan_module")
    public static final PromotionCardModuleName PriceAreaYuanModule = null;

    @SerializedName("stepper_icon")
    public static final PromotionCardModuleName StepperIcon = null;

    @SerializedName("stepper_label")
    public static final PromotionCardModuleName StepperLabel = null;

    @SerializedName("title")
    public static final PromotionCardModuleName Title = null;

    @SerializedName("title_tag")
    public static final PromotionCardModuleName TitleTag = null;

    @SerializedName("top_module")
    public static final PromotionCardModuleName TopModule = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PromotionCardModuleName[] f150032a = null;
    private final String moduleName;

    public static final class a {
        public a() {
        }

        public static PromotionCardModuleName a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            PromotionCardModuleName[] r101 = PromotionCardModuleName.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            PromotionCardModuleName r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getModuleName(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L12;
            return r104;
        L12:
            throw new IllegalArgumentException("No enum constant " + r100);
        L8:
            r104 = null;
            goto L9
        }
    }

    public static PromotionCardModuleName valueOf(String r100) {
        return (PromotionCardModuleName) r27.a.a(PromotionCardModuleName.class, r100);
    }

    public static PromotionCardModuleName[] values() {
        return (PromotionCardModuleName[]) f150032a.clone();
    }

    static {
        PromotionCardModuleName r100 = new PromotionCardModuleName("Title", 0, "title");
        Title = r100;
        PromotionCardModuleName r101 = new PromotionCardModuleName("TitleTag", 1, "title_tag");
        TitleTag = r101;
        PromotionCardModuleName r102 = new PromotionCardModuleName("ImageAreaIndex", 2, "image_area_index");
        ImageAreaIndex = r102;
        PromotionCardModuleName r103 = new PromotionCardModuleName("ImageAreaBottomTip", 3, "image_area_bottom_tip");
        ImageAreaBottomTip = r103;
        PromotionCardModuleName r104 = new PromotionCardModuleName("ImageAreaStatusTag", 4, "image_area_status_tag");
        ImageAreaStatusTag = r104;
        PromotionCardModuleName r105 = new PromotionCardModuleName("ImageAreaFlickerIcon", 5, "image_flicker_icon");
        ImageAreaFlickerIcon = r105;
        PromotionCardModuleName r106 = new PromotionCardModuleName("ImageAreaExplainingBar", 6, "image_area_explaining_bar");
        ImageAreaExplainingBar = r106;
        PromotionCardModuleName r107 = new PromotionCardModuleName("ImageAreaExplainingBarTip", 7, "image_area_explaining_bar_tip");
        ImageAreaExplainingBarTip = r107;
        PromotionCardModuleName r108 = new PromotionCardModuleName("ImageAreaExplainingBarAnim", 8, "image_area_explaining_bar_anim");
        ImageAreaExplainingBarAnim = r108;
        PromotionCardModuleName r109 = new PromotionCardModuleName("ImageAreaModule", 9, "image_area_module");
        ImageAreaModule = r109;
        PromotionCardModuleName r110 = new PromotionCardModuleName("InfoAreaModule", 10, "info_area_module");
        InfoAreaModule = r110;
        PromotionCardModuleName r111 = new PromotionCardModuleName("InfoAreaInnerModule", 11, "info_area_inner_module");
        InfoAreaInnerModule = r111;
        PromotionCardModuleName r112 = new PromotionCardModuleName("InfoAreaSalePointModule", 12, "info_area_sale_point_module");
        InfoAreaSalePointModule = r112;
        PromotionCardModuleName r113 = new PromotionCardModuleName("InfoAreaUserRightLabelModule", 13, "info_area_user_right_label_module");
        InfoAreaUserRightLabelModule = r113;
        PromotionCardModuleName r114 = new PromotionCardModuleName("InfoAreaBenefitLabelModule", 14, "info_area_benefit_label_module");
        InfoAreaBenefitLabelModule = r114;
        PromotionCardModuleName r115 = new PromotionCardModuleName("InfoAreaBenefitLabelTextModule", 15, "info_area_benefit_label_text_module");
        InfoAreaBenefitLabelTextModule = r115;
        PromotionCardModuleName r116 = new PromotionCardModuleName("InfoAreaSecKillModule", 16, "info_area_seckill_module");
        InfoAreaSecKillModule = r116;
        PromotionCardModuleName r117 = new PromotionCardModuleName("InfoAreaSecKillTextModule", 17, "info_area_seckill_text_module");
        InfoAreaSecKillTextModule = r117;
        PromotionCardModuleName r118 = new PromotionCardModuleName("PriceAreaModule", 18, "price_area_module");
        PriceAreaModule = r118;
        PromotionCardModuleName r119 = new PromotionCardModuleName("PriceAreaIntegerTextModule", 19, "price_area_integer_text_module");
        PriceAreaIntegerTextModule = r119;
        PromotionCardModuleName r120 = new PromotionCardModuleName("PriceAreaIntegerModule", 20, "price_area_integer_module");
        PriceAreaIntegerModule = r120;
        PromotionCardModuleName r121 = new PromotionCardModuleName("PriceAreaDecimalModule", 21, "price_area_decimal_module");
        PriceAreaDecimalModule = r121;
        PromotionCardModuleName r122 = new PromotionCardModuleName("PriceAreaYuanModule", 22, "price_area_yuan_module");
        PriceAreaYuanModule = r122;
        PromotionCardModuleName r123 = new PromotionCardModuleName("PriceAreaPrefixModule", 23, "price_area_prefix_module");
        PriceAreaPrefixModule = r123;
        PromotionCardModuleName r124 = new PromotionCardModuleName("PriceAreaSuffixModule", 24, "price_area_suffix_module");
        PriceAreaSuffixModule = r124;
        PromotionCardModuleName r125 = new PromotionCardModuleName("OriginPriceAreaIntegerModule", 25, "origin_price_area_integer_module");
        OriginPriceAreaIntegerModule = r125;
        PromotionCardModuleName r126 = new PromotionCardModuleName("OriginPriceAreaDecimalModule", 26, "origin_price_area_decimal_module");
        OriginPriceAreaDecimalModule = r126;
        PromotionCardModuleName r127 = new PromotionCardModuleName("OriginPriceAreaYuanModule", 27, "origin_price_area_yuan_module");
        OriginPriceAreaYuanModule = r127;
        PromotionCardModuleName r128 = new PromotionCardModuleName("OriginPriceAreaPrefixModule", 28, "origin_price_area_prefix_module");
        OriginPriceAreaPrefixModule = r128;
        PromotionCardModuleName r129 = new PromotionCardModuleName("OriginPriceAreaSuffixModule", 29, "origin_price_area_suffix_module");
        OriginPriceAreaSuffixModule = r129;
        PromotionCardModuleName r130 = new PromotionCardModuleName("DescPriceAreaModule", 30, "desc_price_area_module");
        DescPriceAreaModule = r130;
        PromotionCardModuleName r131 = new PromotionCardModuleName("ButtonAreaModule", 31, "button_area_module");
        ButtonAreaModule = r131;
        PromotionCardModuleName r132 = new PromotionCardModuleName("AddCartModule", 32, "add_cart_module");
        AddCartModule = r132;
        PromotionCardModuleName r133 = new PromotionCardModuleName("BuyModule", 33, "buy_module");
        BuyModule = r133;
        PromotionCardModuleName r134 = new PromotionCardModuleName("BottomModule", 34, "bottom_module");
        BottomModule = r134;
        PromotionCardModuleName r135 = new PromotionCardModuleName("TopModule", 35, "top_module");
        TopModule = r135;
        PromotionCardModuleName r136 = new PromotionCardModuleName("CloseModule", 36, "close_module");
        CloseModule = r136;
        PromotionCardModuleName r137 = new PromotionCardModuleName("Parent", 37, "parent");
        Parent = r137;
        PromotionCardModuleName r138 = new PromotionCardModuleName("CardModule", 38, "card_module");
        CardModule = r138;
        PromotionCardModuleName r139 = new PromotionCardModuleName("StepperIcon", 39, "stepper_icon");
        StepperIcon = r139;
        PromotionCardModuleName r140 = new PromotionCardModuleName("StepperLabel", 40, "stepper_label");
        StepperLabel = r140;
        PromotionCardModuleName r141 = new PromotionCardModuleName("HotAtmosphere", 41, "hot_atmosphere");
        HotAtmosphere = r141;
        f150032a = new PromotionCardModuleName[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141};
        Companion = new a();
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public PromotionCardModuleName(String r100, int r101, String r102) {
        super(r100, r101);
        this.moduleName = r102;
    }
}
