package com.obric.autogui.agents.scripted.impl;

import com.obric.autogui.common.api.platform.device.DeviceInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ScriptResourceIdentity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public static final h a(DeviceInfo r2) {
        DeviceInfo r3 = (DeviceInfo) ZeusTransformUtils.wrapperContextForParams(r2, DeviceInfo.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "deviceInfo");
        return new h(r3.getDeviceId(), r3.getNativeDid());
    }
}
