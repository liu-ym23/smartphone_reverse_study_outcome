package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u0001`\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050&8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayAddiItemInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "background_color", "", "choose", "", "crossed_price", "display_mode", "", "fold_voucher_info", "Lcom/android/ttcjpaysdk/base/ui/data/FrontPayTypeData$HomePageFoldVoucherInfo;", "has_discount", "icon_url", "item_label", "lynx_load_wait_time", "", SendClosePdpEventParam.KEY_LYNX_URL, "need_show_voucher_enhance", "not_choose_msg", "pay_addi_info_type", "primary_combine_pay_info_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/FrontPayTypeData$PrimaryCombinePayInfoList;", "Lkotlin/collections/ArrayList;", "right_button_action", "right_button_desc", "right_msg", "right_msg_desc", "right_msg_desc_prefix", "standard_retain_voucher_label", "standard_show_amount", "standard_voucher_label", "sub_right_msg_desc", "trade_confirm_voucher_enhance_msg", "voucher_hit_type", "voucher_msg_list", "", "voucher_no_list", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayAddiItemInfo implements CJPayObject, Serializable {
    public String background_color;
    public boolean choose;
    public String crossed_price;
    public int display_mode;
    public FrontPayTypeData.HomePageFoldVoucherInfo fold_voucher_info;
    public boolean has_discount;
    public String icon_url;
    public String item_label;
    public long lynx_load_wait_time;
    public String lynx_url;
    public boolean need_show_voucher_enhance;
    public String not_choose_msg;
    public String pay_addi_info_type;
    public ArrayList<FrontPayTypeData.PrimaryCombinePayInfoList> primary_combine_pay_info_list;
    public String right_button_action;
    public String right_button_desc;
    public String right_msg;
    public String right_msg_desc;
    public String right_msg_desc_prefix;
    public String standard_retain_voucher_label;
    public String standard_show_amount;
    public String standard_voucher_label;
    public String sub_right_msg_desc;
    public String trade_confirm_voucher_enhance_msg;
    public String voucher_hit_type;
    public List<String> voucher_msg_list;
    public ArrayList<String> voucher_no_list;

    public CJPayAddiItemInfo() {
        this.not_choose_msg = "";
        this.choose = true;
        this.pay_addi_info_type = "";
        this.right_msg_desc_prefix = "";
        this.right_msg_desc = "";
        this.sub_right_msg_desc = "";
        this.right_msg = "";
        this.right_button_desc = "";
        this.right_button_action = "";
        this.standard_show_amount = "";
        this.standard_voucher_label = "";
        this.crossed_price = "";
        this.icon_url = "";
        this.item_label = "";
        this.fold_voucher_info = new FrontPayTypeData.HomePageFoldVoucherInfo();
        this.standard_retain_voucher_label = "";
        this.voucher_msg_list = new ArrayList();
        this.trade_confirm_voucher_enhance_msg = "";
        this.background_color = "";
        this.lynx_url = "";
        this.lynx_load_wait_time = 2000;
        this.voucher_hit_type = "";
    }
}
