package com.bytedance.android.shopping.store.home.api;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.store.common.param.ECShareParam;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.common.param.StoreAccountParam;
import com.bytedance.android.ec.store.common.param.StoreNaviParam;
import com.bytedance.android.shopping.store.home.entity.FansClubInfo;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010¨\u0001\u001a\u0005\u0018\u0001H©\u0001\"\u0005\b\u0000\u0010©\u00012\u0007\u0010ª\u0001\u001a\u00020\n¢\u0006\u0003\u0010«\u0001J\u0007\u0010¬\u0001\u001a\u000208J\u001a\u0010\u00ad\u0001\u001a\u00030®\u00012\u0007\u0010ª\u0001\u001a\u00020\n2\u0007\u0010¯\u0001\u001a\u00020RR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001c\u0010!\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001c\u0010'\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R\u0014\u0010?\u001a\u000208X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b?\u0010:R\u0011\u0010@\u001a\u000208¢\u0006\b\n\u0000\u001a\u0004\b@\u0010:R\u001c\u0010A\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\f\"\u0004\bC\u0010\u000eR\u001c\u0010D\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\f\"\u0004\bF\u0010\u000eR\u001c\u0010G\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\f\"\u0004\bI\u0010\u000eR\u001a\u0010J\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\f\"\u0004\bL\u0010\u000eR\u001c\u0010M\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u000eR\u001d\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020R0Q¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\f\"\u0004\bW\u0010\u000eR\u001a\u0010X\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\f\"\u0004\bZ\u0010\u000eR\u001a\u0010[\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\f\"\u0004\b]\u0010\u000eR\u001b\u0010^\u001a\u00020_8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\b`\u0010aR\u001c\u0010d\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\f\"\u0004\bf\u0010\u000eR\u001a\u0010g\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\f\"\u0004\bi\u0010\u000eR\u001c\u0010j\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\f\"\u0004\bl\u0010\u000eR\u001c\u0010m\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\f\"\u0004\bo\u0010\u000eR\u001c\u0010p\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\f\"\u0004\br\u0010\u000eR\u001b\u0010s\u001a\u00020t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bw\u0010c\u001a\u0004\bu\u0010vR\u001c\u0010x\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\f\"\u0004\bz\u0010\u000eR\u001b\u0010{\u001a\u00020|8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u007f\u0010c\u001a\u0004\b}\u0010~R\u001f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\f\"\u0005\b\u0082\u0001\u0010\u000eR\u001f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\f\"\u0005\b\u0085\u0001\u0010\u000eR\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\f\"\u0005\b\u0088\u0001\u0010\u000eR \u0010\u0089\u0001\u001a\u00030\u008a\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u008d\u0001\u0010c\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010\f\"\u0005\b\u0090\u0001\u0010\u000eR\u001f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\f\"\u0005\b\u0093\u0001\u0010\u000eR \u0010\u0094\u0001\u001a\u00030\u0095\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0098\u0001\u0010c\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R!\u0010\u0099\u0001\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u0012\n\u0002\u00106\u001a\u0005\b\u009a\u0001\u00103\"\u0005\b\u009b\u0001\u00105R\u001f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010\f\"\u0005\b\u009e\u0001\u0010\u000eR\u001f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010\f\"\u0005\b¡\u0001\u0010\u000eR\u001f\u0010¢\u0001\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010\f\"\u0005\b¤\u0001\u0010\u000eR\u001f\u0010¥\u0001\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010\f\"\u0005\b§\u0001\u0010\u000e¨\u0006°\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/home/api/StoreBaseParam;", "Ljava/io/Serializable;", "()V", "adLogExtra", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "setAdLogExtra", "(Lcom/bytedance/android/ec/model/ECAdLogExtra;)V", "anchorId", "", "getAnchorId", "()Ljava/lang/String;", "setAnchorId", "(Ljava/lang/String;)V", "bcm", "getBcm", "setBcm", "debugUrl", "getDebugUrl", "setDebugUrl", "ecomJsonStr", "getEcomJsonStr", "setEcomJsonStr", "ecomPitayaJsonStr", "getEcomPitayaJsonStr", "setEcomPitayaJsonStr", "enterFrom", "getEnterFrom", "setEnterFrom", "enterMethod", "getEnterMethod", "setEnterMethod", "enterStoreEvent", "getEnterStoreEvent", "setEnterStoreEvent", "entranceLocation", "getEntranceLocation", "setEntranceLocation", "extraSchema", "getExtraSchema", "setExtraSchema", "fansInfo", "Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;", "getFansInfo", "()Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;", "setFansInfo", "(Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;)V", "followStatus", "", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "fromProfile", "", "getFromProfile", "()Z", "setFromProfile", "(Z)V", "isEcShare", "setEcShare", "isLuban", "isV3Store", "liveAnchorId", "getLiveAnchorId", "setLiveAnchorId", "moduleLabel", "getModuleLabel", "setModuleLabel", "pageFrom", "getPageFrom", "setPageFrom", "pageName", "getPageName", "setPageName", "pageType", "getPageType", "setPageType", "passThroughParams", "", "", "getPassThroughParams", "()Ljava/util/Map;", "preGroupId", "getPreGroupId", "setPreGroupId", "preProductId", "getPreProductId", "setPreProductId", "preRoomId", "getPreRoomId", "setPreRoomId", "productBasicRequestParam", "Lcom/bytedance/android/ec/store/common/param/ProductBasicRequestParam;", "getProductBasicRequestParam", "()Lcom/bytedance/android/ec/store/common/param/ProductBasicRequestParam;", "productBasicRequestParam$delegate", "Lkotlin/Lazy;", "productId", "getProductId", "setProductId", "roomId", "getRoomId", "setRoomId", "searchHint", "getSearchHint", "setSearchHint", "searchParams", "getSearchParams", "setSearchParams", "shareContent", "getShareContent", "setShareContent", "shareInfo", "Lcom/bytedance/android/ec/store/common/param/ECShareParam;", "getShareInfo", "()Lcom/bytedance/android/ec/store/common/param/ECShareParam;", "shareInfo$delegate", "shareObject", "getShareObject", "setShareObject", "storeAccountParam", "Lcom/bytedance/android/ec/store/common/param/StoreAccountParam;", "getStoreAccountParam", "()Lcom/bytedance/android/ec/store/common/param/StoreAccountParam;", "storeAccountParam$delegate", "storeDetailUrl", "getStoreDetailUrl", "setStoreDetailUrl", "storeGroupType", "getStoreGroupType", "setStoreGroupType", "storeHomePageUrl", "getStoreHomePageUrl", "setStoreHomePageUrl", "storeNaviParam", "Lcom/bytedance/android/ec/store/common/param/StoreNaviParam;", "getStoreNaviParam", "()Lcom/bytedance/android/ec/store/common/param/StoreNaviParam;", "storeNaviParam$delegate", "storeSourceMethod", "getStoreSourceMethod", "setStoreSourceMethod", "storeSourcePage", "getStoreSourcePage", "setStoreSourcePage", "storeUIParam", "Lcom/bytedance/android/shopping/store/home/api/StoreUIParam;", "getStoreUIParam", "()Lcom/bytedance/android/shopping/store/home/api/StoreUIParam;", "storeUIParam$delegate", "tabId", "getTabId", "setTabId", "taskEnterFrom", "getTaskEnterFrom", "setTaskEnterFrom", "taskType", "getTaskType", "setTaskType", "tempId", "getTempId", "setTempId", "whichAccount", "getWhichAccount", "setWhichAccount", "getPassThroughParam", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Ljava/lang/String;)Ljava/lang/Object;", "isPreview", "putPassThroughParam", "", "value", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StoreBaseParam implements Serializable {
    private ECAdLogExtra adLogExtra;
    private String anchorId;
    private String bcm;
    private String debugUrl;
    private String ecomJsonStr;
    private String ecomPitayaJsonStr;
    private String enterFrom;
    private String enterMethod;
    private String enterStoreEvent;
    private String entranceLocation;
    private String extraSchema;
    private FansClubInfo fansInfo;
    private Integer followStatus;
    private boolean fromProfile;
    private boolean isEcShare;
    private final boolean isLuban;
    private final boolean isV3Store;
    private String liveAnchorId;
    private String moduleLabel;
    private String pageFrom;
    private String pageName;
    private String pageType;
    private final Map<String, Object> passThroughParams;
    private String preGroupId;
    private String preProductId;
    private String preRoomId;
    private final Lazy productBasicRequestParam$delegate;
    private String productId;
    private String roomId;
    private String searchHint;
    private String searchParams;
    private String shareContent;
    private final Lazy shareInfo$delegate;
    private String shareObject;
    private final Lazy storeAccountParam$delegate;
    private String storeDetailUrl;
    private String storeGroupType;
    private String storeHomePageUrl;
    private final Lazy storeNaviParam$delegate;
    private String storeSourceMethod;
    private String storeSourcePage;
    private final Lazy storeUIParam$delegate;
    private Integer tabId;
    private String taskEnterFrom;
    private String taskType;
    private String tempId;
    private String whichAccount;

    public final ProductBasicRequestParam getProductBasicRequestParam() {
        return (ProductBasicRequestParam) this.productBasicRequestParam$delegate.getValue();
    }

    public final ECShareParam getShareInfo() {
        return (ECShareParam) this.shareInfo$delegate.getValue();
    }

    public final StoreAccountParam getStoreAccountParam() {
        return (StoreAccountParam) this.storeAccountParam$delegate.getValue();
    }

    public final StoreNaviParam getStoreNaviParam() {
        return (StoreNaviParam) this.storeNaviParam$delegate.getValue();
    }

    public final StoreUIParam getStoreUIParam() {
        return (StoreUIParam) this.storeUIParam$delegate.getValue();
    }

    public StoreBaseParam() {
        this.storeAccountParam$delegate = LazyKt.lazy(StoreBaseParam$storeAccountParam$2.INSTANCE);
        this.isV3Store = this instanceof ECStoreParam;
        this.productBasicRequestParam$delegate = LazyKt.lazy(StoreBaseParam$productBasicRequestParam$2.INSTANCE);
        this.storeUIParam$delegate = LazyKt.lazy(StoreBaseParam$storeUIParam$2.INSTANCE);
        this.shareInfo$delegate = LazyKt.lazy(StoreBaseParam$shareInfo$2.INSTANCE);
        this.storeNaviParam$delegate = LazyKt.lazy(StoreBaseParam$storeNaviParam$2.INSTANCE);
        this.passThroughParams = new LinkedHashMap();
        this.enterFrom = "open_url";
        this.pageName = "store_page";
        this.enterMethod = "click_comment";
        this.entranceLocation = "open_url";
        this.followStatus = -1;
        this.roomId = "";
        this.anchorId = "";
        this.preGroupId = "";
        this.preProductId = "";
        this.preRoomId = "";
    }

    public final boolean isPreview() {
        String r100 = getProductBasicRequestParam().getTmpId();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L18;
        String r102 = getProductBasicRequestParam().getToken();
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L18;
        return false;
    L13:
        if (r102.length() == 0) goto L16;
        r103 = false;
    L18:
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getBcm() {
        return this.bcm;
    }

    public final String getDebugUrl() {
        return this.debugUrl;
    }

    public final String getEcomJsonStr() {
        return this.ecomJsonStr;
    }

    public final String getEcomPitayaJsonStr() {
        return this.ecomPitayaJsonStr;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEnterStoreEvent() {
        return this.enterStoreEvent;
    }

    public final String getEntranceLocation() {
        return this.entranceLocation;
    }

    public final String getExtraSchema() {
        return this.extraSchema;
    }

    public final FansClubInfo getFansInfo() {
        return this.fansInfo;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final boolean getFromProfile() {
        return this.fromProfile;
    }

    public final String getLiveAnchorId() {
        return this.liveAnchorId;
    }

    public final String getModuleLabel() {
        return this.moduleLabel;
    }

    public final String getPageFrom() {
        return this.pageFrom;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getPageType() {
        return this.pageType;
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

    public final String getProductId() {
        return this.productId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSearchHint() {
        return this.searchHint;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public final String getShareContent() {
        return this.shareContent;
    }

    public final String getShareObject() {
        return this.shareObject;
    }

    public final String getStoreDetailUrl() {
        return this.storeDetailUrl;
    }

    public final String getStoreGroupType() {
        return this.storeGroupType;
    }

    public final String getStoreHomePageUrl() {
        return this.storeHomePageUrl;
    }

    public final String getStoreSourceMethod() {
        return this.storeSourceMethod;
    }

    public final String getStoreSourcePage() {
        return this.storeSourcePage;
    }

    public final Integer getTabId() {
        return this.tabId;
    }

    public final String getTaskEnterFrom() {
        return this.taskEnterFrom;
    }

    public final String getTaskType() {
        return this.taskType;
    }

    public final String getTempId() {
        return this.tempId;
    }

    public final String getWhichAccount() {
        return this.whichAccount;
    }

    public final boolean isEcShare() {
        return this.isEcShare;
    }

    public final boolean isLuban() {
        return this.isLuban;
    }

    public final boolean isV3Store() {
        return this.isV3Store;
    }

    public final <T> T getPassThroughParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) this.passThroughParams.get(r100);
        if ((r101 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r101;
    }

    public final void setAdLogExtra(ECAdLogExtra r100) {
        this.adLogExtra = r100;
    }

    public final void setAnchorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorId = r100;
    }

    public final void setBcm(String r100) {
        this.bcm = r100;
    }

    public final void setDebugUrl(String r100) {
        this.debugUrl = r100;
    }

    public final void setEcShare(boolean r100) {
        this.isEcShare = r100;
    }

    public final void setEcomJsonStr(String r100) {
        this.ecomJsonStr = r100;
    }

    public final void setEcomPitayaJsonStr(String r100) {
        this.ecomPitayaJsonStr = r100;
    }

    public final void setEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFrom = r100;
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethod = r100;
    }

    public final void setEnterStoreEvent(String r100) {
        this.enterStoreEvent = r100;
    }

    public final void setEntranceLocation(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entranceLocation = r100;
    }

    public final void setExtraSchema(String r100) {
        this.extraSchema = r100;
    }

    public final void setFansInfo(FansClubInfo r100) {
        this.fansInfo = r100;
    }

    public final void setFollowStatus(Integer r100) {
        this.followStatus = r100;
    }

    public final void setFromProfile(boolean r100) {
        this.fromProfile = r100;
    }

    public final void setLiveAnchorId(String r100) {
        this.liveAnchorId = r100;
    }

    public final void setModuleLabel(String r100) {
        this.moduleLabel = r100;
    }

    public final void setPageFrom(String r100) {
        this.pageFrom = r100;
    }

    public final void setPageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageName = r100;
    }

    public final void setPageType(String r100) {
        this.pageType = r100;
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

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomId = r100;
    }

    public final void setSearchHint(String r100) {
        this.searchHint = r100;
    }

    public final void setSearchParams(String r100) {
        this.searchParams = r100;
    }

    public final void setShareContent(String r100) {
        this.shareContent = r100;
    }

    public final void setShareObject(String r100) {
        this.shareObject = r100;
    }

    public final void setStoreDetailUrl(String r100) {
        this.storeDetailUrl = r100;
    }

    public final void setStoreGroupType(String r100) {
        this.storeGroupType = r100;
    }

    public final void setStoreHomePageUrl(String r100) {
        this.storeHomePageUrl = r100;
    }

    public final void setStoreSourceMethod(String r100) {
        this.storeSourceMethod = r100;
    }

    public final void setStoreSourcePage(String r100) {
        this.storeSourcePage = r100;
    }

    public final void setTabId(Integer r100) {
        this.tabId = r100;
    }

    public final void setTaskEnterFrom(String r100) {
        this.taskEnterFrom = r100;
    }

    public final void setTaskType(String r100) {
        this.taskType = r100;
    }

    public final void setTempId(String r100) {
        this.tempId = r100;
    }

    public final void setWhichAccount(String r100) {
        this.whichAccount = r100;
    }

    public final void putPassThroughParam(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.passThroughParams.put(r100, r101);
    }
}
