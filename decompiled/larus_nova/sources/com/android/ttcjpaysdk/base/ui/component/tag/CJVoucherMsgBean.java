package com.android.ttcjpaysdk.base.ui.component.tag;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherMsgBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "premium_feel_tag", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherTagBean;", "Lkotlin/collections/ArrayList;", "tag12", "tag34", "tag56", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJVoucherMsgBean implements CJPayObject, Serializable {
    public ArrayList<CJVoucherTagBean> premium_feel_tag;
    public ArrayList<CJVoucherTagBean> tag12;
    public ArrayList<CJVoucherTagBean> tag34;
    public ArrayList<CJVoucherTagBean> tag56;

    public CJVoucherMsgBean() {
        this.tag12 = new ArrayList();
        this.tag34 = new ArrayList();
        this.tag56 = new ArrayList();
        this.premium_feel_tag = new ArrayList();
    }
}
