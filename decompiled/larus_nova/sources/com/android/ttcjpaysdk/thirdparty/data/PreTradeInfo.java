package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.asset.bean.CashierPageInfoBean;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.Utils.AssetLogUtils;
import com.android.ttcjpaysdk.base.ui.data.RetainInfo;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B{\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/PreTradeInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "merchant_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo;", "paytype_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayTypeInfo;", "cashier_page_info", "Lcom/android/ttcjpaysdk/asset/bean/CashierPageInfoBean;", "grey_func_map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "user_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayUserInfo;", "promotion_process", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayProcessInfo;", "retain_info", "Lcom/android/ttcjpaysdk/base/ui/data/RetainInfo;", "ext_param", "track_exts", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo;Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayTypeInfo;Lcom/android/ttcjpaysdk/asset/bean/CashierPageInfoBean;Ljava/util/HashMap;Lcom/android/ttcjpaysdk/thirdparty/data/CJPayUserInfo;Lcom/android/ttcjpaysdk/thirdparty/data/CJPayProcessInfo;Lcom/android/ttcjpaysdk/base/ui/data/RetainInfo;Ljava/lang/String;Ljava/lang/String;)V", "isAssetStandard", "", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreTradeInfo implements CJPayObject, Serializable {
    public CashierPageInfoBean cashier_page_info;
    public String ext_param;
    public HashMap<String, String> grey_func_map;
    public CJPayMerchantInfo merchant_info;
    public CJPayPayTypeInfo paytype_info;
    public CJPayProcessInfo promotion_process;
    public RetainInfo retain_info;
    public String track_exts;
    public CJPayUserInfo user_info;

    public PreTradeInfo() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public final boolean isAssetStandard() {
        return Intrinsics.areEqual("1", this.grey_func_map.get(AssetLogUtils.CJ_PAY_ASSET_STD));
    }

    public PreTradeInfo(CJPayMerchantInfo r100, CJPayPayTypeInfo r101, CashierPageInfoBean r102, HashMap<String, String> r103, CJPayUserInfo r104, CJPayProcessInfo r105, RetainInfo r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "merchant_info");
        Intrinsics.checkNotNullParameter(r101, "paytype_info");
        Intrinsics.checkNotNullParameter(r102, "cashier_page_info");
        Intrinsics.checkNotNullParameter(r103, "grey_func_map");
        Intrinsics.checkNotNullParameter(r104, "user_info");
        Intrinsics.checkNotNullParameter(r105, "promotion_process");
        Intrinsics.checkNotNullParameter(r106, "retain_info");
        Intrinsics.checkNotNullParameter(r107, "ext_param");
        Intrinsics.checkNotNullParameter(r110, "track_exts");
        this.merchant_info = r100;
        this.paytype_info = r101;
        this.cashier_page_info = r102;
        this.grey_func_map = r103;
        this.user_info = r104;
        this.promotion_process = r105;
        this.retain_info = r106;
        this.ext_param = r107;
        this.track_exts = r110;
    }

    public /* synthetic */ PreTradeInfo(CJPayMerchantInfo r210, CJPayPayTypeInfo r310, CashierPageInfoBean r311, HashMap r312, CJPayUserInfo r313, CJPayProcessInfo r314, RetainInfo r315, String r316, String r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        CJPayMerchantInfo r100 = new CJPayMerchantInfo();
    L7:
        if ((r318 & 2) == 0) goto L9;
        CJPayPayTypeInfo r101 = new CJPayPayTypeInfo();
    L11:
        if ((r318 & 4) == 0) goto L13;
        CashierPageInfoBean r102 = new CashierPageInfoBean();
    L15:
        if ((r318 & 8) == 0) goto L17;
        HashMap r103 = new HashMap();
    L19:
        if ((r318 & 16) == 0) goto L21;
        CJPayUserInfo r104 = new CJPayUserInfo();
    L23:
        if ((r318 & 32) == 0) goto L25;
        CJPayProcessInfo r105 = new CJPayProcessInfo();
    L27:
        if ((r318 & 64) == 0) goto L29;
        RetainInfo r106 = new RetainInfo(null, null, null, null, false, null, null, null, false, null, null, null, null, null, false, null, null, 131071, null);
    L30:
        String r107 = "";
        if ((r318 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r318 & 256) != 0) goto L38;
        r107 = r317;
    L38:
        this(r100, r101, r102, r103, r104, r105, r106, r108, r107);
        return;
    L33:
        r108 = r316;
        goto L35
    L29:
        r106 = r315;
        goto L30
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
