package com.bytedance.android.livesdk.revenue.ktv;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/ktv/RevKtvRoomKind;", "", "Idle", "CountDown", "Singing", "Paused", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevKtvRoomKind extends Enum<RevKtvRoomKind> {
    public static final RevKtvRoomKind CountDown = null;
    public static final RevKtvRoomKind Idle = null;
    public static final RevKtvRoomKind Paused = null;
    public static final RevKtvRoomKind Singing = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevKtvRoomKind[] f157169a = null;

    static {
        RevKtvRoomKind r100 = new RevKtvRoomKind("Idle", 0);
        Idle = r100;
        RevKtvRoomKind r101 = new RevKtvRoomKind("CountDown", 1);
        CountDown = r101;
        RevKtvRoomKind r102 = new RevKtvRoomKind("Singing", 2);
        Singing = r102;
        RevKtvRoomKind r103 = new RevKtvRoomKind("Paused", 3);
        Paused = r103;
        f157169a = new RevKtvRoomKind[]{r100, r101, r102, r103};
    }

    public static RevKtvRoomKind valueOf(String r100) {
        return (RevKtvRoomKind) a.a(RevKtvRoomKind.class, r100);
    }

    public static RevKtvRoomKind[] values() {
        return (RevKtvRoomKind[]) f157169a.clone();
    }

    public RevKtvRoomKind(String r100, int r101) {
        super(r100, r101);
    }
}
