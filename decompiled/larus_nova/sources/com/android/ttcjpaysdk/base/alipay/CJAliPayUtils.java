package com.android.ttcjpaysdk.base.alipay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayBPEAService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.api.alipay.AliPayService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
public class CJAliPayUtils {
    private static String aliSdkVersion = "";

    public CJAliPayUtils() {
    }

    public static String getAliSdkVersion() {
        return aliSdkVersion;
    }

    public static boolean isAliPayInstalled(Context r100) {
        if (new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse("alipays://platformapi/startApp")).resolveActivity(r100.getPackageManager()) == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJAliPayUtils#Intent", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJAliPayUtils#Intent", e);
        return false;
    }

    public static String pay(Activity r100, final String r101) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        a.f554342a.getClass();
        final AliPayService r102 = (AliPayService) a.a(AliPayService.class);
        final Object r103 = r102.createPayTask(r100);
        aliSdkVersion = r102.getVersion(r103);
        ICJPayBPEAService r104 = (ICJPayBPEAService) CJPayServiceManager.getInstance().getIService(ICJPayBPEAService.class);
        if (r104 == null) goto L11;
        return r104.alipay(new AnonymousClass1(r102, r103, r101));
    L11:
        return r102.executePay(r103, r101, true);
    L14:
        return "";
    }
}
