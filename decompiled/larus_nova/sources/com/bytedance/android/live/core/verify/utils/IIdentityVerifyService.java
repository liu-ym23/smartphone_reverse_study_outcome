package com.bytedance.android.live.core.verify.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001:\u0003%&'Jj\u0010\u0016\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0018\u001a\u00020\nH&J\b\u0010\u0019\u001a\u00020\rH&J \u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dH&J\n\u0010 \u001a\u0004\u0018\u00010\u0006H&J\n\u0010!\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\"\u001a\u00020\rH&J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H&¨\u0006("}, d2 = {"Lcom/bytedance/android/live/core/verify/utils/IIdentityVerifyService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/app/Activity;", "activity", "Lw80/a;", "certificationSubmit", "", "enterFrom", "Landroid/os/Bundle;", "logBundle", "", "type", "secureUid", "", "isInterceptOnAliPayAppUninstalled", "Lcom/bytedance/android/live/core/verify/utils/IIdentityVerifyService$c;", "onVerifyCallBack", "Lcom/bytedance/android/live/core/verify/utils/IIdentityVerifyService$b;", "getZhiMaSubmitInterface", "isSkipRecordVerify", "hasFetchedSubmit", "", "verify", "getVerifiedConfirmPageSource", "getRealVerifyType", "supportTryPreload", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "isSilent", "Lcom/bytedance/android/live/core/verify/utils/IIdentityVerifyService$a;", "getRealFaceIdentifySyncInterface", "getRealFaceIdentifySync", "getFaceIdentify", "getRealFaceIdentify", "hostOCRSdkReady", "realType", "mobReadSetting", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IIdentityVerifyService extends IService {

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    String getFaceIdentify();

    String getRealFaceIdentify();

    void getRealFaceIdentifySync(Context r100, boolean r101, a r102);

    int getRealVerifyType();

    String getVerifiedConfirmPageSource();

    boolean hostOCRSdkReady();

    void mobReadSetting(String r100, String r101);

    boolean supportTryPreload();

    void verify(Activity r100, w80.a r101, String r102, Bundle r103, int r104, String r105, boolean r106, c r107, b r108, boolean r110, boolean r111);
}
