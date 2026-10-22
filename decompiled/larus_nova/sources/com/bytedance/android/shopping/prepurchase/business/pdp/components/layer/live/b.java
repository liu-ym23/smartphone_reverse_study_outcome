package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.LiveVolume;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f181161a = null;

    static {
        int[] r100 = new int[FloatWindowState.values().length];
        f181161a = r100;
        r100[FloatWindowState.OPEN.ordinal()] = 1;
        r100[FloatWindowState.STOP.ordinal()] = 2;
        int[] r101 = new int[LiveVolume.values().length];
        r101[LiveVolume.MUTE.ordinal()] = 1;
        r101[LiveVolume.UNMUTE.ordinal()] = 2;
    }
}
