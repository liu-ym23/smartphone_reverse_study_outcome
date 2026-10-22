package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/FreqSuggestStyleInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "freq_suggest_style_index_list", "Ljava/util/ArrayList;", "", "has_suggest_card", "", BdpAppEventConstant.PARAMS_SUB_TITLE, "", "title", "title_button_label", "trade_confirm_button_label", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FreqSuggestStyleInfo implements CJPayObject, Serializable {
    public ArrayList<Integer> freq_suggest_style_index_list;
    public boolean has_suggest_card;
    public String sub_title;
    public String title;
    public String title_button_label;
    public String trade_confirm_button_label;

    public FreqSuggestStyleInfo() {
        this.title = "";
        this.sub_title = "";
        this.title_button_label = "";
        this.trade_confirm_button_label = "";
        this.freq_suggest_style_index_list = new ArrayList();
    }
}
