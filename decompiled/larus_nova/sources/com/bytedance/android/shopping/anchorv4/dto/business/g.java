package com.bytedance.android.shopping.anchorv4.dto.business;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010,\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/g;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "title", "getTitle", SocialConstants.PARAM_APP_DESC, "getDesc", "Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/f;", "price", "Lcom/bytedance/android/shopping/anchorv4/dto/business/f;", "c", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/f;", "link", "b", "promotionId", "getPromotionId", "", "kolIdInt", "Ljava/lang/Long;", "getKolIdInt", "()Ljava/lang/Long;", "secKolId", "getSecKolId", "recommendInfo", "getRecommendInfo", "productId", "d", "kolId", "getKolId", "", "icons", "Ljava/util/List;", "getIcons", "()Ljava/util/List;", "", "promotionSource", "Ljava/lang/Integer;", "getPromotionSource", "()Ljava/lang/Integer;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("icons")
    private final List<ECUrlModel> icons;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f166520id;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_KOL_ID)
    private final String kolId;

    @SerializedName("kol_id_int")
    private final Long kolIdInt;

    @SerializedName("link")
    private final String link;

    @SerializedName("price")
    private final f price;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    private final Integer promotionSource;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    private final String recommendInfo;

    @SerializedName("sec_kol_id")
    private final String secKolId;

    @SerializedName("title")
    private final String title;

    public g() {
        this.f166520id = "";
        this.title = "";
        this.desc = "";
        this.link = "";
        this.promotionId = "";
        this.kolIdInt = 0L;
        this.secKolId = "";
        this.recommendInfo = "";
        this.productId = "";
        this.kolId = "";
    }

    public final ECUrlModel a() {
        return this.cover;
    }

    public final String b() {
        return this.link;
    }

    public final f c() {
        return this.price;
    }

    public final String d() {
        return this.productId;
    }
}
