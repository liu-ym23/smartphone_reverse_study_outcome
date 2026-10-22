package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f80545a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f80546b = null;

    static {
        int[] r100 = new int[DynamicUpdateType.values().length];
        f80545a = r100;
        r100[DynamicUpdateType.SUBTITLE.ordinal()] = 1;
        r100[DynamicUpdateType.AUDIO_ASR.ordinal()] = 2;
        r100[DynamicUpdateType.COMMON_SET_DATA.ordinal()] = 3;
        int[] r101 = new int[DynamicGetType.values().length];
        f80546b = r101;
        r101[DynamicGetType.COMMON_GET_DATA.ordinal()] = 1;
    }
}
