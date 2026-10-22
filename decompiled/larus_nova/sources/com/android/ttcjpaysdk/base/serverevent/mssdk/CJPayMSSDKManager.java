package com.android.ttcjpaysdk.base.serverevent.mssdk;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.api.msm.MSMService;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import ve4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/serverevent/mssdk/CJPayMSSDKManager;", "", "()V", "isMSSDKInstalled", "", "checkMSSDKInstalled", "report", "", "sceneName", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayMSSDKManager {
    public static final CJPayMSSDKManager INSTANCE = null;
    private static volatile int isMSSDKInstalled;

    private CJPayMSSDKManager() {
    }

    static {
        INSTANCE = new CJPayMSSDKManager();
        isMSSDKInstalled = -1;
    }

    private final int checkMSSDKInstalled() {
        a.f554342a.getClass();
        MSMService r100 = (MSMService) a.a(MSMService.class);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.checkMSSDKInstalled();
    }

    @JvmStatic
    public static final void report(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L32;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        if (isMSSDKInstalled == 0) goto L35;
        String r103 = CJEnv.e();     // Catch: Throwable -> L29
        if (r103 != null) goto L15;
    L18:
        if (r101 == false) goto L21;
        return;
    L21:
        if (isMSSDKInstalled != (-1)) goto L25;
        isMSSDKInstalled = INSTANCE.checkMSSDKInstalled();     // Catch: Throwable -> L29
        if (isMSSDKInstalled != 0) goto L25;
        return;
    L25:
        a.f554342a.getClass();     // Catch: Throwable -> L29
        MSMService r104 = (MSMService) a.a(MSMService.class);     // Catch: Throwable -> L29
        if (r104 == null) goto L37;
        r104.report(r100, CJEnv.e());     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayMSSDKManager#report", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayMSSDKManager#report", th);
        return;
    L37:
        return;
    L15:
        if (r103.length() == 0) goto L18;
        r101 = false;
        goto L18
    L35:
        return;
    L32:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
