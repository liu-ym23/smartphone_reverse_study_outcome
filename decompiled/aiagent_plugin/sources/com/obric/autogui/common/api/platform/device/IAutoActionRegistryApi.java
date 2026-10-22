package com.obric.autogui.common.api.platform.device;

import d.h.a.b;
import d.x;

/* JADX INFO: compiled from: IAutoActionRegistryApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionRegistryApi {
    String generateDeviceInfoText();

    DeviceInfo getDeviceInfo();

    String getDid();

    String getIid();

    String getNativeDid();

    String getRpDid();

    boolean isDeviceRegistered();

    void whenDeviceRegistered(b<? super DeviceInfo, x> r1);
}
