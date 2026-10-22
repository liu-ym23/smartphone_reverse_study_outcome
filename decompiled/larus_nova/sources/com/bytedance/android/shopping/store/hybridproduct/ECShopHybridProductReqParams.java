package com.bytedance.android.shopping.store.hybridproduct;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bd\u0010eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\b\"\u0004\b*\u0010\nR$\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0006\u001a\u0004\b,\u0010\b\"\u0004\b-\u0010\nR$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u0010\b\"\u0004\b0\u0010\nR$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0006\u001a\u0004\b2\u0010\b\"\u0004\b3\u0010\nR$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0006\u001a\u0004\b5\u0010\b\"\u0004\b6\u0010\nR$\u00107\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001a\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001eR$\u0010:\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0006\u001a\u0004\b;\u0010\b\"\u0004\b<\u0010\nR$\u0010=\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0006\u001a\u0004\b>\u0010\b\"\u0004\b?\u0010\nR$\u0010@\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0006\u001a\u0004\bA\u0010\b\"\u0004\bB\u0010\nR$\u0010C\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0006\u001a\u0004\bD\u0010\b\"\u0004\bE\u0010\nR$\u0010F\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0006\u001a\u0004\bG\u0010\b\"\u0004\bH\u0010\nR$\u0010I\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0006\u001a\u0004\bJ\u0010\b\"\u0004\bK\u0010\nR$\u0010L\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0006\u001a\u0004\bM\u0010\b\"\u0004\bN\u0010\nR\"\u0010P\u001a\u00020O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bP\u0010R\"\u0004\bS\u0010TR2\u0010W\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010V\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R2\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010V\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010X\u001a\u0004\b^\u0010Z\"\u0004\b_\u0010\\R\"\u0010c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010\u0006\u001a\u0004\ba\u0010\b\"\u0004\bb\u0010\n¨\u0006f"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductReqParams;", "Ljava/io/Serializable;", "", "getFilterParamsMerge", "getClientStateMerge", "secShopId", "Ljava/lang/String;", "getSecShopId", "()Ljava/lang/String;", "setSecShopId", "(Ljava/lang/String;)V", "filterParams", "getFilterParams", "setFilterParams", "filterEventParams", "getFilterEventParams", "setFilterEventParams", "", "sortType", "J", "getSortType", "()J", "setSortType", "(J)V", "", "pickType", "Ljava/lang/Integer;", "getPickType", "()Ljava/lang/Integer;", "setPickType", "(Ljava/lang/Integer;)V", "order", "I", "getOrder", "()I", "setOrder", "(I)V", "customIdType", "getCustomIdType", "setCustomIdType", "customIds", "getCustomIds", "setCustomIds", "filterProductIds", "getFilterProductIds", "setFilterProductIds", "moduleType", "getModuleType", "setModuleType", "clickProducts", "getClickProducts", "setClickProducts", "selectParams", "getSelectParams", "setSelectParams", "requestTabType", "getRequestTabType", "setRequestTabType", "querySource", "getQuerySource", "setQuerySource", "shuffleProductIds", "getShuffleProductIds", "setShuffleProductIds", "paginationParams", "getPaginationParams", "setPaginationParams", "hybridParams", "getHybridParams", "setHybridParams", "passThroughApi", "getPassThroughApi", "setPassThroughApi", "clientState", "getClientState", "setClientState", "unexposedIds", "getUnexposedIds", "setUnexposedIds", "", "isFilterRequest", "Z", "()Z", "setFilterRequest", "(Z)V", "", "", "filterParamsFromLynx", "Ljava/util/Map;", "getFilterParamsFromLynx", "()Ljava/util/Map;", "setFilterParamsFromLynx", "(Ljava/util/Map;)V", "clientStateFromLynx", "getClientStateFromLynx", "setClientStateFromLynx", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getLocalTemplateVersions", "setLocalTemplateVersions", "localTemplateVersions", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopHybridProductReqParams implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient String f184922a;
    private String clickProducts;
    private String clientState;
    private Map<String, ? extends Object> clientStateFromLynx;
    private Integer customIdType;
    private String customIds;
    private String filterEventParams;
    private String filterParams;
    private Map<String, ? extends Object> filterParamsFromLynx;
    private String filterProductIds;
    private String hybridParams;
    private boolean isFilterRequest;
    private String moduleType;
    private int order;
    private String paginationParams;
    private volatile String passThroughApi;
    private Integer pickType;
    private String querySource;
    private Integer requestTabType;
    private String secShopId;
    private String selectParams;
    private String shuffleProductIds;
    private long sortType;
    private String unexposedIds;

    public final String getClientStateMerge() {
        JSONObject r100 = com.bytedance.android.shopping.extensions.k.w(this.clientState);
        if (r100 != null) goto L5;
        r100 = new JSONObject();
    L5:
        Map<String, ? extends Object> r101 = this.clientStateFromLynx;
        if (r101 == null) goto L12;
        Iterator<T> r102 = r101.keySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L12;
        String r103 = (String) r102.next();
        r100.put(r103, r101.get(r103));
    L12:
        return r100.toString();
    }

    public final String getFilterParamsMerge() {
        if (com.bytedance.android.shopping.extensions.k.c(this.filterParams) == false) goto L5;
        JSONObject r100 = com.bytedance.commerce.base.json.b.a(this.filterParams);
    L6:
        Map<String, ? extends Object> r101 = this.filterParamsFromLynx;
        if (r101 == null) goto L13;
        Iterator<T> r102 = r101.keySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L13;
        String r103 = (String) r102.next();
        r100.put(r103, r101.get(r103));
    L13:
        return r100.toString();
    L5:
        r100 = new JSONObject();
        goto L6
    }

    public ECShopHybridProductReqParams() {
        this.secShopId = "";
        this.filterParams = "";
        this.filterEventParams = "";
        this.pickType = 0;
        this.f184922a = "";
    }

    public final String getClickProducts() {
        return this.clickProducts;
    }

    public final String getClientState() {
        return this.clientState;
    }

    public final Map<String, Object> getClientStateFromLynx() {
        return this.clientStateFromLynx;
    }

    public final Integer getCustomIdType() {
        return this.customIdType;
    }

    public final String getCustomIds() {
        return this.customIds;
    }

    public final String getFilterEventParams() {
        return this.filterEventParams;
    }

    public final String getFilterParams() {
        return this.filterParams;
    }

    public final Map<String, Object> getFilterParamsFromLynx() {
        return this.filterParamsFromLynx;
    }

    public final String getFilterProductIds() {
        return this.filterProductIds;
    }

    public final String getHybridParams() {
        return this.hybridParams;
    }

    public final String getLocalTemplateVersions() {
        return this.f184922a;
    }

    public final String getModuleType() {
        return this.moduleType;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getPaginationParams() {
        return this.paginationParams;
    }

    public final String getPassThroughApi() {
        return this.passThroughApi;
    }

    public final Integer getPickType() {
        return this.pickType;
    }

    public final String getQuerySource() {
        return this.querySource;
    }

    public final Integer getRequestTabType() {
        return this.requestTabType;
    }

    public final String getSecShopId() {
        return this.secShopId;
    }

    public final String getSelectParams() {
        return this.selectParams;
    }

    public final String getShuffleProductIds() {
        return this.shuffleProductIds;
    }

    public final long getSortType() {
        return this.sortType;
    }

    public final String getUnexposedIds() {
        return this.unexposedIds;
    }

    public final boolean isFilterRequest() {
        return this.isFilterRequest;
    }

    public final void setClickProducts(String r100) {
        this.clickProducts = r100;
    }

    public final void setClientState(String r100) {
        this.clientState = r100;
    }

    public final void setClientStateFromLynx(Map<String, ? extends Object> r100) {
        this.clientStateFromLynx = r100;
    }

    public final void setCustomIdType(Integer r100) {
        this.customIdType = r100;
    }

    public final void setCustomIds(String r100) {
        this.customIds = r100;
    }

    public final void setFilterEventParams(String r100) {
        this.filterEventParams = r100;
    }

    public final void setFilterParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.filterParams = r100;
    }

    public final void setFilterParamsFromLynx(Map<String, ? extends Object> r100) {
        this.filterParamsFromLynx = r100;
    }

    public final void setFilterProductIds(String r100) {
        this.filterProductIds = r100;
    }

    public final void setFilterRequest(boolean r100) {
        this.isFilterRequest = r100;
    }

    public final void setHybridParams(String r100) {
        this.hybridParams = r100;
    }

    public final void setLocalTemplateVersions(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f184922a = r100;
    }

    public final void setModuleType(String r100) {
        this.moduleType = r100;
    }

    public final void setOrder(int r100) {
        this.order = r100;
    }

    public final void setPaginationParams(String r100) {
        this.paginationParams = r100;
    }

    public final void setPassThroughApi(String r100) {
        this.passThroughApi = r100;
    }

    public final void setPickType(Integer r100) {
        this.pickType = r100;
    }

    public final void setQuerySource(String r100) {
        this.querySource = r100;
    }

    public final void setRequestTabType(Integer r100) {
        this.requestTabType = r100;
    }

    public final void setSecShopId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secShopId = r100;
    }

    public final void setSelectParams(String r100) {
        this.selectParams = r100;
    }

    public final void setShuffleProductIds(String r100) {
        this.shuffleProductIds = r100;
    }

    public final void setSortType(long r100) {
        this.sortType = r100;
    }

    public final void setUnexposedIds(String r100) {
        this.unexposedIds = r100;
    }
}
