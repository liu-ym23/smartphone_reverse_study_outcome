package com.bytedance.android.livesdk.chatroom.room.apm;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f110685a = null;

    static {
        int[] r100 = new int[LiveMode.values().length];
        f110685a = r100;
        r100[LiveMode.MEDIA.ordinal()] = 1;
        r100[LiveMode.OFFICIAL_ACTIVITY.ordinal()] = 2;
        r100[LiveMode.SCREEN_RECORD.ordinal()] = 3;
        r100[LiveMode.AUDIO.ordinal()] = 4;
        r100[LiveMode.THIRD_PARTY.ordinal()] = 5;
        r100[LiveMode.ACQUAINTANCE.ordinal()] = 6;
    }
}
