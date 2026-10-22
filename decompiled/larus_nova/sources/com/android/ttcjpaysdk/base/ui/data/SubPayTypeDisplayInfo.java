package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/SubPayTypeDisplayInfo;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "icon_url", "", "password_page_desc_title", "payment_info", "sub_pay_type", "title", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubPayTypeDisplayInfo implements Serializable, CJPayObject {
    public String icon_url;
    public String password_page_desc_title;
    public String payment_info;
    public String sub_pay_type;
    public String title;

    public SubPayTypeDisplayInfo() {
        this.sub_pay_type = "";
        this.icon_url = "";
        this.title = "";
        this.payment_info = "";
        this.password_page_desc_title = "";
    }
}
