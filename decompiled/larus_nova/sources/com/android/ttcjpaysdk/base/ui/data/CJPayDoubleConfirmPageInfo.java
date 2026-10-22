package com.android.ttcjpaysdk.base.ui.data;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayDoubleConfirmPageInfo;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "Ljava/io/Serializable;", "()V", "bubble_desc_icon_url", "", "bubble_desc_text", "button_style", "hit_type", "main_button_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayTopRightBtnInfo;", "page_plain_text", "payment_instruction_icon", "payment_instruction_text", "show_change_pay_type_region", "sub_button_info", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayDoubleConfirmPageInfo extends CJPayPayInfo implements Serializable {
    public String bubble_desc_icon_url;
    public String bubble_desc_text;
    public String button_style;
    public String hit_type;
    public CJPayTopRightBtnInfo main_button_info;
    public String page_plain_text;
    public String payment_instruction_icon;
    public String payment_instruction_text;
    public String show_change_pay_type_region;
    public CJPayTopRightBtnInfo sub_button_info;

    public CJPayDoubleConfirmPageInfo() {
        this.bubble_desc_text = "";
        this.bubble_desc_icon_url = "";
        this.button_style = "";
        this.hit_type = "";
        this.page_plain_text = "";
        this.payment_instruction_text = "";
        this.payment_instruction_icon = "";
        this.show_change_pay_type_region = "";
    }
}
