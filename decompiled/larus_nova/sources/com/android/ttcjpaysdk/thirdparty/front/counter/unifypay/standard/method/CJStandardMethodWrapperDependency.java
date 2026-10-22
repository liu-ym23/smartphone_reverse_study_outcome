package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.method;

import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.android.ttcjpaysdk.std.asset.bean.StdAssetListBean;
import com.android.ttcjpaysdk.thirdparty.data.FrontPreTradeInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u000e\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\nH&JF\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062$\u0010\u0014\u001a \u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00110\u0015H&J6\u0010\u0016\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00110\u0017H&J\u001c\u0010\u0018\u001a\u00020\u00112\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0003H&¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/method/CJStandardMethodWrapperDependency;", "", "applyCurrentPaymentMethodFromQueryResult", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "assetInfo", "topAssetList", "Lorg/json/JSONArray;", "buildAssetListData", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetListBean;", ShareData.ISCOMBINEPAY, "", "getCachedPayType", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontPreTradeInfo;", "getCurPaymentMethodInfo", "isIndependentCashierShow", "isShowCombineStyle", "queryPayType", "", "creditPayActivateStatus", "", "callback", "Lkotlin/Function3;", "queryPayTypeIgnoreCache", "Lkotlin/Function1;", "saveCollapseMap", "map", "", "updateCurrentPaymentMethod", "newMethod", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJStandardMethodWrapperDependency {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void queryPayType$default(CJStandardMethodWrapperDependency r100, String r101, JSONArray r102, Function3 r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 1) == 0) goto L7;
            r101 = null;
        L7:
            if ((r104 & 2) == 0) goto L9;
            r102 = null;
        L9:
            r100.queryPayType(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryPayType");
        }

        public static /* synthetic */ void queryPayTypeIgnoreCache$default(CJStandardMethodWrapperDependency r100, String r101, JSONArray r102, Function1 r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 1) == 0) goto L7;
            r101 = null;
        L7:
            if ((r104 & 2) == 0) goto L9;
            r102 = null;
        L9:
            r100.queryPayTypeIgnoreCache(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryPayTypeIgnoreCache");
        }
    }

    AssetInfoBean applyCurrentPaymentMethodFromQueryResult(AssetInfoBean r100, JSONArray r101);

    StdAssetListBean buildAssetListData(AssetInfoBean r100, boolean r101);

    FrontPreTradeInfo getCachedPayType();

    AssetInfoBean getCurPaymentMethodInfo();

    boolean isIndependentCashierShow();

    boolean isShowCombineStyle();

    void queryPayType(String r100, JSONArray r101, Function3<? super FrontPreTradeInfo, ? super String, ? super String, Unit> r102);

    void queryPayTypeIgnoreCache(String r100, JSONArray r101, Function1<? super FrontPreTradeInfo, Unit> r102);

    void saveCollapseMap(Map<String, Boolean> r100);

    void updateCurrentPaymentMethod(AssetInfoBean r100);
}
