package com.bytedance.android.shopping.store.aggregate;

import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.shopping.store.aggregate.classification.CategoryInfo;
import com.bytedance.android.shopping.store.home.api.StoreBaseParam;
import com.bytedance.android.shopping.store.home.entity.FansClubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b.\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010N\u001a\u00020\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\u0004R\u001e\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010'\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\u0004R\u001a\u0010-\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0007R\u001a\u00103\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001c\u00106\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\u0004R\u001a\u00109\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001a\"\u0004\b;\u0010\u001cR\u001a\u0010<\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001a\"\u0004\b>\u0010\u001cR\u001c\u0010?\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\u0004R\u001a\u0010B\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0007\"\u0004\bD\u0010\u0004R\u001c\u0010E\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0007\"\u0004\bG\u0010\u0004R\u001c\u0010H\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0007\"\u0004\bJ\u0010\u0004R\u001c\u0010K\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0007\"\u0004\bM\u0010\u0004¨\u0006O"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateParam;", "Lcom/bytedance/android/shopping/store/home/api/StoreBaseParam;", "secShopId", "", "(Ljava/lang/String;)V", "categoryId", "getCategoryId", "()Ljava/lang/String;", "setCategoryId", "categoryInfo", "Lcom/bytedance/android/shopping/store/aggregate/classification/CategoryInfo;", "getCategoryInfo", "()Lcom/bytedance/android/shopping/store/aggregate/classification/CategoryInfo;", "setCategoryInfo", "(Lcom/bytedance/android/shopping/store/aggregate/classification/CategoryInfo;)V", "categoryInfoStr", "getCategoryInfoStr", "setCategoryInfoStr", "classificationTabType", "getClassificationTabType", "setClassificationTabType", "entranceInfo", "getEntranceInfo", "setEntranceInfo", "isSplitMode", "", "()Z", "setSplitMode", "(Z)V", "metaInfo", "getMetaInfo", "setMetaInfo", "pageHeightPercent", "", "getPageHeightPercent", "()Ljava/lang/Integer;", "setPageHeightPercent", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "pageParams", "getPageParams", "setPageParams", "pageVersion", "getPageVersion", "setPageVersion", "productCnt", "getProductCnt", "()I", "setProductCnt", "(I)V", "getSecShopId", "selectIndex", "getSelectIndex", "setSelectIndex", "shopId", "getShopId", "setShopId", "showAddCart", "getShowAddCart", "setShowAddCart", "showCategoryTab", "getShowCategoryTab", "setShowCategoryTab", "sourceBtmToken", "getSourceBtmToken", "setSourceBtmToken", "tabLabel", "getTabLabel", "setTabLabel", "tabName", "getTabName", "setTabName", "tabNameSecond", "getTabNameSecond", "setTabNameSecond", "tagData", "getTagData", "setTagData", "deepCopy", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregateParam extends StoreBaseParam {
    private String categoryId;
    private CategoryInfo categoryInfo;
    private String categoryInfoStr;
    private String classificationTabType;
    private String entranceInfo;
    private boolean isSplitMode;
    private String metaInfo;
    private Integer pageHeightPercent;
    private String pageParams;
    private String pageVersion;
    private int productCnt;
    private final String secShopId;
    private int selectIndex;
    private String shopId;
    private boolean showAddCart;
    private boolean showCategoryTab;
    private String sourceBtmToken;
    private String tabLabel;
    private String tabName;
    private String tabNameSecond;
    private String tagData;

    public final ShopAggregateParam deepCopy() {
        ShopAggregateParam r100 = new ShopAggregateParam(this.secShopId);
        r100.shopId = this.shopId;
        r100.showAddCart = this.showAddCart;
        r100.metaInfo = this.metaInfo;
        r100.tabNameSecond = this.tabNameSecond;
        r100.tabName = this.tabName;
        r100.pageHeightPercent = this.pageHeightPercent;
        r100.pageParams = this.pageParams;
        r100.tagData = this.tagData;
        r100.selectIndex = this.selectIndex;
        r100.categoryInfoStr = this.categoryInfoStr;
        CategoryInfo r101 = this.categoryInfo;
        FansClubInfo r102 = null;
        if (r101 == null) goto L5;
        CategoryInfo r103 = r101.deepCopy();
    L6:
        r100.categoryInfo = r103;
        r100.showCategoryTab = this.showCategoryTab;
        r100.tabLabel = this.tabLabel;
        r100.categoryId = this.categoryId;
        r100.classificationTabType = this.classificationTabType;
        r100.pageVersion = this.pageVersion;
        r100.productCnt = this.productCnt;
        r100.sourceBtmToken = this.sourceBtmToken;
        r100.entranceInfo = this.entranceInfo;
        r100.getStoreAccountParam().copyFrom(getStoreAccountParam());
        r100.setTabId(getTabId());
        r100.setDebugUrl(getDebugUrl());
        r100.getProductBasicRequestParam().copyFrom(getProductBasicRequestParam());
        r100.getStoreUIParam().copyFrom(getStoreUIParam());
        r100.getShareInfo().copyFrom(getShareInfo());
        r100.getStoreNaviParam().copyFrom(getStoreNaviParam());
        r100.setFromProfile(getFromProfile());
        r100.getPassThroughParams().clear();
        r100.getPassThroughParams().putAll(getPassThroughParams());
        r100.setSearchHint(getSearchHint());
        r100.setStoreDetailUrl(getStoreDetailUrl());
        r100.setStoreHomePageUrl(getStoreHomePageUrl());
        r100.setSearchParams(getSearchParams());
        r100.setEnterFrom(getEnterFrom());
        r100.setPageName(getPageName());
        r100.setTaskType(getTaskType());
        r100.setBcm(getBcm());
        r100.setTaskEnterFrom(getTaskEnterFrom());
        r100.setTempId(getTempId());
        r100.setEnterMethod(getEnterMethod());
        r100.setEntranceLocation(getEntranceLocation());
        r100.setPageType(getPageType());
        ECAdLogExtra r104 = getAdLogExtra();
        if (r104 == null) goto L9;
        ECAdLogExtra r105 = r104.deepCopy();
    L10:
        r100.setAdLogExtra(r105);
        r100.setFollowStatus(getFollowStatus());
        FansClubInfo r106 = getFansInfo();
        if (r106 == null) goto L13;
        r102 = r106.deepCopy();
    L13:
        r100.setFansInfo(r102);
        r100.setWhichAccount(getWhichAccount());
        r100.setRoomId(getRoomId());
        r100.setAnchorId(getAnchorId());
        r100.setPreGroupId(getPreGroupId());
        r100.setPreProductId(getPreProductId());
        r100.setPreRoomId(getPreRoomId());
        r100.setStoreSourcePage(getStoreSourcePage());
        r100.setStoreSourceMethod(getStoreSourceMethod());
        r100.setStoreGroupType(getStoreGroupType());
        r100.setLiveAnchorId(getLiveAnchorId());
        r100.setPageFrom(getPageFrom());
        r100.setExtraSchema(getExtraSchema());
        r100.setEcShare(isEcShare());
        r100.setShareContent(getShareContent());
        r100.setShareObject(getShareObject());
        r100.setProductId(getProductId());
        r100.setModuleLabel(getModuleLabel());
        r100.setEnterStoreEvent(getEnterStoreEvent());
        r100.setEcomJsonStr(getEcomJsonStr());
        r100.setEcomPitayaJsonStr(getEcomPitayaJsonStr());
        r100.isSplitMode = this.isSplitMode;
        return r100;
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final CategoryInfo getCategoryInfo() {
        return this.categoryInfo;
    }

    public final String getCategoryInfoStr() {
        return this.categoryInfoStr;
    }

    public final String getClassificationTabType() {
        return this.classificationTabType;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getMetaInfo() {
        return this.metaInfo;
    }

    public final Integer getPageHeightPercent() {
        return this.pageHeightPercent;
    }

    public final String getPageParams() {
        return this.pageParams;
    }

    public final String getPageVersion() {
        return this.pageVersion;
    }

    public final int getProductCnt() {
        return this.productCnt;
    }

    public final String getSecShopId() {
        return this.secShopId;
    }

    public final int getSelectIndex() {
        return this.selectIndex;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean getShowAddCart() {
        return this.showAddCart;
    }

    public final boolean getShowCategoryTab() {
        return this.showCategoryTab;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final String getTabLabel() {
        return this.tabLabel;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getTabNameSecond() {
        return this.tabNameSecond;
    }

    public final String getTagData() {
        return this.tagData;
    }

    public final boolean isSplitMode() {
        return this.isSplitMode;
    }

    public ShopAggregateParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "secShopId");
        this.secShopId = r100;
        this.pageHeightPercent = 73;
        this.tabLabel = "";
    }

    public final void setCategoryId(String r100) {
        this.categoryId = r100;
    }

    public final void setCategoryInfo(CategoryInfo r100) {
        this.categoryInfo = r100;
    }

    public final void setCategoryInfoStr(String r100) {
        this.categoryInfoStr = r100;
    }

    public final void setClassificationTabType(String r100) {
        this.classificationTabType = r100;
    }

    public final void setEntranceInfo(String r100) {
        this.entranceInfo = r100;
    }

    public final void setMetaInfo(String r100) {
        this.metaInfo = r100;
    }

    public final void setPageHeightPercent(Integer r100) {
        this.pageHeightPercent = r100;
    }

    public final void setPageParams(String r100) {
        this.pageParams = r100;
    }

    public final void setPageVersion(String r100) {
        this.pageVersion = r100;
    }

    public final void setProductCnt(int r100) {
        this.productCnt = r100;
    }

    public final void setSelectIndex(int r100) {
        this.selectIndex = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setShowAddCart(boolean r100) {
        this.showAddCart = r100;
    }

    public final void setShowCategoryTab(boolean r100) {
        this.showCategoryTab = r100;
    }

    public final void setSourceBtmToken(String r100) {
        this.sourceBtmToken = r100;
    }

    public final void setSplitMode(boolean r100) {
        this.isSplitMode = r100;
    }

    public final void setTabLabel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabLabel = r100;
    }

    public final void setTabName(String r100) {
        this.tabName = r100;
    }

    public final void setTabNameSecond(String r100) {
        this.tabNameSecond = r100;
    }

    public final void setTagData(String r100) {
        this.tagData = r100;
    }
}
