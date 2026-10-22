package com.android.ttcjpaysdk.bdpay.counter.outer.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.thirdparty.data.CJPayAppUserInfo;
import com.bytedance.android.ec.core.event.a;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPayRecommendUserInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "app_user_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayAppUserInfo;", "button_action", "", "button_title", "promotion_voucher_info", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPayPromotionVoucherInfo;", "recommend_msg", a.KEY_RECOMMEND_TYPE, "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRecommendUserInfo implements CJPayObject, Serializable {
    public CJPayAppUserInfo app_user_info;
    public String button_action;
    public String button_title;
    public CJPayPromotionVoucherInfo promotion_voucher_info;
    public String recommend_msg;
    public String recommend_type;

    public CJPayRecommendUserInfo() {
        this.recommend_type = "";
        this.recommend_msg = "";
        this.button_title = "";
        this.button_action = "";
    }
}
