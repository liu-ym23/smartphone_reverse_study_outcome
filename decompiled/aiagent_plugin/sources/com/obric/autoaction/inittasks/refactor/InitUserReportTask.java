package com.obric.autoaction.inittasks.refactor;

import android.content.Context;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.app.HostAppInfo;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.common.api.userreport.AutoActionUserReport;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: InitUserReportTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitUserReportTask implements IAutoActionFoundationReadyTask {
    public InitUserReportTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r6) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        AutoActionUserReport.INSTANCE.initUserReport(r7, new HostAppInfo(AOHostAppTools.INSTANCE.getHostAppPackage(), AOHostAppTools.INSTANCE.getHostAppInfo().getVersionName(), AOHostAppTools.INSTANCE.getHostAppInfo().getVersionCode(), AOSystemTools.INSTANCE.isDebugVersion()));
        return x.f38692a;
    }
}
