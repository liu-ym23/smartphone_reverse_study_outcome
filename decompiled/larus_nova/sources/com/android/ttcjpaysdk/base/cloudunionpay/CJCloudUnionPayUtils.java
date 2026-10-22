package com.android.ttcjpaysdk.base.cloudunionpay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.caijing.sdk.infra.base.api.cloudunionpay.CloudUnionPayService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/cloudunionpay/CJCloudUnionPayUtils;", "", "()V", "getVersion", "", "isInstalled", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "pay", "", "activity", "Landroid/app/Activity;", "payData", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJCloudUnionPayUtils {
    public static final CJCloudUnionPayUtils INSTANCE = null;

    static {
        INSTANCE = new CJCloudUnionPayUtils();
    }

    private CJCloudUnionPayUtils() {
    }

    public final String getVersion() {
        a.f554342a.getClass();
        CloudUnionPayService r100 = (CloudUnionPayService) a.a(CloudUnionPayService.class);
        if (r100 == null) goto L6;
        String r101 = r100.getVersion();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final boolean isInstalled(Context r100) {
        if (r100 != null) goto L12;
        return false;
    L12:
        if (CJPayBasicUtils.checkAppInstalled(r100, "com.unionpay") == false) goto L11;
        return true;
    L11:
        return false;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJCloudUnionPayUtils#isInstalled", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJCloudUnionPayUtils#isInstalled", e);
        goto L11
    }

    public final void pay(Activity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "payData");
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        a.f554342a.getClass();
        CloudUnionPayService r102 = (CloudUnionPayService) a.a(CloudUnionPayService.class);
        if (r102 == null) goto L9;
        r102.pay(r100, r101, new AnonymousClass1());
        return;
    }
}
