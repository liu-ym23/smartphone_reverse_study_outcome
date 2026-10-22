package com.bytedance.android.ec.store.common.param;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.store.search.repository.dto.LogPbDTO;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010$\n\u0002\b\b\u0018\u0000 ¡\u00012\u00020\u0001:\u0002¢\u0001B\t¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001b\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R$\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\f\u001a\u0004\b,\u0010\u000e\"\u0004\b-\u0010\u0010R\u001a\u0010.\u001a\u00020!8\u0006X\u0086D¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u00109\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\f\u001a\u0004\b:\u0010\u000e\"\u0004\b;\u0010\u0010R$\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\f\u001a\u0004\b=\u0010\u000e\"\u0004\b>\u0010\u0010R.\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010F\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u00104\u001a\u0004\bG\u00106\"\u0004\bH\u00108R\"\u0010I\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u00104\u001a\u0004\bI\u00106\"\u0004\bJ\u00108R\"\u0010K\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u00104\u001a\u0004\bK\u00106\"\u0004\bL\u00108R$\u0010M\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010\f\u001a\u0004\bN\u0010\u000e\"\u0004\bO\u0010\u0010R\"\u0010P\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u00104\u001a\u0004\bQ\u00106\"\u0004\bR\u00108R$\u0010S\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010\f\u001a\u0004\bT\u0010\u000e\"\u0004\bU\u0010\u0010R$\u0010V\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010#\u001a\u0004\bW\u0010%\"\u0004\bX\u0010'R$\u0010Y\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010\f\u001a\u0004\bZ\u0010\u000e\"\u0004\b[\u0010\u0010R$\u0010\\\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010\u0019\u001a\u0004\b]\u0010\u001b\"\u0004\b^\u0010\u001dR$\u0010`\u001a\u0004\u0018\u00010_8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010f\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u00104\u001a\u0004\bf\u00106\"\u0004\bg\u00108R\"\u0010h\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010/\u001a\u0004\bi\u00101\"\u0004\bj\u0010kR$\u0010l\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010\f\u001a\u0004\bm\u0010\u000e\"\u0004\bn\u0010\u0010R\"\u0010o\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u00104\u001a\u0004\bp\u00106\"\u0004\bq\u00108R\"\u0010r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010\f\u001a\u0004\bs\u0010\u000e\"\u0004\bt\u0010\u0010R$\u0010u\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010\f\u001a\u0004\bv\u0010\u000e\"\u0004\bw\u0010\u0010R$\u0010x\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010\f\u001a\u0004\by\u0010\u000e\"\u0004\bz\u0010\u0010R$\u0010{\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010\f\u001a\u0004\b|\u0010\u000e\"\u0004\b}\u0010\u0010R%\u0010~\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010\f\u001a\u0004\b\u007f\u0010\u000e\"\u0005\b\u0080\u0001\u0010\u0010R(\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010\f\u001a\u0005\b\u0082\u0001\u0010\u000e\"\u0005\b\u0083\u0001\u0010\u0010R(\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\f\u001a\u0005\b\u0085\u0001\u0010\u000e\"\u0005\b\u0086\u0001\u0010\u0010R)\u0010\u0087\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R&\u0010\u008d\u0001\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u00104\u001a\u0005\b\u008e\u0001\u00106\"\u0005\b\u008f\u0001\u00108R&\u0010\u0090\u0001\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u00104\u001a\u0005\b\u0090\u0001\u00106\"\u0005\b\u0091\u0001\u00108R(\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010\f\u001a\u0005\b\u0093\u0001\u0010\u000e\"\u0005\b\u0094\u0001\u0010\u0010R(\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0095\u0001\u0010\f\u001a\u0005\b\u0096\u0001\u0010\u000e\"\u0005\b\u0097\u0001\u0010\u0010R(\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010\f\u001a\u0005\b\u0099\u0001\u0010\u000e\"\u0005\b\u009a\u0001\u0010\u0010R5\u0010\u009c\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u009b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010A\u001a\u0005\b\u009d\u0001\u0010C\"\u0005\b\u009e\u0001\u0010E¨\u0006£\u0001"}, d2 = {"Lcom/bytedance/android/ec/store/common/param/StoreV2RequestParam;", "Ljava/io/Serializable;", "", "key", "", "value", "", "putPassThroughParam", ExifInterface.GPS_DIRECTION_TRUE, "getPassThroughParam", "(Ljava/lang/String;)Ljava/lang/Object;", "secAuthorId", "Ljava/lang/String;", "getSecAuthorId", "()Ljava/lang/String;", "setSecAuthorId", "(Ljava/lang/String;)V", "secShopId", "getSecShopId", "setSecShopId", "materialId", "getMaterialId", "setMaterialId", "", "goodsType", "Ljava/lang/Long;", "getGoodsType", "()Ljava/lang/Long;", "setGoodsType", "(Ljava/lang/Long;)V", "sortType", "getSortType", "setSortType", "", "pickType", "Ljava/lang/Integer;", "getPickType", "()Ljava/lang/Integer;", "setPickType", "(Ljava/lang/Integer;)V", "sort", "getSort", "setSort", "keyWord", "getKeyWord", "setKeyWord", "size", "I", "getSize", "()I", "", "hasMore", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "tmpId", "getTmpId", "setTmpId", "token", "getToken", "setToken", "", "passThroughParams", "Ljava/util/Map;", "getPassThroughParams", "()Ljava/util/Map;", "setPassThroughParams", "(Ljava/util/Map;)V", "firstInit", "getFirstInit", "setFirstInit", "isStore", "setStore", "isCustom", "setCustom", "entrances", "getEntrances", "setEntrances", "showCoupon", "getShowCoupon", "setShowCoupon", "customIds", "getCustomIds", "setCustomIds", "customIdType", "getCustomIdType", "setCustomIdType", "filterProductIds", "getFilterProductIds", "setFilterProductIds", EffectConfiguration.KEY_CURSOR, "getCursor", "setCursor", "Lcom/bytedance/android/ec/store/search/repository/dto/LogPbDTO;", "logPb", "Lcom/bytedance/android/ec/store/search/repository/dto/LogPbDTO;", "getLogPb", "()Lcom/bytedance/android/ec/store/search/repository/dto/LogPbDTO;", "setLogPb", "(Lcom/bytedance/android/ec/store/search/repository/dto/LogPbDTO;)V", "isHistory", "setHistory", "bottomModuleType", "getBottomModuleType", "setBottomModuleType", "(I)V", "pageParam", "getPageParam", "setPageParam", "hasNextPage", "getHasNextPage", "setHasNextPage", "tabVisitHis", "getTabVisitHis", "setTabVisitHis", "selectParams", "getSelectParams", "setSelectParams", "followStatus", "getFollowStatus", "setFollowStatus", "entranceInfo", "getEntranceInfo", "setEntranceInfo", "authorID", "getAuthorID", "setAuthorID", "shuffleProductIds", "getShuffleProductIds", "setShuffleProductIds", "searchId", "getSearchId", "setSearchId", "lifecycleMonitorId", "J", "getLifecycleMonitorId", "()J", "setLifecycleMonitorId", "(J)V", "defaultSelected", "getDefaultSelected", "setDefaultSelected", "isFromSug", "setFromSug", "groupId", "getGroupId", "setGroupId", "searchSource", "getSearchSource", "setSearchSource", "productTabPassThroughApi", "getProductTabPassThroughApi", "setProductTabPassThroughApi", "", "extraParamMap", "getExtraParamMap", "setExtraParamMap", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreV2RequestParam implements Serializable {
    public static final a Companion = null;
    public static final int VALUE_COUNT = 10;
    private String authorID;
    private int bottomModuleType;
    private Long cursor;
    private Integer customIdType;
    private String customIds;
    private boolean defaultSelected;
    private String entranceInfo;
    private String entrances;
    private Map<String, String> extraParamMap;
    private String filterProductIds;
    private boolean firstInit;
    private String followStatus;
    private Long goodsType;
    private String groupId;
    private boolean hasMore;
    private boolean hasNextPage;
    private boolean isCustom;
    private boolean isFromSug;
    private boolean isHistory;
    private boolean isStore;
    private String keyWord;
    private long lifecycleMonitorId;
    private LogPbDTO logPb;
    private String materialId;
    private String pageParam;
    private Map<String, Object> passThroughParams;
    private Integer pickType;
    private String productTabPassThroughApi;
    private String searchId;
    private String searchSource;
    private String secAuthorId;
    private String secShopId;
    private String selectParams;
    private boolean showCoupon;
    private String shuffleProductIds;
    private final int size;
    private Integer sort;
    private Long sortType;
    private String tabVisitHis;
    private String tmpId;
    private String token;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public StoreV2RequestParam() {
        this.secAuthorId = "";
        this.secShopId = "";
        this.sortType = 0L;
        this.pickType = 0;
        this.size = 10;
        this.hasMore = true;
        this.passThroughParams = new LinkedHashMap();
        this.firstInit = true;
        this.hasNextPage = true;
        this.tabVisitHis = "";
        this.lifecycleMonitorId = -1;
    }

    public final String getAuthorID() {
        return this.authorID;
    }

    public final int getBottomModuleType() {
        return this.bottomModuleType;
    }

    public final Long getCursor() {
        return this.cursor;
    }

    public final Integer getCustomIdType() {
        return this.customIdType;
    }

    public final String getCustomIds() {
        return this.customIds;
    }

    public final boolean getDefaultSelected() {
        return this.defaultSelected;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getEntrances() {
        return this.entrances;
    }

    public final Map<String, String> getExtraParamMap() {
        return this.extraParamMap;
    }

    public final String getFilterProductIds() {
        return this.filterProductIds;
    }

    public final boolean getFirstInit() {
        return this.firstInit;
    }

    public final String getFollowStatus() {
        return this.followStatus;
    }

    public final Long getGoodsType() {
        return this.goodsType;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }

    public final String getKeyWord() {
        return this.keyWord;
    }

    public final long getLifecycleMonitorId() {
        return this.lifecycleMonitorId;
    }

    public final LogPbDTO getLogPb() {
        return this.logPb;
    }

    public final String getMaterialId() {
        return this.materialId;
    }

    public final String getPageParam() {
        return this.pageParam;
    }

    public final Map<String, Object> getPassThroughParams() {
        return this.passThroughParams;
    }

    public final Integer getPickType() {
        return this.pickType;
    }

    public final String getProductTabPassThroughApi() {
        return this.productTabPassThroughApi;
    }

    public final String getSearchId() {
        return this.searchId;
    }

    public final String getSearchSource() {
        return this.searchSource;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSecShopId() {
        return this.secShopId;
    }

    public final String getSelectParams() {
        return this.selectParams;
    }

    public final boolean getShowCoupon() {
        return this.showCoupon;
    }

    public final String getShuffleProductIds() {
        return this.shuffleProductIds;
    }

    public final int getSize() {
        return this.size;
    }

    public final Integer getSort() {
        return this.sort;
    }

    public final Long getSortType() {
        return this.sortType;
    }

    public final String getTabVisitHis() {
        return this.tabVisitHis;
    }

    public final String getTmpId() {
        return this.tmpId;
    }

    public final String getToken() {
        return this.token;
    }

    public final boolean isCustom() {
        return this.isCustom;
    }

    public final boolean isFromSug() {
        return this.isFromSug;
    }

    public final boolean isHistory() {
        return this.isHistory;
    }

    public final boolean isStore() {
        return this.isStore;
    }

    public final <T> T getPassThroughParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (T) this.passThroughParams.get(r100);
    }

    public final void setAuthorID(String r100) {
        this.authorID = r100;
    }

    public final void setBottomModuleType(int r100) {
        this.bottomModuleType = r100;
    }

    public final void setCursor(Long r100) {
        this.cursor = r100;
    }

    public final void setCustom(boolean r100) {
        this.isCustom = r100;
    }

    public final void setCustomIdType(Integer r100) {
        this.customIdType = r100;
    }

    public final void setCustomIds(String r100) {
        this.customIds = r100;
    }

    public final void setDefaultSelected(boolean r100) {
        this.defaultSelected = r100;
    }

    public final void setEntranceInfo(String r100) {
        this.entranceInfo = r100;
    }

    public final void setEntrances(String r100) {
        this.entrances = r100;
    }

    public final void setExtraParamMap(Map<String, String> r100) {
        this.extraParamMap = r100;
    }

    public final void setFilterProductIds(String r100) {
        this.filterProductIds = r100;
    }

    public final void setFirstInit(boolean r100) {
        this.firstInit = r100;
    }

    public final void setFollowStatus(String r100) {
        this.followStatus = r100;
    }

    public final void setFromSug(boolean r100) {
        this.isFromSug = r100;
    }

    public final void setGoodsType(Long r100) {
        this.goodsType = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setHasNextPage(boolean r100) {
        this.hasNextPage = r100;
    }

    public final void setHistory(boolean r100) {
        this.isHistory = r100;
    }

    public final void setKeyWord(String r100) {
        this.keyWord = r100;
    }

    public final void setLifecycleMonitorId(long r100) {
        this.lifecycleMonitorId = r100;
    }

    public final void setLogPb(LogPbDTO r100) {
        this.logPb = r100;
    }

    public final void setMaterialId(String r100) {
        this.materialId = r100;
    }

    public final void setPageParam(String r100) {
        this.pageParam = r100;
    }

    public final void setPassThroughParams(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.passThroughParams = r100;
    }

    public final void setPickType(Integer r100) {
        this.pickType = r100;
    }

    public final void setProductTabPassThroughApi(String r100) {
        this.productTabPassThroughApi = r100;
    }

    public final void setSearchId(String r100) {
        this.searchId = r100;
    }

    public final void setSearchSource(String r100) {
        this.searchSource = r100;
    }

    public final void setSecAuthorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secAuthorId = r100;
    }

    public final void setSecShopId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secShopId = r100;
    }

    public final void setSelectParams(String r100) {
        this.selectParams = r100;
    }

    public final void setShowCoupon(boolean r100) {
        this.showCoupon = r100;
    }

    public final void setShuffleProductIds(String r100) {
        this.shuffleProductIds = r100;
    }

    public final void setSort(Integer r100) {
        this.sort = r100;
    }

    public final void setSortType(Long r100) {
        this.sortType = r100;
    }

    public final void setStore(boolean r100) {
        this.isStore = r100;
    }

    public final void setTabVisitHis(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabVisitHis = r100;
    }

    public final void setTmpId(String r100) {
        this.tmpId = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }

    public final void putPassThroughParam(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.passThroughParams.put(r100, r101);
    }
}
