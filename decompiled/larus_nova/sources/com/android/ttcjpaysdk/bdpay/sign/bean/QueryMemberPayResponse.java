package com.android.ttcjpaysdk.bdpay.sign.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.utils.CJUnifyPayEventUtils;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000fR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/bean/QueryMemberPayResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "code", "", "msg", "status", IGoogleService.ResponseKey.DISPLAY_NAME, CJUnifyPayEventUtils.PARAM_KEY_PAY_TYPE_LIST, "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/bdpay/sign/bean/PayTypeItem;", "Lkotlin/collections/ArrayList;", "first_pay_type_item", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/android/ttcjpaysdk/bdpay/sign/bean/PayTypeItem;)V", "hasBankCard", "", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QueryMemberPayResponse implements CJPayObject, Serializable {
    public String code;
    public String display_name;
    public PayTypeItem first_pay_type_item;
    public String msg;
    public ArrayList<PayTypeItem> pay_type_list;
    public String status;

    public QueryMemberPayResponse() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final boolean hasBankCard() {
        Iterator<T> r100 = this.pay_type_list.iterator();
    L4:
        if (r100.hasNext() == false) goto L14;
        Object r101 = r100.next();
        PayTypeItem r102 = (PayTypeItem) r101;
        if (Intrinsics.areEqual(r102.card_type, "DEBIT") == false) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L4;
    L15:
        if (r101 == null) goto L23;
        return true;
    L23:
        return false;
    L8:
        if (Intrinsics.areEqual(r102.card_type, "CREDIT") == true) goto L11;
        r103 = false;
        goto L12
    L14:
        r101 = null;
        goto L15
    }

    public QueryMemberPayResponse(String r100, String r101, String r102, String r103, ArrayList<PayTypeItem> r104, PayTypeItem r105) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "status");
        Intrinsics.checkNotNullParameter(r103, IGoogleService.ResponseKey.DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r104, CJUnifyPayEventUtils.PARAM_KEY_PAY_TYPE_LIST);
        Intrinsics.checkNotNullParameter(r105, "first_pay_type_item");
        this.code = r100;
        this.msg = r101;
        this.status = r102;
        this.display_name = r103;
        this.pay_type_list = r104;
        this.first_pay_type_item = r105;
    }

    public /* synthetic */ QueryMemberPayResponse(String r210, String r211, String r212, String r213, ArrayList r214, PayTypeItem r215, int r216, DefaultConstructorMarker r217) {
        String r100 = "";
        if ((r216 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r216 & 8) != 0) goto L19;
        r100 = r213;
    L19:
        if ((r216 & 16) == 0) goto L21;
        ArrayList r104 = new ArrayList();
    L23:
        if ((r216 & 32) == 0) goto L25;
        PayTypeItem r105 = new PayTypeItem(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L26:
        this(r101, r102, r103, r100, r104, r105);
        return;
    L25:
        r105 = r215;
        goto L26
    L21:
        r104 = r214;
        goto L23
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
