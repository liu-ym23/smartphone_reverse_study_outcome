package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/FreqSuggestCardInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "has_suggest_card", "", "sub_pay_type_info", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontSubPayTypeInfo;", "title_button_label", "", "trade_confirm_button_label", "type", "", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FreqSuggestCardInfo implements CJPayObject, Serializable {
    public boolean has_suggest_card;
    public FrontSubPayTypeInfo sub_pay_type_info;
    public String title_button_label;
    public String trade_confirm_button_label;
    public int type;

    public FreqSuggestCardInfo() {
        this.title_button_label = "";
        this.trade_confirm_button_label = "";
        this.sub_pay_type_info = new FrontSubPayTypeInfo();
    }
}
