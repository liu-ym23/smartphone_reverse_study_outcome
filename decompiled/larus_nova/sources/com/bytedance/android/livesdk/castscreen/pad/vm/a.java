package com.bytedance.android.livesdk.castscreen.pad.vm;

import com.bytedance.android.live.core.arch.mvvm.d;
import com.bytedance.android.livesdk.castscreen.castscreenapi.model.PlayType;
import h80.c;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface a extends com.bytedance.android.livesdk.castscreen.pc.vm.b {
    void chooseDevicePlay(long r100, PlayType r101, of1.a r102, String r103);

    d<c<of1.a>> getCurPlayDevice();

    d<List<of1.a>> getDeviceList();

    void startScanDevices(PlayType r100);
}
