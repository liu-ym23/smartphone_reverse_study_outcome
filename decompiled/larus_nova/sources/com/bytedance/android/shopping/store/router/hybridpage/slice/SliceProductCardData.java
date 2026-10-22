package com.bytedance.android.shopping.store.router.hybridpage.slice;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.common.param.StoreAccountParam;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 \u0085\u00012\u00020\u0001:\u0002\u0086\u0001B\t¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001d\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0018\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0018\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\"\u00105\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0013\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0018\u001a\u0004\b8\u0010\u001a\"\u0004\b9\u0010\u001cR$\u0010:\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0018\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\u001cR\"\u0010>\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010D\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010\u0018\u001a\u0004\bE\u0010\u001a\"\u0004\bF\u0010\u001cR.\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010U\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0018\u001a\u0004\bV\u0010\u001a\"\u0004\bW\u0010\u001cR\"\u0010X\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0018\u001a\u0004\bY\u0010\u001a\"\u0004\bZ\u0010\u001cR\"\u0010[\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\u0018\u001a\u0004\b\\\u0010\u001a\"\u0004\b]\u0010\u001cR$\u0010_\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR$\u0010e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010\u0018\u001a\u0004\bf\u0010\u001a\"\u0004\bg\u0010\u001cR$\u0010h\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010\u0018\u001a\u0004\bi\u0010\u001a\"\u0004\bj\u0010\u001cR$\u0010l\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010\u0018\u001a\u0004\bs\u0010\u001a\"\u0004\bt\u0010\u001cR\"\u0010u\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010\u0018\u001a\u0004\bv\u0010\u001a\"\u0004\bw\u0010\u001cR$\u0010x\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010\u0018\u001a\u0004\by\u0010\u001a\"\u0004\bz\u0010\u001cR\"\u0010{\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010\u0018\u001a\u0004\b|\u0010\u001a\"\u0004\b}\u0010\u001cR%\u0010~\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010\u0018\u001a\u0004\b\u007f\u0010\u001a\"\u0005\b\u0080\u0001\u0010\u001cR\u0014\u0010\u0081\u0001\u001a\u00020^8F¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001¨\u0006\u0087\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/slice/SliceProductCardData;", "Ljava/io/Serializable;", "", "key", "", "value", "", "putPassThroughParam", ExifInterface.GPS_DIRECTION_TRUE, "getPassThroughParam", "(Ljava/lang/String;)Ljava/lang/Object;", "Lcom/bytedance/android/ec/store/common/param/StoreAccountParam;", "storeAccountParam$delegate", "Lkotlin/Lazy;", "getStoreAccountParam", "()Lcom/bytedance/android/ec/store/common/param/StoreAccountParam;", "storeAccountParam", "", "isPreview", "Z", "()Z", "setPreview", "(Z)V", "secShopId", "Ljava/lang/String;", "getSecShopId", "()Ljava/lang/String;", "setSecShopId", "(Ljava/lang/String;)V", "shopId", "getShopId", "setShopId", "ecomEntranceFrom", "getEcomEntranceFrom", "setEcomEntranceFrom", "enterFrom", "getEnterFrom", "setEnterFrom", "pageName", "getPageName", "setPageName", "entranceLocation", "getEntranceLocation", "setEntranceLocation", "storeSourcePage", "getStoreSourcePage", "setStoreSourcePage", "storeSourceMethod", "getStoreSourceMethod", "setStoreSourceMethod", "storeGroupType", "getStoreGroupType", "setStoreGroupType", "isEcShare", "setEcShare", "shareContent", "getShareContent", "setShareContent", "shareObject", "getShareObject", "setShareObject", "", "lifecycleMonitorId", "J", "getLifecycleMonitorId", "()J", "setLifecycleMonitorId", "(J)V", "searchParams", "getSearchParams", "setSearchParams", "", "passThroughParams", "Ljava/util/Map;", "getPassThroughParams", "()Ljava/util/Map;", "setPassThroughParams", "(Ljava/util/Map;)V", "Lcom/bytedance/android/ec/store/common/param/ProductBasicRequestParam;", "productBasicRequestParam", "Lcom/bytedance/android/ec/store/common/param/ProductBasicRequestParam;", "getProductBasicRequestParam", "()Lcom/bytedance/android/ec/store/common/param/ProductBasicRequestParam;", "setProductBasicRequestParam", "(Lcom/bytedance/android/ec/store/common/param/ProductBasicRequestParam;)V", "preGroupId", "getPreGroupId", "setPreGroupId", "preProductId", "getPreProductId", "setPreProductId", "preRoomId", "getPreRoomId", "setPreRoomId", "", "followStatus", "Ljava/lang/Integer;", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "tempId", "getTempId", "setTempId", "liveAnchorId", "getLiveAnchorId", "setLiveAnchorId", "Lorg/json/JSONObject;", "entranceInfoJsonObject", "Lorg/json/JSONObject;", "getEntranceInfoJsonObject", "()Lorg/json/JSONObject;", "setEntranceInfoJsonObject", "(Lorg/json/JSONObject;)V", "entranceInfo", "getEntranceInfo", "setEntranceInfo", "roomId", "getRoomId", "setRoomId", "searchSource", "getSearchSource", "setSearchSource", "searchKeyword", "getSearchKeyword", "setSearchKeyword", "searchGroupID", "getSearchGroupID", "setSearchGroupID", "isFromAd", "()I", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SliceProductCardData implements Serializable {
    public static final a Companion = null;
    private String ecomEntranceFrom;
    private String enterFrom;
    private String entranceInfo;
    private JSONObject entranceInfoJsonObject;
    private String entranceLocation;
    private Integer followStatus;
    private boolean isEcShare;
    private boolean isPreview;
    private long lifecycleMonitorId;
    private String liveAnchorId;
    private String pageName;
    private Map<String, Object> passThroughParams;
    private String preGroupId;
    private String preProductId;
    private String preRoomId;
    private ProductBasicRequestParam productBasicRequestParam;
    private String roomId;
    private String searchGroupID;
    private String searchKeyword;
    private String searchParams;
    private String searchSource;
    private String secShopId;
    private String shareContent;
    private String shareObject;
    private String shopId;
    private final Lazy storeAccountParam$delegate;
    private String storeGroupType;
    private String storeSourceMethod;
    private String storeSourcePage;
    private String tempId;

    public static final class a {
        public a() {
        }

        public static SliceProductCardData a(ECShopSearchParam r100) {
            Intrinsics.checkNotNullParameter(r100, "searchParams");
            SliceProductCardData r101 = new SliceProductCardData();
            StoreAccountParam r102 = r101.getStoreAccountParam();
            r102.setSecUserId(r100.getStoreAccountParam().getSecUserId());
            r102.setUserId(r100.getStoreAccountParam().getUserId());
            r101.setPreview(r100.isPreview());
            r101.setSecShopId(r100.getSecShopId());
            r101.setShopId(r100.getShopId());
            r101.setEnterFrom(r100.getEnterFrom());
            r101.setPageName(r100.getPageName());
            r101.setEntranceLocation(r100.getEntranceLocation());
            r101.setStoreSourcePage(r100.getStoreSourcePage());
            r101.setStoreSourceMethod(r100.getStoreSourceMethod());
            r101.setStoreGroupType(r100.getStoreGroupType());
            r101.setEcShare(r100.isEcShare());
            r101.setShareContent(r100.getShareContent());
            r101.setShareObject(r100.getShareObject());
            r101.setPassThroughParams(r100.getPassThroughParams());
            r101.setProductBasicRequestParam(r100.getProductBasicRequestParam());
            r101.setFollowStatus(r100.getFollowStatus());
            r101.setTempId(r100.getTempId());
            r101.setEntranceInfo(r100.getEntranceInfo());
            r101.setRoomId(r100.getRoomId());
            r101.setSearchSource(r100.getSearchSource());
            String r103 = r100.getSearchKeyword();
            if (r103 != null) goto L5;
            r103 = "";
        L5:
            r101.setSearchKeyword(r103);
            r101.setSearchGroupID(r100.getGroupId());
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    public final StoreAccountParam getStoreAccountParam() {
        return (StoreAccountParam) this.storeAccountParam$delegate.getValue();
    }

    public final int isFromAd() {
        JSONObject r100 = k.w(this.entranceInfo);
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.optInt("is_from_ad", 0);
    }

    public SliceProductCardData() {
        this.storeAccountParam$delegate = LazyKt.lazy(SliceProductCardData$storeAccountParam$2.INSTANCE);
        this.ecomEntranceFrom = "";
        this.enterFrom = "open_url";
        this.pageName = "store_page";
        this.entranceLocation = "open_url";
        this.lifecycleMonitorId = -1;
        this.passThroughParams = new LinkedHashMap();
        this.productBasicRequestParam = new ProductBasicRequestParam();
        this.preGroupId = "";
        this.preProductId = "";
        this.preRoomId = "";
        this.followStatus = -1;
        this.entranceInfo = "";
        this.roomId = "";
        this.searchKeyword = "";
    }

    public final String getEcomEntranceFrom() {
        return this.ecomEntranceFrom;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final JSONObject getEntranceInfoJsonObject() {
        return this.entranceInfoJsonObject;
    }

    public final String getEntranceLocation() {
        return this.entranceLocation;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final long getLifecycleMonitorId() {
        return this.lifecycleMonitorId;
    }

    public final String getLiveAnchorId() {
        return this.liveAnchorId;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final Map<String, Object> getPassThroughParams() {
        return this.passThroughParams;
    }

    public final String getPreGroupId() {
        return this.preGroupId;
    }

    public final String getPreProductId() {
        return this.preProductId;
    }

    public final String getPreRoomId() {
        return this.preRoomId;
    }

    public final ProductBasicRequestParam getProductBasicRequestParam() {
        return this.productBasicRequestParam;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSearchGroupID() {
        return this.searchGroupID;
    }

    public final String getSearchKeyword() {
        return this.searchKeyword;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public final String getSearchSource() {
        return this.searchSource;
    }

    public final String getSecShopId() {
        return this.secShopId;
    }

    public final String getShareContent() {
        return this.shareContent;
    }

    public final String getShareObject() {
        return this.shareObject;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getStoreGroupType() {
        return this.storeGroupType;
    }

    public final String getStoreSourceMethod() {
        return this.storeSourceMethod;
    }

    public final String getStoreSourcePage() {
        return this.storeSourcePage;
    }

    public final String getTempId() {
        return this.tempId;
    }

    public final boolean isEcShare() {
        return this.isEcShare;
    }

    public final boolean isPreview() {
        return this.isPreview;
    }

    public final <T> T getPassThroughParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) this.passThroughParams.get(r100);
        if ((r101 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r101;
    }

    public final void setEcShare(boolean r100) {
        this.isEcShare = r100;
    }

    public final void setEcomEntranceFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ecomEntranceFrom = r100;
    }

    public final void setEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFrom = r100;
    }

    public final void setEntranceInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entranceInfo = r100;
    }

    public final void setEntranceInfoJsonObject(JSONObject r100) {
        this.entranceInfoJsonObject = r100;
    }

    public final void setEntranceLocation(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entranceLocation = r100;
    }

    public final void setFollowStatus(Integer r100) {
        this.followStatus = r100;
    }

    public final void setLifecycleMonitorId(long r100) {
        this.lifecycleMonitorId = r100;
    }

    public final void setLiveAnchorId(String r100) {
        this.liveAnchorId = r100;
    }

    public final void setPageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageName = r100;
    }

    public final void setPassThroughParams(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.passThroughParams = r100;
    }

    public final void setPreGroupId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.preGroupId = r100;
    }

    public final void setPreProductId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.preProductId = r100;
    }

    public final void setPreRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.preRoomId = r100;
    }

    public final void setPreview(boolean r100) {
        this.isPreview = r100;
    }

    public final void setProductBasicRequestParam(ProductBasicRequestParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.productBasicRequestParam = r100;
    }

    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomId = r100;
    }

    public final void setSearchGroupID(String r100) {
        this.searchGroupID = r100;
    }

    public final void setSearchKeyword(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchKeyword = r100;
    }

    public final void setSearchParams(String r100) {
        this.searchParams = r100;
    }

    public final void setSearchSource(String r100) {
        this.searchSource = r100;
    }

    public final void setSecShopId(String r100) {
        this.secShopId = r100;
    }

    public final void setShareContent(String r100) {
        this.shareContent = r100;
    }

    public final void setShareObject(String r100) {
        this.shareObject = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setStoreGroupType(String r100) {
        this.storeGroupType = r100;
    }

    public final void setStoreSourceMethod(String r100) {
        this.storeSourceMethod = r100;
    }

    public final void setStoreSourcePage(String r100) {
        this.storeSourcePage = r100;
    }

    public final void setTempId(String r100) {
        this.tempId = r100;
    }

    public final void putPassThroughParam(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.passThroughParams.put(r100, r101);
    }
}
