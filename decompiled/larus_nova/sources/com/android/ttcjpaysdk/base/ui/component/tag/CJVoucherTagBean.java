package com.android.ttcjpaysdk.base.ui.component.tag;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.map.api.monitor.MapMonitorConst;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherTagBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "actual_show_amount", "", "actual_show_amount_max", "event_type", "label", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherLabel;", "Lkotlin/collections/ArrayList;", "need_wrap", MapMonitorConst.STYLE_TYPE, "sub_pay_type_desc", "tag_border_color", "tag_fill_color", "tag_text_color", a.KEY_TAG_TYPE, "voucher_id", "voucher_msg_sub_type", "voucher_msg_type", "voucher_pos", "voucher_show_type", "isCombineType", "", "isDefaultType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJVoucherTagBean implements CJPayObject, Serializable {
    public String actual_show_amount;
    public String actual_show_amount_max;
    public String event_type;
    public ArrayList<CJVoucherLabel> label;
    public String need_wrap;
    public String style_type;
    public String sub_pay_type_desc;
    public String tag_border_color;
    public String tag_fill_color;
    public String tag_text_color;
    public String tag_type;
    public String voucher_id;
    public String voucher_msg_sub_type;
    public String voucher_msg_type;
    public String voucher_pos;
    public String voucher_show_type;

    public final boolean isCombineType() {
        return TextUtils.equals(this.event_type, "combine_pay");
    }

    public final boolean isDefaultType() {
        return TextUtils.equals(this.event_type, "default");
    }

    public CJVoucherTagBean() {
        this.actual_show_amount = "";
        this.actual_show_amount_max = "";
        this.event_type = "";
        this.style_type = "";
        this.label = new ArrayList();
        this.need_wrap = "";
        this.sub_pay_type_desc = "";
        this.voucher_id = "";
        this.voucher_msg_sub_type = "";
        this.voucher_msg_type = "";
        this.voucher_pos = "";
        this.tag_type = "";
        this.voucher_show_type = "";
        this.tag_border_color = "";
        this.tag_fill_color = "";
        this.tag_text_color = "";
    }
}
