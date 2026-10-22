package com.bytedance.android.livesdk.castscreen.pc.vm;

import com.bytedance.android.live.core.arch.mvvm.d;
import com.bytedance.android.livesdk.castscreen.castscreenapi.model.PlayType;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface c extends b {
    d<com.bytedance.android.livesdk.castscreen.castscreenapi.model.b> getCurPlayDevice();

    d<List<com.bytedance.android.livesdk.castscreen.castscreenapi.model.b>> getDeviceList();

    void getDevicesList(long r100, String r101, PlayType r102, boolean r103, boolean r104, String r105);

    void pushPcPlayMsg(long r100, String r101, PlayType r102, com.bytedance.android.livesdk.castscreen.castscreenapi.model.b r103, String r104);
}
