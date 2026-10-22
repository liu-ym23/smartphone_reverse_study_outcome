package com.obric.aiagent.product.platform.api.rom;

import android.content.Context;
import d.h.a.b;
import d.x;

/* JADX INFO: compiled from: IRomInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IRomInfo {
    String getDeviceBrand();

    String getDeviceModel();

    int getFwkApiVersion();

    void getOSDeviceIdAsync(b<? super String, x> r1);

    String getOSDeviceIdFromCache();

    int getOSReleaseDate();

    String getOSVersion();

    String getRomBuildType();

    String getRomReleaseRegion();

    String getShortOSVersion();

    boolean isOautoModelPreinstalled(Context r1);

    boolean isUTRom();

    void tryInit();

    boolean useAssistantApi();
}
