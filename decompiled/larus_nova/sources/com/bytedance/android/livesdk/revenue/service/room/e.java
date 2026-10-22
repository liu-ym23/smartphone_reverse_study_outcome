package com.bytedance.android.livesdk.revenue.service.room;

import com.bytedance.android.livesdk.revenue.room.RevLiveMode;
import com.bytedance.android.livesdk.revenue.room.RevRoomPermission;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f157434a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f157435b = null;

    static {
        int[] r100 = new int[RevRoomPermission.values().length];
        f157434a = r100;
        r100[RevRoomPermission.GiftVote.ordinal()] = 1;
        int[] r101 = new int[RevLiveMode.values().length];
        f157435b = r101;
        r101[RevLiveMode.VIDEO.ordinal()] = 1;
        r101[RevLiveMode.AUDIO.ordinal()] = 2;
        r101[RevLiveMode.THIRD_PARTY.ordinal()] = 3;
        r101[RevLiveMode.SCREEN_RECORD.ordinal()] = 4;
        r101[RevLiveMode.MEDIA.ordinal()] = 5;
        r101[RevLiveMode.OFFICIAL_ACTIVITY.ordinal()] = 6;
        r101[RevLiveMode.ACQUAINTANCE.ordinal()] = 7;
        r101[RevLiveMode.UNDEFINED.ordinal()] = 8;
    }
}
