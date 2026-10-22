package com.android.ttcjpaysdk.bindcard.unionpay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayProtocolGroupContentsBean;
import com.bytedance.android.ec.core.event.a;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayBankBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "bank_card_id", "", "bank_code", "bank_name", "card_no_mask", a.KEY_CARD_TYPE, "display_desc", "icon_url", "isChecked", "", "protocol_group_contents", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupContentsBean;", "status", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayBankBean implements CJPayObject, Serializable {
    public String bank_card_id;
    public String bank_code;
    public String bank_name;
    public String card_no_mask;
    public String card_type;
    public String display_desc;
    public String icon_url;
    public boolean isChecked;
    public CJPayProtocolGroupContentsBean protocol_group_contents;
    public String status;

    public UnionPayBankBean() {
        this.bank_card_id = "";
        this.bank_code = "";
        this.card_type = "";
        this.bank_name = "";
        this.card_no_mask = "";
        this.icon_url = "";
        this.status = "";
        this.display_desc = "";
        this.protocol_group_contents = new CJPayProtocolGroupContentsBean();
    }
}
