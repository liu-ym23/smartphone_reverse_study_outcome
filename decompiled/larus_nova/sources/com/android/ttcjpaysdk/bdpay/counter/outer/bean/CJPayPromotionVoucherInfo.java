package com.android.ttcjpaysdk.bdpay.counter.outer.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0005R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPayPromotionVoucherInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "is_show_voucher_page", "", "promotion_activitys", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPayPromotionActivity;", "Lkotlin/collections/ArrayList;", "promotion_desc", "", "promotion_lynx_style", "promotion_prefix", "promotion_schema", "promotion_style", "isLynxVoucher", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayPromotionVoucherInfo implements CJPayObject, Serializable {
    public boolean is_show_voucher_page;
    public ArrayList<CJPayPromotionActivity> promotion_activitys;
    public String promotion_desc;
    public String promotion_lynx_style;
    public String promotion_prefix;
    public String promotion_schema;
    public String promotion_style;

    public final boolean isLynxVoucher() {
        if (this.promotion_schema.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L10:
        return false;
    L8:
        if (CollectionsKt.listOf(new String[]{"1", "2"}).contains(this.promotion_style) == false) goto L10;
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public CJPayPromotionVoucherInfo() {
        this.promotion_activitys = new ArrayList();
        this.promotion_prefix = "";
        this.promotion_desc = "";
        this.promotion_schema = "";
        this.promotion_style = "";
        this.promotion_lynx_style = "";
    }
}
