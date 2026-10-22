package com.bytedance.android.window.shop.search.router;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.window.base.common.param.WindowAccountParam;
import com.bytedance.android.ec.window.base.common.param.WindowProductBasicRequestParam;
import com.bytedance.android.ec.window.base.repository.vo.WindowSearchSuggestWord;
import com.bytedance.android.shopping.extensions.k;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u008a\u00012\u00020\u0001:\u0002\u008b\u0001B<\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001d\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\f\u001a\u00020\u000bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001b\u0010\u001e\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R#\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010 \u001a\u0004\b/\u0010!\"\u0004\b0\u0010#R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R\u001a\u00104\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u0010R\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\u000e\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0012R\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u000e\u001a\u0004\b:\u0010\u0010\"\u0004\b;\u0010\u0012R$\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u000e\u001a\u0004\b=\u0010\u0010\"\u0004\b>\u0010\u0012R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\u000e\u001a\u0004\b@\u0010\u0010\"\u0004\bA\u0010\u0012R\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010\u000e\u001a\u0004\bC\u0010\u0010\"\u0004\bD\u0010\u0012R$\u0010E\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010\u000e\u001a\u0004\bF\u0010\u0010\"\u0004\bG\u0010\u0012R$\u0010H\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010\u000e\u001a\u0004\bI\u0010\u0010\"\u0004\bJ\u0010\u0012R$\u0010K\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u000e\u001a\u0004\bL\u0010\u0010\"\u0004\bM\u0010\u0012R$\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010\u000e\u001a\u0004\bO\u0010\u0010\"\u0004\bP\u0010\u0012R$\u0010R\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010X\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010\u000e\u001a\u0004\bY\u0010\u0010\"\u0004\bZ\u0010\u0012R$\u0010[\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\u000e\u001a\u0004\b\\\u0010\u0010\"\u0004\b]\u0010\u0012R$\u0010^\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010\u000e\u001a\u0004\b_\u0010\u0010\"\u0004\b`\u0010\u0012R\"\u0010a\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010 \u001a\u0004\ba\u0010!\"\u0004\bb\u0010#R$\u0010c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010\u000e\u001a\u0004\bd\u0010\u0010\"\u0004\be\u0010\u0012R$\u0010f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010\u000e\u001a\u0004\bg\u0010\u0010\"\u0004\bh\u0010\u0012R\"\u0010i\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010 \u001a\u0004\bi\u0010!\"\u0004\bj\u0010#R$\u0010k\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010\u000e\u001a\u0004\bl\u0010\u0010\"\u0004\bm\u0010\u0012R\"\u0010n\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010 \u001a\u0004\bo\u0010!\"\u0004\bp\u0010#R\u0017\u0010r\u001a\u00020q8\u0006¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR*\u0010x\u001a\n\u0012\u0004\u0012\u00020w\u0018\u00010v8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001c\u0010~\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b~\u0010\u000e\u001a\u0004\b\u007f\u0010\u0010R\u001f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010\u000e\u001a\u0005\b\u0081\u0001\u0010\u0010R\u001f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u000e\u001a\u0005\b\u0083\u0001\u0010\u0010R\u001f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010\u000e\u001a\u0005\b\u0085\u0001\u0010\u0010R\u0014\u0010\u0086\u0001\u001a\u00020Q8F¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001¨\u0006\u008c\u0001"}, d2 = {"Lcom/bytedance/android/window/shop/search/router/ECWindowSearchParam;", "Ljava/io/Serializable;", "", "key", "", "value", "", "putPassThroughParam", ExifInterface.GPS_DIRECTION_TRUE, "getPassThroughParam", "(Ljava/lang/String;)Ljava/lang/Object;", "", "isPreview", "entranceInfo", "Ljava/lang/String;", "getEntranceInfo", "()Ljava/lang/String;", "setEntranceInfo", "(Ljava/lang/String;)V", "searchHint", "getSearchHint", "setSearchHint", "searchKeyword", "getSearchKeyword", "setSearchKeyword", "Lcom/bytedance/android/ec/window/base/common/param/WindowAccountParam;", "storeAccountParam$delegate", "Lkotlin/Lazy;", "getStoreAccountParam", "()Lcom/bytedance/android/ec/window/base/common/param/WindowAccountParam;", "storeAccountParam", "isStoreHotSearch", "Z", "()Z", "setStoreHotSearch", "(Z)V", "enterMethod", "getEnterMethod", "setEnterMethod", "enterFrom", "getEnterFrom", "setEnterFrom", "", "passThroughParams", "Ljava/util/Map;", "getPassThroughParams", "()Ljava/util/Map;", "isHistory", "setHistory", "searchSource", "getSearchSource", "setSearchSource", "pageName", "getPageName", "entranceLocation", "getEntranceLocation", "setEntranceLocation", "enterFromSecond", "getEnterFromSecond", "setEnterFromSecond", "searchParams", "getSearchParams", "setSearchParams", "roomId", "getRoomId", "setRoomId", "anchorId", "getAnchorId", "setAnchorId", "tabNameSecond", "getTabNameSecond", "setTabNameSecond", "tabLabel", "getTabLabel", "setTabLabel", "tabName", "getTabName", "setTabName", "tempId", "getTempId", "setTempId", "", "followStatus", "Ljava/lang/Integer;", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "storeSourcePage", "getStoreSourcePage", "setStoreSourcePage", "storeSourceMethod", "getStoreSourceMethod", "setStoreSourceMethod", "storeGroupType", "getStoreGroupType", "setStoreGroupType", "isEcShare", "setEcShare", "shareContent", "getShareContent", "setShareContent", "shareObject", "getShareObject", "setShareObject", "isFromSug", "setFromSug", "groupId", "getGroupId", "setGroupId", "enableHideFloatLive", "getEnableHideFloatLive", "setEnableHideFloatLive", "Lcom/bytedance/android/ec/window/base/common/param/WindowProductBasicRequestParam;", "productBasicRequestParam", "Lcom/bytedance/android/ec/window/base/common/param/WindowProductBasicRequestParam;", "getProductBasicRequestParam", "()Lcom/bytedance/android/ec/window/base/common/param/WindowProductBasicRequestParam;", "", "Lcom/bytedance/android/ec/window/base/repository/vo/WindowSearchSuggestWord;", "searchSuggestWords", "Ljava/util/List;", "getSearchSuggestWords", "()Ljava/util/List;", "setSearchSuggestWords", "(Ljava/util/List;)V", "authorId", "getAuthorId", "secAuthorId", "getSecAuthorId", "shopId", "getShopId", "secShopId", "getSecShopId", "isFromAd", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowSearchParam implements Serializable {
    public static final a Companion = null;
    public static final String KEY_ENABLE_HIDE_FLOAT_LIVE = "enable_hide_float_live";
    private String anchorId;

    @SerializedName("author_id")
    private final String authorId;
    private boolean enableHideFloatLive;
    private String enterFrom;
    private String enterFromSecond;
    private String enterMethod;
    private String entranceInfo;
    private String entranceLocation;
    private Integer followStatus;
    private String groupId;
    private boolean isEcShare;
    private boolean isFromSug;
    private boolean isHistory;
    private boolean isStoreHotSearch;
    private final String pageName;
    private final Map<String, Object> passThroughParams;
    private final WindowProductBasicRequestParam productBasicRequestParam;
    private String roomId;
    private String searchHint;
    private String searchKeyword;
    private String searchParams;
    private String searchSource;
    private List<WindowSearchSuggestWord> searchSuggestWords;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    @SerializedName("sec_shop_id")
    private final String secShopId;
    private String shareContent;
    private String shareObject;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private final String shopId;
    private final Lazy storeAccountParam$delegate;
    private String storeGroupType;
    private String storeSourceMethod;
    private String storeSourcePage;
    private String tabLabel;
    private String tabName;
    private String tabNameSecond;
    private String tempId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECWindowSearchParam() {
        this(null, null, null, null, 15, null);
    }

    public final WindowAccountParam getStoreAccountParam() {
        return (WindowAccountParam) this.storeAccountParam$delegate.getValue();
    }

    public final int isFromAd() {
        JSONObject r100 = k.w(this.entranceInfo);
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.optInt("is_from_ad", 0);
    }

    public final boolean isPreview() {
        if (this.productBasicRequestParam.getTmpId() != null) goto L15;
        String r100 = this.productBasicRequestParam.getToken();
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    L15:
        return true;
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final boolean getEnableHideFloatLive() {
        return this.enableHideFloatLive;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterFromSecond() {
        return this.enterFromSecond;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getEntranceLocation() {
        return this.entranceLocation;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final Map<String, Object> getPassThroughParams() {
        return this.passThroughParams;
    }

    public final WindowProductBasicRequestParam getProductBasicRequestParam() {
        return this.productBasicRequestParam;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSearchHint() {
        return this.searchHint;
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

    public final List<WindowSearchSuggestWord> getSearchSuggestWords() {
        return this.searchSuggestWords;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
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

    public final String getTabLabel() {
        return this.tabLabel;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getTabNameSecond() {
        return this.tabNameSecond;
    }

    public final String getTempId() {
        return this.tempId;
    }

    public final boolean isEcShare() {
        return this.isEcShare;
    }

    public final boolean isFromSug() {
        return this.isFromSug;
    }

    public final boolean isHistory() {
        return this.isHistory;
    }

    public final boolean isStoreHotSearch() {
        return this.isStoreHotSearch;
    }

    public final <T> T getPassThroughParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) this.passThroughParams.get(r100);
        if ((r101 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r101;
    }

    public final void setAnchorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorId = r100;
    }

    public final void setEcShare(boolean r100) {
        this.isEcShare = r100;
    }

    public final void setEnableHideFloatLive(boolean r100) {
        this.enableHideFloatLive = r100;
    }

    public final void setEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFrom = r100;
    }

    public final void setEnterFromSecond(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFromSecond = r100;
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethod = r100;
    }

    public final void setEntranceInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entranceInfo = r100;
    }

    public final void setEntranceLocation(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entranceLocation = r100;
    }

    public final void setFollowStatus(Integer r100) {
        this.followStatus = r100;
    }

    public final void setFromSug(boolean r100) {
        this.isFromSug = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setHistory(boolean r100) {
        this.isHistory = r100;
    }

    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomId = r100;
    }

    public final void setSearchHint(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchHint = r100;
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

    public final void setSearchSuggestWords(List<WindowSearchSuggestWord> r100) {
        this.searchSuggestWords = r100;
    }

    public final void setShareContent(String r100) {
        this.shareContent = r100;
    }

    public final void setShareObject(String r100) {
        this.shareObject = r100;
    }

    public final void setStoreGroupType(String r100) {
        this.storeGroupType = r100;
    }

    public final void setStoreHotSearch(boolean r100) {
        this.isStoreHotSearch = r100;
    }

    public final void setStoreSourceMethod(String r100) {
        this.storeSourceMethod = r100;
    }

    public final void setStoreSourcePage(String r100) {
        this.storeSourcePage = r100;
    }

    public final void setTabLabel(String r100) {
        this.tabLabel = r100;
    }

    public final void setTabName(String r100) {
        this.tabName = r100;
    }

    public final void setTabNameSecond(String r100) {
        this.tabNameSecond = r100;
    }

    public final void setTempId(String r100) {
        this.tempId = r100;
    }

    public final void putPassThroughParam(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.passThroughParams.put(r100, r101);
    }

    public ECWindowSearchParam(String r100, String r101, String r102, String r103) {
        this.authorId = r100;
        this.secAuthorId = r101;
        this.shopId = r102;
        this.secShopId = r103;
        this.entranceInfo = "";
        this.searchHint = "";
        this.searchKeyword = "";
        this.storeAccountParam$delegate = LazyKt.lazy(ECWindowSearchParam$storeAccountParam$2.INSTANCE);
        this.enterMethod = "";
        this.enterFrom = "";
        this.passThroughParams = new LinkedHashMap();
        this.pageName = "store_page";
        this.entranceLocation = "";
        this.enterFromSecond = "";
        this.roomId = "";
        this.anchorId = "";
        this.followStatus = -1;
        this.productBasicRequestParam = new WindowProductBasicRequestParam();
    }

    public /* synthetic */ ECWindowSearchParam(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
