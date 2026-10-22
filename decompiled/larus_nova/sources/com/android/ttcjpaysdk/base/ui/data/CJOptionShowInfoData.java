package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u001f\u001a\u00020 R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000e¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJOptionShowInfoData;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "crossed_price", "", "ext_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJOptionShowInfoDataExtInfo;", "ext_info_pb", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getExt_info_pb", "()Ljava/util/HashMap;", "setExt_info_pb", "(Ljava/util/HashMap;)V", "origin_asset_amount_desc", "recommend_voucher_info_list", "", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayUIComponent;", "standard_show_amount", "to_combine_asset_amount_desc", "toast_msg_info", "Lcom/android/ttcjpaysdk/base/ui/data/ToastMsgInfo;", "voucher_msg_info_list", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgInfo;", "voucher_msg_map", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean;", "voucher_msg_map_pb", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherTagBeanList;", "getVoucher_msg_map_pb", "setVoucher_msg_map_pb", "afterProtoDecode", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOptionShowInfoData implements CJPayObject, Serializable {
    public String crossed_price;
    public CJOptionShowInfoDataExtInfo ext_info;
    private HashMap<String, String> ext_info_pb;
    public String origin_asset_amount_desc;
    public List<CJPayUIComponent> recommend_voucher_info_list;
    public String standard_show_amount;
    public String to_combine_asset_amount_desc;
    public List<ToastMsgInfo> toast_msg_info;
    public List<AssetInfoBean.VoucherMsgInfo> voucher_msg_info_list;
    public AssetInfoBean.VoucherMsgBean voucher_msg_map;
    private HashMap<String, AssetInfoBean.VoucherTagBeanList> voucher_msg_map_pb;

    public final void afterProtoDecode() {
        this.voucher_msg_map = AssetInfoBeanKt.transVoucherMsgBean(this.voucher_msg_map_pb);
        HashMap<String, String> r100 = this.ext_info_pb;
        if (r100 != null) goto L5;
    L17:
        CJOptionShowInfoDataExtInfo r101 = null;
    L18:
        this.ext_info = r101;
        this.voucher_msg_map_pb = null;
        this.ext_info_pb = null;
        return;
    L5:
        if ((!r100.isEmpty()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L17;
        r101 = new CJOptionShowInfoDataExtInfo();
        String r102 = r100.get("select_page_priority_title");
        String r103 = "";
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        r101.select_page_priority_title = r102;
        String r104 = r100.get("select_page_priority_sub_title");
        if (r104 == null) goto L16;
        r103 = r104;
    L16:
        r101.select_page_priority_sub_title = r103;
        r101.sub_title_promo = r100.get("sub_title_promo");
        r101.desc_title = r100.get("desc_title");
        r101.trade_confirm_button_icon = r100.get("trade_confirm_button_icon");
        goto L18
    }

    public CJOptionShowInfoData() {
        this.voucher_msg_map = new AssetInfoBean.VoucherMsgBean();
    }

    public final HashMap<String, String> getExt_info_pb() {
        return this.ext_info_pb;
    }

    public final HashMap<String, AssetInfoBean.VoucherTagBeanList> getVoucher_msg_map_pb() {
        return this.voucher_msg_map_pb;
    }

    public final void setExt_info_pb(HashMap<String, String> r100) {
        this.ext_info_pb = r100;
    }

    public final void setVoucher_msg_map_pb(HashMap<String, AssetInfoBean.VoucherTagBeanList> r100) {
        this.voucher_msg_map_pb = r100;
    }
}
