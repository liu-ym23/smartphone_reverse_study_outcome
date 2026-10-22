package com.bytedance.android.shopping.anchorv3.repository.api;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0000H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H&J#\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\tH&J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\tH&J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\tH&J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\u001f\u001a\u00020\f2\u0010\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010!H&J\u0017\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010$J\u0012\u0010%\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H&\u0082\u0001\u0002&'¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/api/PdpPackRequestParam;", "Ljava/io/Serializable;", "()V", "asJsonDescription", "Lorg/json/JSONObject;", "getEcomSceneId", "", "getSimplifiedCacheKey", "isInSplit", "", "isPreload", "updateAddressDetail", "", "addressList", "updateAddressId", "userAddressId", "userAddrType", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "updateClientStorage", "clientStorage", "updateFullResp", "fullResp", "updateIsAuth", "isAuth", "updateIsExpanded", "isExpanded", "updateNormalSkuId", "normalSkuId", "updateRefreshRepParams", "params", "updateSelectedIds", "selectedIds", "", "updateShopRecommendTabIndex", "index", "(Ljava/lang/Integer;)V", "updateSkuSwitch", "Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;", "Lcom/bytedance/android/shopping/anchorv3/repository/api/SchemaPackRequest;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public abstract class PdpPackRequestParam implements Serializable {
    private PdpPackRequestParam() {
    }

    public abstract JSONObject asJsonDescription();

    public abstract String getEcomSceneId();

    public abstract PdpPackRequestParam getSimplifiedCacheKey();

    public abstract boolean isInSplit();

    /* JADX INFO: renamed from: isPreload */
    public abstract boolean mo8285isPreload();

    public abstract void updateAddressDetail(String r100);

    public abstract void updateAddressId(String r100, Integer r101);

    public abstract void updateClientStorage(String r100);

    public abstract void updateFullResp(boolean r100);

    public abstract void updateIsAuth(boolean r100);

    public abstract void updateIsExpanded(boolean r100);

    public abstract void updateNormalSkuId(String r100);

    public abstract void updateRefreshRepParams(String r100);

    public abstract void updateSelectedIds(List<String> r100);

    public abstract void updateShopRecommendTabIndex(Integer r100);

    public abstract void updateSkuSwitch(String r100);

    public /* synthetic */ PdpPackRequestParam(DefaultConstructorMarker r100) {
        this();
    }

    public static /* synthetic */ void updateAddressId$default(PdpPackRequestParam r100, String r101, Integer r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.updateAddressId(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAddressId");
    }
}
