package cg3;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\rR\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\rR\u001c\u0010'\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\rR\"\u0010*\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010$R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lcg3/f;", "", "", "orderId", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "productId", ce.f26391f, "", "content", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "rankShop", "l", "rankLogistic", ce.f26396k, "rankGood", ce.f26395j, "photos", "e", "videos", "p", "isAnonymous", "q", "contentCount", "b", "price", "f", SalesInfoStruct.SALES, "m", "", "productImages", "Ljava/util/List;", "h", "()Ljava/util/List;", "productTitle", RXScreenCaptureService.KEY_INDEX, "topic", OfficeSDKRequestTag.KEY_NEW_USER, "", "topicV2", "o", "", "fromReasonSelect", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("content")
    private final String content;

    @SerializedName("content_count")
    private final Long contentCount;

    @SerializedName("from_reason_select")
    private final Boolean fromReasonSelect;

    @SerializedName("anonymous")
    private final Long isAnonymous;

    @SerializedName("order_id")
    private final Long orderId;

    @SerializedName("photos")
    private final String photos;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_PRICE)
    private final String price;

    @SerializedName("product_id")
    private final Long productId;

    @SerializedName("product_images")
    private final List<String> productImages;

    @SerializedName("product_title")
    private final String productTitle;

    @SerializedName("rank_good")
    private final Long rankGood;

    @SerializedName("rank_logistic")
    private final Long rankLogistic;

    @SerializedName("rank_shop")
    private final Long rankShop;

    @SerializedName("product_sales")
    private final String sales;

    @SerializedName("topic")
    private final String topic;

    @SerializedName("topic_v2")
    private final List<String> topicV2;

    @SerializedName("videos")
    private final String videos;

    public f() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071);
    }

    public final String a() {
        return this.content;
    }

    public final Long b() {
        return this.contentCount;
    }

    public final Boolean c() {
        return this.fromReasonSelect;
    }

    public final Long d() {
        return this.orderId;
    }

    public final String e() {
        return this.photos;
    }

    public final String f() {
        return this.price;
    }

    public final Long g() {
        return this.productId;
    }

    public final List<String> h() {
        return this.productImages;
    }

    public final String i() {
        return this.productTitle;
    }

    public final Long j() {
        return this.rankGood;
    }

    public final Long k() {
        return this.rankLogistic;
    }

    public final Long l() {
        return this.rankShop;
    }

    public final String m() {
        return this.sales;
    }

    public final String n() {
        return this.topic;
    }

    public final List<String> o() {
        return this.topicV2;
    }

    public final String p() {
        return this.videos;
    }

    public final Long q() {
        return this.isAnonymous;
    }

    public f(Long r110, Long r111, String r210, Long r211, Long r212, Long r213, String r214, String r215, Long r216, Long r217, String r218, String r219, List r310, String r311, int r312) {
        if ((r312 & 1) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r312 & 2) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r312 & 8) == 0) goto L17;
        Long r103 = null;
    L19:
        if ((r312 & 16) == 0) goto L21;
        Long r104 = null;
    L23:
        if ((r312 & 32) == 0) goto L25;
        Long r105 = null;
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r112 = null;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Long r113 = 0L;
    L39:
        if ((r312 & 512) == 0) goto L41;
        Long r114 = 0L;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        String r116 = null;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        List r117 = null;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r312 & 65536) == 0) goto L61;
        Boolean r108 = Boolean.FALSE;
    L62:
        this.orderId = r100;
        this.productId = r101;
        this.content = r102;
        this.rankShop = r103;
        this.rankLogistic = r104;
        this.rankGood = r105;
        this.photos = r106;
        this.videos = r112;
        this.isAnonymous = r113;
        this.contentCount = r114;
        this.price = r115;
        this.sales = r116;
        this.productImages = r117;
        this.productTitle = r107;
        this.topic = null;
        this.topicV2 = null;
        this.fromReasonSelect = r108;
        return;
    L61:
        r108 = null;
        goto L62
    L57:
        r107 = r311;
        goto L59
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r112 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
