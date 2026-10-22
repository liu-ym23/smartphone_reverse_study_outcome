package com.android.ttcjpaysdk.superpay;

import android.app.Activity;
import android.content.Context;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayH5LynxUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ&\u0010\t\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/superpay/SuperPaySign;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", d.D, "", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "(Landroid/content/Context;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/CJPayHostInfo;)V", "openLynxPage", "", "Companion", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SuperPaySign {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/superpay/SuperPaySign$Companion;", "", "()V", "isSuperPaySign", "", d.D, "", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean isSuperPaySign(String r100) {
            if (r100 != null) goto L10;
            return false;
        L10:
            return new JSONObject(new JSONObject(r100).optString("extra")).optBoolean("is_super_pay_open");
        L7:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("SuperPaySign#isSuperPaySign", e);
            CJBasicCommonUtils.logCatch("CJCatch", "SuperPaySign#isSuperPaySign", e);
            return false;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SuperPaySign(Context r100, String r101, CJPayHostInfo r102) {
        openLynxPage(r100, r101, r102);
    }

    private final void openLynxPage(Context r100, String r101, CJPayHostInfo r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof Activity) == false) goto L14;
        if (r101 == null) goto L15;
        String r103 = new JSONObject(r101).optString("url");     // Catch: Exception -> L8
        CJPayH5LynxUtil.INSTANCE.openLynxPageWithCallback((Activity) r100, r103, CJPayHostInfo.Companion.copy(r102), SuperPaySign$openLynxPage$1$1.INSTANCE);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SuperPaySign#openLynxPage", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SuperPaySign#openLynxPage", e);
        return;
    L15:
        return;
    }
}
