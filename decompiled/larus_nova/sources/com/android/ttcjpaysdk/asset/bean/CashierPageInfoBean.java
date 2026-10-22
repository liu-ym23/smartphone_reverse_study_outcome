package com.android.ttcjpaysdk.asset.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPayTypeInfo;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/asset/bean/CashierPageInfoBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "asset_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "collected_asset_ext_map", "", "ext_info", "", "out_display_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayTypeInfo$OutDisplayInfo;", "pay_again_display_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayTypeInfo$PayAgainDisplayInfo;", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CashierPageInfoBean implements CJPayObject, Serializable {
    public AssetInfoBean asset_info;
    public String collected_asset_ext_map;
    public Map<String, String> ext_info;
    public CJPayPayTypeInfo.OutDisplayInfo out_display_info;
    public CJPayPayTypeInfo.PayAgainDisplayInfo pay_again_display_info;

    public CashierPageInfoBean() {
        this.asset_info = new AssetInfoBean();
        this.out_display_info = new CJPayPayTypeInfo.OutDisplayInfo();
        this.pay_again_display_info = new CJPayPayTypeInfo.PayAgainDisplayInfo();
        this.collected_asset_ext_map = "";
        this.ext_info = MapsKt.emptyMap();
    }
}
