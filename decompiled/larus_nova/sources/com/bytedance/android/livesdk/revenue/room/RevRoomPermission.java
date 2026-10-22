package com.bytedance.android.livesdk.revenue.room;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/room/RevRoomPermission;", "", "GiftVote", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevRoomPermission extends Enum<RevRoomPermission> {
    public static final RevRoomPermission GiftVote = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevRoomPermission[] f157280a = null;

    static {
        RevRoomPermission r100 = new RevRoomPermission();
        GiftVote = r100;
        f157280a = new RevRoomPermission[]{r100};
    }

    public static RevRoomPermission valueOf(String r100) {
        return (RevRoomPermission) r27.a.a(RevRoomPermission.class, r100);
    }

    public static RevRoomPermission[] values() {
        return (RevRoomPermission[]) f157280a.clone();
    }

    public RevRoomPermission() {
        super("GiftVote", 0);
    }
}
