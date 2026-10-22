package com.bytedance.android.shopping.api.video;

import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b!\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/api/video/AVScene;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "subTag", "getSubTag", "setSubTag", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CONTENT_DEFAULT", "CONTENT_COMMENT_ITEM", "CONTENT_COMMENT_GALLERY", "CONTENT_PRODUCT_DETAIL_HEADER", "CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW", "CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW_OPT", "CONTENT_PD_LIVE_REPLAY_WINDOW", "CONTENT_PD_MORE_VIDEO_WINDOW", "CONTENT_PRODUCT_DETAIL_GALLERY", "CONTENT_PRODUCT_DETAIL_MEDIA_BOX", "CONTENT_BUYER_SHOW", "CONTENT_LIVE_REPLAY", "SHOP_DEFAULT", "WINDOW_RESERVED", "WINDOW_INNER_FLOW", "SHOP_HEADER", "MALL_PRODUCT_INFLOW_LIVE_REPLAY", "PDP_HEADER_KOL", "PDP_HEADER_KOL_OPT", "MALL", "MALL_HEVC", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AVScene extends Enum<AVScene> {
    public static final AVScene CONTENT_BUYER_SHOW = null;
    public static final AVScene CONTENT_COMMENT_GALLERY = null;
    public static final AVScene CONTENT_COMMENT_ITEM = null;
    public static final AVScene CONTENT_DEFAULT = null;
    public static final AVScene CONTENT_LIVE_REPLAY = null;
    public static final AVScene CONTENT_PD_LIVE_REPLAY_WINDOW = null;
    public static final AVScene CONTENT_PD_MORE_VIDEO_WINDOW = null;
    public static final AVScene CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW = null;
    public static final AVScene CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW_OPT = null;
    public static final AVScene CONTENT_PRODUCT_DETAIL_GALLERY = null;
    public static final AVScene CONTENT_PRODUCT_DETAIL_HEADER = null;
    public static final AVScene CONTENT_PRODUCT_DETAIL_MEDIA_BOX = null;
    public static final a Companion = null;
    public static final AVScene MALL = null;
    public static final AVScene MALL_HEVC = null;
    public static final AVScene MALL_PRODUCT_INFLOW_LIVE_REPLAY = null;
    public static final AVScene PDP_HEADER_KOL = null;
    public static final AVScene PDP_HEADER_KOL_OPT = null;
    public static final AVScene SHOP_DEFAULT = null;
    public static final AVScene SHOP_HEADER = null;
    public static final AVScene WINDOW_INNER_FLOW = null;
    public static final AVScene WINDOW_RESERVED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AVScene[] f170615a = null;
    private String subTag;
    private String tag;

    public static final class a {
        public a() {
        }
    }

    public static AVScene valueOf(String r100) {
        return (AVScene) r27.a.a(AVScene.class, r100);
    }

    public static AVScene[] values() {
        return (AVScene[]) f170615a.clone();
    }

    static {
        AVScene r100 = new AVScene("CONTENT_DEFAULT", 0, "ecom_content", "default");
        CONTENT_DEFAULT = r100;
        AVScene r101 = new AVScene("CONTENT_COMMENT_ITEM", 1, "ecom_content", "comment_item");
        CONTENT_COMMENT_ITEM = r101;
        AVScene r102 = new AVScene("CONTENT_COMMENT_GALLERY", 2, "ecom_content", "comment_gallery");
        CONTENT_COMMENT_GALLERY = r102;
        AVScene r103 = new AVScene("CONTENT_PRODUCT_DETAIL_HEADER", 3, "ecom_content", "product_detail_header");
        CONTENT_PRODUCT_DETAIL_HEADER = r103;
        AVScene r104 = new AVScene("CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW", 4, "ecom_content", "product_detail_float_window");
        CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW = r104;
        AVScene r105 = new AVScene("CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW_OPT", 5, "ecom_content", "product_detail_float_window_opt");
        CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW_OPT = r105;
        AVScene r106 = new AVScene("CONTENT_PD_LIVE_REPLAY_WINDOW", 6, "ecom_content", "product_detail_replay_float");
        CONTENT_PD_LIVE_REPLAY_WINDOW = r106;
        AVScene r107 = new AVScene("CONTENT_PD_MORE_VIDEO_WINDOW", 7, "ecom_content", "product_detail_more_video");
        CONTENT_PD_MORE_VIDEO_WINDOW = r107;
        AVScene r108 = new AVScene("CONTENT_PRODUCT_DETAIL_GALLERY", 8, "ecom_content", "product_detail_gallery");
        CONTENT_PRODUCT_DETAIL_GALLERY = r108;
        AVScene r109 = new AVScene("CONTENT_PRODUCT_DETAIL_MEDIA_BOX", 9, "ecom_content", "product_detail_media_box");
        CONTENT_PRODUCT_DETAIL_MEDIA_BOX = r109;
        AVScene r110 = new AVScene("CONTENT_BUYER_SHOW", 10, "ecom_content", "buyer_show");
        CONTENT_BUYER_SHOW = r110;
        AVScene r111 = new AVScene("CONTENT_LIVE_REPLAY", 11, "ecom_content", PaidReplayConstants.VALUE_FROM_CONTENT_TYPE);
        CONTENT_LIVE_REPLAY = r111;
        AVScene r112 = new AVScene("SHOP_DEFAULT", 12, "shop", "default");
        SHOP_DEFAULT = r112;
        AVScene r113 = new AVScene("WINDOW_RESERVED", 13, LiveEndPageData.TAG_WINDOW, PromotionDepositPresaleActivity.RESERVED);
        WINDOW_RESERVED = r113;
        AVScene r114 = new AVScene("WINDOW_INNER_FLOW", 14, LiveEndPageData.TAG_WINDOW, "inner_flow");
        WINDOW_INNER_FLOW = r114;
        AVScene r115 = new AVScene("SHOP_HEADER", 15, "shop", "header");
        SHOP_HEADER = r115;
        AVScene r116 = new AVScene("MALL_PRODUCT_INFLOW_LIVE_REPLAY", 16, "mall", "mall_product_inflow_live_replay");
        MALL_PRODUCT_INFLOW_LIVE_REPLAY = r116;
        AVScene r117 = new AVScene("PDP_HEADER_KOL", 17, "ecom_content", "product_detail_header_kol");
        PDP_HEADER_KOL = r117;
        AVScene r118 = new AVScene("PDP_HEADER_KOL_OPT", 18, "ecom_content", "product_detail_header_kol_opt");
        PDP_HEADER_KOL_OPT = r118;
        AVScene r119 = new AVScene("MALL", 19, "mall", "mall_native");
        MALL = r119;
        AVScene r120 = new AVScene("MALL_HEVC", 20, "mall", "mall_native_hevc");
        MALL_HEVC = r120;
        f170615a = new AVScene[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120};
        Companion = new a();
    }

    public final String getSubTag() {
        return this.subTag;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setSubTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subTag = r100;
    }

    public final void setTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tag = r100;
    }

    public AVScene(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.tag = r102;
        this.subTag = r103;
    }
}
