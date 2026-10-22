package com.bytedance.android.livesdk.headset;

import com.bytedance.android.livesdkapi.service.HeadsetType;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f132633a = null;

    static {
        int[] r100 = new int[HeadsetType.values().length];
        f132633a = r100;
        r100[HeadsetType.BluetoothA2DP.ordinal()] = 1;
        r100[HeadsetType.BluetoothSco.ordinal()] = 2;
        r100[HeadsetType.WiredHeadSet.ordinal()] = 3;
        r100[HeadsetType.WiredHeadPhones.ordinal()] = 4;
    }
}
