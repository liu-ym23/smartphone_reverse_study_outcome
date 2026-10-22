package com.android.ttcjpaysdk.bdpay.counter.outer.utils;

import com.android.ttcjpaysdk.base.paynologin.CJBDPayWithoutLoginUtils;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayHostService;
import com.bytedance.caijing.sdk.infra.base.account.CJAccount;
import kotlin.Metadata;
import xc4.f;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/utils/CJOuterCommonUtils;", "", "", "checkLivePluginAvailable", "Lxc4/f;", "getCurrentUserInfo", "<init>", "()V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0})
public final class CJOuterCommonUtils {
    public static final CJOuterCommonUtils INSTANCE = null;

    static {
        INSTANCE = new CJOuterCommonUtils();
    }

    private CJOuterCommonUtils() {
    }

    public final f getCurrentUserInfo() {
        CJBDPayWithoutLoginUtils r100 = CJBDPayWithoutLoginUtils.INSTANCE;
        if (r100.isPayWithoutLogin() == false) goto L5;
        CJOuterCommonUtils r101 = this;
    L6:
        if (r101 == null) goto L10;
        f r102 = r100.getHostUserInfo();
        if (r102 == null) goto L10;
        return r102;
    L10:
        return CJAccount.a();
    L5:
        r101 = null;
        goto L6
    }

    public final boolean checkLivePluginAvailable() {
        ICJPayHostService r100 = (ICJPayHostService) CJPayServiceManager.getInstance().getIService(ICJPayHostService.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isLivePluginAvailable();
    }
}
