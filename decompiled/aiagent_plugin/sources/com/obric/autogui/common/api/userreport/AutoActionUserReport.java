package com.obric.autogui.common.api.userreport;

import android.content.Context;
import com.obric.autogui.common.api.app.HostAppInfo;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.ugc.aweme.framework.services.DynamicProxy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AutoActionUserReport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionUserReport implements IAutoActionUserReportApi {
    public static final AutoActionUserReport INSTANCE = null;

    static {
        INSTANCE = new AutoActionUserReport();
    }

    private AutoActionUserReport() {
    }

    @Override // com.obric.autogui.common.api.userreport.IAutoActionUserReportApi
    public void initUserReport(Context r3, HostAppInfo r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "appInfo");
        IAutoActionUserReportApi r2 = provideImpl();
        if (r2 == null) goto L6;
        r2.initUserReport(r5, r4);
        return;
    }

    @Override // com.obric.autogui.common.api.userreport.IAutoActionUserReportApi
    public IAutoActionUserReportApi.UploadingStatus uploadUserReport(Context r3, UserReportInfo r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "userReportInfo");
        IAutoActionUserReportApi r2 = provideImpl();
        if (r2 == null) goto L7;
        IAutoActionUserReportApi.UploadingStatus r6 = r2.uploadUserReport(r5, r4);
        if (r6 == null) goto L7;
        return r6;
    L7:
        return IAutoActionUserReportApi.UploadingStatus.NotSupported;
    }

    private final IAutoActionUserReportApi provideImpl() {
        IAutoActionUserReportApi r0 = (IAutoActionUserReportApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionUserReportApi.class), IAutoActionUserReportApi.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot acquire UserReport API.");
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, DynamicProxy.class) == true) goto L8;
        return r0;
    }
}
