package com.bytedance.android.livesdk.gift.platform.business.tray2.viewModel;

import com.bytedance.android.live.gift.tray.TrayMode;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f130413a = null;

    static {
        int[] r100 = new int[TrayMode.values().length];
        f130413a = r100;
        r100[TrayMode.IDLE.ordinal()] = 1;
        r100[TrayMode.AUDIO_GIFT.ordinal()] = 2;
        r100[TrayMode.MULTI_PK.ordinal()] = 3;
        r100[TrayMode.PK.ordinal()] = 4;
        r100[TrayMode.EQUAL_VIDEO_TALK.ordinal()] = 5;
        r100[TrayMode.VIDEO_CHORUS.ordinal()] = 6;
        r100[TrayMode.PLATFORM.ordinal()] = 7;
        r100[TrayMode.GAME.ordinal()] = 8;
        r100[TrayMode.MEDIA.ordinal()] = 9;
        r100[TrayMode.VS_BAR.ordinal()] = 10;
    }
}
