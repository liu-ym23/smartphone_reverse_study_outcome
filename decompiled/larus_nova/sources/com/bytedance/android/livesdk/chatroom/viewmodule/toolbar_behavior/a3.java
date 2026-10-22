package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f117080a = null;

    static {
        int[] r100 = new int[LiveMode.values().length];
        f117080a = r100;
        r100[LiveMode.VIDEO.ordinal()] = 1;
        r100[LiveMode.THIRD_PARTY.ordinal()] = 2;
        r100[LiveMode.MEDIA.ordinal()] = 3;
        r100[LiveMode.AUDIO.ordinal()] = 4;
        r100[LiveMode.SCREEN_RECORD.ordinal()] = 5;
        r100[LiveMode.ACQUAINTANCE.ordinal()] = 6;
    }
}
