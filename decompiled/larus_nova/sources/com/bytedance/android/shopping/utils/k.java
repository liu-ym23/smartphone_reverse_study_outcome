package com.bytedance.android.shopping.utils;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.ec.common.api.domainselect.IDomainSelect;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class k {
    public static String a() {
        int r100 = ECSdk.f48106a;
        IDomainSelect r101 = (IDomainSelect) ECSdk.a(IDomainSelect.class);
        if (r101 == null) goto L12;
        String r102 = r101.selectedHost();
        if (r102 == null) goto L12;
        if (StringsKt.trim(r102).toString().length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        return r102;
    L9:
        r103 = false;
    L12:
        return CJPayConstant.TT_CJ_PAY_FOLLOW_HOST;
    }

    static {
    }
}
