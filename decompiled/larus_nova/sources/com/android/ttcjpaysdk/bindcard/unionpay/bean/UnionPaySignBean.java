package com.android.ttcjpaysdk.bindcard.unionpay.bean;

import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBindCardBaseBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayButtonInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPaySignBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayBindCardBaseBean;", "button_info", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayButtonInfo;", "(Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayButtonInfo;)V", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPaySignBean extends CJPayBindCardBaseBean {
    public CJPayButtonInfo button_info;

    /* JADX WARN: Multi-variable type inference failed */
    public UnionPaySignBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public UnionPaySignBean(CJPayButtonInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "button_info");
        this.button_info = r100;
    }

    public /* synthetic */ UnionPaySignBean(CJPayButtonInfo r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new CJPayButtonInfo();
    L5:
        this(r100);
    }
}
