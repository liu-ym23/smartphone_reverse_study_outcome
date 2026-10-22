package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.bytedance.android.ec.store.repository.vo.AuthorReputationVO;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR$\u0010*\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR$\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR*\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR*\u0010O\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010J\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR$\u0010R\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u000b\u001a\u0004\bS\u0010\r\"\u0004\bT\u0010\u000fR$\u0010V\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010d\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010k\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR$\u0010q\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010\u0004\u001a\u0004\br\u0010\u0006\"\u0004\bs\u0010\bR0\u0010v\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020u\u0018\u00010t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R'\u0010}\u001a\u0004\u0018\u00010|8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001¨\u0006\u0085\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreHeaderBaseInfoVO;", "Ljava/io/Serializable;", "", "shopId", "Ljava/lang/String;", "getShopId", "()Ljava/lang/String;", "setShopId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "shopLogo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getShopLogo", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setShopLogo", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "shopName", "getShopName", "setShopName", "brandTag", "getBrandTag", "setBrandTag", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "reputationDTO", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "getReputationDTO", "()Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "setReputationDTO", "(Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;)V", "Lcom/bytedance/android/ec/store/repository/vo/AuthorReputationVO;", "reputationVO", "Lcom/bytedance/android/ec/store/repository/vo/AuthorReputationVO;", "getReputationVO", "()Lcom/bytedance/android/ec/store/repository/vo/AuthorReputationVO;", "setReputationVO", "(Lcom/bytedance/android/ec/store/repository/vo/AuthorReputationVO;)V", "authorId", "getAuthorId", "setAuthorId", "secAuthorId", "getSecAuthorId", "setSecAuthorId", "authorAvatar", "getAuthorAvatar", "setAuthorAvatar", "authorNickName", "getAuthorNickName", "setAuthorNickName", "Lsj3/b;", "topListDTO", "Lsj3/b;", "getTopListDTO", "()Lsj3/b;", "setTopListDTO", "(Lsj3/b;)V", "Lcom/bytedance/android/shopping/store/home/entity/v;", "shopDisplayName", "Lcom/bytedance/android/shopping/store/home/entity/v;", "getShopDisplayName", "()Lcom/bytedance/android/shopping/store/home/entity/v;", "setShopDisplayName", "(Lcom/bytedance/android/shopping/store/home/entity/v;)V", "Luj3/b;", "topListVO", "Luj3/b;", "getTopListVO", "()Luj3/b;", "setTopListVO", "(Luj3/b;)V", "fansCount", "getFansCount", "setFansCount", "", "fansCountText", "Ljava/util/List;", "getFansCountText", "()Ljava/util/List;", "setFansCountText", "(Ljava/util/List;)V", "tagList", "getTagList", "setTagList", "shopLogoIcon", "getShopLogoIcon", "setShopLogoIcon", "Lcom/bytedance/android/ec/model/o;", "shopXZGInfo", "Lcom/bytedance/android/ec/model/o;", "getShopXZGInfo", "()Lcom/bytedance/android/ec/model/o;", "setShopXZGInfo", "(Lcom/bytedance/android/ec/model/o;)V", "Lcom/bytedance/android/shopping/store/home/entity/ShopSocialInfo;", "shopSocialInfo", "Lcom/bytedance/android/shopping/store/home/entity/ShopSocialInfo;", "getShopSocialInfo", "()Lcom/bytedance/android/shopping/store/home/entity/ShopSocialInfo;", "setShopSocialInfo", "(Lcom/bytedance/android/shopping/store/home/entity/ShopSocialInfo;)V", "", "shopType", "Ljava/lang/Integer;", "getShopType", "()Ljava/lang/Integer;", "setShopType", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/shopping/store/home/entity/s;", "headerStyleConfig", "Lcom/bytedance/android/shopping/store/home/entity/s;", "getHeaderStyleConfig", "()Lcom/bytedance/android/shopping/store/home/entity/s;", "setHeaderStyleConfig", "(Lcom/bytedance/android/shopping/store/home/entity/s;)V", "shopTypeDescription", "getShopTypeDescription", "setShopTypeDescription", "", "Lcom/bytedance/android/shopping/store/home/entity/ShopValueInfoItem;", "shopValueInfo", "Ljava/util/Map;", "getShopValueInfo", "()Ljava/util/Map;", "setShopValueInfo", "(Ljava/util/Map;)V", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "tagV2List", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "getTagV2List", "()Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "setTagV2List", "(Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHeaderBaseInfoVO implements Serializable {

    @SerializedName("avatar_medium")
    private ECUrlModel authorAvatar;

    @SerializedName("user_id")
    private String authorId;

    @SerializedName("nick_name")
    private String authorNickName;

    @SerializedName("brand_tag")
    private ECUrlModel brandTag;

    @SerializedName("fans_count")
    private String fansCount;

    @SerializedName("fans_count_text")
    private List<String> fansCountText;

    @SerializedName("header_style_config")
    private s headerStyleConfig;

    @SerializedName("reputation")
    private AuthorReputationDTO reputationDTO;
    private AuthorReputationVO reputationVO;

    @SerializedName("sec_author_id")
    private String secAuthorId;

    @SerializedName("shop_display_name")
    private v shopDisplayName;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private String shopId;

    @SerializedName("shop_logo")
    private ECUrlModel shopLogo;

    @SerializedName("shop_logo_icon")
    private ECUrlModel shopLogoIcon;

    @SerializedName("shop_name")
    private String shopName;

    @SerializedName("shop_social_info")
    private ShopSocialInfo shopSocialInfo;

    @SerializedName("shop_type")
    private Integer shopType;

    @SerializedName("shop_type_description")
    private String shopTypeDescription;

    @SerializedName("value_info")
    private Map<String, ShopValueInfoItem> shopValueInfo;

    @SerializedName("shop_xzg_info")
    private com.bytedance.android.ec.model.o shopXZGInfo;

    @SerializedName("tag_list")
    private List<? extends ECUrlModel> tagList;

    @SerializedName("tag_v2_list")
    private ECTagListDTO tagV2List;

    @SerializedName("shop_list_info")
    private sj3.b topListDTO;
    private uj3.b topListVO;

    public ECStoreHeaderBaseInfoVO() {
    }

    public final ECUrlModel getAuthorAvatar() {
        return this.authorAvatar;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAuthorNickName() {
        return this.authorNickName;
    }

    public final ECUrlModel getBrandTag() {
        return this.brandTag;
    }

    public final String getFansCount() {
        return this.fansCount;
    }

    public final List<String> getFansCountText() {
        return this.fansCountText;
    }

    public final s getHeaderStyleConfig() {
        return this.headerStyleConfig;
    }

    public final AuthorReputationDTO getReputationDTO() {
        return this.reputationDTO;
    }

    public final AuthorReputationVO getReputationVO() {
        return this.reputationVO;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final v getShopDisplayName() {
        return this.shopDisplayName;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final ECUrlModel getShopLogo() {
        return this.shopLogo;
    }

    public final ECUrlModel getShopLogoIcon() {
        return this.shopLogoIcon;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final ShopSocialInfo getShopSocialInfo() {
        return this.shopSocialInfo;
    }

    public final Integer getShopType() {
        return this.shopType;
    }

    public final String getShopTypeDescription() {
        return this.shopTypeDescription;
    }

    public final Map<String, ShopValueInfoItem> getShopValueInfo() {
        return this.shopValueInfo;
    }

    public final com.bytedance.android.ec.model.o getShopXZGInfo() {
        return this.shopXZGInfo;
    }

    public final List<ECUrlModel> getTagList() {
        return this.tagList;
    }

    public final ECTagListDTO getTagV2List() {
        return this.tagV2List;
    }

    public final sj3.b getTopListDTO() {
        return this.topListDTO;
    }

    public final uj3.b getTopListVO() {
        return this.topListVO;
    }

    public final void setAuthorAvatar(ECUrlModel r100) {
        this.authorAvatar = r100;
    }

    public final void setAuthorId(String r100) {
        this.authorId = r100;
    }

    public final void setAuthorNickName(String r100) {
        this.authorNickName = r100;
    }

    public final void setBrandTag(ECUrlModel r100) {
        this.brandTag = r100;
    }

    public final void setFansCount(String r100) {
        this.fansCount = r100;
    }

    public final void setFansCountText(List<String> r100) {
        this.fansCountText = r100;
    }

    public final void setHeaderStyleConfig(s r100) {
        this.headerStyleConfig = r100;
    }

    public final void setReputationDTO(AuthorReputationDTO r100) {
        this.reputationDTO = r100;
    }

    public final void setReputationVO(AuthorReputationVO r100) {
        this.reputationVO = r100;
    }

    public final void setSecAuthorId(String r100) {
        this.secAuthorId = r100;
    }

    public final void setShopDisplayName(v r100) {
        this.shopDisplayName = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setShopLogo(ECUrlModel r100) {
        this.shopLogo = r100;
    }

    public final void setShopLogoIcon(ECUrlModel r100) {
        this.shopLogoIcon = r100;
    }

    public final void setShopName(String r100) {
        this.shopName = r100;
    }

    public final void setShopSocialInfo(ShopSocialInfo r100) {
        this.shopSocialInfo = r100;
    }

    public final void setShopType(Integer r100) {
        this.shopType = r100;
    }

    public final void setShopTypeDescription(String r100) {
        this.shopTypeDescription = r100;
    }

    public final void setShopValueInfo(Map<String, ShopValueInfoItem> r100) {
        this.shopValueInfo = r100;
    }

    public final void setShopXZGInfo(com.bytedance.android.ec.model.o r100) {
        this.shopXZGInfo = r100;
    }

    public final void setTagList(List<? extends ECUrlModel> r100) {
        this.tagList = r100;
    }

    public final void setTagV2List(ECTagListDTO r100) {
        this.tagV2List = r100;
    }

    public final void setTopListDTO(sj3.b r100) {
        this.topListDTO = r100;
    }

    public final void setTopListVO(uj3.b r100) {
        this.topListVO = r100;
    }
}
