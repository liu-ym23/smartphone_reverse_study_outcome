package com.bytedance.android.livesdk.chatroom.broadcast.monitor;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f105355a = null;

    static {
        int[] r100 = new int[LiveMode.values().length];
        f105355a = r100;
        r100[LiveMode.VIDEO.ordinal()] = 1;
        r100[LiveMode.SCREEN_RECORD.ordinal()] = 2;
        r100[LiveMode.THIRD_PARTY.ordinal()] = 3;
        r100[LiveMode.AUDIO.ordinal()] = 4;
        r100[LiveMode.MEDIA.ordinal()] = 5;
    }
}
