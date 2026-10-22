package com.obric.autoaction.inittasks.refactor;

import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.obric.autogui.common.api.platform.device.DeviceInfo;
import com.obric.autogui.util.doubao.settings.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: InitSettingTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitSettingTask implements IAutoActionFoundationReadyTask {
    public static /* synthetic */ x lambda$5NieTy61ZEvgUtBZP0I_bDrCEpc(DeviceInfo r0) {
        return run$lambda$0(r0);
    }

    public InitSettingTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        AODeviceInfo.INSTANCE.whenDeviceRegistered($$Lambda$InitSettingTask$5NieTy61ZEvgUtBZP0I_bDrCEpc.INSTANCE);
        return x.f38692a;
    }

    private static final x run$lambda$0(DeviceInfo r2) {
        o.e((DeviceInfo) ZeusTransformUtils.wrapperContextForParams(r2, DeviceInfo.class, "com.obric.aiagent.plugin"), "it");
        c.f31526a.a();
        return x.f38692a;
    }
}
