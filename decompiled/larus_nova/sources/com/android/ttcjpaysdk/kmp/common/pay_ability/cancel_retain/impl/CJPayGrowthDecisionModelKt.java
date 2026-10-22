package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.impl;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CJPayRetainContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"cancelRetainContactKey", "", "contactInfo", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfo;", "cj_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CJPayGrowthDecisionModelKt {
    public static final String cancelRetainContactKey(CJPayRetainContactInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "contactInfo");
        String r101 = r100.getProcess();
        boolean r102 = true;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        String r104 = "Default";
        if (r103 == false) goto L9;
        r101 = "Default";
    L9:
        String r105 = r100.getFunction();
        if (r105.length() != 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        r105 = "Default";
    L15:
        String r107 = r100.getBehavior();
        if (r107.length() != 0) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == false) goto L21;
        r107 = "Default";
    L21:
        String r109 = r100.getUserState();
        if (r109.length() == 0) goto L25;
        r102 = false;
    L25:
        if (r102 == true) goto L29;
        r104 = r109;
    L29:
        return r101 + '_' + r105 + '_' + r107 + '_' + r104;
    L18:
        r108 = false;
        goto L19
    L12:
        r106 = false;
        goto L13
    L5:
        r103 = false;
        goto L6
    }
}
