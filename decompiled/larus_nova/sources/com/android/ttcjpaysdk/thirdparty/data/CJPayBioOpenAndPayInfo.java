package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayBioOpenAndPayInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "confirm_button_text", "", "enable_bio_open", "icon_url", "loading_time_ms", "", "opened_fail_text", "opened_success_text", "opening_text", "switch_pay_type_text", "title", "token", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBioOpenAndPayInfo implements CJPayObject {
    public String confirm_button_text;
    public String enable_bio_open;
    public String icon_url;
    public long loading_time_ms;
    public String opened_fail_text;
    public String opened_success_text;
    public String opening_text;
    public String switch_pay_type_text;
    public String title;
    public String token;

    public CJPayBioOpenAndPayInfo() {
        this.title = "";
        this.icon_url = "";
        this.switch_pay_type_text = "";
        this.confirm_button_text = "";
        this.opening_text = "";
        this.opened_success_text = "";
        this.opened_fail_text = "";
        this.loading_time_ms = -1;
        this.token = "";
        this.enable_bio_open = "0";
    }
}
