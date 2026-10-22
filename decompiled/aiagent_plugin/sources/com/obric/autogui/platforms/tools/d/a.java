package com.obric.autogui.platforms.tools.d;

import com.obric.aiagent.trace.ITraceReport;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.device.DeviceInfo;
import com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: StandardDeviceInfoApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements IAutoActionRegistryApi {
    private static final String TAG = "Std/DevInfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0801a f30141a = null;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StandardDeviceInfoApiImpl.kt */
    public static final class C0801a {
        public /* synthetic */ C0801a(h r1) {
            this();
        }

        private C0801a() {
        }
    }

    static {
        f30141a = new C0801a(null);
    }

    /* JADX INFO: renamed from: lambda$0VG2zSLszTl-2KWYn7T2CWYvRK0, reason: not valid java name */
    public static /* synthetic */ x m859lambda$0VG2zSLszTl2KWYn7T2CWYvRK0(d.h.a.b r0, a r1, String r2) {
        return a(r0, r1, r2);
    }

    public a() {
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public DeviceInfo getDeviceInfo() {
        return (DeviceInfo) ZeusTransformUtils.preCheckCast(b.f30142a, DeviceInfo.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public boolean isDeviceRegistered() {
        ITraceReport r4 = (ITraceReport) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITraceReport.class), ITraceReport.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        String r5 = r4.getFlowDid();
        if (r5 == null) goto L13;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 != true) goto L13;
        return true;
    L9:
        r6 = false;
    L13:
        return false;
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public String getDid() {
        return getDeviceInfo().getDeviceId();
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public String getNativeDid() {
        return getDeviceInfo().getNativeDid();
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public String getRpDid() {
        return getDeviceInfo().getRpDeviceId();
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public String getIid() {
        return getDeviceInfo().getInstallId();
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public String generateDeviceInfoText() {
        DeviceInfo r3 = getDeviceInfo();
        StringBuilder r0 = new StringBuilder();
        r0.append("DID=" + r3.getDeviceId() + ";RPDID=" + r3.getRpDeviceId() + ";IID=" + r3.getInstallId());
        String r4 = r0.toString();
        o.c(r4, "toString(...)");
        return r4;
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public void whenDeviceRegistered(d.h.a.b<? super DeviceInfo, x> r4) {
        final d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "callback");
        ITraceReport r0 = (ITraceReport) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITraceReport.class), ITraceReport.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.whenFlowDidReady(new $$Lambda$a$0VG2zSLszTl2KWYn7T2CWYvRK0(r5, this));
        return;
    }

    private static final x a(d.h.a.b r2, a r3, String r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        Loog.INSTANCE.d(TAG, " - whenDeviceRegistered.");
        r5.invoke(r3.getDeviceInfo());
        return x.f38692a;
    }
}
