package com.obric.autogui.common.api.platform.device;

import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: AODeviceInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AODeviceInfo implements IAutoActionRegistryApi {
    public static final AODeviceInfo INSTANCE = null;
    private final /* synthetic */ IAutoActionRegistryApi $$delegate_0;

    static {
        INSTANCE = new AODeviceInfo();
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public String generateDeviceInfoText() {
        return this.$$delegate_0.generateDeviceInfoText();
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public DeviceInfo getDeviceInfo() {
        return this.$$delegate_0.getDeviceInfo();
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public String getDid() {
        return this.$$delegate_0.getDid();
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public String getIid() {
        return this.$$delegate_0.getIid();
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public String getNativeDid() {
        return this.$$delegate_0.getNativeDid();
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public String getRpDid() {
        return this.$$delegate_0.getRpDid();
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public boolean isDeviceRegistered() {
        return this.$$delegate_0.isDeviceRegistered();
    }

    @Override // com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi
    public void whenDeviceRegistered(b<? super DeviceInfo, x> r3) {
        b<? super DeviceInfo, x> r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "callback");
        this.$$delegate_0.whenDeviceRegistered(r4);
    }

    private AODeviceInfo() {
        this.$$delegate_0 = AOPlatformTools.INSTANCE.registry();
    }
}
