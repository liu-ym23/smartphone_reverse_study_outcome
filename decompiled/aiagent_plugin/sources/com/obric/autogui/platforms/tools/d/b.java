package com.obric.autogui.platforms.tools.d;

import com.obric.aiagent.platform.depend.ITraceDepend;
import com.obric.aiagent.privacy_sec.IPrivacy;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.trace.ITraceReport;
import com.obric.autogui.common.api.platform.device.DeviceInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StandardDeviceInfoStorage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements DeviceInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f30142a = null;

    static {
        f30142a = new b();
    }

    private b() {
    }

    @Override // com.obric.autogui.common.api.platform.device.DeviceInfo
    public String getDeviceId() {
        ITraceReport r2 = (ITraceReport) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITraceReport.class), ITraceReport.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        String r3 = r2.getFlowDid();
        if (r3 == null) goto L6;
        return r3;
    L6:
        return "";
    }

    @Override // com.obric.autogui.common.api.platform.device.DeviceInfo
    public String getInstallId() {
        ITraceDepend r2 = (ITraceDepend) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITraceDepend.class), ITraceDepend.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        String r3 = r2.getInstallId();
        if (r3 == null) goto L6;
        return r3;
    L6:
        return "";
    }

    public final String a() {
        IPrivacy r2 = (IPrivacy) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacy.class), IPrivacy.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getRpDeviceId();
    }

    @Override // com.obric.autogui.common.api.platform.device.DeviceInfo
    public String getRpDeviceId() {
        String r0 = a();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getDeviceId();
    }

    @Override // com.obric.autogui.common.api.platform.device.DeviceInfo
    public String getNativeDid() {
        String r0 = ObricProductSdk.INSTANCE.platformService().romInfo().getOSDeviceIdFromCache();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }
}
