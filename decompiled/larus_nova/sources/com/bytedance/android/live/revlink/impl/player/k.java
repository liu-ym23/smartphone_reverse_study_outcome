package com.bytedance.android.live.revlink.impl.player;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f97461a = null;

    static {
        int[] r100 = new int[LiveMode.values().length];
        f97461a = r100;
        r100[LiveMode.THIRD_PARTY.ordinal()] = 1;
        r100[LiveMode.VIDEO.ordinal()] = 2;
        r100[LiveMode.AUDIO.ordinal()] = 3;
        r100[LiveMode.SCREEN_RECORD.ordinal()] = 4;
        r100[LiveMode.MEDIA.ordinal()] = 5;
    }
}
