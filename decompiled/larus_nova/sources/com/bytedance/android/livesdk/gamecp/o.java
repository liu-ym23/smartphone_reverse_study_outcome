package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f125453a = null;

    static {
        int[] r100 = new int[LiveMode.values().length];
        f125453a = r100;
        r100[LiveMode.VIDEO.ordinal()] = 1;
        r100[LiveMode.AUDIO.ordinal()] = 2;
        r100[LiveMode.SCREEN_RECORD.ordinal()] = 3;
        r100[LiveMode.THIRD_PARTY.ordinal()] = 4;
    }
}
